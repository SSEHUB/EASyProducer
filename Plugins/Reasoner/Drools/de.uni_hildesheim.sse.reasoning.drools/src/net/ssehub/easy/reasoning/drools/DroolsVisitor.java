package net.ssehub.easy.reasoning.drools;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.varModel.confModel.AssignmentState;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.confModel.IConfigurationVisitor;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.cst.AttributeVariable;
import net.ssehub.easy.varModel.cst.BlockExpression;
import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.cst.CompoundAccess;
import net.ssehub.easy.varModel.cst.CompoundInitializer;
import net.ssehub.easy.varModel.cst.ConstantValue;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.cst.ContainerInitializer;
import net.ssehub.easy.varModel.cst.ContainerOperationCall;
import net.ssehub.easy.varModel.cst.IConstraintTreeVisitor;
import net.ssehub.easy.varModel.cst.IfThen;
import net.ssehub.easy.varModel.cst.Let;
import net.ssehub.easy.varModel.cst.MultiAndExpression;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;
import net.ssehub.easy.varModel.cst.Parenthesis;
import net.ssehub.easy.varModel.cst.Self;
import net.ssehub.easy.varModel.cst.UnresolvedExpression;
import net.ssehub.easy.varModel.cst.Variable;
import net.ssehub.easy.varModel.model.Attribute;
import net.ssehub.easy.varModel.model.AttributeAssignment;
import net.ssehub.easy.varModel.model.Comment;
import net.ssehub.easy.varModel.model.CompoundAccessStatement;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.FreezeBlock;
import net.ssehub.easy.varModel.model.IModelVisitor;
import net.ssehub.easy.varModel.model.ModelElement;
import net.ssehub.easy.varModel.model.OperationDefinition;
import net.ssehub.easy.varModel.model.PartialEvaluationBlock;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.ProjectImport;
import net.ssehub.easy.varModel.model.ProjectInterface;
import net.ssehub.easy.varModel.model.datatypes.AnyType;
import net.ssehub.easy.varModel.model.datatypes.BooleanType;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.ConstraintType;
import net.ssehub.easy.varModel.model.datatypes.Container;
import net.ssehub.easy.varModel.model.datatypes.DerivedDatatype;
import net.ssehub.easy.varModel.model.datatypes.Enum;
import net.ssehub.easy.varModel.model.datatypes.EnumLiteral;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.IDatatypeVisitor;
import net.ssehub.easy.varModel.model.datatypes.IntegerType;
import net.ssehub.easy.varModel.model.datatypes.MetaType;
import net.ssehub.easy.varModel.model.datatypes.OclKeyWords;
import net.ssehub.easy.varModel.model.datatypes.OrderedEnum;
import net.ssehub.easy.varModel.model.datatypes.RealType;
import net.ssehub.easy.varModel.model.datatypes.Reference;
import net.ssehub.easy.varModel.model.datatypes.Sequence;
import net.ssehub.easy.varModel.model.datatypes.Set;
import net.ssehub.easy.varModel.model.datatypes.StringType;
import net.ssehub.easy.varModel.model.datatypes.VersionType;
import net.ssehub.easy.varModel.model.values.BooleanValue;
import net.ssehub.easy.varModel.model.values.CompoundValue;
import net.ssehub.easy.varModel.model.values.ConstraintValue;
import net.ssehub.easy.varModel.model.values.ContainerValue;
import net.ssehub.easy.varModel.model.values.EnumValue;
import net.ssehub.easy.varModel.model.values.IValueVisitor;
import net.ssehub.easy.varModel.model.values.IntValue;
import net.ssehub.easy.varModel.model.values.MetaTypeValue;
import net.ssehub.easy.varModel.model.values.NullValue;
import net.ssehub.easy.varModel.model.values.RealValue;
import net.ssehub.easy.varModel.model.values.ReferenceValue;
import net.ssehub.easy.varModel.model.values.StringValue;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.VersionValue;

/**
 * Visitor implementation of Drools Expert. 
 * @author Saripalli
 * @since 26.08.2012
 *
 */
public class DroolsVisitor implements IModelVisitor, 
    IDatatypeVisitor, IConstraintTreeVisitor, IValueVisitor, IConfigurationVisitor {
    
    private EASyLogger logger = EASyLoggerFactory.INSTANCE.getLogger(this.getClass(), Activator.BUNDLE_ID);
    
    public static final int THRESHOLD = 200;
    public static final String TYPESAFE = "@typesafe (false) \n";
    
    /**
     * A flag to perform according to the optimization type.
     */
    protected static boolean optimize = true;
    private static boolean abortReasoning = false;
    


    /**
     * Rules that are pure assignments expressions are grouped in this category.
     * Each rule has unique name.
     */
    private static List<String> agendaGroup1 = new ArrayList<String>();
    
    /**
     * Rules that assignments on satisfaction of a hard constraint are grouped in this category.
     * Note, first agendagroup1 rules are fired, then agendagroup2.Pure constraints are grouped 
     * into group2 that are fired at the last.
     */
    private static LinkedList<String> agendaGroup2 = new LinkedList<String>();

    /**
     * A map containing compound declaration as its key, and nested element names that have default values.
     * Used to keep track of nested elements that are configured by default.
     */
    private static Map<String, List<String>> compMap = new HashMap<String, List<String>>();
    private static Map<String, List<String>> compMap2 = new HashMap<String, List<String>>();
    
    
    /**
     * String that will contain variables that are pre-defined before reasoning. A list 'dList' 
     * is used in Drools that will have pre-defined variables and also variables that are defined
     * through expressions.  
     */
    private static String dListAdder = "";
    private static Map<String, Integer> droolsClassMap = new HashMap<String, Integer>();
    private static List<String> factList = new ArrayList<String>();
    private static String importedProjectName = "";
    private static int totalDecls = 0;
    
    private LinkedHashMap<String, Integer> importedProjectMap = new LinkedHashMap<String, Integer>();
    
    


    private boolean evaluationChecking = false;
    private boolean evaluationCalls = false;
    
    /**
     * List containing declaration of drools variables, with right syntax - name, and type, 
     * and/or default value.
     */
    private List<String> decisionVariables = new ArrayList<String>();
    
    /**
     * A map containing variable name and its value in drools syntax. This map contains 
     * variables that are fully configured.
     */
    private Map<String, String> configMap = new LinkedHashMap<String, String>();
    
    /**
     * A map containing variable name and its value in drools syntax. This map contains 
     * variables that are partially configured.
     */
    private Map<String, String> configMap2 = new LinkedHashMap<String, String>();
    
    /**
     * Drools printer object. 
     */
    private DroolsPrinter dPrinter = null;
    
    /**
     * Rule count number.
     */
    private int ruleCount = 0;
    
    
    /**
     * List contains rules that are pure assignments in nature.
     */
    private List<String> assgnConstraints = new ArrayList<String>();
    
    
    /**
     * List contains rules that are hard constrains and/or rules that are expressed as hard constraint
     * implies assignment.
     */
    private List<String> hardConstraints = new ArrayList<String>();
    
    
    /** 
     * Visitor for hard constraints.
     */
    private DroolsConstraintVisitor droolsConstraintVis = null;
    
    /**
     * Visitor for assignment constraints.
     */
    private DroolsAssignmentsVisitor droolsAssgnVis = null;
    
    /**
     * List of messages (warnings, errors etc..)
     */
    private List<ModelElement> messageList = new ArrayList<ModelElement>();
    
    private Map<String, Integer> enumMap = new HashMap<String, Integer>();
    
    /**
     * Flag for visiting container value.
     */
    private boolean visitingConatinerValue = false;
    private String declaration = null;
    
    /**
     * Compound declaration.
     */
    private String compDeclaration = null;
    
    /**
     * <b>True</b> if visiting non-nested. 
     */
    private boolean visitingNonNested = false;
    
    /**
     * <b>True</b> if visiting Nested. 
     */
    private boolean visitingNested = false;
    
    /**
     * <b>True</b> if visiting Configuration. 
     */
    private boolean visitingConfiguration = false;
    private String value = "";
    private String currentCompound = "";
    private Map<String, ModelElement> constraintsInAttributeAssignmentMap = new HashMap<String, ModelElement>();
    private AssignmentAttributeConstraints attributeConstraints = null;
    private String compoundAccessSlot = "";
    private List<String> variablesAssigned = new ArrayList<String>();
    
    /**
     * <b>True</b> if the variable being visited is a primitive type (i.e. non compound type).
     */
    private boolean isPrimitiveType = false;
    
    


    /**
     * This map contains rule number as key and corresponding model element (which
     * is a constraint). This helps makes it easier to add messages to the reasoning result, 
     * that contain a list of unsatisfied constraints, for instance.
     */
    private Map<Integer, ModelElement> ruleMapper = new HashMap<Integer, ModelElement>();
    
    /**
     * All the compound types are inserted as facts, otherwise they cannot be reaosned on. 
     */
    private List<String> facts = new ArrayList<String>();
    /**
     * All the compound declarations, as a type declaration in Drools. These are transformed into 
     * Java classes at rume-time.
     */
    private List<String> compoundFacts = new ArrayList<String>();
    
    /**
     * List containing rules that cannot be supported by Drools. Some rules are pre-scanned before 
     * feeding into the rule engine.
     */
    private List<Integer> listofUnsupportedRules = new ArrayList<Integer>();
    
    /**
     * List that contains the declaration (names) that have default values. This is to track the declarations
     * that are configured by default and thus, to avoid re-configuration of defauls. 
     */
    private List<String> configuredByDefaultList = new ArrayList<String>();
    
    /**
     * This is used to mitigate the problem with Drools/Java defaults. For e.g., if there is a 
     * constraint on variables that are not yet assigned, Drools can still process/fire it.
     * As a counter to this, problem, this list containing the names of the variables, is used. 
     * A constraint is fired only if the variables presne tin the constraint are present in this 
     * list. 
     */
    private List<String> dList = new ArrayList<String>();
    
    
    /**
     * Map containing name and type of the variable.
     */
    private Map<String, IDatatype> variableMap = new HashMap<String, IDatatype>();
    private Boolean declarationToBeUpdated = true;
    private List<String> dVariables = new ArrayList<String>();

    /**
     * Nested elements with defaults.
     */
    private List<String> nestedDefaults = new ArrayList<String>();
    
    /**
     * A flag to use internal optimization technique.
     * @param optimize param. <b>True</b> if optimization is to be performed. if so,
     * variables that have constraints are only used for reasoning. 
     */
    public static void setOptimize(boolean optimize) {
        DroolsVisitor.optimize = optimize;
    }

    
    /**
     * Initialization of the required constructors.
     */
    public static void clear() {
        agendaGroup1 = new ArrayList<String>();
        agendaGroup2 = new LinkedList<String>();
        compMap = new HashMap<String, List<String>>();
        compMap2 = new HashMap<String, List<String>>();
        dListAdder = "";
        droolsClassMap = new HashMap<String, Integer>();
        factList = new ArrayList<String>();
        importedProjectName = "";
        totalDecls = 0;
    }
    
    /**
     * Getter for map with info. on project imports. 
     * @return Map contains names of the imported projects as Keys and count for total number of elements 
     * as their respective values. 
     */
    public LinkedHashMap<String, Integer> getImportedProjectMap() {
        return importedProjectMap;
    }
    
    /**
     * Method to get the imported project name.
     * @return project name of the imported project.
     */
    public static String getImportedProjectName() {
        return importedProjectName;
    }
    
    /**
     * Getter, or method to identify if the reasoning should be performed 
     * based on the logic that a default cannot be overridden with a default.
     * @return <b>True</b> if the reasoning should not be aborted/stopped.
     */
    public static boolean isAbortReasoning() {
        return abortReasoning;
    }

    
    /**
     * Method to retrieve the map containing decision's name and the drools project
     * class number it belongs to.
     * @return Map.
     */
    public static Map<String, Integer> getDroolsClasseMap() {
        return droolsClassMap;
    }

    /**
     * Method to add the agenda groups.
     * @param group agenda group.
     */
    public static void addAgendaGroup1(String group) {
        agendaGroup1.add(group);
    }
    
    /**
     * Method that return the string containing variables to be added to dlist.
     * @return dList
     */
    public static String getDList() {
        return dListAdder;
    }
    
    /**
     * Method to retrieve the agenda groups.
     * @return List containing the agenda groups.
     */
    public static List<String> getAgendaGroups1() {
        return agendaGroup1;
    }
    
    
    /**
     * Method to add the agenda groups.
     * @param group agenda group.
     */
    public static void addAgendaGroup2(String group) {
        agendaGroup2.add(group);
    }
    
    /**
     * Method to retrieve the agenda groups.
     * @return List containing the agenda groups.
     */
    public static LinkedList<String> getAgendaGroups2() {
        return agendaGroup2;
    }
    
    
    /**
     * Getter for the compoundMap that contains the relation between decision variable of compound
     * types and types.
     * @return compound Map.
     */
    public static Map<String, List<String>> getCompoundMap() {
//        return compMap;
        return compMap2;
    }
    
    /**
     * Getetr for validation constraints.
     * @return hardconstraints.
     */
    public List<String> getHardConstraints() {
        return hardConstraints;
    }
    
    /**
     * Getter for list of not supported rules/constraints.
     * @return List of not supported rules - list contains 
     * integers which are mapped to the rule number.
     */
    public List<Integer> getListofUnsupportedRules() {
        return listofUnsupportedRules;
    }

    /**
     * Getter for the list containing facts.
     * @return list containing facts.
     */
    public List<String> getFacts() {
        return facts;
    }
    
    /**
     * Getter for the map containing names of the declarations and their types.
     * @return variablemap Map containing names of the declarations and their types..
     */
    public Map<String, IDatatype> getVariableMap() {
        return variableMap;
    }
    
    /**
     * Getter for the list containing the names of the variables that have default values.
     * @return list A list containing names..
     */
    public List<String> getdList() {
        return dList;
    }

    /**
     * Getter for attribute map, which holds a key for a constraint in the attribute assignment.
     * @return Attribute map.
     */
    public Map<String, ModelElement> getAttributeMap() {
        return constraintsInAttributeAssignmentMap;
    }
    
    /**
     * Setter for evaluation checking.
     * @param evaluationChecking Indicator for if the checking type is a regular model checking 
     * or evaluation specific. 
     */
    public void setEvaluationChecking(boolean evaluationChecking) {
        this.evaluationChecking = evaluationChecking;
    }
    
    /**
     * Setter for eval calls.
     * @param evaluationCalls Indicator if the ocl call is an eval call.
     */
    public void setEvaluationCalls(boolean evaluationCalls) {
        this.evaluationCalls = evaluationCalls;
    }
    
    
    /**
     * Getter for map containing Enums.
     * @return Map containing Enum and its ordinal.
     */
    public Map<String, Integer> getEnumMap() {
        return enumMap;
    }
    
    /**
     * Getter for rule Mapper.
     * @return ruleMapper Map of model elements with a unique key.
     */
    public Map<Integer, ModelElement> getRuleMapper() {
        return ruleMapper;
    }
    
    /**
     * Getter for key count.
     * @return key count for rules.
     */
    public int getRuleCount() {
        return ruleCount;
    }
    
    /**
     * Setter for the rule number.
     * @param ruleCount Rule number.
     */
    public void setRuleCount(int ruleCount) {
        this.ruleCount = ruleCount;
    }
    
    /**
     * Getter for the map containing configuration values.
     * @return Map containing the configuration. 
     */
    public Map<String, String> getConfigMap() {
        return configMap;
    }
    
    /**
     * Getter for the map containing configuration values.
     * @return Map containing the configuration (partial compounds). 
     */
    public Map<String, String> getConfigMap2() {
        return configMap2;
    }
    
    /**
     * Getter for the list of decision variable declarations.
     * @return List containing all the decision variable declarations.
     */
    public List<String> getDecisionVariables() {
        return decisionVariables;
    }
    /**
     * Getter for the total declarations.
     * @return totalDecls Total number of decision variable declarations.
     */
    public static int getTotalDecls() {
        return totalDecls;
    }
    
    
    /**
     * List of containable model elements that are not supported.
     * @return List containing not supported model elements.
     */
    public List<ModelElement> getMessages() {
        return this.messageList;
        
    }
    
    
    
    
    
    @Override
    public void visitEnum(Enum eenum) {
        String name = eenum.getName();
        for (int i = 0; i < eenum.getLiteralCount(); i++) {
            String litName = eenum.getLiteral(i).getName();
            String decl = "global Integer ";
            String droolsEnumName = name + "_" + litName;
            decl += droolsEnumName + ";";
            enumMap.put(droolsEnumName, eenum.getLiteral(i).getOrdinal());
            dPrinter.append(decl);
        }
    }

    @Override
    public void visitOrderedEnum(OrderedEnum eenum) {
        String name = eenum.getName();
//        enum is added as a global variable in Drools
        for (int i = 0; i < eenum.getLiteralCount(); i++) {
            String litName = eenum.getLiteral(i).getName();
            String decl = "global Integer ";
            String droolsEnumName = name + "_" + litName;
            decl += droolsEnumName + ";";
            enumMap.put(droolsEnumName, eenum.getLiteral(i).getOrdinal());
            dPrinter.append(decl);
        }
        
    }

    @Override
    public void visitCompound(Compound compound) {
        String name = compound.getName();
        currentCompound = name;
        compoundFacts.add(name);
        compDeclaration = "declare " + name;
        String typesafe = "@typesafe (false) \n";
        String refinement = "";
        if (compound.getRefinesCount() > 0) { // legacy, stay at the first
            refinement = " extends " + compound.getRefines(0).getName();
        }
        compDeclaration += refinement;
        compDeclaration += "\n" + typesafe;
        int defValInd = 0;
        for (int i = 0; i < compound.getElementCount(); i++) {
            DecisionVariableDeclaration declTemp = compound.getElement(i);
            defValInd = visitCompoundElement(name, defValInd, declTemp);

        }
        if (!compMap2.containsKey(name)) {
            List<String> tempList = new ArrayList<String>();
            for (int index = 0; index < compound.getElementCount(); index++) {
                tempList.add(compound.getElement(index).getName());
            }
            compMap2.put(name, tempList);
        }
        for (int j = 0; j < compound.getConstraintsCount(); j++) {
            Constraint cons = (Constraint) compound.getConstraint(j); 
            handleConstraintInCompound(cons);
            
        }
        for (int i = 0; i < compound.getAssignmentCount(); i++) {
            compound.getAssignment(i).accept((IModelVisitor) this);
        }
        compDeclaration += "\n" + "end";
        if (defValInd == compound.getElementCount()) {
            dList.add(name);
        }
        dPrinter.append(compDeclaration);
        compDeclaration = "";
    }

    /**
     * Method to handle each constraint within the compound or attribute assignment block.
     * @param cons constraint.
     */
    private void handleConstraintInCompound(Constraint cons) {
        if (cons.getConsSyntax() instanceof OCLFeatureCall) {
            OCLFeatureCall call = (OCLFeatureCall) cons.getConsSyntax();
            int callType = getCompoundConstraintType(call);
            if (callType == 1) {
                executeHardCompoundConstraint(call, cons);
            } else if (callType == 0) {
                droolsAssgnVis = new DroolsAssignmentsVisitor();
                droolsAssgnVis.setRrulePrepend("a");
                int ruleNr = AssignmentAttributeConstraints.getRuleCounter();
                DroolsAssignmentsVisitor.setRuleCount(ruleNr);
                droolsAssgnVis.visitOclFeatureCall(call);
                String rule = droolsAssgnVis.getRule();
                constraintsInAttributeAssignmentMap.put("a" + ruleNr, cons);
                assgnConstraints.add(rule);
                AssignmentAttributeConstraints.setRuleCounter(++ruleNr);
            } else if (callType == 2) {
                droolsConstraintVis = new DroolsConstraintVisitor();
                droolsConstraintVis.setRrulePrepend("a");
                int ruleNr = AssignmentAttributeConstraints.getRuleCounter();
                droolsConstraintVis.setRuleCount(ruleNr);
                droolsConstraintVis.visitOclFeatureCall(call);
                String rule = droolsConstraintVis.getRule();
                constraintsInAttributeAssignmentMap.put("a" + ruleNr, cons);
                hardConstraints.add(rule);
                AssignmentAttributeConstraints.setRuleCounter(++ruleNr);
                executeHardCompoundConstraint(call, cons);
            }
        }
    }
    
    /**
     * {@inheritDoc}
     */
    public void visitAttributeAssignment(AttributeAssignment assignment) {
        for (int i = 0; i < assignment.getModelElementCount(); i++) {
            if (assignment.getModelElement(i) instanceof DecisionVariableDeclaration) {
                DecisionVariableDeclaration declTemp = (DecisionVariableDeclaration) 
                        assignment.getModelElement(i);
                if (!(declTemp.getType() instanceof Compound) 
                        && (declTemp.getDefaultValue() != null)) {
                    if (compMap.containsKey(currentCompound)) {
                        compMap.get(currentCompound).add(declTemp.getName());
                    } else {
                        compMap.put(currentCompound, new ArrayList<String>());
                        compMap.get(currentCompound).add(declTemp.getName());
                    }
                }
                if (currentCompound.equals("")) {
                    declTemp.accept((IModelVisitor) this);
                } else {
                    visitCompoundElement(currentCompound, 0, declTemp);
                }
            } else if (assignment.getModelElement(i) instanceof Constraint) {
                Constraint cons = (Constraint) assignment.getModelElement(i);
                handleConstraintInCompound(cons);
                //TODO: change to be implemented.
            }
            
        }
        
        // TODO [AttributeAssignment] visit contained variables (affected), constraints and realizing constraints
        for (int a = 0; a < assignment.getAssignmentCount(); a++) {
            logger.info("nothing to do here!");
        }
    }
    
    /**
     * Type of call the constraint in the compound represents, modification or hard.
     * @param call OCL Call.
     * @return Returns the type of the call. 0 if modification, else 1.
     */
    private int getCompoundConstraintType(OCLFeatureCall call) {
        
        boolean operationIsEquals = (call.getOperation().equals(OclKeyWords.EQUALS)); 
        boolean operationIsAssignment = (call.getOperation().equals(OclKeyWords.ASSIGNMENT));
        boolean isModification = operationIsEquals || operationIsAssignment;
        
        int operationTyp = 1;
        
        if (isModification) {
            if (call.getOperand() instanceof Variable) {
                operationTyp = 0;
            } else if (call.getOperand() instanceof CompoundAccess) {
                operationTyp = 0;
            } else {
                operationTyp = 1;
            }
        } else {
            
            if (call.getOperation().equals(OclKeyWords.IMPLIES)) {
                boolean theRHSisOCL = call.getParameter(0) instanceof OCLFeatureCall;
                if (theRHSisOCL) {
                    OCLFeatureCall call2 = (OCLFeatureCall) call.getParameter(0);
                    if (call2.getOperation().equals(OclKeyWords.EQUALS) && call2.getParameterCount() == 1) {
                        if (call2.getOperand() instanceof Variable || call2.getOperand() instanceof CompoundAccess) {
                            operationTyp = 2;
                        }
                    }
                }
            } else {
                operationTyp = 1;
            }
        }
        
        return operationTyp;
    }
    
    /**
     * Execute the constraint within the compound.
     * @param call OCL Call.
     * @param constraint The exact constraint in the compound.
     */
    private void executeHardCompoundConstraint(OCLFeatureCall call, Constraint constraint) {
        attributeConstraints = new AssignmentAttributeConstraints();
        attributeConstraints.visitOclFeatureCall(call);
        String ruleCounter = AssignmentAttributeConstraints.getAttributeRuleCounter();
        constraintsInAttributeAssignmentMap.put(ruleCounter, constraint);
        hardConstraints.add(attributeConstraints.getRule() + "\n");
    }

    /**
     * Method to process the nested element of the compound.
     * @param compoundName Name of the compound.
     * @param defValInd indicator if the compound is fully configured.
     * @param declTemp Current nested element being visited.
     * @return an increment of defValInd if the current nested element has a default value.
     */
    private int visitCompoundElement(String compoundName, int defValInd, 
            DecisionVariableDeclaration declTemp) {
        this.variableMap.put(declTemp.getName(), declTemp.getType());
        compDeclaration += "\n \t";
        compDeclaration += declTemp.getName();
        compDeclaration += " : ";
        visitingNested = true;
        declTemp.getType().accept(this);
        if (null != declTemp.getDefaultValue()) {
            defValInd++;
            dList.add(compoundName + "." + declTemp);
            declTemp.getDefaultValue().accept(this);
            nestedDefaults.add(declTemp.getName());
        }
        if (declTemp.getType() instanceof Compound) {
            logger.info("compound type nested element " + compoundName 
                    + " ->  " + declTemp.getName());
        }
        visitingNested = false;
        return defValInd;
    }

    @Override
    public void visitDerivedDatatype(DerivedDatatype datatype) {
        
    }

    @Override
    public void visitEnumLiteral(EnumLiteral literal) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visitReference(Reference reference) {
        reference.getType().accept(this);

    }

    @Override
    public void visitSequence(Sequence sequence) {
        if (visitingNonNested) {
            this.declaration += "List";
        } else if (visitingNested) {
            compDeclaration += "List";
        }
    }

    @Override
    public void visitSet(Set set) {
        if (visitingNonNested) {
            this.declaration += "Set";
        } else if (visitingNested) {
            compDeclaration += "Set";
        }
    }

    @Override
    public void visitProject(Project project) {
        abortReasoning = false;
        String name = project.getName();
        dPrinter = new DroolsPrinter();
        if (evaluationChecking) {
            name += "_eval";
        }
        (new DroolsDelegationVisitor()).addDroolsGlobals(name, dPrinter);
        
        
        for (int i = 0; i < project.getElementCount(); i++) {
            if (project.getElement(i) instanceof DecisionVariableDeclaration
                    && ((DecisionVariableDeclaration) project.getElement(i)).getType() instanceof Compound) {
                DecisionVariableDeclaration decl = (DecisionVariableDeclaration) project.getElement(i);
                if (compMap2.containsKey(decl.getType().getName())) {
                    compMap2.get(decl.getType().getName()).add(decl.getName());
                } else {
                    compMap2.put(decl.getType().getName(), new ArrayList<String>());
                    compMap2.get(decl.getType().getName()).add(decl.getName());
                }
            }
        }
    }

    @Override
    public void visitProjectImport(ProjectImport pImport) {
        
        Project importedProject = pImport.getResolved();
//        logger.info("name of the project import " + importedProject.getName());
//        logger.info("\ttotal elements " + importedProject.getElementCount());
//        logger.info("\ttotal internal constraints " + importedProject.getInternalConstraintCount());
        
        importedProjectName = pImport.getProjectName();
        int count = ruleCount;
        for (int i = 0; i < importedProject.getElementCount(); i++) { 
            this.ruleMapper.put(ruleCount, importedProject.getElement(i));
            importedProject.getElement(i).accept((IModelVisitor) this);
            ruleCount++;
            count++;
        }
        
        importedProjectMap.put(importedProjectName, count);
        variablesAssigned.removeAll(variablesAssigned);
        importedProjectName = "";
    }

    @Override
    public void visitDecisionVariableDeclaration(DecisionVariableDeclaration decl) {
        this.visitingNonNested = true;
        String name = decl.getName();
        
        if (declarationToBeUpdated) {
            this.variableMap.put(name, decl.getType());
        }
        
        this.declaration = name;
        declaration += " : ";
        performOptimization(decl);

        /**
         * if a Declaration. is a compound type and any of its nested elements have default values,
         * then "Declaration.NestedElement" is added to the drools dList.
         */
        if (decl.getType().getTypeClass().equals(Compound.class)) {
            processCompoundTypeDeclaration(decl);
        }
        if (decl.getDefaultValue() instanceof ConstraintSyntaxTree 
                && !(decl.getDefaultValue() instanceof ConstantValue)) {
            ConstraintSyntaxTree call = (ConstraintSyntaxTree) decl.getDefaultValue();
            Variable var = new Variable(decl);
            OCLFeatureCall valueCall = new OCLFeatureCall(var, OclKeyWords.ASSIGNMENT, call);
            valueCall.accept(this);
            configuredByDefaultList.add(decl.getName());
        } else if (null != decl.getDefaultValue() && !(decl.getType() instanceof Container)) {
            dList.add(name);
            if (!(decl.getType() instanceof Compound)) {
                decl.getDefaultValue().accept(this);
            } else {
                visitingNonNested = false; visitingConfiguration = true;
                decl.getDefaultValue().accept(this);
                configMap.put(name, value);
                this.value = "";
                variablesAssigned.add(name);
            }
            configuredByDefaultList.add(decl.getName());
        } 
        if (decl.getType().getTypeClass().equals(Reference.class) && !isBasicType(decl.getType().getName())) {
            String typ = decl.getType().getName();
            String val = " new " + typ + "()";
            configMap.put(decl.getName(), val);
        }
        declaration += "\n";
        this.dVariables.add(name);
        if (droolsClassMap.containsKey(name)) {
            this.decisionVariables.add(declaration);
        }
        declaration = "";
        visitingNonNested = false;
        value = "";
        if (decl.getType().getTypeClass().equals(Compound.class)) {
            Compound c = (Compound) decl.getType();
            for (int i = 0; i < c.getElementCount(); i++) {
                if (nestedDefaults.contains(c.getElement(i).getName())) {
                    dList.add(name + "." + c.getElement(i));
                } 
            }
        }
        visitDecisionVariableDeclarationAttributes(decl);
    }


    /**
     * Method performing optimization.
     * @param decl DecisionVariabledeclaration.
     */
    private void performOptimization(DecisionVariableDeclaration decl) {
        String name = decl.getName();
        isPrimitiveType = false;
        decl.getType().accept(this);
        if (optimize) {
            if (isPrimitiveType) {
                if (DroolsVariablesPreProcessor.getVariablesUsed().contains(name)) {
                    droolsClassMap.put(name, totalDecls);
                    totalDecls++;
                } 
            } else {
                droolsClassMap.put(name, totalDecls);
                totalDecls++;
            }
        } else {
            droolsClassMap.put(name, totalDecls);
            totalDecls++;
        }
    }


    /**
     * Method to process all the attributes associated with a decision variable declaration.
     * @param decl Declaration.
     */
    private void visitDecisionVariableDeclarationAttributes(DecisionVariableDeclaration decl) {
        String name = decl.getName();
        for (int i = 0; i < decl.getAttributesCount(); i++) {
            Attribute attr = new Attribute("$attr_" + name + "_" + decl.getAttribute(i).getName(), 
                    decl.getAttribute(i).getType(), decl.getAttribute(i).getParent(), 
                    decl.getAttribute(i).getElement());
            attr.accept((IModelVisitor) this);
            droolsClassMap.put("$attr_" + name + "_" + decl.getAttribute(i).getName(), totalDecls);
            totalDecls++;
           
        }
    }

    

    /**
     * Method to process declarations of a compound type.
     * @param decl Declaration.
     */
    private void processCompoundTypeDeclaration(DecisionVariableDeclaration decl) {
        String name = decl.getName();
        String cName = decl.getType().getName();
        if (compMap.containsKey(cName)) {
            List<String> compMapD = compMap.get(cName);
            for (int i = 0; i < compMapD.size(); i++) {
                dList.add(name + "." + compMapD.get(i));
            }
        } 
        
    }
    
    /**
     * Method to check if a given nested element type is a basic type.  
     * @param typeName type name.
     * @return <True> if the type is either String, Integer, Double or Boolean. 
     */
    private boolean isBasicType(String typeName) {
        boolean result = true;
        if (typeName.equals("String")) {
            result = true;
        } else if (typeName.equals("Boolean")) {
            result = true;
        } else if (typeName.equals("Integer")) {
            result = true;
        } else if (typeName.equals("Real")) {
            result = true;
        } else {
            result = false;
        }
        
        return result;
    }

    @Override
    public void visitAttribute(Attribute attribute) {
        
        variableMap.put(attribute.getName(), attribute.getType());
        this.visitingNonNested = true;
        declaration = "";
        declaration += attribute.getName() + " : ";
        attribute.getType().accept(this);
        if (null != attribute.getDefaultValue()) {
            attribute.getDefaultValue().accept(this);
            dList.add(attribute.getName());
        }
        visitingNonNested = false;
        declaration += "\n";
        if (!decisionVariables.contains(declaration)) {
            this.decisionVariables.add(declaration);
            droolsClassMap.put(attribute.getName(), totalDecls);
            totalDecls++;
            dVariables.add(attribute.getName());
        }
        declaration = "";
        
    }

    @Override
    public void visitConstraint(Constraint constraint) {
        constraint.getConsSyntax().accept(this);
        
    }

    @Override
    public void visitFreezeBlock(FreezeBlock freeze) {
        String rule = (new DroolsDelegationVisitor()).getRuleForFreezeBlock(freeze, ruleCount, importedProjectName);

        assgnConstraints.add(rule);
        
    }

    @Override
    public void visitOperationDefinition(OperationDefinition opdef) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visitPartialEvaluationBlock(PartialEvaluationBlock block) {
        for (int i = 0; i < block.getEvaluableCount(); i++) {
            DroolsConstraintVisitor.setRuleCounter();
            block.getEvaluable(i).accept(this);
        }
        DroolsConstraintVisitor.deactivateRuleCounter();
        
    }

    @Override
    public void visitProjectInterface(ProjectInterface iface) {
        // TODO Auto-generated method stub
    }

    @Override
    public void visitDatatype(IDatatype datatype) {
        // TODO Auto-generated method stub
    }

    @Override
    public void visitAnyType(AnyType datatype) {
        // TODO Auto-generated method stub
    }

    @Override
    public void visitMetaType(MetaType datatype) {
        // TODO Auto-generated method stub
    }

    @Override
    public void visitDerivedType(DerivedDatatype datatype) {
        String type = "";
        int primitiveType = 0;
        if (IntegerType.TYPE.isAssignableFrom(datatype.getBasisType())) {
            type = "int";
        } else if (RealType.TYPE.isAssignableFrom(datatype.getBasisType())) {
            type = "double";
        } else if (BooleanType.TYPE.isAssignableFrom(datatype.getBasisType())) {
            type = "boolean";
        } else if (StringType.TYPE.isAssignableFrom(datatype.getBasisType())) {
            type = "String";
        } else if (Set.TYPE.isAssignableFrom(datatype.getBasisType())) {
            type = "Set";
            primitiveType = 1;
        } else if (Sequence.TYPE.isAssignableFrom(datatype.getBasisType())) {
            type = "List";
            primitiveType = 1;
        } else if (Enum.TYPE.isAssignableFrom(datatype.getBasisType())) {
            type = "int";
        } else if (OrderedEnum.TYPE.isAssignableFrom(datatype.getBasisType())) {
            type = "int";
        }
        if (visitingNested) {
            compDeclaration += type;
        } else if (visitingNonNested) {
            declaration += type;
            if (primitiveType == 0) {
                isPrimitiveType = true;
            }
        }
    }

    @Override
    public void visitBooleanType(BooleanType type) {
        
        if (visitingNonNested) {
            this.declaration += "Boolean";
            isPrimitiveType = true;
        } else if (visitingNested) {
            compDeclaration += "Boolean";
        }
    }

    @Override
    public void visitConstraintType(ConstraintType type) {
        // TODO handle constraint which may change during runtime
    }
    
    @Override
    public void visitStringType(StringType type) {
        if (this.visitingNonNested) {
            this.declaration += "String";
            isPrimitiveType = true;
        } else if (visitingNested) {
            compDeclaration += "String";
        }
    }

    @Override
    public void visitIntegerType(IntegerType type) {
        if (this.visitingNonNested) {
            this.declaration += "int";
            isPrimitiveType = true;
        } else if (visitingNested) {
            compDeclaration += "int";
        }
    }

    @Override
    public void visitRealType(RealType type) {
        if (visitingNonNested) {
            this.declaration += "double";
            isPrimitiveType = true;
        } else if (visitingNested) {
            compDeclaration += "double";
        }
    }

    @Override
    public void visitCompoundType(Compound compound) {
        if (visitingNonNested) {
            this.declaration += compound.getName();
        } else if (visitingNested) {
            compDeclaration += compound.getName();
        }
    }

    @Override
    public void visitEnumType(Enum enumType) {
        if (visitingNonNested) {
            this.declaration += "int";
            isPrimitiveType = true;
        } else if (visitingNested) {
            compDeclaration += "int";
        }
    }

    @Override
    public void visitOrderedEnumType(OrderedEnum enumType) {
        if (visitingNonNested) {
            this.declaration += "int";
            isPrimitiveType = true;
        } else if (visitingNested) {
            compDeclaration += "int";
        }
    }
    @Override
    public void visitConstantValue(ConstantValue value) {
        value.getConstantValue().accept(this);
    }
    @Override
    public void visitVariable(Variable variable) {
//        logger.info("compound is " + variable.getVariable().getName());
//        logger.info("ca slot " + variable.getVariable().getName() + compoundAccessSlot);
        compoundAccessSlot = variable.getVariable().getName() + compoundAccessSlot;
        
    }
    
    @Override
    public void visitAnnotationVariable(AttributeVariable variable) {
        // TODO check whether specific method is needed
        visitVariable(variable);
    }
    
    @Override
    public void visitParenthesis(Parenthesis parenthesis) {
        // TODO Auto-generated method stub
        
    }
    
    /**
     * {@inheritDoc}
     */
    public void visitContainerInitializer(ContainerInitializer init) {
        // TODO check
    }
    
    /**
     * {@inheritDoc}
     */
    public void visitCompoundInitializer(CompoundInitializer init) {
        // TODO check
    }
   
    /**
     * Operation is neither assignment not equals - pure hard constraint.
     * Operation is  equals (==): 
     *      if operand is variable -> execute method: processModificationForVariable
     *      if operand is compoundAccess -> execute method: processModificationForCompoundAccess.
     *      
     * {@inheritDoc} 
     */
    @Override
    public void visitOclFeatureCall(OCLFeatureCall call) {
        boolean operationIsEquals = (call.getOperation().equals(OclKeyWords.EQUALS)); 
        boolean operationIsAssignment = (call.getOperation().equals(OclKeyWords.ASSIGNMENT));
        if (!operationIsEquals && !operationIsAssignment) {
            hardConstraintsCalls(call);
        } else if (operationIsEquals) {
            if ((call.getOperand() instanceof Variable) 
                    || (call.getOperand() instanceof CompoundAccess)) {
                if (!evaluationCalls) {
                    
//                    addPureHardConstraint(call, constraint, true);
                    String constraintRule = getModifiedConstraintCall(call);
                    if ((call.getOperand() instanceof Variable)) {
                        processModificationForVariable(call, constraintRule); 
                        
                    } else if (call.getOperand() instanceof CompoundAccess) {
                        processModificationForCompoundAccess(call, constraintRule);
                    }
                    
                } else {
                    hardConstraintsCalls(call);
                }
                
            } else if (call.getOperand() instanceof ConstantValue) {
                ConstantValue cv = (ConstantValue) call.getOperand();
                if (cv.getConstantValue() instanceof ReferenceValue) {
                    assgnConstraintsCalls(call);
                } else {
                    hardConstraintsCalls(call);
                }
            } else {
                hardConstraintsCalls(call);
            }
        } else if (operationIsAssignment) {
            if (call.getOperand() instanceof Variable) {
                String varname = ((Variable) call.getOperand()).getVariable().getName();
                Variable var = (Variable) call.getOperand();
                if (!(var.getVariable() instanceof Attribute)) {
                    if (variablesAssigned.contains(varname)) {
                        abortReasoning = true;
                        assgnConstraintsCalls(call);
                    } else if (!variablesAssigned.contains(varname)) {
                        variablesAssigned.add(varname);
                        assgnConstraintsCalls(call);
                    }
                } else {
                    assgnConstraintsCalls(call);
                }
            } else if (call.getOperand() instanceof CompoundAccess) {
                assgnConstraintsCalls(call);
            } else {
                hardConstraintsCalls(call);
            }
        }
    }
    
    @Override
    public void visitMultiAndExpression(MultiAndExpression expression) {
        for (int e = 0; e < expression.getExpressionCount(); e++) {
            expression.getExpression(e).accept(this);
        }
    }

    /**
     * Process modification rules, where operand is a compound access.
     * @param call OCL Call.
     * @param constraintRule A string representation of Drools "not" of this this call.
     */
    private void processModificationForCompoundAccess(OCLFeatureCall call, 
            String constraintRule) {
        compoundAccessSlot = "";
        call.getOperand().accept(this);
        assgnConstraintsCalls(call);
        
        compoundAccessSlot = "";
        CompoundAccess cac = (CompoundAccess) call.getOperand();
        boolean isContainer = cac.getResolvedSlot().getType().getTypeClass().equals(Sequence.class)
                || cac.getResolvedSlot().getType().getTypeClass().equals(Set.class);
        if (!(isContainer && (call.getParameter(0) instanceof ConstantValue))) {
            logger.info("");
            //TODO: NOT SURE, TO BE IMPLEMENTED
        }
        hardConstraints.add(constraintRule);
    }


    /**
     * Process modification rules, where operand is a variable.
     * @param call OCL Call.
     * @param constraintRule A string representation of Drools "not" of this this call.
     */
    private void processModificationForVariable(OCLFeatureCall call, 
            String constraintRule) {
        Variable var = (Variable) call.getOperand();
        String name = ((Variable) call.getOperand()).getVariable().getName();
        assgnConstraintsCalls(call);
        addAssinmentConstraintsToMap(constraintRule, name);
        configuredByDefaultList.add(name);
        
        boolean varIsContainer = var.getVariable().getType().getTypeClass().equals(Sequence.class)
                || var.getVariable().getType().getTypeClass().equals(Set.class);
//                        boolean varIsCompound = var.getVariable().getType().getTypeClass().equals(Compound.class);
        if (!varIsContainer ) {
            logger.info("");
        }
    }


    /**
     * Private method that adds rules that are converted to hard constraints to a map.
     * @param constraintRule Hard constraint rule.
     * @param name Name of the variable that is associated with the hard constarint.
     */
    private void addAssinmentConstraintsToMap(String constraintRule, String name) {
        hardConstraints.add(constraintRule);
    }


    /**
     * A modification related call/expression is translated into an equivalent negation call.
     * For example, a == 5, is also passed to the reasoner as : (not (not (a == 5))) 
     * @param call OCLFeatureCall.
     * @return Rule.
     */
    private String getModifiedConstraintCall(OCLFeatureCall call) {
        DroolsEqualityEvaluator evaluator = new DroolsEqualityEvaluator();
        OCLFeatureCall call4 = new OCLFeatureCall(call, "not");
        OCLFeatureCall call5 = new OCLFeatureCall(call4, "not");
        evaluator.setRuleCount(0 - ruleCount);
        evaluator.visitOclFeatureCall(call5);
        
        return evaluator.getRule();
    }
    
    

    

    /**
     * A private method to process OCL calls that are assignment constraints.
     * @param call OCL Call.
     */
    private void assgnConstraintsCalls(OCLFeatureCall call) {
        boolean toAdd = true; 
        if (call.getOperand() instanceof Variable) {
            Variable var = (Variable) call.getOperand();
            String varName = var.getVariable().getName();
            if (!DroolsVariablesPreProcessor.getVariablesUsed().contains(varName)
                    && optimize
                    && !var.getVariable().getType().isAssignableFrom(Compound.TYPE)) {
                toAdd = false;
            }
        }
        
        if (toAdd) {
            droolsAssgnVis = new DroolsAssignmentsVisitor();
            DroolsAssignmentsVisitor.setRuleCount(ruleCount);
            droolsAssgnVis.visitOclFeatureCall(call);
            if (droolsAssgnVis.isRuleNotSupported()) {
                logger.info("rule not supported is " + ruleCount);
                listofUnsupportedRules.add(ruleCount);
            }
            String rule = droolsAssgnVis.getRule();
            assgnConstraints.add(rule);
        }
        
        
        
    }
    /**
     * A private method to process OCL calls that are hard constraints.
     * @param call OCL call.
     */
    private void hardConstraintsCalls(OCLFeatureCall call) {
        
        
        /*
         * Implies calls. Two kinds of expressions are passed. One, modification & the second, 
         * validation expression.
         */
        if (call.getOperation().equals(OclKeyWords.IMPLIES) && (call.getParameter(0) instanceof OCLFeatureCall)) {
            OCLFeatureCall call1 = (OCLFeatureCall) call.getParameter(0);
            if (call1.getOperation().equals("=") || call1.getOperation().equals("==")) {
                boolean isCompoundValue = false;
                if (call1.getParameter(0) instanceof ConstantValue) {
                    ConstantValue val = (ConstantValue) call1.getParameter(0);
                    isCompoundValue = val.getConstantValue() instanceof CompoundValue;
                }
                if ((call1.getOperand() instanceof Variable)
                        && !isCompoundValue) {
                    writeExpressionsWithDecisionvariables(call);
                    DroolsImpliesEvaluator impEval = new DroolsImpliesEvaluator();
                    impEval.setRuleCount(0 - ruleCount);
                    impEval.visitOclFeatureCall(call);
                    hardConstraints.add(impEval.getRule());
                } else if (call1.getOperand() instanceof CompoundAccess
                        && !isCompoundValue) {
                    compoundAccessSlot = "";
                    DroolsImpliesEvaluator impEval = new DroolsImpliesEvaluator();
                    impEval.setRuleCount(0 - ruleCount);
                    impEval.visitOclFeatureCall(call);
                    hardConstraints.add(impEval.getRule());
                    call1.getOperand().accept(this);
                    addValidationRule(call);
//                    if (!DroolsEngine.getAssignedVariables().contains(compoundAccessSlot)) {
//                    }
                    compoundAccessSlot = "";
                } else {
                    //Little ambiguous about this part, therefore as a separate block. 
                    logger.info("");
                    addValidationRule(call);
                }
            } else {
                addValidationRule(call);
            }
        } else {
            addValidationRule(call);
        }
    }


    /**
     * Method to get the rules for decision variables in the implication calls.
     * @param call OCLFeatureCall
     */
    private void writeExpressionsWithDecisionvariables(OCLFeatureCall call) {
        OCLFeatureCall call1 = (OCLFeatureCall) call.getParameter(0);
        String varName = ((Variable) call1.getOperand()).getVariable().getName();
        //Stopping passing a hard constraint for implies based value modification.
//        addAssinmentConstraintsToMap(constraintRule, varName);
        droolsConstraintVis = new DroolsConstraintVisitor();
        droolsConstraintVis.setRuleCount(ruleCount);
        droolsConstraintVis.visitOclFeatureCall(call);
        String rule = droolsConstraintVis.getRule();
        addAssinmentConstraintsToMap(rule, varName);
    }


    /**
     * Adds a rule that validates the given constraint.
     * @param call OCL Feature call expression.
     */
    private void addValidationRule(OCLFeatureCall call) {
        droolsConstraintVis = new DroolsConstraintVisitor();
        droolsConstraintVis.setRuleCount(ruleCount);
        droolsConstraintVis.visitOclFeatureCall(call);
        String rule = droolsConstraintVis.getRule();
        hardConstraints.add(rule);
        if (!droolsConstraintVis.isRuleSupported()) {
            listofUnsupportedRules.add(ruleCount);
        }
    }
    @Override
    public void visitLet(Let let) {
        droolsConstraintVis = new DroolsConstraintVisitor();
        declarationToBeUpdated = false;
        DecisionVariableDeclaration decl = let.getVariable();
        DecisionVariableDeclaration decl2 = new DecisionVariableDeclaration(decl.getName(), 
                decl.getType(), decl.getParent());
        droolsClassMap.put(decl.getName(), totalDecls);
        totalDecls++;
        
        try {
            decl2.setValue(let.getVariable().getDefaultValue());
        } catch (ValueDoesNotMatchTypeException e) {
            e.printStackTrace();
        } catch (CSTSemanticException e) {
            e.printStackTrace();
        }
        
        decl2.accept((IModelVisitor) this);
        if (let.getInExpression() instanceof OCLFeatureCall) {
            OCLFeatureCall call1 = (OCLFeatureCall) let.getInExpression();
            DroolsConstraintVisitor.setRuleCounter();
            droolsConstraintVis.setRuleCount(ruleCount);
//            droolsConstraintVis.setLetSuffix(Integer.toString(ruleCount));
            droolsConstraintVis.visitOclFeatureCall(call1);
            hardConstraints.add(droolsConstraintVis.getRule());
            DroolsConstraintVisitor.deactivateRuleCounter();
        }
        declarationToBeUpdated = true;
        
    }
    @Override
    public void visitIfThen(IfThen ifThen) {
        ConstraintSyntaxTree cst = ifThen.getIfExpr();
        ConstraintSyntaxTree cstThen = ifThen.getThenExpr();
        ConstraintSyntaxTree cstElse = ifThen.getElseExpr();
        OCLFeatureCall call1 = new OCLFeatureCall(cst, OclKeyWords.IMPLIES, cstThen);
        OCLFeatureCall notCall = new OCLFeatureCall(cst, OclKeyWords.NOT);
        OCLFeatureCall call2 = new OCLFeatureCall(notCall, OclKeyWords.IMPLIES, cstElse);
//        hardConstraintsCalls(call1);
        createIfThenElseConstraint(call1);
        ruleCount = 0 - ruleCount;
//        hardConstraintsCalls(call2);
        createIfThenElseConstraint(call2);
        
    }
    
    /**
     * Creating of reformed constraints specific to if-then-else expressions.
     * @param call If-then-else OCLFeaturesCall.
     */
    private void createIfThenElseConstraint(OCLFeatureCall call) {
        droolsConstraintVis = new DroolsConstraintVisitor();
        droolsConstraintVis.setRuleCount(ruleCount);
        OCLFeatureCall call1 = new OCLFeatureCall(call, "not");
        OCLFeatureCall reformedCall = new OCLFeatureCall(call1, "not");
        
        droolsConstraintVis.visitOclFeatureCall(reformedCall);
        String rule = droolsConstraintVis.getRule();
        hardConstraints.add(rule);
        if (!droolsConstraintVis.isRuleSupported()) {
            listofUnsupportedRules.add(ruleCount);
        }
        
        String s = ruleCount + "." + Math.abs(ruleCount);
        double r = Double.parseDouble(s);
        droolsConstraintVis = new DroolsConstraintVisitor();
        droolsConstraintVis.setRuleCount(r);
        droolsConstraintVis.visitOclFeatureCall(call);
        hardConstraints.add(droolsConstraintVis.getRule());
        
    }
    
    @Override
    public void visitContainerOperationCall(ContainerOperationCall call) {
        droolsConstraintVis = new DroolsConstraintVisitor();
        droolsConstraintVis.setRuleCount(ruleCount);
        droolsConstraintVis.visitContainerOperationCall(call);
        String rule = droolsConstraintVis.getRule();
        hardConstraints.add(rule);
    }
    @Override
    public void visitCompoundAccess(CompoundAccess access) {
        String slot = access.getSlotName();
        compoundAccessSlot += "." + slot;
        access.getCompoundExpression().accept(this);
    }
    @Override
    public void visitUnresolvedExpression(UnresolvedExpression expression) {
        
    }
    @Override
    public void visitEnumValue(EnumValue value) {
        
        if (this.visitingNonNested) {
            if (visitingConatinerValue) {
                this.value += "new Integer(" + value.getValue().getOrdinal() + ")";
            } else {
                this.declaration += " = " + value.getValue().getOrdinal();
            }
        } else if (visitingNested) {
            this.compDeclaration += " = " + value.getValue().getOrdinal();
        } else if (visitingConfiguration) {
            this.value += value.getValue().getOrdinal();
        }
     
        
    }

    @Override
    public void visitConstraintValue(ConstraintValue value) {
    }
    
    /**
     * Method to process string and put back the escape sequences.
     * @param str String
     * @return Processed string.
     */
    public static String processStringEscapeSequences(String str) {
        
        str = str.replace("\\", "\\\\");
        str = str.replace("\"", "\\\"");
        str = str.replace("\'", "\\\'");
        str = str.replace("\n", "\\n");
        str = str.replace("\t", "\\t");
        str = str.replace("\r", "\\r");
        
        return str;
    }

    @Override
    public void visitStringValue(StringValue value) {
        String val = value.getValue();
        val = DroolsVisitor.processStringEscapeSequences(val);

        if (this.visitingNonNested) {
            if (visitingConatinerValue) {
                this.value += "\"" + val + "\"";
            } else {
                this.declaration += " = " + "\"" + val + "\"";
            }
        } else if (visitingNested) {
            if (visitingConatinerValue) {
                this.value += "\"" + val + "\"";
            } else {
                this.compDeclaration += " = " + "\"" + val + "\"";
            }
        } else if (visitingConfiguration) {
            this.value += "(\"" + val + "\")";
        }       
    }
    @Override
    public void visitCompoundValue(CompoundValue cValue) {
        String compoundName = cValue.getType().getName();
        Compound temp = (Compound) cValue.getType();
        value += "new " + compoundName + "(";
        if (cValue.isFullyConfigured()) {
            for (int i = 0; i < temp.getDeclarationCount(); i++) {
                String name = temp.getDeclaration(i).getName();
                if (cValue.getNestedValue(name) != null) {
                    cValue.getNestedValue(name).accept(this);  
                } else {
                    this.value += "null";
                }
                if (i != temp.getDeclarationCount() - 1) {
                    this.value += " , ";
                }
            }
        } else {
            this.value += "";
            
        }
        this.value += ")";
         
    }
    
        
     
    
    
    @Override
    public void visitContainerValue(ContainerValue cValue) {
        boolean setValue = Set.TYPE.isAssignableFrom(cValue.getType());
        if (cValue.getElementSize() != 0) {
            if (!setValue) {
                this.value += " new java.util.ArrayList(java.util.Arrays.asList(";
            } else {
                this.value += " new java.util.HashSet(java.util.Arrays.asList(";
            }
            this.visitingConatinerValue = true;
            for (int i = 0; i < cValue.getElementSize(); i++) {
                if (cValue.getElement(i) instanceof ContainerValue) {
                    visitingConfiguration = true;
                }
                cValue.getElement(i).accept(this);
                if (i != cValue.getElementSize() - 1) {
                    this.value += " , ";
                }
                
            }
            this.value += "))"; 
            if (visitingNonNested) {
                declaration += " = " + this.value;
            } else if (visitingNested) {
                compDeclaration += " = " + this.value;
            } 
            visitingConatinerValue = false;
            if (!visitingConfiguration) {
                this.value = "";
            }
        }
        
    }
    @Override
    public void visitIntValue(IntValue value) {
        if (this.visitingNonNested) {
            if (visitingConatinerValue) {
                this.value += value.getValue();
            } else {
                this.declaration += " = " + value.getValue();
            }
        } else if (visitingNested) {
            if (visitingConatinerValue) {
                this.value += value.getValue();
            } else {
                this.compDeclaration += " = " + value.getValue();
            }
        } else if (visitingConfiguration) {
            this.value += value.getValue();
        }
    }
    @Override
    public void visitRealValue(RealValue value) {
        if (this.visitingNonNested) {
            if (visitingConatinerValue) {
                this.value += value.getValue();
            } else {
                this.declaration += " = " + value.getValue();
            }
        } else if (visitingNested) {
            if (visitingConatinerValue) {
                this.value += value.getValue();
            } else {
                this.compDeclaration += " = " + value.getValue();
            }
        } else if (visitingConfiguration) {
            this.value += value.getValue();
        }      
    }
    @Override
    public void visitBooleanValue(BooleanValue value) {
        if (this.visitingNonNested) {
            if (visitingConatinerValue) {
                this.value += "" + value.getValue();
            } else {
                this.declaration += " = " + value.getValue();
            }
        } else if (visitingNested) {
            if (visitingConatinerValue) {
                this.value += value.getValue();
            } else {
                this.compDeclaration += " = " + value.getValue();
            }
        } else if (visitingConfiguration) {
            this.value += value.getValue();
        }
    }
    @Override
    public void visitReferenceValue(ReferenceValue referenceValue) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void visitMetaTypeValue(MetaTypeValue value) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void visitConfiguration(Configuration configuration) {
        addProjectClass();
        Iterator<IDecisionVariable> iterator = configuration.iterator();    
        while (iterator.hasNext()) {
            iterator.next().accept((IConfigurationVisitor) this);
        }
        long inTime = System.currentTimeMillis();
        dPrinter.addConfig(configMap, configMap2);
        dPrinter.addFacts(factList);
        
        long outTime = System.currentTimeMillis();
        logger.info("total time spent in config method " + (outTime - inTime) / 1000.0);
        
        (new DroolsDelegationVisitor()).addRules(dPrinter, assgnConstraints, hardConstraints);
        
    }
    
    
    @Override
    public void visitDecisionVariable(IDecisionVariable variable) {
        String name = variable.getDeclaration().getName();
        if (variable.getValue() instanceof CompoundValue) {
            
            CompoundValue cv = (CompoundValue) variable.getValue();
            cv.accept(this);
            Compound comp = (Compound) cv.getType();
            factList.add(name);
            int thr = DroolsVisitor.getDroolsClasseMap().get(name) / DroolsVisitor.THRESHOLD;
            if (cv.isConfigured()) {
                partialCompoundV("P" + thr + "." + name, cv);
                dList.add(name);
            } else {
                partialCompoundV("P" + thr + "." + name, cv);
                visitAttributeAssignmentBlockValue(cv, comp);
            }
        } 
        
        Class<? extends IDatatype> varClass = variable.getDeclaration().getType().getTypeClass();
        if (varClass.equals(Sequence.class) || varClass.equals(Set.class)) {
            ContainerValue contV1 = (ContainerValue) variable.getValue();
            if (contV1 == null) {
                String contName = variable.getDeclaration().getName();
                this.configMap.put(contName, null);
            } 
            
        }
        
        if ((null != variable.getValue() && (variable.getState() != AssignmentState.DEFAULT)) 
                || variable.getValue() instanceof CompoundValue) {
            this.value = "";
            this.visitingConfiguration = true;
            if ((variable.getValue().isConfigured())) {
                dList.add(name);
            }

            variable.getValue().accept(this);
            
            if (!configMap.containsKey(name)) {
                this.configMap.put(name, value);
            }
            if (variable.getDeclaration().getType().getClass().equals(Compound.class)) {
                facts.add(variable.getDeclaration().getName());
            }
            this.value = "";
        }
        
    }

    /**
     * Method to parse and translate impartial compound assignments.
     * @param name name of the variable.
     * @param cv Variable's compound value.
     */
    private void partialCompoundV(String name, CompoundValue cv) {
        Compound temp = (Compound) cv.getType();
        for (int i = 0; i < temp.getElementCount(); i++) {
            String nName = temp.getElement(i).getName();
            Value val = cv.getNestedValue(nName);
            if (null != val && !(val instanceof CompoundValue)) {
                String k = name;
                int in = k.indexOf(".");
                String nK = k.substring(in + 1, k.length());
                dList.add(nK);
                if (val instanceof EnumValue) {
                    dList.add(name);
                    EnumValue ev = (EnumValue) val;
                    configMap2.put(name + "." + nName, Integer.toString(ev.getValue().getOrdinal()));
                } else if (val instanceof CompoundValue) {
                    logger.info("compV");
                } else if (!isNotACollection(temp.getType())) {
                    logger.info("Cannot process collection!");
                } else if (val instanceof StringValue) {
                    configMap2.put(name + "." + nName, "\"" + val.getValue().toString()
                            + "\"");
                } else {
                    dList.add(name);
                    if (val.getValue() != null) {
                        configMap2.put(name + "." + nName, val.getValue().toString());
                    }
                }
            } else if (val instanceof CompoundValue) {
                configMap2.put(name + "." + nName, " new " + temp.getElement(i).getType().getName() + "()");
                if (((CompoundValue) val).isConfigured()) {
                    CompoundValue cVal = (CompoundValue) val;
                    partialCompoundV(name + "." + nName, cVal);
                    
                }
                facts.add(name + "." + nName);
            }
            if ((val == null ) && (temp.getElement(i).getType() instanceof Compound)) {
                configMap2.put("##" +  name + "." + nName, " new " + temp.getElement(i).getType().getName() + "()");
                compounsInitializerInConfigurationGroup("##" + name + "." + nName, 
                        (Compound) temp.getElement(i).getType());
            }
        }
        
    }
    /**
     * Method that initializes the compounds used in the compound initializer expressions in the
     * configuration group.
     * @param name Name of the element in the compoundINIT which is compound type.
     * @param compound compound (Type)
     */
    private void compounsInitializerInConfigurationGroup(String name, Compound compound) {
        
        for (int i = 0; i < compound.getElementCount(); i++) {
            if (compound.getElement(i).getType() instanceof Compound) {
                String nName = compound.getElement(i).getName(); 
                configMap2.put(name + "." + nName, " new " + compound.getElement(i).getType().getName() + "()");
            }
        }
    }

    /**
     * Visiting configuration for the attribute assignment block.
     * @param cv value of the compound.
     * @param comp Compound.
     */
    private void visitAttributeAssignmentBlockValue(CompoundValue cv, Compound comp) {
        for (int i = 0; i < comp.getAssignmentCount(); i++) {
            AttributeAssignment assgn = comp.getAssignment(i);
            for (int j = 0; j < assgn.getModelElementCount() 
                    && (assgn.getModelElement(j) instanceof DecisionVariableDeclaration); j++) {
                
                Value consV = cv.getNestedValue(assgn.getModelElement(j).getName());
                if (null != consV) {
                    logger.info(" consV " + consV.getValue());
                } else {
                    logger.info("It is null/not configured");
                }
            }
        }
    }
    
    /**
     * Method to identify if a type is a collection.
     * @param type Type.
     * @return true if the type is a collection.
     */
    private boolean isNotACollection(IDatatype type) {
        boolean result = true;
        if (type.getTypeClass().equals(Sequence.class) || type.getTypeClass().equals(Set.class)) {
            result = false;
        }
        return result;
    }
    /**
     * A private method to add a project class in the drools .drl file.
     */
    private void addProjectClass() {
        
//        Adding drools project class
        (new DroolsDelegationVisitor()).addProjectClass(dPrinter, this.decisionVariables);
        
    }
    
    /**
     * Getter for the path of the .drl file.
     * @return Path of the file.
     * @throws IOException Throws exception if the file is not found.
     */
    public String getFilePath() throws IOException {
        return dPrinter.getFilePath();
    }

    @Override
    public void visitComment(Comment comment) {
        // TODO Auto-generated method stub
    }

    

    @Override
    public void visitComment(net.ssehub.easy.varModel.cst.Comment comment) {
        // TODO Auto-generated method stub
    }
    
    
    /**
     * Method to stop the translation process, stops writing to the .drl file.
     */
    public void closeProject() {
        totalDecls = 0;
        dPrinter.close();
    }

    @Override
    public void visitNullValue(NullValue value) {
        // TODO Auto-generated method stub
    }


    @Override
    public void visitCompoundAccessStatement(CompoundAccessStatement access) {
        // TODO Auto-generated method stub
    }


    @Override
    public void visitVersionValue(VersionValue value) {
        // TODO Auto-generated method stub
    }

    @Override
    public void visitVersionType(VersionType type) {
        // TODO Auto-generated method stub
    }

    @Override
    public void visitSelf(Self self) {
        // TODO Auto-generated method stub
    }
    
    @Override
    public void visitBlockExpression(BlockExpression block) {
        for (int e = 0, n = block.getExpressionCount(); e < n; e++) {
            block.getExpression(e).accept(this);
        }
    }

}
