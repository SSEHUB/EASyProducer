package io.ssehub.easy.demo.command;

import io.ssehub.easy.demo.command.commands.Command;
import io.ssehub.easy.demo.command.commands.ExitCommand;
import io.ssehub.easy.demo.command.commands.HelpCommand;

import java.lang.reflect.Modifier;
import java.text.Collator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Implements the command processor.
 * 
 * @author SSE@SUH
 */
public class Processor {
	
	private static String appName = "";
	
	private static final Map<String, Command> COMMANDS = new TreeMap<String, Command>(Collator.getInstance());

	/**
	 * Changes the display name of the application.
	 * 
	 * @param name the display name
	 */
	protected static void setAppName(String name) {
		appName = name;
	}
	
	/**
	 * Registers a command.
	 * 
	 * @param command the command to be registered
	 * @return <code>true</code> if successful, <code>false</code> else (no command given or already registered command name)
	 */
	public static final boolean register(Command command) {
		boolean register = false;
		if (null != command) {
			String key = command.getCommandName();
			if (!COMMANDS.containsKey(key)) {
				COMMANDS.put(key, command);
				register = true;
			}
		}
		return register;
	}

	/**
	 * Registers mandatory default commands.
	 */
	static {
		register(new ExitCommand());
		register(new HelpCommand());
	}
	
	/**
	 * Prints the menu.
	 */
	private static void printHelp() {
		System.out.println("Commands: " + appName);
		for (Command cmd : COMMANDS.values()) {
			System.out.print(" - ");
			System.out.print(cmd.getCommandName());
			System.out.print(": ");
			System.out.println(cmd.getHelpText());
		}
	}
	
	/**
	 * Turns arguments into a String.
	 * 
	 * @param args the arguments
	 * @return the resulting String (just concatenated with whitespaces)
	 */
	private static String argumentsToString(String[] args) {
		StringBuilder result = new StringBuilder();
		for (int a = 0; a < args.length; a++) {
			if (a > 0) {
				result.append(" ");
			}
			result.append(args[a]);
		}
		return result.toString();
	}
	
	/**
	 * Returns the arguments, i.e., excludes the command name.
	 * 
	 * @param text the full command (name + arguments)
	 * @return the the arguments
	 */
	private static String[] separateArguments(String[] text) {
		String[] result;
		if (text.length > 1) {
			result = new String[text.length - 1];
			System.arraycopy(text, 1, result, 0, result.length);
		} else {
			result = new String[0];
		}
		return result;
	}

	/**
	 * Returns whether <code>modifiers</code> indicate that a class holding them can be instantiated.
	 *  
	 * @param modifiers the modifiers
	 * @return <code>true</code> if instantiation is possible, <code>false</code> else
	 */
	protected static boolean canBeInstantiated(int modifiers) {
		return !(Modifier.isAbstract(modifiers) || Modifier.isInterface(modifiers));
	}
	
	/**
	 * Tries to register the specified class as command.
	 * 
	 * @param className the class name
	 * @return <code>true</code> if successful, <code>false</code> else
	 */
	protected static boolean register(String className) {
		boolean successful = false;
		try {
			Class<?> cls = Class.forName(className);
			if (Command.class.isAssignableFrom(cls)
					&& canBeInstantiated(cls.getModifiers())) {
				register((Command) cls.newInstance());
				successful = true;
			}
		} catch (ClassNotFoundException | IllegalAccessException
				| InstantiationException | SecurityException e) {
			System.out.println("Command loading problem for "
					+ className + ": " + e.getMessage());
		}
		return successful;
	}

	/**
	 * Starts the processor.
	 * 
	 * @param args ignored
	 */
	public static void main(String[] args) {
		printHelp();
		Scanner scanner = new Scanner(System.in);
		boolean exit = false;
		Map<String, Object> sharedMem = new HashMap<String, Object>();
		do {
			System.out.println("Enter command and options:");
			String line = scanner.nextLine();
			if (null != line) {
				String[] tmp = line.split(" ");
				if (tmp.length > 0) {
					String cmdName = tmp[0];
					String[] cmdArgs = separateArguments(tmp);
					Command cmd = COMMANDS.get(cmdName);
					if (null == cmd) {
						System.out.println("Unknown command: " + cmdName + " args: " + argumentsToString(cmdArgs));
					} else {
						String error = cmd.execute(cmdArgs, sharedMem);
						if (null != error) {
							System.out.println("ERROR: " + error);
						}
						if (Boolean.TRUE == sharedMem.get(HelpCommand.HELP)) {
							printHelp();
							sharedMem.remove(HelpCommand.HELP);
						}
						exit = Boolean.TRUE == sharedMem.get(ExitCommand.EXIT);
					}
				}
			}
		} while (!exit);
		scanner.close();
	}

}
