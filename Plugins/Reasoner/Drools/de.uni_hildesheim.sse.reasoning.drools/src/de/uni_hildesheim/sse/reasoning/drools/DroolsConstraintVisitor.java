package de.uni_hildesheim.sse.reasoning.drools;

import java.util.ArrayList;
import java.util.List;

import de.uni_hildesheim.sse.model.cst.CSTSemanticException;
import de.uni_hildesheim.sse.model.cst.CompoundAccess;
import de.uni_hildesheim.sse.model.cst.CompoundInitializer;
import de.uni_hildesheim.sse.model.cst.ConstantValue;
import de.uni_hildesheim.sse.model.cst.ContainerInitializer;
import de.uni_hildesheim.sse.model.cst.ContainerOperationCall;
import de.uni_hildesheim.sse.model.cst.IConstraintTreeVisitor;
import de.uni_hildesheim.sse.model.cst.IfThen;
import de.uni_hildesheim.sse.model.cst.Let;
import de.uni_hildesheim.sse.model.cst.OCLFeatureCall;
import de.uni_hildesheim.sse.model.cst.Parenthesis;
import de.uni_hildesheim.sse.model.cst.Self;
import de.uni_hildesheim.sse.model.cst.UnresolvedExpression;
import de.uni_hildesheim.sse.model.cst.Variable;
import de.uni_hildesheim.sse.model.varModel.Attribute;
import de.uni_hildesheim.sse.model.varModel.AttributeAssignment;
import de.uni_hildesheim.sse.model.varModel.Constraint;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.datatypes.BooleanType;
import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
import de.uni_hildesheim.sse.model.varModel.datatypes.Container;
import de.uni_hildesheim.sse.model.varModel.datatypes.DerivedDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.Enum;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.IntegerType;
import de.uni_hildesheim.sse.model.varModel.datatypes.OclKeyWords;
import de.uni_hildesheim.sse.model.varModel.datatypes.OrderedEnum;
import de.uni_hildesheim.sse.model.varModel.datatypes.RealType;
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
import de.uni_hildesheim.sse.model.varModel.values.VersionValue;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory.EASyLogger;

/**
 * Visitor implementation for hard constraints for Drools. Hard constraints do not take 
 * assignment constraints into account.
 * @author Phani
 *
 */
public class DroolsConstraintVisitor implements 
    IConstraintTreeVisitor, IValueVisitor {
    
    private EASyLogger logger = EASyLoggerFactory.INSTANCE.getLogger(this.getClass(),
            "de.uni_hildesheim.sse.reasoning.drools");
    
    private static final String WHEN = "when";
    private static final String THEN = "then";
    private static final String END = "end";
    private static final boolean USEJAVADIALECT = true;
    
    private static int ruleCounter = 0;
    private static List<String> contValues = new ArrayList<String>();
    private Number ruleCount = 0;
    private String ruleHeader = "";
    private final String ruleAttributes = "agenda-group " + "\"" + "Group 2" + "\"" + "\n"
            + "dialect " + "\"mvel" + "\""
            + "\nno-loop true" 
            + "\n";
    private final String modificationAttributes = //"agenda-group " + "\"" + "Group 1" + "\"" + "\n"
            "\n" + "dialect " + "\"mvel" + "\""
            + "\nno-loop true" 
//            + "\nlock-on-active true" 
            + "\n";
    private String printoutInDrls = "System.out.println(" + "\"" + "Rule not satisfied # " 
            + "\"" + " + ";
    
    private List<String> pattern = new ArrayList<String>();
    private List<String> pattern2 = new ArrayList<String>();
    private List<String> orPatterns = new ArrayList<String>();
    private boolean visitingMetaValue = false;
    private String containerCallDeclaration = "";
    private String containerDeclInitial = "$$" + "P" + " : " + "Project" + "(";
    private String variableStatusChecker = "dList.contains";
    private boolean unusedConstraint = false;
    private boolean doNotFix = false;
    private boolean changeMeta = false;
    
    /**
     * Part of the rule logic present as hard constraint.
     * Exp1 implies var == Exp2, here Exp1 represents the constraint.
     */
    private String constraint = "";
    
    /**
     * part of the rule logic present as assignment constraint. 
     * For example, in - Exp1 implies var = Exp2; - RHS of implies is modification, i.e. var == Exp2.
     * 
     */
    private String modification = "";
    
    /**
     * the complete rule.
     */
    private String rule = "";
    
    /**
     * An indicator to know if the part of the constraint expression belongs to the modification 
     * part or constraint part.
     */
    private boolean modificationConstraint = false;
    
    /**
     * An iterator of the expression, that points out to the variable being modified, in case 
     * of a modification constraint.
     */
    private int rhsIndicator = 0;
    
    /**
     * An iterator of the expression, that points out to the variable being modified, in case 
     * of a modification constraint. This supplements rhsIndicator for mvelDialect being 
     * used in Drools rules.
     */
    private int mvelModeIndicator = 0;
    
    /**
     * Contains drools syntax to add a rule number to the list containing 
     * model elements (constraints) that are no satisfied in the model.
     */
    private String unsatisfiedRuleListAppender = "";
    
    /**
     * Drools operation equivalent of IVML operation name.
     */
    private DroolsOperations dOp;
    
    private List<String> compoundPlaceHolders = new ArrayList<String>();
    
    /**
     * An indicator if the rule is not supported currently by Drools.
     */
    private boolean ruleSupported = true;
    
    /**
     * Current operation being processed. A distinction in how a rule is written is made in case of 
     * the operation {@link OclKeyWords} IS_DEFINED.
     */
    private String currentOperation = "";
    
    /**
     *Current compound slot being accessed.  
     */
    private String currentSlot = "";
    
    /**
     *This contains the patterns for container operation calls, which much different from those 
     *of normal, non-container type variables. 
     */
    private String containerHead = "";
    
    /**
     * Current compound being visited.
     */
    private String currentCompound = "";
    
    /**
     * This consists of the part of rule logic that checks if the variable being reasoned
     * has been defined in terms of a java object. This is particularly essential in case of 
     * compound accesses.
     */
    private String isDefinedString = "";
    
    /**
     * In the context of processing and writing rules for Let expression, the local
     * variable is used with a suffix. The suffix for the let local variable is created in
     * {@link DroolsVisitor}
     */
    private String letSuffix = "";
    
    /**
     * The variable to be added to the list containing al the defined variables.
     */
    private String dListAdder = "";
    
    /**
     * When a compound variable is modified/assigned, each of the nested element name is added to a list in Drools. 
     * This string contains this part in Drools syntax. The names are stored in the format of nested access.
     */
    private List<String> compounddListAdder = new ArrayList<String>();
    
    private String innerslot = "";
    private String modClass = "P";
    private String compoundHeads = "";
    private String varBeingModified = "";
    private String prependRule = "";
    

    /**
     * Sole constructor for the class.
     */
    public DroolsConstraintVisitor() {
        dOp = new DroolsOperations(); 
    }
    
    /**
     * Method to set the ruleCounter.
     * 
     */
    public static void setRuleCounter() {
        ruleCounter++;
    }
    
    /**
     * Method to add a suffix in case of let expressions. In drools, the local variable in Let are translated 
     * like any decision variable.
     * @param suffix Suffix zto be added to the variable used in the rule.
     */
    public void setLetSuffix(String suffix) {
        letSuffix = suffix;
    }
    
    /**
     * Method to deactivate the rule counter, in the case of eval blocks.
     */
    public static void deactivateRuleCounter() {
        ruleCounter = 0;
    }
    

    /**
     * Method that returns rule numbers invlolving modification of collection values.
     * @return List containing rules numbers involving container values.
     */
    public static List<String> getContValueRules() {
        return contValues;
    }
    
    /**
     * Getter for isRuleSupported.
     * @return Returns <b>True</b> if the rule is supported.
     */
    public boolean isRuleSupported() {
        return ruleSupported;
    }
    
    /**
     * Setter for rule number in writing Drools rules. The rule number will be utilized in retrieving 
     * the list of conflicting constraints in the tool chain.
     * @param ruleCount Rule number.
     */
    public void setRuleCount(int ruleCount) {
        this.ruleCount = ruleCount;
        ruleHeader = "";
        constraint = "";
        rule = "";
        pattern.removeAll(pattern);
        pattern.add("");
    }
    
    /**
     * Setter for the rule prepending the rule.
     * @param prepend String to prepend to the rule name.
     */
    public void setRrulePrepend(String prepend) {
        prependRule = prepend;
    }
    
    /**
     * Method that retrieves the Project class number the variable belongs to,
     * and also also writes the class pattern of the rule.
     * @param name name of the variable.
     */
    private void writeDroolsClassPattern(String name) {
        int thr = -1;
        
        if (DroolsVisitor.getDroolsClasseMap().get(name) != null) {
            thr = DroolsVisitor.getDroolsClasseMap().get(name) / DroolsVisitor.THRESHOLD;
        }
        String tempPattern = "\nP" + (thr) + " : " + "Project" + thr + "()\n";
        
        if (pattern.contains("isDefined(P" + thr + ")")) {
            pattern.add("isDefined(P" + thr + ")");
            
        }
        
        if (!compoundHeads.contains(tempPattern)) {
            compoundHeads += tempPattern; 
        }
        if (thr == -1) {
            unusedConstraint = true;
        }
    }
   
    /**
     * Setter for rule number in writing Drools rules. The rule number will be utilized in retrieving 
     * the list of conflicting constraints in the tool chain.
     * @param ruleCount Rule number.
     */
    public void setRuleCount(Number ruleCount) {
        this.ruleCount = ruleCount;
        ruleHeader = "";
        constraint = "";
        rule = "";
        pattern.removeAll(pattern);
        pattern.add("");
    }
    
    
    /**
     * Method that returns the drools class number.
     * @param name Variable name.
     * @return Drools class number.
     */
    private int getDroolsClassNr(String name) {
        int projNr = 0;
        if (DroolsVisitor.getDroolsClasseMap().get(name) == null) {
//            logger.info("name null " + name);
            unusedConstraint = true;
        } else {
            projNr = DroolsVisitor.getDroolsClasseMap().get(name) / DroolsVisitor.THRESHOLD; 
        }
        return projNr;
    }
    
    /**
     * Method to derive the final rule.
     * @return The rule.
     */
    public String getRule() {
        addRuleHeaders();
        finalRuleInitializer();
        
        String printStmnt = printoutInDrls;
        if (modification.equals("")) {
            constraint = "!(" + constraint + ")"; 
            if (ruleCount instanceof Integer) {
                int intRuleCount = (Integer) ruleCount;
                if (intRuleCount >= 0) {
                    unsatisfiedRuleListAppender = "cList.add(" + ruleCount + ");\n";
                    printStmnt += ruleCount  + ");" + "\n";
                } else {
                    unsatisfiedRuleListAppender = "cList.add(" + Math.abs(intRuleCount) + ");\n";
                    printStmnt += "\"+ -> \"+" + " " + Math.abs(intRuleCount)  + ");" + "\n";
                } 
            } else {
                double doubleRuleCount = (Double) ruleCount;
                if (doubleRuleCount >= 0) {
                    unsatisfiedRuleListAppender = "cList.add(" + ruleCount + ");\n";
                    printStmnt += ruleCount  + ");" + "\n";
                } else {
                    unsatisfiedRuleListAppender = "cList.add(" + Math.abs(doubleRuleCount) + ");\n";
                    printStmnt += "\"+ -> \"+" + " " + Math.abs(doubleRuleCount)  + ");" + "\n";
                }
            }
        } 
        rule += " " + constraint;
        rule += ")\n";
        if (!modification.equals("")) {
            modification = "modify(" + modClass + "){" + modification + "};"; 
            printStmnt = "";
        }
        rule = this.ruleHeader + " " + WHEN +  "\n" + rule + "\t)" + "\n" + THEN + "\n";
        
        rule += addVariableStatus() + "\n";
        rule += "\n" 
                + printStmnt + unsatisfiedRuleListAppender;
        rule += END + "\n";
        modificationConstraint = false; modification = "";
        rhsIndicator = 0;
        unsatisfiedRuleListAppender = "";
        mvelModeIndicator = 0;
        compoundHeads = "";
        dListAdder = "";
        compoundPlaceHolders.removeAll(compoundPlaceHolders);
        if (!ruleSupported || unusedConstraint) {
//            logger.info("Non supported rule is " + rule);
            rule = "";
        }
        changeMeta = false;
        return rule;
    }
    
    /**
     * Private method to add rule headers.
     * Rule headers include the agenda group, rule number or ID.
     */
    private void addRuleHeaders() {
        if (!modificationConstraint) {
            this.ruleHeader = "rule " + "\"" + prependRule + ruleCount; 
            if (ruleCounter != 0) {
                ruleHeader += "_" + ruleCounter;
            }
            ruleHeader += "\"" + "\n" + ruleAttributes;
        } else {
            String agenda = "agenda-group " + "\"" + "Group 2" + "_" + ruleCount
                    //Roman: Commented lines cause a loop
                    //String agenda = "agenda-group " + "\"" + "Group 0"
                    + DroolsVisitor.getImportedProjectName()
                    + "\"" + "\n";
            this.ruleHeader = "rule " + "\"" +  prependRule + ruleCount + "\"" + "\n"  
                    + agenda + modificationAttributes;
            DroolsVisitor.addAgendaGroup2("Group 2" + "_" + ruleCount + DroolsVisitor.getImportedProjectName());
            //DroolsVisitor.addAgendaGroup2("Group 0" + DroolsVisitor.getImportedProjectName());
        }
    }

    /**
     * Method that initializes the final rule, with all the necessary drools rule project headers.
     * Since, all the decision variables are translated into various Drools project class members,
     * The project headers are needed in the rule, to find the matching project objects. 
     */
    private void finalRuleInitializer() {
        if (containerHead.equals("")) {
            rule += compoundHeads 
                    + containerHead
                    + "\n" + pattern.get(0) + "\n" + "P : Project( \n\teval(\n\t";
        } else {
            rule += compoundHeads 
                    + containerDeclInitial 
                    + containerCallDeclaration + ")\n"
                    + containerHead
                    + "\n" + pattern.get(0) + "\n" + "P : Project( eval(\n\t";
        }
        for (int i = 1; i < this.pattern.size(); i++) {
            rule += pattern.get(i);
            rule += " && ";
        }
        for (int i = 0; i < this.pattern2.size(); i++) {
            rule += pattern2.get(i);
            rule += " && ";
        }
//        addVariableStatus();
        if (orPatterns.size() > 0) {
            
            rule += "(";
            for (int i = 0; i < this.orPatterns.size(); i++) {
                rule += orPatterns.get(i);
                if (i != orPatterns.size() - 1) {
                    rule += " || ";
                }
            } 
            rule += ") && ";
        }
    }

    /**
     * Updating the status of the variable modified within a rule.
     * @return String that updates the status.
     */
    private String addVariableStatus() {
        String statusAdder = "";
        String addToDlist = "";
        if (!dListAdder.equals("")) {
            addToDlist += "\n\t\tdList.add(\"" + dListAdder + "\");";
            addToDlist += "\n\t\tvList.add(\"" + dListAdder + "\");\n\t";
            for (String str : compounddListAdder) {
                addToDlist += "\t" + "dList.add(\"" + str + "\");\n";
                addToDlist += "\t" + "vList.add(\"" + str + "\");\n";
            }
        }
        if (modificationConstraint) {
            pattern.addAll(pattern2);
            statusAdder += "if (";
            for (int i = 1; i < this.pattern.size(); i++) {
                if (pattern.get(i).contains("List.")) {
                    String temp = pattern.get(i).replace("dList", "fList");
                    statusAdder += temp + " && ";
                }
            }
            
            statusAdder += "true ) {\n\t";
            String x = "\tif (" 
                    + "fList.contains(\"" + dListAdder + "\") ) {";
            x += "\n\t\t " + "System.err.println(" + "\"" + "Error LHS fixed ######## " 
                    + "\"" + " + " + ruleCount +  ");\n"
                    + "\t\t //cList.add(" + ruleCount + ");\n\t}";
            x += " else {\n\t\t" 
                    + addToDlist;
            if (!dListAdder.equals("") && !doNotFix) {
                x += "\tfList.add(\"" + dListAdder + "\");\n\t";
            }
            for (String str : compounddListAdder) {
                if (!dListAdder.equals("") && !doNotFix) {
                    x += "\tfList.add(\"" + str + "\");\n\t";
                }
                x += "\tdList.add(\"" + str + "\");\n\t";
                x += "\tvList.add(\"" + str + "\");\n\t";
            }
            x += modification
                    + "\n\t}";
            statusAdder += x + "\n}";
        } 
        
        String statusValidator = "";
        if (modificationConstraint) {
            pattern.addAll(pattern2);
            if (changeMeta) {
                statusValidator += " else {\n\t" 
                        + "if ( " 
                        + "fList.contains( \""
                        + dListAdder + "\") ) {";
            } else {
                statusValidator += " else {\n\t" 
                        + "if ( " + "dList.contains(\"" + dListAdder + "\") || " 
                        + "fList.contains( \""
                        + dListAdder + "\") ) {";
            }
            int num = 0;
            if (ruleCount instanceof Double) {
                num = ruleCount.intValue();
            } else {
                num = ruleCount.intValue();
            }
            statusValidator += "\n\t\t" + "System.err.println(" + "\"" + "Error LHS default ######## " 
                    + "\"" + " + " + Math.abs(num) +  ");\n"
                    + "\t\t//cList.add(" + Math.abs(num) + ");\n\t}"
                    + " else {\n\t\t" 
                    + addToDlist
                    + modification 
                    + "\n\t}" + "\n}";
        }
        
        return statusAdder + statusValidator + " \n";
    }
    
    @Override
    public void visitConstantValue(ConstantValue value) {
        value.getConstantValue().accept(this);
    }
    
    @Override
    public void visitOclFeatureCall(OCLFeatureCall call) {
        String op = call.getOperation();
        currentOperation = op;
        int result = getCalltype(call);
        
        switch (result) {
        case 0:
            variableStatusChecker = "dList.contains";
            call.getOperand().accept(this);
            this.modificationConstraint = true;
            rhsIndicator++;
            for (int i = 0; i < call.getParameterCount(); i++) {
                call.getParameter(i).accept(this);
            }
            break;

        case 1:
            notModificationRule(call, op);
            break;
            
        default:
            logger.info("");
            break;
        }
    }
    
    /**
     * Method to identify the type of constraint.
     * @param call OCL call.
     * @return 0 if it is a soft constraint, 1 if it is a hard constraint.
     */
    private int getCalltype(OCLFeatureCall call) {
        int result = 0;
        String op = call.getOperation();
        boolean operationIsImplies = op.equals(OclKeyWords.IMPLIES);
        int params = call.getParameterCount();
        
        if (operationIsImplies && rhsIndicator == 0 && (params == 1) 
                && call.getParameter(0).getClass().equals(call.getClass())) {
            OCLFeatureCall temp = (OCLFeatureCall) call.getParameter(0);
            boolean operationisEquals = temp.getOperation().equals(OclKeyWords.EQUALS);
            if (operationisEquals && (ruleCounter == 0)
                    && (temp.getOperand() instanceof Variable)) {
                result = 0;
                
            } else if (temp.getOperation().equals(OclKeyWords.EQUALS) && (ruleCounter == 0)
                    && (temp.getOperand() instanceof CompoundAccess)) {
                result = 0;
            } else {
                rhsIndicator++;
                result = 1;
            }
        } else if (operationIsImplies && (rhsIndicator == 0) 
                && (call.getParameter(0) instanceof Parenthesis)) {
            rhsIndicator++;
            result = 1;
//            call1.accept(this);
        } else {
            rhsIndicator++;
            result = 1;
        }
        
        return result;
    }

    /**
     * Method to process where there is no modification, i.e. Pure hard constraints or validations. 
     * @param call OCL Call.
     * @param operation Operation.
     */
    private void notModificationRule(OCLFeatureCall call, String operation) {

        // Check this in future.
        // To mitigate the problem with equalities involving reals, ocl calls are rewritten 
        // as not(unequals - expression)
        OCLFeatureCall callA = call;
        if (!modificationConstraint) {
            callA = processEqualityCall(call, operation, callA);
            
        } else {
            if (this.mvelModeIndicator != 0) {
                callA = processEqualityCall(call, operation, callA);
            }
        }
        operation = callA.getOperation();
        
        if (DroolsOperations.isImplicitOperation(operation)) {
            doJavaSyntax(callA, operation);
        } else {
            if (!DroolsOperations.isOperationSupported(operation)) {
                ruleSupported = false;
            }
            doLispSyntax(callA, operation);
        }
    }

    /**
     * A private method to change the signature of Ocl call whose operation is "==".
     * This is represented as !(operand <> parameter), as Drools sometimes gives strange results for real value
     * comparison.
     * @param call Original ocl call.
     * @param op Operation.
     * @param callA Re-written call for drools.
     * @return Returns an ocl call with a changed signature.
     */
    private OCLFeatureCall processEqualityCall(OCLFeatureCall call, String op, OCLFeatureCall callA) {
        if (op.equals(OclKeyWords.EQUALS)) {
            OCLFeatureCall call1 = new OCLFeatureCall(call.getOperand(), 
                    OclKeyWords.UNEQUALS, call.getParameter(0));
            callA = new OCLFeatureCall(call1, OclKeyWords.NOT);
            
        }
        return callA;
    }

    /**
     * Expression with operation not intrinsically supported by Drools is processed
     * in Lisp style. 
     * Lisp style/syntax is -> (operation param1, param2 ..)
     * @param call OCL FeatureCall.
     * @param op Operation.
     */
    private void doLispSyntax(OCLFeatureCall call, String op) {
        String operation = DroolsOperations.getDroolsOperation(op);
        this.currentOperation = operation;
        if (modificationConstraint) {
            modification += operation + "(";
        } else {
            constraint += operation + "(";
        }
        call.getOperand().accept(this);
        boolean hasParams = (call.getParameterCount() != 0);
        
        if (modificationConstraint && hasParams) {
            modification += " , ";
        } else if (!modificationConstraint && hasParams) {
            constraint += " , ";
        }
        for (int i = 0; i < call.getParameterCount(); i++) {
            call.getParameter(i).accept(this);
            if (i != (call.getParameterCount() - 1)) {
                constraint += " , ";
            } else {
                constraint += " ";
            }
        }
        if (modificationConstraint) {
            if (currentOperation.equals("ivmlDef")) {
                modification += "\"";
            }
            modification += ")";
        } else {
            if (currentOperation.equals("ivmlDef")) {
                constraint += "\"";
                currentOperation = "";
            }
            constraint += ")";
        } 
    }

    /**
     *Expression with operation intrinsically supported by Drools is processed
     * in Java style.  
     * @param call OCL FeatureCall.
     * @param op Operation.
     */
    private void doJavaSyntax(OCLFeatureCall call, String op) {
        @SuppressWarnings("static-access")
        String operation = dOp.getDroolsOperation(op);
        this.currentOperation = operation;
        call.getOperand().accept(this);
        if (this.modificationConstraint) {
            modification += " ";
            if (operation.equals(OclKeyWords.EQUALS)) {
                if ((mvelModeIndicator == 0) ) {
                    this.modification += "=";
                    modification += " ";
                    mvelModeIndicator++;
                } else {
                    modification += "==";
                }
            } else {
                modification += operation + " ";
            }
        } else {
            constraint += " ";
            this.constraint += operation;
            constraint += " ";
        }
        for (int i = 0; i < call.getParameterCount(); i++) {
            call.getParameter(i).accept(this);
            if (i != (call.getParameterCount() - 1)) {
                if (modificationConstraint) {
                    modification += " ";
                } else {
                    constraint += " ";
                }
            }
        }
    }

    @Override
    public void visitVariable(Variable variable) {
        String name = variable.getVariable().getName();
        /**
         * For handling LHS of implies.
         * For eg. Exp1 implies var == Exp2; 
         * Exp1 is LHS.
         */
        if (!modificationConstraint) {
            constraintLogic(variable, name);
        } else {
            /**
            Logic for the variable being modified. 
            For eg.. Exp1 implies var == Exp2; 
            var is the variable being modified. 
            */
            if (mvelModeIndicator == 0) {
                processVariableBeingModified(variable);
            } else {
                /**
                 * For handling, RHS of implies.
                 * For eg.. Exp1 implies var == Exp2;
                 * Exp2 is the RHS. 
                 */
                int thr = getDroolsClassNr(name);
                writeDroolsClassPattern(name);
                modification += "P" + thr + "." + name;
                if (variable.getVariable().getType().getTypeClass().equals(Compound.class)) {
                    writeConstraintLogicForCompoundVariable(variable, name);
                } else {
                    if (variable.getVariable().getParent().getClass().equals(Project.class)) {
                        pattern2.add(variableStatusChecker + "(" + "\"" + name + letSuffix + "\") ");
                    }
                }
            }
        }
    }

    /**
     * Method to process the variable being modified and related scenarios.
     * @param variable Variable to be modified.
     */
    private void processVariableBeingModified(Variable variable) {
        String name = variable.getVariable().getName();
        
        if (variable.getVariable().getType().getTypeClass().equals(Compound.class)) {
            
            /**
             * If the variable is a compound type.
             */
            modifyingCompoundVariable(name);
        } else if (variable.getVariable().getParent().getClass().equals(Compound.class)) {
            /**
             * If the parent of the variable is a compound.
             */
            changeMeta = true;
            modifyingNestedDeclaration(variable);
        } else if (variable.getVariable().getParent().getClass().equals(AttributeAssignment.class)
                && variable.getVariable().getParent().getParent().getClass().equals(Compound.class)) {
            /**
             * if the parent is assignment attribute whose parent is the compound itself.
             */
            changeMeta = true;
            modifyingNestedDeclaration(variable);
        } else {
            
            /**
             * For all other scenarios.
             */
            writeDroolsClassPattern(name);
            currentCompound = name;
            int thr = getDroolsClassNr(name);
            modClass = "P" + thr;
            modification += name;
            dListAdder += name;
            pattern2.add("!vList.contains(" + "\"" + name  + "\") ");
        }
    }
    
    /**
     * Method for modifying compound type variable.
     * @param name name of the variable.
     */
    private void modifyingCompoundVariable(String name) {
        
        writeDroolsClassPattern(name);
        currentCompound = name;
        int thr = getDroolsClassNr(name);
        modClass = "P" + thr;
        modification += name; 
        varBeingModified = name;
        
        if (currentSlot.equals("")) {
            dListAdder += name;
        }
        
    }

    /**
     * Method for modifying a nested element declaration, i.e., variable whose parent is compound. This is
     * especially written to handle the following example.
     * 
     * compound C {
     *      Integer a;
     *      a > 5;
     * }
     * 
     * @param variable Variable whose parent is compound.
     */
    private void modifyingNestedDeclaration(Variable variable) {
        String name = variable.getVariable().getName();
        String parent = variable.getVariable().getParent().getName();
        if (variable.getVariable().getParent().getClass().equals(AttributeAssignment.class)) {
            parent = variable.getVariable().getParent().getParent().getName();
        }
        String compoundName = parent;
        if (!compoundPlaceHolders.contains(compoundName)) {
            compoundHeads += "\n" + "$" + compoundName + ": " + compoundName + "()"; 
        }
        
        /**
         * Retrieving all the declarations of this compound type.
         */
        List<String> li = new ArrayList<String>();
        if (DroolsVisitor.getCompoundMap().get(compoundName) == null) {
            ruleSupported = false;
        }
        li = DroolsVisitor.getCompoundMap().get(compoundName);
        for (String str : li) {
            compounddListAdder.add(str + "." + name);
        }
        
        modClass = "$" + compoundName;
        dListAdder = compoundName + "." + name;
        modification += name;
    }

   
    /**
     * Private method to write the constraint logic.
     * Note: the param name can be extracted from variable, but here it is being passed
     * for the sake of convenience. 
     * @param variable variable.
     * @param name Name.
     */
    private void constraintLogic(Variable variable, String name) {
        String patternToAdd = "isDefined(" + "P." + name + ")";
        boolean isDerivedType = variable.getVariable().getType().getTypeClass().equals(DerivedDatatype.class);
        boolean isCompoundType = variable.getVariable().getType().getTypeClass().equals(Compound.class);
        if (isDerivedType) {
            logger.info("");
        }
        if (isCompoundType) {
            //Adding pattern for a compound type variable.
            patternToAdd = writeConstraintLogicForCompoundVariable(variable, name);
        } 
        
        if ((variable.getVariable().getType().getTypeClass().equals(Compound.class))) {
            //Type is compound.
            notModification(name, patternToAdd, variable);
        } else if (variable.getVariable().getParent().getClass().equals(Compound.class)) {
            //Parent is compound.
            writeConstraintLogicForNestedElement(variable, name, isDerivedType);
        } else {
            //For all other scenarios.
            if (variable.getVariable().getParent().getClass().equals(Project.class)) {
                if (variable.getVariable() instanceof Attribute) {
                    //if attribute, name is changed. 
                    Attribute attr = (Attribute) variable.getVariable();
                    name = "$attr_" + attr.getElement().getName() + "_"
                            + attr.getName();
                }
                pattern.add(variableStatusChecker + "(" + "\"" + name + letSuffix + "\") ");
                if (currentOperation.equals("ivmlDef")) {
                    constraint += "dList, " + "\"" + name; 
                } else {
                    writeConstraintLogicForNonNestedElement(variable, name);
                }
            } else if (variable.getVariable().getParent().getClass().equals(Constraint.class)) {
                // Mainly for the variables used in Let expressions. Parent is Constraint.
                writeConstraintLogicForNonNestedElement(variable, name);
            } else if (variable.getVariable().getParent().getClass().equals(AttributeAssignment.class)) {
                writeConstraintLogicForNonNestedElement(variable, name);
            } else {
                ruleSupported = false;
            }
        }
    }

    /**
     * Method to write constraint logic for non nested element. This can be written in 
     * Drools Java dialect or Mvel dialect. Previous measures show Java dialect for non-nested elements
     * is much faster than using mvel. 
     * @param variable variable.
     * @param name name of the variable.
     */
    private void writeConstraintLogicForNonNestedElement(Variable variable, String name) {
        writeDroolsClassPattern(name);
        int thr = getDroolsClassNr(name);
        char ch = name.charAt(0);
        ch = Character.toUpperCase(ch);
        StringBuilder nameTemp = new StringBuilder(name);
        nameTemp.setCharAt(0, ch);
        String javaDialectNotation = "P" + thr + ".get" + nameTemp + letSuffix + "()";
        if (isNotPrimitiveType(variable)) {
            if (USEJAVADIALECT) {
                pattern.add("isDefined(" + javaDialectNotation + ")");
            } else {
                pattern.add("isDefined(" + "P" + thr + "." + name + ")");
            }
        }
        if (USEJAVADIALECT) {
            constraint += "P" + thr + ".get" + nameTemp + letSuffix + "()";
        } else {
            constraint += "P" + thr + "." + name + letSuffix;
        }
    }

    /**
     * Method to write the constraint logic in drools for a nested element.
     * @param variable variable.
     * @param name Name of the variable.
     * @param isDerivedType <b>True</b> if the variable is a derived type.
     */
    private void writeConstraintLogicForNestedElement(Variable variable, String name, boolean isDerivedType) {
        String patternToAdd;
        patternToAdd = "isDefined( $" + variable.getVariable().getParent().getName() + "." + name + ")";
        pattern.add(patternToAdd);
        String parent = variable.getVariable().getParent().getName();
        if (!compoundPlaceHolders.contains(parent)) {
            compoundPlaceHolders.add(parent);
            compoundHeads += "\n" + "$" + parent + ": " + parent + "()";
        }
        constraint += "$" + parent + "." + name;
        List<String> li = DroolsVisitor.getCompoundMap().get(parent);
        if (isDerivedType && (null != li)) {
            String cAc1 = variableStatusChecker + "(" + "\"" + parent + "\"" + ")";
            String cAc2 = variableStatusChecker + "(" + "\"" + parent + "." + name + "\"" + ")";
            String pattern1 = cAc1 + " || " + cAc2;
            String pattern22 = "";
            for (int i = 0; i < li.size(); i++) {
                String access1 = variableStatusChecker + "(" + "\"" + li.get(i) + "\"" + ")";
                String access2 = variableStatusChecker + "(" + "\"" + li.get(i) + "." + name + "\"" + ")";
                pattern22 += " || " + access1 + " || " + access2;
            }
            pattern.add("(" + pattern1 + pattern22 + ")");
        }  
    }

    /**
     * Method to write the constraint logic for variable of a compound type.
     * @param variable Variable.
     * @param name name of the variable. 
     * @return The constraint logic in drools.
     */
    private String writeConstraintLogicForCompoundVariable(Variable variable, String name) {
        String patternToAdd;
        writeDroolsClassPattern(name);
        if (variable.getVariable().getParent().getClass().equals(Project.class)) {
            int thr = getDroolsClassNr(name);
            String p1 = "isDefined(" + "P" + thr + "." + name;
            pattern.add(p1 + ")");
            if (!currentSlot.equals("")) {
                logger.info("");
            }
            patternToAdd = p1 + ")";
        } else {
            patternToAdd = "isDefined( $" + variable.getVariable().getParent().getName() + "." + name + ")";
            pattern.add(patternToAdd);
        }
        return patternToAdd;
    }

    /**
     * A private method to identify if a non-nested variable is not either an Integer, Real or a Boolean.
     * @param variable Variable.
     * @return <b>True</b> if the variable is not Integer, Real or Boolean.
     */
    private Boolean isNotPrimitiveType(Variable variable) {
        Boolean result = true;
        if (variable.getVariable().getType().equals(IntegerType.TYPE) 
                || variable.getVariable().getType().equals(RealType.TYPE)
                || variable.getVariable().getType().equals(BooleanType.TYPE)) {
            result = false;
            
        }
        
        return result;
    }


    /**
     * Private method for variables participating in evaluation constraints.
     * @param name name of the variable.
     * @param patternToAdd Pattern to add.
     * @param variable Variable.
     */
    private void notModification(String name, String patternToAdd, Variable variable) {
        if (currentOperation.equals("ivmlDef")) {
            currentCompound = name;
            constraint += "dList, " + "\"" + name; // + "\"";
        } else {
            pattern.add(patternToAdd);
            currentCompound = name;
            writeDroolsClassPattern(name);
            int thr = getDroolsClassNr(name);
            constraint += "P" + thr + "." + name;
        }
    }

    @Override
    public void visitParenthesis(Parenthesis parenthesis) {
        if (modificationConstraint) {
            modification += "(";
            parenthesis.getExpr().accept(this);
            modification += ")";
        } else {
            constraint += "(";
            parenthesis.getExpr().accept(this);
            constraint += ")";
        }
    }
    
    /**
     * {@inheritDoc}
     */
    public void visitContainerInitializer(ContainerInitializer init) {
        // TODO check
        ruleSupported = false;
        for (int e = 0; e < init.getExpressionCount(); e++) {
            init.getExpression(e).accept(this);
        }
    }
    
    /**
     * {@inheritDoc}
     */
    public void visitCompoundInitializer(CompoundInitializer init) {
        // TODO check
//        ruleSupported = false;
        if (modificationConstraint) {
            ruleSupported = false;
        }
        Compound compound = init.getType();
        int slotCount = compound.getElementCount();
        if (init.getExpressionCount() == slotCount) {
            constraint += "new " + init.getType().getName() + "(";
            for (int i = 0; i < init.getSlotCount(); i++) {
                init.getExpression(i).accept(this);
                if (i != init.getSlotCount() - 1) {
                    constraint += " , ";
                }
            }
        } else {
            ruleSupported = false;  
        }
        constraint += ")";
    }

    @Override
    public void visitComment(de.uni_hildesheim.sse.model.cst.Comment comment) {
        comment.getExpr().accept(this);
    }
    
 

    @Override
    public void visitEnumValue(EnumValue value) {
        if (modificationConstraint) {
            modification += value.getValue().getOrdinal();
        } else {
            constraint += value.getValue().getOrdinal();
        }
    }

    @Override
    public void visitConstraintValue(ConstraintValue value) {
        // TODO handle dynamically changing constraints
    }

    
    @Override
    public void visitStringValue(StringValue value) {
        String val = value.getValue();
        
//        val = val.replace("\\", "\\" + "\\");
//        val = val.replace("\"", "\\\"");
        val = DroolsVisitor.processStringEscapeSequences(val);
        if (modificationConstraint) {
            modification += "\"" + val + "\"";
        } else {
            constraint += "\"" + val + "\"";
        }
    }

    @Override
    public void visitCompoundValue(CompoundValue cValue) {
        String compoundName = cValue.getType().getName();
        Compound temp = (Compound) cValue.getType();
        String obIns = "";
        obIns += "new " + compoundName + "(";
        if (modificationConstraint) {
            modification += obIns;
        } else {
            constraint += obIns;
        }
        if (cValue.isFullyConfigured()) {
            for (int i = 0; i < temp.getElementCount(); i++) {
                String name = temp.getElement(i).getName();
                if (cValue.getNestedValue(name) != null) {
                    processAddingNestedElementsTodroolsdList(cValue, name);
                    cValue.getNestedValue(name).accept(this);  
                } else {
                    if (modificationConstraint) {
                        modification += "null";
                    } else {
                        constraint += "null";
                    }
                }
                if (i != temp.getElementCount() - 1) {
                    if (modificationConstraint) {
                        modification += ",";
                    } else {
                        constraint += ",";
                    }
                }
            }
        } else {
            ruleSupported = false;
        }
        if (modificationConstraint) {
            modification += ")";
        } else {
            constraint += ")";
        }
    }

    /**
     * Method to process adding each of the ensted elements to the drools dlist, for maintaining the logic 
     * using dynamic status changes.
     * @param cValue Compound Value.
     * @param name name of the nested element.
     */
    private void processAddingNestedElementsTodroolsdList(CompoundValue cValue, String name) {
        if (modificationConstraint) {
            if (!(cValue.getNestedValue(name) instanceof CompoundValue)) {
                compounddListAdder.add(varBeingModified + "." + name);
            } else {
                varBeingModified += "." + name;
            }
        }
    }

    @Override
    public void visitContainerValue(ContainerValue cValue) {
        boolean setValue = Set.TYPE.isAssignableFrom(cValue.getType());
//        this.ruleSupported = false;
        if (cValue.getElementSize() != 0) {
            contValues.add("Group 2_" + ruleCount);
            String append = "";
            if (!setValue) {
                append += " new java.util.ArrayList(java.util.Arrays.asList(new Object[] {";
            } else {
                append += " new java.util.HashSet(java.util.Arrays.asList(new Object[] {";
            }
            if (modificationConstraint) {
                modification += append;
            } else {
                constraint += append;
            }
            
            for (int i = 0; i < cValue.getElementSize(); i++) {
                if (cValue.getElement(i) instanceof CompoundValue 
                        && !((CompoundValue) cValue.getElement(i)).isFullyConfigured()) {
                    ruleSupported = false;
                }
                cValue.getElement(i).accept(this);
                if (i != cValue.getElementSize() - 1) {
                    if (modificationConstraint) {
                        modification += rule + " , ";
                    } else {
                        constraint += rule + " , ";
                    }
                }
            }
            if (modificationConstraint) {
                modification += "}))";
            } else {
                constraint += "}))";
            }
        } else {
            if (modificationConstraint) {
                modification += "null";
            } else {
                constraint += "null";
            }
        }
    }

    @Override
    public void visitIntValue(IntValue value) {
        if (modificationConstraint) {
            modification += value.getValue();
        } else {
            constraint += value.getValue();
        }
        
    }

    @Override
    public void visitRealValue(RealValue value) {
        if (modificationConstraint) {
            modification += value.getValue();
        } else {
            constraint += value.getValue();
        }
    }

    @Override
    public void visitBooleanValue(BooleanValue value) {
        if (modificationConstraint) {
            modification += value.getValue();
        } else {
            constraint += value.getValue();
        }
    }

    @Override
    public void visitReferenceValue(ReferenceValue referenceValue) {
        String name = referenceValue.getValue().getName(); // may be null -> getValueEx
        Boolean isRefToCompound = referenceValue.getType().getTypeClass().equals(Compound.class);
        if (modificationConstraint) {
            if (isRefToCompound && !currentSlot.equals("")) {
                modification += name + ".";
                dListAdder += name + "." + currentSlot;
            } else {
                modification += name;
                dListAdder += name;
            }
        } else {
            if (isRefToCompound) {
                currentCompound = name;
                String patternToAdd;
                String patternToAdd1 = variableStatusChecker + "(" + "\"" + name + "." + currentSlot + "\") ";
                String patternToAdd2 = variableStatusChecker + "(" + "\"" + name + "\") ";
                String type = referenceValue.getType().getName();
                String patternToAdd3 = variableStatusChecker + "(" + "\"" + type + "\") ";
                String patternToAdd4 = variableStatusChecker + "(" + "\"" + type + "." + currentSlot + "\") ";
                patternToAdd = "(" + patternToAdd1 + " || " + patternToAdd2 + " || " 
                        + patternToAdd3 + " || " + patternToAdd4 + ")";
                pattern.add(patternToAdd);
            } else {
                pattern.add(variableStatusChecker + "(" + "\"" + name + "\") ");
            }
            int droolsClassNr = getDroolsClassNr(referenceValue.getValue().getName());
            constraint += "P" + droolsClassNr + "." + referenceValue.getValue().getName();
        }
        
    }

    @Override
    public void visitMetaTypeValue(MetaTypeValue value) {
        String parent = value.getContainedType().toString();
        visitingMetaValue = true;
        currentCompound = parent;
        if (!compoundPlaceHolders.contains(parent)) {
            compoundPlaceHolders.add(parent);
            compoundHeads += "\n" + "$" + value.getContainedType() + ": " + value.getContainedType() + "()"; 
        } 
        if (!modificationConstraint) {
            constraint += "$" + value.getContainedType();
            pattern.add(variableStatusChecker + "(" + "\"" + currentCompound + "." + currentSlot + "\") ");
//            List<String> li = DroolsVisitor.getCompoundMap().get(parent);
        } else {
            changeMeta = true;
            if (mvelModeIndicator != 0) {
                modification += "$" + value.getContainedType();
            } else {
                modification += "$" + value.getContainedType();
                modClass = "$" + value.getContainedType().toString();
                
            }
        }
        
    }


    @Override
    public void visitLet(Let let) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitIfThen(IfThen ifThen) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitContainerOperationCall(ContainerOperationCall call) {
//        ruleSupported = false;
        String op = call.getOperation();
        ContainerClass cc = new ContainerClass();
        call.getContainer().accept(cc);
        call.getExpression().accept(cc);
        if (!DroolsOperations.isOperationSupported(op)) {
            ruleSupported = false;
        }
        containerHead += "\n" 
                + cc.contVar + cc.cHead 
                + cc.innerlogic + " from " + cc.logic + ")";
        if (!modificationConstraint) {
            
            constraint += DroolsOperations.getDroolsOperation(op) + "(" 
                    + cc.container + " , " + cc.contVar + ")";
        } else {
            modification += DroolsOperations.getDroolsOperation(op) + "(" 
                    + cc.container + " , " + cc.contVar + ")";
            rhsIndicator++;
            mvelModeIndicator++;
            mvelModeIndicator++;
        }
    }
    
    
    /**
     * Inner class exclusively dedicated to handle container calls and logic.
     * @author Phani 
     *
     */
    class ContainerClass implements IConstraintTreeVisitor {

//        private String containerDecl = "";
        private String cHead = " : ";
        private String logic = "";
        private String contVar = "";
        private String innerlogic = "";
        private String container = "";
        private String containerType = "";
        private String slot = "";
        
//        $l : java.util.ArrayList() from collect ( Number(this > 4) from p1.seq1)
        
        @Override
        public void visitConstantValue(ConstantValue value) {
            if (value.getConstantValue() instanceof StringValue) {
                innerlogic += " \"" + value.getConstantValue().getValue() + "\" ";
            } else if (value.getConstantValue() instanceof EnumValue) {
                EnumValue ev = (EnumValue) value.getConstantValue();
                innerlogic += " " + ev.getValue().getOrdinal() + " ";
            } else {
                innerlogic += " " + value.getConstantValue().getValue() + " ";
            }
        }

        @Override
        public void visitVariable(Variable variable) {
            if (variable.getVariable().isTemporaryVariable()) {
                innerlogic += "this ";
            } else {
                String parent = "P";
                if (!variable.getVariable().getParent().getClass().equals(Project.class)) {
                    parent = variable.getVariable().getParent().getName();
//                    containerDecl = "$$" + parent + " : " + parent + "()";
                } else {
                    int thr = getDroolsClassNr(variable.getVariable().getName());
                    writeDroolsClassPattern(variable.getVariable().getName());
                    String isDef = "isDefined(" +  parent + thr + "." + variable.getVariable().getName() + ")";
//                    containerDecl +=  isDef + " ";
                    if (!containerCallDeclaration.equals("")) {
                        containerCallDeclaration += "&& " + isDef + " ";
                    } else {
                        containerCallDeclaration += isDef + " ";
                        
                    }
                    
                } 
              
                if (variable.getVariable().getType().getTypeClass().equals(Compound.class)) {
                    int thr = getDroolsClassNr(variable.getVariable().getName());
                    container = parent + thr + "." + variable.getVariable().getName() + "." + slot;
                    logic += parent + thr + "." + variable.getVariable().getName() + "." + slot;
                    contVar = "$" + variable.getVariable().getName() + "_" + slot;
                    
                } else {
                    int thr = getDroolsClassNr(variable.getVariable().getName());
                    container = parent + thr + "." + variable.getVariable().getName();
                    logic += parent + thr + "." + variable.getVariable().getName();
                    contVar = "$" + variable.getVariable().getName();
                }
                if (Set.TYPE.isAssignableFrom(variable.getVariable().getType())) {
                    cHead += "java.util.Set() from collect (";
                } else {
                    cHead += "java.util.ArrayList() from collect (";
                }
                cHead += getDroolsType(variable.getVariable().getType());
                
                
            }
        }
        
        /**
         * Private method to get the drools type.
         * @param type Type.
         * @return The type to be used in the drools logic for container calls.
         */
        private String getDroolsType(IDatatype type) {
            String typ = type.getName();
            if (typ.equals(IntegerType.TYPE.getName()) || containerType.equals(IntegerType.TYPE.getName())) {
                typ = "Number";
            } else if (typ.equals(RealType.TYPE.getName()) || containerType.equals(RealType.TYPE.getName())) {
                typ = "Number";
            } else if (typ.equals(StringType.TYPE.getName()) || containerType.equals(StringType.TYPE.getName())) {
                typ = "String";
            } else if (typ.equals(BooleanType.TYPE.getName()) || containerType.equals(BooleanType.TYPE.getName())) {
                typ = "Boolean";
            } else {
                typ = type.getName();
                if (type.getTypeClass().equals(Sequence.class) || type.getTypeClass().equals(Set.TYPE)) {
                    Container cont = (Container) type;
                    if (cont.getContainedType().isAssignableFrom(Enum.TYPE) 
                            || cont.getContainedType().isAssignableFrom(OrderedEnum.TYPE)) {
                        typ = "Integer";
                    }
                }
            }
            
            return typ;
        }

        @Override
        public void visitParenthesis(Parenthesis parenthesis) {
            parenthesis.getExpr().accept(this);
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
        public void visitComment(de.uni_hildesheim.sse.model.cst.Comment comment) {
            comment.getExpr().accept(this);
        }

        @Override
        public void visitOclFeatureCall(OCLFeatureCall call) {
            this.innerlogic += "( ";
            String op = call.getOperation();
            if (DroolsOperations.isImplicitOperation(op)) {
                call.getOperand().accept(this);
                this.innerlogic += " " + DroolsOperations.getDroolsOperation(op) + " ";
                call.getParameter(0).accept(this);
            } else {
                innerlogic += DroolsOperations.getDroolsOperation(op);
                innerlogic += "(";
                call.getOperand().accept(this);
                innerlogic += " , ";
                call.getParameter(0).accept(this);
                innerlogic += ")";
            }
            innerlogic += ")";
        }
        
        
        
        @Override
        public void visitLet(Let let) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void visitIfThen(IfThen ifThen) {
            // TODO Auto-generated method stub
            
        }
        
        @Override
        public void visitSelf(Self self) {
            // TODO Auto-generated method stub
        }

        @Override
        public void visitContainerOperationCall(ContainerOperationCall call) {
            logger.info("inner call ");
        }

        @Override
        public void visitCompoundAccess(CompoundAccess access) {
            String slot = access.getSlotName();
            try {
                containerType = access.inferDatatype().getType().getName();
            } catch (CSTSemanticException e) {
                e.printStackTrace();
            }
            this.slot = slot;
            access.getCompoundExpression().accept(this);
        }

        @Override
        public void visitUnresolvedExpression(UnresolvedExpression expression) {
            // TODO Auto-generated method stub
            
        }
        
    }

    

    @Override
    public void visitCompoundAccess(CompoundAccess access) {
        String slot = access.getSlotName();
        currentSlot = slot;
        innerslot = "." + slot + innerslot;
        access.getCompoundExpression().accept(this);
        isDefinedString += "." + slot;
        if (!visitingMetaValue) {
            int clNr = getDroolsClassNr(currentCompound); 
            String isDefinedTemp = "isDefined(" + "P" + clNr + "." + currentCompound + isDefinedString + ")";
            if ((access.getResolvedSlot().getType() instanceof Compound)) {
                pattern.add(isDefinedTemp);
            } else if (!currentCompound.equals("")) {
                if (!modificationConstraint) {
                    pattern.add(variableStatusChecker + "(" + "\"" + currentCompound 
                            + isDefinedString  + "\") ");
                } else {
                    if (mvelModeIndicator == 0) {
                        dListAdder = currentCompound + isDefinedString;
                        pattern2.add("!vList.contains(" + "\"" + dListAdder  + "\") ");
                    } else {
                        pattern2.add(variableStatusChecker + "(" + "\"" + currentCompound 
                                + isDefinedString  + "\") ");
                    }
                }
                isDefinedString = "";
            }
        }
        if (!modificationConstraint) {
            constraint += "." + slot;
        } else {
            if (mvelModeIndicator == 0) {
                modification +=  "." + slot;
                if (visitingMetaValue) {
                    List<String> li = DroolsVisitor.getCompoundMap().get(currentCompound);
                    compounddListAdder.add(currentCompound + "." + slot);
                    
                    if (li.size() == 0) {
                        compounddListAdder.add(currentCompound + "." + slot);
                        dListAdder = currentCompound + "." + slot;
                        doNotFix = true;
                    }
                }
            } else {
                modification += "." + slot;
            }
        }
    }

    @Override
    public void visitUnresolvedExpression(UnresolvedExpression expression) {
        // TODO Auto-generated method stub
        
    }

    /**
     * {@inheritDoc}
     */
    public void visitAttributeAssignment(AttributeAssignment assignment) {
        // TODO Auto-generated method stub
    }

    @Override
    public void visitNullValue(NullValue value) {
        // TODO Auto-generated method stub
    }

    @Override
    public void visitVersionValue(VersionValue value) {
        // TODO Auto-generated method stub
    }
    
    @Override
    public void visitSelf(Self self) {
        // TODO Auto-generated method stub
    }

}
