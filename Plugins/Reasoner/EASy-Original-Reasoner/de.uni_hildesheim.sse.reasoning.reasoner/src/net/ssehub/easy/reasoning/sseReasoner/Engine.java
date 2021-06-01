package net.ssehub.easy.reasoning.sseReasoner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.ssehub.easy.basics.messages.Status;
import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.reasoning.core.reasoner.GeneralMeasures;
import net.ssehub.easy.reasoning.core.reasoner.IReasonerInterceptor;
import net.ssehub.easy.reasoning.core.reasoner.Message;
import net.ssehub.easy.reasoning.core.reasoner.ReasonerConfiguration;
import net.ssehub.easy.reasoning.core.reasoner.ReasoningResult;
import net.ssehub.easy.reasoning.sseReasoner.functions.FailedElementDetails;
import net.ssehub.easy.reasoning.sseReasoner.functions.FailedElements;
import net.ssehub.easy.varModel.confModel.AssignmentState;
import net.ssehub.easy.varModel.confModel.CommandAssignmentState;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.confModel.IAssignmentState;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.ModelElement;
import net.ssehub.easy.varModel.model.Project;

/**
 * Class for executing reasoner and returning the result.
 * 
 * @author Sizonenko
 * @author Holger Eichelberger
 */
public class Engine {
    
    private static final String VIOLATED_CONSTRAINTS = "Constraints not satisfied:";
    private static final String VIOLATED_VARIABLES = "Reassignment is forbitten in the same project. Failed variables:";
    
    private Resolver resolver;
    
    private ReasoningResult result;
    
    private List<ModelElement> failedModelElements = new ArrayList<ModelElement>();
    private List<Set<AbstractVariable>> variablesInConstraints = new ArrayList<Set<AbstractVariable>>();
    private List<Set<IDecisionVariable>> problemDecisions = new ArrayList<Set<IDecisionVariable>>();
    private List<ConstraintSyntaxTree> problemConstraintParts = new ArrayList<ConstraintSyntaxTree>();
    private List<Constraint> problemConstraints = new ArrayList<Constraint>();
    private List<Project> failedElementProjects = new ArrayList<Project>();
    private List<Message.SuggestionType> failedElementSuggestions = new ArrayList<Message.SuggestionType>();  
    private List<IDecisionVariable> constraintVariables = new ArrayList<IDecisionVariable>();  
    private List<Integer> errorClassification = new ArrayList<Integer>();  
    
    
    private long evaluationTime;
    private int reevaluationCount;
    
    private int failedConstraints = 0;
    private int failedAssignments = 0;
    
    /**
     * Main constructor for creating an instance of the reasoner.
     * 
     * @param cfg Configuration to reason on.
     * @param reasonerConfig the reasoner configuration to be used for reasoning (e.g. taken from the UI, 
     *        may be <b>null</b>)
     * @param observer An optional progress observer, shall be {@link ProgressObserver#NO_OBSERVER} if unused
     * @param interceptor an optional interceptor instance
     */
    public Engine(Configuration cfg, ReasonerConfiguration reasonerConfig,
        ProgressObserver observer, IReasonerInterceptor interceptor) {
        this.resolver = new Resolver(cfg, reasonerConfig);
        this.resolver.setInterceptor(interceptor);
        boolean isRuntimeMode = reasonerConfig.isRuntimeMode();
        this.resolver.setIncremental(isRuntimeMode);
        this.result = new ReasoningResult();
        if (!isRuntimeMode) {
            // in runtime mode, we keep frozen variables frozen and operate only on unfrozen.
            // else, the configuration initialization freezes whatever it can freeze although constraints
            // may not fully be evaluated. We have to unfreeze such a (reused/copied) configuration
            // here to be able to do our job. We unfreeze to assigned and reset wasAssigned, but for performance
            // reasons rely on the existing configuration but overwrite values where needed (storing the state before 
            // freezing does not work as then easily erroneous reassignments may occur.            
            cfg.unfreeze(CommandAssignmentState.ASSIGNED_CLEAR);
        }
    } 
    
    /**
     * Method for launching the reasoner.
     *  
     * @return {@link ReasoningResult} failed constraints and assignments, if exist.
     */
    public ReasoningResult reason() {
        long startTime = System.currentTimeMillis();
        resolver.resolve();
        result.setTimeout(resolver.hasTimeout());
        result.setStopped(resolver.wasStopped());
        FailedElements failedElements = resolver.getFailedElements();
        if (failedElements.hasProblems()) {
            analyzeProblemConstraints(failedElements);
            analyzeProblemVariables(failedElements);
        }
        evaluationTime = System.currentTimeMillis() - startTime;
        reevaluationCount = resolver.reevaluationCount();
        result.setMeasure(Measures.VARIABLES_IN_CONSTRAINTS, resolver.variableInConstraintCount());
        result.setMeasure(GeneralMeasures.CONSTRAINT_COUNT, resolver.constraintCount());
        result.setMeasure(GeneralMeasures.REEVALUATION_COUNT, reevaluationCount);
        result.setMeasure(Measures.PROBLEM_CONSTRAINTS, failedConstraints);
        result.setMeasure(Measures.PROBLEM_ASSIGNMENTS, failedAssignments);
        result.setMeasure(GeneralMeasures.PROBLEMS, failedConstraints + failedAssignments);
        result.setMeasure(GeneralMeasures.REASONING_TIME, evaluationTime);
        result.setMeasure(GeneralMeasures.TRANSLATION_TIME, resolver.getTranslationTime());
        result.setMeasure(GeneralMeasures.EVALUATION_TIME, resolver.getEvaluationTime());
        return result;
    } 
    
    /**
     * Method for analyzing problem points - failed constraints and associated variables.
     * @param failedElements Problem points.
     */
    private void analyzeProblemConstraints(FailedElements failedElements) {
        if (failedElements.problemConstraintCount() > 0) {
            Map<Constraint, FailedElementDetails> problemConstraintMap = failedElements.getProblemConstraintMap();
            Iterator<Constraint> problemIterator = failedElements.getProblemConstraints();
            while (problemIterator.hasNext()) {   
                this.failedConstraints++;
                Constraint constraint = problemIterator.next();
                failedModelElements.add(constraint);
                FailedElementDetails failedElementDetails = problemConstraintMap.get(constraint);                
                if (constraint.getTopLevelParent() instanceof Project) {
                    failedElementProjects.add((Project) constraint.getTopLevelParent());                    
                }
                constraintVariables.add(resolver.getConstraintVariable(constraint)); // ok if get-result is null
                java.util.Set<IDecisionVariable> problemVars = failedElementDetails.getProblemPoints(); 
                java.util.Set<AbstractVariable> vars = new HashSet<AbstractVariable>();
                for (IDecisionVariable problemVar : problemVars) {
                    vars.add(problemVar.getDeclaration());
                }
                variablesInConstraints.add(vars);
                problemDecisions.add(problemVars);
                problemConstraintParts.add(failedElementDetails.getProblemConstraintPart());
                problemConstraints.add(failedElementDetails.getProblemConstraint());
                failedElementSuggestions.add(Message.SuggestionType.PROBLEM_POINTS);
                errorClassification.add(failedElementDetails.getErrorClassifier());
            }
            Message problemConstraintMsg = createMessage(VIOLATED_CONSTRAINTS);
            result.addMessage(problemConstraintMsg);
            clearFailedInfo();
        }
    }
    
    /**
     * Method for analyzing failed elements and creating error messages.
     * @param failedElements All failed elements from the reasoner.
     */
    private void analyzeProblemVariables(FailedElements failedElements) {       
        if (failedElements.problemVariabletCount() > 0) {
            Map<AbstractVariable, FailedElementDetails> problemVariableMap = failedElements.getProblemVariableMap();
            Iterator<AbstractVariable> problemVariables = failedElements.getProblemVariables();
            while (problemVariables.hasNext()) {
                this.failedAssignments++;
                AbstractVariable problemVariable = problemVariables.next();
                failedModelElements.add(problemVariable);
                FailedElementDetails failedElementDetails = problemVariableMap.get(problemVariable);
                if (problemVariable.getTopLevelParent() instanceof Project) {
                    failedElementProjects.add((Project) problemVariable.getTopLevelParent());                    
                }
                failedElementSuggestions.add(Message.SuggestionType.REASSIGNMENT);
                Set<AbstractVariable> vars = new HashSet<AbstractVariable>();
                vars.add(problemVariable);
                problemDecisions.add(failedElementDetails.getProblemPoints());
                problemConstraintParts.add(failedElementDetails.getProblemConstraintPart());
                problemConstraints.add(failedElementDetails.getProblemConstraint());
                variablesInConstraints.add(vars);
                constraintVariables.add(null);
                errorClassification.add(failedElementDetails.getErrorClassifier());
            } 
            Message problemVarialbeMsg = createMessage(VIOLATED_VARIABLES);
            result.addMessage(problemVarialbeMsg);
            clearFailedInfo();
        } 
    } 
    
    /**
     * Clears information about failed elements.
     */
    private void clearFailedInfo() {
        failedModelElements.clear();
        variablesInConstraints.clear();
        problemDecisions.clear();
        problemConstraintParts.clear();
        problemConstraints.clear();
        failedElementProjects.clear();
        failedElementSuggestions.clear();
        constraintVariables.clear();
        errorClassification.clear();
    }
    
    /**
     * Method for creating custom message fields.
     * @param text Text for the message.
     * @return Created message.
     */
    private Message createMessage(String text) {
        Message msg = new Message(text, failedModelElements, Status.ERROR);
        msg.addConstraintVariables(variablesInConstraints);
        msg.addProblemVariables(problemDecisions);
        msg.addProblemConstraintParts(problemConstraintParts);
        msg.addProblemConstraints(problemConstraints);
        msg.addConflictingElementProjects(failedElementProjects);
        msg.addConflictingElementSuggestions(failedElementSuggestions);
        msg.addNamedConstraintVariables(constraintVariables);
        msg.addErrorClassification(errorClassification);
        return msg;
    }
    
    /**
     * Method for getting evaluation time of the model.
     * @return Time in milliseconds.
     */
    public long getEvaluationTime() {
        return evaluationTime;
    }
    
    /**
     * Method for getting reevaluation count of the model.
     * @return Number of reevaluations.
     */
    public long getReevaluationCount() {
        return reevaluationCount;
    }

    /**
     * Returns whether the reasoner is (still) operating.
     * 
     * @return <code>true</code> for operating, <code>false</code> else
     */
    boolean isRunning() {
        return resolver.isRunning();
    }

    /**
     * Stops/terminates reasoning. If possible, a reasoner shall stop the reasoning
     * operations as quick as possible. A reasoner must not implement this operation.
     * 
     * @return <code>true</code> if the reasoner tries to stop, <code>false</code> else 
     *     (operation not implemented)
     */
    boolean stop() {
        return resolver.stop();
    }
    
    /**
     * Clears this instance for reuse.
     * 
     * @see #markForReuse()
     * @see #reInit()
     */
    void clear() {
        // keep the interceptor!
        this.result = new ReasoningResult();
        clearFailedInfo();
        evaluationTime = 0;
        reevaluationCount = 0;
        failedConstraints = 0;
        failedAssignments = 0;
        resolver.clear();
    }

    /**
     * Marks this instance for re-use. Must be called before the first call to {@link #resolve()}.
     * 
     * @see #clear()
     * @see #reInit()
     */
    void markForReuse() {
        resolver.markForReuse();
    }
    
    /**
     * Re-initializes this resolver instance to allocated resources only if really needed.
     * 
     * @see #markForReuse()
     * @see #clear()
     */
    void reInit() {
        resolver.reInit();
    }
    
    /**
     * Sets the desired assignment state. The default value is {@link AssignmentState#DERIVED}, but specific reasoning
     * operations such as configuration initialization may require a different state.
     * 
     * @param state the state to use
     */
    void setAssignmentState(IAssignmentState state) {
        resolver.setAssignmentState(state); 
    }

}
