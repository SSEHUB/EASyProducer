package de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel;

import java.util.List;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilLanguageException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.Expression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;

/**
 * Implements a value switch.
 * 
 * @author Holger Eichelberger
 */
public class SwitchStatement implements ITemplateElement {
    
    private Expression switchExpression;
    private Alternative[] alternatives;
    private VariableDeclaration implicitVar;
    
    /**
     * A switch alternative.
     * 
     * @author Holger Eichelberger
     */
    public static class Alternative {
        private Expression condition;
        private Expression value;

        /**
         * Creates the default alternative.
         * 
         * @param value the resulting value
         */
        public Alternative(Expression value) {
            this(null, value);
        }
        
        /**
         * Creates an alternative.
         * 
         * @param condition an expression to be checked against the switch expression
         * @param value the resulting value if the alternative is valid
         */
        public Alternative(Expression condition, Expression value) {
            this.condition = condition;
            this.value = value;
        }
        
        /**
         * Returns the alternative condition.
         * 
         * @return the condition
         */
        public Expression getCondition() {
            return condition;
        }
        
        /**
         * Returns the resulting value if the alternative is considered valid.
         * 
         * @return the value (expression)
         */
        public Expression getValue() {
            return value;
        }
        
        /**
         * Whether this alternative is the default.
         * 
         * @return <code>true</code> if it is the default, <code>false</code> else
         */
        public boolean isDefault() {
            return null == condition;
        }

        /**
         * Infers the type of this alternative based on its value.
         * 
         * @return the type of the alternative
         * @throws ExpressionException in case that type resolution fails
         */
        public TypeDescriptor<? extends IVilType> inferType() throws ExpressionException {
            return value.inferType();
        }

    }

    /**
     * Creates a new switch expression.
     * 
     * @param switchExpression the switch expression
     * @param implicitVar the implicit variable representing the actual value of the switch expression
     * @param alternatives the alternatives in the switch including an optional default alternative
     * @throws VilLanguageException in case of semantic problems while creating this instance
     */
    public SwitchStatement(Expression switchExpression, VariableDeclaration implicitVar, 
        List<Alternative> alternatives) throws VilLanguageException {
        this(switchExpression, implicitVar, toArray(alternatives));
    }
    
    /**
     * Creates a new switch expression.
     * 
     * @param switchExpression the switch expression
     * @param implicitVar the implicit variable representing the actual value of the switch expression
     * @param alternatives the alternatives in the switch including an optional default alternative
     * @throws VilLanguageException in case of semantic problems while creating this instance
     */
    public SwitchStatement(Expression switchExpression, VariableDeclaration implicitVar, Alternative[] alternatives) 
        throws VilLanguageException {
        this.switchExpression = switchExpression;
        this.implicitVar = implicitVar;
        try {
            this.switchExpression.inferType();
        } catch (ExpressionException e) {
            throw new VilLanguageException(e);
        }
        if (null == alternatives || 0 == alternatives.length) {
            throw new VilLanguageException("switch must contain at least on alternative", 
                VilLanguageException.ID_SEMANTIC);
        }
        int dfltCount = 0;
        for (int a = 0; a < alternatives.length; a++) {
            if (alternatives[a].isDefault()) {
                dfltCount++;
            }
        }
        if (dfltCount > 1) {
            throw new VilLanguageException("switch must not contain several defaults", 
                VilLanguageException.ID_SEMANTIC);
        }
        this.alternatives = alternatives;
    }

    /**
     * Transforms the given alternatives into an array.
     * 
     * @param alternatives the alternatives, may be <b>null</b>
     * @return the alternatives as an array, <b>null</b> if the input was <b>null</b>
     */
    public static final Alternative[] toArray(List<Alternative> alternatives) {
        Alternative[] result;
        if (null == alternatives) {
            result = null;
        } else {
            result = new Alternative[alternatives.size()];
            alternatives.toArray(result);
        }
        return result;
    }
    
    /**
     * Returns the switch expression.
     * 
     * @return the switch expression
     */
    public Expression getSwitchExpression() {
        return switchExpression;
    }
    
    /**
     * Get the number of alternatives of this switch statement.
     * 
     * @return The number of alternatives of this switch statement.
     */
    public int getAlternativeCount() {
        return null == alternatives ? 0 : alternatives.length;
    }
    
    /**
     * Get the alternative of this statement at the specified index.
     * 
     * @param index The 0-based index of the alternative to be returned.
     * @return The alternative at the given index.
     * @throws IndexOutOfBoundsException if <code>index &lt; 0 || index &gt;={@link #getAlternativeCount()}</code>
     */
    public Alternative getAlternative(int index) {
        if (null == alternatives) {
            throw new IndexOutOfBoundsException();
        }
        return alternatives[index];
    }
    
    /**
     * Returns the implicit variable defined by this switch statement.
     * 
     * @return the implicit variable
     */
    public VariableDeclaration getImplicitVariable() {
        return implicitVar;
    }

    @Override
    public Object accept(IVisitor visitor) throws VilLanguageException {
        return visitor.visitSwitch(this);
    }
    
    @Override
    public boolean isBlock() {
        return false; // unsure
    }

    @Override
    public TypeDescriptor<? extends IVilType> inferType() throws VilLanguageException {
        try {
            TypeDescriptor<? extends IVilType> result = null;
            for (int a = 0; TypeDescriptor.ANY != result && a < alternatives.length; a++) {
                Alternative alt = alternatives[a];
                TypeDescriptor<? extends IVilType> tmp = alt.inferType();
                if (null == result) {
                    result = tmp;
                } else if (!tmp.equals(result)) {
                    result = TypeDescriptor.ANY;
                }
            }
            return result;
        } catch (ExpressionException e) {
            throw new VilLanguageException(e);
        }
    }

}
