package de.uni_hildesheim.sse.reasoning.drools;
import de.uni_hildesheim.sse.reasoning.core.frontend.IReasonerInitializer;
import de.uni_hildesheim.sse.reasoning.core.reasoner.IReasoner;


/**
 * Implements the reasoner initializer for testing.
 * 
 * @author Holger Eichelberger
 */
public class DroolsReasonerInitializer implements IReasonerInitializer {

    /**
     * Stores the default instance.
     */
    public static IReasonerInitializer INSTANCE = new DroolsReasonerInitializer();
    
    /**
     * Prevents external creation.
     */
    private DroolsReasonerInitializer() {
    }
    
    @Override
    public String getName() {
        return DroolsReasonerDescriptor.NAME;
    }

    @Override
    public String getVersion() {
        return DroolsReasonerDescriptor.VERSION;
    }

    @Override
    public IReasoner create() {
        return new DroolsReasoner();
    }

}
