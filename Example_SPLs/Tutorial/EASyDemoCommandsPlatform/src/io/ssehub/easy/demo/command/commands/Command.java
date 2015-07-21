package io.ssehub.easy.demo.command.commands;

import java.util.Map;

/**
 * Defines the interface for a command.
 * 
 * @author SSE@SUH
 */
public interface Command {

	/**
	 * Returns the name of the command.
	 * 
	 * @return the name of the command (single word, no spaces)
	 */
	public String getCommandName();
	
	/**
	 * Returns the help text.
	 * 
	 * @return the help text
	 */
	public String getHelpText();
	
	/**
	 * Executes the command.
	 * 
	 * @param args the command line arguments
	 * @param data shared data, may be modified as a side effect
	 * @return <b>null</b> if execution was successful, an error message else
	 */
	public String execute(String[] args, Map<String, Object> data);
	
}
