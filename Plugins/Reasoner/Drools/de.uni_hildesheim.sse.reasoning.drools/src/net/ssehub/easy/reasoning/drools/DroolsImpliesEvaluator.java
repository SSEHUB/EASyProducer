package net.ssehub.easy.reasoning.drools;

import java.util.ArrayList;
import java.util.List;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.varModel.cst.AttributeVariable;
import net.ssehub.easy.varModel.cst.BlockExpression;
import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.cst.CompoundAccess;
import net.ssehub.easy.varModel.cst.CompoundInitializer;
import net.ssehub.easy.varModel.cst.ConstantValue;
import net.ssehub.easy.varModel.cst.ContainerInitializer;
import net.ssehub.easy.varModel.cst.ContainerOperationCall;
import net.ssehub.easy.varModel.cst.DeferInitExpression;
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
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.BooleanType;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.Container;
import net.ssehub.easy.varModel.model.datatypes.DerivedDatatype;
import net.ssehub.easy.varModel.model.datatypes.Enum;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.IntegerType;
import net.ssehub.easy.varModel.model.datatypes.OclKeyWords;
import net.ssehub.easy.varModel.model.datatypes.OrderedEnum;
import net.ssehub.easy.varModel.model.datatypes.RealType;
import net.ssehub.easy.varModel.model.datatypes.Sequence;
import net.ssehub.easy.varModel.model.datatypes.Set;
import net.ssehub.easy.varModel.model.datatypes.StringType;
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
import net.ssehub.easy.varModel.model.values.VersionValue;

/**
 * Visitor implementation for hard constraints for Drools. Hard constraints do not take 
 * assignment constraints into account.
 * @author Phani
 *
 */
public class DroolsImpliesEvaluator implements IConstraintTreeVisitor, IValueVisitor {
    
    private EASyLogger logger = EASyLoggerFactory.INSTANCE.getLogger(this.getClass(), Activator.BUNDLE_ID);
    
    private static final String WHEN = "when";
    private static final String THEN = "then";
    private static final String END = "end";
    private static final boolean USEJAVADIALECT = true;
    
    private static int ruleCounter = 0;
    private static List<String> contValues = new ArrayList<String>();
    private Number ruleCount = 0;
    private String ruleHeader = "";
    private final String ruleAttributes = "agenda-group " + "\"" + "Group 2"
            + DroolsVisitor.getImportedProjectName()
            + "\"" + "\n"
            + "dialect " + "\"mvel" + "\""
            + "\nno-loop true" 
//            + "\nlock-on-active true" 
            + "\n";
    private String printoutInDrls = "System.out.println(" + "\"" + "Rule not satisfied # " 
            + "\"" + " + ";
    
    private List<String> pattern = new ArrayList<String>();
    private List<String> rhsPattern = new ArrayList<String>();
    private List<String> orPatterns = new ArrayList<String>();
    private boolean visitingMetaValue = false;
    private String containerCallDeclaration = "";
    private String containerDeclInitial = "$$" + "P" + " : " + "Project" + "(";
    private String dListContains = "dList.contains";
    private int rhsCounter = 0;
    
    /**
     * Part of the rule logic present as hard constraint.
     */
    private String constraint = "";
    
    /**
     * part of the rule logic present as assignment constraint. 
     * For example, in - Exp21 implies var = Expr2; - RHS of implies is modification.
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
    
    /**
     * An iterator of the expression, that points out to the variable being modified, in case 
     * of a modification constraint. This supplements rhsIndicator for mvelDialect being 
     * used in Drools rules.
     */
    
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
    private String currentOp = "";
    
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
//    private String dListAdder = "";
    
    private String innerslot = "";
    private String modClass = "P";
    private String compoundHeads = "";
    

    /**
     * Sole constructor for the class.
     */
    public DroolsImpliesEvaluator() {
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
//        pattern.add("");
//        logger.info("rule count traditional is " + ruleCount1);
    }
    
    /**
     * Method that retrieves the Project class number the variable belongs to,
     * and also also writes the class pattern of the rule.
     * @param name name of the variable.
     */
    private void writeDroolsClassPattern(String name) {
        int thr = 0;
        if (DroolsVisitor.getDroolsClasseMap().get(name) != null) {
            
            thr = DroolsVisitor.getDroolsClasseMap().get(name) / DroolsVisitor.THRESHOLD;
        }
        String tempPattern = "\nP" + (thr) + " : " 
                + "Project" + thr + "()\n";
        if (pattern.contains("isDefined(P" + thr + ")")) {
            pattern.add("isDefined(P" + thr + ")");
            
        }
        if (!compoundHeads.contains(tempPattern)) {
            compoundHeads += tempPattern; 
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
    
    @Override
    public void visitConstantValue(ConstantValue value) {
        value.getConstantValue().accept(this);
    }

    @Override
    public void visitVariable(Variable variable) {
        String name = variable.getVariable().getName();
        if (!modificationConstraint) {
            constraintLogic(variable, name);
        } 
    }

    @Override
    public void visitAnnotationVariable(AttributeVariable variable) {
        // TODO check whether specific method is needed
        visitVariable(variable);
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
            patternToAdd = writeConstraintLogicForCompoundVariable(variable, name);
        } 
        if ((variable.getVariable().getType().getTypeClass().equals(Compound.class))) {
            notModification(name, patternToAdd, variable);
        } else if (variable.getVariable().getParent().getClass().equals(Compound.class)) {
            writeConstraintLogicForNestedElement(variable, name, isDerivedType);
        } else {
            if (variable.getVariable().getParent().getClass().equals(Project.class)) {
                if (variable.getVariable() instanceof Attribute) {
                    Attribute attr = (Attribute) variable.getVariable();
                    name = "$attr_" + attr.getElement().getName() + "_"
                            + attr.getName();
                }
                pattern.add(dListContains + "(" + "\"" + name + letSuffix + "\") ");
                if (rhsCounter > 0) {
                    rhsPattern.add(dListContains + "(" + "\"" + name + letSuffix + "\") ");
                }
                if (currentOp.equals("ivmlDef")) {
                    constraint += "dList, " + "\"" + name; 
                } else {
                    writeConstraintLogicForNonNestedElement(variable, name);
                }
            } else if (variable.getVariable().getParent().getClass().equals(Constraint.class)) {
                // Mainly for the variables used in Let expressions. Parent is Constraint.
                writeConstraintLogicForNonNestedElement(variable, name);
            } else {
                logger.info("name and parent " + name + " " + variable.getVariable().getParent().getClass());
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
            String cAc1 = dListContains + "(" + "\"" + parent + "\"" + ")";
            String cAc2 = dListContains + "(" + "\"" + parent + "." + name + "\"" + ")";
            String pattern1 = cAc1 + " || " + cAc2;
            String pattern22 = "";
            for (int i = 0; i < li.size(); i++) {
                String access1 = dListContains + "(" + "\"" + li.get(i) + "\"" + ")";
                String access2 = dListContains + "(" + "\"" + li.get(i) + "." + name + "\"" + ")";
                pattern22 += " || " + access1 + " || " + access2;
            }
            pattern.add("(" + pattern1 + pattern22 + ")");
            if (rhsCounter > 0) {
                rhsPattern.add("(" + pattern1 + pattern22 + ")");
            }
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
//            if (!currentOp.equals("ivmlDef")) {
//                pattern.add(variableStatusChecker + "(" + "\"" + name + "\")");
//            }
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
        if (currentOp.equals("ivmlDef")) {
            currentCompound = name;
            constraint += "dList, " + "\"" + name; // + "\"";
//            currentOp = "";
        } else {
            pattern.add(patternToAdd);
//            pattern.add(addCompoundPattern(variable, name));
            currentCompound = name;
            writeDroolsClassPattern(name);
            int thr = getDroolsClassNr(name);
            constraint += "P" + thr + "." + name;
            
        }
    }

    @Override
    public void visitParenthesis(Parenthesis parenthesis) {
        constraint += "(";
        parenthesis.getExpr().accept(this);
        constraint += ")";
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
    public void visitComment(net.ssehub.easy.varModel.cst.Comment comment) {
        comment.getExpr().accept(this);
    }
    
    @Override
    public void visitOclFeatureCall(OCLFeatureCall call) {
        String op = call.getOperation();
        currentOp = op;
        notModificationRule(call, op);
    }
    
    @Override
    public void visitDeferInitExpression(DeferInitExpression expression) {
        expression.getExpression().accept(this); // transparent
    }
    
    @Override
    public void visitMultiAndExpression(MultiAndExpression expression) {
        for (int e = 0; e < expression.getExpressionCount(); e++) {
            expression.getExpression(e).accept(this);
        }
    }

    /**
     * Method to process which do not have any constraints plus modifications. 
     * @param call Ocl call.
     * @param op Operation.
     */
    private void notModificationRule(OCLFeatureCall call, String op) {

        // Check this in future.
        // To mitigate the problem with equalities involving reals, ocl calls are rewritten 
        // as not(unequals - expression)
        OCLFeatureCall callA = call;
        if (!modificationConstraint) {
            callA = processEqualityCall(call, op, callA);
            
        } 
        op = callA.getOperation();
        
        if (DroolsOperations.isImplicitOperation(op)) {
            doJavaSyntax(callA, op);
        } else {
            if (!DroolsOperations.isOperationSupported(op)) {
                ruleSupported = false;
            }
            doLispSyntax(callA, op);
        }
    }

    /**
     * A private method to change the signature of Ocl call whose operation is "=".
     * This is represented as !(operand <> parameter), as Drools sometimes gives strage results for real value
     * comparision.
     * @param call Original ocl call.
     * @param op Operation.
     * @param callA Re-written call for drools.
     * @return Returns an ocl call with a changed signature.
     */
    private OCLFeatureCall processEqualityCall(OCLFeatureCall call, String op, OCLFeatureCall callA) {
        if (op.equals(OclKeyWords.EQUALS) || op.equals(OclKeyWords.ASSIGNMENT)) {
            OCLFeatureCall call1 = new OCLFeatureCall(call.getOperand(), 
                    OclKeyWords.UNEQUALS, call.getParameter(0));
            callA = new OCLFeatureCall(call1, OclKeyWords.NOT);
            
        }
        return callA;
    }

    /**
     * Expression with operation not intrinsically supported by Drools is processed
     * in Lisp style. 
     * @param call OCL FeatureCall.
     * @param op Operation.
     */
    private void doLispSyntax(OCLFeatureCall call, String op) {
        String operation = DroolsOperations.getDroolsOperation(op);
        this.currentOp = operation;
        constraint += operation + "(";
        call.getOperand().accept(this);
        rhsCounter++;
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
         
        if (currentOp.equals("ivmlDef")) {
            constraint += "\"";
            currentOp = "";
        }
        constraint += ")";
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
        this.currentOp = operation;
        call.getOperand().accept(this);

        constraint += " ";
        this.constraint += operation;
        constraint += " ";
        for (int i = 0; i < call.getParameterCount(); i++) {
            call.getParameter(i).accept(this);
            if (i != (call.getParameterCount() - 1)) {
                constraint += " ";
            }
        }
    }
   
    /**
     * Method that returns the drools class number.
     * @param name Variable name.
     * @return Drools class number.
     */
    private int getDroolsClassNr(String name) {
        return DroolsVisitor.getDroolsClasseMap().get(name) / DroolsVisitor.THRESHOLD;
    }
    
    /**
     * Method to derive the final rule.
     * @return The rule.
     */
    public String getRule() {
        addRuleHeaders();
        finalRuleInitializer();
        
        String printStmnt = printoutInDrls;
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
        rule += " " + constraint;
        rule += ")\n";
        if (!modification.equals("")) {
            modification = "modify(" + modClass + "){" + modification + "};"; 
            printStmnt = "";
        }
        rule = this.ruleHeader + " " + WHEN +  "\n" + rule + "\t)" + "\n" + THEN + "\n";
        
//        rule += "\n" 
//                + addChecker(pattern, printStmnt 
//                        + "\t\t" + unsatisfiedRuleListAppender);
        rule += "\n" + unsatisfiedRuleListAppender + "\n" + printStmnt; 
        rule += END + "\n";
        modificationConstraint = false; modification = "";
        unsatisfiedRuleListAppender = "";
        compoundHeads = "";
        compoundPlaceHolders.removeAll(compoundPlaceHolders);
        if (!ruleSupported) {
//            logger.info("Non supported rule is " + rule);
            rule = "";
        }
        return rule;
    }
    
    /**
     * Method to add a constraint validation check taking status of the variables/expressions into 
     * consideration. Relevant to the forms: var == exp 
     * @param pattern List of patterns
     * @param stringtoAdd String in drools format that throws error in case of constraint invalidity.
     * @return returns the string representation in drools.
     */
    private String addChecker(List<String> pattern, String stringtoAdd) {
        String result = "";
        List<String> patternCopy = pattern;
        for (int i = 0; i < patternCopy.size(); i++) {
            String str = patternCopy.get(i).replace("dList", "fList");
            patternCopy.set(i, str);
        }
        if (patternCopy.size() > 0) {
            String temp = "";
            result += "if (" + patternCopy.get(0) + " )" + " {\n\t";
            result += "if (";
            for (int i = 1; i < patternCopy.size(); i++) {
                result += patternCopy.get(i) + " && ";
                temp += patternCopy.get(i) + " && ";
            }
            temp += " true ";
            result += " true " + ") " + "{\n\t\t";
            result += stringtoAdd + "\n\t}" + "\n}";
            result += " else {" + "\n\t";
            result += "if (" + "!(" + temp + "))" + " {" + "\n\t";
            result += stringtoAdd + "\n\t}" + "\n}\n";
        }
        return result;
//        return "";
    }
    
    /**
     * Private method to add rule headers.
     * Rule headers include the agenda group, rule number or ID.
     */
    private void addRuleHeaders() {
        if (!modificationConstraint) {
            this.ruleHeader = "rule " + "\"" + ruleCount; 
            if (ruleCounter != 0) {
                ruleHeader += "_" + ruleCounter;
            }
            ruleHeader += "\"" + "\n" + ruleAttributes;
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
                    + "\n"  + "\n" + "P : Project( \n\teval(\n\t";
        } else {
            rule += compoundHeads 
                    + containerDeclInitial 
                    + containerCallDeclaration + ")\n"
                    + containerHead
                    + "\n" + "\n" + "P : Project( eval(\n\t";
        }
        for (int i = 0; i < this.pattern.size(); i++) {
            rule += pattern.get(i);
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

    
    


    @Override
    public void visitEnumValue(EnumValue value) {
        constraint += value.getValue().getOrdinal();
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
        constraint += "\"" + val + "\"";
    }

    @Override
    public void visitCompoundValue(CompoundValue cValue) {
        String compoundName = cValue.getType().getName();
        Compound temp = (Compound) cValue.getType();
        String obIns = "";
        obIns += "new " + compoundName + "(";
        constraint += obIns;
        if (cValue.isFullyConfigured()) {
            for (int i = 0; i < temp.getElementCount(); i++) {
                String name = temp.getElement(i).getName();
                if (cValue.getNestedValue(name) != null) {
                    cValue.getNestedValue(name).accept(this);  
                } else {
                    constraint += "null";
                }
                if (i != temp.getElementCount() - 1) {
                    constraint += ",";
                }
            }
        } else {
            ruleSupported = false;
        }
        constraint += ")";
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
            constraint += append;
            
            for (int i = 0; i < cValue.getElementSize(); i++) {
                cValue.getElement(i).accept(this);
                if (i != cValue.getElementSize() - 1) {
                    constraint += rule + " , ";
                }
            }
            constraint += "}))";
        } else {
            constraint += "null";
        }
    }

    @Override
    public void visitIntValue(IntValue value) {
        constraint += value.getValue();
        
    }

    @Override
    public void visitRealValue(RealValue value) {
        constraint += value.getValue();
    }

    @Override
    public void visitBooleanValue(BooleanValue value) {
        constraint += value.getValue();
    }

    @Override
    public void visitReferenceValue(ReferenceValue referenceValue) {
        String name = referenceValue.getValue().getName(); // may be null -> getValueEx
        Boolean isRefToCompound = referenceValue.getType().getTypeClass().equals(Compound.class);
        if (isRefToCompound) {
            currentCompound = name;
            String patternToAdd;
            String patternToAdd1 = dListContains + "(" + "\"" + name + "." + currentSlot + "\") ";
            String patternToAdd2 = dListContains + "(" + "\"" + name + "\") ";
            String type = referenceValue.getType().getName();
            String patternToAdd3 = dListContains + "(" + "\"" + type + "\") ";
            String patternToAdd4 = dListContains + "(" + "\"" + type + "." + currentSlot + "\") ";
            patternToAdd = "(" + patternToAdd1 + " || " + patternToAdd2 + " || " 
                     + patternToAdd3 + " || " + patternToAdd4 + ")";
            pattern.add(patternToAdd);
        } else {
            pattern.add(dListContains + "(" + "\"" + name + "\") ");
        }
        constraint += referenceValue.getValue().getName();
        
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
            List<String> li = DroolsVisitor.getCompoundMap().get(parent);
            if ((null != li)) {
                String pattern2 = "";
                for (int i = 0; i < li.size(); i++) {
                    String access2 = dListContains + "(" + "\"" + li.get(i) + "." + currentSlot + "\"" + ")";
                    pattern2 += " || " + access2;
                }
                pattern.add("( true " + pattern2 + ")");
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
//        String containerDeclInitial = "$$" + "P" + " : " + "Project" + "(";
        containerHead += "\n" 
                //+ containerDeclInitial 
                //+ containerCallDeclaration  + ")" + "\n" 
                + cc.contVar + cc.cHead 
//                + containerCallLogic; 
                + cc.innerlogic + " from " + cc.logic + ")";
        if (!modificationConstraint) {
            
            constraint += DroolsOperations.getDroolsOperation(op) + "(" 
                    + cc.container + " , " + cc.contVar + ")";
        } 
    }
    
    
    /**
     * Inner class exclusively dedicated to handle container calls and logic.
     * @author Phani 
     *
     */
    class ContainerClass implements IConstraintTreeVisitor {

        private String cHead = " : ";
        private String logic = "";
        private String contVar = "";
        private String innerlogic = "";
        private String container = "";
        private String containerType = "";
        private String slot = "";
        
//        $l : java.util.ArrayList() from collect ( Number(this > 4) from p1.seq1)
        
        @Override
        public void visitDeferInitExpression(DeferInitExpression expression) {
            expression.getExpression().accept(this); // transparent
        }
        
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
                } else {
                    int thr = getDroolsClassNr(variable.getVariable().getName());
                    writeDroolsClassPattern(variable.getVariable().getName());
                    String isDef = "isDefined(" +  parent + thr + "." + variable.getVariable().getName() + ")";
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
        
        @Override
        public void visitAnnotationVariable(AttributeVariable variable) {
            // TODO check whether specific method is needed
            visitVariable(variable);
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
        public void visitComment(net.ssehub.easy.varModel.cst.Comment comment) {
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
        public void visitMultiAndExpression(MultiAndExpression expression) {
            this.innerlogic += "( ";
            for (int e = 0; e < expression.getExpressionCount(); e++) {
                if (e > 0) {
                    innerlogic += " && ";
                }
                expression.getExpression(e).accept(this);
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
        public void visitBlockExpression(BlockExpression block) {
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
                    pattern.add(dListContains + "(" + "\"" + currentCompound 
                            + isDefinedString  + "\") ");
                    if (rhsCounter > 0) {
                        rhsPattern.add(dListContains + "(" + "\"" + currentCompound 
                                + isDefinedString  + "\") ");
                    }
                } 
                isDefinedString = "";
            }
        }
        if (!modificationConstraint) {
            constraint += "." + slot;
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

    @Override
    public void visitBlockExpression(BlockExpression block) {
        // TODO Auto-generated method stub
    }

}
