package de.uni_hildesheim.sse.easy_producer.core.mgmt;

import java.util.Observable;

/**
 * Parent-class for all controller-classes. Every controller which changes the model should inherit this class to make
 * it observable.
 * 
 * @author Kapeluch
 */
public abstract class Controller extends Observable {

    /**
     * Notifies all observers.
     */
    public void changed() {
        setChanged();
        notifyObservers();
    }

    /**
     * Overloaded method for notification including the comparison of old and new value. Notification will only be
     * applied if newValue differs from oldValue.
     * 
     * @param oldValue The old value (before a change is done).
     * @param newValue The new value
     * (should differ from the oldValue, otherwise this method will no fire a change event).
     */
    public void changed(Object oldValue, Object newValue) {
        if (oldValue == null || newValue == null) {
            if (oldValue != newValue) {
                changed();
            }
        } else {
            if (!oldValue.equals(newValue)) {
                changed();
            }
        }
    }
}
