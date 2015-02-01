package spring;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
/**
 * 
 * Class template to handle outputs of quote and depth data.
 * To write in the appropriate output file
 *
 */
public class DataOutputController {
	public static final String quoteFolderName = "data";
	public static final String depthFolderName = "data";
	public static final String fileFormat = "txt";
/**
 * Initialize outputs by preparing output folder
 */
	public static void init() {
		if (!new File(quoteFolderName).exists()) {
			new File(quoteFolderName).mkdirs();
		}
		if (!new File(depthFolderName).exists()) {
			new File(depthFolderName).mkdirs();
		}
	}
	/**
	 * Write quote data to file
	 */
	public static void saveQuoteData(String fileName, String line)
			throws Exception {
		FileWriter fw = null;
		PrintWriter pw = null;
		try {
			fw = new FileWriter(quoteFolderName + File.separator + fileName
					+ "." + fileFormat, true);
			pw = new PrintWriter(fw, true);
			pw.println(line);
		} catch (Exception e) {
			try {
				fw.close();
			} catch (Exception ex) {
			}
			throw e;
		}
		try {
			fw.close();
		} catch (Exception e) {

		}

	}
	/**
	 * Write depth data to file
	 */
	public static void saveDepthData(String fileName, String line)
			throws Exception {
		FileWriter fw = null;
		PrintWriter pw = null;
		try {
			fw = new FileWriter(depthFolderName + File.separator + fileName
					+ "." + fileFormat, true);
			pw = new PrintWriter(fw, true);
			pw.println(line);
		} catch (Exception e) {
			try {
				fw.close();
			} catch (Exception ex) {
			}
			throw e;
		}
		try {
			fw.close();
		} catch (Exception e) {

		}

	}
}
