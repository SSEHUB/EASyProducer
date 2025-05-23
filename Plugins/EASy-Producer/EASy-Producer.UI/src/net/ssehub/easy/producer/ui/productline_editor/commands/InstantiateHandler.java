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
import org.eclipse.ui.handlers.HandlerUtil;

import net.ssehub.easy.producer.eclipse.model.ProductLineProject;
import net.ssehub.easy.producer.ui.productline_editor.project_configuration.ProductLineCommands;

/**
 * Command handler for (hierarchical/self)-instantiation of a PLP.
 * 
 * @author Holger Eichelberger
 */
public class InstantiateHandler extends AbstractPlpHandler {

    @Override
    protected void execute(ExecutionEvent event, IProject project, ProductLineProject plp) throws ExecutionException {
        ProductLineCommands.instantiateProductLine(HandlerUtil.getActiveShell(event), plp, false);
    }

}
