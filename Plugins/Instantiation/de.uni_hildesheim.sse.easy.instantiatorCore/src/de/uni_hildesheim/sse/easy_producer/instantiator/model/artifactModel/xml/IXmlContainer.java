package de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.xml;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArtifactException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationMeta;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Set;

/**
 * Defines the operations of an XML container, i.e., an element which contains XML elements.
 * 
 * @author Holger Eichelberger
 */
public interface IXmlContainer {

    /**
     * Selects XML elements according to a given path. We may go for XPath expressions in future.
     * 
     * @param path the path to the elements
     * @return the matching elements (may be empty)
     * @throws ArtifactException in case invalid XmlElements are used.
     */
    @OperationMeta(returnGenerics = XmlElement.class)
    public Set<XmlElement> selectByPath(String path) throws ArtifactException;

    /**
     * Returns a Set with all XmlElements matching name. Childs are processed aswell. <br>
     * Uses case sensitivity by default.
     * 
     * @param name The required name.
     * @return set with matching XmlElements.
     * @throws ArtifactException in case that invalid Elements are used.
     */
    @OperationMeta(returnGenerics = XmlElement.class)
    public Set<XmlElement> selectByName(String name) throws ArtifactException;

}
