package de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions;

import java.util.ArrayList;
import java.util.List;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;

/**
 * Represents a container initializer expression consisting of various entries
 * all in the same dimension.
 * 
 * @author Holger Eichelberger
 */
public class ContainerInitializerExpression extends Expression {

    private Expression[] initExpressions;
    private TypeDescriptor<?> type;

    /**
     * Creates a new empty container initializer expression.
     */
    public ContainerInitializerExpression() {
        this(null);
    }

    /**
     * Creates a new empty container initializer expression. Currently, this 
     * constructor expects that the input is valid (appropriate dimensions)
     * 
     * @param initExpressions the initializer expressions, either logical expressions
     *   or container initializer expression
     */
    public ContainerInitializerExpression(Expression[] initExpressions) {
        this.initExpressions = initExpressions;
    }
    
    /**
     * Internal constructor for set initialization.
     * 
     * @param initExpressions the initializer expressions, either logical expressions
     *   or container initializer expression
     * @param type the type of the expression
     */
    private ContainerInitializerExpression(Expression[] initExpressions, TypeDescriptor<?> type) {
        this.initExpressions = initExpressions;
        this.type = type;
    } 
    
    /**
     * Returns the specified initializer expression.
     * 
     * @param index the index of the specified expression
     * @return the specified expression
     * @throws IndexOutOfBoundsException if <code>index &lt; 0 || index &gt;= {@link #getInitExpressionsCount()}</code>
     */
    public Expression getInitExpression(int index) {
        return initExpressions[index];
    }

    /**
     * Returns the number of initializer expressions.
     * 
     * @return the number of initializer expressions
     */
    public int getInitExpressionsCount() {
        return null == initExpressions ? 0 : initExpressions.length;
    }
    
    /**
     * Returns the more common type.
     * 
     * @param t1 the first type
     * @param t2 the second type
     * @return the more common type or "Any"
     */
    private static  TypeDescriptor<?> moreCommon(TypeDescriptor<?> t1, 
        TypeDescriptor<?> t2) {
        TypeDescriptor<?> result;
        if (t1.isAssignableFrom(t2)) {
            result = t1;
        } else if (t2.isAssignableFrom(t1)) {
            result = t2;
        } else {
            result = TypeRegistry.anyType();
        }
        return result;
    }
    
    @Override
    public TypeDescriptor<?> inferType() throws VilException {
        if (null == type) {
            TypeDescriptor<?>[] parameter;
            if (getInitExpressionsCount() > 0) {
                List<TypeDescriptor<?>> params = new ArrayList<TypeDescriptor<?>>();
                List<TypeDescriptor<?>> local = new ArrayList<TypeDescriptor<?>>();
                for (int e = 0; e < getInitExpressionsCount(); e++) {
                    Expression ex = getInitExpression(e);
                    local.clear();
                    if (ex instanceof ContainerInitializerExpression) {
                        ContainerInitializerExpression initEx = (ContainerInitializerExpression) ex;
                        for (int i = 0; i < initEx.getInitExpressionsCount(); i++) {
                            local.add(initEx.getInitExpression(i).inferType());
                        }
                    } else {
                        local.add(ex.inferType());
                    }
                    if (0 == e) {
                        params.addAll(local);
                    } else {
                        if (params.size() != local.size()) {
                            throw new VilException("parameter size does not match", 
                                VilException.ID_SEMANTIC);
                        } else {
                            for (int p = 0; p < params.size(); p++) {
                                params.set(p, moreCommon(params.get(p), local.get(p)));
                            }
                        }
                    }
                }
                parameter = TypeDescriptor.createArray(params.size());
                params.toArray(parameter);
            } else {
                parameter = null;
            }
            type = TypeRegistry.getSequenceType(parameter); // allow duplicates, map will convert automatically
        }
        return type;
    }

    @Override
    public Object accept(IExpressionVisitor visitor) throws VilException {
        return visitor.visitContainerInitializerExpression(this);
    }
    
    /**
     * Converts this container initializer to a set.
     * 
     * @return the corresponding set initializer
     * @throws VilException in case that conversion fails
     */
    public ContainerInitializerExpression toSet() throws VilException {
        TypeDescriptor<?>[] parameter;
        parameter = TypeDescriptor.createArray(type.getGenericParameterCount());
        for (int p = 0; p < parameter.length; p++) {
            parameter[p] = type.getGenericParameterType(p);
        }
        return new ContainerInitializerExpression(initExpressions, TypeRegistry.getSetType(parameter));
    }

}
