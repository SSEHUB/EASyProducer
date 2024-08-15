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
import java.util.function.Consumer;

import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;

/**
 * Representes a Java class in code.
 * 
 * @author Holger Eichelberger
 */
public class JavaCodeClass extends JavaCodeVisibleElement {

    static final JavaCodeClass EMPTY = new JavaCodeClass("", JavaCodeArtifact.EMPTY);
    private static NewLineStrategy newLineStrategy = new ConditionalAttributeNewLineStrategy();
    
    private Kind kind = Kind.CLASS;
    private List<IJavaCodeElement> elements = new ArrayList<>();
    private JavaCodeClass enclosing;
    private IJavaCodeArtifact artifact;
    private JavaCodeTypeSpecification extendingClass;
    private List<JavaCodeTypeSpecification> implementedInterfaces;
    
    public enum Kind {
        CLASS("class"),
        INTERFACE("interface"),
        ANNOTATION("@interface"),
        ENUM("enum");
        
        private String keyword;
        
        private Kind(String keyword) {
            this.keyword = keyword;
        }
        
        public String getKeyword() {
            return keyword;
        }
        
    }
    
    /**
     * Creates a public class with given name in {@code artifact}.
     * 
     * @param name the name of the class
     * @param artifact the name of the containing artifact
     */
    JavaCodeClass(String name, IJavaCodeArtifact artifact) {
        this(name, artifact, null);
    }

    /**
     * Creates a public enum with given name and comment as top-level entity in {@code artifact}.
     * 
     * @param name the name of the enum
     * @param artifact the name of the containing artifact
     * @param comment the describing comment of the enum
     */
    JavaCodeClass(String name, IJavaCodeArtifact artifact, String comment) {
        super(name, JavaCodeVisibility.PUBLIC, comment);
        this.artifact = artifact;
    }

    /**
     * Creates a nested class with given name within {@code enclosing}.
     * 
     * @param name the name of the class
     * @param enclosing the enclosing class
     */
    JavaCodeClass(String name, JavaCodeClass enclosing) {
        super(name, JavaCodeVisibility.PUBLIC, null);
        this.enclosing = enclosing;
    }
    
    @Invisible
    @Override
    public IJavaCodeArtifact getArtifact() {
        if (null == artifact) {
            return enclosing.getArtifact();
        } else {
            return artifact;
        }
    }
    
    @Invisible
    @Override
    protected JavaCodeClass getEnclosing() {
        return enclosing;
    }
    
    @Override
    protected JavaCodeClass getClassParent() {
        return this;
    }

    /**
     * Creates a protected class with given {@code name}.
     * 
     * @param name the name of the class
     * @return the created class
     */
    public JavaCodeClass addClass(String name) {
        return IJavaCodeElement.add(elements, new JavaCodeClass(name, this).setProtected());
    }
    
    public JavaCodeAttribute addAttribute(String type, String name) {
        return IJavaCodeElement.add(elements, 
            new JavaCodeAttribute(JavaCodeTypeSpecification.create(type, this), name, this), 
            lastAttribute(elements));
    }

    public JavaCodeAttribute addAttribute(JavaCodeTypeSpecification type, String name) {
        return IJavaCodeElement.add(elements, new JavaCodeAttribute(type, name, this), 
            lastAttribute(elements));
    }
    
    private static int lastAttribute(List<IJavaCodeElement> elements) {
        int pos = 0;
        while (pos < elements.size() && elements.get(pos).isAttribute()) {
            pos++;
        }
        return pos;
    }
    
    public JavaCodeClass addExtends(String type) {
        extendingClass = JavaCodeTypeSpecification.create(type, this);
        return this;
    }
    
    public JavaCodeClass addInterface(String type) {
        if (null == implementedInterfaces) {
            implementedInterfaces = new ArrayList<>();
        }
        IJavaCodeElement.add(implementedInterfaces, JavaCodeTypeSpecification.create(type, this));
        return this;
    }
    
    protected void setKind(Kind kind) {
        this.kind = kind;
    }
    
    public JavaCodeClass asInterface() {
        setKind(Kind.INTERFACE);
        return this;
    }
    
    public JavaCodeClass asAnnotation() {
        setKind(Kind.ANNOTATION);
        return this;
    }

    public JavaCodeMethod addMainMethod() {
        return addMainMethod("The main method.", "args", "command line parameters");
    }

    public JavaCodeMethod addMainMethod(String methodComment, String param, String paramComment) {
        JavaCodeMethod result = addMethod("void", "main", methodComment)
            .setStatic();
        result.addParameter("String[]", param, paramComment);
        return result;
    }

    public JavaCodeMethod addConstructor() {
        return addMethod(getName(), null);
    }

    public JavaCodeMethod addConstructor(String comment) {
        return IJavaCodeElement.add(elements, 
            configureConstructor(new JavaCodeMethod(null, getName(), this, comment)));
    }
    
    protected JavaCodeMethod configureConstructor(JavaCodeMethod cons) {
        return cons;
    }

    public JavaCodeMethod addMethod(String name) {
        return IJavaCodeElement.add(elements, new JavaCodeMethod(name, this));
    }

    public JavaCodeMethod addMethod(String type, String name) {
        return IJavaCodeElement.add(elements, 
            new JavaCodeMethod(JavaCodeTypeSpecification.create(type, this), name, this));
    }

    public JavaCodeMethod addMethod(String type, String name, String comment) {
        return IJavaCodeElement.add(elements, 
            new JavaCodeMethod(JavaCodeTypeSpecification.create(type, this), name, this, comment));
    }
    
    public JavaCodeMethod addMethod(JavaCodeTypeSpecification type, String name, String comment) {
        return IJavaCodeElement.add(elements, new JavaCodeMethod(type, name, this, comment));
    }

    public JavaCodeMethod addMethod(JavaCodeTypeSpecification type, String name) {
        return IJavaCodeElement.add(elements, new JavaCodeMethod(type, name, this));
    }
    
    /**
     * Adds an extensible default getter for {@code attribute}.
     * 
     * @param attribute the attribute to add the getter for
     * @return the getter
     */
    public JavaCodeMethod addGetter(JavaCodeAttribute attribute) {
        return attribute.addGetter();
    }

    /**
     * Adds an extensible default setter for {@code attribute}.
     * 
     * @param attribute the attribute to add the setter for
     * @return the setter
     */
    public JavaCodeMethod addSetter(JavaCodeAttribute attribute) {
        return attribute.addSetter();
    }

    @Override
    public JavaCodeClass setVisibility(String visibility) {
        super.setVisibility(visibility);
        return this;
    }

    @Override
    public JavaCodeClass setVisibility(JavaCodeVisibility visibility) {
        super.setVisibility(visibility);
        return this;
    }
    
    @Override
    public JavaCodeClass setPublic() {
        super.setPublic();
        return this;
    }

    @Override
    public JavaCodeClass setPrivate() {
        super.setPrivate();
        return this;
    }

    @Override
    public JavaCodeClass setProtected() {
        super.setProtected();
        return this;
    }

    @Override
    public JavaCodeClass setPackage() {
        super.setPackage();
        return this;
    }

    @Override
    public JavaCodeClass setStatic(boolean isStatic) {
        super.setStatic(isStatic);
        return this;
    }

    @Override
    public JavaCodeClass setStatic() {
        super.setStatic();
        return this;
    }
    
    /**
     * Returns the class kind.
     * 
     * @return the class kind
     */
    @Invisible
    Kind getKind() {
        return kind;
    }

    /*public JavaCodeJavadocComment setJavadocComment() {
        return new JavaCodeJavadocComment();
    }*/

    @Invisible
    @Override
    public void store(CodeWriter out) {
        super.store(out); // comment, annotations
        out.printwi(getModifier() + kind.getKeyword() + " " + getName());
        if (null != extendingClass) {
            out.print(" extends ");
            extendingClass.store(out);
        }
        IJavaCodeElement.storeList(" implements ", implementedInterfaces, ", ", out);
        storeBlock(out);
        out.println();
    }
    
    protected void storeBlock(CodeWriter out) {
        out.println(" {");
        out.increaseIndent();
        storeAtBlockStart(out);
        if (elements.size() > 0) {
            out.println();
            newLineStrategy.start();
            for (IJavaCodeElement e: elements) {
                if (newLineStrategy.emitNewlineBefore(e)) {
                    out.println();
                }
                e.store(out);
                if (newLineStrategy.emitNewlineAfter(e)) {
                    out.println();
                }
            }
        }
        out.decreaseIndent();
        out.printwi("}");        
    }

    /**
     * Called before storing the code elements at the beginning of the block.
     * 
     * @param out the code writer
     */
    protected void storeAtBlockStart(CodeWriter out) {
    }

    @Override
    @Invisible(inherit = true)
    public String getTracerStringValue(StringComparator comparator) {
        return getClass().getSimpleName() + ": " + getName();
    }

    @Override
    public IJavaCodeElement getParent() {
        return enclosing;
    }

    @Invisible
    @Override
    public void setParent(IJavaCodeElement parent) {
        setParent(parent, p -> this.enclosing = p);
    }

    /**
     * Helper to set a parent of required type {@link JavaCodeClass}.
     * 
     * @param parent the parent
     * @param consumer the setter consumer
     */
    static void setParent(IJavaCodeElement parent, Consumer<JavaCodeClass> consumer) {
        IJavaCodeElement.setParent(parent, JavaCodeClass.class, consumer);
    }

    /**
     * Determines a code class parent.
     * 
     * @param element the element to start searching from
     * @return the code class parent or <b>null</b>
     */
    static JavaCodeClass getParentCodeClass(IJavaCodeElement element) {
        IJavaCodeElement iter = element.getParent();
        while (iter != null && !(iter instanceof JavaCodeClass)) {
            iter = iter.getParent();
        }
        return iter instanceof JavaCodeClass ? (JavaCodeClass) iter : null;
    }
    
    protected int getElementsCount() {
        return elements.size();
    }

}
