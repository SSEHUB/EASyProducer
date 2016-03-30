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
package net.ssehub.easy.instantiation.java.artifacts;

import org.eclipse.jdt.core.dom.ExpressionStatement;
import org.eclipse.jdt.core.dom.ITypeBinding;

import net.ssehub.easy.instantiation.core.model.artifactModel.IArtifactVisitor;
import net.ssehub.easy.instantiation.core.model.artifactModel.representation.Binary;
import net.ssehub.easy.instantiation.core.model.artifactModel.representation.Text;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;

/**
 * Super class for nested elements of a {@link JavaMethod}.
 * Should not be visible in VIL, thus, do not register this class.
 * @author El-Sharkawy
 *
 */
abstract class AbstractJavaStatement extends JavaParentFragmentArtifact {

    private String attributeName;
    private ExpressionStatement expression;
    private String binding;
    private String qualifiedName;
    
    /**
     * Default constructor of this class.
     * @param parent The parent of this artifact.
     * @param expression The Statement expression, which may be edited.
     * @param attributeName The name of the statement.
     * @param typeBinding The type of the binding
     */
    AbstractJavaStatement(IJavaParent parent, ExpressionStatement expression, String attributeName,
        ITypeBinding typeBinding) {
        super(parent);
        this.expression = expression;
        this.attributeName = attributeName;
        this.binding = typeBinding.getName();
        this.qualifiedName = typeBinding.getQualifiedName();
    }

    @Override
    public void delete() throws VilException {
        try {
            expression.delete();
            super.delete();
        } catch (IllegalArgumentException e) {
            throw new VilException("Cannot delete \"" + attributeName + "\" from "
                + ((JavaMethod) getParent()).getNameSafe() + ".", VilException.ID_WHILE_INSTANTIATION);
        }
    }
    
    @Override
    public String getName() throws VilException {
        return attributeName;
    }

    @Override
    public void rename(String name) throws VilException {
    }
    
    /**
     * Returns the qualified name represented as string.
     * @return qualified name as string
     */
    public String getQualifiedName() {
        return qualifiedName;
    }

    /**
     * Returns the type of the call represented as string.
     * 
     * @return type as string
     */
    public String getType() {
        return binding;
    }
    
    @Override
    public Text getText() throws VilException {
        return Text.CONSTANT_EMPTY;
    }

    @Override
    public Binary getBinary() throws VilException {
        return Binary.CONSTANT_EMPTY;
    }
    
    @Override
    public void accept(IArtifactVisitor visitor) {
        visitor.visitFragmentArtifact(this);
    }
    
    @Invisible
    @Override
    public String getStringValue(StringComparator comparator) {
        return "call '" + getNameSafe() + "'";
    }

}
