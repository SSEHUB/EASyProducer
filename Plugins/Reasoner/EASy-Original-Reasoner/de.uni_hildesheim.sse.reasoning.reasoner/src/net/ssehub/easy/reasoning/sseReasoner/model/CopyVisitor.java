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
package net.ssehub.easy.reasoning.sseReasoner.model;

import java.util.HashMap;
import java.util.Map;

import net.ssehub.easy.varModel.cst.BasicCopyVisitor;
import net.ssehub.easy.varModel.cst.Comment;
import net.ssehub.easy.varModel.cst.CompoundAccess;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.cst.Self;
import net.ssehub.easy.varModel.cst.Variable;
import net.ssehub.easy.varModel.model.AbstractVariable;

/**
 * Copies a constraint syntax tree possibly mapping the variables. May be 
 * reused after calling {@link #clear()}
 * 
 * @author Sizonenko
 * @author Holger Eichelberger
 */
public class CopyVisitor extends BasicCopyVisitor {

    private Map<Variable, Variable> mapping;
    private Map<AbstractVariable, CompoundAccess> mappingCA;
    private ConstraintSyntaxTree selfEx;
    private AbstractVariable self;
    private boolean containsSelf;

    /**
     * Creates a copy visitor without mapping.
     */
    public CopyVisitor() {
        this(null);
    }
    
    /**
     * Creates a copy visitor with explicit mapping.
     * 
     * @param mappingCA a mapping from old variable declarations to new compound access declarations,
     *   existing variable declarations are taken over if no mapping is given, may be <b>null</b>
     *   in case of no mapping at all
     * @see #setMappings(Map, Map)
     */
    public CopyVisitor(Map<AbstractVariable, CompoundAccess> mappingCA) {
        // setCopyVariables not needed as overridden anyway
        setDoInferDatatype(false);
        setCopyConstants(false); 
        setMappings(mappingCA);
    }  

    /**
     * Sets the mapping. [init, reuse]
     * 
     * @param mappingCA a mapping from variable declarations to new compound access declarations,
     *   existing variable declarations are taken over if no mapping is given, may be <b>null</b>
     *   in case of no mapping at all
     */
    public void setMappings(Map<AbstractVariable, CompoundAccess> mappingCA) {
        this.mappingCA = mappingCA;
    }

    /**
     * Returns whether the last execution visited a <i>self</i>.
     * 
     * @return <code>true</code> for <i>self</i>, <code>false</code> else
     */
    public boolean containsSelf() {
        return containsSelf;
    }
    
    /**
     * Clears this visitor for reuse.
     * 
     * @see #clearVariableMapping()
     */
    public void clear() {
        super.clear();
        containsSelf = false;
        mappingCA = null;
        selfEx = null;
        self = null;
        clearVariableMapping();
    }
    
    /**
     * Adds a variable mapping to be considered during copying.
     * 
     * @param orig the original variable to be replaced (may be <b>null</b>, ignored)
     * @param dest the destination variable to replace <code>orig</code> (may be <b>null</b>, ignored)
     * @return <b>this</b>
     */
    public CopyVisitor addVariableMapping(Variable orig, Variable dest) {
        if (null != orig) {
            if (null == mapping) {
                mapping = new HashMap<Variable, Variable>();
            }
            mapping.put(orig, dest);
        }
        return this;
    }

    /**
     * Clears the mapping for a given variable.
     * 
     * @param var the variable to clear the mapping for (may be <b>null</b>, ignored)
     * @return <b>this</b>
     */
    public CopyVisitor clearVariableMapping(Variable var) {
        if (null != mapping && null != var) {
            mapping.remove(var);
        }
        return this;
    }

    /**
     * Clears the entire variable mapping.
     * @return <b>this</b>
     */
    public CopyVisitor clearVariableMapping() {
        if (null != mapping) {
            mapping.clear();
        }
        return this;
    }

    /**
     * Defines <i>self</i> in terms of an expression.
     * 
     * @param selfEx the expression (may be <b>null</b>, ignored then).
     * @return <b>this</b>
     */
    public CopyVisitor setSelf(ConstraintSyntaxTree selfEx) {
        this.selfEx = selfEx;
        return this;
    }

    /**
     * Defines <i>self</i> in terms of a variable declaration. Creates a variable on demand and re-uses it. Dont' call
     * also {@link #setSelf(ConstraintSyntaxTree)} on the same expression.
     * 
     * @param self the variable (declaration) representing self (may be <b>null</b>, ignored then).
     * @return <b>this</b>
     */
    public CopyVisitor setSelf(AbstractVariable self) {
        this.self = self;
        return this;
    }
    
    /**
     * Accepts <b>this</b> on <code>cst</code> and returns {@link #getResult()}.
     * 
     * @param cst the constraint to visit
     * @return the visiting result
     */
    public ConstraintSyntaxTree accept(ConstraintSyntaxTree cst) {
        cst.accept(this);
        return getResult();
    }

    /**
     * Accepts <b>this</b> on <code>cst</code>, returns {@link #getResult()} and {@link #clear() clears} 
     * <b>this</b>.
     * 
     * @param cst the constraint to visit
     * @return the visiting result
     */
    public ConstraintSyntaxTree acceptAndClear(ConstraintSyntaxTree cst) {
        cst.accept(this);
        ConstraintSyntaxTree result = getResult();
        clear();
        return result;
    }

    @Override
    public void visitVariable(Variable variable) {
        ConstraintSyntaxTree res;
        CompoundAccess tmp = null == mappingCA ? null : mappingCA.get(variable.getVariable());
        if (null != tmp) {
            res = inferDatatype(tmp);
        } else {
            res = variable;
            if (null != mapping) {
                res = mapping.get(variable);
                if (null == res) {
                    res = variable;
                }
            }
        }
        setResult(res);
    }

    @Override
    public void visitComment(Comment comment) {
        // don't copy comments at all
    }

    @Override
    public void visitSelf(Self self) {
        if (null == selfEx && null != this.self) {
            selfEx = new Variable(this.self);
        }
        if (selfEx != null) {
            setResult(selfEx);
        } else {
            setResult(self); // no replacement needed            
        }
        containsSelf = true;
    }

}
