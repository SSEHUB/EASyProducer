package de.uni_hildesheim.sse.easy.loader.framework;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.cert.X509Certificate;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.Version;

/**
 * Implements a fake bundle.
 * 
 * @author Holger Eichelberger
 */
public class FakeBundle implements Bundle {

    private BundleContext context;

    /**
     * Creates a fake bundle with associated bundle context.
     * 
     * @param context the bundle context
     */
    FakeBundle(BundleContext context) {
        this.context = context;
    }
    
    @Override
    public int compareTo(Bundle other) {
        return 0;
    }

    @Override
    public <A> A adapt(Class<A> arg0) {
        return null;
    }

    @Override
    public Enumeration<URL> findEntries(String arg0, String arg1, boolean arg2) {
        return new Vector<URL>().elements();
    }

    @Override
    public BundleContext getBundleContext() {
        return context;
    }

    @Override
    public long getBundleId() {
        return 0;
    }

    @Override
    public File getDataFile(String arg0) {
        return null;
    }

    @Override
    public URL getEntry(String arg0) {
        return null;
    }

    @Override
    public Enumeration<String> getEntryPaths(String arg0) {
        return new Vector<String>().elements();
    }

    @Override
    public Dictionary<String, String> getHeaders() {
        return null;
    }

    @Override
    public Dictionary<String, String> getHeaders(String arg0) {
        return null;
    }

    @Override
    public long getLastModified() {
        return 0;
    }

    @Override
    public String getLocation() {
        return "";
    }

    @Override
    public ServiceReference<?>[] getRegisteredServices() {
        return null;
    }

    @Override
    public URL getResource(String arg0) {
        return null;
    }

    @Override
    public Enumeration<URL> getResources(String arg0) throws IOException {
        return new Vector<URL>().elements();
    }

    @Override
    public ServiceReference<?>[] getServicesInUse() {
        return null;
    }

    @Override
    public Map<X509Certificate, List<X509Certificate>> getSignerCertificates(int arg0) {
        return null;
    }

    @Override
    public int getState() {
        return 0;
    }

    @Override
    public String getSymbolicName() {
        return "fake.bundle";
    }

    @Override
    public Version getVersion() {
        return new Version("1.0");
    }

    @Override
    public boolean hasPermission(Object arg0) {
        return false;
    }

    @Override
    public Class<?> loadClass(String arg0) throws ClassNotFoundException {
        return Class.forName(arg0);
    }

    @Override
    public void start() throws BundleException {
    }

    @Override
    public void start(int arg0) throws BundleException {
    }

    @Override
    public void stop() throws BundleException {
    }

    @Override
    public void stop(int arg0) throws BundleException {
    }

    @Override
    public void uninstall() throws BundleException {
    }

    @Override
    public void update() throws BundleException {
    }

    @Override
    public void update(InputStream arg0) throws BundleException {
    }

}
