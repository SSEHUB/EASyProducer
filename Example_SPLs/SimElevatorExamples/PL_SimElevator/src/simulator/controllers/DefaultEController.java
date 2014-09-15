/*
 * #if($controlling_controllertype == "DefaultEController")
 */
package simulator.controllers;

import simulator.model.Target;

/**
 * Diese Klasse ist unser Default Controller zur Steuerung einer
 * Elevator-Instanz.
 */
public class DefaultEController extends AbstractController {

	/**
	 * &Uuml;berladener Konstruktor
	 * 
	 * @param iFloors - Anzahl der Stockwerke, wird &uuml;ber das GUI eingestellt
	 * @param iSpeed - Geschwindigkeit des Fahrstuhl, wird &uuml;ber das GUI eingestellt
	 * @param iWaiting - Wie lange die T&uuml;ren bei dem Erreichen eines Ziels offen
	 *        bleiben wird &uuml;ber das GUI eingestellt
	 */
	public DefaultEController(int index, int iFloors) {
		super(index);
		for (int i = 0; i <= iFloors; i++) {
			lTargetList.add(null);
			lIgnoreList.add(false);
		}
		
	}

	/**
	 * startet die Simulation
	 */
	@Override
	public boolean simulate() {
		synchronized (lTargetList) {
			
			// Verarbeitung der Stornierungen
			processDeletions();
			
			// Verarbeitung eines PriorityCalls.
			if (!clqPriorityQueue.isEmpty() && !hasPriorityCall) {
				processPriorityCall();
			}

			// Bewegt werden darf der Fahrstuhl nur, wenn er im Rahmen des
			// Schachtes bleibt
			if (eElevator.getCurrentFloor() + eElevator.getDirection() <= lTargetList.size()
					&& eElevator.getCurrentFloor() + eElevator.getDirection() >= 0) {
				eElevator.setCurrentFloor(eElevator.getCurrentFloor()
						+ eElevator.getDirection());
			}

			if (eElevator.getDirection() != 0 || bSameFloor) {
				bSameFloor = false;
			}

			return currentTarget != null
					&& eElevator.getCurrentFloor() == currentTarget.getFloor()
					|| bSameFloor;
		}
	}

	@Override
	public void doAfterAnimate() {
		//synchronized (lTargetList) {
			processDeletions();

			lTargetList.set(currentTarget.getFloor(), null);
			currentTarget = null;
			if (hasPriorityCall && clqPriorityQueue.isEmpty()) {
				hasPriorityCall = false;
			} else if (!clqPriorityQueue.isEmpty()) {
				processPriorityCall();
			}
			
			// neues Ziel in Fahrtrichtung suchen. Erst mit Beachtung der Richtung des Ziels und
			// dann ohne, da sonst Ziele evtl. nicht angefahren werden
			if (!hasPriorityCall && (!updateTarget(eElevator.getDirection(), true) 
					&& !updateTarget(eElevator.getDirection(), false))) {

				eElevator.setDirection(eElevator.getDirection() * -1);
				// wenn auch in der anderen Richtung kein weiteres Ziel vorhanden
				// ist, dann warten
				if (!updateTarget(eElevator.getDirection(), true) 
						&& !updateTarget(eElevator.getDirection(), false)) {
					eElevator.setDirection(0);
				}
			}
		//}
	}

	
	@Override
	public void addFloor(Target target) {
		synchronized (lTargetList) {
			ControllerListener.notifyAllFloorSelected(target);
			if (lTargetList.get(target.getFloor()) == null) {
				lTargetList.set(target.getFloor(), target);
			}

			// falls der Fahrstuhl kein Ziel hat, dann muss die Richtung neu
			// ermittelt werden
			if (eElevator.getDirection() == 0) {
				// bSameFloor = false;
				if (target.getFloor() > eElevator.getCurrentFloor()) {
					eElevator.setDirection(1);
				} else if (target.getFloor() < eElevator.getCurrentFloor()) {
					eElevator.setDirection(-1);
				} else {
					bSameFloor = true;
					if (currentTarget == null) {
						currentTarget = target;
						return;
					}
				}
			}

			// Fahrtwunsch in Fahrtrichtung suchen, desses Richtungswunsch der Fahrtrichtung
			// entspricht, falls Ziel nicht gerade erreicht wurde
			if(currentTarget == null || currentTarget.getFloor() != eElevator.getCurrentFloor()) {
				if (target.getFloor() != eElevator.getCurrentFloor()
						&& !hasPriorityCall && !updateTarget(eElevator.getDirection(), true)) {
					
					// falls kein Ziel gefunden wurde, dann Ziel in Fahrtrichtung ohne Beachtung
					// des Richtungswunsches suchen
					updateTarget(eElevator.getDirection(), false);

					// wenn noch immer kein Ziel gefunden wurde, dann in entgegengesetzter Richtung
					// ohne Beachtung der Target-Direction suchen
					if (currentTarget == null) {
						updateTarget(eElevator.getDirection() * -1, false);
					}
				}
			}
			startSimulation();
		}
	}

	@Override
	public boolean updateTarget(int iDir, boolean bAttendTargetDir) {
		synchronized (lTargetList) {
			
			// Target vom aktuellen Stockwerk bis Erdgeschoss oder Dach suchen
			// abhängig von der Richtung iDir
			for (int i = eElevator.getCurrentFloor(); i < lTargetList.size()
					&& i >= 0 && eElevator.getDirection() != 0; i += iDir) {
				
				if(bAttendTargetDir) {
					
					if (lTargetList.get(i) != null
							&& ((lTargetList.get(i).getiDirection() == eElevator
									.getDirection()) || lTargetList.get(i)
									.getiDirection() == 0)) {

						currentTarget = lTargetList.get(i);
						return true;
					}
					
				} else {
					
					if (lTargetList.get(i) != null) {
						currentTarget = lTargetList.get(i);
						return true;
					}
					
				}
				
			}

			return false;
		}
	}

	@Override
	public void processPriorityCall() {
		hasPriorityCall = true;

		currentTarget = clqPriorityQueue.poll();

		if (currentTarget.getFloor() > eElevator.getCurrentFloor()) {
			eElevator.setDirection(1);
		} else if (currentTarget.getFloor() < eElevator.getCurrentFloor()) {
			eElevator.setDirection(-1);
		} else {
			bSameFloor = true;
		}
	}
	
	
	public void processDeletions(){
		synchronized (lTargetList) {
			while(!clqDeletionQueue.isEmpty()) {
				Integer iDelFloor = clqDeletionQueue.poll();
				
				if (currentTarget == lTargetList.get(iDelFloor)) {
					
					lTargetList.set(iDelFloor, null);
					currentTarget = null;
					
					// Ziele in beiden Richtungen suchen
					if (!updateTarget(eElevator.getDirection(), true)) {
						
						if(updateTarget(eElevator.getDirection() * -1, true)) {
							eElevator.setCurrentFloor(eElevator.getCurrentFloor() + eElevator.getDirection());
							eElevator.setCurrentFloor(eElevator.getCurrentFloor() + eElevator.getDirection());
							eElevator.setDirection(eElevator.getDirection() * -1);
						} else {
							eElevator.setCurrentFloor(eElevator.getCurrentFloor() + eElevator.getDirection());
							eElevator.setDirection(0);
						}

					}
					//updateTarget(eElevator.getDirection(), true);
				} else {
					lTargetList.set(iDelFloor, null);
				}
			}

		}
	}
	
	public boolean updateTarget() {
		return false;
	}
}
/*
 * #end
 */