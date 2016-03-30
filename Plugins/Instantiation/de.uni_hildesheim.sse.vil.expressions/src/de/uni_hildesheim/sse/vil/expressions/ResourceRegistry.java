package de.uni_hildesheim.sse.vil.expressions;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.nodemodel.INode;

import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;

/**
 * Registers type registries for resource (URIs). This allows the UI parts of xText
 * editors to access to correct type registry.
 * 
 * @author Holger Eichelberger
 */
public class ResourceRegistry {

    private static final Map<URI, TypeRegistry> MAP = Collections.synchronizedMap(
        new HashMap<URI, TypeRegistry>());

    /**
     * Prevents external object creation.
     */
    private ResourceRegistry() {
    }
    
    /**
     * Clears the registry.
     */
    public static void clear() {
        MAP.clear();
    }
    
    /**
     * Unregisters the type registry for a given URI.
     * 
     * @param uri the URI (may be <b>null</b>)
     */
    public static void unregister(URI uri) {
        if (null != uri) {
            MAP.remove(uri);
        }
    }

    /**
     * Unregisters the type registry for a given resource (via its URI).
     * 
     * @param resource the resource (may be <b>null</b>)
     * @see #unregister(URI)
     */
    public static void unregister(Resource resource) {
        if (null != resource) {
            unregister(resource.getURI());
        }
    }

    /**
     * Registers a type registry for a given URI. Registration happens only if <code>uri</code>
     * is not <b>null</b> and the given <code>registry</code> is not {@link TypeRegistry#DEFAULT}.
     * 
     * @param uri the URI to register the <code>registry</code> for
     * @param registry the registry to be registered
     */
    public static void register(URI uri, TypeRegistry registry) {
        if (null != uri && TypeRegistry.DEFAULT != registry) {
            MAP.put(uri, registry);
        }
    }

    /**
     * Registers a type registry for a given resource (via its URI). Registration happens only if <code>resource</code>
     * (and its URI) are not <b>null</b> and the given <code>registry</code> is not {@link TypeRegistry#DEFAULT}.
     * 
     * @param uri the URI to register the <code>registry</code> for (may be <b>null</b>)
     * @param registry the registry to be registered
     */
    public static void register(Resource resource, TypeRegistry registry) {
        if (null != resource) {
            register(resource.getURI(), registry);
        }
    }

    /**
     * Registers a type registry for a given resource (via its URI). Registration happens only if <code>resource</code>
     * (and its URI) are not <b>null</b> and the given <code>registry</code> is not {@link TypeRegistry#DEFAULT}.
     * 
     * @param uri the URI to register the <code>registry</code> for (may be <b>null</b>)
     * @param registry the registry to be registered
     */
    public static TypeRegistry getTypeRegistry(java.net.URI uri) {
        URI tmp = null;
        if (null != uri) {
            tmp = URI.createURI(uri.toString());
        }
        return getTypeRegistry(tmp);
    }

    /**
     * Returns the type registry for a given URI.
     * 
     * @param uri the URL the type registry shall be returned for (may be <b>null</b>)
     * 
     * @return the related type registry or {@link TypeRegistry#DEFAULT} if non was registered
     */
    public static TypeRegistry getTypeRegistry(URI uri) {
        TypeRegistry result = null;
        if (null != uri) {
            result = MAP.get(uri);
        }
        if (null == result) {               
            result = TypeRegistry.DEFAULT;
        }
        return result;
    }

    /**
     * Returns the type registry for a given resource (via its URI).
     * 
     * @param resource the resource the type registry shall be returned for (may be <b>null</b>)
     * 
     * @return the related type registry or {@link TypeRegistry#DEFAULT} if non was registered
     * @see #getTypeRegistry(URI)
     */
    public static TypeRegistry getTypeRegistry(Resource resource) {
        return getTypeRegistry(null == resource ? null : resource.getURI());
    }

    /**
     * Returns the type registry for a given (parse tree) node (via its resource URI).
     * 
     * @param node the node the type registry shall be returned for (may be <b>null</b>)
     * 
     * @return the related type registry or {@link TypeRegistry#DEFAULT} if non was registered
     * @see #getTypeRegistry(EObject)
     */
    public static TypeRegistry getTypeRegistry(INode node) {
        return getTypeRegistry(null == node ? null : node.getSemanticElement());
    }

    /**
     * Returns the type registry for a given (grammar tree) <i>EObject</i> (via its resource URI).
     * 
     * @param object the object the type registry shall be returned for (may be <b>null</b>)
     * 
     * @return the related type registry or {@link TypeRegistry#DEFAULT} if non was registered
     * @see #getTypeRegistry(Resource)
     */
    public static TypeRegistry getTypeRegistry(EObject object) {
        return getTypeRegistry(null ==object ? null : object.eResource());
    }

}
