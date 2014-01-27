package de.uni_hildesheim.sse;

/**
 * Initialization support for running Xtext languages without equinox extension
 * registry.
 */
public class IvmlStandaloneSetup extends IvmlStandaloneSetupGenerated {

    /**
     * Performs the setup.
     */
    public static void doSetup() {
        new IvmlStandaloneSetup().createInjectorAndDoEMFRegistration();
    }
}
