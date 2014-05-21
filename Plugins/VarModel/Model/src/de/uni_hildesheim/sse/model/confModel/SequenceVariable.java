package de.uni_hildesheim.sse.model.confModel;

import de.uni_hildesheim.sse.model.varModel.AbstractVariable;

/**
 * Decision variable for <tt>Sequences</tt>s.
 * @author lueder
 * @author Holger Eichelberger
 */
public class SequenceVariable extends ContainerVariable {
    
    /**
     * Sole Constructor for this class.
     * @param varDecl the variable declaration for this variable
     * @param parent the parent of this set
     * @param isVisible Specifies whether this variables is exported by an interface or not:
     * <ul>
     * <li><tt>true</tt>: The variable is exported by an interface or there is no interface</li>.
     * <li><tt>false</tt>: There is an interface which does not export this variable</li>.
     * </ul>
     */
    public SequenceVariable(AbstractVariable varDecl, IConfigurationElement parent, boolean isVisible) {
        super(parent, varDecl, isVisible);
    }
    
    @Override
    protected String getElementName(int index) {
        return getDeclaration().getName() + " [" + String.valueOf(index) + "]";
    }
    
}
