package io.ssehub.easy.demo.command.file;

import io.ssehub.easy.demo.command.commands.Command;

import java.io.File;
import java.util.Map;

/**
 * Tries to emit the directory of the first argument. This command
 * explicitly extends the command set and is mandatory for this (sub-)productline.
 * 
 * @author SSE@SUH
 */
public class DirCommand implements Command {

	@Override
	public String getCommandName() {
		return "dir";
	}

	@Override
	public String getHelpText() {
		return "prints the diractory of the first argument";
	}

	@Override
	public String execute(String[] args, Map<String, Object> data) {
		String error = null;
		if (0 == args.length) {
			error = "No directory given";
		} else {
			String dirName = args[0]; 
			File file = new File(dirName);
			if (!file.exists()) {
				error = "'" + dirName + "' does not exist";
			} else if (!file.canRead()) {
				error = "cannot read '" + dirName + "'";
			} else {
				if (file.isFile()) {
					System.out.println(file.getAbsolutePath());
				} else {
					File[] files = file.listFiles();
					if (null != files) {
						for (File f : files) {
							System.out.println(f.getAbsolutePath());
						}
					} else {
						System.out.println("No files.");
					}
				}
			}
		}
		return error;
	}

}
