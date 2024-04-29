package net.ssehub.easy.instantiation.core.model.buildlangModel;

import java.util.ArrayList;
import java.util.List;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.instantiation.core.Bundle;
import net.ssehub.easy.instantiation.core.model.artifactModel.IArtifact;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.Conversion;
import net.ssehub.easy.instantiation.core.model.vilTypes.IStringValueProvider;
import net.ssehub.easy.instantiation.core.model.vilTypes.IVilType;
import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;
import net.ssehub.easy.instantiation.core.model.vilTypes.ListSet;
import net.ssehub.easy.instantiation.core.model.vilTypes.ReturnGenerics;
import net.ssehub.easy.instantiation.core.model.vilTypes.Set;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;

/**
 * Denotes the result of a rule execution.
 * 
 * @author Holger Eichelberger
 */
public class RuleExecutionResult implements IVilType, IStringValueProvider {

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
        NOT_APPLICABLE;
        
        /**
         * Turns a rule body execution result into a status. Either it is anyway a status or it was successful if object
         * is not <b>null</b>.
         * 
         * @param object the object to be converted
         * @return the status
         */
        public static Status toStatus(Object object) {
            Status result;
            if (object instanceof Status) {
                result = (Status) object; 
            } else {
                result = object != null ? Status.SUCCESS : Status.FAIL; 
            }
            return result;
        }

    }
    
    public static final TypeDescriptor<?> TYPE;
    private Status status;
    private List<IArtifact> result;
    private List<IArtifact> allResults;
    private String failReason;
    private Integer failCode;
    private boolean hasChanges;

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
        this.failReason = context.getFailReason();
        this.failCode = context.getFailCode();
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
        TypeDescriptor<?> type;
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
    @ReturnGenerics(IArtifact.class)
    public Set<IArtifact> result() {
        return new ListSet<IArtifact>(result, IArtifact.class);
    }
    
    /**
     * All results achieved so far.
     * 
     * @return all results
     */
    @ReturnGenerics(IArtifact.class)
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
    
    /**
     * Changes the status to {@link Status#FAIL}.
     */
    @Invisible
    public void fail() {
        status = Status.FAIL;
    }
    
    /**
     * Returns the fail reason (if the execution failed).
     * 
     * @return the reason or <b>null</b> if unknown, not set or not failing
     */
    public String getFailReason() {
        return failReason;
    }
    
    /**
     * The failure code.
     * 
     * @return the failure code (may be <b>null</b> if not set)
     */
    public Integer getFailCode() {
        return failCode;
    }
    
    /**
     * Defines whether the rule call represented by this instance changed the configuration
     * and committed the changes.
     * 
     * @param hasChanges <code>true</code> for changes, <code>false</code> else
     */
    public void setChanges(boolean hasChanges) {
        this.hasChanges = hasChanges;
    }

    /**
     * Returns whether the rule call represented by this instance changed the configuration
     * and committed the changes.
     * 
     * @return <code>true</code> for changes, <code>false</code> else
     */
    public boolean hasChanges() {
        return hasChanges;
    }

    /**
     * Conversion operation.
     * 
     * @param res the rule execution result to be converted/projected
     * @return the converted value
     */
    @Invisible
    @Conversion
    @ReturnGenerics(IArtifact.class)
    public static Set<IArtifact> convert(RuleExecutionResult res) {
        return res.result();
    }

    @Override
    public String getStringValue(StringComparator comparator) {
        return "RuleExecutionResult " + getStatus();
    }
    
}
