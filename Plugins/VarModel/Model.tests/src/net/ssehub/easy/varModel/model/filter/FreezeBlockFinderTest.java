package net.ssehub.easy.varModel.model.filter;

import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;

import java.util.List;

import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Test;

import net.ssehub.easy.varModel.model.FreezeBlock;

/**
 * Test cases for FreezeBlockFinder class.
 * @author El-Sharkawy
 *
 */
public class FreezeBlockFinderTest extends AbstractFrozenElementsFinderTest {

    private FreezeBlockFinder finder;
    
    /**
     * Tests whether only not imported elements can be found.
     */
    @Test
    public void testFindNotImportedFreezeBlocks() {
        finder = new FreezeBlockFinder(ORIGIN_PROJECT, FilterType.NO_IMPORTS);
        List<FreezeBlock> frozenBlocks = finder.getFreezeBlocks();
        
        Assert.assertNotNull(frozenBlocks);
        Assert.assertEquals(1, frozenBlocks.size());
        Assert.assertSame(FREEZEBLOCKS[0], frozenBlocks.get(0));
    }

    /**
     * Tests whether imported and not imported elements can be found.
     */
    @Test
    public void testALLFreezeBlocks() {
        finder = new FreezeBlockFinder(ORIGIN_PROJECT, FilterType.ALL);
        List<FreezeBlock> frozenBlocks = finder.getFreezeBlocks();
        
        Assert.assertNotNull(frozenBlocks);
        Assert.assertEquals(FREEZEBLOCKS.length, frozenBlocks.size());
        MatcherAssert.assertThat(frozenBlocks, hasItems(FREEZEBLOCKS));
    }
    
    /**
     * Tests whether only imported elements can be found.
     */
    @SuppressWarnings("unchecked")
    @Test
    public void testFindImportedFreezeBlocks() {
        finder = new FreezeBlockFinder(ORIGIN_PROJECT, FilterType.ONLY_IMPORTS);
        List<FreezeBlock> frozenBlocks = finder.getFreezeBlocks();
        
        Matcher<Iterable<FreezeBlock>> expected;
        expected = allOf(hasItem(FREEZEBLOCKS[1]), hasItem(FREEZEBLOCKS[2]), hasItem(FREEZEBLOCKS[3]));
        
        Assert.assertNotNull(frozenBlocks);
        Assert.assertEquals(3, frozenBlocks.size());
        MatcherAssert.assertThat(frozenBlocks, expected);
    }
}
