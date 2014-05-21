package de.uni_hildesheim.sse.model.varModel.filter;

import java.util.ArrayList;
import java.util.List;

import de.uni_hildesheim.sse.model.varModel.FreezeBlock;
import de.uni_hildesheim.sse.model.varModel.Project;

/**
 * Finds all freeze blocks in a given project.
 * @author El-Sharkawy
 *
 */
public class FreezeBlockFinder extends AbstractFrozenElementsFinder {

    private List<FreezeBlock> freezeBlocks;
    
    /**
     * Default constructor for this class.
     * @param project The project which should be inspected.
     * @param filtertype Specifies whether imports shall be considered or not.
     */
    public FreezeBlockFinder(Project project, FilterType filtertype) {
        super(project, filtertype);
        freezeBlocks = new ArrayList<FreezeBlock>();
        project.accept(this);
    }
    
    /**
     * Returns a list of all freeze blocks in the specified project.
     * @return A maybe empty list of existing freeze blocks.
     */
    public List<FreezeBlock> getFreezeBlocks() {
        return freezeBlocks;
    }

    /**
     * {@inheritDoc}
     */
    public void visitFreezeBlock(FreezeBlock freeze) {
        // Store freeze block
        freezeBlocks.add(freeze);
    }
}
