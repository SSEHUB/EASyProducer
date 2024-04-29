package net.ssehub.easy.instantiation.core.model.artifactModel;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.basics.messages.Message;
import net.ssehub.easy.instantiation.core.Bundle;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.ListSet;
import net.ssehub.easy.instantiation.core.model.vilTypes.Set;

/**
 * A factory to create individual artifacts. Please note that this factory does not store
 * an entire artifact model rather than it creates individual artifacts. See {@link #createArtifactModel(File)}
 * for creating an artifact model instance. Call {@link #release(ArtifactModel)} if an artifact
 * model instance is not used anymore.
 * 
 * @author Holger Eichelberger
 */
public class ArtifactFactory {
    
    private static final String DEFAULT_MODEL_BASE = "";
    
    /**
     * Stores a tree of artifact creator nodes. The top level tree node is the most generic (no 
     * creator) in order to simplify the algorithms.
     */
    private static final ArtifactCreatorNode ARTIFACT_CREATORS = new ArtifactCreatorNode(null);

    private static final EASyLogger LOGGER = EASyLoggerFactory.INSTANCE.getLogger(ArtifactFactory.class, Bundle.ID);

    // search this in reverse order
    private static final List<ArtifactModel> MODELS = new ArrayList<ArtifactModel>();
    
    /**
     * Prevents external creation.
     */
    private ArtifactFactory() {
    }

    /**
     * Initializes the artifact factory models with one default model storing unmatching artifacts.
     */
    private static void initialize() {
        if (MODELS.isEmpty()) {
            MODELS.add(new ArtifactModel(new File(DEFAULT_MODEL_BASE)));
        }
    }
    
    /**
     * Clears the whole artifact model (for testing, failure case).
     */
    public static void clear() {
        MODELS.clear();
        initialize();
    }
    
    /**
     * Creates an artifact model which is linked to its artifact so that it is notified about relevant changes.
     * Each obtained artifact model must be released by calling {@link #release(ArtifactModel)}.
     *
     * @param base the base directory for file relocation, shall be the related project root
     *
     * @return the instantiation environment
     */
    public static ArtifactModel createArtifactModel(File base) {
        initialize();
        ArtifactModel model = new ArtifactModel(base);
        MODELS.add(model);
        return model;
    }
    
    /**
     * Releases and unregisters the given artifact model.
     * 
     * @param model the model to be released
     */
    public static synchronized void release(ArtifactModel model) {
        initialize();
        MODELS.remove(model);
        model.clear();
    }
    
    /**
     * Clears the default model containing unmatched artifacts.
     */
    public static synchronized void clearDefaultModel() {
        if (!MODELS.isEmpty()) {
            ArtifactModel m = MODELS.get(0);
            if (DEFAULT_MODEL_BASE.equals(m.getBase().getPath())) {
                m.clear();
            }
        }
    }
    
    /**
     * Creates an artifact instance.
     *  
     * @param real the real (underlying) artifact instance
     * @return the resulting handling artifact
     * @throws VilException in case that the creation fails, e.g., <code>real</code> is <b>null</b>
     * 
     * @see #createArtifact(Class, Object, ArtifactModel)
     */
    public static IArtifact createArtifact(Object real) throws VilException {
        return createArtifact(IArtifact.class, real, null);
    }
    
    /**
     * Creates an artifact instance.
     * 
     * @param <T> the type of the artifact to be returned
     * @param kind the kind of artifact in terms of a class (typically the top-level interfaces)
     * @param real the real (underlying) artifact instance (must be instance of Comparable)
     * @param model the model to add the artifact to, <b>null</b> if the factory shall determine the artifact model
     * @return the resulting handling artifact
     * @throws VilException in case that the creation fails, e.g., <code>real</code> is <b>null</b>
     */
    public static <T extends IArtifact> T createArtifact(Class<T> kind, Object real, ArtifactModel model) 
        throws VilException {
        if (null == real) {
            throw new VilException("given object must not be null", VilException.ID_IS_NULL);
        }
        
        if (null == model) {
            model = findModel(real);
        }
        IArtifact artifact = model.getArtifact(real);
        if (null == artifact) {
            IArtifactCreator creator = findCreator(kind, real);
            if (null == creator) {
                throw new VilException("no artifact creator handles " + real.getClass().getName() + " " + real, 
                    VilException.ID_NO_ARTIFACT_CREATOR);
            }
            artifact = creator.createArtifactInstance(real, model);
            model.register(real, artifact);
        } else {
            artifact.update();
        }
        try {
            return kind.cast(artifact);
        } catch (ClassCastException e) {
            throw new VilException("obtained artifact is of type " 
                + artifact.getClass().getName() + " but " + kind.getName() + " is requested", 
                VilException.ID_INVALID_TYPE);
        }
    }

    /**
     * Creates an artifact instance.
     * 
     * @param real the real (underlying) artifact instance
     * @return the resulting handling artifact
     * @throws VilException in case that the creation fails, e.g., <code>real</code> is <b>null</b>
     * 
     * @see #createArtifact(Class, Object, ArtifactModel)
     */
    public static IFileSystemArtifact createFileSystemArtifact(File real) throws VilException {
        return createArtifact(IFileSystemArtifact.class, real, null);
    }

    /**
     * Creates an artifact instance.
     * 
     * @param real the real (underlying) artifact instance
     * @param model the model to add the artifact to, <b>null</b> if the factory shall determine the artifact model
     * @return the resulting handling artifact
     * @throws VilException in case that the creation fails, e.g., <code>real</code> is <b>null</b>
     * 
     * @see #createArtifact(Class, Object, ArtifactModel)
     */
    static IFileSystemArtifact createFileSystemArtifact(File real, ArtifactModel model) throws VilException {
        return createArtifact(IFileSystemArtifact.class, real, model);
    }
    
    /**
     * Returns the {@link ArtifactCreator} annotation for <code>cls</code>.
     * 
     * @param cls the class to be examined
     * @return the annotation instance of <b>null</b>
     */
    static ArtifactCreator getCreator(Class<?> cls) {
        return cls.getAnnotation(ArtifactCreator.class);
    }
    
    /**
     * Checks the replacement of <code>registered</code> by <code>replacing</code>
     * from the perspective of the {@link ArtifactFactory}.
     * 
     * @param registered the already registered class
     * @param replacing the replacing class
     * @return an error message or <b>null</b> if replacement is ok
     */
    public static String checkReplacement(Class<?> registered, Class<?> replacing) {
        String message = null;
        ArtifactCreator regCreator = getCreator(registered);
        if (null != regCreator) {
            if (null == getCreator(replacing)) {
                message = "replacing class " + replacing.getName() + " must also be an artifact creator";
            }
        }
        return message;
    }
    
    /**
     * Is called to notify that the given class <code>cls</code> was registered in 
     * {@link net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry}.
     * A more loose coupling would be preferrable but this would require more explicit registration...
     * 
     * @param cls the class which that registered
     */
    public static void registered(Class<?> cls) {
        ArtifactCreator creatorAnnotation = getCreator(cls);
        if (null != creatorAnnotation) {
            Class<? extends IArtifactCreator> creatorClass = creatorAnnotation.value();
            if (null == creatorClass) {
                LOGGER.error("artifact creator class empty at class " + cls.getName());
            } else {
                try {
                    addArtifactCreator(creatorClass.getDeclaredConstructor().newInstance());
                } catch (IllegalAccessException | NoSuchMethodException | InstantiationException e) {
                    LOGGER.error("cannot create artifact creator of class " + creatorClass.getName() 
                        + ": " + e.getMessage());
                } catch (InvocationTargetException e) {
                    LOGGER.error("cannot create artifact creator of class " + creatorClass.getName() 
                        + ": " + e.getCause().getMessage());
                }
            }
        }
    }
    
    /**
     * Add artifact creator to the set of artifact creators for automatic (default) creation
     * of artifacts.
     * 
     * @param creator the creator to be added
     */
    public static void addArtifactCreator(IArtifactCreator creator) {
        String creatorArtifactName = creator.getArtifactClass().getSimpleName();
        Class<? extends IArtifactCreator> creatorClass = creator.getClass();
        ArtifactCreatorNode node = ARTIFACT_CREATORS;
        // sift down along inheritance hierarchy
        boolean replaced = false;
        do {
            ArtifactCreatorNode found = null;
            for (int c = 0; null == found && c < node.getChildrenCount(); c++) {
                ArtifactCreatorNode tmp = node.getChild(c);
                if (tmp.isMoreGeneralThan(creatorClass)) {
                    if (tmp.getArtifactName().equals(creatorArtifactName)) {
                        // same artifact - replace as otherwise a more generic node will occur as most specific
                        // node in hierarchy
                        tmp.setCreator(creator);
                        replaced = true;
                        break;
                    }
                    found = tmp;
                }
            }
            if (!replaced) {
                if (null == found) {
                    node.addChild(creator);
                    break;
                } else {
                    node = found;
                }
            }
        } while (null != node && !replaced); // shall not occur due to init, (null == found) && break
        if (null != node) {
            String parent;
            if (null == node.getCreator()) {
                parent = "as root creator";
            } else {
                parent = "below " + node.getCreator().getClass().getName();
            }
            LOGGER.info((replaced ? "replaced" : "registered") + " " + creatorClass.getName() + " " + parent);
        } else {
            LOGGER.error("internal error: " + creatorClass.getName() + " not registered");
        }
    }
    
    /**
     * Returns a creator for <code>real</code>.
     * 
     * @param kind the kind of artifact in terms of a class (typically the top-level interfaces)
     * @param real the real artifact instance
     * @return the creator, may be <b>null</b> if no artifact creator is able to handle <code>real</code>
     */
    private static IArtifactCreator findCreator(Class<? extends IArtifact> kind, Object real) {
        return findCreator(kind, real, ARTIFACT_CREATORS, null).getCreator();
    }
    
    /**
     * Recursive search for a creator.
     * 
     * @param kind the kind of artifact in terms of a class (typically the top-level interfaces)
     * @param real the real artifact instance
     * @param node the node to analyze (including children)
     * @param actualResult the actual result (in order to issue warnings in case of multiple results)
     * @return the actual (refined) result
     */
    private static ArtifactCreatorNode findCreator(Class<? extends IArtifact> kind, Object real, 
        ArtifactCreatorNode node, ArtifactCreatorNode actualResult) {
        ArtifactCreatorNode candidateResult = node; // this is already a candidate
        for (int c = 0; c < node.getChildrenCount(); c++) {
            ArtifactCreatorNode tmp = node.getChild(c);
            boolean handles = tmp.handlesArtifact(kind, real); 
            if (handles || tmp.subtreeMayHandle(kind)) {
                ArtifactCreatorNode tmpResult = findCreator(kind, real, tmp, actualResult);
                if (!handles && tmpResult == tmp) {
                    tmpResult = null;
                }
                if (null != tmpResult) {
                    candidateResult = tmpResult; // take more specific result
                }
            }
        }
        if (null != candidateResult) {
            if (null != actualResult && null != actualResult.getCreator()) {
                LOGGER.warn(candidateResult.getCreatorClassName() + " is another handling creator for " 
                    + real.getClass().getName() + "in addition to " + actualResult.getCreatorClassName());
                // keep actual result 
            } else {
                actualResult = candidateResult;
            }
        }
        return actualResult;
    }
    
    /**
     * Configures the given <code>node</code> and its children.
     * 
     * @param node the node to be configured
     * @param properties the properties containing the configuration
     * @param messages configuration messages (to be modified as a side effect)
     */
    private static void configureArtifactCreators(ArtifactCreatorNode node, Properties properties, 
        List<Message> messages) {
        node.configure(properties, messages);
        for (int c = 0; c < node.getChildrenCount(); c++) {
            configureArtifactCreators(node.getChild(c), properties, messages);
        }
    }
    
    /**
     * Configures the artifact creators. Each artifact creator may look for a property with its
     * own single name and read a comma separated list of regular file path patterns for its configuration. If
     * empty, the artifact creator shall be disabled. If If {@link IArtifactCreator#DEFAULT_PATTERN} is contained, 
     * then the default
     * implementation shall be called, otherwise only the configured entries shall be considered.<br/>
     * <i>Please call this method when all types are registered so that all artifact creators are known.</i>
     * 
     * @param properties the properties for configuring the artifact creators
     * @return configuration messages, i.e., warnings and errors which occurred while configuring the artifact creators
     */
    public static List<Message> configureArtifactCreators(Properties properties) {
        List<Message> messages = new ArrayList<Message>();
        configureArtifactCreators(ARTIFACT_CREATORS, properties, messages);
        return messages;
    }

    /**
     * Searches for paths in the artifact model by type.
     * 
     * @param path the path denoting the artifacts to be selected
     * @param type the type of the artifacts to be returned (may be <b>null</b> if type selection does not apply)
     * @param byKind by subtyping (<code>true</code>) or by equality (<code>false</code>)
     * @param negate negate the selection
     * 
     * @return the found artifacts
     */
    public static synchronized Set<FileArtifact> selectByType(Path path, Class<?> type, boolean byKind, 
        boolean negate) {
        initialize();
        List<FileArtifact> result = new LinkedList<FileArtifact>();
        for (int m = MODELS.size() - 1; m >= 0; m--) {
            MODELS.get(m).selectByType(path, type, result, byKind, negate);
        }
        return new ListSet<FileArtifact>(result, type);
    }
    
    /**
     * Returns the artifact model which is most specific for <code>real</code>.
     * 
     * @param real the real artifact (or its string path)
     * @return the matching artifact model
     */
    public static synchronized ArtifactModel findModel(Object real) {
        initialize();
        if (real instanceof String) {
            real = new File(real.toString()).getAbsoluteFile();
        }
        ArtifactModel result = null;
        int maxPrio = 0;
        for (int m = MODELS.size() - 1; null == result && m >= 0; m--) {
            ArtifactModel model = MODELS.get(m);
            int prio = model.handles(real);
            if (prio > 0 && (null == result || prio > maxPrio)) {
                result = model;
                maxPrio = prio;
            }
        }
        if (null == result) {
            result = MODELS.get(0);
        }
        return result;
    }
    
    /**
     * Returns the default artifact model.
     * 
     * @return the default artifact model
     */
    static ArtifactModel getDefaultArtifactModel() {
        initialize();
        return MODELS.get(0);
    }

}
