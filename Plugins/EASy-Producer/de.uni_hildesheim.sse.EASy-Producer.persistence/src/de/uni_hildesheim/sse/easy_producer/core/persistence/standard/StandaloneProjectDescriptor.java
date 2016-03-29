package de.uni_hildesheim.sse.easy_producer.core.persistence.standard;

import java.io.File;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.BuildModel;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Script;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IProjectDescriptor;
import net.ssehub.easy.basics.modelManagement.ModelInfo;
import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.basics.progress.ProgressObserver;

/**
 * Implements a descriptor for the source and target VIL project locations.
 * The {@link #ProjectDescriptor(StandaloneProjectDescriptor, File) 
 * second constructor} allows to specify a different target location.
 * 
 * @author Holger Eichelberger
 */
public class StandaloneProjectDescriptor implements IProjectDescriptor {

    private IProjectDescriptor parent;
    private File base;
    private Script vilScript;

    /**
     * Creates a standalone project descriptor.
     * 
     * @param vilInfo the model information instance for the VIL script to run
     * @param base the folder to instantiate into
     * @throws ModelManagementException in case that resolving the model, obtaining 
     *   information etc failed.
     */
    public StandaloneProjectDescriptor(ModelInfo<Script> vilInfo, File base) throws ModelManagementException {
        this.parent = null;
        this.base = base;
        vilScript = BuildModel.INSTANCE.load(vilInfo);
    }

    /**
     * Creates a standalone project descriptor.
     * 
     * @param vilScript the VIL script to run
     * @param base the folder to instantiate into
     * @throws ModelManagementException in case that resolving the model, obtaining 
     *   information etc failed.
     */
    public StandaloneProjectDescriptor(Script vilScript, File base) throws ModelManagementException {
        this.parent = null;
        this.base = base;
        this.vilScript = vilScript;
    }

    /**
     * Allows to instantiate into a given location.
     * 
     * @param parent the parent descriptor (also representing the source, to
     *   be obtained via {@link #ProjectDescriptor()})
     * @param base the folder to instantiate into
     */
    public StandaloneProjectDescriptor(IProjectDescriptor parent, File base) {
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
            result = PersistenceConstants.EASY_FILES_DEFAULT;
            break;
        case VIL:
            result = PersistenceConstants.EASY_FILES_DEFAULT;
            break;
        case VTL:
            result = PersistenceConstants.EASY_FILES_DEFAULT;
            break;
        default:
            result = null;
            break;
        }
        return result;
    }

}
