package test.de.uni_hildesheim.sse;

import java.net.URI;
import java.net.URISyntaxException;

import de.uni_hildesheim.sse.model.management.VarModel;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.ProjectImport;
import de.uni_hildesheim.sse.utils.modelManagement.Version;
import de.uni_hildesheim.sse.utils.modelManagement.VersionRestriction;
import de.uni_hildesheim.sse.utils.modelManagement.VersionRestriction.Operator;

/**
 * A demonstration of the import validation. Refactored from original implementation.
 * 
 * @author Jähne
 */
public class ImportValidationDemo {

    /**
     * Short demonstration of the import validation.
     * 
     * @param args
     *            unused.
     * @throws URISyntaxException .
     */
    public static void main(String[] args) throws URISyntaxException {
        System.out.println("Please ensure that Patrick's version of the importer is enabled");
        
        String tempURIanfang = "bla/"; // testOnly
        VarModel model = VarModel.INSTANCE;

        Project root = new Project("root");
        root.setVersion(new Version(1));
        root.addImport(new ProjectImport("a", null));
        root.addImport(new ProjectImport("b", null));

        Project a = new Project("a");
        a.setVersion(new Version(1));
        VersionRestriction[] cVersRestr = new VersionRestriction[1];
        cVersRestr[0] = new VersionRestriction("c", Operator.GREATER_EQUALS, new Version(3, 1));
        ProjectImport cImport1 = new ProjectImport("c", null, false, false, cVersRestr); // import
        a.addImport(cImport1); // A importiert c mit version > 1

        Project b = new Project("b");
        b.setVersion(new Version(1));
        VersionRestriction[] cVr2 = new VersionRestriction[1];
        cVr2[0] = new VersionRestriction("c", Operator.LESS_EQUALS, new Version(3, 1));
        ProjectImport cImport2 = new ProjectImport("c", null, true, false, cVr2); // conflict
        b.addImport(cImport2); // A importiert c mit version > 1
        b.addImport(new ProjectImport("d", null, false, false, new VersionRestriction("d", Operator.GREATER_EQUALS,
                new Version(3, 1))));

        Project projC1 = new Project("c");
        projC1.setVersion(new Version(3));

        Project projC2 = new Project("c");
        projC2.setVersion(new Version(2));

        Project projC3 = new Project("c");
        projC3.setVersion(new Version(3, 1));

        Project projC32 = new Project("c");
        projC32.setVersion(new Version(3, 2));
        projC32.addImport(new ProjectImport("d", null)); // HIER ist der test, ob das flag funzt
        
        Project projd1 = new Project("d");
        projd1.setVersion(new Version(3));
        
        Project projd2 = new Project("d");
        projd2.setVersion(new Version(3, 2));
//        projC32.addImport(new ProjectImport("a", null, true, false, new VersionRestriction("a", Operator.LESS_EQUALS,
//                new Version(3))));

        model.updateModel(root, new URI(tempURIanfang + root.getName()));
        model.updateModel(a, new URI(tempURIanfang + a.getName()));
        model.updateModel(b, new URI(tempURIanfang + b.getName()));
        model.updateModel(projC1, new URI(tempURIanfang + projC1.getName()));
        model.updateModel(projC2, new URI(tempURIanfang + projC2.getName()));
        model.updateModel(projC3, new URI(tempURIanfang + projC3.getName()));
        model.updateModel(projC32, new URI(tempURIanfang + projC3.getName() + ":)"));
        model.updateModel(projd1, new URI(tempURIanfang + projd1));
        model.updateModel(projd2, new URI(tempURIanfang + projd2));

        VarModel.INSTANCE.resolveImports(root, new URI(tempURIanfang + root.getName()), null);
    }

    // try {
    // iv.validateProject(root);
    // System.out.println("YEAH :)");
    // System.out.println("Projektübersicht:");
    // for (ProjectInfo pi : iv.projectsImported) {
    // System.out
    // .println("\t" + pi.getName() + " : " + pi.getVersion().getVersion()
    // + ", " + pi.getLocation());
    // }
    // } catch (ImportValidationException e) {
    // System.err.println(e.getMessage());
    // }

}
