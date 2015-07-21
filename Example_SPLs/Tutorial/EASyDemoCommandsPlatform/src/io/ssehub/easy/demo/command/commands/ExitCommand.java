package io.ssehub.easy.demo.command.commands;

import java.util.Map;

/**
 * Implements the mandatory (!) exit command.
 * 
 * @author SSE@SUH
 */
public class ExitCommand implements Command {

	public static final String EXIT = "exit";
	
	@Override
	public String getCommandName() {
		return "exit";
	}

	@Override
	public String getHelpText() {
		return "terminates the program";
	}

	@Override
	public String execute(String[] args, Map<String, Object> data) {
		data.put(EXIT, Boolean.TRUE);
		return null;
	}

}
