/*
 * Copyright 2009-2014 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.varModel.cst;

import java.util.Map;

import net.ssehub.easy.basics.modelManagement.IVariable;
import net.ssehub.easy.basics.modelManagement.IVersionRestriction.IVariableMapper;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;

/**
 * Copies a constraint syntax tree possibly mapping the variables. May be 
 * reused after calling {@link #clear()}
 * 
 * @author Holger Eichelberger
 */
public class CopyVisitor extends BasicCopyVisitor {

    private Map<AbstractVariable, AbstractVariable> mapping;
    private IVariableMapper mapper;
    private IVariableReplacer replacer;

    /**
     * Defines a common variable replacer. (Shall replace <code>mapping</code> in the future).
     * 
     * @author Holger Eichelberger
     */
    public interface IVariableReplacer extends IVariableMapper {
        
        /**
         * Maps a leaf variable.
         * 
         * @param variable the variable to be mapped
         * @return the mapped variable or <b>null</b> if there is no mapping
         */
        public ConstraintSyntaxTree mapLeaf(Variable variable);
        
    }
    
    /**
     * Creates a copy visitor without mapping.
     */
    public CopyVisitor() {
        this((Map<AbstractVariable, AbstractVariable>) null);
    }
    
    /**
     * Creates a copy visitor with explicit mapping.
     * 
     * @param mapping a mapping from old variable declarations to new variable declarations,
     *   existing variable declarations are taken over if no mapping is given, may be <b>null</b>
     *   in case of no mapping at all
     */
    public CopyVisitor(Map<AbstractVariable, AbstractVariable> mapping) {
        this.mapping = mapping;
    }

    /**
     * Creates a copy visitor with explicit mapping.
     * 
     * @param mapper the variable mapper (may be <b>null</b>)
     */
    public CopyVisitor(IVariableMapper mapper) {
        this.mapper = mapper;
        if (mapper instanceof IVariableReplacer) {
            this.replacer = (IVariableReplacer) mapper;
        }
    }
    
    /**
     * Returns the specified variable mapping.
     * @return A mapping from old variable declarations to new variable declarations,
     *   existing variable declarations are taken over if no mapping is given, may be <b>null</b>
     */
    protected Map<AbstractVariable, AbstractVariable> getMapping() {
        return mapping;
    }

    @Override
    public void visitVariable(Variable variable) {
        ConstraintSyntaxTree var = null;
        if (null != replacer) {
            var = replacer.mapLeaf(variable);
        }
        if (null == var) { // getCopyVariables
            var = new Variable(mapVariable(variable.getVariable()));
        }
        setResult(var);
    }

    @Override
    protected DecisionVariableDeclaration mapVariable(DecisionVariableDeclaration var) {
        DecisionVariableDeclaration result = null;
        if (null != mapping) {
            AbstractVariable tmp = mapping.get(var); 
            if (tmp instanceof DecisionVariableDeclaration) {
                result = var;
            }
        }
        if (null == result && null != mapper) {
            IVariable tmp = mapper.map(var);
            if (tmp instanceof DecisionVariableDeclaration) {
                result = var;
            }
        }
        if (null == result) {
            result = var;
        }
        return result;
    }

    @Override
    protected AbstractVariable mapVariable(AbstractVariable var) {
        AbstractVariable result = null;
        if (null != mapping) {
            result = mapping.get(var);
            if (null == result) {
                result = var;
            }
        } else {
            result = var;
        }
        return result;
    }

    @Override
    public void visitAnnotationVariable(AttributeVariable variable) {
        ConstraintSyntaxTree var = null;
        if (null != replacer) {
            var = replacer.mapLeaf(variable);
        }
        if (null == var) {
            super.visitAnnotationVariable(variable);
            var = getResult();
        }
        setResult(var);
    }

}
