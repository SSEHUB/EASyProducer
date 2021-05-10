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
package net.ssehub.easy.standalone.ant;

import java.io.File;
import java.io.IOException;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;

import de.uni_hildesheim.sse.easy.loader.ListLoader;
import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.execution.TracerFactory;
import net.ssehub.easy.instantiation.core.model.tracing.ConsoleTracerFactory;
import net.ssehub.easy.producer.core.mgmt.EasyExecutor;
import net.ssehub.easy.reasoning.core.reasoner.ReasoningResult;

/**
 * A low level ANT task for EASy, running without the EASy core, just using the {@link EasyExecutor}.
 * 
 * @author Holger Eichelberger
 */
public class EASyPlain extends AbstractEASyTask {
    
    private File startupList;
    private boolean verbose = false;
    
    /**
     * Defines the startup list for the EASy {@link ListLoader} as an external file. If not given, the file 
     * {@code .easyStartup} is assumed in the classpath. In essence, this file lists the sequence for Activators and
     * ServiceDescriptors to be started. For the format, please consult {@link ListLoader} or the developers 
     * documentation.
     * 
     * @param file the startup list
     */
    public void setStartupList(File file) {
        startupList = file;
    }
    
    /**
     * Sets the flag for verbose output.
     * 
     * @param verbose {@code true} for verbose, {@code false} else
     */
    public void setVerbose(boolean verbose) {
        this.verbose = verbose;
    }
    
    @Override
    public void execute() throws BuildException {
        if (null != getProjectName() && null != getSource() && null != getTarget()) {
            try {
                ListLoader loader = new ListLoader(startupList);
                loader.setVerbose(true);
                log("EASy starting");
                loader.startup();
                log("EASy started");

                EasyExecutor exec = new EasyExecutor(new File("."), new File("EASy"), getProjectName())
                    .setVilSource(getSource())
                    .setVilTarget(getTarget())
                    .setLogger(new EasyExecutor.Logger() {
                        
                        @Override
                        public void warn(String text) {
                            log(text, Project.MSG_WARN);
                        }

                        @Override
                        public void error(String text) {
                            log(text, Project.MSG_ERR);
                        }
                        
                        @Override
                        public void info(String text) {
                            if (verbose) {
                                log(text);
                            }
                        }
                        
                    });
                exec.setTracerFactory(verbose ? ConsoleTracerFactory.INSTANCE : TracerFactory.DEFAULT);
                exec.setupLocations();
                exec.loadIvmlModel();
                log("EASy locations added");
                exec.loadIvmlModel();
                ReasoningResult rResult = exec.propagateOnIvmlModel();
                log("Reasoning is ok: " + (!rResult.hasConflict()));
                exec.executeVil();
                exec.discardLocations();
                
                log("EASy stopping", Project.MSG_INFO);
                loader.shutdown();
                log("EASy stopped", Project.MSG_INFO);
            } catch (ModelManagementException e) {
                log(e.getMessage());
            } catch (VilException e) {
                log(e.getMessage());
            } catch (IOException e) {
                log(e.getMessage());
            } catch (IllegalStateException e) {
                log(e.getMessage());
            }
        } else {
            log("Source, target and project name must be set.");
        }
    }

}
