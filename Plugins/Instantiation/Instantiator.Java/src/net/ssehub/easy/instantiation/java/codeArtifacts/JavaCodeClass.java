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
import java.util.Comparator;
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
        this(name, enclosing, null);
    }

    /**
     * Creates a nested class with given name within {@code enclosing} with comment.
     * 
     * @param name the name of the class
     * @param enclosing the enclosing class
     * @param comment the class comment
     */
    JavaCodeClass(String name, JavaCodeClass enclosing, String comment) {
        super(name, JavaCodeVisibility.PUBLIC, comment);
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

    /**
     * Creates a protected class with given {@code name} with comment.
     * 
     * @param name the name of the class
     * @param comment the class comment
     * @return the created class
     */
    public JavaCodeClass addClass(String name, String comment) {
        return IJavaCodeElement.add(elements, new JavaCodeClass(name, this, comment).setProtected());
    }
    
    /**
     * Adds a public enum with the given name.
     * 
     * @param name the enum name
     * @return the enum
     */
    public JavaCodeEnum addEnum(String name) {
        return IJavaCodeElement.add(elements, new JavaCodeEnum(name, this));
    }

    /**
     * Adds a public enum with the given name.
     * 
     * @param name the enum name
     * @param comment the javadoc comment of the class
     * @return the enum
     */
    public JavaCodeEnum addEnum(String name, String comment) {
        return IJavaCodeElement.add(elements, new JavaCodeEnum(name, this, comment));
    }

    /**
     * Adds an initializer block.
     * 
     * @param isStatic whether the initializer shall be static
     * @return the created initializer
     */
    public JavaCodeInitializer addInitializer(boolean isStatic) {
        return IJavaCodeElement.add(elements, new JavaCodeInitializer(this, isStatic));
    }

    /**
     * Removes {@code elt} if {@link JavaCodeElement#isEmpty()}. Please not that no related
     * imports are removed.
     * 
     * @param elt the element to check
     */
    public void removeIfEmpty(JavaCodeElement elt) {
        if (elt.isEmpty()) {
            elements.remove(elt);
        }
    }
    
    public JavaCodeAttribute addAttribute(String type, String name) {
        return createAttribute(type, name, true);
    }
    
    public JavaCodeAttribute createAttribute(String type, String name, boolean add) {
        JavaCodeAttribute result = new JavaCodeAttribute(JavaCodeTypeSpecification.create(type, this), name, this);
        if (add) {
            IJavaCodeElement.add(elements, result, lastAttribute(elements));
        }
        return result;
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

    /**
     * Adds an implemented interface.
     * 
     * @param type the (qualified) name of the interface, ignored if empty
     * @return <b>this</b>
     */
    public JavaCodeClass addInterface(String type) {
        if (type.length() > 0) {
            if (null == implementedInterfaces) {
                implementedInterfaces = new ArrayList<>();
            }
            IJavaCodeElement.add(implementedInterfaces, JavaCodeTypeSpecification.create(type, this));
        }
        return this;
    }

    /**
     * Sets the class kind.
     * 
     * @param kind the new kind
     */
    protected void setKind(Kind kind) {
        this.kind = kind;
    }
    
    /**
     * Turns this class to an interface.
     * 
     * @return <b>this</b>
     */
    public JavaCodeClass asInterface() {
        setKind(Kind.INTERFACE);
        return this;
    }
    
    /**
     * Conditionally turns this class to an interface.
     * 
     * @param enable interface if {@code true}, else no change
     * @return <b>this</b>
     */
    public JavaCodeClass asInterface(boolean enable) {
        if (enable) {
            asInterface();
        }
        return this;
    }
    
    public JavaCodeClass asAnnotation() {
        setKind(Kind.ANNOTATION);
        return this;
    }

    public JavaCodeMethod addMainMethod() {
        return addMainMethod("The main method.", "args", "command line arguments");
    }

    public JavaCodeMethod addMainMethod(String methodComment, String param, String paramComment) {
        JavaCodeMethod result = addMethod("void", "main", methodComment)
            .setStatic();
        result.addParameter("String[]", param, paramComment);
        return result;
    }

    public JavaCodeMethod addConstructor() {
        return addConstructor(null);
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

    public JavaCodeMethod addMethod(String type, String name, String comment, String returnComment) {
        JavaCodeMethod result = addMethod(type, name, comment);
        result.getJavadocComment().addReturnComment(returnComment);
        return result;
    }

    public JavaCodeMethod addMethod(JavaCodeTypeSpecification type, String name, String comment) {
        return IJavaCodeElement.add(elements, new JavaCodeMethod(type, name, this, comment));
    }

    public JavaCodeMethod addMethod(JavaCodeTypeSpecification type, String name) {
        return IJavaCodeElement.add(elements, new JavaCodeMethod(type, name, this));
    }
    
    /**
     * Adds a default getter for {@code attribute}.
     * 
     * @param attribute the attribute to add the getter for
     * @return the getter
     */
    public JavaCodeMethod addGetter(JavaCodeAttribute attribute) {
        return attribute.addGetter();
    }

    /**
     * Adds a default setter for {@code attribute}.
     * 
     * @param attribute the attribute to add the setter for
     * @return the setter
     */
    public JavaCodeMethod addSetter(JavaCodeAttribute attribute) {
        return attribute.addSetter();
    }

    /**
     * Adds a default setter for {@code attribute}.
     * 
     * @param attribute the attribute to add the setter for
     * @param paramName explicit name for the parameter, may be <b>null</b> for the name of the attribute 
     * @return the setter
     */
    public JavaCodeMethod addSetter(JavaCodeAttribute attribute, String paramName) {
        return attribute.addSetter(paramName);
    }
    
    /**
     * Adds an empty toString method with override annotation to this class.
     * 
     * @return the method
     */
    public JavaCodeMethod addToString() {
        JavaCodeMethod toString = addMethod("String", "toString");
        toString.addOverrideAnnotation();
        return toString;
    }

    /**
     * Adds an empty hashCode method with override annotation to this class.
     * 
     * @return the method
     */
    public JavaCodeMethod addHashCode() {
        JavaCodeMethod hash = addMethod("int", "hashCode");
        hash.addOverrideAnnotation();
        return hash;
    }

    /**
     * Adds an empty equals method with override annotation to this class.
     * 
     * @param paramName the name of the parameter of the object to compare
     * @return the method
     */
    public JavaCodeMethod addEquals(String paramName) {
        JavaCodeMethod eq = addMethod("boolean", "equals");
        eq.addOverrideAnnotation();
        eq.addParameter("Object", "other");
        return eq;
    }
    
    /**
     * Adds an empty main method with override annotation to this class.
     * 
     * @param paramName the name of the parameter of the object to compare
     * @param varArg use an array parameter type ({@code false}) or a varArg parameter ({@code true})
     * @return the method
     */
    public JavaCodeMethod addMain(String paramName, boolean varArg) {
        JavaCodeMethod main = addMethod("", "main", "Executes the program.");
        main.setStatic();
        main.addParameter("String" + (varArg ? "[]" : "..."), "args", "Command line arguments");
        return main;
    }
    
    /**
     * Adds text and indents it.
     * 
     * @param text the text
     */
    public void add(String text) {
        elements.add(new JavaCodeText(text, true, true));
    }
    
    /**
     * Adds text without indentation/pre-indended.
     * 
     * @param text the text
     */
    public void addRaw(String text) {
        elements.add(new JavaCodeText(text, false, true));
    }

    /**
     * Adds an empty line.
     * 
     * @return <b>this</b>
     */
    public JavaCodeClass addEmptyLine() {
        IJavaCodeElement.add(elements, new JavaCodeEmptyLine(this));
        return this;
    }

    /**
     * Adds a single-line comment.
     * 
     * @param text the comment text
     * @return <b>this</b>
     */
    public JavaCodeClass addSLComment(String text) {
        IJavaCodeElement.add(elements, new JavaCodeSingleLineComment(this, text));
        return this;
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
    public JavaCodeClass setPublic(boolean isPublic) {
        super.setPublic(isPublic);
        return this;
    }

    @Override
    public JavaCodeClass setPrivate() {
        super.setPrivate();
        return this;
    }

    @Override
    public JavaCodeClass setPrivate(boolean isPrivate) {
        super.setPrivate(isPrivate);
        return this;
    }

    @Override
    public JavaCodeClass setProtected() {
        super.setProtected();
        return this;
    }

    @Override
    public JavaCodeClass setProtected(boolean isProtected) {
        super.setProtected(isProtected);
        return this;
    }

    @Override
    public JavaCodeClass setPackage() {
        super.setPackage();
        return this;
    }

    @Override
    public JavaCodeClass setPackage(boolean isPackage) {
        super.setPackage(isPackage);
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
            for (IJavaCodeElement e: sortedElements()) {
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
    
    private enum ElementSorting {
        NONE,
        CONS,
        CONS_ALPHA
    }
    
    private List<IJavaCodeElement> sortedElements() {
        List<IJavaCodeElement> result;
        ElementSorting sorting = IJavaCodeElement.getFormattingArgument(ElementSorting.class, 
            "eltSorting", ElementSorting.NONE);
        switch (sorting) {
        case CONS:
            result = partition(null);
            break;
        case CONS_ALPHA:
            result = partition(IJavaCodeElement.KEY_COMPARATOR);
            break;
        default: // implies none, do nothing
            result = elements;
            break;
        }
        return result;
    }

    /**
     * Partitions the elements in before constructors (attributes, comments), constructors and rest (methods, comments).
     * Applies {@code methodComparator} if given.
     * 
     * @param methodComparator comparator for methods
     * @return the partitioned/sorted elements
     */
    private List<IJavaCodeElement> partition(Comparator<IJavaCodeElement> methodComparator) {
        // group related but not partitionable
        List<IJavaCodeElement> result = ProxyElement.proxy(elements);

        // partition into fixed groups, proxies are transparent
        List<IJavaCodeElement> before = new ArrayList<>();
        List<IJavaCodeElement> init = new ArrayList<>();
        List<IJavaCodeElement> cons = new ArrayList<>();
        List<IJavaCodeElement> rest = new ArrayList<>();
        boolean inMethods = false;
        for (IJavaCodeElement e : result) {
            if (e.isConstructor()) {
                inMethods = true;
                cons.add(e);
            } else if (e.isMethod()) {
                inMethods = true;
                rest.add(e);
            } else if (e.isInitializer()) {
                init.add(e);
            } else if (!inMethods || e.isAttribute()) {
                before.add(e);
            } else {
                inMethods = true;
                rest.add(e);
            }
        }

        // optionally sort
        IJavaCodeElement.sort(rest, methodComparator);
        
        // un-partition from fixed groups
        result.clear();
        result.addAll(before);
        result.addAll(init);
        result.addAll(cons);
        result.addAll(rest);
        
        // ungroup related but not partitionable
        ProxyElement.unproxy(result);
        
        return result;
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
        IJavaCodeElement iter = null;
        if (null != element) {
            iter = element.getParent();
            while (iter != null && !(iter instanceof JavaCodeClass)) {
                iter = iter.getParent();
            }
        }
        return iter instanceof JavaCodeClass ? (JavaCodeClass) iter : null;
    }
    
    protected int getElementsCount() {
        return elements.size();
    }

}
