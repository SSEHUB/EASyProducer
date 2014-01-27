package de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel;

/**
 * The (abstract) top-level non-decomposable artifact. Subclasses represent basic 
 * artifacts such as files and directories and shall only be derived if absolutely
 * necessary as they are considered as default meta-classes. Subclasses of existing 
 * classes may be defined in order to provide more specific operations.
 * 
 * @author Holger Eichelberger
 */
public abstract class SimpleArtifact implements IArtifact {

}
