package de.uni_hildesheim.sse.easy_producer.instantiator.model.common;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.IResolvable;
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

    /**
     * Creates an abstract resolvable model.
     * 
     * @param imports the imports
     */
    protected AbstractResolvableModel(Imports<M> imports) {
        this.imports = imports;
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
     * Add a project import to this model.
     * 
     * @param imp The additional project import.
     */
    public void addImport(ModelImport<M> imp) {
        if (null == imports) {
            imports = new Imports<M>(null);
        }
        imports.add(imp);
    }

}
