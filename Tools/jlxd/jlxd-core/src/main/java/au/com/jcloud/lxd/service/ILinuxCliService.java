package au.com.jcloud.lxd.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface ILinuxCliService {

	/**
	 * Execute a linux command
	 * 
	 * @param cmd the command to execute
	 * @return the result of the execution
	 * @throws IOException
	 * @throws InterruptedException
	 */
	String executeLinuxCmd(String cmd) throws IOException, InterruptedException;

	/**
	 * Execute a linux command returning the a list of Strings as a result
	 */
	List<String> executeLinuxCmdWithResultLines(String cmd) throws IOException, InterruptedException;

	/**
	 * Execute a linux command returning the text result as an integer
	 */
	int executeLinuxCmdWithResultInt(String cmd) throws IOException, InterruptedException;

	/**
	 * Execute a linux command returning the result as a json object
	 */
	<T> T executeLinuxCmdWithResultJsonObject(String cmd, Class<T> classType) throws IOException, InterruptedException;

	/**
	 * Count number of lines in a file
	 */
	int getLinesCountForFile(File readFile) throws IOException, InterruptedException;

	/**
	 * Get the last n lines from a file
	 */
	List<String> getLastNFileLines(File readFile, int linesToRead);

	/**
	 * Get last n lines from a file, returning only the first few lines from
	 * that set.
	 */
	List<String> getLastNFileLines(File readFile, int linesToRead, int headSize);

	String getFileNameWithoutExtension(String filename);

	String getFileExtension(String filename);

	String firstCharUpperCase(String input);

}
