package de.uni_hildesheim.sse.easy.loader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;

import de.uni_hildesheim.sse.easy.loader.framework.Log;
import de.uni_hildesheim.sse.easy.loader.framework.Utils;

/**
 * Implements an EASy loader which obtains the start sequence from a text file.
 * 
 * @author Holger Eichelberger
 */
public class ListLoader {

    public static final String EASY_STARTUP_FILE_NAME = ".easyStartup";
    private List<StartupInfo> startupSequence = new ArrayList<StartupInfo>();
    private boolean verbose = false;

    /**
     * Defines the initialization types supported by this loader.
     * 
     * @author Holger Eichelberger
     */
    public enum InitType {
        
        /**
         * An OSGi activator startup / shutdown.
         */
        ACTIVATOR,
        
        /**
         * An Eclipse DS startup / shutdown.
         */
        DS;
    }
    
    /**
     * Stores startup information about a certain class.
     * 
     * @author Holger Eichelberger
     */
    private class StartupInfo {
        private InitType type;
        private String className;
        
        /**
         * Creates a startup information object.
         * 
         * @param type the startup / shutdown type
         * @param className the class to be started / stopped
         */
        StartupInfo(InitType type, String className) {
            this.type = type;
            this.className = className;
        }
        
        /**
         * Starts up the associated class according to the startup type.
         * 
         * @return <code>true</code> in case of success, <code>false</code> else
         */
        public boolean start() {
            boolean result;
            switch(type) {
            case ACTIVATOR:
                if (verbose) {
                    Log.info("START activator " + className);
                }
                result = Utils.startBundle(getClass().getClassLoader(), className);
                break;
            case DS:
                if (verbose) {
                    Log.info("START DS " + className);
                }
                result = Utils.activateDsInstance(getClass().getClassLoader(), className);
                break;
            default:
                result = false;
                break;
            }
            return result;
        }

        /**
         * Stops the associated class according to the shutdown type.
         * 
         * @return <code>true</code> in case of success, <code>false</code> else
         */
        public boolean stop() {
            boolean result;
            switch(type) {
            case ACTIVATOR:
                if (verbose) {
                    Log.info("STOP activator " + className);
                }
                result = Utils.stopBundle(getClass().getClassLoader(), className);
                break;
            case DS:
                if (verbose) {
                    Log.info("STOP DS " + className);
                }
                result = Utils.deactivateDsInstance(getClass().getClassLoader(), className);
                break;
            default:
                result = false;
                break;
            }
            return result;
        }
        
    }
    
    /**
     * Creates a list loader which reads the startup sequence from the current class loader.
     * 
     * @throws IOException in case of loading the startup sequence fails
     */
    public ListLoader() throws IOException {
        this(null);
    }
    
    /**
     * Creates a list loader which reads the startup sequence from the given file.
     * 
     * @param listFile the file to consider (may be <b>null</b> for reading information from a
     *   classloader resource)
     * @throws IOException in case of loading the startup sequence fails
     */
    public ListLoader(File listFile) throws IOException {
        InputStream is;
        if (null == listFile) {
            is = getClass().getClassLoader().getResourceAsStream(EASY_STARTUP_FILE_NAME);
        } else {
            is = new FileInputStream(listFile);
        }
        LineNumberReader lnr = new LineNumberReader(new InputStreamReader(is));
        String line = null;
        do {
            line = lnr.readLine();
            if (null != line) {
                processLine(line);
            }
        } while (null != line);
        Utils.closeQuietly(is);
    }
    
    /**
     * Performs EASy startup activities.
     */
    public void startup() {
        for (StartupInfo info : startupSequence) {
            info.start();
        }
    }

    /**
     * Performs EASy shutdown activities.
     */
    public void shutdown() {
        for (StartupInfo info : startupSequence) {
            info.stop();
        }
    }
    
    /**
     * Processes a single line from the startup sequence file.
     * 
     * @param line the line to be processed
     */
    private void processLine(String line) {
        int pos = line.indexOf(':');
        if (pos > 0 && line.length() > pos) {
            String marker = line.substring(0, pos).trim();
            String className = line.substring(pos + 1).trim();
            InitType type = InitType.valueOf(marker); // TODO check result
            if (null != type) {
                startupSequence.add(new StartupInfo(type, className));
            }
        }
    }
    
    /**
     * Changes the verbosity mode.
     * 
     * @param verbose shall we be verbose?
     */
    public void setVerbose(boolean verbose) {
        this.verbose = verbose;
    }

}
