package de.uni_hildesheim.sse.reasoning.drools;

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
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.BooleanType;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.IntegerType;
import net.ssehub.easy.varModel.model.datatypes.OclKeyWords;
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
 * Class for visiting constraints in attribute assignment blocks.
 * @author Phani
 */
public class AssignmentAttributeConstraints implements IConstraintTreeVisitor, IValueVisitor {
    
    private EASyLogger logger = EASyLoggerFactory.INSTANCE.getLogger(this.getClass(),
            "de.uni_hildesheim.sse.reasoning.drools");
    
    private static int ruleCounter = 0;
    

    private final String ruleAttributes = "agenda-group " + "\"" + "Group 2" + "\"" + "\n"
            + "dialect " + "\"mvel" + "\""
            + "\nno-loop true" + "\n";
    private String constraint = "";
    private String rule = "";
    private List<String> compoundPlaceHolders = new ArrayList<String>();
    private String compoundHeads = "";
    private int ruleItr = 0;
    private boolean doNotAddRule = false;
    private String containerHead = "";
    private List<String> projectPatterns = new ArrayList<String>();
    private String compoundExpr = "";
    private String isDefinedString = "";
    private String dListContainsString = "eval( ";
    private String curComp = "";
    private List<String> pattern = new ArrayList<String>();
    
    /**
     * Flag if to add the constraint/rule to the drl file. 
     */
    private boolean addC = false;
    
    
    /**
     * Getter for rulecounter.
     * @return rulecounter.
     */
    public static int getRuleCounter() {
        return ruleCounter;
    }

    /**
     * Setter for rulecounter.
     * @param ruleCounter rulecounter.
     */
    public static void setRuleCounter(int ruleCounter) {
        AssignmentAttributeConstraints.ruleCounter = ruleCounter;
    }
    
    /**
     * Setter for the flag addC.
     * @param flag True or false.
     */
    public void setAddC(boolean flag) {
        addC = flag;
    }
    
    /**
     * Method to add drools project patterns to the rule.
     * @param var Variable name for which the project pattern is being written.
     */
    private void writeDroolsClasses(String var) {
        int classNr = DroolsVisitor.getDroolsClasseMap().get(var) / DroolsVisitor.THRESHOLD;
        String project = "\nP" + (classNr) + " : " 
                + "Project" + classNr + "()\n";
        if (!projectPatterns.contains(project)) {
            projectPatterns.add(project);
        }
        
    }
    
    @Override
    public void visitConstantValue(ConstantValue value) {
        value.getConstantValue().accept(this);
    }

    @Override
    public void visitVariable(Variable variable) {
        String var = variable.getVariable().getName();
        boolean parentIsProject = variable.getVariable().getParent().getClass().equals(Project.class);
        if ((variable.getVariable().getType().getTypeClass().equals(Compound.class))) {
            if (parentIsProject) {
                int thr = DroolsVisitor.getDroolsClasseMap().get(var) / DroolsVisitor.THRESHOLD; 
                compoundExpr += "P" + thr + "." + var;
                isDefinedString += "isDefined(P" + thr + "." + var + ") && ";
//                constraint += variable.getVariable().getName();
            } 
        } 
        if (variable.getVariable().getType().getTypeClass().equals(Sequence.TYPE)) {
            doNotAddRule = true;
        } 
        if (parentIsProject) {
            writeConstraintForProjectVariable(var);
        } else if (variable.getVariable().getParent().getClass().equals(Compound.class)) {
            String dListContains = "";
//            String compoundName = variable.getVariable().getParent().getName();
//            List<String> lisOfCompounds = DroolsVisitor.getCompoundMap().get(compoundName);
//            for (int i = 0; i < lisOfCompounds.size(); i++) {
//                dListContains += "dList.contains(" + "\"" + lisOfCompounds.get(i) + "." + var + "\"" + ")" + " && ";
//            }
//            logger.info("dList contains is " + dListContains);
            compoundExpr += " $" + variable.getVariable().getParent().getName();
            constraint += " $" + variable.getVariable().getParent().getName() + "." + var;
            if (!compoundPlaceHolders.contains(variable.getVariable().getParent().getName())) {
                compoundPlaceHolders.add(variable.getVariable().getParent().getName());
                compoundHeads += "\n" + "$" + variable.getVariable().getParent().getName() + ": " 
                        + variable.getVariable().getParent().getName() + "()\n"; 
            }
            dListContainsString += dListContains;
        } else {
//            logger.info("var with unknown parent is " + var);
            if (null != DroolsVisitor.getDroolsClasseMap().get(var)) {
                writeConstraintForProjectVariable(var);
            } else {
                doNotAddRule = true;
            }
        }
        
    }

    /**
     * Method to write the constraint/condition for a variable whose parent is the project.
     * @param var Variable name.
     */
    private void writeConstraintForProjectVariable(String var) {
        int classNr = DroolsVisitor.getDroolsClasseMap().get(var) / DroolsVisitor.THRESHOLD;
        writeDroolsClasses(var);
        constraint += "P" + classNr + "." + var;
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
    public void visitComment(Comment comment) {
        // TODO Auto-generated method stub
        
    }
    
    /**
     * Method that returns the rule counter/number of the constraint being visited in the attribute
     * assignment block. 
     * @return Rule counter/number.
     */
    public static String getAttributeRuleCounter() {
        return "a" + ruleCounter;
    }
    
    /**
     * Method to derive the final rule.
     * @return The rule.
     */
    public String getRule() {
        rule += "rule " + "\"a" + ruleCounter + "\"" + "\n";
        rule += ruleAttributes + "when\n\t"; 
        for (int i = 0; i < projectPatterns.size(); i++) {
            rule += projectPatterns.get(i);
        }
        for (String str : pattern) {
            dListContainsString += str + " && ";
        }
        rule += containerHead + compoundHeads
                + "P : Project(" +  dListContainsString + "!(" + isDefinedString + constraint 
                + "))\n)\n";
        rule += "then\n\t";
        rule += "System.out.println( " + "\"Rule not satisfied : " + "a" + ruleCounter + "\");\n";
        rule += "aList.add(" + "\"" 
                + "a" + ruleCounter 
                + "\"" + ");\nend";
        if (doNotAddRule) {
            rule = "";
        }
//        logger.info("Rule -> " + rule);

        ruleCounter++;
        ruleItr = 0;
        return rule;
    }

    @Override
    public void visitOclFeatureCall(OCLFeatureCall call) {
        boolean isImplicitOperation = DroolsOperations.isImplicitOperation(call.getOperation());
        if (ruleItr == 0) {
            if ((call.getOperand() instanceof Variable) && !addC) {
//                doNotAddRule = true;
                ruleItr++;
            }   
        }
        if (call.getOperation().equals(OclKeyWords.IS_DEFINED)) {
            doNotAddRule = true;
            
        }
        if (isImplicitOperation) {
            call.getOperand().accept(this);
            String op = DroolsOperations.getDroolsOperation(call.getOperation());
            if (op.equals("=")) {
                op = "==";
            } 
            constraint += " " + op + " ";
            for (int i = 0; i < call.getParameterCount(); i++) {
                call.getParameter(i).accept(this);
            }
        } else {
            String op = DroolsOperations.getDroolsOperation(call.getOperation());
            if (op.equals("=")) {
                op = "==";
            }
            constraint += op;
            constraint += " (";
            call.getOperand().accept(this);
            boolean hasParams = (call.getParameterCount() != 0);
            if (hasParams) {
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
            constraint += ")";
        }
    }

    @Override
    public void visitLet(Let let) {
        doNotAddRule = true;
    }

    @Override
    public void visitIfThen(IfThen ifThen) {
        doNotAddRule = true;
    }

    @Override
    public void visitContainerOperationCall(ContainerOperationCall call) {
        String op = call.getOperation();
        ContainerClass cc = new ContainerClass();
        call.getContainer().accept(cc);
        call.getExpression().accept(cc);
        if (!DroolsOperations.isOperationSupported(op)) {
            doNotAddRule = true;
        }
        containerHead = cc.containerDecl + "\n" + cc.contVar + cc.cHead 
                + cc.innerlogic + " from " + cc.logic + ")" + "\n\t";
        constraint += DroolsOperations.getDroolsOperation(op) + "(" 
                + cc.container + " , " + cc.contVar + ")";
//        logger.info("container op -> " + op);
//        this.doNotAddRule = true;
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
        private String containerDecl = "";
        private String container = "";
        private String containerType = "";
        private String slot = "";
        
//        $l : java.util.ArrayList() from collect ( Number(this > 4) from p1.seq1)
        
        @Override
        public void visitConstantValue(ConstantValue value) {
            innerlogic += " " + value.getConstantValue().getValue() + " ";
        }

        @Override
        public void visitVariable(Variable variable) {
            if (variable.getVariable().isTemporaryVariable()) {
                innerlogic += "this ";
            } else {
                String parent = "P";
                if (!variable.getVariable().getParent().getClass().equals(Project.class)) {
                    parent = variable.getVariable().getParent().getName();
                    containerDecl = "$$" + parent + " : " + parent + "()";
                } else {
                    String isDef = "isDefined($$" +  parent + "." + variable.getVariable().getName() + ")";
                    containerDecl = "$$" + "P" + " : " + "Project" + "(" + isDef + ")";
                } 
                
                if (variable.getVariable().getType().getTypeClass().equals(Compound.class)) {
                    container = parent + "." + variable.getVariable().getName() + "." + slot;
                    logic = "$$" + parent + "." + variable.getVariable().getName() + "." + slot;
                    contVar = "$" + variable.getVariable().getName() + "_" + slot;
                } else {
                    container = parent + "." + variable.getVariable().getName();
                    logic = "$$" + parent + "." + variable.getVariable().getName();
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
        public void visitContainerOperationCall(ContainerOperationCall call) {
            logger.info("inner call ");
            doNotAddRule = true;
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

        @Override
        public void visitSelf(Self self) {
            // TODO Auto-generated method stub
        }
        
    }
    
    
    

    @Override
    public void visitCompoundAccess(CompoundAccess access) {
        access.getCompoundExpression().accept(this);
        if (access.getResolvedSlot().getType().getTypeClass().equals(Sequence.class)) {
            doNotAddRule = true;
        }
        if (access.getResolvedSlot().getType().getTypeClass().equals(Compound.class)) {
            compoundExpr += "." + access.getSlotName();
            isDefinedString += "isDefined(" + compoundExpr + ") && "; 
        }
        constraint += "." + access.getSlotName();
        if (!curComp.equals("")) {
            pattern.add("dList.contains(" + "\"" + curComp + "." + access.getSlotName() + "\"" + ")\n");
        }
    }

    @Override
    public void visitUnresolvedExpression(UnresolvedExpression expression) {
        // TODO Auto-generated method stub
        
    }
    
    /**
     * Visit method for constraint.
     * @param constraint Constraint.
     */
    public void visitConstraint(Constraint constraint) {
        constraint.getConsSyntax().accept(this);
    }

    @Override
    public void visitConstraintValue(ConstraintValue value) {
    }

    @Override
    public void visitEnumValue(EnumValue value) {
        constraint += value.getValue().getOrdinal();
    }

    @Override
    public void visitStringValue(StringValue value) {
        constraint += "\"" + value.getValue() + "\"";
    }

    @Override
    public void visitCompoundValue(CompoundValue value) {
        doNotAddRule = true;
    }

    @Override
    public void visitContainerValue(ContainerValue value) {
        doNotAddRule = true;
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
        doNotAddRule = true;
    }

    @Override
    public void visitMetaTypeValue(MetaTypeValue value) {
        String parent = value.getContainedType().getName();
        curComp = parent;        
        compoundExpr += "$" + parent;
        constraint += "$" + value.getValue().getName();
        if (!compoundPlaceHolders.contains(parent)) {
            compoundPlaceHolders.add(parent);
            compoundHeads += "\n" + "$" + value.getContainedType() + ": " 
                    + value.getContainedType() + "()\n"; 
        }
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
    public void visitAnnotationVariable(AttributeVariable variable) {
        // TODO check whether specific method is needed
        visitVariable(variable);
    }

}
