package de.uni_hildesheim.sse.persistency.xml;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import net.ssehub.easy.basics.modelManagement.IModel;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.ContainableModelElement;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.ModelQuery;
import net.ssehub.easy.varModel.model.ModelQueryException;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.IntegerType;

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
        try {
            List<IModel> models = XmlIo.read(WriteTest.FILE, true);
            Project p1 = (Project) models.get(0);
            DecisionVariableDeclaration decVar = (DecisionVariableDeclaration) 
                ModelQuery.findElementByName(p1, "intVar", DecisionVariableDeclaration.class);
            boolean ok = true;
            if (null == decVar) {
                Assert.fail("intVar not found");
                ok = false;
            } else {
                if (IntegerType.TYPE != decVar.getType()) {
                    Assert.fail("type identity problem");
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
                        Assert.fail("operation identity problem");
                    } else {
                        Assert.fail("constraint is not a feature call");
                        ok = false;
                    }
                } else {
                    Assert.fail("constraint not found");
                    ok = false;
                }
                Assert.assertEquals(true, ok);
            }
        } catch (FileNotFoundException e) {
            Assert.fail(e.getMessage());
        } catch (ModelQueryException e) {
            Assert.fail(e.getMessage());
        } catch (IOException e) {
            Assert.fail(e.getMessage());
        }
    }
}