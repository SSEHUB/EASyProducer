package net.ssehub.easy.reasoning.drools2;

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

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.basics.messages.Status;
import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.reasoning.core.model.ReasonerModel;
import net.ssehub.easy.reasoning.core.model.ReasoningOperation;
import net.ssehub.easy.reasoning.core.model.ReasoningState;
import net.ssehub.easy.reasoning.core.model.variables.CompoundVariable;
import net.ssehub.easy.reasoning.core.model.variables.ReasonerVariable;
import net.ssehub.easy.reasoning.core.reasoner.Message;
import net.ssehub.easy.reasoning.core.reasoner.ReasoningResult;
import net.ssehub.easy.reasoning.drools2.functions.FactUpdater;
import net.ssehub.easy.reasoning.drools2.functions.FailedElements;
import net.ssehub.easy.reasoning.drools2.functions.FailedRules;
import net.ssehub.easy.reasoning.drools2.translation.ModelTranslator;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.model.ModelElement;
import net.ssehub.easy.varModel.persistency.StringProvider;

/**
 * Drools reasoning instance for performing one reasoning step. Check for Stats.
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
        this.reasoningID = rModel.getReasoningID();
        /*** From ReasonerModel ***/
        /*** Finish RM creation ***/
//        Statistic.addTimestamp(reasoningID, System.currentTimeMillis());
        /*** Start constraint translation to rules ***/
        FailedRules.createNewList(reasoningID);
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
        /*** Finish constraint translation to rules ***/
//        Statistic.addTimestamp(reasoningID, System.currentTimeMillis());
        /*** Start KB creation ***/
        knowledgeBase = createKnowledgeBase(); 
//        Statistic.addTimestamp(reasoningID, System.currentTimeMillis());
        session = knowledgeBase.newStatefulKnowledgeSession();
//        Statistic.addTimestamp(reasoningID, System.currentTimeMillis());
        FactUpdater updater = new FactUpdater(session);
//        Statistic.addTimestamp(reasoningID, System.currentTimeMillis());
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
        /*** Finish KB creation ***/
//        Statistic.addTimestamp(reasoningID, System.currentTimeMillis());
        /*** Start Fact update ***/
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
//        Statistic.addTimestamp(reasoningID, System.currentTimeMillis());
        knowledgeBuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
//        Statistic.addTimestamp(reasoningID, System.currentTimeMillis());
        Resource res = ResourceFactory.newFileResource(tmpDRLFile);
//        Statistic.addTimestamp(reasoningID, System.currentTimeMillis());
        knowledgeBuilder.add(res, ResourceType.DRL);
//        Statistic.addTimestamp(reasoningID, System.currentTimeMillis());
        if ( knowledgeBuilder.hasErrors() ) {
            LOGGER.error(knowledgeBuilder.getErrors().toString());
            List<ModelElement> conflictingElements = new ArrayList<ModelElement>();
            conflictingElements.add(rModel.getProject());
            Message errorMsg = new Message("Unable to translate Project:\n" + knowledgeBuilder.getErrors().toString(),
                conflictingElements, Status.ERROR);
            result.addMessage(errorMsg);
        }
//        Statistic.addTimestamp(reasoningID, System.currentTimeMillis());
        KnowledgeBase knowledgeBase = KnowledgeBaseFactory.newKnowledgeBase();
//        Statistic.addTimestamp(reasoningID, System.currentTimeMillis());
        knowledgeBase.addKnowledgePackages(knowledgeBuilder.getKnowledgePackages());
//        Statistic.addTimestamp(reasoningID, System.currentTimeMillis());
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
                /*** Finish Fact update ***/                
//                Statistic.addTimestamp(reasoningID, System.currentTimeMillis());
                /*** Start Drools reasoning ***/
                session.fireAllRules();
                session.dispose();
                /*** Finish Drools reasoning ***/
//                Statistic.addTimestamp(reasoningID, System.currentTimeMillis());
                /*** Start result creation ***/
                FailedElements failedElements = FailedRules.getFailedRuleList(reasoningID);
                failedModelElements = null;
                if (failedElements.hasErrors()) {
                    validationFailed(failedElements);                    
                } else if (rModel.getVariablesUsedInConstraints().size() > 0) {                    
                    validationSuccessful();
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
        /*** Finish result creation ***/
//        Statistic.addTimestamp(reasoningID, System.currentTimeMillis());
        /*** Finish measurement ***/
//        PerformanceStatistics.getStats(reasoningID);   
//        PerformanceStatistics.clearReasoningID(reasoningID);
        /*** ***/
        for (IDecisionVariable variable : rModel.getConfiguration()) {
            System.out.println(variable.getDeclaration() 
                    + " : "
                    + variable.getState().toString()
                    + " : " 
                    + variable.getValue());
        }        
    
        return result;
    }

    /**
     * End of Reasoning: this method will be executed if the reasoner detected violated constraints.
     * @param failedElements All failed constraints.
     */
    private void validationFailed(FailedElements failedElements) {
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

    /**
     * End of Reasoning: this method will be executed if the reasoner has not detected any violated constraints.
     */
    private void validationSuccessful() {
        variableAssignmentResult();
        int nPropagatedVariables = rModel.getCountPropagatedVariables();
        if (nPropagatedVariables > 0) {
            List<ModelElement> propagatedVariables = new ArrayList<ModelElement>();
            for (int i = 0; i < nPropagatedVariables; i++) {
                propagatedVariables.add(rModel.getPropagatedVariable(i).getDeclaration());
            }
            result.addMessage(new Message("Values have been propagated", propagatedVariables, Status.INFO));
        }
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
