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
package de.uni_hildesheim.sse.vil.rt.tests;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.junit.Assert;

import de.uni_hildesheim.sse.BuildLangModelUtility;
import de.uni_hildesheim.sse.vil.rt.RtVilExpressionParser;
import de.uni_hildesheim.sse.vil.rt.RtVilModelUtility;
import de.uni_hildesheim.sse.vil.rt.tests.types.Register;
import net.ssehub.easy.basics.modelManagement.IModelLoader;
import net.ssehub.easy.basics.modelManagement.ModelManagement;
import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.dslCore.TranslationResult;
import net.ssehub.easy.instantiation.core.model.buildlangModel.BuildModel;
import net.ssehub.easy.instantiation.core.model.buildlangModel.BuildlangExecution;
import net.ssehub.easy.instantiation.core.model.buildlangModel.ITracer;
import net.ssehub.easy.instantiation.core.model.execution.TracerFactory;
import net.ssehub.easy.instantiation.core.model.expressions.ExpressionParserRegistry;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.Configuration;
import net.ssehub.easy.instantiation.rt.core.model.rtVil.BuiltIn;
import net.ssehub.easy.instantiation.rt.core.model.rtVil.IRtValueAccess;
import net.ssehub.easy.instantiation.rt.core.model.rtVil.IRtVilConcept;
import net.ssehub.easy.instantiation.rt.core.model.rtVil.ReasoningHookAdapter;
import net.ssehub.easy.instantiation.rt.core.model.rtVil.RtVilExecution;
import net.ssehub.easy.instantiation.rt.core.model.rtVil.RtVilModel;
import net.ssehub.easy.instantiation.rt.core.model.rtVil.Script;
import net.ssehub.easy.reasoning.core.reasoner.AbstractTest;
import net.ssehub.easy.reasoning.core.reasoner.ReasonerConfiguration;
import net.ssehub.easy.reasoning.core.reasoner.ReasoningResult;
import net.ssehub.easy.varModel.management.VarModel;
import net.ssehub.easy.varModel.varModel.testSupport.MeasurementCollector;
import net.ssehub.easy.varModel.varModel.testSupport.TSVMeasurementCollector;
import test.de.uni_hildesheim.sse.vil.buildlang.ITestConfigurer;
import test.de.uni_hildesheim.sse.vil.buildlang.TestTracerFactory;

/**
 * Configures the tests for rt-VIL.
 * 
 * @author Holger Eichelberger
 */
public class RtVilTestConfigurer implements ITestConfigurer<Script> {

    @Override
    public String getSystemPropertyName() {
        return "vil.rt.testdata.home";
    }

    @Override
    public ModelManagement<Script> getModelManagement() {
        return RtVilModel.INSTANCE;
    }

    @Override
    public IModelLoader<Script> getModelLoader() {
        return RtVilModelUtility.INSTANCE;
    }

    @Override
    public TranslationResult<Script> parse(URI uri) throws IOException {
        return RtVilModelUtility.INSTANCE.parse(uri);
    }

    @Override
    public void print(TranslationResult<Script> result, Writer out, boolean emitComments, boolean emitImports) {
        RtVilModelUtility.INSTANCE.print(result, out, emitComments, emitImports);
    }
    
    @Override
    public void furtherInitialization() {
        ExpressionParserRegistry.setExpressionParser(RtVilExecution.LANGUAGE, new RtVilExpressionParser());
        BuiltIn.initialize();
        
        try {
            BuildModel.INSTANCE.loaders().registerLoader(BuildLangModelUtility.INSTANCE, ProgressObserver.NO_OBSERVER);
        } catch (ModelManagementException e) {
            e.printStackTrace(System.err);
            Assert.assertTrue(false); // shall not happen
        }
        Register.register();
    }
    
    @Override
    public void addTestDataLocations(File dir) {
        try {
            VarModel.INSTANCE.locations().addLocation(dir, ProgressObserver.NO_OBSERVER);
            BuildModel.INSTANCE.locations().addLocation(dir, ProgressObserver.NO_OBSERVER);
        } catch (ModelManagementException e) {
            e.printStackTrace(System.err);
            Assert.assertTrue(false); // shall not happen
        }
    }
    
    @Override
    public String getFileExtension() {
        return "rtvil";
    }

    @Override
    public BuildlangExecution createExecutionEnvironment(ITracer tracer, File base, String startRuleName,
        Map<String, Object> parameter) {
        RtVilExecution result = new RtVilExecution(tracer, base, parameter);
        result.setStopAfterBindValues(false); // although default, fits to initial code
        result.setUseReasoner(true);
        result.setReasoningHook(new ReasoningHookAdapter() {

            private String id;
            
            @Override
            public void preReasoning(Script script, IRtVilConcept concept, IRtValueAccess values, 
                Configuration config) {
                File base = AbstractRtTest.determineTestDataDir(getSystemPropertyName());
                TSVMeasurementCollector.ensureCollector(new File(base, 
                    "temp/measurements-rtvil.tsv"));
                id = MeasurementCollector.start(config.getConfiguration(), "RT-VIL");
            }
            
            @Override
            public void postReasoning(Script script, IRtVilConcept concept, IRtValueAccess values, 
                Configuration config, ReasoningResult result) {
                MeasurementCollector.endAuto(id);
                AbstractTest.transferReasoningMeasures(MeasurementCollector.getInstance(), id, 
                    AbstractRtTest.MEASUREMENTS, result);
                MeasurementCollector.end(id);
                result.logInformation(config.getConfiguration().getProject(), 
                    ReasonerConfiguration.ADDITIONAL_INFO_LOG_SYSOUT);
            }
        });
        return result;
    }

    @Override
    public TracerFactory createTestTracerFactory(Writer trace, String[] baseFolders) {
        return new TestTracerFactory(trace, baseFolders);
    }

}
