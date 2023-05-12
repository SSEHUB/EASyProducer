package de.uni_hildesheim.sse.vil.expressions.translation;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionDslPackage;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.Import;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.LanguageUnit;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.ParameterList;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.VersionSpec;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.VersionStmt;
import net.ssehub.easy.basics.messages.IMessage;
import net.ssehub.easy.basics.modelManagement.AvailableModels;
import net.ssehub.easy.basics.modelManagement.IModel;
import net.ssehub.easy.basics.modelManagement.IVersionRestriction;
import net.ssehub.easy.basics.modelManagement.ImportResolver;
import net.ssehub.easy.basics.modelManagement.ModelImport;
import net.ssehub.easy.basics.modelManagement.ModelInfo;
import net.ssehub.easy.basics.modelManagement.ModelManagement;
import net.ssehub.easy.basics.modelManagement.Version;
import net.ssehub.easy.basics.modelManagement.VersionFormatException;
import net.ssehub.easy.dslCore.translation.ErrorCodes;
import net.ssehub.easy.dslCore.translation.TranslatorException;
import net.ssehub.easy.instantiation.core.model.common.Advice;
import net.ssehub.easy.instantiation.core.model.common.Compound;
import net.ssehub.easy.instantiation.core.model.common.ExpressionStatement;
import net.ssehub.easy.instantiation.core.model.common.ICompoundReceiver;
import net.ssehub.easy.instantiation.core.model.common.IResolvableOperation;
import net.ssehub.easy.instantiation.core.model.common.ITypedefReceiver;
import net.ssehub.easy.instantiation.core.model.common.IVariableDeclarationReceiver;
import net.ssehub.easy.instantiation.core.model.common.Imports;
import net.ssehub.easy.instantiation.core.model.common.ListVariableDeclarationReceiver;
import net.ssehub.easy.instantiation.core.model.common.OperationAnnotations;
import net.ssehub.easy.instantiation.core.model.common.Typedef;
import net.ssehub.easy.instantiation.core.model.common.VariableDeclaration;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.expressions.AbstractCallExpression;
import net.ssehub.easy.instantiation.core.model.expressions.CallArgument;
import net.ssehub.easy.instantiation.core.model.expressions.Expression;
import net.ssehub.easy.instantiation.core.model.expressions.Resolver;
import net.ssehub.easy.instantiation.core.model.vilTypes.CompoundTypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.IMetaOperation;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.IvmlTypeResolver;
import net.ssehub.easy.varModel.model.Project;

/**
 * A reusable model translator.
 * 
 * @author Holger Eichelberger
 *
 * @param <I> the variable declaration type
 * @param <R> the resolver type
 * @param <E> the expression translator type
 */
public abstract class ModelTranslator 
    <M extends IModel, I extends VariableDeclaration, R extends Resolver<I>, S extends ExpressionStatement, 
    E extends ExpressionTranslator<I, R, S>> extends net.ssehub.easy.dslCore.translation.ModelTranslator<E> {

    private R resolver;
    
    /**
     * Creates a new model translator.
     * 
     * @param expressionTranslator the expression translator instance
     * @param resolver the resolver instance
     */
    public ModelTranslator(E expressionTranslator, R resolver) {
        super(expressionTranslator);
        this.resolver = resolver;
    }
    
    /**
     * Returns the resolver instance.
     * 
     * @return the resolver
     */
    protected R getResolver() {
        return resolver;
    }
    
    /**
     * Processes the imports and returns an summarizing instance.
     * 
     * @param imports the imports to be processed
     * @return the summarizing instance
     * @throws TranslatorException in case that processing the imports fails
     */
    protected Imports<M> processImports(EList<Import> imports) throws TranslatorException {
        Imports<M> result;
        if (null != imports) {
            Set<String> known = new HashSet<String>();
            List<ModelImport<M>> tmp = new ArrayList<ModelImport<M>>();
            for (Import imp : imports) {
                String name = imp.getName();
                if (imp.getWildcard() != null) {
                    name += ModelImport.WILDCARD_POSTFIX;
                }
                if (!known.contains(name) /*&& isImport and not conflict*/) {
                    boolean isInsert = imp.getInsert() != null;
                    warnVersionRestrictions(imp.getVersionSpec());
                    tmp.add(new ModelImport<M>(name, false, getExpressionTranslator().
                        processRestriction(name, imp.getVersionSpec(), resolver), isInsert));
                    known.add(name);
                } else {
                    throw new TranslatorException(name + " is imported multiple times", imp, 
                        ExpressionDslPackage.Literals.IMPORT__NAME, ErrorCodes.IMPORT);
                }
            }
            result = new Imports<M>(tmp);
        } else {
            result = null;
        }
        return result;
    }
    
    /**
     * Returns an extension import (super script, super template).
     * 
     * @param name the name of the model
     * @param imports the known imports
     * @param cause the causing ECore element (in case of throwing an exception)
     * @param causingFeature the causing feature (in case of throwing an exception)
     * @return the found import
     * @throws TranslatorException in case that the import cannot be found
     */
    protected ModelImport<M> getExtensionImport(String name, Imports<M> imports, EObject cause, 
        EStructuralFeature causingFeature) throws TranslatorException {
        ModelImport<M> result = null;
        if (null != name) {
            result = imports.getImport(name);
            if (null == result) {
                throw new TranslatorException(name + " is not imported", cause, causingFeature, ErrorCodes.IMPORT);
            }
        }
        return result;
    }

    /**
     * Processes the typedefs in <code>elts</code>.
     * 
     * @param elts the elements
     * @param receiver the typedef receiver
     */
    protected void processTypedefContents(List<EObject> elts, ITypedefReceiver receiver) {
        List<de.uni_hildesheim.sse.vil.expressions.expressionDsl.TypeDef> defs = select(
            elts, de.uni_hildesheim.sse.vil.expressions.expressionDsl.TypeDef.class);
        processTypedefs(defs, receiver);
    }

    /**
     * Processes the compounds in <code>elts</code>.
     * 
     * @param elts the elements
     * @param receiver the compound receiver
     */
    protected void processCompoundContents(List<EObject> elts, ICompoundReceiver receiver) {
        List<de.uni_hildesheim.sse.vil.expressions.expressionDsl.Compound> defs = select(
            elts, de.uni_hildesheim.sse.vil.expressions.expressionDsl.Compound.class);
        processCompounds(defs, receiver);
    }

    /**
     * Processes the given typedefs.
     * 
     * @param defs the typedefs
     * @param receiver the typedef receiver
     */
    protected void processTypedefs(List<de.uni_hildesheim.sse.vil.expressions.expressionDsl.TypeDef> defs, 
        ITypedefReceiver receiver) {
        int count;
        do {
            count = defs.size();
            processTypedefs(defs, receiver, false);
            if (count == defs.size()) {
                break;
            }
        } while (count > 0);
        if (defs.size() > 0) {
            processTypedefs(defs, receiver, true);
        }
    }

    /**
     * Processes the given compounds.
     * 
     * @param defs the compounds
     * @param receiver the compozbd receiver
     */
    protected void processCompounds(List<de.uni_hildesheim.sse.vil.expressions.expressionDsl.Compound> cmps, 
        ICompoundReceiver receiver) {
        int count;
        do {
            count = cmps.size();
            processCompounds(cmps, receiver, false);
            if (count == cmps.size()) {
                break;
            }
        } while (count > 0);
        if (cmps.size() > 0) {
            processCompounds(cmps, receiver, true);
        }
    }

    /**
     * Processes the given typedefs.
     * 
     * @param defs the typedefs
     * @param receiver the typedef receiver
     * @param force force processing typedefs not resolved so far
     */
    private void processTypedefs(List<de.uni_hildesheim.sse.vil.expressions.expressionDsl.TypeDef> defs, 
        ITypedefReceiver receiver, boolean force) {
        Iterator<de.uni_hildesheim.sse.vil.expressions.expressionDsl.TypeDef> iter = defs.iterator();
        while (iter.hasNext()) {
            de.uni_hildesheim.sse.vil.expressions.expressionDsl.TypeDef def = iter.next();
            try {
                String name = def.getName();
                TypeDescriptor<?> type = getExpressionTranslator().processType(def.getType(), resolver);
                if (!resolver.getTypeRegistry().addTypeAlias(name, type)) {
                    error("Type name '" + name + "' already exists", def, 
                        ExpressionDslPackage.Literals.TYPE_DEF__NAME, ErrorCodes.NAME_CLASH);
                }
                Typedef typedef = createTypedef(name, type);
                receiver.addTypedef(typedef);
                iter.remove();
            } catch (VilException e) {
                if (force) {
                    error(e.getMessage(), def, ExpressionDslPackage.Literals.TYPE_DEF__NAME, e.getId());
                }
            } catch (TranslatorException e) {
                if (force) {
                    error(e);
                }
            }
        }        
    }

    /**
     * Processes the given typedefs.
     * 
     * @param defs the typedefs
     * @param receiver the typedef receiver
     * @param force force processing typedefs not resolved so far
     */
    private void processCompounds(List<de.uni_hildesheim.sse.vil.expressions.expressionDsl.Compound> cmps, 
        ICompoundReceiver receiver, boolean force) {
        Iterator<de.uni_hildesheim.sse.vil.expressions.expressionDsl.Compound> iter = cmps.iterator();
        TypeRegistry registry = resolver.getTypeRegistry();
        while (iter.hasNext()) {
            de.uni_hildesheim.sse.vil.expressions.expressionDsl.Compound cmp = iter.next();
            try {
                CompoundTypeDescriptor refines = null;
                if (null != cmp.getSuper()) {
                    TypeDescriptor<?> tmp = registry.getType(cmp.getSuper(), false);
                    if (null == tmp) {
                        error("Parent compound '" + cmp.getSuper() + "' does not exists", cmp, 
                            ExpressionDslPackage.Literals.COMPOUND__SUPER, ErrorCodes.UNKNOWN_TYPE);
                    } else if (tmp instanceof CompoundTypeDescriptor) {
                        refines = (CompoundTypeDescriptor) tmp;
                    } else {
                        error(cmp.getSuper() + "' is not a compound", cmp, 
                            ExpressionDslPackage.Literals.COMPOUND__SUPER, ErrorCodes.TYPE_CONSISTENCY);
                    }
                }
                CompoundTypeDescriptor cType = new CompoundTypeDescriptor(cmp.getName(), 
                    null != cmp.getAbstract(), refines, registry);
                List<de.uni_hildesheim.sse.vil.expressions.expressionDsl.VariableDeclaration> vars = copy(cmp.getVars());
                if (null != vars) {
                    ListVariableDeclarationReceiver<I> recv = new ListVariableDeclarationReceiver<I>(
                        cmp.getVars().size());
                    processVariableDeclarations(vars, recv, false);
                    Set<String> known = new HashSet<String>();
                    CompoundTypeDescriptor.SlotDescriptor[] slots = new CompoundTypeDescriptor.SlotDescriptor[
                        recv.getVariableCount()];
                    CompoundTypeDescriptor cIter = refines;
                    while (null != cIter) {
                        for (int s = 0; s < cIter.getSlotCount(); s++) {
                            known.add(cIter.getSlot(s).getName());
                        }
                        cIter = cIter.getRefines();
                    }
                    for (int s = 0; s < slots.length; s++) {
                        I var = recv.getVariable(s);
                        String varName = var.getName();
                        if (known.contains(varName)) {
                            error("Slot '" + varName + "' is already declared", vars.get(s), 
                                ExpressionDslPackage.Literals.VARIABLE_DECLARATION__NAME, ErrorCodes.REDEFINITION);
                        } else {
                            known.add(varName);
                        }
                        slots[s] = new CompoundTypeDescriptor.SlotDescriptor(cType, var);
                    }
                    cType.setFields(slots);
                }
                receiver.addCompound(createCompound(cType));
                if (!registry.registerCompoundType(cType)) {
                    error("Compound '" + cType.getName() + "' is already declared", cmp, 
                        ExpressionDslPackage.Literals.COMPOUND__NAME, ErrorCodes.REDEFINITION);
                }
                iter.remove();
            } catch (VilException e) {
                if (force) {
                    error(e.getMessage(), cmp, ExpressionDslPackage.Literals.COMPOUND__NAME, e.getId());
                }
            }
        }        
    }

    /**
     * Creates a typdef object.
     * 
     * @param name the name of the typdef/alias
     * @param type the the type
     * @return the typedef
     */
    protected abstract Typedef createTypedef(String name, TypeDescriptor<?> type) throws VilException;

    /**
     * Creates a compound object.
     * 
     * @param type the the compound type
     * @return the typedef
     */
    protected abstract Compound createCompound(CompoundTypeDescriptor type) throws VilException;

    /**
     * Processes all variable declarations considering dependencies and terminates with
     * an error if not all can be resolved.
     * 
     * @param decls the declarations to be processed
     * @param receiver a receiver for the created instances
     */
    protected void processVariableDeclarations(
        List<de.uni_hildesheim.sse.vil.expressions.expressionDsl.VariableDeclaration> decls, 
        IVariableDeclarationReceiver<I> receiver) {
        processVariableDeclarations(decls, receiver, true);
    }

    /**
     * Processes all variable declarations considering dependencies and terminates with
     * an error if not all can be resolved.
     * 
     * @param decls the declarations to be processed
     * @param receiver a receiver for the created instances
     * @param addToResolver add the newly created variables to the resolver instance
     */
    protected void processVariableDeclarations(
        List<de.uni_hildesheim.sse.vil.expressions.expressionDsl.VariableDeclaration> decls, 
        IVariableDeclarationReceiver<I> receiver, boolean addToResolver) {
        int count;
        do {
            count = decls.size();
            processVariableDeclarations(decls, receiver, false, addToResolver);
            if (count == decls.size()) {
                break;
            }
        } while (count > 0);
        if (decls.size() > 0) {
            processVariableDeclarations(decls, receiver, true, addToResolver);
        }
    }

    /**
     * Processes a set of variable declarations and adds successfully processed
     * ones to the current resolver level.
     * 
     * @param decls the declarations to be processed (successfully processed declarations will be removed, may be 
     *   modified as a side effect)
     * @param receiver a receiver for the created instances
     * @param force if <code>true</code> a failing variable creation will be recorded as an error, 
     *   <code>false</code> failing creations will be ignored
     * @param addToResolver add the newly created variable to the resolver instance
     */
    private void processVariableDeclarations(List<de.uni_hildesheim.sse.vil.expressions.expressionDsl.VariableDeclaration> decls, 
        IVariableDeclarationReceiver<I> receiver, boolean force, boolean addToResolver) {
        Iterator<de.uni_hildesheim.sse.vil.expressions.expressionDsl.VariableDeclaration> iter = decls.iterator();
        while (iter.hasNext()) {
            de.uni_hildesheim.sse.vil.expressions.expressionDsl.VariableDeclaration decl = iter.next();
            try {
                I varDecl = getExpressionTranslator().processVariableDeclaration(decl, resolver);
                receiver.addVariableDeclaration(varDecl);
                if (addToResolver) {
                    resolver.add(varDecl);
                }
                iter.remove();
            } catch (TranslatorException e) {
                if (force) {
                    error(e);
                }
            }
        }
    }

    /**
     * Processes the advices (of a script).
     * 
     * @param advices the advices to be processed
     * @param modelURI the URI to the model being processed
     * @return the processed advices
     */
    protected Advice[] processAdvices(EList<de.uni_hildesheim.sse.vil.expressions.expressionDsl.Advice> advices, 
        URI modelURI) {
        Advice[] result = null;
        if (null != advices) {
            result = new Advice[advices.size()];
            for (int a = 0; a < advices.size(); a++) {
                de.uni_hildesheim.sse.vil.expressions.expressionDsl.Advice adv = advices.get(a);
                String name = Utils.getQualifiedNameString(adv.getName());
                try {
                    IVersionRestriction restrictions = getExpressionTranslator().processRestriction(
                        name, adv.getVersionSpec(), resolver);                
                    StringBuilder warning = new StringBuilder();
                    result[a] = Advice.create(name, modelURI, restrictions, warning);
                    buildLocalTypeRegistry(result[a]);
                    if (warning.length() > 0) {
                        warning(warning.toString(), adv, ExpressionDslPackage.Literals.ADVICE__NAME, ErrorCodes.IMPORT);
                    }
                } catch (TranslatorException e) {
                    error(e);
                }
            }
        }
        return result;
    }

    /**
     * Builds a local type registry for <code>advice</code>.
     * 
     * @param advice the advice to build the local type registry for
     */
    private void buildLocalTypeRegistry(Advice advice) {
        Project varModel = advice.getResolved();
        if (null != varModel) {
            TypeRegistry registry = resolver.getTypeRegistry();
            registry.addTypeResolver(new IvmlTypeResolver(varModel, registry));
        }
    }
    
    /**
     * Issues implementation warnings about version restrictions.
     * 
     * @param spec the version specification (may be <b>null</b>)
     */
    protected void warnVersionRestrictions(VersionSpec spec) {
        getExpressionTranslator().warnVersionRestrictions(spec);
    }

    /**
     * Resolves the parameters in <code>pList</code>.
     * 
     * @param pList the parameter list to be resolved
     * @param cause the causing object containing the parameters
     * @param paramListFeature the param list feature on <code>cause</code>
     * @param resolver the resolver instance
     * @return the resolved parameters (may actually be less then in <code>pList</code> in case of name or type failures
     * @throws TranslatorException in case that a problem occurred
     */
    protected I[] resolveParameters(ParameterList pList, EObject cause, EStructuralFeature paramListFeature, 
        R resolver) throws TranslatorException {
        I[] result;
        if (null != pList) {
            result = resolveParameters(pList.getParam(), cause, paramListFeature, resolver);
        } else {
            result = null;
        }
        return result;
    }

    /**
     * Resolves the parameters in <code>parameters</code>.
     * 
     * @param parameters the parameters to be resolved
     * @param cause the causing object containing the parameters
     * @param paramListFeature the param list feature on <code>cause</code>
     * @param resolver the resolver instance
     * @return the resolved parameters (may actually be less then in <code>pList</code> in case of name or type failures
     * @throws TranslatorException in case that a problem occurred
     */
    protected I[] resolveParameters(EList<de.uni_hildesheim.sse.vil.expressions.expressionDsl.Parameter> parameters, 
        EObject cause, EStructuralFeature paramListFeature, R resolver) throws TranslatorException {
        I[] result;
        if (null != parameters) {
            List<I> tmp = new ArrayList<I>();
            int firstDefaultParam = -1;
            int lastNonDefaultParam = -1;
            for (int p = 0; p < parameters.size(); p++) {
                de.uni_hildesheim.sse.vil.expressions.expressionDsl.Parameter par = parameters.get(p);
                TypeDescriptor<?> type = getExpressionTranslator().processType(par.getType(), resolver);
                if (null != type) {
                    for (int t = 0; t < tmp.size(); t++) {
                        if (tmp.get(t).getName().equals(par.getName())) {
                            error("duplicate parameter name '"+par.getName()+"'", par, 
                                ExpressionDslPackage.Literals.PARAMETER__NAME, ErrorCodes.NAME_CLASH);
                        }
                    }
                    Expression dflt = null;
                    if (null != par.getDflt()) {
                        dflt = getExpressionTranslator().processAssignment(par, type, par.getDflt(), resolver);
                    }
                    tmp.add(getExpressionTranslator().createVariableDeclaration(par.getName(), type, false, 
                        dflt, resolver));
                    if (null != dflt) {
                        if (firstDefaultParam < 0) {
                            firstDefaultParam = p;
                        }
                    } else {
                        lastNonDefaultParam = p;
                    }
                }
            }
            if (firstDefaultParam >= 0 && lastNonDefaultParam > firstDefaultParam) {
                error("Default parameters must be given after non-default parameters", cause, 
                    paramListFeature, ErrorCodes.TYPE_CONSISTENCY);
            }
            result = createArray(tmp.size());
            tmp.toArray(result);
        } else {
            result = null;
        }
        return result;
    }
    
    /**
     * Creates an array of <I>.
     * @param len the length of the array
     * @return the array
     */
    protected abstract I[] createArray(int len);

    /**
     * Converts a grammar version statement into a model version object.
     * 
     * @param versionStatement the version statement to be converts
     * @return the resulting model version object
     */
    public static Version convert(VersionStmt versionStatement) {
        Version version = null;
        String vString;
        if (null == versionStatement) {
            vString = null;
        } else {
            vString = versionStatement.getVersion();
        }
        if (null == vString) {
            version = null;
        } else {
            try {
                version = new Version(vString);
            } catch (VersionFormatException e) {
            }
        }
        return version;
    }
    
    /**
     * Returns the management instance.
     * 
     * @return the management instance
     */
    protected abstract ModelManagement<M> getManagementInstance();
    
    /**
     * Resolves the imports.
     * 
     * @param input the input language element
     * @param inputFeature the EMF feature this resolution happens on
     * @param model the model being created
     * @param uri the physical URI of the project
     * @param inProgress the other projects being resolved at once (in order to avoid loops)
     */
    protected void resolveImports(LanguageUnit input, EStructuralFeature inputFeature, 
        M model, URI uri, List<? extends LanguageUnit> inProgress, ImportResolver<M> impResolver) {
        List<ModelInfo<M>> infoInProgress = new ArrayList<ModelInfo<M>>();
        AvailableModels<M> available = getManagementInstance().availableModels();
        for (int p = 0; p < inProgress.size(); p++) {
            LanguageUnit pr = inProgress.get(p);
            VersionStmt versionStatement = pr.getVersion();
            String vString;
            if (null == versionStatement) {
                vString = null;
            } else {
                vString = versionStatement.getVersion();
            }
            try {
                List<ModelInfo<M>> info = available.getModelInfo(pr.getName(), vString);
                if (null != info) {
                    infoInProgress.addAll(info);
                }
            } catch (VersionFormatException e) {
                error(e.getMessage(), input, inputFeature, ErrorCodes.IMPORT);
            }
        }
        List<IMessage> resolutionMessages = getManagementInstance().resolveImports(model, uri, infoInProgress, 
            impResolver);
        if (resolutionMessages.size() > 0) {
            resolutionMessages = postResolveImports(model, uri, resolutionMessages);
        }        
        for (int i = 0; i < resolutionMessages.size(); i++) {
            IMessage msg = resolutionMessages.get(i);
            switch (msg.getStatus()) {
            case ERROR:
                error(msg.getDescription(), input, inputFeature, ErrorCodes.IMPORT);
                break;
            case WARNING:
                warning(msg.getDescription(), input, inputFeature, ErrorCodes.IMPORT);
                break;
            default:
                break;
            }
        }
        addImportedVariablesToResolver(model, false, new HashSet<M>());
    }
    
    /**
     * Adds (transitively) imported variables to the actual resolver.
     * 
     * @param model the model to consider
     * @param addModel whether the variables of <code>model</code> shall be added (<code>true</code>)
     *   or whether only its imports shall be traversed
     * @param done collects models that are already processed
     * @see #addVisibleDeclarationsToResolver(IModel, Resolver)
     */
    private void addImportedVariablesToResolver(M model, boolean addModel, Set<M> done) {
        if (!done.contains(model)) {
            if (addModel) {
                addVisibleDeclarationsToResolver(model, resolver);
            }
            done.add(model);
            for (int i = 0; i < model.getImportsCount(); i++) {
                @SuppressWarnings("unchecked")
                M resolved = (M) model.getImport(i).getResolved();
                if (null != resolved) {
                    addImportedVariablesToResolver(resolved, true, done);
                }
            }
        }
    }
    
    /**
     * Adds visible declarations of <code>model</code> to <code>resolver</code>. This method 
     * shall not consider imports as it is called by {@link #addImportedVariablesToResolver(IModel, boolean, Set)}.
     * 
     * @param model the model to consider
     * @param resolver the resolver to add variables to
     */
    protected abstract void addVisibleDeclarationsToResolver(M model, R resolver);
    
    /**
     * Is called in case of resolution problems.
     * 
     * @param model the model to be resolved
     * @param uri the physical URI of the project
     * @param resolutionMessages the messages collected so far
     * @return the new resolution messages
     */
    protected List<IMessage> postResolveImports(M model, URI uri, List<IMessage> resolutionMessages) {
        return resolutionMessages;
    }

    /**
     * Checks operation annotation consistency and emits warnings/errors.
     * 
     * @param <O> the operation type
     * @param op the operation to check
     * @param cause the causing ECore element (in case of throwing an exception)
     * @param causingFeature the causing feature (in case of throwing an exception)
     */
    protected <O extends IResolvableOperation<I>> void checkOperationAnnotations(O op, EObject cause, 
        EStructuralFeature causingFeature) {
        boolean dispCase = op.hasAnnotation(OperationAnnotations.DISPATCH_CASE);
        boolean override = op.hasAnnotation(OperationAnnotations.OVERRIDE);
        if (dispCase || override) {
            CallArgument[] args = new CallArgument[op.getParameterCount()];
            for (int p = 0; p < args.length; p++) {
                args[p] = new CallArgument(op.getParameter(p).getType());
            }
            int unnamedArgsCount = CallArgument.countUnnamedArguments(args);
            try {
                List<IMetaOperation> cand = AbstractCallExpression.assignableCandidates(op.getDeclaringType(), 
                    op.getName(), args, unnamedArgsCount, false, true);
                int dispatchBasisCount = 0;
                int overrideCount = 0;
                for (int o = 0; o < cand.size(); o++) {
                    IMetaOperation c = cand.get(o);
                    if (c instanceof IResolvableOperation) {
                        IResolvableOperation<?> tmp = (IResolvableOperation<?>) c;
                        overrideCount += tmp.hasAnnotation(OperationAnnotations.OVERRIDE) ? 1 : 0;
                        dispatchBasisCount += tmp.hasAnnotation(OperationAnnotations.DISPATCH_BASIS) ? 1 : 0;
                    }
                }
                if (dispCase && cand.size() > 0) {
                    if (dispatchBasisCount > 1) {
                        warning("Multiple matching dispatch basis operations found for " 
                            + op.getSignature(), cause, causingFeature, ErrorCodes.TYPE_CONSISTENCY);
                    } else if (dispatchBasisCount == 0) {
                        warning("No matching dispatch basis operations found for " + op.getSignature(), 
                            cause, causingFeature, ErrorCodes.TYPE_CONSISTENCY);
                    }
                }
                if (override) {
                    boolean ok = cand.size() > 0 && overrideCount < cand.size();
                    if (!ok) {
                        warning("No matching non-overriding operation found for " + op.getSignature(), 
                            cause, causingFeature, ErrorCodes.TYPE_CONSISTENCY);
                    }
                }
            } catch (VilException e) {
                warning(e.getMessage(), cause, causingFeature, e.getId());
            }
        }
    }
    

}
