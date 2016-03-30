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
package test.de.uni_hildesheim.sse.vil.buildlang;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.Map;

import org.eclipse.emf.common.util.URI;

import de.uni_hildesheim.sse.BuildLangModelUtility;
import net.ssehub.easy.basics.modelManagement.IModelLoader;
import net.ssehub.easy.basics.modelManagement.ModelManagement;
import net.ssehub.easy.dslCore.TranslationResult;
import net.ssehub.easy.instantiation.core.model.buildlangModel.BuildModel;
import net.ssehub.easy.instantiation.core.model.buildlangModel.BuildlangExecution;
import net.ssehub.easy.instantiation.core.model.buildlangModel.ITracer;
import net.ssehub.easy.instantiation.core.model.buildlangModel.Script;
import net.ssehub.easy.instantiation.core.model.execution.TracerFactory;

/**
 * Configures the tests for the build language (VIL).
 * 
 * @author Holger Eichelberger
 */
public class BuildLangTestConfigurer implements ITestConfigurer<Script> {

    private String systemProperty;
    
    /**
     * Creates a configurer taking the tests from the folder in <code>systemProperty</code>.
     * 
     * @param systemProperty the system property pointing to the test folder
     */
    public BuildLangTestConfigurer(String systemProperty) {
        this.systemProperty = systemProperty;
    }
    
    @Override
    public String getSystemPropertyName() {
        return systemProperty;
    }

    @Override
    public ModelManagement<Script> getModelManagement() {
        return BuildModel.INSTANCE;
    }

    @Override
    public IModelLoader<Script> getModelLoader() {
        return BuildLangModelUtility.INSTANCE;
    }

    @Override
    public TranslationResult<Script> parse(URI uri) throws IOException {
        return BuildLangModelUtility.INSTANCE.parse(uri);
    }

    @Override
    public void print(TranslationResult<Script> result, Writer out, boolean emitComments, boolean emitImports) {
        BuildLangModelUtility.INSTANCE.print(result, out, emitComments, emitImports);
    }

    @Override
    public void furtherInitialization() {
        // nothing to do
    }

    @Override
    public String getFileExtension() {
        return "vil";
    }

    @Override
    public BuildlangExecution createExecutionEnvironment(ITracer tracer, File base, String startRuleName, 
        Map<String, Object> parameter) {
        return new BuildlangExecution(tracer, base, startRuleName, parameter);
    }

    @Override
    public TracerFactory createTestTracerFactory(Writer trace, String[] baseFolders) {
        return new TestTracerFactory(trace, baseFolders);
    }
    
    @Override
    public void addTestDataLocations(File dir) {
    }

}
