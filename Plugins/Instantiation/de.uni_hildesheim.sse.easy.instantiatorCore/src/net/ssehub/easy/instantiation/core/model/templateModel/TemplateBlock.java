package net.ssehub.easy.instantiation.core.model.templateModel;

import net.ssehub.easy.instantiation.core.model.common.ILanguageElement;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;

/**
 * Implements a template block.
 * 
 * @author Holger Eichelberger
 */
public class TemplateBlock extends AbstractTemplateElement {

    private ITemplateElement[] body;

    /**
     * Constructor for serialization.
     */ 
    TemplateBlock() {
    }
    
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
        ITemplateElement last = getTypeDefiningElement();
        if (null == last) {
            result = TypeRegistry.voidType();
        } else {
            result = last.inferType();
        }
        return result;
    }

    /**
     * Returns the type-defining body element.
     *  
     * @return the type-defining body element
     */
    protected ITemplateElement getTypeDefiningElement() {
        ITemplateElement result;
        if (null == body || 0 == body.length) {
            result = null;
        } else {
            result = body[body.length - 1];
        }
        return result;
    }

    @Override
    protected void setParent(ILanguageElement parent) {
        super.setParent(parent);
        if (null != body) {
            for (int b = 0; b < getBodyElementCount(); b++) {
                ITemplateLangElement elt = getBodyElement(b);
                if (elt instanceof AbstractTemplateElement) {
                    ((AbstractTemplateElement) elt).setParent(this);
                }
            }
        }
    }

    @Override
    public boolean endsWithContentStatement() {
        ITemplateElement elt = getTypeDefiningElement();
        return null != elt && elt.endsWithContentStatement();
    }

}
