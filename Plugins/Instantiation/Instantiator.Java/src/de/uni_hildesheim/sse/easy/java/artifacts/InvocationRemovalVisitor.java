package de.uni_hildesheim.sse.easy.java.artifacts;

import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CharacterLiteral;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.IMethodBinding;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.PrimitiveType;
import org.eclipse.jdt.core.dom.PrimitiveType.Code;
import org.eclipse.jdt.core.dom.SimpleType;
import org.eclipse.jdt.core.dom.StringLiteral;
import org.eclipse.jdt.core.dom.Type;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;

import de.uni_hildesheim.sse.easy_producer.instantiator.Bundle;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory.EASyLogger;

/**
 * Visitor to find all method invocations.
 * 
 * @author Aike Sass
 *
 */
public class InvocationRemovalVisitor extends ASTVisitor {

    private static EASyLogger logger = EASyLoggerFactory.INSTANCE.getLogger(InvocationRemovalVisitor.class, Bundle.ID);

    private MethodDeclaration methodDeclaration;
    private IMethodBinding methodDeclarationBinding;
    private boolean hasBeenDeleted;
    private Object replacement;

    /**
     * Default Constructor.
     * 
     * @param methodDeclaration
     *            the method declaration
     * @param replacement the replacement that should be inserted
     */
    public InvocationRemovalVisitor(MethodDeclaration methodDeclaration, Object replacement) {
        this.methodDeclaration = methodDeclaration;
        this.methodDeclarationBinding = methodDeclaration.resolveBinding();
        this.replacement = replacement;
        hasBeenDeleted = false;
    }

    @Override
    public boolean visit(MethodInvocation node) {
        IMethodBinding iMethod = (IMethodBinding) node.resolveMethodBinding();
        IMethodBinding methodDeclarationCandidate = iMethod.getMethodDeclaration();
        if (check(methodDeclarationCandidate)) {
            // Delete node with expression (i.e.: ClassName.methodname())
            if (null != node.getExpression()) {
                node.getParent().delete();
            } else {
                if (null != replacement) {
                    if (node.getParent().getNodeType() == ASTNode.VARIABLE_DECLARATION_FRAGMENT) {
                        VariableDeclarationFragment fragment = (VariableDeclarationFragment) node.getParent();
                        Expression expression = null;
                        Type type = methodDeclaration.getReturnType2();
                        int exprType = determineType(type);
                        switch (exprType) {
                        case Expression.NUMBER_LITERAL:
                            expression = fragment.getAST().newNumberLiteral(String.valueOf(replacement));
                            break;
                        case Expression.STRING_LITERAL:
                            expression = fragment.getAST().newStringLiteral();
                            ((StringLiteral) expression).setLiteralValue(String.valueOf(replacement));
                            break;
                        case Expression.BOOLEAN_LITERAL:
                            expression = fragment.getAST().newBooleanLiteral(Boolean.valueOf(replacement.toString()));
                            break;
                        case Expression.CHARACTER_LITERAL:
                            expression = fragment.getAST().newCharacterLiteral();
                            String string = String.valueOf(replacement);
                            if (string.length() != 1) {
                                logger.warn(string + " contains more then one character. Cutting the string of at "
                                        + string.charAt(0));
                            }
                            char c = string.charAt(0);
                            ((CharacterLiteral) expression).setCharValue(Character.valueOf(c));
                            break;
                        case Expression.NULL_LITERAL:
                            expression = fragment.getAST().newNullLiteral();
                            break;
                        case Expression.TYPE_LITERAL:
                            expression = fragment.getAST().newTypeLiteral();
                            break;
                        default:
                            logger.error("Type '" + type + "' not supported yet...");
                            break;
                        }
                        if (expression != null) {
                            fragment.setInitializer(expression);
                        }
                    }
                } else {
                    node.delete();
                }
            }
            hasBeenDeleted = true;
        }
        return false;
    }

    /**
     * Mapping between types.
     * 
     * @param type
     *            type
     * @return code of the type
     */
    private int determineType(Type type) {
        int expressionType = -1;
        if (type.isPrimitiveType()) {
            PrimitiveType prim = (PrimitiveType) type;
            Code code = prim.getPrimitiveTypeCode();
            if (code.equals(PrimitiveType.INT) | code.equals(PrimitiveType.DOUBLE) | code.equals(PrimitiveType.FLOAT)
                    | code.equals(PrimitiveType.LONG)) {
                expressionType = Expression.NUMBER_LITERAL;
            } else if (code.equals(PrimitiveType.BOOLEAN)) {
                expressionType = Expression.BOOLEAN_LITERAL;
            } else if (code.equals(PrimitiveType.CHAR)) {
                expressionType = Expression.CHARACTER_LITERAL;
            }
        }
        if (type.isSimpleType()) {
            // String, Double
            SimpleType simple = (SimpleType) type;
            String simpleTypeName = simple.getName().getFullyQualifiedName();
            if (simpleTypeName.equals("String")) {
                expressionType = Expression.STRING_LITERAL;
            } else if (simpleTypeName.equals("Double") | simpleTypeName.equals("Long") 
                | simpleTypeName.equals("Float")) {
                expressionType = Expression.NUMBER_LITERAL;
            } else if (simpleTypeName.equals("Boolean")) {
                expressionType = Expression.BOOLEAN_LITERAL;
            } else {
                /* 
                 * WARNING: If the type is not one of the above it will be set to Expression.NULL_LITERAL resulting 
                 * that for every expression the replacement will be 'null'!!!
                 */
                expressionType = Expression.NULL_LITERAL;
            }
        }
        return expressionType;
    }

    /**
     * Check if a method binding matches to the one that should be deleted.
     * 
     * @param candidate
     *            the method binding that should be investigated
     * @return result
     */
    private boolean check(IMethodBinding candidate) {
        boolean result = null != candidate;
        result = result && methodDeclarationBinding.getName().equals(candidate.getName());
        return result;
    }

    /**
     * Getter that identifies if a node has been deleted.
     * 
     * @return true if node has been deleted otherwise false
     */
    public boolean hasBeenDeleted() {
        return hasBeenDeleted;
    }

}
