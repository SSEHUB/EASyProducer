package de.uni_hildesheim.sse.easy_producer.core.mgmt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;


/**
 * An {@link Iterator} over all predecessors or successors of one {@link PLPInfo}.
 * @author El-Sharkawy
 * @since 23.07.2012
 *
 */
public final class MemberIterator implements Iterator<PLPInfo> {
    private Iterator<PLPInfo> relatives;
    
    /**
     * Sole constructor of this class.
     * @param relatives The IDs of all prede- or successors of the current project.
     */
    MemberIterator(Collection<String> relatives) {
        List<PLPInfo> projects = new ArrayList<PLPInfo>();
        
        for (String relativeID : relatives) {
            PLPInfo plp = SPLsManager.INSTANCE.getPLP(relativeID);
            if (null != plp) {
                projects.add(plp);
            }
        }
        
        this.relatives = projects.iterator();
    }

    @Override
    public boolean hasNext() {
        return relatives.hasNext();
    }

    @Override
    public PLPInfo next() {
        return relatives.next();
    }

    @Override
    public void remove() {
        relatives.remove();
    }
}