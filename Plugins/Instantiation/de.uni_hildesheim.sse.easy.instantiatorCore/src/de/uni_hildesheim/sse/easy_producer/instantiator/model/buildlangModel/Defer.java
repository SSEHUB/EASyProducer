package de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel;

import java.util.ArrayList;
import java.util.List;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilLanguageException;

/**
 * Representation of a defer-statement in VIL which allows dynamically scheduling
 * workflows for execution during the execution of a workflow.
 *  
 * @author kroeher
 *
 */
public class Defer implements IRuleElement {

    private Rule deferredWorkflow;
    private List<Rule> requiredWorkflows;
    
    /**
     * Create a defer which defines the scheduling of a workflow execution (deferred workflow)
     * after the execution of a single workflow or a set workflows the deferred workflow depends on.
     *  
     * @param deferred The deferred workflow.
     */
    public Defer(Rule deferred) {
        this.deferredWorkflow = deferred;
        this.requiredWorkflows = new ArrayList<Rule>();
    }
    
    /**
     * Get the deferred workflow of this defer.
     * 
     * @return The deferred workflow.
     */
    public Rule getDeferredWorkflow() {
        return this.deferredWorkflow;
    }
    
    /**
     * Add a required workflow to this defer. Required workflows must be executed before the deferred
     * workflow can be executed.
     * 
     * @param workflow The required workflow of this defer.
     */
    public void addRequiredWorkflow(Rule workflow) {
        this.requiredWorkflows.add(workflow);
    }
    
    /**
     * Get the number of required workflows of this defer.
     * 
     * @return The number of required workflows of this defer.
     */
    public int getRequiredWorkflowCount() {
        return this.requiredWorkflows.size();
    }
    
    /**
     * Get the required workflow of this defer at the specified index.
     * 
     * @param index The 0-based index of the required workflow to be returned.
     * @return The required workflow at the given index.
     */
    public Rule getRequiredWorkflow(int index) {
        return this.requiredWorkflows.get(index);
    }
    
    @Override
    public Object accept(IVisitor visitor) throws VilLanguageException {
        //visitor.visitDefer(this);
        return null;
    }
    
}
