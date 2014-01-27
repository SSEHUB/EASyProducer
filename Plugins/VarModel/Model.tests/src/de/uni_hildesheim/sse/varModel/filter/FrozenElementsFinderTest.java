package de.uni_hildesheim.sse.varModel.filter;

import static org.junit.matchers.JUnitMatchers.hasItems;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import de.uni_hildesheim.sse.model.varModel.IFreezable;
import de.uni_hildesheim.sse.model.varModel.filter.FilterType;
import de.uni_hildesheim.sse.model.varModel.filter.FrozenElementsFinder;

/**
 * Test cases for FreezeBlockFinder class.
 * @author El-Sharkawy
 *
 */
public class FrozenElementsFinderTest extends AbstractFrozenElementsFinderTest {

    private FrozenElementsFinder finder;
    
    /**
     * Tests whether only not imported elements can be found.
     */
    @Test
    public void testFindNotImportedFreezeBlocks() {
        finder = new FrozenElementsFinder(ORIGIN_PROJECT, FilterType.NO_IMPORTS);
        List<IFreezable> frozenElements = finder.getFrozenElements();
        List<IFreezable> expectedElements = new ArrayList<IFreezable>();
        for (int i = 0; i < FREEZEBLOCKS[0].getFrozenCount(); i++) {
            expectedElements.add(FREEZEBLOCKS[0].getFreezable(i));
        }
        
        Assert.assertNotNull(frozenElements);
        Assert.assertEquals(expectedElements.size(), frozenElements.size());
        Assert.assertThat(frozenElements, hasItems(expectedElements.toArray(new IFreezable[expectedElements.size()])));
    }

    /**
     * Tests whether imported and not imported elements can be found.
     */
    @Test
    public void testALLFreezeBlocks() {
        finder = new FrozenElementsFinder(ORIGIN_PROJECT, FilterType.ALL);
        List<IFreezable> frozenElements = finder.getFrozenElements();
        List<IFreezable> expectedElements = new ArrayList<IFreezable>();
        for (int i = 0; i < FREEZEBLOCKS.length; i++) {
            for (int j = 0; j < FREEZEBLOCKS[i].getFrozenCount(); j++) {
                expectedElements.add(FREEZEBLOCKS[i].getFreezable(j));
            }            
        }
        
        Assert.assertNotNull(frozenElements);
        Assert.assertEquals(expectedElements.size(), frozenElements.size());
        Assert.assertThat(frozenElements, hasItems(expectedElements.toArray(new IFreezable[expectedElements.size()])));
    }
    
    /**
     * Tests whether only imported elements can be found.
     */
    @Test
    public void testFindImportedFreezeBlocks() {
        finder = new FrozenElementsFinder(ORIGIN_PROJECT, FilterType.ONLY_IMPORTS);
        List<IFreezable> frozenElements = finder.getFrozenElements();
        List<IFreezable> expectedElements = new ArrayList<IFreezable>();
        for (int i = 1; i < FREEZEBLOCKS.length; i++) {
            for (int j = 0; j < FREEZEBLOCKS[i].getFrozenCount(); j++) {
                expectedElements.add(FREEZEBLOCKS[i].getFreezable(j));
            }            
        }
        
        Assert.assertNotNull(frozenElements);
        Assert.assertEquals(expectedElements.size(), frozenElements.size());
        Assert.assertThat(frozenElements, hasItems(expectedElements.toArray(new IFreezable[expectedElements.size()])));
    }

}
