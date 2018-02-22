package de.uni_hildesheim.sse.easy.loader.framework;

import java.util.Dictionary;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.ComponentInstance;


/**
 * Implements a fake component context.
 * 
 * @author Holger Eichelberger
 */
public class FakeComponentContext implements ComponentContext {

    public static final ComponentContext INSTANCE = new FakeComponentContext();
    
    @Override
    public void disableComponent(String arg0) {
    }

    @Override
    public void enableComponent(String arg0) {
    }

    @Override
    public BundleContext getBundleContext() {
        return FakeBundleContext.INSTANCE;
    }

    @Override
    public ComponentInstance getComponentInstance() {
        return null;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public Dictionary getProperties() {
        return null;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public ServiceReference getServiceReference() {
        return null;
    }

    @Override
    public Bundle getUsingBundle() {
        return null;
    }

    @Override
    public Object locateService(String arg0) {
        return null;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Object locateService(String arg0, ServiceReference arg1) {
        return null;
    }

    @Override
    public Object[] locateServices(String arg0) {
        return null;
    }

}
