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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;

import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.Annotation;
import org.eclipse.jdt.core.dom.Comment;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.MemberValuePair;
import org.eclipse.jdt.core.dom.NormalAnnotation;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.instantiation.java.Bundle;

/**
 * JDT AST parser helper methods.
 * 
 * @author Holger Eichelberger
 */
public class CodeParser {

    /**
     * Applies {@code consumer} to the list {@code supplier} by trying to convert the entries to {@code cls} while 
     * handling JDT exceptions.
     * 
     * @param <T> the expected element type
     * @param supplier the list supplier (the access may throw an exception)
     * @param cls the element type class
     * @param consumer the element consumer
     */
    static <T> void apply(Supplier<List<?>> supplier, Class<T> cls, Consumer<T> consumer) {
        try {
            List<?> list = supplier.get();
            if (null != list) {
                for (Object o: list) {
                    if (cls.isInstance(o)) {
                        consumer.accept(cls.cast(o));
                    }
                }
            }
        } catch (UnsupportedOperationException e) {
            EASyLoggerFactory.INSTANCE.getLogger(CodeParser.class, Bundle.ID)
                .debug("AST list access not supported: " + e.getMessage());
        }
    }
    
    static <T> T first(List<T> list, T dflt) {
        return get(list, 0, dflt);
    }

    static <T> T get(List<T> list, int pos, T dflt) {
        return pos < list.size() ? list.get(pos) : dflt;
    }

    interface EntryConsumer {
        
        public void accept(Object key, Object value);
        
    }
    
    static void apply(Supplier<Map<?, ?>> supplier, EntryConsumer consumer) {
        try {
            Map<?, ?> map = supplier.get();
            if (null != map) {
                for (Object p : map.entrySet()) {
                    if (p instanceof Map.Entry) {
                        @SuppressWarnings("unchecked")
                        Map.Entry<Object, Object> ent = (Map.Entry<Object, Object>) p;
                        consumer.accept(ent.getKey(), ent.getValue());
                    }
                }
            }
        } catch (UnsupportedOperationException e) {
            EASyLoggerFactory.INSTANCE.getLogger(CodeParser.class, Bundle.ID)
                .debug("AST map access not supported: " + e.getMessage());
        }
    }
    
    interface IdRestConsumer {
        
        public void accept(String id, String rest);
        
    }

    static void idRest(List<?> fragments, IdRestConsumer consumer) {
        consumer.accept(fragments.get(0).toString(), join(fragments, 1, -1));
    }
    
    static String join(List<?> fragments, int start, int end) {
        if (end < 0) {
            end = fragments.size();
        }
        String result = "";
        for (int i = start; i < end; i++) {
            if (result.length() > 0) {
                result += " ";
            }
            result += fragments.get(i);
        }
        return result.trim();
    }
    
    static String stringOf(String value) {
        String result = value.trim();
        if (result.startsWith("\"")) {
            result = result.substring(1);
        }
        if (result.endsWith("\"")) {
            result = result.substring(0, result.length() - 1);
        }
        return result;
    }
    
    static <T> void accept(Consumer<T> consumer, T value) {
        if (null != consumer) {
            consumer.accept(value);
        }
    }

    /**
     * Maps comments by their end position.
     * 
     * @param unit the compilation unit to take to comments from
     * @return the mapped comments
     */
    static Map<Integer, Comment> mapComments(CompilationUnit unit) {
        Map<Integer, Comment> result = new HashMap<>();
        if (null != unit) { // TODO prepare as hash
            for (Object o : unit.getCommentList()) {
                if (o instanceof Comment) {
                    Comment c = (Comment) o;
                    result.put(c.getStartPosition() + c.getLength(), c);
                }
            }
        }
        return result;
    }
    
    static String getComment(ASTNode node, Map<Integer, Comment> comments, char[] source) {
        return CodeParser.getComment(CodeParser.getCommentBefore(node, comments), source);
    }
    
    static String getComment(Comment comment, char[] source) {
        String result = null;
        if (null != comment) {
            if (comment.isBlockComment()) {
                result = new String(source, comment.getStartPosition() + 2, comment.getLength() - 4).trim();
            } // incomplete
        }
        return result;
    }

    static Comment getCommentBefore(ASTNode node, Map<Integer, Comment> comments) {
        Comment result = null; 
        if (null != comments) {
            for (int i = 1; null == result && i <= 3; i++) { // space -> line break
                result = comments.get(node.getStartPosition() - i); 
            }
        }
        return result;
    }

    static void visitCommentBefore(ASTNode node, Map<Integer, Comment> comments, ASTVisitor visitor) {
        Comment before = getCommentBefore(node, comments);
        if (null != before) {
            before.accept(visitor);
        }
    }

    static void visitCommentAfter(ASTNode node, Map<Integer, Comment> comments, ASTVisitor visitor) {
        Comment after = getCommentAfter(node, comments);
        if (null != after) {
            after.accept(visitor);
        }
    }

    static Comment getCommentAfter(ASTNode node, Map<Integer, Comment> comments) {
        Comment result = null; 
        if (null != comments) {
            int end = node.getStartPosition() + node.getLength();
            for (int i = 0; null == result && i <= 1; i++) { // line break
                result = comments.get(end + i); 
            }
        }
        return result;
    }

    static void processAnnotations(Supplier<List<?>> supplier, Consumer<Boolean> enabledConsumer, 
        Consumer<String> commentConsumer, JavaCodeAnnotationParent elt) {
        CodeParser.apply(supplier, Annotation.class, an -> {
            String fqt = an.getTypeName().getFullyQualifiedName();
            if ("VTL".equals(fqt)) {
                if (an instanceof NormalAnnotation) {
                    apply(() -> ((NormalAnnotation) an).values(), MemberValuePair.class, v -> {
                        if (v.getValue() != null) {
                            String name = v.getName().getIdentifier();
                            String value = v.getValue().toString();
                            if ("enabled".equals(name)) {
                                accept(enabledConsumer, Boolean.valueOf(value));
                            } else if ("comment".equals(name)) {
                                accept(commentConsumer, stringOf(value));
                            }
                        }
                    });
                }
            } else if (elt != null) {
                JavaCodeAnnotation jca = elt.addAnnotation(fqt);
                CodeParser.apply(() -> an.properties(), (k, v) -> {
                    jca.addArgument(k.toString(), v.toString());
                });
            }
        });
    }

}
