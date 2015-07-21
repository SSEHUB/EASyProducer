package io.ssehub.easy.demo.command.file;

import io.ssehub.easy.demo.command.Processor;

import java.io.File;

/**
 * A velocity-instantiated processor.
 * 
 * @author SSE@SUH
 */
public class Main extends Processor {

	private static final String APP_NAME = "";
	private static final String CLASS_SUFFIX = ".class";
	private static final String QN_SEPARATOR = ".";
	
	/**
	 * Registers the commands.
	 */
	static {
		setAppName(APP_NAME);
		loadCommands(new File("bin"), "", true);
	}
	
	/** 
	 * Loads all commands that can be found. Please note that we explicitly aim at removing  classes / files 
	 * during instantiation and (here) not at generating a service spec or so.
	 *  
	 * @param file the file to be searched
	 * @param qn the recent qualified name collected so far
	 * @param ignoreQn whether <code>qn</code> shall be ignore in this call (typically a top-level call. 
	 */
	private static final void loadCommands(File file, String qn, boolean ignoreQn) {
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			if (null != files) {
				for (File f : files) {
					loadCommands(f, ignoreQn ? "" : (0 == qn.length() ? file.getName() : qn + QN_SEPARATOR + file.getName()), false);
				}
			}
		} else if (file.isFile()) {
			String name = file.getName();
			if (name.endsWith(CLASS_SUFFIX)) {
				name = name.substring(0, name.length() - CLASS_SUFFIX.length());
				String className = qn + QN_SEPARATOR + name;
				register(className);
			}
		}
	}
	
	/**
	 * Starts the processor.
	 * 
	 * @param args ignored
	 */
	public static void main(String[] args) {
		Processor.main(args);
	}
	
}
