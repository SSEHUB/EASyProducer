package au.com.jcloud.lxd;

import java.io.File;

public class LxdConstants {
	public static final String OS_NAME = System.getProperty("os.name");
	public static final String USER_DIR = System.getProperty("user.dir");
	public static final String USER_HOME_DIR = System.getProperty("user.home");
	public static final String TEMP_DIR = System.getProperty("java.io.tmpdir");

	public static final int JLXD_EXEC_TIMEOUT = Integer.parseInt(System.getProperty("jlxd.timeout", "30000"));

	public static final String USER_CONFIG_DIR = LxdConstants.USER_HOME_DIR + File.separator + ".config";

	public static final boolean IS_WINDOWS = OS_NAME.toLowerCase().startsWith("win");

	public static final String DEFAULT_FILEPATH_USER_CONFIG_LXD = LxdConstants.USER_CONFIG_DIR + File.separator + "lxc";
	public static final String DEFAULT_FILEPATH_REMOTE_CERT = LxdConstants.DEFAULT_FILEPATH_USER_CONFIG_LXD + File.separator + "client.crt";
	public static final String DEFAULT_FILEPATH_REMOTE_KEY = LxdConstants.DEFAULT_FILEPATH_USER_CONFIG_LXD + File.separator + "client.key";
	
	public static final String COLON = ":";
}
