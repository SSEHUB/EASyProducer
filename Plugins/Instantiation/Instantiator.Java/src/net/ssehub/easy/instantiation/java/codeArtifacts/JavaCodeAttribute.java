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

import net.ssehub.easy.instantiation.core.model.templateModel.CodeWriter;
import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;
import net.ssehub.easy.instantiation.core.model.vilTypes.OperationMeta;
import net.ssehub.easy.instantiation.core.model.vilTypes.PseudoString;

/**
 * Represents an attribute of a class in Java.
 * 
 * @author Holger Eichelberger
 */
public class JavaCodeAttribute extends JavaCodeVisibleElement {

    private JavaCodeTypeSpecification type;
    private JavaCodeClass enclosing;
    private JavaCodeExpression initializer;

    /**
     * Creates an attribute.
     * 
     * @param type the type of the attribute; the type is validated/potentially registered as import in the 
     *   containing artifact
     * @param name the name
     * @param enclosing the enclosing class
     */
    protected JavaCodeAttribute(JavaCodeTypeSpecification type, String name, JavaCodeClass enclosing) {
        super(name, JavaCodeVisibility.PRIVATE, null);
        this.enclosing = enclosing;
        this.type = type;
    }

    @Override
    public boolean isAttribute() {
        return true;
    }

    @Invisible
    @Override
    public IJavaCodeArtifact getArtifact() {
        return enclosing.getArtifact();
    }
    
    @Invisible
    @Override
    protected JavaCodeClass getEnclosing() {
        return enclosing;
    }

    @Invisible
    @Override
    public void store(CodeWriter out) {
        super.store(out); // comment, annotations
        out.printwi(getModifier());
        type.store(out); 
        out.print(" ");
        out.print(getName());
        if (null != initializer) {
            out.print(" = ");
            initializer.store(out);
        }
        out.println(";");
    }

    @Invisible(inherit = true)
    @Override
    public String getTracerStringValue(StringComparator comparator) {
        return getClass().getSimpleName() + ": " + getName();
    }
    
    @Override
    public JavaCodeAttribute setVisibility(String visibility) {
        super.setVisibility(visibility);
        return this;
    }

    @Override
    public JavaCodeAttribute setVisibility(JavaCodeVisibility visibility) {
        super.setVisibility(visibility);
        return this;
    }
    
    @Override
    public JavaCodeAttribute setPublic() {
        super.setPublic();
        return this;
    }

    @Override
    public JavaCodeAttribute setPrivate() {
        super.setPrivate();
        return this;
    }

    @Override
    public JavaCodeAttribute setProtected() {
        super.setProtected();
        return this;
    }

    @Override
    public JavaCodeAttribute setPackage() {
        super.setPackage();
        return this;
    }

    @Override
    public JavaCodeAttribute setStatic(boolean isStatic) {
        super.setStatic(isStatic);
        return this;
    }

    @Override
    public JavaCodeAttribute setStatic() {
        super.setStatic();
        return this;
    }
    
    public JavaCodeAttribute setPublicStaticFinal() {
        super.setPublic();
        super.setStatic();
        super.setFinal();
        return this;
    }
    
    @OperationMeta(name = {"addInitializer", "initializer"})
    public JavaCodeAttribute addInitializer(JavaCodeExpression initializer) {
        this.initializer = initializer;
        if (null != this.initializer) {
            this.initializer.setParent(this);
        }
        return this;
    }
    
    @OperationMeta(name = {"addStringInitializer", "stringInitializer"})
    public JavaCodeAttribute addStringInitializer(String stringEx) {
        this.initializer = new JavaCodeStringExpression(this, stringEx);
        return this;
    }
    
    public JavaCodeAnonymousClass addAnonymous(String cls) {
        JavaCodeAnonymousClass ano = new JavaCodeAnonymousClass(cls, getEnclosing());
        this.initializer = JavaCodeAnonymousClass.toExpression(ano);
        return ano;
    }
    
    public JavaCodeConstructorCall addNew(String cls) {
        this.initializer = new JavaCodeConstructorCall(this, cls, false, "");
        return (JavaCodeConstructorCall) this.initializer;
    }
    
    public JavaCodeNewArrayExpression addNewArray(String type) {
        this.initializer = new JavaCodeNewArrayExpression(this, type);
        return (JavaCodeNewArrayExpression) this.initializer;
    }
    
    public JavaCodeMethodCall addCall(String methodName, JavaCodeImportScope scope) {
        this.initializer = new JavaCodeMethodCall(this, methodName, scope, false, "");
        return (JavaCodeMethodCall) this.initializer;
    }

    /**
     * Adds an extensible default getter for this attribute.
     * 
     * @return the getter
     */
    public JavaCodeMethod addGetter() {
        return addGetter(false);
    }
    
    /**
     * Adds an extensible default getter for this attribute.
     * 
     * @param mayBeNull if the value may be <b>null</b>
     * @return the getter
     */
    public JavaCodeMethod addGetter(boolean mayBeNull) {
        final String attribute = getName();
        JavaCodeMethod method = enclosing.addMethod(type, 
            "get" + PseudoString.firstToUpperCase(attribute), "Returns the value of " + attribute + ".");
        method.setStatic(isStatic());
        String retComment = "the value of " + attribute + (mayBeNull ? ", may be <b>null</b>" : "");
        method.addReturn(new JavaCodeTextExpression(this, getName()), retComment);
        return method;
    }
    
    /**
     * Adds an extensible default setter for this attribute.
     * 
     * @return the setter
     */
    public JavaCodeMethod addSetter() {
        return addSetter(null);
    }

    /**
     * Adds an extensible default setter for this attribute.
     *
     * @param paramName explicit name for the parameter, may be <b>null</b> or empty for the name of the attribute 
     * @return the setter
     */
    public JavaCodeMethod addSetter(String paramName) {
        return addSetter(paramName, false);
    }

    /**
     * Adds an extensible default setter for this attribute.
     *
     * @param mayBeNull if the value may be <b>null</b>
     * @return the setter
     */
    public JavaCodeMethod addSetter(boolean mayBeNull) {
        return addSetter(null, mayBeNull);
    }
    
    /**
     * Adds an extensible default setter for this attribute.
     *
     * @param paramName explicit name for the parameter, may be <b>null</b> or empty for the name of the attribute 
     * @param mayBeNull if the value may be <b>null</b>
     * @return the setter
     */
    public JavaCodeMethod addSetter(String paramName, boolean mayBeNull) {
        final String attribute = getName();
        final String pName = (null == paramName || paramName.length() == 0) ? attribute : paramName;
        JavaCodeMethod method = enclosing.addMethod(JavaCodeTypeSpecification.VOID, 
            "set" + PseudoString.firstToUpperCase(attribute), "Changes the value of " + attribute + ".");
        method.setStatic(isStatic());
        method.addParameter(type, pName, "the new value" + (mayBeNull ? ", may be <b>null</b>" : ""));
        method.add("this." + attribute + " = " + pName + ";");
        return method;
    }

    @Override
    public IJavaCodeElement getParent() {
        return enclosing;
    }

    @Invisible
    @Override
    public void setParent(IJavaCodeElement parent) {
        JavaCodeClass.setParent(parent, p -> this.enclosing = p);    
    }
    
}
