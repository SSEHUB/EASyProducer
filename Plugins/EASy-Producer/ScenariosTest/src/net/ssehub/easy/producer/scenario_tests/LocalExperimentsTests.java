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
package net.ssehub.easy.producer.scenario_tests;

import java.io.File;
import java.io.IOException;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import net.ssehub.easy.instantiation.core.model.buildlangModel.IBuildlangElement;
import net.ssehub.easy.instantiation.core.model.buildlangModel.IEnumeratingLoop;
import net.ssehub.easy.instantiation.core.model.buildlangModel.Rule;
import net.ssehub.easy.instantiation.core.model.buildlangModel.Script;
import net.ssehub.easy.instantiation.core.model.common.RuntimeEnvironment;
import net.ssehub.easy.instantiation.core.model.common.VariableDeclaration;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.execution.IInstantiatorTracer;
import net.ssehub.easy.instantiation.core.model.execution.TracerFactory;
import net.ssehub.easy.instantiation.core.model.expressions.AbstractTracerBase;
import net.ssehub.easy.instantiation.core.model.expressions.CallExpression.CallType;
import net.ssehub.easy.instantiation.core.model.expressions.Expression;
import net.ssehub.easy.instantiation.core.model.templateModel.Def;
import net.ssehub.easy.instantiation.core.model.templateModel.ITemplateLangElement;
import net.ssehub.easy.instantiation.core.model.templateModel.ITracer;
import net.ssehub.easy.instantiation.core.model.templateModel.Template;
import net.ssehub.easy.instantiation.core.model.tracing.ConsoleTracerFactory;
import net.ssehub.easy.instantiation.core.model.vilTypes.Collection;
import net.ssehub.easy.instantiation.core.model.vilTypes.FieldDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.OperationDescriptor;
import net.ssehub.easy.varModel.varModel.testSupport.TextTestUtils;

/**
 * Experiment tests that currently can only be executed locally.
 * 
 * @author Holger Eichelberger
 */
public class LocalExperimentsTests extends ExperimentsTests {

    /**
     * Starts up the test.
     */
    @BeforeClass
    public static void startUp() {
        ExperimentsTests.startUp();
    }

    /**
     * Tears down the test.
     */
    @AfterClass
    public static void shutDown() {
        ExperimentsTests.shutDown();
    }

    /**
     * Traces VTL execution times.
     * 
     * @author Holger Eichelberger
     */
    private static class VtlExecutionTimeTracer extends AbstractTracerBase
        implements net.ssehub.easy.instantiation.core.model.buildlangModel.ITracer, 
        net.ssehub.easy.instantiation.core.model.templateModel.ITracer, IInstantiatorTracer {

        private HashMap<String, Long> start = new HashMap<String, Long>();
        private HashMap<String, Long> results = new HashMap<String, Long>();
        private int vtlNestingLevel = 0;
        
        /**
         * Returns the names of the measured scripts.
         * 
         * @return the names
         */
        private Set<String> scriptNames() {
            return results.keySet();
        }
        
        /**
         * Returns the execution time of the given script.
         * 
         * @param scriptName the name of the script
         * @return the execution time or <b>null</b> if unknown
         */
        private Long getExecutionTime(String scriptName) {
            return null == scriptName ? null : results.get(scriptName);
        }

        @Override
        public void visitDef(Def def, RuntimeEnvironment<?, ?> environment) {
        }

        @Override
        public void visitedDef(Def def, RuntimeEnvironment<?, ?> environment, Object result) {
        }
        
        @Override
        public void trace(String text) {
        }

        @Override
        public void traceWarning(String text) {
        }

        @Override
        public void valueDefined(VariableDeclaration var, FieldDescriptor field, Object value) {
        }

        @Override
        public void traceExecutionException(VilException exception) {
        }

        @Override
        public void enable(boolean enable) {
        }

        @Override
        public void visitingCallExpression(OperationDescriptor descriptor, CallType callType, Object[] args) {
        }

        @Override
        public void visitedCallExpression(OperationDescriptor descriptor, CallType callType, Object[] args,
            Object result) {
        }

        @Override
        public void failedAt(Expression expression) {
        }

        @Override
        public void traceMessage(String message) {
        }

        @Override
        public void traceError(String message) {
        }

        @Override
        public void visitTemplate(Template template) {
            if (0 == vtlNestingLevel) {
                start.put(template.getName(), System.currentTimeMillis());
            }
            vtlNestingLevel++;
        }

        @Override
        public void visitedTemplate(Template template) {
            vtlNestingLevel--;
            if (0 == vtlNestingLevel) {
                long endTime = System.currentTimeMillis();
                Long startTime = start.remove(template.getName());
                if (null != startTime) {
                    results.put(template.getName(), endTime - startTime);
                }
            }
        }

        @Override
        public void visitedSwitch(Object select, int alternative, Object value) {
        }

        @Override
        public void visitLoop(VariableDeclaration var) {
        }

        @Override
        public void visitedLoop(VariableDeclaration var) {
        }

        @Override
        public void failedAt(ITemplateLangElement element) {
        }

        @Override
        public void visitFlush() {
        }

        @Override
        public void visitedFlush() {
        }

        @Override
        public void visitScript(Script script, RuntimeEnvironment<?, ?> environment) {
        }

        @Override
        public void visitScriptBody(Script script, RuntimeEnvironment<?, ?> environment) {
        }

        @Override
        public void visitedScript(Script script) {
        }

        @Override
        public void visitRule(Rule rule, RuntimeEnvironment<?, ?> environment) {
        }

        @Override
        public void visitedRule(Rule rule, RuntimeEnvironment<?, ?> environment, Object result) {
        }

        @Override
        public void visitLoop(IEnumeratingLoop loop, RuntimeEnvironment<?, ?> environment) {
        }

        @Override
        public void visitIteratorAssignment(IEnumeratingLoop loop,
            net.ssehub.easy.instantiation.core.model.buildlangModel.VariableDeclaration var, Object value) {
        }

        @Override
        public void visitedLoop(IEnumeratingLoop loop, RuntimeEnvironment<?, ?> environment) {
        }

        @Override
        public Collection<?> adjustSequenceForMap(Collection<?> collection) {
            return null;
        }

        @Override
        public Collection<Object> adjustSequenceForJoin(Collection<Object> collection) {
            return null;
        }

        @Override
        public void visitSystemCall(String[] args) {
        }

        @Override
        public void visitingInstantiator(String name) {
        }

        @Override
        public void visitedInstantiator(String name, Object result) {
        }

        @Override
        public void visitAlternative(boolean takeIf) {
        }

        @Override
        public void failedAt(IBuildlangElement element) {
        }

        @Override
        public void reset() {
        }

        @Override
        public void visitWhileBody() {
        }

        @Override
        public void visitedWhileBody() {
        }
        
    }
    
    /**
     * A tracer factory for time tracing.
     * 
     * @author Holger Eichelberger
     */
    private static class TimeTracerFactory extends TracerFactory {

        private VtlExecutionTimeTracer tracer;
        
        /**
         * Constructs a new tracer factory and sets this instance
         * as the default factory.
         */
        private TimeTracerFactory() {
            tracer = new VtlExecutionTimeTracer();
        }
        
        @Override
        public ITracer createTemplateLanguageTracerImpl() {
            return tracer;
        }

        @Override
        public net.ssehub.easy.instantiation.core.model.buildlangModel.ITracer
            createBuildLanguageTracerImpl() {
            return tracer;
        }

        @Override
        public IInstantiatorTracer createInstantiatorTracerImpl() {
            return tracer;
        }

        /**
         * Returns the names of the measured scripts.
         * 
         * @return the names
         */
        private Set<String> scriptNames() {
            return tracer.scriptNames();
        }
        
        /**
         * Returns the execution time of the given script.
         * 
         * @param scriptName the name of the script
         * @return the execution time or <b>null</b> if unknown
         */
        private Long getExecutionTime(String scriptName) {
            return tracer.getExecutionTime(scriptName);
        }

        /**
         * Prints the execution time results as a simple table.
         */
        private void printResults() {
            ArrayList<String> names = new ArrayList<String>();
            names.addAll(scriptNames());
            Collections.sort(names, Collator.getInstance());
            for (String name : names) {
                Long time = getExecutionTime(name);
                if (null != time) {
                    System.out.println(name + "\t\t" + time);
                }
            }
        }
        
    }

    /**
     * Test modified QM XML templates.
     * 
     * @throws IOException shall not occur
     */
    @Test
    public void testXml() throws IOException {
        TimeTracerFactory factory = new TimeTracerFactory();
        TracerFactory.setInstance(factory);
        //TracerFactory.setInstance(new ConsoleTracerFactory(true));
        // no reasoning: we just need specific structures/values
        File tmp = executeCase("xmlExperiments", null, "", null, Mode.INSTANTIATE);
        if (null != tmp) {
            File expected = new File(tmp, "GenTopoHardwareCorrelationFinancialPom.xml");
            TextTestUtils.assertFileEquality(new File(tmp, "hwAlg.xml"), expected);
            TextTestUtils.assertFileEquality(new File(tmp, "hwAlg1.xml"), expected);
            TextTestUtils.assertFileEquality(new File(tmp, "hwAlg2.xml"), expected);
            TextTestUtils.assertFileEquality(new File(tmp, "hwAlg3.xml"), expected);
    
            expected = new File(tmp, "InterfacesPom.xml");
            TextTestUtils.assertFileEquality(new File(tmp, "ifPom.xml"), expected);
            TextTestUtils.assertFileEquality(new File(tmp, "ifPom1.xml"), expected);
            TextTestUtils.assertFileEquality(new File(tmp, "ifPom2.xml"), expected);
            TextTestUtils.assertFileEquality(new File(tmp, "ifPom3.xml"), expected);
    
            expected = new File(tmp, "pipelinePom.xml");
            TextTestUtils.assertFileEquality(new File(tmp, "pip.xml"), expected);
            TextTestUtils.assertFileEquality(new File(tmp, "pip1.xml"), expected);
            TextTestUtils.assertFileEquality(new File(tmp, "pip2.xml"), expected);
            TextTestUtils.assertFileEquality(new File(tmp, "pip3.xml"), expected);
            
            expected = new File(tmp, "pipelines.xml");
            TextTestUtils.assertFileEquality(new File(tmp, "pips.xml"), expected);
            TextTestUtils.assertFileEquality(new File(tmp, "pips1.xml"), expected);
            TextTestUtils.assertFileEquality(new File(tmp, "pips2.xml"), expected);
            TextTestUtils.assertFileEquality(new File(tmp, "pips3.xml"), expected);
            
            expected = new File(tmp, "ModelGenPom.xml");
            TextTestUtils.assertFileEquality(new File(tmp, "modelGenPom.xml"), expected);
            TextTestUtils.assertFileEquality(new File(tmp, "modelGenPom1.xml"), expected);
            TextTestUtils.assertFileEquality(new File(tmp, "modelGenPom2.xml"), expected);
            TextTestUtils.assertFileEquality(new File(tmp, "modelGenPom3.xml"), expected);
    
            expected = new File(tmp, "pipSettings.xml");
            TextTestUtils.assertFileEquality(new File(tmp, "set.xml"), expected);
            TextTestUtils.assertFileEquality(new File(tmp, "set1.xml"), expected);
            TextTestUtils.assertFileEquality(new File(tmp, "set2.xml"), expected);
            TextTestUtils.assertFileEquality(new File(tmp, "set3.xml"), expected);

            factory.printResults();
        }
    }

    /**
     * Test modified QM Java templates.
     * 
     * @throws IOException shall not occur
     */
    @Test
    public void testJava() throws IOException {
        // no reasoning: we just need specific structures/values
        File tmp = executeCase("javaExperiments", null, "", null, Mode.INSTANTIATE); 
        if (null != tmp) {
            File expected = new File(tmp, "FCorrelationFinancial.java");
            TextTestUtils.assertFileEquality(new File(tmp, "fcFam.java"), expected);
            TextTestUtils.assertFileEquality(new File(tmp, "fcFam0.java"), expected);
            TextTestUtils.assertFileEquality(new File(tmp, "fcFam1.java"), expected);
    
            expected = new File(tmp, "IFCorrelationFinancial.java");
            TextTestUtils.assertFileEquality(new File(tmp, "fcFamI.java"), expected);
            TextTestUtils.assertFileEquality(new File(tmp, "fcFamI0.java"), expected);
            TextTestUtils.assertFileEquality(new File(tmp, "fcFamI1.java"), expected);
    
            expected = new File(tmp, "IPriorityDataSink.java");
            TextTestUtils.assertFileEquality(new File(tmp, "psSnk.java"), expected);
            TextTestUtils.assertFileEquality(new File(tmp, "psSnk0.java"), expected);
            TextTestUtils.assertFileEquality(new File(tmp, "psSnk1.java"), expected);
    
            expected = new File(tmp, "PriorityDataSink.java");
            TextTestUtils.assertFileEquality(new File(tmp, "psSnkI.java"), expected);
            TextTestUtils.assertFileEquality(new File(tmp, "psSnkI0.java"), expected);
            TextTestUtils.assertFileEquality(new File(tmp, "psSnkI1.java"), expected);
    
            expected = new File(tmp, "PriorityDataSinkProfiling.java");
            TextTestUtils.assertFileEquality(new File(tmp, "psSnkIP.java"), expected);
            TextTestUtils.assertFileEquality(new File(tmp, "psSnkIP0.java"), expected);
            TextTestUtils.assertFileEquality(new File(tmp, "psSnkIP1.java"), expected);
            
            expected = new File(tmp, "ISpringFinancialData.java");
            TextTestUtils.assertFileEquality(new File(tmp, "spSrc.java"), expected);
            TextTestUtils.assertFileEquality(new File(tmp, "spSrc0.java"), expected);
            TextTestUtils.assertFileEquality(new File(tmp, "spSrc1.java"), expected);
            
            expected = new File(tmp, "SpringFinancialData.java");
            TextTestUtils.assertFileEquality(new File(tmp, "spSrcI.java"), expected);
            TextTestUtils.assertFileEquality(new File(tmp, "spSrcI0.java"), expected);
            TextTestUtils.assertFileEquality(new File(tmp, "spSrcI1.java"), expected);
            
            expected = new File(tmp, "SpringFinancialDataProfiling.java");
            TextTestUtils.assertFileEquality(new File(tmp, "spSrcIP.java"), expected);
            TextTestUtils.assertFileEquality(new File(tmp, "spSrcIP0.java"), expected);
            TextTestUtils.assertFileEquality(new File(tmp, "spSrcIP1.java"), expected);
    
            expected = new File(tmp, "SpringFinancialDataProfilingImpl.java");
            TextTestUtils.assertFileEquality(new File(tmp, "spProfSrcI.java"), expected);
            TextTestUtils.assertFileEquality(new File(tmp, "spProfSrcI0.java"), expected);
            TextTestUtils.assertFileEquality(new File(tmp, "spProfSrcI1.java"), expected);
    
            expected = new File(tmp, "SerializationRegistry.java");
            TextTestUtils.assertFileEquality(new File(tmp, "serReg.java"), expected);
            TextTestUtils.assertFileEquality(new File(tmp, "serReg0.java"), expected);
            TextTestUtils.assertFileEquality(new File(tmp, "serReg1.java"), expected);
    
            expected = new File(tmp, "FCorrelationFinancialSerializers.java");
            TextTestUtils.assertFileEquality(new File(tmp, "tSerFCor.java"), expected);
            TextTestUtils.assertFileEquality(new File(tmp, "tSerFCor0.java"), expected);
            TextTestUtils.assertFileEquality(new File(tmp, "tSerFCor1.java"), expected);
            
            expected = new File(tmp, "GenTopoHardwareFinancialCorrReceiver.cpp");
            TextTestUtils.assertFileEquality(new File(tmp, "FCorReceiver.cpp"), expected);
            TextTestUtils.assertFileEquality(new File(tmp, "FCorReceiver0.cpp"), expected);
            TextTestUtils.assertFileEquality(new File(tmp, "FCorReceiver1.cpp"), expected);
    
            expected = new File(tmp, "GenTopoHardwareFinancialCorrSender.cpp");
            TextTestUtils.assertFileEquality(new File(tmp, "FCorSender.cpp"), expected);
            TextTestUtils.assertFileEquality(new File(tmp, "FCorSender0.cpp"), expected);
            TextTestUtils.assertFileEquality(new File(tmp, "FCorSender1.cpp"), expected);
        }
    }

    /**
     * For developing modified Java templates.
     * 
     * @throws IOException shall not occur
     */
    //@Ignore("just for development/debugging")
    @Test
    public void testJavaDebug() throws IOException {
        TracerFactory.setInstance(new ConsoleTracerFactory(true));

        String[] names = new String[3];
        names[0] = "javaExperiments";
        names[1] = "javaExperiments";
        names[2] = "javaExperimentsDebug";

        // no reasoning: we just need specific structures/values
        File tmp = executeCase(names, null, "", null, Mode.INSTANTIATE); 
        if (null != tmp) {
            File expected = new File(tmp, "PriorityPip_DataManagementElement0DataManagementElement.java");
            TextTestUtils.assertFileEquality(new File(tmp, "PrioPip_DME.java"), expected);
            TextTestUtils.assertFileEquality(new File(tmp, "PrioPip_DME0.java"), expected);
            TextTestUtils.assertFileEquality(new File(tmp, "PrioPip_DME1.java"), expected);
        }
    }

}
