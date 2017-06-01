package net.ssehub.easy.instantiation.core.model.vilTypes;

import net.ssehub.easy.varModel.model.datatypes.IDatatype;

/**
 * VIL types implementing this interface may provide a more actual type of an object, 
 * e.g., an argument during dynamic dispatch.
 * 
 * Actually, this interface mixes VIL and IVML types, but we need the type (or at least
 * its qualified actual type/import path, which is not the qualified name)
 * 
 * @author Holger Eichelberger
 */
public interface IActualTypeProvider extends IVilType {

    /**
     * The more actual type name of this object.
     * 
     * @return the more actual type name (may be <b>null</b> if none can be determined)
     */
    public IDatatype determineActualTypeName();
    
    /**
     * Returns the more actual type of this object.
     * 
     * @return the more actual type
     */
    public TypeDescriptor<?> getType();
        
}
