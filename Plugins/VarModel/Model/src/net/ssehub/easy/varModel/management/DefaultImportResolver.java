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
package net.ssehub.easy.varModel.management;

import java.util.List;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.basics.messages.IMessage;
import net.ssehub.easy.basics.messages.Message;
import net.ssehub.easy.basics.messages.Status;
import net.ssehub.easy.basics.modelManagement.ModelImport;
import net.ssehub.easy.varModel.Bundle;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.ProjectImport;

/**
 * A project imports resolver. Don't store information in attributes!
 * 
 * @author Holger Eichelberger
 */
class DefaultImportResolver extends net.ssehub.easy.basics.modelManagement.DefaultImportResolver<Project> {

    /**
     * Creates the resolver instance.
     */
    DefaultImportResolver() {
        super(true); // enable cycles
        EASyLogger logger = EASyLoggerFactory.INSTANCE.getLogger(getClass(), Bundle.ID);
        logger.info("Model.DefaultImportResolver registered");            
    }

    /**
     * Checks the imported interfaces for obvious import problems, such as importing projects
     * with interfaces as a whole.
     * 
     * @param imp the import to be resolved
     * @param model the model which may resolve the import
     * @param messages which occur during resolution, <code>null</code> or empty 
     *   if none (modified as a side effect)
     * @return <code>true</code> if the import is fine, <code>true</code> if problems were detected
     */
    @Override
    protected boolean checkImported(ModelImport<Project> imp, Project model, List<IMessage> messages) {
        boolean isOk = true;
        if (!imp.isConflict() && imp instanceof ProjectImport) {
            ProjectImport pImp = (ProjectImport) imp;
            boolean projectHasInterfaces = model.hasInterfaces();
            boolean impHasInterfaces = !isEmptyOrNull(pImp.getInterfaceName());
            if (projectHasInterfaces && !impHasInterfaces) {
                messages.add(new Message("import for project '" + imp.getName() 
                    + "' does not refer to an interface but project declares interfaces", 
                    Status.ERROR));
                isOk = false;
            } else if (!projectHasInterfaces && impHasInterfaces) {
                messages.add(new Message("import for project '" + imp.getName() 
                    + "' refers to an interface but project does not declare interfaces", 
                    Status.ERROR));
                isOk = false;
            }
        }
        return isOk;
    }

    /**
     * Returns whether <code>text</code> is empty or <b>null</b>.
     * @param text the string to be tested
     * @return <code>true</code> if <code>text</code> is empty or <b>null</b>, 
     *   <code>false</code> else
     */
    private static boolean isEmptyOrNull(String text) {
        return null == text || 0 == text.length();
    }

}
