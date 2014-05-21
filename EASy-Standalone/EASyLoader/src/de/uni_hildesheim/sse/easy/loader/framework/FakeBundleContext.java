package de.uni_hildesheim.sse.easy.loader.framework;

import java.io.File;
import java.io.InputStream;
import java.util.Collection;
import java.util.Dictionary;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.BundleListener;
import org.osgi.framework.Filter;
import org.osgi.framework.FrameworkListener;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

/**
 * Implements a fake bundle context.
 * 
 * @author Holger Eichelberger
 */
public class FakeBundleContext implements BundleContext {

    public static final BundleContext INSTANCE = new FakeBundleContext();
    private Bundle bundle = new FakeBundle(this);
    
    @Override
    public void addBundleListener(BundleListener arg0) {
    }

    @Override
    public void addFrameworkListener(FrameworkListener arg0) {
    }

    @Override
    public void addServiceListener(ServiceListener arg0) {
    }

    @Override
    public void addServiceListener(ServiceListener arg0, String arg1) throws InvalidSyntaxException {
    }

    @Override
    public Filter createFilter(String arg0) throws InvalidSyntaxException {
        return null;
    }

    @Override
    public ServiceReference<?>[] getAllServiceReferences(String arg0, String arg1) throws InvalidSyntaxException {
        return null;
    }

    @Override
    public Bundle getBundle() {
        return bundle;
    }

    @Override
    public Bundle getBundle(long arg0) {
        return bundle;
    }

    @Override
    public Bundle getBundle(String arg0) {
        return bundle;
    }

    @Override
    public Bundle[] getBundles() {
        return null;
    }

    @Override
    public File getDataFile(String arg0) {
        return null;
    }

    @Override
    public String getProperty(String arg0) {
        return null;
    }

    @Override
    public <S> S getService(ServiceReference<S> arg0) {
        return null;
    }

    @Override
    public ServiceReference<?> getServiceReference(String arg0) {
        return null;
    }

    @Override
    public <S> ServiceReference<S> getServiceReference(Class<S> arg0) {
        return null;
    }

    @Override
    public ServiceReference<?>[] getServiceReferences(String arg0, String arg1) throws InvalidSyntaxException {
        return null;
    }

    @Override
    public <S> Collection<ServiceReference<S>> getServiceReferences(Class<S> arg0, String arg1)
        throws InvalidSyntaxException {
        return null;
    }

    @Override
    public Bundle installBundle(String arg0) throws BundleException {
        return null;
    }

    @Override
    public Bundle installBundle(String arg0, InputStream arg1) throws BundleException {
        return null;
    }

    @Override
    public ServiceRegistration<?> registerService(String[] arg0, Object arg1, Dictionary<String, ?> arg2) {
        return null;
    }

    @Override
    public ServiceRegistration<?> registerService(String arg0, Object arg1, Dictionary<String, ?> arg2) {
        return null;
    }

    @Override
    public <S> ServiceRegistration<S> registerService(Class<S> arg0, S arg1, Dictionary<String, ?> arg2) {
        return null;
    }

    @Override
    public void removeBundleListener(BundleListener arg0) {
    }

    @Override
    public void removeFrameworkListener(FrameworkListener arg0) {
    }

    @Override
    public void removeServiceListener(ServiceListener arg0) {
    }

    @Override
    public boolean ungetService(ServiceReference<?> arg0) {
        return false;
    }

}
