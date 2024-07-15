/*
 * Copyright 2009-2024 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.instantiation.java.codeArtifacts;

import java.util.ArrayList;
import java.util.List;

import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;
import net.ssehub.easy.instantiation.core.model.vilTypes.OperationMeta;
import net.ssehub.easy.instantiation.java.codeArtifacts.JavaCodeClass.Kind;

public class JavaCodeMethod extends JavaCodeAbstractVisibleElement {

    private JavaCodeTypeSpecification type;
    private JavaCodeClass enclosing;
    private List<IJavaCodeElement> elements = new ArrayList<>();
    private List<JavaCodeParameterSpecification> parameter;
    private List<JavaCodeTypeSpecification> exceptions;

    protected JavaCodeMethod(String name, JavaCodeClass enclosing) {
        this(JavaCodeTypeSpecification.VOID, name, enclosing);
    }

    protected JavaCodeMethod(JavaCodeTypeSpecification type, String name, JavaCodeClass enclosing) {
        this(type, name, enclosing, null);
    }

    protected JavaCodeMethod(JavaCodeTypeSpecification type, String name, JavaCodeClass enclosing, String comment) {
        super(name, Visibility.PUBLIC, comment);
        this.enclosing = enclosing;
        this.type = type;
    }

    @Invisible
    public IJavaCodeArtifact getArtifact() {
        return enclosing.getArtifact();
    }
    
    @Invisible
    public JavaCodeClass getEnclosing() {
        return enclosing;
    }

    /**
     * Adds a (formal) method parameter.
     * 
     * @param type the type of the parameter
     * @param name the name of the parameter
     * @return the parameter instance
     */
    public JavaCodeParameterSpecification addParameter(String type, String name) {
        return addParameter(type, name, null);
    }

    /**
     * Adds a (formal) method parameter.
     * 
     * @param type the type of the parameter
     * @param name the name of the parameter
     * @param comment the Javadoc comment to be linked to this parameter (just the text)
     * @return the parameter instance
     */
    public JavaCodeParameterSpecification addParameter(String type, String name, String comment) {
        if (null == parameter) {
            parameter = new ArrayList<>();
        }
        if (null != comment && getJavadocComment() != null) {
            getJavadocComment().addParameterComment(name, comment);
        }
        return IJavaCodeElement.add(parameter, new JavaCodeParameterSpecification(type, name, this));
    }

    public JavaCodeTypeSpecification addException(String type) {
        return addException(type, null);
    }

    public JavaCodeTypeSpecification addException(String type, String comment) {
        if (null == exceptions) {
            exceptions = new ArrayList<>();
        }
        if (null != comment && getJavadocComment() != null) {
            getJavadocComment().addExceptionComment(type, comment);
        }
        return IJavaCodeElement.add(exceptions, new JavaCodeTypeSpecification(type, getEnclosing()));
    }

    /**
     * Adds text and indents it.
     * 
     * @param text the text
     */
    public void add(String text) {
        elements.add(new JavaCodeText(text, true));
    }
    
    /**
     * Adds text without indentation/pre-indended.
     * 
     * @param text the text
     */
    public void addRaw(String text) {
        elements.add(new JavaCodeText(text, false));
    }
    
    @Invisible
    @Override
    public void store(CodeWriter out) {
        super.store(out); // comment, annotations
        out.printwi(getModifier());
        type.store(out);
        out.print(" ");
        out.print(getName());
        out.print("(");
        IJavaCodeElement.storeList(parameter, ", ", out);
        out.print(")");
        IJavaCodeElement.storeList(" ", exceptions, ", ", out);
        if (!isAbstract() || enclosing.getKind() == Kind.INTERFACE) {
            out.println(" {");
            out.increaseIndent();
            for (IJavaCodeElement attr: elements) {
                attr.store(out);
            }
            out.decreaseIndent();
            out.printlnwi("}");
        } else {
            out.println(";");
        }
    }

    @Override
    public String getStringValue(StringComparator comparator) {
        return "JavaMethod: " + getName();
    }
    
    @Override
    @OperationMeta(name = {"visibility"})
    public JavaCodeMethod setVisibility(String visibility) {
        super.setVisibility(visibility);
        return this;
    }

    @Override
    @OperationMeta(name = {"visibility"})
    public JavaCodeMethod setVisibility(Visibility visibility) {
        super.setVisibility(visibility);
        return this;
    }
    
    @Override
    @OperationMeta(name = {"public"})
    public JavaCodeMethod setPublic() {
        super.setPublic();
        return this;
    }

    @Override
    @OperationMeta(name = {"private"})
    public JavaCodeMethod setPrivate() {
        super.setPrivate();
        return this;
    }

    @Override
    @OperationMeta(name = {"protected"})
    public JavaCodeMethod setProtected() {
        super.setProtected();
        return this;
    }

    @Override
    @OperationMeta(name = {"package"})
    public JavaCodeMethod setPackage() {
        super.setPackage();
        return this;
    }

    @Override
    @OperationMeta(name = {"static"})
    public JavaCodeMethod setStatic(boolean isStatic) {
        super.setStatic(isStatic);
        return this;
    }

    @OperationMeta(name = {"static"})
    @Override
    public JavaCodeMethod setStatic() {
        super.setStatic();
        return this;
    }

}
