package net.ssehub.easy.instantiation.core.model.expressions;

import net.ssehub.easy.basics.modelManagement.Version;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.EnumValue;

/**
 * Represents a parenthesis expression.
 * 
 * @author Holger Eichelberger
 */
public class ConstantExpression extends Expression {

    private Object value;
    private TypeDescriptor<?> type;
    
    /**
     * Creates a new constant expression.
     * 
     * @param type the type of this constant
     * @param value the assigned value of this constant
     * @param registry the type registry to resolve (local) types
     * @throws VilException in case of type incompatibilities
     */
    public ConstantExpression(TypeDescriptor<?> type, Object value, TypeRegistry registry) 
        throws VilException {
        assert null != type;
        if (null == type) {
            throw new VilException("type must not be null", VilException.ID_INTERNAL); 
        }
        this.type = type;
        this.value = value;
        if (null != value) {
            boolean ok;
            if (TypeRegistry.NULL == value) {
                ok = true;
            } else {
                if (value instanceof EnumValue) {
                    ok = checkAndConvert(registry.getType(((EnumValue) value).getDatatype()));
                } else if (value instanceof Version) {
                    ok = checkAndConvert(TypeRegistry.versionType());
                } else {
                    ok = checkAndConvert(registry.getType(value.getClass().getName()));
                    ok |= checkAndConvert(registry.getType(value.getClass().getSimpleName())); // for artifacts
                }
            }
            if (!ok) {
                throw new VilException("type '" + type.getName() + "' is not compatible to value " + value, 
                    VilException.ID_SEMANTIC); 
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
    private boolean checkAndConvert(TypeDescriptor<?> checkFor) {
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
    public TypeDescriptor<?> getType() {
        return type;
    }

    
    @Override
    public TypeDescriptor<?> inferType() throws VilException {
        return type;
    }

    @Override
    public Object accept(IExpressionVisitor visitor) throws VilException {
        return visitor.visitConstantExpression(this);
    }

}
