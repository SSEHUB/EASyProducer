package de.uni_hildesheim.sse.translation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.nodemodel.BidiTreeIterator;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;

import de.uni_hildesheim.sse.model.varModel.Comment;
import de.uni_hildesheim.sse.model.varModel.IModelElement;
import de.uni_hildesheim.sse.model.varModel.ModelElement;
import de.uni_hildesheim.sse.model.varModel.StructuredComment;

/**
 * Methods for accessing and converting comments.
 * 
 * @author Holger Eichelberger
 */
class CommentUtils {

    private static final String TOKEN_WHITESPACE = "WS";
    private static final String TOKEN_SL_COMMENT = "SL_COMMENT";
    private static final String TOKEN_ML_COMMENT = "ML_COMMENT";
    
    /**
     * Handles the comments assigned to the EMF AST element <code>object</code>.
     * This method does not add the result to some project, context, etc.
     * 
     * @param object the EMF AST element to analyze
     * @return the resulting comment as string (may be <b>null</b> if there is no comment)
     */
    static String commentsToString(EObject object) {
        // detection of comments is a bit strange and I'm not sure how many
        // comments can actually be detected in this way. it goes
        // 1) determine parse tree node of EObject (a composite node)
        // 2) if comments are given, then they occur as nodes at the beginning of the
        //    composite (we assign the preceeding comments as usual in programming languages)
        // 3) run over contained nodes, ignore leading rule calls, collect whitespaces and 
        //    comments
        ICompositeNode cnode = NodeModelUtils.getNode(object);
        String result = null;
        if (null != cnode) {
            StringBuilder commentBuilder = null;
            BidiTreeIterator<INode> iter = cnode.getAsTreeIterable().iterator();
            String lastType = null;
            while (iter.hasNext()) {
                INode cur = iter.next();
                EObject grammarElement = cur.getGrammarElement();
                if (grammarElement instanceof TerminalRule) {
                    TerminalRule terminal = (TerminalRule) grammarElement;
                    String name = terminal.getName();
                    boolean isWs = name.equals(TOKEN_WHITESPACE);
                    if (isWs || name.equals(TOKEN_SL_COMMENT) || name.equals(TOKEN_ML_COMMENT)) {
                        if (!isWs) {
                            lastType = name;
                        }
                        if (null == commentBuilder) {
                            commentBuilder = new StringBuilder();                            
                        }
                        commentBuilder.append(cur.getText());
                    }
                } else {
                    if (!(grammarElement instanceof RuleCall)) {
                        break;
                    }
                }
            }
            if (null != commentBuilder) {
                // skip pure indentation
                int start = 0;
                int size = commentBuilder.length();
                while (start < size && Character.isWhitespace(commentBuilder.charAt(start))) {
                    start++;
                }
                if (start >= size) {
                    commentBuilder = null;
                }
            }            
            if (null != commentBuilder) {
                // some heuristics... better approach is welcome - however, I tried to keep the IVMLWriter and 
                // its newline formatting
                int start = 0;
                while (start < commentBuilder.length() && Character.isWhitespace(commentBuilder.charAt(start)) 
                    && !Character.isSpaceChar(commentBuilder.charAt(start))) {
                    start++;
                }
                // skip trailing spaces -> indentation
                int end = commentBuilder.length() - 1;
                if (TOKEN_SL_COMMENT.equals(lastType)) {
                    int lastNonWsChar = end;
                    boolean firstNonWsChar = true;
                    while (end >= 0 && Character.isWhitespace(commentBuilder.charAt(end))) {
                        if (!Character.isSpaceChar(commentBuilder.charAt(end)) && firstNonWsChar) {
                            lastNonWsChar = end;
                            firstNonWsChar = false;
                        }
                        end--;
                    }
                    if (lastNonWsChar < commentBuilder.length()) {
                        end = lastNonWsChar + 1;
                    }
                } else {
                    while (end >= 0 && Character.isSpaceChar(commentBuilder.charAt(end))) {
                        end--;
                    }
                }
                if (start > end) {
                    start = 0;
                    end = commentBuilder.length();
                }
                result = commentBuilder.substring(start, end);
            }
        }
        return result;
    }

    /**
     * Creates a {@link Comment} from comments assigned to the EMF AST element <code>object</code>.
     * This method does not add the result to some project, context, etc.
     * 
     * @param object the EMF AST element to analyze
     * @param parent the parent of the new comment in the IVML object model
     * @return the resulting comment as string (may be <b>null</b> if there is no comment)
     */
    static Comment toComment(EObject object, IModelElement parent) {
        Comment result;
        String comment = commentsToString(object);
        if (null == comment) {
            result = null;
        } else {
            result = new Comment(comment, parent);
        }
        return result;
    }

    /**
     * Creates a {@link Comment} from comments assigned to the EMF AST element <code>object</code>.
     * This method does not add the result to some project, context, etc.
     * 
     * @param object the EMF AST element to analyze
     * @param parent the parent of the new comment in the IVML object model
     * @return the resulting comment as string (may be <b>null</b> if there is no comment)
     */
    static StructuredComment toStructuredComment(EObject object, ModelElement parent) {
        StructuredComment result;
        String comment = commentsToString(object);
        if (null == comment) {
            result = null;
        } else {
            result = new StructuredComment(comment, parent);
        }
        return result;
    }

    /**
     * Creates a {@link Comment} from comments assigned to the EMF AST element <code>object</code>.
     * This method does not add the result to some project, context, etc.
     * 
     * @param object the EMF AST element to analyze
     * @param context the resolution context
     * @return the resulting comment as string (may be <b>null</b> if there is no comment)
     */
    static StructuredComment ensureStructuredComment(EObject object, TypeContext context) {
        StructuredComment result;
        String comment = commentsToString(object);
        if (null == comment) {
            result = new StructuredComment(null, context.getProject());
        } else {
            result = new StructuredComment(comment, context.getProject());
        }
        context.addToProject(null, null, result);
        return result;
    }
    
    /**
     * Prints out a test and thereby emits explicit characters for marking the
     * line feed. [debug]
     * 
     * @param comment the comment to be printed out
     */
    static void println(String comment) {
        System.out.println(comment.replaceAll("\r", "\\\\r").replaceAll("\n", "\\\\n"));
    }
    
}
