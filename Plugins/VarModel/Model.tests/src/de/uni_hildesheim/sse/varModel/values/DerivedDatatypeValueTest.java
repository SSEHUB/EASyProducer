package de.uni_hildesheim.sse.varModel.values;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import de.uni_hildesheim.sse.model.cst.CSTSemanticException;
import de.uni_hildesheim.sse.model.cst.ConstantValue;
import de.uni_hildesheim.sse.model.cst.OCLFeatureCall;
import de.uni_hildesheim.sse.model.cst.Variable;
import de.uni_hildesheim.sse.model.varModel.Constraint;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
import de.uni_hildesheim.sse.model.varModel.datatypes.DerivedDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.IntegerType;
import de.uni_hildesheim.sse.model.varModel.values.Value;
import de.uni_hildesheim.sse.model.varModel.values.ValueDoesNotMatchTypeException;
import de.uni_hildesheim.sse.model.varModel.values.ValueFactory;

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
