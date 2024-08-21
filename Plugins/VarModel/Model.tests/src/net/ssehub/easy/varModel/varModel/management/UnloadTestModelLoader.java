package net.ssehub.easy.varModel.varModel.management;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

import net.ssehub.easy.basics.messages.IMessage;
import net.ssehub.easy.basics.messages.Message;
import net.ssehub.easy.basics.messages.Status;
import net.ssehub.easy.basics.modelManagement.IModelLoader;
import net.ssehub.easy.basics.modelManagement.ImportResolver;
import net.ssehub.easy.basics.modelManagement.ModelImport;
import net.ssehub.easy.basics.modelManagement.ModelInfo;
import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.varModel.management.VarModel;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.ProjectImport;

/**
 * A model loader for the unload model functionality. This model loader
 * constructs a simple dependency of variability models in memory and
 * allows the VarModel to read them. The models are structure as follows:
 * <ul>
 *   <li><code>b</code> imports <code>e</code></li>
 *   <li><code>p1</code> imports <code>a</code> and <code>b</code></li>
 *   <li><code>p2</code> imports <code>b</code> and <code>c</code></li>
 *   <li><code>p3</code> imports <code>b</code> and <code>d</code></li>
 *   <li><code>p4</code> imports <code>d</code></li>
 *   <li><code>f</code> is not imported at all</li>
 * </ul>
 * For the moment, we do not consider versions at all.
 * 
 * @author Holger Eichelberger
 */
class UnloadTestModelLoader implements IModelLoader<Project> {

    public static final File BASE = new File("Z:\\models");
    
    private Map<String, ModelInfo<Project>> name2Info = new HashMap<String, ModelInfo<Project>>();
    private Map<ModelInfo<Project>, Project> data = new HashMap<ModelInfo<Project>, Project>();

    /**
     * Creates the loader and the model for testing the unload functionality.
     */
    private UnloadTestModelLoader() {
        registerProject("a");
        registerProject("e");
        registerProject("b", "e");
        registerProject("c");
        registerProject("d");
        registerProject("f");
        registerProject("p1", "a", "b");
        registerProject("p2", "b", "c");
        registerProject("p3", "b", "d");
        registerProject("p4", "d");
    }
    
    /**
     * Performs the tests as it knows the structures. This method shall be called by a test method.
     * 
     * @throws ModelManagementException in case that the tests fails due to varModel problems
     */
    public static void performTests() throws ModelManagementException {
        int count = VarModel.INSTANCE.getModelCount();
        UnloadTestModelLoader loader = new UnloadTestModelLoader();
        VarModel.INSTANCE.locations().addLocation(BASE, ProgressObserver.NO_OBSERVER);
        VarModel.INSTANCE.loaders().registerLoader(loader, ProgressObserver.NO_OBSERVER);
        // no model was loaded
        Assert.assertEquals(VarModel.INSTANCE.getModelCount(), count);
        // prepare all models
        for (ModelInfo<Project> info : loader.infos()) {
            Assert.assertTrue(loader.getProject(info) == VarModel.INSTANCE.load(info));
        }
        // no model was loaded
        Assert.assertEquals(VarModel.INSTANCE.getModelCount(), count + loader.infoCount());

        testUnloading(loader, "f", "f"); // f is not imported so it shall be unloaded
        testUnloading(loader, "a"); // a is imported so it shall not be unloaded
        testUnloading(loader, "e"); // e is imported so it shall not be unloaded
        testUnloading(loader, "b"); // b is imported and imports e so it shall not be unloaded
        testUnloading(loader, "c"); // c is imported so it shall not be unloaded
        testUnloading(loader, "d"); // d is imported so it shall not be unloaded
        testUnloading(loader, "p1", "p1", "a"); // p1 shall be unloaded, also a
        testUnloading(loader, "p2", "p2", "c"); // p2 shall be unloaded, also c
        testUnloading(loader, "p3", "p3", "b", "e"); // p3 shall be unloaded, also b and transitively e
        testUnloading(loader, "p4", "p4", "d"); // p4 shall be unloaded, as now d is not imported from other projects
        
        VarModel.INSTANCE.loaders().unregisterLoader(loader, ProgressObserver.NO_OBSERVER);
        VarModel.INSTANCE.locations().removeLocation(BASE, ProgressObserver.NO_OBSERVER);
    }
    
    /**
     * Tries unloading <code>projectName</code> and tests for <code>expectedUnloaded</code>.
     * 
     * @param loader the model loader
     * @param projectName the project to be unloaded
     * @param expectedUnloaded the names of the models to be unloaded with <code>projectName</code>
     * @throws ModelManagementException in case of VarModel errors
     */
    private static void testUnloading(UnloadTestModelLoader loader, String projectName, 
        String... expectedUnloaded) throws ModelManagementException {
        //System.out.println("unloading " + projectName + " expecting " + Arrays.toString(expectedUnloaded));
        ModelInfo<Project> info = loader.getProjectInfo(projectName);
        Assert.assertNotNull("project information object for '" + projectName + "' does not exist", info);
        Assert.assertNotNull("project '" + projectName + "' is not resolved" + info.getResolved());
        int count = VarModel.INSTANCE.getModelCount();
        HashSet<String> pNames = new HashSet<String>(count);
        for (int i = 0; i < count; i++) {
            pNames.add(VarModel.INSTANCE.getModel(i).getName());
        }
        Assert.assertEquals("expected number of unloaded projects is not met", expectedUnloaded.length, 
            VarModel.INSTANCE.unload(info.getResolved(), ProgressObserver.NO_OBSERVER));
        for (int i = 0; i < expectedUnloaded.length; i++) {
            Assert.assertNotNull(loader.getProjectInfo(expectedUnloaded[i]));
            Assert.assertNull("project '" + expectedUnloaded[i] + "' is still resolved", 
                loader.getProjectInfo(expectedUnloaded[i]).getResolved());
            Assert.assertNotNull("project '" + expectedUnloaded[i] + "' does not exist", 
                pNames.remove(expectedUnloaded[i]));
        }
        for (int i = 0; i < VarModel.INSTANCE.getModelCount(); i++) { // varModel may have changed
            pNames.remove(VarModel.INSTANCE.getModel(i).getName());
        }
        Assert.assertTrue("model name mismatch", pNames.isEmpty());
    }
    
    /**
     * Returns the number of project information objects.
     * 
     * @return the number of project information objects
     */
    private int infoCount() {
        return data.size();
    }
    
    /**
     * Returns the information objects.
     * 
     * @return the known information objects
     */
    private Iterable<ModelInfo<Project>> infos() {
        return data.keySet();
    }
    
    /**
     * Returns the project assigned to <code>info</code>.
     * @param info the information object
     * @return the project assigned to <code>info</code>
     */
    private Project getProject(ModelInfo<Project> info) {
        return data.get(info);
    }
    
    /**
     * Returns the project information matching to <code>projectName</code>.
     * @param projectName the project name
     * @return the project information object, or <b>null</b> if not found
     */
    private ModelInfo<Project> getProjectInfo(String projectName) {
        return name2Info.get(projectName);
    }
    
    /**
     * Registers an empty project with given names and given imports.
     * 
     * @param projectName the name of the project
     * @param importNames the imports (may be empty)
     */
    private void registerProject(String projectName, String... importNames) {
        Project p = new Project(projectName);
        List<ModelImport<Project>> imps = null;
        if (null != importNames) {
            imps = new ArrayList<ModelImport<Project>>();
            for (int i = 0; i < importNames.length; i++) {
                if (null != importNames[i] && importNames[i].length() > 0) {
                    ProjectImport imp = new ProjectImport(importNames[i], null);
                    p.addImport(imp);
                    imps.add(imp);
                }
            }
            if (imps.isEmpty()) {
                imps = null;
            }
        }
        File file = new File(BASE, projectName + ".ivml");
        // don't care whether this exists or not
        ModelInfo<Project> info = new ModelInfo<Project>(p.getName(), p.getVersion(), this, file.toURI(), imps);
        data.put(info, p);
        name2Info.put(projectName, info);
    }
    
    @Override
    public LoadResult<Project> load(ModelInfo<Project> info, ImportResolver<Project> resolver) {
        List<Project> projects = new ArrayList<Project>();
        List<IMessage> messages = new ArrayList<IMessage>();
        Project project = data.get(info);
        if (null != project) {
            projects.add(project);
        } else {
            messages.add(new Message("'" + info.getName() + " v" + info.getVersion() + "' not found", Status.ERROR));
        }
        return new LoadResult<Project>(projects, messages);
    }

    @Override
    public void scan(File location, IModelInfoHolder<Project> holder) {
        String sLocation = location.toURI().normalize().toString();
        for (ModelInfo<Project> info : data.keySet()) {
            String iLocation = info.getLocation().normalize().toString();
            if (iLocation.startsWith(sLocation)) {
                holder.addResult(info);
            }
        }
    }

}
