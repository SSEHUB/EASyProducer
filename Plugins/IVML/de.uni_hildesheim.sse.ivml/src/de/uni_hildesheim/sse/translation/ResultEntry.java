/*
 * Copyright 2009-2016 University of Hildesheim, Software Systems Engineering
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
package de.uni_hildesheim.sse.translation;

import java.net.URI;

import de.uni_hildesheim.sse.ModelUtility;
import de.uni_hildesheim.sse.translation.ModelTranslator.Result;
import net.ssehub.easy.varModel.management.VarModel;
import net.ssehub.easy.varModel.model.Project;

/**
 * A result entry consisting of an xtext and a result model.
 * 
 * @author Holger Eichelberger
 */
class ResultEntry {
    private de.uni_hildesheim.sse.ivml.Project eProject; 
    private Project project;
    private TypeContext context;
    private Utils.SplitResult splitResult;
    private URI uri;
    private int errorCount;

    /**
     * Creates the result entry.
     * 
     * @param eProject the xtext project
     * @param project the result project
     * @param context the actual type context
     * @param splitResult the type splitted model elements of <code>eProject</code>
     */
    ResultEntry(de.uni_hildesheim.sse.ivml.Project eProject, Project project, TypeContext context, 
        Utils.SplitResult splitResult) {
        this.eProject = eProject;
        this.project = project;
        this.context = context;
        this.splitResult = splitResult;
    }
    
    /**
     * Sets additional information required to register a successfully created model with {@link VarModel}.
     * 
     * @param uri the URI of the model (if given, indicates that a successfully loaded model shall be registered) 
     * @param errorCount the initial error count
     */
    void setRegistrationInfo(URI uri, int errorCount) {
        this.uri = uri;
        this.errorCount = errorCount;
    }
    
    /**
     * Completes loading.
     * 
     * @param result the parent instance
     */
    void completeLoading(Result result) { 
        result.getTranslator().completeLoading(this);
    }

    /**
     * Returns the (result) project.
     * 
     * @return the project
     */
    Project getProject() {
        return project;
    }
    
    /**
     * Returns the splitted entries.
     * 
     * @return the splitted entries
     */
    Utils.SplitResult getSplitResult() {
        return splitResult;
    }
    
    /**
     * Returns the actual type context.
     * 
     * @return the type context
     */
    TypeContext getContext() {
        return context;
    }
    
    /**
     * Returns the xText project.
     * 
     * @return the xText project
     */
    de.uni_hildesheim.sse.ivml.Project getEProject() {
        return eProject;
    }
    
    /**
     * Registers the (successful) result if needed, i.e., if {@link #setRegistrationInfo(URI, int)} has been called
     * with a URL.
     * 
     * @param errorCount the actual error count
     * @return <code>true</code> if a registration happened, <code>false</code> else
     */
    boolean registerIfNeeded(int errorCount) {
        boolean registered = false;
        if (null != uri && this.errorCount == errorCount) {
            // required if models in the same file refer to each other
            VarModel.INSTANCE.updateModel(project, uri, ModelUtility.INSTANCE, false);
            registered = true;
        }
        VarModel.INSTANCE.notifyLoadingCompleted(project, uri);
        return registered;
    }

}