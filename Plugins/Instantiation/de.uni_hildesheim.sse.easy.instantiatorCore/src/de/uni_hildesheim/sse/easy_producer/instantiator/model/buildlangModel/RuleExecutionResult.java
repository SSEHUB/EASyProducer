package de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel;

import java.util.ArrayList;
import java.util.List;

import de.uni_hildesheim.sse.easy_producer.instantiator.Bundle;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.IArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Invisible;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ListSet;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationMeta;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Set;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.VilException;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;

/**
 * Denotes the result of a rule execution.
 * 
 * @author Holger Eichelberger
 */
public class RuleExecutionResult implements IVilType {

    /**
     * Denotes the execution status.
     * 
     * @author Holger Eichelberger
     */
    public enum Status {
        
        /**
         * Successful execution of preconditions, body and postcondition.
         */
        SUCCESS,
        
        /**
         * Failure during body or postcondition. 
         */
        FAIL,
        
        /**
         * Preconditions are not met. Rule is not applicable.
         */
        NOT_APPLICABLE
    }
    
    public static final TypeDescriptor<? extends IVilType> TYPE;
    private Status status;
    private List<IArtifact> result;
    private List<IArtifact> allResults;

    /**
     * Creates a new rule execution result.
     * 
     * @param status the execution status
     * @param context the actual rule execution context to take the data from
     */
    public RuleExecutionResult(Status status, RuleExecutionContext context) {
        this.status = status;
        this.result = transfer(context.resultAsCollection());
        this.allResults = transfer(context.allResultsAsCollection());
    }
    
    /**
     * Transfers the data in <code>in</code> into a new list to be stored in an instance of 
     * this class.
     * 
     * @param in the collection to be considered as input
     * @return the created list
     */
    private static List<IArtifact> transfer(java.util.Collection<IArtifact> in) {
        List<IArtifact> result = new ArrayList<IArtifact>(in.size());
        result.addAll(in);
        return result;
    }
    
    /**
     * Registers itself and defines the value of the constant.
     */
    static {
        TypeDescriptor<? extends IVilType> type;
        try {
            type = TypeRegistry.DEFAULT.registerType(RuleExecutionResult.class);
        } catch (VilException e) {
            type = TypeRegistry.voidType(); // that there is at least a type
            EASyLoggerFactory.INSTANCE.getLogger(Resolver.class, Bundle.ID).exception(e);
        }
        TYPE = type;
    }
    
    /**
     * The immediate result of the execution.
     * 
     * @return the immediate result
     */
    @OperationMeta(returnGenerics = IArtifact.class)
    public Set<IArtifact> result() {
        return new ListSet<IArtifact>(result, IArtifact.class);
    }
    
    /**
     * All results achieved so far.
     * 
     * @return all results
     */
    @OperationMeta(returnGenerics = IArtifact.class)
    public Set<IArtifact> allResults() {
        return new ListSet<IArtifact>(allResults, IArtifact.class);
    }
    
    /**
     * Returns all results collected so far as a Java collection.
     * 
     * @return all results
     */
    java.util.Collection<IArtifact> allResultsAsCollection() {
        return allResults;
    }

    /**
     * Returns the results of the execution of the related rule as a Java collection.
     * 
     * @return the immediate results
     */
    java.util.Collection<IArtifact> resultAsCollection() {
        return result;        
    }
    
    /**
     * Returns the execution status of the rule.
     * 
     * @return the execution status
     */
    @Invisible
    public Status getStatus() {
        return status;
    }
    
}
