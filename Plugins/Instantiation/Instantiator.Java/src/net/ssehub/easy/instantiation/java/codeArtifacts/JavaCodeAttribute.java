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
import net.ssehub.easy.instantiation.core.model.vilTypes.OperationMeta;

public class JavaCodeAttribute extends JavaCodeVisibleElement {

    private JavaCodeTypeSpecification type;
    private JavaCodeClass enclosing;

    protected JavaCodeAttribute(String name, JavaCodeClass enclosing) {
        this(JavaCodeTypeSpecification.VOID, name, enclosing);
    }

    protected JavaCodeAttribute(JavaCodeTypeSpecification type, String name, JavaCodeClass enclosing) {
        super(name, Visibility.PRIVATE, null);
        this.enclosing = enclosing;
        this.type = type;
    }

    @Invisible
    @Override
    public IJavaCodeArtifact getArtifact() {
        return enclosing.getArtifact();
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
    @OperationMeta(name = {"visibility"})
    public JavaCodeAttribute setVisibility(String visibility) {
        super.setVisibility(visibility);
        return this;
    }

    @Override
    @OperationMeta(name = {"visibility"})
    public JavaCodeAttribute setVisibility(Visibility visibility) {
        super.setVisibility(visibility);
        return this;
    }
    
    @Override
    @OperationMeta(name = {"public"})
    public JavaCodeAttribute setPublic() {
        super.setPublic();
        return this;
    }

    @Override
    @OperationMeta(name = {"private"})
    public JavaCodeAttribute setPrivate() {
        super.setPrivate();
        return this;
    }

    @Override
    @OperationMeta(name = {"protected"})
    public JavaCodeAttribute setProtected() {
        super.setProtected();
        return this;
    }

    @Override
    @OperationMeta(name = {"package"})
    public JavaCodeAttribute setPackage() {
        super.setPackage();
        return this;
    }

    @Override
    @OperationMeta(name = {"static"})
    public JavaCodeAttribute setStatic(boolean isStatic) {
        super.setStatic(isStatic);
        return this;
    }

    @OperationMeta(name = {"static"})
    @Override
    public JavaCodeAttribute setStatic() {
        super.setStatic();
        return this;
    }
    
}
