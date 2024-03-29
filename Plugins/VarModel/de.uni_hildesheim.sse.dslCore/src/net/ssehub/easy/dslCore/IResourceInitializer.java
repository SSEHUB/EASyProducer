package net.ssehub.easy.dslCore;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Injector;

/**
 * Defines a plug-in resource initializer.
 * 
 * @author Holger Eichelberger
 */
public interface IResourceInitializer {
    
    /**
     * Returns the resource set.
     * 
     * @param injector the injector to use for creating the resource set
     * 
     * @return the resource set
     */
    public XtextResourceSet createResourceSet(Injector injector);

    /**
     * Converts an Eclipse URI to a <i>java.net.URI</i>.
     * 
     * @param uri
     *            the URI to convert
     * @return the converted URI
     * @throws URISyntaxException
     *             in case of URI syntax errors
     */
    public java.net.URI toNetUri(URI uri) throws URISyntaxException;
    
    /**
     * Returns whether this initializer works for Eclipse.
     * 
     * @return <code>true</code> for Eclipse, <code>false</code> else
     */
    public boolean forEclipse();
    
    /**
     * Resolves a URL to an implementing file or Jar URL.
     * 
     * @param url the URL to be resolved
     * @return the resolved URL or <code>url</code>
     * @throws IOException in case of resolution problems 
     */
    public URL resolve(URL url) throws IOException;
    
}