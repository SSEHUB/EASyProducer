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
import java.io.StringWriter;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import net.ssehub.easy.basics.modelManagement.ModelInfo;
import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.basics.modelManagement.VersionFormatException;
import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.cst.AttributeVariable;
import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.cst.ConstantValue;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;
import net.ssehub.easy.varModel.cst.Variable;
import net.ssehub.easy.varModel.management.VarModel;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.Attribute;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.FreezeBlock;
import net.ssehub.easy.varModel.model.IFreezable;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.ConstraintType;
import net.ssehub.easy.varModel.model.datatypes.EnumLiteral;
import net.ssehub.easy.varModel.model.datatypes.FreezeVariableType;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.OclKeyWords;
import net.ssehub.easy.varModel.model.datatypes.OrderedEnum;
import net.ssehub.easy.varModel.model.filter.DeclarationFinder;
import net.ssehub.easy.varModel.model.filter.DeclarationFinder.VisibilityType;
import net.ssehub.easy.varModel.model.filter.FilterType;
import net.ssehub.easy.varModel.model.rewrite.ProjectRewriteVisitor;
import net.ssehub.easy.varModel.model.rewrite.RewriteContext;
import net.ssehub.easy.varModel.model.rewrite.modifier.IProjectModifier;
import net.ssehub.easy.varModel.model.values.EnumValue;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;
import net.ssehub.easy.varModel.persistency.IVMLWriter;

/**
 * Tests the {@link ProjectRewriteVisitor}, whether it is able to freeze the QualiMaster model as expected.
 * @author El-Sharkawy
 *
 */
public class DynamicFreezeTest extends AbstractEasyScenarioTest {

    /**
     * This modifier is used to freeze all relevant declarations inside the CFG projects of Qualimaster.
     * @author El-Sharkawy
     *
     */
    private static class ProjectFreezeModifier implements IProjectModifier {
        // Constants as specified by the QM extension
        private static final String CFG_POSTFIX = "Cfg";
        private static final String PROJECT_ADAPTIVITYCFG = "Adaptivity" + CFG_POSTFIX;
        private static final String ANNOTATION_BINDING_TIME = "bindingTime";
        private static final String CONST_BINDING_TIME_RUNTIME_MON = "runtimeMon";
        private static final int RUNTIME_LEVEL = 2;
        
        private static final Set<String> BLACKLIST = new HashSet<String>();
        
        static {
            // Already frozen in Observables (not in config)
            BLACKLIST.add("qualityParameters");
        }
        
        private List<DecisionVariableDeclaration> declarations;
        private Configuration config;
        
        private Map<String, Project> usedProjects = new HashMap<String, Project>();
        
        @Override
        public void modifyProject(Project project, RewriteContext context) {
            // Freeze only in configuration projects
            String pName = project.getName();
            if (pName.endsWith(CFG_POSTFIX) && !pName.equals(PROJECT_ADAPTIVITYCFG)) {
                String projectNS = pName.substring(0, pName.length() - CFG_POSTFIX.length());
                
                // Filter for relevant declarations
                List<IFreezable> toFreeze = new ArrayList<IFreezable>();
                for (int i = 0, end = declarations.size(); i < end; i++) {
                    DecisionVariableDeclaration decl = declarations.get(i);
                    // Include condition: Declaration was declared in <project> or <projectCfg>
                    if (decl.getNameSpace().equals(projectNS) || decl.getNameSpace().equals(pName)) {
                        
                        // Exclude condition: Declaration is runtime variable or toplevel constraint variable
                        if (!ConstraintType.TYPE.isAssignableFrom(decl.getType()) && !isRuntimeVariable(config, decl)
                            && !BLACKLIST.contains(decl.getName())) {
                            
                            toFreeze.add((IFreezable) decl);
                        }
                    }
                }
                IFreezable[] freezes = toFreeze.toArray(new IFreezable[0]);
                
                // Create selector
                DecisionVariableDeclaration itr = null;
                ConstraintSyntaxTree selector = null;
                Attribute annotation = getBindingTimeAnnotation(project);
                if (null != annotation && annotation.getType() instanceof OrderedEnum) {
                    OrderedEnum btType = (OrderedEnum) annotation.getType();
                    EnumLiteral lit = null;
                    ConstantValue cVal = null;
                    for (int i = 0, end = btType.getLiteralCount(); i < end && null == lit; i++) {
                        if (btType.getLiteral(i).getName().equals(CONST_BINDING_TIME_RUNTIME_MON)) {
                            lit = btType.getLiteral(i);
                            try {
                                cVal = new ConstantValue(ValueFactory.createValue(btType, lit));
                            } catch (ValueDoesNotMatchTypeException e) {
                                Assert.fail(e.getMessage());
                            }
                        }
                    }
                    if (null != cVal) {
                        IDatatype freezeType = new FreezeVariableType(freezes, project);
                        itr = new DecisionVariableDeclaration("var", freezeType, project);
                        AttributeVariable attrExpr = new AttributeVariable(new Variable(itr), annotation);
                        selector = new OCLFeatureCall(attrExpr, OclKeyWords.GREATER_EQUALS, cVal);
                        try {
                            selector.inferDatatype();
                        } catch (CSTSemanticException e) {
                            itr = null;
                            selector = null;
                        }
                    }
                }
                
                FreezeBlock block = new FreezeBlock(freezes, itr, selector, project);
                project.add(block);
            }
        }
        
        /**
         * Checks whether the given declaration is a runtime variable.
         * @param config The configuration where the declaration belongs to.
         * @param declaration The declaration to test.
         * @return <code>true</code> if the variable is a runtime variable and should not be frozen, 
         *     <code>false</code> else.
         */
        private boolean isRuntimeVariable(Configuration config, DecisionVariableDeclaration declaration) {
            boolean isRuntimeVar = false;

            IDecisionVariable var = config.getDecision(declaration);
            IDecisionVariable annotationVar = null;
            
            for (int i = 0, end = var.getAttributesCount(); i < end && null == annotationVar; i++) {
                IDecisionVariable tmpVar = var.getAttribute(i);
                if (ANNOTATION_BINDING_TIME.equals(tmpVar.getDeclaration().getName())) {
                    annotationVar = tmpVar;
                }
            }
            
            if (null != annotationVar && null != annotationVar.getValue()
                && annotationVar.getValue() instanceof EnumValue) {
                
                EnumLiteral selectedLiteral = ((EnumValue) annotationVar.getValue()).getValue();
                isRuntimeVar = selectedLiteral.getOrdinal() >= RUNTIME_LEVEL;
            }
            
            return isRuntimeVar;
        }
        
        /**
         * Returns the binding time annotation of the project to create the selector statement of the freeze block.
         * @param project The project for which the freeze block shall be created.
         * @return The binding time annotation or <code>null</code> it could not be found.
         */
        private Attribute getBindingTimeAnnotation(Project project) {
            Attribute btAnnotation = project.getAttribute(ANNOTATION_BINDING_TIME);
            
            // Try to build up the cache
            if (null == btAnnotation && project.getName().endsWith(CFG_POSTFIX)) {
                String baseName = project.getName().substring(0, project.getName().length() - CFG_POSTFIX.length());
                Project baseProject = usedProjects.get(baseName);
                if (null == baseProject) {
                    for (int i = 0, end = project.getImportsCount(); i < end && null == baseProject; i++) {
                        Project importedProject = project.getImport(i).getResolved();
                        String importedName = importedProject.getName();
                        
                        if (!usedProjects.containsKey(importedName)) {
                            usedProjects.put(importedName, importedProject);
                        }
                        
                        if (baseName.equals(importedName)) {
                            baseProject = importedProject;
                        }
                    }
                }
                
                if (null != baseProject) {
                    for (int i = 0, end = baseProject.getAttributesCount(); i < end && btAnnotation == null; i++) {
                        btAnnotation = baseProject.getAttribute(ANNOTATION_BINDING_TIME);
                    }
                }
            }
            
            return btAnnotation;
        }
    }
    
    private static final String PROJECT_OBSERVABLESCFG = "ObservablesCfg";

    private final File testdataDir = new File(getTestDataDir(), "real/QualiMaster/jun16");
    private final File expectedModelDir = new File(testdataDir, "expected");
    
    @Override
    protected File getTestFolder() {
        return new File(testdataDir, "without_freeze");
    }

    /**
     * Loads the specified {@link Project} from the {@link #getTestFolder()} folder.
     * @param folder The main folder from where to load the project structure, e.g., {@link #getTestFolder()}.
     * @param projectName The name of the main project to load.
     * @param version Optional: the version of the project to load (only numbers, without an preceding v).
     * @return The specified project, loaded from the {@link #getTestFolder()}.
     */
    private Project loadProject(File folder, String projectName, String version) {
        Project mainProject = null;
        
        // Register test data folder for model loading        
        try {
            VarModel.INSTANCE.locations().addLocation(folder, ProgressObserver.NO_OBSERVER);
        } catch (ModelManagementException e) {
            Assert.fail("unexpected exception: " + e.getMessage());
        }
        
        // Determine start file
        String fileName = null == version ? projectName : projectName + "_" + version;
        File modelFile = new File(folder, fileName + ".ivml");
        Assert.assertTrue("Error: File \"" + modelFile.getAbsolutePath() + "\" does not exist.", modelFile.exists());
        
        // Load the model
        URI modelURI = modelFile.toURI();
        try {
            ModelInfo<Project> info = 
                VarModel.INSTANCE.availableModels().getModelInfo(projectName, version, modelURI);
            Assert.assertNotNull("IVML model " + projectName + " cannot be found", info);
            mainProject = VarModel.INSTANCE.load(info);
        } catch (VersionFormatException e) {
            Assert.fail("version information invalid");
        } catch (ModelManagementException e) {
            Assert.fail("unexpected exception: " + e);
        }
        Assert.assertNotNull("cannot load IVML model \"" + projectName + "\" (syntax?)", mainProject);
        
        return mainProject;
    }
    
    /**
     * Tests whether the {@link ProjectRewriteVisitor} is able add {@link FreezeBlock}s as it should be done in the
     * QualiMaster tool.
     */
    @Test
    public void testDynamicFreeze() {
        Project qmModel = loadProject(getTestFolder(), "QM", "0");
        Configuration config = new Configuration(qmModel);
        Project expectedModel = loadProject(expectedModelDir, "QM", "0");
        
        // Freeze the project, except for the runtime elements.
        // Find declarations to freeze
        DeclarationFinder finder = new DeclarationFinder(qmModel, FilterType.ALL, null);
        List<DecisionVariableDeclaration> allDeclarations = new ArrayList<DecisionVariableDeclaration>();
        List<AbstractVariable> tmpList = finder.getVariableDeclarations(VisibilityType.ALL);
        for (int i = 0, end = tmpList.size(); i < end; i++) {
            AbstractVariable declaration = tmpList.get(i);
            if (declaration instanceof DecisionVariableDeclaration
                && !(declaration.getNameSpace().equals(PROJECT_OBSERVABLESCFG))) {
                
                allDeclarations.add((DecisionVariableDeclaration) declaration);
            }
        }
        
        // Freeze
        ProjectRewriteVisitor rewriter = new ProjectRewriteVisitor(qmModel, FilterType.ALL);
        ProjectFreezeModifier freezer = new ProjectFreezeModifier();
        freezer.declarations = allDeclarations;
        freezer.config = config;
        rewriter.addProjectModifier(freezer);
        qmModel.accept(rewriter);
        
        // Test correct freezing
        compare(qmModel, expectedModel, new HashSet<Project>());
    }
    
    /**
     * Recursive method for comparing the modified project with the expected project. 
     * @param actual The modified project (which was changed by the {@link ProjectRewriteVisitor}).
     * @param expected The expected project, loaded from {@link #expectedModelDir}.
     * @param done The list of already tested modified projects, should be empty when called from outside.
     */
    private void compare(Project actual, Project expected, Set<Project> done) {
        if (!done.contains(actual)) {
            done.add(actual);
      
            // Compare String version of projects
            Assert.assertEquals("Project \"" + actual.getName() + "\" is not as expected:\n", toString(expected),
                toString(actual));
            
            // Continue with imported projects
            for (int i = 0; i < actual.getImportsCount(); i++) {
                // Imports of expected should be in same order as in actual
                compare(actual.getImport(i).getResolved(), expected.getImport(i).getResolved(), done);
            }
        }
    }

    /**
     * Converts the given project to a String.
     * @param project The project to convert, must not be <code>null</code>.
     * @return The parseable string version of the project.
     */
    private String toString(Project project) {
        StringWriter sWriter = new StringWriter();
        IVMLWriter iWriter = new IVMLWriter(sWriter);
        project.accept(iWriter);
        return sWriter.toString();
    }
}
