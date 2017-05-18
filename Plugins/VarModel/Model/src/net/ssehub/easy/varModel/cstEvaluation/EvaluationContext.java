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
package net.ssehub.easy.varModel.cstEvaluation;

import java.text.Collator;
import java.util.Locale;

import net.ssehub.easy.basics.messages.Status;
import net.ssehub.easy.varModel.confModel.IAssignmentState;
import net.ssehub.easy.varModel.confModel.IConfiguration;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.values.ReferenceValue;
import net.ssehub.easy.varModel.model.values.Value;

/**
 * Some basic functionality required by the evaluators without exposing the {@link EvaluationVisitor}.
 *   
 * @author Holger Eichelberger
 */
public abstract class EvaluationContext implements IConfiguration {
    
    public static final Locale INITIAL_LOCALE = new Locale("en", "us");
    private static Locale defaultLocale = INITIAL_LOCALE;
    private Locale locale = defaultLocale;

    /**
     * Changes the default locale for evaluation.
     * 
     * @param locale the new locale, ignored if <b>null</b>
     */
    public static void setDefaultLocale(Locale locale) {
        if (null != locale)  {
            defaultLocale = locale;
        }
    }

    /**
     * Returns the default locale for evaluation.
     * 
     * @return the locale
     */
    public static Locale getDefaultLocale() {
        return defaultLocale;
    }
    
    /**
     * Returns the actual locale for evaluation.
     * 
     * @return the locale
     */
    public Locale getLocale() {
        return locale;
    }
    
    /**
     * Changes the locale for evaluation.
     * 
     * @param locale the new locale, ignored if <b>null</b>
     */
    public void setLocale(Locale locale) {
        if (null != locale) {
            this.locale = locale;
        }
    }

    /**
     * Returns the collator corresponding to the actual locale of this context.
     * 
     * @return the collator
     */
    public Collator getCollator() {
        return Collator.getInstance(getLocale());
    }
    
    /**
     * Returns whether values shall be assigned, i.e., the configuration may be changed.
     * 
     * @return <code>true</code> if values shall be assigned, <code>false</code> else
     */
    public abstract boolean allowAssignValues();
    
    /**
     * Notifies the change listener, i.e., the value of <code>variable</code> has changed.
     * 
     * @param variable the changed variable
     */
    public abstract void notifyChangeListener(IDecisionVariable variable);

    /**
     * Adds an evaluation message.
     * 
     * @param message the message to be added
     */
    public abstract void addMessage(EvaluationVisitor.Message message);

    /**
     * Returns the target state of the evaluation for <code>variable</code>.
     * 
     * @param variable the variable to return the target state for (do not modify!!!)
     * @return the target state (may be <b>null</b> if the actual value cannot be 
     *   assigned do to a state conflict)
     */
    public abstract IAssignmentState getTargetState(IDecisionVariable variable);
    
    /**
     * Adds an evaluation error message.
     * 
     * @param message the message to be added
     */
    public void addErrorMessage(String message) {
        addErrorMessage(message, null);
    }
    
    /**
     * Adds an evaluation error message.
     * 
     * @param message the message to be added
     * @param variable Optional {@link IDecisionVariable} which caused the error
     */
    public void addErrorMessage(String message, IDecisionVariable variable) {
        addMessage(new EvaluationVisitor.Message(message, Status.ERROR, variable));
    }

    /**
     * Adds an evaluation error message based on a throwable.
     * 
     * @param throwable the throwable carrying the message
     */
    public void addErrorMessage(Throwable throwable) {
        addErrorMessage(throwable.getMessage());
    }
    
    /**
     * Indicates that the evaluation of this constraint shall lead to a warning.
     */
    public abstract void issueWarning();
    
    /**
     * Returns whether the expression to be evaluated is a propagation.
     * 
     * @return <code>true</code> if it is a propagation, i.e. propagation shall be allowed, <code>false</code> else
     */
    public abstract boolean allowPropagation();

    /**
     * Dereferences a value within this context.
     * 
     * @param value the value to dereference
     * @return the dereferenced value (may be <b>null</b> if undefined)
     */
    public Value getDereferencedValue(Value value) {
        Value dereferencedValue = value;
        if (null != dereferencedValue && dereferencedValue instanceof ReferenceValue) {
            AbstractVariable referredDecl = ((ReferenceValue) dereferencedValue).getValue();
            if (null != referredDecl) {
                IDecisionVariable var = getDecision(referredDecl);
                if (null != var && null != var.getValue()) {
                    dereferencedValue = var.getValue();
                }
            } else {
                ConstraintSyntaxTree refExpression = ((ReferenceValue) dereferencedValue).getValueEx();
                EvaluationVisitor evalVisitor = new EvaluationVisitor(this, null, false, null);
                refExpression.accept(evalVisitor);
                if (!evalVisitor.constraintFailed()) {
                    dereferencedValue = evalVisitor.getResult();
                }
            }
        }
        return dereferencedValue;
    }

}
