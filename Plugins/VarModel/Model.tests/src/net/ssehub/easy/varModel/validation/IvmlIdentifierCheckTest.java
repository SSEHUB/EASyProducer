package net.ssehub.easy.varModel.validation;

import org.junit.Assert;
import org.junit.Test;

import net.ssehub.easy.varModel.model.IvmlKeyWords;

/**
 * Tests the {@link IvmlIdentifierCheck} class.
 * @author El-Sharkawy
 *
 */
public class IvmlIdentifierCheckTest {

    /**
     * Tests whether the keyword <tt>null</tt> is checked correctly.
     */
    @Test
    public void testNullKeyWord() {
        Assert.assertTrue(IvmlIdentifierCheck.isReservedName(IvmlKeyWords.NULL));
        Assert.assertFalse(IvmlIdentifierCheck.isValidIdentifier(IvmlKeyWords.NULL));
    }

}
