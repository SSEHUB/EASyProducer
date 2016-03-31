package net.ssehub.easy.reasoning.drools;

import java.util.ArrayList;
import java.util.List;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.varModel.cst.AttributeVariable;
import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.cst.Comment;
import net.ssehub.easy.varModel.cst.CompoundAccess;
import net.ssehub.easy.varModel.cst.CompoundInitializer;
import net.ssehub.easy.varModel.cst.ConstantValue;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.cst.ContainerInitializer;
import net.ssehub.easy.varModel.cst.ContainerOperationCall;
import net.ssehub.easy.varModel.cst.IConstraintTreeVisitor;
import net.ssehub.easy.varModel.cst.IfThen;
import net.ssehub.easy.varModel.cst.Let;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;
import net.ssehub.easy.varModel.cst.Parenthesis;
import net.ssehub.easy.varModel.cst.Self;
import net.ssehub.easy.varModel.cst.UnresolvedExpression;
import net.ssehub.easy.varModel.cst.Variable;
import net.ssehub.easy.varModel.model.Attribute;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.BooleanType;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.Container;
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
 * Class for reasoning on Assignment constraints.
 * @author Phani
 *
 */
public class DroolsAssignmentsVisitor implements IConstraintTreeVisitor, IValueVisitor {
    
    private EASyLogger logger = EASyLoggerFactory.INSTANCE.getLogger(this.getClass(), Activator.BUNDLE_ID);
    
    private static final String AGENDA = "agenda-group " + "\"" + "Group 0";
    private static final String NOLOOP = "no-loop true" + "\n";
    private static final String LOCKON = "lock-on-active true" + "\n";
    private static final String DIALECT = "dialect " + "\"" + "mvel" + "\"" + "\n";
    private static final String WHEN = "when" + "\n";
    private static final String THEN = "then \n\t";
    private static final String END = "end" + "\n";
    private static final boolean USEJAVADIALECT = true;
    private static List<String> contValues = new ArrayList<String>();
    private static int ruleCount = 0;
    
    private List<String> factUpdate = new ArrayList<String>();
    
    private boolean isGroup0 = false;
    private int modifyingClassnr = 0;
    private boolean defaultStatus = true;
    private String partialContVal = "";
    private String modclass = "P";
    /**
     * Contains the part of Drools rule that is being modified. 
     */
    private String modify = "";
    /**
     * Actual & complete Drools rule.
     */
    private String rule = "";
    /**
     * An iterator over the rule while visiting the CST. This is used to identify if the 
     * iterator points to the variable that is being modified. depending on this, the structure of 
     * the rule changes.  
     */
    private int ruleItr = 0; 
    /**
     * Placeholder consists of all the patterns that the Drools's rete engine should look into.
     * Specifically, it contains compound facts and combination of other patterns.
     */
    private String placeHolder = "";
    
    /*+
     * List of all patterns that go into the rule placeholder. Compound facts are not included here.
     */
    private List<String> patternList = new ArrayList<String>();
    private boolean ruleNotSupported = false;
    private boolean unusedConstraint = false;
    private List<String> compoundPlaceHolders = new ArrayList<String>();
    private String compoundHeads = "";
    
    /**
     * When a variable is modified/assigned, its name is added to a list in Drools. This string 
     * contains this part in Drools syntax. 
     */
    private String dListAdder = "";
    
    /**
     * This string will iteratively adds up the compound's nested element that is being modified.
     */
    private String slotChange = "";
    
    /**
     * When a compound variable is modified/assigned, each of the nested element name is added to a list in Drools. 
     * This string contains this part in Drools syntax. The names are stored in the format of nested access.
     */
    private List<String> compounddListAdder = new ArrayList<String>();
    
    /**
     *Current compound slot being accessed.  
     */
    private String currentSlot = "";
    
    /**
     * Current operation being processed. A distinction in how a rule is written is made in case of 
     * the operation {@link OclKeyWords} IS_DEFINED.
     */
    private String currentOperation = "";

    /**
     * Current compound being visited.
     */
    private String currentCompound = "";
    private boolean visitmeta = false;
    
    /**
     *This contains the patterns for container operation calls, which much different from those 
     *of normal, non-container type variables. 
     */
    private String containerHead = "";
    
    /**
     * This consists of the part of rule logic that checks if the variable being reasoned
     * has been defined in terms of a java object. This is particularly essential in case of 
     * compound accesses.
     */
    private String isDefinedString = "";
    
    
    
    private String containerCallDeclaration = "";
    private String containerDeclInitial = "$$" + "P" + " : " + "Project" + "(";
    
    private String dList = "";
    private List<String> compoundInitSlotChanges = new ArrayList<String>();
    private String compoundInitValue = "";
    private List<String> compoundInitRuleParts = new ArrayList<String>();
    private String factInsertion = "";
    private String prependRule = "";
    
    /**
     * Sole constructor for the class.
     */
    public DroolsAssignmentsVisitor() {
//        dOp = new DroolsOperations();
    }
    
    /**
     * Method that returns rule numbers invlolving modification of collection values.
     * @return List containing rules numbers involving container values.
     */
    public static List<String> getContValueRules() {
        return contValues;
    }
    
    /**
     * Setter for the rule prepending the rule.
     * @param prepend String to prepend to the rule name.
     */
    public void setRrulePrepend(String prepend) {
        prependRule = prepend;
    }

    /**
     * Getter for isRuleNotSupported.
     * @return <b>True</b> if the rule is not supported.
     */
    public boolean isRuleNotSupported() {
        return ruleNotSupported;
    }
    
    /**
     * Method that returns the drools class number.
     * @param name Variable name.
     * @return Drools class number.
     */
    private int getDroolsClassNr(String name) {
        if (!DroolsVisitor.getDroolsClasseMap().containsKey(name)) {
            ruleNotSupported = true;
            return -1;
        }
        return DroolsVisitor.getDroolsClasseMap().get(name) / DroolsVisitor.THRESHOLD;
    }
    
    /**
     * Method that retrieves the Project class number the variable belongs to,
     * and also also writes the class pattern of the rule.
     * @param name name of the variable.
     * @return Class number.
     */
    private int writeDroolsClassPattern(String name) {
        int thr = -1;
        
        if (DroolsVisitor.getDroolsClasseMap().get(name) != null) {
            thr = DroolsVisitor.getDroolsClasseMap().get(name) / DroolsVisitor.THRESHOLD;
        }
        
        String tempPattern = "\nP" + thr + ": " + "Project" + thr + "()";
        
        if (!compoundHeads.contains(tempPattern) && (thr != modifyingClassnr)) {
            compoundHeads += tempPattern;
        }
        
        if (thr == -1) {
            unusedConstraint = true;
        }
        return thr;
    }
    
    /**
     * Getter for the rule.
     * @return Rule.
     */
    public String getRule() {
        if (!slotChange.equals("")) {
            dListAdder = slotChange;
        }
        if (!dListAdder.equals("")) {
            patternList.add("!fList.contains(" + "\"" + dListAdder + "\"" + ")");
        }
        // Adding all the patterns.
        for (int i = 0; i < patternList.size(); i++) {
            placeHolder += patternList.get(i);
            if (i != (patternList.size() - 1)) {
                placeHolder += " && ";
            }
        } 
        
        modify = "\n" + "modify(" + modclass + ")";
        String eval = "";
        if (!placeHolder.equals("")) {
//            isGroup0 = false;
            eval = placeHolder;
        } else {
            
            eval = placeHolder;
        }
        placeHolder = compoundHeads + "\n" + "P" + modifyingClassnr + " : Project" + modifyingClassnr 
                + "(" + eval + ")\n";
        addRuleLogic();
        
        if (ruleNotSupported || unusedConstraint) {
//            logger.info("non supported rule is " + rule);
            rule = "";
        }
        return rule;
    }

    /**
     * Method to add the main logic of the rule. This consists of the rule number, 
     * agenda group and the RHS part.
     */
    private void addRuleLogic() {
        String ruleHeader1 = "" + "\"";
        if (ruleCount >= 0) {
            ruleHeader1 = "rule " + "\"" + prependRule + ruleCount + "\"" + "\n";
        } else {
            ruleHeader1 = "rule " + "\"" + Math.abs(ruleCount) + "\"" + "\n";
        }
        String ruleHeader2 = "";
        ruleHeader2 = addRuleLHS(ruleHeader2);
        DroolsVisitor.addAgendaGroup1("Group 0_" + ruleCount);
        String ruleHeader = ruleHeader1 + ruleHeader2;
        String ruleC = rule;
        rule = ruleHeader; 
        if (!dListAdder.equals("")) {
            addModifiedvariableTracker();
        }
        for (int i = 0; i < compoundInitSlotChanges.size(); i++) {
            rule += compoundInitSlotChanges.get(i);
           
        }
        for (int i = 0; i < compoundInitRuleParts.size(); i++) {
            rule += compoundInitRuleParts.get(i) + "\n\t";
        }
        if (compoundInitRuleParts.size() == 0) {
            rule += modify + "{" + ruleC + " " + "};" 
                    + "\n";
            rule += partialContVal + "\n";
//            rule += "System.out.println(" + "\"" + "Rule modified : " + "\"" + " + " + ruleCount + ");\n";
        } 
        if (factInsertion.length() > 0) {
            rule += "\n" + factInsertion;
        }
        for (String str : factUpdate) {
            rule += "update(" + str + ");\n";
        }
        rule += END;
    }

    /**
     * this method adds the necessary drools related code that adds the name of the variable being modified
     * to a list used in the .drl file. The names are added accordingly for compound types. 
     */
    private void addModifiedvariableTracker() {
        rule += "dList.add(\"" + dListAdder + "\");\n\t";
        if (!isGroup0) {
//        TODO check
            rule += "vList.add(\"" + dListAdder + "\");\n";
        }
        
        for (String str : compounddListAdder) {
            rule += "\t" + "dList.add(\"" + str + "\");\n";
            if (!isGroup0) {
                rule += "\t" + "vList.add(\"" + str + "\");\n";
            }
        }
        rule += "\n";
        addStatusToVariableBeingModified();
        if (dListAdder.contains(".")) {
            String[] seperated = dListAdder.split("[.]");
            String temp = "";
            for (int e = 0; e < seperated.length - 1; e++) {
                temp += seperated[e];
                rule += "dList.add(\"" + temp + "\");\n";
                temp += ".";
            }
        }
    }

    /**
     * Method adds the Left hand side of a rule. 
     * @param ruleHeaderLHS lhs side
     * @return Lhs side of the rule.
     */
    private String addRuleLHS(String ruleHeaderLHS) {
        if (isGroup0) {
            ruleHeaderLHS = AGENDA + DroolsVisitor.getImportedProjectName() + "\"" + "\n"
                    + DIALECT 
                    + NOLOOP 
                    + LOCKON 
                    + WHEN + placeHolder 
                    + containerDeclInitial 
                    + containerCallDeclaration 
                    + ")\n"
                    + containerHead
                    + THEN;
        } else if (!isGroup0 || !containerHead.equals("")) {
            ruleHeaderLHS = AGENDA + DroolsVisitor.getImportedProjectName() + "\"" + "\n"
                    // GENDA + "_" + ruleCount + DroolsVisitor.getImportedProjectName() + "\"" + "\n"
                    //Use the commented for only one group, i.e. Group0
                    + DIALECT 
                    + NOLOOP 
//                    + LOCKON 
                    + WHEN + placeHolder
                    + containerDeclInitial 
                    + containerCallDeclaration 
                    + ")\n" 
                    + containerHead
                    + THEN;
        }
        return ruleHeaderLHS;
    }

    /**
     * Method to add status to the variable being modified, during rule execution.
     */
    private void addStatusToVariableBeingModified() {
        if (!defaultStatus) {
            String statusMethod = "if ( ";
            for (String pattern : patternList) {
                statusMethod += pattern.replaceFirst("dList", "fList");
                statusMethod += " && ";
            }
            statusMethod += " true " + ") {" + "\n\t";
            statusMethod += "fList.add(\"" + dListAdder + "\");\n";
            for (String str : compounddListAdder) {
                statusMethod += "\t" + "fList.add(\"" + str + "\");\n";
            }
            statusMethod += "}";
            rule += statusMethod;
        }
    }

    /**
     * Setter for ruleCount.
     * @param ruleCount Rule count or rule number.
     */
    public static void setRuleCount(int ruleCount) {
        DroolsAssignmentsVisitor.ruleCount = ruleCount;
    }

    @Override
    public void visitConstantValue(ConstantValue value) {
        value.getConstantValue().accept(this);
    }

    @Override
    public void visitVariable(Variable variable) {
        String var = variable.getVariable().getName();
        if ((variable.getVariable().getType().getTypeClass().equals(Compound.class))) {
            currentCompound = var;
            isDefinedString = "";
        }
        if (ruleItr == 0) {
            /**
             * Variable being modified.
             */
            visitingVariableTobeModified(variable, var);
        } else {
            
            if (currentOperation.equals(OclKeyWords.IS_DEFINED)) {
                rule += " dList, \"" + var; // + "\"";
                int thr = writeDroolsClassPattern(var);
                patternList.add("isDefined(" + "P" + thr + "." 
                        + var + ")");
            } else {
                int thr = writeDroolsClassPattern(var);
                if (!(variable.getVariable().getType().getTypeClass().equals(Compound.class))) {
                    /**
                     * Processing variable that is not a compound type.
                     */
                    processNonCompoundTypeVariable(var, thr);
                } else if (variable.getVariable().getParent().getClass().equals(Compound.class)) {
                    /**
                     * Processing variable whose parent is a compound.
                     * Used for constraints expressed in a compound. 
                     */
                    processVariableInCompound(variable);
                } else {
                    rule += "P" + thr + "." + var;
                    compoundInitValue += "P" + thr + "." + var; 
                }
            }
        }
        
    }
    
    @Override
    public void visitAnnotationVariable(AttributeVariable variable) {
        // TODO check whether specific method is needed
        visitVariable(variable);
    }

    /**
     * Processing variable whose parent is a compound.
     * @param variable variable.
     */
    private void processVariableInCompound(Variable variable) {
        String var = variable.getVariable().getName();
        String compoundName = variable.getVariable().getParent().getName();
        if (!compoundPlaceHolders.contains(compoundName)) {
            compoundPlaceHolders.add(compoundName);
            compoundHeads += "\n" + "$" + compoundName + ": " + compoundName + "()"; 
        }
        rule += " $" + variable.getVariable().getParent().getName() + "." + var;
    }

    /**
     * Method to process the variable that is not a compound type.
     * @param variableName name of the variable.
     * @param droolsClassNr Drools class nr. it belongs to.
     */
    private void processNonCompoundTypeVariable(String variableName, int droolsClassNr) {
        if (USEJAVADIALECT) {
            char ch = variableName.charAt(0);
            ch = Character.toUpperCase(ch);
            StringBuilder nameTemp = new StringBuilder(variableName);
            nameTemp.setCharAt(0, ch);
            rule += "P" + droolsClassNr + ".get" + nameTemp + "()";
            compoundInitValue += "P" + droolsClassNr + ".get" + nameTemp + "()"; 
        } else {
            rule += "P" + droolsClassNr + "." + variableName;
        }
        String pttrn = "dList.contains(" + "\"" + variableName + "\") ";
        patternList.add(pttrn);
    }

    /**
     * Method to process visiting the variable to be modified.
     * @param variable Variable.
     * @param variableName name of the variable.
     */
    private void visitingVariableTobeModified(Variable variable, String variableName) {
        boolean parentIsACompound = variable.getVariable().getParent().getClass().equals(Compound.class);
        if ((variable.getVariable().getType().getTypeClass().equals(Compound.class))
                && !parentIsACompound) {
            /**
             * Modifying variable whose type is compound.
             */
            modifyCompoundTypeVariable(variableName);
        } else if (variable.getVariable().getParent().getClass().equals(Compound.class)) {
            /**
             * Modifying variable declared in a compound, i.e. variable whose parent is compound.
             * Used for constraints expressed in a compound. 
             */
            modifyVariableDeclaredInCompound(variable);
        } else {
            if (variable.getVariable() instanceof Attribute) {
                Attribute attr = (Attribute) variable.getVariable();
                variableName = "$attr_" + attr.getElement().getName() + "_"
                        + attr.getName();
            }
            if (DroolsVisitor.getDroolsClasseMap().get(variableName) == null) {
                logger.info("null name " + variableName);
            }
            modifyingClassnr = DroolsVisitor.getDroolsClasseMap().get(variableName) / DroolsVisitor.THRESHOLD;
            int thr = writeDroolsClassPattern(variableName);
            modclass = "P" + thr; 
            rule += variableName;
            dListAdder = variableName;
            /*
             * For future, in case only one group be used for all the rules for direct modification.
             * Similar change needs to be made in the class  DroolsConstraintVisitor suitably.
             * 
             * 
             */
            patternList.add("!vList.contains(" + "\"" + variableName  + "\") ");
            
            
        }
    }

    /**
     * Method to modify variable declared in a compound, i.e. variable whose parent is a compound.
     * @param variable variable.
     */
    private void modifyVariableDeclaredInCompound(Variable variable) {
        String variableName = variable.getVariable().getName();
        String compoundName = variable.getVariable().getParent().getName();
        
        if (!compoundPlaceHolders.contains(compoundName)) {
            compoundPlaceHolders.add(compoundName);
            compoundHeads += "\n" + "$" + compoundName + ": " + compoundName + "()"; 
        }
        List<String> li = DroolsVisitor.getCompoundMap().get(compoundName);
        for (String str : li) {
            compounddListAdder.add(str + "." + variableName);
        }
        modclass = "$" + compoundName;
        rule += variableName;
        dListAdder = compoundName + "." + variableName;
        patternList.add("!vList.contains(" + "\"" + compoundName + "." + variableName  + "\") ");
    }

    /**
     * Modifying a variable whose type is compound.
     * @param variableName Name of the variable.
     */
    private void modifyCompoundTypeVariable(String variableName) {
        slotChange += variableName;
        currentCompound = variableName;
        modifyingClassnr = DroolsVisitor.getDroolsClasseMap().get(variableName) / DroolsVisitor.THRESHOLD;
        int thr = writeDroolsClassPattern(variableName);
        modclass = "P" + thr;
//        rule += variableName + "";
        dListAdder = variableName + currentSlot;
        patternList.add("isDefined(" + modclass + "." + variableName + ")");
    }
    
    

    @Override
    public void visitParenthesis(Parenthesis parenthesis) {
        rule += "(";
        compoundInitValue += "("; 
        parenthesis.getExpr().accept(this);
        rule += ")";
        compoundInitValue += ")";
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
        rule += "new " + init.getType().getName() + "(";
        for (int i = 0; i < init.getSlotCount(); i++) {
            dList += "." + init.getSlot(i);
            processInnerCompoundInitializer(init.getExpression(i));
            if (i != init.getSlotCount() - 1) {
                rule += " , ";
            }
            
        }
//        if (init.getExpressionCount() == slotCount) {
//        } else {
//            
//            ruleNotSupported = true;
//        }
        rule += ")";
            
    }
    
    /**
     * This method is used to check if compound initializer expressions are in turn an compound initiliazers
     * and does a recursive processing to add the names of elements being modified
     * to the dList in .drl file. 
     * @param cst CST - each compound initializer expression.
     */
    private void processInnerCompoundInitializer(ConstraintSyntaxTree cst) {
        int thr = DroolsVisitor.getDroolsClasseMap().get(currentCompound) / DroolsVisitor.THRESHOLD;
        if (cst instanceof CompoundInitializer) {
            patternList.add("isDefined(P" + thr + "." +  currentCompound + dList + ")");
            visitCompoundInitializer((CompoundInitializer) cst);
        } else {
            cst.accept(this);
            String addTodList = "dList.add(" + "\"" + currentCompound + dList + "\"" + ");";
            String modifying = "modify(P" + thr + ") {" + "P" + thr + "." + currentCompound + dList 
                    + " = " + compoundInitValue + " }; \n"; 
            compoundInitSlotChanges.add(addTodList + "\n");
            compoundInitRuleParts.add(modifying);
            this.dList = "";
            compoundInitValue = "";
        }
    }

    @Override
    public void visitComment(Comment comment) {
        comment.getExpr().accept(this);
    }
    
    @Override
    public void visitOclFeatureCall(OCLFeatureCall call) {
        if (ruleItr == 0) {
            defaultStatus = call.getOperation().equals("=");
            call.getOperand().accept(this);
            rule += " ";
            if (call.getOperand() instanceof Variable && (call.getParameter(0) instanceof ConstantValue)) {
                ConstantValue val = (ConstantValue) call.getParameter(0);
                if (!(val.getConstantValue() instanceof CompoundValue)) {
                    rule += "=";
                }
            } else {
                rule += "=";
            }
            ruleItr++;
            rule += "  ";
            boolean rhsIsConstantValue = call.getParameterCount() == 1 
                    && call.getParameter(0) instanceof ConstantValue;
            if (rhsIsConstantValue && call.getOperation().equals("=")) {
                isGroup0 = true;
            } else if (rhsIsConstantValue && call.getOperation().equals("==")) {
                isGroup0 = false;
            }
            for (int i = 0; i < call.getParameterCount(); i++) {
                call.getParameter(i).accept(this);
            }
        } else {
            doModification(call);
        }
        
    }
    
    /**
     * Private method to process while traversing the sytax tree.
     * @param call Ocl FeatureCall.
     */
    private void doModification(OCLFeatureCall call) {
        // Check this in future.
        // To mitigate the problem with equalities involving reals, ocl calls are rewritten 
        // as not(unequals - expression) 
        String op = call.getOperation();
        currentOperation = op;
        OCLFeatureCall callA = call;
        if (ruleItr != 0 && (op.equals(OclKeyWords.EQUALS)) ) {
            OCLFeatureCall call1 = new OCLFeatureCall(call.getOperand(), 
                    OclKeyWords.UNEQUALS, call.getParameter(0));
            callA = new OCLFeatureCall(call1, OclKeyWords.NOT);
        }
        op = callA.getOperation();
        if (DroolsOperations.isImplicitOperation(op)) {
            doJavaSyntax(callA, op);
        } else {
            if (!DroolsOperations.isOperationSupported(op)) {
                ruleNotSupported = true;
            }
            doLispSyntax(callA, op);
        }
    }
    
    /**
     * Expression with operation not intrinsically supported by Drools is processed
     * in Lisp style. 
     * @param call OCL FeatureCall.
     * @param op Operation.
     */
    private void doLispSyntax(OCLFeatureCall call, String op) {

        rule += DroolsOperations.getDroolsOperation(op) + "(";
        compoundInitValue += DroolsOperations.getDroolsOperation(op) + "("; 
        call.getOperand().accept(this);
        boolean hasParams = (call.getParameterCount() != 0);
        if (hasParams) {
            rule += " , ";
            compoundInitValue += " , ";
        }
        for (int i = 0; i < call.getParameterCount(); i++) {
            call.getParameter(i).accept(this);
            if (i != (call.getParameterCount() - 1)) {
                rule += " , ";
                compoundInitValue += " , ";
            } else {
                rule += " ";
                compoundInitValue += " ";
            }
        }
        if (currentOperation.equals(OclKeyWords.IS_DEFINED)) {
            rule += "\"";
        }
        rule += " )";
        compoundInitValue += " )";
        
    }

    /**
     *Expression with operation intrinsically supported by Drools is processed
     * in Java style.  
     * @param call OCL FeatureCall.
     * @param op Operation.
     */
    private void doJavaSyntax(OCLFeatureCall call, String op) {
        String operation = DroolsOperations.getDroolsOperation(op);
        call.getOperand().accept(this);
        rule += " ";
        compoundInitValue += " ";
        if (operation.equals(OclKeyWords.EQUALS)) {
            rule += "==";
            rule += " ";
            compoundInitValue += "== ";
        } else {
            rule += " ";
            rule += operation;
            rule += " ";
            compoundInitValue += " " + operation + " ";
        }
        
        for (int i = 0; i < call.getParameterCount(); i++) {
            call.getParameter(i).accept(this);
            if (i != (call.getParameterCount() - 1)) {
                rule += " ";
                compoundInitValue += " ";
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
        ContainerClass cc = new ContainerClass();
        
//        ruleNotSupported = true;
        String op = call.getOperation();
        
        rule += DroolsOperations.getDroolsOperation(op); 
        rule += "( ";
        call.getContainer().accept(cc);
        call.getExpression().accept(cc);
        rule += cc.container + " , " + cc.contVar + " )"; 
        if (!DroolsOperations.isOperationSupported(op)) {
            ruleNotSupported = true;
        }
        containerHead += "\n" + cc.contVar + cc.cHead + cc.innerlogic + " from " + cc.logic + ")\n";
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
//        private String containerDecl = "";
        private String container = "";
        private String slot = "";
        private String containerType = "";
        
//        $l : java.util.ArrayList() from collect ( Number(this > 4) from p1.seq1)
        
        @Override
        public void visitConstantValue(ConstantValue value) {
            if (value.getConstantValue() instanceof MetaTypeValue) {
                this.visitMetaTypeValue((MetaTypeValue) value.getConstantValue());
            } else if (value.getConstantValue() instanceof StringValue) {
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
                    logic = parent + thr + "." + variable.getVariable().getName() + "." + slot;
                    contVar = "$" + variable.getVariable().getName() + "_" + slot;
                } else {
                    int thr = getDroolsClassNr(variable.getVariable().getName());
                    container = parent + thr + "." + variable.getVariable().getName();
                    logic = parent + thr + "." + variable.getVariable().getName();
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
         * Method to be used for visiting the container operation calls involving quantifiers applying
         * to all instances of a compound. 
         * @param value Value to be visited.
         */
        public void visitMetaTypeValue(MetaTypeValue value) {
            String parent = value.getContainedType().toString();
//            String isDef = "isDefined($$" +  parent + "." + slot + ")";
//            containerDecl += "$$" + parent + ": " + parent + "(" + isDef + ")";
            container = "$$" + parent + "." + slot;
            logic = "$$" + parent + "." + slot;
            contVar = "$" + parent + "_" + slot;
            
            if (Set.TYPE.isAssignableFrom(value.getContainedType())) {
                cHead += "java.util.Set() from collect (";
            } else {
                cHead += "java.util.ArrayList() from collect (";
            }
            cHead += getDroolsType(value.getContainedType());
            
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
            parenthesis.accept(this);
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
        public void visitComment(Comment comment) {
            comment.accept(this);
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
                innerlogic += op;
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
        currentSlot = "." + slot;
        access.getCompoundExpression().accept(this);
        isDefinedString += "." + slot;
        if (access.getResolvedSlot().getType() instanceof Compound) {
            if (DroolsVisitor.getDroolsClasseMap().get(currentCompound) != null) {
                int clNr = DroolsVisitor.getDroolsClasseMap().get(currentCompound) / DroolsVisitor.THRESHOLD;
                patternList.add("isDefined(" + "P" + clNr + "." 
                        + currentCompound + isDefinedString + ")");
            } else {
                patternList.add("isDefined(" + currentCompound + isDefinedString + ")");
                ruleNotSupported = true;
            }
        } else {
            if (ruleItr != 0) {
                patternList.add("dList.contains(" + "\"" + currentCompound 
                        + isDefinedString  + "\") ");
            }
        }
        if (ruleItr == 0) {
            if (visitmeta) {
                rule = modclass + isDefinedString;
                
            } else {
                int classNr = getDroolsClassNr(currentCompound);
                factUpdate.add("P" + classNr + "." + currentCompound);
                rule += currentCompound;
                rule += "." + slot;
                slotChange += "." + slot;
            }
        } else {
            rule += "." + slot;
        }
    }

    @Override
    public void visitUnresolvedExpression(UnresolvedExpression expression) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visitEnumValue(EnumValue value) {
        rule += value.getValue().getOrdinal();
    }

    @Override
    public void visitStringValue(StringValue value) {
        String val = value.getValue();
        val = DroolsVisitor.processStringEscapeSequences(val);
        
        rule += "\"" + val + "\"";
        compoundInitValue += "\"" + val + "\""; 
    }

    @Override
    public void visitCompoundValue(CompoundValue cValue) {
        CompoundValueClass compoundValue = new CompoundValueClass();
        String value = "";
        
//        String compoundName = cValue.getType().getName();
        
        Compound temp = (Compound) cValue.getType();
        for (int i = 0; i < temp.getDeclarationCount(); i++) {
            String name = temp.getDeclaration(i).getName();
            if (cValue.getNestedValue(name) != null) {
                value += dListAdder + "." + name + " = ";
                compounddListAdder.add(dListAdder + "." + name);
                cValue.getNestedValue(name).accept(compoundValue);
                value += compoundValue.nestedVal;
                value += " , ";
                compoundValue.nestedVal = "";
                int classnr = getDroolsClassNr(dListAdder);
                factUpdate.add("P" + classnr + "." + dListAdder);
            }
        }
        rule += "";
//        ruleNotSupported = true;
        if (!value.equals("")) {
            rule += value;
        } 
    }
    
    /**
     * Private class for visiting compound values, when the comound value is not fully configured.
     * @author saripalli
     *
     */
    class CompoundValueClass implements IValueVisitor {
        
        private String nestedVal = "";


        @Override
        public void visitConstraintValue(ConstraintValue value) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void visitEnumValue(EnumValue value) {
            nestedVal = String.valueOf(value.getValue().getOrdinal());
        }

        @Override
        public void visitStringValue(StringValue value) {
            String val = value.getValue();
            val = DroolsVisitor.processStringEscapeSequences(val);
            
            nestedVal += "\"" + val + "\"";
        }

        @Override
        public void visitCompoundValue(CompoundValue value) {
            ruleNotSupported = true;
            
        }

        @Override
        public void visitContainerValue(ContainerValue value) {
            ruleNotSupported = true;
            
        }

        @Override
        public void visitIntValue(IntValue value) {
            nestedVal = value.getValue().toString();
            
        }

        @Override
        public void visitRealValue(RealValue value) {
            nestedVal = value.getValue().toString();
            
        }

        @Override
        public void visitBooleanValue(BooleanValue value) {
            nestedVal = value.getValue().toString();
            
        }

        @Override
        public void visitReferenceValue(ReferenceValue referenceValue) {
            // TODO Auto-generated method stub
            ruleNotSupported = true;
            
        }

        @Override
        public void visitMetaTypeValue(MetaTypeValue value) {
            // TODO Auto-generated method stub
            ruleNotSupported = true;
            
        }
    
        @Override
        public void visitNullValue(NullValue value) {
            // TODO Auto-generated method stub
        }

        @Override
        public void visitVersionValue(VersionValue value) {
            // TODO Auto-generated method stub
        }

    }

    @Override
    public void visitContainerValue(ContainerValue cValue) {
        boolean setValue = Set.TYPE.isAssignableFrom(cValue.getType());
        if (cValue.getElementSize() != 0) {
            contValues.add("Group 0_" + ruleCount);
            if (!setValue) {
                rule += " new java.util.ArrayList(java.util.Arrays.asList(";
            } else {
                rule += " new java.util.HashSet(java.util.Arrays.asList(";
            }
            int drooslClassnr = getDroolsClassNr(dListAdder);
            for (int i = 0; i < cValue.getElementSize(); i++) {
                if (cValue.getElement(i) instanceof CompoundValue 
                        ) {
//                    ruleNotSupported = true;
                    CompoundValue cv = (CompoundValue) cValue.getElement(i);
                    Compound temp = (Compound) cv.getType();
                    String compName = cv.getType().getName();
                    rule += "new " + compName + "()";
                    for (int j = 0; j < temp.getDeclarationCount(); j++) {
                        CompoundValueClass compoundValue = new CompoundValueClass();
                        String name = temp.getDeclaration(j).getName();
                        if (cv.getNestedValue(name) != null) {
                            cv.getNestedValue(name).accept(compoundValue);
                            String tempValue = compoundValue.nestedVal;
                            String modifyIndividual = " , "
                                    + "at(" + dListAdder + " , " + i + ")" + "." 
                                    + temp.getDeclaration(j).getName() + " = " + tempValue + "\n";
                            partialContVal += modifyIndividual; 
                            compounddListAdder.add(compName + "." + name);
                        }
                        
                    }
                } else {
                    cValue.getElement(i).accept(this);
                    rule += ")";
                }
                if (cValue.getElement(i) instanceof CompoundValue) {
                    if (!setValue) {
                        factInsertion += "insert(" + modclass + "." + dListAdder 
                                + ".get(" + i + ")" + ");\n";
                    } else {
                        factInsertion += "insert(" + "at(" + "P" + drooslClassnr 
                                + "." + dListAdder + " , " + i + ")" + ");\n";
                    }
                }
                if (i != cValue.getElementSize() - 1) {
                    rule += " , ";
                }
            }
            rule += "))"; 
            rule += "\n";
            rule += partialContVal + "\n";
            partialContVal = "";
        }
    }

    @Override
    public void visitIntValue(IntValue value) {
        rule += value.getValue();
        compoundInitValue += value.getValue(); 
    }

    @Override
    public void visitRealValue(RealValue value) {
        rule += value.getValue();
        compoundInitValue += value.getValue(); 
    }

    @Override
    public void visitBooleanValue(BooleanValue value) {
        rule += value.getValue();
        compoundInitValue += value.getValue(); 
    }

    @Override
    public void visitReferenceValue(ReferenceValue referenceValue) {
        if (ruleItr == 0) {
            String adder = referenceValue.getValue().getName();  // may be null -> getValueEx
            if (!currentSlot.equals("")) {
                adder += currentSlot;
            }
            dListAdder += adder;
            rule += referenceValue.getValue().getName();
            
        } else {
            int droolsClNr = getDroolsClassNr(referenceValue.getValue().getName()); 
            rule += "P" + droolsClNr +  "." + referenceValue.getValue().getName();
        }
    }
    
    

    @Override
    public void visitMetaTypeValue(MetaTypeValue value) {
        String parent = value.getContainedType().toString();
        currentCompound = "$" + parent;
        if (!compoundPlaceHolders.contains(parent)) {
            compoundPlaceHolders.add(parent);
            compoundHeads += "\n" + "$" + value.getContainedType() + ": " + value.getContainedType() + "()"; 
        }
        if (ruleItr == 0) {
            this.visitmeta = true;
            modclass = "$" + parent;
            dListAdder = parent + currentSlot;
            List<String> li = DroolsVisitor.getCompoundMap().get(parent);
            for (String str : li) {
                compounddListAdder.add(str + currentSlot);
            }
        } else {
            String ptrn1 = "dList.contains(" + "\"" + parent + currentSlot + "\") ";
            String ptrn2 = "dList.contains(" + "\"" + parent + "\") ";
            String pattern = "(" + ptrn1 + " || " + ptrn2 + ")";
            patternList.add(pattern);
            rule += "$" + parent; 
            
        }
    }

    @Override
    public void visitConstraintValue(ConstraintValue value) {
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
