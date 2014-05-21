package de.uni_hildesheim.sse.model.cst;

import de.uni_hildesheim.sse.model.varModel.IvmlDatatypeVisitor;
import de.uni_hildesheim.sse.model.varModel.datatypes.Container;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;

/**
 * Represents an initializer for containers. This initializer may contain expressions for initializing container 
 * entries. IVML: <code>{<i>expression</i>, ...}</code>. We need a special constraint tree node for this purpose as 
 * values form {@link de.uni_hildesheim.sse.model.varModel.values} are intended to be constants and, thus, cannot 
 * contain arbitrary expressions.
 * 
 * @author Holger Eichelberger
 */
public class ContainerInitializer extends ConstraintSyntaxTree {

    private Container type;
    private ConstraintSyntaxTree[] expressions;

    /**
     * Creates a new container initializer. 
     * 
     * @param type the type of the compound
     * @param expressions the initializing expressions (in sequence for containers which support sequences)
     * @throws CSTSemanticException in case that the initialization fails, element type mismatch
     */
    public ContainerInitializer(Container type, ConstraintSyntaxTree[] expressions) throws CSTSemanticException {
        this.type = type;
        this.expressions = expressions;
        if (null == expressions) {
            throw new CSTSemanticException("expressions is null", CSTSemanticException.INTERNAL);
        }
        IDatatype containedType = type.getContainedType();
        for (int e = 0; e < expressions.length; e++) {
            IDatatype eType = expressions[e].inferDatatype();
            if (!containedType.isAssignableFrom(eType)) {
                throw new CSTSemanticException("value " + e + " in initializer is of type '" 
                    + IvmlDatatypeVisitor.getQualifiedType(eType) + "' but not of expected type '" 
                    + IvmlDatatypeVisitor.getQualifiedType(containedType) + "'", CSTSemanticException.TYPE_MISMATCH);
            }
        }
    }

    /**
     * Returns the type of the container.
     * 
     * @return the type of the container
     */
    public Container getType() {
        return type;
    }
    
    /**
     * Returns the number of expressions.
     * 
     * @return the number of expressions
     */
    public int getExpressionCount() {
        return expressions.length;
    }
    
    /**
     * Returns the specified expression.
     * 
     * @param index the index of the expression to be returned
     * @return the specified expression
     * @throws IndexOutOfBoundsException if <code>index &lt; 0 || index &gt;={@link #getExpressionCount()}</code>
     */
    public ConstraintSyntaxTree getExpression(int index) {
        return expressions[index];
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(IConstraintTreeVisitor visitor) {
        visitor.visitContainerInitializer(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IDatatype inferDatatype() throws CSTSemanticException {
        return type;
    }

}
