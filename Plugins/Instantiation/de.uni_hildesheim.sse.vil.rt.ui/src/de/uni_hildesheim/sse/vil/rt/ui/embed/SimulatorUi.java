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
package de.uni_hildesheim.sse.vil.rt.ui.embed;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import de.uni_hildesheim.sse.vil.rt.ui.embed.SimulationSettingsDialog.TempArgument;
import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.basics.modelManagement.ModelInfo;
import net.ssehub.easy.dslCore.ui.ConfigurationEditorFactory;
import net.ssehub.easy.instantiation.core.model.buildlangModel.VariableDeclaration;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.OperationDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.Sequence;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.NoVariableFilter;
import net.ssehub.easy.instantiation.rt.core.model.rtVil.Bundle;
import net.ssehub.easy.instantiation.rt.core.model.rtVil.Executor;
import net.ssehub.easy.instantiation.rt.core.model.rtVil.ISimulationNotifier;
import net.ssehub.easy.instantiation.rt.core.model.rtVil.RtVILMemoryStorage;
import net.ssehub.easy.instantiation.rt.core.model.rtVil.Script;
import net.ssehub.easy.varModel.confModel.Configuration;

/**
 * Implements a UI for simulating rt-VIL.
 *  
 * @author Holger Eichelberger
 */
public class SimulatorUi implements ISimulationNotifier {

    private Shell shell;
    private net.ssehub.easy.instantiation.core.model.vilTypes.configuration.Configuration config;
    private Script model;
    private Argument[] openArguments;
    private File base;
    private NamedViewerFilter[] filters;

    /**
     * Creates the simulator UI.
     * 
     * @param shell the parent shell
     * @param config the configuration instance
     * @param base the base project folder
     * @param info the model being edited in the related model editor
     */
    public SimulatorUi(Shell shell, Configuration config, File base, ModelInfo<?> info) {
        this(shell, config, base, info, null);
    }
    
    /**
     * Creates the simulator UI.
     * 
     * @param shell the parent shell
     * @param config the configuration instance
     * @param base the base project folder
     * @param info the model being edited in the related model editor
     * @param filters the default viewer filters (<b>null</b> for {@link #createDefaultFilters()}.
     */
    public SimulatorUi(Shell shell, Configuration config, File base, ModelInfo<?> info, NamedViewerFilter[] filters) {
        RtVILMemoryStorage.setSimulationNotifier(this);
        this.shell = shell;
        Configuration cfg = new Configuration(config.getProject()); // copy the configuration to avoid writing back
        this.config = new net.ssehub.easy.instantiation.core.model.vilTypes.configuration.Configuration(cfg, NoVariableFilter.INSTANCE); // for change history
        this.filters = null == filters ? createDefaultFilters() : filters;
        initModel(info);
        this.base = base;
    }

    /**
     * Creates the default filter.
     */
    protected NamedViewerFilter[] createDefaultFilters() {
        NamedViewerFilter[] filters = new NamedViewerFilter[1];
        filters[0] = new NamedViewerFilter("state != FROZEN", ConfigurationEditorFactory.createNonFrozenFilter(false));
        return filters;
    }

    /**
     * Performs the simulation and calls, if required, the settings dialog
     * 
     * @see #simulate()
     * @see #openSettingsDialog()
     * @see #argumentsValid()
     */
    public void configureOrSimulate() {
        boolean simulate = true;
        if (!argumentsValid()) {
            simulate = (Window.OK == openSettingsDialog());
        }
        if (simulate) {
            Display.getCurrent().asyncExec(new Runnable() {

                @Override
                public void run() {
                    simulate();
                }});
        }
    }
    
    /**
     * Performs the simulation.
     */
    public void simulate() {
        String error = null;
        try {
            Map<String, Object> arguments = new HashMap<String, Object>();
            File tmp = Files.createTempDirectory("rtVilSim").toFile();
            tmp.deleteOnExit();
            arguments.put(Executor.PARAM_SOURCE, base);
            // grant access to all variables
            arguments.put(Executor.PARAM_CONFIG, config);
            arguments.put(Executor.PARAM_TARGET, tmp);
            for (int a = 0; a < openArguments.length; a++) {
                Argument arg = openArguments[a];
                arguments.put(arg.getName(), arg.getValue());
            }
            Executor executor = new Executor(model, arguments);
            executor.addBase(base);
            executor.execute();
        } catch (IOException e) {
            error = e.getMessage();
        } catch (VilException e) {
            error = e.getMessage();
        }
        if (null != error) {
            MessageDialog.openError(shell, "rt-VIL execution problem", error);
        }
    }
    
    /**
     * Opens the settings dialog.
     * 
     * @return exit code of dialog
     */
    public int openSettingsDialog() {
        SimulationSettingsDialog dlg = new SimulationSettingsDialog(shell, config, openArguments, filters);
        int result = dlg.open();
        if (Window.OK == result) {
            writeOpenArgumentsToSettings();
        }
        return result;
    }
    
    /**
     * Returns whether all open arguments are valid, i.e. have values set and are ready for simulation.
     * 
     * @return <code>true</code> if valid, <code>false</code> else
     */
    public boolean argumentsValid() {
        boolean valid = true;
        for (int a = 0; valid && a < openArguments.length; a++) {
            valid = openArguments[a].isValid();
        }
        return valid;
    }

    /**
     * Initializes the model and the open arguments.
     * 
     * @param info the information object to initialize the model from
     */
    private void initModel(ModelInfo<?> info) {
        model = (Script) info.getResolved(); // must exist, otherwise no panel!
        if (null != model) {
            final int baseArgCount = 3;
            final int openArgCount = Math.max(0, model.getParameterCount() - baseArgCount);
            openArguments = new Argument[openArgCount];
            for (int a = 0; a < openArgCount; a++) {
                VariableDeclaration param = model.getParameter(baseArgCount  + a);
                openArguments[a] = new Argument(param.getName(), param.getType());
            }
            readOpenArgumentsFromSettings();
        }
    }

    /**
     * Returns the simulator properties file.
     * 
     * @return the simulator properties file
     */
    private static File getSimulatorPropertiesFile() {
        IWorkspace workspace = ResourcesPlugin.getWorkspace();
        File workspaceDirectory = workspace.getRoot().getLocation().toFile();
        File metadataDir = new File(workspaceDirectory, ".metadata");
        File metadataPluginsDir = new File(metadataDir, ".plugins");
        File metadataBundleDir = new File(metadataPluginsDir, Bundle.ID);
        return new File(metadataBundleDir, "rtVilSimulator.properties");        
    }
    
    /**
     * Reads the open arguments from the {@link #getSimulatorPropertiesFile() settings file}. 
     */
    private void readOpenArgumentsFromSettings() {
        File settingsFile = getSimulatorPropertiesFile();
        if (settingsFile.exists()) {
            Properties settings = new Properties();
            try {
                FileInputStream in = new FileInputStream(settingsFile);
                settings.load(in);
                in.close();
                for (int o = 0; o < openArguments.length; o++) {
                    Argument arg = openArguments[o];
                    String argName = arg.getName();
                    if (argName.equals("bindings")) {
                        readBindingsArgument(settings, arg, settingsFile);
                    } else {
                        readOtherArgument(settings, arg, settingsFile);
                    }
                }
            } catch (IOException e) {
                getLogger().error("While reading simulator settings from '" + settingsFile + "': " + e.getMessage());
            }
        }
    }
    
    /**
     * Writes the open arguments to the settings file.
     */
    private void writeOpenArgumentsToSettings() {
        File settingsFile = getSimulatorPropertiesFile();
        if (!settingsFile.exists()) {
            settingsFile.getParentFile().mkdirs();
        }
        Properties settings = new Properties();
        for (int o = 0; o < openArguments.length; o++) {
            Argument arg = openArguments[o];
            String argName = arg.getName();
            Object value = arg.getValue();
            if (argName.equals("bindings")) {
                if (value instanceof Sequence<?>) {
                    try {
                        // default type if VIL does not know of which left hand side an initializer is
                        value = net.ssehub.easy.instantiation.core.model.vilTypes.Map.convert(
                           (Sequence<?>) value);
                    } catch (VilException e) {
                        getLogger().exception(e);
                    }
                }
                Map<?, ?> map = null;
                if (value instanceof net.ssehub.easy.instantiation.core.model.vilTypes.Map) {
                    net.ssehub.easy.instantiation.core.model.vilTypes.Map<?, ?> tmp 
                        = (net.ssehub.easy.instantiation.core.model.vilTypes.Map<?, ?>) value;
                    map = tmp.toMap();
                } else if (value instanceof Map<?, ?>) {
                    map = (Map<?, ?>) value;
                }
                if (null != map) {
                    int count = 0;
                    for (Map.Entry<?, ?> entry : map.entrySet()) {
                        settings.put(getBindingsArgumentKey(count++), 
                            unquote(entry.getKey()) + " -> " + entry.getValue());
                    }
                }
            } else {
                String key = getOtherArgumentKey(arg);
                if (null != value) {
                    settings.put(key, arg.getValueExpressionText());
                }
            }
        }
        try {
            FileOutputStream out = new FileOutputStream(settingsFile);
            settings.store(out, "auto saved");
            out.close();
        } catch (IOException e) {
            getLogger().error("While writing simulator settings from '" + settingsFile + "': " + e.getMessage());
        }
    }
    
    /**
     * Removes leading / trailing quotes from the string representation of <code>object</code>.
     * 
     * @param object the object to be unquoted
     * @return the unquoted representation
     */
    private static String unquote(Object object) {
        String string;
        if (null == object) {
            string = null;
        } else {
            string = object.toString();
            if (string.length() > 1 && string.startsWith("\"") && string.endsWith("\"")) {
                string = string.substring(1, string.length() - 1);
            }
        }
        return string;
    }
    
    /**
     * Reads the value bindings argument from the settings file.
     * 
     * @param settings the parsed setting properties
     * @param bindings the argument bindings to be read / modified
     * @param settingsFile the settings file (for logging messages)
     */
    private void readBindingsArgument(Properties settings, Argument bindings, File settingsFile) {
        try {
            int b = 0;
            Map<Object, Object> map = new HashMap<Object, Object>();
            String expr = "{";
            while (true) {
                String key = getBindingsArgumentKey(b);
                String binding = settings.getProperty(key, null);
                if (null != binding) {
                    int pos = binding.indexOf("->");
                    if (pos > 0 && pos + 2 < binding.length()) { // it's within
                        String name = binding.substring(0, pos).trim();
                        String value = binding.substring(pos + 2, binding.length()).trim();
                        try {
                            map.put(name, Double.valueOf(value));
                            if (expr.length() > 1) {
                                expr += ", ";
                            }
                            expr += "{\"" + name + "\", " + value + "}";
                        } catch (NumberFormatException nfe) {
                            getLogger().error("While reading simulator bindings for '" + name + " from '" 
                                + settingsFile + "'': " + nfe.getMessage());
                        }
                    } else {
                        getLogger().error("While reading simulator bindings '" + binding + " from '" 
                            + settingsFile + "'': unrecognized format, missing '->'");
                    }
                } else {
                    break;
                }
                b++;
            }
            expr += "}";
            TempArgument tmp = SimulationSettingsDialog.analyze(expr, null); // {} <-> primary expression
            TypeDescriptor<?>[] types = new TypeDescriptor<?>[2];
            types[0] = TypeRegistry.stringType();
            types[1] = TypeRegistry.realType();
            net.ssehub.easy.instantiation.core.model.vilTypes.Map<String, Double> values 
                = new net.ssehub.easy.instantiation.core.model.vilTypes.Map<String, Double>(map, types);
            bindings.setValue(tmp.getValueExpression(), values);
        } catch (VilException e) {
            getLogger().error("While setting simulator bindings from '" + settingsFile + "': " 
                + e.getMessage());
        }
    }
    
    /**
     * Returns a binding argument key for the specified <code>index</code>.
     * 
     * @param index the index of the argument in the properties file
     * @return the key
     */
    private static String getBindingsArgumentKey(int index) {
        return "argument.bindings." + index;
    }

    /**
     * Reads an other argument from the settings file.
     * 
     * @param settings the parsed setting properties
     * @param argument the argument to be read / modified
     * @param settingsFile the settings file (for logging messages)
     */
    private void readOtherArgument(Properties settings, Argument argument, File settingsFile) {
        String key = getOtherArgumentKey(argument);
        String value = settings.getProperty(key, null);
        if (null != value) {
            try {
                TempArgument tmp = SimulationSettingsDialog.analyze(value, null);
                argument.setValue(tmp.getValueExpression(), tmp.getValue());
            } catch (VilException ve) {
                getLogger().error("While parsing expression for '" + argument.getName() + "' from '" + settingsFile 
                    + "': " + ve.getMessage());
            }
        }
    }
    
    /**
     * Returns the properties file argument key for the given other <code>argument</code>.
     *  
     * @param argument the argument to return the key for
     * @return the key
     */
    private String getOtherArgumentKey(Argument argument) {
        return "argument." + argument.getName();
    }
    
    /**
     * Returns the logger for this class.
     * 
     * @return the logger
     */
    private static EASyLogger getLogger() {
        return EASyLoggerFactory.INSTANCE.getLogger(EASyLogger.class, Bundle.ID);
    }

    @Override
    public void notifyOperationCall(OperationDescriptor operation, Object[] args) {
        // just ignore..
    }

    @Override
    public boolean doRollbackSimulation() {
        return true;
    }

}
