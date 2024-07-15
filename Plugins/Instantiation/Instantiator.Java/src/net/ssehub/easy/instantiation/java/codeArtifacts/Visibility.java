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

public enum Visibility {
    
    PUBLIC(null, "public", "+"),
    PROTECTED(null, "protected", "#"),
    PRIVATE(null, "private", "-"),
    PACKAGE("", "package", "~");
    
    private String keyword;
    private String[] name;
    
    private Visibility(String keyword, String... name) {
        this.keyword = null == keyword && name.length > 0 ? name[0] : keyword;
        this.name = name;
    }
    
    public boolean matches(String text) {
        boolean matches = false;
        for (int i = 0; !matches && i < name.length; i++) {
            matches = name[i].equals(text);
        }
        return matches;
    }
    
    public String getKeyword() {
        return keyword;
    }

    public String getPrefix() {
        return keyword.length() > 0 ? keyword + " " : keyword;
    }

    public static Visibility match(String text) {
        return match(text, Visibility.PUBLIC);
    }

    public static Visibility match(String text, Visibility dflt) {
        Visibility result = dflt;
        for (Visibility v : values()) {
            if (v.matches(text)) {
                result = v;
                break;
            }
        }
        return result;
    }

}
