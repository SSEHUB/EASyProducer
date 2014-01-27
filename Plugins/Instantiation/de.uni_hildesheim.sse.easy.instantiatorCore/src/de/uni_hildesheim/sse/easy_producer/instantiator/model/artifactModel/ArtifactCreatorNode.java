package de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import de.uni_hildesheim.sse.utils.messages.Message;

/**
 * Stores an artifact creator and its subordinate (more specific) creators according 
 * to the inheritance hierarchy.
 * 
 * @author Holger Eichelberger
 */
class ArtifactCreatorNode {
    private IArtifactCreator creator;
    private List<ArtifactCreatorNode> children; // lazy

    /**
     * Creates a new artifact creator node.
     * 
     * @param creator the artifact creator
     */
    public ArtifactCreatorNode(IArtifactCreator creator) {
        this.creator = creator;
    }

    /**
     * Returns whether this creator node is more general than the given <code>cls</code>.
     * 
     * @param cls the class of the creator to be compared
     * @return <code>true</code> if this creator is more general than <code>cls</code>, 
     *   <code>false</code> else, in particular the relation is unclear
     */
    public boolean isMoreGeneralThan(Class<? extends IArtifactCreator> cls) {
        return null == creator || creator.getClass().isAssignableFrom(cls);
    }
    
    /**
     * Returns the number of children.
     * 
     * @return the number of children
     */
    public int getChildrenCount() {
        return null == children ? 0 : children.size();
    }
    
    /**
     * Returns the specified child.
     * 
     * @param index the index of the child to be returned
     * @return the specified child
     * @throws IndexOutOfBoundsException in case of <code>index &lt; 0 
     *     || index &gt;={{@link #getChildrenCount()}}</code>
     */
    public ArtifactCreatorNode getChild(int index) {
        if (null == children) {
            throw new IndexOutOfBoundsException();
        }
        return children.get(index);
    }
    
    /**
     * Adds a new child.
     * 
     * @param creator the creator to be stored in the new child
     */
    void addChild(IArtifactCreator creator) {
        if (null == children) {
            children = new ArrayList<ArtifactCreatorNode>();
        }
        children.add(new ArtifactCreatorNode(creator));
    }
    
    /**
     * Replaces the current creator. This shall only happen if the related
     * artifact also replaces an existing artifact.
     * 
     * @param creator the new creator.
     */
    void setCreator(IArtifactCreator creator) {
        if (null != creator) {
            this.creator = creator;
        }
    }
    
    /**
     * Returns the attached creator.
     * 
     * @return the attached creator
     */
    public IArtifactCreator getCreator() {
        return creator;
    }
    
    /**
     * Returns whether the attached creator handles the given <code>real</code> 
     * artifact instance.
     * 
     * @param kind the kind of artifact in terms of a class (typically the top-level interfaces)
     * @param real the real artifact
     * @return <code>true</code> if the attached creator handles <code>real</code>, 
     *     <code>false</code> else
     */
    public boolean handlesArtifact(Class<? extends IArtifact> kind, Object real) {
        return null == creator || creator.handlesArtifact(kind, real);
    }
    
    /**
     * Returns the name of the class of the attached creator.
     * 
     * @return the name of the attached creator
     */
    String getCreatorClassName() {
        return null == creator ? "<root>" : creator.getClass().getName(); 
    }
    
    /**
     * Configures the attached artifact creator.
     * 
     * @param properties the properties used to configure the creator
     * @param messages configuration messages (to be modified as a side effect)
     */
    void configure(Properties properties, List<Message> messages) {
        if (null != creator) {
            creator.configure(properties, messages);
        }
    }
    
    /**
     * Returns the name of the artifact.
     * 
     * @return the name of the artifact
     */
    String getArtifactName() {
        return creator.getArtifactClass().getSimpleName();
    }
    
    /**
     * Returns whether the subtree represented by this node may handle the
     * given <code>kind</code> of artifact.
     * 
     * @param kind the kind to be tested (may be <b>null</b>)
     * @return <code>true</code> if it may handle, <code>false</code> if not (in particular 
     *     <code>kind</code> is <b>null</b>)
     */
    public boolean subtreeMayHandle(Class<? extends IArtifact> kind) {
        return null != kind && creator.getArtifactClass().isAssignableFrom(kind);
    }
}