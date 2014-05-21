package test.de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.testArtifacts;

/**
 * A derived artifact for testing. Please adjust the declared arrays in case that further VIL
 * constructors or visible operations are added so that the test cases can react
 * appropriately and automatically.
 * 
 * @author Holger Eichelberger
 */
public class MySubArtifact extends MyArtifact {

    /**
     * This is the VIL "constructor" method as constructors may be used for internal purposes.
     * 
     * @param test a parameter
     * @param test2 a second parameter
     * @return the created artifact
     */
    public static MySubArtifact create(String test, String test2) {
        return new MySubArtifact();
    }
    
    /**
     * This method shall still be invisible due to the annotation in the super class.
     */
    public void invisible() {
    }
    
    /**
     * This shall be visible to VIL but only in this artifact.
     */
    public void subMethod() {
    }
    
    /**
     * Neither this nor overriding methods shall be visible to VIL due to an inherited annotation.
     */
    @Override
    public void internal() {
    }

}
