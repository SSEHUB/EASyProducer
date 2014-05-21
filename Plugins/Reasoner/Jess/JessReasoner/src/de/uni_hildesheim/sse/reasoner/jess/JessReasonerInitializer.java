package de.uni_hildesheim.sse.reasoner.jess;

import jess.JessVersion;
import de.uni_hildesheim.sse.reasoning.core.frontend.IReasonerInitializer;
import de.uni_hildesheim.sse.reasoning.core.reasoner.IReasoner;

/**
 * Implements the reasoner initializer for testing.
 * 
 * @author Holger Eichelberger
 */
public class JessReasonerInitializer implements IReasonerInitializer {

    /**
     * Stores the default instance.
     */
    public static IReasonerInitializer INSTANCE = new JessReasonerInitializer();
    
    /**
     * Prevents external creation.
     */
    private JessReasonerInitializer() {
    }
    
    @Override
    public String getName() {
        return JessReasonerDescriptor.NAME;
    }

    @Override
    public String getVersion() {
        return JessVersion.VERSION_STRING;
    }

    @Override
    public IReasoner create() {
        return new JessR();
    }

}
