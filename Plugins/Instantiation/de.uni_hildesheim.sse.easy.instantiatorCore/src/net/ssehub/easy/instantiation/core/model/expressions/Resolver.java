package net.ssehub.easy.instantiation.core.model.expressions;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import net.ssehub.easy.basics.modelManagement.IModel;
import net.ssehub.easy.dslCore.translation.ErrorCodes;
import net.ssehub.easy.dslCore.translation.IMessageReceiver;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;

/**
 * A basic implementation for a hierarchical resolver.
 * 
 * @param <V> the type of variable declarations
 * 
 * @author Holger Eichelberger
 */
public abstract class Resolver<V extends IResolvable> implements IResolver<V> {

    /**
     * Defines a type for contexts (i.e., constants).
     * 
     * @author Holger Eichelberger
     */
    protected interface IContextType {
    }
    
    /**
     * Represents a (nested) resolution level.
     * 
     * @param <V> the type of variable declarations
     *
     * @author Holger Eichelberger
     */
    private static class Level<V extends IResolvable> {
        private Map<String, V> variables = new HashMap<String, V>();
        private IContextType context;
        private boolean limit = false;
        
        /**
         * Creates a new level with a given context type.
         * 
         * @param context the context type
         */
        public Level(IContextType context) {
            setContextType(context);
        }
        
        /**
         * Puts a variable.
         * 
         * @param name the name of the variable
         * @param var the variable (resolvable)
         */
        public void put(String name, V var) {
            variables.put(name, var);
        }
        
        /**
         * Removes a variable.
         * 
         * @param name the name of the variable
         */
        public void remove(String name) {
            variables.remove(name);
        }
        
        /**
         * Returns whether this level contains a variable with the given <code>name</code>.
         * 
         * @param name the name to search for
         * @return <code>true</code> if the variable is registered, <code>false</code> else
         */
        public boolean contains(String name) {
            return variables.containsKey(name);
        }
        
        /**
         * Returns the variable for a given name.
         * 
         * @param name the name to return the variable for
         * @return the variable (may be <b>null</b>)
         */
        public V get(String name) {
            return variables.get(name);
        }
        
        /**
         * Defines the current context.
         * 
         * @param context the current context
         */
        public void setContextType(IContextType context) {
            this.context = context;
        }
        
        /**
         * Returns the current context.
         * 
         * @return the current context
         */
        public IContextType getContextType() {
            return context;
        }
        
        /**
         * Indicates that subsequent resolutions within that scope shall not exceed this scope.
         */
        public void limitVariables() {
            limit = true;
        }
        
        /**
         * Returns whether this scope is limited.
         * 
         * @return <code>true</code> if limited, <code>false</code> else
         * @see #limitVariables()
         */
        public boolean isLimited() {
            return limit;
        }
        
    }
    
    private Stack<Level<V>> levels = new Stack<Level<V>>();
    private IRuntimeEnvironment environment;
    private TypeRegistry registry;
    
    /**
     * Creates a new resolver.
     * 
     * @param registry the local type registry
     */
    public Resolver(TypeRegistry registry) {
        this.registry = registry;
        pushLevel(); // push the basic level
    }
    
    /**
     * Creates a new resolver considering the runtime environment. (for expression
     * resolution only).
     * 
     * @param environment the runtime environment
     */
    public Resolver(IRuntimeEnvironment environment) {
        this(environment.getTypeRegistry());
        this.environment = environment;
    }
    
    /**
     * Returns the (local) type registry.
     * 
     * @return the local type registry (from the {@link #environment}).
     */
    public TypeRegistry getTypeRegistry() {
        return registry;
    }
    
    @Override
    public V resolve(String name, boolean local) {
        return resolve(name, local, null, null, null);
    }

    /**
     * Resolves a variable.
     * 
     * @param name the name of the variable
     * @param local consider only the local scope or also outside nested scopes
     * @param cause the causing EObject (may be <b>null</b>)
     * @param causeFeature the causing feature on <code>cause</code> (may be <b>null</b>)
     * @param receiver the message receiver for discouraged warnings (may be <b>null</b>, but if not <b>null</b> also 
     *     <code>cause</code> and <code>causeFeature</code> shall be given for standard message receivers)
     * @return the variable declaration or <b>null</b>
     */
    @SuppressWarnings("unchecked")
    public V resolve(String name, boolean local, EObject cause, EStructuralFeature causeFeature, 
        IMessageReceiver receiver) {
        V result = null;
        if (null != environment) {
            result = (V) environment.get(name);
        }
        boolean limited = false;
        for (int l = levels.size() - 1; null == result && l >= 0; l--) {
            Level<V> level = levels.get(l);
            result = level.get(name);
            if (limited && null != result && null != receiver) {
                receiver.warning("discouraged scope access to variable '" + name + "'", cause, 
                    causeFeature, ErrorCodes.DISCOURAGED);
            }
            if (local) {
                break;
            }
            if (null == result && level.isLimited()) {
                limited = true;
            }
        }
        return result;
    }
    
    /**
     * Returns the actual context type.
     * 
     * @return the actual context type
     */
    public IContextType getContextType() {
        return levels.peek().getContextType();
    }
    
    /**
     * Defines the actual context type.
     * 
     * @param context the actual context type
     */
    public void setContextType(IContextType context) {
        levels.peek().setContextType(context);
    }
    
    /**
     * Adds a variable declaration to the actual level.
     * 
     * @param decl the variable declaration
     */
    public void add(V decl) {
        add(decl, "");
    }
    
    /**
     * Removes the given declaration from the actual level.
     * 
     * @param decl the declaration to remove
     */
    public void remove(V decl) {
        remove(decl, "");
    }
    
    /**
     * Adds a <code>name</code> alias for <code>decl</code>, only if <code>name</code>
     * has not been defined before. This method helps to migrate from old to new implicit name conventions.
     * 
     * @param name the alias name
     * @param decl the variable declaration
     */
    public void addAlias(String name, V decl) {
        Level<V> level = levels.peek();
        if (null == level.get(name)) {
            level.put(name, decl);
        }
    }

    /**
     * Adds a variable declaration to the actual level.
     * 
     * @param decl the variable declaration
     * @param qualification the qualification path of the name
     */
    protected void add(V decl, String qualification) {
        Level<V> level = levels.peek();
        level.put(qualification + decl.getName(), decl);
    }
    
    /**
     * Removes a variable declaration from the actual level.
     * 
     * @param decl the variable declaration
     * @param qualification the qualification path of the name
     */
    protected void remove(V decl, String qualification) {
        Level<V> level = levels.peek();
        level.remove(qualification + decl.getName());
    }
    
    /**
     * Indicates that subsequent resolutions within that scope shall not exceed the actual scope.
     */
    public void limitVariablesOnCurrentLevel() {
        levels.peek().limitVariables();
    }

    /**
     * Returns whether a variable with the same name as <code>decl</code> is already known.
     * 
     * @param decl the declaration to search for
     * @return <code>true</code> if there is a variable, <code>false</code> else
     * @see #contains(IResolvable)
     */
    public boolean contains(V decl) {
        return contains(decl.getName());
    }
     
    /**
     * Returns whether a variable with <code>name</code> is already known.
     * 
     * @param name the variable name to search for
     * @return <code>true</code> if there is a variable, <code>false</code> else
     */    
    public boolean contains(String name) {
        boolean contains = false;
        for (int l = levels.size() - 1; !contains && l >= 0; l--) {
            contains = levels.get(l).contains(name);
        }
        return contains;
    }
    
    /**
     * Adds all variable declarations in <code>decl</code> to the actual level.
     * 
     * @param decls the declarations to be added (may be <b>null</b>)
     */
    public void add(V[] decls) {
        if (null != decls) {
            for (int v = 0; v < decls.length; v++) {
                add(decls[v]);
            }
        }
    }
    
    /**
     * Adds all variable declarations in <code>decl</code> to the actual level.
     * 
     * @param decls the declarations to be added (may be <b>null</b>)
     */
    public void add(List<V> decls) {
        if (null != decls) {
            for (int v = 0; v < decls.size(); v++) {
                add(decls.get(v));
            }
        }
    }
    
    /**
     * Returns the default type.
     * 
     * @return the default type
     */
    protected abstract IContextType getDefaultType();
    
    /**
     * Pushes a resolution level, e.g., when a nested language unit is opened.
     * An opening with {@link #pushLevel()} shall properly be closed with {@link #popLevel()}.
     */
    public void pushLevel() {
        IContextType type;
        if (levels.isEmpty()) {
            type = getDefaultType();
        } else {
            type = levels.peek().getContextType();
        }
        levels.push(new Level<V>(type)); // push the basic level, take over the type - nested structures in rules
    }
    
    /**
     * Pops the top resolution level, e.g., when a nested language unit is closed.
     * The most basic level cannot be popped.
     * 
     * @throws EmptyStackException if the most basic level shall be popped
     */
    public void popLevel() {
        if (levels.size() > 1) {
            levels.pop();
        } else {
            throw new EmptyStackException();
        }
    }
    
    /**
     * Returns the current number of levels. Please note that one basic level
     * is always present, i.e., the number of pushed levels is <code>{@link #getLevelCount()} - 1</code>.
     * 
     * @return the current number of levels
     */
    public int getLevelCount() {
        return levels.size();
    }
    
    @Override
    public Object getIvmlElement(String name) {
        return null; // cannot resolve by default
    }
    
    /**
     * Returns the current model.
     * 
     * @return the current model (or <b>null</b> if there is none)
     */
    public IModel getCurrentModel() {
        return null; // shall be overridden
    }
    
    /**
     * Resolves a type within the known contexts / models.
     * 
     * @param name the name of the type
     * @return the type or <b>null</b> for unknown
     */
    public TypeDescriptor<?> resolveType(String name) {
        return null;
    }

}
