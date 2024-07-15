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

public abstract class JavaCodeVisibleElement implements IJavaCodeElement {

    private boolean isStatic;
    private String name;
    private Visibility visibility;
    private List<JavaCodeAnnotation> annotations;
    private JavaCodeJavadocComment comment;

    protected JavaCodeVisibleElement(String name, Visibility visibility, String comment) {
        this.name = name;
        this.visibility = visibility;
        if (null != comment) {
            this.comment = new JavaCodeJavadocComment(comment, this); 
        }
    }
    
    @OperationMeta(name = {"visibility"})
    public JavaCodeVisibleElement setVisibility(String visibility) {
        this.visibility = Visibility.match(visibility);
        return this;
    }

    @OperationMeta(name = {"visibility"})
    public JavaCodeVisibleElement setVisibility(Visibility visibility) {
        this.visibility = visibility;
        return this;
    }
    
    @OperationMeta(name = {"public"})
    public JavaCodeVisibleElement setPublic() {
        setVisibility(Visibility.PUBLIC);
        return this;
    }

    @OperationMeta(name = {"private"})
    public JavaCodeVisibleElement setPrivate() {
        setVisibility(Visibility.PRIVATE);
        return this;
    }

    @OperationMeta(name = {"protected"})
    public JavaCodeVisibleElement setProtected() {
        setVisibility(Visibility.PROTECTED);
        return this;
    }

    @OperationMeta(name = {"package"})
    public JavaCodeVisibleElement setPackage() {
        setVisibility(Visibility.PACKAGE);
        return this;
    }

    /**
     * Sets this element's static state.
     * 
     * @param isStatic if the element is static
     * @return <b>this</b>
     */
    @OperationMeta(name = {"static"})
    public JavaCodeVisibleElement setStatic(boolean isStatic) {
        this.isStatic = isStatic;
        return this;
    }

    /**
     * Sets this element to static.
     * 
     * @return <b>this</b>
     */
    @OperationMeta(name = {"static"})
    public JavaCodeVisibleElement setStatic() {
        setStatic(true);
        return this;
    }
    
    /**
     * Adds an annotation.
     * 
     * @param type the annotation type, may be fully qualified
     * @return the annotation for further processing
     */
    public JavaCodeAnnotation addAnnotation(String type) {
        if (null == annotations) {
            annotations = new ArrayList<>();
        }
        return IJavaCodeElement.add(annotations, new JavaCodeAnnotation(type, this));
    }

    /**
     * Returns the visibility.
     * 
     * @return the visibility
     */
    @Invisible
    Visibility getVisibility() {
        return visibility;
    }
    
    /**
     * Returns the name.
     * 
     * @return the name of the element
     */
    public String getName() {
        return name;
    }

    /**
     * Returns whether the element is static.
     * 
     * @return {@code true} for static, {@code false} for instance
     */
    public boolean isStatic() {
        return isStatic;
    }
    
    @Invisible
    protected String insertModifier(String text) {
        return text;
    }

    @Invisible
    protected String insertGenerics(String text) {
        return text;
    }

    @Invisible
    protected String getModifier() {
        String result = getVisibility().getPrefix();
        result = insertModifier(result);
        if (isStatic) {
            result += IJavaCodeElement.appendWhitespace(result) +  "static";
        }
        result = insertGenerics(result);
        return IJavaCodeElement.appendWhitespace(result);
    }

    @Invisible
    public void store(CodeWriter out) {
        if (null != comment) {
            comment.store(out);
        }
        if (null != annotations) {
            for (JavaCodeAnnotation a : annotations) {
                a.store(out);
            }
        }
    }
    
    /**
     * Returns the javadoc comment attached to this element.
     * 
     * @return the comment, may be <b>null</b> for none
     */
    public JavaCodeJavadocComment getJavadocComment() {
        return comment;
    }

}
