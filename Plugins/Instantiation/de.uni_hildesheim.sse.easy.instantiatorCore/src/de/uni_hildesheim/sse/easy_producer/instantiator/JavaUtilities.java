/*
 * Copyright 2009-2015 University of Hildesheim, Software Systems Engineering
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.uni_hildesheim.sse.easy_producer.instantiator;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import de.uni_hildesheim.sse.utils.Environment;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.os.UnixOperations;


/**
 * Common utility functions for Java operations which may be used by several instantiators.
 * @author Sascha El-Sharkawy
 *
 */
public class JavaUtilities {
    
    public static final String JDK_PATH = determineJDKDir();
    public static final String[] JRE_CLASS_PATH = determineJREClassPath(); 
    
    /**
     * Avoid initialization of utility class.
     */
    private JavaUtilities() {}

    /**
     * Determines the PATH (root folder) of the installed and most used JDK installation.
     * This algorithm will try the following things to detect the JDK installation:
     * <ol>
     *     <li>Find the JDK via the <tt>JAVA_HOME</tt> system variable</li>
     *     <li>Find the JDK via the command <tt>where/whereis javac</tt></li>
     * </ol>
     * @return The location of a JDK (top folder) or <tt>null</tt> if it could not be found.
     * @see <a href="http://docs.oracle.com/cd/E19182-01/820-7851/inst_cli_jdk_javahome_t/index.html">
     * JAVA_HOME system variable</a>
     * @see <a href="http://stackoverflow.com/questions/15725601/finding-jdk-path-and-storing-it-as-a-string-in-java">
     * Source of the used algorithm</a>
     */
    private static String determineJDKDir() {
        // Try to resolve JDK path via JAVA_HOME system variable (should be the fastest method, but not reliable
        String jdkPath = System.getenv("JAVA_HOME");
        
        //checkstyle: stop exception type check 
        try {
            if (jdkPath == null || !(new File(jdkPath).exists())) {
                //"where" on Windows and "whereis" on Linux/Mac
                if (Environment.isWinOS()) {
                    String path = getCommandOutput("where javac");
                    if (path != null && !path.isEmpty()) {
                        //Response will be the path including "javac.exe" so need to
                        //Get the two directories above that
                        File javacFile = new File(path);
                        File jdkInstallationDir = javacFile.getParentFile().getParentFile();
                        jdkPath = jdkInstallationDir.getAbsolutePath();
                    }
                } else {
                    String response = getCommandOutput("whereis javac");
                    if (response != null) {
                        //The response will be "javac:  /usr ... "
                        //so parse from the "/" - if no "/" then there was an error with the command
                        int pathStartIndex = response.indexOf('/');
                        if (pathStartIndex != -1) {
                            //Else get the directory that is two above the javac.exe file
                            String path = response.substring(pathStartIndex, response.length());
                            File javacFile;
                            try {
                                javacFile = UnixOperations.resolveSymbolicLink(new File(path));
                                File jdkInstallationDir = javacFile.getParentFile().getParentFile();
                                jdkPath = jdkInstallationDir.getAbsolutePath();
                            } catch (IOException e) {
                                /* 
                                 * Should not occur since we already tested that this will
                                 * only be executed on not Windows machines.
                                 */
                                EASyLoggerFactory.INSTANCE.getLogger(JavaUtilities.class, Bundle.ID).exception(e);
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            /*
             * In case of any errors, JDK_PATH shall return null instead of crashing the OSGI environment of EASy.
             */
            EASyLoggerFactory.INSTANCE.getLogger(JavaUtilities.class, Bundle.ID).exception(e);
        }
        
        //checkstyle: resume exception type check 
        
        return jdkPath;
    }

    /**
     * Executes the given command inside the command line and returns the result of the command.
     * Part of the {@link #determineJDKDir()} method.
     * @param command A windows or unix command to execute on the command line.
     * @return The result of the executed command.
     * @see <a href="http://stackoverflow.com/questions/15725601/finding-jdk-path-and-storing-it-as-a-string-in-java">
     * http://stackoverflow.com/questions/15725601/finding-jdk-path-and-storing-it-as-a-string-in-java</a>
     */
    private static String getCommandOutput(String command)  {
        //the string to return
        String output = null;       

        Process process = null;
        BufferedReader reader = null;
        InputStreamReader streamReader = null;
        InputStream stream = null;

        //checkstyle: stop exception type check 
        try {
            process = Runtime.getRuntime().exec(command);

            //Get stream of the console running the command
            stream = process.getInputStream();
            streamReader = new InputStreamReader(stream);
            reader = new BufferedReader(streamReader);

            String currentLine = null;  //store current line of output from the cmd
            StringBuilder commandOutput = new StringBuilder();  //build up the output from cmd
            while ((currentLine = reader.readLine()) != null) {
                commandOutput.append(currentLine);
            }

            int returnCode = process.waitFor();
            if (returnCode == 0) {
                output = commandOutput.toString();
            }
        } catch (Exception e) {
            EASyLoggerFactory.INSTANCE.getLogger(JavaUtilities.class, Bundle.ID).exception(e);
        } finally {
            //Close all inputs / readers

            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException e) {
                    EASyLoggerFactory.INSTANCE.getLogger(JavaUtilities.class, Bundle.ID).exception(e);
                }
            } 
            if (streamReader != null) {
                try {
                    streamReader.close();
                } catch (IOException e) {
                    EASyLoggerFactory.INSTANCE.getLogger(JavaUtilities.class, Bundle.ID).exception(e);
                }
            }
            if (reader != null) {
                try {
                    streamReader.close();
                } catch (IOException e) {
                    System.err.println("Cannot close stream input reader! " + e);
                }
            }
        }
        //checkstyle: resume exception type check 
        
        //Return the output from the command - may be null if an error occured
        return output;
    }
    
    /**
     * Determines the JRE class path.
     * 
     * @return String array containing all libs
     */
    private static String[] determineJREClassPath() {
        String result = System.getProperty("java.class.path");
        if (null == result) {
            result = JDK_PATH + "lib/rt.jar";
        }
        return new String[] {result};
    }
}
