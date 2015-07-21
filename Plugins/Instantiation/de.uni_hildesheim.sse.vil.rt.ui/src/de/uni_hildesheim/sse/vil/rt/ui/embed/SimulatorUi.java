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
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import de.uni_hildesheim.sse.dslcore.ui.ConfigurationEditorFactory;
import de.uni_hildesheim.sse.easy_producer.instantiator.Bundle;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.VariableDeclaration;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.rtVil.Executor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.rtVil.RtVILMemoryStorage;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.rtVil.Script;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration.NoVariableFilter;
import de.uni_hildesheim.sse.model.confModel.Configuration;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.modelManagement.ModelInfo;
import de.uni_hildesheim.sse.vil.rt.ui.embed.SimulationSettingsDialog.TempArgument;

/**
 * Implements a UI for simulating rtVIL.
 *  
 * @author Holger Eichelberger
 */
public class SimulatorUi {

    private Shell shell;
    private de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration.Configuration config;
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
        RtVILMemoryStorage.setSimulationHint(true);
        this.shell = shell;
        Configuration cfg = new Configuration(config.getProject()); // copy the configuration to avoid writing back
        this.config = new de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.
            configuration.Configuration(cfg, NoVariableFilter.INSTANCE); // for change history
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
        return dlg.open();
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
        final int baseArgCount = 3;
        final int openArgCount = Math.max(0, model.getParameterCount() - baseArgCount);
        openArguments = new Argument[openArgCount];
        for (int a = 0; a < openArgCount; a++) {
            VariableDeclaration param = model.getParameter(baseArgCount  + a);
            openArguments[a] = new Argument(param.getName(), param.getType());
        }
        // just for now and for QM
        if (openArguments.length > 0 && "event".equals(openArguments[0].getName())) {
            try {
                TempArgument tmp = SimulationSettingsDialog.analyze(
                    "new StartupAdaptationEvent(\"PriorityPip\")", null);
                openArguments[0].setValue(tmp.getValueExpression(), tmp.getValue());
            } catch (VilException e) {
                EASyLoggerFactory.INSTANCE.getLogger(getClass(), Bundle.ID).error(
                    "While initializing QM dialog: " + e.getMessage());
            }
        }
        if (openArguments.length > 1 && "bindings".equals(openArguments[1].getName())) {
            try {
                TempArgument tmp = SimulationSettingsDialog.analyze("null", null); // {} <-> primary expression
                openArguments[1].setValue(tmp.getValueExpression(), tmp.getValue());
            } catch (VilException e) {
                EASyLoggerFactory.INSTANCE.getLogger(getClass(), Bundle.ID).error(
                    "While initializing QM dialog: " + e.getMessage());
            }
        }
    }

}
