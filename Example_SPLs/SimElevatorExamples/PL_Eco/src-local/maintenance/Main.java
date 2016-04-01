package maintenance;

import simulator.controllers.ControllerListener;

public class Main {
	
	public static void main(String[] args) {
		ControllerListener.addListener(new MaintenanceListener());
		main.Main.main(args);
	}

}
