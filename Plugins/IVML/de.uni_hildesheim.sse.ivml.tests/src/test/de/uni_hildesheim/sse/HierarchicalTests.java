package test.de.uni_hildesheim.sse;

import java.io.File;
import java.util.List;

import org.junit.Assert;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import de.uni_hildesheim.sse.ModelUtility;
import de.uni_hildesheim.sse.model.management.VarModel;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.reasoning.core.importResolver.ReasoningImportResolver;
import de.uni_hildesheim.sse.utils.modelManagement.ModelInfo;
import de.uni_hildesheim.sse.utils.modelManagement.ModelLocations;
import de.uni_hildesheim.sse.utils.modelManagement.ModelLocations.Location;
import de.uni_hildesheim.sse.utils.modelManagement.ModelManagementException;

/**
 * Some tests for the hierarchical model loading capabilities.
 * 
 * @author Holger Eichelberger
 */
public class HierarchicalTests extends AbstractTest {

    /**
     * Represents the directory containing the tests.
     */
    private static final File DIR = new File(TESTDATA_DIR, "hierarchical");
    
    /**
     * Starts up the test overriding the parent method.
     */
    @BeforeClass
    public static void startUp() {
        // "override" parent startUp
        ReasoningImportResolver.registerAsTopResolver();
        resourceInitialization();
    }

    /**
     * Tears down the test overriding the parent method.
     */
    @AfterClass
    public static void shutDown() {
        // "override" parent shutDown
    }

    /**
     * A basic hierarchical test.
     */
    @Test
    public void testCase1() {
        ModelLocations<Project> knownLocations = VarModel.INSTANCE.locations();
        for (int l = 0; l < knownLocations.getLocationCount(); l++) {
            System.out.println(knownLocations.getLocation(l));
        }
        
        File base = new File(DIR, "case1");
        File pl0 = new File(base, "pl0/EASy");
        File pl1 = new File(base, "pl1/EASy");
        try {
            Location pl0Loc = VarModel.INSTANCE.locations().addLocation(pl0, OBSERVER);
            Location pl1Loc = VarModel.INSTANCE.locations().addLocation(pl1, OBSERVER);
            // add Parent
            pl1Loc.addDependentLocation(pl0Loc);
            
            VarModel.INSTANCE.loaders().registerLoader(ModelUtility.INSTANCE, OBSERVER);
            
            List<ModelInfo<Project>> infos = VarModel.INSTANCE.availableModels().getModelInfo("pl1");
            Assert.assertNotNull(infos);
            Assert.assertTrue(1 == infos.size());
            Project project = VarModel.INSTANCE.load(infos.get(0));
            Assert.assertNotNull(project);
            
            VarModel.INSTANCE.locations().removeLocation(pl1Loc, OBSERVER);
            VarModel.INSTANCE.locations().removeLocation(pl0Loc, OBSERVER);
            VarModel.INSTANCE.loaders().unregisterLoader(ModelUtility.INSTANCE, OBSERVER);
        } catch (ModelManagementException e) {
            Assert.fail("unexpected exception " + e);
        }
    }
    
}
