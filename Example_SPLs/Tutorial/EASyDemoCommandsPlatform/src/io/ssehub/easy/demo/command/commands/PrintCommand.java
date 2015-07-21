package io.ssehub.easy.demo.command.commands;

import java.util.Map;

/**
 * Prints text.
 * 
 * @author SSE@SUH
 */
public class PrintCommand implements Command {

	@Override
	public String getCommandName() {
		return "print";
	}

	@Override
	public String getHelpText() {
		return "prints the given arguments";
	}

	@Override
	public String execute(String[] args, Map<String, Object> data) {
		for (int a = 0; a < args.length; a++) {
			if (a > 0) {
				System.out.print(" ");
			}
			System.out.print(args[a]);
		}
		System.out.println();
		return null;
	}

}
