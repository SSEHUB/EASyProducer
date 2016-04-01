package de.uni_hildesheim.sse.reasoning.reasoner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import de.uni_hildesheim.sse.model.confModel.Configuration;
import de.uni_hildesheim.sse.model.confModel.DisplayNameProvider;
import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;
import de.uni_hildesheim.sse.model.cst.ConstraintSyntaxTree;
import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.Constraint;
import de.uni_hildesheim.sse.model.varModel.ModelElement;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.persistency.StringProvider;
import de.uni_hildesheim.sse.reasoning.core.model.PerformanceStatistics;
import de.uni_hildesheim.sse.reasoning.core.reasoner.Message;
import de.uni_hildesheim.sse.reasoning.core.reasoner.ReasonerConfiguration;
import de.uni_hildesheim.sse.reasoning.core.reasoner.ReasonerConfiguration.IAdditionalInformationLogger;
import de.uni_hildesheim.sse.reasoning.core.reasoner.ReasoningResult;
import de.uni_hildesheim.sse.reasoning.reasoner.functions.FailedElementDetails;
import de.uni_hildesheim.sse.reasoning.reasoner.functions.FailedElements;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory.EASyLogger;
import de.uni_hildesheim.sse.utils.messages.Status;
import de.uni_hildesheim.sse.utils.progress.ProgressObserver;

/**
 * Class for executing reasoner and returning the result.
 * @author Sizonenko
 *
 */
public class Engine {
    
    private static final String VIOLATED_CONSTRAINTS = "Constraints not satisfied:";
    private static final String VIOLATED_VARIABLES = "Reassignment is forbitten in the same project. Failed variables:";
    
    private static final EASyLogger LOGGER
        = EASyLoggerFactory.INSTANCE.getLogger(Engine.class, Descriptor.BUNDLE_NAME);
    
    private String reasoningID;
    
    private Resolver resolver;
    
    private ReasoningResult result;
    
    private Project project;
    
    private List<ModelElement> failedModelElements;
    private List<String> failedElementLabels;
    private List<Set<AbstractVariable>> variablesInConstraints;
    private List<Set<IDecisionVariable>> problemDecisions;
    private List<ConstraintSyntaxTree> problemConstraintParts;
    private List<String> failedElementComments;
    private List<Project> failedElementProjects;
    private List<String> failedElementSuggestions;  
    private List<IDecisionVariable> constraintVariables;  
    
    private Map<Constraint, IDecisionVariable> constraintVariableMap;
    
    private String msgText;
    private String comment;
    private String suggestion;
    
    private IAdditionalInformationLogger infoLogger;
    
    private long startTime = System.currentTimeMillis();
    
    private int failedConstraints = 0;
    private int failedAssignments = 0;
    
    /**
     * Main constructor for creating an instance of the reasoner.
     * @param cfg Configuration to reason on.
     * @param project Project to reason on.
     * @param reasonerConfig the reasoner configuration to be used for reasoning (e.g. taken from the UI, 
     *        may be <b>null</b>)
     * @param observer An optional progress observer, shall be {@link ProgressObserver#NO_OBSERVER} if unused
     */
    public Engine(Project project, Configuration cfg, ReasonerConfiguration reasonerConfig,
        ProgressObserver observer) {
        this.project = project;
        this.reasoningID = PerformanceStatistics.createReasoningID(project.getName(), "Model validation");
        this.resolver = new Resolver(project, cfg, true, reasonerConfig);
        this.resolver.setIncremental(reasonerConfig.isRuntimeMode());
        this.result = new ReasoningResult();
        this.infoLogger = reasonerConfig.getLogger();
    }
    /**
     * Method for lunching reasoning.     * 
     * @return {@link ReasoningResult} failed constraints and assignments, if exist.
     */
    public ReasoningResult reason() {
//        PerformanceStatistics.createPerformanceMeasurement(reasoningID);
//        PerformanceStatistics.addTimestamp(reasoningID);
        resolver.resolve();
//        PerformanceStatistics.addTimestamp(reasoningID);
//        FailedElements failedElements = FailedRules.getFailedElements(reasoningID);
        FailedElements failedElements = resolver.getFailedElements();
        if (failedElements.hasProblems()) {
            constraintVariableMap = resolver.getConstraintVariableMap();
            analyzeProblemConstraints(failedElements);
            analyzeProblemVariables(failedElements);
        } 
//        PerformanceStatistics.addTimestamp(reasoningID);
//        PerformanceStatistics.getStats(reasoningID);   
//        PerformanceStatistics.clearReasoningID(reasoningID);
        infoLogger.info("");
        infoLogger.info("Model: " + project.getName());
        infoLogger.info("Number of variables: " + resolver.variableCount());
        infoLogger.info("Number of constraints: " + resolver.constraintCount());
        infoLogger.info("Number of reevaluations: " + resolver.reevaluationCount());
        infoLogger.info("Number of problem constraints: " + failedConstraints);
        infoLogger.info("Number of problem assignments: " + failedAssignments);
        infoLogger.info("Evaluation time: " + (System.currentTimeMillis() - startTime));
        return result;        
    } 
    
    /**
     * Method for analyzing problem points - failed constraints and associated variables.
     * @param failedElements Problem points.
     */
    private void analyzeProblemConstraints(FailedElements failedElements) {
        if (failedElements.problemConstraintCount() > 0) {
            initFailedLists();
            Map<Constraint, FailedElementDetails> problemConstraintMap = failedElements.getProblemConstraintMap();
            Iterator<Constraint> problemConstraints = failedElements.getProblemConstraints();
            while (problemConstraints.hasNext()) {   
                this.failedConstraints++;
                Constraint constraint = problemConstraints.next();
                failedModelElements.add(constraint);
                FailedElementDetails failedElementDetails = problemConstraintMap.get(constraint);                
                if (constraint.getTopLevelParent() instanceof Project) {
                    failedElementProjects.add((Project) constraint.getTopLevelParent());                    
                }                
                if (constraintVariableMap.get(constraint) != null) {
                    constraintVariables.add(constraintVariableMap.get(constraint));
                    if (constraintVariableMap.get(constraint).getDeclaration().getComment() == null) {
                        msgText = constraintVariableMap.get(constraint).getDeclaration().getName();  
                    } else {
                        msgText = constraintVariableMap.get(constraint).getDeclaration().getComment();
//                            + " (" + traceToTop(constraintVariableMap.get(failedRule)) + " )";
                    } 
                } else {
                    constraintVariables.add(null);
                    msgText = StringProvider.toIvmlString(constraint.getConsSyntax());
                }
                comment = msgText;
                java.util.Set<IDecisionVariable> problemVars = failedElementDetails.getProblemPoints(); 
                java.util.Set<AbstractVariable> vars = new HashSet<AbstractVariable>();
                for (IDecisionVariable problemVar : problemVars) {
                    vars.add(problemVar.getDeclaration());
                }
                String problemPoints = "";
                int count = 0;
                for (AbstractVariable variable : vars) {
                    if (count > 0) {
                        if (count == vars.size() - 1) {
                            problemPoints += " or ";
                        } else {
                            problemPoints += ", ";
                        }
                    }
                    String displayVarName = DisplayNameProvider.getInstance().getDisplayName(variable);
                    String displayParentName = DisplayNameProvider.getInstance().getParentNames(variable);
                    if (displayParentName != null) {
                        problemPoints = problemPoints + "\"" + displayVarName + "\" in " + displayParentName;
                    } else {
                        problemPoints = problemPoints + "\"" + displayVarName + "\"";
                    }
                    count++;
                }
                if (problemPoints.length() > 0) {
                    problemPoints = " Please check: " + problemPoints;
                    suggestion = problemPoints;
                }
                msgText = msgText + problemPoints;
                variablesInConstraints.add(vars);
                problemDecisions.add(problemVars);
                problemConstraintParts.add(failedElementDetails.getProblemConstraintPart());
                failedElementLabels.add(msgText);
                failedElementComments.add(comment);
                failedElementSuggestions.add(suggestion);
            }
            Message problemConstraintMsg = createMessage(VIOLATED_CONSTRAINTS);
            result.addMessage(problemConstraintMsg);
//            if (Descriptor.LOGGING) {
//            }
            printMessage(problemConstraintMsg);                
            nullFailedLists();
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
            initFailedLists();
            while (problemVariables.hasNext()) {
                this.failedAssignments++;
                AbstractVariable problemVariable = problemVariables.next();
                failedModelElements.add(problemVariable);
                FailedElementDetails failedElementDetails = problemVariableMap.get(problemVariable);
                if (problemVariable.getTopLevelParent() instanceof Project) {
                    failedElementProjects.add((Project) problemVariable.getTopLevelParent());                    
                }
                msgText = DisplayNameProvider.getInstance().getDisplayName(problemVariable) 
                    + " (" + traceToTop(problemVariable) + " )";
                failedElementLabels.add(msgText);
                failedElementComments.add(msgText);
                failedElementSuggestions.add("Check for variable reassignments in the same Project scope");
                Set<AbstractVariable> vars = new HashSet<AbstractVariable>();
                vars.add(problemVariable);
                problemDecisions.add(failedElementDetails.getProblemPoints());
                problemConstraintParts.add(failedElementDetails.getProblemConstraintPart());
                variablesInConstraints.add(vars);
                constraintVariables.add(null);
            } 
            Message problemVarialbeMsg = createMessage(VIOLATED_VARIABLES);
            result.addMessage(problemVarialbeMsg);
//            if (Descriptor.LOGGING) {
//            }
            printMessage(problemVarialbeMsg);                
            nullFailedLists();
        } 
    } 
    
    /**
     * Method for creating a msg of trace to the top element 
     * of constraint or variable that fail in the reasoning.
     * @param element Constraint of Variable.
     * @return text text of the trace.
     */
    private String traceToTop(ModelElement element) {
        String text = "";
        if (element.getParent() != null) {
            text = " -> " + element.getParent().getName();
            ModelElement mElement = (ModelElement) element.getParent();
            text = text + traceToTop(mElement);
        }
        return text;
    }
    
    /**
     * Method for initializing lists of failed elements.
     */
    private void initFailedLists() {
        failedModelElements = new ArrayList<ModelElement>();
        failedElementLabels = new ArrayList<String>(); 
        variablesInConstraints = new ArrayList<Set<AbstractVariable>>();
        problemDecisions = new ArrayList<Set<IDecisionVariable>>();
        problemConstraintParts = new ArrayList<ConstraintSyntaxTree>();
        failedElementComments = new ArrayList<String>();
        failedElementProjects = new ArrayList<Project>();
        failedElementSuggestions = new ArrayList<String>();
        constraintVariables = new ArrayList<IDecisionVariable>();
        msgText = null;
        comment = null;
        suggestion = null;
    }
    
    /**
     * Method for nulling lists of failed elements.
     */
    private void nullFailedLists() {
        failedModelElements = null;
        failedElementLabels = null;
        variablesInConstraints = null;
        problemDecisions = null;
        problemConstraintParts = null;
        failedElementComments = null;
        failedElementProjects = null;
        failedElementSuggestions = null;
        constraintVariables = null;
        msgText = null;
        comment = null;
        suggestion = null;
    }
    
    /**
     * Method for creating custom message fields.
     * @param text Text for the message.
     * @return Created message.
     */
    private Message createMessage(String text) {
        Message msg = new Message(text, failedModelElements, Status.ERROR);
        msg.addConflictingElementLabels(failedElementLabels);
        msg.addConstraintVariables(variablesInConstraints);
        msg.addProblemVariables(problemDecisions);
        msg.addProblemConstraintParts(problemConstraintParts);
        msg.addConflictingElementComments(failedElementComments);
        msg.addConflictingElementProjects(failedElementProjects);
        msg.addConflictingElementSuggestions(failedElementSuggestions);
        msg.addNamedConstraintVariables(constraintVariables);
        return msg;
    }
    
    /**
     * Method for printing out Message.
     * @param msg Message to be printed out.
     */
    private void printMessage(Message msg) {
        for (int i = 0; i < msg.getConflictsCount(); i++) {
            infoLogger.info("---");
            if (msg.getConflicts().get(i) instanceof Constraint) {
                Constraint constraint = (Constraint) msg.getConflicts().get(i);
                infoLogger.info("Failed element (EP): " 
                    + StringProvider.toIvmlString(constraint.getConsSyntax())); 
            } else {
                infoLogger.info("Failed element (EP): " 
                    + StringProvider.toIvmlString(msg.getConflicts().get(i)));                
            }
            infoLogger.info("Failed elements label (CT): " + msg.getConflictLabels().get(i));
            infoLogger.info("Failed elements comment: " + msg.getConflictComments().get(i));
            infoLogger.info("Failed elements project: " + msg.getConflictProjects().get(i).getName());
            infoLogger.info("Failed elements suggestion: " + msg.getConflictSuggestions().get(i));
            infoLogger.info("Failed elements variables: " + msg.getProblemVariables().get(i));
            infoLogger.info("Failed elements problem constraint parts: " 
                + StringProvider.toIvmlString(msg.getProblemConstraintParts().get(i)));
            infoLogger.info("Failed elements constraint variable: " 
                + msg.getNamedConstraintVariables().get(i));            
        }
    }   
  
}
