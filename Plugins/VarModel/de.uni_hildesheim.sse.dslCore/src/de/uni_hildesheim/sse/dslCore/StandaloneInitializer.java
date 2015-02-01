package de.uni_hildesheim.sse.dslCore;

import java.net.URISyntaxException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Injector;



/**
 * Defines a standalone resource listener.
 * 
 * @author Holger Eichelberger
 */
public class StandaloneInitializer implements IResourceInitializer {

    @Override
    public boolean forEclipse() {
        return false;
    }
    
    @Override
    public XtextResourceSet createResourceSet(Injector injector) {
        XtextResourceSet resourceSet = injector.getInstance(XtextResourceSet.class);
        resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
        return resourceSet;
    }

    @Override
    public java.net.URI toNetUri(URI uri) throws URISyntaxException {
        return new java.net.URI(uri.toString());
    }

}
