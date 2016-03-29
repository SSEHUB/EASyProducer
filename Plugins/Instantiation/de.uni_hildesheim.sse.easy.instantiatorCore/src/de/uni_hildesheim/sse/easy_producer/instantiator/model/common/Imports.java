package de.uni_hildesheim.sse.easy_producer.instantiator.model.common;

import java.util.ArrayList;
import java.util.List;

import net.ssehub.easy.basics.modelManagement.IModel;
import net.ssehub.easy.basics.modelManagement.ModelImport;

/**
 * Stores the model imports for a language unit.
 * 
 * @param <M> the model type
 * 
 * @author Holger Eichelberger
 */
public class Imports <M extends IModel> {

    private List<ModelImport<M>> imports;

    /**
     * Creates an imports instance.
     * 
     * @param imports the actual imports
     */
    public Imports(List<ModelImport<M>> imports) {
        this.imports = imports;
    }

    /**
     * Creates an imports instance form the given <code>src</code> instance.
     * 
     * @param src the source imports instance
     */
    protected Imports(Imports<M> src) {
        if (null != src) {
            this.imports = src.imports;
        }
    }
    
    /**
     * Get the number of imports of this template.
     * 
     * @return The number of imports of this template.
     */
    public int getImportsCount() {
        return null == imports ? 0 : imports.size();
    }
    
    /**
     * Get the parameter of this template at the specified index.
     * 
     * @param index The 0-based index of the import to be returned.
     * @return The import at the given index.
     * @throws IndexOutOfBoundsException if 
     *     <code>index &lt; 0 || index &gt;={@link #getImportsCount()}</code>
     */
    public ModelImport<M> getImport(int index) {
        if (null == imports) {
            throw new IndexOutOfBoundsException();
        }
        return imports.get(index);
    }
    
    /**
     * Returns an import matching the given <code>name</code>.
     * 
     * @param name the name to search for
     * @return the matching import or <b>null</b>
     */
    public ModelImport<M> getImport(String name) {
        ModelImport<M> result = null;
        int count = getImportsCount();
        for (int i = 0; null == result && i < count; i++) {
            ModelImport<M> imp = getImport(i);
            if (imp.getName().equals(name)) {
                result = imp;
            }
        }
        return result;
    }
    
    /**
     * Adds an import.
     * 
     * @param imp the import to be added
     */
    public void add(ModelImport<M> imp) {
        if (null == imports) {
            imports = new ArrayList<ModelImport<M>>();
        }
        imports.add(imp);
    }

}
