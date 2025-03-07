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
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;

import net.ssehub.easy.instantiation.core.model.templateModel.CodeWriter;
import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;

/**
 * Represents a Javadoc comment. This class cares for HTML output quoting.
 * 
 * @author Holger Eichelberger
 */
public class JavaCodeJavadocComment implements IJavaCodeElement {

    private static final Set<String> HTML_ELEMENTS = Set.of("code", "br", "p", "div", "it", "ul", "ol", "li", "b", "i");
    private static final Set<Character> HTML_ESCAPES = Set.of('’');
    
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
        if (null != comment) {
            final String marker = Tag.RETURN.getTag();
            int pos = comment.lastIndexOf(marker);
            if (pos > 0) {
                addReturnComment(comment.substring(pos + marker.length()).trim());
                this.comment = comment.substring(0, pos);
            }
        }
        this.attachedTo = attachedTo;
    }
    
    private enum Tag {
        
        GENERIC("param"),
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
                middle = " ";
                String n = name;
                if (Tag.GENERIC == tag) {
                    if (!n.startsWith("<")) {
                        n = "<" + n;
                    }
                    if (!n.endsWith(">")) {
                        n = n + ">";
                    }
                }
                middle += n;
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
        if (null != taggedParts && !taggedParts.isEmpty()) {
            storeTagsImpl(out);
        }
    }
    
    private void storeTagsImpl(CodeWriter out) {
        boolean withReturnThrows = false;
        boolean withParam = false;
        if (attachedTo instanceof JavaCodeMethod) {
            withReturnThrows = true;
            withParam = true;
        } else if (attachedTo instanceof JavaCodeClass) {
            withParam = true;
        }
        if (withReturnThrows || withParam) {
            AtomicInteger before = new AtomicInteger();
            out.printlnwi(" *");
            if (withParam) {
                streamByTag(Tag.GENERIC).forEach(t -> t.store(out, before));
                streamByTag(Tag.PARAM).forEach(t -> t.store(out, before));
            }
            if (withReturnThrows) {
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
    
    private Optional<NameTaggedComment> getTag(Tag tag, String name) {
        return null == taggedParts 
            ? Optional.empty() 
            : taggedParts.stream().filter(p -> p.tag == tag && p.name.equals(name)).findAny();
    }
    
    private JavaCodeJavadocComment addTaggedPart(Tag tag, String name, String comment) {
        if (null == taggedParts) {
            taggedParts = new ArrayList<>();
        }
        Optional<NameTaggedComment> t = getTag(tag, name);
        if (t.isEmpty()) {
            taggedParts.add(new NameTaggedComment(tag, name, comment));
        } else {
            t.get().comment = comment;
        }
        return this;
    }
    
    void setAttachedTo(IJavaCodeElement attachedTo) {
        this.attachedTo = attachedTo;
    }
    
    public String getComment() {
        return comment;
    }

    /**
     * Changes the main comment text.
     * 
     * @param comment the comment text
     * @return <b>this</b>
     */
    public JavaCodeJavadocComment setComment(String comment) {
        this.comment = comment;
        return this;
    }
    
    /**
     * Changes the main comment text and the return value comment text.
     * 
     * @param comment the comment text
     * @param returnComment the return comment text
     * @return <b>this</b>
     */
    public JavaCodeJavadocComment setComment(String comment, String returnComment) {
        setComment(comment);
        return addReturnComment(returnComment);
    }

    /**
     * Adds text to the main comment text.
     * 
     * @param comment the comment text
     * @return <b>this</b>
     */
    public JavaCodeJavadocComment addComment(String comment) {
        if (null == this.comment) {
            setComment(comment);
        } else {
            this.comment += comment;
        }
        return this;
    }

    /**
     * Adds/changes a generic comment.
     * 
     * @param name the name of the generic
     * @param comment the comment text
     * @return <b>this</b>
     */
    public JavaCodeJavadocComment addGenericComment(String name, String comment) {
        return addTaggedPart(Tag.GENERIC, name, comment);
    }

    /**
     * Adds/changes a parameter comment.
     * 
     * @param name the name of the parameter
     * @param comment the comment text
     * @return <b>this</b>
     */
    public JavaCodeJavadocComment addParameterComment(String name, String comment) {
        return addTaggedPart(Tag.PARAM, name, comment);
    }
    
    public JavaCodeJavadocComment deleteParameterComment(String name) {
        taggedParts.removeIf(t -> t.tag == Tag.PARAM && t.name.equals(name));
        return this;
    }

    /**
     * Adds/changes the return comment.
     * 
     * @param comment the comment text
     * @return <b>this</b>
     */
    public JavaCodeJavadocComment addReturnComment(String comment) {
        return addTaggedPart(Tag.RETURN, "", comment);
    }

    /**
     * Adds/changes an exception comment.
     * 
     * @param type the exception type, may be qualified
     * @param comment the comment text
     * @return <b>this</b>
     */
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
     * Returns whether a char shall be skipped that the beginning or end of a potential HTML
     * element, i.e., whitespaces as well as opening or closing brackets.
     * 
     * @param ch the character
     * @param left skip left or right
     * @return {@code true} for skip, {@code false} for not skip
     */
    private static boolean skipHtmlChar(char ch, boolean left) {
        return Character.isWhitespace(ch) || left ? ch == '<' : ch == '>';
    }
    
    /**
     * Returns whether {@code text} is probably an HTML element based on a lookup in {@link #HTML_ELEMENTS}.
     * 
     * @param text the text
     * @return {@code true} for HTML element, {@code false} else
     */
    private static boolean isHtmlElement(String text) {
        boolean result = false;
        int left = 0;
        while (left < text.length() && skipHtmlChar(text.charAt(left), true)) {
            left++;
        }
        int right = text.length() - 1;
        while (right >= 0 && skipHtmlChar(text.charAt(right), false)) {
            right--;
        }
        if (left > 0 && right < text.length()) {
            String elt = text.substring(left, right + 1);
            if (elt.startsWith("/")) {
                elt = elt.substring(1);
            } else if (elt.endsWith("/")) {
                elt = elt.substring(0, elt.length() - 1);
            }
            result = HTML_ELEMENTS.contains(elt);
        }
        return result;
    }

    /**
     * Implements the plain HTML escaping with exceptions taken from {@link #HTML_ESCAPES}.
     * 
     * @param text the text to escape
     * @return the escaped text
     */
    private static String escapeHtmlImpl(String text) {
        return IJavaCodeElement.escape(text, HTML_ESCAPES, StringEscapeUtils::escapeHtml);
    }
    
    /**
     * Relaxed escaping for Javadoc HTML. Implements a simple heuristic that everything
     * that is within &lt; &gt; is considered as an element and not escaped while everything
     * outside is escaped.
     * 
     * @param text the text to escape
     * @return the escaped text
     * @see #escapeHtmlImpl(String)
     */
    @Invisible
    public static String escapeHtml(String text) {
        String[] split = text.split("\"");
        for (int i = 0; i < split.length; i++) {
            String tmp = split[i];
            String tmpRes = "";
            boolean inElement = false;
            int jLastOpen = -1;
            int jLastSplit = 0;
            for (int j = 0; j < tmp.length(); j++) {
                char c = tmp.charAt(j);
                if (c == '<') {
                    inElement = true;
                    jLastOpen = j;
                } else if (c == '>') {
                    if (inElement && jLastOpen >= 0) {
                        tmpRes += escapeHtmlImpl(tmp.substring(jLastSplit, jLastOpen));
                        jLastSplit = j + 1;
                        String elt = tmp.substring(jLastOpen, jLastSplit);
                        if (!isHtmlElement(elt)) {
                            elt = escapeHtmlImpl(elt);
                        }
                        tmpRes += elt;
                        inElement = false;
                    }
                }
            }
            tmpRes += escapeHtmlImpl(tmp.substring(jLastSplit, tmp.length()));
            split[i] = tmpRes;
        }
        text = String.join("\"", split);
        return text;
    }

    /**
     * Copies comment information over from {@code comment}, may overwrite existing information.
     * 
     * @param comment the comment to take information from, may be <b>null</b>
     */
    @Invisible
    public void copyFrom(JavaCodeJavadocComment comment) {
        if (null != comment) {
            if (null != comment.comment) {
                this.comment = comment.comment;
            }
            if (null != comment.taggedParts) {
                for (NameTaggedComment part : comment.taggedParts) {
                    addTaggedPart(part.tag, part.name, part.comment);
                }
            }
        }
    }

    void adjustException(JavaCodeTypeSpecification exc) {
        Optional<NameTaggedComment> t = getTag(Tag.THROWS, exc.getFullName());
        if (t.isPresent()) {
            t.get().name = exc.getOutputTypeName();
        }
    }

}
