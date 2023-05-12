package de.uni_hildesheim.sse.translation;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.uni_hildesheim.sse.ivml.AccessName;
import de.uni_hildesheim.sse.ivml.AnnotateTo;
import de.uni_hildesheim.sse.ivml.AttrAssignment;
import de.uni_hildesheim.sse.ivml.Eval;
import de.uni_hildesheim.sse.ivml.ExpressionStatement;
import de.uni_hildesheim.sse.ivml.Freeze;
import de.uni_hildesheim.sse.ivml.IvmlPackage;
import de.uni_hildesheim.sse.ivml.OpDefStatement;
import de.uni_hildesheim.sse.ivml.QualifiedName;
import de.uni_hildesheim.sse.ivml.Typedef;
import de.uni_hildesheim.sse.ivml.VariableDeclaration;
import de.uni_hildesheim.sse.ivml.VariableDeclarationPart;
import net.ssehub.easy.dslCore.translation.MessageReceiver;
import net.ssehub.easy.dslCore.translation.TranslatorException;
import net.ssehub.easy.varModel.cstEvaluation.DispatchInformation;
import net.ssehub.easy.varModel.management.VarModel;
import net.ssehub.easy.varModel.model.Comment;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.IModelElement;
import net.ssehub.easy.varModel.model.IvmlDatatypeVisitor;
import net.ssehub.easy.varModel.model.OperationAnnotations;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.StructuredComment;
import net.ssehub.easy.varModel.model.datatypes.CustomOperation;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;

/**
 * Some public utility methods.
 * 
 * @author Holger Eichelberger
 */
public class Utils {

    /**
     * Prevents this class from being instantiated from outside.
     */
    private Utils() {
    }

    /**
     * Returns a string representing a qualified name. (May change in future to
     * structured qualified names.)
     * 
     * @param name
     *            the qualified name
     * @return the corresponding string representation
     */
    public static String getQualifiedNameString(QualifiedName name) {
        return getQualifiedNameString(name, null);
    }

    /**
     * Returns a string representing a qualified name. (May change in future to
     * structured qualified names.)
     * 
     * @param name
     *            the qualified name
     * @param aName
     *            optional access to a compound (may be <b>null</b>)
     * @return the corresponding string representation
     */
    public static String getQualifiedNameString(QualifiedName name,
            AccessName aName) {
        StringBuilder result = new StringBuilder();
        for (String s : name.getQName()) {
            result.append(s);
        }
        if (null != aName) {
            for (String s : aName.getAName()) {
                result.append(s);
            }
        }
        return result.toString();
    }
    
    /**
     * Selects those elements out of <code>list</code> which are an instance
     * of <code>type</code>.
     * 
     * @param <T> the type of elements to be selected
     * 
     * @param list the list to select from
     * @param type the type to select upon
     * @return a list of elements which are an instance of <code>type</code>
     */
    public static <T> List<T> select(List<EObject> list, Class<T> type) {
        List<T> result = new LinkedList<T>();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            EObject tmp = list.get(i);
            if (type.isInstance(tmp)) {
                result.add(type.cast(tmp));
            }
        }
        return result;
    }
    
    /**
     * The result of splitting a contents object.
     * 
     * @author Holger Eichelberger
     *
     */
    public static class SplitResult {
        private List<Typedef> typedefs;
        private List<VariableDeclaration> varDecls;
        private List<Freeze> freezes;
        private List<Eval> evals;
        private List<ExpressionStatement> exprs;
        private List<AnnotateTo> attrs;
        private List<OpDefStatement> opdefs;
        private List<AttrAssignment> attrAssignments;

        /**
         * Returns the type definitions.
         * 
         * @return the type definitions or <b>null</b>
         */
        public List<Typedef> getTypedefs() {
            return typedefs;
        }

        /**
         * Returns the variable declarations.
         * 
         * @return the variable declarations or <b>null</b>
         */
        public List<VariableDeclaration> getVarDecls() {
            return varDecls;
        }

        /**
         * Returns the freezes.
         * 
         * @return the freezes or <b>null</b>
         */
        public List<Freeze> getFreezes() {
            return freezes;
        }

        /**
         * Returns the evals.
         * 
         * @return the evals or <b>null</b>
         */
        public List<Eval> getEvals() {
            return evals;
        }

        /**
         * Returns the expressions.
         * 
         * @return the expressions or <b>null</b>
         */
        public List<ExpressionStatement> getExprs() {
            return exprs;
        }

        /**
         * Returns the attributes.
         * 
         * @return the attributes or <b>null</b>
         */
        public List<AnnotateTo> getAttrs() {
            return attrs;
        }

        /**
         * Returns the operation definitions.
         * 
         * @return the operation definitions or <b>null</b>
         */
        public List<OpDefStatement> getOpdefs() {
            return opdefs;
        }
        
        /**
         * Returns the attribute assignments.
         * 
         * @return the attribute assignments or <b>null</b>
         */
        public List<AttrAssignment> getAttrAssignments() {
            return attrAssignments;
        }
        
    }
    
    /**
     * Helper function to assign the <code>element</code> to 
     * <code>list</code> if <code>element</code> is of type 
     * <code>type</code> and to create <code>list</code> if not
     * defined before.
     * 
     * @param <T> the type of elements to be processed
     * 
     * @param list the list to insert <code>element</code> into
     * @param element the element to be inserted
     * @param type the type to check for
     * @return <code>list</code> or a new list including <code>element</code>
     *   if <code>type</code> matches
     */
    private static <T> List<T> assign(List<T> list, Object element, Class<T> type) {
        if (type.isInstance(element)) {
            if (null == list) {
                list = new LinkedList<T>();
            }
            list.add(type.cast(element));
        }
        return list;
    }
    
    /**
     * Splits the now heterogeneous list of elements in <code>elements</code>
     * into individual lists stored in the result instance.
     * 
     * @param elements the elements to split
     * @return the result instance
     */
    public static SplitResult split(List<EObject> elements) {
        SplitResult result = new SplitResult();
        split(elements, result);
        return result;
    }

    
    /**
     * Splits the now heterogeneous list of elements in <code>elements</code>
     * into individual lists stored in <code>result</code> instance.
     * 
     * @param elements the elements to split
     * @param result the result instance to be modified as a side effect
     */
    public static void split(List<EObject> elements, SplitResult result) {
        int size = elements.size();
        for (int i = 0; i < size; i++) {
            EObject tmp = elements.get(i);
            result.typedefs = assign(result.typedefs, tmp, Typedef.class);
            result.varDecls = assign(result.varDecls, tmp, VariableDeclaration.class);
            result.freezes = assign(result.freezes, tmp, Freeze.class);
            result.evals = assign(result.evals, tmp, Eval.class);
            result.exprs = assign(result.exprs, tmp, ExpressionStatement.class);
            result.attrs = assign(result.attrs, tmp, AnnotateTo.class);
            result.opdefs = assign(result.opdefs, tmp, OpDefStatement.class);
            result.attrAssignments = assign(result.attrAssignments, tmp, AttrAssignment.class);
            //if (tmp instanceof AttrAssignment) {
            //    split(((AttrAssignment) tmp).getElements(), result);
            //}
        }
    }

    /**
     * Returns whether the import resolution shall be enabled. This method is legacy and was 
     * created while the editor was in an early stage. Please check and remove if adequate.
     * 
     * @return <code>true</code> if import resolution is enabled, <code>false</code> else
     */
    public static final boolean isImportResolutionEnabled() {
        return VarModel.INSTANCE.locations().getLocationCount() > 0;
    }
    
    /**
     * Turns the declared variable names of the <code>varDecl</code> into a string. [debugging]
     * 
     * @param varDecl the variable declaration
     * @return the names of the declared variables
     */
    public static String toString(VariableDeclaration varDecl) {
        String result = "";
        for (VariableDeclarationPart p : varDecl.getDecls()) {
            if (result.length() > 0) {
                result = result + ", ";
            }
            result = result + p.getName();
        }
        return result;
    }

    /**
     * Returns the unqualified name of <code>type</code>.
     * 
     * @param type the type
     * @return the unqualified name
     */
    static String unqualified(IDatatype type) {
        return IvmlDatatypeVisitor.getUnqualifiedType(type);
    }

    /**
     * Creates a structured comment for the given <code>object</code> in <code>context</code> depending on the 
     * contents of <code>comments</code>, i.e. whether there are comments or not.
     * 
     * @param object the EObject to create the comment for
     * @param context the type context to assign the created context to
     * @param comments the comments to consider
     * @return the created comment object or <b>null</b>
     */
    static StructuredComment createStructuredComment(EObject object, TypeContext context, List<Comment> comments) {
        StructuredComment comment;
        if (comments.isEmpty()) {
            comment = null; 
        } else {
            comment = CommentUtils.ensureStructuredComment(object, context);
        }
        return comment;
    }
    
    /**
     * Assigns the comments in <code>comments</code> to the corresponding model elements
     * in <code>elements</code>.
     * 
     * @param target the structured comment to store the mapping in
     * @param elements the elements to be assigned to the comments
     * @param comments the comments (must be of same size)
     * @param parent the explicit parent element of the comments
     */
    static void assignComments(StructuredComment target, List<?> elements, List<Comment> comments, 
        IModelElement parent) {
        assert comments.size() == elements.size();
        for (int i = 0; i < comments.size(); i++) {
            Comment comment = comments.get(i);
            if (null != comment) {
                comment.setParent(parent);
                target.assignComment(elements.get(i), comment);
            }
        }
    }

    /**
     * Defines the annotations for an operation and validates them for the given {@code operation}.
     * 
     * @param op the defining operation statement
     * @param operation the translated IVML operation
     * @param project the actual project
     * @param receiver the message receiver for warnings and errors
     */
    static void setAnnotations(OpDefStatement op, CustomOperation operation, Project project, 
        MessageReceiver receiver) {
        if (null != op.getAnnotations()) {
            operation.setAnnotations(op.getAnnotations().getId());
            
            boolean dispCase = operation.hasAnnotation(OperationAnnotations.DISPATCH_CASE);
            boolean override = operation.hasAnnotation(OperationAnnotations.OVERRIDE);
            if (dispCase || override) {
                IDatatype[] paramTypes = new IDatatype[operation.getParameterCount()];
                for (int p = 0; p < paramTypes.length; p++) {
                    paramTypes[p] = operation.getParameterType(p);
                }
                DispatchInformation di = new DispatchInformation(operation, paramTypes, true);
                di.checkForDispatch(project);
                if (dispCase && di.getCandidatesCount() > 0) {
                    if (di.getDispatchBasisCount() > 1) {
                        receiver.warning("Multiple matching dispatch basis operations found for " 
                            + operation.getSignature(), op, IvmlPackage.Literals.OP_DEF_STATEMENT__ANNOTATIONS, 
                            ErrorCodes.WARNING_USAGE);
                    } else if (di.getDispatchBasisCount() == 0) {
                        receiver.warning("No matching dispatch basis operations found for " + operation.getSignature(), 
                            op, IvmlPackage.Literals.OP_DEF_STATEMENT__ANNOTATIONS, ErrorCodes.WARNING_USAGE);
                    }
                }
                if (override) {
                    boolean ok = di.getCandidatesCount() > 0 && di.getOverrideCount() < di.getCandidatesCount();
                    if (!ok) {
                        receiver.warning("No matching non-overriding operation found for " +  operation.getSignature(), 
                            op, IvmlPackage.Literals.OP_DEF_STATEMENT__ANNOTATIONS, ErrorCodes.WARNING_USAGE);
                    }
                }
            }
        }
    }

    /**
     * Checks the sequence of default and non-default parameters.
     * 
     * @param op the operation declaration
     * @param param the parameters to check
     * @param receiver the message receiver for warnings and errors
     */
    static void checkDefaultParamSequence(OpDefStatement op, DecisionVariableDeclaration[] param, 
        MessageReceiver receiver) {
        int lastNonDefaultParam = -1;
        int lastDefaultParam = -1;
        for (int p = 0; p < param.length; p++) {
            if (null == param[p].getName()) {
                lastNonDefaultParam = p;
            } else {
                if (lastDefaultParam < 0) {
                    lastDefaultParam = p;
                }
            }
        }
        if (param.length > 0) {
            if (lastDefaultParam > 0 && lastNonDefaultParam > lastDefaultParam) {
                receiver.error("parameters with default values must follow parameters without default values", op, 
                    IvmlPackage.Literals.ACTUAL_ARGUMENT_LIST__NAME, ErrorCodes.WARNING_USAGE);
            }
        }
    }

    /**
     * Emits an already defined error.
     * 
     * @param name the already defined name
     * @param object the causing Ecore object
     * @param feature the causing feature
     * @throws TranslatorException the corresponding exception always  
     */
    static void alreadyDefinedError(String name, EObject object, EStructuralFeature feature) 
        throws TranslatorException {
        throw new TranslatorException("name '" + name + "' is already defined in the same scope", object, feature, 
            ErrorCodes.REDEFINITION);
    }

    /**
     * Turns variable declaration parts into strings for debugging.
     * 
     * @param parts the parts
     * @return the names
     */
    static String toString(List<VariableDeclarationPart> parts) {
        String result = "";
        for (int i = 0; i < parts.size(); i++) {
            if (i > 0) {
                result = result + ",";
            }
            result = result + parts.get(i).getName();
        }
        return result;
    }

}
