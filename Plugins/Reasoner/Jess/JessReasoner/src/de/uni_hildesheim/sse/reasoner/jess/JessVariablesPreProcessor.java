package de.uni_hildesheim.sse.reasoner.jess;

import java.util.HashSet;

import de.uni_hildesheim.sse.model.cst.Comment;
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
import de.uni_hildesheim.sse.model.varModel.datatypes.BooleanType;
import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
import de.uni_hildesheim.sse.model.varModel.datatypes.Container;
import de.uni_hildesheim.sse.model.varModel.datatypes.DerivedDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.Enum;
import de.uni_hildesheim.sse.model.varModel.datatypes.IntegerType;
import de.uni_hildesheim.sse.model.varModel.datatypes.OrderedEnum;
import de.uni_hildesheim.sse.model.varModel.datatypes.RealType;
import de.uni_hildesheim.sse.model.varModel.datatypes.Sequence;
import de.uni_hildesheim.sse.model.varModel.datatypes.Set;
import de.uni_hildesheim.sse.model.varModel.datatypes.StringType;

/**
 * Class for preprocessing the variables. This class is dedicated for optimization of drools. 
 * The idea is to pass variables that are exactly needed for reasoning.
 * @author saripalli
 *
 */
public class JessVariablesPreProcessor implements IConstraintTreeVisitor {
    
    private static boolean advancedOptimization = JessR.getOptimizationCaseNr() == 2;
    
    private static HashSet<String> variablesUsed = new HashSet<String>();
    
    /**
     * Getter for the set containing names of the variables used in constraints.
     * @return variablesUsed - set containing variables used.
     */
    public static HashSet<String> getVariablesUsed() {
        return variablesUsed;
    }

    @Override
    public void visitConstantValue(ConstantValue value) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visitVariable(Variable variable) {
        String name = variable.getVariable().getName();
        boolean isDerivedType = variable.getVariable().getType().getTypeClass().equals(DerivedDatatype.class);
        boolean parentIsCompound = variable.getVariable().getParent().getClass().equals(Compound.class);
        
        
        if (!variable.getVariable().getType().getTypeClass().equals(Compound.class)
                && !isDerivedType && !parentIsCompound) {
            if (variable.getVariable().getType().equals(IntegerType.TYPE)) {
                variablesUsed.add(name);
            } else if (variable.getVariable().getType().equals(RealType.TYPE)) {
                variablesUsed.add(name);
            } else if (variable.getVariable().getType().equals(StringType.TYPE)) {
                if (name.equals("nameCopy")) {
                    System.out.println(isDerivedType + " _ " + parentIsCompound + " _ ");
                }
                variablesUsed.add(name);
            } else if (variable.getVariable().getType().equals(BooleanType.TYPE)) {
                variablesUsed.add(name);
            } else if (variable.getVariable().getType() instanceof Container) {
                System.out.println(name + " name ....");
                variablesUsed.add(name);
            } else if (variable.getVariable().getType().getTypeClass().equals(Enum.class)) {
                variablesUsed.add(name);
            } else if (variable.getVariable().getType().getTypeClass().equals(OrderedEnum.class)) {
                variablesUsed.add(name);
            }
            
        } 
        if (isDerivedType) {
            DerivedDatatype datatype = (DerivedDatatype) variable.getVariable().getType();
            if (IntegerType.TYPE.isAssignableFrom(datatype.getBasisType())) {
                variablesUsed.add(name);
            } else if (RealType.TYPE.isAssignableFrom(datatype.getBasisType())) {
                variablesUsed.add(name);
            } else if (BooleanType.TYPE.isAssignableFrom(datatype.getBasisType())) {
                variablesUsed.add(name);
            } else if (StringType.TYPE.isAssignableFrom(datatype.getBasisType())) {
                variablesUsed.add(name);
            } else if (Set.TYPE.isAssignableFrom(datatype.getBasisType())) {
                System.out.print("");
            } else if (Sequence.TYPE.isAssignableFrom(datatype.getBasisType())) {
                System.out.print("");
            } else if (Enum.TYPE.isAssignableFrom(datatype.getBasisType())) {
                variablesUsed.add(name);
            } else if (OrderedEnum.TYPE.isAssignableFrom(datatype.getBasisType())) {
                variablesUsed.add(name);
            } else {
                System.out.println("datatype " + datatype);
            }
        }

    }

    @Override
    public void visitParenthesis(Parenthesis parenthesis) {
        parenthesis.getExpr().accept(this);
    }

    @Override
    public void visitComment(Comment comment) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visitOclFeatureCall(OCLFeatureCall call) {
        if (!advancedOptimization || !call.getOperation().equals("=")) {
            traverseOCL(call);
        }
//        if (advancedOptimization && call.getOperation().equals("=")) {
//            if (call.getParameter(0) instanceof ConstraintSyntaxTree) {
//                traverseOCL(call);   
//            }
//        }
        
        
    }

    /**
     * Traversing the OCL tree.
     * @param call OCLFeature Call.
     */
    private void traverseOCL(OCLFeatureCall call) {
        call.getOperand().accept(this);
        for (int i = 0; i < call.getParameterCount(); i++) {
            call.getParameter(i).accept(this);
        }
    }

    @Override
    public void visitLet(Let let) {
        // TODO Auto-generated method stub
        let.getInExpression().accept(this);
        let.getVariable().getDefaultValue().accept(this);

    }

    @Override
    public void visitIfThen(IfThen ifThen) {
        ifThen.getIfExpr().accept(this);
        ifThen.getElseExpr().accept(this);
        ifThen.getThenExpr().accept(this);
    }

    @Override
    public void visitContainerOperationCall(ContainerOperationCall call) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visitCompoundAccess(CompoundAccess access) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visitDslFragment(DslFragment fragment) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visitUnresolvedExpression(UnresolvedExpression expression) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visitCompoundInitializer(CompoundInitializer initializer) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visitContainerInitializer(ContainerInitializer initializer) {
        // TODO Auto-generated method stub

    }

}
