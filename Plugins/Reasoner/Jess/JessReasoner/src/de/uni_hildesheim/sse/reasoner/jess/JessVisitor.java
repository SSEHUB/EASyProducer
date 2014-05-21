package de.uni_hildesheim.sse.reasoner.jess;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import de.uni_hildesheim.sse.model.confModel.Configuration;
import de.uni_hildesheim.sse.model.confModel.IConfigurationVisitor;
import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;
import de.uni_hildesheim.sse.model.cst.CSTSemanticException;
import de.uni_hildesheim.sse.model.cst.CompoundAccess;
import de.uni_hildesheim.sse.model.cst.CompoundInitializer;
import de.uni_hildesheim.sse.model.cst.ConstantValue;
import de.uni_hildesheim.sse.model.cst.ConstraintSyntaxTree;
import de.uni_hildesheim.sse.model.cst.ContainerInitializer;
import de.uni_hildesheim.sse.model.cst.ContainerOperationCall;
import de.uni_hildesheim.sse.model.cst.DslFragment;
import de.uni_hildesheim.sse.model.cst.IConstraintTreeVisitor;
import de.uni_hildesheim.sse.model.cst.IfThen;
import de.uni_hildesheim.sse.model.cst.Let;
import de.uni_hildesheim.sse.model.cst.OCLFeatureCall;
import de.uni_hildesheim.sse.model.cst.Parenthesis;
import de.uni_hildesheim.sse.model.cst.UnresolvedExpression;
import de.uni_hildesheim.sse.model.cst.Variable;
import de.uni_hildesheim.sse.model.varModel.Attribute;
import de.uni_hildesheim.sse.model.varModel.AttributeAssignment;
import de.uni_hildesheim.sse.model.varModel.Comment;
import de.uni_hildesheim.sse.model.varModel.Constraint;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.FreezeBlock;
import de.uni_hildesheim.sse.model.varModel.IModelVisitor;
import de.uni_hildesheim.sse.model.varModel.ModelElement;
import de.uni_hildesheim.sse.model.varModel.OperationDefinition;
import de.uni_hildesheim.sse.model.varModel.PartialEvaluationBlock;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.ProjectImport;
import de.uni_hildesheim.sse.model.varModel.ProjectInterface;
import de.uni_hildesheim.sse.model.varModel.datatypes.AnyType;
import de.uni_hildesheim.sse.model.varModel.datatypes.BooleanType;
import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
import de.uni_hildesheim.sse.model.varModel.datatypes.ConstraintType;
import de.uni_hildesheim.sse.model.varModel.datatypes.DerivedDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.Enum;
import de.uni_hildesheim.sse.model.varModel.datatypes.EnumLiteral;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatypeVisitor;
import de.uni_hildesheim.sse.model.varModel.datatypes.IntegerType;
import de.uni_hildesheim.sse.model.varModel.datatypes.MetaType;
import de.uni_hildesheim.sse.model.varModel.datatypes.OclKeyWords;
import de.uni_hildesheim.sse.model.varModel.datatypes.OrderedEnum;
import de.uni_hildesheim.sse.model.varModel.datatypes.RealType;
import de.uni_hildesheim.sse.model.varModel.datatypes.Reference;
import de.uni_hildesheim.sse.model.varModel.datatypes.Sequence;
import de.uni_hildesheim.sse.model.varModel.datatypes.Set;
import de.uni_hildesheim.sse.model.varModel.datatypes.StringType;
import de.uni_hildesheim.sse.model.varModel.values.BooleanValue;
import de.uni_hildesheim.sse.model.varModel.values.CompoundValue;
import de.uni_hildesheim.sse.model.varModel.values.ConstraintValue;
import de.uni_hildesheim.sse.model.varModel.values.ContainerValue;
import de.uni_hildesheim.sse.model.varModel.values.EnumValue;
import de.uni_hildesheim.sse.model.varModel.values.IValueVisitor;
import de.uni_hildesheim.sse.model.varModel.values.IntValue;
import de.uni_hildesheim.sse.model.varModel.values.MetaTypeValue;
import de.uni_hildesheim.sse.model.varModel.values.NullValue;
import de.uni_hildesheim.sse.model.varModel.values.RealValue;
import de.uni_hildesheim.sse.model.varModel.values.ReferenceValue;
import de.uni_hildesheim.sse.model.varModel.values.StringValue;

/**
 * Visitor clss for Jess reasoner. This class is supported by JessRulesVisitor class 
 * for Jess rules (constraints). 
 * @author saripalli
 *
 */
public class JessVisitor implements IModelVisitor, IValueVisitor, IConstraintTreeVisitor, 
    IDatatypeVisitor, IConfigurationVisitor {

    private static boolean optimization = false;
    

    private static int instance = 0;
    private static List<String> assignmentModules = new ArrayList<String>();
    

    private JessFileWriter jessWriter = new JessFileWriter();
    private Map<String, IDatatype> variableMap = new HashMap<String, IDatatype>();


    private String projectName;
    private Project project;
    private String config = "";
    private boolean projectVisted = false;
    private boolean compoundVisited = false;
    private boolean enumVisited = false;
    private boolean decVarVisited = false;
    private boolean intValueVisited = false;
    private boolean strValueVisited = false;
    
    private boolean compoundValueVisited = false;
    private boolean contValueVisited = false; 
    private boolean enumValueVisited = false;
    private String value = "";
    private List<String> valueList = new ArrayList<String>();
    
    private List<String> constraintModuleList = new ArrayList<String>();
    private List<String> modificationModuleList = new ArrayList<String>();
    
    private String ruleFinal = "";

    
    private boolean typeVisitor = false;
    private JessRulesVisitor jessRules = new JessRulesVisitor();
    private JessAssignmentVisitor jessAssignments = new JessAssignmentVisitor();
    private JessVariablesVisitor jessVariablesList = new JessVariablesVisitor();
    
    private HashMap<String, Integer> map = new HashMap<String, Integer>();  
    private List<String> compoundList = new ArrayList<String>();
    private List<Integer> nonSupportedRules = new ArrayList<Integer>();
    private Map<Integer, ModelElement> ruleMapper = new HashMap<Integer, ModelElement>();
    private int keyCount = 0;
    private List<ConstraintSyntaxTree> variablesVisited = new ArrayList<ConstraintSyntaxTree>();
    
   
    public static void setOptimization(boolean optimization) {
        JessVisitor.optimization = optimization;
    }
    
    /**
     * getter for the slot instance in a compound.
     * @return instance slot value of a compound (deftemplate)
     */
    public static int getInstance() {
        return instance;
    }
    
    /**
     * Getter for the list containing assignment modules.
     * @return assignmentModules.
     */
    public static List<String> getAssignmentModules() {
        return assignmentModules;
    }
    
    
    public static void incrementInstance() {
        instance++;
    }

    /**
     * Getter for rule mapper.
     * @return ruleMapper Map of model elements with a unique key.
     */
    public Map<Integer, ModelElement> getRuleMapper() {
        return ruleMapper;
    }

    /**
     * Getter for key count.
     * @return key count for rules.
     */
    public int getKeyCount() {
        return keyCount;
    }
    /**
     * Setter for key count.
     * @param keyCount Key count.
     */
    public void setKeyCount(int keyCount) {
        this.keyCount = keyCount;
    }
    /**
     * Getter for list of all rules not supportable.
     * @return Returns the list of rule numbers that are not supported by Jess.
     */
    public List<Integer> getNonSupportedRules() {
        return nonSupportedRules;
    }
    
    
    /**
     * Getter for the map containing names of the declarations and their types.
     * @return variablemap Map containing names of the declarations and their types..
     */
    public Map<String, IDatatype> getVariableMap() {
        return variableMap;
    }
    /**
     * Method to test if integer value has been visited. 
     * @return intValueVisited true if visited
     */
    public boolean isIntValueVisited() {
        return this.intValueVisited;
    }

    /**
     * Method to test if string value has been visited. 
     * @return strValueVisited true if visited
     */
    public boolean isStrValueVisited() {
                
        return this.strValueVisited;
    }

    /**
     * Method to test if enum value is visited.
     * @return true if enum value is visited.
     */
    public boolean isEnumValueVisited() {
        return enumValueVisited;
    }
    /**
     * Method to test if compoundvalue value has been visited. 
     * @return compoundValueVisited true if visited
     */
    public boolean isCompoundValueVisited() {
        return this.compoundValueVisited;
    }

    /**
     * Method to test if container value has been visited. 
     * @return contValueVisited true if visited
     */
    public boolean isContValueVisited() {
        return this.contValueVisited;
    }

   
    
    /**
     * Method to test if enum has been visited. 
     * @return enumVisited true if visited
     */
    public boolean isEnumVisited() {
        return this.enumVisited;
    }

    /**
     * Method to test if Decision variable has been visited. 
     * @return decVarVisited true if visited
     */
    public boolean isDecVarVisited() {
        return this.decVarVisited;
    }

    /**
     * Method to test if configuration is empty or configured correctly. 
     * @return config true if configured
     */
    public String getConfig() {
        return this.config;
    }

    /**
     * Method to test if project has been visited. 
     * @return projectVisited true if visited
     */
    public boolean isProjectVisted() {
        return this.projectVisted;
    }

    /**
     * Method to test if compound has been visited. 
     * @return compoundVisited true if visited 
     */
    public boolean isCompoundVisited() { 
        return this.compoundVisited;
    }
 
    /**
     * {@inheritDoc}
     */
    @Override
    public void visitCompound(Compound compound) {
        this.compoundList.add(compound.getName());
        String compoundExtension = "";
        
        if (compound.getRefines() == null) { 
            compoundExtension = "";
        } else { 
            compoundExtension = "extends " + compound.getRefines().getName();  
        }
    
        String compoundName = compound.getName();
        String name = "(deftemplate "  + compoundName +  " " + compoundExtension + "\n";
        jessWriter.append(name);
        
        String nameInitial = "(slot compound_name (type STRING) (default " + "\"" + compound.getName() + "\"";
        String compoundIntial = "\t" + nameInitial + " ))" + "\n"; 
        jessWriter.append(compoundIntial);
                
        String instanceSlot = "(slot instance (type ANY))\n";
        jessWriter.append(instanceSlot);
        //Uptil now, writing deftemplate declaration and writing the first default slot
        
        for (int i = 0; i < compound.getElementCount(); i++) {
            this.variableMap.put(compound.getElement(i).getName(), compound.getElement(i).getType());
            jessWriter.append("\t");
            compound.getElement(i).getType().accept(this);  
            jessWriter.append(" " + compound.getElement(i).getName()); 
                        
            jessWriter.append("(type ");
            compound.getElement(i).getType().accept(this);
            
            if (compound.getElement(i).getDefaultValue() != null) {
                jessWriter.append("(default ");
                compound.getElement(i).getDefaultValue().accept(this);
                jessWriter.append(this.value);
                this.value = "";
                jessWriter.append(")");
            } else {
                jessWriter.append("");
            }
            jessWriter.append(")\n");
        }
        String closeTemplate = ")" + "\n"; 
        jessWriter.append(closeTemplate);
        
        this.compoundVisited = true;
        
        // TODO [AttributeAssignment] visit attribute assignments
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitDerivedDatatype(DerivedDatatype arg0) {
           
        
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitOrderedEnum(OrderedEnum arg0) {
        String enumDecl = "(defglobal "; 
        jessWriter.append(enumDecl);
        
        String enumName = arg0.getName();
        int totalEnumLiterals = arg0.getLiteralCount(); 
        
        for (int i = 0; i < totalEnumLiterals; i++) {
            String enumDecl1 = "?*" + enumName + "_";
            jessWriter.append(enumDecl1);
            arg0.getLiteral(i).accept(this);
        }
        
        String closeTemplate = ")" + "\n";
        jessWriter.append(closeTemplate);
        
        this.enumVisited = true;   
        
    }
    

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitEnum(Enum arg0) {
        String enumDecl = "(defglobal "; 
        jessWriter.append(enumDecl);
       
        String enumName = arg0.getName();
        
        int totalEnumLiterals = arg0.getLiteralCount();
    
        for (int i = 0; i < totalEnumLiterals; i++) {
            String enumDecl1 = "?*" + enumName + "_";
            jessWriter.append(enumDecl1);
            arg0.getLiteral(i).accept(this);      
        }
  
        String closeTemplate = ")" + "\n";
        jessWriter.append(closeTemplate);
        
        this.enumVisited = true;  

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitEnumLiteral(EnumLiteral arg0) {
                
        String enumName = arg0.getName();
        map.put(enumName, new Integer(arg0.getOrdinal())); 
        String enumVal = "*" + " = " + arg0.getOrdinal() + " ";
        jessWriter.append(enumName + enumVal); 

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitReference(Reference arg0) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitSequence(Sequence arg0) {
        
        if (!this.typeVisitor) {
            jessWriter.append("(multislot "); 
            this.typeVisitor = true;
        } else {
            jessWriter.append("ANY)");
            this.typeVisitor = false;
        }

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitSet(Set arg0) {
        
        if (!this.typeVisitor) {
            jessWriter.append("(multislot "); 
            this.typeVisitor = true;
        } else {
            jessWriter.append("ANY)");
            this.typeVisitor = false;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitBooleanValue(BooleanValue arg0) {
        if (arg0.getValue() != null) {
            this.value += " " + arg0.getValue().toString().toUpperCase();
        } else {
            this.value += " nil";
        }
        
        
    } 

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitCompoundValue(CompoundValue value) {
         
        String compoundName = value.getType().getName();
        
        Compound temp = (Compound) value.getType();
        
        if (this.compoundList.contains(compoundName)) {
            this.compoundList.remove(compoundName);
        }
        
        this.value += "(assert (".concat(compoundName);
        
        for (int i = 0; i < temp.getElementCount(); i++) {
            String name = temp.getElement(i).getName();
            this.value += " (" + name + " ";
            if (value.getNestedValue(name) != null) {
                value.getNestedValue(name).accept(this);  
            } else {
                this.value += "nil";
            }
            this.value += ")";
        }
        this.value += "(instance " + instance + ")";
        instance++;
        
        this.compoundValueVisited = true;  
        this.value += "))\n";
    }

    /**
     * {@inheritDoc}
     */  

    @Override
    public void visitContainerValue(ContainerValue arg0) {
        if (arg0 != null) {
            this.value +=  " (create$ ";
            for (int i = 0; i < arg0.getElementSize(); i++) {
                arg0.getElement(i).accept(this);
                this.value += " ";
            }
            this.value += ") ";
        } else {
            this.value += " nil";
        }
        this.contValueVisited = true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitEnumValue(EnumValue arg0) {
        if (arg0.getValue() != null) {
            this.value += " " + map.get(arg0.getValue().getName());
        } else {
            this.value += " nil";
        }

        this.enumValueVisited = true;

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitIntValue(IntValue arg0) {
        if (arg0.getValue() != null) {
            this.value += arg0.getValue();
        } else {
            this.value += " nil";
        }
        this.intValueVisited = true; 
        
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitRealValue(RealValue arg0) {
        if (arg0.getValue() != null) {
            this.value += arg0.getValue();
        } else {
            this.value += " nil";
        }
        this.intValueVisited = true;

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitStringValue(StringValue arg0) {

        if (arg0.getValue() != null) {
            this.value += " " + "\"" + arg0.getValue() + "\"";
        } else {
            this.value += " nil";
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitAttribute(Attribute arg0) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitConstraint(Constraint arg0) {
        arg0.getConsSyntax().accept(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitDecisionVariableDeclaration(DecisionVariableDeclaration decl) { 
        boolean compoundType = decl.getType() instanceof Compound;
        if (compoundType) {
            processDeclaration(decl);
        } else {
            if (optimization ) {
                if (JessVariablesPreProcessor.getVariablesUsed().contains(decl.getName())) {
                    processDeclaration(decl);
                }
            } else {
                processDeclaration(decl);
            }
        }
    }

    /**
     * Processing individual declaration.
     * @param decl declaration.
     */
    private void processDeclaration(DecisionVariableDeclaration decl) {
        this.decVarVisited = true;
        this.variableMap.put(decl.getName(), decl.getType());
        jessVariablesList.visitDecisionVariableDeclaration(decl);
        if (decl.getDefaultValue() instanceof OCLFeatureCall) {
            OCLFeatureCall call = (OCLFeatureCall) decl.getDefaultValue();
            Variable variable = new Variable(decl);
            OCLFeatureCall valueCall = new OCLFeatureCall(variable, OclKeyWords.EQUALS, call);
            valueCall.accept(this);
        } else if (decl.getDefaultValue() != null) {
            this.value += "(modify ?id (" + decl.getName() + " ";
            decl.getDefaultValue().accept(this);
            this.value += ")" + ")\n";
            Variable var = new Variable(decl);
            this.variablesVisited.add(var);
            this.valueList.add(this.value);
            this.value = "";
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitFreezeBlock(FreezeBlock freeze) {
        // TODO Auto-generated method stub
        String module = "(defmodule mod1_RULE_ASSIGNMENT_" + keyCount + ")" + "\n";
        String noLoop = "(declare (no-loop TRUE))";
        String ruleInint = JessCommons.DEFRULE + "mod1_RULE_ASSIGNMENT_" + keyCount 
                + "::RULE_ASSIGNMENT_" + keyCount
                + "\n" + noLoop + "\n";
        String rule = module + ruleInint;
        String ruleContent = "";
        String projectHeader = "?id <- (Proj ";
        for (int i = 0; i < freeze.getFrozenCount(); i++) {
            projectHeader += "(" + freeze.getFrozen(i) + " $?" + freeze.getFrozen(i) + ")";
            ruleContent += "( ?*FixedList* add " + " \"" + freeze.getFrozen(i) + "\"" + ")" + "\n";
        }
        projectHeader += ")" + "\n" + "=>" + "\n";
        rule += projectHeader + ruleContent + ")";
        JessVisitor.getAssignmentModules().add("mod1_RULE_ASSIGNMENT_" + keyCount);
        this.modificationModuleList.add(rule + "\n");
        keyCount++;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitOperationDefinition(OperationDefinition arg0) {
        // TODO Auto-generated method stub
        

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitPartialEvaluationBlock(PartialEvaluationBlock arg0) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     */
    @Override 
    public void visitProject(Project arg0) {
        
        this.projectName = arg0.getName(); 
        this.project = arg0;
        jessWriter.openProject(projectName);
        //Add the global Var that contains the rules numbers of the rules that were fired.
        jessWriter.append("(defglobal ?*FiredList* = (new java.util.ArrayList))\n");
        //Method to get the firedList.
        jessWriter.append("(deffunction getList ()\n (return ?*FiredList*))\n");
        //initial project deftemplate
        String projectDefinition  = "(deftemplate project (slot projectName (type STRING)) )" 
                + "\n";
        jessWriter.append(projectDefinition);
        
        String validatorGlobal = "(defglobal ?*ModelValidator* = 0)";
        String incrementorFunc = "(deffunction incrementor ()" + "\n"
                                     + "(bind ?*ModelValidator* (+ ?*ModelValidator* 1)))";
        String validationFunc = "(deffunction getValidation ()" + "\n"
                                     + "\n" + "(return ?*ModelValidator*))";
        jessWriter.append(validatorGlobal + "\n\n" + incrementorFunc + "\n\n" + validationFunc + "\n\n");
        jessWriter.append("(defglobal ?*FixedList* = (new java.util.ArrayList))\n");
        this.projectVisted = true; 
        jessVariablesList.visitProject(arg0);
        
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitProjectImport(ProjectImport arg0) {
        Project importedProject = arg0.getResolved(); 
        String importedProjectName = importedProject.getName();
        
        String projectDefinition  = "(deftemplate " + importedProjectName + "(slot projectName (type STRING)) )" 
                + "\n"; 
        jessWriter.append(projectDefinition);
        
        for (int i = 0; i < importedProject.getElementCount(); i++) { 
            this.ruleMapper.put(new Integer(keyCount), importedProject.getElement(i));
            importedProject.getElement(i).accept((IModelVisitor) this);
            this.keyCount++;
            
        }
        
        for (int j = 0; j < importedProject.getInternalConstraintCount(); j++) {
            this.ruleMapper.put(new Integer(keyCount), importedProject.getElement(j));
            importedProject.getInternalConstraint(j).accept((IModelVisitor) this); 
            this.keyCount++;
        } 
   
    }

    /**
     * {@inheritDoc}
     */ 
    @Override
    public void visitProjectInterface(ProjectInterface arg0) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitParenthesis(Parenthesis parenthesis) {
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
     * {@inheritDoc}
     */
    @Override
    public void visitComment(de.uni_hildesheim.sse.model.cst.Comment parenthesis) {
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void visitOclFeatureCall(OCLFeatureCall call) {
        boolean operationIsEquals = (call.getOperation().equals(OclKeyWords.ASSIGNMENT))
                || (call.getOperation().equals(OclKeyWords.EQUALS));
        if (!operationIsEquals) {
            
            notEqualsOperation(call);
        } else {
            
            if ((call.getOperand() instanceof Variable) 
                    || (call.getOperand() instanceof CompoundAccess) ) {
                boolean hasValue = hasDefinedValue(call);
                try {
                    if (call.getParameter(0) instanceof ConstantValue 
                            && !(call.getOperand().inferDatatype() instanceof Compound)
                            && !(call.getOperand() instanceof CompoundAccess)) {
                        variablesVisited.add(call.getOperand());
                        equalsOperation(call);
                        notEqualsOperation(call);
                    } else if ((call.getParameter(0) instanceof OCLFeatureCall) 
                            || (call.getParameter(0) instanceof Parenthesis) 
                            || (call.getParameter(0) instanceof ContainerOperationCall)) {
                        equalsOperation(call); 
                    } else {
                        //TODO: remove this?
                        equalsOperation(call);
                        if (hasValue) {
                            variablesVisited.add(call.getOperand());
                            notEqualsOperation(call);
                        } else {
                            boolean varIsCompoundAcess = call.getOperand() instanceof CompoundAccess;
                            if (variablesVisited.contains(call.getOperand())) {
                                notEqualsOperation(call);
                            } else if (varIsCompoundAcess) {
                                equalsOperation(call);
                            } else if (!(call.getOperand().inferDatatype() instanceof Compound)) {
                                equalsOperation(call);
                            }
                        }
                    }
                } catch (CSTSemanticException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } else {
                notEqualsOperation(call);
            }
        }
 
    }

    /**
     * Private method for equals operations.
     * @param call OCL call.
     */
    private void equalsOperation(OCLFeatureCall call) {
        this.variablesVisited.add(call.getOperand());
        this.jessAssignments.visitProject(this.project);
        jessAssignments.setRuleCount(this.keyCount);
        jessAssignments.visitOclFeatureCall(call);
        jessAssignments.visitAfterOclFeatureCall(call);
        this.ruleFinal = jessAssignments.getFinalRule() + JessCommons.NEWLINE;
        this.modificationModuleList.add(this.ruleFinal);
        jessAssignments.visitRuleAfter();
    }

    /**
     * Method to check if a value is already defined for the variable.
     * @param call OCL call.
     * @return <True> if the variable has defined value.
     */
    private boolean hasDefinedValue(OCLFeatureCall call) {
        boolean hasValue = true;
        if (call.getOperand() instanceof Variable) {
            hasValue = ((Variable) call.getOperand()).getVariable().getDefaultValue() != null;
        } else if (call.getOperand() instanceof CompoundAccess) {
            if (((CompoundAccess) call.getOperand()).getCompoundExpression() 
                    instanceof Variable) {
                variablesVisited.add(((CompoundAccess) call.getOperand()).getCompoundExpression());
                CompoundAccess cAc = ((CompoundAccess) call.getOperand());
                if (null != cAc.getResolvedSlot().getDefaultValue()) {
                    hasValue = true;
                    System.out.println("value - " + cAc.getResolvedSlot() + " .. " + hasValue);
                } else {
                    hasValue = false;
                }
            }
//            hasValue = true;
        } else {
            hasValue = variablesVisited.contains(call.getOperand());
        }
        return hasValue;
    }
    
    /**
     * Defines an internal method to put logic when the OCL call does not contains an <b>equals</b> operation.
     * @param call OCL call.
     */
    private void notEqualsOperation(OCLFeatureCall call) {
        /*
        if (call.getOperation().equals(OclKeyWords.IMPLIES) && call.getParameter(0) instanceof OCLFeatureCall) {
            OCLFeatureCall rhs = (OCLFeatureCall) call.getParameter(0);
            if (rhs.getOperation().equals("==")) {
                OCLFeatureCall tempCall = new OCLFeatureCall(call, OclKeyWords.NOT);
                OCLFeatureCall newCall = new OCLFeatureCall(tempCall, OclKeyWords.NOT);
                jessRules.visitProject(this.project);
                jessRules.setRuleCount(0 - this.keyCount);
                jessRules.visitOclFeatureCall(newCall); 
                jessRules.visitAfterOclFeatureCall();
                this.ruleFinal = jessRules.getFinalRule() + JessCommons.NEWLINE;
                this.constraintModuleList.add(this.ruleFinal); 
                jessRules.visitRuleAfter();
            }
        }
        */
        jessRules.visitProject(this.project);
        jessRules.setRuleCount(this.keyCount);
        jessRules.visitOclFeatureCall(call); 
        jessRules.visitAfterOclFeatureCall();
        
        this.ruleFinal = jessRules.getFinalRule() + JessCommons.NEWLINE;
        if (jessRules.isHasModModule()) {
            this.modificationModuleList.add(this.ruleFinal);
        } else {
            this.constraintModuleList.add(this.ruleFinal); 
        }
        
        jessRules.visitRuleAfter(); 
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void visitContainerOperationCall(ContainerOperationCall call) {
        jessRules.visitProject(this.project);
        jessRules.visitContainerOperationCall(call);
        jessRules.setRuleCount(this.keyCount);
        jessRules.visitAfterOclFeatureCall();
        this.ruleFinal = jessRules.getFinalRule() + JessCommons.NEWLINE;
        this.constraintModuleList.add(this.ruleFinal);
        jessRules.visitRuleAfter();
    }
    
    /**
     * get Final Rule.
     * @return finalRule 
     */
    public String getRuleFinal() {
        return ruleFinal;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitConstantValue(ConstantValue value) { 
      
        value.getConstantValue().accept(this);
        
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void visitVariable(Variable variable) {
              
   
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitLet(Let let) {
        // TODO Auto-generated method stub
        
        
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitIfThen(IfThen ifThen) {
        // TODO Auto-generated method stub
        
    }



    /**
     * {@inheritDoc}
     */
    @Override
    public void visitBooleanType(BooleanType arg0) {
        if (!this.typeVisitor) {
            jessWriter.append("(slot ");
            this.typeVisitor = true;
            
        } else {
            jessWriter.append("SYMBOL)");
            this.typeVisitor = false;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitCompoundType(Compound arg0) {
        if (!this.typeVisitor) {
            jessWriter.append("(slot ");
            this.typeVisitor = true;
        } else {
            jessWriter.append("ANY)");
            this.typeVisitor = false;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitDatatype(IDatatype arg0) {
        // TODO Auto-generated method stub
        
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitDerivedType(DerivedDatatype dType) {

        
        if (!this.typeVisitor) {
            jessWriter.append("(slot ");
            this.typeVisitor = true;
            
        } else {
            jessWriter.append("ANY)");
            this.typeVisitor = false;
        }
        
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitEnumType(Enum arg0) {
       
        if (!this.typeVisitor) {
            jessWriter.append("(slot ");
            this.typeVisitor = true;
        } else {
            jessWriter.append("INTEGER)");
            this.typeVisitor = false;
        }
        
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitIntegerType(IntegerType arg0) {
        if (!this.typeVisitor) {
            jessWriter.append("(slot ");
            this.typeVisitor = true;
        } else {
            jessWriter.append("INTEGER)");
            this.typeVisitor = false; 
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitOrderedEnumType(OrderedEnum arg0) {
        // TODO Auto-generated method stub
        
        
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitRealType(RealType arg0) {
        
        if (!this.typeVisitor) {
            jessWriter.append("(slot ");
            this.typeVisitor = true;
        } else {
            jessWriter.append("FlOAT)");
            this.typeVisitor = false; 
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitStringType(StringType arg0) {
        
        
        if (!this.typeVisitor) {
            jessWriter.append("(slot ");
            this.typeVisitor = true;
        } else {
            jessWriter.append("STRING)");
            this.typeVisitor = false;
        }
        
    }

    @Override
    public void visitCompoundAccess(CompoundAccess arg0) {
        // TODO Auto-generated method stub 
        
    }

    @Override
    public void visitReferenceValue(ReferenceValue arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitConfiguration(Configuration configuration) {
        System.out.println("total used decls : " + variableMap.size());
        Iterator<IDecisionVariable> iterator = configuration.iterator();
        while (iterator.hasNext()) {
            iterator.next().accept((IConfigurationVisitor) this);
            instance++;
        }
        this.visitProjectAfter();
        this.runRules();
        
        
    }
    
 
    @Override
    public void visitDecisionVariable(IDecisionVariable variable) {
        this.value = "";
        boolean valueNotNull = (variable.getValue() != null);
        boolean notACompound = !(variable.getDeclaration().getType() instanceof Compound);
        boolean isACompound = (variable.getDeclaration().getType() instanceof Compound);
        if (notACompound) {
            String name = variable.getDeclaration().getName();
            boolean varIsUsed = JessVariablesPreProcessor.getVariablesUsed().contains(name);
            if (varIsUsed && valueNotNull) {
                this.value += "(modify ?id (" + variable.getDeclaration().getName() + " ";
                variable.getValue().accept(this);
                this.value += ")" + ")\n";
                this.valueList.add(this.value);
                this.value = "";
            }
        } else if (isACompound && valueNotNull) {
            if (variable.getValue().isConfigured()) {
                this.value += "(modify ?id (" + variable.getDeclaration().getName() + " ";
                variable.getValue().accept(this);
                this.value += ")" + ")\n";
                
            } else {
                this.value = "";
                this.value += "(modify ?id (" + variable.getDeclaration().getName() + " ";
                variable.getValue().accept(this);
                this.value += ")" + ")\n";
            }
            this.valueList.add(this.value);
            this.value = "";
        }
            
        
    }
    
    /**
     * A private method to visit after project to add a default 
     * project template to reason about defglobals.  Moreover, the actual writing of the rules
     * as per their module type is done here. Two types of modules are defined for rules.
     * (a) mod1 - dedicated to capture all the rules where modifications take place
     * (b) mod2 - dedicated to rule which do not contain modifications but pure constraints.
     * This is essential as it is possible for the jess engine to run the modification module 
     * first and later the pure constraints module, else, Jess fires the same rule more than once 
     * resulting in wrong value to determine the satisfiability of a project with respect
     * to its configuration.
     */
    private void visitProjectAfter() {
        StringBuffer templList = jessVariablesList.getProjTemplate();
        String pHead = "";
//        pHead = templList.toString() + ")";
        LinkedList<String> projectList = jessVariablesList.getProjectList();
        for (int i = 0; i < projectList.size(); i++) {
            jessWriter.append(projectList.get(i));
        }
        pHead += ")";
        String proAssert = "(bind ?id (assert (Proj)))";
        jessWriter.append(pHead + "\n" + proAssert + "\n");
        StringBuffer values = new StringBuffer();
        for (String str :this.valueList) {
            values.append(str);
        }
        values.append("\n\n");
        jessWriter.append(values.toString());
        StringBuffer compoundAssertion = new StringBuffer();
        for (int i = 0; i < this.compoundList.size(); i++) {
            compoundAssertion.append("(assert (" + this.compoundList.get(i) + "))");
            compoundAssertion.append("\n" + "(run)\n");
        }
        StringBuffer modificationRules = new StringBuffer();
        /**
         * Add rules and associated defmodule for value modifications.
         */
        if (this.modificationModuleList.size() != 0) {
            jessWriter.append("(defmodule mod1)\n");
            for (int i = 0; i < this.modificationModuleList.size(); i++) {
                modificationRules.append(this.modificationModuleList.get(i));
            }
        } 
        
        StringBuffer validationRules = new StringBuffer();
        /**
         * All the mod2 rules, strict validation rules.
         */
        if (this.constraintModuleList.size() != 0) {
            validationRules.append("(defmodule mod2)\n");
            for (String str : this.constraintModuleList) {
                validationRules.append(str);
            }
        }
        jessWriter.append(compoundAssertion.toString() + modificationRules.toString()
                + validationRules.toString());
    }
    
    /**
     * Method called from visitConfiguration, to add constructs 
     * to run the rules in the .clp file and save the facts. 
     */
    private void runRules() {
        
        jessWriter.append("(focus MAIN)\n");
        jessWriter.append("(run)\n");
        runModules("mod1");
        
        
        List<String> modules = assignmentModules;
        int inc = 1;
        while (inc <= 2) {
            for (String str : modules) {
                runModules(str);
            }
            inc++;
        }
        modules.removeAll(modules);
        
        runModules("mod2");
        
        jessWriter.append("(facts MAIN) \n");
        jessWriter.append("(printout t (getValidation) crlf)" + "\n");
        this.nonSupportedRules = jessRules.getNonSupportedRules();
        List<Integer> tempList = jessAssignments.getNonSupportedRules();
        for (int i = 0; i < tempList.size(); i++) {
            this.nonSupportedRules.add(tempList.get(i));
        }
        
    }

    /**
     * Method that writes the constructs to focus on each defmodule and run.
     * @param name Name of the defmodule.
     */
    private void runModules(String name) {
        String runModule = "(try\n" + "(focus " + name + ")\n" + "(run)\n"
                + "\tcatch \n\t(printout t " + "\"" 
                + "NO  MODULE " + name  + " \"" + " crlf)\n)\n";
        jessWriter.append(runModule);
        
//        jessWriter.append("(try\n");
//        jessWriter.append("(focus " + name + ")\n");
//        jessWriter.append("(run)\n");
//        jessWriter.append("\tcatch \n\t(printout t " + "\"" 
//            + "NO  MODULE " + name  + " \"" + " crlf)\n)\n");
    }

    @Override
    public void visitDslFragment(DslFragment fragment) {
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
    public void visitMetaTypeValue(MetaTypeValue value) {
        // TODO Auto-generated method stub
        
    }
    
    /**
     * {@inheritDoc}
     */
    public void visitUnresolvedExpression(UnresolvedExpression expression) {
        // transparently go on
        ConstraintSyntaxTree actual = expression.getActualExpression();
        if (null != actual) {
            actual.accept(this);
        }
    }

    /**
     * Returns the jess configuration file temporarily created for reasoning via the jess engine.
     * @return A temp file created for the current reasoning
     */
    File getJessCLPFile() {
        return jessWriter.getJessCLPFile();
    }

    @Override
    public void visitConstraintType(ConstraintType type) {
        // TODO Auto-generated method stub
    }

    @Override
    public void visitConstraintValue(ConstraintValue value) {
        // TODO Auto-generated method stub
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitComment(Comment comment) {
        // No action needed in reasoning
    }

    /**
     * {@inheritDoc}
     */
    public void visitAttributeAssignment(AttributeAssignment assignment) {
        // TODO [AttributeAssignment] visit contained variables (affected), constraints and realizing constraints
        for (int a = 0; a < assignment.getAssignmentCount(); a++) {
            assignment.getAssignment(a).accept((IModelVisitor) this);
        }
    }
    
    @Override
    public void visitNullValue(NullValue value) {
        // TODO Auto-generated method stub
    }

}
