package de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel;

import java.util.List;
import java.util.Properties;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Invisible;
import de.uni_hildesheim.sse.utils.messages.Message;

/**
 * Describes creator instances which know how to translate real world objects into artifact instances.
 * Implementations must fulfill the following contract:
 * <ul>
 *   <li>{@link #handlesArtifact(Class, Object)} is called to figure out whether a creator
 *     is able to handle a certain artifact under given class-based restrictions. Typically, 
 *     more specific creators are asked later than more generic ones, but more specific
 *     creators (according to inheritance relationships) are considered first for creation.
 *     An implementation which answers <code>true</code> must be able to create the queried
 *     artifact.</li> 
 *   <li>{@link #createArtifactInstance(Object, ArtifactModel)} actually creates an instance for the 
 *     previously queried object. However, no information shall be stored nor there is a 
 *     guarantee that {@link #createArtifactInstance(Object, ArtifactModel)} will be called (dependent
 *     on the other registered creators). As stated above, if {@link #handlesArtifact(Class, Object)}
 *     answers with <code>true</code>, {@link #createArtifactInstance(Object, ArtifactModel)} must be able
 *     to perform the creation for the given object.</li>
 * </ul>
 * 
 * @author Holger Eichelberger
 */
public interface IArtifactCreator {

    /**
     * A pseudo token denoting the implemented configuration (value {@value}).
     */
    public static final String DEFAULT_PATTERN = "*";
    
    /**
     * Returns whether this creator handles this type of artifact.
     * 
     * @param kind the kind of artifact in terms of a class (typically the top-level interfaces)
     * @param real the real world object
     * @return <code>true</code> if it can handle the artifact, <code>false</code> else
     */
    @Invisible(inherit = true)
    public boolean handlesArtifact(Class<? extends IArtifact> kind, Object real);

    /**
     * Returns the artifact instance for <code>real</code>.
     * 
     * @param real the real world object
     * @param model the artifact model to create the artifact within
     * @return the instance or <b>null</b> if <code>real</code> cannot be handled
     * @throws VilException in case that any instance creation problem occurs
     */
    @Invisible(inherit = true)
    public IArtifact createArtifactInstance(Object real, ArtifactModel model) throws VilException;
    
    /**
     * Configures its own reaction according to a set of properties.
     * Each artifact creator may look for a property with its
     * own single name and read a comma separated list of regular file path patterns for its configuration. If
     * empty, the artifact creator shall be disabled. If {@link #DEFAULT_PATTERN} is contained, then the default
     * implementation shall be called, otherwise only the configured entries shall be considered.
     * A creator shall not modify the given <code>properties</code> (exceptions may apply).
     * 
     * @param properties the properties to configure on
     * @param messages configuration messages (to be modified as a side effect)
     */
    @Invisible(inherit = true)
    public void configure(Properties properties, List<Message> messages);
    
    /**
     * The class of the artifact being created. Do <b>not</b> override this method
     * for an existing creator if you plan to just replace an existing artifact! In
     * that case subclass the respective creator and override only 
     * {@link #createArtifactInstance(Object, ArtifactModel)}.
     * 
     * @return the class of the artifact being created
     */
    @Invisible(inherit = true)
    public Class<? extends IArtifact> getArtifactClass();

}
