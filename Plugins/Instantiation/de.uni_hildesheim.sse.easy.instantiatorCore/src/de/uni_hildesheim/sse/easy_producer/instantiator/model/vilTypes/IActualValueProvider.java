package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes;

/**
 * VIL types implementing this interface may provide a more actual value of an object, 
 * e.g., during value assignment in the {@link de.uni_hildesheim.sse.easy_producer.instantiator.model.
 * buildlangModel.RuntimeEnvironment}. <br/>
 * Default types implementing this interface shall not use 
 * their attributes as this method will be called via a template object and, thus, must implement a 
 * (not-necessarily accessible) no-argument constructor.
 * 
 * @author Holger Eichelberger
 */
public interface IActualValueProvider {

    /**
     * Determines a more actual value for <code>object</code> in the context of using it for <b>this</b> type.
     * Default types implementing this interface shall not use 
     * their attributes as this method will be called via a template object.
     * 
     * @param object the initial object (may be <b>null</b>)
     * @return the actual object (may be <code>object</code> if no actual value is available, may be <b>null</b> if
     *   <code>object</code> was null)
     */
    public Object determineActualValue(Object object);
    
}
