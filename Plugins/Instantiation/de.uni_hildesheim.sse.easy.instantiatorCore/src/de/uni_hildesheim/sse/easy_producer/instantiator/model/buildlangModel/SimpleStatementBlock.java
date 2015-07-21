package de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;

/**
 * Represents a simple statement as block (without brackets).
 * 
 * @author Holger Eichelberger
 */
public class SimpleStatementBlock implements IRuleBlock {

    private IRuleElement element;

    /**
     * Creates a simple statement block.
     * 
     * @param element the element that constitutes the block
     */
    public SimpleStatementBlock(IRuleElement element) {
        this.element = element;
    }
    
    @Override
    public int getBodyElementCount() {
        return 1;
    }

    @Override
    public IRuleElement getBodyElement(int index) {
        if (0 == index) {
            return element;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public boolean isVirtual() {
        return true;
    }
    
    @Override
    public void addBodyElement(int index, IRuleElement element) throws VilException {
        throw new VilException("cannot add to a simple statement", VilException.ID_INTERNAL);
    }

}
