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

import org.w3c.dom.Node;

import net.ssehub.easy.instantiation.core.model.artifactModel.CompositeFragmentArtifact;
import net.ssehub.easy.instantiation.core.model.artifactModel.IArtifactChangedListener;
import net.ssehub.easy.instantiation.core.model.artifactModel.IArtifactVisitor;
import net.ssehub.easy.instantiation.core.model.artifactModel.representation.Binary;
import net.ssehub.easy.instantiation.core.model.artifactModel.representation.Text;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.IStringValueProvider;
import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;

/**
 * An abstract fragment representing a XML node.
 * 
 * @author Holger Eichelberger
 */
public abstract class XmlNode extends CompositeFragmentArtifact implements IStringValueProvider, 
    IArtifactChangedListener {

    private XmlElement parent;
    private Text cdata;
    private Text text;
    private Node node;

    /**
     * Creates a new XML comment fragment artifact.
     * 
     * @param parent the parent artifact
     * @param node the node that is represented by this XmlElement
     */
    protected XmlNode(XmlElement parent, Node node) {
        this.parent = parent;
        this.node = node;
    }
    
    /**
     * Returns the parent of this fragment.
     * 
     * @return the parent of this fragment
     */
    public XmlElement getParent() {
        return parent;
    }
    
    /**
     * Returns the represented XML node.
     * 
     * @return the node (may be <b>null</b>)
     */
    protected Node getNode() {
        return node;
    }
    
    /**
     * Changes the representing XML node.
     * 
     * @param node the new representing XML node
     */
    protected void setNode(Node node) {
        this.node = node;
    }
    
    /**
     * Checks the validity of this object.
     * 
     * @throws VilException in case that this object is invalid
     */
    protected void checkValidity() throws VilException {
        if (null == this.node) {
            throw new VilException("element already deleted", VilException.ID_INVALID);
        }
    }
    
    /**
     * Checks if this object represents the Root element. Root elements can not be changed.
     * @throws VilException in case that this object is the root element.
     */
    protected void checkRoot() throws VilException {
        if (null != this.node && this.node.getOwnerDocument().getDocumentElement() == this.node) {
            throw new VilException("root element can not be changed", VilException.ID_SECURITY);
        }        
    }
    
    /**
     * Removes a child from this Element.
     * @param child the child that is to be removed.
     */
    abstract void deleteChild(XmlNode child);
    
    @Override
    public void delete() throws VilException {
        checkValidity();
        checkRoot();
        parent.deleteChild(this);
        this.node.getParentNode().removeChild(this.node);
        this.node = null;
        this.parent = null;
    }
    
    /**
     * Sets the cdata of the element.
     * 
     * @param cdata String of the cdata to store
     * @throws VilException in case that reading fails for some reason
     */
    public void setCdata(String cdata) throws VilException {
        if (null == this.cdata) {
            this.cdata = new Text(cdata, true);
            this.cdata.getListeners().registerListener(this);
        } else {
            this.cdata.setText(cdata);
        }
        node.setTextContent(cdata);
    }

    @Override
    public Binary getBinary() throws VilException {
        //checkValidity();
        return new Binary("", true); // TODO to be replaced by parsed text
    }
    
    @Override
    public Text getText() throws VilException {
        //checkValidity();
        if (null == this.text) {
            this.text = new Text(true);
        }
        return this.text;
    }
    
    /**
     * Returns the text object even if it is <b>null</b>.
     * 
     * @return the text object
     */
    protected Text getTextDirect() {
        return this.text;
    }
    
    /**
     * Returns the cdata of the element.
     * @return the cdata information of this element. Null if there is no cdata
     * @throws VilException if element is invalid.
     */
    public Text getCdata() throws VilException {
        if (null == cdata) {
            setCdata("");
        }
        //checkValidity();
        return this.cdata;
    }
    
    /**
     * Returns the text object for cdata regardless whether it is null.
     * 
     * @return the text object for cdata, may be <b>null</b>
     */
    protected Text getCdataDirect() {
        return this.cdata;
    }

    /**
     * Returns the parent XML file artifact.
     * 
     * @return the parent file artifact, may be <b>null</b>
     */
    @Invisible
    XmlFileArtifact getFile() {
        return null != parent ? parent.getFile() : null;
    }

    /**
     * Notifies the containing file about a change through this object.
     */
    protected void notifyChange() {
        notifyChange(this);
    }
    
    /**
     * Notifies the containing file about a change.
     * 
     * @param cause the causing object
     */
    void notifyChange(Object cause) {
        XmlFileArtifact file = getFile();
        if (null != file) {
            try { 
                file.artifactChanged(cause);
            } catch (VilException e) {
            }
        }
    }

    @Invisible
    @Override
    public void artifactChanged(Object cause) throws VilException {
        node.setTextContent(cdata.getText());
        notifyChange(this);
    }

    @Override
    public void accept(IArtifactVisitor visitor) {
        visitor.visitCompositeFragmentArtifact(this);
    }

    @Override
    public void update() throws VilException {
        //Method not needed at the moment.
    }

}
