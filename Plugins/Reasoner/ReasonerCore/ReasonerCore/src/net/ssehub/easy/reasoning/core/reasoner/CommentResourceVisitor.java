/*
 * Copyright 2009-2021 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.reasoning.core.reasoner;

import java.io.StringWriter;
import java.io.Writer;

import net.ssehub.easy.varModel.cst.CompoundAccess;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;
import net.ssehub.easy.varModel.cst.Variable;
import net.ssehub.easy.varModel.management.CommentResource;
import net.ssehub.easy.varModel.management.ModelCommentsPersistencer;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.IModelElement;
import net.ssehub.easy.varModel.model.datatypes.OclKeyWords;
import net.ssehub.easy.varModel.model.datatypes.Operation.FormattingHint;
import net.ssehub.easy.varModel.persistency.IVMLWriter;
import net.ssehub.easy.varModel.persistency.StringProvider;

/**
 * A visitor turning (partial) IVML elements into more or less explainable strings based on a given 
 * {@code CommentResource}. IVML operations can be turned into strings through a pseudo signature of "." as operator 
 * and arguments, e.g., using "isDefined(.)" as key. Variables are read from {@code CommentResource} as such.
 * 
 * @author Holger Eichelberger
 */
public class CommentResourceVisitor extends IVMLWriter {
    
    private CommentResource comments;

    /**
     * Creates a visitor instance.
     * 
     * @param out the output writer
     * @param comments the comment resource, may be <b>null</b> for none
     */
    private CommentResourceVisitor(Writer out, CommentResource comments) {
        super(out);
        setWriter(out); // below IVMLWriter the constructor argument is turned into a BufferedString :/
        this.comments = comments;
    }

    /**
     * Visits a model element and returns the translated elements as String. Without a properly defined comments
     * resource, this shall lead to similar results as delivered by {@link StringProvider}.
     * 
     * @param elt the element to visit
     * @param comments the comment resource, may be <b>null</b> for none
     * 
     * @return the translated string
     */
    public static String visit(IModelElement elt, CommentResource comments) {
        StringWriter out = new StringWriter();
        elt.accept(new CommentResourceVisitor(out, comments));
        return out.toString();
    }

    @Override
    protected void appendOCLFeatureCall(OCLFeatureCall call, FormattingHint hint) {
        String key = call.getOperation();
        String closing;
        if (OclKeyWords.INDEX_ACCESS.equals(key)) {
            key += "[";
            closing = "]";
        } else {
            key += "(";
            closing = ")";
        }
        for (int i = 0; i <= call.getParameterCount(); i++) { // include the operand!!
            if (i > 0) {
                key += ",";
            }
            key += ".";
        }
        key += closing;
        if (null != getComment(key)) {
            String[] args = new String[call.getParameterCount() + 1];
            int pos = 0;
            Writer old = getWriter();
            StringWriter tmp = new StringWriter();
            setWriter(tmp);
            call.getOperand().accept(this);
            args[pos++] = tmp.toString();
            
            for (int i = 0; i < call.getParameterCount(); i++) {
                tmp = new StringWriter();
                setWriter(tmp);
                call.getParameter(i).accept(this);
                args[pos++] = tmp.toString();
            }
            setWriter(old);
            appendComment(key, args);
        } else {
            super.appendOCLFeatureCall(call, hint);
        }
    }
    
    @Override
    public void visitConstraint(Constraint constraint) {
        if (!appendComment(ModelCommentsPersistencer.getKey(constraint), null)) {
            Writer old = getWriter();
            StringWriter tmp = new StringWriter();
            setWriter(tmp);
            constraint.getConsSyntax().accept(this);
            setWriter(old);
            String tmpStr = tmp.toString();
            if (tmpStr.length() == 0) {
                super.visitConstraint(constraint);
            } else {
                appendOutput(tmpStr);
            }
        }
    }
    
    @Override
    public void visitVariable(Variable variable) {
        AbstractVariable var = variable.getVariable();
        if (!appendComment(var.getQualifiedName(), null)) {
            super.visitVariable(variable);
        }
    }
    
    /**
     * Returns the comment for {@code key}.
     * 
     * @param key the key (may be <b>null</b>)
     * @return the comment or <b>null</b> for none
     */
    private String getComment(String key) {
        String result = null;
        if (key != null && null != comments) {
            result = comments.get(key);
        }
        return result;
    }

    /**
     * Appends a comment taken from the comments resource.
     * 
     * @param key the key (may be <b>null</b>)
     * @param args the arguments for an operation, replacing "{i}" with i a non-negative integer denoting 
     *   operand (0) and parameter (1..)
     * @return {@code true} if the operation was performed and something was appended to this writer, {@code false} else
     */
    private boolean appendComment(String key, String[] args) {
        boolean done = false;
        String comment = getComment(key);
        if (null != comment) {
            if (null != args) {
                for (int i = 0; i < args.length; i++) {
                    comment = comment.replace("{" + i + "}", args[i]);
                }
            }
            appendOutput(comment);
            done = true;
        }
        return done;
    }
    
    @Override
    public void visitCompoundAccess(CompoundAccess access) {
        IVMLWriter bypassWriter = IVMLWriter.getInstance(new StringWriter());
        // determine the full expression first and use it as key. Does not work with this visitor as otherwise
        // replacements happen
        access.accept(bypassWriter);
        String key = bypassWriter.getWriter().toString();
        IVMLWriter.releaseInstance(bypassWriter);

        // if we have a key, done - else, delegate
        if (!appendComment(key, null)) {
            super.visitCompoundAccess(access);
        }
    }

    
}
