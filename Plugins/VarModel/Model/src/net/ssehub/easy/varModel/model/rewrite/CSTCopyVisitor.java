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

import java.util.Map;

import net.ssehub.easy.varModel.cst.ConstantValue;
import net.ssehub.easy.varModel.cst.CopyVisitor;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.ContainableModelElement;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.ExplicitTypeVariableDeclaration;
import net.ssehub.easy.varModel.model.IModelElement;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.values.Value;

/**
 * Special {@link CopyVisitor} as needed by the {@link ProjectCopyVisitor}.
 * @author El-Sharkawy
 */
class CSTCopyVisitor extends CopyVisitor {
    
    private boolean complete;
    private ProjectCopyVisitor copyier;
    
    /**
     * Creates a copy visitor with explicit mapping. This is for first round of translation, where <b>not</b> all
     * projects have been translated.
     * 
     * @param mapping a mapping from old variable declarations to new variable declarations,
     *   existing variable declarations are taken over if no mapping is given, may be <b>null</b>
     *   in case of no mapping at all
     */
    CSTCopyVisitor(Map<AbstractVariable, AbstractVariable> mapping) {
        this(mapping, null);
    }
    
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
        this.copyier = copyier;
        complete = true;
    }
    
    /**
     * Specifies whether the constraint could be translated completely.
     * @return <tt>true</tt> constraint was translated completely, <tt>false</tt> {@link UntranslatedDeclaration}s
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
        IDatatype type = nestedValue.getContainedType();
        if (null != type && !type.isPrimitive()) {
            // Value must be translated
            complete = false;
            
            IDatatype copiedType = copyier.getTranslatedType(type);
            if (null != copiedType) {
                ValueCopyVisitor valueCopyier = new ValueCopyVisitor(copyier);
                nestedValue.accept(valueCopyier);
                if (valueCopyier.translatedCompletely()) {
                    setResult(new ConstantValue(valueCopyier.getResult()));
                    complete = true;
                }
            }
        }
        super.visitConstantValue(constantValue);
    }

}