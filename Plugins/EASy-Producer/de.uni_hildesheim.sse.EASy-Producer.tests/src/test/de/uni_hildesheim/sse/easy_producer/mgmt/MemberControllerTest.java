package test.de.uni_hildesheim.sse.easy_producer.mgmt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.uni_hildesheim.sse.easy_producer.core.mgmt.MemberController;
import de.uni_hildesheim.sse.easy_producer.core.mgmt.MemberIterator;
import de.uni_hildesheim.sse.easy_producer.core.mgmt.PLPInfo;
import de.uni_hildesheim.sse.easy_producer.model.ProductLineProject;

/**
 * Tests the MemberController and its functions.
 * 
 * @author Pastuschek
 * 
 */
public class MemberControllerTest {

    private MemberController testController = new MemberController("test");
    private PLPInfo first = new PLPInfo("f", "first", "1", null);
    private Set<String> testSet;
    private Collection<PLPInfo> testCollection;
    private List<PLPInfo> testListe = new ArrayList<PLPInfo>();
    private MemberIterator memIt;
    private List<String> testListeString;
    private PLPInfo testProject = new ProductLineProject("test", null);

    /**
     * Sets up the testing cases, with one predecessor and one successor added. Also sets up a list with a project.
     */
    @Before
    public void setUp() {

        testController.addPredecessor(first);
        testController.addSuccessor(first);
        testListe.add(first);

    }

    /**
     * Tests functionality of predecessor methods.
     */
    @Test
    public void testPredecessors() {

        // Test whether Controller has predecessors (should be the case since we added one in the setUp)
        Assert.assertTrue(testController.hasPredecessors());
        Assert.assertTrue(testController.containsPredecessor(first.getProjectName()));
        Assert.assertFalse(testController.containsPredecessor("notWithin"));

        // Test possible Predecessors
        testListeString = testController.getPossiblePredecessors();
        Assert.assertFalse(testListeString.isEmpty());

        // Test iterables with a predecessor
        testIterables(false, first, true);

        // Delete all predecessors (and successors)
        testController.clear();

        // Test whether controller has any predecessors (all should be deleted by now)
        Assert.assertFalse(testController.hasPredecessors());
        Assert.assertFalse(testController.containsPredecessor(""));
        Assert.assertFalse(testController.containsPredecessor(new UUID(0, 0)));

        // Test iterables without a predecessor
        testIterables(true, first, true);

        // Test controller with predecessors added as a list
        testController.setPredecessors(testListe);
        Assert.assertTrue(testController.hasPredecessors());
        Assert.assertTrue(testController.containsPredecessor(testListe.get(0).getProjectName()));

        // Delete all predecessors (and successors)
        testController.clear();

        // Test controller with predecessors added via ID
        testController.addPredecessor(testProject.getProjectID());
        Assert.assertTrue(testController.hasPredecessors());

        // Test the MemberIterator of the predecessors
        memIt = testController.predecessors();
        Assert.assertTrue(memIt.hasNext());

        // Test the removing of a single predecessor
        testController.removePredecessor(testProject.getProjectID());
        Assert.assertFalse(testController.hasPredecessors());

    }

    /**
     * Tests functionality of successor methods.
     */
    @Test
    public void testSuccessors() {

        // Test whether Controller has successors (should be the case since we added one in the setUp)
        Assert.assertTrue(testController.hasSuccessors());
        Assert.assertTrue(testController.containsSuccessor(first.getProjectID()));

        // Test iterables with a successor
        testIterables(false, first, false);

        // Delete all successors (and predecessors)
        testController.clear();

        // Test whether controller has any successors (all should be deleted by now)
        Assert.assertFalse(testController.hasSuccessors());
        Assert.assertFalse(testController.containsSuccessor(""));

        // Test iterables without a successor
        testIterables(true, first, true);

        // Test controller with successors added as a list
        testController.setSuccessors(testListe);
        Assert.assertTrue(testController.hasSuccessors());
        Assert.assertTrue(testController.containsSuccessor(testListe.get(0).getProjectID()));

        // Delete all successors (and predecessors)
        testController.clear();

        // Test controller with successors added via ID
        testController.addSuccessor(testProject.getProjectID());
        Assert.assertTrue(testController.hasSuccessors());

        // Test the MemberIterator of the successors
        memIt = testController.successors();
        Assert.assertTrue(memIt.hasNext());

        // Test the removing of a single successor
        testController.removeSuccessor(testProject.getProjectID());
        Assert.assertFalse(testController.hasSuccessors());

    }

    /**
     * Tests the iterables of the controller containing a list of all predecessors/successors.
     * 
     * @param empty : boolean [Iterables are expected to be empty]
     * @param project : PLPInfo [Project PLP Info that is (not) expected to be within the iterables]
     * @param forPredecessor : boolean [True if predecessors are to be tested / False for successors]
     */
    private void testIterables(boolean empty, PLPInfo project, boolean forPredecessor) {

        // Retrieve current sets/collections dependent on predecessor/successor
        if (forPredecessor) {
            testSet = testController.getPredecessorIDs();
            testCollection = testController.getPredecessors();
        } else {
            testSet = (Set<String>) testController.getSuccessorIDs();
            testCollection = (Collection<PLPInfo>) testController.getSuccessors();
        }

        // Test whether they are empty/filled as expected
        if (empty) {
            Assert.assertFalse(testSet.contains(project.getProjectID()));
            Assert.assertTrue(testSet.isEmpty());
            Assert.assertFalse(testCollection.contains(project));
            Assert.assertTrue(testCollection.isEmpty());
        } else {
            Assert.assertTrue(testSet.contains(project.getProjectID()));
            Assert.assertFalse(testSet.isEmpty());
            Assert.assertTrue(testSet.size() == 1);
            Assert.assertTrue(testCollection.contains(project));
            Assert.assertFalse(testCollection.isEmpty());
            Assert.assertTrue(testCollection.size() == 1);
        }
    }

}
