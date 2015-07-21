package de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;

/**
 * Implements a template block.
 * 
 * @author Holger Eichelberger
 */
public class TemplateBlock implements ITemplateElement {

    private ITemplateElement[] body;

    /**
     * Creates a new block.
     * 
     * @param body the body
     */
    public TemplateBlock(ITemplateElement[] body) {
        this.body = body;
    }

    /**
     * Changes the body elements.
     * 
     * @param body the new body elements
     */
    public void setBody(ITemplateElement[] body) {
        this.body = body;
    }
    
    /**
     * Get the number of body elements of this rule.
     * 
     * @return The number of body elements of this rule.
     */
    public int getBodyElementCount() {
        return null == body ? 0 : body.length;
    }
    
    /**
     * Get the element of this block at the specified index.
     * 
     * @param index The 0-based index of the element to be returned. 
     * @return The element at the given index.
     * @throws IndexOutOfBoundsException if <code>index &lt; 0 || index &gt;={@link #getBodyElementCount()}</code>
     */
    public ITemplateElement getBodyElement(int index) {
        if (null == body) {
            throw new IndexOutOfBoundsException();
        }
        return body[index];
    }
    
    @Override
    public Object accept(IVisitor visitor) throws VilException {
        return visitor.visitTemplateBlock(this);
    }
    
    @Override
    public boolean isBlock() {
        return true;
    }

    @Override
    public TypeDescriptor<?> inferType() throws VilException {
        TypeDescriptor<?> result;
        if (null == body || 0 == body.length) {
            result = TypeRegistry.voidType();
        } else {
            result = body[body.length - 1].inferType();
        }
        return result;
    }

}
