package net.ssehub.easy.producer.core.mgmt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.UUID;


/**
 * Creates a new MemberController for a PLP.
 * 
 * @author Hundt
 * @author El-Sharkawy
 */
public class MemberController extends Controller {

    private String memberID = null;
    /*
     * Order of members is necessary
     */
    private LinkedHashMap<String, PLPInfo> predecessors = new LinkedHashMap<String, PLPInfo>();
    private LinkedHashMap<String, PLPInfo> successors = new LinkedHashMap<String, PLPInfo>();
    
    /**
     * Constructor.
     * 
     * @param memberID the ID of the product inheriting this MemberController
     */
    public MemberController(String memberID) {
        this.memberID = memberID;
    }

    /**
     * Replaces a PLP info stored with same ID in this controller.
     * 
     * @param newPLP the replacing PLP
     */
    public void replacePLPInfo(PLPInfo newPLP) {
        replacePLPInfo(predecessors, newPLP);
        replacePLPInfo(successors, newPLP);
    }
    
    /**
     * Replaces a PLP info stored with same ID.
     * 
     * @param map the map to be modified
     * @param newPLP the replacing PLP
     */
    private static void replacePLPInfo(LinkedHashMap<String, PLPInfo> map, PLPInfo newPLP) {
        PLPInfo info = map.get(newPLP.getProjectID());
        if (null != info) {
            map.put(newPLP.getProjectID(), newPLP);
        }
    }

    /**
     * Check for Predecessors.
     * 
     * @return returns true if there is at least one predecessor
     */
    public boolean hasPredecessors() {
        return (this.predecessors.size() != 0);
    }

    /**
     * Check for Successors.
     * 
     * @return returns true if there is at least one successor
     */
    public boolean hasSuccessors() {
        return (successors.size() != 0);
    }

    /**
     * Check for a specified Predecessor.
     * 
     * @param inputID the UUID of the product line member in question
     * @return returns true if this UUID is already listed as a predecessor
     */
    public boolean containsPredecessor(UUID inputID) {
        return (predecessors.containsKey(inputID.toString()));
    }

    /**
     * Check for a specified Predecessor.
     * 
     * @param projectName the name of the product line member in question
     * @return returns true if this name is already listed as a predecessor
     */
    public boolean containsPredecessor(String projectName) {
        boolean found = false;
        List<PLPInfo> predList = new ArrayList<PLPInfo>(predecessors.values());
        for (int i = 0; i < predList.size(); i++) {
            if (predList.get(i).getProjectName().equals(projectName)) {
                found = true;
                i = predList.size();
            }
        }
        return found;
    }

    /**
     * Check for a specified Successor.
     * 
     * @param inputID the UUID of the product line member in question
     * @return returns true if this UUID is already listed as a successor
     */
    public boolean containsSuccessor(String inputID) {
        return (successors.containsKey(inputID));
    }

    /**
     * Returns the List of all predecessors.
     * @return the predecessors
     */
    public Collection<PLPInfo> getPredecessors() {
        return predecessors.values();
    }

    /**
     * Returns the List of all predecessor ids.
     * @return the predecessor ids
     */
    public Set<String> getPredecessorIDs() {
        return predecessors.keySet();
    }

    /**
     * Returns the List of all successor ids.
     * @return the successor ids
     */
    public Iterable<String> getSuccessorIDs() {
        return successors.keySet();
    }
    
    /**
     * Returns a list of all successor projects.
     * @return the successors
     */
    public Iterable<PLPInfo> getSuccessors() {
        return successors.values();
    }

    /**
     * This method replaces all stored information of existing predecessors.
     * 
     * @param predecessors A list of all predecessors
     */
    public void setPredecessors(List<PLPInfo> predecessors) {
        this.predecessors.clear();
        for (PLPInfo info : predecessors) {
            addPredecessor(info);
        }
    }

    /**
     * This method replaces all stored information of existing successors.
     * 
     * @param successors A list of all successors
     */
    public void setSuccessors(List<PLPInfo> successors) {
        this.successors.clear();
        for (PLPInfo info : successors) {
            addSuccessor(info);
        }
    }

    /**
     * Adds a predecessor project to this model.
     * @param predecessorID the UUID of the new predecessor
     */
    public void addPredecessor(String predecessorID) {
        // add predecessor
        PLPInfo predecessorPLP = SPLsManager.INSTANCE.getPLP(predecessorID);
        if (predecessorPLP != null) {
            
            addPredecessor(predecessorPLP);

            // vice versa add this member new successor to predecessor
            if (!predecessorPLP.getMemberController().containsSuccessor(memberID)) {
                predecessorPLP.getMemberController().addSuccessor(memberID);
            }
        }
    }

    /**
     * This method adds a predecessor in case, the predecessor name is known.
     * 
     * @param info the predecessor info
     */
    public void addPredecessor(PLPInfo info) {
        this.predecessors.put(info.getProjectID(), info);
        changed();
    }

    /**
     * Adds a sucessor project to this model.
     * @param successorID the UUID of the new successor
     */
    public void addSuccessor(String successorID) {
        // add successor
        PLPInfo successorPLP = SPLsManager.INSTANCE.getPLP(successorID);
        if (successorPLP != null) {
            addSuccessor(successorPLP);

            // vice versa add this member as new predecessor to successor
            if (!successorPLP.getMemberController().containsPredecessor(memberID)) {
                successorPLP.getMemberController().addPredecessor(memberID);
            }
        }
    }

    /**
     * This method adds a successor.
     * 
     * @param info the information on the successor.
     */
    public void addSuccessor(PLPInfo info) {
        this.successors.put(info.getProjectID(), info);
        changed();
    }

    /**
     * Removes a predecessor by given ID.
     * 
     * @param predecessorID The ID of the predecessor
     */
    public void removePredecessor(String predecessorID) {
        predecessors.remove(predecessorID);

        // vice versa remove this member as a successor from the before
        // mentioned predecessor
        PLPInfo predecessorPLP = SPLsManager.INSTANCE.getPLP(predecessorID);
        if (predecessorPLP.getMemberController().containsSuccessor(memberID)) {
            predecessorPLP.getMemberController().removeSuccessor(memberID);
        }

        changed();
    }

    /**
     * Removes a successor by given ID.
     * 
     * @param successorID The ID of the successor
     */
    public void removeSuccessor(String successorID) {
        successors.remove(successorID);

        // vice versa remove this member as a predecessor from the before
        // mentioned successor
        PLPInfo successorPLP = SPLsManager.INSTANCE.getPLP(successorID);
        if (successorPLP.getMemberController().containsPredecessor(memberID)) {
            successorPLP.getMemberController().removePredecessor(memberID);
        }

        changed();
    }

    /**
     * This method removes all stored information about pre- and successors.
     */
    public void clear() {
        predecessors.clear();
        successors.clear();
    }

    /**
     * Returns only the successors that are valid in terms of not creating a loop of successors and predecessors.
     * 
     * @return a List of all possible Successors
     */
    public List<String> getPossiblePredecessors() {
        // set input of the Tableviewer (all but the current and its
        // predecessors)
        HashMap<String, PLPInfo> allNodes = SPLsManager.INSTANCE.getProductLineProjects();
        List<String> result = new ArrayList<String>();
        result.addAll(allNodes.keySet());

        // Get the bad elements which are not allowed as predecessors
        ArrayList<String> badElements = new ArrayList<String>();
        // all successors of direct successors
        badElements.addAll(getAllSuccessors());
        // all predecessors of direct predecessors
        for (String directSuccessor : getSuccessorIDs()) {
            PLPInfo plpSuccessor = SPLsManager.INSTANCE.getPLP(directSuccessor);
            if (null != plpSuccessor) {
                badElements.addAll(plpSuccessor.getMemberController().getAllSuccessors());
            }
        }

        result.removeAll(badElements);
        result.remove(memberID);

        return result;
    }

    /**
     * Returns a list of all direct and indirect successor-IDs.
     * 
     * @return A list of UUIDs from successors
     * @since 18.10.2011
     */
    private List<String> getAllSuccessors() {
        ArrayList<String> result = new ArrayList<String>();
        for (String successor : successors.keySet()) {
            if (!result.contains(successor)) {
                result.add(successor);
            }
            PLPInfo plp = SPLsManager.INSTANCE.getPLP(successor);
            if (plp != null) {
                result.addAll(plp.getMemberController().getAllSuccessors());
            }
        }
        return result;
    }
    
    /**
     * Returns an iterator for all predecessor {@link PLPInfo}s.
     * @return Iterator for all predecessor {@link PLPInfo}s.
     * @since 23.07.2012
     */
    public MemberIterator predecessors() {
        Collection<String> preCollection = predecessors.keySet();
        return new MemberIterator(preCollection);
    }
    
    /**
     * Returns an iterator for all successor {@link PLPInfo}s.
     * @return Iterator for all successor {@link PLPInfo}s.
     * @since 23.07.2012
     */
    public MemberIterator successors() {
        Collection<String> preCollection = successors.keySet();
        return new MemberIterator(preCollection);
    }
    
    /**
     * Getter returns the size of the Predecessors because
     * getPredecessors returns a Collection and we may need this parameter.
     * 
     * @return size The size of the Predecessors-List.
     */
    public int getPredecessorsCount() {
        int size = predecessors.size();
        return size;
    }
    
    /**
     * Getter returns the size of the Successors because
     * getSuccessors returns Collection and we may need this parameter.
     * 
     * @return size The size of the Successors.List.
     */
    public int getSuccessorsCount() {
        int size = successors.size();
        return size;
    }
}
