package de.uni_hildesheim.sse.easy.cmd;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Helper class for testing commandline comands.
 * @author El-Sharkawy
 *
 */
class ProcessExecuter {
    
    private Process process;
    private BufferedReader inStream;
    private BufferedReader errStream;

    /**
     * Creates a new Instance and executes the given <tt>command</tt> in a new java process.
     * @param cmd The command which shall be executed.
     * @throws  SecurityException
     *          If a security manager exists and its
     *          {@link SecurityManager#checkExec checkExec}
     *          method doesn't allow creation of the subprocess
     *
     * @throws  IOException
     *          If an I/O error occurs
     *
     * @throws  NullPointerException
     *          If <code>command</code> is <code>null</code>
     *
     * @throws  IllegalArgumentException
     *          If <code>command</code> is empty
     */
    public ProcessExecuter(String command) throws IOException {
        process = Runtime.getRuntime().exec(command, null, AllTests.AUT_DIR);
        inStream = new BufferedReader( new InputStreamReader(process.getInputStream()));
        errStream = new BufferedReader( new InputStreamReader(process.getErrorStream()));
    }
    
    /**
     * Starts a Java program (a main class).
     * This constructor inserts a "java -classpath AUT_LOCATION" in front of the given command.
     * @param command The Main method and the arguments which should be started.
     * @param logAll if <tt>true</tt> the default logging level will be used, if <tt>false</tt> only warnings will
     *     be printed. <tt>false</tt> should be sufficient for most calls.
     * @throws  SecurityException
     *          If a security manager exists and its
     *          {@link SecurityManager#checkExec checkExec}
     *          method doesn't allow creation of the subprocess
     *
     * @throws  IOException
     *          If an I/O error occurs
     */
    public ProcessExecuter(String command, boolean logAll) throws IOException{
        List<String> commands = new ArrayList<String>();
        commands.add("java");
        commands.add("-cp");
        commands.add("." + File.pathSeparatorChar + AllTests.AUT_LIBS.getCanonicalPath() + File.separator + "*");
        if (!logAll) {
            commands.add("-Dde.uni_hildesheim.sse.easy.logging.level=WARN");
        }
        String[] cmdsAsArray = command.split(" ");
        for (int i = 0; i < cmdsAsArray.length; i++) {
            commands.add(cmdsAsArray[i]);
        }
        System.out.println(Arrays.toString(commands.toArray()));
        
        ProcessBuilder builder = new ProcessBuilder(commands);
        builder.directory(AllTests.AUT_DIR);   
        process = builder.start();
        inStream = new BufferedReader( new InputStreamReader(process.getInputStream()));
        errStream = new BufferedReader( new InputStreamReader(process.getErrorStream()));
    }
    
    /**
     * Input stream where successful messages will be printed.
     * @return Input stream of successful messages.
     */
    public BufferedReader getInStream() {
        return inStream;
    }

    /**
     * Input stream where error messages will be printed.
     * @return Input stream of error messages.
     */
    public BufferedReader getErrStream() {
        return errStream;
    }
    
    /**
     * Executes the given command.
     * @return in case of an error the caught error message, <tt>null</tt> otherwise.
     * @throws IOException
     */
    public String execute() throws IOException {
        // TODO check: typically this is done in an own thread! fails for reasoning - waitFor workaround
        StringBuffer msg = new StringBuffer();
        String line = null;
        
        // Collect all normal messages, before collecting all errors.
        while((line = getInStream().readLine()) != null) {
            msg.append(line);
            msg.append("\n");
        }
        System.out.println(msg);
        
        //Collect and return all errors
        msg = new StringBuffer();
        while((line = getErrStream().readLine()) != null) {
            msg.append(line);
            msg.append("\n");
        }
        
        return msg.length() == 0 ? null : msg.toString();
    }
    
    /**
     * Just waits for the end of the process.
     * 
     * @return the process return code
     * @throws InterruptedException in case that the process is interrupted
     */
    public int waitFor() throws InterruptedException {
        return process.waitFor();
    }
}
