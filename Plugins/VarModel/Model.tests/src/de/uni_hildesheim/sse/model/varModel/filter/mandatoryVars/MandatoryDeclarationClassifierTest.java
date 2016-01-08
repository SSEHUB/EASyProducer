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
package de.uni_hildesheim.sse.model.varModel.filter.mandatoryVars;

import org.junit.Assert;
import org.junit.Test;

import de.uni_hildesheim.sse.model.confModel.Configuration;
import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;
import de.uni_hildesheim.sse.model.cst.CSTSemanticException;
import de.uni_hildesheim.sse.model.cst.CompoundAccess;
import de.uni_hildesheim.sse.model.cst.ConstantValue;
import de.uni_hildesheim.sse.model.cst.OCLFeatureCall;
import de.uni_hildesheim.sse.model.cst.Variable;
import de.uni_hildesheim.sse.model.varModel.Constraint;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
import de.uni_hildesheim.sse.model.varModel.datatypes.ConstraintType;
import de.uni_hildesheim.sse.model.varModel.datatypes.DerivedDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.IntegerType;
import de.uni_hildesheim.sse.model.varModel.datatypes.OclKeyWords;
import de.uni_hildesheim.sse.model.varModel.filter.FilterType;
import de.uni_hildesheim.sse.model.varModel.values.ValueDoesNotMatchTypeException;
import de.uni_hildesheim.sse.model.varModel.values.ValueFactory;
import de.uni_hildesheim.sse.varModel.testSupport.ProjectTestUtilities;

/**
 * Tests the {@link MandatoryDeclarationClassifier}.
 * @author El-Sharkawy
 */
public class MandatoryDeclarationClassifierTest {
    
    private static final ConstantValue ZERO;
    
    static {
        ConstantValue zero = null;
        try {
            zero = new ConstantValue(ValueFactory.createValue(IntegerType.TYPE, 0));
        } catch (ValueDoesNotMatchTypeException e) {
            Assert.fail("Could not initalize 0 as an IntegerValue");
        }
        ZERO = zero;
    }
    
    /**
     * Tests whether assignments are ignored.
     * @throws CSTSemanticException Must not occur, otherwise {@link Constraint}s are broken.
     */
    @Test
    public void testIgnoreAssignments() throws CSTSemanticException {
        // Create Project, with 3 declarations, 2 are used in a constrained, one is optional
        Project project = new Project("testFindOnlyConstrainedVariablesSimple");
        DecisionVariableDeclaration declA = new DecisionVariableDeclaration("intA", IntegerType.TYPE, project);
        project.add(declA);
        Constraint comparison = new Constraint(project);
        OCLFeatureCall compCall = new OCLFeatureCall(new Variable(declA), OclKeyWords.ASSIGNMENT, ZERO);
        comparison.setConsSyntax(compCall);
        project.add(comparison);
        
        // Create configuration out of valid project
        ProjectTestUtilities.validateProject(project);
        Configuration config = new Configuration(project);
        
        // Check importance
        MandatoryDeclarationClassifier finder = new MandatoryDeclarationClassifier(config, FilterType.ALL);
        project.accept(finder);
        VariableContainer importances = finder.getImportances();
        
        // Test correct behavior: declC is not mandatory
        assertVariable(config.getDecision(declA), false, importances);
    }
    
    /**
     * Tests whether simple toplevel declarations are resolved correctly.
     * @throws CSTSemanticException Must not occur, otherwise {@link Constraint}s are broken.
     */
    @Test
    public void testFindOnlyConstrainedVariablesSimple() throws CSTSemanticException {
        // Create Project with 3 declarations, 2 are used in a constrained, one is optional
        Project project = new Project("testFindOnlyConstrainedVariablesSimple");
        DecisionVariableDeclaration declA = new DecisionVariableDeclaration("intA", IntegerType.TYPE, project);
        DecisionVariableDeclaration declB = new DecisionVariableDeclaration("intB", IntegerType.TYPE, project);
        DecisionVariableDeclaration declC = new DecisionVariableDeclaration("intC", IntegerType.TYPE, project);
        project.add(declA);
        project.add(declB);
        project.add(declC);
        Constraint comparison = new Constraint(project);
        OCLFeatureCall compCall = new OCLFeatureCall(new Variable(declA), OclKeyWords.GREATER, new Variable(declB));
        comparison.setConsSyntax(compCall);
        project.add(comparison);
        
        // Create configuration out of valid project
        ProjectTestUtilities.validateProject(project);
        Configuration config = new Configuration(project);
        
        // Check importance
        MandatoryDeclarationClassifier finder = new MandatoryDeclarationClassifier(config, FilterType.ALL);
        project.accept(finder);
        VariableContainer importances = finder.getImportances();
        
        // Test correct behavior: declC is not mandatory
        assertVariable(config.getDecision(declA), true, importances);
        assertVariable(config.getDecision(declB), true, importances);
        assertVariable(config.getDecision(declC), false, importances);
    }
    
    /**
     * Test whether slots of a compound are resolved correctly.
     * @throws CSTSemanticException Must not occur, otherwise {@link Constraint}s are broken.
     */
    @Test
    public void testFindConstrainedCompoundSlots() throws CSTSemanticException {
        // Create project with compound, one slot has a constraint
        Project project = new Project("testFindConstrainedCompoundSlots");
        Compound dimType = new Compound("Dimension", project);
        project.add(dimType);
        DecisionVariableDeclaration declWidth = new DecisionVariableDeclaration("width", IntegerType.TYPE, dimType);
        DecisionVariableDeclaration declHeight = new DecisionVariableDeclaration("height", IntegerType.TYPE, dimType);
        dimType.add(declWidth);
        dimType.add(declHeight);
        DecisionVariableDeclaration dimDecl = new DecisionVariableDeclaration("dimension", dimType, project);
        project.add(dimDecl);
        Constraint comparison = new Constraint(project);
        CompoundAccess slotAccess = new CompoundAccess(new Variable(dimDecl), declWidth.getName());
        OCLFeatureCall compCall = new OCLFeatureCall(slotAccess, OclKeyWords.GREATER, ZERO);
        comparison.setConsSyntax(compCall);
        project.add(comparison);
        
        // Create configuration out of valid project
        ProjectTestUtilities.validateProject(project);
        Configuration config = new Configuration(project);
        
        // Check importance
        MandatoryDeclarationClassifier finder = new MandatoryDeclarationClassifier(config, FilterType.ALL);
        project.accept(finder);
        VariableContainer importances = finder.getImportances();
        
        // Test correct behavior: slot height is not mandatory, compound and slot width are mandatory
        IDecisionVariable compoundVar = config.getDecision(dimDecl);
        IDecisionVariable slotWidth = null;
        IDecisionVariable slotHeight = null;
        for (int i = 0; i < compoundVar.getNestedElementsCount(); i++) {
            IDecisionVariable nestedVar = compoundVar.getNestedElement(i);
            if (declWidth.equals(nestedVar.getDeclaration())) {
                slotWidth = nestedVar;
            } else if (declHeight.equals(nestedVar.getDeclaration())) {
                slotHeight = nestedVar;
            }
        }
        assertVariable(compoundVar, true, importances);
        assertVariable(slotWidth, true, importances);
        assertVariable(slotHeight, false, importances);
    }
    
    /**
     * Test whether slots of a compound are resolved correctly.
     * Contrary to {@link #testFindConstrainedCompoundSlots()}, this method tests whether
     * the slots are composed correctly.
     * @throws CSTSemanticException Must not occur, otherwise {@link Constraint}s are broken.
     */
    @Test
    public void testFindConstrainedMultiCompoundSlots() throws CSTSemanticException {
        // Create project with compound with nested compound, one nested slot has a constraint to top slot
        Project project = new Project("testFindConstrainedMultiCompoundSlots");
        Compound dimType2D = new Compound("Dimension2D", project);
        project.add(dimType2D);
        DecisionVariableDeclaration declWidth = new DecisionVariableDeclaration("width", IntegerType.TYPE, dimType2D);
        DecisionVariableDeclaration declHeight = new DecisionVariableDeclaration("height", IntegerType.TYPE, dimType2D);
        dimType2D.add(declWidth);
        dimType2D.add(declHeight);
        Compound dimType3D = new Compound("Dimension3D", project);
        project.add(dimType3D);
        DecisionVariableDeclaration dim2DDecl = new DecisionVariableDeclaration("dimension2D", dimType2D, dimType3D);
        dimType3D.add(dim2DDecl);
        DecisionVariableDeclaration depthDecl = new DecisionVariableDeclaration("depth", IntegerType.TYPE, dimType3D);
        dimType3D.add(depthDecl);
        DecisionVariableDeclaration dim3DDecl = new DecisionVariableDeclaration("dimension3D", dimType3D, project);
        project.add(dim3DDecl);
        // Constraint for nested slot
        Constraint comparison = new Constraint(project);
        CompoundAccess slotAccess = new CompoundAccess(new Variable(dim3DDecl), dim2DDecl.getName());
        CompoundAccess slotAccess2 = new CompoundAccess(slotAccess, declWidth.getName());
        CompoundAccess slotAccess3 = new CompoundAccess(new Variable(dim3DDecl), depthDecl.getName());
        OCLFeatureCall compCall = new OCLFeatureCall(slotAccess2, OclKeyWords.GREATER, slotAccess3);
        comparison.setConsSyntax(compCall);
        project.add(comparison);
        
        // Create configuration out of valid project
        ProjectTestUtilities.validateProject(project);
        Configuration config = new Configuration(project);
        
        // Check importance
        MandatoryDeclarationClassifier finder = new MandatoryDeclarationClassifier(config, FilterType.ALL);
        project.accept(finder);
        VariableContainer importances = finder.getImportances();
        
        // Test correct behavior: slot height is not mandatory, all other are mandatory
        IDecisionVariable compoundVar = config.getDecision(dim3DDecl);
        IDecisionVariable nestedCompoundVar = compoundVar.getNestedElement(0);
        IDecisionVariable slotDepth = compoundVar.getNestedElement(1);
        IDecisionVariable slotWidth = null;
        IDecisionVariable slotHeight = null;
        for (int i = 0; i < nestedCompoundVar.getNestedElementsCount(); i++) {
            IDecisionVariable nestedVar = nestedCompoundVar.getNestedElement(i);
            if (declWidth.equals(nestedVar.getDeclaration())) {
                slotWidth = nestedVar;
            } else if (declHeight.equals(nestedVar.getDeclaration())) {
                slotHeight = nestedVar;
            }
        }
        assertVariable(compoundVar, true, importances);
        assertVariable(nestedCompoundVar, true, importances);
        assertVariable(slotWidth, true, importances);
        assertVariable(slotHeight, false, importances);
        assertVariable(slotDepth, true, importances);
    }
    
    /**
     * Tests that variables having a default variable are <b>not</b> classified as mandatory, even if they are
     * used inside a constraint.
     * @throws ValueDoesNotMatchTypeException Must not occur, otherwise default values of
     * {@link DecisionVariableDeclaration} are broken.
     * @throws CSTSemanticException Must not occur, otherwise {@link Constraint}s are broken.
     */
    @Test
    public void testVariablesWithDefaultValuesAreIgnored() throws ValueDoesNotMatchTypeException,
        CSTSemanticException {
        
        // Create Project, with 2 declarations, one is optional, because it already has a (default) value 
        Project project = new Project("testVariablesWithDefaultValuesAreIgnored");
        DecisionVariableDeclaration declA = new DecisionVariableDeclaration("intA", IntegerType.TYPE, project);
        declA.setValue(ZERO);
        DecisionVariableDeclaration declB = new DecisionVariableDeclaration("intB", IntegerType.TYPE, project);
        project.add(declA);
        project.add(declB);
        Constraint comparison = new Constraint(project);
        OCLFeatureCall compCall = new OCLFeatureCall(new Variable(declA), OclKeyWords.GREATER, new Variable(declB));
        comparison.setConsSyntax(compCall);
        project.add(comparison);
        
        // Create configuration out of valid project
        ProjectTestUtilities.validateProject(project);
        Configuration config = new Configuration(project);
        
        // Check importance
        MandatoryDeclarationClassifier finder = new MandatoryDeclarationClassifier(config, FilterType.ALL);
        project.accept(finder);
        VariableContainer importances = finder.getImportances();
        
        // Test correct behavior: declC is not mandatory
        assertVariable(config.getDecision(declA), false, importances);
        assertVariable(config.getDecision(declB), true, importances);
    }
    
    /**
     * Tests whether constraints defined in a compound trigger that instances of the compound are marked as mandatory.
     * @throws CSTSemanticException Must not occur, otherwise {@link Constraint}s are broken.
     */
    @Test
    public void testGeneralInnerCompoundConstraints() throws CSTSemanticException {
        Project project = new Project("testGeneralInnerCompoundConstraints");
        Compound dimType = new Compound("Dimension", project);
        project.add(dimType);
        DecisionVariableDeclaration declWidth = new DecisionVariableDeclaration("width", IntegerType.TYPE, dimType);
        DecisionVariableDeclaration declHeight = new DecisionVariableDeclaration("height", IntegerType.TYPE, dimType);
        dimType.add(declWidth);
        dimType.add(declHeight);
        Constraint innerConstraint = new Constraint(dimType);
        OCLFeatureCall compCall = new OCLFeatureCall(new Variable(declWidth), OclKeyWords.GREATER, ZERO);
        innerConstraint.setConsSyntax(compCall);
        dimType.addConstraint(innerConstraint);  
        DecisionVariableDeclaration dimDecl = new DecisionVariableDeclaration("dimension", dimType, project);
        project.add(dimDecl);
        
        // Create configuration out of valid project
        ProjectTestUtilities.validateProject(project);
        Configuration config = new Configuration(project);
        
        // Check importance
        MandatoryDeclarationClassifier finder = new MandatoryDeclarationClassifier(config, FilterType.ALL);
        project.accept(finder);
        VariableContainer importances = finder.getImportances();
        
        // Test correct behavior: slot height is not mandatory, compound and slot width are mandatory
        IDecisionVariable compoundVar = config.getDecision(dimDecl);
        IDecisionVariable slotWidth = null;
        IDecisionVariable slotHeight = null;
        for (int i = 0; i < compoundVar.getNestedElementsCount(); i++) {
            IDecisionVariable nestedVar = compoundVar.getNestedElement(i);
            if (declWidth.equals(nestedVar.getDeclaration())) {
                slotWidth = nestedVar;
            } else if (declHeight.equals(nestedVar.getDeclaration())) {
                slotHeight = nestedVar;
            }
        }
//        assertVariable(compoundVar, true, importances);
        assertVariable(slotWidth, true, importances);
        assertVariable(slotHeight, false, importances);
    }
    
    /**
     * Same as {@link #testGeneralInnerCompoundConstraints()}, but the compound is also nested inside another compound.
     * Both compounds should be marked as mandatory.
     * @throws CSTSemanticException Must not occur, otherwise {@link Constraint}s are broken.
     */
    @Test
    public void testGeneralInnerCompoundConstraints2() throws CSTSemanticException {
        Project project = new Project("testGeneralInnerCompoundConstraints2");
        Compound dimType2D = new Compound("Dimension2D", project);
        project.add(dimType2D);
        DecisionVariableDeclaration declWidth = new DecisionVariableDeclaration("width", IntegerType.TYPE, dimType2D);
        DecisionVariableDeclaration declHeight = new DecisionVariableDeclaration("height", IntegerType.TYPE, dimType2D);
        dimType2D.add(declWidth);
        dimType2D.add(declHeight);
        Constraint innerConstraint = new Constraint(dimType2D);
        OCLFeatureCall compCall = new OCLFeatureCall(new Variable(declWidth), OclKeyWords.GREATER, ZERO);
        innerConstraint.setConsSyntax(compCall);
        dimType2D.addConstraint(innerConstraint);  
        Compound dimType3D = new Compound("Dimension3D", project);
        project.add(dimType3D);
        DecisionVariableDeclaration dim2DDecl = new DecisionVariableDeclaration("dimension2D", dimType2D, dimType3D);
        dimType3D.add(dim2DDecl);
        DecisionVariableDeclaration dim3DDecl = new DecisionVariableDeclaration("dimension3D", dimType3D, project);
        project.add(dim3DDecl);
        
        // Create configuration out of valid project
        ProjectTestUtilities.validateProject(project);
        Configuration config = new Configuration(project);
        
        // Check importance
        MandatoryDeclarationClassifier finder = new MandatoryDeclarationClassifier(config, FilterType.ALL);
        project.accept(finder);
        VariableContainer importances = finder.getImportances();
        
        // Test correct behavior: slot height is not mandatory, compounds and slot width are mandatory
        IDecisionVariable compoundVar = config.getDecision(dim3DDecl);
        IDecisionVariable nestedCompoundVar = compoundVar.getNestedElement(0);
        IDecisionVariable slotWidth = null;
        IDecisionVariable slotHeight = null;
        for (int i = 0; i < nestedCompoundVar.getNestedElementsCount(); i++) {
            IDecisionVariable nestedVar = nestedCompoundVar.getNestedElement(i);
            if (declWidth.equals(nestedVar.getDeclaration())) {
                slotWidth = nestedVar;
            } else if (declHeight.equals(nestedVar.getDeclaration())) {
                slotHeight = nestedVar;
            }
        }
//        assertVariable(compoundVar, true, importances);
//        assertVariable(nestedCompoundVar, true, importances);
        assertVariable(slotWidth, true, importances);
        assertVariable(slotHeight, false, importances);
    }
    
    /**
     * Tests whether constraints of constraint variables will be considered.
     * @throws ValueDoesNotMatchTypeException Must not occur, otherwise {@link ConstraintType}s are broken.
     * @throws CSTSemanticException Must not occur, otherwise {@link ConstraintType}s are broken.
     */
    @Test
    public void testConstraintVariablesAreConsidered() throws ValueDoesNotMatchTypeException, CSTSemanticException {
        // Create Project with 3 declarations and a constraint variable using 2 of them
        Project project = new Project("testConstraintVariablesAreConsidered");
        DecisionVariableDeclaration declA = new DecisionVariableDeclaration("intA", IntegerType.TYPE, project);
        DecisionVariableDeclaration declB = new DecisionVariableDeclaration("intB", IntegerType.TYPE, project);
        DecisionVariableDeclaration declC = new DecisionVariableDeclaration("intC", IntegerType.TYPE, project);
        project.add(declA);
        project.add(declB);
        project.add(declC);
        DecisionVariableDeclaration declConstraint = new DecisionVariableDeclaration("constraint", ConstraintType.TYPE,
            project);
        OCLFeatureCall compCall = new OCLFeatureCall(new Variable(declA), OclKeyWords.GREATER, new Variable(declB));
        declConstraint.setValue(compCall);
        project.add(declConstraint);
        
        // Create configuration out of valid project
        ProjectTestUtilities.validateProject(project);
        Configuration config = new Configuration(project);
        
        // Check importance
        MandatoryDeclarationClassifier finder = new MandatoryDeclarationClassifier(config, FilterType.ALL);
        project.accept(finder);
        VariableContainer importances = finder.getImportances();
        
        // Test correct behavior
        assertVariable(config.getDecision(declA), true, importances);
        assertVariable(config.getDecision(declB), true, importances);
        assertVariable(config.getDecision(declC), false, importances);
        assertVariable(config.getDecision(declConstraint), false, importances);
    }
    
    /**
     * Tests whether instances of typedefs ({@link DerivedDatatype}) are considered.
     * @throws CSTSemanticException Must not occur, otherwise {@link Constraint}s are broken.
     */
    @Test
    public void testTypeDefsAreConsidered() throws CSTSemanticException {
        Project project = new Project("testTypeDefsAreConsidered");
        DerivedDatatype posIntType = new DerivedDatatype("PositiveInteger", IntegerType.TYPE, project);
        Constraint derivedTypeConstraint = new Constraint(posIntType);
        OCLFeatureCall comparison = new OCLFeatureCall(new Variable(posIntType.getTypeDeclaration()),
            OclKeyWords.GREATER, ZERO);
        derivedTypeConstraint.setConsSyntax(comparison);
        posIntType.setConstraints(new Constraint[] {derivedTypeConstraint});
        project.add(posIntType);
        DecisionVariableDeclaration posIntDecl = new DecisionVariableDeclaration("posInt", posIntType, project);
        project.add(posIntDecl);
        
        // Create configuration out of valid project
        ProjectTestUtilities.validateProject(project);
        Configuration config = new Configuration(project);
        
        // Check importance
        MandatoryDeclarationClassifier finder = new MandatoryDeclarationClassifier(config, FilterType.ALL);
        project.accept(finder);
        VariableContainer importances = finder.getImportances();
        
        // Test correct behavior
        assertVariable(config.getDecision(posIntDecl), true, importances);
    }
    
    /**
     * Combination of {@link #testAliasesAreNotConsidered()} and {@link #testTypeDefsAreConsidered()} as this is tricky.
     * @throws CSTSemanticException Must not occur, otherwise {@link Constraint}s are broken.
     */
    @Test
    public void testTypeDefsAreConsideredAliasesNot() throws CSTSemanticException {
        Project project = new Project("testTypeDefsAreConsideredAliasesNot");
        DerivedDatatype posIntType = new DerivedDatatype("PositiveInteger", IntegerType.TYPE, project);
        Constraint derivedTypeConstraint = new Constraint(posIntType);
        OCLFeatureCall comparison = new OCLFeatureCall(new Variable(posIntType.getTypeDeclaration()),
                OclKeyWords.GREATER, ZERO);
        derivedTypeConstraint.setConsSyntax(comparison);
        posIntType.setConstraints(new Constraint[] {derivedTypeConstraint});
        project.add(posIntType);
        DecisionVariableDeclaration posIntDecl = new DecisionVariableDeclaration("posInt", posIntType, project);
        project.add(posIntDecl);
        DerivedDatatype aliasType = new DerivedDatatype("Alias", IntegerType.TYPE, project);
        project.add(aliasType);
        DecisionVariableDeclaration aliasDecl = new DecisionVariableDeclaration("aliasInt", aliasType, project);
        project.add(aliasDecl);
        
        // Create configuration out of valid project
        ProjectTestUtilities.validateProject(project);
        Configuration config = new Configuration(project);
        
        // Check importance
        MandatoryDeclarationClassifier finder = new MandatoryDeclarationClassifier(config, FilterType.ALL);
        project.accept(finder);
        VariableContainer importances = finder.getImportances();
        
        // Test correct behavior
        assertVariable(config.getDecision(posIntDecl), true, importances);
        assertVariable(config.getDecision(aliasDecl), false, importances);
    }
    
    /**
     * Tests whether instances of typedefs ({@link DerivedDatatype}) are <b>not</b> considered if they do not contain
     * a constraint, i.e., are only an alias.
     * @throws CSTSemanticException Must not occur, otherwise {@link Constraint}s are broken.
     */
    @Test
    public void testAliasesAreNotConsidered() throws CSTSemanticException {
        Project project = new Project("testAliasesAreNotConsidered");
        DerivedDatatype aliasType = new DerivedDatatype("Alias", IntegerType.TYPE, project);
        project.add(aliasType);
        DecisionVariableDeclaration aliasDecl = new DecisionVariableDeclaration("aliasInt", aliasType, project);
        project.add(aliasDecl);
        
        // Create configuration out of valid project
        ProjectTestUtilities.validateProject(project);
        Configuration config = new Configuration(project);
        
        // Check importance
        MandatoryDeclarationClassifier finder = new MandatoryDeclarationClassifier(config, FilterType.ALL);
        project.accept(finder);
        VariableContainer importances = finder.getImportances();
        
        // Test correct behavior: alias is not mandatory
        assertVariable(config.getDecision(aliasDecl), false, importances);
    }

    /**
     * Asserts whether a {@link IDecisionVariable} was resolved correctly.
     * @param variable The variable to check.
     * @param mandatory The assumed result: <tt>true</tt> the variable should be mandatory.
     * @param importances The container of all result from the last retrieval.
     */
    private void assertVariable(IDecisionVariable variable, boolean mandatory, VariableContainer importances) {
        Assert.assertNotNull("Error tested variable instance is null", variable);
        
        if (mandatory) {
            Assert.assertTrue("Variable \"" + variable.getDeclaration().getName() + "\" not declared as mandatory",
                importances.isMandatory(variable));
        } else {
            Assert.assertFalse("Variable \"" + variable.getDeclaration().getName() + "\" declared as mandatory, "
                + "but should not", importances.isMandatory(variable));
        }
    }

}
