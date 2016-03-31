package net.ssehub.easy.varModel.model.datatypes;

/**
 * Collects all types defined for IVML.
 * 
 * @author Holger Eichelberger
 */
public class Types {
    
    private static final IDatatype[] TYPES = {
        AnyType.TYPE, 
        BooleanType.TYPE, 
        Compound.TYPE,
        Container.TYPE,
        ConstraintType.TYPE,
        Enum.TYPE,
        IntegerType.TYPE, 
        MetaType.TYPE,
        OrderedEnum.TYPE,
        RealType.TYPE,
        Reference.TYPE,
        Sequence.TYPE,
        Set.TYPE, 
        StringType.TYPE,
        VersionType.TYPE
    };

    /**
     * Prevents external creation.
     */
    private Types() {
    }
    
    /**
     * Returns the currently known types.
     * 
     * @return the currently known types
     */
    public static final IDatatype[] getTypes() {
        return TYPES.clone();
    }
    
}
    
