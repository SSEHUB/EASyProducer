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
package test.net.ssehub.easy.reasoning.core.qm;

import java.io.File;

import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.ProjectImport;
import test.net.ssehub.easy.reasoning.core.reasoner.AbstractTest;
import test.net.ssehub.easy.reasoning.core.reasoner.ITestDescriptor;

/**
 * Parent class for tests based on the QualiMaster use cases.
 * @author Sizonenko
 * @author El-Sharkawy
 *
 */
public abstract class AbstractQualiMasterTest extends AbstractTest {
      
    protected static final File TESTDATA = determineTestDataFolder("reasonerCore.testdata.home");

    private Project basic;
    private Project observables;
    private Project hardware;
    private Project hardwareCfg;
    private Project adaptivity;
    private Project adaptivityCfg;
    private Project observablesCfg;
    private Project dataManagement;
    private Project dataManagementCfg;
    private Project reconfigurableHardware;
    private Project reconfigurableHardwareCfg;
    private Project algorithms;
    private Project algorithmsCfg;
    private Project families;
    private Project familiesCfg;
    private Project pipelines;
    private Project priorityPipCfg;
    private Project pipelinesCfg;
    private Project infrastructure;
    private Project infrastructureCfg;
    private Project qm;
    
    private ProjectImport importBasic;
    private ProjectImport importObservables;
    private ProjectImport importHardware;
    private ProjectImport importHardwareCfg;
    private ProjectImport importAdaptivity;
    private ProjectImport importAdaptivityCfg;
    private ProjectImport importObservablesCfg;
    private ProjectImport importDataManagement;
    private ProjectImport importDataManagementCfg;
    private ProjectImport importReconfigurableHardware;
    private ProjectImport importReconfigurableHardwareCfg;
    private ProjectImport importAlgorithms;
    private ProjectImport importAlgorithmsCfg;
    private ProjectImport importFamilies;
    private ProjectImport importFamiliesCfg;
    private ProjectImport importPipelines;
    private ProjectImport importPriorityPipCfg;
    private ProjectImport importPipelinesCfg;
    private ProjectImport importInfrastructure;
    private ProjectImport importInfrastructureCfg;

    /**
     * Creating a test instance.
     * 
     * @param descriptor the test descriptor
     * @param testPath the test path (empty or null means do not try to load models)
     */
    protected AbstractQualiMasterTest(ITestDescriptor descriptor, String testPath) {
        super(descriptor, testPath);
    }
    
    /**
     * Method for loading all projects.
     */
    private void loadAllProjects() {
        basic = loadProject("Basics.ivml");
        observables = loadProject("Observables.ivml");
        hardware = loadProject("Hardware.ivml");
        hardwareCfg = loadProject("HardwareCfg.ivml");
        adaptivity = loadProject("Adaptivity.ivml");
        adaptivityCfg = loadProject("AdaptivityCfg.ivml");
        observablesCfg = loadProject("ObservablesCfg.ivml");
        dataManagement = loadProject("DataManagement.ivml");
        dataManagementCfg = loadProject("DataManagementCfg.ivml");
        reconfigurableHardware = loadProject("ReconfigurableHardware.ivml");
        reconfigurableHardwareCfg = loadProject("ReconfigurableHardwareCfg.ivml");
        algorithms = loadProject("Algorithms.ivml");
        algorithmsCfg = loadProject("AlgorithmsCfg.ivml");
        families = loadProject("Families.ivml");
        familiesCfg = loadProject("FamiliesCfg.ivml");
        pipelines = loadProject("Pipelines.ivml");
        priorityPipCfg = loadProject("PriorityPipCfg.ivml");
        pipelinesCfg = loadProject("PipelinesCfg.ivml");
        infrastructure = loadProject("Infrastructure.ivml");
        infrastructureCfg = loadProject("InfrastructureCfg.ivml");
        qm = loadProject("QM_0.ivml");
    }
    
    /**
     * Method for creating project imports.
     */
    private void createProjectImports() {
        importBasic = new ProjectImport(basic.getName(), null);
        importObservables = new ProjectImport(basic.getName(), null);
        importHardware = new ProjectImport(basic.getName(), null);
        importHardwareCfg = new ProjectImport(basic.getName(), null);
        importAdaptivity = new ProjectImport(basic.getName(), null);
        importAdaptivityCfg = new ProjectImport(basic.getName(), null);
        importObservablesCfg = new ProjectImport(basic.getName(), null);
        importDataManagement = new ProjectImport(basic.getName(), null);
        importDataManagementCfg = new ProjectImport(basic.getName(), null);
        importReconfigurableHardware = new ProjectImport(basic.getName(), null);
        importReconfigurableHardwareCfg = new ProjectImport(basic.getName(), null);
        importAlgorithms = new ProjectImport(basic.getName(), null);
        importAlgorithmsCfg = new ProjectImport(basic.getName(), null);
        importFamilies = new ProjectImport(basic.getName(), null);
        importFamiliesCfg = new ProjectImport(basic.getName(), null);
        importPipelines = new ProjectImport(basic.getName(), null);
        importPriorityPipCfg = new ProjectImport(basic.getName(), null);
        importPipelinesCfg = new ProjectImport(basic.getName(), null);
        importInfrastructure = new ProjectImport(basic.getName(), null);
        importInfrastructureCfg = new ProjectImport(basic.getName(), null);
    }
    
    /**
     * Method to create QM model(import projects) and validate it. 
     * @param expectedFailedConstraints Number of constraints that are expected to fail.
     */        
    public final void reasoningTest(int expectedFailedConstraints) {
        loadAllProjects();
        createProjectImports();
        observables.addImport(importBasic);
        hardware.addImport(importBasic);
        hardware.addImport(importObservables);
        hardwareCfg.addImport(importHardware);
        adaptivity.addImport(importBasic);
        adaptivity.addImport(importObservables);
        adaptivityCfg.addImport(importAdaptivity);
        observablesCfg.addImport(importObservables);
        dataManagement.addImport(importBasic);
        dataManagement.addImport(importObservables);
        dataManagementCfg.addImport(importDataManagement);
        reconfigurableHardware.addImport(importBasic);
        reconfigurableHardware.addImport(importObservables);
        reconfigurableHardwareCfg.addImport(importReconfigurableHardware);
        algorithms.addImport(importBasic);
        algorithms.addImport(importObservables);
        algorithms.addImport(importReconfigurableHardware);
        algorithmsCfg.addImport(importReconfigurableHardware);
        algorithmsCfg.addImport(importReconfigurableHardwareCfg);
        algorithmsCfg.addImport(importAlgorithms);
        families.addImport(importBasic);
        families.addImport(importAlgorithms);
        familiesCfg.addImport(importReconfigurableHardware);
        familiesCfg.addImport(importFamilies);
        familiesCfg.addImport(importAlgorithmsCfg);
        pipelines.addImport(importBasic);
        pipelines.addImport(importFamilies);
        pipelines.addImport(importDataManagement);
        pipelines.addImport(importHardware);
        priorityPipCfg.addImport(importPipelines);
        priorityPipCfg.addImport(importFamiliesCfg);
        priorityPipCfg.addImport(importDataManagementCfg);
        pipelinesCfg.addImport(importPriorityPipCfg);
        infrastructure.addImport(importBasic);
        infrastructure.addImport(importHardware);
        infrastructure.addImport(importReconfigurableHardware);
        infrastructure.addImport(importFamilies);
        infrastructure.addImport(importObservables);
        infrastructure.addImport(importAdaptivity);
        infrastructure.addImport(importPipelines);
        infrastructureCfg.addImport(importInfrastructure);
        infrastructureCfg.addImport(importPipelinesCfg);
        qm.addImport(importHardwareCfg);
        qm.addImport(importReconfigurableHardwareCfg);
        qm.addImport(importDataManagementCfg);
        qm.addImport(importObservablesCfg);
        qm.addImport(importAdaptivityCfg);
        qm.addImport(importAlgorithmsCfg);
        qm.addImport(importFamiliesCfg);
        qm.addImport(importPipelinesCfg);
        qm.addImport(importInfrastructureCfg);
        
        resultHandler(expectedFailedConstraints, -1, qm);
    }    
    

}
