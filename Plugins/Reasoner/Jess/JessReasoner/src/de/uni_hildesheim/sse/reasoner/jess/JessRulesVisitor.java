package de.uni_hildesheim.sse.reasoner.jess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.uni_hildesheim.sse.model.confModel.Configuration;
import de.uni_hildesheim.sse.model.confModel.IConfigurationVisitor;
import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;
import de.uni_hildesheim.sse.model.cst.CSTSemanticException;
import de.uni_hildesheim.sse.model.cst.CompoundAccess;
import de.uni_hildesheim.sse.model.cst.CompoundInitializer;
import de.uni_hildesheim.sse.model.cst.ConstantValue;
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
 * This class is written for the purpose of visiting OCLfeature calls and 
 * Expression (in the future). The visitors methods are called from the class JessVisitor. 
 * This class contains additional methods for rule derivation in Jess format. Rules can be
 * mainly of three types : 
 * (a) with pure constrains
 * (b) modifications if the constrains in the LHS are satisfied.
 * (c) and modifications without any constrains (pure Expressions).
 * @author phani saripalli
 *
 */
public class JessRulesVisitor implements IModelVisitor, 
    IConstraintTreeVisitor, IDatatypeVisitor, IValueVisitor, IConfigurationVisitor {
    
    private static final String NOLOOP = "(declare (no-loop TRUE))";
    private boolean contBeingModified = false;
    
    /**
     * String buffer containing the rule.
     */
    private StringBuffer ruleBuffer = new StringBuffer("");
    private Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
    private Map<String, String> idMap = new HashMap<String, String>();
    private Map<String, String> compoundMap = new HashMap<String, String>();
    private int ruleItr = 0;
    private int ruleItrRhs = 0;
    private boolean hasRHS = false;
    private int contItr = 0;
    private String declOne = "";
    private String containerBeingVisited = "";
    private boolean oclVisited = false;
    private boolean compoundAccess = false;
    private String compoundBeingAccessed = "";
    private int assgnInc = 0;
    
    private int ruleCount = 0;
    private String pRuleHeader = "?id <- (Proj ";
    private String finalRule = "";
    private List<String> patternHead = new ArrayList<String>();
    
    private Project project;
    private boolean modification = false;
    private boolean modifyingtemplElem = false;
    private String modifiedCompName = "";
    private boolean ignoreRule = false;
    /**
     * Each variable is checked if it is defined. This list contains such parts of 
     * each variable used in the constraint/rule.
     */
    private List<String> nilEqPlaceholder = new ArrayList<String>();
    private boolean hasModModule = false;
    private int totalDecl = 0;
    private int compoundCount = 0;
    private boolean ruleSupported = true;
    private List<String> compoundInstants = new ArrayList<String>();
    
    private List<String> compoundAccessInstants = new ArrayList<String>();
    private List<Integer> nonSupportedRules = new ArrayList<Integer>();
    private String currentOp = "";
    private String currentCompound = "";
    private int operandTyp = 0;
    
    private String modificationTracker = "";

    


    /**
     * Method to retrieve the list of not supported rules.
     * @return List containing the numbers for the rules not supported.
     */
    public List<Integer> getNonSupportedRules() {
        return nonSupportedRules;
    }

    /**
     * Method to set the Rule count or rule number.
     * @param nr The rule number
     */
    public void setRuleCount(int nr) {
        this.ruleCount = nr;
    }
    
    /**
     * A method that tells if the project has a Jess Modification module.
     * @return <b>True</b> if there is a Jess modification module.
     */
    public boolean isHasModModule() {
        return hasModModule;
    }



    /**
     * Getter for the string representing the rule. 
     * @return finalRule Rule.
     */
    public String getFinalRule() {
        return finalRule;
    }



    /**
     * Method to define the rule header. Jess rules consist of header (a description of what 
     * facts to look into) and the part consists of the actual rule.. 
     */
    public void visitAfterOclFeatureCall() {
        String hold = "";
        
        for (int i = 0; i < this.patternHead.size(); i++) {
            String compElement = this.patternHead.get(i);
            String compName = compoundMap.get(compElement);
            hold += idMap.get(compElement) + " <- " + "(" + "" + compName + " ";
            for (int in = 0; in < map.get(compName).size(); in++) {
                String endString = map.get(compName).get(in);
                hold += endString.replace(endString.substring(endString.length() - 1), compElement + ")");   
            }
            hold += ") ";
        }
        

        String validionFuncAccess = "(incrementor)"; //+ "(printout t (incrementor) crlf)";
        
        finalRuleDerivation(hold, validionFuncAccess); 
        
        hold = "";
        map.clear();
    }



    /**
     * A private method called from VisitiOclFeatureCall(OCLFeatureCall args0) method 
     * to derive the final rule. 
     * @param ruleContent The main part of the rule, leaving out all the syntactical
     * elements like NEWLINE, BRACKETS etc.
     * @param validionFuncAccess A statement to write in the Jess files that 
     * aids keeping track of the number of times rules were contradicted.   
     */
    private void finalRuleDerivation(String ruleContent, String validionFuncAccess) {
        String neqPlaceholder = "";
        neqPlaceholder += this.pRuleHeader + ")";
        for (int i = 0; i < this.nilEqPlaceholder.size(); i++) {
            neqPlaceholder += this.nilEqPlaceholder.get(i);
        }
        boolean ruleToBeAdded = this.ruleSupported && (ruleCount != 0);
        if (ruleToBeAdded) {
            if (!this.hasRHS) {
                
                finalRule = this.declOne + "\n";
                finalRule += JessCommons.DEFRULE + "mod2::RULE_" + ruleCount + JessCommons.NEWLINE  
                        + "\n" + NOLOOP + "\n" + ruleContent + neqPlaceholder
                        + JessCommons.NEWLINE + this.ruleBuffer + JessCommons.BRACKETCLOSE + " )"
                        + JessCommons.NEWLINE + JessCommons.IMPLIES + "\n" + validionFuncAccess + "\n"
                        + "(printout t " + "\"" + " NOT SATISFIED BY " + ruleCount + "\"" + " crlf )" 
                        + "\n(?*FiredList* add " + ruleCount + ")"
                        + JessCommons.NEWLINE + JessCommons.BRACKETCLOSE; 
                
                
            } else {
                String salience = "(declare (salience " + ruleCount * -100 + "))";
                String module = "\n(defmodule mod1_RULE_ASSIGNMENT_" + ruleCount + ")" + "\n";
                if (this.modifyingtemplElem) {
                    finalRule = module + JessCommons.DEFRULE + "mod1_RULE_ASSIGNMENT_" + ruleCount + "::RULE_ASSIGN_#_"
                            + "\n" + NOLOOP + "\n" + ruleContent 
                            + JessCommons.NEWLINE + neqPlaceholder
                            + JessCommons.NEWLINE + this.ruleBuffer + JessCommons.BRACKETCLOSE 
                            + "\n" + JessCommons.NEWLINE 
                            + JessCommons.BRACKETCLOSE; 
                    
                } else {
                    finalRule = JessCommons.DEFRULE + "mod1" + "::RULE_ASSIGN_#_"
                    		+ ruleCount + "\n" 
                            + "\n" + JessCommons.NEWLINE  + ruleContent 
                            + JessCommons.NEWLINE + neqPlaceholder
                            + JessCommons.NEWLINE + this.ruleBuffer
                            + JessCommons.BRACKETCLOSE + "\n"
                            + modificationTracker
                            + ")\n"; 
                    modificationTracker = "";
                    
                }
                
                JessVisitor.getAssignmentModules().add("mod1_RULE_ASSIGNMENT_" + ruleCount);
            }
        } else {
            if (ignoreRule) {
                finalRule = "";
            } else {
                finalRule = "";
                this.nonSupportedRules.add(ruleCount);
            }
        }
//        System.out.println("Rule is -> " + newRule);
        neqPlaceholder = "";
        this.nilEqPlaceholder.removeAll(nilEqPlaceholder);
    }
    
    
    
    @Override
    public void visitOclFeatureCall(OCLFeatureCall call) {
        this.oclVisited = true; 
       
        if (!call.getOperation().equals(OclKeyWords.IMPLIES)) {  
            notImpliesRule(call);
               
        } else { 
            if ((call.getParameter(0) instanceof OCLFeatureCall) ) {
                OCLFeatureCall innerCall = (OCLFeatureCall) call.getParameter(0);
                boolean condTwo = (innerCall.getOperand() instanceof Variable)
                        || (innerCall.getOperand() instanceof CompoundAccess);
                boolean eqOp = innerCall.getOperation().equals(OclKeyWords.EQUALS);
                if (eqOp && (this.assgnInc == 0) 
                        && condTwo) {  
                    this.hasModModule = true; 
                    this.hasRHS = true;  
                    this.assgnInc++;
                    ruleBuffer.append("(test ");
                    /*This is the case - true implies a == 10;
                     * this is written as (test (= TRUE TRUE)) => THE RHS PART
                     */
                    if (call.getOperand() instanceof ConstantValue) {
                        ruleBuffer.append("(= ");
                        call.getOperand().accept(this);
                        call.getOperand().accept(this);
                        ruleBuffer.append(")");
                    } else {
                        call.getOperand().accept(this);
                    }
                    ruleBuffer.append(")" + "\n" + " => "); 
                    if (ruleItrRhs == 0) {      
                        ruleItrRhs++; 
                    }
                    this.modification = true; 
                    
                    for (int i = 0; i < call.getParameterCount(); i++) { 
                        call.getParameter(i).accept(this);
                    } 
                    
                } else {
                    this.notImpliesRule(call);
                }
            } else if (call.getParameter(0) instanceof Parenthesis) {
                OCLFeatureCall call1 = new OCLFeatureCall(call.getOperand(), OclKeyWords.IMPLIES,
                        ((Parenthesis) call.getParameter(0)).getExpr());
                call1.accept(this);
            } else {
                notImpliesRule(call);
            }
        }
        
    }


    /**
     * A method to put logic for OCL calls without implications.
     * @param call OCLCall
     */
    private void notImpliesRule(OCLFeatureCall call) {
        if (ruleItr == 0 && !this.hasRHS) {  
            ruleBuffer.append("(test (not ");
            ruleItr++;
        } else if (ruleItr == 0) { 
//            aR.append("(test ");
            ruleItr++; 
        }
        ruleBuffer.append("(");
        if (!this.modification) {
            boolean operatorIsUnion = (call.getOperation().equals(OclKeyWords.UNION));
            if (!operatorIsUnion) {
                ruleBuffer.append(JessCommons.getJessOperator(call.getOperation()) + " ");
                this.currentOp = call.getOperation();
            } else {
                doContainerOperations(call);
            }
        }  
        call.getOperand().accept(this);
        for (int i = 0; i < call.getParameterCount(); i++) { 
            call.getParameter(i).accept(this);  
        } 
        ruleBuffer.append(") ");
    }  
    
    /**
     * sets the defaults after visiting the rule.
     */
    public void visitRuleAfter() { 

        this.ruleItrRhs = 0;
        this.hasRHS = false;
        this.ruleItr = 0;
        map.clear(); 
        this.ruleBuffer.setLength(0);
        this.ruleBuffer.append("");
        this.hasModModule = false;
        this.declOne = "";
        this.oclVisited = false;
        this.pRuleHeader = "?id <- (Proj ";
        this.patternHead.removeAll(patternHead);
        this.contBeingModified = false;
        this.ruleSupported = true;
        this.compoundInstants.removeAll(compoundInstants);
        this.compoundAccessInstants.removeAll(compoundAccessInstants);
        this.assgnInc = 0;
        
        
        
    }
    
    @Override
    public void visitContainerOperationCall(ContainerOperationCall call) {
        this.ruleItr++;
        this.modification = false;
        boolean isRule = true;
        if (this.contItr == 0 && !this.oclVisited) {
            ruleBuffer.append("(test (not ");
            isRule = false;
        } else {
            this.ruleItr++;
        }
        ruleBuffer.append("( ");
        boolean selectOp = call.getOperation().equals(OclKeyWords.SELECT); 
        boolean rejectOp = call.getOperation().equals(OclKeyWords.REJECT);
        boolean anyOp = call.getOperation().equals(OclKeyWords.ANY);
        boolean oneOp = call.getOperation().equals(OclKeyWords.ONE);
        boolean allOp = call.getOperation().equals(OclKeyWords.FOR_ALL);
        boolean collectOp = call.getOperation().equals(OclKeyWords.COLLECT);
        if (selectOp || collectOp) {
            ruleBuffer.append("IVMLselect( ");
        } else if (rejectOp) {
            ruleBuffer.append("IVMLrej(");
        } else if (anyOp) {
            ruleBuffer.append("IVMLany( ");
        } else if (oneOp) {
            ruleBuffer.append("IVMLone( ");
        } else if (allOp) {
            ruleBuffer.append("IVMLforAll( ");
        } else {
            System.out.print("");
        }
        ruleBuffer.append(JessCommons.getJessOperator(call.getOperation()) + " ");
        this.currentOp = call.getOperation();
        if (call.getOperation().equals(OclKeyWords.APPLY)) {
            
            System.out.print("");
        } else {
            
            
            declOne = "(defglobal ";
            
            String lambdaFunc = "(map(lambda";
            ruleBuffer.append(lambdaFunc);
            ruleBuffer.append("(");
            for (int i = 0; i < call.getDeclaratorsCount(); i++) {
                declOne += "?*CD_" + this.totalDecl + "_" + call.getDeclarator(i).getName() + "* = nil";
                ruleBuffer.append("?*CD_" + this.totalDecl + "_" + call.getDeclarator(i).getName() + "* ");
                this.totalDecl++;
            }
            declOne += ")";
            ruleBuffer.append(")");
            call.getExpression().accept(this);
            ruleBuffer.append(")");
            call.getContainer().accept(this);
            ruleBuffer.append(")"); 
        }
        if (selectOp || rejectOp || anyOp || oneOp) {
            ruleBuffer.append(" ) " + this.containerBeingVisited + ")");
        } else if (allOp) {
            ruleBuffer.append(" ) " + this.containerBeingVisited + "");
        } else if (collectOp) {
            System.out.println("this cont visited ");
            ruleBuffer.append(" ) " + this.containerBeingVisited + ")");
        } else {
            System.out.print("");
        }
        if (!isRule) {
            ruleBuffer.append(") ");
        }
    }

    @Override
    public void visitSequence(Sequence seq) {
        boolean parentIsProject = seq.getParent().equals(this.project);
        String collectionName = seq.getName();
        processCollection(parentIsProject, collectionName);
    }

    /**
     * To process a collection.
     * @param parentIsProject <b>True</b> if the parent is project.
     * @param collectionName name of the collection.
     */
    private void processCollection(boolean parentIsProject, String collectionName) {
        String jessNeqChunk = "";
        if (parentIsProject) {
            jessNeqChunk = "(test (neq " + "?*" + collectionName + "*" + "nil))";
            this.containerBeingVisited = "?*" + collectionName + "*";
        } else {
            jessNeqChunk = "(test (neq " + "$?" + collectionName + "nil))";
            this.containerBeingVisited = "$?" + collectionName; 
        }

        this.nilEqPlaceholder.add(jessNeqChunk);
    }
    
    @Override
    public void visitSet(Set set) {
        boolean parentIsProject = set.getParent().equals(this.project);
        String collectionName = set.getName();
        processCollection(parentIsProject, collectionName);
        /*
        String jessNeqChunk = "";
        if (parentIsProject) {
            jessNeqChunk = "(test (neq " + "?*" + collectionName + "..*" + "nil))";
            this.containerBeingVisited = "?*" + collectionName + "*"; 
        } else {
            jessNeqChunk = "(test (neq " + "$?" + collectionName + "nil))";
            this.containerBeingVisited = "$?" + collectionName; 
        }
        this.nilEqPlaceholder.add(jessNeqChunk);
        */
    }

    /**
     * Method for processing all set and sequence operations.
     * @param call OCL call.
     */
    private void doContainerOperations(OCLFeatureCall call)  {
        try {
            boolean lhsIsSet = Set.TYPE.isAssignableFrom(call.getOperand().inferDatatype());
            boolean rhsIsSet = Set.TYPE.isAssignableFrom(call.getParameter(0).inferDatatype());
            if (lhsIsSet && rhsIsSet) {
                ruleBuffer.append(JessCommons.getJessOperator(call.getOperation()) + " ");
            } else {
                ruleBuffer.append("IVMLUnion" + " ");
            }
        } catch (CSTSemanticException e) {
            e.printStackTrace();
        } 
    }
    
    @Override
    public void  visitVariable(Variable var) { 
        if (Reference.TYPE.isAssignableFrom(var.getVariable().getType())) {
            this.ruleSupported = false;
        }
        String varName = var.getVariable().getName();
        if (var.getVariable().getType().getTypeClass().isAssignableFrom(Sequence.class)
                || var.getVariable().getType().getTypeClass().isAssignableFrom(Set.class)) {
            this.contBeingModified = true;
        } else {
            this.contBeingModified = false;
        }
        getOperandTyp(var);
        boolean parentIsProject = var.getVariable().getParent().getClass().equals(this.project.getClass());

        if (parentIsProject && !this.compoundAccess) {
            nonNestedVariablePatternMatcher(varName, var);

        } else if (var.getVariable().isTemporaryVariable()) {
            
            if (this.declOne.equals("")) {
                ruleBuffer.append("?" + varName);
            } else {
                ruleBuffer.append("?*CD_" + (this.totalDecl - 1) + "_" + varName + "*");
            }
        } else if (this.compoundAccess) {
            currentCompound = varName;
            String jessN = "$?" + varName;
            String cName = this.compoundBeingAccessed;
            if (!this.compoundInstants.contains(cName)) {
                this.compoundInstants.add(cName);
                this.compoundAccessInstants.add(varName);
            } else {
                if (!this.compoundAccessInstants.contains(varName)) {
//                    this.ruleSupported = false;
                }
            }
            if (!this.patternHead.contains(var.getVariable().getName())) {
                this.patternHead.add(var.getVariable().getName());
            }
            String appendeR = "(test (eq " + jessN + idMap.get(var.getVariable().getName()) + "))";
            if (!this.pRuleHeader.contains("(" + varName + " $?" + varName + ")")) {
                this.pRuleHeader += "(" + varName + " $?" + varName + ")";
            }
            if (!this.nilEqPlaceholder.contains(appendeR)) {
                this.nilEqPlaceholder.add(appendeR);
            }
            
        } else {
            nestedElementPatternMatcher(var, varName);
        } 
        
    }

    /**
     * Private method to identify if the operand is a set or a sequence.
     * @param var Variable.
     */
    private void getOperandTyp(Variable var) {
        if (var.getVariable().getType().getTypeClass().isAssignableFrom(Sequence.class)) {
            this.operandTyp = 1;
        } else if (var.getVariable().getType().getTypeClass().isAssignableFrom(Set.class)) {
            operandTyp = 2;
        } else {
            operandTyp = 0;
        }
    }

    /**
     * Private method to proces pattern matching for nested variable.
     * @param var Variable.
     * @param varName Variable name.
     */
    private void nestedElementPatternMatcher(Variable var, String varName) {
        String jessVarName = "$?" + varName + " ";
        String jessN = "(test (neq " + jessVarName + "nil))";
        boolean currentOpEmpty = this.currentOp.equals(OclKeyWords.IS_EMPTY) 
                || this.currentOp.equals(OclKeyWords.NOT_EMPTY); 
        if (this.contBeingModified && !currentOpEmpty) {
            jessN = "(test (neq (IVMLsize $?" + varName + ") 0))";
        }

        if (this.modification ) { 
            this.modifiedCompName = var.getVariable().getParent().getName();
            String appendeR = "modify " + idMap.get(this.modifiedCompName) 
                    + " (" + varName + " ";
            ruleBuffer.append(appendeR);
            this.modification = false;
            this.modifyingtemplElem = true; 
        } else {
            String appendeR = "$?" + varName + " ";
            if (isSpecificContainerOperation(currentOp)) {
                appendeR += operandTyp + " "; 
            }
            ruleBuffer.append(appendeR);
            this.containerBeingVisited = "$?" + varName + " "; 
            if (!this.nilEqPlaceholder.contains(jessN)) {
                this.nilEqPlaceholder.add(jessN);
            }
        }
    }

    /**
     * A private method to process the pattern matching for non-nested variable.
     * @param varName Variable name.
     */
    private void nonNestedVariablePatternMatcher(String varName, Variable variable) {
        boolean derivedType = variable.getVariable().getType() instanceof DerivedDatatype;
        if (derivedType && JessR.getOptimizationCaseNr() == 2 
                && !JessVariablesPreProcessor.getVariablesUsed().contains(varName)) {
            ignoreRule = true;
            ruleSupported = false;
        }
        String jessN = "(test (neq $?" + varName + " nil))";
        boolean currentOpEmpty = this.currentOp.equals(OclKeyWords.IS_EMPTY) 
                || this.currentOp.equals(OclKeyWords.NOT_EMPTY);
        if (this.contBeingModified && !currentOpEmpty) {
            jessN = "(test (neq (IVMLsize $?" + varName + ") 0))";
        }
        if (!this.pRuleHeader.contains("(" + varName + " $?" + varName + ")")) {
            this.pRuleHeader += "(" + varName + " $?" + varName + ")";
        }
        if (this.modification) {
            String temp = "\nprintout t (" + "ListAdd" + " ?*FixedList* " + "\"" + varName + "\"" + ")" + "\n";
//            modificationTracker += temp;
            String appendeR = "modify ?id (" + varName + " ";
            ruleBuffer.append(temp + ") \n (");
            ruleBuffer.append(appendeR);
            this.modification = false;
            
        } else {
            
            String appendeR = "$?" + varName + " ";
            if (isSpecificContainerOperation(currentOp)) {
                appendeR += operandTyp + " "; 
            }
            ruleBuffer.append(appendeR);
            this.containerBeingVisited = "$?" + varName; 
            
            
            if (!this.nilEqPlaceholder.contains(jessN) && !(this.currentOp.equals(OclKeyWords.IS_DEFINED))) {
                this.nilEqPlaceholder.add(jessN);
            }
        }
    }
    
    @Override
    public void visitCompoundAccess(CompoundAccess compAccess) {  
     
        this.compoundAccess = true;
        this.compoundBeingAccessed = compAccess.getResolvedSlot().getParent().getName();
//        if (!this.patternHead.contains(this.compoundBeingAccessed)) {
//            this.patternHead.add(this.compoundBeingAccessed);
//        }
        
        
        
        compAccess.getCompoundExpression().accept(this);
        if (this.modification ) { 
            this.modifiedCompName = this.compoundBeingAccessed;
            
            ruleBuffer.append("modify " + idMap.get(currentCompound) 
                    + " (" + compAccess.getSlotName() + " " + " ");
            this.modification = false;
            this.modifyingtemplElem = true; 
        } else {
            this.containerBeingVisited = "$?" + compAccess.getSlotName() + " "; 
            if (this.currentOp != OclKeyWords.IS_DEFINED) {
                this.nilEqPlaceholder.add("(test (neq " + "$?" + compAccess.getSlotName() + currentCompound + " nil))");
                ruleBuffer.append("$?" + compAccess.getSlotName() + currentCompound +" ");
            }
        }
        this.compoundAccess = false;
        
    }

    @Override
    public void visitDerivedDatatype(DerivedDatatype arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitProject(Project proj) {
        this.project = proj;
        for (int i = 0; i < proj.getElementCount(); i++) {
            proj.getElement(i).accept((IModelVisitor) this);
        }
    }
    
    @Override
    public void visitDecisionVariableDeclaration(DecisionVariableDeclaration decl) {
        if (decl.getType() instanceof Compound) {
            String name = decl.getName();
            String keyTemp = " ?id_" + this.compoundCount;
            if (!idMap.containsKey(name)) {
                
                idMap.put(name, keyTemp);
            } 
            
            if (!compoundMap.containsKey(name)) {
                compoundMap.put(name, decl.getType().getName());
            }
            this.compoundCount++;
        }
    }

    @Override
    public void visitCompound(Compound comp) {

            
        for (int i = 0; i < comp.getElementCount(); i++) {
            String nestElem = comp.getElement(i).getName();
            String ruleVar = "(" + nestElem + " $?" + nestElem + ")";
            if (!map.containsKey(comp.getName())) {
                map.put(comp.getName(), new ArrayList<String>());
            } 
            map.get(comp.getName()).add(ruleVar); 
        }
        
    }
    
    /**
     * Private method to identify if the operator is a container 
     * specific operation to change method signature in Jess.
     * @param operation operation/Operator.
     * @return Retrurns <b>True</b> if the operator is one of the following - asSequence, 
     * asSet, union or intersection.
     */
    private boolean isSpecificContainerOperation(String operation) {
        boolean asSetOrSeq = operation.equals(OclKeyWords.AS_SEQUENCE) || operation.equals(OclKeyWords.AS_SET);
        boolean interUnion = operation.equals(OclKeyWords.UNION);
        return interUnion || asSetOrSeq;
        
    }
    
    @Override
    public void visitConstantValue(ConstantValue value) {
        
        value.getConstantValue().accept(this);
    }
    
     
    @Override
    public void visitEnumValue(EnumValue value) {
        ruleBuffer.append(" " + "?*" + value.getType().getName() + "_" + value.getValue().getName() + "* ");
        
    }
    
    
    
    @Override
    public void visitStringValue(StringValue value) {
        ruleBuffer.append(" " + "\"" + value.getValue() + "\" ");
        
    }
    
    
    
    @Override
    public void visitCompoundValue(CompoundValue value) {

        String compoundName = value.getType().getName();
        
        Compound temp = (Compound) value.getType();
        ruleBuffer.append("(assert (".concat(compoundName));
        
        for (int i = 0; i < temp.getElementCount(); i++) {
            String name = temp.getElement(i).getName();
            ruleBuffer.append(" (" + name + " ");
            if (value.getNestedValue(name) != null) {
                value.getNestedValue(name).accept(this);  
            } else {
                ruleBuffer.append("nil");
            }
            ruleBuffer.append(")");
        }
        
        ruleBuffer.append("))\n");
    }
    
    
    
    @Override
    public void visitContainerValue(ContainerValue value) {

        String temp = "(create$ ";
        ruleBuffer.append(temp);
        for (int i = 0; i < value.getElementSize(); i++) {
            value.getElement(i).accept(this);
            ruleBuffer.append(" ");
        }
        ruleBuffer.append(") ");
    }
    
    
    
    @Override
    public void visitIntValue(IntValue value) {

        ruleBuffer.append(" " + value.getValue() + " ");
        
    }
    
    
    
    @Override
    public void visitRealValue(RealValue value) {
        ruleBuffer.append(" " + value.getValue() + " ");
        
    }
    
    
    
    @Override
    public void visitBooleanValue(BooleanValue value) {
        ruleBuffer.append(" " + value.getValue().toString().toUpperCase() + " ");
        
    }

    
    @Override
    public void visitEnum(Enum arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitEnumLiteral(EnumLiteral arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitOrderedEnum(OrderedEnum arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitReference(Reference arg0) {
        this.ruleSupported = false;
    }




    @Override
    public void visitIfThen(IfThen arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitLet(Let let) {
        // TODO Auto-generated method stub
        
        
    }


    @Override
    public void visitParenthesis(Parenthesis arg0) {
        arg0.getExpr().accept(this);
        
    }
    
    /**
     * {@inheritDoc}
     */
    public void visitContainerInitializer(ContainerInitializer init) {
        // TODO check
        for (int e = 0; e < init.getExpressionCount(); e++) {
            init.getExpression(e).accept(this);
        }
    }
    
    /**
     * {@inheritDoc}
     */
    public void visitCompoundInitializer(CompoundInitializer init) {
        // TODO check
        for (int e = 0; e < init.getExpressionCount(); e++) {
            init.getExpression(e).accept(this);
        }
    }

    @Override
    public void visitComment(de.uni_hildesheim.sse.model.cst.Comment arg0) {
        arg0.getExpr().accept(this);
    }

    @Override
    public void visitAttribute(Attribute arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitConstraint(Constraint arg0) {
        // TODO Auto-generated method stub
        
    }



    @Override
    public void visitFreezeBlock(FreezeBlock arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitOperationDefinition(OperationDefinition arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitPartialEvaluationBlock(PartialEvaluationBlock arg0) {
        // TODO Auto-generated method stub
        
    }


    @Override
    public void visitProjectImport(ProjectImport arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitProjectInterface(ProjectInterface arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitBooleanType(BooleanType arg0) {
        // TODO Auto-generated method stub
        
    }



    @Override
    public void visitCompoundType(Compound arg0) {
        // TODO Auto-generated method stub
        
    }



    @Override
    public void visitDatatype(IDatatype arg0) {
        // TODO Auto-generated method stub
        
    }



    @Override
    public void visitDerivedType(DerivedDatatype arg0) {
        // TODO Auto-generated method stub
        
    }



    @Override
    public void visitEnumType(Enum arg0) {
        // TODO Auto-generated method stub
        
    }



    @Override
    public void visitIntegerType(IntegerType arg0) {
        // TODO Auto-generated method stub
        
        
    }



    @Override
    public void visitOrderedEnumType(OrderedEnum arg0) {
        // TODO Auto-generated method stub
        
    }



    @Override
    public void visitRealType(RealType arg0) {
        // TODO Auto-generated method stub
        
    }



    @Override
    public void visitStringType(StringType arg0) {
        // TODO Auto-generated method stub
        
    }



    @Override
    public void visitConfiguration(Configuration configuration) {
        // TODO Auto-generated method stub
        
    }



    @Override
    public void visitDecisionVariable(IDecisionVariable variable) {
        // TODO Auto-generated method stub
        
    }





    @Override
    public void visitReferenceValue(ReferenceValue referenceValue) {

        this.ruleSupported = false;
    }



    @Override
    public void visitDslFragment(DslFragment fragment) {
        // TODO Auto-generated method stub
        
    }



    @Override
    public void visitMetaTypeValue(MetaTypeValue value) {
        // TODO Auto-generated method stub
        
    }



    @Override
    public void visitAnyType(AnyType datatype) {
        // TODO Auto-generated method stub
        
    }



    @Override
    public void visitMetaType(MetaType datatype) {

        
    }

    @Override
    public void visitUnresolvedExpression(UnresolvedExpression expression) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitConstraintValue(ConstraintValue value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitConstraintType(ConstraintType type) {
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
