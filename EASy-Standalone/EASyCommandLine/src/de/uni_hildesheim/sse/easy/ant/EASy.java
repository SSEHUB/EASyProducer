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
package de.uni_hildesheim.sse.easy.ant;

import java.io.File;
import java.io.IOException;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;

import de.uni_hildesheim.sse.easy.cmd.InstantiationCommands;
import de.uni_hildesheim.sse.easy.cmd.LowlevelCommands;
import de.uni_hildesheim.sse.easy.cmd.ProjectNameMapper;
import de.uni_hildesheim.sse.easy_producer.core.mgmt.PLPInfo;
import de.uni_hildesheim.sse.easy_producer.core.persistence.PersistenceException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.model.confModel.Configuration;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.reasoning.core.frontend.ReasonerFrontend;
import de.uni_hildesheim.sse.reasoning.core.reasoner.IReasoner;
import de.uni_hildesheim.sse.reasoning.core.reasoner.Message;
import de.uni_hildesheim.sse.reasoning.core.reasoner.ReasonerConfiguration;
import de.uni_hildesheim.sse.reasoning.core.reasoner.ReasoningResult;
import de.uni_hildesheim.sse.utils.progress.ProgressObserver;

/**
 * A simple ANT task for EASy.
 * 
 * @author Holger Eichelberger
 */
public class EASy extends Task {
    
    private File source;
    private File target;
    private String reasoner;
    private String projectName;
    
    /**
     * Defines the source folder.
     * 
     * @param source the source folder
     */
    public void setSource(File source) {
        this.source = source;
    }
    
    /**
     * Defines the target folder.
     * 
     * @param target the target folder
     */
    public void setTarget(File target) {
        this.target = target;
    }

    /**
     * Defines the reasoner in terms of name:version.
     * 
     * @param reasoner the reasoner
     */
    public void setReasoner(String reasoner) {
        this.reasoner = reasoner;
    }
    
    /**
     * Returns the project name. Typically EASy assumes the name of the folder
     * to be the name of the project. However, this is not always the case.
     * 
     * @param projectName the project name
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
    
    /**
     * Defines the optional installation location of Maven.
     * 
     * @param mavenHome as absolute path
     */
    public void setMavenHome(String mavenHome) {
        if (mavenHome.length() > 0) {
            System.setProperty("easy.maven.home", mavenHome);
        }
    }
    
    @Override
    public void execute() throws BuildException {
        if (null != projectName) {
            ProjectNameMapper.setInstance(new ProjectNameMapper() {
                
                @Override
                public String getName(File project) {
                    return projectName;
                }
            });
        }
        try {
            LowlevelCommands.startEASy();
            if (null != reasoner) {
                String[] tmp = reasoner.split(":");
                if (null == tmp || 0 == tmp.length) {
                    throw new BuildException("reasoner not given in form name:version");
                }
                ReasonerFrontend frontend = ReasonerFrontend.getInstance();
                IReasoner reasoner = frontend.findReasoner(tmp[0], tmp[1]);
                if (null == reasoner) {
                    throw new BuildException("reasoner not found: " + reasoner);
                }
                frontend.setReasonerHint(reasoner.getDescriptor());
                LowlevelCommands.loadProject(source);
                String projectName = ProjectNameMapper.getInstance().getName(source);
                PLPInfo plpPre = LowlevelCommands.getProject(projectName);
                Project project = plpPre.getProject();
                Configuration config = plpPre.getConfiguration();
                ReasonerConfiguration rConfig = new ReasonerConfiguration();
                ReasoningResult result = ReasonerFrontend.getInstance().check(project, config, rConfig, 
                    ProgressObserver.NO_OBSERVER);
                if (result.hasConflict()) {
                    String msg = "";
                    for (int r = 0; r < result.getMessageCount(); r++) {
                        Message m = result.getMessage(r);
                        msg += m.getStatus() + ":" + m.getDescription();
                    }
                    throw new BuildException(msg);
                }
            }
            InstantiationCommands.instantiate(source, target);
        } catch (IOException e) {
            throw new BuildException(e.getMessage(), e);
        } catch (VilException e) {
            throw new BuildException(e.getMessage(), e);
        } catch (PersistenceException e) {
            throw new BuildException(e.getMessage(), e);
        }
    }

}
