package de.uni_hildesheim.sse.easy.ant;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;

import org.apache.tools.ant.Task;
import org.apache.tools.ant.types.selectors.SelectorUtils;

import de.uni_hildesheim.sse.easy.loader.Generator;
import de.uni_hildesheim.sse.easy.loader.IExclusionSelector;

/**
 * Ant Task that will start the automated generation.
 * @author Patu
 */
public class AntGenerator extends Task {

    private static final boolean DEBUG = false;
    private Vector<BaseFeature> base = new Vector<BaseFeature>();
    private Vector<AddFeature> addF = new Vector<AddFeature>();
    private boolean forced = true;
    private String pluginPath = ".";
    private String target = "newGenerator";
    private String eclipsePath = "plugins/eclipse";
    private String baseDir = ".";
    private String libsPath = ".";
    private IExclusionSelector exclusionSelector = null;
    
    /**
     * Where to find compiled classes, relative to base dir.
     */
    private String classesPath = "bin";
    
    /**
     * Adds a base file for the generator.
     * @return the basefeature object.
     */
    public BaseFeature createBaseFeature() {
        BaseFeature base = new BaseFeature();
        this.base.add(base);
        return base;
    }
    
    /**
     * Adds a additonal file for the generator.
     * @return the additonal object.
     */
    public AddFeature createAddFeature() {
        AddFeature addF = new AddFeature();
        this.addF.add(addF);
        return addF;
    }
    
    /**
     * Sets the path for the required libs.
     * @param libs Path to the libs.
     */
    public void setLibsPath(String libs) {
        if (null != libs) {
            this.libsPath = libs;
        }
    }
    
    /**
     * Adds a target for the generated JARS.
     * @param target The target as String.
     */
    public void setTarget(String target) {
        if (null != target) {
            this.target = target;
        }
    }
    
    /**
     * Defines optional global exclusion patterns.
     * 
     * @param excludes the exclusion patterns
     */
    public void setExcludes(String excludes) {
        this.exclusionSelector = new AntPathExclusionSelector(excludes);
    }
    
    /**
     * Implements a global exclusion selector based on ANT patterns.
     * 
     * @author Holger Eichelberger
     */
    private static class AntPathExclusionSelector implements IExclusionSelector {

        private List<String> patterns = new ArrayList<String>();
        
        /**
         * Creates an exclusion selector.
         * 
         * @param excludes the exclude patterns in ANT-style, comma separated
         */
        private AntPathExclusionSelector(String excludes) {
            StringTokenizer tok = new StringTokenizer(excludes, ", ", false); // ANT style
            while (tok.hasMoreTokens()) {
                patterns.add(tok.nextToken());
            }
        }
        
        @Override
        public boolean isExcluded(String name) {
            boolean excluded = false;
            for (int p = 0; !excluded && p < patterns.size(); p++) {
                excluded = SelectorUtils.match(patterns.get(p), name);
            }
            return excluded;
        }
        
    }
    
    /**
     * Sets the path for eclipse plugins.
     * @param eclipsePath The target as String.
     */
    public void setEclipsePath(String eclipsePath) {
        if (null != eclipsePath) {
            this.eclipsePath = eclipsePath;
            System.out.println("Eclipse Path is: " + eclipsePath);
        }
    }

    /**
     * Sets the baseDir for the bootstrap of the generator.
     * @param baseDir the base as String.
     */
    public void setBaseDir(String baseDir) {
        if (null != baseDir) {
            this.baseDir = baseDir;
        }
    }
    
    /**
     * Sets whether the Generator should force a build.
     * TRUE is default.
     * @param forced anything but 0, no and false will cause the build to be forced.
     */
    public void setForced(String forced) {
        if (null != forced) {
            forced = forced.toLowerCase();
            if (forced.equals("0") || forced.equals("no") || forced.equals("false")) {
                this.forced = false;
            }
        }
    }
    
    /**
     * Sets the path for the plugins. Defines the bootstrap base.
     * @param pluginPath The path of the plugins as string.
     */
    public void setPluginPath(String pluginPath) {
        if (null != pluginPath) {
            this.pluginPath = pluginPath;
        }
    }
    
    /**
     * Setter for the path of compiled classes.
     * @param classesPath Where to find the compiled classes, relative to basePath.
     */
    public void setClassesPath(String classesPath) {
        if (null != pluginPath) {
            this.classesPath = classesPath;
        }
    }
    
    /**
     * The task executer.
     */
    public void execute() {
        if (DEBUG) {
            System.out.println();
            System.out.println("Base: ");
            for (int i = 0; i < base.size(); i++) {
                System.out.println(base.get(i).getFile().getAbsolutePath());
            }
            System.out.println("Add: ");
            for (int i = 0; i < addF.size(); i++) {
                System.out.println(addF.get(i).getFile().getAbsolutePath());
            }
            System.out.println("Forced: " + forced);
        }
        
        List<File> baseList = new ArrayList<File>();
        List<File> addList = new ArrayList<File>();
        
        for (int i = 0; i < base.size(); i++) {
            baseList.add(base.get(i).getFile());
        }
        
        for (int i = 0; i < addF.size(); i++) {
            addList.add(addF.get(i).getFile());
        }
        
        if (DEBUG) {
            System.out.println();
            System.out.println("Base: ");
            for (int i = 0; i < baseList.size(); i++) {
                System.out.println(baseList.get(i).getAbsolutePath());
            }
            System.out.println("Add: ");
            for (int i = 0; i < addList.size(); i++) {
                System.out.println(addList.get(i).getAbsolutePath());
            }
        }
        Generator.setExclusionSelector(exclusionSelector);
        Generator.autoGenerate(baseList, addList, forced, pluginPath, eclipsePath, target, baseDir, 
                classesPath, libsPath);
        
    }
    
    /**
     * This class represents base features.
     * @author Patu
     *
     */
    public class BaseFeature {
        
        private String path;
        private File file = null;
        
        /**
         * Constructor.
         */
        public BaseFeature() {}

        
        /**
         * Sets the path attribute.
         * @param path the path as a string
         */
        public void setPath(String path) {
            this.path = path;
        }
        
        /**
         * Returns the actual file.
         * @return the actual file
         */
        public File getFile() {
            if (null != path) {
                if (null == file) {
                    file = new File(path);
                }
            }
            return file;        
        }
        
    }
    
    /**
     * This class represents additional features.
     * @author Patu
     *
     */
    public class AddFeature {
        
        private String path;
        private File file = null;
        
        /**
         * Consturctor.
         */
        public AddFeature() {}

        
        /**
         * Sets the path attribute.
         * @param path the path as a string
         */
        public void setPath(String path) {
            this.path = path;
        }
        
        /**
         * returns the actual File.
         * @return the actual file
         */
        public File getFile() {
            if (null != path) {
                if (null == file) {
                    file = new File(path);
                }
            }
            return file;        
        }
        
    }
    
}
