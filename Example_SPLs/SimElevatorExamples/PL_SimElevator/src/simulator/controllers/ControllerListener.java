package simulator.controllers;

import java.util.ArrayList;
import java.util.List;

import simulator.model.Target;

/**
 * A controller listener. Informs interested parties about updates in the controllers.
 */
public abstract class ControllerListener {

	private static final List<ControllerListener> LISTENERS = new ArrayList<ControllerListener>();
	
	/**
	 * Is called when a floor is selected.
	 * 
	 * @param target the selected target
	 */
	public abstract void notifyFloorSelected(Target target);
	
	/**
	 * Notifies all listeners about a selected floor target.
	 * 
	 * @param target the selected target
	 */
	public static void notifyAllFloorSelected(Target target) {
		for (int l = 0; l < LISTENERS.size(); l++) {
			LISTENERS.get(l).notifyFloorSelected(target);
		}
	}

	/**
	 * Adds a given listener.
	 * 
	 * @param listener the listener to be added
	 */
	public static void addListener(ControllerListener listener) {
		if (null != listener && !LISTENERS.contains(listener)) {
			LISTENERS.add(listener);
		}
	}
	
	/**
	 * Removes a given listener.
	 * 
	 * @param listener the listener to be removed
	 */
	public static void removeListener(ControllerListener listener) {
		if (null != listener) {
			LISTENERS.remove(listener);
		}
	}
	
}
