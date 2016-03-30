package net.ssehub.easy.producer.ui.confModel;

import java.util.Map;

import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.Attribute;
import net.ssehub.easy.varModel.model.AttributeAssignment;
import net.ssehub.easy.varModel.model.Comment;
import net.ssehub.easy.varModel.model.CompoundAccessStatement;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.FreezeBlock;
import net.ssehub.easy.varModel.model.IModelVisitor;
import net.ssehub.easy.varModel.model.OperationDefinition;
import net.ssehub.easy.varModel.model.PartialEvaluationBlock;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.ProjectImport;
import net.ssehub.easy.varModel.model.ProjectInterface;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.DerivedDatatype;
import net.ssehub.easy.varModel.model.datatypes.Enum;
import net.ssehub.easy.varModel.model.datatypes.EnumLiteral;
import net.ssehub.easy.varModel.model.datatypes.OrderedEnum;
import net.ssehub.easy.varModel.model.datatypes.Reference;
import net.ssehub.easy.varModel.model.datatypes.Sequence;
import net.ssehub.easy.varModel.model.datatypes.Set;
import net.ssehub.easy.varModel.model.filter.DeclrationInConstraintFinder;

/**
 * Sets error messages for {@link GUIVariable}s.
 * @author El-Sharkawy
 *
 */
class ErrorSetter implements IModelVisitor {
    private Map<AbstractVariable, GUIVariable> variableMap;
    private String errorMsg;
    
    /**
     * Sole constructor for setting error messages by this class.
     * @param variableMap A map of ({@link AbstractVariable}, {@link GUIVariable}) for all
     * {@link GUIVariable}s of the {@link GUIConfiguration} where this {@link ErrorSetter} is used. 
     */
    ErrorSetter(Map<AbstractVariable, GUIVariable> variableMap) {
        this.variableMap = variableMap;
    }
    
    /**
     * For specifying a readable error message.
     * @param errorMsg A error message which can be ready by a normal user.
     * <tt>null</tt> deletes the error message (should be done before handling the next conflict).
     */
    void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public void visitEnum(Enum eenum) {
        // Not needed
    }

    @Override
    public void visitOrderedEnum(OrderedEnum eenum) {
        // Not needed
    }

    @Override
    public void visitCompound(Compound compound) {
        // Not needed
    }

    @Override
    public void visitDerivedDatatype(DerivedDatatype datatype) {
        // Not needed
    }

    @Override
    public void visitEnumLiteral(EnumLiteral literal) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitReference(Reference reference) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitSequence(Sequence sequence) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitSet(Set set) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitProject(Project project) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitProjectImport(ProjectImport pImport) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitDecisionVariableDeclaration(DecisionVariableDeclaration decl) {
        GUIVariable guiVariable = variableMap.get(decl);
        if (null != guiVariable) {
            guiVariable.addErrorMessage(decl, errorMsg);
        }
    }

    @Override
    public void visitAttribute(Attribute attribute) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitConstraint(Constraint constraint) {
        if (null != constraint) {
            ConstraintSyntaxTree cst = constraint.getConsSyntax();
            DeclrationInConstraintFinder finder = new DeclrationInConstraintFinder(cst);
            java.util.Set<AbstractVariable> delcarations = finder.getDeclarations();
            for (AbstractVariable abstractVariable : delcarations) {
                GUIVariable guiVariable = variableMap.get(abstractVariable);
                if (null != guiVariable) {
                    guiVariable.addErrorMessage(constraint, errorMsg);
                }
            }
        }
    }

    @Override
    public void visitFreezeBlock(FreezeBlock freeze) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitOperationDefinition(OperationDefinition opdef) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitPartialEvaluationBlock(PartialEvaluationBlock block) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitProjectInterface(ProjectInterface iface) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitComment(Comment comment) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitAttributeAssignment(AttributeAssignment assignment) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitCompoundAccessStatement(CompoundAccessStatement access) {
        // TODO Auto-generated method stub
    }

}
