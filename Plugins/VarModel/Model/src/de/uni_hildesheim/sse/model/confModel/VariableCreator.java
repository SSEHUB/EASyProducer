/*
 * Copyright 2009-2013 University of Hildesheim, Software Systems Engineering
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
package de.uni_hildesheim.sse.model.confModel;

import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
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

/**
 * Factory for converting {@link AbstractVariable} into {@link DecisionVariable}.
 * Creates the {@link DecisionVariable} and sets the default value if possible.
 * 
 * @author El-Sharkawy
 * @author Holger Eichelberger
 */
public class VariableCreator implements IDatatypeVisitor {
    
    private IDecisionVariable variable;
    private IConfigurationElement parent;
    private AbstractVariable varDecl;
    private ConfigurationException configExcetion;
    private boolean isVisible;

    /**
     * Sole constructor for this class.
     * @param varDecl The specification of the variable which should be created
     * @param parent The parent this variable is part of, typically the {@link Configuration}
     *   instance, but in case of compounds also the containing {@link DecisionVariable}
     * @param isVisible Specifies whether this variables is exported by an interface or not:
     * <ul>
     * <li><tt>true</tt>: The variable is exported by an interface or there is no interface</li>.
     * <li><tt>false</tt>: There is an interface which does not export this variable</li>.
     * </ul>
     */
    public VariableCreator(AbstractVariable varDecl, IConfigurationElement parent, boolean isVisible) {
        variable = null;
        this.configExcetion = null;
        this.varDecl = varDecl;
        this.parent = parent;
        this.isVisible = isVisible;
        varDecl.getType().accept(this);
    }
    
    /**
     * Returns the created variable.
     * @return The {@link DecisionVariable} representing the given {@link AbstractVariable}.
     * @throws ConfigurationException in case that the types of 
     *   {@link AbstractVariable} and {@link DecisionVariable} do not comply
     */
    public IDecisionVariable getVariable() throws ConfigurationException {                
        return variable;
    }

    /**
     * Return the {@link IDecisionVariable} as in {@link #getVariable()}.
     * However, during the initialization of {@link NestedVarConfigProvider} the usage of the
     * {@link DefaultValueSetter} will cause {@link NullPointerException}'s. Therefore, this method with 
     * <tt>setDefaultValue = false</tt> should be used inside the initialization of nested {@link IDecisionVariable}s.
     * @param setDefaultValue <tt>true</tt> if the default value should be set for the newly created
     *     {@link IDecisionVariable}, otherwise <tt>false</tt>.
     * @return The {@link IDecisionVariable} representing the given {@link AbstractVariable},
     * which was created by running the constructor of this class.
     * @throws ConfigurationException in case that the types of 
     *   {@link AbstractVariable} and {@link DecisionVariable} do not comply
     */
    IDecisionVariable getVariable(boolean setDefaultValue) throws ConfigurationException {
        IDecisionVariable var = null;
        if (!setDefaultValue && null == configExcetion) {
            var = variable;
        } else {
            var = getVariable();
        }
        
        return var;
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
        // TODO Not needed
    }

    @Override
    public void visitDerivedType(DerivedDatatype datatype) {
        datatype.getBasisType().accept(this);
    }

    @Override
    public void visitSet(Set set) {
        variable = new SetVariable(varDecl, parent, isVisible);
    }

    @Override
    public void visitSequence(Sequence sequence) {
        variable = new SequenceVariable(varDecl, parent, isVisible);
    }

    @Override
    public void visitReference(Reference reference) {
        variable = new BasisVariable(parent, varDecl, isVisible);
    }

    @Override
    public void visitBooleanType(BooleanType type) {
        variable = new BasisVariable(parent, varDecl, isVisible);
    }

    @Override
    public void visitStringType(StringType type) {
        variable = new BasisVariable(parent, varDecl, isVisible);
    }
    
    @Override
    public void visitConstraintType(ConstraintType type) {
        variable = new BasisVariable(parent, varDecl, isVisible);
    }

    @Override
    public void visitIntegerType(IntegerType type) {
        variable = new BasisVariable(parent, varDecl, isVisible);
    }

    @Override
    public void visitRealType(RealType type) {
        variable = new BasisVariable(parent, varDecl, isVisible);
    }

    @Override
    public void visitCompoundType(Compound compound) {
        variable = new CompoundVariable(parent, varDecl, isVisible);
    }

    @Override
    public void visitEnumType(Enum enumType) {
        variable = new BasisVariable(parent, varDecl, isVisible);
    }

    @Override
    public void visitOrderedEnumType(OrderedEnum enumType) {
        variable = new BasisVariable(parent, varDecl, isVisible);
    }

    @Override
    public void visitVersionType(VersionType type) {
        // this is an internal type, variables actually cannot hold values of this type
    }
}
