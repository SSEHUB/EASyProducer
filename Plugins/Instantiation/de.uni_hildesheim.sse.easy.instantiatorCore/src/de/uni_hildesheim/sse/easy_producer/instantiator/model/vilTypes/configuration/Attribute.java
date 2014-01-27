package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArraySequence;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArraySet;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Invisible;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Sequence;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Set;
import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;

/**
 * Represents an attribute from a variability model imported into VIL.
 * 
 * @author Holger Eichelberger
 */
public class Attribute extends AbstractIvmlVariable {
    
    /**
     * Creates a new attribute instance.
     * 
     * @param attribute the IVML attribute
     */
    Attribute(IDecisionVariable attribute) {
        super(attribute);
    }

    @Override
    protected void initializeAttributes() {
        // has no attributes
    }
    
    /**
     * Returns the specified attribute.
     * 
     * @param index the 0-based index of the attribute to return
     * @return the specified attribute
     * @throws IndexOutOfBoundsException if <code>index &lt; 0 || index &gt;= {@link #getAttributeCount()}</code>
     */
    Attribute getAttribute(int index) {
        throw new IndexOutOfBoundsException();
    }
    
    /**
     * Returns the number of attributes.
     * 
     * @return the number of attributes
     */
    int getAttributeCount() {
        return 0;
    }

    @Invisible
    @Override
    public Sequence<DecisionVariable> variables() {
        return ArraySequence.empty(DecisionVariable.class);
    }

    @Invisible
    @Override
    public Set<Attribute> attributes() {
        return ArraySet.empty(DecisionVariable.class);
    }

}
