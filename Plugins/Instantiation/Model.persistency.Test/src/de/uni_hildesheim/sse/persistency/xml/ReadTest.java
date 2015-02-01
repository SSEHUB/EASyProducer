package de.uni_hildesheim.sse.persistency.xml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import de.uni_hildesheim.sse.model.cst.ConstraintSyntaxTree;
import de.uni_hildesheim.sse.model.cst.OCLFeatureCall;
import de.uni_hildesheim.sse.model.varModel.Constraint;
import de.uni_hildesheim.sse.model.varModel.ContainableModelElement;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.ModelQuery;
import de.uni_hildesheim.sse.model.varModel.ModelQueryException;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.datatypes.IntegerType;
import de.uni_hildesheim.sse.utils.modelManagement.IModel;

/**
 * A simple model read test. Please execute {@link WriteTest} before. This test must
 * be executed in a different JVM than the {@link WriteTest} in order to validate
 * that the singleton instances are properly set.
 * 
 * @author Holger Eichelberger
 */
// TODO: Does not work! Please fix! 
public class ReadTest extends AbstractTest {

    /**
     * Executes the read test.
     */
    @Test
    public void testRead() {
        FileInputStream in;
        try {
            in = new FileInputStream(WriteTest.FILE);
            List<IModel> models = XmlIo.read(in);
            Project p1 = (Project) models.get(0);
            DecisionVariableDeclaration decVar = (DecisionVariableDeclaration) 
                ModelQuery.findElementByName(p1, "intVar", DecisionVariableDeclaration.class);
            boolean ok = true;
            if (null == decVar) {
                logger.error("intVar not found");
                ok = false;
            } else {
                if (IntegerType.TYPE != decVar.getType()) {
                    logger.error("type identity problem");
                    ok = false;
                }
            }
            Constraint firstConstraint = null;
            for (int c = 0; c < p1.getElementCount(); c++) {
                ContainableModelElement elt = p1.getElement(c);
                if (elt instanceof Constraint && null == firstConstraint) {
                    firstConstraint = (Constraint) elt;
                }
            }
            if (null != firstConstraint) {
                ConstraintSyntaxTree cst = firstConstraint.getConsSyntax();
                if (cst instanceof OCLFeatureCall) {
                    OCLFeatureCall call = (OCLFeatureCall) cst;
                    if (WriteTest.FIRST_CONSTRAINT_OPERATION != call.getResolvedOperation()) {
                        logger.error("operation identity problem");
                    } else {
                        logger.error("constraint is not a feature call");
                        ok = false;
                    }
                } else {
                    logger.error("constraint not found");
                    ok = false;
                }
                Assert.assertEquals(true, ok);
            }
        } catch (FileNotFoundException e) {
            logger.exception(e);
        } catch (ModelQueryException e) {
            logger.exception(e);
        }
    }
}