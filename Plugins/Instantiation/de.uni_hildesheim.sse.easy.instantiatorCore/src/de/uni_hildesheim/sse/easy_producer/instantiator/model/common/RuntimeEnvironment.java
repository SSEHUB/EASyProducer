package de.uni_hildesheim.sse.easy_producer.instantiator.model.common;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.IArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.IResolvable;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.IRuntimeEnvironment;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArtifactException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration.Configuration;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration.IvmlElement;
import de.uni_hildesheim.sse.utils.modelManagement.IModel;
import de.uni_hildesheim.sse.utils.modelManagement.IndentationConfiguration;

/**
 * Provides the runtime environment for executing a VIL models. After
 * creating a runtime environment, first the context must be defined using
 * {@link #switchContext(IModel)}.
 * 
 * @author Holger Eichelberger
 */
public class RuntimeEnvironment implements IRuntimeEnvironment {

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
        private IModel model;
        private int indentation;
        private IndentationConfiguration indentationConfiguration;
        private String[] paths;
        
        /**
         * Creates a new context.
         * 
         * @param model the related model
         */
        public Context(IModel model) {
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
        public IModel getModel() {
            return model;
        }

        /**
         * Returns the value of <code>resolvable</code>.
         * 
         * @param resolvable the variable to return the value for
         * @return the value of <code>resolvable</code>
         * @throws ExpressionException in case that <code>resolvable</code> was not defined
         */
        public Object getValue(IResolvable resolvable) throws ExpressionException {
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
                throw new ExpressionException("variable " + resolvable.getName() + " is not defined", 
                    VilLanguageException.ID_NOT_FOUND);
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
                    found = true;
                }
            }
            return found; // is defined, may have value null
        }
        
        /**
         * Changes the value of <code>var</code> where it is defined.
         * 
         * @param var the variable to be modified
         * @param object the value of <code>var</code>
         * @throws VilLanguageException in case of an attempt of modifying a constant
         */
        public void setValue(VariableDeclaration var, Object object) throws VilLanguageException {
            if (var.isConstant() && isDefined(var)) {
                throw new VilLanguageException("variable " + var.getName() + " is constant", 
                    VilLanguageException.ID_IS_CONSTANT);
            }
            boolean found = false;
            for (int l = levels.size() - 1; !found && l >= 0; l--) {
                Level level = levels.get(l);
                if (level.values.containsKey(var)) {
                    level.values.put(var, object);
                    level.variables.put(var.getName(), var);
                    if (var.getType() == TypeRegistry.configurationType() && object instanceof Configuration) {
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
         * @throws ArtifactException in case that storing artifacts fails, the level will be popped anyway
         */
        public void popLevel() throws ArtifactException {
            if (levels.size() > 1) {
                Level top = levels.pop();
                // rather simple, does not look for other levels!
                for (Object o : top.values.values()) {
                    if (o instanceof IArtifact) {
                        IArtifact artifact = (IArtifact) o;
                        artifact.store();
                    }
                }
            } else {
                throw new IllegalArgumentException("lowest level element cannot be removed");
            }
        }

        /**
         * Changes the value of <code>var</code> to the top level.
         * 
         * @param var the variable to be modified
         * @param object the value of <code>var</code>
         * @throws VilLanguageException in case of an attempt of modifying a constant
         */
        public void addValue(VariableDeclaration var, Object object) throws VilLanguageException {
            Level level = levels.peek();
            level.values.put(var, object);
            level.variables.put(var.getName(), var);
            if (var.getType() == TypeRegistry.configurationType() && object instanceof Configuration) {
                level.configurations.add((Configuration) object);
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
         * @throws ExpressionException in case that <code>name</code> was not defined
         */
        public Object getIvmlValue(String name) throws ExpressionException {
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
                throw new ExpressionException("IVML element " + name + " is not defined", 
                    VilLanguageException.ID_NOT_FOUND);
            }
            return value;
        }

    }
    
    private Map<IModel, Context> contexts = new HashMap<IModel, Context>();
    private Context currentContext;
    private TypeRegistry typeRegistry;
    
    /**
     * Creates a new runtime environment.
     */
    public RuntimeEnvironment() {
        typeRegistry = TypeRegistry.DEFAULT; // TODO preliminary
    }

    @Override
    public TypeRegistry getTypeRegistry() {
        return typeRegistry;
    }
    
    /**
     * Switches the context.
     * 
     * @param model the model the context is assigned to
     */
    public void switchContext(IModel model) {
        currentContext = contexts.get(model);
        if (null == currentContext) {
            currentContext = new Context(model);
            contexts.put(model, currentContext);
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
    public IModel getContextModel() {
        IModel model;
        if (null == currentContext) {
            model = null;
        } else {
            model = currentContext.getModel();
        }
        return model;
    }

    @Override
    public Object getValue(IResolvable resolvable) throws ExpressionException {
        return currentContext.getValue(resolvable);
    }
    
    /**
     * Returns the value of <code>var</code>.
     * 
     * @param var the variable to return the value for
     * @return the value of <code>var</code>
     * @throws VilLanguageException in case that <code>var</code> was not defined
     */
    public Object getValue(VariableDeclaration var) throws VilLanguageException {
        try {
            return getValue((IResolvable) var);
        } catch (ExpressionException e) {
            throw new VilLanguageException(e);
        }
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
     * @throws VilLanguageException in case of an attempt of modifying a constant
     */
    public void setValue(IResolvable var, Object object) throws VilLanguageException {
        setValue((VariableDeclaration) var, object);
    }
    
    /**
     * Changes the value of <code>var</code> where it is defined.
     * 
     * @param var the variable to be modified
     * @param object the value of <code>var</code>
     * @throws VilLanguageException in case of an attempt of modifying a constant
     */
    public void setValue(VariableDeclaration var, Object object) throws VilLanguageException {
        checkType(var, object);
        currentContext.setValue(var, object);
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
     * @throws ArtifactException in case that storing artifacts fails, the level will be popped anyway
     */
    public void popLevel() throws ArtifactException {
        currentContext.popLevel();
    }

    /**
     * Changes the value of <code>var</code> to the top level.
     * 
     * @param var the variable to be modified
     * @param object the value of <code>var</code>
     * @throws VilLanguageException in case of an attempt of modifying a constant
     */
    public void addValue(VariableDeclaration var, Object object) throws VilLanguageException {
        checkType(var, object);
        currentContext.addValue(var, object);
    }

    /**
     * Checks whether <code>object</code> can be assigned to <code>var</code>.
     * 
     * @param var the variable to assign <code>object</code> to
     * @param object the object to be assigned (may be <b>null</b>)
     * @throws VilLanguageException in case of type incompatibilities
     */
    private void checkType(VariableDeclaration var, Object object) throws VilLanguageException {
        if (null != object && !var.getType().isInstance(object)) {
            String oTypeName;
            TypeDescriptor<?> oType = typeRegistry.findType(object.getClass());
            if (null == oType) {
                oTypeName = "?";
            } else {
                oTypeName = oType.getVilName();
            }
            throw new VilLanguageException("cannot assign value of type " + oTypeName 
                + " to " + var.getName() + " of type " + var.getType().getVilName(), 
                VilLanguageException.ID_RUNTIME_TYPE);
        }
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
    public Object getIvmlValue(String name) throws ExpressionException {
        return currentContext.getIvmlValue(name);
    }

}
