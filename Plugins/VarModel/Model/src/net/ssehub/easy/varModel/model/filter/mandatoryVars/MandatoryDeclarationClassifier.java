/*
 * Copyright 2009-2016 University of Hildesheim, Software Systems Engineering
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.ssehub.easy.varModel.model.filter.mandatoryVars;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.cst.AttributeVariable;
import net.ssehub.easy.varModel.cst.BlockExpression;
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
import net.ssehub.easy.varModel.model.AbstractProjectVisitor;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.Attribute;
import net.ssehub.easy.varModel.model.AttributeAssignment;
import net.ssehub.easy.varModel.model.Comment;
import net.ssehub.easy.varModel.model.CompoundAccessStatement;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.FreezeBlock;
import net.ssehub.easy.varModel.model.IModelElement;
import net.ssehub.easy.varModel.model.OperationDefinition;
import net.ssehub.easy.varModel.model.PartialEvaluationBlock;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.ProjectInterface;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.ConstraintType;
import net.ssehub.easy.varModel.model.datatypes.DerivedDatatype;
import net.ssehub.easy.varModel.model.datatypes.Enum;
import net.ssehub.easy.varModel.model.datatypes.EnumLiteral;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.OclKeyWords;
import net.ssehub.easy.varModel.model.datatypes.OrderedEnum;
import net.ssehub.easy.varModel.model.datatypes.Reference;
import net.ssehub.easy.varModel.model.datatypes.Sequence;
import net.ssehub.easy.varModel.model.datatypes.Set;
import net.ssehub.easy.varModel.model.filter.DeclarationFinder;
import net.ssehub.easy.varModel.model.filter.FilterType;
import net.ssehub.easy.varModel.model.filter.DeclarationFinder.VisibilityType;

/**
 * Heuristic classifier, which determines whether the variables of a {@link Configuration}
 * should be changed by the user or not.
 * 
 * <h2>When is a variable mandatory?</h2>
 * <ul>
 *   <li>There exist a constraint specifying that these variable must be defined
 *   (cf. {@link OclKeyWords#IS_DEFINED})</li>
 *   <li>The variable has no default value.</li>
 * </ul>
 * 
 * <h2>How to use:</h2>
 * <ol>
 *   <li>Call constructor with configuration</li>
 *   <li>Visit project of configuration</li>
 *   <li>Call {@link #getImportances()}</li>
 *   <li>For each {@link net.ssehub.easy.varModel.confModel.IDecisionVariable} (even nested variables),
 *   the {@link VariableContainer} can be asked whether the variable is mandatory</li>
 * </ol>
 * 
 * <h3>For instance:</h3>
 * <pre><code>   IDecisionVariable variable ... // Variable to be tested
 *   MandatoryDeclarationClassifier finder = new MandatoryDeclarationClassifier(config, FilterType.ALL);
 *   project.accept(finder);
 *   VariableContainer importances = finder.getImportances();
 *   boolean isMandatory = importances.isMandatory(variable); // Result for variable
 * </code></pre>
 * @author El-Sharkawy
 */
public class MandatoryDeclarationClassifier extends AbstractProjectVisitor implements IConstraintTreeVisitor {
  
    private VariableContainer varContainer;
    private Context context;
    private MandatoryClassifierSettings settings;
    private Map<IDatatype, List<AbstractVariable>> declarationsByType;
    private boolean nextVarIsMandatory;
    
    /**
     * Initializes, but not start, this classifier.
     * @param config The current configuration, which should be checked.
     * @param filterType Specifies whether project imports shall be considered or not.
     */
    public MandatoryDeclarationClassifier(Configuration config, FilterType filterType) {
        this(config, filterType, new MandatoryClassifierSettings());
    }
    
    /**
     * Initializes, but not start, this classifier.
     * @param config The current configuration, which should be checked.
     * @param filterType Specifies whether project imports shall be considered or not.
     * @param settings Optional settings.
     */
    public MandatoryDeclarationClassifier(Configuration config, FilterType filterType,
        MandatoryClassifierSettings settings) {
        
        super(config.getProject(), filterType);
        declarationsByType = new HashMap<IDatatype, List<AbstractVariable>>();
        this.settings = settings;
        varContainer = new VariableContainer(config, this.settings);
        context = new Context();
        nextVarIsMandatory = false;
    }
    
    /**
     * Returns the information which variables are mandatory (should be changed by the user).
     * Must be called after the visitation of the main project:
     * <code>configuration.getProject().accept(this)</code>.
     * @return The {@link VariableContainer} can be queried for mandatory variables.
     */
    public VariableContainer getImportances() {
        return varContainer;
    }

    @Override
    public void visitDecisionVariableDeclaration(DecisionVariableDeclaration decl) {
        // Constraint variables may contain constraints which must be visited
        IDatatype type = decl.getType();
        ConstraintSyntaxTree constraint = decl.getDefaultValue();
        if (ConstraintType.isConstraint(type) && null != constraint) {
            constraint.accept(this);
        }
        // The variable is not mandatory if it has already a value by means of a default value
        if (settings.considerDefaultValues() && null != decl.getDefaultValue()) {
            varContainer.setImportance(decl.getQualifiedName(), Importance.OPTIONAL);
        }
    }

    @Override
    public void visitAttribute(Attribute attribute) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitConstraint(Constraint constraint) {
        context.clear();
        ConstraintSyntaxTree syntax = constraint.getConsSyntax();
        IModelElement parent = constraint.getParent();
        if (null != syntax) {
            if (parent instanceof Project || parent instanceof DerivedDatatype) {
                syntax.accept(this);
            } else if (parent instanceof Compound) {
                Compound cType = (Compound) parent;
                context.addParent(cType.getQualifiedName());
                syntax.accept(this);
                if (context.elementsWereFound()) {
                    // Nested elements of instance are mandatory -> instance is also mandatory
                    varContainer.setImportance(cType.getQualifiedName(), Importance.MANDATORY);
                }
            }
        }
    }
    
    /**
     * Find all declarations for the given {@link IDatatype}, also not top level declarations.
     * @param type Only declarations matching the specified type will be found
     * @return All declarations which are assignable to the given type.
     */
    private List<AbstractVariable> getDeclarationsByType(IDatatype type) {
        List<AbstractVariable> declarations = declarationsByType.get(type);
        if (null == declarations) {
            DeclarationFinder finder = new DeclarationFinder(getStartingProject(), getFilterType(), type, false);
            declarations = finder.getVariableDeclarations(VisibilityType.ALL);
            
            // Consider isAssignableFrom: This is used in finder, but not desired here...
            // Here, we only want the direct type or "inherited" types
            for (int i = declarations.size() - 1; i >= 0; i--) {
                IDatatype declType = declarations.get(i).getType();
                boolean delete = declType != type;
                
                while (delete && declType instanceof DerivedDatatype) {
                    declType = ((DerivedDatatype) declType).getBasisType();
                    delete = declType != type;
                }
                
                if (delete) {
                    declarations.remove(i);
                }
            }
            
            declarationsByType.put(type, declarations);
        }
        
        
        return declarations;
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
        // Not needed
    }

    @Override
    public void visitAttributeAssignment(AttributeAssignment assignment) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitCompoundAccessStatement(CompoundAccessStatement access) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitEnum(Enum eenum) {
        if (settings.treatEnumsAsMandatory()) {
            List<AbstractVariable> variables = getDeclarationsByType(eenum);
            for (int i = 0, n = variables.size(); i < n; i++) {
                setImportanceForAllInstancesOfDeclaration(variables.get(i), Importance.MANDATORY);
            }
        }
    }

    @Override
    public void visitOrderedEnum(OrderedEnum eenum) {
        visitEnum(eenum);
    }

    /**
     * Changes the {@link VariableImportance} for all instances of the given {@link AbstractVariable}.
     * @param decl A (nested) declaration for which all instances shall be changed.
     * @param importance The new {@link Importance} to set.
     */
    private void setImportanceForAllInstancesOfDeclaration(AbstractVariable decl, Importance importance) {
        varContainer.setImportance(decl.getQualifiedName(), importance);
    }


    @Override
    public void visitCompound(Compound compound) {
        // Compounds can contain constraints -> visit all of them
        Compound parent = compound.getRefines();
        if (null != parent) {
            visitCompound(parent);
        }
        // Visit constraints of a compound
        for (int i = 0, n = compound.getConstraintsCount(); i < n; i++) {
            visitConstraint(compound.getConstraint(i));
        }
        // Visit variables of a compound (especially constraint variables are of interest).
        for (int i = 0, end = compound.getInheritedElementCount(); i < end; i++) {
            visitDecisionVariableDeclaration(compound.getInheritedElement(i));
        }
    }

    @Override
    public void visitDerivedDatatype(DerivedDatatype datatype) {
        int nConstraints = datatype.getConstraintCount();
        
        // Set all instances of typeDef to mandatory
//        if (nConstraints > 0) {
//            List<AbstractVariable> variables = getDeclarationsByType(datatype);
//            for (int i = 0, n = variables.size(); i < n; i++) {
//                setImportanceForAllInstancesOfDeclaration(variables.get(i), Importance.MANDATORY);
//            }
//        }
        
        // Visit all constraints, as they could also include other variables
        for (int i = 0; i < nConstraints; i++) {
            Constraint constraint = datatype.getConstraint(i);
            if (null != constraint) {
                visitConstraint(constraint);
            }
        }
        
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
    public void visitConstantValue(ConstantValue value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitVariable(Variable variable) {
        AbstractVariable decl = variable.getVariable();
        if (nextVarIsMandatory) {
            IModelElement parent = decl.getParent();
            if (parent instanceof DerivedDatatype) {
                List<AbstractVariable> instances = getDeclarationsByType((DerivedDatatype) parent);
                if (null != instances) {
                    for (int i = 0, end = instances.size(); i < end; i++) {
                        setImportanceForAllInstancesOfDeclaration(instances.get(i), Importance.MANDATORY);
                    }
                }
            } else {
                String qName = context.hasParent() ? getSlotOfCompound(decl) : decl.getQualifiedName();
                context.elementFound();
                varContainer.setImportance(qName, Importance.MANDATORY);
                if (context.depth() > 0) {
                    context.addParent(qName);
                }
            }
        }
    }

    @Override
    public void visitAnnotationVariable(AttributeVariable variable) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitParenthesis(Parenthesis parenthesis) {
        parenthesis.getExpr().accept(this);
    }

    @Override
    public void visitComment(net.ssehub.easy.varModel.cst.Comment comment) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitOclFeatureCall(OCLFeatureCall call) {
        // TODO consider re-assignments of constraint variables
        String op = call.getOperation();
        ConstraintSyntaxTree operand = call.getOperand();
        
        if (OclKeyWords.IS_DEFINED.equals(op)) {
            nextVarIsMandatory = true;
            operand.accept(this);
            nextVarIsMandatory = false;
        } else if (!OclKeyWords.ASSIGNMENT.equals(op) && null != operand) {
            // Most assignments should not be considered
            operand.accept(this);
            for (int i = 0; i < call.getParameterCount(); i++) {
                call.getParameter(i).accept(this);
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
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitCompoundAccess(CompoundAccess access) {
        context.compoundDown();
        access.getCompoundExpression().accept(this);
        AbstractVariable slotDecl = access.getResolvedSlot();
        if (null != slotDecl && context.hasParent()) {
            String nestedVar = getSlotOfCompound(access.getResolvedSlot());
            if (null != nestedVar) {
                context.elementFound();
                varContainer.setImportance(nestedVar, Importance.MANDATORY);
                if (context.depth() > 1) {
                    context.addParent(nestedVar);
                }
            }
        }
        context.compoundUp();
        if (0 == context.depth()) {
            context.clear();
        }
    }
    
    /**
     * Retrieves the instance for the given declaration for the compound which was
     * visited before.
     * @param slotDeclaration The declaration of a slot inside a compound.
     * @return The related qualified name for the instance.
     */
    private String getSlotOfCompound(AbstractVariable slotDeclaration) {
        String qName = null;
        String pName = context.getParent();
        if (null != pName) {
            qName = pName + "::" + slotDeclaration.getName();
        }
        return qName;
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

    @Override
    public void visitSelf(Self self) {
    }

    @Override
    public void visitBlockExpression(BlockExpression block) {
        for (int e = 0, n = block.getExpressionCount(); e < n; e++) {
            block.getExpression(e).accept(this);
        }
    }

}
