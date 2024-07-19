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

import net.ssehub.easy.instantiation.core.model.vilTypes.IVilType;

/**
 * Represents a Java (or UML-named) visibility.
 * 
 * @author Holger Eichelberger
 */
public enum JavaCodeVisibility implements IVilType {
    
    PUBLIC(null, "public", "+"),
    PROTECTED(null, "protected", "#"),
    PRIVATE(null, "private", "-"),
    PACKAGE("", "package", "~");
    
    private String keyword;
    private String[] name;

    /**
     * Creates an instance.
     * 
     * @param keyword the keyword, may be empty or <b>null</b> (use the first name)
     * @param name the names to match string values against
     */
    private JavaCodeVisibility(String keyword, String... name) {
        this.keyword = null == keyword && name.length > 0 ? name[0] : keyword;
        this.name = name;
    }
    
    /**
     * Returns whether {@code text} matches the name of one of the defined visibilities.
     * 
     * @param text the text to match
     * @return {@code true} if there is a match, {@code false} else
     */
    public boolean matches(String text) {
        boolean matches = false;
        for (int i = 0; !matches && i < name.length; i++) {
            matches = name[i].equals(text);
        }
        return matches;
    }
    
    /**
     * Returns the Java keyword for this visibility.
     * 
     * @return the keyword
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     * Returns the Java keyword prefix for this visibility, i.e., potentially suffixed with a whitespace.
     * 
     * @return the keyword prefix
     */
    public String getPrefix() {
        return keyword.length() > 0 ? keyword + " " : keyword;
    }

    /**
     * Returns the code visibility for {@code text} with default {@link #PUBLIC}.
     * 
     * @param text the text to match
     * @return the visibility
     */
    public static JavaCodeVisibility match(String text) {
        return match(text, JavaCodeVisibility.PUBLIC);
    }

    /**
     * Returns the code visibility for {@code text} with given default.
     * 
     * @param text the text to match
     * @param dflt the default value if {@code text} cannot be matched
     * @return the visibility
     */
    public static JavaCodeVisibility match(String text, JavaCodeVisibility dflt) {
        JavaCodeVisibility result = dflt;
        for (JavaCodeVisibility v : values()) {
            if (v.matches(text)) {
                result = v;
                break;
            }
        }
        return result;
    }

}
