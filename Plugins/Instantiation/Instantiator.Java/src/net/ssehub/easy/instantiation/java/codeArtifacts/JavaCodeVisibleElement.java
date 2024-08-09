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

/**
 * Potentially visible code element.
 * 
 * @author Holger Eichelberger
 */
public abstract class JavaCodeVisibleElement extends JavaCodeElement {

    private boolean isStatic;
    private String name;
    private JavaCodeVisibility visibility;
    private List<JavaCodeAnnotation> annotations;
    private JavaCodeJavadocComment comment;

    /**
     * Creates an element.
     * 
     * @param name the element name
     * @param visibility the visibility
     * @param comment the optional comment for this element, may be <b>null</b>
     */
    protected JavaCodeVisibleElement(String name, JavaCodeVisibility visibility, String comment) {
        super(null);
        this.name = name;
        this.visibility = visibility;
        if (null != comment) {
            ensureJavadocComment(comment);
        }
    }

    /**
     * Ensures that this element has a comment.
     * 
     * @param comment the comment text, may be empty
     */
    protected void ensureJavadocComment(String comment) {
        if (null == this.comment) {
            this.comment = new JavaCodeJavadocComment(comment, this); 
        }
    }

    @Override
    public boolean hasJavadocComment() {
        return comment != null;
    }

    /**
     * Changes the visibility.
     * 
     * @param visibility the new visibility using Java or UML keywords
     * @return <b>this</b> (for chaining)
     */
    public JavaCodeVisibleElement setVisibility(String visibility) {
        this.visibility = JavaCodeVisibility.match(visibility);
        return this;
    }

    /**
     * Changes the visibility.
     * 
     * @param visibility the new visibility using Java or UML keywords
     * @return <b>this</b> (for chaining)
     */
    public JavaCodeVisibleElement setVisibility(JavaCodeVisibility visibility) {
        this.visibility = visibility;
        return this;
    }

    /**
     * Sets the visibility of this element to public.
     * 
     * @return <b>this</b> (for chaining)
     */
    public JavaCodeVisibleElement setPublic() {
        setVisibility(JavaCodeVisibility.PUBLIC);
        return this;
    }

    /**
     * Sets the visibility of this element to private.
     * 
     * @return <b>this</b> (for chaining)
     */
    public JavaCodeVisibleElement setPrivate() {
        setVisibility(JavaCodeVisibility.PRIVATE);
        return this;
    }

    /**
     * Sets the visibility of this element to protected.
     * 
     * @return <b>this</b> (for chaining)
     */
    public JavaCodeVisibleElement setProtected() {
        setVisibility(JavaCodeVisibility.PROTECTED);
        return this;
    }

    /**
     * Sets the visibility of this element to package.
     * 
     * @return <b>this</b> (for chaining)
     */
    public JavaCodeVisibleElement setPackage() {
        setVisibility(JavaCodeVisibility.PACKAGE);
        return this;
    }

    /**
     * Sets this element's static state.
     * 
     * @param isStatic if the element is static
     * @return <b>this</b>
     */
    public JavaCodeVisibleElement setStatic(boolean isStatic) {
        this.isStatic = isStatic;
        return this;
    }

    /**
     * Sets this element to static.
     * 
     * @return <b>this</b>
     */
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
        return addAnnotation(type, null);
    }
    
    /**
     * Adds an annotation.
     * 
     * @param type the annotation type, may be fully qualified
     * @param nested a nested type qualification within {@code type}, may be empty or <b>null</b> for none
     * @return the annotation for further processing
     */
    public JavaCodeAnnotation addAnnotation(String type, String nested) {
        if (null == annotations) {
            annotations = new ArrayList<>();
        }
        return IJavaCodeElement.add(annotations, 
            new JavaCodeAnnotation(new JavaCodeTypeSpecification(type, getClassParent()), nested, this));
    }

    /**
     * Returns the enclosing class.
     * 
     * @return the enclosing class
     */
    @Invisible
    protected abstract JavaCodeClass getEnclosing();
    
    /**
     * Returns the class to be used as parent, e.g., for {@link JavaCodeTypeSpecification}.
     * 
     * @return the class parent, by default {@link #getEnclosing()}
     */
    @Invisible
    protected JavaCodeClass getClassParent() {
        return getEnclosing();
    }

    /**
     * Returns the visibility.
     * 
     * @return the visibility
     */
    @Invisible
    JavaCodeVisibility getVisibility() {
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
    
    /**
     * Inserts additional modifiers after the visibility of the {@link #getModifier() modifiers}.
     * 
     * @param text the text collected for modifiers so far
     * @return the composed text, by default {@code text}
     */
    @Invisible
    protected String insertModifier(String text) {
        return text;
    }

    /**
     * Inserts additional modifiers after the optional static modifier of the {@link #getModifier() modifiers}.
     * 
     * @param text the text collected for modifiers so far
     * @return the composed text, by default {@code text}
     */
    @Invisible
    protected String insertGenerics(String text) {
        return text;
    }

    /**
     * Returns the modifier(s) as text.
     * 
     * @return the modifiers
     * @see #insertModifier(String)
     * @see #insertGenerics(String)
     */
    @Invisible
    protected String getModifier() {
        String result = getVisibility().getPrefix();
        result = insertModifier(result);
        if (isStatic) {
            result = IJavaCodeElement.appendWhitespace(result) +  "static";
        }
        result = insertGenerics(result);
        return IJavaCodeElement.appendWhitespace(result);
    }

    @Override
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
    
    @Override
    public int getElementCount() {
        int result = 1;
        if (null != comment) {
            result += comment.getElementCount();
        }
        if (null != annotations) {
            for (JavaCodeAnnotation a : annotations) {
                result += a.getElementCount();
            }
        }
        return result;
    }
    
}
