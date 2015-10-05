package de.uni_hildesheim.sse.easy_producer.instantiator.model.common;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.IArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.IExpressionVisitor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.IResolvable;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.IRuntimeEnvironment;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Collection;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IActualValueProvider;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ITypedModel;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilGenericType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ListSequence;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ListSet;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration.Configuration;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration.DecisionVariable;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration.IvmlElement;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration.IvmlTypes;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.Reference;
import de.uni_hildesheim.sse.model.varModel.values.NullValue;
import de.uni_hildesheim.sse.utils.modelManagement.IModel;
import de.uni_hildesheim.sse.utils.modelManagement.IRestrictionEvaluationContext;
import de.uni_hildesheim.sse.utils.modelManagement.IVariable;
import de.uni_hildesheim.sse.utils.modelManagement.IndentationConfiguration;
import de.uni_hildesheim.sse.utils.modelManagement.RestrictionEvaluationException;
import de.uni_hildesheim.sse.utils.modelManagement.Version;

/**
 * Provides the runtime environment for executing a VIL models. After
 * creating a runtime environment, first the context must be defined using
 * {@link #switchContext(IModel)}.
 * 
 * @author Holger Eichelberger
 */
public abstract class RuntimeEnvironment implements IRuntimeEnvironment, IRestrictionEvaluationContext {

    /**
     * Defines a nested level of value assignments.
     * 
     * @author Holger Eichelberger
     */
    private static class Level {
        private Map<VariableDeclaration, Object> values = new HashMap<VariableDeclaration, Object>();
        private Map<String, VariableDeclaration> variables = new HashMap<String, VariableDeclaration>();
        private List<Configuration> configurations = new ArrayList<Configuration>();
    }

    /**
     * Defines a context for executing one model within.
     * 
     * @author Holger Eichelberger
     */
    private static class Context {
        private Stack<Level> levels = new Stack<Level>();
        private ITypedModel model;
        private int indentation;
        private IndentationConfiguration indentationConfiguration;
        private String[] paths;
        
        /**
         * Creates a new context.
         * 
         * @param model the related model
         */
        public Context(ITypedModel model) {
            this.model = model;
            if (null != model.getIndentationConfiguration() 
                && model.getIndentationConfiguration().isIndentationEnabled()) {
                indentationConfiguration = model.getIndentationConfiguration();
            }
            pushLevel();
        }
        
        /**
         * Returns the model.
         * 
         * @return the model
         */
        public ITypedModel getModel() {
            return model;
        }

        /**
         * Returns the value of <code>resolvable</code>.
         * 
         * @param resolvable the variable to return the value for
         * @return the value of <code>resolvable</code>
         * @throws VilException in case that <code>resolvable</code> was not defined
         */
        public Object getValue(IResolvable resolvable) throws VilException {
            boolean found = false;
            Object value = null;  
            for (int l = levels.size() - 1; !found && l >= 0; l--) {
                Level level = levels.get(l);
                if (level.values.containsKey(resolvable)) {
                    found = true;
                    value = level.values.get(resolvable);
                }
            }
            if (!found) {
                throw new VilException("variable " + resolvable.getName() + " is not defined", 
                    VilException.ID_NOT_FOUND);
            }
            return value;
        }
        
        /**
         * Returns the variable of name <code>name</code> if defined.
         * 
         * @param name the name of the variable
         * @return the variable or <b>null</b> if not found
         */
        public VariableDeclaration get(String name) {
            VariableDeclaration result = null;
            for (int l = levels.size() - 1; null == result && l >= 0; l--) {
                Level level = levels.get(l);
                result = level.variables.get(name);
            }
            return result;
        }
        
        /**
         * Returns whether <code>var</code> is defined (a value was assigned).
         * 
         * @param var the variable to look for
         * @return <code>true</code> if <code>var</code> is defined, <code>false</code> else
         */
        public boolean isDefined(VariableDeclaration var) {
            boolean found = false;
            for (int l = levels.size() - 1; !found && l >= 0; l--) {
                Level level = levels.get(l);
                if (level.values.containsKey(var)) {
                    found = null != level.values.get(var);
                }
            }
            return found;
        }
        
        /**
         * Changes the value of <code>var</code> where it is defined.
         * 
         * @param var the variable to be modified
         * @param object the value of <code>var</code>
         * @throws VilException in case of an attempt of modifying a constant
         */
        public void setValue(VariableDeclaration var, Object object) throws VilException {
            if (var.isConstant() && isDefined(var)) {
                throw new VilException("variable " + var.getName() + " is constant", 
                    VilException.ID_IS_CONSTANT);
            }
            
            boolean found = false;
            for (int l = levels.size() - 1; !found && l >= 0; l--) {
                Level level = levels.get(l);
                if (level.values.containsKey(var)) {
                    level.values.put(var, object);
                    level.variables.put(var.getName(), var);
                    if (var.getType() == IvmlTypes.configurationType() && object instanceof Configuration) {
                        level.configurations.add((Configuration) object);
                    }
                    found = true;
                }
            }
            if (!found) {
                // if not already defined, add to top level
                addValue(var, object);
            }
        }
        
        /**
         * Pushes a new level.
         */
        public void pushLevel() {
            levels.push(new Level());
        }
        
        /**
         * Removes the topmost level.
         * 
         * @throws VilException in case that storing artifacts fails, the level will be popped anyway
         */
        public void popLevel() throws VilException {
            storeArtifacts();
            if (levels.size() > 1) {
                levels.pop();
            } else {
                throw new IllegalArgumentException("lowest level element cannot be removed");
            }
        }
        
        /**
         * Stores the recent artifacts.
         * 
         * @throws VilException in case that storing artifacts fails
         */
        public void storeArtifacts() throws VilException {
            if (levels.size() > 0) {
                Level top = levels.peek();
                // rather simple, does not look for other levels!
                for (Object o : top.values.values()) {
                    if (o instanceof IArtifact) {
                        IArtifact artifact = (IArtifact) o;
                        artifact.store();
                    }
                }
            }
        }

        /**
         * Changes the value of <code>var</code> to the top level.
         * 
         * @param var the variable to be modified
         * @param object the value of <code>var</code>
         * @throws VilException in case of an attempt of modifying a constant
         */
        public void addValue(VariableDeclaration var, Object object) throws VilException {
            Level level = levels.peek();
            level.values.put(var, object);
            level.variables.put(var.getName(), var);
            if (var.getType() == IvmlTypes.configurationType() && object instanceof Configuration) {
                level.configurations.add((Configuration) object);
            }
        }
        
        /**
         * Removes the binding for <code>var</code> from the top level.
         * 
         * @param var the variable to be removed
         */
        public void removeValue(VariableDeclaration var) {
            Level level = levels.peek();
            Object object = level.values.get(var);
            level.values.remove(var);
            level.variables.remove(var.getName());
            if (var.getType() == IvmlTypes.configurationType() && object instanceof Configuration) {
                level.configurations.remove((Configuration) object);
            }
        }

        /**
         * Returns the indentation information for the underlying model.
         * 
         * @return the indentation information
         */
        public IndentationConfiguration getIndentationConfiguration() {
            return indentationConfiguration;
        }
        
        /**
         * Returns the current indentation.
         * 
         * @return the current indentation (in single whitespaces)
         */
        public int getIndentation() {
            return indentation;
        }
        
        /**
         * Increases the indentation by one step.
         */
        public void increaseIndentation() {
            if (null != indentationConfiguration) {
                indentation += Math.max(0, indentationConfiguration.getIndentationStep());
            }
        }
        
        /**
         * Decreases the indentation by one step.
         */
        public void decreaseIndentation() {
            if (null != indentationConfiguration) {
                int step = Math.max(0, indentationConfiguration.getIndentationStep());
                if (indentation > step) {
                    indentation -= step;
                }
            }
        }

        /**
         * Returns the value of the IVML element denoted by <code>name</code> in the closest scope defining
         * an IVML configuration.
         * 
         * @param name the name
         * @return the value
         * @throws VilException in case that <code>name</code> was not defined
         */
        public Object getIvmlValue(String name) throws VilException {
            boolean found = false;
            Object value = null;  
            for (int l = levels.size() - 1; !found && l >= 0; l--) {
                Level level = levels.get(l);
                for (int c = 0; !found && c < level.configurations.size(); c++) {
                    IvmlElement elt = level.configurations.get(c).getElement(name);
                    if (null != elt) {
                        found = true;
                        value = elt; // not getValue/getName -> return the element itself
                    }
                }
            }
            if (!found) {
                throw new VilException("IVML element " + name + " is not defined", 
                    VilException.ID_NOT_FOUND);
            }
            return value;
        }

    }
    
    private Map<IModel, Context> contexts = new HashMap<IModel, Context>();
    private Context currentContext;
    private TypeRegistry typeRegistry;
    
    /**
     * Creates a new runtime environment using the default type registry.
     */
    public RuntimeEnvironment() {
        typeRegistry = TypeRegistry.DEFAULT;
    }

    /**
     * Creates a new runtime environment with a given type registry instance.
     * 
     * @param typeRegistry the type registry to use
     */
    public RuntimeEnvironment(TypeRegistry typeRegistry) {
        this.typeRegistry = typeRegistry;
    }
    
    @Override
    public TypeRegistry getTypeRegistry() {
        return typeRegistry;
    }
    
    /**
     * Switches the context.
     * 
     * @param model the model the context is assigned to
     * @return the old context for switching back
     */
    public ITypedModel switchContext(ITypedModel model) {
        ITypedModel oldContext;
        if (null != currentContext) {
            oldContext = currentContext.getModel();
        } else {
            oldContext = null; // just at the very first call
        }
        TypeRegistry tmp = model.getTypeRegistry();
        if (null != tmp) {
            typeRegistry = tmp;
        }
        currentContext = contexts.get(model);
        if (null == currentContext) {
            currentContext = new Context(model);
            contexts.put(model, currentContext);
        }
        return oldContext;
    }
    
    /**
     * Explicitly deletes a context if it is not the current context.
     * 
     * @param model the model to delete the context for
     */
    public void deleteContext(ITypedModel model) {
        Context context = contexts.get(model);
        if (context != currentContext) {
            contexts.remove(model);
        }
    }

    /**
     * Defines the (sub-script) search paths of the current context.
     * 
     * @param paths the search paths
     */
    public void setContextPaths(List<File> paths) {
        if (null != currentContext) {
            String[] tmp = null;
            if (null != paths) {
                tmp = new String[paths.size()];
                for (int i = 0; i < tmp.length; i++) {
                    tmp[i] = paths.get(i).getAbsolutePath();
                }
            }
            currentContext.paths = tmp;
        }
    }

    @Override
    public String[] getContextPaths() {
        String[] result = null;
        if (null != currentContext) {
            result = currentContext.paths;
        }
        return result;
    }
    
    /**
     * Returns the model assigned to the context.
     * 
     * @return the model (may be <b>null</b> if {@link #switchContext(IModel)} was 
     *   not called before)
     */
    public ITypedModel getContextModel() {
        ITypedModel model;
        if (null == currentContext) {
            model = null;
        } else {
            model = currentContext.getModel();
        }
        return model;
    }

    @Override
    public Object getValue(IResolvable resolvable) throws VilException {
        Object result = null;
        try {
            result = currentContext.getValue(resolvable);
        } catch (VilException e) {
            boolean found = false;
            for (Context ctx : contexts.values()) {
                if (ctx != currentContext) {
                    try {
                        result = ctx.getValue(resolvable);
                        found = true;
                    } catch (VilException e1) {
                        // ignore, we have e
                    }
                }
            }
            if (!found) {
                throw e;
            }
        }
        return result;
    }
    
    /**
     * Returns the value of <code>var</code>.
     * 
     * @param var the variable to return the value for
     * @return the value of <code>var</code>
     * @throws VilException in case that <code>var</code> was not defined
     */
    public Object getValue(VariableDeclaration var) throws VilException {
        return getValue((IResolvable) var);
    }

    @Override
    public void storeArtifacts() throws VilException {
        currentContext.storeArtifacts();
    }
    
    /**
     * Returns the variable of name <code>name</code> if defined.
     * 
     * @param name the name of the variable
     * @return the variable or <b>null</b> if not found
     */
    public VariableDeclaration get(String name) {
        return currentContext.get(name);
    }
    
    /**
     * Returns whether <code>var</code> is defined (a value was assigned).
     * 
     * @param var the variable to look for
     * @return <code>true</code> if <code>var</code> is defined, <code>false</code> else
     */
    public boolean isDefined(VariableDeclaration var) {
        return currentContext.isDefined(var);
    }
    
    /**
     * Changes the value of <code>var</code> where it is defined.
     * 
     * @param var the variable to be modified
     * @param object the value of <code>var</code>
     * @throws VilException in case of an attempt of modifying a constant
     */
    public void setValue(IResolvable var, Object object) throws VilException {
        setValue((VariableDeclaration) var, object);
    }
    
    /**
     * Changes the value of <code>var</code> where it is defined.
     * 
     * @param var the variable to be modified
     * @param object the value of <code>var</code>
     * @throws VilException in case of an attempt of modifying a constant
     */
    public void setValue(VariableDeclaration var, Object object) throws VilException {
        TypeDescriptor<?> type = var.getType();
        if (type instanceof IActualValueProvider) {
            object = ((IActualValueProvider) type).determineActualValue(object);
        } else {
            object = checkInitialCollectionValue(type, object);
        }
        object = checkType(var, object);
        currentContext.setValue(var, object);
    }
    
    /**
     * Checks initial collection values for type compliance. Actually, the parser is not 
     * able to create the right type for all "{}", so we correct this here.
     * 
     * @param type the type
     * @param object the object value
     * @return <code>object</code> or a more specific / better matching type
     */
    private static Object checkInitialCollectionValue(TypeDescriptor<?> type, Object object) {
        if ((type.isSet() || type.isSequence()) && object instanceof Collection) {
            Collection<?> coll = (Collection<?>) object;
            if (coll.isEmpty() && type.getGenericParameterCount() > 0 && !type.isSame(coll.getType())) {
                if (type.isSet()) {
                    object = new ListSet<Object>(new ArrayList<Object>(), type.getGenericParameter());
                } else {
                    object = new ListSequence<Object>(new ArrayList<Object>(), type.getGenericParameter());
                }
            }
        }
        return object;
    }
    
    /**
     * Pushes a new level.
     */
    public void pushLevel() {
        currentContext.pushLevel();
    }
    
    /**
     * Removes the topmost level.
     * 
     * @throws VilException in case that storing artifacts fails, the level will be popped anyway
     */
    public void popLevel() throws VilException {
        currentContext.popLevel();
    }

    /**
     * Changes the value of <code>var</code> to the top level.
     * 
     * @param var the variable to be modified
     * @param object the value of <code>var</code>
     * @throws VilException in case of an attempt of modifying a constant
     */
    public void addValue(VariableDeclaration var, Object object) throws VilException {
        object = checkType(var, object);
        currentContext.addValue(var, object);
    }
    
    /**
     * Removes the variable binding for <code>var</code> if it exists.
     * 
     * @param var the variable to be removed
     */
    public void removeValue(VariableDeclaration var) {
        currentContext.removeValue(var);
    }

    /**
     * Checks whether <code>object</code> can be assigned to <code>var</code>.
     * 
     * @param var the variable to assign <code>object</code> to
     * @param object the object to be assigned (may be <b>null</b>)
     * @return <code>object</code> or <b>null</b> if object is {@link NullValue}.
     * @throws VilException in case of type incompatibilities
     */
    private Object checkType(VariableDeclaration var, Object object) throws VilException {
        if (NullValue.INSTANCE == object || NullValue.VALUE == object) {
            object = null;
        }
        if (null != object) {
            boolean compatible = var.getType().isInstance(object);
            if (!compatible) {
                if (object instanceof DecisionVariable) {
                    IDatatype dType = Reference.dereference(
                        ((DecisionVariable) object).getVariable().getDeclaration().getType());
                    TypeDescriptor<?> td = getTypeRegistry().getType(dType);
                    if (null != td) {
                        compatible = var.getType().isAssignableFrom(td);
                    }
                }
            }
            if (!compatible) {
                String oTypeName;
                TypeDescriptor<?> oType = typeRegistry.findType(object.getClass());
                if (null == oType && object instanceof IVilGenericType) {
                    // unmodifiable wrapper types
                    oType = ((IVilGenericType) object).getType();
                }
                if (null == oType) {
                    oTypeName = "?";
                } else {
                    oTypeName = oType.getVilName();
                }
                if (object instanceof DecisionVariable) {
                    DecisionVariable decVar = (DecisionVariable) object;
                    oTypeName += " (" + decVar.getType() + ")";
                }
                throw new VilException("cannot assign value of type " + oTypeName 
                    + " to " + var.getName() + " of type " + var.getType().getVilName(), 
                    VilException.ID_RUNTIME_TYPE);
            }
        }
        return object;
    }

    /**
     * Returns the indentation information for the underlying model.
     * 
     * @return the indentation information
     */
    public IndentationConfiguration getIndentationConfiguration() {
        return currentContext.getIndentationConfiguration();
    }
    
    /**
     * Returns the current indentation.
     * 
     * @return the current indentation (in single whitespaces)
     */
    public int getIndentation() {
        return currentContext.getIndentation();
    }
    
    /**
     * Increases the indentation by one step.
     */
    public void increaseIndentation() {
        currentContext.increaseIndentation();
    }
    
    /**
     * Decreases the indentation by one step.
     */
    public void decreaseIndentation() {
        currentContext.decreaseIndentation();
    }

    @Override
    public Object getIvmlValue(String name) throws VilException {
        return currentContext.getIvmlValue(name);
    }
    
    // restriction evaluation

    @Override
    public void setValue(IVariable variable, Version version) throws RestrictionEvaluationException {
        if (variable instanceof VariableDeclaration) {
            try {
                addValue((VariableDeclaration) variable, version);
            } catch (VilException e) {
                throw new RestrictionEvaluationException(e.getMessage(), e.getId());
            }
        } else {
            throw new RestrictionEvaluationException("unsupported type", RestrictionEvaluationException.ID_INTERNAL);
        }
    }

    @Override
    public void unsetValue(IVariable variable) throws RestrictionEvaluationException {
        if (variable instanceof VariableDeclaration) {
            removeValue((VariableDeclaration) variable);
        } else {
            throw new RestrictionEvaluationException("unsupported type", RestrictionEvaluationException.ID_INTERNAL);
        }
    }
    
    /**
     * Creates the expression visitor for this environment.
     * 
     * @return the expression visitor
     */
    protected abstract IExpressionVisitor createEvaluationProcessor();
    
    /**
     * Releases the expression visitor for this environment.
     * 
     * @param processor the expression visitor
     */
    protected abstract void releaseEvaluationProcessor(IExpressionVisitor processor);

    @Override
    public Object startEvaluation() throws RestrictionEvaluationException {
        if (null == currentContext) {
            switchContext(DummyModel.INSTANCE);
        }
        pushLevel();
        return createEvaluationProcessor();
    }

    @Override
    public void endEvaluation(Object processor) throws RestrictionEvaluationException {
        if (processor instanceof IExpressionVisitor) {
            releaseEvaluationProcessor((IExpressionVisitor) processor);
        }
        try {
            popLevel();
        } catch (VilException e) {
            throw new RestrictionEvaluationException(e.getMessage(), e.getId());
        }
    }
    
}
