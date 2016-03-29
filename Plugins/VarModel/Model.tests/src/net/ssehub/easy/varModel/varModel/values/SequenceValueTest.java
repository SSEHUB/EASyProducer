package net.ssehub.easy.varModel.varModel.values;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.Container;
import net.ssehub.easy.varModel.model.datatypes.IntegerType;
import net.ssehub.easy.varModel.model.datatypes.Sequence;
import net.ssehub.easy.varModel.model.values.ContainerValue;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;

/**
 * Test case for SequenceValue & also CompoundValue.
 * @author Saripalli
 *
 */
public class SequenceValueTest { 

    private Project project;
    private Compound gassenTyp;
    private Compound hochRegal;
    private Container seq;
    
    /**
     * Creates a project, which is needed as toplevel element.
     */
    @Before
    public void setUp() {
        project = new Project("project");
        gassenTyp = new Compound("gassenTyp", project);
        
        //Add maxX and maxY of type integers to the compound gassenTyp
        gassenTyp.add(new DecisionVariableDeclaration("maxX", IntegerType.TYPE, gassenTyp));
        gassenTyp.add(new DecisionVariableDeclaration("maxY", IntegerType.TYPE, gassenTyp));
    
        
        //Defining another compound in which a sequence of gassenTyp is added
        hochRegal = new Compound("hochRegal", project);
        seq = new Sequence("seq", gassenTyp, hochRegal);
        DecisionVariableDeclaration seqDec = new DecisionVariableDeclaration("seq_var", seq, hochRegal);
        hochRegal.add(seqDec);
    }
    
    
    /**
     * Method to test SequenceValue if it is possible to create a sequence of a type Compound
     * and successfully create sequence values.
     * @throws ValueDoesNotMatchTypeException Must not throw ValueDoesNotMatchTypeException.
     */
    @Test
    public void testSequenceValue() throws ValueDoesNotMatchTypeException {
        //Does not throw ValueDoesNotMatchTypeException anymore
        ContainerValue seqValue;
        String[] values1 = {"maxX", "5", "maxY", "15"};
        String[] values2 = {"maxX", "6", "maxY", "16"};
        seqValue = (ContainerValue) ValueFactory.createValue(seq, values1, values2);
        Assert.assertEquals(2, seqValue.getElementSize());
        
        Assert.assertTrue(seqValue.isFullyConfigured());
    }
   
    /**
     * Method to test SequenceValue if it is possible to create a sequence of a type Compound
     * and successfully create sequence values.
     * @throws ValueDoesNotMatchTypeException Must not throw ValueDoesNotMatchTypeException.
     */
    @Test
    public void testSequenceValueNotFullConfigured() throws ValueDoesNotMatchTypeException {
        //Does not throw ValueDoesNotMatchTypeException anymore
        ContainerValue seqValue;
        String[] values1 = {"maxX", "15"};
        String[] values2 = {"maxY", "6"};
        seqValue = (ContainerValue) ValueFactory.createValue(seq, values1, values2);
        Assert.assertEquals(2, seqValue.getElementSize());
        
        Assert.assertFalse(seqValue.isFullyConfigured());
    }

    /**
     * Method to test SequenceValue if it is possible to create a sequence of a type Compound
     * and successfully create sequence values.
     */
    @Test
    public void testSequenceValue1() {     
        //Does not throw ValueDoesNotMatchTypeException anymore
        try {
            @SuppressWarnings("unused") //Testing whether the instantiation fails correctly.
            ContainerValue seqValue = (ContainerValue) ValueFactory.createValue(seq, "maxX", "5", "maxY", "15" , 
                    "maxX", "6", "maxY", "16");
            Assert.fail();
        } catch (ValueDoesNotMatchTypeException e) {
            //Exception should occur
        }
    }
}
