/*
 * Copyright 2009-2014 University of Hildesheim, Software Systems Engineering
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

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

import net.ssehub.easy.basics.modelManagement.ModelInfo;
import net.ssehub.easy.dslCore.ui.editors.ModelEditorConfigurer.IHeader;
import net.ssehub.easy.dslCore.ui.listeners.AggregatingModelLoadingListener;
import net.ssehub.easy.dslCore.ui.listeners.BasicModelLoadingListener;
import net.ssehub.easy.dslCore.ui.listeners.ButtonUiControl;
import net.ssehub.easy.instantiation.rt.core.model.rtVil.RtVilModel;
import net.ssehub.easy.instantiation.rt.core.model.rtVil.Script;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.management.VarModel;
import net.ssehub.easy.varModel.model.Project;

/**
 * Implements the embedded editor header panel.
 * 
 * @author Holger Eichelberger
 */
public class HeaderPanel extends Composite implements IHeader {

    private Button settings;
    private Button simulate;
    private SimulatorUi simulator;
    private AggregatingModelLoadingListener listener;
    
    /**
     * Creates the header panel.
     * 
     * @param parent the parent composite
     * @param config the configuration instance
     * @param base the base project folder
     * @param info the model being edited in the related model editor
     */
    public HeaderPanel(Composite parent, Configuration config, File base, ModelInfo<?> info) {
        super(parent, SWT.NONE);
        this.simulator = new SimulatorUi(parent.getShell(), config, base, info);
        setLayout(new FillLayout());
        settings = new Button(this, SWT.PUSH);
        settings.setText("Simulation settings...");
        settings.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                simulator.openSettingsDialog();
            }
        });
        
        simulate = new Button(this, SWT.PUSH);
        simulate.setText("Simulate");
        simulate.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                simulator.configureOrSimulate();
            }
        });
        listener = new AggregatingModelLoadingListener(new ButtonUiControl(simulate));
        listener.initialize();
        ModelInfo<Project> ivmlInfo = VarModel.INSTANCE.availableModels().getModelInfo(config.getProject());
        BasicModelLoadingListener<Project> ivmlListener = new BasicModelLoadingListener<Project>(
            ivmlInfo, VarModel.INSTANCE, listener);
        @SuppressWarnings("unchecked")
        BasicModelLoadingListener<Script> rtVilListener = new BasicModelLoadingListener<Script>(
            (ModelInfo<Script>) info, RtVilModel.INSTANCE, listener); 
        listener.addListeners(ivmlListener, rtVilListener);
    }

    @Override
    public void revalidateComponents(boolean hasErrors) {
        simulate.setEnabled(!hasErrors);
    }

    @Override
    public void close() {
    }
    
    @Override
    public void dispose() {
        listener.dispose();
    }

}
