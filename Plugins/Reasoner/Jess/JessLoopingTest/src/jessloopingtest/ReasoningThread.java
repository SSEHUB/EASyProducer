package jessloopingtest;

import jess.JessException;
import jess.Rete;

public class ReasoningThread extends Thread{

	private JessController jessController;
	private Rete jessEngine;
	private String jessFileName;
	private boolean terminationActivated = false;
	
	private Thread thread = null;
	
	public ReasoningThread (JessController jc, Rete engine, String fileName) {
		jessController = jc;
		jessEngine = engine;
		jessFileName = fileName;
		
		try {
			jessEngine.batch(jessFileName);
		} catch (JessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		thread = Thread.currentThread();
		try {				
			jessEngine.run();
			System.err.println("termination is: " + terminationActivated);
			//jessEngine.runUntilHalt();
			if (!terminationActivated) {
				System.out.println("reasoningTask: termination is not activated!");
				jessController.setResultFound(true);
				jessController.notifySuccessfulReasoning();
			}
		} catch (JessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setTerminationActivated (boolean active) {
		System.err.println("in reasoning task termination set to:" + active);
		terminationActivated = active;
	}

	public Thread getThread() {
		return thread;
	}
}
