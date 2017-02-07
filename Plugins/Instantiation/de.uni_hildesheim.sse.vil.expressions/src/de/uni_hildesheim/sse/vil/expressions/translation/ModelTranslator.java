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
import net.ssehub.easy.instantiation.core.model.common.ExpressionStatement;
import net.ssehub.easy.instantiation.core.model.common.ITypedefReceiver;
import net.ssehub.easy.instantiation.core.model.common.IVariableDeclarationReceiver;
import net.ssehub.easy.instantiation.core.model.common.Imports;
import net.ssehub.easy.instantiation.core.model.common.Typedef;
import net.ssehub.easy.instantiation.core.model.common.VariableDeclaration;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.expressions.Resolver;
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
                if (!known.contains(name) /*&& isImport and not conflict*/) {
                    warnVersionRestrictions(imp.getVersionSpec());
                    tmp.add(new ModelImport<M>(name, false, getExpressionTranslator().
                        processRestriction(name, imp.getVersionSpec(), resolver)));
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
    
    protected void processTypedefContents(List<EObject> elts, ITypedefReceiver receiver) {
        List<de.uni_hildesheim.sse.vil.expressions.expressionDsl.TypeDef> defs = select(
            elts, de.uni_hildesheim.sse.vil.expressions.expressionDsl.TypeDef.class);
        processTypedefs(defs, receiver);
    }

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
     * Creates a typdef object.
     * 
     * @param name the name of the typdef/alias
     * @param type the the type
     * @return the typedef
     */
    protected abstract Typedef createTypedef(String name, TypeDescriptor<?> type) throws VilException;

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
        int count;
        do {
            count = decls.size();
            processVariableDeclarations(decls, receiver, false);
            if (count == decls.size()) {
                break;
            }
        } while (count > 0);
        if (decls.size() > 0) {
            processVariableDeclarations(decls, receiver, true);
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
     */
    private void processVariableDeclarations(List<de.uni_hildesheim.sse.vil.expressions.expressionDsl.VariableDeclaration> decls, 
        IVariableDeclarationReceiver<I> receiver, boolean force) {
        Iterator<de.uni_hildesheim.sse.vil.expressions.expressionDsl.VariableDeclaration> iter = decls.iterator();
        while (iter.hasNext()) {
            de.uni_hildesheim.sse.vil.expressions.expressionDsl.VariableDeclaration decl = iter.next();
            try {
                I varDecl = getExpressionTranslator().processVariableDeclaration(decl, resolver);
                receiver.addVariableDeclaration(varDecl);
                resolver.add(varDecl);
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
     * @param resolver the resolver instance
     * @return the resolved parameters (may actually be less then in <code>pList</code> in case of name or type failures
     * @throws TranslatorException in case that a problem occurred
     */
    protected I[] resolveParameters(ParameterList pList, R resolver) throws TranslatorException {
        I[] result;
        if (null != pList) {
            result = resolveParameters(pList.getParam(), resolver);
        } else {
            result = null;
        }
        return result;
    }

    /**
     * Resolves the parameters in <code>parameters</code>.
     * 
     * @param parameters the parameters to be resolved
     * @param resolver the resolver instance
     * @return the resolved parameters (may actually be less then in <code>pList</code> in case of name or type failures
     * @throws TranslatorException in case that a problem occurred
     */
    protected I[] resolveParameters(EList<de.uni_hildesheim.sse.vil.expressions.expressionDsl.Parameter> parameters, 
        R resolver) throws TranslatorException {
        I[] result;
        if (null != parameters) {
            List<I> tmp = new ArrayList<I>();
            for (de.uni_hildesheim.sse.vil.expressions.expressionDsl.Parameter p : parameters) {
                TypeDescriptor<?> type = getExpressionTranslator().processType(p.getType(), resolver);
                if (null != type) {
                    for (int t = 0; t < tmp.size(); t++) {
                        if (tmp.get(t).getName().equals(p.getName())) {
                            error("duplicate parameter name '"+p.getName()+"'", p, 
                                ExpressionDslPackage.Literals.PARAMETER__NAME, ErrorCodes.NAME_CLASH);
                        }
                    }
                    tmp.add(getExpressionTranslator().createVariableDeclaration(p.getName(), type, false, 
                        null, resolver));
                }
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

}
