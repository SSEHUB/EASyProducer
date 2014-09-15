/*
 * Copyright 2009-2013 University of Hildesheim, Software Systems Engineering
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

package de.uni_hildesheim.sse.easy_producer.instantiator.model.execution;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import de.uni_hildesheim.sse.easy_producer.instantiator.Bundle;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.BuildModel;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.BuildlangExecution;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.ITracer;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.RuleExecutionResult;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Script;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilLanguageException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArraySequence;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArtifactException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IProjectDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ListSequence;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ListSet;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Project;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration.FrozenVariablesFilter;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration.IVariableFilter;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration.NoVariableFilter;
import de.uni_hildesheim.sse.model.confModel.Configuration;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.progress.ProgressObserver;

/**
 * Executes VIL scripts. This is a convenience class following the builder
 * pattern, i.e., you create an instance, add parameter and finally execute
 * the constructed call. Please note that some arguments may be optional from the
 * point of view of default EASy execution! Further, projects may be given in terms
 * of their base folder or as an {@link IProjectDescriptor}, whereby the project 
 * descriptor carries explicit information about the project and shall be preferred 
 * (except for explicit testing purposes). However, if multiple sources are given, as a convention 
 * the first one shall the top-level project that needs to be executed.
 * 
 * @author Holger Eichelberger
 */
public class Executor {
    
    /**
     * The default source project parameter (called {@link BuildlangExecution#PARAM_SOURCE}).
     */
    public static final String PARAM_SOURCE = BuildlangExecution.PARAM_SOURCE;

    /**
     * The default target project parameter (called {@link BuildlangExecution#PARAM_TARGET}).
     */
    public static final String PARAM_TARGET = BuildlangExecution.PARAM_TARGET;
    
    /**
     * The default configuration parameter (called {@link BuildlangExecution#PARAM_CONFIG}).
     */
    public static final String PARAM_CONFIG = BuildlangExecution.PARAM_CONFIG;
    
    // add further to static initializer!
    
    /**
     * Defines the default start rule name.
     */
    public static final String DEFAULT_START_RULE_NAME = Script.DEFAULT_START_RULE_NAME;

    private static final Set<String> DEFAULT_PARAMS = new HashSet<String>();
    
    private Map<String, Object> arguments = new HashMap<String, Object>();
    private Script script;
    private String startRuleName = DEFAULT_START_RULE_NAME;
    private File base;
    private boolean frozenOnly = true;
    
    /**
     * Creates an executor with default arguments.
     * 
     * @param script the script to execute
     * @throws IllegalArgumentException in case that <code>source</code> is <b>null</b>
     */
    public Executor(Script script) {
        if (null == script) {
            throw new IllegalArgumentException("VIL build script must be given");
        }
        this.script = script;
    }
    
    /**
     * Creates an executor with predefined arguments. This enables
     * to execute scripts with custom parameters.
     * 
     * @param script the script to execute (ignored if <b>null</b>)
     * @param arguments the arguments matching all par
     */
    public Executor(Script script, Map<String, Object> arguments) {
        this(script);
        if (null != arguments) {
            for (Map.Entry<String, Object> entry : arguments.entrySet()) {
                String name = entry.getKey();
                Object value = entry.getValue();
                if (DEFAULT_PARAMS.contains(name)) {
                    this.arguments.put(name, value);
                } else {
                    this.arguments.put(name, convertToVIL(value));
                }
            }
        }
    }
    
    static {
        DEFAULT_PARAMS.add(PARAM_SOURCE);
        DEFAULT_PARAMS.add(PARAM_TARGET);
        DEFAULT_PARAMS.add(PARAM_CONFIG);
    }
    
    /**
     * Adds the start rule name as argument.
     * 
     * @param startRuleName the start rule name, "main" by default if <b>null</b> or empty
     * @return this executor instance
     */
    public Executor addStartRuleName(String startRuleName) {
        if (null != startRuleName && startRuleName.length() > 0) {
            this.startRuleName = startRuleName;
        }
        return this;
    }
    
    /**
     * Switches on / off whether only frozen variables shall be able for instantiation. This enables
     * runtime variability. Please note that this switch applies only to configurations created in
     * this class, not configurations created outside and passed in.
     * 
     * @param frozenOnly if <code>true</code> only frozen variables will be considered in a configuration instance
     *   created by this class, <code>false</code> else
     * @return this executor instance
     */
    public Executor frozenOnly(boolean frozenOnly) {
        this.frozenOnly = frozenOnly;
        return this;
    }

    /**
     * Adds the source folder as argument. This is opposite to {@link #addSources(File[])}.
     * 
     * @param source the source folder (project)
     * @return this executor instance
     * @throws IllegalArgumentException in case that <code>source</code> is <b>null</b>
     */
    public Executor addSource(File source) {
        if (null == source) {
            throw new IllegalArgumentException("at least one source must be given");
        }
        arguments.put(PARAM_SOURCE, source);
        return this;
    }
    
    /**
     * Adds the source project as argument. 
     * 
     * @param source the source project
     * @return this executor instance
     * @throws IllegalArgumentException in case that <code>source</code> is <b>null</b>
     */
    public Executor addSource(IProjectDescriptor source) {
        if (null == source) {
            throw new IllegalArgumentException("at least one source must be given");
        }
        arguments.put(PARAM_SOURCE, source);
        return this;
    }

    /**
     * Adds the source folders as argument. This is opposite to {@link #addSource(File)}.
     * 
     * @param sources the source folders (projects)
     * @return this executor instance
     */
    public Executor addSources(List<File> sources) {
        if (null == sources || 0 == sources.size()) {
            throw new IllegalArgumentException("at least one source must be given");
        }
        File[] sFiles = new File[sources.size()];
        return addSources(sources.toArray(sFiles));
    }
    
    /**
     * Adds the source folders as argument. This is opposite to {@link #addSource(File)}.
     * 
     * @param sources the source folders (projects)
     * @return this executor instance
     * @throws IllegalArgumentException in case that <code>sources</code> is <b>null</b> or empty
     */
    public Executor addSources(File[] sources) {
        if (null == sources || 0 == sources.length) {
            throw new IllegalArgumentException("at least one source must be given");
        }
        arguments.put(PARAM_SOURCE, sources);
        return this;
    }

    /**
     * Adds the source projects as argument. This is opposite to {@link #addSource(IProjectDescriptor)}.
     * 
     * @param sources the source projects
     * @return this executor instance
     * @throws IllegalArgumentException in case that <code>sources</code> is <b>null</b> or empty
     */
    public Executor addSources(IProjectDescriptor[] sources) {
        if (null == sources || 0 == sources.length) {
            throw new IllegalArgumentException("at least one source must be given");
        }
        arguments.put(PARAM_SOURCE, sources);
        return this;
    }
    
    /**
     * Adds the target (folder) as argument.
     * 
     * @param target the target folder (may be <b>null</b>, then source is taken)
     * @return this executor instance
     */
    public Executor addTarget(File target) {
        arguments.put(PARAM_TARGET, target);
        return this;
    }

    /**
     * Adds the target project as argument.
     * 
     * @param target the target project (may be <b>null</b>, then source is taken)
     * @return this executor instance
     */
    public Executor addTarget(IProjectDescriptor target) {
        arguments.put(PARAM_TARGET, target);
        return this;
    }

    /**
     * Adds the configuration as argument.
     * 
     * @param config the variability configuration
     * @return this executor instance
     * @throws IllegalArgumentException in case that <code>config</code> is <b>null</b>
     */
    public Executor addConfiguration(Configuration config) {
        if (null == config) {
            throw new IllegalArgumentException("config must not be null");
        }
        arguments.put(PARAM_CONFIG, config);
        return this;
    }

    /**
     * Explicitly adds an argument for the base directory for resolving property files.
     * 
     * @param base the base directory, the target directory if <b>null</b>
     * @return this executor instance
     */
    public Executor addBase(File base) {
        this.base = base;
        return this;
    }

    /**
     * Adds a custom argument. If possible, this method maps automatically
     * <ul>
     *  <li><i>java.util.Set<T></i> to <code>setOf<T></code></li>
     *  <li><i>java.util.List<T></i> to <code>sequenceOf<T></code></li>
     *  <li><i>java.util.Map<K, V></i> to <code>mapOf<K, V></code></li>
     * </ul>
     * 
     * @param name the name of the argument
     * @param value the actual value
     * @return this executor instance
     * @throws IllegalArgumentException in case that <code>name</code> is not given
     */
    public Executor addCustomArgument(String name, Object value) {
        if (null == name || 0 == name.length()) {
            throw new IllegalArgumentException("parameter name must be given");
        }
        arguments.put(name, convertToVIL(value));
        return this;
    }

    /**
     * Returns an unknown VIL collection type.
     * 
     * @return an unknown VIL collection  type
     */
    private static TypeDescriptor<?>[] unknownCollectionType() {
        TypeDescriptor<?>[] unknown = TypeDescriptor.createArray(1);
        unknown[0] = TypeRegistry.anyType();
        return unknown;
    }

    /**
     * Returns an unknown VIL map type.
     * 
     * @return an unknown VIL map type
     */
    private static TypeDescriptor<?>[] unknownMapType() {
        TypeDescriptor<?>[] unknown = TypeDescriptor.createArray(2);
        unknown[0] = TypeRegistry.anyType();
        unknown[1] = TypeRegistry.anyType();
        return unknown;
    }

    /**
     * Converts an object to VIL, if possible. 
     * 
     * @param object the object to be converted
     * @return the converted object
     */
    private static Object convertToVIL(Object object) {
        Object result = object;
        try {
            // internally, everything is an object...
            if (null != object) {
                if (object.getClass().isArray()) {
                    Object[] tmp = new Object[Array.getLength(object)];
                    for (int i = 0; i < tmp.length; i++) {
                        tmp[i] = convertToVIL(Array.get(object, i));
                    }
                    result = new ArraySequence<Object>(tmp, unknownCollectionType());
                } else if (object instanceof java.util.Set) {
                    java.util.Set<?> set = (java.util.Set<?>) object;
                    java.util.List<Object> tmp = new ArrayList<Object>();
                    for (Object o : set) {
                        tmp.add(convertToVIL(o));
                    }
                    result = new ListSet<Object>(tmp, unknownCollectionType());
                } else if (object instanceof java.util.List) {
                    java.util.List<?> list = (java.util.List<?>) object;
                    java.util.List<Object> tmp = new ArrayList<Object>();
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        tmp.add(convertToVIL(list.get(i)));
                    }
                    result = new ListSequence<Object>(tmp, unknownCollectionType());
                } else if (object instanceof java.util.Map) {
                    java.util.Map<?, ?> map = (java.util.Map<?, ?>) object;
                    java.util.Map<Object, Object> tmp = new HashMap<Object, Object>();
                    for (Map.Entry<?, ?> entry : map.entrySet()) {
                        tmp.put(convertToVIL(entry.getKey()), convertToVIL(entry.getValue()));
                    }
                    result = new de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Map<Object, Object>(
                        tmp, unknownMapType());
                }
            }
        } catch (ClassCastException e) {
            EASyLoggerFactory.INSTANCE.getLogger(Executor.class, Bundle.ID).warn(
                "class mismatch during automatic VIL parameter conversion: " + e.getMessage());
        }
        return result;
    }
    
    /**
     * Executes the contained VIL build language script without observer and with default parameter checks. 
     * 
     * @throws VilLanguageException in case that artifact operations or script execution fails
     * @throws IllegalArgumentException in case that input is missing or wrong
     */
    public void execute() throws VilLanguageException {
        execute(true);
    }

    /**
     * Executes the contained VIL build language script without observer and possibly without default parameter checks 
     * (may be helpful in case of custom arguments). 
     * 
     * @param check carry out default parameter checks and default argument settings for EASy script execution (if 
     *     disabled, full responsibility for proper execution is on caller side)
     * @throws VilLanguageException in case that artifact operations or script execution fails
     * @throws IllegalArgumentException in case that input is missing or wrong
     */
    public void execute(boolean check) throws VilLanguageException {
        execute(ProgressObserver.NO_OBSERVER, check);
    }

    /**
     * Executes the contained VIL build language script with the given observer (mainly used within 
     * parameter conversion) and possibly without default parameter checks (may be helpful in case of custom arguments).
     * 
     * @param observer the observer to be considered (must not be <b>null</b>)
     * @param check carry out default parameter checks and default argument settings for EASy script execution (if 
     *     disabled, full responsibility for proper execution is on caller side)
     * @throws VilLanguageException in case that artifact operations or script execution fails
     * @throws IllegalArgumentException in case that input is missing or wrong
     */
    public void execute(ProgressObserver observer, boolean check) throws VilLanguageException {
        if (null == observer) {
            throw new IllegalArgumentException("observer must not be null");
        }
        Map<String, Object> actArgs = new HashMap<String, Object>();
        actArgs.putAll(arguments);
        ITracer tracer = TracerFactory.createBuildLanguageTracer();
        File base = this.base;
        if (check) {
            checkArguments(actArgs, observer);
            // check target and use default if possible
            if (null == actArgs.get(PARAM_TARGET)) {
                if (actArgs.get(PARAM_SOURCE) instanceof Project) {
                    actArgs.put(PARAM_TARGET, actArgs.get(PARAM_SOURCE));
                }
            }
            if (null == actArgs.get(PARAM_TARGET)) {
                throw new IllegalArgumentException(
                    "no target project specified, neither via target project nor explicitly");
            }
            
            if (null == base) {
                Object tmp = actArgs.get(PARAM_TARGET);
                if (tmp instanceof Project) {
                    base = ((Project) tmp).getPath().getAbsolutePath();
                }
            }
        }
        if (null == base) {
            throw new IllegalArgumentException(
                "no base folder specified, neither via target project nor explicitly");
        }
        if (script.isDirty()) {
            Script old = script;
            script = BuildModel.INSTANCE.reload(script);
            EASyLoggerFactory.INSTANCE.getLogger(getClass(), Bundle.ID).info("Reloading model " + script.getName() 
                + " " + System.identityHashCode(script) + " as it was marked dirty " + (old != script)); // for Cui
        }
        BuildlangExecution executor = new BuildlangExecution(tracer, base, startRuleName, actArgs);
        try {
            Object result = script.accept(executor);
            if (result instanceof RuleExecutionResult) {
                RuleExecutionResult rExecResult = (RuleExecutionResult) result;
                if (RuleExecutionResult.Status.FAIL == rExecResult.getStatus()) {
                    StringBuilder tmp = new StringBuilder("build execution failed");
                    if (executor.getFailedCount() > 0) {
                        tmp.append(" in rule");
                        if (executor.getFailedCount() > 1) {
                            tmp.append("s");
                        }
                        tmp.append(" ");
                        for (int f = 0; f < executor.getFailedCount(); f++) {
                            if (f > 0) {
                                tmp.append(", ");
                            }
                            tmp.append(executor.getFailed(f).getName());
                        }
                    }
                    VilLanguageException e = new VilLanguageException(tmp.toString(), 
                        VilLanguageException.ID_RUNTIME_RULE_FAILED);
                    tracer.traceExecutionException(e);
                    throw e;
                }
            }
        } catch (VilLanguageException e) {
            tracer.traceExecutionException(e);
            throw e;
        }
        tracer.reset();
    }
    
    /**
     * Checks a project argument.
     * 
     * @param args the name-argument mapping
     * @param param the name of the parameter to be analyzed
     * @param observer the observer for longer operations
     * @throws VilLanguageException in case that artifact operations fail
     * @throws IllegalArgumentException in case that input is missing or wrong
     */
    private static void checkProjectArgument(Map<String, Object> args, String param, ProgressObserver observer) 
        throws VilLanguageException {
        if (null == args.get(param)) {
            throw new IllegalArgumentException(param + " not given");
        }
        if (args.get(param) instanceof File) {
            try {
                args.put(param, new Project((File) args.get(param), observer));
            } catch (ArtifactException e) {
                throw new VilLanguageException(e.getMessage(), e.getId());
            }
        }
        if (args.get(param) instanceof IProjectDescriptor) {
            try {
                args.put(param, Project.getProjectFor((IProjectDescriptor) args.get(param)));
            } catch (ArtifactException e) {
                throw new VilLanguageException(e.getMessage(), e.getId());
            }
        }
        if (param.equals(PARAM_SOURCE) && args.get(PARAM_SOURCE) instanceof IProjectDescriptor[]) {
            try {
                IProjectDescriptor[] tmp = (IProjectDescriptor[]) args.get(PARAM_SOURCE);
                Project[] sources = new Project[tmp.length];
                for (int f = 0; f < tmp.length; f++) {
                    sources[f] = Project.getProjectFor(tmp[f]);
                }
                args.put(PARAM_SOURCE, sources);
            } catch (ArtifactException e) {
                throw new VilLanguageException(e.getMessage(), e.getId());
            }
        }
        if (param.equals(PARAM_SOURCE) && args.get(PARAM_SOURCE) instanceof File[]) {
            try {
                File[] tmp = (File[]) args.get(PARAM_SOURCE);
                Project[] sources = new Project[tmp.length];
                for (int f = 0; f < tmp.length; f++) {
                    sources[f] = new Project(tmp[f], observer);
                }
                args.put(PARAM_SOURCE, sources);
            } catch (ArtifactException e) {
                throw new VilLanguageException(e.getMessage(), e.getId());
            }
        }
        if (!(args.get(param) instanceof Project)) {
            if (!(param.equals(PARAM_SOURCE) && args.get(PARAM_SOURCE) instanceof Project[])) {
                throw new IllegalArgumentException(param + " is neither instance of " + Project.class.getName() 
                    + " nor an array of that class");
            } // else ok
        } // else ok
    }
    
    /**
     * Checks the arguments.
     * 
     * @param args the name-argument mapping
     * @param observer the observer for longer operations
     * @throws VilLanguageException in case that artifact operations fail
     * @throws IllegalArgumentException in case that input is missing or wrong
     */
    private void checkArguments(Map<String, Object> args, ProgressObserver observer) 
        throws VilLanguageException {
        checkProjectArgument(args, PARAM_SOURCE, observer);
        checkProjectArgument(args, PARAM_TARGET, observer);
        if (null == args.get(PARAM_CONFIG)) {
            throw new IllegalArgumentException("no configuration given");
        }
        if (args.get(PARAM_CONFIG) instanceof Configuration) {
            IVariableFilter filter;
            if (frozenOnly) {
                filter = FrozenVariablesFilter.INSTANCE;
            } else {
                filter = NoVariableFilter.INSTANCE;
            }
            args.put(PARAM_CONFIG, new de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes
                .configuration.Configuration((Configuration) args.get(PARAM_CONFIG), filter)); 
        }
        if (!(args.get(PARAM_CONFIG) instanceof de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes
            .configuration.Configuration)) {
            throw new IllegalArgumentException(PARAM_CONFIG + " is not instance of " + de.uni_hildesheim.sse
                .easy_producer.instantiator.model.vilTypes.configuration.Configuration.class.getName());
        }
    }
    
}
