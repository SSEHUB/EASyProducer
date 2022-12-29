/*
 * Copyright 2009-2021 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.producer.core.mgmt;

import java.io.File;
import java.io.PrintStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.basics.modelManagement.IModelLoader;
import net.ssehub.easy.basics.modelManagement.IModelLoader.IModelInfoHolder;
import net.ssehub.easy.basics.modelManagement.ModelInfo;
import net.ssehub.easy.basics.modelManagement.ModelLocations.Location;
import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.instantiation.core.model.buildlangModel.BuildModel;
import net.ssehub.easy.instantiation.core.model.buildlangModel.Script;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.execution.Executor;
import net.ssehub.easy.instantiation.core.model.execution.TracerFactory;
import net.ssehub.easy.instantiation.core.model.templateModel.TemplateModel;
import net.ssehub.easy.instantiation.core.model.tracing.ConsoleTracerFactory;
import net.ssehub.easy.producer.core.persistence.internal.Activator;
import net.ssehub.easy.reasoning.core.frontend.ReasonerFrontend;
import net.ssehub.easy.reasoning.core.reasoner.Message;
import net.ssehub.easy.reasoning.core.reasoner.ReasonerConfiguration;
import net.ssehub.easy.reasoning.core.reasoner.ReasoningResult;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.management.VarModel;
import net.ssehub.easy.varModel.model.Project;

/**
 * Defines a configurable executor class to run the main steps of EASy-Producer in a convenient manner.
 * Besides configuration options, the following methods must be called in the given sequence to run EASy-Producer
 * <ol>
 *   <li>{@link #setupLocations()}</li>
 *   <li>{@link #loadIvmlModel()}</li>
 *   <li>{@link #reasonOnIvmlModel()}</li>
 *   <li>{@link #executeVil()}</li>
 *   <li>{@link #discardLocations()}</li>
 * </ol>
 * You may call these methods individually and handle the exceptions or you may call {@link #execute()} instead, which
 * performs exactly this sequence. In particular, configuration methods are stated in builder style, while the calls
 * mentioned above may return the specific results.
 * 
 * This class requires that EASy-Producer is loaded and initialized, either through an EASy-Loader, e.g., the 
 * ListLoader, through Eclipse plugins or, directly, through manually calling the required registration classes.
 *  
 * @author Holger Eichelberger
 */
public class EasyExecutor {

    private File base;
    private List<File> ivmlFolder = new ArrayList<File>();
    private File vilFolder;
    private File vtlFolder;
    private File vilSource;
    private File vilTarget;
    private String ivmlModelName;
    private String vilModelName;
    private String vilStartRuleName;
    private Map<String, Object> vilArguments;
    private Configuration cfg;
    private ProgressObserver observer = ProgressObserver.NO_OBSERVER;
    private ReasonerConfiguration rCfg;
    private TracerFactory tracerFactory = ConsoleTracerFactory.INSTANCE;
    private Logger logger = new Logger() {

        private EASyLogger logger = EASyLoggerFactory.INSTANCE.getLogger(EasyExecutor.class, Activator.PLUGIN_ID);
        
        @Override
        public void warn(String text) {
            logger.warn(text);
        }

        @Override
        public void error(String text) {
            logger.error(text);
        }
        
        @Override
        public void info(String text) {
            logger.info(text);
        }
        
    };
    
    /**
     * Defines a simple logger frontend interface.
     * 
     * @author Holger Eichelberger
     */
    public interface Logger {

        /**
         * Logs a warning.
         * 
         * @param text the warning text
         */
        public void warn(String text);
        
        /**
         * Logs an error.
         * 
         * @param text the error text
         */
        public void error(String text);
        
        /**
         * Logs an information.
         * 
         * @param text the information text
         */
        public void info(String text);
        
    }

    /**
     * Creates an instance of the executor with no folders/model names set. Only the progress observer (set to 
     * {@link ProgressObserver#NO_OBSERVER}), a default reasoner configuration, the 
     * {@link ConsoleTracerFactory#INSTANCE console tracer factory} and an {@link EASyLogger} are assigned.
     */
    public EasyExecutor() {
        rCfg = new ReasonerConfiguration();
    }
    
    /**
     * Creates an instance of the executor with basic information absolutely required to execute EASy-Producer. The 
     * progress observer is set to {@link ProgressObserver#NO_OBSERVER}, a default reasoner configuration, the 
     * {@link ConsoleTracerFactory#INSTANCE console tracer factory} and an {@link EASyLogger} are assigned.
     * 
     * @param project the basic project folder to which paths in VIL are assumed to be relative. Also used as project 
     *   folders for VIL for a self-instantiation (acts as {@link #setProjectBase(File)}, {@link #setVilSource(File)} 
     *   and {@link #setVilTarget(File)}). 
     * @param modelFolder the folder where IVML, VIL and VTL model files are located, usually a sub-folder of 
     *   {@code base} (acts as {@link #setIvmlFolder(File)}, {@link #setVilFolder(File)} and 
     *   {@link #setVtlFolder(File)}.
     * @param modelName the name of the model to load, assuming that IVML and VIL models have the same name (acts as 
     *   {@link #setIvmlModelName(String)} and {@link #setVilModelName(String)}).
     */
    public EasyExecutor(File project, File modelFolder, String modelName) {
        base = project;
        ivmlFolder.add(modelFolder);
        ivmlModelName = modelName;
        vilFolder = modelFolder;
        vilModelName = modelName;
        vtlFolder = modelFolder;
        vilSource = project;
        vilTarget = project;
        rCfg = new ReasonerConfiguration();
    }
    
    /**
     * Sets the project base needed to interpret relative path names correctly.
     *  
     * @param base the base folder
     * @return <b>this</b> (builder style)
     */
    public EasyExecutor setProjectBase(File base) {
        this.base = base;
        return this;
    }

    /**
     * Sets the IVML model folder where to load the IVML model from. This is initially set to the common model folder.
     * Further folders are added as dependent locations.
     *  
     * @param ivmlFolder the folder 
     * @return <b>this</b> (builder style)
     */
    public EasyExecutor setIvmlFolder(File ivmlFolder) {
        if (this.ivmlFolder.size() > 0) {
            this.ivmlFolder.set(0, ivmlFolder);
        } else {
            this.ivmlFolder.add(ivmlFolder);
        }
        return this;
    }
    
    /**
     * Adds this folder as main IVML model folder and turns all known folders to dependent locations.
     * 
     * @param ivmlFolder the new main IVML model folder
     * @return <b>this</b> (builder style)
     */
    public EasyExecutor prependIvmlFolder(File ivmlFolder) {
        this.ivmlFolder.add(0, ivmlFolder);
        return this;
    }
    
    /**
     * Adds an additional IVML folder. Additional folders are added as dependent locations.
     * 
     * @param ivmlFolder the additional IVML folder
     * @return <b>this</b> (builder style)
     */
    public EasyExecutor addIvmlFolder(File ivmlFolder) {
        this.ivmlFolder.add(ivmlFolder);
        return this;
    }

    /**
     * Sets the VIL model folder where to load the VIL model from. This is initially set to the common model folder.
     *  
     * @param vilFolder the folder 
     * @return <b>this</b> (builder style)
     */
    public EasyExecutor setVilFolder(File vilFolder) {
        this.vilFolder = vilFolder;
        return this;
    }

    /**
     * Sets the VTL model folder where to load the VTL models from. This is initially set to the common model folder.
     *  
     * @param vtlFolder the folder 
     * @return <b>this</b> (builder style)
     */
    public EasyExecutor setVtlFolder(File vtlFolder) {
        this.vtlFolder = vtlFolder;
        return this;
    }
    
    /**
     * Sets the VIL project source folder. This is initially set to the common project folder.
     *  
     * @param vilSource the folder 
     * @return <b>this</b> (builder style)
     */
    public EasyExecutor setVilSource(File vilSource) {
        this.vilSource = vilSource;
        return this;
    }

    /**
     * Sets the VIL project target folder. This is initially set to the common project folder. May be the same as 
     * {@link #setVilTarget(File)} for a self-instantiation or it may differ.
     *  
     * @param vilTarget the folder 
     * @return <b>this</b> (builder style)
     */
    public EasyExecutor setVilTarget(File vilTarget) {
        this.vilTarget = vilTarget;
        return this;
    }
    
    // do we need the versions here?

    /**
     * Sets the IVML model name. This is initially set to the common model name. 
     *  
     * @param ivmlModelName the model name 
     * @return <b>this</b> (builder style)
     */
    public EasyExecutor setIvmlModelName(String ivmlModelName) {
        this.ivmlModelName = ivmlModelName;
        return this;
    }

    /**
     * Sets the VIL model name. This is initially set to the common model name. 
     *  
     * @param vilModelName the model name 
     * @return <b>this</b> (builder style)
     */
    public EasyExecutor setVilModelName(String vilModelName) {
        this.vilModelName = vilModelName;
        return this;
    }
    
    /**
     * Adds a custom VIL start rule argument. If not called, no (additional) arguments will be passed to VIL (except for
     * the default VIL arguments of source, target and configuration) - don't try to specify those arguments here. 
     * Custom arguments must be declared in the VIL script.
     * 
     * @param name the name of the custom argument
     * @param value the value of the custom argument
     * @return <b>this</b> (builder style)
     */
    public EasyExecutor addVilArgument(String name, Object value) {
        if (null == vilArguments) {
            vilArguments = new HashMap<String, Object>();
        }
        vilArguments.put(name, value);
        return this;
    }
    
    /**
     * Sets the VIL start rule name. If not called, the default start rule name {@code main} is used.
     *   
     * @param vilStartRuleName the VIL start rule name (must be a non-empty string)
     * @return <b>this</b> (builder style)
     */
    public EasyExecutor setVilStartRuleName(String vilStartRuleName) {
        this.vilStartRuleName = vilStartRuleName;
        return this;
    }

    /**
     * Sets the progress observer instance. This is initially set to {@link ProgressObserver#NO_OBSERVER}. 
     *  
     * @param observer the observer instance
     * @return <b>this</b> (builder style)
     */
    public EasyExecutor setProgressObserver(ProgressObserver observer) {
        this.observer = observer;
        return this;
    }

    /**
     * Sets the reasoner configuration instance. This is initially set to an instance created by 
     * {@link ReasonerConfiguration#ReasonerConfiguration()}. 
     *  
     * @param rCfg the configuration instance
     * @return <b>this</b> (builder style)
     */
    public EasyExecutor setReasonerConfiguration(ReasonerConfiguration rCfg) {
        this.rCfg = rCfg;
        return this;
    }

    /**
     * Sets the tracer factory. Initially, the {@link ConsoleTracerFactory#INSTANCE console tracer factory} is set. 
     *  
     * @param tracerFactory the factory instance (<b>null</b> for the default one)
     * @return <b>this</b> (builder style)
     */
    public EasyExecutor setTracerFactory(TracerFactory tracerFactory) {
        this.tracerFactory = tracerFactory;
        return this;
    }
    
    /**
     * Sets the logger instance. Initially, the logger delegates to an {@link EASyLogger}. 
     *  
     * @param logger the logger instance
     * @return <b>this</b> (builder style)
     */
    public EasyExecutor setLogger(Logger logger) {
        this.logger = logger;
        return this;
    }
    
    /**
     * Sets up the EASy-Producer locations containing the model files.
     * 
     * @throws ModelManagementException in case that setting up a folders fails for some reasons
     */
    public void setupLocations() throws ModelManagementException {
        Location primary = null;
        for (File f : ivmlFolder) {
            logger.info("Setting IVML location " + f);
            Location loc = VarModel.INSTANCE.locations().addLocation(f, observer);
            if (null == primary) {
                primary = loc;
            } else {
                primary.addDependentLocation(loc);
            }
        }
        logger.info("Setting VIL location " + vilFolder);
        BuildModel.INSTANCE.locations().addLocation(vilFolder, observer);
        logger.info("Setting VTL location " + vtlFolder);
        TemplateModel.INSTANCE.locations().addLocation(vtlFolder, observer);
    }

    /**
     * Loads the IVML model and creates a configuration instance. {@link #setupLocations()} must be called before.
     * 
     * @return the configuration instance including the IVML model instance
     * @throws ModelManagementException if loading the IVML model fails
     */
    public Configuration loadIvmlModel() throws ModelManagementException {
        logger.info("Loading model: " + ivmlModelName);
        List<ModelInfo<Project>> models = VarModel.INSTANCE.availableModels().getModelInfo(ivmlModelName);
        if (null != models && !models.isEmpty()) {
            ModelInfo<Project> prjInfo = models.get(0);
            Project prj = VarModel.INSTANCE.load(prjInfo);
            logger.info("Creating configuration instance: " + ivmlModelName);
            cfg = new Configuration(prj);
        } else {
            logger.error("No model found: " + ivmlModelName);
            // there might be no file, there may be erroneous IVML files for which we do not get error information
            for (File folder : ivmlFolder) {
                IModelLoader<Project> loader = VarModel.INSTANCE.loaders().getDefaultLoader();
                loader.scan(folder, new IModelInfoHolder<Project>() {
                    
                    @Override
                    public boolean isKnown(URI uri, IModelLoader<Project> loader) {
                        return false;
                    }
                    
                    @Override
                    public void error(String message) {
                        logger.error(message);
                    }
                    
                    @Override
                    public void addResult(ModelInfo<Project> toAdd) {
                    }
                });
            }
        }
        return cfg;
    }
    
    /**
     * Executes the reasoning on the IVML configuration built by {@link #loadIvmlModel()}, here in terms of the 
     * propagation reasoning mode. {@link #loadIvmlModel()} must have been called before.
     *  
     * @return the reasoning result provided by the reasoner
     * @throws IllegalStateException if {@link #loadIvmlModel()} has not been called before
     */
    public ReasoningResult propagateOnIvmlModel() {
        if (null != cfg) {
            logger.info("Reasoning by propagation on model " + ivmlModelName);
            return ReasonerFrontend.getInstance().propagate(cfg, rCfg, observer);
        }  else {
            throw new IllegalStateException("No IVML model loaded / configuration available.");
        }
    }
    
    /**
     * Executes VIL on the model.
     * 
     * @throws ModelManagementException in case that the VIL model cannot be loaded
     * @throws VilException if executing VIL fails for some reason
     * @throws IllegalStateException if {@link #loadIvmlModel()} has not been called before
     */
    public void executeVil() throws ModelManagementException, VilException {
        if (null != cfg) {
            logger.info("Loading VIL script: " + vilModelName);
            List<ModelInfo<Script>> vil = BuildModel.INSTANCE.availableModels().getModelInfo(vilModelName);
            if (null != vil && !vil.isEmpty()) {
                ModelInfo<Script> vilInfo = vil.get(0);
                Script script = BuildModel.INSTANCE.load(vilInfo);
                
                if (null != tracerFactory) {
                    TracerFactory.setInstance(tracerFactory);
                }
                TracerFactory.registerProgressObserver(observer);
                logger.info("Executing VIL script: " + vilModelName);
                Executor exec = new Executor(script)
                    .addBase(base)
                    .addSource(vilSource)
                    .addConfiguration(cfg)
                    .addTarget(vilTarget);
                if (null != vilArguments) {
                    for (Map.Entry<String, Object> ent : vilArguments.entrySet()) {
                        exec.addCustomArgument(ent.getKey(), ent.getValue());
                    }
                }
                if (null != vilStartRuleName) {
                    exec.addStartRuleName(vilStartRuleName);
                }
                try {
                    exec.execute();
                } catch (VilException e) {
                    TracerFactory.unregisterProgressObserver(observer);
                }
            } else {
                logger.error("No VIL script found: " + vilModelName);
            }
        } else {
            throw new IllegalStateException("No IVML model loaded / configuration available.");
        }
    }

    /**
     * Discards the EASy-Producer locations set up in {@link #setupLocations()}.
     * 
     * @throws ModelManagementException in case that setting up a folders fails for some reasons
     */
    public void discardLocations() throws ModelManagementException {
        logger.info("Discarding VTL location " + vtlFolder);
        TemplateModel.INSTANCE.locations().removeLocation(vtlFolder, observer);
        logger.info("Discarding VIL location " + vilFolder);
        BuildModel.INSTANCE.locations().removeLocation(vilFolder, observer);
        for (int f = ivmlFolder.size() - 1; f >= 0; f--) {
            File folder = ivmlFolder.get(f);
            logger.info("Discarding IVML location " + folder);
            VarModel.INSTANCE.locations().removeLocation(folder, observer);
        }
    }
    
    /**
     * Clears model caches (IVML, VIL, VTL) and implicitly forces a re-resolution, in particular of wildcard imports.
     */
    public void clearModels() {
        TemplateModel.INSTANCE.clear();
        BuildModel.INSTANCE.clear();
        VarModel.INSTANCE.clear();
    }

    /**
     * Executes all steps as described above.
     * 
     * @return <b>this</b> (builder style)
     * @throws ModelManagementException if a model location cannot be set or a model cannot be loaded 
     * @throws VilException if executing VIL fails
     */
    public EasyExecutor execute() throws ModelManagementException, VilException {
        setupLocations();
        loadIvmlModel();
        propagateOnIvmlModel();
        executeVil();
        discardLocations();
        return this;
    }
    
    /**
     * Returns the configuration used by this executor.
     * 
     * @return the configuration
     */
    public Configuration getConfiguration() {
        return cfg;
    }
    
    /**
     * Replaces the configuration stored in this class. 
     * 
     * @param cfg the configuration (if <b>null</b> further processing is disabled and {@link IllegalStateException} 
     * may be thrown)
     */
    public void setConfiguration(Configuration cfg) {
        this.cfg = cfg;
    }

    /**
     * Convenience method to print the given configuration to {@code System.out}.
     * 
     * @param cfg the configuration to print
     */
    public static void printConfiguration(Configuration cfg) {
        printConfiguration(System.out, cfg);
    }

    /**
     * Convenience method to print the configuration.
     * 
     * @param cfg the configuration to print
     * @param out the target output stream
     */
    public static void printConfiguration(PrintStream out, Configuration cfg) {
        Configuration.printConfig(out, cfg);
    }

    /**
     * Convenience method to print the contained configuration.
     * 
     * @param out the target output stream
     */
    public void printConfiguration(PrintStream out) {
        printConfiguration(out, cfg);
    }

    /**
     * Convenience method to print the contained configuration to {@code System.out}.
     */
    public void printConfiguration() {
        printConfiguration(System.out);
    }

    /**
     * Convenience method to print the relevant information from reasoning messages.
     * 
     * @param rRes the reasoning result to print
     * @param out the target output stream
     */
    public static void printReasoningMessages(ReasoningResult rRes, PrintStream out) {
        for (int m = 0; m < rRes.getMessageCount(); m++) {
            Message msg = rRes.getMessage(m);
            out.println(msg.getDescription());
            out.println(msg.getConflictComments());
            out.println(msg.getConflictSuggestions());
        }
    }

    /**
     * Convenience method to print the relevant information from reasoning messages to {@code System.out}.
     * 
     * @param rRes the reasoning result to print
     */
    public static void printReasoningMessages(ReasoningResult rRes) {
        printReasoningMessages(rRes, System.out);
    }
    
}
