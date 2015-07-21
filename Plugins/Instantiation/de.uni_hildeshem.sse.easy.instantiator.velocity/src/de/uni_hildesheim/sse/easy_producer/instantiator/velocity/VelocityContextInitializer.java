/*
 * Copyright 2009-2015 University of Hildesheim, Software Systems Engineering
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
import de.uni_hildesheim.sse.model.varModel.datatypes.VersionType;
import de.uni_hildesheim.sse.model.varModel.values.BooleanValue;
import de.uni_hildesheim.sse.model.varModel.values.CompoundValue;
import de.uni_hildesheim.sse.model.varModel.values.EnumValue;
import de.uni_hildesheim.sse.model.varModel.values.IntValue;
import de.uni_hildesheim.sse.model.varModel.values.RealValue;
import de.uni_hildesheim.sse.model.varModel.values.StringValue;
import de.uni_hildesheim.sse.model.varModel.values.Value;
import de.uni_hildesheim.sse.model.varModel.values.VersionValue;
import de.uni_hildesheim.sse.utils.modelManagement.Version;

/**
 * Converts an {@link IDecisionVariable} into flat {@link VelocityContextItem}, because Velocity needs a
 * simple (name, value) tuple for instantiation.
 * @author Sascha El-Sharkawy
 *
 */
class VelocityContextInitializer implements IDatatypeVisitor {
    public static final char SLOT_ACCESS = '-';
    private List<VelocityContextItem> values;
    private StringBuffer variableName;
    private IDecisionVariable variable;
    
    /**
     * Sole constructor, will immediately start the conversation.
     * @param variable A frozen {@link IDecisionVariable} of the configuration which shall be
     * used inside the instantiation process.
     */
    VelocityContextInitializer(IDecisionVariable variable) {
        values = new ArrayList<VelocityContextItem>();
        variableName = new StringBuffer();
        this.variable = variable;
        variable.getDeclaration().getType().accept(this);
    }
    
    /**
     * The converted {@link VelocityContextItem}s.
     * Structured variables like compounds oder container will be converted into multiple items, one item
     * for each nested element.
     * @return The converted items of the {@link IDecisionVariable} passed to the constructor.
     */
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

    /**
     * Shall convert {@link de.uni_hildesheim.sse.model.confModel.ContainerVariable}
     * into {@link VelocityContextItem}s, but not implemented yet.
     */
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
        reference.getType().accept(this); // configuration handles references transparently
    }

    @Override
    public void visitBooleanType(BooleanType type) {
        variableName.append(variable.getDeclaration().getName());
        BooleanValue booleanValue = (BooleanValue) variable.getValue();
        if (null != booleanValue) {
            values.add(new VelocityContextItem(variableName.toString(), booleanValue.getValue()));
        }
    }

    @Override
    public void visitStringType(StringType type) {
        variableName.append(variable.getDeclaration().getName());
        StringValue stringValue = (StringValue) variable.getValue();
        if (null != stringValue) {
            values.add(new VelocityContextItem(variableName.toString(), stringValue.getValue()));
        }
    }

    @Override
    public void visitIntegerType(IntegerType type) {
        variableName.append(variable.getDeclaration().getName());
        IntValue intValue = (IntValue) variable.getValue();
        if (null != intValue) {
            values.add(new VelocityContextItem(variableName.toString(), intValue.getValue()));
        }
    }

    @Override
    public void visitRealType(RealType type) {
        variableName.append(variable.getDeclaration().getName());
        RealValue realValue = (RealValue) variable.getValue();
        if (null != realValue) {
            values.add(new VelocityContextItem(variableName.toString(), realValue.getValue()));
        }
    }

    @Override
    public void visitCompoundType(Compound compound) {
        StringBuffer variableNameBeforeCMP = new StringBuffer(variableName);
        variableName.append(variable.getDeclaration().getName());
        CompoundValue cmpValue = (CompoundValue) variable.getValue();
        if (null != cmpValue) {
            for (int i = 0; i < compound.getElementCount(); i++) {
                StringBuffer elementName = new StringBuffer(compound.getElement(i).getName());
                Value nestedValue = cmpValue.getNestedValue(elementName.toString());
                if (null != nestedValue) {
                    elementName.insert(0, SLOT_ACCESS);
                    elementName.insert(0, variableName);
                    values.add(new VelocityContextItem(elementName.toString(), nestedValue.getValue()));
                }
            }
            values.add(new VelocityContextItem(variable.getDeclaration().getName(), cmpValue));
        }
        variableName = variableNameBeforeCMP;
    }
    

    @Override
    public void visitEnumType(Enum enumType) {
        variableName.append(variable.getDeclaration().getName());
        EnumValue enumValue = (EnumValue) variable.getValue();
        if (null != enumValue) {
            values.add(new VelocityContextItem(variableName.toString(), enumValue.getValue().getName()));
        }
    }

    @Override
    public void visitOrderedEnumType(OrderedEnum enumType) {
        visitEnumType(enumType);
    }

    @Override
    public void visitVersionType(VersionType type) {
        variableName.append(variable.getDeclaration().getName());
        VersionValue versionValue = (VersionValue) variable.getValue();
        if (null != versionValue) {
            values.add(new VelocityContextItem(variableName.toString(), Version.toString(versionValue.getValue())));
        }
    }

}
