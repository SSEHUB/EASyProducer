package de.uni_hildesheim.sse.reasoning.core.reasoner;

import java.util.ArrayList;
import java.util.List;

import de.uni_hildesheim.sse.model.varModel.ModelElement;
import de.uni_hildesheim.sse.utils.messages.Status;

/**
 * Part of the {@link ReasoningResult} class, expressing on error/warning of a complete {@link ReasoningResult}.
 * @author El-Sharkawy
 *
 */
public class Message extends de.uni_hildesheim.sse.utils.messages.Message {

    private List<ModelElement> conflictingElements;

    /**
     * Sole constructor for multiple conflicting elements.
     * @param explanation A textual representation of this message
     * @param conflictingElements A list of model elements which lead to the current message, or <tt>null</tt>
     * @param status The status of this message, e. g. Error or Warning
     */
    public Message(String explanation, List<ModelElement> conflictingElements, Status status) {
        super(explanation, status);

        // Avoid NullpointerExceptions
        this.conflictingElements = new ArrayList<ModelElement>();
        if (null != conflictingElements) {
            this.conflictingElements.addAll(conflictingElements);
        }
    }
    
    /**
     * Creates a list with on element. 
     * 
     * @param element the element to put into the list
     * @return the list with <code>element</code> as member if <code><b>null</b> != element</code>, <b>null</b> else
     */
    public static final List<ModelElement> createList(ModelElement element) {
        List<ModelElement> result;
        if (null != element) {
            result = new ArrayList<ModelElement>();
            result.add(element);
        } else {
            result = null;
        }
        return result;
    }

    /**
     * Returns the list of conflicting items.
     * @return The list of conflicting items
     */
    public List<ModelElement> getConflicts() {
        return conflictingElements;
    }
}
