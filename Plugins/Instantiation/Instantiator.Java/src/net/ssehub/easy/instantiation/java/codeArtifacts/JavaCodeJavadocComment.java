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
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;

import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;

/**
 * Represents a Javadoc comment. This class cares for HTML output quoting.
 * 
 * @author Holger Eichelberger
 */
public class JavaCodeJavadocComment implements IJavaCodeElement {

    private String comment;
    private IJavaCodeElement attachedTo;
    private List<NameTaggedComment> taggedParts;
    
    /**
     * Creates an instance.
     * 
     * @param comment the comment text
     * @param attachedTo the element this comment is attached to.
     */
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

        public void store(CodeWriter out, AtomicInteger count) {
            String middle = "";
            if (name != null && name.length() > 0) {
                middle = " " + name;
            }
            out.printlnwi(" * " + tag.getTag() + middle + " " + escapeHtml(comment));
            if (null != count) {
                count.incrementAndGet();
            }
        }

    }
    
    @Invisible
    @Override
    public void store(CodeWriter out) {
        if (null != comment) {
            out.printlnwi("/**");
            String[] lines = comment.split("\\n");
            for (String l : lines) {
                out.printlnwi(" * " + escapeHtml(l.trim()));
            }
            storeTags(out);
            out.printlnwi(" */");
        }
    }
    
    private void storeTags(CodeWriter out) {
        if (null != taggedParts) {
            if (attachedTo instanceof JavaCodeMethod) {
                AtomicInteger before = new AtomicInteger();
                out.printlnwi(" *");
                streamByTag(Tag.PARAM).forEach(t -> t.store(out, before));
                streamByTag(Tag.RETURN).forEach(t -> t.store(out, before));
                if (streamByTag(Tag.THROWS).count() > 0) {
                    if (before.get() > 0) {
                        out.printlnwi(" *");
                    }
                    streamByTag(Tag.THROWS).forEach(t -> t.store(out, null));
                }
            }
        }
    }
    
    @Override
    public int getElementCount() {
        int result = 0;
        if (null != comment) {
            result += 1 + StringUtils.countMatches(comment, "\\n");
            if (null != taggedParts) {
                if (attachedTo instanceof JavaCodeMethod) {
                    result += taggedParts.size();
                }
            }
        }
        return result;
    }    
    
    private Stream<NameTaggedComment> streamByTag(Tag tag) {
        return taggedParts.stream().filter(t -> t.tag == tag);
    }
    
    private JavaCodeJavadocComment addTaggedPart(Tag tag, String name, String comment) {
        if (null == taggedParts) {
            taggedParts = new ArrayList<>();
        }
        Optional<NameTaggedComment> t = taggedParts.stream().filter(p -> p.tag == tag && p.name.equals(name)).findAny();
        if (t.isEmpty()) {
            taggedParts.add(new NameTaggedComment(tag, name, comment));
        } else {
            t.get().comment = comment;
        }
        return this;
    }
    
    public JavaCodeJavadocComment setComment(String comment) {
        this.comment = comment;
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
    public IJavaCodeElement getParent() {
        return null;
    }

    @Override
    public void setParent(IJavaCodeElement parent) {
    }
    
    /**
     * Relaxed escaping for Javadoc HTML.
     * 
     * @param text the text to escape
     * @return the escaped text
     */
    public static String escapeHtml(String text) {
        String[] split = text.split("\"");
        for (int i = 0; i < split.length; i++) {
            split[i] = StringEscapeUtils.escapeHtml(split[i]);
        }
        text = String.join("\"", split);
        return text;
    }

}
