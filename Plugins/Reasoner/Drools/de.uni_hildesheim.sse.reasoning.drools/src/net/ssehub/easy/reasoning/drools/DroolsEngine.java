package net.ssehub.easy.reasoning.drools;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.definition.type.FactField;
import org.drools.definition.type.FactType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.basics.messages.Status;
import net.ssehub.easy.basics.progress.ObservableTask;
import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.reasoning.core.reasoner.AttributesCheckVisitor;
import net.ssehub.easy.reasoning.core.reasoner.Message;
import net.ssehub.easy.reasoning.core.reasoner.ReasonerConfiguration;
import net.ssehub.easy.reasoning.core.reasoner.ReasoningResult;
import net.ssehub.easy.varModel.confModel.AllFreezeSelector;
import net.ssehub.easy.varModel.confModel.AssignmentState;
import net.ssehub.easy.varModel.confModel.CompoundVariable;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.confModel.ConfigurationException;
import net.ssehub.easy.varModel.confModel.ContainerVariable;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;
import net.ssehub.easy.varModel.cst.Variable;
import net.ssehub.easy.varModel.model.Attribute;
import net.ssehub.easy.varModel.model.AttributeAssignment;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.IModelVisitor;
import net.ssehub.easy.varModel.model.ModelElement;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.ProjectImport;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.Container;
import net.ssehub.easy.varModel.model.datatypes.Enum;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.OclKeyWords;
import net.ssehub.easy.varModel.model.datatypes.OrderedEnum;
import net.ssehub.easy.varModel.model.datatypes.Reference;
import net.ssehub.easy.varModel.model.datatypes.Sequence;
import net.ssehub.easy.varModel.model.datatypes.Set;
import net.ssehub.easy.varModel.model.values.CompoundValue;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;

/**
 * The drools engine class responsible for checking consistency, and value propagation.
 * @author Phani
 *
 */
public class DroolsEngine {
    
    private EASyLogger logger = EASyLoggerFactory.INSTANCE.getLogger(this.getClass(), Activator.BUNDLE_ID);
    
    /**
     * Optimization Case Nr. : 
     * Case 0 : all the variables are passed for reasoning
     * Case 1 : only variables that have constraints are passed. Note : this allows the type definitions, which are 
     *          treated as internal constraints, are also passed.
     * Case 2 : only the variables that have constraints are passed. Note : type definitions, or the internal
     *          constraints are not passed.          
     */
    private static OptimizationType optimizationType = OptimizationType.ADVANCED;
    

    private static List<String> assignedVariables = new ArrayList<String>();
    private boolean abortReasoning = false;

    private Map<String, Boolean> hasConstraint = new HashMap<String, Boolean>();
    private ConstraintChecker cChecker = null;
    private List<Constraint> constraintList = new ArrayList<Constraint>();
    private Map<String, IDecisionVariable> decisions = new HashMap<String, IDecisionVariable>();
    private DroolsVisitor droolsVisitor;
    private List<Integer> cList = new ArrayList<Integer>();
    private List<String> aList = new ArrayList<String>();
    private List<Message> messageList = new ArrayList<Message>();
    
    /**
     * Map with rule number as key and the value as the relevant model element. 
     */
    private Map<Integer, ModelElement> ruleMapper = new HashMap<Integer, ModelElement>();
    private int key = 1;
    
    /**
     * Drools knowledge session.
     */
    private StatefulKnowledgeSession ksession = null;
    private boolean propagate = false;
    private String pckg = "";
    
    /**
     * Configuration.
     */
    private Configuration config = null;
    
    /**
     * Map with decision variable names and decision variables.
     */
    private Map<String, IDecisionVariable> decisionsMap = new HashMap<String, IDecisionVariable>();
    
    /**
     * Map with decision variable names and their datatypes.
     */
    private Map<String, IDatatype> varMap = null;
    
    /**
     * List contains variables names that have been assigned values through configuration, 
     */
    private List<String> dList = new ArrayList<String>();
    
    /**
     * List contains variables names that have been assigned values through value propagation, 
     */
    private List<String> vList = new ArrayList<String>();
    
    /**
     * May remove this.
     * TODO: check
     */
    private List<String> variableList = new ArrayList<String>();
    
    /**
     * List contains variable names whose values have been changed during 
     * reasoning.
     */
    
    /**
     * This list contains variable names that have been fixed during reasoning.
     */
    private List<String> fixedVariables = new ArrayList<String>();
    
    private List<ModelElement> propagatedValues = new ArrayList<ModelElement>();
    private List<ModelElement> deadDecisions = new ArrayList<ModelElement>();
    private List<String> droolsProjects = new ArrayList<String>();
 
    /**
     * These are the project instances in drools that have been inserted as project
     * facts into Drools knowledge session.
     */
    private List<Object> droolsProjectIns = new ArrayList<Object>();
    
    /**
     * Reasoning result.
     */
    private ReasoningResult reasoningResult = null;
    private String nestedCompoundAccess = "";
    private ObservableTask subTask = null;
    
 
    /**
     * Constructor for the class.
     * @param visitor Visitor.
     */
    DroolsEngine(DroolsVisitor visitor) {
        this.droolsVisitor = visitor;
        
    }
    
    /**
     * Getter for optimization type.
     * @return optimization type.
     */
    public static OptimizationType getOptimizationType() {
        return optimizationType;
    } 
    
    /**
     * Method to get the list containing names of the variables that are defined.
     * In case, of a compound access, the list would contains - decisionName + "." + slot.
     * And accordingly for multiple nested variables.
     * @return assignenedVariables.
     */
    public static List<String> getAssignedVariables() {
        return assignedVariables;
    }
    
    
    
    /**
     * Public method to identify if it is a model checking or model propagation 
     * (checking & configuration updation). For example, in case of 
     * a check operation, the flag is set to <b>False</b>.
     * @param flag Flag.
     */
    public void setPropagate(boolean flag) {
        this.propagate = flag;
    }
    
    /**
     * Getter for knowledge session.
     * @return ksession Drools KnowledgeSession.
     */
    public StatefulKnowledgeSession getKsession() {
        return ksession;
    }
    
    
    
    // checkstyle: stop exception type check 
    /**
     * This method checks if a given project is consistent with the given configuration.
     * @param project Project.
     * @param cfg Configuration.
     * @param reasonerConfig reasoner configuration.
     * @param observer Progress Observer.
     * @return Result of the reasoning process.
     */
    public ReasoningResult check(Project project, Configuration cfg, ReasonerConfiguration reasonerConfig,
            ProgressObserver observer) {
        subTask = new ObservableTask("Reasoning", 3, observer);
        long inTime = System.currentTimeMillis();
        ReasoningResult result = doTranslate(project, cfg);
        long transTime = System.currentTimeMillis();
        logger.info("Translation time " + (transTime - inTime) / 1000.0);
        subTask.notifyProgress();
        logger.info("********************************** BEGIN REASONING **********************************");
        if (!abortReasoning) {
            instantiateKnowledgeBase(project, result);
            
        } 
        // Printing the configuration after reasoning, can be deleted at a later stage. 
//        printConfig(); 
        logger.info("********************************** END REASONING **********************************");
        logger.info("Message count : " + result.getMessageCount());
        droolsVisitor.closeProject();
        stop();

        if (!propagate) {
        
            boolean attrCheck = AttributesCheckVisitor.check(cfg, reasonerConfig, result);
            logger.info("attrcCheck is " + attrCheck +  " .. " + result.hasConflict());
        }
        abortReasoning = false;
//        DroolsVariablesPreProcessor.getVariablesUsed().removeAll(DroolsVariablesPreProcessor.getVariablesUsed());
        // Call Garbage Collector to remove discarded objects
        System.gc();
        subTask.notifyEnd();
        return result;
    }

    /**
     * Perform initial steps of the translation.
     * @param project Project.
     * @param cfg Configuration.
     * @return Reasoning result.
     */
    private ReasoningResult doTranslate(Project project, Configuration cfg) {
        if (optimizationType.equals(OptimizationType.NONE)) {
            DroolsVisitor.setOptimize(false);
        } else {
            preprocessProjectElements(project);
        }
        DroolsOperations.loadOperators();
        DroolsOperations.createDroolsOperators();
        DroolsOperations.createNonSupportedOperatorsList();
        ReasoningResult result = new ReasoningResult();
        logger.info("Checking ... ");
        project.accept(droolsVisitor);
        this.config = cfg;
        preProcessConfiguration(project, result);
        //Visit project imports recursively. 
        visitInnerImports(project);
        
        java.util.Set<Map.Entry<Integer, ModelElement>> set = droolsVisitor.getRuleMapper().entrySet();
        for (Map.Entry<Integer, ModelElement> itr : set) {
            this.ruleMapper.put(itr.getKey(), itr.getValue());
        }
        //visit all project elements.
        visitProjectElements(project);
        if (DroolsVisitor.isAbortReasoning()) {
            abortReasoning = true;
        }
        cfg.accept(droolsVisitor);
        this.varMap = droolsVisitor.getVariableMap();
        return result;
    }

    /**
     * Pre-process configuration to check for reassignments of defaults.
     * @param project Project.
     * @param result Reasoning result.
     */
    private void preProcessConfiguration(Project project, ReasoningResult result) {
        Iterator<IDecisionVariable> iterator = this.config.iterator();    
        while (iterator.hasNext()) {
            IDecisionVariable dc = (IDecisionVariable) iterator.next();
            String decName = dc.getDeclaration().getName();
            if (dc.getDeclaration().getType() instanceof Compound) {
                CompoundValue cv = (CompoundValue) dc.getValue();
                Compound c = (Compound) cv.getType();
                if (cv.isFullyConfigured()) {
                    assignedVariables.add(decName);
                }
                //a compound type's def value is never null
                extractAssignedElements(decName, cv, c);
//                checkReAssignmentsOfDefaults(result, dc, decName);
            } else if (!(dc.getDeclaration() instanceof Attribute)) {
                checkReAssignmentsOfDefaults(result, dc, decName, project);
            }
            decisions.put(decName, dc);
        }
    }
    
    /**
     * Method to process declarations.
     * This is where the required optimization takes place. 
     * The aim is to use the declarations that have constraints.
     * The rest are ignored as they speed up the reasoning process.
     * @param project Project.
     */
    private void preprocessProjectElements(Project project) {
        DroolsVariablesPreProcessor processor = new DroolsVariablesPreProcessor();
        for (int i = 0; i < project.getImportsCount(); i++) { 
            ProjectImport tempProjectImport = project.getImport(i);
            preprocessProjectElements(tempProjectImport.getResolved());
        }
        
        for (int i = 0; i < project.getElementCount(); i++) {
            if (project.getElement(i) instanceof Constraint) {
                Constraint cons = (Constraint) project.getElement(i);
                cons.getConsSyntax().accept(processor);
            } 
            if (project.getElement(i) instanceof DecisionVariableDeclaration) {
                DecisionVariableDeclaration decl = (DecisionVariableDeclaration) project.getElement(i);
                if (decl.getDefaultValue() != null) {
                    ConstraintSyntaxTree call = (ConstraintSyntaxTree) decl.getDefaultValue();
                    Variable var = new Variable(decl);
                    OCLFeatureCall valueCall = new OCLFeatureCall(var, OclKeyWords.EQUALS, call);
                    valueCall.accept(processor);
                }
            }
            if (project.getElement(i) instanceof AttributeAssignment) {
                processor.visitAttributeAssignment((AttributeAssignment) project.getElement(i));  
            }
        }
        
        if (optimizationType.equals(OptimizationType.INTERMEDIATE)) {
            for (int i = 0; i < project.getInternalConstraintCount(); i++) {
                project.getInternalConstraint(i).getConsSyntax().accept(processor);
            }
            
        }
        
    }

    /**To check if the assignments have already defaults (for variables of non-compound types).
     * 
     * @param result Reasoning result.
     * @param dc Decision variable.
     * @param decName Name.
     * @param project project.
     */
    private void checkReAssignmentsOfDefaults(ReasoningResult result, IDecisionVariable dc, 
            String decName, Project project) {
        
        
        if (dc.getState().equals(AssignmentState.ASSIGNED)) {
            if ((dc.getDeclaration().getDefaultValue() != null) 
                    && (dc.getDeclaration().getParent().equals(project))) {
                abortReasoning = true;
                Message assignmentWarningMessage = new Message("Multiple assignment of defaults to a variable", 
                        null, Status.ERROR);
                result.addMessage(assignmentWarningMessage);
            } 
            assignedVariables.add(dc.getDeclaration().getName());
        } 
    }

    /**
     * Private method that determines what variables are defined, and adds to a list which is used 
     * to write rules.  
     * @param decName Name of the declaration.
     * @param cv Compound Value.
     * @param comp Compound Name.
     */
    private void extractAssignedElements(String decName, CompoundValue cv, Compound comp) {
        for (int i = 0; i < comp.getElementCount(); i++) {
            String nestedElem = comp.getElement(i).getName();
            String stringToAdd = decName + "." + nestedElem;
            if (!(cv.getNestedValue(nestedElem) instanceof CompoundValue)) {
                
                if (!(cv.getNestedValue(comp.getElement(i).getName()) == null)) {
//                    logger.info("string to add : " + stringToAdd);
                    assignedVariables.add(stringToAdd);
                } 
            } else {
                extractAssignedElements(decName + "." + comp.getElement(i), 
                        (CompoundValue) cv.getNestedValue(nestedElem), 
                        (Compound) comp.getElement(i).getType());
            }
        }
    }

    /**
     * Method that handles visiting all the project elements, including internal constraints,
     * generates unique key for each project element.
     * @param project The project to visit.
     */
    private void visitProjectElements(Project project) {
        
        long inInt = System.currentTimeMillis();
//        logger.info("project " + project.getName());
//        logger.info("total elements " + project.getElementCount());
//        logger.info("total inter " + project.getInternalConstraintCount());
        for (int i = 0; i < project.getElementCount(); i++) {
            droolsVisitor.setRuleCount(key);
            this.ruleMapper.put(new Integer(key), project.getElement(i));
            key++;
            if (project.getElement(i) instanceof DecisionVariableDeclaration) {
                DecisionVariableDeclaration decl = (DecisionVariableDeclaration) project.getElement(i);
                variableList.add(decl.getName());
            }
            if (project.getElement(i) instanceof Constraint) {
                Constraint constraint = (Constraint) project.getElement(i);
                constraintList.add(constraint);
            } 
            project.getElement(i).accept((IModelVisitor) droolsVisitor);
        }
        for (int j = 0; j < project.getInternalConstraintCount(); j++) {
            droolsVisitor.setRuleCount(key);
            this.ruleMapper.put(new Integer(key), project.getInternalConstraint(j));
            key++;
            project.getInternalConstraint(j).accept((IModelVisitor) droolsVisitor);
        }
        long outInt = System.currentTimeMillis();
        logger.info("Time to parse all elements " + (outInt - inInt) / 1000.0);
    }

    /**
     * Method to recursively visit the inner project imports.
     * @param project Resolved project.
     */
    private void visitInnerImports(Project project) {
        for (int i = 0; i < project.getImportsCount(); i++) { 
            ProjectImport tempProjectImport = project.getImport(i);
            if (tempProjectImport.getResolved().getImportsCount() != 0) {
                visitInnerImports(tempProjectImport.getResolved());
            }
            tempProjectImport.accept((IModelVisitor) droolsVisitor);   
            this.key = droolsVisitor.getRuleCount();
        }
    }

    /**
     * Method to instantiate drools knowledge base. Reasoning result are added as messages. 
     * @param project Project.
     * @param result Reasoning result.
     */
    private void instantiateKnowledgeBase(Project project, ReasoningResult result) {
        long inTime = System.currentTimeMillis();
        long loadI = System.currentTimeMillis();
        long loadO = 0;
        try {
            KnowledgeBase kbase = readKnowledgeBase(droolsVisitor.getFilePath());
            StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
            this.ksession = ksession;
            String packageName = addDroolsGlobals(ksession);
            FactType fact = kbase.getFactType(packageName, "Project");
            Object projIns = fact.newInstance();
            ksession.insert(projIns);
            droolsProjects.add("Project");
            droolsProjectIns.add(projIns);
            int nu = DroolsVisitor.getTotalDecls();
            
            
            if ((nu / DroolsVisitor.THRESHOLD) == 0) {
                FactType fact1 = kbase.getFactType(packageName, "Project0");
                Object projIns1 = fact1.newInstance();
                ksession.insert(projIns1);
                droolsProjects.add("Project0");
                droolsProjectIns.add(projIns1);
            } else {
                for (int i = 0; i <= (nu / DroolsVisitor.THRESHOLD); i++) {
                    FactType fact1 = kbase.getFactType(packageName, "Project" + i);
                    if (fact1 != null) {
                        Object projIns1 = fact1.newInstance();
                        ksession.insert(projIns1);
                        droolsProjects.add("Project" + i);
                        droolsProjectIns.add(projIns1);
                    }
                }
            }
            
            loadO = System.currentTimeMillis();
            logger.info("time to load facts : " + ((loadO / 1000.0) - (loadI / 1000.0)));
            subTask.notifyProgress();
            fireRules(ksession);
            
            @SuppressWarnings("rawtypes")
            Iterator fItr = ksession.getFactHandles().iterator();
            while (fItr.hasNext()) {
                Object ob = fItr.next();
                logger.info("fact -> " + ob);
            }
            addMessages(project, result, ksession);
            this.reasoningResult = result;
            processCheckORPropagate(result, ksession, projIns); 
            subTask.notifyProgress();
            ksession.dispose();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        long outTime = System.currentTimeMillis();
        logger.info("Reasoning Time ->" + (outTime - inTime) / 1000.0 );
        logger.info("Diff : " + ((outTime / 1000.0) - (loadO / 1000.0)));
    }

    /**
     * Method to identify and process check OR value propagation appropriately.
     * @param result Reasoning result.
     * @param ksession Drools knowledge session.
     * @param projIns Project Instance.
     * @throws ConfigurationException Configuration exception , should not occur if there 
     * are no errors in configuration.
     * @throws ValueDoesNotMatchTypeException Should not occur, if values are created and assigned to appropriate
     * datatypes.
     */
    private void processCheckORPropagate(ReasoningResult result, StatefulKnowledgeSession ksession, Object projIns)
        throws ConfigurationException, ValueDoesNotMatchTypeException {
        
        if (this.propagate && !result.hasConflict()) {
            logger.info("it is value propagation");
            valuePropagate(ksession, projIns);
            Message propMes = new Message("Certain variables have been changed.", propagatedValues, Status.INFO);
            result.addMessage(propMes);
//                addDeadDecisionsMessage(result);
        } else if (propagate && result.hasConflict()) {
            Message propMes = new Message("The model is inconsistent and therefore, variables cannot be" 
                    + " updated.", null, Status.INFO);
            result.addMessage(propMes);
        }
    }

    /**
     * Method to add drools globals.
     * @param ksession Drools KNowledge session.
     * @return Returns the packagename of the .drl (drools rule) file.
     */
    private String addDroolsGlobals(StatefulKnowledgeSession ksession) {
        this.pckg = DroolsEngine.class.getPackage().getName();
        /**
         * cList contains the rule ids of the rules that are not satisfied.
         */
        ksession.setGlobal("cList", new ArrayList<Integer>());
        ksession.setGlobal("aList", new ArrayList<String>());
        ksession.setGlobal("dList", new ArrayList<Object>());
        ksession.setGlobal("vList", new ArrayList<String>());
        /*
         * flist is the list containing names of the variables with fixed status. 
         */
        ksession.setGlobal("fList", new ArrayList<String>());
        ArrayList<String> definedList = (ArrayList<String>) droolsVisitor.getdList();
        java.util.Set<String> tempSet = new HashSet<String>();
        tempSet.addAll(definedList);
        definedList.removeAll(definedList);
        definedList.addAll(tempSet);
        @SuppressWarnings("unchecked")
        List<String> defL = (ArrayList<String>) ksession.getGlobal("dList");
        for (int i = 0; i < definedList.size(); i++) {
            defL.add(definedList.get(i));
        }
        
        addEnums(ksession);
        return this.pckg;
    }

    /**
     * Private method to load enumerations as global values in the drools rule file. 
     * @param ksession Drools Knowledge Session.
     */
    private void addEnums(StatefulKnowledgeSession ksession) {
        Map<String, Integer> enumMap = new HashMap<String, Integer>();
        enumMap = droolsVisitor.getEnumMap();
        Iterator<String> itr = enumMap.keySet().iterator();
        while (itr.hasNext()) {
            String k = itr.next();
            ksession.setGlobal(k, enumMap.get(k));
        }
    }


    /**
     * Private method to fire the rules.
     * @param ksession Knowledge Session. 
     */
    @SuppressWarnings("unchecked")
    private void fireRules(StatefulKnowledgeSession ksession) {
        ksession.getAgenda().getAgendaGroup("Group Config").setFocus();
        ksession.fireAllRules();
        LinkedHashMap<String, Integer> importedProjectMap = droolsVisitor.getImportedProjectMap();
        Iterator<String> itr = importedProjectMap.keySet().iterator();
        
        while (itr.hasNext()) {
            String projectN = itr.next();
            ksession.getAgenda().getAgendaGroup("Group 0" + projectN).setFocus();
            ksession.fireAllRules();
        }
        
        ksession.getAgenda().getAgendaGroup("Group 0").setFocus();
        ksession.fireAllRules();
        evaluateInnerProjectScopes(ksession);
        
        
        List<String> agendaGroups = DroolsVisitor.getAgendaGroups1();
        LinkedList<String> agendaGroups2 = DroolsVisitor.getAgendaGroups2();
        
        
        Collections.sort(agendaGroups);
        Collections.sort(agendaGroups2); 
        
        runDirectModification(ksession, agendaGroups);
        
        runImplication(ksession, agendaGroups2);
        
        
        ksession.getAgenda().getAgendaGroup("Group 2").setFocus();
        ksession.fireAllRules();
        List<String> dList = (ArrayList<String>) ksession.getGlobal("dList");
        removeDuplicates(dList);
        logger.info(" dList is **** " + " **** " + dList);
        fixedVariables = (ArrayList<String>) ksession.getGlobal("fList");
        logger.info(" fList is **** " + " **** " + fixedVariables);
        
    }

    /**
     * Method to run direct modification rules.
     * @param ksession Drools knowledge session.
     * @param agendaGroups Agenda groups.
     */
    private void runDirectModification(StatefulKnowledgeSession ksession, List<String> agendaGroups) {
        for (int i = 0; i < agendaGroups.size(); i++) {
            for (String str : agendaGroups) {
                ksession.getAgenda().getAgendaGroup(str).setFocus();
                ksession.fireAllRules();
            }
        }
    }
    
    /**
     * Method to run implication rules.
     * @param ksession Drools knowledge session.
     * @param agendaGroups2 Agenda groups for implication rules.
     */
    private void runImplication(StatefulKnowledgeSession ksession, LinkedList<String> agendaGroups2) {
        for (int J = 0; J < agendaGroups2.size(); J++) {
            for (int i = 0; i < agendaGroups2.size(); i++) {
                String str = agendaGroups2.get(i);
                ksession.getAgenda().getAgendaGroup(str).setFocus();
                ksession.fireAllRules();
            }
        }
    }


    /**
     * Method to evaluate rules in inner project scopes.
     * @param ksession Drools Knowledge session.
     */
    private void evaluateInnerProjectScopes(StatefulKnowledgeSession ksession) {
        LinkedHashMap<String, Integer> importedProjectMap = droolsVisitor.getImportedProjectMap();
        Iterator<String> itr = importedProjectMap.keySet().iterator();
        while (itr.hasNext()) {
            String projectN = itr.next();
            for (int i = 0; i < importedProjectMap.get(projectN); i++) {
                ksession.getAgenda().getAgendaGroup("Group 0_" + i + projectN).setFocus();
                ksession.fireAllRules();
                ksession.getAgenda().getAgendaGroup("Group 2_" + i + projectN).setFocus();
                ksession.fireAllRules();
            }
            ksession.getAgenda().getAgendaGroup("Group 2" + projectN).setFocus();
            ksession.fireAllRules();
            
        }
    }
    
    
    /**
     * Method to remove duplicates in a list.
     * @param list List.
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    private void removeDuplicates(List list) {
        java.util.Set set = new HashSet();
        set.addAll(list);
        list.removeAll(list);
        list.addAll(set);
        
    }

    /**
     * A private method to add messages to the reasoning result.
     * @param project Project.
     * @param result Reasoning result.
     * @param ksession Drools Knowledge Session.
     */
    @SuppressWarnings("unchecked")
    private void addMessages(Project project, ReasoningResult result, StatefulKnowledgeSession ksession) {
        cList = (ArrayList<Integer>) ksession.getGlobal("cList");
        removeDuplicates(cList);
        logger.info("Total failing constraints " + cList.size());
        List<ModelElement> conflictingConstraints = new ArrayList<ModelElement>();
        aList = (ArrayList<String>) ksession.getGlobal("aList");
        java.util.Set<String> tempSet = new HashSet<String>();
        tempSet.addAll(aList);
        aList.removeAll(aList);
        aList.addAll(tempSet);
        if (droolsVisitor.getMessages().size() != 0) {
            List<ModelElement> cMEList = droolsVisitor.getMessages();
            Message mesAttrAssgn = new Message("Constraints are not supported in the attribute "
                    + "assignment blocks", cMEList, Status.UNSUPPORTED);
            result.addMessage(mesAttrAssgn);
        }
        
        for (int i = 0; i < cList.size(); i++) {
            conflictingConstraints.add(this.ruleMapper.get(cList.get(i)));
        }

        for (int i = 0; i < aList.size(); i++) {
            conflictingConstraints.add(droolsVisitor.getAttributeMap().get(aList.get(i)));
        }
        
        List<ModelElement> notSupportedConstraints = new ArrayList<ModelElement>();
        for (int i = 0; i < droolsVisitor.getListofUnsupportedRules().size(); i++) {
            int index = droolsVisitor.getListofUnsupportedRules().get(i);
//            notSupportedConstraints.add(project.getElement(index));
            if (index < 0) {
                index = 0 - index;
            }
            notSupportedConstraints.add(ruleMapper.get(index));
        }
        
        Message mes = new Message("Constraints not satisfied", conflictingConstraints, Status.ERROR);
        if (conflictingConstraints.size() != 0) {
            messageList.add(mes);
        }
        
        Message mes2 = new Message("Constraints not supported", notSupportedConstraints, Status.UNSUPPORTED);
        if (notSupportedConstraints.size() != 0) {
            messageList.add(mes2);
        }
        logger.info("Nr. of constraints not supported " + notSupportedConstraints.size());
        
        
        for (int i = 0; i < messageList.size(); i++) {
            logger.info("message " + messageList.get(i).getDescription());
            result.addMessage(messageList.get(i));
        }
    }
    
    /**
     * A private method for rule parsing.
     * @param path of the .drl file.
     * @return KnowledgeBase.
     * @throws Exception Exception.
     */
    private static KnowledgeBase readKnowledgeBase(String path) throws Exception {
        
        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();

        // Print out model by Holger
//        try {
//            LineNumberReader lnir = new LineNumberReader(new FileReader(new File(path)));
//            String line;
//            do {
//                line = lnir.readLine();
//                if (null != line) {
//                    System.out.println(line);
//                }
//            } while (null != line);
//            lnir.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        
        
        FileInputStream  fis = new FileInputStream(path);
        kbuilder.add(ResourceFactory.newInputStreamResource(fis), ResourceType.DRL);
        KnowledgeBuilderErrors errors = kbuilder.getErrors();
        if (errors.size() > 0) {
            for (KnowledgeBuilderError error: errors) {
                System.err.println(error + "@line " + error.getLines());
            }
            throw new IllegalArgumentException("Could not parse knowledge.");
        }
        KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
        kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
        return kbase;
    }
 // checkstyle: resume exception type check 
    
    /**
     * Private method for value propagation.
     * @param ksession Knowledge Session.
     * @param projIns The project instance.
     * @throws ConfigurationException 
     * @throws ValueDoesNotMatchTypeException 
     */
    private void valuePropagate(StatefulKnowledgeSession ksession, Object projIns) throws 
        ConfigurationException, ValueDoesNotMatchTypeException  {
        
        logger.info("fact count " + ksession.getFactCount() + " " 
                + ksession.getFactHandle(projIns));
        @SuppressWarnings("unchecked")
        List<String> dList = (ArrayList<String>) ksession.getGlobal("dList");
        logger.info(" dList is **** " + " **** " + dList);
        @SuppressWarnings("unchecked")
        List<String> vList = (ArrayList<String>) ksession.getGlobal("vList");
        logger.info("vList is " + vList);
        this.dList = dList;
        this.vList = vList;
        logger.info("\n\t\t************************************************* BELOW VALUES ARE CHANGED");
        for (int in = 0; in < droolsProjects.size(); in++) {
            String project = droolsProjects.get(in);
            List<FactField> fFields = ksession.getKnowledgeBase().getFactType(pckg, project).getFields();
            setVarMap(varMap);
            for (int i = 0; i < fFields.size(); i++) {
                String typeName = fFields.get(i).getType().getSimpleName();
                Object val = fFields.get(i).get(droolsProjectIns.get(in));
                if (null != val) {
                    
                    if (typeName.equals(String.class.getSimpleName())) {
                        updateNonNested(fFields.get(i), val.toString());
                    } else if (typeName.equals(Boolean.class.getSimpleName())) {
                        updateNonNested(fFields.get(i), val.toString());
                    } else if (typeName.equals(int.class.getSimpleName())) {
                        updateNonNested(fFields.get(i), val.toString());
                    } else if (typeName.equals(double.class.getSimpleName())) {
                        updateNonNested(fFields.get(i), val.toString());
                    } else {
                        if (!typeName.equals("Set") && !typeName.equals("List")) {
                            List<FactField> cFields = ksession.getKnowledgeBase().getFactType(pckg, typeName)
                                    .getFields();
                            updateNested(fFields.get(i), cFields, droolsProjectIns.get(in));
                        } else {
                            processCollection(val, fFields.get(i), droolsProjectIns.get(in));
                        }
                    }
                }
            }
        }
        
    }   
    
    /**
     * Setting up the map.
     * @param map Variable map.
     */
    
    public void setVarMap(Map<String, IDatatype> map) {
        this.varMap = map;
        createDecisionsMap();
        
    }
    
    
    /**
     * A private method to create a map for all the decisions given the declaration names.
     */
    private void createDecisionsMap() {
        Iterator<IDecisionVariable> iterator = this.config.iterator();    
        while (iterator.hasNext()) {
            IDecisionVariable dc = (IDecisionVariable) iterator.next();
            String decName = dc.getDeclaration().getName();
            IDatatype type = varMap.get(decName);
            if (null != type) {
                this.decisionsMap.put(decName, dc);
            }
            
        }
    }
    
    /**
     * Update a non-nested variable in the configuration.
     * @param fField a fact field of type int.
     * @param value value as String.
     * @throws ConfigurationException Should not occur if there is no flaw in the configuration.
     * @throws ValueDoesNotMatchTypeException Should not occur if the values are being configured to 
     * the right datatypes.
     */
    private void updateNonNested(FactField fField, String value) throws ConfigurationException, 
        ValueDoesNotMatchTypeException {
        
        String name = fField.getName();
        IDecisionVariable dc = decisionsMap.get(name);
        if (!(vList.contains(name) || dList.contains(name))) {
            if (null != decisionsMap.get(name)) {
                logger.info(name + " Can be a dead decision variable!");
                deadDecisions.add(dc.getDeclaration());
            }
        }
        AssignmentState state = AssignmentState.DEFAULT;
        if (decisionsMap.get(name) != null) {
            if (vList.contains(name)) {
                state = AssignmentState.DERIVED;
            } else if (fixedVariables.contains(name)) {
                state = AssignmentState.FROZEN;
            } else {
                state = (AssignmentState) decisionsMap.get(name).getState();
            }
        }
        
        int propType = propagationType(name); 
        if (propType == 0 && !dc.getState().equals(AssignmentState.FROZEN)) {
            if (vList.contains(name) || dList.contains(name)) {
                Value intV = ValueFactory.createValue(this.varMap.get(name), value);
                config.getDecision(dc.getDeclaration()).setValue(intV, state);
                propagatedValues.add(dc.getDeclaration());
                freezeDecisionvariable(name, dc);
            } else if (!dList.contains(name)) {
                narrowValuesSearch(name);
            }
        } else if (propType == 1 && !dc.getState().equals(AssignmentState.FROZEN)) {
            if (vList.contains(name) || dList.contains(name)) {
                Value intV = getIVMLValue(1, name, value);
                dc.setValue(intV, state);
                propagatedValues.add(dc.getDeclaration());
                freezeDecisionvariable(name, dc);
            }
        } else if (propType == 2 && !dc.getState().equals(AssignmentState.FROZEN)) {
            if (vList.contains(name) || dList.contains(name)) {
                Value intV = getIVMLValue(2, name, value);
                dc.setValue(intV, state);
                propagatedValues.add(dc.getDeclaration());
                freezeDecisionvariable(name, dc);
            }
        } else if (propType == -1) {
            if (name.contains("$")) {
                String[] tokens = name.split("[_]");
                String varName = tokens[1];
                String attr = tokens[2];
                if (decisionsMap.get(varName) != null) {
                    dc = decisionsMap.get(varName);
                    Value val = getIVMLValue(-1, attr, value);
                    if (val != null) {
                        dc.getDeclaration().getAttribute(attr).setValue(val.getValue());
                    }
                }
            }
        }
    }

    /**
     * Method to freeze a decision variable.
     * @param name name of the decision variable.
     * @param dc decision variable.
     * 
     */
    private void freezeDecisionvariable(String name, IDecisionVariable dc) {
        if (fixedVariables.contains(name)) {
            dc.freeze(AllFreezeSelector.INSTANCE);
        } 
    }
    
    /**
     * Method that returns IVML value for a declaration. 
     * @param propType Propagation type : 0 if the variable is not a reference, enum and ordered enum. 
     * 1 if the variable is an enum,
     * 2 if the variable is an ordered enum,
     * else, -1. 
     * @param name ae of the varable.
     * @param value Value  obtained from Drools engine.
     * @return Returns IVML Value.
     * @throws ValueDoesNotMatchTypeException Should not occur if the values are being configured to 
     * the right datatypes.
     */
    private Value getIVMLValue(int propType, String name, String value) throws 
    ValueDoesNotMatchTypeException {
        
        Value dcValue = null;
        
        if (propType == 0) {
            dcValue = ValueFactory.createValue(this.varMap.get(name), value);
        } else if (propType == 1) {
            Enum en = (Enum) decisionsMap.get(name).getDeclaration().getType();
            dcValue = ValueFactory.createValue(this.varMap.get(name), 
                    en.getLiteralByOrdinal(Integer.parseInt(value)));
        } else if (propType == 2) {
            OrderedEnum en = (OrderedEnum) decisionsMap.get(name).getDeclaration().getType();
            dcValue = ValueFactory.createValue(this.varMap.get(name), 
                    en.getLiteralByOrdinal(Integer.parseInt(value)));
        } else {
            dcValue = null;
        }
        
        return dcValue;
    }
    
    
    /**
     * Method to identify what type of value propagation.
     * 
     * @param name Name of the variable.
     * @return -1 if the variable is not part of the configuration. 0 if the variable is
     * neither an Enum or OrderedEnum. 1 if the variable is an enum and 2 if it is an ordered enum.
     * 
     */
    private int propagationType(String name) {
        int result = -1;
        if (null != decisionsMap.get(name) && null != varMap.get(name)) {
            if (decisionsMap.get(name).getState() == AssignmentState.FROZEN) {
                result = -1;
            } else if (!varMap.get(name).getTypeClass().isAssignableFrom(Enum.class)
                && !varMap.get(name).getTypeClass().isAssignableFrom(OrderedEnum.class)
                && !varMap.get(name).getTypeClass().equals(Reference.class)) {
                result = 0;
            } else if ((null != varMap.get(name)) && varMap.get(name).getTypeClass().isAssignableFrom(Enum.class)
                    && !varMap.get(name).getTypeClass().equals(Reference.class)) {
                result = 1;
            } else if (varMap.get(name).getTypeClass().isAssignableFrom(OrderedEnum.class)
                    && !varMap.get(name).getTypeClass().equals(Reference.class)) {
                result = 2;
            }
        } else {
            result = -1;
        }
        return result;
    }
    
    /**
     * Method to update compound types.
     * @param fField Fact fields.
     * @param cFields List of facts that are compounds.
     * @param projIns Project Instance.
     * @throws ValueDoesNotMatchTypeException Should not occur if the values are being configured to 
     * the right datatypes.
     * @throws ConfigurationException Should not occur if there is no flaw in the configuration..
     */
    private void updateNested(FactField fField, List<FactField> cFields, Object projIns) 
        throws ValueDoesNotMatchTypeException, ConfigurationException {
        String declName = fField.getName();
        logger.info("Name of the dVariable is " + declName);
        IDecisionVariable dc = decisionsMap.get(declName);
        if (!(dc.getDeclaration().getType() instanceof Compound)) {
            return;
        }
        Compound c = (Compound) dc.getDeclaration().getType();
        for (int i = 0; i < c.getElementCount(); i++) {
            logger.info("\tand name " + c.getElement(i).getName());
            CompoundValue cv = (CompoundValue) this.config.getDecision(dc.getDeclaration()).getValue();
            String fieldName = cFields.get(i).getName();
            if (isBasicType(cFields.get(i).getType().getSimpleName())) {
                Object value = cFields.get(i).get(fField.get(projIns));
                Boolean isRef = dc.getDeclaration().getType().getTypeClass().equals(Reference.class);
                if (!isRef) {
                    Boolean update = shouldUpdateNested(declName, fieldName, c.getName());
                    int variableType = getVariableType(c.getElement(i).getType());
                    if (update) {
                        switch (variableType) {
                        case 2:
                            Enum en = (Enum) c.getElement(i).getType();
                            cv.configureValue(fieldName, en.getLiteralByOrdinal((Integer) value));
                            dc.setValue(cv, AssignmentState.DERIVED);
                            logger.info("\t\t" + "changed -> " + fieldName + " and value " + value);
                            break;
                        case 3:
                            OrderedEnum ordEn = (OrderedEnum) c.getElement(i).getType();
                            cv.configureValue(fieldName, ordEn.getLiteralByOrdinal((Integer) value));
                            dc.setValue(cv, AssignmentState.DERIVED);
                            logger.info("\t\t" + "changed -> " + fieldName + " and value " + value);
                            break;
                        case 4:
                            logger.info("Cannot process collections");
                            break;
                        default:
                            cv.configureValue(fieldName, value);
                            logger.info("\t\tchanged -> " + fieldName + " and value " + value);
                            dc.setValue(cv, AssignmentState.DERIVED);
                            break;
                        }
                        propagatedValues.add(decisionsMap.get(declName).getDeclaration());
                        
                    } 
                }
            } else if (!isAContainer(cFields.get(i).getType().getSimpleName())) {
                nestedCompoundAccess += declName;
                String typeName = c.getElement(i).getType().getName();
                String nestedName = c.getElement(i).getName();
                CompoundValue outerCV = (CompoundValue) cv.getNestedValue(nestedName);
                if (null != outerCV) {
                    CompoundValue innerValue = outerCV;
                    logger.info("inner value " + innerValue);
                    nestedCompoundAccess += "." + c.getElement(i).getName();
                    List<FactField> cFields2 = ksession.getKnowledgeBase().getFactType(pckg, typeName).getFields();
                    innerValue = getCompoundValue(innerValue, cFields2, cFields.get(i).get(fField.get(projIns)));
                    cv.configureValue(fieldName, innerValue);
                    dc.setValue(cv, AssignmentState.DERIVED);
                }
                
                logger.info("\t\t*********************************************************");
                nestedCompoundAccess = "";
            } else if (isAContainer(cFields.get(i).getType().getSimpleName())) {
                if ((cFields.get(i).get(fField.get(projIns)) != null) ) {
                    processNestedContainer(fField, projIns, c, cv, cFields.get(i));
                    dc.setValue(cv, AssignmentState.DERIVED);
                }
            }
        }
                
    }
    
    /**
     * Private method to update nested-container-values.
     * @param fField Fact field.
     * @param projIns Project instance.
     * @param comp Compound of the nested element being updated.
     * @param cv Compound value.
     * @param nestedFactField Nested fact field, i.e. field representing the container being updated.
     */
    private void processNestedContainer(FactField fField, Object projIns, Compound comp, 
            CompoundValue cv, FactField nestedFactField) {
        logger.info("name of the fact field " + nestedFactField.getName());
        @SuppressWarnings("rawtypes")
        List listContainer = (List) nestedFactField.get(fField.get(projIns));
        Object[] containerValueArray = new Object[listContainer.size()];
        logger.info(" list l " + listContainer);
        Value contValue = null;
        IDatatype containerType = comp.getElement(nestedFactField.getName()).getType();
        
        int key = getVariableType(comp.getElement(nestedFactField.getName()).getType());
        switch (key) {
        case 1:
            logger.info("Int/Real/String/Boolean");
            Container container = (Container) containerType;
            if (container.getContainedType().isAssignableFrom(Enum.TYPE)) {
                Enum en = (Enum) container.getContainedType();
                for (int i = 0; i < listContainer.size(); i++) {
                    containerValueArray[i] = en.getLiteralByOrdinal((Integer) listContainer.get(i));
                }
            }
            if (container.getContainedType().isAssignableFrom(OrderedEnum.TYPE)) {
                OrderedEnum en = (OrderedEnum) container.getContainedType();
                for (int i = 0; i < listContainer.size(); i++) {
                    containerValueArray[i] = en.getLiteralByOrdinal((Integer) listContainer.get(i));
                }
            }
            
            try {
                contValue = ValueFactory.createValue(containerType, containerValueArray);
                cv.configureValue(nestedFactField.getName(), contValue);
            } catch (ValueDoesNotMatchTypeException e) {
                e.printStackTrace();
            }
            break;
        case 4:
            logger.info("Set/Sequence here ... Cannot process");
            break;
        default:
            break;
        }
        
        
    }
    
    /**
     * Method that returns the type of the variable.
     * Default type - 1 - for int, string, real, and boolean,
     * 2 - Enum, 3 - Ordered enum and 4 for container types.
     * @param type datatype of a variable.
     * @return Retzurns a number representing the type based on which a switch is written.
     */
    private int getVariableType(IDatatype type) {
        int result = 1;
        if (type.isAssignableFrom(Enum.TYPE)) {
            result = 2;
        } else if (type.isAssignableFrom(OrderedEnum.TYPE)) {
            result = 3;
        } else if (type.equals(Set.TYPE) || type.equals(Sequence.TYPE)) {
            result = 4;
        }
        
        return result;
    }
    
    /**
     * Method to identify if a type is a container type.
     * @param type Type.
     * @return True if the type is either a sequence or a set.
     */
    private boolean isAContainer(String type) {
        boolean result = false;
        
        if (type.contains("List") || type.contains("Set")) {
            result = true;
        }
        
        return result;
    }
    
    /**
     * Recursive method that is responsible for updating nested compound values.
     * @param cValue Compound value.
     * @param cFields cFiles are the list of fields of a compound variable. 
     * A compound variable is a java object is drools.
     * @param val Value
     * @return returns the updated compound value.
     * @throws ValueDoesNotMatchTypeException Should not occur if right value is assigned to the the right 
     * type.
     */
    private CompoundValue getCompoundValue(CompoundValue cValue, List<FactField> cFields, Object val) 
        throws ValueDoesNotMatchTypeException {
        logger.info("Type is -> " + cValue);
        Compound temp = (Compound) cValue.getType();
        
        for (int i = 0; i < temp.getElementCount(); i++) {
            String name = temp.getElement(i).getName();
            String tempS = nestedCompoundAccess + "." + name;
            if (isBasicType(cFields.get(i).getType().getSimpleName()) 
                    && !isAContainer(cFields.get(i).getType().getSimpleName())) {
                if (!temp.getElement(i).getType().isAssignableFrom(Enum.TYPE)
                        && (vList.contains(tempS) || dList.contains(tempS))) {
                    cValue.configureValue(name, cFields.get(i).get(val));
                } else if (temp.getElement(i).getType().isAssignableFrom(Enum.TYPE)
                        && (vList.contains(tempS) || dList.contains(tempS))) {
                    Enum en = (Enum) temp.getElement(i).getType();
                    Object enV = en.getLiteralByOrdinal((Integer) cFields.get(i).get(val));
                    cValue.configureValue(name, enV);
                }
            } else if (!isAContainer(cFields.get(i).getType().getSimpleName())) {
                String innerType = temp.getElement(i).getType().getName();
                nestedCompoundAccess += "." + name;
                List<FactField> cFields2 = ksession.getKnowledgeBase().getFactType(pckg, innerType).getFields();
                Object innerVal = cFields.get(i).get(val);
                CompoundValue innerCValue = (CompoundValue) cValue;
               
                innerCValue = getCompoundValue(innerCValue, cFields2, innerVal);
                cValue.configureValue(name, innerCValue);
            }
        }
        
        return cValue;
    }

    /**
     * A private method to identify if a nested element value should be updated.This decision is based 
     * on the result of reasoning. Precisely, if a value has been changed during reasoning or has been set 
     * during project configuration stage, the result is set to <b>True</b>.
     * @param declName Name of the decision Variable.
     * @param fieldName Name of the nested element (or field).
     * @param compoundName Name of the compound type.
     * @return <b>True</b> if a nested element value has be updated.
     */
    private boolean shouldUpdateNested(String declName, String fieldName, String compoundName) {
        
        Boolean result1 = vList.contains(declName + "." + fieldName);
        Boolean result2 = vList.contains(compoundName + "." + fieldName);
        return (result1 || result2);
    }
    
    /**
     * Method to check if a given nested element type is a basic type.  
     * @param typeName type name.
     * @return <True> if the type is either String, Integer, Double or Boolean. 
     */
    private boolean isBasicType(String typeName) {
        boolean result = true;
        if (typeName.equals(String.class.getSimpleName())) {
            result = true;
        } else if (typeName.equals(Boolean.class.getSimpleName())) {
            result = true;
        } else if (typeName.equals(int.class.getSimpleName()) || typeName.equals(Integer.class.toString())) {
            result = true;
        } else if (typeName.equals(double.class.getSimpleName()) || typeName.equals(Double.class.toString())) {
            result = true;
        } else {
            result = false;
        }
        
        
        return result;
    }
    
    
    
    /**
     * Private method to process the collection for value propagation.
     * @param value Value (Object).
     * @param field fact field. 
     * @param projIns projectInstance.
     * @throws ValueDoesNotMatchTypeException 
     * @throws ConfigurationException 
     * 
     */
    @SuppressWarnings("rawtypes")
    private void processCollection(Object value, FactField field, Object projIns)
        throws ValueDoesNotMatchTypeException, ConfigurationException {
        String type = field.getType().getSimpleName();
        String name = field.getName();
        IDecisionVariable dc = decisionsMap.get(name);
        logger.info("name of the collection : " + name + " and its state " + dc.getState());
        if (null != value && !dc.getState().equals(AssignmentState.FROZEN)) {
            if (type.equals("List")) {
                logger.info("hererere seq");
                List list = (List) value;
                if (list.size() >= 0) {
                    Object[] cValues = new Object[list.size()];
                    //isBasicType(l.get(0).getClass().toString())
                    if (isBasicType(list.get(0).getClass().toString()) 
                            && (dList.contains(name) || vList.contains(name))) {
                        for (int i = 0; i < list.size(); i++) {
                            cValues[i] = list.get(i);
                        }
                        
                        processEnumsInCollections(list, cValues, dc);
                        Value v = ValueFactory.createValue(dc.getDeclaration().getType(), cValues);
                        dc.setValue(v, AssignmentState.DERIVED);
                        freezeDecisionvariable(name, dc);
                    } else {
                        processCompoundBasedSequence(name, field, projIns);
                        
                    }
                } 
            } else if (type.equals("Set")) {
                java.util.Set set = (java.util.Set) value;
                logger.info("hererere");
                Object[] cValues = new Object[set.size()];
                if (set.size() > 0) {
                    //isBasicType(set.iterator().next().getClass().toString())
                    if (isBasicType(set.iterator().next().getClass().toString())
                            && (dList.contains(name) || vList.contains(name))) {
                        Iterator itr = set.iterator();
                        int i = 0;
                        while (itr.hasNext()) {
                            Object ob = itr.next();
                            cValues[i] = ob;
                            i++;
                        }
                        processEnumsInCollections(set, cValues, dc);
                        Value v = ValueFactory.createValue(dc.getDeclaration().getType(), cValues);
                        dc.setValue(v, AssignmentState.DERIVED);
                        freezeDecisionvariable(name, dc);
                        
                    } else {
                        processCompoundBasedSet(name, field, projIns);
                    }
                }
            }
        }
    }

    /**
     * Method to process sequences of a compound type.
     * @param name name of the decision variable.
     * @param field factFiled.
     * @param projIns project instance.
     * @throws ValueDoesNotMatchTypeException 
     */
    @SuppressWarnings("rawtypes")
    private void processCompoundBasedSequence(String name, FactField field, Object projIns) 
        throws ValueDoesNotMatchTypeException {
        
        logger.info("This set is not composed of basic types ");
        IDecisionVariable dc = decisionsMap.get(name);
        Sequence seq = (Sequence) dc.getDeclaration().getType();
        if (seq.getContainedType().getTypeClass().equals(Compound.class)) {
            Compound comp = (Compound) seq.getContainedType();
            List<FactField> cFields = ksession.getKnowledgeBase().getFactType(pckg, comp.getName())
                    .getFields();
            List fields = (List) field.get(projIns);

            configureCollectionValue(dc, comp, cFields, fields);
        }
    }

    /**
     * Method to configure the value for the collection : value prop.
     * @param dc Decision variable.
     * @param comp compound the collection is composed of.
     * @param cFields list of factfields.
     * @param fields fields within the collection.
     * @throws ValueDoesNotMatchTypeException Should not occur.
     */
    @SuppressWarnings("rawtypes")
    private void configureCollectionValue(IDecisionVariable dc, Compound comp, List<FactField> cFields, List fields)
        throws ValueDoesNotMatchTypeException {
        if (dc.getState() != AssignmentState.FROZEN) {
            ContainerVariable parentVariable = (ContainerVariable) dc;
            for (int j = 0; j < parentVariable.getNestedElementsCount(); j++) {
                CompoundVariable nestedCompoundVar = (CompoundVariable) parentVariable.getNestedElement(j);
                for (int n = 0; n < fields.size(); n++) {
                    for (int i = 0; i < comp.getDeclarationCount(); i++) {
                        boolean supported = true;
                        Object fieldValue = cFields.get(i).get(fields.get(n));
                        if (fieldValue == null) {
                            supported = false;
                        }
                        if (comp.getDeclaration(i).getType() instanceof Enum) {
                            Enum en = (Enum) comp.getDeclaration(i).getType();
                            fieldValue = en.getLiteralByOrdinal((Integer) fieldValue);
                        } else if (comp.getDeclaration(i).getType() instanceof OrderedEnum) {
                            OrderedEnum oen = (OrderedEnum) comp.getDeclaration(i).getType();
                            fieldValue = oen.getLiteralByOrdinal((Integer) fieldValue);
                        } else if (comp.getDeclaration(i).getType() instanceof Compound) {
                            supported = false;
                        } else if (comp.getDeclaration(i).getType() instanceof Sequence) {
                            supported = false;
                        } else if (comp.getDeclaration(i).getType() instanceof Set) {
                            supported = false;
                        } else {
                            logger.info(cFields.get(i).getName() + " and its value " + fieldValue);
                        }
                        if (supported) {
                            String slotName = cFields.get(i).getName();
                            IDecisionVariable nestedSlot = nestedCompoundVar.getNestedVariable(slotName);
                            IDatatype nestedType = nestedSlot.getDeclaration().getType();
                            Value nestedValue = ValueFactory.createValue(nestedType, fieldValue);
                            try {
                                nestedSlot.setValue(nestedValue, AssignmentState.DERIVED);
                            } catch (ConfigurationException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }
    
    /**
     * Method to process sequences of a compound type.
     * @param name name of the decision variable.
     * @param field factFiled.
     * @param projIns project instance.
     * @throws ValueDoesNotMatchTypeException 
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    private void processCompoundBasedSet(String name, FactField field, Object projIns) 
        throws ValueDoesNotMatchTypeException {
        
        logger.info("This set is not composed of basic types ");
        IDecisionVariable dc = decisionsMap.get(name);
        Set set = (Set) dc.getDeclaration().getType();
        if (set.getContainedType().getTypeClass().equals(Compound.class)) {
            Compound comp = (Compound) set.getContainedType();
            List<FactField> cFields = ksession.getKnowledgeBase().getFactType(pckg, comp.getName())
                    .getFields();
//            List fields = (List) field.get(projIns);
            List fields = new ArrayList((HashSet) field.get(projIns));

            configureCollectionValue(dc, comp, cFields, fields);
        }
    }
    
    

    /**
     * Method to process enums in non-nested sequences.
     * @param list Drools sequence as a list.
     * @param cValues Container Value, in an array.
     * @param dc Decision variable associated with the container.
     */
    private void processEnumsInCollections(@SuppressWarnings("rawtypes") List list, Object[] cValues, 
            IDecisionVariable dc) {
        @SuppressWarnings("rawtypes")
        Class classType = dc.getDeclaration().getType().getTypeClass();
        if (classType.equals(Sequence.class) ) {
            Container container = (Container) dc.getDeclaration().getType();
            if (container.getContainedType().isAssignableFrom(Enum.TYPE)) {
                Enum en = (Enum) container.getContainedType();
                for (int i = 0; i < list.size(); i++) {
                    cValues[i] = en.getLiteralByOrdinal((Integer) list.get(i));
                }
            }
            if (container.getContainedType().isAssignableFrom(OrderedEnum.TYPE)) {
                OrderedEnum en = (OrderedEnum) container.getContainedType();
                for (int i = 0; i < list.size(); i++) {
                    cValues[i] = en.getLiteralByOrdinal((Integer) list.get(i));
                }
            }
        }
    }
    
    /**
     * Method to process enums in non-nested sets.
     * @param set Drools set as a set.
     * @param cValues Container Value, in an array.
     * @param dc Decision variable associated with the container.
     */
    @SuppressWarnings({ "unused", "rawtypes" })
    private void processEnumsInCollections(java.util.Set set, Object[] cValues, 
            IDecisionVariable dc) {
        Class classType = dc.getDeclaration().getType().getTypeClass();
        Container container = (Container) dc.getDeclaration().getType();
        if (container.getContainedType().isAssignableFrom(Enum.TYPE)) {
            Enum en = (Enum) container.getContainedType();
            Iterator itr = set.iterator();
            int i = 0;
            while (itr.hasNext()) {
                Object ob = itr.next();
                cValues[i] = en.getLiteralByOrdinal((Integer) ob);
                
            }
        }
        
        if (container.getContainedType().isAssignableFrom(OrderedEnum.TYPE)) {
            OrderedEnum en = (OrderedEnum) container.getContainedType();
            Iterator itr = set.iterator();
            int i = 0;
            while (itr.hasNext()) {
                Object ob = itr.next();
                cValues[i] = en.getLiteralByOrdinal((Integer) ob);
                
            }
        }
    }
    
    
    
    /**
     * Private method that searches the boundary conditions for a given variable
     * whose values has not been set.
     * @param name Name of the variable.
     */
    private void narrowValuesSearch(String name) {
        cChecker = new ConstraintChecker();
        cChecker.setCurrentVariable(name);
        for (int i = 0; i < constraintList.size(); i++) {
            Constraint cons = constraintList.get(i);
            cons.getConsSyntax().accept(cChecker);
            if (cChecker.getcNr() > 0) {
                logger.info("Name " + name + " - has atleast one constraint");
                hasConstraint.put(name, true);
                logger.info("Boundaries -> " + cChecker.getBoundaries() 
                        + " AND THE DOMAIN RANGE IS VERY NARROW");
                if (cChecker.getBoundaries() == 2) {
                    processValueNarrowing(name);
                }  
            }
        }
    }

    /**
     * Private method to narrow down a variable to a produce hint to the reasoner.
     * @param name name of the variable.
     */
    private void processValueNarrowing(String name) {
        if (cChecker.getBoundaryValues().size() == cChecker.getOperations().size()) {
            int i1 = Integer.parseInt(cChecker.getBoundaryValues().get(0));
            int i2 = Integer.parseInt(cChecker.getBoundaryValues().get(1));
            int i3 = Math.abs(i1 - i2);
            if (i3 == 2
                    && shouldNarrowDown(cChecker.getOperations())) {
                Message propMes;
                if (cChecker.getOperations().get(0).equals(">")) {
                    propMes = new Message(name
                            + " may be " + (i1 + 1), null, Status.INFO);
                    logger.info(name
                            + " may be " + (i1 + 1));
                    reasoningResult.addMessage(propMes);
                } else {
                    propMes = new Message("Value for " + name
                            + " can be " + (i1 - 1), null, Status.INFO);
                    logger.info("Value for " + name
                            + " can be " + (i1 - 1));
                    reasoningResult.addMessage(propMes);
                }
                
            }
        }
    }
    
    /**
     * Method to identify conditions when the narrowing down should take place in relation to operaots.
     * Firstly, all operators should be different, and then currently, value narrowing will take place over 
     * variables constrained by <b><</b> and <b>></b> operators. 
     * @param operators List containing operators.
     * @return <b>True</b> if value narrowing down should take place.
     */
    private boolean shouldNarrowDown(List<String> operators) {
        boolean result = true;
        if (operators.contains(">=") || operators.contains("<=")) {
            result = false;
        } else {
            HashSet<String> hashSet = new HashSet<String>(operators);
            result = operators.size() == hashSet.size();
        }
        
        return result;
    }
    
    /**
     * Private method to identify if a variable is constrained.
     * @param name Name of the variable.
     * @return True if there is a constrained attached with it.
     */
    public Boolean isConstrained(String name) {
        Boolean result = false;
        cChecker = new ConstraintChecker();
        cChecker.setCurrentVariable(name);
        for (int i = 0; i < constraintList.size(); i++) {
            Constraint cons = constraintList.get(i);
            cons.getConsSyntax().accept(cChecker);
            if (cChecker.getcNr() > 0) {
                hasConstraint.put(name, true);     
                result = true;
            }
        }
        return result;
    }
    
    /**
     * Clearing contents of lists and maps used for tracking variables.
     */
    public void stop() {
        assignedVariables = new ArrayList<String>();
        DroolsVisitor.clear();
    }
}

