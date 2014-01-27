package de.uni_hildesheim.sse.model.varModel.values;

import java.util.HashMap;
import java.util.Map;

import de.uni_hildesheim.sse.model.varModel.datatypes.BooleanType;
import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
import de.uni_hildesheim.sse.model.varModel.datatypes.ConstraintType;
import de.uni_hildesheim.sse.model.varModel.datatypes.Container;
import de.uni_hildesheim.sse.model.varModel.datatypes.DerivedDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.IntegerType;
import de.uni_hildesheim.sse.model.varModel.datatypes.MetaType;
import de.uni_hildesheim.sse.model.varModel.datatypes.RealType;
import de.uni_hildesheim.sse.model.varModel.datatypes.Reference;
import de.uni_hildesheim.sse.model.varModel.datatypes.Sequence;
import de.uni_hildesheim.sse.model.varModel.datatypes.Set;
import de.uni_hildesheim.sse.model.varModel.datatypes.StringType;

/**
 * The ValueFactory provides easy access to the Values.
 * Object values passed in must match the value instance to be created for the 
 * specified data types. Object values may be 
 * <ul>
 *   <li>constants, such as integer values, doubles, strings</li>
 *   <li>instances of {@link Value}</li>
 *   <li>instances of {@link de.uni_hildesheim.sse.model.cst.ConstraintSyntaxTree} denoting entire expressions</li>
 *   <li>object arrays for <ul>
 *     <li>container: just containing the values</li>
 *     <li>compounds: containing name-value pairs (first entry name, second value)
 *        denoting the values for individual slots. A special value is 
 *        {@link CompoundValue#SPECIAL_SLOT_NAME_TYPE} where the value contains an
 *        object of {@link IDatatype} denoting the actual type of the compound
 *        in case of refined compounds).</li></ul>
 *   </li>
 * </ul>
 * 
 * @author lueder
 * @author Holger Eichelberger
 * @author El-Sharkawy
 */
public class ValueFactory {
    
    /**
     * This map values associated to the origin datatype.
     */
    private static Map<Class<? extends IDatatype>, IValueCreator> map
        = new HashMap<Class<? extends IDatatype>, IValueCreator>();
    
    /**
     * Private interface for calling the constructor of the right value type.
     * @author El-Sharkawy
     *
     */
    private static interface IValueCreator {
        /**
         * Part of this Factory, should call the constructor of a value.
         * 
         * @param type The concrete datype for which this value should be created.
         * This is needed for <code>StructuredDatatypes</code>.
         * @param value The unparsed value(s) which should be stored in the newly created value object-
         * @return A value object storing the parsed information of the parameter.
         * @throws ValueDoesNotMatchTypeException If the given value does not match the specified type.
         */
        Value createValue(IDatatype type, Object... value) throws ValueDoesNotMatchTypeException;
    }
    
    /**
     * Assign the constructors of the correct <code>Values</code> to the related <code>IDatatype</code>.
     */
    static {
        //Assign BasisDatatypes
        assignStringValue();
        assignIntegerValue();
        assignRealValue();
        assignBooleanValue();
        assignConstraintValue();
        
        //Assign CustomDatatypes
        assignCompoundValue();
        assignContainerValue();
        assignEnumValue();
        assignReferenceValue();
        assignDerivedDatypeValue();
        
        // Assign pseudo types
        assignMetaTypeValue();
    }
    
    /**
     * Prevent external initialization, allow subclassing.
     */
    private ValueFactory() {
    }

    /**
     * This method assigns the constructor for <code>StringValues</code> to the IDatatype <code>StringType</code>.
     */
    private static void assignStringValue() {
        map.put(StringType.class, new IValueCreator() {
            public StringValue createValue(IDatatype type, Object... value) throws ValueDoesNotMatchTypeException {
                StringValue ret;
                if (null == value) {
                    ret = new StringValue(null);
                } else {
                    ret = new StringValue(value[0].toString());
                }
                return ret;
            }
        });
    }
    
    /**
     * This method assigns the constructor for <code>IntValues</code> to the IDatatype <code>IntegerType</code>.
     */
    private static void assignIntegerValue() {
        map.put(IntegerType.class, new IValueCreator() {
            public IntValue createValue(IDatatype type, Object... value) throws ValueDoesNotMatchTypeException {
                IntValue ret;
                if (null == value) {
                    ret = new IntValue();
                } else {
                    assert 1 == value.length;
                    ret = new IntValue(value[0].toString());
                }
                return ret;
            }
        });
    }
    
    /**
     * This method assigns the constructor for <code>RealValues</code> to the IDatatype <code>RealType</code>.
     */
    private static void assignRealValue() {
        map.put(RealType.class, new IValueCreator() {
            public RealValue createValue(IDatatype type, Object... value) throws ValueDoesNotMatchTypeException {
                RealValue ret;
                if (null == value) {
                    ret = new RealValue();
                } else {
                    assert 1 == value.length;
                    ret = new RealValue(value[0].toString());
                }
                return ret;
            }
        });
    }
    
    /**
     * This method assigns the constructor for <code>DerivedDatatypeValues</code>
     * to the IDatatype <code>DerivedDatatype</code>. Since there do not exist any <code>DerivedDatatypeValues</code>,
     * this method calls the {@link #createValue(IDatatype, Object...)}
     * for the basis datatype of the <code>DerivedDatatype</code>.
     */
    private static void assignDerivedDatypeValue() {
        map.put(DerivedDatatype.class, new IValueCreator() {
            public Value createValue(IDatatype type, Object... value) throws ValueDoesNotMatchTypeException {
                DerivedDatatype dType = (DerivedDatatype) type;
                IDatatype origin = dType.getBasisType();
                return ValueFactory.createValue(origin, value);
            }
        });
    }

    /**
     * This method assigns the constructor for <code>BooleanValues</code> to the IDatatype <code>BooleanType</code>.
     */
    private static void assignMetaTypeValue() {
        map.put(MetaType.class, new IValueCreator() {
            public MetaTypeValue createValue(IDatatype type, Object... value) throws ValueDoesNotMatchTypeException {
                MetaTypeValue ret;
                if (null == value) {
                    throw new ValueDoesNotMatchTypeException("no value given", 
                        ValueDoesNotMatchTypeException.NO_DATATYPE);
                } else {
                    ret = new MetaTypeValue(value[0]);
                }
                return ret;
            }
        });
    }
    
    /**
     * This method assigns the constructor for <code>BooleanValues</code> to the IDatatype <code>BooleanType</code>.
     */
    private static void assignBooleanValue() {
        map.put(BooleanType.class, new IValueCreator() {
            public BooleanValue createValue(IDatatype type, Object... value) throws ValueDoesNotMatchTypeException {
                BooleanValue ret;
                if (null == value) {
                    ret = new BooleanValue();
                } else {
                    assert 1 == value.length;
                    ret = new BooleanValue(value[0].toString());
                }
                return ret;
            }
        });
    }

    /**
     * This method assigns the constructor for <code>ConstraintValues</code> to the IDatatype <code>BooleanType</code>.
     */
    private static void assignConstraintValue() {
        map.put(ConstraintType.class, new IValueCreator() {
            public ConstraintValue createValue(IDatatype type, Object... value) throws ValueDoesNotMatchTypeException {
                ConstraintValue ret;
                if (null == value) {
                    ret = new ConstraintValue(null);
                } else {
                    assert 1 == value.length;
                    ret = new ConstraintValue(value[0]);
                }
                return ret;
            }
        });
    }
    
    /**
     * This method assigns the constructor for <code>EnumValues</code> to the IDatatype 
     * <code>Enum</code> and <code>OrderedEnum</code>.
     */
    private static void assignEnumValue() {
        IValueCreator creator = new IValueCreator() {
            public EnumValue createValue(IDatatype type, Object... value) throws ValueDoesNotMatchTypeException {
                EnumValue result;
                de.uni_hildesheim.sse.model.varModel.datatypes.Enum eType = 
                    (de.uni_hildesheim.sse.model.varModel.datatypes.Enum) type;
                if (null == value) {
                    result = new EnumValue(eType);
                } else {
                    assert 1 == value.length;
                    result = new EnumValue(eType, value[0]);
                }
                return result;
            }
        };
        map.put(de.uni_hildesheim.sse.model.varModel.datatypes.Enum.class, creator);
        map.put(de.uni_hildesheim.sse.model.varModel.datatypes.OrderedEnum.class, creator);
    }
    
    /**
     * This method assigns the constructor for <code>CompoundValues</code> to the IDatatype <code>Compound</code>.
     */
    private static void assignCompoundValue() {
        map.put(Compound.class, new IValueCreator() {
            public CompoundValue createValue(IDatatype type, Object... value) throws ValueDoesNotMatchTypeException {
                CompoundValue result;
                if (null != value && 1 == value.length && value[0] instanceof CompoundValue) {
                    result = (CompoundValue) value[0];
                } else {
                    //This cast must work, as this method should only be called if the type is an instanceof compound
                    Compound cmp = (Compound) type;
                    result = new CompoundValue(cmp, value);
                }
                return result;
            }
        });
    }

    /**
     * This method assigns the constructor for {@link ContainerValue} to the IDatatype {@link Compound}.
     */
    private static void assignContainerValue() {
        IValueCreator creator = new IValueCreator() {
            public ContainerValue createValue(IDatatype type, Object... value) throws ValueDoesNotMatchTypeException {
                ContainerValue result;
                if (null != value && 1 == value.length && value[0] instanceof ContainerValue) {
                    // TODO this shall work on each type - currently inconsistent
                    result = (ContainerValue) value[0];
                } else {
                    //This cast must work, as this method should only be called if the type is an instanceof container
                    Container cont = (Container) type;
                    result = new ContainerValue(cont, value);
                }
                return result;
            }
        }; 
        map.put(Set.class, creator);
        map.put(Sequence.class, creator);
    }

    /**
     * This method assigns the constructor for {@link ReferenceValue} to the IDatatype {@link Reference}.
     */
    private static void assignReferenceValue() {
        map.put(Reference.class, new IValueCreator() {
            public ReferenceValue createValue(IDatatype type, Object... value) throws ValueDoesNotMatchTypeException {
                Reference ref = (Reference) type;
                return new ReferenceValue(ref, value);
            }
        });
    }
    
    /**
     * Creates and returns a Value.
     * @param type The IDatatype of the value
     * @param value the string formatted value(s)
     * @return A suitable value related to the given <code>IDatatype</code> or <b>null</b>
     * if no suitable Value exists, but should not occur.
     * @throws ValueDoesNotMatchTypeException in case of <code>value</code> cannot be converted to <code>type</code>
     */
    public static Value createValue(IDatatype type, Object... value) throws ValueDoesNotMatchTypeException {
        Value returnValue = null;
        if (Reference.TYPE.isAssignableFrom(type) && Reference.TYPE != type) {
            returnValue = map.get(type.getTypeClass()).createValue(type, value);
        } else {
            returnValue = map.get(type.getTypeClass()).createValue(type.getType(), value);
        }
        
        return returnValue;
    }

}
