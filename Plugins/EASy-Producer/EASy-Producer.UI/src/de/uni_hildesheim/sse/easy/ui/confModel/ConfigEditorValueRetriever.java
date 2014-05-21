package de.uni_hildesheim.sse.easy.ui.confModel;

import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.datatypes.AnyType;
import de.uni_hildesheim.sse.model.varModel.datatypes.BooleanType;
import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
import de.uni_hildesheim.sse.model.varModel.datatypes.ConstraintType;
import de.uni_hildesheim.sse.model.varModel.datatypes.Container;
import de.uni_hildesheim.sse.model.varModel.datatypes.DerivedDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.Enum;
import de.uni_hildesheim.sse.model.varModel.datatypes.EnumLiteral;
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
import de.uni_hildesheim.sse.model.varModel.values.Value;

/**
 * This class is part of the <tt>ConfigurationCellEditor.getValue(Object)</tt> and converts a given
 * {@link IDecisionVariable} to an Object so that the Eclipse editors are able to handle it.
 * @author El-Sharkawy
 *
 */
class ConfigEditorValueRetriever implements IDatatypeVisitor {
    private Object returnValue;
    private IDecisionVariable variable;

    /**
     * Sole constructor for this class for converting a given {@link IDecisionVariable}
     * to an Object so that the Eclipse editors are able to handle it.
     * @param variable The to be converted {@link IDecisionVariable}.
     */
    ConfigEditorValueRetriever(IDecisionVariable variable) {
        this.variable = variable;
        variable.getDeclaration().getType().accept(this);
    }
    
    /**
     * Returns the value of the given {@link IDecisionVariable} so that it can be used as return value for
     * the <tt>ConfigurationCellEditor.getValue(Object)</tt> method.
     * @return A value as needed by the Eclipse UI.
     */
    Object getValue() {
        return returnValue;
    }

    @Override
    public void visitDatatype(IDatatype datatype) {
        //Not needed
    }

    @Override
    public void visitAnyType(AnyType datatype) {
        //Not needed
    }

    @Override
    public void visitMetaType(MetaType datatype) {
        //Not needed
    }
    
    @Override
    public void visitConstraintType(ConstraintType datatype) {
        // Will probably not be accessible to the editor
    }

    @Override
    public void visitDerivedType(DerivedDatatype datatype) {
        datatype.getBasisType().accept(this);        
    }

    @Override
    public void visitSet(Set set) {
        handleSetAndSequence(set);
    }

    @Override
    public void visitSequence(Sequence sequence) {
        handleSetAndSequence(sequence);
    }
    
    /**
     * Sets the returnValue for Container types.
     * @param type The Container of the current {@link IDecisionVariable}.
     */
    private void handleSetAndSequence(Container type) {
        ContainerValue value = (ContainerValue) variable.getValue();
        
        if (null != value && value.getElementSize() > 0) {
            StringBuffer result = new StringBuffer();
            for (int i = 0; i < value.getElementSize() - 1; i++) {
                //TODO SE: Only BasisTypes are supported. support Compounds, sets, ... in future
//                ConstantValue constValue = (ConstantValue) value.getElement(i);
                Value constValue = value.getElement(i);
                result.append(constValue.getValue().toString());
                result.append(", ");
            }
            // Append last element without extra comma
//            ConstantValue constValue = (ConstantValue) value.getElement(value.getElementSize() - 1);
            Value constValue = value.getElement(value.getElementSize() - 1);
            result.append(constValue.getValue().toString());
            
            returnValue = result.toString();
        } else {
            returnValue = "";
        }
    }

    @Override
    public void visitReference(Reference reference) {
        handleSimpleDatatype();
    }

    @Override
    public void visitBooleanType(BooleanType type) {
        if (variable.getValue() != null) {
            if (variable.getValue().getValue().equals(true)) {
                returnValue = 0;
            } else {
                returnValue = 1;
            }
        }
    }

    @Override
    public void visitStringType(StringType type) {
        handleSimpleDatatype();
    }

    @Override
    public void visitIntegerType(IntegerType type) {
        handleSimpleDatatype();
    }

    @Override
    public void visitRealType(RealType type) {
        handleSimpleDatatype();
    }
    
    /**
     * Sets the returnValue for simple datatypes like BasisDatatypes. 
     */
    private void handleSimpleDatatype() {
        Value tmpValue = variable.getValue();
        if (null != tmpValue && null != tmpValue.getValue()) {
            //Texteditors expect a String, therefore use toString-method.
            returnValue = tmpValue.getValue().toString();
        } else {
            returnValue = "";
        }
    }

    @Override
    public void visitCompoundType(Compound compound) {
        StringBuffer result = new StringBuffer(variable.getDeclaration().getType().getName());
        result.append(" = {");
        DecisionVariableDeclaration cpDec = (DecisionVariableDeclaration) variable.getDeclaration();
        Compound cp = (Compound) cpDec.getType();
        
        for (int i = 0; i < cp.getElementCount(); i++) {
            String name = cp.getElement(i).getName();
            String value = "null";
            CompoundValue cpVal = (CompoundValue) variable.getValue();
            Value nestedVal = cpVal.getNestedValue(name);
            if (null != nestedVal.getValue()) {
                value = nestedVal.getValue().toString();
            } 
            result.append(nestedVal.getType().getName());
            result.append(" ");
            result.append(name);
            result.append(" = ");
            result.append(value);
            result.append(", ");
        }
        result.delete(result.length() - 2, result.length());
        result.append("}");
        
        returnValue = result.toString();
    }

    @Override
    public void visitEnumType(Enum enumType) {
        Value tmpValue = variable.getValue();
        
        if (null != tmpValue) {
            EnumLiteral literal = (EnumLiteral) tmpValue.getValue();
            //ComboBox need the the index instead of the literal or string representation
            for (int i = 0; i < enumType.getLiteralCount() && null == returnValue; i++) {
                if (enumType.getLiteral(i) == literal) {
                    returnValue = i;
                }
            }
        } else {
            returnValue = 0;
        }
    }

    @Override
    public void visitOrderedEnumType(OrderedEnum enumType) {
        visitEnumType(enumType);
    }
}
