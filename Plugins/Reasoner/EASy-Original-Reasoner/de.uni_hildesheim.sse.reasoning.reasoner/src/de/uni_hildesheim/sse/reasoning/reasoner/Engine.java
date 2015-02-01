package de.uni_hildesheim.sse.reasoning.reasoner;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
    
    private static final String VIOLATED_CONSTRAINTS = "Constraints not satisfied";
    private static final String VIOLATED_VARIABLES = "Error in assignments";
    
    private static final EASyLogger LOGGER
        = EASyLoggerFactory.INSTANCE.getLogger(Engine.class, Descriptor.BUNDLE_NAME);
    
    private String reasoningID;
    
    private Resolver resolver;
    
    private ReasoningResult result;
    
    private List<ModelElement> failedModelElements;
    private List<String> failedElementLabels;
    
    private Configuration config;
    
    private boolean customMessages;
    
    private Map<Constraint, AbstractVariable> constraintVariableMap;
    
    private long startTime = System.currentTimeMillis();
    
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
        this.reasoningID = PerformanceStatistics.createReasoningID(project.getName(), "Model validation");
        FailedRules.createNewList(reasoningID);
        this.config = cfg;
        this.resolver = new Resolver(project, cfg, reasoningID);
        this.result = new ReasoningResult();
        this.customMessages = reasonerConfig.getCustomMessages();
    }
    /**
     * Method for lunching reasoning.     * 
     * @return {@link ReasoningResult} failed constraints and assignments, if exist.
     */
    public ReasoningResult reason() {
        resolver.resolve();
        FailedElements failedElements = FailedRules.getFailedElements(reasoningID);
        if (failedElements.hasErrors()) {
            constraintVariableMap = resolver.getConstraintVariableMap();
            analyzeFailedElements(failedElements);
        } 
        FailedRules.clearResults(reasoningID);        
        System.out.println("Number of constraints: " + resolver.constraintCount());
        System.out.println("Number of variables: " + resolver.variableCount());
        System.out.println("Evaluation time: " + (System.currentTimeMillis() - startTime));
        return result;        
    }
    
    /**
     * Method for analyzing failed elements and creating error messages.
     * @param failedElements All failed elements from the reasoner.
     */
    private void analyzeFailedElements(FailedElements failedElements) {
        if (failedElements.failedConstraintCount() > 0) {
            Iterator<Constraint> failedConstraints = failedElements.getFailedConstraints();
            failedModelElements = new ArrayList<ModelElement>(failedElements.failedConstraintCount());
            failedElementLabels = new ArrayList<String>(failedElements.failedConstraintCount());
            while (failedConstraints.hasNext()) {
                Constraint failedRule = failedConstraints.next();
                failedModelElements.add(failedRule);
                System.out.println("Failed constraint (EASy): " 
                    + StringProvider.toIvmlString(failedRule.getConsSyntax()));
                String msgText = null;
                if (constraintVariableMap.get(failedRule) != null) {
                    if (constraintVariableMap.get(failedRule).getComment() == null) {
                        msgText = constraintVariableMap.get(failedRule).getName();  
                    } else {
                        msgText = constraintVariableMap.get(failedRule).getComment()
                            + " (" + traceToTop(constraintVariableMap.get(failedRule)) + " )";
                    } 
                } else {
                    msgText = StringProvider.toIvmlString(failedRule.getConsSyntax());
                }
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
                    problemPoints = problemPoints + "\"" + DisplayNameProvider.getInstance().getDisplayName(variable) 
                        + "\" in " + DisplayNameProvider.getInstance().getParentNames(variable);
                    count++;
                }
                if (problemPoints.length() > 0) {
                    problemPoints = " Please check: " + problemPoints;
                }
                msgText = msgText + problemPoints;
                failedElementLabels.add(msgText);
                System.out.println("Failed constraint label (ConfigTool): " + msgText);
            }
            Message msg = new Message(VIOLATED_CONSTRAINTS, failedModelElements, Status.ERROR);
            msg.addConflictingElementLabels(failedElementLabels);
            result.addMessage(msg);
            failedModelElements = null;
            failedElementLabels = null;
        } 
        if (failedElements.failedVariablesCount() > 0) {
            Iterator<AbstractVariable> failedVariables = failedElements.getFailedVariables();
            failedModelElements = new ArrayList<ModelElement>(failedElements.failedVariablesCount());
            failedElementLabels = new ArrayList<String>(failedElements.failedVariablesCount());            
            while (failedVariables.hasNext()) {
                AbstractVariable failedVariable = failedVariables.next();
                failedModelElements.add(failedVariable);
                System.out.println("Failed variable (EASy): " + failedVariable.toString());
                String msgText = DisplayNameProvider.getInstance().getDisplayName(failedVariable) 
                    + " (" + traceToTop(failedVariable) + " )";
                failedElementLabels.add(msgText);
                System.out.println("Failed variable label (ConfigTool): " + msgText);
            }          
            Message msg = new Message(VIOLATED_CONSTRAINTS, failedModelElements, Status.ERROR);
            msg.addConflictingElementLabels(failedElementLabels);
            result.addMessage(msg);
            failedModelElements = null;
            failedElementLabels = null;
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
    
//    /**
//     * Method for analyzing failed elements and creating error messages.
//     * @param failedElements All failed elements from the reasoner.
//     */
//    private void analyzeFailedElements(FailedElements failedElements) {
//        if (!customMessages) {
//            if (failedElements.failedConstraintCount() > 0) {
//                failedModelElements = new ArrayList<ModelElement>(failedElements.failedConstraintCount());
//                Iterator<Constraint> failedConstraints = failedElements.getFailedConstraints();
//                while (failedConstraints.hasNext()) {
//                    Constraint failedRule = failedConstraints.next();
//                    failedModelElements.add(failedRule);
//                    System.out.println("Failed constraint: " 
//                        + StringProvider.toIvmlString(failedRule.getConsSyntax()));
//                }
//                result.addMessage(new Message(VIOLATED_CONSTRAINTS, failedModelElements, Status.ERROR));
//                failedModelElements = null;
//            } 
//            if (failedElements.failedVariablesCount() > 0) {
//                failedModelElements = new ArrayList<ModelElement>(failedElements.failedVariablesCount());
//                Iterator<AbstractVariable> failedVariables = failedElements.getFailedVariables();
//                while (failedVariables.hasNext()) {
//                    AbstractVariable failedVariable = failedVariables.next();
//                    failedModelElements.add(failedVariable);
//                    System.out.println("Failed variable: " + failedVariable.toString());
//                }            
//                result.addMessage(new Message(VIOLATED_VARIABLES, failedModelElements, Status.ERROR));
//                failedModelElements = null;
//            }        
//        } else {
//            if (failedElements.failedConstraintCount() > 0) {
//                failedElementLabels = new ArrayList<String>(failedElements.failedConstraintCount());
//                Iterator<Constraint> failedConstraints = failedElements.getFailedConstraints();
//                while (failedConstraints.hasNext()) {
//                    String msgText = null;
//                    Constraint failedRule = failedConstraints.next();
//                    if (constraintVariableMap.get(failedRule) != null) {
//                        if (constraintVariableMap.get(failedRule).getComment() == null) {
//                            msgText = constraintVariableMap.get(failedRule).getName();  
//                        } else {
//                            msgText = constraintVariableMap.get(failedRule).getName() + " : " 
//                                + constraintVariableMap.get(failedRule).getComment();
//                        } 
//                    } else {
//                        msgText = StringProvider.toIvmlString(failedRule.getConsSyntax());
//                    }
//                    failedElementLabels.add(msgText);
//                    System.out.println("Failed constraint: " + msgText);
//                }
//                Message msg = new Message(VIOLATED_CONSTRAINTS, null, Status.ERROR);
//                msg.addConflictingElementLabels(failedElementLabels);
//                result.addMessage(msg);
//                failedElementLabels = null;
//            } 
//            if (failedElements.failedVariablesCount() > 0) {
//                failedElementLabels = new ArrayList<String>(failedElements.failedVariablesCount());
//                Iterator<AbstractVariable> failedVariables = failedElements.getFailedVariables();
//                while (failedVariables.hasNext()) {
//                    AbstractVariable failedVariable = failedVariables.next();
//                    failedElementLabels.add(failedVariable.getName());
//                    System.out.println("Failed variable: " + failedVariable.getName());
//                }            
//                Message msg = new Message(VIOLATED_CONSTRAINTS, null, Status.ERROR);
//                msg.addConflictingElementLabels(failedElementLabels);
//                result.addMessage(msg);
//                failedElementLabels = null;
//            }          
//        }   
//    }

}
