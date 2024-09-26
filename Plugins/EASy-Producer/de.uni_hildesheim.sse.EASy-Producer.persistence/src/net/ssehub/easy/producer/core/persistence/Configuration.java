package net.ssehub.easy.producer.core.persistence;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.producer.core.persistence.internal.Activator;
import net.ssehub.easy.producer.core.persistence.internal.IndentationPrintWriter;
import net.ssehub.easy.producer.core.persistence.internal.util.FileUtils;
import net.ssehub.easy.producer.core.persistence.standard.PersistenceConstants;

/**
 * Implements the base (path) configuration of EASy. The configuration normalized the given paths ({@link FileUtils}. 
 * Internally, configurations store a timestamp in order to determine when to reload them. This class supports the old
 * legacy configuration format (just for reading) and the new XML-based format (reading and writing).
 * 
 * @author Holger Eichelberger
 */
public class Configuration {
    
    public static final Configuration DEFAULT = new Configuration();
    
    public static final String TOP_LEVEL_CONFIG_NAME = ".EASyProducer";
    
    private static final EASyLogger LOGGER = EASyLoggerFactory.INSTANCE.getLogger(Configuration.class, 
        Activator.PLUGIN_ID);
    
    // configuration values
    
    private Map<PathKind, List<String>> paths;
    
    // internal
    
    private File projectFolder;
    private File file;
    private long timestamp;
    private boolean fromFile;

    /**
     * Defines the supported paths.
     * 
     * @author Holger Eichelberger
     */
    public enum PathKind {
        
        /**
         * The path to the IVML models.
         */
        IVML,
        
        /**
         * The path to the VIL models.
         */
        VIL,

        /**
         * The path to the VTL models.
         */
        VTL;
    }

    /**
     * Creates the default configuration. Calls {@link #setToEASyDefaults}.
     */
    private Configuration() {
        createStructures();
        setToEASyDefaults();
    }
    
    /**
     * Creates a copy of the given configuration.
     * 
     * @param src the source to copy from
     */
    Configuration(Configuration src) {
        if (null == src) {
            src = DEFAULT;
        }
        this.projectFolder = src.projectFolder;
        this.file = src.file;
        this.timestamp = src.timestamp;
        createStructures();
        for (PathKind kind: PathKind.values()) {
            this.paths.put(kind, new ArrayList<String>(src.paths.get(kind)));
        }
    }
    
    /**
     * Creates a new configuration.
     * 
     * @param projectFolder the (canonical) project folder
     */
    Configuration(File projectFolder) {
        createStructures();
        this.projectFolder = projectFolder;
        this.file = new File(this.projectFolder, TOP_LEVEL_CONFIG_NAME);
        if (file.exists()) {
            load();
        } else {
            initDefaults();
        }
    }
    
    /**
     * Checks this configuration for modifications since last reading it.
     */
    void checkForModification() {
        if (!isRecent()) {
            load();
        }
    }
    
    /**
     * Returns whether this configuration is (initially) read from file or based on internal settings/defaults.
     * 
     * @return {@code true} if read from file, {@code false} else
     */
    public boolean isFromFile() {
        return fromFile;
    }
    
    /**
     * Sets all three paths to {@link PersistenceConstants#EASY_FILES_DEFAULT}.
     */
    public void setToEASyDefaults() {
        setPathDirect(PathKind.IVML, PersistenceConstants.EASY_FILES_DEFAULT);
        setPathDirect(PathKind.VIL, PersistenceConstants.EASY_FILES_DEFAULT);
        setPathDirect(PathKind.VTL, PersistenceConstants.EASY_FILES_DEFAULT);
        fromFile = false;
    }
    
    /**
     * Returns whether the configuration file is recent.
     * 
     * @return <code>true</code> if the configuration file is recent and does not need to be reloaded, 
     *   <code>false</code> else
     */
    public boolean isRecent() {
        boolean recent;
        if (file.exists() && timestamp > 0) {
            recent = file.lastModified() > timestamp;
        } else {
            recent = true; // don't override if file does not exist 
        }
        return recent;
    }
    
    /**
     * Returns whether the configuration was materialized (stored) or whether this configuration 
     * consists of values loaded from default settings.
     * 
     * @return <code>true</code> if this configuration was materialized, <code>false</code> else
     */
    public boolean isMaterialized() {
        return null != file && file.exists();
    }

    /**
     * Reads the configuration from the old (legacy) format.
     * 
     * @param firstLine the first line read for identifying the file format
     * @param lnr the line number reader to read the remaining lines of the file
     * @throws IOException in case of I/O problems
     */
    private void readOldFormat(String firstLine, LineNumberReader lnr) throws IOException {
        if (null != firstLine) {
            setPathDirect(PathKind.IVML, firstLine);
            String line = lnr.readLine();
            if (null != line) {
                setPathDirect(PathKind.VIL, line); // legacy format v2
                setPathDirect(PathKind.VTL, line);
            } else {
                setPathDirect(PathKind.VIL, firstLine); // legacy format v1
                setPathDirect(PathKind.VTL, firstLine);
            }
        }
    }

    /**
     * Reads the configuration for the extensible XML format.
     * 
     * @param reader the reader to read from
     * @throws IOException in case of I/O problems
     */
    private void readXmlFormat(Reader reader) throws IOException {
        try {
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            XMLReader xmlReader = parser.getXMLReader();
            InputSource inputSource = new InputSource(reader);
            xmlReader.setContentHandler(new ConfigurationContentHandler(this));
            xmlReader.parse(inputSource);
            if (null == getPath(PathKind.VTL, 0)) {
                // set VTL path by default to VIL path
                setPathDirect(PathKind.VTL, combinePath(PathKind.VIL));
            }
        } catch (ParserConfigurationException | SAXException e) {
            throw new IOException(e);
        }
    }
    
    /**
     * Loads the configuration file.
     */
    private void load() {
        if (null != file) { // -> DEFAULT
            clear();
            
            FileReader reader = null;
            try {
                reader = new FileReader(file);
                if (reader.markSupported()) {
                    reader.mark(0);
                } 
                LineNumberReader lnr = new LineNumberReader(reader);
                String line = lnr.readLine();
                if (null != line && line.trim().startsWith("<?xml")) {
                    if (reader.markSupported()) {
                        reader.reset();
                    } else {
                        try {
                            reader.close();
                        } catch (IOException e) {
                        }
                        reader = new FileReader(file);
                    }
                    readXmlFormat(reader);
                } else {
                    readOldFormat(line, lnr);
                }
                reader.close();
                timestamp = file.lastModified();
                fromFile = true;
            } catch (IOException e) {
                LOGGER.warn("configuration I/O problem: " + e.getMessage());
                if (null != reader) {
                    try {
                        reader.close();
                    } catch (IOException e1) {
                    }
                }
            }
            
            initDefaults(); // lazy post init
        }
    }
        
    // configuration access - implement further configurations here

    /**
     * Creates the initial structures / objects for configuration attributes.
     */
    private void createStructures() {
        paths = new HashMap<PathKind, List<String>>();
        for (PathKind kind : PathKind.values()) {
            paths.put(kind, new ArrayList<String>());
        }
    }
    
    /**
     * Initializes configuration values lazily with default values.
     */
    private void initDefaults() {
        for (PathKind kind : PathKind.values()) {
            setPathDefault(kind);
        }
    }
    
    /**
     * Clears the configuration.
     */
    private void clear() {
        for (PathKind kind : PathKind.values()) {
            paths.get(kind).clear();
        }        
    }
    
    /**
     * Sets the default value of a path in case that it has not been set before (lazy).
     * 
     * @param kind the path kind to set the default value
     */
    private void setPathDefault(PathKind kind) {
        if (paths.get(kind).isEmpty()) {
            paths.get(kind).addAll(DEFAULT.paths.get(kind));
        }
    }
    
    /**
     * Checks the given path.
     * 
     * @param path the path to be checked
     * @return a modified path if required
     */
    public static String checkPath(String path) {
        if (!path.endsWith(FileUtils.SEPARATOR_STRING)) {
            path += FileUtils.SEPARATOR_STRING; // local modification
        }
        return path;
    }
    
    /**
     * Sets a path due to its string representation, thus, be careful. This method does not store the new configuration.
     * If {@code path} contains multiple paths, e.g., separated by ";" or ":", they will be set at once.
     * 
     * @param kind the path kind to modify
     * @param path the path value
     * @see #combinePath(PathKind)
     */
    public void setPathDirect(PathKind kind, String path) {
        if (!path.endsWith(FileUtils.SEPARATOR_STRING)) {
            path += FileUtils.SEPARATOR_STRING;
        }
        List<String> pth = paths.get(kind);
        pth.clear();
        for (String s: path.replace(":", ";").split(";")) {
            pth.add(s);
        }
    }
    
    /**
     * Sets the given path and stores the new configuration.
     * 
     * @param kind the kind of path to be modified
     * @param path the new path value
     * @throws IOException in case that setting the path fails as the canonical path cannot be identified
     * 
     * @see #setPath(PathKind, File)
     */
    public void setPath(PathKind kind, String path) throws IOException {
        setPath(kind, new File(path));
    }

    /**
     * Sets the given path.
     * 
     * @param kind the kind of path to be modified
     * @param path the new path value
     * @throws IOException in case that setting the path fails as the canonical path cannot be identified
     */
    public void setPath(PathKind kind, File path) throws IOException {
        String sPath = path.getCanonicalPath();
        if (null != projectFolder) { // -> DEFAULT
            String pPath = projectFolder.getPath();
            if (!pPath.endsWith(File.separator)) {
                pPath += File.separator;
            }
            if (sPath.startsWith(pPath)) {
                sPath = sPath.substring(pPath.length());
            }
        }
        setPathDirect(kind, FileUtils.toIndependent(path.getPath()));
    }

    /**
     * Returns the number of configured paths per {@code kind}.
     * 
     * @param kind the path kind
     * @return the number of paths
     */
    public int getPathCount(PathKind kind) {
        return paths.get(kind).size();
    }

    /**
     * Returns a path as a string.
     * 
     * @param kind the path kind
     * @param index the path index
     * @return the related path, <b>null</b> if none was configured for {@code kind}
     * @throws IndexOutOfBoundsException if not within range of {@link #getPathCount(PathKind)}
     */
    public String getPath(PathKind kind, int index) {
        return paths.get(kind).isEmpty() ? null : paths.get(kind).get(index);
    }
    
    /**
     * Returns whether the specified path is the same as the internal EASy default value.
     * 
     * @param kind the path kind
     * @return <code>boolean</code> if the specified path is the same, <code>false</code> else
     */
    public boolean isPathEasyDefault(PathKind kind) {
        return PersistenceConstants.EASY_FILES_DEFAULT.equals(getPath(kind, 0));
    }

    /**
     * Returns a path as a file within the containing project.
     * 
     * @param kind the path kind
     * @param index the path index
     * @return the related path
     * @throws IndexOutOfBoundsException if not within range of {@link #getPathCount(PathKind)}
     */
    public File getPathFile(PathKind kind, int index) {
        return new File(projectFolder, getPath(kind, index));
    }
    
    /**
     * Stores the configuration values.
     */
    public void store() {
        if (null != file) { // -> DEFAULT
            IndentationPrintWriter writer = null;
            try {
                writer = new IndentationPrintWriter(new FileWriter(file));
                writer.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
                writer.println("<" + ConfigurationContentHandler.XML_ELT_CONFIGURATION + ">");
                writer.increaseIndentation();
                for (PathKind kind : PathKind.values()) {
                    storePath(writer, kind);
                }
                writer.decreaseIndentation();
                writer.println("</" + ConfigurationContentHandler.XML_ELT_CONFIGURATION + ">");
                writer.close();
            } catch (IOException e) {
                LOGGER.warn("configuration I/O problem: " + e.getMessage());
            }
            timestamp = file.lastModified();
        }
    }
    
    /**
     * Returns all paths for {@code kind} combined by the system path separator.
     * 
     * @param kind the kind
     * @return the combined path
     */
    public String combinePath(PathKind kind) {
        String result;
        List<String> pth = paths.get(kind);
        if (pth.isEmpty()) {
            result = null;
        } else {
            result = "";
            for (int p = 0; p < pth.size(); p++) {
                if (p > 0) {
                    result += File.pathSeparator;
                }
                result += pth.get(p);
            }
        }
        return result;
    }
    
    /**
     * Stores a given path.
     * 
     * @param writer the writer to store the path to
     * @param kind the path kind to store
     */
    private void storePath(IndentationPrintWriter writer, PathKind kind) {
        String path = combinePath(kind);
        if (null != path && path.length() > 0) {
            writer.printIndentation();
            writer.print("<" + ConfigurationContentHandler.XML_ELT_PATH + " " 
                + ConfigurationContentHandler.XML_ATTR_KIND + "=\"");
            writer.print(kind.name());
            writer.print("\" " + ConfigurationContentHandler.XML_ATTR_VALUE + "=\"");
            writer.print(path);
            writer.println("\" />");
        }
    }

}
