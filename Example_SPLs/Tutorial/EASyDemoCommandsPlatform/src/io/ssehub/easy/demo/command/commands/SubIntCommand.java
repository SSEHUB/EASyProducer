package io.ssehub.easy.demo.command.commands;

import java.util.Map;

/**
 * Adds at least two integers.
 * 
 * @author SSE@SUH
 */
public class SubIntCommand implements Command {

	@Override
	public String getCommandName() {
		return "sub";
	}

	@Override
	public String getHelpText() {
		return "subtracts at least two integers";
	}

	@Override
	public String execute(String[] args, Map<String, Object> data) {
		String error = null;
		if (args.length < 2) {
			error = "not enough arguments to subtract";
		} else {
			int result = 0;
			int arg = 0;
			try {
				while (arg < args.length) {
					int tmp = Integer.parseInt(args[arg]);
					if (0 == arg) {
						result = tmp;
					} else {
						result -= tmp;
					}
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
