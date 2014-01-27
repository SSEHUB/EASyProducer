package de.uni_hildesheim.sse.varModel.datatypes;

import java.util.HashMap;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

import de.uni_hildesheim.sse.model.cst.CSTSemanticException;
import de.uni_hildesheim.sse.model.cst.OCLFeatureCall;
import de.uni_hildesheim.sse.model.cst.Variable;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.datatypes.AnyType;
import de.uni_hildesheim.sse.model.varModel.datatypes.BooleanType;
import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
import de.uni_hildesheim.sse.model.varModel.datatypes.Container;
import de.uni_hildesheim.sse.model.varModel.datatypes.Enum;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.IntegerType;
import de.uni_hildesheim.sse.model.varModel.datatypes.MetaType;
import de.uni_hildesheim.sse.model.varModel.datatypes.Operation;
import de.uni_hildesheim.sse.model.varModel.datatypes.OrderedEnum;
import de.uni_hildesheim.sse.model.varModel.datatypes.RealType;
import de.uni_hildesheim.sse.model.varModel.datatypes.Sequence;
import de.uni_hildesheim.sse.model.varModel.datatypes.Set;
import de.uni_hildesheim.sse.model.varModel.datatypes.StringType;

/**
 * TestFile to test the OperationList.
 * @author beck
 * @author Holger Eichelberger
 * @author El-Sharkawy
 *
 */
public class OperationTest {

    private static Project project;
    private static HashMap<IDatatype, Variable> map;
    
    /**
     * setUP for all Testcases.
     */
    @BeforeClass
    public static void setUpBeforeClass() {
        project = new Project("project");        
        map = new HashMap<IDatatype, Variable>();

        putDatatypeToMap(AnyType.TYPE, "any");
        putDatatypeToMap(MetaType.TYPE, "meta");
        
        putDatatypeToMap(IntegerType.TYPE, "int");
        putDatatypeToMap(StringType.TYPE, "str");
        putDatatypeToMap(BooleanType.TYPE, "bool");
        putDatatypeToMap(RealType.TYPE, "real");  
        putDatatypeToMap(Compound.TYPE, "Compound");  
//        putDatatypeToMap(Sequence.TYPE, "seq");
//        putDatatypeToMap(Container.TYPE, "Container");
        putDatatypeToMap(Enum.TYPE, "Enum");
        putDatatypeToMap(OrderedEnum.TYPE, "OrderedEnum");
//        putDatatypeToMap(Set.TYPE, "Set");
        
        //Ensure instantiation of all Datatypes before testing.
        @SuppressWarnings("unused")
        IDatatype type = Sequence.TYPE;
        type = Container.TYPE;
        type = Set.TYPE;
    }
    
    /**
     * Method to create a hashMap with the BasisDatatypes and their variables.
     * @param type the IDatatype which should be added to the hashMap
     * @param name the name for the IDatatype e.g. "string" for StringType 
     */
    private static void putDatatypeToMap(IDatatype type, String name) {
        DecisionVariableDeclaration decl = new DecisionVariableDeclaration(name, type, project);
        Variable var = new Variable(decl);
        map.put(type, var);
    }
        
    /**
     * Test whether the right operations for the IntegerType are saved.
     */
    @Test
    public void integerOperations() {
        Operation integer1     = IntegerType.EQUALS_INTEGER_INTEGER;
        Assert.assertNotNull(integer1);
        Operation integer2     = IntegerType.EQUALS_INTEGER_REAL;
        Assert.assertNotNull(integer2);
        Operation integer3     = IntegerType.NOTEQUALS_INTEGER_INTEGER;
        Assert.assertNotNull(integer3);
        Operation integer4     = IntegerType.NOTEQUALS_INTEGER_REAL;
        Assert.assertNotNull(integer4);
        Operation integer5     = IntegerType.PLUS_INTEGER_INTEGER;
        Assert.assertNotNull(integer5);
        Operation integer6     = IntegerType.PLUS_INTEGER_REAL;
        Assert.assertNotNull(integer6);
        Operation integer7     = IntegerType.MINUS_INTEGER_INTEGER;
        Assert.assertNotNull(integer7);
        Operation integer8     = IntegerType.MINUS_INTEGER_REAL;
        Assert.assertNotNull(integer8);
        Operation integer9     = IntegerType.MULT_INTEGER_INTEGER;
        Assert.assertNotNull(integer9);
        Operation integer10    = IntegerType.MULT_INTEGER_REAL;
        Assert.assertNotNull(integer10);
        Operation integer11    = IntegerType.DIV_INTEGER_INTEGER;
        Assert.assertNotNull(integer11);
        Operation integer12    = IntegerType.DIV_INTEGER_REAL;
        Assert.assertNotNull(integer12);
        Operation integer13    = IntegerType.GREATER_INTEGER_INTEGER;
        Assert.assertNotNull(integer13);
        Operation integer14    = IntegerType.GREATER_INTEGER_REAL;
        Assert.assertNotNull(integer14);
        Operation integer15    = IntegerType.LESS_INTEGER_INTEGER;
        Assert.assertNotNull(integer15);
        Operation integer16    = IntegerType.LESS_INTEGER_REAL;
        Assert.assertNotNull(integer16);
        Operation integer17    = IntegerType.GREATER_EQUALS_INTEGER_INTEGER;
        Assert.assertNotNull(integer17);
        Operation integer18    = IntegerType.GREATER_EQUALS_INTEGER_REAL;
        Assert.assertNotNull(integer18);
        Operation integer19    = IntegerType.LESS_EQUALS_INTEGER_INTEGER;
        Assert.assertNotNull(integer19);
        Operation integer20    = IntegerType.LESS_EQUALS_INTEGER_REAL;
        Assert.assertNotNull(integer20);
        Operation integer21    = IntegerType.MIN_INTEGER_INTEGER;
        Assert.assertNotNull(integer21);
        Operation integer23    = IntegerType.MAX_INTEGER_INTEGER;
        Assert.assertNotNull(integer23);
        Operation integer25    = IntegerType.ABS_INTEGER_INTEGER;
        Assert.assertNotNull(integer25);
        Operation integer27    = IntegerType.INVERSE_INTEGER;
        Assert.assertNotNull(integer27);
        Operation integer30    = IntegerType.MOD_INTEGER_INTEGER;
        Assert.assertNotNull(integer30);
        Operation integer31    = IntegerType.MOD_INTEGER_REAL;
        Assert.assertNotNull(integer31);
    }
    
    /**
     * Test whether the right operations for the RealType are saved.
     */
    @Test
    public void realOperations() {
        Operation real1     = RealType.EQUALS_REAL_REAL;
        Assert.assertNotNull(real1);
        Operation real2     = RealType.EQUALS_REAL_INTEGER;
        Assert.assertNotNull(real2);
        Operation real3     = RealType.NOTEQUALS_REAL_REAL;
        Assert.assertNotNull(real3);
        Operation real4     = RealType.NOTEQUALS_REAL_INTEGER;
        Assert.assertNotNull(real4);
        Operation real5     = RealType.PLUS_REAL_REAL;
        Assert.assertNotNull(real5);
        Operation real6     = RealType.PLUS_REAL_INTEGER;
        Assert.assertNotNull(real6);
        Operation real7     = RealType.MINUS_REAL_REAL;
        Assert.assertNotNull(real7);
        Operation real8     = RealType.MINUS_REAL_INTEGER;
        Assert.assertNotNull(real8);
        Operation real9     = RealType.MULT_REAL_REAL;
        Assert.assertNotNull(real9);
        Operation real10    = RealType.MULT_REAL_INTEGER;
        Assert.assertNotNull(real10);
        Operation real11    = RealType.DIV_REAL_REAL;
        Assert.assertNotNull(real11);
        Operation real12    = RealType.DIV_REAL_INTEGER;
        Assert.assertNotNull(real12);
        Operation real13    = RealType.GREATER_REAL_REAL;
        Assert.assertNotNull(real13);
        Operation real14    = RealType.GREATER_REAL_INTEGER;
        Assert.assertNotNull(real14);
        Operation real15    = RealType.LESS_REAL_REAL;
        Assert.assertNotNull(real15);
        Operation real16    = RealType.LESS_REAL_INTEGER;
        Assert.assertNotNull(real16);
        Operation real17    = RealType.GREATER_EQUALS_REAL_REAL;
        Assert.assertNotNull(real17);
        Operation real18    = RealType.GREATER_EQUALS_REAL_INTEGER;
        Assert.assertNotNull(real18);
        Operation real19    = RealType.LESS_EQUALS_REAL_REAL;
        Assert.assertNotNull(real19);
        Operation real20    = RealType.LESS_EQUALS_REAL_INTEGER;
        Assert.assertNotNull(real20);
        Operation real21    = RealType.MIN_REAL_REAL;
        Assert.assertNotNull(real21);
        Operation real22    = RealType.MIN_REAL_INTEGER;
        Assert.assertNotNull(real22);
        Operation real23    = RealType.MAX_REAL_REAL;
        Assert.assertNotNull(real23);
        Operation real24    = RealType.MAX_REAL_INTEGER;
        Assert.assertNotNull(real24);
        Operation real25    = RealType.ABS_REAL_REAL;
        Assert.assertNotNull(real25);
        Operation real27    = RealType.INVERSE_REAL;
        Assert.assertNotNull(real27);
    }
    
    /**
     * Tests boolean operations.
     */
    @Test
    public void booleanOperations() {
        Operation boolean1 = BooleanType.EQUALS;
        Assert.assertNotNull(boolean1);
        Operation boolean2 = BooleanType.UNEQUALS;
        Assert.assertNotNull(boolean2);
        Operation boolean3 = BooleanType.NOT;
        Assert.assertNotNull(boolean3);
        Operation boolean4 = BooleanType.OR;
        Assert.assertNotNull(boolean4);
        Operation boolean5 = BooleanType.XOR;
        Assert.assertNotNull(boolean5);
        Operation boolean6 = BooleanType.AND;
        Assert.assertNotNull(boolean6);
        Operation boolean7 = BooleanType.IMPLIES;
        Assert.assertNotNull(boolean7);
        Operation boolean8 = BooleanType.IFF;
        Assert.assertNotNull(boolean8);
    }
    
    /**
     * Tests string operations.
     */
    @Test
    public void stringOperations() {
        Operation string1 = StringType.EQUALS;
        Assert.assertNotNull(string1);
        Operation string2 = StringType.UNEQUALS;
        Assert.assertNotNull(string2);
        Operation string3 = StringType.SIZE;
        Assert.assertNotNull(string3);
        Operation string4 = StringType.TO_INTEGER;
        Assert.assertNotNull(string4);
        Operation string5 = StringType.TO_REAL;
        Assert.assertNotNull(string5);
        Operation string6 = StringType.CONCAT;
        Assert.assertNotNull(string6);
        Operation string7 = StringType.SUBSTRING;
        Assert.assertNotNull(string7);
    }
    
    /**
     * Tests container operations.
     */
    @Test
    public void containerOperations() {
        Operation container1 = Container.APPLY;
        Assert.assertNotNull(container1);
        Operation container2 = Container.FORALL;
        Assert.assertNotNull(container2);
        Operation container3 = Container.SIZE;
        Assert.assertNotNull(container3);
        Operation container4 = Container.TYPE_OF;
        Assert.assertNotNull(container4);
        Operation container5 = Container.UNEQUALS;
        Assert.assertNotNull(container5);
    }

    /**
     * Tests a compound assignment between inherited compounds.
     */
    @Test
    public void testCompoundAssignment() {
        Operation compound1 = Compound.EQUALS;
        Assert.assertNotNull(compound1);
        Operation compound2 = Compound.NOTEQUALS;
        Assert.assertNotNull(compound2);
        Operation compound3 = Compound.TYPE_OF;
        Assert.assertNotNull(compound3);
    }
    
    /**
     * Method calls the testBasisOperation method and the testTooManyParametersInOperationMethod for all
     * available operations.
     * @throws CSTSemanticException should not Occur
     */
    @Test
    public void testAllBasisOperations() throws CSTSemanticException {
        int operationsCount = Operation.getOperationsCount();
        
        //calls the following methods for all operations
        for (int i = 0; i < operationsCount; i++) {
            IDatatype type = Operation.getOperation(i).getOperand();
            Assert.assertTrue(hasOperation(type, Operation.getOperation(i)));
            testBasisOperation(Operation.getOperation(i));
            testTooManyParametersInOperation(Operation.getOperation(i));
            testWrongParametersInOperation(Operation.getOperation(i));
        }

        //Test whether the amount of supported operations has changed
        Assert.assertEquals(155, operationsCount);
    }
    
    /**
     * Copies an operation and compares this with the origin.
     * @param operation the current operation which should be copied
     * @throws CSTSemanticException should not occur
     */
    private void testBasisOperation(Operation operation) throws CSTSemanticException {

        Variable operand = map.get(operation.getOperand());
        
        //create a new OCLFeatureCall with the same operand, operation and parameters
        if (null != operand) {
            Variable[] parameters = new Variable[operation.getParameterCount()];
            for (int j = 0; j < operation.getParameterCount(); j++) {                
                parameters[j] = map.get(operation.getParameter(j));  
            }
         
            OCLFeatureCall call = new OCLFeatureCall(operand, operation.getName(), parameters);                
                
            Assert.assertEquals(operation.getReturns(), call.inferDatatype());
        }
        
    }
    
    /**
     * Copies an Operation which a too long parameter list.
     * @param operation the current operation which should be changed
     */
    private void testTooManyParametersInOperation(Operation operation) {        
        Variable operand = map.get(operation.getOperand());
        
        if (null != operand) {
            //creates a "too long" array
            Variable[] parameters = new Variable[operation.getParameterCount() + 1];
            for (int i = 0; i < operation.getParameterCount(); i++) {
                parameters[i] = map.get(operation.getParameter(i));
            }
            
            //try to add a parameter a second time to the parameter array
            int pos = operation.getParameterCount();
            if (0 != pos) {
                parameters[pos] = map.get(operation.getParameter(pos - 1));
            } else {
                parameters[pos] = map.get(BooleanType.TYPE);
            }
            OCLFeatureCall call = new OCLFeatureCall(operand, operation.getName(), parameters);
            
            try {
                call.inferDatatype();
                Assert.fail();
            } catch (CSTSemanticException cstExc) {
                //Should occur --> everything is ok
            }
        }        
    }
    
    /**
     * Copies an Operation with a wrong parameter list.
     * @param operation the current operation which should be changed
     */
    private void testWrongParametersInOperation(Operation operation) {
        
        Variable operand = map.get(operation.getOperand());
        
        Boolean found = false;
        Operation op = Operation.getOperation(0);
        if (0 != operation.getParameterCount()) {
            //search for a operation with operationsCount == 0
            for (int i = 0; i < Operation.getOperationsCount() && !found; i++) {
                if (0 == Operation.getOperation(i).getParameterCount()) {
                    op = Operation.getOperation(i);
                    found = true;
                }
            }            
        } else {
            //search for a operation with operationsCount != 0
            for (int i = 0; i < Operation.getOperationsCount() && !found; i++) {
                if (0 != Operation.getOperation(i).getParameterCount()) {
                    op = Operation.getOperation(i);
                    found = true;
                }
            }
        }
        
        //create a new OCLFeatureCall with the same variables of the operation except the parameters
        if (null != operand && op.getParameterCount() > 0) {
            Variable[] parameters = new Variable[op.getParameterCount()];
            for (int i = 0; i < op.getParameterCount(); i++) {
                parameters[i] = map.get(op.getParameter(i));           
            }

            //copy the operation with a wrong parameter-list
            OCLFeatureCall call = new OCLFeatureCall(operand, operation.getName(), parameters);
            try {
                call.inferDatatype();                
                System.out.println(operation.getName());
                System.out.println(operation.getOperand().getName());
                System.out.println(operation.getParameterCount());
                System.out.println(call.getParameterCount());                
                Assert.fail();
            } catch (CSTSemanticException cstExc) {
                //Should occur --> everything is ok
            }
        }        
    }
    
    
    /**
     * Copies a compoundOperation and compares the return-types.
     * @throws CSTSemanticException should not occur
     */
    @Test
    public void testCompoundOperation() throws CSTSemanticException {      
        
        for (int i = 0; i < Operation.getOperationsCount(); i++) {
            
            Operation operation = Operation.getOperation(i);
            
            Variable operand = map.get(operation.getOperand());
            Variable[] parameters = new Variable[operation.getParameterCount()];
            
            if (null != operand) {
                if (Compound.TYPE == operand.inferDatatype()) {
                    
                    for (int j = 0; j < operation.getParameterCount(); j++) {                
                        parameters[j] = map.get(operation.getParameter(j));  
                    }
                    OCLFeatureCall call = new OCLFeatureCall(operand, operation.getName(), parameters);
                    
                    Assert.assertEquals(operation.getReturns(), call.inferDatatype());
                }
            }            
        }
        
    }
    
    
    /**
     * Returns whether a datatype has a given operation.
     * @param datatype the datatype to check for
     * @param operation the operation to check for
     * @return <code>true</code> if <code>operation</code> is defined on 
     *   <code>datatype</code>, <code>false</code> else
     */
    private boolean hasOperation(IDatatype datatype, Operation operation) {
        boolean found = false;
        for (int o = 0; !found && o < datatype.getOperationCount(); o++) {
            found = datatype.getOperation(o).equals(operation);
        }
        return found;
    }

}
