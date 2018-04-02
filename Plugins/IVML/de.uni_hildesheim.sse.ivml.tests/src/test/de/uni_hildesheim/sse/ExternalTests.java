package test.de.uni_hildesheim.sse;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.junit.Assert;
import org.junit.Test;

import de.uni_hildesheim.sse.ModelUtility;
import de.uni_hildesheim.sse.translation.ErrorCodes;
import net.ssehub.easy.basics.modelManagement.ModelInfo;
import net.ssehub.easy.dslCore.TranslationResult;
import net.ssehub.easy.varModel.confModel.AssignmentState;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.cstEvaluation.EvaluationVisitor;
import net.ssehub.easy.varModel.management.VarModel;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.ContainableModelElement;
import net.ssehub.easy.varModel.model.Project;

/**
 * A test class for blackbox testing parser and type resolution of 
 * IVML files contributed from "external" sources. 
 * 
 * @author Holger Eichelberger
 */
public class ExternalTests extends AbstractTest {

    /**
     * Represents the directory containing the tests.
     */
    private static final File DIR = new File(getTestDataDir(), "external");

    /**
     * Creates a file in {@link #DIR}.
     * 
     * @param name
     *            the name of the file (excluding ".ivml")
     * @return the file
     */
    private static final File createFile(String name) {
        return new File(DIR, name + ".ivml");
    }

    /**
     * Tests the EasY file with 10000 variables.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void test10000() throws IOException {
        assertEqual(createFile("10000Variables"), null, null);
    }

    /**
     * ScaleLog test case leading to stackoverflow.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void scaleLogGoodsIn() throws IOException {
        assertEqual(createFile("GoodsIn_Instances"), null, null);
    }

    /**
     * Constraint set test case. Simplified version contributed by QualiMaster.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testConstraintSet() throws IOException {
        assertEqual(createFile("constraintSet"), null, null);
    }

    /**
     * Constraint set test case. Simplified version contributed by QualiMaster (R. Sizonenko).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testConstraintSet2() throws IOException {
        assertEqual(createFile("constraintSet2"), null, null);
    }
    
    /**
     * Constraint set test case. Simplified version contributed by QualiMaster (R. Sizonenko).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testConstraintSet3() throws IOException {
        assertEqual(createFile("constraintSet3"), null, null);
    }

    /**
     * A basic test for cyclic imports.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testLoop() throws IOException {
        assertEqual(createFile("loop"), null, null);
    }
    
    /**
     * Topology test case. Use of ref and refBy in compounds and sequences.
     * Simplified version contributed by QualiMaster.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testReferences() throws IOException {
        assertEqual(createFile("references"), null, null);
    }
    
    /**
     * refBy over operation test case. 
     * Simplified version contributed by K. Schmid.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testReferences2() throws IOException {
        assertEqual(createFile("references2"), null, null);
    }

    /**
     * Failing Topology test case as variable is not dereferenced (omitting refBy).
     * Simplified version contributed by QualiMaster.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testReferencesFail() throws IOException {
        assertEqual(createFile("referencesFail"), null, null, CSTSemanticException.TYPE_MISMATCH);
    }

    /**
     * Self interface import from wrong model contributed by Sebastian Bender.
     * The base model (v0) defines the interface, the second model (v1) imports 
     * the (same) model by name without version and accidentally the v0 is taken
     * instead of v2. 
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testInterfaceImportFail() throws IOException {
        assertEqual(createFile("InterfaceImportFail_1"), "InterfaceImportFail", "1", ErrorCodes.IMPORT);
    }

    /**
     * Simple alarm system case (sets, using self).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testAlarm() throws IOException {
        assertEqual(createFile("alarm"), null, null);
    }

    /**
     * Simple alarm system case (sets, using self).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testAlarmSelf() throws IOException {
        assertEqual(createFile("alarmSelf"), null, null);
    }

    /**
     * Simple alarm system case (sequences).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testAlarmSeq() throws IOException {
        assertEqual(createFile("alarmSeq"), null, null);
    }

    /**
     * Simple alarm system case (sequences, using self).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testAlarmSeqSelf() throws IOException {
        assertEqual(createFile("alarmSeqSelf"), null, null);
    }
    
    /**
     * Assign abstract case (contributed by R. Sizonenko and S. El-Sharkawy).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testAssignAbstract() throws IOException {
        File file = createFile("assignAbstract");
        assertEqual(file, null, null);
        URI uri = URI.createFileURI(file.getAbsolutePath());
        TranslationResult<Project> result = ModelUtility.INSTANCE.parse(uri);
        for (int r = 0; r < result.getResultCount(); r++) {
            new Configuration(result.getResult(r));
        }
    }

    /**
     * Simple alarm system case (sequences, using self).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testNestedAttribute() throws IOException {
        assertEqual(createFile("nestedAttribute"), null, null);

        // obtain the model
        List<ModelInfo<Project>> infos = VarModel.INSTANCE.availableModels().getModelInfo("nestedAttribute");
        Assert.assertTrue(null != infos && 1 == infos.size());
        Project project = infos.get(0).getResolved();
        Assert.assertNotNull(project);

        // resolve the constraints...
        Configuration config = new Configuration(project);
        EvaluationVisitor evaluator = new EvaluationVisitor(config, AssignmentState.ASSIGNED, false, null);
        for (int c = 0; c < project.getElementCount(); c++) {
            ContainableModelElement elt = project.getElement(c);
            if (elt instanceof Constraint) {
                Constraint constraint = (Constraint) elt;
                ConstraintSyntaxTree cst = constraint.getConsSyntax();
                if (null != cst) {
                    evaluator.visit(cst);
                    Assert.assertTrue(evaluator.constraintFulfilled());
                    evaluator.clearResult();
                }
            }
        }
    }

    /**
     * Tests a signature problem with <code>isUnique</code> (by M. Keunecke).
     * 
     * @throws IOException shall not occur
     */
    @Test
    public void testUnique() throws IOException {
        assertEqual(createFile("isUnique"), null, null);
    }

    /**
     * Tests a signature problem with <code>isUnique</code> (by M. Keunecke).
     * 
     * @throws IOException shall not occur
     */
    @Test
    public void testUnique2() throws IOException {
        assertEqual(createFile("isUnique2"), null, null);
    }

    /**
     * Tests a signature problem with <code>isUnique</code> (by M. Keunecke).
     * 
     * @throws IOException shall not occur
     */
    @Test
    public void testUnique3() throws IOException {
        assertEqual(createFile("isUnique3"), null, null);
    }

    /**
     * Tests a problem with compound initializers and references.
     * 
     * @throws IOException shall not occur
     */
    @Test
    public void testCompoundRefAssignTest2() throws IOException {
        assertEqual(createFile("CompoundRefAssignTest2"), null, null);
    }

}
