package net.ssehub.easy.reasoning.drools2.model.variables;

import java.util.HashMap;
import java.util.Map;

import net.ssehub.easy.reasoning.drools2.model.ReasonerModel;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.model.datatypes.BooleanType;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.ConstraintType;
import net.ssehub.easy.varModel.model.datatypes.DerivedDatatype;
import net.ssehub.easy.varModel.model.datatypes.Enum;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.IntegerType;
import net.ssehub.easy.varModel.model.datatypes.OrderedEnum;
import net.ssehub.easy.varModel.model.datatypes.RealType;
import net.ssehub.easy.varModel.model.datatypes.Reference;
import net.ssehub.easy.varModel.model.datatypes.Sequence;
import net.ssehub.easy.varModel.model.datatypes.Set;
import net.ssehub.easy.varModel.model.datatypes.StringType;

/**
 * Factory for creating {@link IntVariable}'s for a given {@link IDecisionVariable}.
 * @author El-Sharkawy
 *
 */
public class ReasonerVariableFactory {
    
    //public static final String DELIMITER = "__";
    
    /**
     * This map stores the information, which constructor should be called for a given {@link IDatatype}.
     */
    private static Map<Class<? extends IDatatype>, IReasonerVariableCreator> map;
    
    /**
     * Files the map and specifies, which ReasonerVariable should be created for each possible {@link IDatatype}.
     */
    static {
        map = new HashMap<Class<? extends IDatatype>, ReasonerVariableFactory.IReasonerVariableCreator>();
        
        // Basic Datatypes
        createIntegerHandler();
        createStringHandler();
        createBooleanHandler();
        createRealHandler();
        createEnumHandler();
        createReferencesHandler();
        createConstraintHandler();
        
        //Structured Datatypes
        createDerivedVariablesHandler();
        createCompoundHandler();
        createSetHandler();
        createSequenceHandler();
    }
    
    /**
     * Private interface for calling the constructor of the right {@link ReasonerVariable}.
     * @author El-Sharkawy
     *
     */
    private interface IReasonerVariableCreator {
        
        /**
         * Method for creating the {@link ReasonerVariable}s.
         * @param configVariable The {@link IDecisionVariable} for which the {@link ReasonerVariable} shall be created.
         * @param model the {@link ReasonerModel}, where this variable should be added to
         *     (needed for {@link net.ssehub.easy.reasoning.drools2.model.datatypes.ReasonerDatatype} resolution).
         * @param parent Variables container.     
         * @return A {@link ReasonerVariable} representing the given {@link IDecisionVariable}.
         */
        ReasonerVariable createReasonerVariable(IDecisionVariable configVariable, ReasonerModel model,
                ReasonerVariable parent);
    }
    
    /**
     * Adds a {@link IReasonerVariableCreator} to this map for creating {@link IntVariable}s.
     */
    private static void createIntegerHandler() {
        map.put(IntegerType.class, new IReasonerVariableCreator() {
            
            @Override
            public ReasonerVariable createReasonerVariable(IDecisionVariable configVariable, ReasonerModel model, 
                    ReasonerVariable parent) {
                
                return new IntVariable(configVariable, cleanName(configVariable.getDeclaration().getName()), model,
                        parent);
            }
        });
    }
    
    /**
     * Adds a {@link IReasonerVariableCreator} to this map for creating {@link StringVariable}s.
     */
    private static void createStringHandler() {
        map.put(StringType.class, new IReasonerVariableCreator() {
            
            @Override
            public ReasonerVariable createReasonerVariable(IDecisionVariable configVariable, ReasonerModel model, 
                    ReasonerVariable parent) {
                
                return new StringVariable(configVariable, cleanName(configVariable.getDeclaration().getName()), model,
                        parent);
            }
        });
    }
    
    /**
     * Adds a {@link IReasonerVariableCreator} to this map for creating {@link BooleanVariable}s.
     */
    private static void createBooleanHandler() {
        map.put(BooleanType.class, new IReasonerVariableCreator() {
            
            @Override
            public ReasonerVariable createReasonerVariable(IDecisionVariable configVariable, ReasonerModel model, 
                    ReasonerVariable parent) {
                
                return new BooleanVariable(configVariable, cleanName(configVariable.getDeclaration().getName()),
                        model, parent);
            }
        });
    }
    
    /**
     * Adds a {@link IReasonerVariableCreator} to this map for creating {@link RealVariable}s.
     */
    private static void createRealHandler() {
        map.put(RealType.class, new IReasonerVariableCreator() {
            
            @Override
            public ReasonerVariable createReasonerVariable(IDecisionVariable configVariable, ReasonerModel model, 
                    ReasonerVariable parent) {
                
                return new RealVariable(configVariable, cleanName(configVariable.getDeclaration().getName()), model,
                        parent);
            }
        });
    }
    
    /**
     * Adds a {@link IReasonerVariableCreator} to this map for creating {@link EnumVariable}s.
     */
    private static void createEnumHandler() {
        IReasonerVariableCreator enumCreator = new IReasonerVariableCreator() {
            
            @Override
            public ReasonerVariable createReasonerVariable(IDecisionVariable configVariable, ReasonerModel model, 
                    ReasonerVariable parent) {
                
                return new EnumVariable(configVariable, cleanName(configVariable.getDeclaration().getName()), model,
                        parent);
            }
        };
        
        map.put(Enum.class, enumCreator);
        map.put(OrderedEnum.class, enumCreator);
    }
    
    /**
     * Adds a {@link IReasonerVariableCreator} to this map for creating {@link ReferenceVariable}s.
     */
    private static void createReferencesHandler() {
        map.put(Reference.class, new IReasonerVariableCreator() {
            
            @Override
            public ReasonerVariable createReasonerVariable(IDecisionVariable configVariable, ReasonerModel model, 
                    ReasonerVariable parent) {
                
                return new ReferenceVariable(configVariable, cleanName(configVariable.getDeclaration().getName()),
                        model, parent);
            }
        });
    }
    
    /**
     * Adds a {@link IReasonerVariableCreator} to this map for creating {@link ConstraintVariable}s.
     */
    private static void createConstraintHandler() {
        map.put(ConstraintType.class, new IReasonerVariableCreator() {
            
            @Override
            public ReasonerVariable createReasonerVariable(IDecisionVariable configVariable, ReasonerModel model, 
                    ReasonerVariable parent) {
                
                return new ConstraintVariable(configVariable, cleanName(configVariable.getDeclaration().getName()),
                        model, parent);
            }
        });
    }
    
    /**
     * Adds a {@link IReasonerVariableCreator} to this map for creating {@link ReasonerVariable}s of a
     * {@link DerivedDatatype}.
     */
    private static void createDerivedVariablesHandler() {
        map.put(DerivedDatatype.class, new IReasonerVariableCreator() {
            
            @Override
            public ReasonerVariable createReasonerVariable(IDecisionVariable configVariable, ReasonerModel model, 
                    ReasonerVariable parent) {
                
                // Determine the basis (origin) datatype of the derived datatype and call the factory again.
                DerivedDatatype dType = (DerivedDatatype) configVariable.getDeclaration().getType();
                IDatatype origin = dType.getBasisType();
                return ReasonerVariableFactory.createVariables(origin, configVariable, model, parent);
            }
        });
    }
    
    /**
     * Adds a {@link IReasonerVariableCreator} to this map for creating {@link ReferenceVariable}s.
     */
    private static void createCompoundHandler() {
        map.put(Compound.class, new IReasonerVariableCreator() {
            
            @Override
            public ReasonerVariable createReasonerVariable(IDecisionVariable configVariable, ReasonerModel model, 
                    ReasonerVariable parent) {
                
                // Create the compound
                CompoundVariable cmpVariable = new CompoundVariable(configVariable,
                        cleanName(configVariable.getDeclaration().getName()), model, parent);
                
                // Recursive call for all nested elements, to create a flat model
                for (int i = 0; i < configVariable.getNestedElementsCount(); i++) {
                    IDecisionVariable nestedVariable = configVariable.getNestedElement(i);
                    ReasonerVariable nestedReasonerVariable = createVariables(nestedVariable.getDeclaration().getType(),
                        nestedVariable, model, cmpVariable);
                    cmpVariable.addNested(nestedReasonerVariable);
                }
                
                return cmpVariable;
            }
        });
    }
    
    /**
     * Adds a {@link IReasonerVariableCreator} to this map for creating {@link SetVariable}s.
     */
    private static void createSetHandler() {
        map.put(Set.class, new IReasonerVariableCreator() {
            
            @Override
            public ReasonerVariable createReasonerVariable(IDecisionVariable configVariable, ReasonerModel model, 
                    ReasonerVariable parent) {
                                
                return new SetVariable(configVariable,
                        cleanName(configVariable.getDeclaration().getName()), model, parent);
            }
        });
    }
    
    /**
     * Adds a {@link IReasonerVariableCreator} to this map for creating {@link SequenceVariable}s.
     */
    private static void createSequenceHandler() {
        map.put(Sequence.class, new IReasonerVariableCreator() {
            
            @Override
            public ReasonerVariable createReasonerVariable(IDecisionVariable configVariable, ReasonerModel model, 
                    ReasonerVariable parent) {
                
                return new SequenceVariable(configVariable, cleanName(configVariable.getDeclaration().getName()),
                        model, parent);
            }
        });
    }
    
    /**
     * Creates a {@link ReasonerVariable}s for the given {@link IDecisionVariable}.
     * @param configVariable The {@link IDecisionVariable} for which {@link ReasonerVariable}s should be created.
     * @param model the {@link ReasonerModel}, where this variable should be added to
     *     (needed for {@link net.ssehub.easy.reasoning.drools2.model.datatypes.ReasonerDatatype} resolution).
     * @param parent Variables container. 
     * @return A {@link ReasonerVariable} representing the given {@link IDecisionVariable}.
     */
    public static ReasonerVariable createVariables(IDecisionVariable configVariable, ReasonerModel model,
            ReasonerVariable parent) {
        IDatatype type = configVariable.getDeclaration().getType();
        
        // Creates the ReasonerVariables for the given IDecisionVariable
        return createVariables(type, configVariable, model, parent);
    }
    
    /**
     * Internal factory method for creating {@link ReasonerVariable}s.
     * This method facilitates method calls for different ({@link IDecisionVariable}, {@link IDatatype}),
     * which is needed by the {@link #createDerivedVariablesHandler()} method. 
     * @param type The {@link IDatatype} of the {@link IDecisionVariable}. In case of a {@link DerivedDatatype},
     *     this can be {@link DerivedDatatype#getBasisType()}.
     * @param configVariable The {@link IDecisionVariable} for which {@link IntVariable}s should be created.
     * @param model the {@link ReasonerModel}, where this variable should be added to
     *     (needed for {@link net.ssehub.easy.reasoning.drools2.model.datatypes.ReasonerDatatype} resolution).
     * @param parent Variables container.
     * @return A {@link ReasonerVariable} representing the given {@link IDecisionVariable}.
     */
    private static ReasonerVariable createVariables(IDatatype type, IDecisionVariable configVariable,
        ReasonerModel model, ReasonerVariable parent) {
        
        ReasonerVariable result = null;
        if (Reference.TYPE.isAssignableFrom(type) && Reference.TYPE != type) {
            result = map.get(type.getClass()).createReasonerVariable(configVariable, model, parent);
        } else {
            result = map.get(type.getType().getClass()).createReasonerVariable(configVariable, model, parent);
        }
        return result;
    }
    
    /**
     * Method to get rid of spaces, [], {} in set and sequence nested elements names.
     * @param name name before modification.
     * @return modified name.
     */
    private static String cleanName(String name) {
        String noSpaceName = name.replace(" ", "");
        String noLeftCBracketsName = noSpaceName.replace("{", "");
        String noRightRBracketsName = noLeftCBracketsName.replace("}", "");
        String noLeftSBracketsName = noRightRBracketsName.replace("[", "");
        String noRightSBracketsName = noLeftSBracketsName.replace("]", "");
        return noRightSBracketsName;
        
    }
}
