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
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import net.ssehub.easy.instantiation.core.model.templateModel.CodeWriter;
import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;
import net.ssehub.easy.instantiation.core.model.vilTypes.OperationMeta;

/**
 * Potentially visible code element.
 * 
 * @author Holger Eichelberger
 */
public abstract class JavaCodeVisibleElement extends JavaCodeElement {

    private boolean isStatic;
    private boolean isFinal;
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
        this.name = validateName(name);
        this.visibility = visibility;
        if (null != comment) {
            ensureJavadocComment(comment);
        }
    }
    
    /**
     * Validates/Adjusts the name.
     * 
     * @param name the name to validate
     * @return the validated name
     */
    protected String validateName(String name) {
        return name;
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
    
    @Invisible()
    @Override
    public String getSortKey() {
        return name;
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
     * Sets the visibility of this element to public.
     * 
     * @param isPublic whether public visibility shall be set
     * @return <b>this</b> (for chaining)
     */
    public JavaCodeVisibleElement setPublic(boolean isPublic) {
        if (isPublic) {
            setPublic();
        }
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
     * Sets the visibility of this element to private.
     * 
     * @param isPrivate whether private visibility shall be set
     * @return <b>this</b> (for chaining)
     */
    public JavaCodeVisibleElement setPrivate(boolean isPrivate) {
        if (isPrivate) {
            setPrivate();
        }
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
     * Sets the visibility of this element to protected.
     * 
     * @param isProtected whether protected visibility shall be set
     * @return <b>this</b> (for chaining)
     */
    public JavaCodeVisibleElement setProtected(boolean isProtected) {
        if (isProtected) {
            setProtected();
        }
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
     * Sets the visibility of this element to package.
     * 
     * @param isPackage whether package visibility shall be set
     * @return <b>this</b> (for chaining)
     */
    public JavaCodeVisibleElement setPackage(boolean isPackage) {
        if (isPackage) {
            setPackage();
        }
        return this;
    }

    /**
     * Sets this element's static modifier state.
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
        return setStatic(true);
    }

    /**
     * Sets this element's final modifier state.
     * 
     * @param isFinal if the element is final
     * @return <b>this</b>
     */
    public JavaCodeVisibleElement setFinal(boolean isFinal) {
        this.isFinal = isFinal;
        return this;
    }

    /**
     * Sets this element to final.
     * 
     * @return <b>this</b>
     */
    public JavaCodeVisibleElement setFinal() {
        return setFinal(true);
    }

    /**
     * Adds an annotation.
     * 
     * @param type the annotation type, may be fully qualified
     * @return the annotation for further processing
     */
    @OperationMeta(name = {"addAnnotation", "annotate"})
    public JavaCodeAnnotation addAnnotation(String type) {
        return addAnnotation(type, null);
    }
    
    /**
     * Adds a suppress warnings annotation.
     * 
     * @return the annotation for further processing
     */
    @OperationMeta(name = {"addSuppressWarningsAnnotation", "suppressWarnings"})
    public JavaCodeAnnotation addSuppressWarningsAnnotation() {
        return addAnnotation(SuppressWarnings.class.getSimpleName());
    }
    
    /**
     * Adds an annotation.
     * 
     * @param type the annotation type, may be fully qualified
     * @param nested a nested type qualification within {@code type}, may be empty or <b>null</b> for none
     * @return the annotation for further processing
     */
    @OperationMeta(name = {"addAnnotation", "annotate"})
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
     * Returns whether the element is final.
     * 
     * @return {@code true} for final, {@code false} for non-final
     */
    public boolean isFinal() {
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
        if (isFinal) {
            result = IJavaCodeElement.appendWhitespace(result) +  "final";
        }
        result = insertGenerics(result);
        return IJavaCodeElement.appendWhitespace(result);
    }

    @Override
    @Invisible
    public void store(CodeWriter out) {
        if (null != comment && enableStoreComment()) {
            comment.store(out);
        }
        if (null != annotations) {
            for (JavaCodeAnnotation a : annotations) {
                a.store(out);
            }
        }
    }
    
    /**
     * Enables a specified comment in {@link #store(CodeWriter)}.
     * 
     * @return {@code true} for enabled, {@code false} for disabled
     */
    protected boolean enableStoreComment() {
        return true;
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
    
    /**
     * Returns the annotations.
     * 
     * @param types the annotation types to look for
     * @return {@code true} if annotations were found, {@code false} else
     */
    protected boolean hasAnnotation(String... types) {
        boolean result = false;
        if (annotations != null) {
            Set<String> tmp = Arrays.stream(types).collect(Collectors.toSet());
            result = annotations.stream().anyMatch(a -> tmp.contains(a.getType()));
        }
        return result;
    }
    
}
