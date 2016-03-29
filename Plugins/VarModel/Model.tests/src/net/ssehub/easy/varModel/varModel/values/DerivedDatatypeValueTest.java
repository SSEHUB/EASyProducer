package net.ssehub.easy.varModel.varModel.values;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.cst.ConstantValue;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;
import net.ssehub.easy.varModel.cst.Variable;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.DerivedDatatype;
import net.ssehub.easy.varModel.model.datatypes.IntegerType;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;

/**
 * This class test the correct instantiation of Values for the {@link DerivedDatype}s.
 * @author El-Sharkawy
 *
 */
public class DerivedDatatypeValueTest {

    private Project project;
    
    /**
     * The creation of an empty project, needed for all tests.
     */
    @Before
    public void setUp() {
        project = new Project("project");
    }

    /**
     * Test the correct instantiation of a Value for a {@link DerivedDatype} with an {@link IntegerType} as
     * <code>BasisDatatype</code>.
     * @throws ValueDoesNotMatchTypeException Must not occur, otherwise there is an error in the whole model
     * @throws CSTSemanticException Must not occur, otherwise there is an error in the whole model
     */
    @Test
    public void testBasisDatatypeValueCreation() throws ValueDoesNotMatchTypeException, CSTSemanticException {
        //Create DerivedDatatype
        DerivedDatatype bitrate = new DerivedDatatype("Bitrate", IntegerType.TYPE, project);
        Variable var = new Variable(bitrate.getTypeDeclaration());
        Value value = ValueFactory.createValue(IntegerType.TYPE, "128");
        ConstantValue consValue = new ConstantValue(value);
        OCLFeatureCall constraint = new OCLFeatureCall(var, IntegerType.GREATER_INTEGER_INTEGER.getName(), consValue);
        Constraint cons = new Constraint(constraint, null);
        Constraint[] constraints = {cons};
        bitrate.setConstraints(constraints);
        
        //Create a value
        Value videoValue = ValueFactory.createValue(bitrate, "5");
        Assert.assertNotNull(videoValue);
    }
   
    /**
     * Test the correct instantiation of a Value for a {@link DerivedDatype} with an {@link Compound} as
     * <code>BasisDatatype</code>.
     * @throws ValueDoesNotMatchTypeException Must not occur, otherwise there is an error in the whole model
     * @throws CSTSemanticException Must not occur, otherwise there is an error in the whole model
     */
    @Test
    public void testCompoundValueCreation() throws ValueDoesNotMatchTypeException, CSTSemanticException {
        //Create DerivedDatatype
        Compound compound = new Compound("cmp", project);
        DecisionVariableDeclaration intA = new DecisionVariableDeclaration("intA", IntegerType.TYPE, compound);
        compound.add(intA);
        DerivedDatatype noIdeaType = new DerivedDatatype("NoIdeaType", compound, project);
        Variable var = new Variable(noIdeaType.getTypeDeclaration());
        
        Value value = ValueFactory.createValue(compound, "intA", "5");
        ConstantValue consValue = new ConstantValue(value);
        OCLFeatureCall constraint = new OCLFeatureCall(var, Compound.NOTEQUALS.getName(), consValue);
        Constraint cons = new Constraint(constraint, null);
        Constraint[] constraints = {cons};
        noIdeaType.setConstraints(constraints);
        
        //Create a value
        Value videoValue = ValueFactory.createValue(noIdeaType, "intA", "6");
        Assert.assertNotNull(videoValue);
    }
}
