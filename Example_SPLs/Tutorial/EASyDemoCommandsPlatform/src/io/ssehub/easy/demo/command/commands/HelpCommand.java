package io.ssehub.easy.demo.command.commands;

import java.util.Map;

/**
 * Implements the mandatory (!) help command.
 * 
 * @author SSE@SUH
 */
public class HelpCommand implements Command {

	public static final String HELP = "help";
	
	@Override
	public String getCommandName() {
		return "help";
	}

	@Override
	public String getHelpText() {
		return "prints this help";
	}

	@Override
	public String execute(String[] args, Map<String, Object> data) {
		data.put(HELP, Boolean.TRUE);
		return null;
	}

}
