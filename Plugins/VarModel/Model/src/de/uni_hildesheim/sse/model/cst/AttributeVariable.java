package de.uni_hildesheim.sse.model.cst;

import de.uni_hildesheim.sse.model.varModel.Attribute;

/**
 * A variable which represents an attribute. However, access to an attribute
 * may be qualified, e.g. via a {@link CompoundAccess}, i.e., <code>qualifier.attribute</code>
 * whereby qualifier may even be <code>c.a.attribute</code> of unlimited nesting. 
 * However, the attribute shall point to the original definition of the attribute
 * variable. This class is a (polymorphic)
 * subclass of {@link Variable} as it just adds an attribute (and helps saving
 * memory in case that the qualifying attribute is not needed).
 * 
 * @author Holger Eichelberger
 */
public class AttributeVariable extends Variable {

    private ConstraintSyntaxTree qualifier;
    
    /**
     * Creates an attribute variable.
     * 
     * @param qualifier an optional expression required to uniquely address the specific
     *   variable the <code>attribute</code> is referring to (may be <b>null</b>)
     * @param attribute the attribute (as variable)
     */
    public AttributeVariable(ConstraintSyntaxTree qualifier, Attribute attribute) {
        super(attribute);
        this.qualifier = qualifier;
    }

    /**
     * Returns the qualifier for accessing the variable, e.g., an expression
     * to be put before.
     * 
     * @return the qualifier (may be <b>null</b>)
     */
    @Override
    public ConstraintSyntaxTree getQualifier() {
        return qualifier;
    }
    
}
