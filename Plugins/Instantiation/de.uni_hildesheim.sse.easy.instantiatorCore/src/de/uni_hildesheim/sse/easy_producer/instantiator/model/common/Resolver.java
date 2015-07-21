package de.uni_hildesheim.sse.easy_producer.instantiator.model.common;

import java.util.Stack;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.AbstractCallExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.CallArgument;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.CallExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.IResolvable;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.IRuntimeEnvironment;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Constants;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IMetaOperation;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IMetaType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;
import de.uni_hildesheim.sse.utils.modelManagement.IModel;
import de.uni_hildesheim.sse.utils.modelManagement.ModelImport;

/**
 * A common resolver.
 * 
 * @param <M> the specific type of model
 * @param <O> the specific type of operation
 * @param <E> the specific call expression
 * @param <V> the specific class of variables 
 * 
 * @author Holger Eichelberger
 */
public abstract class Resolver<M extends IResolvableModel<V>, O extends IResolvableOperation<V>, 
    E extends ModelCallExpression<V, M, O>, V extends IResolvable> 
    extends de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.Resolver<V> {

    private Stack<M> models = new Stack<M>();

    /**
     * Creates a new resolver instance.
     * 
     * @param registry a specific (local) registry
     */
    public Resolver(TypeRegistry registry) {
        super(registry);
    }
    
    /**
     * Creates a new resolver considering the runtime environment. (for expression
     * resolution only).
     * 
     * @param environment the runtime environment
     */
    @SuppressWarnings("unchecked")
    public Resolver(IRuntimeEnvironment environment) {
        super(environment);
        if (environment instanceof RuntimeEnvironment) {
            // push the context model of the runtime environment in order to resolve
            // also def and rule calls defined in the same model
            RuntimeEnvironment rEnv = (RuntimeEnvironment) environment;
            IModel model = rEnv.getContextModel();
            if (null != model) {
                models.push((M) model);
            }
        }
    }
        
    /**
     * Adds a model instance for resolution.
     * 
     * @param model the model instance
     */
    public void pushModel(M model) {
        models.push(model);
        pushLevel();
        for (int p = 0; p < model.getParameterCount(); p++) {
            add(model.getParameter(p));
        }
        for (int v = 0; v < model.getVariableDeclarationCount(); v++) {
            V varDecl = model.getVariableDeclaration(v);
            if (model.isImplicit(varDecl)) {
                add(varDecl, "");
            }
        }
    }
    
    @Override
    public M getCurrentModel() {
        return models.isEmpty() ? null : models.peek();
    }

    /**
     * Enumerates the imports and adds relevant model elements such as qualified
     * variable declarations to this resolver.
     * 
     * @param model the model to add the imports for
     */
    public void enumerateImports(M model) {
        String qualifier = model.getName() + Constants.QUALIFICATION_SEPARATOR;
        for (int v = 0; v < model.getVariableDeclarationCount(); v++) {
            V varDecl = model.getVariableDeclaration(v);
            if (!model.isImplicit(varDecl)) {
                add(varDecl, qualifier);
            }
        }
        addImportedVariables(model, "");
    }
    
    /**
     * Adds imported variables with their qualified name.
     * 
     * @param model the model to add the variables for
     * @param path the qualified name path collected so far
     */
    private void addImportedVariables(M model, String path) {
        for (int i = 0; i < model.getImportsCount(); i++) {
            ModelImport<?> imp = model.getImport(i);
            if (null != imp.getResolved()) {
                @SuppressWarnings("unchecked")
                M m = (M) imp.getResolved();
                String tmp = path + imp.getName() + Constants.QUALIFICATION_SEPARATOR;
                for (int v = 0; v < m.getVariableDeclarationCount(); v++) {
                    V varDecl = m.getVariableDeclaration(v);
                    if (!model.isImplicit(varDecl)) {
                        add(varDecl, tmp);
                    }
                }
                addImportedVariables(m, tmp);
            }
        }
    }
    
    /**
     * Removes the top-level model instance from resolution.
     */
    public void popModel() {
        models.pop();
        popLevel();
    }
    
    /**
     * Creates a new model call expression.
     * 
     * @param model the actual model to resolve the operation on
     * @param isSuper this is a super call
     * @param name the name of the operation
     * @param arguments the actual arguments
     * @return the created expression
     * @throws VilException in case of an erroneously qualified name
     */
    protected abstract E createCallExpression(M model, boolean isSuper, String name, CallArgument... arguments) 
        throws VilException;
 
    /**
     * Class for successively testing and resolving call expressions (super calls, imported calls, recursive calls).
     * 
     * @author Holger Eichelberger
     *
     */
    private class CallExpressionTester {
        
        private String name;
        private CallArgument[] arguments;
        private VilException lastException;
        
        /**
         * Creates a call expression tester.
         * 
         * @param name name of the call
         * @param arguments call arguments
         */
        CallExpressionTester(String name, CallArgument... arguments) {
            this.name = name;
            this.arguments = arguments;
        }

        /**
         * Creates a call expression and tries to resolve the call.
         * 
         * @param model the model to resolve on
         * @param isSuper whether it is a super call
         * @return the created call expression in case of success, <b>null</b> else
         */
        E createAndCheckCall(M model, boolean isSuper) {
            E result = null;
            try {
                E tmp = createCallExpression(model, isSuper, name, arguments);
                tmp.inferType();
                result = tmp;
            } catch (VilException e) {
                lastException = e;
            }
            return result;
        }
       
        /**
         * Returns the last exception produced by {@link #createAndCheckCall(IResolvableModel, boolean)}.
         * 
         * @return the last exception or <b>null</b>
         */
        VilException getLastException() {
            return lastException;
        }
        
    }

    /**
     * Determines the model denoted by a qualified name.
     * 
     * @param model the model to start search for, may be the first segment of a qualified name or provider 
     *     of imports
     * @param name (qualified) name
     * @return <b>null</b> if <code>name</code> is not qualified, the qualified model else
     * @throws VilException if qualified and cannot be resolved or qualified super call
     */
    private M determineQualifiedModel(M model, String name) throws VilException {
        M result = null;
        int pos = name.indexOf(Constants.QUALIFICATION_SEPARATOR);
        String modelName;
        String remainderName;
        if (pos > 0) {
            modelName = name.substring(0, pos);
            remainderName = name.substring(pos + Constants.QUALIFICATION_SEPARATOR.length(), name.length());
        } else {
            modelName = name;
            remainderName = "";
        }
        if (model.getName().equals(modelName)) {
            result = determineQualifiedModel(model, remainderName);
        } else {
            for (int i = 0; null == result && i < model.getImportsCount(); i++) {
                ModelImport<?> imp = model.getImport(i);
                if (null != imp.getResolved() && imp.getName().equals(modelName)) {
                    @SuppressWarnings("unchecked")
                    M importedModel = (M) imp.getResolved();
                    if (remainderName.length() > 0) {
                        result = determineQualifiedModel(importedModel, remainderName);
                    } else {
                        result = importedModel;
                    }
                }
            }
        }
        return result;
    }
    
    /**
     * Determines the model denoted by a qualified name.
     * 
     * @param model the model to start search for, may be the first segment of a qualified name or provider 
     *     of imports
     * @param isSuper is it a super call?
     * @param name (qualified) name
     * @return <b>null</b> if <code>name</code> is not qualified, the qualified model else
     * @throws VilException if qualified and cannot be resolved or qualified super call
     */
    private M determineQualifiedModel(M model, boolean isSuper, String name) throws VilException {
        M result = null;
        int pos = name.lastIndexOf(Constants.QUALIFICATION_SEPARATOR);
        if (pos > 0) {
            if (isSuper) {
                throw new VilException("qualified names cannot be used in super calls", 
                    VilException.ID_CANNOT_RESOLVE);
            } 
            result = determineQualifiedModel(model, name.substring(0, pos));
            if (null == result) {
                throw new VilException("cannot resolve qualification in " + name, 
                    VilException.ID_CANNOT_RESOLVE);
            }
        }
        return result;
    }
    
    /**
     * Creates a call to a {@link IResolvableOperation} for one of the current model instances.
     * 
     * @param name the name of the function to be called
     * @param isSuper is it a super call?
     * @param arguments the arguments of the call
     * @return the resolved expression
     * @throws VilException in case that the function cannot be resolved.
     */
    @SuppressWarnings("unchecked")
    public E createCallExpression(boolean isSuper, String name, CallArgument... arguments) 
        throws VilException {
        CallExpressionTester tester = new CallExpressionTester(name, arguments);
        E result = null;
        if (!models.isEmpty()) {
            M model = models.peek();
            M qModel = determineQualifiedModel(model, isSuper, name);
            if (null != qModel) {
                // if qualified and not found -> exception thrown, else null==N/A or qModel exists
                result = tester.createAndCheckCall(qModel, false); // qualified cannot be super
            }
            if (null == result) {
                if (!isSuper) { // in case of super, do not start with this but with parent model
                    result = tester.createAndCheckCall(model, isSuper);
                } else {
                    if (null == model.getParent()) { // if it is super and no parent -> error!
                        throw new VilException("model is not extended, no super possible", 
                            VilException.ID_CANNOT_RESOLVE);
                    }
                }
                if (null == result) {
                    do { // check the parents
                        model = (M) model.getParent();
                        if (null != model) {
                            result = tester.createAndCheckCall(model, isSuper);
                        }
                    } while (null != model && null == result);
                }
            }
            for (int s = models.size() - 1; null == result && s >= 0; s--) {
                M importedModel = models.get(s);
                result = tester.createAndCheckCall(importedModel, false);
                for (int i = 0; null == result && i < importedModel.getImportsCount(); i++) {
                    M imported = (M) importedModel.getImport(i).getResolved();
                    if (null != imported) {
                        result = tester.createAndCheckCall(imported, false);
                    }
                }
            }
            if (null == result) {
                if (null == tester.getLastException()) {
                    throw new VilException("cannot resolve rule " 
                        + AbstractCallExpression.getSignature(name, arguments), VilException.ID_CANNOT_RESOLVE);
                } else {
                    throw tester.getLastException();
                }
            }
        } else {
            throw new VilException("model stack is empty", VilException.ID_INTERNAL);
        }
        return result;
    }
    
    /**
     * Creates an extension call expression to functions provided by extension types 
     * (see {@link IResolvableModel#getExtensionType(int)}). This method works only
     * on the top-level model!
     * 
     * @param name the name of the function to be called
     * @param arguments the arguments to that function
     * @return the resolved function
     * @throws VilException in case that the function cannot be resolved.
     */
    public CallExpression createExtensionCallExpression(String name, CallArgument... arguments) 
        throws VilException {
        CallExpression result = null;
        if (!models.isEmpty()) {
            VilException lastException = null;
            M model = models.peek();
            for (int t = 0; null == result && t < model.getExtensionTypesCount(); t++) {
                IMetaType type = model.getExtensionType(t);
                try {
                    IMetaOperation op = AbstractCallExpression.resolveOperation(type, name, arguments);
                    if (null != op) {
                        result = new CallExpression(op, arguments);
                        result.inferType();
                    }
                } catch (VilException e) {
                    lastException = e;
                }
            }
            if (null == result && null != lastException) {
                throw lastException;
            }
        }
        return result;
    }
    
    @Override
    public Object getIvmlElement(String name) {
        Object result = null;
        for (int s = models.size() - 1; null == result && s >= 0; s--) {
            result = models.get(s).getIvmlElement(name);
        }  
        return result;
    }

}
