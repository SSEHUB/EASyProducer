package de.uni_hildesheim.sse.easy.adaptation.events;

/**
 * Defines the basic interface for an adaptation event, i.e., an event that may cause an 
 * adaptation such as a regular schedule or an event issued by monitoring/analysis. Specific
 * interfaces must be registered via {@link AbstractAdaptationManager#registerAdaptationEvent(Class)}.
 * 
 * @author Holger Eichelberger
 */
public interface IAdaptationEvent {

    /**
     * The source of this event (for avoiding event cycles).
     * 
     * @return the event source
     */
    public Object getSource();
    
}
