package de.uni_hildesheim.sse.varModel.versioning;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import de.uni_hildesheim.sse.model.management.VarModel;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.ProjectImport;
import de.uni_hildesheim.sse.utils.messages.IMessage;
import de.uni_hildesheim.sse.utils.modelManagement.Version;
import de.uni_hildesheim.sse.utils.modelManagement.VersionRestriction;
import de.uni_hildesheim.sse.utils.modelManagement.VersionRestriction.Operator;

/**
 * ...
 * 
 * @author XovoxKingdom
 * @author kroeher
 */
public class ImportValidationTest {

    /**
     * number of resulting messages after starting the validationprocess.
     */
    private int numberOfMessages;

    /**
     * distinguished projectnames.
     */
    private String[] suffixProjectNames = {"_mostTrivialTest", "_irrelevantConflict", "_simpleImport",
        "_simpleConflict", "_legitIMportAndConflict", "_retrospectiveConflict", "_localImportRestriction",
        "_invalidImport", "_circularImports"

    };

    /**
     * Two-step test.
     * First step: define two project of which one includes a false import of the other
     * project with respect to the version restriction.
     * Second step: the false import (the version restriction) will be corrected by
     * updating the version of the imported project in the version restriction.
     */
    @Test
    public final void versionCorrectionTest() {
        VarModel model = VarModel.INSTANCE;
        String dummyUri = "path/";
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
        ProjectImport falsePLImport = new ProjectImport("PL_ImportTest", null, false, false,
                new VersionRestriction("PL_ImportTest", Operator.EQUALS, new Version(0)));
        invalidProductProject.addImport(falsePLImport);
        // Add both projects to the variability model
        try {
            model.updateModel(plProject, new URI(dummyUri + plProject.getName()));
            model.updateModel(invalidProductProject, new URI(dummyUri + invalidProductProject.getName()));
        } catch (URISyntaxException e1) {
            e1.printStackTrace();
        }
        /*
         * Resolve the false import.
         * Expected result: the number of messages is not 0 as it must contain
         * at least one error-message because of the false import.
         */
        try {
            List<IMessage> msgList = VarModel.INSTANCE.resolveImports(invalidProductProject,
                    new URI(dummyUri + invalidProductProject.getName()), null);
            numberOfMessages = msgList.size();
            Assert.assertNotSame(0, numberOfMessages);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        /*
         * Correct the product (the false import) in terms of creating a new project
         * with the same name and version number as the invalid one previously, correct
         * the version restriction and add the project again to the model.
         */
        Project correctedProductProject = new Project("New_Product");
        correctedProductProject.setVersion(new Version(0));
        ProjectImport correctedPLImport = new ProjectImport("PL_ImportTest", null, false, false,
                new VersionRestriction("PL_ImportTest", Operator.EQUALS, new Version(0, 3)));
        correctedProductProject.addImport(correctedPLImport);
        try {
            model.updateModel(correctedProductProject, new URI(dummyUri + correctedProductProject.getName()));
        } catch (URISyntaxException e1) {
            e1.printStackTrace();
        }
        /*
         * Resolve the corrected import.
         * Expected result: the number of messages is 0 as no error-message should occur.
         */
        try {
            List<IMessage> msgList = VarModel.INSTANCE.resolveImports(correctedProductProject,
                    new URI(dummyUri + correctedProductProject.getName()), null);    
            numberOfMessages = msgList.size();
            Assert.assertEquals(0, numberOfMessages);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
    
    
    
    /** One project with no restrictions. */
    @Test
    public final void mostTrivialTest() {
        VarModel model = VarModel.INSTANCE;
        String dummyUri = "path/";
        Project root = new Project("root" + suffixProjectNames[0]);
        root.setVersion(new Version(1));
        try {
            model.updateModel(root, new URI(dummyUri + root.getName()));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        try {
            List<IMessage> msgList = VarModel.INSTANCE.resolveImports(root, new URI(dummyUri + root.getName()), null);
            numberOfMessages = msgList.size();
            Assert.assertEquals(0, numberOfMessages);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    /** Two projects conflict with a non-existing project. **/
    @Test
    public final void irrelevantConflict() {
        VarModel model = VarModel.INSTANCE;
        String dummyUri = "path/";
        Project root = new Project("root" + suffixProjectNames[1]);
        root.setVersion(new Version(1));
        ProjectImport conflictC1 = new ProjectImport("c" + suffixProjectNames[1], null, false, false,
                new VersionRestriction("c" + suffixProjectNames[1], Operator.EQUALS, new Version(1)));
        root.addImport(conflictC1);
        try {
            model.updateModel(root, new URI(dummyUri + root.getName()));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        Project b = new Project("b" + suffixProjectNames[1]);
        b.setVersion(new Version(1));
        b.addImport(conflictC1);
        try {
            model.updateModel(b, new URI(dummyUri + b.getName()));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        try {
            List<IMessage> msgList = VarModel.INSTANCE.resolveImports(root, new URI(dummyUri + root.getName()), null);
            numberOfMessages = msgList.size();
            Assert.assertEquals(1, numberOfMessages);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    /** Simple Import with no restrictions. **/
    @Test
    public final void simpleImport() {
        VarModel model = VarModel.INSTANCE;
        String dummyUri = "path/";
        Project root = new Project("root" + suffixProjectNames[2]);
        root.setVersion(new Version(1));
        ProjectImport aImport = new ProjectImport("a" + suffixProjectNames[2], null);
        root.addImport(aImport);
        try {
            model.updateModel(root, new URI(dummyUri + root.getName()));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        Project a = new Project("a" + suffixProjectNames[2]);
        a.setVersion(new Version(1));
        try {
            model.updateModel(a, new URI(dummyUri + a.getName()));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        try {
            List<IMessage> msgList = VarModel.INSTANCE.resolveImports(root, new URI(dummyUri + root.getName()), null);
            numberOfMessages = msgList.size();
            Assert.assertEquals(0, numberOfMessages);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    /** Simple direct conflict. **/
    @Test
    public final void simpleConflict() {
        VarModel model = VarModel.INSTANCE;
        String dummyUri = "path/";
        Project root = new Project("root" + suffixProjectNames[3]);
        root.setVersion(new Version(1));
        ProjectImport aImport = new ProjectImport("a" + suffixProjectNames[3], null, true, false,
                new VersionRestriction("a" + suffixProjectNames[3], Operator.EQUALS, new Version(1)));
        root.addImport(aImport);
        try {
            model.updateModel(root, new URI(dummyUri + root.getName()));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        Project a = new Project("a" + suffixProjectNames[3]);
        a.setVersion(new Version(1));
        try {
            model.updateModel(a, new URI(dummyUri + a.getName()));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        try {
            List<IMessage> msgList = VarModel.INSTANCE.resolveImports(root, new URI(dummyUri + root.getName()), null);
            numberOfMessages = msgList.size();
            Assert.assertEquals(1, numberOfMessages);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
    

    /** Impossible import restriction causes error, because the chosen project is restricted. **/
    @Test
    public final void impossibleImportRestriction() {
        VarModel model = VarModel.INSTANCE;
        String dummyUri = "path/";
        Project root = new Project("root_" + "impossibleImportRestriction");
        root.setVersion(new Version(1));
        ProjectImport aImport = new ProjectImport("a_"
                + "impossibleImportRestriction", null, false, false,
                new VersionRestriction("a_" + "impossibleImportRestriction",
                Operator.GREATER_EQUALS, new Version(3, 1)));
        root.addImport(aImport);
        try {
            model.updateModel(root, new URI(dummyUri + root.getName()));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        Project a = new Project("a_" + "impossibleImportRestriction");
        a.setVersion(new Version(1));
        try {
            model.updateModel(a, new URI(dummyUri + a.getName()));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        try {
            List<IMessage> msgList = VarModel.INSTANCE.resolveImports(root, new URI(dummyUri + root.getName()), null);
            numberOfMessages = msgList.size();
            Assert.assertEquals(2, numberOfMessages);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    /** a imports c [possible: c1, c2], but b removes c2 => valid solution. **/
    @Test
    public final void legitImportAndConflict() {
        VarModel model = VarModel.INSTANCE;
        String dummyUri = "path/";
        Project root = new Project("root" + suffixProjectNames[4]);
        root.setVersion(new Version(1));
        ProjectImport aImport = new ProjectImport("a" + suffixProjectNames[4], null);
        root.addImport(aImport);
        ProjectImport bImport = new ProjectImport("b" + suffixProjectNames[4], null);
        root.addImport(bImport);
        try {
            model.updateModel(root, new URI(dummyUri + root.getName()));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        Project a = new Project("a" + suffixProjectNames[4]);
        a.setVersion(new Version(1));
        a.addImport(new ProjectImport("c" + suffixProjectNames[4], null));
        try {
            model.updateModel(a, new URI(dummyUri + a.getName()));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        Project b = new Project("b" + suffixProjectNames[4]);
        b.setVersion(new Version(1));
        b.addImport(new ProjectImport("c" + suffixProjectNames[4], null, true, false, new VersionRestriction("c"
                + suffixProjectNames[4], Operator.LESS_EQUALS, new Version(1))));
        try {
            model.updateModel(b, new URI(dummyUri + b.getName()));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        Project c1 = new Project("c" + suffixProjectNames[4]);
        c1.setVersion(new Version(1));
        try {
            model.updateModel(c1, new URI(dummyUri + c1.getName()));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        Project c2 = new Project("c" + suffixProjectNames[4]);
        c2.setVersion(new Version(2));
        try {
            model.updateModel(c2, new URI(dummyUri + c2.getName()));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        try {
            List<IMessage> msgList = VarModel.INSTANCE.resolveImports(root, new URI(dummyUri + root.getName()), null);
            numberOfMessages = msgList.size();
            Assert.assertEquals(3, numberOfMessages);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    /** a imports c, but c conflicts with root -> invalid solution. **/
    @Test
    public final void retrospectiveConflict() {
        VarModel model = VarModel.INSTANCE;
        String dummyUri = "path/";
        Project root = new Project("root" + suffixProjectNames[5]);
        root.setVersion(new Version(1));
        ProjectImport aImport = new ProjectImport("a" + suffixProjectNames[5], null);
        root.addImport(aImport);
        ProjectImport bImport = new ProjectImport("b" + suffixProjectNames[5], null);
        root.addImport(bImport);
        try {
            model.updateModel(root, new URI(dummyUri + root.getName()));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        Project a = new Project("a" + suffixProjectNames[5]);
        a.setVersion(new Version(1));
        a.addImport(new ProjectImport("c" + suffixProjectNames[5], null));
        try {
            model.updateModel(a, new URI(dummyUri + a.getName()));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        Project b = new Project("b" + suffixProjectNames[5]);
        b.setVersion(new Version(1));
        try {
            model.updateModel(b, new URI(dummyUri + b.getName()));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        Project c = new Project("c" + suffixProjectNames[5]);
        c.setVersion(new Version(1));
        c.addImport(new ProjectImport("root" + suffixProjectNames[5], null, true, false, new VersionRestriction("root"
                + suffixProjectNames[5], Operator.UNEQUALS, new Version(1, 2, 3, 4)))); // root-project is now
                                                                                        // rejected
        try {
            model.updateModel(c, new URI(dummyUri + c.getName()));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        try {
            List<IMessage> msgList = VarModel.INSTANCE.resolveImports(root, new URI(dummyUri + root.getName()), null);
            numberOfMessages = msgList.size();
            Assert.assertEquals(4, numberOfMessages);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    /**
     * a imports c1 and b imports c2 -> valid solution, if (local)blackbox-flag is set.
     **/
    @Test
    public final void localImportRestriction() {
        VarModel model = VarModel.INSTANCE;
        String dummyUri = "path/";
        Project root = new Project("root" + suffixProjectNames[6]);
        root.setVersion(new Version(1));
        ProjectImport aImport = new ProjectImport("a" + suffixProjectNames[6], null);
        root.addImport(aImport);
        ProjectImport bImport = new ProjectImport("b" + suffixProjectNames[6], null);
        root.addImport(bImport);
        try {
            model.updateModel(root, new URI(dummyUri + root.getName()));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        Project a = new Project("a" + suffixProjectNames[6]); // imports c1
        a.setVersion(new Version(1));
        a.addImport(new ProjectImport("c" + suffixProjectNames[6], null, false, false, new VersionRestriction("c"
                + suffixProjectNames[6], Operator.LESS, new Version(2))));
        try {
            model.updateModel(a, new URI(dummyUri + a.getName()));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        Project b = new Project("b" + suffixProjectNames[6]); // imports c2
        b.setVersion(new Version(1));
        b.addImport(new ProjectImport("c" + suffixProjectNames[6], null, false, false, new VersionRestriction("c"
                + suffixProjectNames[6], Operator.GREATER_EQUALS, new Version(2))));
        try {
            model.updateModel(b, new URI(dummyUri + b.getName()));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        Project c1 = new Project("c" + suffixProjectNames[6]);
        c1.setVersion(new Version(1));
        try {
            model.updateModel(c1, new URI(dummyUri + c1.getName()));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        Project c2 = new Project("c" + suffixProjectNames[6]);
        c2.setVersion(new Version(2));
        try {
            model.updateModel(c2, new URI(dummyUri + c2.getName()));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        try {
            List<IMessage> msgList = VarModel.INSTANCE.resolveImports(root, new URI(dummyUri + root.getName()), null);
            numberOfMessages = msgList.size();
            Assert.assertEquals(0, numberOfMessages);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    /** projectimport with missing project. **/
    @Test
    public final void invalidImport() {
        VarModel model = VarModel.INSTANCE;
        String dummyUri = "path/";
        Project root = new Project("root" + suffixProjectNames[7]);
        root.setVersion(new Version(1));
        ProjectImport aImport = new ProjectImport("b" + suffixProjectNames[7], null);
        root.addImport(aImport);
        try {
            model.updateModel(root, new URI(dummyUri + root.getName()));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        try {
            List<IMessage> msgList = VarModel.INSTANCE.resolveImports(root, new URI(dummyUri + root.getName()), null);
            numberOfMessages = msgList.size();
            Assert.assertEquals(1, numberOfMessages);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    /** circular projectimports. **/
    @Test
    public final void circularImports() {
        VarModel model = VarModel.INSTANCE;
        String dummyUri = "path/";
        Project root = new Project("root" + suffixProjectNames[8]);
        root.setVersion(new Version(1));
        ProjectImport aImport = new ProjectImport("a" + suffixProjectNames[8], null);
        root.addImport(aImport);
        try {
            model.updateModel(root, new URI(dummyUri + root.getName()));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        Project a = new Project("a" + suffixProjectNames[8]);
        a.setVersion(new Version(1));
        ProjectImport bImport = new ProjectImport("b" + suffixProjectNames[8], null);
        a.addImport(bImport);
        try {
            model.updateModel(a, new URI(dummyUri + a.getName()));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        Project b = new Project("b" + suffixProjectNames[8]);
        b.setVersion(new Version(1));
        ProjectImport rootImport = new ProjectImport("root" + suffixProjectNames[8], null);
        b.addImport(rootImport);
        try {
            model.updateModel(b, new URI(dummyUri + b.getName()));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        try {
            List<IMessage> msgList = VarModel.INSTANCE.resolveImports(root, new URI(dummyUri + root.getName()), null);
            numberOfMessages = msgList.size();
            for (IMessage msg : msgList) {
                System.out.println(msg.getDescription());
            }
            Assert.assertEquals(2, numberOfMessages);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
