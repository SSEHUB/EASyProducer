package net.ssehub.easy.producer.ui.confModel;

import java.util.Map;

import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
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
import net.ssehub.easy.varModel.model.filter.IDecisionVariableInConstraintFinder;

/**
 * Sets error messages for {@link GUIVariable}s.
 * @author El-Sharkawy
 *
 */
class ErrorSetter implements IModelVisitor {
    private Map<AbstractVariable, GUIVariable> variableMap;
    private String errorMsg;
    private Configuration config;
    
    /**
     * Sole constructor for setting error messages by this class.
     * @param variableMap A map of ({@link AbstractVariable}, {@link GUIVariable}) for all
     * {@link GUIVariable}s of the {@link GUIConfiguration} where this {@link ErrorSetter} is used.
     * @param config The wrapped {@link Configuration} of the current {@link GUIConfiguration}.
     */
    ErrorSetter(Map<AbstractVariable, GUIVariable> variableMap, Configuration config) {
        this.variableMap = variableMap;
        this.config = config;
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
            IDecisionVariableInConstraintFinder finder = new IDecisionVariableInConstraintFinder(config, false);
            cst.accept(finder);
            java.util.Set<IDecisionVariable> variables = finder.getVariables();
            for (IDecisionVariable variable : variables) {
                GUIVariable guiVariable = getVariable(variable);
                if (null != guiVariable) {
                    guiVariable.addErrorMessage(constraint, errorMsg);
                }
            }
        }
    }
    
    /**
     * Recursive part of {@link #visitConstraint(Constraint)}: Maps a (nested) {@link IDecisionVariable} to the correct
     * (nested) {@link GUIVariable}.
     * @param variable The {@link IDecisionVariable} for which the {@link GUIVariable} shall be retrieved.
     * @return The wrapping {@link GUIVariable} for the given {@link IDecisionVariable} or <tt>null</tt> if it could
     * not be found.
     */
    private GUIVariable getVariable(IDecisionVariable variable) {
        GUIVariable result = null;
        
        if (variable.isNested() && variable.getParent() instanceof IDecisionVariable) {
            GUIVariable parent = getVariable((IDecisionVariable) variable.getParent());
            if (null != parent) {
                for (int i = 0, end = parent.getNestedElementsCount(); i < end && null == result; i++) {
                    GUIVariable nestedVar = parent.getNestedElement(i);
                    if (nestedVar.getVariable() == variable) {
                        result = nestedVar;
                    }
                }
            }
        } else {
            result = variableMap.get(variable.getDeclaration());
        }
        
        return result;
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
