package de.uni_hildesheim.sse.model.validation;

import junit.framework.Assert;

import org.junit.Test;

import de.uni_hildesheim.sse.model.varModel.IvmlKeyWords;

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
