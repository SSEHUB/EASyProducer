package io.ssehub.easy.demo.command.commands;

import java.util.Map;

/**
 * Adds at least two integers.
 * 
 * @author SSE@SUH
 */
public class AddIntCommand implements Command {

	@Override
	public String getCommandName() {
		return "add";
	}

	@Override
	public String getHelpText() {
		return "adds at least two integers";
	}

	@Override
	public String execute(String[] args, Map<String, Object> data) {
		String error = null;
		if (args.length < 2) {
			error = "not enough arguments to add";
		} else {
			int result = 0;
			int arg = 0;
			try {
				while (arg < args.length) {
					result += Integer.parseInt(args[arg]);
					arg++;
				}
				System.out.println("Result: " + result);
			} catch (NumberFormatException e) {
				error = "at argument " + arg + ":" + e.getMessage();
			}
		}
		return error;
	}

}
