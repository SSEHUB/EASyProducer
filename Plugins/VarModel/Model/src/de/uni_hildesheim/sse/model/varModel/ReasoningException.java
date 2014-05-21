package de.uni_hildesheim.sse.model.varModel;
/**
 * An exception class for all reasoning exceptions.
 * 
 * @author Patrick Jähne
 */
@SuppressWarnings("serial")
public abstract class ReasoningException extends IvmlException {

    // TODO HE: please note that the VarModel throws its own exception
    //      type and it is already used within the IVML editor - additional
    //      exceptions may break the editor. Further, the resolution mechanism
    //      is intended to collect all messages so that the caller can decide
    //      how to proceed with them (integration with Eclipse error mechanism).
    //      If this exception is intended to be a common exception for reasoning 
    //      (reasoning infrastructure), then please define this exception there
    //      as the model does not do any reasoning ;)
    
    /**
     * * Create a new exception based on the given message.
     * 
     * @param message the message
     * @param code a code detailing the exception
     */
    public ReasoningException(String message, int code) {
        super(message, code);
        // TODO Auto-generated constructor stub
    }

}
