package net.ssehub.easy.varModel.cst;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.IvmlException;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.BooleanType;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.IntegerType;
import net.ssehub.easy.varModel.model.datatypes.Sequence;
import net.ssehub.easy.varModel.model.datatypes.Set;
import net.ssehub.easy.varModel.model.values.ValueFactory;

/**
 * This class tests the correct behavior of the {@link ContainerOperationCall} class.
 * 
 * @author Holger Eichelberger
 * @see ContainerOperationCall
 */
public class ContainerOperationCallTest {

    private Project project;
    
    /**
     * Creates a project, which is needed as toplevel element.
     */
    @Before
    public void setUp() {
        project = new Project("project");
    }
    
    // TODO HE: other branches in ContainerOperationCall missing! 
    
    /**
     * Tests an index-based container access. In IVML:
     * <code>
     *   setOf(Integer) set;
     *   set->forall(t|t>10);
     * </code>
     * @throws IvmlException Should not occur, as the nested constraint is semantically correct.
     */
    @Test
    public void testIndexBasedContainer() throws IvmlException {
        IDatatype setType = new Set("setOf(Integer)", IntegerType.TYPE, project);
        DecisionVariableDeclaration sVar = new DecisionVariableDeclaration("set", setType, project);
        Variable sVarCst = new Variable(sVar);
        ConstantValue constCst10 = new ConstantValue(ValueFactory.createValue(IntegerType.TYPE, "10"));
        DecisionVariableDeclaration tVar = new DecisionVariableDeclaration("t", IntegerType.TYPE, project);
        Variable tVarCst = new Variable(tVar);
        OCLFeatureCall greater = new OCLFeatureCall(tVarCst, ">", constCst10);
        ContainerOperationCall opCall = new ContainerOperationCall(sVarCst, "forAll", greater, tVar);
        IDatatype resultType = opCall.inferDatatype();
        Assert.assertTrue(resultType.isAssignableFrom(BooleanType.TYPE));
    }

    /**
     * Tests an index-based container access. In IVML:
     * <code>
     *   setOf(Integer) set;
     *   set->apply(t,r|max(t,r))
     * </code>
     * @throws IvmlException Should not occur, as the nested constraint is semantically correct.
     */
    @Test
    public void testContainerApply() throws IvmlException {
        IDatatype setType = new Sequence("sequence(Integer)", IntegerType.TYPE, project);
        DecisionVariableDeclaration sVar = new DecisionVariableDeclaration("set", setType, project);
        Variable sVarCst = new Variable(sVar);
        ConstantValue constCst0 = new ConstantValue(ValueFactory.createValue(IntegerType.TYPE, "0"));
        DecisionVariableDeclaration tVar = new DecisionVariableDeclaration("t", IntegerType.TYPE, project);
        Variable tVarVar = new Variable(tVar);
        DecisionVariableDeclaration rVar = new DecisionVariableDeclaration("r", IntegerType.TYPE, project);
        rVar.setValue(constCst0);
        Variable rVarVar = new Variable(rVar);
        OCLFeatureCall lambda = new OCLFeatureCall(tVarVar, "max", rVarVar); 
        // we just assume that the last declarator collects the results and will be returned
        ContainerOperationCall featureCall = new ContainerOperationCall(sVarCst, "apply", lambda, tVar, rVar);
        IDatatype resultType = featureCall.inferDatatype();
        Assert.assertTrue(resultType.isAssignableFrom(constCst0.inferDatatype()));
    }    
    
}
