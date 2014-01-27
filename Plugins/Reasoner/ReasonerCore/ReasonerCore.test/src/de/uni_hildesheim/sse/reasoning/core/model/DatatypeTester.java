package de.uni_hildesheim.sse.reasoning.core.model;

import org.junit.Assert;

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
import de.uni_hildesheim.sse.reasoning.core.model.variables.BooleanVariable;
import de.uni_hildesheim.sse.reasoning.core.model.variables.CompoundVariable;
import de.uni_hildesheim.sse.reasoning.core.model.variables.EnumVariable;
import de.uni_hildesheim.sse.reasoning.core.model.variables.IntVariable;
import de.uni_hildesheim.sse.reasoning.core.model.variables.RealVariable;
import de.uni_hildesheim.sse.reasoning.core.model.variables.ReasonerVariable;
import de.uni_hildesheim.sse.reasoning.core.model.variables.ReferenceVariable;
import de.uni_hildesheim.sse.reasoning.core.model.variables.SequenceVariable;
import de.uni_hildesheim.sse.reasoning.core.model.variables.SetVariable;
import de.uni_hildesheim.sse.reasoning.core.model.variables.StringVariable;

/**
 * Tests whether {@link de.uni_hildesheim.sse.model.confModel.IDecisionVariable}s are translated
 * to correct {@link ReasonerVariable}s, i.e. whether the correct class was used.
 * @author El-Sharkawy
 *
 */
class DatatypeTester implements IDatatypeVisitor {
    private ReasonerVariable variable;
    
    /**
     * Sole constructor for testing.
     * It is not necessary to create a variable of this class, as no output/object will be returned
     * during the tests. Instead, this tester directly calls Junit assertion methods.
     * @param variable The translated {@link ReasonerVariable} which should be testet.
     */
    DatatypeTester(ReasonerVariable variable) {
        this.variable = variable;
        IDatatype type = variable.getDecisionVariable().getDeclaration().getType();
        type.accept(this);
    }

    @Override
    public void visitStringType(StringType type) {
        Assert.assertSame(StringVariable.class, variable.getClass());
    }
    
    @Override
    public void visitSet(Set set) {
        Assert.assertSame(SetVariable.class, variable.getClass());
    }
    
    @Override
    public void visitSequence(Sequence sequence) {
        Assert.assertSame(SequenceVariable.class, variable.getClass());
    }
    
    @Override
    public void visitReference(Reference reference) {
        Assert.assertSame(ReferenceVariable.class, variable.getClass());
    }
    
    @Override
    public void visitRealType(RealType type) {
        Assert.assertSame(RealVariable.class, variable.getClass());
    }
    
    @Override
    public void visitOrderedEnumType(OrderedEnum enumType) {
        visitEnumType(enumType);                
    }
    
    @Override
    public void visitMetaType(MetaType datatype) {
        Assert.fail("Not supported Datatype");                
    }
    
    @Override
    public void visitIntegerType(IntegerType type) {
        Assert.assertSame(IntVariable.class, variable.getClass());
    }
    
    @Override
    public void visitEnumType(Enum enumType) {
        Assert.assertSame(EnumVariable.class, variable.getClass());
    }
    
    @Override
    public void visitDerivedType(DerivedDatatype datatype) {
        datatype.getBasisType().accept(this);
    }
    
    @Override
    public void visitDatatype(IDatatype datatype) {
        // Not needed
    }
    
    @Override
    public void visitConstraintType(ConstraintType type) {
        Assert.fail("Not supported Datatype");
    }
    
    @Override
    public void visitCompoundType(Compound compound) {
        Assert.assertSame(CompoundVariable.class, variable.getClass());
        CompoundVariable cmpVariable = (CompoundVariable) variable;
        for (int i = 0; i < compound.getInheritedElementCount(); i++) {
            AbstractVariable nestedVariable = compound.getInheritedElement(i);
            String slotName = nestedVariable.getName();
            ReasonerVariable nestedReasonerVariable = cmpVariable.getNestedVariable(slotName);
            Assert.assertNotNull("Nested variable " + slotName + " was not translated correctly.",
                nestedReasonerVariable);
            new DatatypeTester(nestedReasonerVariable);
        }
    }
    
    @Override
    public void visitBooleanType(BooleanType type) {
        Assert.assertSame(BooleanVariable.class, variable.getClass());
    }
    
    @Override
    public void visitAnyType(AnyType datatype) {
        Assert.fail("Not supported Datatype");
    }
}
