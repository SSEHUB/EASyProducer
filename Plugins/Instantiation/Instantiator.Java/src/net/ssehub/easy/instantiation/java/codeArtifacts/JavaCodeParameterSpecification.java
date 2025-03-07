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
 * Represents a Java method parameter (specification).
 * 
 * @author Holger Eichelberger
 */
public class JavaCodeParameterSpecification extends JavaCodeTypeSpecification implements JavaCodeAnnotationParent {

    private String name;
    private List<JavaCodeAnnotation> annotations;
    private boolean isFinal;

    /**
     * Creates a parameter specification.
     * 
     * @param type the type of the parameter
     * @param name the name of the parameter
     * @param method the owning method
     */
    protected JavaCodeParameterSpecification(String type, String name, JavaCodeMethod method) {
        super(type, method.getEnclosing());
        this.name = name;
    }
    
    /**
     * Creates a parameter specification.
     * 
     * @param type the type of the parameter
     * @param name the name of the parameter
     * @param method the owning method
     */
    protected JavaCodeParameterSpecification(JavaCodeTypeSpecification type, String name, JavaCodeMethod method) {
        super(type, method.getEnclosing());
        this.name = name;
    }
    
    /**
     * Returns the parameter name.
     * 
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets this parameter declaration to final.
     * 
     * @return <b>this</b> for chaining
     */
    public JavaCodeParameterSpecification setFinal() {
        return setFinal(true);
    }

    /**
     * Sets this parameter declaration conditionally to final.
     * 
     * @param isFinal whether this variable shall be final
     * @return <b>this</b> for chaining
     */
    public JavaCodeParameterSpecification setFinal(boolean isFinal) {
        this.isFinal = isFinal;
        return this;
    }    
    
    /**
     * Adds an annotation.
     * 
     * @param type the annotation type, may be fully qualified
     * @return the annotation for further processing
     */
    @OperationMeta(name = {"addAnnotation", "annotate"})
    public JavaCodeAnnotation addAnnotation(String type) {
        if (null == annotations) {
            annotations = new ArrayList<>();
        }
        return IJavaCodeElement.add(annotations, 
            new JavaCodeAnnotation(new JavaCodeTypeSpecification(type, getEnclosing()), this));
    }

    @Invisible
    @Override
    public void store(CodeWriter out) {
        if (null != annotations) {
            for (JavaCodeAnnotation a : annotations) {
                a.storeNoLn(out);
            }
        }
        if (isFinal) {
            out.print("final ");
        }
        super.store(out);
        out.print(" ");
        out.print(name);
    }
    
    @Override
    @Invisible(inherit = true)
    public String getTracerStringValue(StringComparator comparator) {
        return getClass().getSimpleName() + " " + getType() + " " + name;
    }

}
