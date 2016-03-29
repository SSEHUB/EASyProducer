package de.uni_hildesheim.sse.persistency.xml;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.BuildModel;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Script;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IProjectDescriptor;
import net.ssehub.easy.basics.modelManagement.ModelInfo;
import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.management.VarModel;
import net.ssehub.easy.varModel.model.Project;

/**
 * Implements a descriptor for the source and target VIL project locations.
 * The {@link #ProjectDescriptor() no-argument constructor}
 * obtains the relevant information for the model itself (i.e., the project
 * it is located in). The {@link #ProjectDescriptor(ProjectDescriptor, File) 
 * second constructor} allows to specify a different target location.
 * 
 * @author Aike Sass
 */
public class ProjectDescriptor implements IProjectDescriptor {
    
    private static final Map<String, Configuration> CONFIG_CACHE = new HashMap<String, Configuration>();

    private ProjectDescriptor parent;
    private File base;
    private Script vilScript;
    private final String easy = "EASy";

    /**
     * Creates the default project descriptor for the QM model to be instantiated.
     * 
     * @param fileName name of the file
     * @param modelName name of the model
     * 
     * @throws ModelManagementException in case that resolving the model, obtaining 
     *   information etc failed.
     */
    public ProjectDescriptor(String fileName, String modelName) throws ModelManagementException {
        this.parent = null;
        this.base = new File(fileName);

        BuildModel repository = BuildModel.INSTANCE;
        // by convention the same name, ignore versions for now
        List<ModelInfo<Script>> vilScripts = repository.availableModels().getModelInfo(modelName);
        if (null == vilScripts || vilScripts.isEmpty()) {
            throw new ModelManagementException("Cannot resolve main instantiation script", 
                ModelManagementException.ID_CANNOT_RESOLVE);
        } else {
            ModelInfo<Script> info = vilScripts.get(0); // primitive, ok for now
            vilScript = repository.load(info);
        }
    }

    /**
     * Allows to instantiate the QM model into a given location.
     * 
     * @param parent the parent descriptor (also representing the source, to
     *   be obtained via {@link #ProjectDescriptor()})
     * @param base the folder to instantiate into
     */
    public ProjectDescriptor(ProjectDescriptor parent, File base) {
        this.parent = parent;
        this.base = base;
        if (!base.exists()) {
            base.mkdirs();
        }
        this.vilScript = parent.getMainVilScript();
    }
    
    @Override
    public File getBase() {
        return base;
    }

    @Override
    public int getPredecessorCount() {
        return null != parent ? 1 : 0;
    }

    @Override
    public IProjectDescriptor getPredecessor(int index) {
        if (index < 0 || index >= getPredecessorCount()) {
            throw new IndexOutOfBoundsException();
        }
        return parent;
    }

    @Override
    public Script getMainVilScript() {
        return vilScript;
    }

    @Override
    public ProgressObserver createObserver() {
        return ProgressObserver.NO_OBSERVER; // TODO check, preliminary
    }

    @Override
    public String getModelFolder(ModelKind kind) {
        String result;
        switch (kind) {
        case IVML:
            result = easy;
            break;
        case VIL:
            result = easy;
            break;
        case VTL:
            result = easy;
            break;
        default:
            result = null;
            break;
        }
        return result;
    }
    
//    /**
//     * Returns the top-level QM configuration.
//     * 
//     * @return the top-level configuration to be used for instantiation
//     */
//    public Configuration getConfiguration(String modelName) {
//        return getConfiguration(modelName);
//    }

    /**
     * .
     * @param modelName the name of the model
     * @return created configuration
     */
    static Configuration getConfiguration(String modelName) {
        Configuration result = CONFIG_CACHE.get(modelName);
        if (null == result) {
            Project model = null;
            List<ModelInfo<Project>> infos = VarModel.INSTANCE.availableModels().getModelInfo(modelName);
            // primitive for now
            if (null != infos) {
                ModelInfo<Project> info = infos.get(0);
                try {
                    model = VarModel.INSTANCE.load(info);
                } catch (ModelManagementException e) {
//                    Dialogs.showErrorDialog("Model error", ModelAccess.class, e);
                    System.out.println("Model error: " + e);
                }
            }
            if (null == model) {
                model = new Project(modelName);
            }
            result = new Configuration(model, true);
//            Reasoner reasoner = new Reasoner();
//            ReasoningResult rresult = reasoner.propagate(model, result, new ReasonerConfiguration(), ProgressObserver.NO_OBSERVER);
//            System.out.println("Reasoning Result is: " + rresult.getMessageCount());
//            CONFIG_CACHE.put(modelName, result);
        }
        return result;
    }

}
