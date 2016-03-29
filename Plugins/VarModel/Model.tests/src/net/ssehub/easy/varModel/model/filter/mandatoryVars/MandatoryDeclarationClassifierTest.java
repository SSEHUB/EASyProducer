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
package net.ssehub.easy.varModel.model.filter.mandatoryVars;

import org.junit.Assert;
import org.junit.Test;

import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.cst.CompoundAccess;
import net.ssehub.easy.varModel.cst.ConstantValue;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;
import net.ssehub.easy.varModel.cst.Variable;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.ConstraintType;
import net.ssehub.easy.varModel.model.datatypes.DerivedDatatype;
import net.ssehub.easy.varModel.model.datatypes.IntegerType;
import net.ssehub.easy.varModel.model.datatypes.OclKeyWords;
import net.ssehub.easy.varModel.model.filter.FilterType;
import net.ssehub.easy.varModel.model.filter.mandatoryVars.MandatoryDeclarationClassifier;
import net.ssehub.easy.varModel.model.filter.mandatoryVars.VariableContainer;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;
import net.ssehub.easy.varModel.persistency.StringProvider;
import net.ssehub.easy.varModel.varModel.testSupport.ProjectTestUtilities;

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
        Constraint isDefined = new Constraint(project);
        OCLFeatureCall compCall = new OCLFeatureCall(isDefined(declA), OclKeyWords.AND, isDefined(declB));
        isDefined.setConsSyntax(compCall);
        project.add(isDefined);
        
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
        comparison.setConsSyntax(isDefined(slotAccess));
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
        Constraint isDefined = new Constraint(project);
        CompoundAccess slotAccess = new CompoundAccess(new Variable(dim3DDecl), dim2DDecl.getName());
        CompoundAccess slotAccess2 = new CompoundAccess(slotAccess, declWidth.getName());
        CompoundAccess slotAccess3 = new CompoundAccess(new Variable(dim3DDecl), depthDecl.getName());
        OCLFeatureCall compCall = new OCLFeatureCall(isDefined(slotAccess2), OclKeyWords.AND,
            isDefined(slotAccess3));
        isDefined.setConsSyntax(compCall);
        project.add(isDefined);
        
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
     * Tests whether constraint variables inside a compound are considered correctly.
     * @throws ValueDoesNotMatchTypeException Must not occur, otherwise
     * {@link DecisionVariableDeclaration#setValue(ConstraintSyntaxTree)} is broken for constraint variables
     * (type {@link ConstraintType}).
     * @throws CSTSemanticException Must not occur, otherwise {@link Constraint}s are broken.
     */
    @Test
    public void testConstraintsInsideCompound() throws ValueDoesNotMatchTypeException, CSTSemanticException {
        // Create compound with a nested constraint variable inside
        Project project = new Project("testConstraintsInsideCompound");
        Compound dimType = new Compound("Dimension", project);
        project.add(dimType);
        DecisionVariableDeclaration declWidth = new DecisionVariableDeclaration("width", IntegerType.TYPE, dimType);
        DecisionVariableDeclaration declHeight = new DecisionVariableDeclaration("height", IntegerType.TYPE, dimType);
        dimType.add(declWidth);
        dimType.add(declHeight);
        // create nested constraint variable inside compound
        DecisionVariableDeclaration constDecl = new DecisionVariableDeclaration("check", ConstraintType.TYPE, dimType);
        constDecl.setValue(isDefined(declWidth));
        dimType.add(constDecl);
        DecisionVariableDeclaration dimDecl = new DecisionVariableDeclaration("dimension", dimType, project);
        project.add(dimDecl);
        
        // Validate project for testing and create config
        ProjectTestUtilities.validateProject(project);
        Configuration config = new Configuration(project);
        // Check importance
        MandatoryDeclarationClassifier finder = new MandatoryDeclarationClassifier(config, FilterType.ALL);
        project.accept(finder);
        VariableContainer importances = finder.getImportances();
        
        // Test correct behavior: slot height is not mandatory, all other are mandatory
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
       // assertVariable(compoundVar, true, importances);
        assertVariable(slotWidth, true, importances);
        assertVariable(slotHeight, false, importances);
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
        Constraint isDefined = new Constraint(project);
        OCLFeatureCall compCall = new OCLFeatureCall(isDefined(declA), OclKeyWords.AND, isDefined(declB));
        isDefined.setConsSyntax(compCall);
        project.add(isDefined);
        
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
        innerConstraint.setConsSyntax(isDefined(declWidth));
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
        innerConstraint.setConsSyntax(isDefined(declWidth));
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
        OCLFeatureCall compCall = new OCLFeatureCall(isDefined(declA), OclKeyWords.AND, isDefined(declB));
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
        DerivedDatatype posIntType = new DerivedDatatype("NonNullInteger", IntegerType.TYPE, project);
        Constraint derivedTypeConstraint = new Constraint(posIntType);
        derivedTypeConstraint.setConsSyntax(isDefined(posIntType.getTypeDeclaration()));
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
     * Tests whether instances of typedefs of typedefs ({@link DerivedDatatype}) are considered.
     * @throws CSTSemanticException Must not occur, otherwise {@link Constraint}s are broken.
     */
    @Test
    public void testTypeDefsOfTypeDefsAreConsidered() throws CSTSemanticException {
        Project project = new Project("testTypeDefsOfTypeDefsAreConsidered");
        DerivedDatatype posIntType = new DerivedDatatype("NonNullInteger", IntegerType.TYPE, project);
        Constraint derivedTypeConstraint = new Constraint(posIntType);
        derivedTypeConstraint.setConsSyntax(isDefined(posIntType.getTypeDeclaration()));
        posIntType.setConstraints(new Constraint[] {derivedTypeConstraint});
        project.add(posIntType);
        DerivedDatatype posIntType2 = new DerivedDatatype("NonNullInteger2", posIntType, project);
        project.add(posIntType2);
        DecisionVariableDeclaration posIntDecl = new DecisionVariableDeclaration("posInt", posIntType2, project);
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
     * Tests whether instances of typedefs ({@link DerivedDatatype}) used inside a {@link Compound} are considered.
     * @throws CSTSemanticException Must not occur, otherwise {@link Constraint}s are broken.
     */
    @Test
    public void testTypeDefsInsideCompoundAreConsidered() throws CSTSemanticException {
        Project project = new Project("testTypeDefsInsideCompoundAreConsidered");
        DerivedDatatype posIntType = new DerivedDatatype("NonNullInteger", IntegerType.TYPE, project);
        Constraint derivedTypeConstraint = new Constraint(posIntType);
        derivedTypeConstraint.setConsSyntax(isDefined(posIntType.getTypeDeclaration()));
        posIntType.setConstraints(new Constraint[] {derivedTypeConstraint});
        project.add(posIntType);
        Compound cType = new Compound("CP", project);
        DecisionVariableDeclaration posIntDecl = new DecisionVariableDeclaration("posInt", posIntType, cType);
        cType.add(posIntDecl);
        project.add(cType);        
        DecisionVariableDeclaration cmpDecl = new DecisionVariableDeclaration("cmp", cType, project);
        project.add(cmpDecl);
        
        // Create configuration out of valid project
        ProjectTestUtilities.validateProject(project);
        Configuration config = new Configuration(project);
        
        // Check importance
        MandatoryDeclarationClassifier finder = new MandatoryDeclarationClassifier(config, FilterType.ALL);
        project.accept(finder);
        VariableContainer importances = finder.getImportances();
        
        // Test correct behavior
        IDecisionVariable cmpVar = config.getDecision(cmpDecl);
        //assertVariable(cmpVar, true, importances);
        assertVariable(cmpVar.getNestedElement(0), true, importances);
    }
    
    /**
     * Combination of {@link #testAliasesAreNotConsidered()} and {@link #testTypeDefsAreConsidered()} as this is tricky.
     * @throws CSTSemanticException Must not occur, otherwise {@link Constraint}s are broken.
     */
    @Test
    public void testTypeDefsAreConsideredAliasesNot() throws CSTSemanticException {
        Project project = new Project("testTypeDefsAreConsideredAliasesNot");
        DerivedDatatype posIntType = new DerivedDatatype("NonNullInteger", IntegerType.TYPE, project);
        Constraint derivedTypeConstraint = new Constraint(posIntType);
        derivedTypeConstraint.setConsSyntax(isDefined(posIntType.getTypeDeclaration()));
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

    /**
     * Helper method for creating a isDefined constraint for the given variable.
     * @param variableExpression Should point to a variable, e.g. a {@link Variable} or {@link CompoundAccess}.
     * @return The generated isDefined constraint for the given variable. An assertion failure is created,
     * if the sub constraint is not valid.
     */
    private static ConstraintSyntaxTree isDefined(ConstraintSyntaxTree variableExpression) {
        ConstraintSyntaxTree isDefinedConstraint = new OCLFeatureCall(variableExpression, OclKeyWords.IS_DEFINED);
        
        try {
            isDefinedConstraint.inferDatatype();
        } catch (CSTSemanticException e) {
            Assert.fail("Could not create \"" + StringProvider.toIvmlString(isDefinedConstraint) + "\", reason: "
                + e.getMessage());
        }

        return isDefinedConstraint;
    }
    
    /**
     * Helper method for creating a isDefined constraint for the given declaration.
     * @param declaration The declaration for which the constraint shall be created.
     * @return The generated isDefined constraint for the given declaration. An assertion failure is created,
     * if the sub constraint is not valid.
     */
    private static ConstraintSyntaxTree isDefined(AbstractVariable declaration) {
        return isDefined(new Variable(declaration));
    }
}
