package net.ssehub.easy.instantiation.core.model.vilTypes;

import java.util.Iterator;

import org.junit.Assert;

import net.ssehub.easy.instantiation.core.model.vilTypes.Sequence;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.AbstractIvmlVariable;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.DecisionVariable;
import net.ssehub.easy.varModel.model.values.BooleanValue;
import net.ssehub.easy.varModel.model.values.CompoundValue;
import net.ssehub.easy.varModel.model.values.ConstraintValue;
import net.ssehub.easy.varModel.model.values.ContainerValue;
import net.ssehub.easy.varModel.model.values.EnumValue;
import net.ssehub.easy.varModel.model.values.IValueVisitor;
import net.ssehub.easy.varModel.model.values.IntValue;
import net.ssehub.easy.varModel.model.values.MetaTypeValue;
import net.ssehub.easy.varModel.model.values.NullValue;
import net.ssehub.easy.varModel.model.values.RealValue;
import net.ssehub.easy.varModel.model.values.ReferenceValue;
import net.ssehub.easy.varModel.model.values.StringValue;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.model.values.VersionValue;

/**
 * Implements a value tester for an individual decision variable.
 * 
 * @author Holger Eichelberger
 */
class ValueTester implements IValueVisitor {
    
    private AbstractIvmlVariable decl;
    
    /**
     * Creates a value tester instance.
     * 
     * @param decl the VIL instance to test
     */
    ValueTester(AbstractIvmlVariable decl) {
        this.decl = decl;
    }

    @Override
    public void visitConstraintValue(ConstraintValue value) {
        // not relevant in final configuration
    }

    @Override
    public void visitEnumValue(EnumValue value) {
        Assert.assertTrue(decl.getValue() 
            instanceof net.ssehub.easy.instantiation.core.model.vilTypes.configuration.EnumValue);
        Assert.assertNotNull(decl.getEnumValue());
        Assert.assertTrue(decl.getEnumValue().equals(decl.getValue())); // may be two different instances
        Assert.assertEquals(value.getValue().getName(), decl.getEnumValue().getName());
    }

    @Override
    public void visitStringValue(StringValue value) {
        Assert.assertTrue(decl.getValue() instanceof String);
        Assert.assertNotNull(decl.getStringValue());
        Assert.assertTrue(decl.getStringValue().equals(decl.getValue()));
        Assert.assertEquals(value.getValue(), decl.getStringValue());
    }

    @Override
    public void visitCompoundValue(CompoundValue value) {
        //Assert.assertNull(decl.getValue());
        Iterator<DecisionVariable> iter = decl.variables().iterator();
        while (iter.hasNext()) {
            DecisionVariable var = iter.next();
            Value val = value.getNestedValue(var.getName());
            Assert.assertNotNull(val);
            val.accept(new ValueTester(var));
        }
    }

    @Override
    public void visitContainerValue(ContainerValue value) {
        //Assert.assertNull(decl.getValue());
        Sequence<DecisionVariable> seq = decl.variables();
        for (int i = 0; i < value.getElementSize(); i++) {
            Value val = value.getElement(i);
            val.accept(new ValueTester(seq.get(i)));
        }
    }

    @Override
    public void visitIntValue(IntValue value) {
        Assert.assertTrue(decl.getValue() instanceof Integer);
        Assert.assertNotNull(decl.getIntegerValue());
        Assert.assertTrue(decl.getIntegerValue().equals(decl.getValue()));
        Assert.assertEquals(value.getValue(), decl.getIntegerValue());
    }

    @Override
    public void visitRealValue(RealValue value) {
        Assert.assertTrue(decl.getValue() instanceof Double);
        Assert.assertNotNull(decl.getRealValue());
        Assert.assertTrue(decl.getRealValue().equals(decl.getValue()));
        Assert.assertEquals(value.getValue(), decl.getRealValue());
    }

    @Override
    public void visitBooleanValue(BooleanValue value) {
        Assert.assertTrue(decl.getValue() instanceof Boolean);
        Assert.assertNotNull(decl.getBooleanValue());
        Assert.assertTrue(decl.getBooleanValue().equals(decl.getValue()));
        Assert.assertEquals(value.getValue(), decl.getBooleanValue());
    }

    @Override
    public void visitReferenceValue(ReferenceValue referenceValue) {
        // unsure
    }

    @Override
    public void visitMetaTypeValue(MetaTypeValue value) {
        // not relevant here
    }

    @Override
    public void visitNullValue(NullValue value) {
        // shall not occur
    }

    @Override
    public void visitVersionValue(VersionValue value) {
        // shall not occur as variables actually cannot not have this type
    }
    
}