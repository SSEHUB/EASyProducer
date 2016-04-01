package simulator.controllers;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;

import simulator.model.Elevator;
import simulator.model.Target;
import engine.ElevatorEngine;

public abstract class AbstractController {
	private int index;
	
	protected ConcurrentLinkedQueue<Target> clqPriorityQueue = new ConcurrentLinkedQueue<Target>();
	protected ConcurrentLinkedQueue<Integer> clqDeletionQueue = new ConcurrentLinkedQueue<Integer>();	
	protected boolean hasPriorityCall = false;
	protected Thread simuThread = null;
	protected ArrayList<Target> lTargetList = new ArrayList<Target>();
	protected Target currentTarget = null;
	protected ArrayList<Boolean> lIgnoreList = new ArrayList<Boolean>();
	protected boolean bSameFloor = false;
	protected boolean updateNecessary = false;
	protected Elevator eElevator = new Elevator();
	
	
	protected AbstractController(int index) {
		this. index = index;
	}
	
	/**
	 * @return the eElevator
	 */
	public Elevator getElevator() {
		return eElevator;
	}
	
	/**
	 * @return ControllerIndex
	 */
	public final int getIndex() {
		return index;
	}
	
	/**
	 * @return the clqPriorityQueue
	 */
	public final ConcurrentLinkedQueue<Target> getClqPriorityQueue() {
		return clqPriorityQueue;
	}
	
	/**
	 * @param clqPriorityQueue the clqPriorityQueue to set
	 */
	public final void setClqPriorityQueue(ConcurrentLinkedQueue<Target> clqPriorityQueue) {
		this.clqPriorityQueue = clqPriorityQueue;
	}
	
	/**
	 * 
	 * @return geplante Stornierungen
	 */
	public final ConcurrentLinkedQueue<Integer> getDeletionQueue() {
		return clqDeletionQueue;
	}
	
	/**
	 * @return the hasPriorityCall
	 */
	public final boolean isHasPriorityCall() {
		return hasPriorityCall;
	}
	
	/**
	 * @param hasPriorityCall the hasPriorityCall to set
	 */
	public final void setHasPriorityCall(boolean hasPriorityCall) {
		this.hasPriorityCall = hasPriorityCall;
	}
	
	/**
	 * @return the currentTarget
	 */
	public final Target getCurrentTarget() {
		return currentTarget;
	}
	
	/**
	 * @param currentTarget the currentTarget to set
	 */
	public final void setCurrentTarget(Target currentTarget) {
		this.currentTarget = currentTarget;
	}
	
	
	/**
	 * @return the simuThread
	 */
	public final Thread getSimuThread() {
		return simuThread;
	}

	/**
	 * @return the lTargetList
	 */
	public final ArrayList<Target> getTargetList() {
		return lTargetList;
	}
	
	/**
	 * @param lTargetList the lTargetList to set
	 */
	public final void setTargetList(ArrayList<Target> lTargetList) {
		this.lTargetList = lTargetList;
	}
	
	/**
	 * @return the lIgnoreList
	 */
	public final ArrayList<Boolean> getlIgnoreList() {
		return lIgnoreList;
	}
	
	/**
	 * @param iIndex the lIgnoreList to set
	 */
	public final void setlItemIgnoreList(int iIndex) {
		this.lIgnoreList.set(iIndex, true);
	}
	
	/**
	 * @return bSameFloor
	 */
	public final boolean isSameFloor() {
		return bSameFloor;
	}
	
	protected final void setSameFloor(boolean sameFloor) {
		bSameFloor = sameFloor;
	}
	
	/**
	 * 
	 * @return updateNecessary
	 */
	public final boolean isUpdateNecessary() {
		return updateNecessary;
	}
	
	
	/**
	 * startet den Simulations-Thread
	 */
	public final void startSimulation() {
		if(simuThread == null || !simuThread.isAlive()) {
			simuThread = new Thread(new ElevatorEngine(this));
			simuThread.start();
		}
	}
	
	public final void addPriorityCall(int i) {
		clqPriorityQueue.add(new Target(i, 0));
		if(currentTarget == null)
			processPriorityCall();
		startSimulation();
	}
	
	public final void addDeletion(int iFloor) {
		clqDeletionQueue.add(iFloor);
		startSimulation();
	}
	
	public abstract boolean simulate();
	
	public abstract void addFloor(Target target);
	
	public abstract boolean updateTarget();
	
	
	public abstract void processPriorityCall();
	
	public abstract void processDeletions();
	
	public abstract boolean updateTarget(int iDir, boolean bAttendTargetDir);
	
	public abstract void doAfterAnimate();
}
