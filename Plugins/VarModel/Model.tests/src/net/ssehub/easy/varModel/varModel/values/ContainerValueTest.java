package net.ssehub.easy.varModel.varModel.values;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.varModel.model.datatypes.IntegerType;
import net.ssehub.easy.varModel.model.datatypes.Set;
import net.ssehub.easy.varModel.model.values.ContainerValue;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;

/**
 * ContainerValue test class.
 * 
 * @author Sass
 *
 */
public class ContainerValueTest {
    
    private static final EASyLogger LOGGER = EASyLoggerFactory.INSTANCE.getLogger(ContainerValueTest.class, "Test");
    
    private ContainerValue value;
    
    private Set set;
    
    private Object[] innerStart = {"1", "2", "3", "4"};
    
    /**
     * Creates a project that is needed for this test.
     */
    @Before
    public void setUp() {
        set = new Set("set", IntegerType.TYPE, null);
        Set outerSet = new Set("outerSet", set, null);
        Value innerValue = null;
        try {
            innerValue = (ContainerValue) ValueFactory.createValue(set, innerStart);
            value = (ContainerValue) ValueFactory.createValue(outerSet, innerValue);
        } catch (ValueDoesNotMatchTypeException e) {
            LOGGER.exception(e);
        }
        Assert.assertSame(innerValue, value.getElement(0));
    }
    
    /**
     * Tests whether cloning of ContainerValue succeeds and if the cloned objects are the same.
     * @throws ValueDoesNotMatchTypeException Must not occur, otherwise it the setValue method of {@link ContainerValue}
     * is detecting duplicates but there are no duplicates.
     */
    @Test
    public void cloneContainerTest() throws ValueDoesNotMatchTypeException {
        ContainerValue clone = (ContainerValue) value.clone();
        Assert.assertNotSame(clone, value);
        ContainerValue subValue = (ContainerValue) value.getElement(0);
        int subsize = subValue.getElementSize();
        Value integerValue = null;
        try {
            integerValue = ValueFactory.createValue(IntegerType.TYPE, "5");
        } catch (ValueDoesNotMatchTypeException e) {
            LOGGER.exception(e);
        }
        subValue.setValue(0, integerValue);
        Assert.assertEquals(subsize, subValue.getElementSize());
        Assert.assertNotSame(clone, value);
        Assert.assertFalse("ContainerValue and its clone are the same!", value.equals(clone));
    }
    

}
