package net.ssehub.easy.instantiation.core.model.common;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.function.Supplier;

import net.ssehub.easy.basics.modelManagement.IModel;
import net.ssehub.easy.basics.modelManagement.IRestrictionEvaluationContext;
import net.ssehub.easy.basics.modelManagement.IVariable;
import net.ssehub.easy.basics.modelManagement.IndentationConfiguration;
import net.ssehub.easy.basics.modelManagement.RestrictionEvaluationException;
import net.ssehub.easy.basics.modelManagement.Version;
import net.ssehub.easy.instantiation.core.Bundle;
import net.ssehub.easy.instantiation.core.model.artifactModel.IArtifact;
import net.ssehub.easy.instantiation.core.model.expressions.IExpressionVisitor;
import net.ssehub.easy.instantiation.core.model.expressions.IResolvable;
import net.ssehub.easy.instantiation.core.model.expressions.IRuntimeEnvironment;
import net.ssehub.easy.instantiation.core.model.vilTypes.Collection;
import net.ssehub.easy.instantiation.core.model.vilTypes.IActualValueProvider;
import net.ssehub.easy.instantiation.core.model.vilTypes.ITypedModel;
import net.ssehub.easy.instantiation.core.model.vilTypes.IVilGenericType;
import net.ssehub.easy.instantiation.core.model.vilTypes.ListSequence;
import net.ssehub.easy.instantiation.core.model.vilTypes.ListSet;
import net.ssehub.easy.instantiation.core.model.vilTypes.Sequence;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.Configuration;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.DecisionVariable;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.IvmlElement;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.IvmlTypes;
import net.ssehub.easy.varModel.model.IvmlDatatypeVisitor;
import net.ssehub.easy.varModel.model.datatypes.DerivedDatatype;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.Reference;
import net.ssehub.easy.varModel.model.values.CompoundValue;
import net.ssehub.easy.varModel.model.values.NullValue;

/**
 * Provides the runtime environment for executing a VIL models. After
 * creating a runtime environment, first the context must be defined using
 * {@link #switchContext(IModel)}.
 * 
 * @param <V> the variable declaration type
 * @param <M> the model type
 * @author Holger Eichelberger
 */
public abstract class RuntimeEnvironment<V extends VariableDeclaration, M extends IModel> 
    implements IRuntimeEnvironment, IRestrictionEvaluationContext {

    /**
     * Defines a nested level of value assignments.
     * 
     * @param <V> the variable declaration type
     * @author Holger Eichelberger
     */
    private static class Level<V extends VariableDeclaration> {
        private Map<V, Object> values = new HashMap<V, Object>();
        private Map<String, V> variables = new HashMap<String, V>();
        private List<Configuration> configurations = new ArrayList<Configuration>();
        
        @Override
        public String toString() {
            return "[" + values + " " + variables + "]";
        }

    }

    /**
     * Defines a context for executing one model within.
     * 
     * @param <D> the variable declaration type
     * @param <O> the model type
     * @author Holger Eichelberger
     */
    private class Context<D extends VariableDeclaration, O extends IModel> {
        private Stack<Level<D>> levels = new Stack<Level<D>>();
        private IResolvableModel<D, O> model;
        private int indentation;
        private IndentationConfiguration indentationConfiguration;
        private String[] paths;
        
        /**
         * Creates a new context.
         * 
         * @param model the related model
         */
        public Context(IResolvableModel<D, O> model) {
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
        public IResolvableModel<D, O> getModel() {
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
                Level<D> level = levels.get(l);
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
        public D get(String name) {
            D result = null;
            for (int l = levels.size() - 1; null == result && l >= 0; l--) {
                Level<D> level = levels.get(l);
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
        public boolean isDefined(D var) {
            return isDefined(var, levels.size() - 1);
        }
        
        /**
         * Returns whether <code>var</code> is defined (a value was assigned).
         * 
         * @param var the variable to look for
         * @param maxIndex the maximum level index to start searching for
         * @return <code>true</code> if <code>var</code> is defined, <code>false</code> else
         */
        private boolean isDefined(D var, int maxIndex) {
            boolean found = false;
            for (int l = maxIndex; !found && l >= 0; l--) {
                Level<D> level = levels.get(l);
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
        public void setValue(D var, Object object) throws VilException {
            if (var.isConstant() && isDefined(var)) {
                throw new VilException("variable " + var.getName() + " is constant", 
                    VilException.ID_IS_CONSTANT);
            }
            
            boolean found = false;
            for (int l = levels.size() - 1; !found && l >= 0; l--) {
                Level<D> level = levels.get(l);
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
            levels.push(new Level<D>());
        }
        
        /**
         * Removes the topmost level.
         * 
         * @throws VilException in case that storing artifacts fails, the level will be popped anyway
         */
        public void popLevel() throws VilException {
            storeArtifacts(false);
            if (levels.size() > 1) {
                levels.pop();
            } else {
                throw new IllegalArgumentException("lowest level element cannot be removed");
            }
        }
        
        /**
         * Stores the recent artifacts, but only artifacts that are not excluded and not initially defined on the 
         * current level (avoids repeated writing the same artifacts along a nesting hierarchy).
         * 
         * @param force force storing artifacts
         * @throws VilException in case that storing artifacts fails
         * @see RuntimeEnvironment#markNoAutoStore(IArtifact)
         * @see RuntimeEnvironment#unmarkNoAutoStore(IArtifact)
         */
        public void storeArtifacts(boolean force) throws VilException {
            if (levels.size() > 0) {
                Level<D> top = levels.peek();
                int maxLevel = levels.size() - 2; // do not look into top
                for (Map.Entry<D, Object> ent : top.values.entrySet()) {
                    Object o = ent.getValue();
                    if (o instanceof IArtifact 
                        && (force || (!noAutoStore.contains(o) && !isDefined(ent.getKey(), maxLevel)))) {
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
        public void addValue(D var, Object object) throws VilException {
            Level<D> level = levels.peek();
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
        public void removeValue(D var) {
            Level<D> level = levels.peek();
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
         * Changes the current indentation (in steps).
         * 
         * @param steps the number of indentation steps
         */
        public void setIndentationSteps(int steps) {
            if (steps > 0 && null != indentationConfiguration) {
                indentation = steps * indentationConfiguration.getIndentationStep();
            }
        }

        /**
         * Changes the current indentation.
         * 
         * @param indentation the new indentation (in single whitespaces)
         */
        public void setIndentation(int indentation) {
            if (indentation >= 0) {
                this.indentation = indentation;
            }
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
                Level<D> level = levels.get(l);
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
        
        /**
         * Returns the top-level configuration based on defining global VIL/VTL script parameters.
         * 
         * @return the top-level configuration (may be <b>null</b> if unknown)
         */
        public Configuration getTopLevelConfiguration() {
            Configuration result = null;
            if (!levels.isEmpty()) {
                List<Configuration> cfgs = levels.get(0).configurations;
                if (cfgs != null && !cfgs.isEmpty()) {
                    result = cfgs.get(0);
                }
            }
            return result;
        }

    }
    
    private Map<IModel, Context<V, M>> contexts = new HashMap<IModel, Context<V, M>>();
    private Context<V, M> currentContext;
    private IResolvableModel<V, M> mostSpecificModel;
    private TypeRegistry typeRegistry;
    private Class<V> cls;
    private Set<IArtifact> noAutoStore = new HashSet<IArtifact>();
    private Supplier<String> modelNameSupplier = new Supplier<String>() {
        
        @Override
        public String get() {
            String modelName = null;
            if (null != currentContext && currentContext.getModel() != null && contexts.size() > 0) {
                modelName = currentContext.getModel().getName();
            }
            return modelName;
        }
        
    };
    
    /**
     * Creates a new runtime environment using the default type registry.
     * 
     * @param cls the variable declaration type
     */
    public RuntimeEnvironment(Class<V> cls) {
        this.cls = cls;
        typeRegistry = TypeRegistry.DEFAULT;
    }

    /**
     * Creates a new runtime environment with a given type registry instance.
     * 
     * @param cls the variable declaration type
     * @param typeRegistry the type registry to use
     */
    public RuntimeEnvironment(Class<V> cls, TypeRegistry typeRegistry) {
        this.cls = cls;
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
    public IResolvableModel<V, M> switchContext(IResolvableModel<V, M> model) {
        IResolvableModel<V, M> oldContext;
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
            currentContext = new Context<V, M>(model);
            contexts.put(model, currentContext);
        }

        if (null != oldContext && currentContext.getModel().isAssignableFrom(oldContext)) {
            mostSpecificModel = oldContext; 
        } else {
            // keep different most specific even if the context does not change as the decision to have an upstream
            // model was taken before
            if (null == mostSpecificModel || oldContext != currentContext.getModel()) {
                mostSpecificModel = currentContext.getModel();
            }
        }
        return oldContext;
    }
    
    /**
     * Explicitly deletes a context if it is not the current context.
     * 
     * @param model the model to delete the context for
     */
    public void deleteContext(ITypedModel model) {
        Context<V, M> context = contexts.get(model);
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
    public IResolvableModel<?, M> getContextModel() {
        IResolvableModel<?, M> model;
        if (null == currentContext) {
            model = null;
        } else {
            model = currentContext.getModel();
        }
        return model;
    }
    
    public IResolvableModel<?, M> getMostSpecificContextModel() {
        return mostSpecificModel;
    }

    @Override
    public Object getValue(IResolvable resolvable) throws VilException {
        Object result = null;
        try {
            result = currentContext.getValue(resolvable);
        } catch (VilException e) {
            boolean found = false;
            for (Context<V, M> ctx : contexts.values()) {
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
     * Returns the value of <code>name</code> within <code>contextModel</code>.
     * 
     * @param contextModel the model indicating the context
     * @param name the name of the variable
     * @return the value of <code>name</code>
     * @throws VilException in case that the context/variable is not known
     */
    public Object getValue(IResolvableModel<V, M> contextModel, String name) throws VilException {
        Context<V, M> context = contexts.get(contextModel);
        if (null == context) {
            throw new VilException("No such context", VilException.ID_INSUFFICIENT_ARGUMENT);
        }
        V varDecl = context.get(name);
        if (null == varDecl) {
            throw new VilException("variable " + name + " is not defined", 
                VilException.ID_NOT_FOUND);
        }
        return context.getValue(varDecl);
    }
    
    /**
     * Returns the value of <code>var</code>.
     * 
     * @param var the variable to return the value for
     * @return the value of <code>var</code>
     * @throws VilException in case that <code>var</code> was not defined
     */
    public Object getValue(V var) throws VilException {
        return getValue((IResolvable) var);
    }

    @Override
    public void storeArtifacts(boolean force) throws VilException {
        currentContext.storeArtifacts(force);
    }
    
    /**
     * Returns the variable of name <code>name</code> if defined.
     * 
     * @param name the name of the variable
     * @return the variable or <b>null</b> if not found
     */
    public V get(String name) {
        return currentContext.get(name);
    }
    
    /**
     * Returns whether <code>var</code> is defined (a value was assigned).
     * 
     * @param var the variable to look for
     * @return <code>true</code> if <code>var</code> is defined, <code>false</code> else
     */
    public boolean isDefined(V var) {
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
        if (cls.isInstance(var)) {
            setValue(cls.cast(var), object);
        }
    }
    
    /**
     * Changes the value of <code>var</code> where it is defined.
     * 
     * @param var the variable to be modified
     * @param object the value of <code>var</code>
     * @throws VilException in case of an attempt of modifying a constant
     */
    public void setValue(V var, Object object) throws VilException {
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
        } else if (type.isMap() && object instanceof Sequence) { 
            // some conversions do not work as parameters are resolved as expressions without knowing the type to 
            // apply to this is for a specific type. May be that generic type<->object conversions are needed here
            try {
                object = net.ssehub.easy.instantiation.core.model.vilTypes.Map.convert((Sequence<?>) object);
            } catch (VilException e) {
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
    public void addValue(V var, Object object) throws VilException {
        object = checkType(var, object);
        currentContext.addValue(var, object);
    }
    
    /**
     * Removes the variable binding for <code>var</code> if it exists.
     * 
     * @param var the variable to be removed
     */
    public void removeValue(V var) {
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
    private Object checkType(V var, Object object) throws VilException {
        return checkType(var.getName(), var.getType(), object, getTypeRegistry(), modelNameSupplier);
    }

    /**
     * Checks whether <code>object</code> can be assigned to some form of variable/field with name <code>name</code> 
     * and type <code>type</code>.
     * 
     * @param name the name of the variable/field to assign <code>object</code> to
     * @param type the type of the variable/field to assign <code>object</code> to
     * @param object the object to be assigned (may be <b>null</b>)
     * @param registry the type registry to use
     * @param modelName optional model name supplier called in error cases, may be <b>null</b> for none, may 
     *     return <b>null</b>
     * @return <code>object</code> or <b>null</b> if object is {@link NullValue}.
     * @throws VilException in case of type incompatibilities
     */
    public static Object checkType(String name, TypeDescriptor<?> type, Object object, TypeRegistry registry, 
        Supplier<String> modelName) throws VilException {
        if (type instanceof IActualValueProvider) {
            object = ((IActualValueProvider) type).determineActualValue(object);
        } else {
            object = checkInitialCollectionValue(type, object);
        }        
        if (NullValue.INSTANCE == object || NullValue.VALUE == object) {
            object = null;
        }
        if (null != object) {
            boolean compatible = type.isInstance(object);
            if (!compatible) {
                if (object instanceof DecisionVariable) {
                    DecisionVariable decVar = (DecisionVariable) object;
                    IDatatype dType = decVar.getActualType();
                    dType = DerivedDatatype.resolveToBasis(Reference.dereference(dType));
                    TypeDescriptor<?> td = registry.getType(dType);
                    if (null != td) {
                        compatible = type.isAssignableFrom(td);
                    }
                    // late evaluation of "primitives"
                    if (compatible) {
                        object = evaluatePrimitives(object, decVar, type);
                    }
                }
                if (object instanceof CompoundValue) {
                    CompoundValue cValue = (CompoundValue) object;
                    IDatatype dType = cValue.getType();
                    dType = DerivedDatatype.resolveToBasis(Reference.dereference(dType));
                    TypeDescriptor<?> td = registry.getType(dType);
                    if (null != td) {
                        compatible = type.isAssignableFrom(td);
                    }
                }
            }
            if (!compatible) {
                String oTypeName;
                TypeDescriptor<?> oType = registry.findType(object.getClass());
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
                    IDatatype dType = decVar.getActualType();
                    String typeName;
                    if (null != dType) {
                        typeName = IvmlDatatypeVisitor.getUnqualifiedType(dType);
                    } else { // original code fallback
                        typeName = decVar.getTypeName();
                    }
                    oTypeName += " (" + typeName + ")";
                }
                String msg = appendModelName("cannot assign value of type \"" + oTypeName + "\" to \"" + name
                    + "\" of type \"" + type.getVilName() + "\"", modelName);
                Bundle.getLogger(RuntimeEnvironment.class).debug(msg);
                throw new VilException(msg, VilException.ID_RUNTIME_TYPE);
            }
        }
        return object;
    }

    /**
     * Appends the model name from {@link modelName} supplier if feasible.
     * 
     * @param msg the message to append
     * @param modelName the model name supplier, may be <b>null</b> or return <b>null</b> (ignored then)
     * @return the message (with appended) model name 
     */
    private static String appendModelName(String msg, Supplier<String> modelName) {
        if (null != modelName) {
            String mName = modelName.get();
            if (null != mName) {
                msg += " called in '" + mName + "'";
            }
        }
        return msg;
    }

    /**
     * Evaluates <code>decVar</code> to its primitive value according to <code>varType</code>. Late evaluation.
     * 
     * @param object the evaluated value so far
     * @param decVar the decision variable
     * @param varType the variable type
     * @return <code>object</code> or the evaluated value
     */
    private static Object evaluatePrimitives(Object object, DecisionVariable decVar, TypeDescriptor<?> varType) {
        if (TypeRegistry.integerType().isSame(varType)) {
            object = decVar.getIntegerValue();
        } else if (TypeRegistry.realType().isSame(varType)) {
            object = decVar.getRealValue();
        } else if (TypeRegistry.booleanType().isSame(varType)) {
            object = decVar.getBooleanValue();
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
     * Changes the current indentation (in steps).
     * 
     * @param steps the number of indentation steps
     */
    public void setIndentationSteps(int steps) {
        currentContext.setIndentationSteps(steps);
    }

    /**
     * Changes the current indentation.
     * 
     * @param indentation the new indentation (in single whitespaces)
     */
    public void setIndentation(int indentation) {
        currentContext.setIndentation(indentation);
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
        if (cls.isInstance(variable)) {
            try {
                addValue(cls.cast(variable), version);
            } catch (VilException e) {
                throw new RestrictionEvaluationException(e.getMessage(), e.getId());
            }
        } else {
            throw new RestrictionEvaluationException("unsupported type", RestrictionEvaluationException.ID_INTERNAL);
        }
    }

    @Override
    public void unsetValue(IVariable variable) throws RestrictionEvaluationException {
        if (cls.isInstance(variable)) {
            removeValue(cls.cast(variable));
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
            switchContext(new DummyModel<V, M>());
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
    
    /**
     * Returns the top-level configuration based on defining global VIL/VTL script parameters.
     * 
     * @return the top-level configuration (may be <b>null</b> if unknown)
     */
    public Configuration getTopLevelConfiguration() {
        return currentContext.getTopLevelConfiguration();
    }
    
    /**
     * Marks artifacts as excluded from auto-storing when related variabeles become unavailable.
     * 
     * @param artifact the artifact
     */
    public void markNoAutoStore(IArtifact artifact) {
        noAutoStore.add(artifact);
    }

    /**
     * Marks artifacts as again included from auto-storing when related variabeles become unavailable.
     * 
     * @param artifact the artifact
     */
    public void unmarkNoAutoStore(IArtifact artifact) {
        noAutoStore.remove(artifact);
    }

}
