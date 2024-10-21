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

/**
 * Internal artifact for explicitly created instances and delayed adding/linking. Prevents/handles 
 * {@link NullPointerException}.
 * 
 * @author Holger Eichelberger
 */
class DummyJavaCodeArtifact implements IJavaCodeArtifact {

    static final IJavaCodeArtifact INSTANCE = new DummyJavaCodeArtifact();

    /**
     * Prevents external creation.
     */
    private DummyJavaCodeArtifact() {
    }
    
    @Override
    public void validateType(IJavaCodeTypeSpecification type) {
    }

    @Override
    public String validateStaticMethodCall(String name, JavaCodeImportScope scope) {
        return name;
    }

    @Override
    public void registerImport(IJavaCodeImport imp) {
    }

    @Override
    public JavaCodeImport addImport(String imp) {
        return new JavaCodeImport(imp, INSTANCE);
    }

}
