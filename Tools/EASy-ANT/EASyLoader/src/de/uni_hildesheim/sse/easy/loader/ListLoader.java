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
public class ListLoader extends AbstractStartupInfoLoader {

    public static final String EASY_STARTUP_FILE_NAME = ".easyStartup";

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
        super(load(getStream(listFile, loader)));
    }

    /**
     * Creates a list loader that reads the startup sequence from an input stream. {@code is} will
     * be closed by this constructor.
     * 
     * @param is the input stream containing the startup sequence
     * @throws IOException in case of loading the startup sequence fails
     */
    public ListLoader(InputStream is) throws IOException {
        super(load(is));
    }

    /**
     * Creates a list loader that reads the startup sequence from a reader. {@code reader} will
     * be closed by this constructor.
     * 
     * @param reader the reader providing access to the startup sequence
     * @throws IOException in case of loading the startup sequence fails
     */
    public ListLoader(Reader reader) throws IOException {
        super(load(reader));
    }

    /**
     * Loads the startup sequence from an input stream. {@code is} will not be closed by this method.
     * 
     * @param is the input stream containing the startup sequence
     * @return the loaded startup information
     * @throws IOException in case of loading the startup sequence fails
     */
    private static List<StartupInfo> load(InputStream is) throws IOException {
        return load(new InputStreamReader(is));
    }

    /**
     * Returns the underlying input stream.
     * 
     * @param listFile the file to consider (may be <b>null</b> for reading information from {@code loader})
     * @param loader the class loader to load from
     * @return the input stream
     * @throws IOException in case of loading the startup sequence fails
     */
    private static InputStream getStream(File listFile, ClassLoader loader) throws IOException {
        InputStream is;
        if (null == listFile) {
            is = loader.getResourceAsStream(EASY_STARTUP_FILE_NAME);
        } else {
            is = new FileInputStream(listFile);
        }
        return is;
    }

    /**
     * Loads the startup sequence from a reader. {@code reader} will be closed by this method.
     * 
     * @param reader the reader providing access to the startup sequence
     * @return the loaded startup information
     * @throws IOException in case of loading the startup sequence fails
     */
    private static List<StartupInfo> load(Reader reader) throws IOException {
        List<StartupInfo> result = new ArrayList<StartupInfo>();
        LineNumberReader lnr = new LineNumberReader(reader);
        String line = null;
        do {
            line = lnr.readLine();
            if (null != line) {
                processLine(line, result);
            }
        } while (null != line);
        Utils.closeQuietly(reader);
        return result;
    }
    
    /**
     * Processes a single line from the startup sequence file.
     * 
     * @param line the line to be processed
     * @param startupSequence the startup sequence to be modified as a side effect
     */
    private static void processLine(String line, List<StartupInfo> startupSequence) {
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

}
