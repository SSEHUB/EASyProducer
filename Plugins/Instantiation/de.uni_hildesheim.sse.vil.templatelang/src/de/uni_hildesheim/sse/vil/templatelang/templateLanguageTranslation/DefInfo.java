package de.uni_hildesheim.sse.vil.templatelang.templateLanguageTranslation;

import de.uni_hildesheim.sse.vil.templatelang.templateLang.VilDef;
import net.ssehub.easy.instantiation.core.model.templateModel.Def;

/**
 * Stores (temporary) information about the relation of an ECore and an Template 
 * model instance.
 * 
 * @author Holger Eichelberger
 */
class DefInfo {

    private VilDef vilDef;
    private Def def;

    /**
     * Creates an information object.
     * 
     * @param vilDef the VIL def from ECore
     * @param def the related def template model instance
     */
    public DefInfo(VilDef vilDef, Def def) {
        this.vilDef = vilDef;
        this.def = def;
    }
    
    /**
     * Returns the VIL def from ECore.
     * 
     * @return the VIL def
     */
    public VilDef getVilDef() {
        return vilDef;
    }
    
    /**
     * Returns the related template model instance.
     * 
     * @return the def instance
     */
    public Def getDef() {
        return def;
    }
    
}
