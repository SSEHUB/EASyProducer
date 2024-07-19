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
import java.util.stream.Stream;

import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;

public class JavaCodeJavadocComment implements IJavaCodeElement {

    private String comment;
    private IJavaCodeElement attachedTo;
    private List<NameTaggedComment> taggedParts;
    
    JavaCodeJavadocComment(String comment, IJavaCodeElement attachedTo) {
        this.comment = comment;
        final String marker = Tag.RETURN.getTag();
        int pos = comment.lastIndexOf(marker);
        if (pos > 0) {
            addReturnComment(comment.substring(pos + marker.length()).trim());
            this.comment = comment.substring(0, pos);
        }
        this.attachedTo = attachedTo;
    }
    
    private enum Tag {
        
        PARAM("param"),
        RETURN("return"),
        THROWS("throws");
        
        private String tag;
        
        private Tag(String tag) {
            this.tag = tag;
        }
        
        public String getTag() {
            return "@" + tag;
        }
        
    }
    
    private static class NameTaggedComment {
        
        private Tag tag;
        private String name;
        private String comment;
        
        private NameTaggedComment(Tag tag, String name, String comment) {
            this.tag = tag;
            this.name = name;
            this.comment = comment;
        }

        public void store(CodeWriter out) {
            String middle = "";
            if (name != null && name.length() > 0) {
                middle = " " + name;
            }
            out.printlnwi(" * " + tag.getTag() + middle + " " + comment);            
        }

    }
    
    @Invisible
    @Override
    public void store(CodeWriter out) {
        if (null != comment) {
            out.printlnwi("/**");
            out.printlnwi(" * " + comment);
            if (taggedParts != null) {
                if (attachedTo instanceof JavaCodeMethod) {
                    out.printlnwi(" *");
                    streamByTag(Tag.PARAM).forEach(t -> t.store(out));
                    streamByTag(Tag.RETURN).forEach(t -> t.store(out));
                    if (streamByTag(Tag.THROWS).count() > 0) {
                        out.printlnwi(" *");
                        streamByTag(Tag.THROWS).forEach(t -> t.store(out));
                    }
                }
            }
            out.printlnwi(" */");
        }
    }
    
    private Stream<NameTaggedComment> streamByTag(Tag tag) {
        return taggedParts.stream().filter(t -> t.tag == tag);
    }
    
    private JavaCodeJavadocComment addTaggedPart(Tag tag, String name, String comment) {
        if (null == taggedParts) {
            taggedParts = new ArrayList<>();
        }
        if (!taggedParts.stream().anyMatch(p -> p.tag == tag && p.name.equals(name))) {
            taggedParts.add(new NameTaggedComment(tag, name, comment));
        }
        return this;
    }
    
    public JavaCodeJavadocComment addParameterComment(String name, String comment) {
        return addTaggedPart(Tag.PARAM, name, comment);
    }

    public JavaCodeJavadocComment addReturnComment(String comment) {
        return addTaggedPart(Tag.RETURN, "", comment);
    }

    public JavaCodeJavadocComment addExceptionComment(String type, String comment) {
        return addTaggedPart(Tag.THROWS, type, comment);        
    }

    @Invisible
    @Override
    public IJavaCodeArtifact getArtifact() {
        return null;
    }
    
    @Override
    public String getStringValue(StringComparator comparator) {
        return "JavaComment";
    }

    @Override
    public IJavaCodeElement getParent() {
        return null;
    }

}
