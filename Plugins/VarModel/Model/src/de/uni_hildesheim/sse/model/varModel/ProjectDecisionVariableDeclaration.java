package de.uni_hildesheim.sse.model.varModel;

import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;

/**
 * Facilitates attribute propagation to parent project.
 * 
 * @author Holger Eichelberger
 */
class ProjectDecisionVariableDeclaration extends DecisionVariableDeclaration {
    
    /**
     * Constructor for decision variable declaration.
     * @param name Name of the decision variable declaration
     * @param type type of the new VariableDeclaration
     * @param parent the object, in which this specific one is embedded
     */
    public ProjectDecisionVariableDeclaration(String name, IDatatype type, ModelElement parent) {
        super(name, type, parent);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean attribute(Attribute attribute) {
        return super.attribute(attribute) && getParent().propagateAttribute(attribute);
    }
    
}