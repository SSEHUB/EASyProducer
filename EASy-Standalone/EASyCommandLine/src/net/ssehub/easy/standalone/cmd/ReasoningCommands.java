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

package net.ssehub.easy.standalone.cmd;

import java.io.File;
import java.io.IOException;

import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.basics.modelManagement.VersionFormatException;
import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.producer.core.mgmt.PLPInfo;
import net.ssehub.easy.producer.core.persistence.PersistenceException;
import net.ssehub.easy.producer.core.persistence.PersistenceUtils;
import net.ssehub.easy.reasoning.core.frontend.ReasonerFrontend;
import net.ssehub.easy.reasoning.core.reasoner.ReasonerConfiguration;
import net.ssehub.easy.reasoning.core.reasoner.ReasoningResult;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.management.VarModel;
import net.ssehub.easy.varModel.model.Project;

/**
 * This class is currently rather preliminary and basically intended for testing proper loading
 * of the reasoner by the EASy Loader.<br/>
 * <b>Before calling any of the methods in this class, EASy must be loaded via calling 
 * {@link LowlevelCommands#startEASy()}.</b>
 * 
 * @author Holger Eichelberger
 * @author Sascha El-Sharkawy
 */
public class ReasoningCommands {

    /**
     * Checks the validity of the specified EASy project by reasoning.
     * 
     * @param project the project the model is located in
     * @return <code>true</code> if conflict occurred, <code>false</code> otherwise
     * 
     * @throws PersistenceException in case that the model cannot be loaded for some reason
     */
    public static boolean checkValidity(File project) throws PersistenceException {
        LowlevelCommands.loadProject(project);
        String projectName = ProjectNameMapper.getInstance().getName(project);
        PLPInfo plp = LowlevelCommands.getProject(projectName);
        return checkValidity(plp.getProject());
    }
    
    /**
     * Checks the validity of the specified IVML model by reasoning.
     * 
     * @param project the project the model is located in
     * @param ivmlFile the IVML model file to be checked
     * @return <code>true</code> if conflict occurred, <code>false</code> else
     * 
     * @throws ModelManagementException in case that the model cannot be loaded for some reason
     */
    public static boolean checkValidity(File project, File ivmlFile) 
        throws ModelManagementException {
        net.ssehub.easy.producer.core.persistence.Configuration config 
            = PersistenceUtils.getConfiguration(project);
        PersistenceUtils.addLocation(config, ProgressObserver.NO_OBSERVER);    
        Project ivmlProject = PersistenceUtils.loadModel(VarModel.INSTANCE, ivmlFile);      
        return checkValidity(ivmlProject);
    }
    
    /**
     * Checks the validity of the specified IVML model by reasoning.
     * 
     * @param project the project the model is located in
     * @param ivmlDefinition the IVML model definition
     * @return <code>true</code> if conflict occurred, <code>false</code> else
     * 
     * @throws ModelManagementException in case that the model cannot be loaded for some reason
     */
    public static boolean checkValidity(File project, ModelLoadDefinition ivmlDefinition) 
        throws ModelManagementException {
        VarModel.INSTANCE.locations().addLocation(project, ProgressObserver.NO_OBSERVER);
        Project ivmlProject = Utils.loadPreferredModel(VarModel.INSTANCE, ivmlDefinition, project);
        return checkValidity(ivmlProject);
    }

    /**
     * Checks the validity of the specified IVML model by reasoning.
     * 
     * @param project the IVML model to be checked
     * @return <code>true</code> if conflict occurred, <code>false</code> else
     */
    public static boolean checkValidity(Project project) {
        Configuration config = new Configuration(project);
        ReasonerConfiguration rConfig = new ReasonerConfiguration();
        ReasoningResult result = ReasonerFrontend.getInstance().check(config, rConfig, 
            ProgressObserver.NO_OBSERVER);
        return result.hasConflict();
    }
    
    /**
     * Just for testing.
     * 
     * @param args command line arguments - ignored
     * 
     * @throws IOException in case of I/O problems
     * @throws VersionFormatException in case of version specification problems
     * @throws ModelManagementException in case of problems loading the models
     */
    public static void main(String[] args) throws IOException, VersionFormatException, ModelManagementException  {
        LowlevelCommands.startEASy();
        ModelLoadDefinition mld = new ModelLoadDefinition("PL_SimElevator_frozen", "0");
        File project = new File("../EASyCommandLineTest/testdata/elevator/PL_SimElevator_frozen");
        System.out.println("has conflict: " + checkValidity(project, mld));
    }
    
}
