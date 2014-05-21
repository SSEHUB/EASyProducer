package de.uni_hildesheim.sse.easy_producer.instantiator.velocity;

import org.osgi.service.component.ComponentContext;

import de.uni_hildesheim.sse.easy_producer.instantiator.Transformator;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;
import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;
import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.values.StringValue;

/**
 * The velocity transformator engine implementation.
 * 
 * @author gewalt
 * @author ahrens
 * @author El-Sharkawy
 * @author reller
 * @author Kapeluch
 * @author gawenda
 * 
 */
public class VelocityTransformatorEngine extends AbstractVelocityIntantiatorEngine {
   
    public VelocityTransformatorEngine() {
        // required by DS
    }
    
    /**
     * Private method to activate plugin.
     * @param context Context.
     */
    protected void activate(ComponentContext context) {
        Transformator.addEngine(this);
        TypeRegistry.DEFAULT.register(VelocityInstantiator.class);
    }

    /**
     * Private method to to de-activate plugin.
     * @param context Context.
     */
    protected void deactivate(ComponentContext context) {
        // this is not the official way of using DS but the official way is instable
        Transformator.removeEngine(this);
    }
    
    @Override
    protected void addStringValue2Context(IDecisionVariable stringVariable) {
        AbstractVariable declaration = stringVariable.getDeclaration();
        StringValue value = (StringValue) stringVariable.getValue();
        
        getVelocityContext().put(declaration.getName(), value.getValue());
    }

}
