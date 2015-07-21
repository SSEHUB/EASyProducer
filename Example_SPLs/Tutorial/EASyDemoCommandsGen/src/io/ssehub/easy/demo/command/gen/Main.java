package io.ssehub.easy.demo.command.gen;

import io.ssehub.easy.demo.command.Processor;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.StringTokenizer;

/**
 * Implements a generation-instantiated command processor.
 * 
 * @author SSE@SUH
 */
public class Main extends Processor {

	/**
	 * Starts the processor.
	 * 
	 * @param args ignored
	 */
	public static void main(String[] args) {
		Properties prop = new Properties();
		try {
			File propFile = new File("program.properties");
			FileInputStream fis = new FileInputStream(propFile);
			prop.load(fis);
			fis.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		setAppName(prop.getProperty("appName", ""));
		String cmds = prop.getProperty("cmds", "");
		StringTokenizer cmdTokens = new StringTokenizer(cmds);
		while (cmdTokens.hasMoreTokens()) {
			String clsName = cmdTokens.nextToken().trim();
			if (clsName.length() > 0) {
				register(clsName);
			}
		}
		Processor.main(args);
	}

}
