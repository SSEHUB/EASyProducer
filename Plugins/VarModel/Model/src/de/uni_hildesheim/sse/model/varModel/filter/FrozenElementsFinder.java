package de.uni_hildesheim.sse.model.varModel.filter;

import java.util.ArrayList;
import java.util.List;

import de.uni_hildesheim.sse.model.varModel.FreezeBlock;
import de.uni_hildesheim.sse.model.varModel.IFreezable;
import de.uni_hildesheim.sse.model.varModel.Project;

/**
 * This class searches through a project (and its imports) for finding frozen elements.
 * @author El-Sharkawy
 *
 */
public class FrozenElementsFinder extends AbstractFrozenElementsFinder {
    
    private List<IFreezable> frozenElements;
    
    /**
     * Default constructor for this class.
     * @param project The project which should be inspected.
     * @param filtertype Specifies whether imports shall be considered or not.
     */
    public FrozenElementsFinder(Project project, FilterType filtertype) {
        super(project, filtertype);
        frozenElements = new ArrayList<IFreezable>();
        project.accept(this);
    }
    
    /**
     * Returns all discovered frozen elements.
     * @return All frozen elements.
     */
    public List<IFreezable> getFrozenElements() {
        return frozenElements;
    }

    /**
     * {@inheritDoc}
     */
    public void visitFreezeBlock(FreezeBlock freeze) {
        // Save frozen elements.
        for (int i = 0; i < freeze.getFreezableCount(); i++) {
            frozenElements.add(freeze.getFreezable(i));
        }
    }
}
