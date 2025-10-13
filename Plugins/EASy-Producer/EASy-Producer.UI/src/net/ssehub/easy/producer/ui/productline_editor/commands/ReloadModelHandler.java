/*
 * Copyright 2009-2024 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.producer.ui.productline_editor.commands;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;

import de.uni_hildesheim.sse.ui.Activator;
import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.producer.core.persistence.Configuration;
import net.ssehub.easy.producer.core.persistence.PersistenceUtils;
import net.ssehub.easy.producer.eclipse.model.ProductLineProject;

/**
 * Command handler for re-loading the models of a PLP.
 * 
 * @author Holger Eichelberger
 */
public class ReloadModelHandler extends AbstractPlpHandler {

    @Override
    protected void execute(ExecutionEvent event, IProject project, ProductLineProject plp) throws ExecutionException {
        try {
            Configuration cfg 
                = net.ssehub.easy.producer.eclipse.persistency.eclipse.PersistenceUtils.getConfiguration(project);
            PersistenceUtils.processLocation(cfg, false, false, ProgressObserver.NO_OBSERVER);
            PersistenceUtils.processLocation(cfg, true, false, ProgressObserver.NO_OBSERVER);
        } catch (ModelManagementException e) {
            EASyLoggerFactory.INSTANCE.getLogger(ReloadModelHandler.class, Activator.PLUGIN_ID).warn(
                "While reloading models: " + e.getMessage());
        }
    }

    @Override
    public boolean isEnabled() {
        return getEasyConfigFile() != null && super.isAbstractHandlerEnabled();
    }    
    
}
