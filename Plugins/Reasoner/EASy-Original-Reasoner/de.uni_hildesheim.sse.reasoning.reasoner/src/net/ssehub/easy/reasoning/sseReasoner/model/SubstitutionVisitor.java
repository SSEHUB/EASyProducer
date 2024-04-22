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

import net.ssehub.easy.varModel.cst.AttributeVariable;
import net.ssehub.easy.varModel.cst.BasicCopyVisitor;
import net.ssehub.easy.varModel.cst.Comment;
import net.ssehub.easy.varModel.cst.CompoundAccess;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.cst.DeferInitExpression;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;
import net.ssehub.easy.varModel.cst.Self;
import net.ssehub.easy.varModel.cst.Variable;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.Attribute;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.IAttributableElement;
import net.ssehub.easy.varModel.model.IvmlKeyWords;

/**
 * Substitutes variables in a constraint syntax tree by copying the syntax tree. May be 
 * reused after calling {@link #clear()}. {@link #addVariableMapping(AbstractVariable, Variable)}
 * takes precedence over {@link #setMappings(ContextStack)}.
 * 
 * @author Sizonenko
 * @author Holger Eichelberger
 */
public class SubstitutionVisitor extends BasicCopyVisitor {

    private Map<AbstractVariable, ConstraintSyntaxTree> mapping;
    private ContextStack globalMapping;
    private ConstraintSyntaxTree selfEx;
    private AbstractVariable self;
    private boolean containsSelf;
    private ConstraintSyntaxTree excludeFromMapping;

    /**
     * Creates a copy visitor without mapping.
     */
    public SubstitutionVisitor() {
        this(null);
    }
    
    /**
     * Creates a copy visitor with explicit mapping.
     * 
     * @param globalMapping a mapping from variable declarations to new access expressions,
     *   existing variable declarations are taken over if no mapping is given, may be <b>null</b>
     *   in case of no mapping at all
     * @see #setMappings(ContextStack)
     */
    public SubstitutionVisitor(ContextStack globalMapping) {
        // setCopyVariables not needed as overridden anyway
        setDoInferDatatype(false);
        setCopyConstants(false); 
        setCopyExpressions(false);
        setMappings(globalMapping);
    }  

    /**
     * Sets the mapping. [init, reuse]
     * 
     * @param globalMapping a mapping from variable declarations to new access expressions,
     *   existing variable declarations are taken over if no mapping is given, may be <b>null</b>
     *   in case of no mapping at all
     */
    public void setMappings(ContextStack globalMapping) {
        this.globalMapping = globalMapping;
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
        globalMapping = null;
        selfEx = null;
        self = null;
        excludeFromMapping = null;        
        clearVariableMapping();
    }
    
    /**
     * Adds a variable mapping to be considered during substitution. Takes precedence over 
     * {@link #setMappings(ContextStack)}. If a variable mapping is defined by {@link #setMappings(ContextStack)}, 
     * potential transitive mappings of <code>dest</code>
     * are considered and instead of <code>orig</code>-<code>dest</code>, a mapping from <code>orig</code> to the 
     * transitive value is registered.
     * 
     * @param orig the original variable to be replaced (may be <b>null</b>, ignored)
     * @param dest the destination variable to replace <code>orig</code> (may be <b>null</b>, ignored)
     * @param derefCount the number of refBy operations to apply to the expression refering to <code>dest</code>
     * @return <b>this</b>
     */
    public SubstitutionVisitor addVariableMapping(AbstractVariable orig, AbstractVariable dest, int derefCount) {
        ConstraintSyntaxTree destEx = null;
        if (null != globalMapping) { // allow for transitive substitution saving unneeded variables
            ConstraintSyntaxTree ca = globalMapping.getMapping(dest);
            if (null != ca) {
                destEx = ca;
            }
        }
        if (null == destEx) {
            if (dest instanceof Attribute) {
                Attribute att = (Attribute) dest;
                IAttributableElement elt = att.getElement();
                ConstraintSyntaxTree qualifier = null;
                if (elt instanceof DecisionVariableDeclaration) {
                    qualifier = new Variable((DecisionVariableDeclaration) elt);
                }
                destEx = new AttributeVariable(qualifier, (Attribute) dest);
            } else {
                destEx = new Variable(dest);
            }
        }
        if (null != orig) {
            for (int d = 1; d <= derefCount; d++) {
                destEx = new OCLFeatureCall(destEx, IvmlKeyWords.REFBY);
            }
            addVariableMapping(orig, destEx);
        }
        return this;
    }
    
    /**
     * Adds a variable mapping to be considered during substitution. Takes precedence over 
     * {@link #setMappings(ContextStack)}.
     * 
     * @param orig the original variable to be replaced (may be <b>null</b>, ignored)
     * @param ex the expression to replace <code>orig</code>
     * @return <b>this</b>
     */
    public SubstitutionVisitor addVariableMapping(AbstractVariable orig, ConstraintSyntaxTree ex) {
        if (null == mapping) {
            mapping = new HashMap<AbstractVariable, ConstraintSyntaxTree>();
        }
        mapping.put(orig, ex);
        return this;
    }

    /**
     * Clears the mapping for a given variable.
     * 
     * @param var the variable to clear the mapping for (may be <b>null</b>, ignored)
     * @return <b>this</b>
     */
    public SubstitutionVisitor clearVariableMapping(AbstractVariable var) {
        if (null != mapping && null != var) {
            mapping.remove(var);
        }
        return this;
    }

    /**
     * Clears the entire variable mapping.
     * @return <b>this</b>
     */
    public SubstitutionVisitor clearVariableMapping() {
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
    public SubstitutionVisitor setSelf(ConstraintSyntaxTree selfEx) {
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
    public SubstitutionVisitor setSelf(AbstractVariable self) {
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
    public void visitAnnotationVariable(AttributeVariable variable) {
        ConstraintSyntaxTree result;
        if (variable.getQualifier() != null) {
            result = variable;
        } else {
            result = map(variable);
        }
        if (null == result || result == variable) {
            // nothing happened, it might be a deep translation
            super.visitAnnotationVariable(variable);
        } else {
            setResult(result);
        }
    }

    @Override
    public void visitVariable(Variable variable) {
        setResult(map(variable));
    }

    /**
     * Maps a variable to its accessor expression.
     * 
     * @param variable the variable to map
     * @return the accessor expression, may be <b>null</b>
     */
    private ConstraintSyntaxTree map(Variable variable) {
        ConstraintSyntaxTree res = null;
        if (variable != excludeFromMapping) {
            if (null != mapping) {
                res = mapping.get(variable.getVariable());
            }
            if (null == res) {
                ConstraintSyntaxTree tmp = 
                    null == globalMapping ? null : globalMapping.getMapping(variable.getVariable());
                if (null != tmp) {
                    res = inferDatatype(tmp);
                }
            }
        }
        if (null == res) {
            res = variable;
        }
        return res;
    }

    /**
     * Excludes the given expression from mapping, e.g., if the expression is an already complete accessor expression
     * and a mapping would be based on a previously registered (incorrect) mapping.
     * Comparison is done by reference.
     * 
     * @param cst the expression to exclude, may be <b>null</b> for no exclude
     */
    public void excludeFromMapping(ConstraintSyntaxTree cst) {
        this.excludeFromMapping = cst;
    }

    @Override
    public void visitCompoundAccess(CompoundAccess access) {
        super.visitCompoundAccess(access);
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
    
    /**
     * Visits a default init expression.
     * 
     * @param expression the expression
     */
    public void visitDeferInitExpression(DeferInitExpression expression) {
        expression.getExpression().accept(this); // force evaluation
    }

}
