package de.uni_hildesheim.sse.model.confModel;

import de.uni_hildesheim.sse.model.cst.ConstantValue;
import de.uni_hildesheim.sse.model.cst.ConstraintSyntaxTree;
import de.uni_hildesheim.sse.model.cst.Variable;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.datatypes.AnyType;
import de.uni_hildesheim.sse.model.varModel.datatypes.BooleanType;
import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
import de.uni_hildesheim.sse.model.varModel.datatypes.ConstraintType;
import de.uni_hildesheim.sse.model.varModel.datatypes.DerivedDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.Enum;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatypeVisitor;
import de.uni_hildesheim.sse.model.varModel.datatypes.IntegerType;
import de.uni_hildesheim.sse.model.varModel.datatypes.MetaType;
import de.uni_hildesheim.sse.model.varModel.datatypes.OrderedEnum;
import de.uni_hildesheim.sse.model.varModel.datatypes.RealType;
import de.uni_hildesheim.sse.model.varModel.datatypes.Reference;
import de.uni_hildesheim.sse.model.varModel.datatypes.Sequence;
import de.uni_hildesheim.sse.model.varModel.datatypes.Set;
import de.uni_hildesheim.sse.model.varModel.datatypes.StringType;
import de.uni_hildesheim.sse.model.varModel.values.CompoundValue;
import de.uni_hildesheim.sse.model.varModel.values.ContainerValue;
import de.uni_hildesheim.sse.model.varModel.values.IntValue;
import de.uni_hildesheim.sse.model.varModel.values.StringValue;
import de.uni_hildesheim.sse.model.varModel.values.Value;
import de.uni_hildesheim.sse.model.varModel.values.ValueDoesNotMatchTypeException;
import de.uni_hildesheim.sse.model.varModel.values.ValueFactory;

/**
 * Part of the configuration, setts for a given {@link Variable} the default value if specified for the related
 * {@link DecisionVariableDeclaration}.
 * @author El-Sharkawy
 *
 */
class DefaultValueSetter implements IDatatypeVisitor {
    
    private IDecisionVariable variable;
    
    /**
     * Sole constructor for this class.
     * @param variable .
     */
    public DefaultValueSetter(IDecisionVariable variable) {
        this.variable = variable;
        variable.getDeclaration().getType().accept(this);
    }

    /**
     * {@inheritDoc}
     */
    public void visitDatatype(IDatatype datatype) {
       // Not needed
    }

    /**
     * {@inheritDoc}
     */
    public void visitDerivedType(DerivedDatatype datatype) {
        datatype.getBasisType().accept(this);        
    }

    /**
     * {@inheritDoc}
     */
    public void visitSet(Set set) {
        if (null == variable.getValue() && null != variable.getDeclaration().getDefaultValue()) {
            ContainerValue containerVal = ((ContainerValue) ((ConstantValue) variable.getDeclaration().
                    getDefaultValue()).getConstantValue());
            try {
                variable.setValue(containerVal, AssignmentState.DEFAULT);
            } catch (ConfigurationException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    public void visitSequence(Sequence sequence) {
        if (null == variable.getValue() && null != variable.getDeclaration().getDefaultValue()) {
            //Getting the container value
            ContainerValue containerVal = ((ContainerValue) ((ConstantValue) variable.getDeclaration().
                    getDefaultValue()).getConstantValue());
            //Build value array containing all values
            Value[] values = new Value[containerVal.getElementSize()];
            for (int i = 0; i < values.length; i++) {
                values[i] = containerVal.getElement(i);
            }
            ContainerValue value;
            try {
                value = (ContainerValue) ValueFactory.createValue(sequence, (Object[]) values);
                variable.setValue(value, AssignmentState.DEFAULT);
            } catch (ValueDoesNotMatchTypeException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (ConfigurationException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    public void visitReference(Reference reference) {
        if (null == variable.getValue()) {
            ConstraintSyntaxTree defaultValue  = variable.getDeclaration().getDefaultValue();
            try {
                if (null != defaultValue && defaultValue instanceof Variable) {
                    Variable declValue = (Variable) defaultValue;
                    Value refValue = ValueFactory.createValue(Reference.TYPE, declValue.getVariable());
                    variable.setValue(refValue, AssignmentState.DEFAULT);
                }
            } catch (ConfigurationException e) {
                // Must not occur since the variable do not have any assignments inside this if
                e.printStackTrace();
            } catch (ValueDoesNotMatchTypeException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    public void visitBooleanType(BooleanType type) {
        setValueForBasisType(type);  
    }

    /**
     * {@inheritDoc}
     */
    public void visitStringType(StringType type) {
        setValueForBasisType(type);         
    }

    /**
     * {@inheritDoc}
     */
    public void visitIntegerType(IntegerType type) {
        setValueForBasisType(type);     
    }

    /**
     * {@inheritDoc}
     */
    public void visitRealType(RealType type) {
        setValueForBasisType(type);   
    }
    
    /**
     * {@inheritDoc}
     */
    public void visitConstraintType(ConstraintType type) {
        setValueForBasisType(type);        
    }
    
    /**
     * Sets the value for a {@link DecisionVariableDeclaration} of a <tt>BasisDatatype</tt>.<br/>
     * This works also pretty fine for enumerations.
     * @param type the type of the variable of this Setter.
     */
    private void setValueForBasisType(IDatatype type) {
        if (null == variable.getValue()) {
            ConstraintSyntaxTree defaultValue  = variable.getDeclaration().getDefaultValue();
            try {
                if (null != defaultValue && defaultValue instanceof ConstantValue) {
                    ConstantValue constValue = (ConstantValue) defaultValue;
                    variable.setValue(constValue.getConstantValue(), AssignmentState.DEFAULT);
                }
            } catch (ConfigurationException e) {
                // Must not occur since the variable do not have any assignments inside this if
                e.printStackTrace();
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    public void visitCompoundType(Compound compound) {
        String[] result;
        if (null == variable.getValue()) {
            try {
                result = getCompItems(compound);
                AssignmentState state = AssignmentState.UNDEFINED;
                for (int i = 1; i < result.length; i += 2) {
                    //Since one value is set, the AssignementState is default.
                    if (null != result[i]) {
                        state = AssignmentState.DEFAULT;
                    }
                }
                variable.setValue(ValueFactory.createValue(compound, (Object[]) result), state);
            } catch (ValueDoesNotMatchTypeException e) {
                // Must not occur since this method ensure a perfect match
                e.printStackTrace();
            } catch (ConfigurationException e) {
                // Must not occur since the variable do not have any assignments inside this if
                e.printStackTrace();
            }
        }
        
        CompoundValue cmpValue = (CompoundValue) variable.getValue();
        for (int i = 0; i < compound.getElementCount(); i++) {
            DecisionVariableDeclaration nestedDeclaration = compound.getElement(i);
            
            try {
                ConstraintSyntaxTree valueAssignment = nestedDeclaration.getDefaultValue();
                if (null != valueAssignment) {
                    Value nestedValue = ((ConstantValue) valueAssignment).getConstantValue();
                    cmpValue.configureValue(nestedDeclaration.getName(), nestedValue);
                }
            } catch (ValueDoesNotMatchTypeException e) {
                // Values should match or must be resolved by the reasoner.
            }
        }
    }

    /**
     * Method to get an array of itemnames and values. Needed to call the Valuefactory properly.
     * @param cp Compound with nested elements
     * @return alternating list of name, value ...
     */
    private String[] getCompItems(Compound cp) {
        
        //String array containing the result (alternating name,value)
        String[] ret = new String[cp.getElementCount() * 2];
        
        //if the values are set at variable declaration
        if (variable.getDeclaration().getDefaultValue() != null) {
            int counter = 0;
            for (int i = 0; i < cp.getElementCount(); i = i + 1) {
                ret[counter] = cp.getElement(i).getName(); //Name
                
                //Getting the value by the name
                ConstantValue consCompVal = (ConstantValue) variable.getDeclaration().getDefaultValue();
                CompoundValue compVal = (CompoundValue) consCompVal.getConstantValue();
                Value nestedValue = compVal.getNestedValue(ret[counter]);
                
                if (null != nestedValue.getValue()) {
                    ret[counter + 1] = nestedValue.getValue().toString(); 
                } else {
                    ret[counter + 1] = null; 
                }
                counter += 2;
            }
        } else {
          //if the values are set at compound declaration
            int counter = 0;
            for (int i = 0; i < cp.getElementCount(); i++) {
                ret[counter] = cp.getElement(i).getName(); //Name
                ConstantValue consVal = (ConstantValue) cp.getElement(i).getDefaultValue();
                
                if (null != consVal) {
                    //Getting the right type/value
                    if (consVal.inferDatatype().equals(IntegerType.TYPE)) {
                        IntValue intVal = (IntValue) consVal.getConstantValue();
                        if (null != intVal.getValue()) {
                            ret[counter + 1] = intVal.getValue().toString(); 
                        } else {
                            ret[counter + 1] = null; 
                        }                
                    } else if (consVal.inferDatatype().equals(StringType.TYPE)) {
                        StringValue strVal = (StringValue) consVal.getConstantValue();
                        if (null != strVal.getValue()) {
                            ret[counter + 1] = strVal.getValue().toString(); 
                        } else {
                            ret[counter + 1] = null; 
                        }                
                    }
                }
                counter += 2;
            }
        }
        return ret;
    }
    
    /**
     * {@inheritDoc}
     */
    public void visitEnumType(Enum enumType) {
        setValueForBasisType(enumType);      
    }

    /**
     * {@inheritDoc}
     */
    public void visitOrderedEnumType(OrderedEnum enumType) {
        setValueForBasisType(enumType);
        
    }

    /**
     * {@inheritDoc}
     */
    public void visitAnyType(AnyType datatype) {
        // TODO Auto-generated method stub
    }

    /**
     * {@inheritDoc}
     */
    public void visitMetaType(MetaType datatype) {
        // TODO Auto-generated method stub
    }
}
