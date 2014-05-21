package de.uni_hildesheim.sse.model.cst;

import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.datatypes.Container;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.Operation;
import de.uni_hildesheim.sse.model.varModel.datatypes.TypeQueries;

/**
 * Represents a set operation call with declarators, e.g. a quantor call.
 * Apply and lamda-Expression: For the moment we denote a lambda expression as
 * <code>
 *   setOf(Integer) set;
 *   set->apply(t,r=0|max(t,r))
 * </code>
 * An usual operation is iterated over all elements of the set using the declarator
 * <i>t</i> while the result is collected in <i>r</i> by subsequent
 * application of <i>r=max(t,r)</i> on each <i>t</i> in <i>set</i>.
 * <i>r</i> is returned as result of the lambda expression.
 * 
 * @author Holger Eichelberger
 */
public class ContainerOperationCall extends ConstraintSyntaxTree {
    
    private ConstraintSyntaxTree container;
    private String operation;
    private DecisionVariableDeclaration[] declarators;
    private ConstraintSyntaxTree expression;
    private Operation resolvedOperation; // lazy
    private IDatatype result; // lazy
    
    /**
     * Creates a new let expression.
     * @param container the container to operate on
     * @param operation the name of the operation to be executed
     * @param expression the expression to be iterated (using at least one declarator)
     * @param declarators local variables only used within this expression (at least one) 
     */
    public ContainerOperationCall(ConstraintSyntaxTree container, String operation, 
            ConstraintSyntaxTree expression, DecisionVariableDeclaration... declarators) {
        assert null != container;
        this.container = container;
        assert null != operation;
        this.operation = operation;
        assert null != expression;
        this.expression = expression;
        assert null != declarators && declarators.length > 0;
        this.declarators = declarators;
    }
    
    /**
     * Returns the name of the operation to be executed.
     * 
     * @return the name of the operation
     */
    public String getOperation() {
        return operation;
    }
    
    /**
     * Returns the set to operate on (given as an expression).
     * 
     * @return the set to operate on
     * @deprecated use {@link #getContainer()} instead
     */
    @Deprecated
    public ConstraintSyntaxTree getSet() {
        return container;
    }
    
    /**
     * Returns the set to operate on (given as an expression).
     * 
     * @return the set to operate on
     */
    public ConstraintSyntaxTree getContainer() {
        return container;
    }
    
    /**
     * Returns the iterating expression.
     * 
     * @return the iterating expression
     */
    public ConstraintSyntaxTree getExpression() {
        return expression;
    }
    
    /**
     * Returns the number of declarators.
     * 
     * @return the number of declarators (should be positive)
     */
    public int getDeclaratorsCount() {
        return declarators.length;
    }
    
    /**
     * Returns the specified declarator.
     * 
     * @param index the index of the declarator to return
     * @return the specified declarator
     * @throws IndexOutOfBoundsException if 
     *     <code>index&lt;0 || index&gt;={@link #getDeclaratorsCount()}</code>
     */
    public DecisionVariableDeclaration getDeclarator(int index) {
        return declarators[index];
    }

    /**
     * {@inheritDoc}
     */
    public IDatatype inferDatatype() throws CSTSemanticException {
        if (null == result) {
            //check whether the OCLFeatureCall is semantically correct
            //we need an operation (name) and the data type to call on
            if (null != operation && null != container) {
                IDatatype setType = container.inferDatatype();
                if (setType instanceof Container) {
                    IDatatype contained = ((Container) setType).getContainedType();
                    for (int i = 0; i < declarators.length; i++) {
                        if (!declarators[i].getType().isAssignableFrom(contained)) {
                            throw new CSTSemanticException("type '" + declarators[i].getName()
                                + "' of declarator does not match the contained type of the collection", 
                                CSTSemanticException.TYPE_MISMATCH);
                        }
                    }
                    
                    IDatatype param = expression.inferDatatype(); // typically boolean
                    // just ask the operand for the operation
                    Operation op = TypeQueries.getOperation(setType, operation, param);
                    if (null == op || !op.isContainerOperation()) {
                        throw new UnknownOperationException(operation, 
                            CSTSemanticException.UNKNOWN_OPERATION, setType, param);
                    }
                    result = op.getActualReturnType(setType, param);
                    resolvedOperation = op;
                    // equalparamtypes are not required here as different semantics
                } else {
                    throw new CSTSemanticException("left hand side is not a container", 
                        CSTSemanticException.CONTAINER_OPERATION);
                }
            } else {
                // should not happen
                throw new CSTSemanticException("<internal error>", CSTSemanticException.INTERNAL);
            }
        }
        
        //If no exception is thrown, this OCLFeature call is semantically correct. 
        return result;
    }
    
    /**
     * {@inheritDoc}
     */
    public void accept(IConstraintTreeVisitor visitor) {
        visitor.visitContainerOperationCall(this); // no further operations!
    }

    /**
     * Returns the resolved operation. The result is only valid if
     * {@link #inferDatatype()} was called before this operation.
     * 
     * @return the resolved operation, <b>null</b> if the operation cannot
     *   be resolved or {@link #inferDatatype()} was not called before
     */
    public Operation getResolvedOperation() {
        return resolvedOperation;
    }

}
