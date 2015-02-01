package de.uni_hildesheim.sse.dslCore;

import java.net.URISyntaxException;

import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Injector;

/**
 * A resource initializer specific for Eclipse. An Eclipse plugin using
 * the IVML core needs to provide an instance of this class 
 * to {@link ModelUtility#setResourceInitializer(IResourceInitializer)}.
 * 
 * @author Holger Eichelberger
 */
public class EclipseResourceInitializer implements IResourceInitializer {
    
    /**
     * Creates the resource initializer based on the plugin of the application.
     */
    public EclipseResourceInitializer() {
    }

    @Override
    public boolean forEclipse() {
        return true;
    }
    
    @Override
    public XtextResourceSet createResourceSet(Injector injector) {
        XtextResourceSet resourceSet = injector.getInstance(XtextResourceSet.class);
        //resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
        return resourceSet;
    }
    
    @Override
    public java.net.URI toNetUri(URI uri) throws URISyntaxException {
        URI resolvedFile = CommonPlugin.resolve(uri);
        java.net.URI result = null;
        if (null != resolvedFile) {
            result = new java.net.URI(resolvedFile.toString());
        } 
        if (null == result) {
            // don't know how to handle this at the moment
            result = new java.net.URI(uri.toString());
        }
        return result;
    }
    
}
