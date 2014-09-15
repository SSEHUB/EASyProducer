/*
 * #if($controlling_controllertype == "DistanceEController")
 */
package simulator.controllers;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;

import simulator.model.Elevator;
import simulator.model.Target;

/**
 * Diese Klasse beschreibt einen Fahrstuhlcontroller, der
 * die Entfernung zwischen Stockwerken miteinbezieht und
 * sich nicht an der Fahrtrichtung orientiert. &Uuml;ber ein Priorit&auml;tensystem
 * wird sichergestellt, dass kein Fahrtwunsch ignoriert wird.
 */
public class DistanceEController extends AbstractController {
	private int iTravelledDistance = 0;
	private int iPriorityThreshold;
	

	public DistanceEController(int index, int iFloors) {
		super(index);
		eElevator = new Elevator();
		lTargetList = new ArrayList<Target>();
		lIgnoreList = new ArrayList<Boolean>();
		iPriorityThreshold = iFloors / 2;
		clqPriorityQueue = new ConcurrentLinkedQueue<Target>();
		for (int i = 0; i <= iFloors; i++) {
			lTargetList.add(null);
			lIgnoreList.add(false);
		}
		currentTarget = null;

	}

	@Override
	public boolean simulate() {
		synchronized (lTargetList) {
			
			processDeletions();

			if (!clqPriorityQueue.isEmpty() && !hasPriorityCall) {
				processPriorityCall();
			}

			if (eElevator.getCurrentFloor() + eElevator.getDirection() <= lTargetList.size()
					&& eElevator.getCurrentFloor() + eElevator.getDirection() >= 0) {

				eElevator.setCurrentFloor(eElevator.getCurrentFloor()
						+ eElevator.getDirection());
				iTravelledDistance++;
			}

			boolean targetFound = currentTarget != null
					&& eElevator.getCurrentFloor() == currentTarget.getFloor();

			if (eElevator.getDirection() != 0 || bSameFloor) {
				bSameFloor = false;

				if (targetFound) {

					lTargetList.set(currentTarget.getFloor(), null);
					currentTarget = null;
					/*
					 * Überprüfen, ob es sich um einen PriorityCall handelte und
					 * ob noch weitere vorliegen
					 */
					if (hasPriorityCall && clqPriorityQueue.isEmpty()) {
						hasPriorityCall = false;
					} else if (!clqPriorityQueue.isEmpty()) {
						processPriorityCall();
					}

					for (int i = 0; i < lTargetList.size(); i++) {
						if (lTargetList.get(i) != null) {
							lTargetList.get(i).calculatePriority(
									iTravelledDistance);
						}
					}
					updateTargetByPriority();

					// wenn in der anderen Richtung kein weiteres Ziel vorhanden
					// ist, dann warten
					if (currentTarget == null) {
						eElevator.setDirection(0);
					}
					iTravelledDistance = 0;
				}

			}

			return targetFound;
		}
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
				bSameFloor = false;
				if (target.getFloor() > eElevator.getCurrentFloor()) {
					eElevator.setDirection(1);
				} else if (target.getFloor() < eElevator.getCurrentFloor()) {
					eElevator.setDirection(-1);
				} else {
					bSameFloor = true;
				}
			}

			// Prioritäten aktualisieren
			for (int i = 0; i < lTargetList.size(); i++) {
				if (lTargetList.get(i) != null && i != target.getFloor()) {
					lTargetList.get(i).calculatePriority(iTravelledDistance);
				}
			}
			iTravelledDistance = 0;
			
			// wenn es kein Ziel gibt, dann dieses Stockwerk als Ziel setzen, damit
			// der Fahrstuhl startet
			if(currentTarget == null) {
				currentTarget = target;
				
			// sonst updateNecessary auf true setzen, damit das Ziel nach einem Schritt
			// des Fahrstuhls aktualisiert wird 
			} else {
				updateNecessary = true;
			}
			startSimulation();
		}
	}

	@Override
	public boolean updateTarget() {
			updateNecessary = false;
			// nächstes Ziel zwischen aktuellem Stockwerk und aktuellem Ziel
			// suchen,
			// falls vorhanden
			if(!hasPriorityCall) {
				if (currentTarget == null) {
					for (int i = 0; i < lTargetList.size(); i++) {
						if (lTargetList.get(i) != null) {
							currentTarget = lTargetList.get(i);
							return true;
						}
					}
				} else {
					return updateTargetByPriority();
				}
			}

			return false;

	}


	/**
	 * Es wird das neue Zielstockwerk gesucht. Dabei wird die Priorit&auml;t
	 * jedes Stockwerks miteinbezogen, damit keins ausgelassen wird. Beim
	 * &Uuml;berschreiten des PriorityThresholds wird das Target mit der
	 * gr&ouml;ssten &Uuml;berschreitung angew&auml;hlt.
	 * 
	 * @return true, wenn ein Ziel gefunden wurde, sonst false
	 */
	public boolean updateTargetByPriority() {
		synchronized (lTargetList) {
			Target bestPriority = null;
			// Ziel mit der höchsten Priorität über der Schwelle finden
			for (int i = 0; i < lTargetList.size(); i++) {

				if (lTargetList.get(i) != null
						&& lTargetList.get(i).getPriority() >= iPriorityThreshold) {

					if (bestPriority == null
							|| lTargetList.get(i).getPriority() > bestPriority
									.getPriority()) {
						bestPriority = lTargetList.get(i);
					}
				}
			}

			// Wenn Ziel über Schwelle gefunden wurde, dann als nächstes Ziel
			// setzen
			// und true zurückgeben
			if (bestPriority != null) {
				currentTarget = bestPriority;

				if (eElevator.getCurrentFloor() < bestPriority.getFloor()) {
					eElevator.setDirection(1);
				} else if (eElevator.getCurrentFloor() > bestPriority
						.getFloor()) {
					eElevator.setDirection(-1);
				}

				return true;

				// sonst nächstes Ziel wählen (Distanz)
			} else {
				int down;
				int up;
				for (int i = 1; i < lTargetList.size(); i++) {
					down = eElevator.getCurrentFloor() - i;
					up = eElevator.getCurrentFloor() + i;

					// oberhalb vom aktuellen Stockwerk prüfen, ob Ziel
					// vorhanden
					if (up < lTargetList.size() && lTargetList.get(up) != null) {
						currentTarget = lTargetList.get(up);
						eElevator.setDirection(1);
						return true;
					}

					// unterhalb vom aktuellen Stockwerk prüfen, ob Ziel
					// vorhanden
					if (down >= 0 && lTargetList.get(down) != null) {
						currentTarget = lTargetList.get(down);
						eElevator.setDirection(-1);
						return true;
					}
				}
				return false;
			}
		}

	}

	/**
	 * 
	 * @return iTravelledDistance
	 */
	public int getiTravelledDistance() {
		return iTravelledDistance;
	}

//	@Override
//	public void deleteCall(int iFloor) {
//		synchronized (lTargetList) {
//			if (currentTarget == lTargetList.get(iFloor)) {
//				lTargetList.set(iFloor, null);
//				currentTarget = null;
//				updateTarget();
//			} else {
//				lTargetList.set(iFloor, null);
//			}
//		}
//	}
	

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
	
	@Override
	public void processDeletions(){
		synchronized (lTargetList) {
			while(!clqDeletionQueue.isEmpty()) {
				Integer iDelFloor = clqDeletionQueue.poll();
				
				if (currentTarget == lTargetList.get(iDelFloor)) {
					
					lTargetList.set(iDelFloor, null);
					currentTarget = null;
					
					if(updateTargetByPriority()) {
						eElevator.setCurrentFloor(eElevator.getCurrentFloor() + (- eElevator.getDirection()));
						eElevator.setCurrentFloor(eElevator.getCurrentFloor() + (- eElevator.getDirection()));
					} else {
						eElevator.setCurrentFloor(eElevator.getCurrentFloor() + eElevator.getDirection());
						eElevator.setDirection(0);
					}
					
				} else {
					lTargetList.set(iDelFloor, null);
				}
			}

		}
	}

	@Override
	public void doAfterAnimate() {
		
	}

	@Override
	public boolean updateTarget(int iDir, boolean bAttendTargetDir) {
		return false;
	}
}
/*
 * #end
 */