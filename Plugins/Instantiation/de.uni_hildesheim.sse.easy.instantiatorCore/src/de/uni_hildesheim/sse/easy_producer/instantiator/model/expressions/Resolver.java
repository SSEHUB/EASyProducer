package de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;

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
    
    @SuppressWarnings("unchecked")
    @Override
    public V resolve(String name, boolean local) {
        V result = null;
        if (null != environment) {
            result = (V) environment.get(name);
        }
        for (int l = levels.size() - 1; null == result && l >= 0; l--) {
            result = levels.get(l).get(name);
            if (local) {
                break;
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

}
