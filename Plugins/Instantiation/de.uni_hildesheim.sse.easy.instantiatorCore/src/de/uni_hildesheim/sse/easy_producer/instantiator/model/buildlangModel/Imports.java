package de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel;

import java.util.List;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.Template;
import de.uni_hildesheim.sse.utils.modelManagement.ModelImport;

/**
 * Stores the model imports and VTL requirements for a Script.
 * 
 * @author Holger Eichelberger
 */
public class Imports extends de.uni_hildesheim.sse.easy_producer.instantiator.model.common.Imports<Script> {

    private List<ModelImport<Template>> vtlRestrictions;

    /**
     * Creates an imports instance.
     * 
     * @param imports the actual imports
     * @param vtlRestrictions the VTL restrictions (may be <b>null</b>)
     */
    public Imports(List<ModelImport<Script>> imports, List<ModelImport<Template>> vtlRestrictions) {
        super(imports);
    }
    
    /**
     * Creates an imports instance.
     * 
     * @param imports the actual imports
     * @param vtlRestrictions the VTL restrictions (may be <b>null</b>)
     */
    public Imports(de.uni_hildesheim.sse.easy_producer.instantiator.model.common.Imports<Script> imports, 
        List<ModelImport<Template>> vtlRestrictions) {
        super(imports);
        this.vtlRestrictions = vtlRestrictions;
    }
    
    /**
     * Returns the number of VTL restrictions.
     * 
     * @return the number of VTL restrictions
     */
    public int getVtlRestrictionsCount() {
        return null == vtlRestrictions ? 0 : vtlRestrictions.size(); 
    }
    
    /**
     * Returns the specified VTL restriction.
     * 
     * @param index the 0-based index of the VTL restriction
     * @return the specified model import
     * @throws IndexOutOfBoundsException if <code>index &lt; 0 || index &gt;={@link #getVtlRestrictionsCount()}</code>
     */
    public ModelImport<Template> getVtlRestriction(int index) {
        if (null == vtlRestrictions) {
            throw new IndexOutOfBoundsException();
        }
        return vtlRestrictions.get(index);
    }
    
}