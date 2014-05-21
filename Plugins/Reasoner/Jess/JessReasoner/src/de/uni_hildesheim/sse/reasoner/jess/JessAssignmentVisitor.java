package de.uni_hildesheim.sse.reasoner.jess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import de.uni_hildesheim.sse.model.varModel.OperationDefinition;
import de.uni_hildesheim.sse.model.varModel.PartialEvaluationBlock;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.ProjectImport;
import de.uni_hildesheim.sse.model.varModel.ProjectInterface;
import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
import de.uni_hildesheim.sse.model.varModel.datatypes.DerivedDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.Enum;
import de.uni_hildesheim.sse.model.varModel.datatypes.EnumLiteral;
import de.uni_hildesheim.sse.model.varModel.datatypes.OclKeyWords;
import de.uni_hildesheim.sse.model.varModel.datatypes.OrderedEnum;
import de.uni_hildesheim.sse.model.varModel.datatypes.Reference;
import de.uni_hildesheim.sse.model.varModel.datatypes.Sequence;
import de.uni_hildesheim.sse.model.varModel.datatypes.Set;
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
 * A visitor class to process all the value assignments.
 * 
 */
public class JessAssignmentVisitor implements IModelVisitor, 
    IConstraintTreeVisitor, IValueVisitor {
    
    private Project project;
    private Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>(); 
    private Map<String, String> compoundMap = new HashMap<String, String>();
    private Map<String, String> idMap = new HashMap<String, String>();
    private String currentCompound = "";
    private List<String> patternHead = new ArrayList<String>();
    private int ruleCount = 1;
    private String declOne = "";
    
    private String modificationTracker = "";
    
    /**
     * Total number of temporary declarations used in certain quantor functions. 
     */
    private int totalTempDeclCount = 0;
    
    private String containerBeingVisited = "";
    private boolean contBeingModified = false;
    
    /**
     * The main part of the rule.
     */
    private StringBuffer ruleBuffer = new StringBuffer("");
    
    /**
     * Each variable is checked if it is defined. This list contains such parts of 
     * each variable used in the constraint/rule.
     */
    private List<String> nilEqPlaceholder = new ArrayList<String>();
    
    /**
     * Final rule.
     */
    private String finalRule = "";
    
    private int ruleItr = 0;
    private String modifiedCompName = ""; 
    private boolean modifyingComp = false;
    private int compoundCount = 0;
    
    /**
     * Project rule header.
     */
    private String pRuleHeader = "?id <- (Proj ";
    
    private boolean compoundAccess = false;
    
    /**
     * When a part of the rule is not supported by the reasoner, this is flagged to <b>False</b>
     */
    private boolean ruleSupported = true;
    private List<Integer> nonSupportedRules = new ArrayList<Integer>();
    /**
     * Current operation.
     */
    private String currentOp = "";
    private int operandTyp = 0;
    
    private String noLoop = "(declare (no-loop TRUE))";
    String freezeCheck = "";
    

    /**
     * Method to get the list of rule numbersfor rules that are not supported.
     * @return nonSupportedRules List of rule numbers not supported.
     */
    public List<Integer> getNonSupportedRules() {
        return nonSupportedRules;
    }

    /**
     * Method to set the rule number.
     * @param nr The Rule number.
     */
    public void setRuleCount(int nr) {
        this.ruleCount = nr;
    }
    
    /**
     * Getter for the string representing the rule. 
     * @return finalRule Rule.
     */
    public String getFinalRule() {
        return finalRule;
    }
    
    @Override
    public void visitOclFeatureCall(OCLFeatureCall call) {
        this.currentOp = call.getOperation();
        if (this.ruleItr == 0) {
            ruleBuffer.append("=> \n" + "(");
            
            call.getOperand().accept(this);
            
            ruleItr++;
            for (int i = 0; i < call.getParameterCount(); i++) {
                call.getParameter(i).accept(this);   
            }
            
        } else {
            ruleBuffer.append("(");
            ruleBuffer.append(JessCommons.getJessOperator(call.getOperation()) + " ");
            call.getOperand().accept(this);
            for (int i = 0; i < call.getParameterCount(); i++) {
                call.getParameter(i).accept(this);   
            }
            ruleBuffer.append(")");
            
        }

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
    public void visitVariable(Variable variable) {
        if (Reference.TYPE.isAssignableFrom(variable.getVariable().getType())) {
            this.ruleSupported = false;
        }
        String varName = variable.getVariable().getName(); 
        boolean parentIsProject = variable.getVariable().getParent().getClass().equals(this.project.getClass());
        if (variable.getVariable().getType().getTypeClass().isAssignableFrom(Sequence.class)
                || variable.getVariable().getType().getTypeClass().isAssignableFrom(Set.class)) {
            this.contBeingModified = true;
        } else {
            this.contBeingModified = false;
        }
        getOperandTyp(variable);
        if (parentIsProject && !this.compoundAccess) {
            processNonNestedElementRule(variable, varName); 
        } else if (variable.getVariable().isTemporaryVariable()) {
            if (this.declOne.equals("")) {
                ruleBuffer.append("?" + varName);
            } else {
                ruleBuffer.append("?*CD_" + (this.totalTempDeclCount - 1) + "_" + varName + "*");
            }
            System.out.print("");
        } else if (this.compoundAccess) {
            currentCompound = varName;
            String jessN = "$?" + varName;
            String appendeR = "(test (eq " + jessN + idMap.get(currentCompound) + "))";
            
            if (!this.pRuleHeader.contains("(" + varName + " $?" + varName + ")")) {
                this.pRuleHeader += "(" + varName + " $?" + varName + ")";
            }
            if (!this.patternHead.contains(variable.getVariable().getName())) {
                this.patternHead.add(variable.getVariable().getName());
            }
            if (!this.nilEqPlaceholder.contains(appendeR)) {
                this.nilEqPlaceholder.add(appendeR);
            }
        } else {
            String jessN = "(test (neq $?" + varName + " nil))";
            String cName = variable.getVariable().getParent().getName();
            if (!this.patternHead.contains(cName)) {
                this.patternHead.add(cName);
            }
            if (this.ruleItr == 0) {
                
                this.modifiedCompName = variable.getVariable().getParent().getName();
                String appendeR = "modify " + idMap.get(this.modifiedCompName) 
                        + " (" + varName + " ";
                ruleBuffer.append(appendeR);
                this.modifyingComp = true;
            } else {
                if (!this.nilEqPlaceholder.contains(jessN)) {
                    this.nilEqPlaceholder.add(jessN);
                }
                String appendeR = " $?" + varName + " ";
                if (isSpecificContainerOperation(currentOp)) {
                    appendeR += operandTyp + " "; 
                }
                ruleBuffer.append(appendeR);
            }
        }
        
    }
    
    /**
     * Private method to identify if the openrand is a set or a sequence.
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
     * Private method to identify if the operator is a container 
     * specific operation to change method signature in Jess.
     * @param op Operator.
     * @return Retrurns <b>True</b> if the operator is one of the following - asSequence, 
     * asSet, union or intersection.
     */
    private boolean isSpecificContainerOperation(String op) {
        boolean asSetOrSeq = op.equals(OclKeyWords.AS_SEQUENCE) || op.equals(OclKeyWords.AS_SET);
        boolean interUnion = op.equals(OclKeyWords.UNION);
        return interUnion || asSetOrSeq;
        
    }

    /**
     * Private method to process non-nested element rule.
     * @param arg0 variable.
     * @param varName Variable name.
     */
    private void processNonNestedElementRule(Variable arg0, String varName) {
        String jessN = "(test (neq $?" + varName + " nil))";
        if (!this.pRuleHeader.contains("(" + varName + " $?" + varName + ")")) {
            this.pRuleHeader += "(" + varName + " $?" + varName + ")";
        }
        boolean currentOpEmpty = this.currentOp.equals(OclKeyWords.IS_EMPTY) 
                || this.currentOp.equals(OclKeyWords.NOT_EMPTY);
        if (this.contBeingModified && !currentOpEmpty) {
            jessN = "(test (neq (length$ $?" + varName + ") 0))";
        }
        
        if (this.ruleItr == 0) {
            String temp = "printout t (" + "ListAdd" + " ?*FixedList* " + "\"" + varName + "\"" + ")" + "\n";
            freezeCheck = "(test (not (ListContains ?*FixedList* " + "\"" + varName + "\"" + ")))" + "\n";
            String appendeR = "modify ?id (" + varName + " ";
            ruleBuffer.append(temp + ") \n (");
            ruleBuffer.append(appendeR);
//            modificationTracker += temp;
            
        } else {
            this.containerBeingVisited = "$?" + varName;
            String appendeR = " $?" + varName + " ";
            if (isSpecificContainerOperation(currentOp)) {
                appendeR += operandTyp + " ";
            }
            ruleBuffer.append(appendeR);
            if (!this.nilEqPlaceholder.contains(jessN)) {
                this.nilEqPlaceholder.add(jessN);
            }
        }
    }
    
    /**
     * Method to define the rule header. Jess rules consist of header (a description of what 
     * facts to look into) and the part consists of the actual rule.. 
     * @param call OCL call.
     */
    public void visitAfterOclFeatureCall(OCLFeatureCall call) {
        

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

        finalRuleDerivation(hold); 
        
        hold = "";
        map.clear();
    }
    
    /**
     * A private method called from VisitiOclFeatureCall(OCLFeatureCall args0) method 
     * to derive the final rule. 
     * @param ruleContent The main part of the rule, leaving out all the syntactical
     * elements like NEWLINE, BRACKETS etc.
     * aids in keeping track of the number of times rules were contradicted.   
     */
    private void finalRuleDerivation(String ruleContent) {
        String neqPlaceholder = "";
        neqPlaceholder += this.pRuleHeader + ")";
        for (int i = 0; i < this.nilEqPlaceholder.size(); i++) {
            neqPlaceholder += this.nilEqPlaceholder.get(i);
        }
        boolean ruleToBeAdded = this.ruleSupported && (ruleCount != 0);
        
        if (ruleToBeAdded) {
            finalRule = this.declOne + "\n";
            String key = "mod1_RULE_ASSIGNMENT_" + ruleCount;
            finalRule += JessCommons.DEFRULE + "mod1" + "::RULE_ASSIGNMENT_"
                    + ruleCount  
                    + "\n" + noLoop + "\n" 
                    + JessCommons.NEWLINE  + ruleContent 
                    + JessCommons.NEWLINE + neqPlaceholder + JessCommons.NEWLINE + freezeCheck
                    + this.ruleBuffer + JessCommons.BRACKETCLOSE 
                    + JessCommons.NEWLINE + JessCommons.BRACKETCLOSE + JessCommons.NEWLINE;
            finalRule += modificationTracker;
            if (this.modifyingComp) {
                finalRule += ")\n)";
            } else {
                finalRule += ")";
            }
//            JessVisitor.getAssignmentModules().add(key);
        } else {
            
            finalRule = "";
            System.out.println("Rule not supported # " + ruleCount);
            this.nonSupportedRules.add(ruleCount);
        }
        neqPlaceholder = "";
        this.nilEqPlaceholder.removeAll(nilEqPlaceholder);
        modificationTracker = "";
    }
    
    /**
     * sets the defaults after visiting the rule.
     */
    public void visitRuleAfter() { 
        this.ruleItr = 0;
        map.clear(); 
        this.ruleBuffer.setLength(0);
        this.ruleBuffer.append("");
        this.pRuleHeader = "?id <- (Proj ";
        this.modifyingComp = false;
        this.patternHead.removeAll(patternHead);
        this.ruleSupported = true;
        
    }

    
    @Override
    public void visitConstantValue(ConstantValue value) {
        value.getConstantValue().accept(this);        
    }
    
    @Override
    public void visitBooleanValue(BooleanValue value) {
        ruleBuffer.append(" " + value.getValue().toString().toUpperCase() + " ");
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
        ruleBuffer.append("(instance "  + JessVisitor.getInstance() + ")");
        JessVisitor.incrementInstance();
        
        ruleBuffer.append("))\n");
        
    }

    @Override
    public void visitContainerValue(ContainerValue arg0) {

        String temp = "(create$ ";
        ruleBuffer.append(temp);
        for (int i = 0; i < arg0.getElementSize(); i++) {
            arg0.getElement(i).accept(this);
            ruleBuffer.append(" ");
        }
        ruleBuffer.append(") ");
        
    }

    @Override
    public void visitEnumValue(EnumValue value) {
        ruleBuffer.append(" " + "?*" + value.getType().getName() + "_" + value.getValue().getName() + "* ");
        
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
    public void visitReferenceValue(ReferenceValue arg0) {

        this.ruleSupported = false;
    }

    @Override
    public void visitStringValue(StringValue value) {
        ruleBuffer.append(" " + "\"" + value.getValue() + "\" ");
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
    public void visitCompound(Compound arg0) {

        for (int i = 0; i < arg0.getElementCount(); i++) {
            String nestElem = arg0.getElement(i).getName();
            String ruleVar = "(" + nestElem + " $?" + nestElem + ")";
            if (!map.containsKey(arg0.getName())) {
                map.put(arg0.getName(), new ArrayList<String>());
            } 
            map.get(arg0.getName()).add(ruleVar); 
        }
        
    }

    @Override
    public void visitDerivedDatatype(DerivedDatatype arg0) {
        // TODO Auto-generated method stub
        
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
    public void visitSequence(Sequence arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitSet(Set arg0) {
        // TODO Auto-generated method stub
        
    }

   

    @Override
    public void visitCompoundAccess(CompoundAccess arg0) {
        this.compoundAccess = true;
        arg0.getCompoundExpression().accept(this);
        if (this.ruleItr == 0) { 
            
            ruleBuffer.append("modify " + idMap.get(currentCompound) 
                    + " (" + arg0.getSlotName() + " "); 
            try {
                if (arg0.inferDatatype().getTypeClass().isAssignableFrom(Sequence.class)
                        || arg0.inferDatatype().getType().getTypeClass().isAssignableFrom(Set.class)) {
                    this.contBeingModified = true;
                }
            } catch (CSTSemanticException e) {
                e.printStackTrace();
            } 
        } else {
            ruleBuffer.append(" $?" + arg0.getSlotName() + currentCompound + " ");
            this.containerBeingVisited = "$?" + arg0.getSlotName();
            this.nilEqPlaceholder.add("(test (neq " + "$?" + arg0.getSlotName() + currentCompound + " nil))");
        }
        this.compoundAccess = false;
        
    }


    @Override
    public void visitContainerOperationCall(ContainerOperationCall call) {
        this.currentOp = call.getOperation();
        this.ruleItr++;
        if (this.contBeingModified) {
            ruleBuffer.append(" (list ");
            this.contBeingModified = false;
        }
        boolean selectOp = call.getOperation().equals(OclKeyWords.SELECT); 
        boolean rejectOp = call.getOperation().equals(OclKeyWords.REJECT);
        boolean anyOp = call.getOperation().equals(OclKeyWords.ANY);
        boolean oneOp = call.getOperation().equals(OclKeyWords.ONE);
        boolean allOp = call.getOperation().equals(OclKeyWords.FOR_ALL);
        boolean collectOp = call.getOperation().equals(OclKeyWords.COLLECT);
        
        ruleBuffer.append("( ");
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
        
        if (call.getOperation().equals(OclKeyWords.APPLY)) {
            
            System.out.print("");
        } else {
            
            declOne = "(defglobal ";
            
            String lambdaFunc = "(map(lambda";
            ruleBuffer.append(lambdaFunc);
            ruleBuffer.append("(");
            for (int i = 0; i < call.getDeclaratorsCount(); i++) {
                declOne += "?*CD_" + this.totalTempDeclCount + "_" + call.getDeclarator(i).getName() + "* = nil";
                ruleBuffer.append("?*CD_" + this.totalTempDeclCount + "_" + call.getDeclarator(i).getName() + "* ");
                this.totalTempDeclCount++;
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
            ruleBuffer.append(" ) " + this.containerBeingVisited + ")");
        } else {
            System.out.print("");
        }
        ruleBuffer.append(") ");
        
    }

    @Override
    public void visitIfThen(IfThen arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitLet(Let arg0) {
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
    public void visitDslFragment(DslFragment fragment) {
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

