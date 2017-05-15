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
package de.uni_hildesheim.sse.ui.contentassist;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.ui.IImageHelper;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;

import com.google.inject.Inject;

import de.uni_hildesheim.sse.ivml.AdditiveExpression;
import de.uni_hildesheim.sse.ivml.AssignmentExpression;
import de.uni_hildesheim.sse.ivml.Call;
import de.uni_hildesheim.sse.ivml.EqualityExpression;
import de.uni_hildesheim.sse.ivml.Expression;
import de.uni_hildesheim.sse.ivml.ExpressionStatement;
import de.uni_hildesheim.sse.ivml.FeatureCall;
import de.uni_hildesheim.sse.ivml.ImplicationExpression;
import de.uni_hildesheim.sse.ivml.LogicalExpression;
import de.uni_hildesheim.sse.ivml.MultiplicativeExpression;
import de.uni_hildesheim.sse.ivml.PostfixExpression;
import de.uni_hildesheim.sse.ivml.PrimaryExpression;
import de.uni_hildesheim.sse.ivml.Project;
import de.uni_hildesheim.sse.ivml.RelationalExpression;
import de.uni_hildesheim.sse.ivml.ContainerOp;
import de.uni_hildesheim.sse.ivml.TypedefCompound;
import de.uni_hildesheim.sse.ivml.UnaryExpression;
import de.uni_hildesheim.sse.ivml.Value;
import de.uni_hildesheim.sse.translation.Utils;
import de.uni_hildesheim.sse.ui.resources.Images;
import net.ssehub.easy.basics.modelManagement.ModelInfo;
import net.ssehub.easy.varModel.management.VarModel;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.AttributeAssignment;
import net.ssehub.easy.varModel.model.ContainableModelElement;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.IModelElement;
import net.ssehub.easy.varModel.model.IvmlDatatypeVisitor;
import net.ssehub.easy.varModel.model.ModelQuery;
import net.ssehub.easy.varModel.model.ModelQueryException;
import net.ssehub.easy.varModel.model.datatypes.AnyType;
import net.ssehub.easy.varModel.model.datatypes.BooleanType;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.DerivedDatatype;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.IResolutionScope;
import net.ssehub.easy.varModel.model.datatypes.IntegerType;
import net.ssehub.easy.varModel.model.datatypes.Operation;
import net.ssehub.easy.varModel.model.datatypes.RealType;
import net.ssehub.easy.varModel.model.datatypes.Reference;
import net.ssehub.easy.varModel.model.datatypes.VersionType;

/**
 * Implements a proposal provider for IVML expressions. We separate the expression proposal provider
 * from the remainder of the proposal implementation to enable specialized embedded editors such as the constraint
 * editor to work with a restricted proposal provider. This class also provides access to the IVML model if available.
 * 
 * @author Dernek
 * @author Holger Eichelberger
 */
public class ExpressionProposalProvider extends AbstractIvmlProposalProvider  {

    @Inject
    private IImageHelper imageHelper; // make protected to allow use in extending class?
    
    /**
     * Check whether a given List is <b>null</b> or empty.
     * 
     * @param list
     *            The list to be checked.
     * @return <b>True</b> if the list is <b>null</b> or has no elements.
     *         <b>False</b> otherwise.
     */
    protected static boolean isEmpty(List<?> list) {
        return null == list || list.isEmpty();
    }
    
    /**
     * Provides access to the already created IVML model if available.
     * 
     * @param model the node representing the ECore Xtext model
     * @return the IVML project (<b>null</b> if not available)
     */
    protected net.ssehub.easy.varModel.model.Project getVarModel(EObject model) {
        net.ssehub.easy.varModel.model.Project result = null;
        try {
            URI uri = new URI(model.eResource().getURI().toString());
            ModelInfo<net.ssehub.easy.varModel.model.Project> info 
                = VarModel.INSTANCE.availableModels().getInfo(uri);
            if (null != info) {
                result = info.getResolved();
            }
        } catch (URISyntaxException e) {
            // ignore
        }
        return result;
    }

    /**
     * Finds the definition of a data type within the model represented by <code>model</code>.
     * 
     * @param model the node representing the ECore Xtext model
     * @param typeDef the containing type (may be <b>null</b> for the project represented by <code>typeDef</code>)
     * @param name the name of the type (may be <b>null</b> to search for the type of <code>typeDef</code>
     * @return the type definition or <b>null</b> if not found
     * @see #getVarModel(EObject)
     */
    protected IDatatype findType(EObject model, TypedefCompound typeDef, String name) {
        IDatatype result = null;
        String typeName = null == typeDef ? null : typeDef.getName();
        net.ssehub.easy.varModel.model.Project prj = getVarModel(model);
        if (null != prj) {
            IResolutionScope scope = prj;
            if (null != typeName) {
                try {
                    IDatatype type = ModelQuery.findElementByTypeName(prj, typeName, null);
                    if (null == name) {
                        result = type;
                    }
                    if (type instanceof IResolutionScope) {
                        scope = (IResolutionScope) type;
                    }
                } catch (ModelQueryException e) {
                    // ignore
                }
            }
            if (null != name) {
                try {
                    AbstractVariable var = ModelQuery.findVariable(scope, name, null);
                    if (null != var) {
                        result = var.getType();
                    }
                } catch (ModelQueryException e1) {
                    // ignore
                }
            }
        }
        return result;
    }

    /**
     * Propose declared variables on a compound <code>type</code>.
     * 
     * @param type the compound type
     * @param context the content assist context
     * @param acceptor the proposal acceptor
     * @param priority the maximum display priority to decrease per type refined type
     * @param done the already processed variables (variable names)
     */
    protected void propose(Compound type, ContentAssistContext context, 
        ICompletionProposalAcceptor acceptor, int priority, Set<String> done) {
        if (null != type) {
            for (int i = 0; i < type.getDeclarationCount(); i++) {
                propose(type.getDeclaration(i), context, acceptor, priority, done);
            }
            for (int a = 0; a < type.getAssignmentCount(); a++) {
                propose(type.getAssignment(a), context, acceptor, priority, done);
            }
            propose(type.getRefines(), context, acceptor, priority - 1, done);
        }
    }

    /**
     * Propose declared variables on the given attribute assignment.
     * 
     * @param assgn the attribute assignment
     * @param context the content assist context
     * @param acceptor the proposal acceptor
     * @param priority the maximum display priority to decrease per type refined type
     * @param done the already processed variables (variable names)
     */
    protected void propose(AttributeAssignment assgn, ContentAssistContext context, 
        ICompletionProposalAcceptor acceptor, int priority, Set<String> done) {
        for (int i = 0; i < assgn.getElementCount(); i++) {
            propose(assgn.getElement(i), context, acceptor, priority, done);
        }
        for (int a = 0; a < assgn.getAssignmentCount(); a++) {
            propose(assgn.getAssignment(a), context, acceptor, priority, done);
        }
    }
    
    /**
     * Proposes an IVML variable declaration.
     * 
     * @param decl the variable declaration
     * @param context the content assist context
     * @param acceptor the proposal acceptor
     * @param priority the display priority to use
     * @param done the already processed variables (variable names)
     */
    protected void propose(DecisionVariableDeclaration decl, ContentAssistContext context, 
        ICompletionProposalAcceptor acceptor, int priority, Set<String> done) {
        String name = decl.getName();
        if (!done.contains(name)) {
            IModelElement parent = decl.getParent();
            while (null != parent && !(parent instanceof Project || parent instanceof Compound)) {
                parent = parent.getParent(); // jump over attribute assignments
            }
            String parentNameSuffix = "";
            if (null != parent) {
                parentNameSuffix = " from " + parent.getName();
            }
            StyledString displayName = new StyledString();
            displayName.append(name + " : " + IvmlDatatypeVisitor.getUnqualifiedType(decl.getType()) + parentNameSuffix);
            ICompletionProposal proposal = createCompletionProposal(name, displayName,
                imageHelper.getImage(Images.NAME_VARIABLE), priority, // TODO check image
                context.getPrefix(), context);
            acceptor.accept(proposal);
        }
    }

    /**
     * Completes a literal value.
     * 
     * @param model the node representing the ECore Xtext model
     * @param assignment the assignment
     * @param context the content assist context
     * @param acceptor the proposal acceptor
     */
    @Override
    public void completeLiteral_Val(EObject model, Assignment assignment, ContentAssistContext context, 
        ICompletionProposalAcceptor acceptor) {
        net.ssehub.easy.varModel.model.Project project = getVarModel(model);
        if (null != project) {
            Set<String> done = new HashSet<String>();
            INode node = context.getCurrentNode();
            while (null != node) {
                EObject semElt = node.getSemanticElement();
                if (semElt instanceof TypedefCompound) {
                    try {
                        Compound type = (Compound) ModelQuery.findType(project, ((TypedefCompound) semElt).getName(), 
                            Compound.class);
                        propose(type, context, acceptor, 2000, done);
                    } catch (ModelQueryException e) {
                        // ignore
                    }
                } // consider attrAssignment??
                node = node.getParent();
            }
            for (int i = 0; i < project.getElementCount(); i++) {
                ContainableModelElement elt = project.getElement(i);
                if (elt instanceof DecisionVariableDeclaration) {
                    propose((DecisionVariableDeclaration) elt, context, acceptor, 1000, done);
                }
            }
        }
    }
    
    /**
     * Returns the <code>TypedefCompound</code>-object inside the declaration of this compound.
     * 
     * @param node the last complete node
     * @return <code>TypedefCompoundImpl</code>, maybe <b>null</b>.
     */
    protected TypedefCompound findTypedefCompound(INode node) {
        TypedefCompound result = null;
        if (null != node) {
            if (node.getSemanticElement() instanceof TypedefCompound) {
                result = (TypedefCompound) node.getSemanticElement();
            } else {
                INode parentNode = node.getParent();
                result = findTypedefCompound(parentNode);
            }
        }
        return result;
    }

    /**
     * Propose completions for a high-level prototype of expressions with (internal) functions.
     * 
     * @param model the node representing the ECore Xtext model
     * @param assignment the assignment
     * @param context the content assist context
     * @param acceptor the proposal acceptor
     */
    @Override
    public void completeLogicalExpressionPart_Op(EObject model, Assignment assignment, ContentAssistContext context, 
        ICompletionProposalAcceptor acceptor) {
        // take this as a high-level prototype each expression must go through
        proposeOperations(model, context, acceptor, false);
    }

    /**
     * Propose completions for a call.
     * 
     * @param model the node representing the ECore Xtext model
     * @param assignment the assignment
     * @param context the content assist context
     * @param acceptor the proposal acceptor
     */
    public void completeCall_Call(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        proposeOperations(model, context, acceptor, false);
    }

    /**
     * Propose completions for a set operation.
     * 
     * @param model the node representing the ECore Xtext model
     * @param assignment the assignment
     * @param context the content assist context
     * @param acceptor the proposal acceptor
     */
    public void completeCall_SetOp(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        proposeOperations(model, context, acceptor, true);
    }

    /**
     * Propose operations by inferring the actual IVML type. 
     * 
     * @param model the node representing the ECore Xtext model
     * @param context the content assist context
     * @param acceptor the proposal acceptor
     * @param containerOp propose only container operations
     */
    protected void proposeOperations(EObject model, ContentAssistContext context, ICompletionProposalAcceptor acceptor, 
        boolean containerOp) {
        INode prevNode = context.getCurrentNode().getPreviousSibling();
        EObject prev = null != prevNode ? prevNode.getSemanticElement() : null;
        if (prev instanceof ExpressionStatement) {
            ExpressionStatement ex = (ExpressionStatement) prev;
            prev = ex.getExpr();
        }
        IDatatype type = null;
        if (prev instanceof PrimaryExpression) {
            PrimaryExpression primEx = (PrimaryExpression) prev;
            if (null != primEx.getEx()) {
                TypedefCompound cmpDef = findTypedefCompound(context.getCurrentNode());
                type = inferType(primEx.getEx(), model, cmpDef);
            }
        } else if (prev instanceof Expression) {
            TypedefCompound cmpDef = findTypedefCompound(context.getCurrentNode());
            type = inferType((Expression) prev, model, cmpDef);
        }
        proposeOperations(type, context, acceptor, containerOp);
    }

    /**
     * Propose operations based on an IVML type. 
     * 
     * @param type the IVML type to propose operations for (may be <b>null</b>)
     * @param context the content assist context
     * @param acceptor the proposal acceptor
     * @param containerOp propose only container operations
     */
    private void proposeOperations(IDatatype type, ContentAssistContext context, ICompletionProposalAcceptor acceptor, 
        boolean containerOp) {
        if (null != type) {
            type = DerivedDatatype.resolveToBasis(type);
            type = Reference.dereference(type);
            for (int o = 0, n = type.getOperationCount(); o < n; o++) {
                Operation op = type.getOperation(o);
                if (containerOp == op.isContainerOperation()) {
                    String sig = stripSignature(op.getSignature());
                    String prop = "";
                    switch(op.getFormattingHint()) {
                    case FUNCTION_CALL:
                        prop = sig;
                        sig = op.getName() + "(";
                        for (int p = 0; p < op.getParameterCount(); p++) {
                            if (p > 0) {
                                sig += ", ";
                            }
                            sig += IvmlDatatypeVisitor.getUniqueType(op.getParameter(p));
                        }
                        sig += ")";
                        break;
                    case OPERATOR_INFIX:
                        sig = op.getName() + " " + IvmlDatatypeVisitor.getUnqualifiedType(op.getParameter(0));
                        prop = op.getName();
                        break;
                    case OPERATOR_POSTFIX:
                        sig = IvmlDatatypeVisitor.getUnqualifiedType(op.getOperand()) + " " + op.getName();
                        prop = op.getName();
                        break;
                    case OPERATOR_PREFIX:
                        sig = op.getName() +" " + IvmlDatatypeVisitor.getUnqualifiedType(op.getOperand());
                        prop = op.getName();
                        break;
                    }
                    StyledString displayName = new StyledString();
                    displayName.append(sig);
                    ICompletionProposal proposal = createCompletionProposal(prop, displayName,
                        imageHelper.getImage(Images.NAME_OPERATION), 400, // TODO check image
                        context.getPrefix(), context);
                    acceptor.accept(proposal);
                }
            }
        }        
    }
    
    /**
     * Removes the defining type from the signature.
     * 
     * @param signature the original signature
     * @return the stripped signature
     */
    private static String stripSignature(String signature) {
        int pos = signature.indexOf('.');
        if (pos > 0 && pos < signature.length() - 1) {
            signature = signature.substring(pos + 1);
        }
        return signature;
    }

    /**
     * Returns the IVML type for <code>expression</code>.
     * 
     * @param expression the expression to return the type for
     * @param model the node representing the ECore Xtext model
     * @param cmpDef the containing type definition (may be <b>null</b> for project)
     * @return the inferred type or <b>null</b> if no type is available
     */
    protected IDatatype inferType(Expression expression, EObject model, TypedefCompound cmpDef) {
        IDatatype result = null;
        if (null != expression.getExpr()) {
            result = inferType(expression.getExpr(), model, cmpDef);
        }
        return result;
    }

    /**
     * Returns the IVML type for <code>expression</code>.
     * 
     * @param expression the expression to return the type for
     * @param model the node representing the ECore Xtext model
     * @param cmpDef the containing type definition (may be <b>null</b> for project)
     * @return the inferred type or <b>null</b> if no type is available
     */
    protected IDatatype inferType(ImplicationExpression expression, EObject model, TypedefCompound cmpDef) {
        IDatatype result = null;
        // leftmost defines type
        if (null != expression.getLeft()) {
            result = inferType(expression.getLeft(), model, cmpDef);
        }
        return result;
    }

    /**
     * Returns the IVML type for <code>expression</code>.
     * 
     * @param expression the expression to return the type for
     * @param model the node representing the ECore Xtext model
     * @param cmpDef the containing type definition (may be <b>null</b> for project)
     * @return the inferred type or <b>null</b> if no type is available
     */
    protected IDatatype inferType(AssignmentExpression expression, EObject model, TypedefCompound cmpDef) {
        IDatatype result = null;
        // leftmost defines type
        if (null != expression.getLeft()) {
            result = inferType(expression.getLeft(), model, cmpDef);
        }
        return result;
    }

    /**
     * Returns the IVML type for <code>expression</code>.
     * 
     * @param expression the expression to return the type for
     * @param model the node representing the ECore Xtext model
     * @param cmpDef the containing type definition (may be <b>null</b> for project)
     * @return the inferred type or <b>null</b> if no type is available
     */
    protected IDatatype inferType(LogicalExpression expression, EObject model, TypedefCompound cmpDef) {
        IDatatype result = null;
        // leftmost defines type
        if (null != expression.getLeft()) {
            result = inferType(expression.getLeft(), model, cmpDef);
        }
        return result;
    }

    /**
     * Returns the IVML type for <code>expression</code>.
     * 
     * @param expression the expression to return the type for
     * @param model the node representing the ECore Xtext model
     * @param cmpDef the containing type definition (may be <b>null</b> for project)
     * @return the inferred type or <b>null</b> if no type is available
     */
    private IDatatype inferType(EqualityExpression expression, EObject model, TypedefCompound cmpDef) {
        IDatatype result = null;
        // leftmost defines type
        if (null != expression.getLeft()) {
            result = inferType(expression.getLeft(), model, cmpDef);
        }
        return result;
    }

    /**
     * Returns the IVML type for <code>expression</code>.
     * 
     * @param expression the expression to return the type for
     * @param model the node representing the ECore Xtext model
     * @param cmpDef the containing type definition (may be <b>null</b> for project)
     * @return the inferred type or <b>null</b> if no type is available
     */
    private IDatatype inferType(RelationalExpression expression, EObject model, TypedefCompound cmpDef) {
        IDatatype result = null;
        // leftmost defines type
        if (null != expression.getLeft()) {
            result = inferType(expression.getLeft(), model, cmpDef);
        }
        return result;
    }

    /**
     * Returns the IVML type for <code>expression</code>.
     * 
     * @param expression the expression to return the type for
     * @param model the node representing the ECore Xtext model
     * @param cmpDef the containing type definition (may be <b>null</b> for project)
     * @return the inferred type or <b>null</b> if no type is available
     */
    private IDatatype inferType(AdditiveExpression expression, EObject model, TypedefCompound cmpDef) {
        IDatatype result = null;
        // leftmost defines type
        if (null != expression.getLeft()) {
            result = inferType(expression.getLeft(), model, cmpDef);
        }
        return result;
    }

    /**
     * Returns the IVML type for <code>expression</code>.
     * 
     * @param expression the expression to return the type for
     * @param model the node representing the ECore Xtext model
     * @param cmpDef the containing type definition (may be <b>null</b> for project)
     * @return the inferred type or <b>null</b> if no type is available
     */
    private IDatatype inferType(MultiplicativeExpression expression, EObject model, TypedefCompound cmpDef) {
        IDatatype result = null;
        // leftmost defines type
        if (null != expression.getLeft()) {
            result = inferType(expression.getLeft(), model, cmpDef);
        }
        return result;
    }

    /**
     * Returns the IVML type for <code>expression</code>.
     * 
     * @param expression the expression to return the type for
     * @param model the node representing the ECore Xtext model
     * @param cmpDef the containing type definition (may be <b>null</b> for project)
     * @return the inferred type or <b>null</b> if no type is available
     */
    private IDatatype inferType(UnaryExpression expression, EObject model, TypedefCompound cmpDef) {
        IDatatype result = null;
        // leftmost defines type
        if (null != expression.getExpr()) {
            result = inferType(expression.getExpr(), model, cmpDef);
        }
        return result;
    }

    /**
     * Returns the IVML type for <code>expression</code>.
     * 
     * @param expression the expression to return the type for
     * @param model the node representing the ECore Xtext model
     * @param cmpDef the containing type definition (may be <b>null</b> for project)
     * @return the inferred type or <b>null</b> if no type is available
     */
    private IDatatype inferType(PostfixExpression expression, EObject model, TypedefCompound cmpDef) {
        IDatatype result = null;
        // leftmost defines type
        if (null != expression.getLeft()) {
            result = inferType(expression.getLeft(), model, cmpDef);
        } else if (null != expression.getCall()) {
            result = inferType(expression.getCall(), null, model, cmpDef);
            if (null != expression.getFCalls()) {
                result = inferType(expression.getFCalls(), result, model, cmpDef);
            }
            // TODO access
        } 
        return result;
    }

    /**
     * Returns the IVML type for <code>expression</code>.
     * 
     * @param expression the expression to return the type for
     * @param model the node representing the ECore Xtext model
     * @param cmpDef the containing type definition (may be <b>null</b> for project)
     * @return the inferred type or <b>null</b> if no type is available
     */
    private IDatatype inferType(PrimaryExpression expression, EObject model, TypedefCompound cmpDef) {
        IDatatype result = null;
        if (null != expression.getLit()) {
            result = inferType(expression.getLit().getVal(), model, cmpDef);
        } else if (null != expression.getEx()) {
            result = inferType(expression.getEx(), model, cmpDef);
        } // TODO ifex, refBy
        if (null != expression.getCalls()) {
            inferType(expression.getCalls(), result, model, cmpDef);
        } 
        // TODO access
        return result;
    }

    /**
     * Returns the IVML type for a chain of <code>calls</code>.
     * 
     * @param expression the expression to return the type for
     * @param model the node representing the ECore Xtext model
     * @param cmpDef the containing type definition (may be <b>null</b> for project)
     * @return the inferred type or <b>null</b> if no type is available
     */
    private IDatatype inferType(List<Call> calls, IDatatype operand, EObject model, TypedefCompound cmpDef) {
        for (int i = 0; i < calls.size(); i++) {
            operand = inferType(calls.get(i), operand, model, cmpDef);
        }
        return operand;
    }
    
    /**
     * Returns the IVML type for a <code>call</code>.
     * 
     * @param expression the expression to return the type for
     * @param model the node representing the ECore Xtext model
     * @param cmpDef the containing type definition (may be <b>null</b> for project)
     * @return the inferred type or <b>null</b> if no type is available
     */
    private IDatatype inferType(Call call, IDatatype operand, EObject model, TypedefCompound cmpDef) {
        IDatatype result = null;
        if (null != operand) {
            if (null != call.getCall()) {
                result = inferType(call.getCall(), operand, model, cmpDef);
            } else if (null != call.getContainerOp()) {
                ContainerOp sOp = call.getContainerOp();
                List<Expression> args = sOp.getArgs();
                int pCount = null == args ? 0 : args.size();
                IDatatype[] param = new IDatatype[pCount];
                for (int p = 0; p < pCount; p++) {
                    param[p] = inferType(args.get(p), model, cmpDef);
               }
                result = inferType(sOp.getName(), operand, param, true);
            } else if (null != call.getArrayEx()) {
                result = null; // TODO
            }
        }
        return result;
    }

    /**
     * Returns the IVML type for a <code>call</code>.
     * 
     * @param expression the expression to return the type for
     * @param operand the operand type (may be <b>null</b>, use first parameter type [implicit operand] instead if 
     *   present)
     * @param model the node representing the ECore Xtext model
     * @param cmpDef the containing type definition (may be <b>null</b> for project)
     * @return the inferred type or <b>null</b> if no type is available
     */
    private IDatatype inferType(FeatureCall call, IDatatype operand, EObject model, TypedefCompound cmpDef) {
        List<Expression> args = call.getArgs();
        IDatatype[] pTypes = null;
        if (null != args) {
                int offset = 0;
                if (null == operand && !args.isEmpty()) {
                    // if not explicitly given, determine from first (implicit) parameter
                    operand = inferType(args.get(0), model, cmpDef);
                    offset = 1;
                }
                if (args.size() > offset) {
                    pTypes = new IDatatype[args.size() - offset];
                    for (int e = offset; e < args.size(); e++) {
                        pTypes[e - offset] = inferType(args.get(e), model, cmpDef);
                    }
                }
        }
        return inferType(call.getName(), operand, pTypes, false);
    }

    /**
     * Determines the type of the operation <code>name</code> on <code>operand</code> with given parameters.
     * 
     * @param name the name of the operation
     * @param operand the operand type
     * @param pTypes the parameter types (may be <b>null</b>)
     * @param containerOp propose only container operations
     * @return the inferred type or <b>null</b> if no type is available
     */
    private IDatatype inferType(String name, IDatatype operand, IDatatype[] pTypes, boolean containerOp) {
        IDatatype result = null;
        operand = Reference.dereference(operand);
        operand = DerivedDatatype.resolveToBasis(operand);
        for (int o = 0; null == result && o < operand.getOperationCount(); o++) {
            Operation op = operand.getOperation(o);
            if (containerOp == op.isContainerOperation() && op.getName().equals(name)) {
                boolean ok;
                int pCount = op.getParameterCount();
                if (0 == pCount) {
                    ok = (null == pTypes || 0 == pTypes.length);
                } else {
                    ok = (null != pTypes && pCount == pTypes.length);
                }
                for (int p = 0; ok && p < pCount; p++) {
                    ok = op.getParameter(p).isAssignableFrom(pTypes[p]);
                }
                if (ok) {
                    result = op.getActualReturnType(operand, pTypes);
                }
            }
        }
        return result;
    }

    /**
     * Returns the IVML type for <code>vale</code>.
     * 
     * @param value the value to return the type for
     * @param model the node representing the ECore Xtext model
     * @param cmpDef the containing type definition (may be <b>null</b> for project)
     * @return the inferred type or <b>null</b> if no type is available
     */
    private IDatatype inferType(Value value, EObject model, TypedefCompound cmpDef) {
        IDatatype type = null;
        if (null != value.getNValue()) {
            String tmp = value.getNValue().getVal();
            if (tmp.indexOf('.') >= 0) {
                type = RealType.TYPE;
            } else {
                type = IntegerType.TYPE;
            }
        } else if (null != value.getBValue()) {
            type = BooleanType.TYPE;
        } else if (null != value.getSelf()) {
            type = findType(model, cmpDef, null);
        } else if (null != value.getSValue()) {
            type = BooleanType.TYPE;
        } else if (null != value.getVersion()) {
            type = VersionType.TYPE;
        } else if (null != value.getQValue()) {
            String qName = Utils.getQualifiedNameString(value.getQValue());
            type = findType(model, cmpDef, qName);
        } else if (null != value.getNullValue()) {
            type = AnyType.TYPE;
        }
        return type;
    }

}