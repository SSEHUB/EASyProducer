/*
 * Copyright 2009-2016 University of Hildesheim, Software Systems Engineering
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.ssehub.easy.instantiation.core.model.artifactModel.xml;

import org.w3c.dom.Node;

import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;

/**
 * A specific root element storing the relation to the containing file artifact.
 * 
 * @author Holger Eichelberger
 */
class XmlRootElement extends XmlElement {

    private XmlFileArtifact file;
    
    /**
     * Creates a new XML root element fragment artifact.
     * 
     * @param file the containing XML file artifact
     * @param parent the parent artifact
     * @param name the name of the element
     * @param attributes the attributes
     * @param node the node that is represented by this XmlElement
     */
    XmlRootElement(XmlFileArtifact file, XmlElement parent, String name, XmlAttribute[] attributes, Node node) {
        super(parent, name, attributes, node);
        this.file = file;
    }
    
    @Invisible
    @Override
    XmlFileArtifact getFile() {
        return file;
    }

}
