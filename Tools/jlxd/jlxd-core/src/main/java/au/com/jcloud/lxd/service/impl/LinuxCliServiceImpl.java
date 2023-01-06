package au.com.jcloud.lxd.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

import au.com.jcloud.lxd.LxdConstants;
import au.com.jcloud.lxd.service.ILinuxCliService;
import au.com.jcloud.lxd.util.ProcessWithTimeout;

/**
 * Created by david.vittor on 21/08/17.
 */
@Named
public class LinuxCliServiceImpl implements ILinuxCliService {
	private static final Logger LOG = Logger.getLogger(LinuxCliServiceImpl.class);

	@Override
	public String executeLinuxCmd(String cmd) throws IOException, InterruptedException {
		StringBuffer result = new StringBuffer();
		BufferedReader in = null;
		LOG.debug("cmd=" + cmd);
		System.out.println(cmd);
		try {
			Process process = null;
			if (LxdConstants.IS_WINDOWS) {
				LOG.warn("Trying to execute linux command in Windows environment: " + cmd);
				process = Runtime.getRuntime().exec(cmd);
				process.getOutputStream().close();
			}
			else {
				String[] cmdArray = { "/bin/sh", "-c", cmd };
				process = Runtime.getRuntime().exec(cmdArray);
				process.getOutputStream().close();
			}
//			ProcessWithTimeout processWithTimeout = new ProcessWithTimeout(process);
//			int exitCode = processWithTimeout.waitForProcess(LxdConstants.JLXD_EXEC_TIMEOUT);
//			if (exitCode == Integer.MIN_VALUE) {
//				throw new InterruptedException("Timeout occured in command: " + cmd);
//			}
			in = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line;

			while ((line = in.readLine()) != null) {
				result.append(line);
			}
			process.waitFor();
		} finally {
			if (in != null) {
				in.close();
			}
		}
		LOG.debug("result=" + result);
		return result.toString();
	}

	@Override
	public List<String> executeLinuxCmdWithResultLines(String cmd) throws IOException, InterruptedException {
		String[] cmdArray = { "/bin/sh", "-c", cmd };
		LOG.debug("cmd=" + cmdArray[2]);
		List<String> result = new ArrayList<String>();
		BufferedReader in = null;
		LOG.debug("cmd=" + cmdArray[2]);
		try {
			System.out.println(java.util.Arrays.toString(cmdArray));
			Process process = Runtime.getRuntime().exec(cmdArray);
			process.getOutputStream().close();
			in = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line;

			while ((line = in.readLine()) != null) {
				result.add(line);
			}
			process.waitFor();
		} finally {
			if (in != null) {
				in.close();
			}
		}
		return result;
	}

	@Override
	public int executeLinuxCmdWithResultInt(String cmd) throws IOException, InterruptedException {
		String output = executeLinuxCmd(cmd);
		if (output.trim().length() > 0) {
			return Integer.parseInt(output.trim());
		}
		return 0;
	}

	@Override
	public <T> T executeLinuxCmdWithResultJsonObject(String cmd, Class<T> classType)
			throws IOException, InterruptedException {
		//System.out.println(cmd);
		String output = executeLinuxCmd(cmd);
		if (output.trim().length() > 0) {
			LOG.debug("output=" + output);
			Gson gson = new Gson();
			return gson.fromJson(output, classType);
		}
		return null;
	}

	@Override
	public int getLinesCountForFile(File readFile) throws IOException, InterruptedException {
		String cmd = "wc -l " + readFile.getAbsolutePath() + " | cut -f 1 -d ' '";
		return executeLinuxCmdWithResultInt(cmd);
	}

	@Override
	public List<String> getLastNFileLines(File readFile, int linesToRead) {
		return getLastNFileLines(readFile, linesToRead, 0);
	}

	@Override
	public List<String> getLastNFileLines(File readFile, int linesToRead, int headSize) {
		List<String> result = new ArrayList<String>();
		try {
			String cmd = "tail -" + linesToRead + " " + readFile.getAbsolutePath();
			if (headSize > 0) {
				cmd += " | head -" + headSize;
			}
			result = executeLinuxCmdWithResultLines(cmd);
		} catch (Exception e) {
			LOG.error(e, e);
		}
		return result;
	}

	@Override
	public String getFileNameWithoutExtension(String filename) {
		int index = filename.lastIndexOf(".");
		if (index > 0) {
			String filenameWithoutExtension = filename.substring(0, index);
			return filenameWithoutExtension;
		}
		return filename;
	}

	@Override
	public String getFileExtension(String filename) {
		int index = filename.lastIndexOf(".");
		return filename.substring(index + 1);
	}

	@Override
	public String firstCharUpperCase(String input) {
		return input.substring(0, 1).toUpperCase() + input.substring(1);
	}

}
