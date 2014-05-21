package de.uni_hildesheim.sse.utils.modelManagement;

/**
 * Defines a model listener in order to inform interested parties about
 * changes within a model instance. Currently, this class does only notify
 * about the internal replacement of an entire model instance as the editor
 * does not support incremental model updates.
 * 
 * @param <M> the model
 * 
 * @author Holger Eichelberger
 */
public interface IModelListener<M extends IModel> {

    /**
     * Is called to notify that <code>oldModel</code> is replaced by 
     * <code>newModel</code>. The listener registrations for 
     * <code>oldModel</code> will be adjusted accordingly.<br/>
     * Do not modify the the listeners of <code>oldModel</code> or <code>newModel</code>
     * during this method.
     * 
     * @param oldModel the old model being replaced
     * @param newModel the new model (the replacement)
     */
    public void notifyReplaced(M oldModel, M newModel);
    
}
