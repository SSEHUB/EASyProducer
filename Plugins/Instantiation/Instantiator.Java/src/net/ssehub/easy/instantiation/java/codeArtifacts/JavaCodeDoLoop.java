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

/**
 * Represents a do-loop.
 *
 * @author Holger Eichelberger
 */
public class JavaCodeDoLoop extends JavaCodeBlock {

    private String condition;
    
    /**
     * Creates a do-loop.
     * 
     * @param parent the parent instance
     * @param condition the loop condition
     */
    public JavaCodeDoLoop(IJavaCodeElement parent, String condition) {
        super(parent, true, false);
        this.condition = condition;
    }

    @Invisible
    @Override
    public void store(CodeWriter out) {
        out.printwi("do");
        super.store(out);
        out.print(" while (");
        out.print(condition);
        out.println(");");
    }

    @Override
    public String getStringValue(StringComparator comparator) {
        return "JavaCodeDoLoop";
    }

}