package de.uni_hildesheim.sse.dslCore;

import java.util.ArrayList;
import java.util.List;

import de.uni_hildesheim.sse.dslCore.translation.Message;
import de.uni_hildesheim.sse.dslCore.translation.MessageReceiver;
import de.uni_hildesheim.sse.utils.messages.IMessage;

/**
 * Represents the result of a translation.
 * 
 * @param <R> the top-level result model class
 * 
 * @author Holger Eichelberger
 */
public class TranslationResult <R> {

    /**
     * Stores an instance which provides access to the messages which
     * occurred during the model translation.
     */
    private MessageReceiver receiver;

    /**
     * Stores the created language units / models.
     */
    private List<R> results;
    
    /**
     * Creates an instance of this class.
     * 
     * @param results the resulting language units (pass in only instances created for
     *        this result)
     * @param receiver the message receiver providing access to translation
     *        messages
     */
    public TranslationResult(List<R> results, MessageReceiver receiver) {
        this.receiver = receiver;
        this.results = results;
    }

    /**
     * Returns the number of messages.
     * 
     * @return the number of messages
     */
    public int getMessageCount() {
        return receiver.getMessageCount();
    }
    
    /**
     * Returns the number of errors among the messages.
     * 
     * @return the number of errors
     */
    public int getErrorCount() {
        return receiver.getErrorCount();
    }

    /**
     * Returns the specified message.
     * 
     * @param index
     *            the position of the message to be returned
     * @return the specified message
     * @throws IndexOutOfBoundsException
     *             if
     *             <code>index&lt;0 || index&gt;={@link #getMessageCount()}</code>
     */
    public Message getMessage(int index) {
        return receiver.getMessage(index);
    }

    /**
     * Returns the list of messages (using the more common type).
     * 
     * @return the list of messages
     */
    public List<IMessage> getMessageList() {
        List<IMessage> result;
        int count = getMessageCount();
        if (count > 0) {
            result = new ArrayList<IMessage>(count);
            for (int m = 0; m < count; m++) {
                result.add(getMessage(m));
            }
        } else {
            result = null;
        }
        return result;
    }

    /**
     * Returns the list of messages.
     * 
     * @return the list of messages
     */
    public List<Message> getMessageListSpecific() {
        List<Message> result;
        int count = getMessageCount();
        if (count > 0) {
            result = new ArrayList<Message>(count);
            for (int m = 0; m < count; m++) {
                result.add(getMessage(m));
            }
        } else {
            result = null;
        }
        return result;
    }

    /**
     * Returns the number of projects being part of the result.
     * 
     * @return the number of projects
     */
    public int getResultCount() {
        return null == results ? 0 : results.size();
    }

    /**
     * Returns the specified result.
     * 
     * @param index the index of the result to be returned
     * @return the specified project
     * @throws IndexOutOfBoundsException if
     *         <code>index&lt;0 || index&gt;={@link #getResultCount()}</code>
     */
    public R getResult(int index) {
        if (null == results) {
            throw new IndexOutOfBoundsException();
        }
        return results.get(index);
    }

    /**
     * Returns a copy of the list of projects.
     * 
     * @return the list of projects
     */
    public List<R> getResultsList() {
        List<R> result = new ArrayList<R>();
        if (null != results) {
            result.addAll(results);
        }
        return result;
    }

}