package de.uni_hildesheim.sse.easy_producer.instantiator.dummyTransformator;

import org.osgi.service.component.ComponentContext;

import de.uni_hildesheim.sse.easy_producer.instantiator.InstantiatorEngine;
import de.uni_hildesheim.sse.easy_producer.instantiator.Transformator;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.BuiltIn;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.ExtensionClassLoaders;
import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;

/**
 * The dummy transformator engine implementation. This engine can be used to archieve multiple instantiation of the same
 * project with a simple workflow:
 * <ul>
 * <li>1. identify the productline that shall be instantiated multiple times</li>
 * <li>2. create a dummy-instantiator</li>
 * <li>3. derive as many new productlines like you want to instantiate</li>
 * <li>4. define every productline as a predecessor for the target productline</li>
 * </ul>
 * 
 * @author gawenda
 * 
 */
public class DummyTransformatorEngine extends InstantiatorEngine {
    
    /**
     * Private method to activate plugin.
     * @param context Context.
     */
    protected void activate(ComponentContext context) {
        // this is not the official way of using DS but the official way is instable
        Transformator.addEngine(this);
        BuiltIn.initialize(); // TODO preliminary position!!!
        ExtensionClassLoaders.registerLoader(getClass().getClassLoader());
    }

    /**
     * Private method to to de-activate plugin.
     * @param context Context.
     */
    protected void deactivate(ComponentContext context) {
        // this is not the official way of using DS but the official way is instable
        ExtensionClassLoaders.unregisterLoader(getClass().getClassLoader());
        Transformator.removeEngine(this);
    }

    @Override
    protected void initEngine() {
        // nothing to do here
    }

    @Override
    public void instantiate() {
        // nothing to do here
    }

    @Override
    protected void addValue2Context(IDecisionVariable variable) {
        // nothing to do here
    }

    @Override
    protected void clearContext() {
        // nothing to do here
        
    }
}
