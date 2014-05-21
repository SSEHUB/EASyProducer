package simulator;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;

import simulator.controllers.AbstractController;
import simulator.model.Target;

/**
 * Der SuperController verwaltet die Fahrtw&uuml;nsche,
 * wenn mehrere Fahrst&uuml;hle synchron gesteuert werden sollen.
 * Ansonsten gibt er die Rufe einfach an die jeweiligen Fahrst&uuml;hle
 * weiter.
 */
public class SuperController {
/*
 * #if($controlling_synchronized == true)	
 */
	
	private ArrayList<AbstractController> lControllers;
	
	/*
	 * #if($outerview_emergencybuttons == true || $innerview_emergencybutton == true)
	 */
	private ConcurrentLinkedQueue<Target> clqPriorityTargets = new ConcurrentLinkedQueue<Target>();;
	/*
	 * #end
	 */
	
	
	/**
	 * Konstruktor des SuperController. Es wird das dem ControllerType entsprechende
	 * Controller Objekt erstellt und in einer Liste gespeichert.
	 * 
	 * @param iControllerType
	 */
	public SuperController(ArrayList<AbstractController> controllers) {
		lControllers = controllers;
	}

	/*
	 * #if($outerview_emergencybuttons == true || $innerview_emergencybutton == true)
	 */
	/**
	 * @return the PriorityTargets
	 */
	public ConcurrentLinkedQueue<Target> getPriorityTargets() {
		return clqPriorityTargets;
	}
	/*
	 * #end
	 */
	
	/**
	 * Verarbeitet die Fahrtwünsche für eine synchrone Fahrstuhlsteuerung
	 * und teilt sie dem n&auml;chsten bzw. sich gerade in die entsprechende
	 * Richtung bewegenden Fahrstuhl-Controller zu.
	 * @param target
	 * @param priority
	 */
	private void delegateCall(Target target, boolean priority) {
		int bestMatch = Integer.MAX_VALUE;
		int iCurrent = Integer.MAX_VALUE;
		//Es werden alle Controller durchgegangen
		for (int i = 0; i < lControllers.size(); i++) {
			
			/*
			 * Hier wird herausgefunden, welcher Controller die besten Voraussetzungen
			 * hat den Call zu übernehmen. Zunächst wird überprüft, ob das Stockwerk
			 * auf der IgnoreList des Controllers ist. 
			 * UND
			 * Das Ziel liegt über dem Fahrstuhl des Controllers UND die derzeitige
			 * Bewegung des Fahrstuhls ist 1.
			 * ODER
			 * Das Ziel liegt unter dem Fahrstuhl des Controllers UND die derzeitige
			 * Bewgung des Fahrstuhls ist -1.
			 * ODER
			 * Der Fahrstuhl hat die Richtung 0 und steht somit im Moment.
			 */
			if ((!lControllers.get(i).getlIgnoreList().get(target.getFloor()))
					&& ((target.getFloor() > lControllers.get(i).getElevator()
							.getCurrentFloor() && lControllers.get(i)
							.getElevator().getDirection() == 1)
							|| (target.getFloor() < lControllers.get(i)
									.getElevator().getCurrentFloor() && lControllers
									.get(i).getElevator().getDirection() == -1) || (lControllers
							.get(i).getElevator().getDirection() == 0))) {
				//Berechnung der Distanz zwischen dem Fahrstuhl und dem Zielstockwerk
				int iNext = Math.abs(target.getFloor()
						- lControllers.get(i).getElevator().getCurrentFloor());
				//Ist die Distanz kürzer als beim letzten Fahrstuhl, wird bestMatch neu gesetzt
				if (iCurrent > iNext) {
					iCurrent = iNext;
					bestMatch = i;
				}
			}
		}
		
		AbstractController bestController = lControllers.get(bestMatch); 
		
		/*
		 * #if($outerview_emergencybuttons == true || $innerview_emergencybutton == true)
		 */
		/*
		 * Handelt es sich um einen PriorityCall, wird das Target
		 * in die PriorityQueue übergeben und anschließend über
		 * processPriorityCall abgearbeitet
		 */
		if (priority) {
			bestController.getClqPriorityQueue().add(target);
			bestController.processPriorityCall();
		} else {
			//Hinzufügen des Targets zur TargetList des bestMatch Controllers
			bestController.addFloor(target);
		}
		/*
		 * #else
		 */
			bestController.addFloor(target);
		/*
		 * #end
		 */
		
		bestController.startSimulation();
	}
	
	/**
	 * Entweder wird das Target hier an delegateCall oder direkt an den spezifizierten
	 * Controller übergeben.
	 * 
	 * @param iFloor - Stockwerk des Fahrwunsches
	 * @param iDirection - Richtung des Fahrtwunsches. 0, wenn keine &uuml;bergeben wurde
	 * @param iControllerIndex - Handelt es sich um einen controllerspezifischen Call,
	 * wird dieser hier spezifiziert
	 * @param insideElevator - true, wenn der Fahrtwunsch im Fahrstuhl ausgel&ouml;st wurde, sonst false
	 */
	public void addTarget(Target target, int iControllerIndex,
			boolean insideElevator) {
		
		AbstractController controller = lControllers.get(iControllerIndex);
		//Überprüfung, ob die Fahrstühle synchron laufen
			if (insideElevator) {
				controller.addFloor(target);
				controller.startSimulation();
			} else {
				delegateCall(target, false);
			}

	}
	
	/**
	 * 
	 * @param iControllerIndex
	 * @param iFloor
	 */
	public void deleteTarget(int iControllerIndex, int iFloor) {
			// bei synchronisierten Fahrstühlen muss der Fahrstuhl gesucht werden,
			// der das Stockwerk anfährt
			for(int i = 0; i < lControllers.size(); i++) {
				if(lControllers.get(i).getTargetList().get(iFloor) != null) {
					lControllers.get(i).addDeletion(iFloor);
					break;
				}
			}
	}
	
	/*
	 * #if($outerview_emergencybuttons == true || $innerview_emergencybutton == true)
	 */
	/**
	 * Bei asynchroner Verarbeitung wird ein PriorityCall in die clqPriorityQueue des
	 * Controllers eingef&uuml;gt.
	 * Bei synchroner Verarbeitung wird das Ziel in die clqPriorityTargets
	 * dieser Klasse eingef&uuml;gt und delegateCall aufgerufen, um den passenden Controller zu finden.
	 * 
	 * @param iControllerIndex - Handelt es sich um einen controllerspezifischen Call,
	 * wird dieser hier spezifiziert
	 * @param iFloor - Stockwerk des Fahrwunsches
	 * @param insideElevator - true, wenn der Fahrtwunsch im Fahrstuhl ausgel&ouml;st wurde, sonst false
	 */
	public void addPriorityCall(int iControllerIndex, int iFloor,
			boolean insideElevator) {
		
		Target target = new Target(iFloor, 0);
		AbstractController controller = lControllers.get(iControllerIndex); 
		
			if (insideElevator) {
				controller.getClqPriorityQueue().add(
						target);
				controller.processPriorityCall();
				controller.startSimulation();

			} else {
				clqPriorityTargets.add(target);
				delegateCall(clqPriorityTargets.poll(), true);
			}
	}
	/*
	 * #end
	 */
/*
 * #end
 */
}