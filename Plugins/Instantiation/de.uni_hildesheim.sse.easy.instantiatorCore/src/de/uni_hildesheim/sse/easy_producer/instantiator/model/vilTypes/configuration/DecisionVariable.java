package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration;

import java.util.ArrayList;
import java.util.List;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArraySet;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationMeta;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Set;
import de.uni_hildesheim.sse.model.confModel.AssignmentState;
import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;

/**
 * Realizes the bridge to the decision variables.
 * 
 * @author Holger Eichelberger
 */
public class DecisionVariable extends AbstractIvmlVariable {

    private Attribute[] attributes;
    
    /**
     * Creates a decision variable.
     * 
     * @param variable the underlying IVML variable
     */
    DecisionVariable(IDecisionVariable variable) {
        super(variable);
    }
    
    @Override
    protected void initializeAttributes() {
        if (null == attributes && variable.getAttributesCount() > 0) {
            List<Attribute> tmp = new ArrayList<Attribute>();
            for (int a = 0; a < variable.getAttributesCount(); a++) {
                IDecisionVariable attribute = variable.getAttribute(a);
                if (AssignmentState.FROZEN == attribute.getState()) {
                    tmp.add(new Attribute(attribute));
                }
            }
            attributes = new Attribute[tmp.size()];
            tmp.toArray(attributes);
        }
    }

    @Override
    @OperationMeta(returnGenerics = { Attribute.class } )
    public Set<Attribute> attributes() {
        initializeAttributes();
        return new ArraySet<Attribute>(attributes, Attribute.class);
    }
    
    /**
     * Returns the specified attribute.
     * 
     * @param index the 0-based index of the attribute to return
     * @return the specified attribute
     * @throws IndexOutOfBoundsException if <code>index &lt; 0 || index &gt;= {@link #getAttributeCount()}</code>
     */
    Attribute getAttribute(int index) {
        initializeAttributes();
        if (null == attributes) {
            throw new IndexOutOfBoundsException();
        }
        return attributes[index];
    }
    
    /**
     * Returns the number of attributes.
     * 
     * @return the number of attributes
     */
    int getAttributeCount() {
        initializeAttributes();
        return null == attributes ? 0 : attributes.length; 
    }
    
}
