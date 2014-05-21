package jessloopingtest;

import jess.JessException;
import jess.Rete;

/**
 * This class represents EASy (the specific part of) which will call the reasoner
 * @author kroeher
 *
 */

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		
		// For debugging of unexpected exceptions!
		Thread.setDefaultUncaughtExceptionHandler(new JessExceptionHandler());
		
		System.err.println("Jess Looping Test!");
		
		Rete engine = new Rete();
		
		// latency time in milliseconds - so far 1 millisecond works!		
		JessController jc = new JessController(engine, 1);
		
		//jc.startReasoning("NoLoopingTest.clp");
		jc.startReasoning("LoopingTest.clp");

		System.err.println("++++++++++++++++++++++++++++++++++++++Wait for new reasoning to start");
		//This is just for debugging!
		//Thread.sleep(5000);
		
		/*
		 * This could also be handled by the JessController.
		 * However, to work with the results, the engine should be cleared
		 * in the main code before starting a new reasoning task.
		 */
		try {
			engine.clear();
		} catch (JessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//jc.startReasoning("LoopingTest.clp");
		jc.startReasoning("NoLoopingTest.clp");

		System.err.println("Jess Loop Test! ... finished");

	}
}

