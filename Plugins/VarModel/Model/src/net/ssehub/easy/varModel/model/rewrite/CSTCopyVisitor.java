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
package net.ssehub.easy.varModel.model.rewrite;

import java.util.Iterator;
import java.util.Map;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.varModel.Bundle;
import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.cst.CompoundInitializer;
import net.ssehub.easy.varModel.cst.ConstantValue;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.cst.ContainerInitializer;
import net.ssehub.easy.varModel.cst.ContainerOperationCall;
import net.ssehub.easy.varModel.cst.CopyVisitor;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;
import net.ssehub.easy.varModel.cst.Self;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.Attribute;
import net.ssehub.easy.varModel.model.AttributeAssignment;
import net.ssehub.easy.varModel.model.ContainableModelElement;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.ExplicitTypeVariableDeclaration;
import net.ssehub.easy.varModel.model.IAttributableElement;
import net.ssehub.easy.varModel.model.IAttributeAccess;
import net.ssehub.easy.varModel.model.IModelElement;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.Container;
import net.ssehub.easy.varModel.model.datatypes.ICustomOperationAccessor;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;

/**
 * Special {@link CopyVisitor} as needed by the {@link ProjectCopyVisitor}.
 * @author El-Sharkawy
 */
class CSTCopyVisitor extends CopyVisitor {
    
    private boolean visitItrExpression;
    private boolean complete;
    private ProjectCopyVisitor copyier;
    private boolean forceAccessors;
        
    /**
     * Creates a copy visitor with explicit mapping. This is for the final round of translation, where all projects
     * have been translated.
     * 
     * @param mapping a mapping from old variable declarations to new variable declarations,
     *   existing variable declarations are taken over if no mapping is given, may be <b>null</b>
     *   in case of no mapping at all
     * @param copyier The calling {@link ProjectCopyVisitor}, containing the list of currently translated projects.
     */
    CSTCopyVisitor(Map<AbstractVariable, AbstractVariable> mapping, ProjectCopyVisitor copyier) {
        super(mapping);
        setCopyExpressions(true); // just to be sure to copy the whole expression
        this.copyier = copyier;
        complete = true;
        visitItrExpression = false;
        forceAccessors = false;
    }
    
    /**
     * Specification whether this visitor should try to fix broken {@link ICustomOperationAccessor}s.
     * These are usually {@link Project}s. 
     * @param forceAccessors {@code true} If an accessor could not be found, a fallback (unprezise) mechanism is used,
     *     this should only be used at the end of the translation if all projects are surely copied, {@code false} is
     *     the default option for this.
     */
    void setForceaccessors(boolean forceAccessors) {
        this.forceAccessors = forceAccessors;
    }
    
    /**
     * Specifies whether the constraint could be translated completely.
     * @return {@code true} constraint was translated completely, {@code false} untranslated declarations
     *     have been used and must be translated at a later point.
     */
    boolean translatedCompletely() {
        return complete;
    }
    
    @Override
    protected AbstractVariable mapVariable(AbstractVariable var) {
        AbstractVariable result = null;
        if (null != getMapping()) {
            result = getMapping().get(var);
            
            if (null == result && var instanceof Attribute && null != var.getParent()
                && null != copyier.getCopiedParent(var.getParent())) {
                
                result = mapAnnotation((Attribute) var);
            }
            
            if (null == result && visitItrExpression && var instanceof DecisionVariableDeclaration) {
                // Create local iterator variable
                DecisionVariableDeclaration varAsDecl = (DecisionVariableDeclaration) var;
                IDatatype cpiedType = copyier.getTranslatedType(var.getType());
                IModelElement copiedParent = copyier.getCopiedParent(var.getParent());
                if (null != cpiedType && null != copiedParent) {
                    if (varAsDecl.isDeclaratorTypeExplicit()) {
                        result = new ExplicitTypeVariableDeclaration(var.getName(), cpiedType, copiedParent);
                    } else {
                        result = new DecisionVariableDeclaration(var.getName(), cpiedType, copiedParent);
                    }
                    // Needed when the expression is evaluated
                    getMapping().put(var, result);
                }
            }
            if (null == result) {
                result = var;
                if (copyier == null || !copyier.getAllCopiedProjects().contains(result.getTopLevelParent())) {
                    complete = false;
                }
            }
        } else {
            result = var;
        }
        return result;
    }

    /**
     * Part of {@link #mapVariable(AbstractVariable)} to map {@link Attribute}s.
     * @param var the annotation to be mapped
     * @return the mapped variable or <code>var</code>
     */
    private AbstractVariable mapAnnotation(Attribute var) {
        AbstractVariable result;
        IModelElement parent = copyier.getCopiedParent(var.getParent());
        
        IAttributableElement orgAttributed = var.getElement();
        IAttributableElement copiedAttributed = (IAttributableElement) getMapping().get(orgAttributed);
        result = null != copiedAttributed ? copiedAttributed.getAttribute(var.getName()) : null;
        if (null != copiedAttributed && null == result && null != parent && parent instanceof IAttributeAccess) {
            
            /*
             * Try to propagate annotations from parent (project) to childs
             * (which may be added after annotation)
             */
            Attribute annotation = ((IAttributeAccess) parent).getAttribute(var.getName());
            if (null != annotation) {
                parent.propagateAttribute(annotation);
                result = copiedAttributed.getAttribute(var.getName());
            }
        }
        
        if (null == result) {
            if (parent instanceof AttributeAssignment) {
                IAttributableElement annotatedElement = ((Attribute) var).getElement();
                if (annotatedElement instanceof IModelElement) {
                    parent = (IModelElement) annotatedElement;
                }
            }
            
            // If-block before is optional -> Please do not wonder about casting back and forth         
            if (parent instanceof IAttributableElement) {
                result = ((IAttributableElement) parent).getAttribute(var.getName());
            }
        }
        
        if (null != result) {
            getMapping().put(var, result);
        }
        return result;
    }
    
    @Override
    public void visitOclFeatureCall(OCLFeatureCall call) {
        if (complete) {
            ConstraintSyntaxTree operand = call.getOperand();
            if (null != operand) {
                operand.accept(this);
                operand = getResult();
            } else {
                operand = null;
            }
            ConstraintSyntaxTree[] args = new ConstraintSyntaxTree[call.getParameterCount()];
            for (int p = 0; p < args.length; p++) {
                call.getParameter(p).accept(this);
                args[p] =  getResult();
            }
            
            ICustomOperationAccessor accessor = call.getAccessor();
            if (null != accessor) {
                ICustomOperationAccessor copiedAccessor = copyier.getCopiedAccessor(accessor);
                
                // Fallback ;-)
                if (null == copiedAccessor && forceAccessors && accessor instanceof Project) {
                    Project orgAcessor = (Project) accessor;
                    Iterator<Project> copiedProjectsItr = copyier.getAllCopiedProjects().iterator();
                    while (copiedAccessor == null && copiedProjectsItr.hasNext()) {
                        Project candidate = copiedProjectsItr.next();
                        if (orgAcessor.getName().equals(candidate.getName())) {
                            copiedAccessor = candidate;
                        }
                    }
                    
                }
    
                if (null != copiedAccessor) {
                    accessor = copiedAccessor;
                } else {
                    // Avoid null pointer by continuing copy process but mark copy as incomplete.
                    complete = false;
                }
            }
            
            if (complete) {
                setResult(new OCLFeatureCall(operand, call.getOperation(), accessor, args));
            } else {
                setResult(call);
            }
        } else {
            setResult(call);
            
        }
    }
    
    @Override
    public void visitCompoundInitializer(CompoundInitializer initializer) {
        if (complete) {
            String[] slots = new String[initializer.getSlotCount()];
            for (int s = 0; s < slots.length; s++) {
                slots[s] = initializer.getSlot(s);
            }
            AbstractVariable[] slotDecls = new DecisionVariableDeclaration[initializer.getSlotCount()];
            for (int s = 0; s < slotDecls.length; s++) {
                slotDecls[s] = mapVariable(initializer.getSlotDeclaration(s));
            }
            ConstraintSyntaxTree[] exprs = new ConstraintSyntaxTree[initializer.getExpressionCount()];
            for (int e = 0; e < exprs.length; e++) {
                initializer.getExpression(e).accept(this);
                exprs[e] = getResult();
            }
            IDatatype copiedType = copyier.getTranslatedType(initializer.getType());
            if (null != copiedType && copiedType instanceof Compound) {
                try {
                    assert initializer.getType().getClass() == copiedType.getClass();
                    setResult(new CompoundInitializer((Compound) copiedType, slots, slotDecls, exprs));
                } catch (CSTSemanticException e) {
                    complete = false;
                    setResult(initializer);
                    EASyLoggerFactory.INSTANCE.getLogger(CSTCopyVisitor.class, Bundle.ID).exception(e);
                }
            } else {
                complete = false;
                setResult(initializer);
            }
        } else {
            setResult(initializer);
        }
    }

    @Override
    public void visitContainerInitializer(ContainerInitializer initializer) {
        if (complete) {
            ConstraintSyntaxTree[] exprs = new ConstraintSyntaxTree[initializer.getExpressionCount()];
            for (int e = 0; e < exprs.length; e++) {
                initializer.getExpression(e).accept(this);
                exprs[e] = getResult();
            }
            IDatatype copiedType = copyier.getTranslatedType(initializer.getType());
            if (null != copiedType && copiedType instanceof Container) {
                try {
                    assert initializer.getType().getClass() == copiedType.getClass();
                    setResult(new ContainerInitializer((Container) copiedType, exprs));
                } catch (CSTSemanticException e) {
                    complete = false;
                    setResult(initializer);
                    EASyLoggerFactory.INSTANCE.getLogger(CSTCopyVisitor.class, Bundle.ID).exception(e);
                }
            } else {
                complete = false;
                setResult(initializer);
            }
        } else {
            setResult(initializer);
        }
    }
    
    @Override
    public void visitContainerOperationCall(ContainerOperationCall call) {
        call.getContainer().accept(this);
        ConstraintSyntaxTree container = getResult();
        visitItrExpression = true;
        call.getExpression().accept(this);
        visitItrExpression = false;
        ConstraintSyntaxTree expression = getResult();
        DecisionVariableDeclaration[] decls = new DecisionVariableDeclaration[call.getDeclaratorsCount()];
        for (int d = 0; d < decls.length; d++) {
            DecisionVariableDeclaration orgDeclarator = call.getDeclarator(d);
            decls[d] = mapVariable(orgDeclarator);
            
            // Declarators in apply's have a default value
            if (null != orgDeclarator.getDefaultValue() && null == decls[d].getDefaultValue()) {
                CSTCopyVisitor dfltValueCopyier = new CSTCopyVisitor(getMapping(), copyier);
                orgDeclarator.getDefaultValue().accept(dfltValueCopyier);
                if (dfltValueCopyier.translatedCompletely()) {
                    ConstraintSyntaxTree copiedDefault = dfltValueCopyier.getResult();
                    try {
                        decls[d].setValue(copiedDefault);
                    } catch (ValueDoesNotMatchTypeException e) {
                        complete = false;
                    } catch (CSTSemanticException e) {
                        complete = false;
                    }
                } else {
                    complete = false;
                }
            }
        }
        setResult(new ContainerOperationCall(container, call.getOperation(), expression, decls));
    }
    
    @Override
    protected DecisionVariableDeclaration mapVariable(DecisionVariableDeclaration var) {
        DecisionVariableDeclaration resultDecl = null;
        AbstractVariable tmpDecl = null;
        if (null != getMapping()) {
            tmpDecl = getMapping().get(var);
            if (null != tmpDecl) {
                IModelElement declsParent = tmpDecl.getTopLevelParent();
                if (tmpDecl instanceof DecisionVariableDeclaration && null != declsParent
                        && copyier.getAllCopiedProjects().contains(declsParent)) {
                    
                    resultDecl = (DecisionVariableDeclaration) tmpDecl;
                }
            }
        }
        if (null == resultDecl && null != copyier) {
            IDatatype copiedType = copyier.getTranslatedType(var.getType());
            IModelElement orgParent = var.getParent();
            IModelElement parent = null;
            if (null != orgParent && orgParent instanceof ContainableModelElement) {
                parent = copyier.getCopiedElement((ContainableModelElement) orgParent);
            }
            
            if (null != orgParent && null == parent) {
                complete = false;
            }
            // Create local declarator / iterator variable
            if (null != copiedType) {
                if (var.isDeclaratorTypeExplicit()) {
                    resultDecl = new ExplicitTypeVariableDeclaration(var.getName(), copiedType, parent);
                } else {
                    resultDecl = new DecisionVariableDeclaration(var.getName(), copiedType, parent);
                }
            }
        }
        if (null == resultDecl) {
            // Error, but prevent NullPointerException
            resultDecl = super.mapVariable(var);
            complete = false;
        }
        return resultDecl;
    }
    
    @Override
    public void visitConstantValue(ConstantValue constantValue) {
        Value nestedValue = constantValue.getConstantValue();
        IDatatype type = nestedValue.getType();
        if (null != type && !type.isPrimitive()) {
            // Value must be translated
            boolean tmpComplete = complete;
            complete = false;
            
            IDatatype copiedType = copyier.getTranslatedType(type);
            if (null != copiedType) {
                ValueCopyVisitor valueCopyier = new ValueCopyVisitor(copyier);
                nestedValue.accept(valueCopyier);
                if (valueCopyier.translatedCompletely()) {
                    setResult(new ConstantValue(valueCopyier.getResult()));
                    // complete = tmpComplete && true
                    complete = tmpComplete;
                }
            }
        } else {
            super.visitConstantValue(constantValue);
        }
    }
    
    @Override
    public void visitSelf(Self self) {
        if (complete && null != copyier) {
            IDatatype copiedType = copyier.getTranslatedType(self.getType());
            if (null != copiedType && copiedType instanceof Compound) {
                setResult(new Self((Compound) copiedType));
            } else {
                complete = false;
                super.visitSelf(self);
            }
        } else {
            super.visitSelf(self);
        }
    }

}
