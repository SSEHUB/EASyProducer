package test.de.uni_hildesheim.sse;

import java.net.URI;
import java.net.URISyntaxException;

import net.ssehub.easy.basics.modelManagement.RestrictionEvaluationException;
import net.ssehub.easy.basics.modelManagement.Version;
import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.management.VarModel;
import net.ssehub.easy.varModel.model.IvmlKeyWords;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.ProjectImport;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.varModel.versioning.ImportValidationTest;

/**
 * A demonstration of the import validation. Refactored from original implementation.
 * 
 * @author Jähne
 */
public class ImportValidationDemo {

    /**
     * Short demonstration of the import validation.
     * 
     * @param args unused.
     * @throws URISyntaxException shall not occur
     * @throws RestrictionEvaluationException shall not occur
     * @throws ValueDoesNotMatchTypeException shall not occur
     * @throws CSTSemanticException shall not occur
     */
    public static void main(String[] args) throws URISyntaxException, RestrictionEvaluationException, 
        ValueDoesNotMatchTypeException, CSTSemanticException  {
        String tempURIanfang = "bla/"; // testOnly
        VarModel model = VarModel.INSTANCE;

        Project root = new Project("root");
        root.setVersion(new Version(1));
        root.addImport(new ProjectImport("a", null));
        root.addImport(new ProjectImport("b", null));

        Project a = new Project("a");
        a.setVersion(new Version(1));
        ImportValidationTest.createImport(a, "c", false, IvmlKeyWords.GREATER_EQUALS, new Version(3, 1));
        // A importiert c mit version > 1

        Project b = new Project("b");
        b.setVersion(new Version(1));
        ImportValidationTest.createImport(b, "c", true, IvmlKeyWords.LESS_EQUALS, new Version(3, 1));
        ImportValidationTest.createImport(b, "d", false, IvmlKeyWords.GREATER_EQUALS, new Version(3, 1));

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
