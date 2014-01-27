package test.de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes;

import java.util.Iterator;

import junit.framework.Assert;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Sequence;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration.AbstractIvmlVariable;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration.DecisionVariable;
import de.uni_hildesheim.sse.model.varModel.values.BooleanValue;
import de.uni_hildesheim.sse.model.varModel.values.CompoundValue;
import de.uni_hildesheim.sse.model.varModel.values.ConstraintValue;
import de.uni_hildesheim.sse.model.varModel.values.ContainerValue;
import de.uni_hildesheim.sse.model.varModel.values.EnumValue;
import de.uni_hildesheim.sse.model.varModel.values.IValueVisitor;
import de.uni_hildesheim.sse.model.varModel.values.IntValue;
import de.uni_hildesheim.sse.model.varModel.values.MetaTypeValue;
import de.uni_hildesheim.sse.model.varModel.values.NullValue;
import de.uni_hildesheim.sse.model.varModel.values.RealValue;
import de.uni_hildesheim.sse.model.varModel.values.ReferenceValue;
import de.uni_hildesheim.sse.model.varModel.values.StringValue;
import de.uni_hildesheim.sse.model.varModel.values.Value;

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
            instanceof de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration.EnumValue);
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
        Assert.assertNull(decl.getValue());
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
        Assert.assertNull(decl.getValue());
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
    
}