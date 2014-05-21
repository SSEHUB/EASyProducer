package de.uni_hildesheim.sse.persistency.xmlTests;

import java.io.FileInputStream;

import de.uni_hildesheim.sse.model.cst.ConstraintSyntaxTree;
import de.uni_hildesheim.sse.model.cst.OCLFeatureCall;
import de.uni_hildesheim.sse.model.varModel.Constraint;
import de.uni_hildesheim.sse.model.varModel.ContainableModelElement;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.ModelQuery;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.datatypes.IntegerType;
import de.uni_hildesheim.sse.persistency.xml.XmlIo;

/**
 * A simple model read test. Please execute {@link WriteTest} before. This test must
 * be executed in a different JVM than the {@link WriteTest} in order to validate
 * that the singleton instances are properly set.
 * 
 * @author Holger Eichelberger
 */
public class ReadTest {

    /**
     * Executes the read test.
     * 
     * @param args ignored
     * @throws Exception in any case of error
     */
    //checkstyle: stop exception type check 
    public static void main(String[] args) throws Exception {
        FileInputStream in = new FileInputStream(WriteTest.FILE);
        Project p1 = XmlIo.read(in);
        DecisionVariableDeclaration decVar = (DecisionVariableDeclaration) 
            ModelQuery.findElementByName(p1, "intVar", DecisionVariableDeclaration.class);
        boolean ok = true;
        if (null == decVar) {
            System.err.println("intVar not found");
            ok = false;
        } else {
            if (IntegerType.TYPE != decVar.getType()) {
                System.err.println("type identity problem");
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
                    System.err.println("operation identity problem");
                } else {
                    System.err.println("constraint is not a feature call");
                    ok = false;
                }
            } else {
                System.err.println("constraint not found");
                ok = false;
            }
            if (ok) {
                System.out.println("ok!");
            }
        }
    }
    //checkstyle: resume exception type check 
}