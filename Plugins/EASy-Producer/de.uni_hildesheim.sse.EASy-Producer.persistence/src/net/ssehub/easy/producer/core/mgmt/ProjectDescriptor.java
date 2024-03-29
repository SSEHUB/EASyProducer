package net.ssehub.easy.producer.core.mgmt;

import java.io.File;
import java.util.Collection;

import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.instantiation.core.model.buildlangModel.Script;
import net.ssehub.easy.instantiation.core.model.vilTypes.IProjectDescriptor;

/**
 * Implements the mapping of relevant information from EASy projects to VIL projects.
 * 
 * @author Holger Eichelberger
 */
class ProjectDescriptor implements IProjectDescriptor {

    private PLPInfo info;
    private PLPInfo[] predecessors;

    /**
     * Creates a project descriptor instance.
     * 
     * @param info the product line information object
     */
    ProjectDescriptor(PLPInfo info) {
        this.info = info;
        Collection<PLPInfo> pred = info.getMemberController().getPredecessors();
        predecessors = new PLPInfo[pred.size()];
        pred.toArray(predecessors);
    }
    
    @Override
    public File getBase() {
        return info.getProjectLocation();
    }

    @Override
    public int getPredecessorCount() {
        return predecessors.length;
    }

    @Override
    public IProjectDescriptor getPredecessor(int index) {
        return new ProjectDescriptor(predecessors[index]);
    }

    @Override
    public Script getMainVilScript() {
        return info.getBuildScript();
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
            result = info.getConfigLocation().toString();
            break;
        case VIL:
            result = info.getScriptLocation().toString();
            break;
        case VTL:
            result = info.getTemplateLocation().toString();
            break;
        default:
            result = null;
            break;
        }
        return result;
    }

}
