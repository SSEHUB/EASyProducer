package io.ssehub.easy.demo.command.aspects;

import io.ssehub.easy.demo.command.Processor;

/**
 * An aspect-instantiated processor.
 * 
 * @author SSE@SUH
 */
public class Main extends Processor {

	private static final String APP_NAME = "";
	
	/**
	 * Starts the processor.
	 * 
	 * @param args ignored
	 */
	public static void main(String[] args) {
		setAppName(APP_NAME);
		Processor.main(args);
	}
	
}
