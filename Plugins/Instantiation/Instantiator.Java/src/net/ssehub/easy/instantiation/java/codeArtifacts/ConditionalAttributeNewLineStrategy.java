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
 * Conditional new line strategy for attributes without javadoc not being separated by new lines.
 * 
 * @author Holger Eichelberger
 */
public class ConditionalAttributeNewLineStrategy implements NewLineStrategy {
    
    private IJavaCodeElement last;
    
    @Override
    public boolean emitNewlineBefore(IJavaCodeElement elt) {
        boolean separateBefore = false;
        boolean lastIsAttribute = null != last && last.isAttribute();
        boolean lastAndEAreAttributes = lastIsAttribute && elt.isAttribute();
        // for subsequent attributes we decide about separation here
        if (lastAndEAreAttributes) {
            separateBefore = elt.hasJavadocComment();
        } else if (lastIsAttribute) {
            separateBefore = true;
        }
        return separateBefore;
    }
    
    @Override
    public boolean emitNewlineAfter(IJavaCodeElement elt) {
        boolean lastIsAttribute = null != last && last.isAttribute();
        boolean lastAndEAreAttributes = lastIsAttribute && elt.isAttribute();
        // for subsequent attributes we delay decision about separation to next
        boolean separate = !lastAndEAreAttributes && !elt.isAttribute();
        last = elt;
        return separate;
    }

    @Override
    public void end() {
        last = null;
    }

}
