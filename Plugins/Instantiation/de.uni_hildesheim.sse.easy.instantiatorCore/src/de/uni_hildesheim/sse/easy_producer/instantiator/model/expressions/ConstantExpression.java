package de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;

/**
 * Represents a parenthesis expression.
 * 
 * @author Holger Eichelberger
 */
public class ConstantExpression extends Expression {

    private Object value;
    private TypeDescriptor<? extends IVilType> type;
    
    /**
     * Creates a new constant expression.
     * 
     * @param type the type of this constant
     * @param value the assigned value of this constant
     * @param registry the type registry to resolve (local) types
     * @throws ExpressionException in case of type incompatibilities
     */
    public ConstantExpression(TypeDescriptor<? extends IVilType> type, Object value, TypeRegistry registry) 
        throws ExpressionException {
        assert null != type;
        if (null == type) {
            throw new ExpressionException("type must not be null", ExpressionException.ID_INTERNAL); 
        }
        this.type = type;
        this.value = value;
        if (null != value) {
            boolean ok = checkAndConvert(registry.getType(value.getClass().getName()));
            ok |= checkAndConvert(registry.getType(value.getClass().getSimpleName())); // for artifacts
            if (!ok) {
                throw new ExpressionException("type " + type.getName() + " is not compatible to value " + value, 
                    ExpressionException.ID_SEMANTIC); 
            }
        }
    }

    /**
     * Checks the given type for compatibility with {@link #value} and converts value if
     * necessary and possible.
     * 
     * @param checkFor the type to check for (as one of the possible types of {@link #value})
     * @return <code>true</code> if value can be assigned to {@link #type}, <code>false</code> else
     */
    private boolean checkAndConvert(TypeDescriptor<? extends IVilType> checkFor) {
        boolean ok = false;
        if (null != checkFor) {
            if (!type.isAssignableFrom(checkFor)) {
                if (String.class == value.getClass()) {
                    try {
                        if (type == TypeRegistry.booleanType()) {
                            value = Boolean.valueOf((String) value);
                            ok = true;
                        } else if (type == TypeRegistry.integerType()) {
                            value = Integer.valueOf((String) value);
                            ok = true;
                        } else if (type == TypeRegistry.realType()) {
                            value = Double.valueOf((String) value);
                            ok = true;
                        } 
                    } catch (NumberFormatException e) {
                        // conversion not possible ;) don't care as this is optional
                    }
                }
            } else {
                ok = true;
            }
        }
        return ok;
    }
    
    /**
     * Returns the value of this expression. Value complies to {@link #getType()}.
     * 
     * @return the expression
     */
    public Object getValue() {
        return value;
    }

    /**
     * Returns the type of this expression.
     * 
     * @return the type
     */
    public TypeDescriptor<? extends IVilType> getType() {
        return type;
    }

    
    @Override
    public TypeDescriptor<? extends IVilType> inferType() throws ExpressionException {
        return type;
    }

    @Override
    public Object accept(IExpressionVisitor visitor) throws ExpressionException {
        return visitor.visitConstantExpression(this);
    }

}
