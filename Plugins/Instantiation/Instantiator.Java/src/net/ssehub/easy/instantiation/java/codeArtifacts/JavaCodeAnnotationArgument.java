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

public class JavaCodeAnnotationArgument implements IJavaCodeElement {

    private String name;
    private String value;
    private JavaCodeAnnotation annotation;
    
    JavaCodeAnnotationArgument(String name, String value, JavaCodeAnnotation annotation) {
        this.name = name;
        this.value = value;
        this.annotation = annotation;
    }
    
    @Override
    public String getStringValue(StringComparator comparator) {
        return "JavaAnnotationArgument (" + name + "=" + value + ")";
    }

    @Override
    public void store(CodeWriter out) {
        out.print(name);
        out.print(" = ");
        out.print(value);
    }

    @Override
    public IJavaCodeArtifact getArtifact() {
        return annotation.getArtifact();
    }

}
