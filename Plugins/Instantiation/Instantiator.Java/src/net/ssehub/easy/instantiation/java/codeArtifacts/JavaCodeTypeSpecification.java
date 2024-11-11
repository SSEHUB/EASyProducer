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

import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;

/**
 * Represents a Java type specification.
 * 
 * @author Holger Eichelberger
 */
public class JavaCodeTypeSpecification implements IJavaCodeElement, IJavaCodeTypeSpecification {

    public static final JavaCodeTypeSpecification VOID = new JavaCodeTypeSpecification(); 
    
    private String type;
    private List<JavaCodeTypeSpecification> generics;
    private JavaCodeClass enclosing;

    /**
     * Creates a type specification for "void".
     */
    private JavaCodeTypeSpecification() {
        this("void", JavaCodeClass.EMPTY);
    }
    
    /**
     * Creates a type specification for the given type.
     * 
     * @param type the type
     * @param element the element to start searching for the parent code class at
     */
    protected JavaCodeTypeSpecification(String type, IJavaCodeElement element) {
        this(type, JavaCodeClass.getParentCodeClass(element));
    }
    
    /**
     * Creates a type specification for the given type.
     * 
     * @param type the type
     * @param enclosing the defining/enclosing class
     */
    protected JavaCodeTypeSpecification(String type, JavaCodeClass enclosing) {
        this.enclosing = enclosing;
        this.type = type; // -> validateType
        int gStartPos = type.indexOf("<");
        int gEndPos = type.lastIndexOf(">");
        if (gStartPos > 0 && gEndPos > 0) {
            String gen = type.substring(gStartPos).trim();
            this.type = type.substring(0, gStartPos).trim();
            generics = parseGenerics(gen, enclosing);
            if (null == generics) {
                generics = new ArrayList<>();
            }
        }
        if (null != enclosing) {
            getArtifact().validateType(this);
        }
    }

    /**
     * Creates a type specification for the given type.
     * 
     * @param type the type
     * @param enclosing the defining/enclosing class
     */
    protected JavaCodeTypeSpecification(JavaCodeTypeSpecification type, JavaCodeClass enclosing) {
        this.enclosing = enclosing;
        this.type = type.type;
        if (null != type.generics) {
            this.generics = new ArrayList<>(type.generics); // deep copy?
        }
    }

    /**
     * Parses the generics part of a type definition into individual top-level generics.
     * 
     * @param text the text containing the generics part to be parsed
     * @param enclosing the enclosing class the type is declared within
     * @return <b>null</b> for no generics, a list of top-level generics else
     */
    public static List<JavaCodeTypeSpecification> parseGenerics(String text, JavaCodeClass enclosing) {
        List<JavaCodeTypeSpecification> result = null;
        int nested = -1;
        int lastPos = -1;
        int endGen = text.length();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            switch (c) {
            case '<':
                nested++;
                if (nested == 0) {
                    lastPos = i + 1;
                }
                break;
            case '>':
                if (nested == 0) {
                    endGen = i;
                }
                nested--;
                break;
            case ',':
                if (nested == 0) {
                    if (null == result) {
                        result = new ArrayList<>();
                    }
                    result.add(new JavaCodeTypeSpecification(text.substring(lastPos, i).trim(), enclosing));
                    lastPos = i + 1;
                }
                break;
            default:
                break;
            }
        }
        if (lastPos > 0 && lastPos < endGen) {
            if (null == result) {
                result = new ArrayList<>();
            }
            result.add(new JavaCodeTypeSpecification(text.substring(lastPos, endGen).trim(), enclosing));
        }
        return result;
    }

    /**
     * Creates a type specification.
     * 
     * @param type the type as string
     * @param enclosing the enclosing class
     * @return the type specification instance
     */
    static JavaCodeTypeSpecification create(String type, JavaCodeClass enclosing) {
        JavaCodeTypeSpecification result;
        if (VOID.getType().equals(type)) {
            result = VOID;
        } else {
            result = new JavaCodeTypeSpecification(type, enclosing);
        }
        return result;
    }
    
    /**
     * Returns the type.
     * 
     * @return the type (without generics, potentially modified based on imports)
     */
    public String getType() {
        return type;
    }
    
    /**
     * Adds a generic.
     * 
     * @param generic the generic
     */
    public void addGeneric(JavaCodeTypeSpecification generic) {
        if (null == generics) {
            generics = new ArrayList<>();
        }
        generics.add(generic);
    }

    @Invisible
    @Override
    public IJavaCodeArtifact getArtifact() {
        return enclosing.getArtifact();
    }
    
    /**
     * Returns the enclosing class.
     * 
     * @return the enclosing class
     */
    @Invisible
    public JavaCodeClass getEnclosing() {
        return enclosing;
    }

    @Invisible
    @Override
    public void store(CodeWriter out) {
        out.print(type);
        if (null != generics) {
            out.print("<");
            for (int g = 0; g < generics.size(); g++) {
                if (g > 0) {
                    out.print(", ");
                }
                generics.get(g).store(out);
            }
            out.print(">");
        }
    }
    
    /**
     * Returns whether a given type is {@code void}.
     * 
     * @param type the type (may be <b>null</b>)
     * @return {@code true} if void, {@code false} else
     */
    public static boolean isVoid(JavaCodeTypeSpecification type) {
        return type == VOID;
    }

    @Override
    @Invisible(inherit = true)
    public String getTracerStringValue(StringComparator comparator) {
        return getClass().getSimpleName() + " " + type;
    }

    @Override
    public String getOutputTypeName() {
        return type;
    }

    public String getOutputType() {
        CodeToStringWriter out = new CodeToStringWriter();
        store(out);
        return out.getString();
    }

    @Override
    public void setOutputTypeName(String typeName) {
        this.type = typeName;
    }
    
    @Override
    public int getGenericCount() {
        return null == generics ? 0 : generics.size();
    }
    
    @Override
    public IJavaCodeTypeSpecification getGeneric(int index) {
        if (null == generics) {
            throw new IndexOutOfBoundsException(index);
        }
        return generics.get(index);
    }

    @Override
    public IJavaCodeElement getParent() {
        return enclosing;
    }

    @Invisible
    @Override
    public void setParent(IJavaCodeElement parent) {
        JavaCodeClass.setParent(parent, p -> this.enclosing = p);
        if (null != enclosing) {
            getArtifact().validateType(this);
        }
    }

}
