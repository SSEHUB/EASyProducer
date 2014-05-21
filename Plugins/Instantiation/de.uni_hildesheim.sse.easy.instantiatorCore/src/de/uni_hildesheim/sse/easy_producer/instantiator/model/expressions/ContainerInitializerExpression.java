package de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions;

import java.util.ArrayList;
import java.util.List;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.VilException;

/**
 * Represents a container initializer expression consisting of various entries
 * all in the same dimension.
 * 
 * @author Holger Eichelberger
 */
public class ContainerInitializerExpression extends Expression {

    private Expression[] initExpressions;
    private TypeDescriptor<? extends IVilType> type;

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
    
    @Override
    public TypeDescriptor<? extends IVilType> inferType() throws ExpressionException {
        if (null == type) {
            TypeDescriptor<? extends IVilType>[] parameter;
            if (getInitExpressionsCount() > 0) {
                List<TypeDescriptor<? extends IVilType>> params = new ArrayList<TypeDescriptor<? extends IVilType>>();
                Expression first = getInitExpression(0);
                if (first instanceof ContainerInitializerExpression) {
                    ContainerInitializerExpression initEx = (ContainerInitializerExpression) first;
                    for (int e = 0; e < initEx.getInitExpressionsCount(); e++) {
                        params.add(initEx.getInitExpression(e).inferType());
                    }
                } else {
                    params.add(first.inferType());
                }
                parameter = TypeDescriptor.createArray(params.size());
                params.toArray(parameter);
            } else {
                parameter = null;
            }
            try {
                type = TypeRegistry.getSequenceType(parameter); // allow duplicates, map will convert automatically
            } catch (VilException e) {
                throw new ExpressionException(e);
            }
        }
        return type;
    }

    @Override
    public Object accept(IExpressionVisitor visitor) throws ExpressionException {
        return visitor.visitContainerInitializerExpression(this);
    }

}
