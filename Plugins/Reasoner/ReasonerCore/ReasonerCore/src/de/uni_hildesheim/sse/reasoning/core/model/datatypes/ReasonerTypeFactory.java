package de.uni_hildesheim.sse.reasoning.core.model.datatypes;

import java.util.HashMap;
import java.util.Map;

import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.CustomDatatype;
import net.ssehub.easy.varModel.model.datatypes.Enum;
import net.ssehub.easy.varModel.model.datatypes.OrderedEnum;
import net.ssehub.easy.varModel.model.datatypes.Reference;

/**
 * Factory for creating {@link ReasonerDatatype}'s for a given {@link CustomDatatype}.
 * @author El-Sharkawy
 * @author Sizonenko
 *
 */
public class ReasonerTypeFactory {
    
    /**
     * This map stores the information, which constructor should be called for a given {@link CustomDatatype}.
     */
    private static Map<Class<? extends CustomDatatype>, IReasonerDatatypeCreator> map
        = new HashMap<Class<? extends CustomDatatype>, IReasonerDatatypeCreator>();
    
    /**
     * Files the map and specifies, which ReasonerDatatype should be created for each possible {@link CustomDatatype}.
     */
    static {
        createCompoundHandler();
        createEnumHandler();
        createReferenceHandler();
    }
    
    /**
     * Private interface for calling the constructor of the right {@link ReasonerDatatype}.
     * @author El-Sharkawy
     *
     */
    private interface IReasonerDatatypeCreator {
        
        /**
         * Method for crating the {@link ReasonerDatatype}s.
         * @param type The {@link CustomDatatype} for which the {@link ReasonerDatatype} shall be created.
         * @param project The {@link Project} where reasoning should be performed.
         * @return A {@link ReasonerDatatype} representing the given {@link CustomDatatype}.
         */
        ReasonerDatatype createReasonerDatatype(CustomDatatype type, Project project);
    }
    
    /**
     * Creates a handler for creating {@link CompoundType}s.
     */
    private static void createCompoundHandler() {
        map.put(Compound.class, new IReasonerDatatypeCreator() {
            
            @Override
            public ReasonerDatatype createReasonerDatatype(CustomDatatype type, Project project) {
                return new CompoundType((Compound) type);
            }
        });
    }
    
    /**
     * Creates a handler for creating {@link Reference}s.
     */
    private static void createReferenceHandler() {
        map.put(Reference.class, new IReasonerDatatypeCreator() {
            
            @Override
            public ReasonerDatatype createReasonerDatatype(CustomDatatype type, Project project) {
                return new ReferenceType((Reference) type, project);
            }
        });
    }
    
    /**
     * Creates a handler for creating {@link Enum}s.
     */
    private static void createEnumHandler() {
        IReasonerDatatypeCreator enumCreator = new IReasonerDatatypeCreator() {
            
            @Override
            public ReasonerDatatype createReasonerDatatype(CustomDatatype type, Project project) {
                return new EnumType((Enum) type);
            }
        };
        
        map.put(Enum.class, enumCreator);
        map.put(OrderedEnum.class, enumCreator);
    }
    
    /**
     * Creates a {@link ReasonerDatatype}s for the given {@link CustomDatatype}.
     * @param type The {@link CustomDatatype} for which {@link ReasonerDatatype}s should be created.
     * @param project The {@link Project} where reasoning should be performed.
     * @return A {@link ReasonerDatatype} representing the given {@link CustomDatatype}.
     */
    public static ReasonerDatatype createDatatype(CustomDatatype type, Project project) {
        ReasonerDatatype createdType = null;
        IReasonerDatatypeCreator creator = map.get(type.getClass());
        if (null != creator) {
            createdType = creator.createReasonerDatatype(type, project);
        }
        
        return createdType;
    }

}
