package de.uni_hildesheim.sse.persistency.xml;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import net.ssehub.easy.basics.modelManagement.IModel;
import net.ssehub.easy.basics.modelManagement.Version;
import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.cst.ConstantValue;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;
import net.ssehub.easy.varModel.cst.Variable;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.OperationDefinition;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.BooleanType;
import net.ssehub.easy.varModel.model.datatypes.CustomOperation;
import net.ssehub.easy.varModel.model.datatypes.IntegerType;
import net.ssehub.easy.varModel.model.datatypes.Operation;
import net.ssehub.easy.varModel.model.datatypes.RealType;
import net.ssehub.easy.varModel.model.datatypes.StringType;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;
import net.ssehub.easy.varModel.persistency.StringProvider;

/**
 * A simple model write+read test.
 * 
 * @author Holger Eichelberger
 */
public class WriteTest extends AbstractTest {

    /**
     * The file to be read/written during the test.
     */
    public static final File FILE = new File("test.xml");

    /**
     * Defines the operation of the first constraint (for further testing).
     */
    public static final Operation FIRST_CONSTRAINT_OPERATION = IntegerType.LESS_EQUALS_INTEGER_INTEGER;
    
    /**
     * Executes the test.
     */
    @Test
    public void testWrite() {
        Project p = new Project("myProject");
        p.setVersion(new Version(1, 2));
        DecisionVariableDeclaration intVar = new DecisionVariableDeclaration("intVar", IntegerType.TYPE, p);
        p.add(intVar);
        p.add(new DecisionVariableDeclaration("boolVar", BooleanType.TYPE, p));
        p.add(new DecisionVariableDeclaration("realVar", RealType.TYPE, p));
        p.add(new DecisionVariableDeclaration("stringVar", StringType.TYPE, p));
        // must be the first constraint for subsequent tests
        ConstraintSyntaxTree cst;
        try {
            cst = new OCLFeatureCall(new Variable(intVar), FIRST_CONSTRAINT_OPERATION.getName(), new ConstantValue(
                    ValueFactory.createValue(IntegerType.TYPE, 1)));
            cst.inferDatatype();
            p.add(new Constraint(cst, p));
            CustomOperation cOp = new CustomOperation(BooleanType.TYPE, "myOp", p.getType(), new ConstantValue(
                    ValueFactory.createValue(BooleanType.TYPE, "true")), null);
            OperationDefinition opDef = new OperationDefinition(p);
            opDef.setOperation(cOp);
            p.add(opDef);
            List<IModel> modelList = new ArrayList<IModel>();
            modelList.add(p);
            XmlIo.write(modelList, FILE, true);
            List<IModel> loadedModelList = XmlIo.read(FILE, true);
            Project p1 = (Project) loadedModelList.get(0);
            String pAsString = StringProvider.toIvmlString(p);
            String p1AsString = StringProvider.toIvmlString(p1);
            Assert.assertEquals(pAsString, p1AsString);
        } catch (ValueDoesNotMatchTypeException e) {
            Assert.fail(e.getMessage());
        } catch (CSTSemanticException e) {
            Assert.fail(e.getMessage());
        } catch (IOException e) {
            Assert.fail(e.getMessage());
        }
    }
}
