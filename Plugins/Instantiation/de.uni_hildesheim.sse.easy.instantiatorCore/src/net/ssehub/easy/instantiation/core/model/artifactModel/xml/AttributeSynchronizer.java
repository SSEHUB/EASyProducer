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

import java.util.HashMap;
import java.util.Map;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Implements an XML attribute synchronizer. As DOM parsing does (usually) not preserve attribute sequences,
 * we synchronize XML attributes if needed through an additional SAX parsing run. This is a SAX content handler
 * maintaining an internal iterator. For each matching element, we synchronize the attributes in the respective
 * VIL attribute fragment.
 * 
 * @author Holger Eichelberger
 */
class AttributeSynchronizer extends DefaultHandler {

    private static final int INDEX_NODE = -1;
    private XmlNode iter;
    private Map<XmlNode, Integer> positions = new HashMap<XmlNode, Integer>();
    
    /**
     * Creates an attribute synchronizer.
     * 
     * @param root the root node to start from
     */
    AttributeSynchronizer(XmlElement root) {
        this.iter = checkPositions(root);
    }
 
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (null != iter) {
            if (qName.equals(iter.getNameSafe())) {
                iter.sortAttributes(attributes);
                iter.synchronizeAttributeSequence();
            } else {
                iter = checkPositions(advanceIter(iter));
            }
        } 
    }
    
    /**
     * Checks whether the initial position of <code>node</code> is stored in {@link #positions}.
     * 
     * @param node the node to check (may be <b>null</b>, ignored then)
     * @return <code>node</code>
     */
    private XmlNode checkPositions(XmlNode node) {
        if (null != node && !positions.containsKey(node)) {
            positions.put(node, INDEX_NODE);  // we are in the node itself, not in the children
        }
        return node;
    }
    
    /**
     * Advances the iterator position. Does not change {@link #iter} directly, but returns the next
     * value of {@link #iter}
     * 
     * @param current the current node
     * @return the next iterator position
     */
    private XmlNode advanceIter(XmlNode current) {
        XmlNode next = checkPositions(current);
        if (null != current) { // are we at the very end?
            int pos = positions.get(current);
            if (INDEX_NODE == pos) { // the last was the node itself, go for the children
                if (current.getChildCount() > 0) { // we have children, take the first one
                    positions.put(current, 0);
                    next = consumeNonXmlElements(current.getChild(0));
                } else { // we have no children, go back to parent
                    positions.remove(current); // we are done
                    next = advanceIter(current.getParent());
                }
            } else { // we are iterating over the children
                if (pos + 1 < current.getChildCount()) { // and we have still more children, take the next one
                    pos++;
                    positions.put(current, pos);
                    next = consumeNonXmlElements(current.getChild(pos));
                } else { // we have no more children, go back to parent
                    positions.remove(current); // we are done
                    next = advanceIter(current.getParent());
                }
            }
        } else {
            next = null; // no node, no parent, end of iteration
        }
        return next;
    }
    
    /**
     * Consumes all following non-{@link XmlElement XmlElements}.
     * 
     * @param node the node to start consuming for (may be <b>null</b>)
     * @return the next non-{@link XmlElement}, may be <code>node</code>, may be <b>null</b>
     * @see #advanceIter(XmlNode)
     */
    private XmlNode consumeNonXmlElements(XmlNode node) {
        XmlNode result;
        if (null != node && !(node instanceof XmlElement)) {
            result = advanceIter(node);
        } else {
            result = node;
        }
        return result;
    }
    
}