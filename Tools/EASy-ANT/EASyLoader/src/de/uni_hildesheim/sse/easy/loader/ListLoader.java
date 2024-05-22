package de.uni_hildesheim.sse.easy.loader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import de.uni_hildesheim.sse.easy.loader.framework.Utils;

/**
 * Implements an EASy loader which obtains the start sequence from a text file.
 * 
 * @author Holger Eichelberger
 */
public class ListLoader implements ILoader {

    public static final String EASY_STARTUP_FILE_NAME = ".easyStartup";
    private List<StartupInfo> startupSequence = new ArrayList<StartupInfo>();
    private boolean verbose = false;

    /**
     * Creates a list loader that reads the startup sequence from the current class loader, i.e., 
     * from {@link #EASY_STARTUP_FILE_NAME}.
     * 
     * @throws IOException in case of loading the startup sequence fails
     */
    public ListLoader() throws IOException {
        this((File) null);
    }

    /**
     * Creates a list loader that reads the startup sequence from the given file.
     * 
     * @param listFile the file to consider (may be <b>null</b> for reading information from the defailt
     *   classloader resource)
     * @throws IOException in case of loading the startup sequence fails
     */
    public ListLoader(File listFile) throws IOException {
        this(listFile, ListLoader.class.getClassLoader());
    }

    /**
     * Creates a list loader that reads the startup sequence from the given file.
     * 
     * @param listFile the file to consider (may be <b>null</b> for reading information from {@code loader})
     * @param loader the class loader to load from
     * @throws IOException in case of loading the startup sequence fails
     */
    public ListLoader(File listFile, ClassLoader loader) throws IOException {
        InputStream is;
        if (null == listFile) {
            is = loader.getResourceAsStream(EASY_STARTUP_FILE_NAME);
        } else {
            is = new FileInputStream(listFile);
        }
        load(is);
        Utils.closeQuietly(is);
    }

    /**
     * Creates a list loader that reads the startup sequence from an input stream. {@code is} will
     * not be closed by this constructor.
     * 
     * @param is the input stream containing the startup sequence
     * @throws IOException in case of loading the startup sequence fails
     */
    public ListLoader(InputStream is) throws IOException {
        load(is);
    }

    /**
     * Creates a list loader that reads the startup sequence from a reader. {@code reader} will
     * not be closed by this constructor.
     * 
     * @param reader the reader providing access to the startup sequence
     * @throws IOException in case of loading the startup sequence fails
     */
    public ListLoader(Reader reader) throws IOException {
        load(reader);
    }

    /**
     * Loads the startup sequence from an input stream. {@code is} will not be closed by this method.
     * 
     * @param is the input stream containing the startup sequence
     * @throws IOException in case of loading the startup sequence fails
     */
    private void load(InputStream is) throws IOException {
        load(new InputStreamReader(is));
    }

    /**
     * Loads the startup sequence from a reader. {@code reader} will not be closed by this method.
     * 
     * @param reader the reader providing access to the startup sequence
     * @throws IOException in case of loading the startup sequence fails
     */
    private void load(Reader reader) throws IOException {
        LineNumberReader lnr = new LineNumberReader(reader);
        String line = null;
        do {
            line = lnr.readLine();
            if (null != line) {
                processLine(line);
            }
        } while (null != line);
    }
    
    @Override
    public void startup() {
        for (StartupInfo info : startupSequence) {
            info.start();
        }
    }

    @Override
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
                startupSequence.add(new StartupInfo(type, className, verbose));
            }
        }
    }
    
    @Override
    public void setVerbose(boolean verbose) {
        this.verbose = verbose;
        for (StartupInfo info : startupSequence) {
            info.setVerbose(verbose);
        }
    }

}
