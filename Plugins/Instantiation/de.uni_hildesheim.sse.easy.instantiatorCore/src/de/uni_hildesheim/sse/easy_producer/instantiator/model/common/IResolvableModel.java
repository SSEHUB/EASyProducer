package de.uni_hildesheim.sse.easy_producer.instantiator.model.common;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.IResolvable;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IMetaType;
import de.uni_hildesheim.sse.utils.modelManagement.IModel;

/**
 * Defines the interface for a resolvable model which may provide its parts
 * as operations.
 * 
 * @param <V> the actual type of variable
 * 
 * @author Holger Eichelberger
 */
public interface IResolvableModel<V extends IResolvable> extends IParameterizable<V>, IModel, IMetaType {

    /**
     * Returns whether the given <code>name</code> resolves to an IVML element.
     * 
     * @param name the name to be resolved
     * @return <code>true</code> if <code>name</code> can be resolved, <code>false</code> else
     */
    public boolean isIvmlElement(String name);
    
    /**
     * Get the parent project which this project extends.
     * 
     * @return The parent project of this project or <code>null</code> if no parent is defined for this project.
     */
    public IResolvableModel<V> getParent();
    
    /**
     * Returns the number of extension types declared in/by this model.
     * 
     * @return the number of extension types
     */
    public int getExtensionTypesCount();
    
    /**
     * Returns the specified extension type.
     * 
     * @param index the 0-based index of the extension type to be returned
     * @return the specified extension type
     * @throws IndexOutOfBoundsException in case that 
     *     <code>index &lt; 0 || index &gt;={@link #getExtensionTypesCount()}</code>
     */
    public IMetaType getExtensionType(int index);
    
    /**
     * Get the number of variable declaration of this model.
     * 
     * @return The number of variable declaration of this model.
     */
    public int getVariableDeclarationCount();

    /**
     * Get the variable declaration of this model at the specified index.
     * 
     * @param index The 0-based index of the variable declaration to be returned.
     * @return The variable declaration at the given index.
     * @throws IndexOutOfBoundsException if 
     *     <code>index &lt; 0 || index &gt;={@link #getVariableDeclarationCount()}</code>
     */
    public V getVariableDeclaration(int index);

    /**
     * Returns whether a variable declaration is implicit (predefined).
     * 
     * @param decl the declaration to be tested
     * @return <code>true</code> if it is implicit, <code>false</code> else
     */
    public boolean isImplicit(V decl);

}
