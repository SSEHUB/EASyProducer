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

import net.ssehub.easy.instantiation.core.model.templateModel.CodeWriter;
import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;
import net.ssehub.easy.instantiation.core.model.vilTypes.OperationMeta;

/**
 * Potentially abstract or visible code element.
 * 
 * @author Holger Eichelberger
 */
public abstract class JavaCodeAbstractVisibleElement extends JavaCodeVisibleElement {

    private boolean isAbstract;
    private List<String> generics;

    /**
     * Creates an element.
     * 
     * @param name the element name
     * @param visibility the visibility
     * @param comment the optional comment for this element, may be <b>null</b>
     */
    protected JavaCodeAbstractVisibleElement(String name, JavaCodeVisibility visibility, String comment) {
        super(name, visibility, comment);
    }

    /**
     * Sets this element's abstract state.
     * 
     * @param isAbstract if the element is abstract
     * @return <b>this</b> for chaining
     */
    @OperationMeta(name = {"setAbstract", "abstract"})
    public JavaCodeAbstractVisibleElement setAbstract(boolean isAbstract) {
        this.isAbstract = isAbstract;
        return this;
    }

    /**
     * Sets this element to abstract.
     * 
     * @return <b>this</b> for chaining
     */
    @OperationMeta(name = {"setAbstract", "abstract"})
    public JavaCodeAbstractVisibleElement setAbstract() {
        setAbstract(true);
        return this;
    }

    /**
     * Returns whether the element is abstract.
     * 
     * @return {@code true} for abstract, {@code false} for not abstract
     */
    public boolean isAbstract() {
        return isAbstract;
    }
    
    /**
     * Adds a generic.
     * 
     * @param generic the generic
     * @return <b>this</b> for chaining
     */
    @OperationMeta(name = {"addGeneric", "generic"})
    public JavaCodeAbstractVisibleElement addGeneric(String generic) {
        if (null == generics) {
            generics = new ArrayList<>();
        }
        generics.add(generic);
        return this;
    }

    @Invisible
    @Override
    protected String insertModifier(String text) {
        String result = text;
        if (isAbstract) {
            result = IJavaCodeElement.appendWhitespace(text) + "abstract";
        }
        return result;
    }

    @Invisible
    @Override
    protected String insertGenerics(String text) {
        return text + IJavaCodeElement.toList(generics, ", "); // TODO SEPARATOR
    }

    
    protected void storeGenerics(CodeWriter out) {
        if (null != generics) {
            out.print("<" + IJavaCodeElement.toList(generics, ", ") + ">");
        }
    }
    
}
