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
package net.ssehub.easy.standalone.ant;

import java.io.File;
import java.io.IOException;

import org.apache.tools.ant.BuildException;

import net.ssehub.easy.basics.messages.Message;
import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.producer.core.mgmt.PLPInfo;
import net.ssehub.easy.producer.core.persistence.PersistenceException;
import net.ssehub.easy.reasoning.core.frontend.ReasonerFrontend;
import net.ssehub.easy.reasoning.core.reasoner.IReasoner;
import net.ssehub.easy.reasoning.core.reasoner.ReasonerConfiguration;
import net.ssehub.easy.reasoning.core.reasoner.ReasoningResult;
import net.ssehub.easy.standalone.cmd.InstantiationCommands;
import net.ssehub.easy.standalone.cmd.LowlevelCommands;
import net.ssehub.easy.standalone.cmd.ProjectNameMapper;
import net.ssehub.easy.varModel.confModel.Configuration;

/**
 * A simple ANT task for EASy based on the EASy core, the PLP project and also the EASy settings.
 * 
 * @author Holger Eichelberger
 */
public class EASy extends AbstractEASyTask {
    
    private String reasoner;
    
    /**
     * Defines the reasoner in terms of name:version.
     * 
     * @param reasoner the reasoner
     */
    public void setReasoner(String reasoner) {
        this.reasoner = reasoner;
    }
    
    @Override
    public void execute() throws BuildException {
        if (null != getProjectName()) {
            ProjectNameMapper.setInstance(new ProjectNameMapper() {
                
                @Override
                public String getName(File project) {
                    return getProjectName();
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
                LowlevelCommands.loadProject(getSource());
                String projectName = ProjectNameMapper.getInstance().getName(getSource());
                PLPInfo plpPre = LowlevelCommands.getProject(projectName);
                Configuration config = plpPre.getConfiguration();
                ReasonerConfiguration rConfig = new ReasonerConfiguration();
                ReasoningResult result = ReasonerFrontend.getInstance().check(config, rConfig, 
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
            InstantiationCommands.instantiate(getSource(), getTarget());
        } catch (IOException e) {
            throw new BuildException(e.getMessage(), e);
        } catch (VilException e) {
            throw new BuildException(e.getMessage(), e);
        } catch (PersistenceException e) {
            throw new BuildException(e.getMessage(), e);
        }
    }

}
