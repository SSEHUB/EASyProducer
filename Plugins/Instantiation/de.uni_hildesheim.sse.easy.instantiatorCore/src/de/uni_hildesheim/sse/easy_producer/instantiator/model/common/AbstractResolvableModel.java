package de.uni_hildesheim.sse.easy_producer.instantiator.model.common;

import java.util.List;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.IResolvable;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;
import de.uni_hildesheim.sse.utils.modelManagement.IModel;
import de.uni_hildesheim.sse.utils.modelManagement.ModelImport;

/**
 * A basic implementation of {@link IResolvableModel}.
 * 
 * @param <V> the actual type of variable declaration
 * @param <M> the actual type of model
 * 
 * @author Holger Eichelberger
 */
public abstract class AbstractResolvableModel<V extends IResolvable, M extends IModel> implements IResolvableModel<V> {

    private Imports<M> imports;
    private TypeRegistry registry;

    /**
     * Creates an abstract resolvable model.
     * 
     * @param imports the imports
     * @param registry the registry which is responsible for this type
     */
    protected AbstractResolvableModel(Imports<M> imports, TypeRegistry registry) {
        this.imports = imports;
        this.registry = registry;
    }
    
    @Override
    public int getImportsCount() {
        return null == imports ? 0 : imports.getImportsCount();
    }

    @Override
    public ModelImport<M> getImport(int index) {
        if (null == imports) {
            throw new IllegalArgumentException();
        }
        return imports.getImport(index);
    }
    
    /**
     * Creates an empty imports instance (in case that a specialized instance
     * shall be used).
     * 
     * @return the created instance
     */
    protected Imports<M> createImports() {
        return new Imports<M>((List<ModelImport<M>>) null);
    }
    
    /**
     * Add a project import to this model.
     * 
     * @param imp The additional project import.
     */
    public void addImport(ModelImport<M> imp) {
        if (null == imports) {
            imports = createImports();
        }
        imports.add(imp);
    }
    
    /**
     * Returns the imports instance.
     * 
     * @return the imports instance
     */
    protected Imports<M> getImports() {
        return imports;
    }
    
    @Override
    public TypeRegistry getTypeRegistry() {
        return registry;
    }

}
