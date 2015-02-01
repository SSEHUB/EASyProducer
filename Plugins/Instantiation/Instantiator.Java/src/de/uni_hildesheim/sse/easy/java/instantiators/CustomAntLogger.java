/**
 * 
 */
package de.uni_hildesheim.sse.easy.java.instantiators;


import java.io.PrintStream;
import java.util.HashMap;


import org.apache.tools.ant.BuildEvent;
import org.apache.tools.ant.BuildLogger;

/**
 * ANT-Message Handler. 
 * 
 * @author Sebastian Bender
 */
public class CustomAntLogger implements BuildLogger {
    
    private HashMap<Integer, String> messages;
    
    /**
     * Creates a custom ANT logger.
     */
    CustomAntLogger() {
        super();
        messages = new HashMap<Integer, String>();
    }

    @Override
    public void messageLogged(BuildEvent event) {
        messages.put(event.getPriority(), event.getMessage());        
    }
    
    /**
     * Returns the collected errors.
     * 
     * @return the errors
     */
    public HashMap<Integer, String> getMessages() {
        return messages;
    }


    /**
     * Defines the errors to be set.
     * 
     * @param errors the errors to set
     */
    public void setMessages(HashMap<Integer, String> errors) {
        this.messages = errors;
    }

    @Override
    public void buildFinished(BuildEvent event) {        
    }

    @Override
    public void buildStarted(BuildEvent event) {        
    }
    
    @Override
    public void targetFinished(BuildEvent event) {        
    }
    
    @Override
    public void targetStarted(BuildEvent event) {        
    }
    
    @Override
    public void taskFinished(BuildEvent event) {        
    }

    @Override
    public void taskStarted(BuildEvent event) {        
    }
    
    @Override
    public void setEmacsMode(boolean emacs) {
    }

    @Override
    public void setErrorPrintStream(PrintStream stream) {        
    }

    @Override
    public void setMessageOutputLevel(int level) {
    }

    @Override
    public void setOutputPrintStream(PrintStream stream) {        
    }
    
}
