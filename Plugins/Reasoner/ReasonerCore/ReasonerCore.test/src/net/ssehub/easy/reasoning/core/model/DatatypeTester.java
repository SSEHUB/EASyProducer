package net.ssehub.easy.reasoning.core.model;

import org.junit.Assert;

import net.ssehub.easy.reasoning.core.model.variables.BooleanVariable;
import net.ssehub.easy.reasoning.core.model.variables.CompoundVariable;
import net.ssehub.easy.reasoning.core.model.variables.EnumVariable;
import net.ssehub.easy.reasoning.core.model.variables.IntVariable;
import net.ssehub.easy.reasoning.core.model.variables.RealVariable;
import net.ssehub.easy.reasoning.core.model.variables.ReasonerVariable;
import net.ssehub.easy.reasoning.core.model.variables.ReferenceVariable;
import net.ssehub.easy.reasoning.core.model.variables.SequenceVariable;
import net.ssehub.easy.reasoning.core.model.variables.SetVariable;
import net.ssehub.easy.reasoning.core.model.variables.StringVariable;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.datatypes.AnyType;
import net.ssehub.easy.varModel.model.datatypes.BooleanType;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.ConstraintType;
import net.ssehub.easy.varModel.model.datatypes.DerivedDatatype;
import net.ssehub.easy.varModel.model.datatypes.Enum;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.IDatatypeVisitor;
import net.ssehub.easy.varModel.model.datatypes.IntegerType;
import net.ssehub.easy.varModel.model.datatypes.MetaType;
import net.ssehub.easy.varModel.model.datatypes.OrderedEnum;
import net.ssehub.easy.varModel.model.datatypes.RealType;
import net.ssehub.easy.varModel.model.datatypes.Reference;
import net.ssehub.easy.varModel.model.datatypes.Sequence;
import net.ssehub.easy.varModel.model.datatypes.Set;
import net.ssehub.easy.varModel.model.datatypes.StringType;
import net.ssehub.easy.varModel.model.datatypes.VersionType;

/**
 * Tests whether {@link net.ssehub.easy.varModel.confModel.IDecisionVariable}s are translated
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

    @Override
    public void visitVersionType(VersionType type) {
        Assert.fail("Not supported Datatype");
    }
    
}
