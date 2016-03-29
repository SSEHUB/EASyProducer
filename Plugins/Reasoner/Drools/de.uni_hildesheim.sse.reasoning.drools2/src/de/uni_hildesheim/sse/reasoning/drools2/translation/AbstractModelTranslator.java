package de.uni_hildesheim.sse.reasoning.drools2.translation;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import de.uni_hildesheim.sse.reasoning.drools2.DroolsReasonerDescriptor;
import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.reasoning.core.model.ReasonerModel;

/**
 * Abstract super class for the individual translator classes, which are responsible for the translation of the
 * {@link ReasonerModel} into drools specific code.
 * @author El-Sharkawy
 *
 */
abstract class AbstractModelTranslator {
    
    /**
     * Constant value for a line break between to translated elements.
     */
    protected static final String LINEBREAK = "\r\n";

    private static final EASyLogger LOGGER =
        EASyLoggerFactory.INSTANCE.getLogger(AbstractModelTranslator.class, DroolsReasonerDescriptor.BUNDLE_NAME);

    /**
     * The ID of the current reasoning task.
     */
    private String reasoningID;
    
    /**
     * The {@link ReasonerModel}, which should be translated for reasoning.
     */
    private ReasonerModel model;
    
    /**
     * The writer where the translated output should be written to.
     */
    private Writer writer;
    
    /**
     * Exceptions, which occurred during the translation.
     */
    private List<Exception> exceptions;
    
    /**
     * Sole constructor for this class.
     * @param model The {@link ReasonerModel}, which should be translated (must not be <tt>null</tt>).
     * @param writer The writer where the output shall be written to (must not be <tt>null</tt>).
     * @param reasoningID The unique ID of the current reasoning process.
     * @see de.uni_hildesheim.sse.reasoning.drools2.functions.FailedRules#createNewList(String)
     */
    protected AbstractModelTranslator(ReasonerModel model, Writer writer, String reasoningID) {
        this.model = model;
        this.writer = writer;
        this.reasoningID = reasoningID;
        exceptions = new ArrayList<Exception>();
    }
    
    /**
     * Getter for the {@link ReasonerModel}.
     * @return Returns the {@link ReasonerModel}, which should be translated.
     */
    protected ReasonerModel getModel() {
        return model;
    }
    
    /**
     * Getter for the writer.
     * @return Returns the writer, which is used for the translation.
     */
    protected Writer getWriter() {
        return writer;
    }
    
    /**
     * Returns the unique ID of the current reasoning process.
     * @return The unique ID of the current Reasoning process, as it could be used inside of the
     * {@link de.uni_hildesheim.sse.reasoning.drools2.functions.FailedRules} class.
     * @see de.uni_hildesheim.sse.reasoning.drools2.functions.FailedRules#createNewList(String)
     */
    protected final String getReasoningID() {
        return reasoningID;
    }
    
    /**
     * Adds an arbitrary string to the current transformation.
     * @param droolsCode The code which should be appended to the current translated code.
     */
    protected void append(String droolsCode) {
        try {
            writer.append(droolsCode);
        } catch (IOException exc) {
            addException(exc);
        }
    }
    
    /**
     * Adds an arbitrary text as comment to the current transformation.
     * @param comment A text, which should be added as a comment line.
     */
    protected void appendComment(String comment) {
        try {
            writer.append("// " + comment + LINEBREAK);
        } catch (IOException exc) {
            addException(exc);
        }
    }

    /**
     * Adds and exception to the list of exceptions.
     * This method should be called from each catch(Exception) block of the sub classes, to see whether an error
     * occurred during transformation or not.
     * @param exception The caught exception.
     */
    protected void addException(Exception exception) {
        exceptions.add(exception);
        LOGGER.exception(exception);
    }
    
    /**
     * Returns whether the errors occurred during transformation.
     * @return <tt>true</tt> if an {@link Exception} occurred during the transformation, <tt>false</tt> otherwise.
     */
    public boolean hasErrors() {
        return !exceptions.isEmpty();
    }
    
    /**
     * Copies the exceptions of another {@link AbstractModelTranslator}.
     * This method should only be used if an {@link AbstractModelTranslator}
     * used a nested {@link AbstractModelTranslator}.
     * @param nestedTranslator A nested {@link AbstractModelTranslator} which was used by this class.
     */
    protected final void copyAllExceptions(AbstractModelTranslator nestedTranslator) {
        exceptions.addAll(nestedTranslator.exceptions);
    }
    
    /**
     * Returns the number of caught exceptions.
     * @return The number of caught exceptions (0 or bigger).
     * @see #getException(int)
     */
    public int getExceptionCount() {
        return exceptions.size();
    }
    
    /**
     * Returns a caught exception.
     * @param index a 0-based index specifying which exception should be returned.
     * @return The exception as specified by the given index.
     * @throws IndexOutOfBoundsException if the index is out of range
     *     (<tt>index &lt; 0 || index &gt;= {@link #getExceptionCount()}</tt>)
     * @see #getExceptionCount()
     */
    public Exception getException(int index) {
        return exceptions.get(index);
    }
}
