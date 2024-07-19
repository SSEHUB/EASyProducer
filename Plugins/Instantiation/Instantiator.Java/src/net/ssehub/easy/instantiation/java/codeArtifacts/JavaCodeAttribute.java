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

import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;
import net.ssehub.easy.instantiation.core.model.vilTypes.PseudoString;

/**
 * Represents an attribute of a class in Java.
 * 
 * @author Holger Eichelberger
 */
public class JavaCodeAttribute extends JavaCodeVisibleElement {

    private JavaCodeTypeSpecification type;
    private JavaCodeClass enclosing;

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
        out.println(getName() + ";");
    }

    @Override
    public String getStringValue(StringComparator comparator) {
        return "JavaAttribute: " + getName();
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
    
    /**
     * Adds an extensible default getter for this attribute.
     * 
     * @return the getter
     */
    public JavaCodeMethod addGetter() {
        final String attribute = getName();
        JavaCodeMethod method = enclosing.addMethod(type, 
            "get" + PseudoString.firstToUpperCase(attribute), "Returns the value of " + attribute + ".");
        method.addReturn(getName(), "the value of " + attribute);
        return method;
    }
    
    /**
     * Adds an extensible default setter for this attribute.
     * 
     * @return the setter
     */
    public JavaCodeMethod addSetter() {
        final String attribute = getName();
        JavaCodeMethod method = enclosing.addMethod(JavaCodeTypeSpecification.VOID, 
            "set" + PseudoString.firstToUpperCase(attribute), "Changes the value of " + attribute + ".");
        method.addParameter(type, attribute, "the new value");
        method.add("this." + attribute + " = " + attribute + ";");
        return method;
    }

    @Override
    public IJavaCodeElement getParent() {
        return enclosing;
    }
    
}
