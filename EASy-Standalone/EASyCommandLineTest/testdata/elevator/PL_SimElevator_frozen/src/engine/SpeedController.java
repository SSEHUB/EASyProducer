package engine;

import gui.buttons.DefaultButton;

import java.util.ArrayList;

import properties.ProgramSettings;
import simulator.model.Elevator;

public class SpeedController {


	public SpeedController() {
		
	}

	/**
	 * Diese Methode gibt den Speed an fuer die Beschleunigung.
	 * 
	 * @throws InterruptedException
	 */
	public void adaptSpeed(int iPos, Elevator elevator,
			ArrayList<DefaultButton> buttons) throws InterruptedException {

		/*
		 * wenn mehr als 2 Buttons auf dem Weg zum target ausgegraut sind, dann
		 * soll der fahrstuhl schneller fahren.
		 */

		// darueber wird der naechste Button ausgewaehlt
		// aktueller Button + iPlus
		int iPlus = elevator.getDirection();
		// damit keine IndexOutOfBouce Ex kommt, wird
		// iPlus null, falls anfang- oder endstockwerk.
		if (elevator.getCurrentFloor() <= 1
				|| (elevator.getCurrentFloor() == ProgramSettings.FLOORS)) {
			iPlus = 0;
		}

		int iSpeed = ProgramSettings.ELEVATORS_SPEED.getValue();
		boolean currentIgnored = buttons.get(elevator.getCurrentFloor())
				.isIgnored();
		boolean nextIgnored = buttons.get(elevator.getCurrentFloor() + iPlus)
				.isIgnored();
		boolean prevIgnored = buttons.get(Math.min(elevator.getCurrentFloor() - iPlus, ProgramSettings.ELEVATORS - 1))
				.isIgnored();
		
		int halfFloorHeight = ProgramSettings.FLOORS_HEIGHT;
		
		if (currentIgnored) {
			// wenn vorheriger nicht ignoriert, dann erste haelfte
			// schneller
			if (!prevIgnored) {
				// erste haelfte

				if (iPos <= halfFloorHeight) {
					// beschleunigen (entspricht geringer Verzögerung)
					Thread.sleep(iSpeed - Math.min(iSpeed, 2 * iPos));
				} else { 
					if (!nextIgnored && iPos > halfFloorHeight) {
						Thread.sleep(iSpeed + (2 * iPos));
					} else {
						Thread.sleep(40);
					}
					// sonst langsamer
				}
			} else {
				Thread.sleep(40);
			}

		} else if (!currentIgnored) {
			if (!nextIgnored) {
				Thread.sleep(iSpeed);
			} else {
				if(iPos > halfFloorHeight) {
					Thread.sleep(iSpeed + (2 * iPos));
				}
			}

		}
		
	}
}
