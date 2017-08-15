/*
 * Copyright 2009-2017 University of Hildesheim, Software Systems Engineering
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

import org.w3c.dom.Comment;
import org.w3c.dom.DOMException;
import org.w3c.dom.Node;

import net.ssehub.easy.instantiation.core.model.artifactModel.FragmentArtifact;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.ParameterMeta;
import net.ssehub.easy.instantiation.core.model.vilTypes.Set;

/**
 * Represents an XML comment.
 * 
 * @author Holger Eichelberger
 */
public class XmlComment extends XmlNode {
    
    /**
     * Creates a new XML comment fragment artifact.
     * 
     * @param parent the parent artifact
     * @param node the node that is represented by this XmlElement
     */
    XmlComment(XmlElement parent, Node node) {
        super(parent, node);
    }
    
    /**
     * Creates a new XmlComment as child of given parent.
     * @param parent The parent of the new XmlComment.
     * @param contents optional initial contents, ignored if empty
     * @return The created XmlElement.
     * @throws VilException if element could not be created.
     */
    public static XmlComment create(XmlElement parent, @ParameterMeta(name = "contents") String contents) 
        throws VilException {
        XmlComment newElement = null;
        if (null == parent) {
            throw new VilException("Can not append child from NULL element!", VilException.ID_IS_NULL);
        }
        try {
            Comment newNode = parent.getNode().getOwnerDocument().createComment(contents);
            parent.getNode().appendChild(newNode); // notifies change
            newElement = new XmlComment(parent, newNode);
            parent.addChild(newElement); // notifies change
        } catch (DOMException exc) {
            throw new VilException("Invalid character, name or ID!", VilException.ID_INVALID);
        }
        if (null != contents && contents.length() > 0) {
            newElement.setCdata(contents);
        }
        return newElement;
    }

    @Override
    public String getStringValue(StringComparator comparator) {
        return "xmlComment ";
    }

    @Override
    public String getName() throws VilException {
        return null;
    }

    @Override
    public void rename(String name) throws VilException {
    }

    @Override
    public Set<? extends FragmentArtifact> selectAll() throws VilException {
        return null;
    }
    
    @Override
    void deleteChild(XmlNode child) {
    }

}
