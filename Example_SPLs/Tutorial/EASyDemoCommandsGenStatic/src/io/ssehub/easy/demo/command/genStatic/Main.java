package io.ssehub.easy.demo.command.genStatic;

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

	/**
	 * Starts the processor.
	 * 
	 * @param args ignored
	 */
	public static void main(String[] args) {
		setAppName(Constants.APP_NAME);
		if (Constants.hasAddCommand) {
			register(new AddIntCommand());
		}
		if (Constants.hasSubCommand) {
			register(new SubIntCommand());
		}
		if (Constants.hasPrintCommand) {
			register(new PrintCommand());
		}
		Processor.main(args);
	}

}
