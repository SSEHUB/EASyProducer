package de.uni_hildesheim.sse.easy_producer.instantiator.velocity;

import java.util.ArrayList;
import java.util.List;

import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;
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
import de.uni_hildesheim.sse.model.varModel.values.BooleanValue;
import de.uni_hildesheim.sse.model.varModel.values.CompoundValue;
import de.uni_hildesheim.sse.model.varModel.values.EnumValue;
import de.uni_hildesheim.sse.model.varModel.values.IntValue;
import de.uni_hildesheim.sse.model.varModel.values.RealValue;
import de.uni_hildesheim.sse.model.varModel.values.StringValue;
import de.uni_hildesheim.sse.model.varModel.values.Value;

class VelocityContextInitializer implements IDatatypeVisitor {
    private static final char SLOT_ACCESS = '-';
    private List<VelocityContextItem> values;
    private StringBuffer variableName;
    private IDecisionVariable variable;
    
    VelocityContextInitializer(IDecisionVariable variable) {
        values = new ArrayList<VelocityContextItem>();
        variableName = new StringBuffer();
        this.variable = variable;
        variable.getDeclaration().getType().accept(this);
    }
    
    List<VelocityContextItem> getItems() {
        return values;
    }

    @Override
    public void visitDatatype(IDatatype datatype) {
        // Not needed
    }

    @Override
    public void visitAnyType(AnyType datatype) {
        // Not needed
    }

    @Override
    public void visitMetaType(MetaType datatype) {
        // Not needed
    }

    @Override
    public void visitConstraintType(ConstraintType datatype) {
        // Not needed
    }
    
    @Override
    public void visitDerivedType(DerivedDatatype datatype) {
        datatype.getBasisType().accept(this);    
    }

    private void handleContainer() {
//        variableName.append(variable.getDeclaration().getName());
//        ContainerValue containerValue = (ContainerValue) variable.getValue();
//        for (int i = 0; i < containerValue.getElementSize(); i++) {
//            ConstraintSyntaxTree cstValue = containerValue.getElement(i);
//            //TODO SE handle this, this is only a preliminary version/test
//            
//        }       
    }
    
    @Override
    public void visitSet(Set set) {
        handleContainer();
    }

    @Override
    public void visitSequence(Sequence sequence) {
        handleContainer();
    }

    @Override
    public void visitReference(Reference reference) {
        variableName.append(variable.getDeclaration().getName());
        //TODO SE: handle refernces.
    }

    @Override
    public void visitBooleanType(BooleanType type) {
        variableName.append(variable.getDeclaration().getName());
        BooleanValue booleanValue = (BooleanValue) variable.getValue();
        values.add(new VelocityContextItem(variableName.toString(), booleanValue.getValue()));
    }

    @Override
    public void visitStringType(StringType type) {
        variableName.append(variable.getDeclaration().getName());
        StringValue stringValue = (StringValue) variable.getValue();
        values.add(new VelocityContextItem(variableName.toString(), stringValue.getValue()));;
    }

    @Override
    public void visitIntegerType(IntegerType type) {
        variableName.append(variable.getDeclaration().getName());
        IntValue intValue = (IntValue) variable.getValue();
        values.add(new VelocityContextItem(variableName.toString(), intValue.getValue()));
    }

    @Override
    public void visitRealType(RealType type) {
        variableName.append(variable.getDeclaration().getName());
        RealValue realValue = (RealValue) variable.getValue();
        values.add(new VelocityContextItem(variableName.toString(), realValue.getValue()));
    }

    @Override
    public void visitCompoundType(Compound compound) {
        StringBuffer variableNameBeforeCMP = new StringBuffer(variableName);
        variableName.append(variable.getDeclaration().getName());
        CompoundValue cmpValue = (CompoundValue) variable.getValue();
        for (int i = 0; i < compound.getElementCount(); i++) {
            StringBuffer elementName = new StringBuffer(compound.getElement(i).getName());
            Value nestedValue = cmpValue.getNestedValue(elementName.toString());
            elementName.insert(0, SLOT_ACCESS);
            elementName.insert(0, variableName);
            values.add(new VelocityContextItem(elementName.toString(), nestedValue.getValue()));
        }
        values.add(new VelocityContextItem(variable.getDeclaration().getName(), cmpValue));
        variableName = variableNameBeforeCMP;
    }
    

    @Override
    public void visitEnumType(Enum enumType) {
        variableName.append(variable.getDeclaration().getName());
        EnumValue enumValue = (EnumValue) variable.getValue();
        values.add(new VelocityContextItem(variableName.toString(), enumValue.getValue().getName()));
    }

    @Override
    public void visitOrderedEnumType(OrderedEnum enumType) {
        visitEnumType(enumType);
    }

}
