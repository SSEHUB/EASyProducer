package de.uni_hildesheim.sse.persistency.xmlTests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import de.uni_hildesheim.sse.model.cst.ConstantValue;
import de.uni_hildesheim.sse.model.cst.ConstraintSyntaxTree;
import de.uni_hildesheim.sse.model.cst.OCLFeatureCall;
import de.uni_hildesheim.sse.model.cst.Variable;
import de.uni_hildesheim.sse.model.varModel.Constraint;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.OperationDefinition;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.datatypes.BooleanType;
import de.uni_hildesheim.sse.model.varModel.datatypes.CustomOperation;
import de.uni_hildesheim.sse.model.varModel.datatypes.IntegerType;
import de.uni_hildesheim.sse.model.varModel.datatypes.Operation;
import de.uni_hildesheim.sse.model.varModel.datatypes.RealType;
import de.uni_hildesheim.sse.model.varModel.datatypes.StringType;
import de.uni_hildesheim.sse.model.varModel.values.ValueFactory;
import de.uni_hildesheim.sse.persistency.StringProvider;
import de.uni_hildesheim.sse.persistency.xml.XmlIo;
import de.uni_hildesheim.sse.utils.modelManagement.Version;

/**
 * A simple model write+read test. 
 * 
 * @author Holger Eichelberger
 */
public class WriteTest {
    
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
     * 
     * @param args ignored
     * @throws Exception in any case of exception
     */
    //checkstyle: stop exception type check 
    public static void main(String[] args) throws Exception {
        Project p = new Project("myProject");
        p.setVersion(new Version(1, 2));
        DecisionVariableDeclaration intVar = new DecisionVariableDeclaration("intVar", IntegerType.TYPE, p); 
        p.add(intVar);
        p.add(new DecisionVariableDeclaration("boolVar", BooleanType.TYPE, p));
        p.add(new DecisionVariableDeclaration("realVar", RealType.TYPE, p));
        p.add(new DecisionVariableDeclaration("stringVar", StringType.TYPE, p));
        // must be the first constraint for subsequent tests
        ConstraintSyntaxTree cst = new OCLFeatureCall(
            new Variable(intVar), 
            FIRST_CONSTRAINT_OPERATION.getName(), 
            new ConstantValue(ValueFactory.createValue(IntegerType.TYPE, 1)));
        cst.inferDatatype();
        p.add(new Constraint(cst, p));
        
        CustomOperation cOp = new CustomOperation(
            BooleanType.TYPE, 
            "myOp", 
            p.getType(), 
            new ConstantValue(ValueFactory.createValue(BooleanType.TYPE, "true")), null);
        OperationDefinition opDef = new OperationDefinition(p);
        opDef.setOperation(cOp);
        p.add(opDef);
        
        FileOutputStream out = new FileOutputStream(FILE);
        XmlIo.write(p, out);
        out.close();
        
        FileInputStream in = new FileInputStream(FILE);
        Project p1 = XmlIo.read(in);
        String pAsString = StringProvider.toIvmlString(p);
        String p1AsString = StringProvider.toIvmlString(p1);
        if (!pAsString.equals(p1AsString)) {
            System.err.println("P:");
            System.err.println(pAsString);
            System.err.println();
            System.err.println("P(XML):");
            System.err.println(p1AsString);
            System.err.println();
        } else {
            System.out.println("ok!");
        }
    }
    //checkstyle: stop exception type check 
}
