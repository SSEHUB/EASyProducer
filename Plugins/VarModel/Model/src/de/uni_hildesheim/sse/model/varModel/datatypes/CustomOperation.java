package de.uni_hildesheim.sse.model.varModel.datatypes;

import de.uni_hildesheim.sse.model.cst.CSTSemanticException;
import de.uni_hildesheim.sse.model.cst.ConstraintSyntaxTree;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.IvmlDatatypeVisitor;

/**
 * Represents a custom operation as defined in the IVML model. Not that
 * currently custom operations are <b>not</b> generic and that the operand needs to be
 * the holder of the custom operation, i.e. the project in order to support empty parameter
 * lists.
 * 
 * @author Holger Eichelberger
 */
public class CustomOperation extends Operation {

    private ConstraintSyntaxTree function;
    private DecisionVariableDeclaration[] parameters;
    
    /**
     * Operation Constructor.
     * 
     * @param returns result type of the operation
     * @param methodname name of the operation
     * @param operant the data type the operation is defined for (shall be a project)
     * @param function the operation calculated by this operation
     * @param parameters list of parameters for operation
     */
    public CustomOperation(IDatatype returns, String methodname, IDatatype operant, 
            ConstraintSyntaxTree function, DecisionVariableDeclaration[] parameters) {
        super(returns, methodname, operant, getParameterTypes(parameters));
        this.parameters = parameters;
        this.function = function;
    }

    /**
     * Changes the function determining the implementation of this custom operation.
     * <code>function</code> may refer to the parameters of this custom operation.
     * 
     * @param function the new function
     * @throws CSTSemanticException in case that the return type does not comply to 
     *   the function
     */
    public void setFunction(ConstraintSyntaxTree function) throws CSTSemanticException {
        IDatatype fType = function.inferDatatype();
        if (!getReturns().isAssignableFrom(fType)) {
            throw new CSTSemanticException("type of implementation expression '" 
                + IvmlDatatypeVisitor.getQualifiedType(fType) + " does not comply to return type '" 
                + IvmlDatatypeVisitor.getQualifiedType(getReturns()) + "'.", 
                CSTSemanticException.TYPE_MISMATCH);
        }
        this.function = function;
    }
    
    /**
     * Returns the datatypes of the parameter declarations.
     * @param decl the parameter declarations (may be <b>null</b>)
     * @return the datatypes (<b>null</b> if <code>decl</code> is null)
     */
    private static IDatatype[] getParameterTypes(DecisionVariableDeclaration[] decl) {
        IDatatype[] result;
        if (null == decl) {
            result = null;
        } else {
            result = new IDatatype[decl.length];
            for (int d = 0; d < decl.length; d++) {
                result[d] = decl[d].getType();
            }
        }
        return result;
    }

    /**
     * Returns the function expression calculated by this operation.
     * 
     * @return the function operation
     */
    @Override
    public ConstraintSyntaxTree getFunction() {
        return function;
    }
    
    /**
     * Returns the parameter at position <code>index</code>.
     * 
     * @param index a 0-based index denoting the parameter 
     *   to be returned
     * @return the specified parameter
     * 
     * @throws IndexOutOfBoundsException if 
     *   <code>index&lt;0 || index&gt;={@link #getParameterCount()}</code>
     */
    public DecisionVariableDeclaration getParameterDeclaration(int index) {
        if (null == parameters) {
            throw new IndexOutOfBoundsException();
        }
        return parameters[index];
    }
    
    /**
     * Returns the number of parameters.
     * 
     * @return the number of parameters
     */
    public int getParameterCount() {
        return null == parameters ? 0 : parameters.length;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean registerAsOperation() {
        return false;
    }

}
