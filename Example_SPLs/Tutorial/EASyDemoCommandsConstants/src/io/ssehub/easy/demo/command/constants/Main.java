package io.ssehub.easy.demo.command.constants;

import io.ssehub.easy.demo.command.Processor;
import io.ssehub.easy.demo.command.commands.AddIntCommand;
import io.ssehub.easy.demo.command.commands.PrintCommand;
import io.ssehub.easy.demo.command.commands.SubIntCommand;

/**
 * Implements a generation-instantiated command processor.
 * 
 * @author SSE@SUH
 */
public class Main extends Processor {

	private static final String APP_NAME = "";
	private static final boolean hasAddCommand = false;
	private static final boolean hasSubCommand = false;
	private static final boolean hasPrintCommand = false;
	
	/**
	 * Starts the processor.
	 * 
	 * @param args ignored
	 */
	public static void main(String[] args) {
		setAppName(APP_NAME);
		if (hasAddCommand) {
			register(new AddIntCommand());
		}
		if (hasSubCommand) {
			register(new SubIntCommand());
		}
		if (hasPrintCommand) {
			register(new PrintCommand());
		}
		Processor.main(args);
	}

}
