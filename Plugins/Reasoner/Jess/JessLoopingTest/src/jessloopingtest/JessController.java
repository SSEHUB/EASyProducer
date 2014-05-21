package jessloopingtest;

import java.util.Timer;
import java.util.TimerTask;

import jess.JessException;
import jess.Rete;

/**
 * The JessController class controls the Jess reasoner, i.e. to avoid looping.
 * @author kroeher
 *
 */
public class JessController {
	
	class TerminationTask extends TimerTask {
		
		private JessController jessController;
		private boolean resultFound = false;
		
		protected TerminationTask (JessController jc) {
			jessController = jc;
		}
		
		@Override
		public void run() {
			if(!resultFound) {
				jessController.terminateReasoning();
			}
		}
		
		public void setResultFound(boolean found) {
			System.err.println("in termination task resultFound set to:" + found);
			resultFound = found;
		}
	}

	private Rete jessEngine = null;
	private int latencyTime = 2;
	private boolean resultFound = false;
	private ReasoningThread reasoningThread = null;
	
	private Timer latencyTimer = null;
	private TerminationTask latencyTask = null;
	private boolean terminationActivated = false;

	
	/**
	 * 
	 * @param engine The rete engine, which performs the reasoning task.
	 * @param latency The time in milliseconds till the reasoning process has to stop
	 */
	public JessController(Rete engine, int latency) {
		jessEngine = engine;
		latencyTime = latency;
	}
	
	/**
	 * 
	 * @param fileName The name of the .clp file to be executed by Jess.
	 */
	public void startReasoning(String fileName) {
		System.out.println("Start reasoning...");
		
		reasoningThread = new ReasoningThread(this, jessEngine, fileName);
		
		latencyTask = new TerminationTask(this);
		latencyTimer = new Timer();
		latencyTimer.schedule(latencyTask, latencyTime);
		
		/* 
		 * Important: do not start reasoningThread before timer.
		 * This will cause synchronization errors!
		 */
		reasoningThread.run();
		
		try {
			System.out.println("Waiting for reasoning results...");
			reasoningThread.join();
			System.out.println("ReasoningThread joined (is shut down)");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		resetAll();
	}
	
	public void notifySuccessfulReasoning() {
		System.out.println("Jess notifies about successful reasonig...");	

		System.out.println("All timers canceled!");
	}
	
	private void terminateReasoning() {
		System.out.println("Terminating Jess from the outside...");
		reasoningThread.setTerminationActivated(true);
		if (!resultFound) {
			System.out.println("termination: no result so far!");
			try {
				jessEngine.halt();
			} catch (JessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("termination: Jess has found some results! Perfect!!");
		}
		System.out.println("...termination done!");
	}
	
	private void resetAll() {
		//Cancel the timer (will close threads)
		latencyTimer.cancel();
		//"Delete" timer object
		latencyTimer = null;
		//"Delete" timer task
		latencyTask = null;
		//Reset private lock variables
		resultFound = false;
		terminationActivated = false;
		//"Delete" reasoning thread
		reasoningThread = null;
	}
	
	protected boolean isTerminationActivated() {
		System.out.println("isTerminationActive: " + terminationActivated);
		return terminationActivated;
	}
	
	protected void setTerminationActivition(boolean activate) {
		System.out.println("setTerminationActivition to: " + activate);
		terminationActivated = activate;
	}
	
	protected boolean isResultFound() {
		System.out.println("isResultFound: " + resultFound);
		return resultFound;
	}
	
	protected void setResultFound(boolean found) {
		System.out.println("setResultFound to: " + found);
		resultFound = found;
	}

}
