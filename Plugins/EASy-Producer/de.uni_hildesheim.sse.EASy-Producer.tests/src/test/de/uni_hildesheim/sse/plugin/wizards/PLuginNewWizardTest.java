package test.de.uni_hildesheim.sse.plugin.wizards;
//
//import org.junit.Assert;
//import org.junit.Test;
//import org.w3c.dom.Text;
//
//import test.PrivateMethodTester;
//import test.PrivateVariable;
//import de.uni_hildesheim.sse.easy.ui.internal.NewEASyProjectWizard;
//import de.uni_hildesheim.sse.easy.ui.internal.NewEASyProjectWizardPage;
//import de.uni_hildesheim.sse.easy_producer.persistency.ResourcesMgmt;
//
///**
// * Testclass for the creation of a new Project-Creation over the NewEASyProjectWizard.
// */
//public class PLuginNewWizardTest {
//
//    /**
//     * Tests the creation of a new Project with the NewEASyProjectWizard.
//     */
//    @Test
//    public void test_performFinish() {
//
//        final String projectname = "A_NEW_PROJECT_GENERATED_OVER_THE_WIZARD";
//
//        // At this time, there shouldn't exit the specified project!
//        Assert.assertFalse(ResourcesMgmt.INSTANCE.getProject(projectname).exists());
//
//        // Count number of projects
//        int numberOfProjects = ResourcesMgmt.INSTANCE.getAllProjects().length;
//
//        // Creates a new Wizard
//        NewEASyProjectWizard wizard = new NewEASyProjectWizard();
//
//        wizard.addPages();
//
//        // Searches the textfield for inserting the projectname
//        PrivateVariable[] variablesOfWizard = PrivateMethodTester.getPrivateVariables(wizard);
//        Text textfield = findTextField(variablesOfWizard);
//
//        // Set projectname
//        textfield.setTextContent(projectname);
//
//        // Press Finish Button
//        Assert.assertTrue(wizard.performFinish());
//
//        // Now, there should exist a new project, we check that
//        Assert.assertTrue(ResourcesMgmt.INSTANCE.getProject(projectname).exists());
//
//        // Therefore it should exist one more project as counted before
//        Assert.assertEquals(numberOfProjects + 1, ResourcesMgmt.INSTANCE.getAllProjects().length);
//        numberOfProjects = ResourcesMgmt.INSTANCE.getAllProjects().length;
//
//        // Next, try to create the same project again so that
//        // ProjectAlreadyExistsException occurs
//        // Creates a new Wizard
//        wizard = new NewEASyProjectWizard();
//        wizard.addPages();
//
//        // Inserts Text into the Wizard
//        variablesOfWizard = PrivateMethodTester.getPrivateVariables(wizard);
//        textfield = findTextField(variablesOfWizard);
//
//        // Set projectname
//        textfield.setTextContent(projectname);
//
//        // Press Finish Button, should be false because project already exists.
//        Assert.assertFalse(wizard.performFinish());
//        // The number of projects should be equal to last counting
//        Assert.assertEquals(numberOfProjects, ResourcesMgmt.INSTANCE.getAllProjects().length);
//    }
//
//    /**
//     * Helping method for test_performFinish().<br/>
//     * Looks for the text field inside of the PLuginNewWizard
//     * 
//     * @param variablesOfWizard private Attributes of an Instance of PLuginNewWizard
//     * @return The textfield or in case of an error: <b>null</b>
//     */
//    private Text findTextField(PrivateVariable[] variablesOfWizard) {
//        Text textfield = null;
//        for (int i = 0; i < variablesOfWizard.length; i++) {
//            // Search for the WizardPage
//            if (variablesOfWizard[i].getType() == NewEASyProjectWizard.class) {
//
//                // Page found, instantiate it
//                NewEASyProjectWizardPage page = (NewEASyProjectWizardPage) variablesOfWizard[i].getInstance();
//
//                // IS MISSING
//                // page.createControl(null);
//                page.createControl(PrivateMethodTester.createComposite());
//
//                // Search for text field
//                PrivateVariable[] variablesOfPage = PrivateMethodTester.getPrivateVariables(page);
//                for (int j = 0; j < variablesOfPage.length; j++) {
//                    if (variablesOfPage[j].getType() == Text.class) {
//                        textfield = (Text) variablesOfPage[j].getInstance();
//                    }
//                }
//            }
//        }
//        return textfield;
//    }
//}
