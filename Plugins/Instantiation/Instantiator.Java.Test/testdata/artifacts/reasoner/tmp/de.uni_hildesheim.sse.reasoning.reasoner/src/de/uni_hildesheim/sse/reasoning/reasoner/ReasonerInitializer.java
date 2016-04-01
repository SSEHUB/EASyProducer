package de.uni_hildesheim.sse.reasoning.reasoner;
import de.uni_hildesheim.sse.reasoning.core.frontend.IReasonerInitializer;
import de.uni_hildesheim.sse.reasoning.core.reasoner.IReasoner;


/**
 * Implements the reasoner initializer for testing.
 * 
 * @author Holger Eichelberger
 */
public class ReasonerInitializer implements IReasonerInitializer {

    /**
     * Stores the default instance.
     */
    public static final IReasonerInitializer INSTANCE = new ReasonerInitializer();
    
    /**
     * Prevents external creation.
     */
    private ReasonerInitializer() {
    }
    
    @Override
    public String getName() {
        return Descriptor.NAME;
    }

    @Override
    public String getVersion() {
        return Descriptor.VERSION;
    }

    @Override
    public IReasoner create() {
        return new Reasoner();
    }

}
