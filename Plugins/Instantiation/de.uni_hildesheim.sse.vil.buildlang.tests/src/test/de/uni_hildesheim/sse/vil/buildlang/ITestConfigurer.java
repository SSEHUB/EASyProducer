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

import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.BuildlangExecution;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.ITracer;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.execution.TracerFactory;
import net.ssehub.easy.basics.modelManagement.IModel;
import net.ssehub.easy.basics.modelManagement.IModelLoader;
import net.ssehub.easy.basics.modelManagement.ModelManagement;
import net.ssehub.easy.dslCore.TranslationResult;

/**
 * Supports application-specific configuration of tests, in particular settings
 * across multiple tests that would otherwise in some situations require multiple
 * inheritance.
 * 
 * @param <M> the actual model type
 * @author Holger Eichelberger
 */
public interface ITestConfigurer <M extends IModel> {

    /**
     * Returns the system property determining the directory containing the actual test data.
     * 
     * @return the name of the system property
     */
    public String getSystemPropertyName();

    /**
     * Returns the model management instance.
     * 
     * @return the model management instance
     */
    public ModelManagement<M> getModelManagement();
    
    /**
     * Returns the default model loader instance.
     * 
     * @return the default model loader
     */
    public IModelLoader<M> getModelLoader();
    
    /**
     * Parses a model from <code>uri</code>.
     * 
     * @param uri the URI to parse from
     * @return the load/parse/translation result
     * @throws IOException in case of I/O problems
     */
    public TranslationResult<M> parse(URI uri) throws IOException;
    
    /**
     * Prints the model stored in the result to the console output stream
     * (for debugging / testing).
     * 
     * @param result the result instance
     * @param out the output writer
     * @param emitComments whether comments shall be emitted
     * @param emitImports whether imports shall be emitted
     */
    public void print(TranslationResult<M> result, Writer out, boolean emitComments, boolean emitImports);
    
    /**
     * Performs further initialization.
     */
    public void furtherInitialization();
    
    /**
     * Returns the file extension.
     * 
     * @return the file extension
     */
    public String getFileExtension();

    /**
     * Creates a new execution environment.
     * 
     * @param tracer the tracer
     * @param base the base directory for making files absolute
     * @param startRuleName the name of the start rule; if multiple source projects are given,
     *   as a convention the first one shall the top-level project that needs to be executed.
     * @param parameter the top-level parameter for the script to be executed
     * @return the execution environment
     */
    public BuildlangExecution createExecutionEnvironment(ITracer tracer, File base, String startRuleName, 
        Map<String, Object> parameter);

    /**
     * Creates a test tracer factory.
     * 
     * @param trace the trace writer
     * @param baseFolders the base folders for turning absolute into relative paths
     * @return the factory
     */
    public TracerFactory createTestTracerFactory(Writer trace, String[] baseFolders);
    
    /**
     * Adds optional test data locations.
     * 
     * @param dir the test data directory
     */
    public void addTestDataLocations(File dir);
}
