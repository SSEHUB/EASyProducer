/*
 * Copyright 2009-2015 University of Hildesheim, Software Systems Engineering
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
package de.uni_hildesheim.sse.easy.ui.productline_editor.instantiator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import de.uni_hildesheim.sse.BuildLangModelUtility;
import de.uni_hildesheim.sse.easy.ui.productline_editor.instantiator.TreeNode.InsertionPoint;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.BuildModel;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.BuildlangWriter;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.ExpressionStatement;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Resolver;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Rule;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.RuleCallExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Script;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.StrategyCallExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.CallArgument;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.Expression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IMetaOperation;
import net.ssehub.easy.basics.modelManagement.ModelInfo;

/**
 * Some tree utility methods.
 * 
 * @author Holger Eichelberger
 */
public class TreeUtils {

    /**
     * Returns the containing rule.
     * 
     * @param node the node to start searching at
     * @return the containing rule (<b>null</b> if there is no containing rule)
     */
    public static RuleTreeNode getContainingRule(TreeNode node) {
        RuleTreeNode result = null;
        TreeNode iter = node;
        while (null != iter && !(iter instanceof RuleTreeNode)) {
            iter = iter.getParent();
        }
        if (iter instanceof RuleTreeNode) {
            result = (RuleTreeNode) iter;
        }
        return result;
    }

    /**
     * Adds <code>text</code> to <code>error</code>.
     * 
     * @param error the error text accumulated so far (may be <b>null</b>)
     * @param text the text to be added
     * @return the modified error text
     */
    private static final String addErrorString(String error, String text) {
        if (null == error) {
            error = "";
        }
        if (error.length() > 0) {
            error += "\n-";
        }
        return error + text;
    }
    
    /**
     * Inserts <code>operation</code> at <code>node</code> into the containing rule considering
     * the <code>insertionPoint</code> and the user specified arguments.
     * 
     * @param script the script to insert into
     * @param node the node to insert at
     * @param insertionPoint the actual insertion point
     * @param operation the operation (call) to insert
     * @param arguments the user-supplied arguments of the call
     * @return <b>null</b> in case of success, the errors detected else
     */
    public static String insertOperation(Script script, TreeNode node, InsertionPoint insertionPoint, 
        IMetaOperation operation, Argument[] arguments) {
        BuildResolverVisitor resVis = new BuildResolverVisitor(script.getTypeRegistry(), node, insertionPoint);
        String error = null;
        try {
            script.accept(resVis);
        } catch (VilException e) {
            error = addErrorString(error, e.getMessage());
        }
        Resolver resolver = resVis.getResolver();
        StringBuilder warnings = new StringBuilder();
        CallArgument[] cArguments = new CallArgument[arguments.length];
        for (int a = 0; a < arguments.length; a++) {
            try {
                Expression expr = BuildLangModelUtility.INSTANCE.createExpression(arguments[a].getArgument(), 
                    resolver, warnings);
                cArguments[a] = new CallArgument(expr); // add name from arguments[a] if available
            } catch (VilException e) {
                error = addErrorString(error, e.getMessage());
            }
        }
        if (null == error) {
            try {
                Expression call;
                if (operation instanceof Rule) {
                    call = new RuleCallExpression(script, false, operation.getName(), cArguments);
                } else {
                    call = new StrategyCallExpression(script, operation.getName(), cArguments);
                }
                call.inferType();
                resVis.insertElement(new ExpressionStatement(call));
            } catch (VilException e) {
                error = addErrorString(error, e.getMessage());
            }
        }
        
        return error;
    }
    
    /**
     * Stores a VIL script.
     * 
     * @param script the script to be stored
     * @throws VilException in case of something going wrong
     */
    public static void store(Script script) throws VilException {
        ModelInfo<Script> info = BuildModel.INSTANCE.availableModels().getModelInfo(script);
        if (null != info) {
            File file = new File(info.getLocation());
            if (file.exists()) {
                file.delete();
            }
            try {
                FileWriter fileWriter = new FileWriter(file);
                BuildlangWriter writer = new BuildlangWriter(fileWriter);
                script.accept(writer);
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                throw new VilException(e.getMessage(), VilException.ID_IO);
            } catch (VilException e) {
                throw new VilException(e.getMessage(), VilException.ID_IO);
            }
        } else {
            throw new VilException("Location of script not available. Cannot save.", VilException.ID_INTERNAL);
        }
    }

}
