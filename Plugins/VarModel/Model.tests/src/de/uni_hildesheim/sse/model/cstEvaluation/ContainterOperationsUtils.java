package de.uni_hildesheim.sse.model.cstEvaluation;

import java.util.Arrays;

import org.junit.Assert;

import de.uni_hildesheim.sse.model.cst.CSTSemanticException;
import de.uni_hildesheim.sse.model.cst.ConstantValue;
import de.uni_hildesheim.sse.model.cst.ConstraintSyntaxTree;
import de.uni_hildesheim.sse.model.cst.OCLFeatureCall;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.Sequence;
import de.uni_hildesheim.sse.model.varModel.datatypes.Set;
import de.uni_hildesheim.sse.model.varModel.values.Value;
import de.uni_hildesheim.sse.model.varModel.values.ValueDoesNotMatchTypeException;
import de.uni_hildesheim.sse.model.varModel.values.ValueFactory;

/**
 * Utility functions for {@link SequenceOperationsTest} and {@link SetOperationsTest}.
 * @author El-Sharkawy
 *
 */
public class ContainterOperationsUtils {

    /**
     * Creates a constraint and tests whether the {@link EvaluationVisitor} will evaluate it to a correct value.
     * @param value The constant value
     * @param operation A unary number operation.
     *     One of {@link de.uni_hildesheim.sse.model.varModel.datatypes.OclKeyWords}.
     * @param expectedResult For testing the expected result of the operation.
     * @param numberType The expected {@link IDatatype} of created results.
     * @param asSet If <tt>true</tt> as Set is created, a sequence otherwise.
     */
    static void assertUnaryConstraint(Number[] value, String operation, Object expectedResult,
        IDatatype numberType, boolean asSet) {
        
        IDatatype contType = asSet ? new Set("set", numberType, null) : new Sequence("seq", numberType, null);
        
        EvaluationVisitor evalutator = new EvaluationVisitor();
        ConstraintSyntaxTree cst = createUnaryConstraint(value, operation, contType);
        cst.accept(evalutator);
        Value result = evalutator.getResult();
        Assert.assertNotNull(result);
        Assert.assertSame(result.getType(), numberType);
        String errorMsg = "Error in " + operation + "-Operation. Expected: " 
            + operation + "(" + Arrays.toString(value) + ") = " + expectedResult + ", but was : " + result.getValue();
        Assert.assertEquals(errorMsg, expectedResult, result.getValue());     
    }
    
    /**
     * Creates an unary constraint for {@link de.uni_hildesheim.sse.model.varModel.datatypes.Container} types.
     * This constraint will have the following form:
     * <tt>value.operation()</tt>
     * @param values The constant container value
     * @param operation A unary container operation.
     *     One of {@link de.uni_hildesheim.sse.model.varModel.datatypes.OclKeyWords}.
     * @param contType A {@link de.uni_hildesheim.sse.model.varModel.datatypes.Container}
     *     of {@link de.uni_hildesheim.sse.model.varModel.datatypes.IntegerType}
     *     or {@link de.uni_hildesheim.sse.model.varModel.datatypes.RealType}
     * @return A constraint in form of <tt>value.operation()</tt>.
     */
    static ConstraintSyntaxTree createUnaryConstraint(Number[] values, String operation, IDatatype contType) {
        OCLFeatureCall cst = null;
        try {
            Value vValue1 = ValueFactory.createValue(contType, (Object[]) values);
            
            ConstantValue cValue1 = new ConstantValue(vValue1);
            cst = new OCLFeatureCall(cValue1, operation);
            cst.inferDatatype();
        } catch (ValueDoesNotMatchTypeException e) {
            Assert.fail(e.getMessage());
        } catch (CSTSemanticException e) {
            Assert.fail(e.getMessage());
        }
        
        return cst;
    }
}
