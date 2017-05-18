/*
 * Copyright 2009-2013 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.varModel.cst;

import java.util.Arrays;

import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.IvmlDatatypeVisitor;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.Container;
import net.ssehub.easy.varModel.model.datatypes.DerivedDatatype;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.OclKeyWords;
import net.ssehub.easy.varModel.model.datatypes.Operation;
import net.ssehub.easy.varModel.model.datatypes.Operation.NestingMode;
import net.ssehub.easy.varModel.model.datatypes.Reference;
import net.ssehub.easy.varModel.model.datatypes.Set;
import net.ssehub.easy.varModel.model.datatypes.TypeQueries;

/**
 * Represents a set operation call with declarators, e.g. a quantor call.
 * Apply and lambda-Expression: For the moment we denote a lambda expression as
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
    private IDatatype iteratorBase; // lazy
    
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
     * Returns the actual container type taking into account that the left
     * side must not be a container but can dynamically be mapped into one.
     * 
     * @return the actual container type
     * @throws CSTSemanticException if types cannot be resolved
     */
    public IDatatype getContainerType() throws CSTSemanticException {
        IDatatype origContainerType = container.inferDatatype();
        IDatatype containerType = DerivedDatatype.resolveToBasis(origContainerType);
        if (!Container.TYPE.isAssignableFrom(containerType)) {
            IDatatype iteratorType = origContainerType; // as "container" is not a container
            if (Compound.TYPE.isAssignableFrom(iteratorType) 
                && null != declarators && declarators.length > 0) {
                IDatatype declType = declarators[0].getType();
                if (null != declType && Reference.isReferenceTo(declType, iteratorType)) {
                    // if there is a declarator with matching reference type, take reference for convenience
                    iteratorType = declType;
                }
            }
            containerType = new Set("", iteratorType, null);
        }
        return containerType;
    }
    
    @Override
    public IDatatype inferDatatype() throws CSTSemanticException {
        if (null == result) {
            //check whether the OCLFeatureCall is semantically correct
            //we need an operation (name) and the data type to call on
            if (null != operation && null != container) {
                IDatatype containerType = getContainerType();
                if (Container.TYPE.isAssignableFrom(containerType)) {
                    iteratorBase = ((Container) containerType).getContainedType();
                    int size = declarators.length;
                    IDatatype param;
                    if (size > 1 && null != declarators[size - 1].getDefaultValue()) {
                        param = declarators[size - 1].getType();
                        size--; // the result value in apply
                        expression.inferDatatype();
                    } else {
                        param = expression.inferDatatype(); // typically boolean
                    }
                    boolean foundResult = size != declarators.length;
                    if ((operation.equals(OclKeyWords.APPLY) || operation.equals(OclKeyWords.ITERATE)) 
                        && !foundResult) {
                        throw new CSTSemanticException("iterate/apply require an initialized return declarator", 
                            CSTSemanticException.DECLARATOR_SEMANTICS);
                    } 
                    
                    // just ask the operand for the operation
                    Operation op = TypeQueries.getOperation(containerType, operation, param);
                    if (null == op || !op.isContainerOperation()) {
                        throw new UnknownOperationException(operation, 
                            CSTSemanticException.UNKNOWN_OPERATION, containerType, param);
                    }
                    // at least the first type must match, allow intermediary temp declarators
                    IDatatype iterType = declarators[0].getType();
                    if (op.getNestingMode() != NestingMode.NONE) {
                        while (Container.TYPE.isAssignableFrom(iteratorBase) 
                            && 1 == iteratorBase.getGenericTypeCount()) {
                            iteratorBase = iteratorBase.getGenericType(0);
                        }
                    }
                    if (!iterType.isAssignableFrom(iteratorBase)) {
                        throw new CSTSemanticException("type '" + IvmlDatatypeVisitor.getUnqualifiedType(iterType)
                            + "' of declarator does not match the contained type of the collection '" 
                            + IvmlDatatypeVisitor.getUnqualifiedType(iteratorBase) + "'", 
                            CSTSemanticException.TYPE_MISMATCH);
                    }
                    result = op.getActualReturnType(containerType, param);
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
    
    @Override
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
    
    @Override
    public boolean equals(Object obj) {
        boolean equals = false;
        if (obj instanceof ContainerOperationCall) {
            ContainerOperationCall other = (ContainerOperationCall) obj;
            equals = operation.equals(other.operation);
            equals &= container.equals(other.container);
            // result hashcode/equals unclear
            equals &= Arrays.equals(declarators, other.declarators);
        }
        return equals;
    }
    
    @Override
    public int hashCode() {
        int hashCode = container.hashCode();
        hashCode *= Arrays.hashCode(declarators);
        hashCode *= operation.hashCode();
        // result hashcode/equals unclear
        return hashCode;
    }

    /**
     * Returns the iterator base type (the type contained in the container we are iterating over).
     * 
     * @return the iterator base type
     */
    public IDatatype getIteratorBaseType() {
        return iteratorBase;
    }

}
