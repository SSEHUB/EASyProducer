package de.uni_hildesheim.sse.reasoning.chocoreasoner.implementation;

import de.uni_hildesheim.sse.model.confModel.Configuration;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.VarModel;
import de.uni_hildesheim.sse.reasoning.core.reasoner.IReasoner;

/**
 * The concrete reasoner of this OSGi plugin.
 * @author El-Sharkawy
 *
 */
public class Choco implements IReasoner {

    @Override
    public boolean isConsistent(Project project) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isConsistent(Project project, Configuration cfg) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void propagateValues(VarModel vm, Configuration cfg) {
        // TODO Auto-generated method stub
        
    }




}
