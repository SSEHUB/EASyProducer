package de.uni_hildesheim.sse.easy.adaptation.events;

/**
 * Just a basic (optional) abstract implementation of the adaptation event interface.
 * 
 * @author Holger Eichelberger
 * */
public abstract class AbstractAdaptationEvent implements IAdaptationEvent {

    private Object source;
    
    /**
     * Creates an adaptation event.
     * 
     * @param source the event source
     */
    protected AbstractAdaptationEvent(Object source) {
        this.source = source;
    }
    
    @Override
    public Object getSource() {
        return source;
    }
    
}
