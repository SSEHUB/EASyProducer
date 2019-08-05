package net.ssehub.easy.varModel.model.datatypes;

import java.util.HashMap;
import java.util.Map;

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
    
    private static final Map<String, IDatatype> BASIC = new HashMap<String, IDatatype>();

    static {
        addBasicType(BooleanType.TYPE);
        addBasicType(IntegerType.TYPE);
        addBasicType(RealType.TYPE);
        addBasicType(StringType.TYPE);
        addBasicType(ConstraintType.TYPE);
        addBasicType(AnyType.TYPE);
    }
    
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

    /**
     * Registers a basic type for retrieval by name.
     * 
     * @param type the basic type
     */
    private static void addBasicType(IDatatype type) {
        BASIC.put(type.getName(), type);
    }

    /**
     * Returns a basic type by name.
     * 
     * @param name the name of the type
     * @return the basic type or <b>null</b> if not found
     */
    public static final IDatatype getBasicTypeByName(String name) {
        return BASIC.get(name);
    }
    
}
    
