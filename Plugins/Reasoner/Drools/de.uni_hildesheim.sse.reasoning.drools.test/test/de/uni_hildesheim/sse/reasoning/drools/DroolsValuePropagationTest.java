package de.uni_hildesheim.sse.reasoning.drools;

import java.io.File;
import java.io.IOException;
import org.junit.Test;

import de.uni_hildesheim.sse.model.confModel.AssignmentState;
import de.uni_hildesheim.sse.model.confModel.Configuration;

public class DroolsValuePropagationTest extends AbstractTest{
    
    
    private static final String DIRPATH = "propagation" + File.separator;
    
    
    //@Test
    public void testSimpleValuePropagation() throws IOException {
        Configuration config = propagate(DIRPATH + "SimpleValuePropagation.ivml");
        
        
        checkConfiguration(config, "a", "15", AssignmentState.FROZEN);
        checkConfiguration(config, "bool", "true", AssignmentState.FROZEN);
        checkConfiguration(config, "str", "Hello World!", AssignmentState.FROZEN);
    }
    
    //@Test
    public void testFrozenValuePropagation() throws IOException {
        Configuration config = propagate(DIRPATH + "FrozenValuePropagation.ivml");
        
        
        checkConfiguration(config, "a", "5", AssignmentState.FROZEN);
        checkConfiguration(config, "b", "5", AssignmentState.DEFAULT);
        checkConfiguration(config, "c", "15", AssignmentState.DERIVED);
        checkConfiguration(config, "e", "9", AssignmentState.FROZEN);
        checkConfiguration(config, "d", "10", AssignmentState.ASSIGNED);
    }
    
    @Test
    public void testEnumsValuePropagation() throws IOException {
        Configuration config = propagate(DIRPATH + "EnumsValuePropagation.ivml");
        
        
        checkConfiguration(config, "color1", "blue", AssignmentState.DERIVED);
        checkConfiguration(config, "t1", "three", AssignmentState.DERIVED);
        checkConfiguration(config, "t2", "tele2", AssignmentState.FROZEN);
//        checkConfiguration(config, "seq1", "", AssignmentState.FROZEN);
    }
    
    //@Test
    public void testNestedEnumsValuePropagation() throws IOException {
        Configuration config = propagate(DIRPATH + "NestedEnumValuePropagation.ivml");
        
        
//        checkConfiguration(config, "seq1", "", AssignmentState.FROZEN);
    }
    
    //@Test
    public void testComplexValuePropagation() throws IOException {
       projectCount = 3;
//        Configuration config = propagate(DIRPATH + "ComplexProp.ivml");
        assertConsistency(DIRPATH + "ComplexProp.ivml", false);
        projectCount = 0; 
        
    }
    
    //@Test
    public void testGoodsExample() throws IOException {
        
        projectCount = 1;
        Configuration config = propagate(DIRPATH + "GoodsIn_Instances.ivml");
        projectCount = 0;
        
//        checkConfiguration(config, "seq1", "", AssignmentState.FROZEN);
    }
    
    
}
