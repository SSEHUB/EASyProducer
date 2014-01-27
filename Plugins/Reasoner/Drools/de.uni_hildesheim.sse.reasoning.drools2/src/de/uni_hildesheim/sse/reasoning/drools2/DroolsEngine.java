package de.uni_hildesheim.sse.reasoning.drools2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.Resource;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;

import de.uni_hildesheim.sse.model.varModel.ModelElement;
import de.uni_hildesheim.sse.persistency.StringProvider;
import de.uni_hildesheim.sse.reasoning.core.model.ReasonerModel;
import de.uni_hildesheim.sse.reasoning.core.model.ReasoningOperation;
import de.uni_hildesheim.sse.reasoning.core.model.ReasoningState;
import de.uni_hildesheim.sse.reasoning.core.model.variables.CompoundVariable;
import de.uni_hildesheim.sse.reasoning.core.model.variables.ReasonerVariable;
import de.uni_hildesheim.sse.reasoning.core.reasoner.Message;
import de.uni_hildesheim.sse.reasoning.core.reasoner.ReasoningResult;
import de.uni_hildesheim.sse.reasoning.drools2.functions.FactUpdater;
import de.uni_hildesheim.sse.reasoning.drools2.functions.FailedElements;
import de.uni_hildesheim.sse.reasoning.drools2.functions.FailedRules;
import de.uni_hildesheim.sse.reasoning.drools2.translation.ModelTranslator;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory.EASyLogger;
import de.uni_hildesheim.sse.utils.messages.Status;
import de.uni_hildesheim.sse.utils.progress.ProgressObserver;

/**
 * Drools reasoning instance for performing one reasoning step.
 * @author El-Sharkawy
 * @author Sizonenko
 */
public class DroolsEngine {
    
    private static final String VIOLATED_CONSTRAINTS = "Constraints not satisfied";
    
    private static final EASyLogger LOGGER
        = EASyLoggerFactory.INSTANCE.getLogger(DroolsEngine.class, DroolsReasonerDescriptor.BUNDLE_NAME);
    
    private KnowledgeBase knowledgeBase;        
    private StatefulKnowledgeSession session;
    private KnowledgeBuilder knowledgeBuilder;
    
    // Elements used for translation
    private Writer translationWriter;
    private File tmpDRLFile;
    private ModelTranslator translator;
    
    // The result of the reasoning
    private ReasoningResult result;
    // Reasoning operation - validation or propagation
    //private ReasoningOperation operation;
    
    /**
     * Exceptions caught {@link Exception#getMessage()} during the creation of the {@link ModelTranslator}.
     */
    private StringBuffer caughtExceptions;
    
    private ReasonerModel rModel;
    
    /**
     * The ID of the current reasoning task for failed rules.
     */
    private String reasoningID;
    
    private List<ModelElement> failedModelElements;
    
    /**
     * Constructor for the Drools Reasoner that initializes the Knowledge Base and fills the content of drl file.
     * @param model The translated variability model, which should be used for reasoning.
     * @param operation The desired kind of reasoning.
     * @param observer An optional progress observer, shall be {@link ProgressObserver#NO_OBSERVER} if unused
     */
    public DroolsEngine(ReasonerModel model, ReasoningOperation operation, ProgressObserver observer) {
        this.rModel = model;
        this.caughtExceptions = new StringBuffer();
        this.result = new ReasoningResult();        
        this.reasoningID = FailedRules.createNewList(rModel.getProject().getName());
        //this.operation = operation;
        
        try {
            tmpDRLFile = File.createTempFile("reasoning_spez_for_"
                + model.getProject().getName(), ".drl");
            tmpDRLFile.deleteOnExit();
            translationWriter = new DroolsWriter(new FileWriter(tmpDRLFile));
        } catch (IOException exc) {
            LOGGER.exception(exc);
            caughtExceptions.append(exc.getMessage());
        }
        
        translator = null;
        if (null != translationWriter) {
            translator = new ModelTranslator(model, translationWriter, reasoningID, operation);
            try {
                translationWriter.flush();
            } catch (IOException exc) {
                LOGGER.exception(exc);
                caughtExceptions.append(exc.getMessage());
            }
            try {
                translationWriter.close();
            } catch (IOException exc) {
                LOGGER.exception(exc);
                caughtExceptions.append(exc.getMessage());
            }
            LOGGER.debug(translationWriter.toString());
        }
        System.out.println("Create KB: " + System.currentTimeMillis());
        // Get the KnowledgeSession
        knowledgeBase = createKnowledgeBase(); 
        session = knowledgeBase.newStatefulKnowledgeSession();
        FactUpdater updater = new FactUpdater(session);
        model.setModelListener(updater);
        // Get variables to reason on
        fillKnowledgeBase();  
    }

    /**
     * Method for filling knowledgeBase with {@link ReasonerVariable} from {@link ReasonerModel}.
     */
    private void fillKnowledgeBase() {
        Set<ReasonerVariable> variables = rModel.getVariablesUsedInConstraints();        
        Iterator<ReasonerVariable> iterator = variables.iterator();
        System.out.println("Insert FactSet: " + System.currentTimeMillis());
        while (iterator.hasNext()) {
            ReasonerVariable rVariable = iterator.next();
            session.insert(rVariable);
        }
    }
    
    /**
     * Method for initializing Drools KnowledgeBase.
     * @return KnowledgeBase that can be used in reasoning.
     */
    private KnowledgeBase createKnowledgeBase() {
        knowledgeBuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        Resource res = ResourceFactory.newFileResource(tmpDRLFile);
        knowledgeBuilder.add(res, ResourceType.DRL);
        if ( knowledgeBuilder.hasErrors() ) {
            LOGGER.error(knowledgeBuilder.getErrors().toString());
            List<ModelElement> conflictingElements = new ArrayList<ModelElement>();
            conflictingElements.add(rModel.getProject());
            Message errorMsg = new Message("Unable to translate Project:\n" + knowledgeBuilder.getErrors().toString(),
                conflictingElements, Status.ERROR);
            result.addMessage(errorMsg);
        }
        KnowledgeBase knowledgeBase = KnowledgeBaseFactory.newKnowledgeBase();
        knowledgeBase.addKnowledgePackages(knowledgeBuilder.getKnowledgePackages());  
        return knowledgeBase;  
    }

    /**
     * Reasonings over the given {@link ReasonerModel} model and checks whether the model is valid.
     * 
     * @return The result of this reasoning step.
     */
    public ReasoningResult reason() {
        
        if (null != translator && !result.hasConflict()) {
            if (translator.getExceptionCount() == 0) {
                System.out.println("Fire rules: " + System.currentTimeMillis());
                session.fireAllRules();
                session.dispose();
                System.out.println("Create result: " + System.currentTimeMillis());
                FailedElements failedElements = FailedRules.getFailedRuleList(reasoningID);
                failedModelElements = null;
                if (failedElements.hasErrors()) {
                    if (failedElements.failedConstraintCount() > 0) {
                        failedModelElements = new ArrayList<ModelElement>(failedElements.failedConstraintCount());
                        Iterator<Integer> failedRules = failedElements.getFailedRules();
                        while (failedRules.hasNext()) {
                            int failedRuleNo = failedRules.next();
                            failedModelElements.add(rModel.getConflictingElement(failedRuleNo));
                            LOGGER.debug("Failed rule nr: " + failedRuleNo + " : " 
                                + StringProvider.toIvmlString(rModel.getConstraint(failedRuleNo)));
                        }
                        result.addMessage(new Message(VIOLATED_CONSTRAINTS, failedModelElements, Status.ERROR));
                    }
                    if (failedElements.failedRulesInCompoundsCount() > 0) {
                        Map<String, Set<Integer>> failedRulesInCmps = failedElements.getFailedRulesInCompounds();
                        Set<String> failedCmpsNames = failedElements.getFailedCompoundsNames();
                        for (String cmpName : failedCmpsNames) {
                            failedModelElements = new ArrayList<ModelElement>();
                            LOGGER.debug("Compound Variables with failed rules: " + cmpName);
                            CompoundVariable cmpVar = (CompoundVariable) rModel.getVariable(cmpName);
                            Set<Integer> failedRules = failedRulesInCmps.get(cmpName);
                            for (Integer failedRule : failedRules) {
                                LOGGER.debug(StringProvider.toIvmlString(
                                    cmpVar.getType().getConflictingConstrain(failedRule)));
                                failedModelElements.add(cmpVar.getType().getConflictingConstrain(failedRule));
                            }
                            result.addMessage(new Message("Constraints in compound " 
                                + cmpName + " not satisfied", failedModelElements, Status.ERROR));
                        }
                    }                    
                }
                if (rModel.getVariablesUsedInConstraints().size() > 0) {                    
                    variableAssignmentResult();
                }
            } else {
                StringBuffer errorMsg = new StringBuffer();
                errorMsg.append("Model could not be translated, because:\n");
                for (int i = 0; i < translator.getExceptionCount(); i++) {
                    errorMsg.append("\n");
                    errorMsg.append(translator.getException(i).getMessage());
                }
                result.addMessage(new Message(errorMsg.toString(), new ArrayList<ModelElement>(), Status.ERROR));
            }
        } else {
            result.addMessage(new Message(caughtExceptions.toString(), new ArrayList<ModelElement>(), Status.ERROR));
        }
        System.out.println("Finish: " + System.currentTimeMillis());
        return result;
    }

    /**
     * Method to get the result of value assignment.
     * Compounds, sets and sequences inside compounds are not supported.
     */
    private void variableAssignmentResult() {
        failedModelElements = new ArrayList<ModelElement>();
        int conflict = 0;
        for (ReasonerVariable reasonerVariable : rModel.getVariablesUsedInConstraints()) {
            if (reasonerVariable.getDecisionVariable().getClass().getSimpleName().equals("CompoundVariable")) {
                CompoundVariable cmpVar = (CompoundVariable) reasonerVariable;
                Iterator<ReasonerVariable> varIterator = cmpVar.iterator();
                while (varIterator.hasNext()) {
                    ReasonerVariable nestedVariable = varIterator.next();
                    if (nestedVariable.getReasoningState() == ReasoningState.CONFLICT) {
                        conflict++;
                        LOGGER.debug("Conflicting variables: " 
                            + nestedVariable.getDecisionVariable().getDeclaration());
                        failedModelElements.add(nestedVariable.getDecisionVariable().getDeclaration());
                    }
                }        
            } else if (!reasonerVariable.getDecisionVariable().getClass().getSimpleName().equals("SetVariable")
                || !reasonerVariable.getDecisionVariable().getClass().getSimpleName().equals("SequenceVariable")) {
                if (reasonerVariable.getReasoningState() == ReasoningState.CONFLICT) {
                    conflict++;
                    LOGGER.debug("Conflicting variables: " 
                        + reasonerVariable.getDecisionVariable().getDeclaration());
                    failedModelElements.add(reasonerVariable.getDecisionVariable().getDeclaration());
                }
            }
        }
        if (conflict > 0) {
            result.addMessage(new Message("Conflicting variables", failedModelElements, Status.ERROR));
        } else {
            for (ReasonerVariable reasonerVariable : rModel.getVariablesUsedInConstraints()) {
                if (reasonerVariable.getDecisionVariable().getClass().getSimpleName().equals("CompoundVariable")) {
                    CompoundVariable cmpVar = (CompoundVariable) reasonerVariable;
                    Iterator<ReasonerVariable> varIterator = cmpVar.iterator();
                    while (varIterator.hasNext()) {
                        ReasonerVariable nestedVariable = varIterator.next();
                        if (nestedVariable.valueAssignedByReasoner()) {
                            nestedVariable.propagate();
                            LOGGER.debug(nestedVariable.getName().toString() + " : "
                                + nestedVariable.getReasoningState().toString() + " : "
                                + nestedVariable.getValue());
                        }
                    }        
                } else if (!reasonerVariable.getDecisionVariable().getClass().getSimpleName().equals("SetVariable")
                    || !reasonerVariable.getDecisionVariable().getClass().getSimpleName().equals("SequenceVariable")) {
                    if (reasonerVariable.valueAssignedByReasoner()) {
                        reasonerVariable.propagate();
                        LOGGER.debug(reasonerVariable.getName().toString() + " : "
                            + reasonerVariable.getReasoningState().toString() + " : "
                            + reasonerVariable.getValue());
                    }
                }
            }
        }
    }
    
    @Override
    public void finalize() throws Throwable {
        try {
            super.finalize();
        } finally {
            if (tmpDRLFile.exists()) {
                tmpDRLFile.delete();
            }
        }
    }
}
