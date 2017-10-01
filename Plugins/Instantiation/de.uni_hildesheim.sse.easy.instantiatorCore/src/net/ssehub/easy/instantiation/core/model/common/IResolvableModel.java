package net.ssehub.easy.instantiation.core.model.common;

import net.ssehub.easy.basics.modelManagement.IModel;
import net.ssehub.easy.basics.modelManagement.ModelImport;
import net.ssehub.easy.instantiation.core.model.vilTypes.IMetaParameterDeclaration;
import net.ssehub.easy.instantiation.core.model.vilTypes.IMetaType;
import net.ssehub.easy.instantiation.core.model.vilTypes.ITypedModel;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;

/**
 * Defines the interface for a resolvable model which may provide its parts
 * as operations.
 * 
 * @param <V> the actual type of variable
 * @param <M> the model type
 * 
 * @author Holger Eichelberger
 */
public interface IResolvableModel<V extends IMetaParameterDeclaration, M extends IModel> 
    extends IParameterizable<V>, ITypedModel {

    /**
     * Returns whether the given <code>name</code> resolves to an IVML element.
     * 
     * @param name the name to be resolved
     * @return the IVML element (value, containable model element), <b>null</b> else
     */
    public Object getIvmlElement(String name);
    
    /**
     * Get the parent project which this project extends.
     * 
     * @return The parent project of this project or <code>null</code> if no parent is defined for this project.
     */
    public IResolvableModel<V, M> getParent();
    
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

    /**
     * Returns the responsible type registry.
     * 
     * @return the type registry
     */
    public TypeRegistry getTypeRegistry();
    
    /**
     * Get the number of typedefs of this model.
     * 
     * @return The number of typedefs of this model.
     */
    public int getTypedefCount();
    
    /**
     * Get the typedef at the specified index.
     * 
     * @param index The 0-based index of the typedef to be returned.
     * @return The typedef parameter at the given index.
     * @throws IndexOutOfBoundsException if <code>index &lt; 0 || index &gt;={@link #getTypedefCount()}</code>
     */
    public Typedef getTypedef(int index);

    /**
     * Returns the typedef with given name.
     * 
     * @param name the name
     * @return the typedef (may be <b>null</b> for none)
     */
    public Typedef getTypedef(String name);
    
    /**
     * Adds a runtime model import.
     * 
     * @param imp the import
     */
    public void addRuntimeImport(ModelImport<M> imp);

    /**
     * Get the number of compounds defined in this model.
     * 
     * @return The number of compounds of this model.
     */
    public int getCompoundCount();
    
    /**
     * Get the compound at the specified index.
     * 
     * @param index The 0-based index of the compound to be returned.
     * @return The compound at the given index.
     * @throws IndexOutOfBoundsException if <code>index &lt; 0 || index &gt;={@link #getCompoundCount()}</code>
     */
    public Compound getCompound(int index);
    
    /**
     * Returns the compound declaration with given name.
     * 
     * @param name the name
     * @return the compound (may be <b>null</b> for none)
     */
    public Compound getCompound(String name);

}
