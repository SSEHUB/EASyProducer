package de.uni_hildesheim.sse.easy_producer.instantiator;

/**
 * Delegate interface for the transformator.
 * 
 * @author gewalt
 * @author gawenda
 * 
 */
public interface TranformatorNotificationDelegate {

    /**
     * Method is called at the delegate when the transformer did finish.
     */
    public void tranformatorDidFinish();

    /**
     * Method is called when the transformer start the transform process.
     * 
     * @param numberOfFiles the number of files in the repository.
     */
    public void tranformatorDidStart(int numberOfFiles);

    /**
     * This method is to reset the progress when multiple Instantiators are used for the same project.
     * @param numberOfFiles The number of files which are transformed in the current step.
     */
    public void transformatorDidFinishInQueue(int numberOfFiles);
    
    /**
     * Method is called when an error occurred during the instantiation.
     * @param message   The error message
     */
    public void transformatorDidFail(String message);

    /**
     * This method should be preferred over a direct call of the EASy-Producer dialogs from the instantiator management
     * to enforce a clean seperation of UI and data.
     * 
     * @param message the message for the dialog
     */
    public void showInfoDialog(String message);
}
