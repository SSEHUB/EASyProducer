package maintenance;

import simulator.controllers.ControllerListener;
import simulator.model.Target;

public class MaintenanceListener extends ControllerListener {

	@Override
	public void notifyFloorSelected(Target target) {
		System.out.println("floor selected: " + target.getFloor() + " with priority " + target.getPriority()); 
	}

}
