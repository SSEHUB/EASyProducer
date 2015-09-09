/*
 * Copyright 2009-2015 University of Hildesheim, Software Systems Engineering
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
package de.uni_hildesheim.sse.easy.java.artifacts;

import java.util.List;

import org.eclipse.jdt.core.dom.ClassInstanceCreation;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.ExpressionStatement;
import org.eclipse.jdt.core.dom.ITypeBinding;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.ArtifactModel;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Invisible;

/**
 * Represents an assignment expression within a method.
 * @author El-Sharkawy
 *
 */
public class JavaAssignment extends AbstractJavaStatement {

    /**
     * The type of the RHS represented (qualified name), i.e. from which <b>TYPE</b> it is assigned <b>from</b>.
     * For instance in
     * <code>
     * Object obj = new String();
     * </code>
     * fromType would be <tt>java.lang.String</tt>.
     */
    private String fromType;
    
    private List<?> arguments;
    /**
     * Constructor for this class if on the right hand side is a constructor call.
     * @param parent The parent of this artifact.
     * @param expression The Statement expression, which may be edited.
     * @param attributeName then name of the attribute as string
     * @param typeBinding The type of the LHS (qualified name),
     *     i.e. to which <b>TYPE</b> it is assigned <b>TO</b>.
     * @param rhs The creation of the assignment of the right hand side (a constructor call).
     */
    JavaAssignment(IJavaParent parent, ExpressionStatement expression, String attributeName, ITypeBinding typeBinding, 
        ClassInstanceCreation rhs) {
        super(parent, expression, attributeName, typeBinding);
        if (null != rhs) {
            ITypeBinding rhsBinding = rhs.resolveTypeBinding();
            arguments = rhs.arguments();
            if (null != rhsBinding) {
                this.fromType = (null != rhs && null != rhsBinding) ? rhsBinding.getQualifiedName() : null;
            }
        }
    }
    
    /**
     * Returns the number of parameters.
     * @return 0 if it has no parameters or the number of parameters.
     */
    int parameterCount() {
        return null != arguments ? arguments.size() : 0;
    }
    
    /**
     * The parameter type at the specified index.
     * @param index A 0-based index.
     * @return The parameter type.
     */
    String getParamType(int index) {
        return ((Expression) arguments.get(index)).resolveTypeBinding().getName();
    }
    
    /**
     * Returns the full qualified name of the assigned element.
     * For instance in
     * <code>
     * Object obj = new String();
     * </code>
     * getFromType would be <tt>java.lang.String</tt>.
     * @return The qualified name of the element which stays on RHS.
     */
    public String getFromType() {
        return fromType;
    }
    
    /**
     * Returns the assignment as String, for debugging only.
     */
    @Override
    public String toString() {
        return "" + getType() + " " + getNameSafe() + " = " + fromType;
    }

    @Invisible
    @Override
    public ArtifactModel getArtifactModel() {
        return getParent().getArtifactModel();
    }

}
