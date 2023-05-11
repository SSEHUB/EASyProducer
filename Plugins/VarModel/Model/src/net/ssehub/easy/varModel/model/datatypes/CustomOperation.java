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
package net.ssehub.easy.varModel.model.datatypes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.IvmlDatatypeVisitor;

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
    private Map<String, DecisionVariableDeclaration> namedParameters;
    private String[] annotations;
    
    /**
     * Constructor for serialization.
     */ 
    CustomOperation() {
    }
    
    /**
     * Operation Constructor.
     * 
     * @param returns result type of the operation
     * @param methodname name of the operation
     * @param operand the data type the operation is defined for (shall be a project)
     * @param function the operation calculated by this operation
     * @param parameters list of parameters for operation
     */
    public CustomOperation(IDatatype returns, String methodname, IDatatype operand, 
        ConstraintSyntaxTree function, DecisionVariableDeclaration[] parameters) {
        super(returns, methodname, operand, getParameterTypes(parameters));
        this.parameters = parameters;
        this.function = function;
        if (null != parameters) {
            for (int p = 0; p < parameters.length; p++) {
                DecisionVariableDeclaration dvd = parameters[p];
                if (null != dvd.getDefaultValue()) {
                    if (null == namedParameters) {
                        namedParameters = new HashMap<String, DecisionVariableDeclaration>();
                    }
                    namedParameters.put(dvd.getName(), dvd);
                }
            }
        }
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

    @Override
    public ConstraintSyntaxTree getFunction() {
        return function;
    }

    @Override
    public DecisionVariableDeclaration getParameterDeclaration(int index) {
        if (null == parameters) {
            throw new IndexOutOfBoundsException();
        }
        return parameters[index];
    }

    @Override
    public DecisionVariableDeclaration getParameter(String name) {
        DecisionVariableDeclaration result = null == namedParameters ? null : namedParameters.get(name);
        if (null == result) {
            for (int p = 0; null == result && p < getParameterCount(); p++) {
                DecisionVariableDeclaration dvd = getParameterDeclaration(p);
                if (dvd.getName().equals(name)) {
                    result = dvd;
                }
            }
        }
        return result;
    }
    
    @Override
    public int getParameterCount() {
        return null == parameters ? 0 : parameters.length;
    }
    
    @Override
    public int getRequiredParameterCount() {
        int paramCount = getParameterCount();
        return null == namedParameters ? paramCount : paramCount - namedParameters.size();
    }
    
    /**
     * Defines the operation annotations.
     * 
     * @param annotations the annotations
     */
    public void setAnnotations(List<String> annotations) {
        if (null != annotations) {
            this.annotations = annotations.toArray(new String[annotations.size()]);
        }
    }

    /**
     * Returns the number of declared annotations.
     * 
     * @return the number of declared annotations
     */
    public int getAnnotationCount() {
        return null == annotations ? 0 : annotations.length;
    }
    
    /**
     * Returns the specified annotation.
     * 
     * @param index the 0-based index of the annotation
     * @return the specified annotation
     * @throws IndexOutOfBoundsException if no annotations are defined or if the index is not 
     *     in[0;{@link #getAnnotationCount()})
     */
    public String getAnnotation(int index) {
        if (null == annotations) {
            throw new IndexOutOfBoundsException("no annotations defined");
        } else {
            return annotations[index];
        }
    }

    /**
     * Returns whether the operation owns {@code annotation} irrespective of upper/lowercase characters.
     * 
     * @param annotation the annotation to search
     * @return {@code true} for found, {@code true} else
     */
    public boolean hasAnnotation(String annotation) {
        return hasAnnotation(annotations, annotation);
    }
            
    /**
     * Returns whether {@code annotations} contains {@code annotation} irrespective of upper/lowercase characters.
     * 
     * @param annotations the annotations to search within (may be <b>null</b>)
     * @param annotation the annotation to search
     * @return {@code true} for found, {@code true} else
     */
    public static boolean hasAnnotation(String[] annotations, String annotation) {
        boolean found = false;
        if (annotations != null) {
            for (int i = 0; !found && i < annotations.length; i++) {
                found = annotations[i].equalsIgnoreCase(annotation);
            }
        }
        return found;
    }

    @Override
    protected boolean registerAsOperation() {
        return false;
    }

}
