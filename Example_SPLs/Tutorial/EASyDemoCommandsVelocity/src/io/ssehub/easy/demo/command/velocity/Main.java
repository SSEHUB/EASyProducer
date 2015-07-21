package io.ssehub.easy.demo.command.velocity;

import io.ssehub.easy.demo.command.Processor;
import io.ssehub.easy.demo.command.commands.*;

/**
 * A velocity-instantiated processor.
 * 
 * @author SSE@SUH
 */
public class Main extends Processor {

	/**
	 * Registers the commands.
	 */
	static {
		setAppName("$appName");
		
		/*
		 * #if($hasAddCommand == true)
		 */
		register(new AddIntCommand());
		/*
		 * #end
		 */
		
		/*
		 * #if($hasSubCommand == true)
		 */
		register(new SubIntCommand());
		/*
		 * #end
		 */

		/*
		 * #if($hasPrintCommand == true)
		 */
		register(new PrintCommand());
		/*
		 * #end
		 */
	}
	
	/**
	 * Starts the processor.
	 * 
	 * @param args ignored
	 */
	public static void main(String[] args) {
		Processor.main(args);
	}
	
}
