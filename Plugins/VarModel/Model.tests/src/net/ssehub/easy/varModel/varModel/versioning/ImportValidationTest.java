package net.ssehub.easy.varModel.varModel.versioning;

import java.io.File;
import java.net.URI;
import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import net.ssehub.easy.basics.messages.IMessage;
import net.ssehub.easy.basics.modelManagement.RestrictionEvaluationException;
import net.ssehub.easy.basics.modelManagement.Version;
import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.cst.CompoundAccess;
import net.ssehub.easy.varModel.cst.ConstantValue;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;
import net.ssehub.easy.varModel.cst.Variable;
import net.ssehub.easy.varModel.management.VarModel;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.ExpressionVersionRestriction;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.ProjectImport;
import net.ssehub.easy.varModel.model.datatypes.OclKeyWords;
import net.ssehub.easy.varModel.model.datatypes.VersionType;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;

/**
 * Basic import restriction tests. Please take case for different suffix names otherwise the model needs a clear 
 * functionality.
 * 
 * @author Patrick Jähne
 * @author kroeher
 * @author Holger Eichelberger
 */
public class ImportValidationTest {

    /**
     * Creates a dummy URL for a model.
     * 
     * @param project the project to create the URI for
     * @return the URI
     */
    private static URI createDummyURI(Project project) {
        return new File("/path/", project.getName() + ".ivml").toURI();
    }

    /**
     * Two-step test.
     * First step: define two project of which one includes a false import of the other
     * project with respect to the version restriction.
     * Second step: the false import (the version restriction) will be corrected by
     * updating the version of the imported project in the version restriction.
     * 
     * @throws RestrictionEvaluationException shall not occur
     * @throws ValueDoesNotMatchTypeException shall not occur
     * @throws CSTSemanticException shall not occur
     */
    @Test
    public final void versionCorrectionTest() throws RestrictionEvaluationException, 
        ValueDoesNotMatchTypeException, CSTSemanticException {
        VarModel model = VarModel.INSTANCE;
        // Construct new product line project with version v0.3.
        Project plProject = new Project("PL_ImportTest");
        plProject.setVersion(new Version(0, 3));
        /*
         *  Construct new (derived) product project, which imports the product line project.
         *  However, the import will be restricted to a false version number:
         *  plProject v0.3, import: v0
         */
        Project invalidProductProject = new Project("New_Product");
        invalidProductProject.setVersion(new Version(0));
        createImport(invalidProductProject, "PL_ImportTest", false, OclKeyWords.EQUALS, new Version(0));
        // Add both projects to the variability model
        model.updateModel(plProject, createDummyURI(plProject));
        model.updateModel(invalidProductProject, createDummyURI(invalidProductProject));
        /*
         * Resolve the false import.
         * Expected result: the number of messages is not 0 as it must contain
         * at least one error-message because of the false import.
         */
        List<IMessage> msgList = VarModel.INSTANCE.resolveImports(invalidProductProject,
            createDummyURI(invalidProductProject), null);
        Assert.assertNotSame(0, msgList.size());
        /*
         * Correct the product (the false import) in terms of creating a new project
         * with the same name and version number as the invalid one previously, correct
         * the version restriction and add the project again to the model.
         */
        Project correctedProductProject = new Project("New_Product");
        correctedProductProject.setVersion(new Version(0));
        createImport(correctedProductProject, "PL_ImportTest", false, OclKeyWords.EQUALS, new Version(0, 3));
        model.updateModel(correctedProductProject, createDummyURI(correctedProductProject));
        /*
         * Resolve the corrected import.
         * Expected result: the number of messages is 0 as no error-message should occur.
         */
        msgList = VarModel.INSTANCE.resolveImports(correctedProductProject,
            createDummyURI(correctedProductProject), null);    
        Assert.assertEquals(0, msgList.size());
    }
    
    /** 
     * One project with no restrictions. 
     */
    @Test
    public final void mostTrivialTest() {
        final VarModel model = VarModel.INSTANCE;
        final String suffix = "_mostTrivialTest";

        Project root = new Project("root" + suffix);
        root.setVersion(new Version(1));
        model.updateModel(root, createDummyURI(root));

        List<IMessage> msgList = VarModel.INSTANCE.resolveImports(root, createDummyURI(root), null);
        Assert.assertEquals(0, msgList.size());
    }

    /** 
     * Two projects conflict with a non-existing project. 
     * 
     * @throws RestrictionEvaluationException shall not occur
     * @throws ValueDoesNotMatchTypeException shall not occur
     * @throws CSTSemanticException shall not occur
     */
    @Test
    public final void irrelevantConflict() throws RestrictionEvaluationException, 
        ValueDoesNotMatchTypeException, CSTSemanticException {
        final VarModel model = VarModel.INSTANCE;
        final String suffix = "_irrelevantConflict";
        
        Project root = new Project("root" + suffix);
        root.setVersion(new Version(1));
        createImport(root, "c" + suffix, false, OclKeyWords.EQUALS, new Version(1));
        model.updateModel(root, createDummyURI(root));

        Project b = new Project("b" + suffix);
        b.setVersion(new Version(1));
        createImport(b, "c" + suffix, false, OclKeyWords.EQUALS, new Version(1));
        model.updateModel(b, createDummyURI(b));

        List<IMessage> msgList = VarModel.INSTANCE.resolveImports(root, createDummyURI(root), null);
        Assert.assertNotSame(0, msgList.size());
    }

    /** 
     * Simple Import with no restrictions. 
     */
    @Test
    public final void simpleImport() {
        final VarModel model = VarModel.INSTANCE;
        String suffix = "_simpleImport";
        
        Project root = new Project("root" + suffix);
        root.setVersion(new Version(1));
        ProjectImport aImport = new ProjectImport("a" + suffix, null);
        root.addImport(aImport);
        model.updateModel(root, createDummyURI(root));

        Project a = new Project("a" + suffix);
        a.setVersion(new Version(1));
        model.updateModel(a, createDummyURI(a));

        List<IMessage> msgList = VarModel.INSTANCE.resolveImports(root, createDummyURI(root), null);
        Assert.assertEquals(0, msgList.size());
    }

    /**
     * Simple direct conflict. 
     * 
     * @throws RestrictionEvaluationException shall not occur
     * @throws ValueDoesNotMatchTypeException shall not occur
     * @throws CSTSemanticException shall not occur
     */
    @Test
    public final void simpleConflict() throws RestrictionEvaluationException, 
        ValueDoesNotMatchTypeException, CSTSemanticException {
        // root (v1)
        //  import a
        //  import a == v1
        // a (v1)
        
        final VarModel model = VarModel.INSTANCE;
        final String suffix = "_simpleConflict";
        
        Project root = new Project("root" + suffix);
        root.setVersion(new Version(1));
        createImport(root, "a" + suffix, true, OclKeyWords.EQUALS, new Version(2));
        model.updateModel(root, createDummyURI(root));

        Project a = new Project("a" + suffix);
        a.setVersion(new Version(1));
        model.updateModel(a, createDummyURI(a));

        List<IMessage> msgList = VarModel.INSTANCE.resolveImports(root, createDummyURI(root), null);
        Assert.assertNotEquals(1, msgList.size());
    }
    

    /** 
     * Impossible import restriction causes error, because the chosen project is restricted. 
     * 
     * @throws RestrictionEvaluationException shall not occur
     * @throws ValueDoesNotMatchTypeException shall not occur
     * @throws CSTSemanticException shall not occur
     */
    @Test
    public final void impossibleImportRestriction() throws RestrictionEvaluationException, 
        ValueDoesNotMatchTypeException, CSTSemanticException {
        final VarModel model = VarModel.INSTANCE;
        final String suffix = "impossibleImportRestriction";

        Project root = new Project("root_" + suffix);
        root.setVersion(new Version(1));
        createImport(root, "a_" + suffix, false, OclKeyWords.GREATER_EQUALS, new Version(3, 1));
        model.updateModel(root, createDummyURI(root));

        Project a = new Project("a_" + suffix);
        a.setVersion(new Version(1));
        model.updateModel(a, createDummyURI(a));

        List<IMessage> msgList = VarModel.INSTANCE.resolveImports(root, createDummyURI(root), null);
        Assert.assertNotEquals(0, msgList.size());
    }

    /** 
     * a imports c [possible: c1, c2], but b removes c2 => valid solution. 
     * 
     * @throws RestrictionEvaluationException shall not occur
     * @throws ValueDoesNotMatchTypeException shall not occur
     * @throws CSTSemanticException shall not occur
     */
    @Test
    public final void legitImportAndConflict() throws RestrictionEvaluationException, ValueDoesNotMatchTypeException, 
        CSTSemanticException {
        // root (v1):
        //   import a
        //   import b
        // a (v1):
        //   import c
        // b (v1):
        //   conflict c>=v1
        // c (v1):
        // c (v2):
        final VarModel model = VarModel.INSTANCE;
        final String suffix = "_legitIMportAndConflict";
        
        Project root = new Project("root" + suffix);
        root.setVersion(new Version(1));
        root.addImport(new ProjectImport("a" + suffix, null));
        root.addImport(new ProjectImport("b" + suffix, null));
        model.updateModel(root, createDummyURI(root));

        Project a = new Project("a" + suffix);
        a.setVersion(new Version(1));
        a.addImport(new ProjectImport("c" + suffix, null));
        model.updateModel(a, createDummyURI(a));

        Project b = new Project("b" + suffix);
        b.setVersion(new Version(1));
        createImport(b, "c" + suffix, true, OclKeyWords.GREATER_EQUALS, new Version(1));
        model.updateModel(b, createDummyURI(b));

        Project c1 = new Project("c" + suffix);
        c1.setVersion(new Version(1));
        model.updateModel(c1, createDummyURI(c1));
        Project c2 = new Project("c" + suffix);
        c2.setVersion(new Version(2));
        model.updateModel(c2, createDummyURI(c2));

        List<IMessage> msgList = VarModel.INSTANCE.resolveImports(root, createDummyURI(root), null);
        Assert.assertTrue(msgList.isEmpty());
    }

    /** 
     * a imports c, but c conflicts with root -> invalid solution. 
     * 
     * @throws RestrictionEvaluationException shall not occur
     * @throws ValueDoesNotMatchTypeException shall not occur
     * @throws CSTSemanticException shall not occur
     **/
    @Test
    public final void retrospectiveConflictFail() throws RestrictionEvaluationException, 
        ValueDoesNotMatchTypeException, CSTSemanticException {
        // root (v1):
        //   import a
        //   import b
        // a (v1):
        //   import c
        // b (v1):
        // c (v1):
        //   conflict root != v1.2.3.4
        final VarModel model = VarModel.INSTANCE;
        final String suffix = "_retrospectiveConflictFail";
        final File dummyUriBase = new File("/path/");

        Project root = new Project("root" + suffix);
        root.setVersion(new Version(1));
        ProjectImport aImport = new ProjectImport("a" + suffix, null);
        root.addImport(aImport);
        ProjectImport bImport = new ProjectImport("b" + suffix, null);
        root.addImport(bImport);
        model.updateModel(root, new File(dummyUriBase, root.getName() + ".ivml").toURI());

        Project a = new Project("a" + suffix);
        a.setVersion(new Version(1));
        a.addImport(new ProjectImport("c" + suffix, null));
        model.updateModel(a, new File(dummyUriBase, a.getName() + ".ivml").toURI());

        Project b = new Project("b" + suffix);
        b.setVersion(new Version(1));
        model.updateModel(b, new File(dummyUriBase, b.getName() + ".ivml").toURI());

        Project c = new Project("c" + suffix);
        c.setVersion(new Version(1));
        createImport(c, "root" + suffix, true, OclKeyWords.UNEQUALS, new Version(1, 2, 3, 4));
        model.updateModel(c, new File(dummyUriBase, c.getName() + ".ivml").toURI());

        List<IMessage> msgList = VarModel.INSTANCE.resolveImports(root, 
            new File(dummyUriBase, root.getName() + ".ivml").toURI(), null);
        Assert.assertNotEquals(0, msgList.size());
    }
    
    /** 
     *  root imports a and b; a imports c; b conflicts with c1; c1; c2 -> c2 (due to highest version rule).
     * 
     * @throws RestrictionEvaluationException shall not occur
     * @throws ValueDoesNotMatchTypeException shall not occur
     * @throws CSTSemanticException shall not occur
     **/
    @Test
    public final void retrospectiveConflict() throws RestrictionEvaluationException, ValueDoesNotMatchTypeException, 
        CSTSemanticException {
        // root (v1):
        //   import a
        //   import b
        // a (v1):
        //   import c
        // b (v1):
        //   conflict c<v2
        // c (v1):
        // c (v2):
        final VarModel model = VarModel.INSTANCE;
        final String suffix = "_retrospectiveConflict";
        final File dummyUriBase = new File("/path/");
        
        Project root = new Project("root" + suffix);
        root.setVersion(new Version(1));
        ProjectImport aImport = new ProjectImport("a" + suffix, null);
        root.addImport(aImport);
        ProjectImport bImport = new ProjectImport("b" + suffix, null);
        root.addImport(bImport);
        model.updateModel(root, new File(dummyUriBase, root.getName() + ".ivml").toURI());

        Project a = new Project("a" + suffix);
        a.setVersion(new Version(1));
        a.addImport(new ProjectImport("c" + suffix, null));
        model.updateModel(a, new File(dummyUriBase, a.getName() + ".ivml").toURI());
        
        Project b = new Project("b" + suffix);
        b.setVersion(new Version(1));
        createImport(b, "c" + suffix, true, OclKeyWords.LESS, new Version(2));
        model.updateModel(b, new File(dummyUriBase, b.getName() + ".ivml").toURI());
        
        Project c1 = new Project("c" + suffix);
        c1.setVersion(new Version(1));
        model.updateModel(c1, new File(dummyUriBase, c1.getName() + ".ivml").toURI());
        
        Project c2 = new Project("c" + suffix);
        c2.setVersion(new Version(2));
        model.updateModel(c2, new File(dummyUriBase, c1.getName() + ".ivml").toURI());
        
        List<IMessage> msgList = VarModel.INSTANCE.resolveImports(root, 
            new File(dummyUriBase, root.getName() + ".ivml").toURI(), null);
        Assert.assertEquals(0, msgList.size());
        Assert.assertEquals(c2, a.getImport(0).getResolved());
    }

    /** 
     *  root imports a and b; a imports c; b conflicts with c2; c1; c2 -> c1 (due to backtracking).
     * 
     * @throws RestrictionEvaluationException shall not occur
     * @throws ValueDoesNotMatchTypeException shall not occur
     * @throws CSTSemanticException shall not occur
     **/
    @Test
    public final void retrospectiveConflict2() throws RestrictionEvaluationException, ValueDoesNotMatchTypeException, 
        CSTSemanticException {
        // root (v1):
        //   import a
        //   import b
        // a (v1):
        //   import c
        // b (v1):
        //   conflict c>v1
        // c (v1):
        // c (v2):
        final VarModel model = VarModel.INSTANCE;
        final File dummyUriBase = new File("/path/");
        final String suffix = "_retrospectiveConflict2";

        Project root = new Project("root" + suffix);
        root.setVersion(new Version(1));
        ProjectImport aImport = new ProjectImport("a" + suffix, null);
        root.addImport(aImport);
        ProjectImport bImport = new ProjectImport("b" + suffix, null);
        root.addImport(bImport);
        model.updateModel(root, new File(dummyUriBase, root.getName() + ".ivml").toURI());

        Project a = new Project("a" + suffix);
        a.setVersion(new Version(1));
        a.addImport(new ProjectImport("c" + suffix, null));
        model.updateModel(a, new File(dummyUriBase, a.getName() + ".ivml").toURI());
        
        Project b = new Project("b" + suffix);
        b.setVersion(new Version(1));
        createImport(b, "c" + suffix, true, OclKeyWords.GREATER, new Version(1));
        model.updateModel(b, new File(dummyUriBase, b.getName() + ".ivml").toURI());
        
        Project c1 = new Project("c" + suffix);
        c1.setVersion(new Version(1));
        model.updateModel(c1, new File(dummyUriBase, c1.getName() + ".ivml").toURI());
        
        Project c2 = new Project("c" + suffix);
        c2.setVersion(new Version(2));
        model.updateModel(c2, new File(dummyUriBase, c1.getName() + ".ivml").toURI());
        
        List<IMessage> msgList = VarModel.INSTANCE.resolveImports(root, 
            new File(dummyUriBase, root.getName() + ".ivml").toURI(), null);
        Assert.assertEquals(0, msgList.size());
        Assert.assertEquals(c1, a.getImport(0).getResolved());
    }
    
    /**
     * a imports c1 and b imports c2 -> valid solution, if (local)blackbox-flag is set.
     * 
     * @throws RestrictionEvaluationException shall not occur
     * @throws ValueDoesNotMatchTypeException shall not occur
     * @throws CSTSemanticException shall not occur
     **/
    @Test
    public final void localImportRestriction() throws RestrictionEvaluationException, ValueDoesNotMatchTypeException, 
        CSTSemanticException {
        final String suffix = "_localImportRestriction";
        final VarModel model = VarModel.INSTANCE;
        
        Project root = new Project("root" + suffix);
        root.setVersion(new Version(1));
        ProjectImport aImport = new ProjectImport("a" + suffix, null);
        root.addImport(aImport);
        ProjectImport bImport = new ProjectImport("b" + suffix, null);
        root.addImport(bImport);
        model.updateModel(root, createDummyURI(root));
        Project a = new Project("a" + suffix); // imports c1
        a.setVersion(new Version(1));
        createImport(a, "c" + suffix, false, OclKeyWords.LESS, new Version(2));
        model.updateModel(a, createDummyURI(a));
        Project b = new Project("b" + suffix); // imports c2
        b.setVersion(new Version(1));
        createImport(b, "c" + suffix, false, OclKeyWords.GREATER_EQUALS, new Version(2));
        model.updateModel(b, createDummyURI(b));
        Project c1 = new Project("c" + suffix);
        c1.setVersion(new Version(1));
        model.updateModel(c1, createDummyURI(c1));
        Project c2 = new Project("c" + suffix);
        c2.setVersion(new Version(2));
        model.updateModel(c2, createDummyURI(c2));
        List<IMessage> msgList = VarModel.INSTANCE.resolveImports(root, createDummyURI(root), null);
        Assert.assertEquals(0, msgList.size());
    }
    
    /**
     * Creates an import with simple restriction.
     * 
     * @param project the project to add the import to
     * @param importName the import name (may be a qualified name with interface or without)
     * @param isConflict whether it is a conflict
     * @param operator the operator to be used with the version
     * @param version the version number
     * @throws RestrictionEvaluationException shall not occur
     * @throws ValueDoesNotMatchTypeException shall not occur
     * @throws CSTSemanticException shall not occur
     */
    public static void createImport(Project project, String importName, boolean isConflict, String operator, 
        Version version) throws RestrictionEvaluationException, ValueDoesNotMatchTypeException, CSTSemanticException {
        String interfaceName = null;
        int pos = importName.indexOf("::");
        if (pos > 0) {
            interfaceName = importName.substring(pos + 2);
            importName = importName.substring(0, pos);
        }
        DecisionVariableDeclaration[] rVars = ExpressionVersionRestriction.createRestrictionVars(importName);

        ConstraintSyntaxTree expr = new OCLFeatureCall(new CompoundAccess(new Variable(rVars[1]), "version"), operator, 
            new ConstantValue(ValueFactory.createValue(VersionType.TYPE, version)));
        expr.inferDatatype();

        project.addImport(new ProjectImport(importName, interfaceName, isConflict, false, 
            new ExpressionVersionRestriction(expr, rVars[0], rVars[1])));
    }

    /** 
     * projectimport with missing project. 
     */
    @Test
    public final void invalidImport() {
        final VarModel model = VarModel.INSTANCE;
        final String suffix = "_invalidImport";
        
        Project root = new Project("root" + suffix);
        root.setVersion(new Version(1));
        ProjectImport aImport = new ProjectImport("b" + suffix, null);
        root.addImport(aImport);
        model.updateModel(root, createDummyURI(root));

        List<IMessage> msgList = VarModel.INSTANCE.resolveImports(root, createDummyURI(root), null);
        Assert.assertNotEquals(0, msgList.size());
    }

    /** 
     * Circular project imports. 
     */
    @Ignore("currently not needed, check is disabled in import resolver as IVML can cope with that")
    @Test
    public final void circularImports() {
        final VarModel model = VarModel.INSTANCE;
        final String suffix = "_circularImports";
        
        Project root = new Project("root" + suffix);
        root.setVersion(new Version(1));
        ProjectImport aImport = new ProjectImport("a" + suffix, null);
        root.addImport(aImport);
        model.updateModel(root, createDummyURI(root));
        
        Project a = new Project("a" + suffix);
        a.setVersion(new Version(1));
        ProjectImport bImport = new ProjectImport("b" + suffix, null);
        a.addImport(bImport);
        model.updateModel(a, createDummyURI(a));
        
        Project b = new Project("b" + suffix);
        b.setVersion(new Version(1));
        ProjectImport rootImport = new ProjectImport("root" + suffix, null);
        b.addImport(rootImport);
        model.updateModel(b, createDummyURI(b));
        
        List<IMessage> msgList = VarModel.INSTANCE.resolveImports(root, createDummyURI(root), null);
        Assert.assertNotEquals(0, msgList.size());
    }
    
}
