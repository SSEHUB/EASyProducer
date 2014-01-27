package main;

import gui.windows.MainWindow;

import java.util.ArrayList;

import simulator.SuperController;

import simulator.controllers.$controlling_controllertype;
import simulator.controllers.AbstractController;


public class ElevatorSimulator {
	
	private static ElevatorSimulator instance = null;
	
	
	// Liste nur bei mehr als einem Fahrstuhl nötig
	/*
	 * #if($elevators > 1)
	 */
	
	private ArrayList<AbstractController> lControllers;
	
	public AbstractController getController(int i) {
		return lControllers.get(i);
	}
	
	/*
	 * #else
	 */
	
	private AbstractController controller;
	
	public AbstractController getController() {
		return controller;
	}
	
	/*
	 * #end
	 */
		
	
	/*
	 * #if($controlling_synchronized == true)
	 */
	
	private SuperController superController;
	
	public SuperController getSuperController() {
		return superController;
	}
	
	public void setSuperController(SuperController aSuperController) {
		this.superController = aSuperController;
	}
	
	/*
	 * #end
	 */
	
	
	public static ElevatorSimulator getInstance() {

		if (instance == null) {

			instance = new ElevatorSimulator();

		}

		return instance;
	}
	
	
	
	private ElevatorSimulator() {
		initController();
		initGUI();
	}
	
	public void initGUI() {
		MainWindow.getInstance();
	}

	public void initController() {
		/*
		 * #if($elevators > 1)
		 */
		
		lControllers = new ArrayList<AbstractController>();
		for (int i = 0; i < $elevators; i++) {
				lControllers.add(new $controlling_controllertype(i, $floors));
		}
		
		/*
		 * #else
		 */
		
		this.controller = new $controlling_controllertype(0, $floors);
		
		/*
		 * #end
		 */
		
		
		/*
		 * #if($controlling_synchronized == true && $elevators > 1)
		 */
		
		this.superController = new SuperController(lControllers);
		
		/*
		 * #end
		 */
		
	}
	
}
