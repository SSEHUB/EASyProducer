package net.ssehub.easy.instantiation.core.model.buildlangModel;

import java.util.List;

import net.ssehub.easy.basics.modelManagement.ModelImport;
import net.ssehub.easy.instantiation.core.model.templateModel.Template;

/**
 * Stores the model imports and VTL requirements for a Script.
 * 
 * @param <M> the actual model type
 * @author Holger Eichelberger
 */
public class Imports <M extends Script> 
    extends net.ssehub.easy.instantiation.core.model.common.Imports<M> {

    private List<ModelImport<Template>> vtlRestrictions;

    /**
     * Creates an imports instance.
     * 
     * @param imports the actual imports
     * @param vtlRestrictions the VTL restrictions (may be <b>null</b>)
     */
    public Imports(List<ModelImport<M>> imports, List<ModelImport<Template>> vtlRestrictions) {
        super(imports);
    }
    
    /**
     * Creates an imports instance.
     * 
     * @param imports the actual imports
     * @param vtlRestrictions the VTL restrictions (may be <b>null</b>)
     */
    public Imports(net.ssehub.easy.instantiation.core.model.common.Imports<M> imports, 
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