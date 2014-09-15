package de.uni_hildesheim.sse.easy.ui.confModel;

import java.util.Map;

import de.uni_hildesheim.sse.model.cst.ConstraintSyntaxTree;
import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.Attribute;
import de.uni_hildesheim.sse.model.varModel.AttributeAssignment;
import de.uni_hildesheim.sse.model.varModel.Comment;
import de.uni_hildesheim.sse.model.varModel.CompoundAccessStatement;
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
import de.uni_hildesheim.sse.model.varModel.datatypes.OrderedEnum;
import de.uni_hildesheim.sse.model.varModel.datatypes.Reference;
import de.uni_hildesheim.sse.model.varModel.datatypes.Sequence;
import de.uni_hildesheim.sse.model.varModel.datatypes.Set;
import de.uni_hildesheim.sse.model.varModel.filter.DeclrationInConstraintFinder;

/**
 * Sets error messages for {@link GUIVariable}s.
 * @author El-Sharkawy
 *
 */
class ErrorSetter implements IModelVisitor {
    private Map<AbstractVariable, GUIVariable> variableMap;
    
    /**
     * Sole constructor for setting error messages by this class.
     * @param variableMap A map of ({@link AbstractVariable}, {@link GUIVariable}) for all
     * {@link GUIVariable}s of the {@link GUIConfiguration} where this {@link ErrorSetter} is used. 
     */
    ErrorSetter(Map<AbstractVariable, GUIVariable> variableMap) {
        this.variableMap = variableMap;
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
            guiVariable.addErrorMessage(decl);
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
                    guiVariable.addErrorMessage(constraint);
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
