package de.uni_hildesheim.sse.reasoning.chocoreasoner.activator;


import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import de.uni_hildesheim.sse.reasoning.chocoreasoner.implementation.Choco;
import de.uni_hildesheim.sse.reasoning.core.frontend.ReasonerFrontend;

/**
 * OSGi activator for the choco reasoner.
 * This activator registers this reasoner to the reasoner frontend (ReasonerCore). 
 * @author Jaehne
 *
 */
public class Activator implements BundleActivator {

    private static BundleContext context;
    private ServiceReference serviceRef;

    static BundleContext getContext() {
        return context;
    }

    @Override
    //checkstyle: stop exception type check 
    public void start(BundleContext bundleContext) throws Exception {
        System.out.println("Registrierung von ChocoReasoner");
        Activator.context = bundleContext;

        Choco reasonerInstance = new Choco();

        serviceRef = context.getServiceReference(ReasonerFrontend.class.getName());
        ReasonerFrontend coreBundle = (ReasonerFrontend) Activator.context.getService(serviceRef);
        
        // Reasoner wird im corebundle eingefügt
        coreBundle.getRegistry().register(reasonerInstance);
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        Activator.context = null;
    }
    //checkstyle: resume exception type check 

}
