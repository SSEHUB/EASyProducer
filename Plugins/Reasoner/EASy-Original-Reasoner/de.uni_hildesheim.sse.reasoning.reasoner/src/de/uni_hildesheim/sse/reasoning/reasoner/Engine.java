package de.uni_hildesheim.sse.reasoning.reasoner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import de.uni_hildesheim.sse.model.confModel.Configuration;
import de.uni_hildesheim.sse.model.confModel.DisplayNameProvider;
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
import de.uni_hildesheim.sse.reasoning.reasoner.functions.FailedElements;
import de.uni_hildesheim.sse.reasoning.reasoner.functions.FailedRules;
import de.uni_hildesheim.sse.reasoning.reasoner.model.VariablesInConstraintsFinder;
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
    private List<Set<AbstractVariable>> constraintVariables;
    private List<String> failedElementComments;
    private List<Project> failedElementProjects;
    private List<String> failedElementSuggestions;  
    private IAdditionalInformationLogger infoLogger;
    
    private Map<Constraint, AbstractVariable> constraintVariableMap;
    
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
        FailedRules.createNewList(reasoningID);
        this.resolver = new Resolver(project, cfg, reasoningID);
        this.resolver.setIncremental(reasonerConfig.reasonIncrementally());
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
        FailedElements failedElements = FailedRules.getFailedElements(reasoningID);
        if (failedElements.hasErrors()) {
            constraintVariableMap = resolver.getConstraintVariableMap();
            analyzeFailedConstraints(failedElements);
            analyzeFailedVariables(failedElements);
        } 
        FailedRules.clearResults(reasoningID); 
//        PerformanceStatistics.addTimestamp(reasoningID);
//        PerformanceStatistics.getStats(reasoningID);   
//        PerformanceStatistics.clearReasoningID(reasoningID);
        infoLogger.info("Model: " + project.getName());
        infoLogger.info("Number of variables: " + resolver.variableCount());
        infoLogger.info("Number of constraints: " + resolver.constraintCount());
        infoLogger.info("Number of reevaluations: " + resolver.reevaluationCount());
        infoLogger.info("Number of failed constraints: " + failedConstraints);
        infoLogger.info("Number of assignments: " + failedAssignments);
        infoLogger.info("Evaluation time: " + (System.currentTimeMillis() - startTime));
        return result;        
    }
    
    /**
     * Method for analyzing failed elements and creating error messages.
     * @param failedElements All failed elements from the reasoner.
     */
    private void analyzeFailedConstraints(FailedElements failedElements) {
        if (failedElements.failedConstraintCount() > 0) {
            Iterator<Constraint> failedConstraints = failedElements.getFailedConstraints();
            initFailedLists();
            String comment = null;
            Project project = null;
            String suggestion = null;
            while (failedConstraints.hasNext()) {
                this.failedConstraints++;
                Constraint failedRule = failedConstraints.next();
                if (failedRule.getTopLevelParent() instanceof Project) {
                    project = (Project) failedRule.getTopLevelParent();                    
                }
                failedModelElements.add(failedRule);
                String msgText = null;
                if (constraintVariableMap.get(failedRule) != null) {
                    if (constraintVariableMap.get(failedRule).getComment() == null) {
                        msgText = constraintVariableMap.get(failedRule).getName();  
                    } else {
                        msgText = constraintVariableMap.get(failedRule).getComment();
//                            + " (" + traceToTop(constraintVariableMap.get(failedRule)) + " )";
                    } 
                } else {
                    msgText = StringProvider.toIvmlString(failedRule.getConsSyntax());
                }
                comment = msgText;
                VariablesInConstraintsFinder finder = new VariablesInConstraintsFinder(failedRule.getConsSyntax());
                String problemPoints = "";
                java.util.Set<AbstractVariable> vars = finder.getVariables();
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
                constraintVariables.add(vars);
                failedElementLabels.add(msgText);
                failedElementComments.add(comment);
                failedElementProjects.add(project);
                failedElementSuggestions.add(suggestion);
                if (Descriptor.LOGGING) {
                    infoLogger.info("Failed constraint(EP): " 
                        + StringProvider.toIvmlString(failedRule.getConsSyntax()));                    
                    infoLogger.info("Failed constraint label(CT): " + msgText);                    
                    infoLogger.info("Comment: " +  comment + "; Project: " + project.getName() 
                        + "; Suggestion: " + suggestion);                    
                }
            }        
            result.addMessage(createMessage(VIOLATED_CONSTRAINTS));          
            nullFailedLists();
        }        
    }
    /**
     * Method for analyzing failed elements and creating error messages.
     * @param failedElements All failed elements from the reasoner.
     */
    private void analyzeFailedVariables(FailedElements failedElements) {       
        if (failedElements.failedVariablesCount() > 0) {
            Iterator<AbstractVariable> failedVariables = failedElements.getFailedVariables();
            initFailedLists(); 
            Project project = null;
            while (failedVariables.hasNext()) {
                this.failedAssignments++;
                AbstractVariable failedVariable = failedVariables.next();
                if (failedVariable.getTopLevelParent() instanceof Project) {
                    project = (Project) failedVariable.getTopLevelParent();                    
                }
                failedModelElements.add(failedVariable);
                String msgText = DisplayNameProvider.getInstance().getDisplayName(failedVariable) 
                    + " (" + traceToTop(failedVariable) + " )";
                failedElementLabels.add(msgText);
                failedElementComments.add(msgText);
                failedElementProjects.add(project);
                failedElementSuggestions.add("Check for variable reassignments in the same Project scope");
                if (Descriptor.LOGGING) {
                    infoLogger.info("Failed variable (EP): " + failedVariable.toString());                    
                    infoLogger.info("Failed variable label (CT): " + msgText);
                    infoLogger.info("Comment: " +  msgText + "; Project: " + project.getName() 
                        + "; Suggestion: " 
                        + "Check for variable reassignments in the same Project scope");                    
                }
                Set<AbstractVariable> vars = new HashSet<AbstractVariable>();
                vars.add(failedVariable);
                if (Descriptor.LOGGING) {
                    printInvolvedVariables(vars);                    
                }
                constraintVariables.add(vars);
            } 
            result.addMessage(createMessage(VIOLATED_VARIABLES));
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
        constraintVariables = new ArrayList<Set<AbstractVariable>>();
        failedElementComments = new ArrayList<String>();
        failedElementProjects = new ArrayList<Project>();
        failedElementSuggestions = new ArrayList<String>();
    }
    
    /**
     * Method for nulling lists of failed elements.
     */
    private void nullFailedLists() {
        failedModelElements = null;
        failedElementLabels = null;
        constraintVariables = null;
        failedElementComments = null;
        failedElementProjects = null;
        failedElementSuggestions = null;
    }
    
    /**
     * Method for creating custom message fields.
     * @param text Text for the message.
     * @return Created message.
     */
    private Message createMessage(String text) {
        Message msg = new Message(text, failedModelElements, Status.ERROR);
        msg.addConflictingElementLabels(failedElementLabels);
        msg.addConstraintVariables(constraintVariables);
        msg.addConflictingElementComments(failedElementComments);
        msg.addConflictingElementProjects(failedElementProjects);
        msg.addConflictingElementSuggestions(failedElementSuggestions);   
        return msg;
    }
    
    /**
     * Method for printing out involved variables.
     * @param variables Set of variables.
     */
    private void printInvolvedVariables(Set<AbstractVariable> variables) {
        infoLogger.info("Involved variables: ");
        for (AbstractVariable abstractVariable : variables) {
            infoLogger.info(abstractVariable.getName() + " ");
        }
        infoLogger.info("");
    }
}
