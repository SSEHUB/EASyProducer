package net.ssehub.easy.varModel.cstEvaluation;

import java.util.Arrays;

import org.junit.Assert;

import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.cst.ConstantValue;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;
import net.ssehub.easy.varModel.cstEvaluation.EvaluationVisitor;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.Sequence;
import net.ssehub.easy.varModel.model.datatypes.Set;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;

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
     *     One of {@link net.ssehub.easy.varModel.model.datatypes.OclKeyWords}.
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
     * Creates an unary constraint for {@link net.ssehub.easy.varModel.model.datatypes.Container} types.
     * This constraint will have the following form:
     * <tt>value.operation()</tt>
     * @param values The constant container value
     * @param operation A unary container operation.
     *     One of {@link net.ssehub.easy.varModel.model.datatypes.OclKeyWords}.
     * @param contType A {@link net.ssehub.easy.varModel.model.datatypes.Container}
     *     of {@link net.ssehub.easy.varModel.model.datatypes.IntegerType}
     *     or {@link net.ssehub.easy.varModel.model.datatypes.RealType}
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
