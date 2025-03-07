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
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import java.util.function.Supplier;

import org.apache.commons.lang.StringUtils;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.compiler.IProblem;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.AnnotationTypeDeclaration;
import org.eclipse.jdt.core.dom.AnnotationTypeMemberDeclaration;
import org.eclipse.jdt.core.dom.AnonymousClassDeclaration;
import org.eclipse.jdt.core.dom.ArrayAccess;
import org.eclipse.jdt.core.dom.ArrayCreation;
import org.eclipse.jdt.core.dom.ArrayInitializer;
import org.eclipse.jdt.core.dom.ArrayType;
import org.eclipse.jdt.core.dom.Assignment;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.BodyDeclaration;
import org.eclipse.jdt.core.dom.BooleanLiteral;
import org.eclipse.jdt.core.dom.BreakStatement;
import org.eclipse.jdt.core.dom.CastExpression;
import org.eclipse.jdt.core.dom.CatchClause;
import org.eclipse.jdt.core.dom.CharacterLiteral;
import org.eclipse.jdt.core.dom.ClassInstanceCreation;
import org.eclipse.jdt.core.dom.Comment;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.ConditionalExpression;
import org.eclipse.jdt.core.dom.ConstructorInvocation;
import org.eclipse.jdt.core.dom.ContinueStatement;
import org.eclipse.jdt.core.dom.CreationReference;
import org.eclipse.jdt.core.dom.Dimension;
import org.eclipse.jdt.core.dom.DoStatement;
import org.eclipse.jdt.core.dom.EmptyStatement;
import org.eclipse.jdt.core.dom.EnhancedForStatement;
import org.eclipse.jdt.core.dom.EnumConstantDeclaration;
import org.eclipse.jdt.core.dom.EnumDeclaration;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.ExpressionMethodReference;
import org.eclipse.jdt.core.dom.ExpressionStatement;
import org.eclipse.jdt.core.dom.FieldAccess;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.ForStatement;
import org.eclipse.jdt.core.dom.GuardedPattern;
import org.eclipse.jdt.core.dom.IfStatement;
import org.eclipse.jdt.core.dom.InfixExpression;
import org.eclipse.jdt.core.dom.InstanceofExpression;
import org.eclipse.jdt.core.dom.Javadoc;
import org.eclipse.jdt.core.dom.LambdaExpression;
import org.eclipse.jdt.core.dom.LineComment;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.Modifier;
import org.eclipse.jdt.core.dom.NullLiteral;
import org.eclipse.jdt.core.dom.NullPattern;
import org.eclipse.jdt.core.dom.NumberLiteral;
import org.eclipse.jdt.core.dom.PatternInstanceofExpression;
import org.eclipse.jdt.core.dom.PostfixExpression;
import org.eclipse.jdt.core.dom.PrefixExpression;
import org.eclipse.jdt.core.dom.QualifiedName;
import org.eclipse.jdt.core.dom.QualifiedType;
import org.eclipse.jdt.core.dom.RecordPattern;
import org.eclipse.jdt.core.dom.ReturnStatement;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.SimpleType;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.eclipse.jdt.core.dom.Statement;
import org.eclipse.jdt.core.dom.StringLiteral;
import org.eclipse.jdt.core.dom.StringTemplateExpression;
import org.eclipse.jdt.core.dom.SuperConstructorInvocation;
import org.eclipse.jdt.core.dom.SuperFieldAccess;
import org.eclipse.jdt.core.dom.SuperMethodInvocation;
import org.eclipse.jdt.core.dom.SuperMethodReference;
import org.eclipse.jdt.core.dom.SwitchCase;
import org.eclipse.jdt.core.dom.SwitchStatement;
import org.eclipse.jdt.core.dom.SynchronizedStatement;
import org.eclipse.jdt.core.dom.TagElement;
import org.eclipse.jdt.core.dom.TextBlock;
import org.eclipse.jdt.core.dom.ThisExpression;
import org.eclipse.jdt.core.dom.ThrowStatement;
import org.eclipse.jdt.core.dom.TryStatement;
import org.eclipse.jdt.core.dom.Type;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclarationStatement;
import org.eclipse.jdt.core.dom.TypeLiteral;
import org.eclipse.jdt.core.dom.TypeMethodReference;
import org.eclipse.jdt.core.dom.TypeParameter;
import org.eclipse.jdt.core.dom.TypePattern;
import org.eclipse.jdt.core.dom.VariableDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationExpression;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.jdt.core.dom.VariableDeclarationStatement;
import org.eclipse.jdt.core.dom.WhileStatement;

/**
 * AST-to-Artifact visitor.
 * 
 * @author Holger Eichelberger
 */
class AST2ArtifactVisitor extends ASTVisitor {
    
    private Stack<JavaCodeBlock> blocks = new Stack<>();
    private Stack<JavaCodeClass> classes = new Stack<>();
    private JavaCodeClass cls;
    private JavaCodeEnum enumeration;
    private JavaCodeMethod method;
    private JavaCodeExpression ex;
    private Map<Integer, Comment> comments;
    private char[] source;
    
    AST2ArtifactVisitor(ASTNode unit, char[] source) {
        this.source = source;
        if (unit instanceof CompilationUnit) {
            comments = CodeParser.mapComments((CompilationUnit) unit);
        }
    }
    
    AST2ArtifactVisitor(JavaCodeBlock result, Map<Integer, Comment> comments, char[] source) {
        blocks.push(result);
        this.comments = comments;
        this.source = source;
    }
    
    /**
     * Parses {@code text} on compilation unit level.
     * 
     * @param text the text to parse from
     * @return the created visitor instance carrying the result, depending on input, result is in 
     * {@link #getClass()}, {@link #getEnum()}, {@link #getMethod()}.
     */
    public static AST2ArtifactVisitor parseCompilationUnit(String text) {
        return parse(text, ASTParser.K_COMPILATION_UNIT);
    }
    
    /**
     * Parses {@code text} on expression level.
     * 
     * @param text the text to parse from
     * @return the created visitor instance carrying the result, depending on input, result is in 
     * {@link #getExpression()}.
     */
    public static AST2ArtifactVisitor parseExpression(String text) {
        return parse(text, ASTParser.K_EXPRESSION);
    }    

    /**
     * Parses {@code text} on compilation unit level.
     * 
     * @param text the text to parse from
     * @param parserKind the expected kind of source level to start parsing at
     * @return the created visitor instance carrying the result
     */
    private static AST2ArtifactVisitor parse(String text, int parserKind) {
        char[] source = text.toCharArray();
        ASTParser parser = ASTParser.newParser(AST.getJLSLatest());
        parser.setKind(parserKind);
        parser.setSource(source);
        parser.setResolveBindings(true);
        parser.setBindingsRecovery(true);
        Map<String, String> options = JavaCore.getOptions();
        JavaCore.setComplianceOptions(JavaCore.VERSION_21, options);
        parser.setCompilerOptions(options);
        ASTNode node = parser.createAST(null);
        AST2ArtifactVisitor vis = new AST2ArtifactVisitor(node, source);
        node.accept(vis);
        if (node instanceof CompilationUnit) {
            CompilationUnit unit = (CompilationUnit) node;
            if (null != unit.getProblems()) { // preliminary
                for (IProblem p : unit.getProblems()) {
                    if (p.getID() != 4195409) { // 4195409: The preview feature...
                        System.out.println("Problem: " + p.getMessage());
                    }
                }
            }
        }
        return vis;
    }
    
    /**
     * Filled with a parsed class if called via {@link #AST2ArtifactVisitor(ASTNode, char[])}.
     * 
     * @return the class, may be <b>null</b> for none/syntax error
     */
    public JavaCodeClass getCls() {
        return cls;
    }
    
    /**
     * Filled with a parsed enum if called via {@link #AST2ArtifactVisitor(ASTNode, char[])}.
     * 
     * @return the enum, may be <b>null</b> for none/syntax error
     */
    public JavaCodeEnum getEnum() {
        return enumeration;
    }

    /**
     * Filled with a parsed method if called via {@link #AST2ArtifactVisitor(ASTNode, char[])}.
     * 
     * @return the method/syntax error, may be <b>null</b> for none/syntax error
     */
    public JavaCodeMethod getMethod() {
        return method;
    }
    
    /**
     * Returns the top-level or the one passed in by {@link #BlockASTVisitor(JavaCodeBlock, Map, char[])}).
     * 
     * @return the block, may be <b>null</b> for none/syntax error
     */
    public JavaCodeBlock getBlock() {
        return blocks.isEmpty() ? null : blocks.peek();
    }
    
    /**
     * Filled with a parsed expression if called via {@link #AST2ArtifactVisitor(ASTNode, char[])}.
     * 
     * @return the expression, may be <b>null</b> for none/syntax error
     */
    public JavaCodeExpression getExpression() {
        return ex;
    }
    
    private JavaCodeClass getCurrentClass() {
        return classes.isEmpty() ? null : classes.peek();
    }
    
    @Override
    public boolean visit(EmptyStatement node) {
        getBlock().add(";");
        return false;
    }
    
    @Override
    public boolean visit(IfStatement node) {
        node.getExpression().accept(this);
        JavaCodeAlternative a = getBlock().addIf(getExToString());
        blocks.push(a);
        node.getThenStatement().accept(this);
        blocks.pop();
        if (node.getElseStatement() != null) {
            blocks.push(a.addElse());
            node.getElseStatement().accept(this);
            blocks.pop();
        }
        return false;
    }

    @Override
    public boolean visit(LineComment node) {
        int startPos = node.getStartPosition() + 2; // cut //
        int pos = startPos; 
        while (pos < source.length && (source[pos] != '\n' && source[pos] != '\r')) {
            pos++;
        }
        getBlock().addSLComment(new String(source, startPos, pos - startPos).trim());
        return false;
    }

    @Override
    public boolean visit(Assignment node) {
        node.getLeftHandSide().accept(this);
        String lhs = getExToString();
        node.getRightHandSide().accept(this);
        if (null != getBlock()) { // expression parsing
            getBlock().addAssignment(lhs, node.getOperator().toString(), getEx());
        }
        return false;
    }

    @Override
    public boolean visit(Block node) {
        boolean nestedBlock = node.getParent() instanceof Block; // artifact does blocks implicitly
        if (nestedBlock) {
            JavaCodeBlock b = new JavaCodeBlock(getBlock(), false, true).indentBefore(true);
            getBlock().addBlock(b);           
            blocks.push(b);
        }
        CodeParser.apply(() -> node.statements(), Statement.class, s -> {
            CodeParser.visitCommentBefore(s, comments, this);
            s.accept(this);
            ex = null; // clean up if expression is used here directly
        });
        if (nestedBlock) {
            blocks.pop();
        }
        return false;
    }
    
    @Override
    public boolean visit(DoStatement node) {
        blocks.push(getBlock().addDoLoop(node.getExpression().toString()));
        node.getBody().accept(this);
        blocks.pop();
        return false;
    }

    @Override
    public boolean visit(EnhancedForStatement node) {
        SingleVariableDeclaration v = node.getParameter();
        node.getExpression().accept(this);
        blocks.push(getBlock().addForLoop(toString(v.getType(), false), v.getName().getIdentifier(), getExToString()));
        node.getBody().accept(this);
        blocks.pop();
        return false;
    }
    
    @Override
    public boolean visit(BreakStatement node) {
        getBlock().addBreak();
        return false;
    }

    @Override
    public boolean visit(ContinueStatement node) {
        getBlock().addContinue();
        return false;
    }

    @Override
    public boolean visit(ExpressionStatement node) {
        node.getExpression().accept(this);
        getBlock().add(getEx());
        return false;
    }
    
    private String toString(Type type, boolean elementType) {
        String result;
        if (null == type) {
            result = "";
        } else {
            result = type.toString();
            if (elementType) {
                if (type instanceof ArrayType) {
                    result = toString(((ArrayType) type).getElementType(), true);
                }
            }
        }
        return result;
    } // handles WildcardType, IntersectionType, UnionType, TypeParameter, PrimitiveType, ParameterizedType, 
      // NameQualifiedType, ArrayType

    @Override
    public boolean visit(ForStatement node) {
        node.getExpression();
        node.initializers();
        node.updaters();
        AtomicReference<String> vType = new AtomicReference<>("");
        List<String> names = new ArrayList<>();
        List<String> inits = new ArrayList<>();
        CodeParser.apply(() -> node.initializers(), Expression.class, i -> {
            if (i instanceof VariableDeclarationExpression) {
                VariableDeclarationExpression d = (VariableDeclarationExpression) i;
                vType.set(toString(d.getType(), false));
                CodeParser.apply(() -> d.fragments(), VariableDeclarationFragment.class, f -> {
                    names.add(f.getName().getIdentifier());
                    if (f.getInitializer() != null) {
                        f.getInitializer().accept(this);
                        inits.add(getExToString());
                    } else {
                        inits.add("");
                    }
                });
            } else {
                i.accept(this);
                inits.add(getExToString());
            }
        });
        String cond = "";
        if (null != node.getExpression()) {
            node.getExpression().accept(this);
            cond = getExToString();
        }

        List<String> updaters = new ArrayList<>();
        CodeParser.apply(() -> node.updaters(), Expression.class, u -> {
            u.accept(this);
            updaters.add(getExToString());
        });
        
        JavaCodeForLoop f = getBlock().addForLoop(vType.get(), CodeParser.first(names, ""), 
            CodeParser.first(inits, ""), cond, CodeParser.first(updaters, ""));
        for (int l = 1; l < Math.min(Math.min(names.size(), inits.size()), updaters.size()); l++) {
            f.addLoopVariable(CodeParser.get(names, l, ""), CodeParser.get(inits, l, ""));
            f.addUpdate(CodeParser.get(updaters, l, ""));
        }
        blocks.push(f);
        node.getBody().accept(this);
        blocks.pop();
        return false;
    }

    @Override
    public boolean visit(ReturnStatement node) {
        node.getExpression().accept(this);
        getBlock().addReturn(getEx());
        return false;
    }

    @Override
    public boolean visit(SuperConstructorInvocation node) {
        return createMethodCall(node.getExpression(), "super", false, () -> node.arguments(), true);
    }

    @Override
    public boolean visit(SuperMethodInvocation node) {
        return createMethodCall(node.getQualifier(), "super." + node.getName().getIdentifier(), false, 
            () -> node.arguments(), false);
    }

    /**
     * Internal access to expression created by last visiting/accept. Clears stored expression.+
     * 
     * @return the expression as formatted string
     */
    private String getExToString() {
        return null == ex ? "" : getEx().toCode();
    }

    /**
     * Internal access to expression created by last visiting/accept. Clears stored expression.+
     * 
     * @return the expression
     */
    private JavaCodeExpression getEx() {
        JavaCodeExpression result = ex;
        ex = null;
        return result;
    }
    
    public boolean visit(SwitchStatement node) {
        node.getExpression().accept(this);
        JavaCodeSwitch sw = getBlock().addSwitch(getEx());
        AtomicReference<String> lastCase = new AtomicReference<>(null);
        AtomicReference<JavaCodeBlock> lastBlock = new AtomicReference<>(null);
        CodeParser.apply(() -> node.statements(), Statement.class, s -> {
            if (s instanceof SwitchCase) {
                SwitchCase ca = (SwitchCase) s;
                if (lastCase.get() != null) { // case without code
                    lastBlock.set(sw.addCase(new JavaCodeTextExpression(sw, lastCase.get()), false, false));
                }
                StringBuilder expr = new StringBuilder();
                CodeParser.apply(() -> ca.expressions(), Expression.class, e -> {
                    e.accept(this);
                    if (expr.length() > 0) {
                        expr.append(", ");
                    }
                    expr.append(getExToString());
                });
                lastCase.set(expr.toString());
                if (lastBlock.get() != null) {
                    blocks.pop();
                    lastBlock.set(null);
                }
            } else {
                if (lastBlock.get() == null) {
                    JavaCodeBlock bl = lastCase.get().isEmpty() 
                        ? sw.addDefault(s instanceof Block, false)
                        : sw.addCase(new JavaCodeTextExpression(sw, lastCase.get()), s instanceof Block, false);
                    lastBlock.set(bl);
                    lastCase.set(null);
                    blocks.push(lastBlock.get());
                }
                s.accept(this);
            }
        });
        return false; // subsumes SwitchExpression
    }
    
    @Override
    public boolean visit(SynchronizedStatement node) {
        node.getExpression().accept(this);
        blocks.push(getBlock().addSynchronized(getEx()));
        node.getBody().accept(this);
        blocks.pop();
        return false;
    }

    @Override
    public boolean visit(ThrowStatement node) {
        node.getExpression().accept(this);
        getBlock().addThrow(getEx());
        return true;
    }

    @Override
    public boolean visit(TryStatement node) {
        JavaCodeTryBlock t = getBlock().addTry();
        CodeParser.apply(() -> node.resources(), VariableDeclarationExpression.class, r -> {
            String type = toString(r.getType(), false);
            CodeParser.apply(() -> r.fragments(), VariableDeclarationFragment.class, f -> {
                if (f.getInitializer() != null) {
                    f.getInitializer().accept(this);
                }
                t.addResource(type, f.getName().getIdentifier(), getEx());
            });
        });
        blocks.push(t);
        node.getBody().accept(this);
        blocks.pop();
        CodeParser.apply(() -> node.catchClauses(), CatchClause.class, c -> {
            SingleVariableDeclaration v = c.getException();
            blocks.push(t.addCatch(toString(v.getType(), false), v.getName().getIdentifier()));
            c.getBody().accept(this);
            blocks.pop();
        });
        if (null != node.getFinally()) {
            blocks.push(t.addFinally());
            node.getFinally().accept(this);
            blocks.pop();
        }
        return false;
    }

    @Override
    public boolean visit(VariableDeclarationStatement node) {
        CodeParser.apply(() -> node.fragments(), VariableDeclarationFragment.class, f -> {
            f.getInitializer().accept(this);
            getBlock().addVariable(toString(node.getType(), false), f.getName().getIdentifier(), getEx());
        });
        return false;
    }

    @Override
    public boolean visit(WhileStatement node) {
        blocks.push(getBlock().addWhileLoop(node.getExpression().toString()));
        node.getBody().accept(this);
        blocks.pop();
        return false;
    }

    @Override
    public boolean visit(AnonymousClassDeclaration node) {
        CodeParser.apply(() -> node.bodyDeclarations(), BodyDeclaration.class, b -> {
            b.accept(this);
        });
        return false;
    }

    @Override
    public boolean visit(ArrayAccess node) {
        return append(node);
    }

    @Override
    public boolean visit(ArrayCreation node) {
        JavaCodeNewArrayExpression nEx = new JavaCodeNewArrayExpression(null, toString(node.getType(), true));
        CodeParser.apply(() -> node.dimensions(), Expression.class, e -> {
            e.accept(this);
            nEx.addDimension(getEx());
        });
        ex = nEx;
        return false;
    }

    @Override
    public boolean visit(ArrayInitializer node) {
        JavaCodeArrayInitializerExpression aEx = new JavaCodeArrayInitializerExpression(null, false);
        CodeParser.apply(() -> node.expressions(), Expression.class, e -> {
            e.accept(this);
            aEx.addArgument(getEx());
        });
        ex = aEx;
        return false;
    }

    @Override
    public boolean visit(BooleanLiteral node) {
        return append(node);
    }

    @Override
    public boolean visit(CastExpression node) {
        node.getExpression().accept(this);
        ex = new JavaCodeCastExpression(null, toString(node.getType(), false), getEx());
        return false;
    }

    @Override
    public boolean visit(CharacterLiteral node) {
        return append(node);
    }

    @Override
    public boolean visit(ClassInstanceCreation node) {
        if (null != node.getAnonymousClassDeclaration()) {
            JavaCodeAnonymousClass c = new JavaCodeAnonymousClass(toString(node.getType(), false), getCurrentClass());
            classes.push(c);
            CodeParser.apply(() -> node.arguments(), Expression.class, a -> {
                a.accept(this);
                c.addArgument(getEx());
            });
            node.getAnonymousClassDeclaration().accept(this);
            classes.pop();
            ex = JavaCodeAnonymousClass.toExpression(c);
        } else {
            createMethodCall(node.getExpression(), toString(node.getType(), false), true, () -> node.arguments(), 
                false);
        }
        return false;
    }

    @Override
    public boolean visit(ConditionalExpression node) {
        node.getExpression().accept(this);
        JavaCodeExpression condEx = getEx();
        node.getThenExpression().accept(this);
        JavaCodeExpression thenEx = getEx();
        node.getElseExpression().accept(this);
        JavaCodeExpression elseEx = getEx();
        ex = new JavaCodeTernaryExpression(null, condEx, thenEx, elseEx);
        return false;
    }

    @Override
    public boolean visit(ConstructorInvocation node) {
        return createMethodCall(null, "this", false, () -> node.arguments(), true);
    }

    @Override
    public boolean visit(CreationReference node) {
        return append(node);
    }

    @Override
    public boolean visit(ExpressionMethodReference node) {
        return append(node);
    }

    @Override
    public boolean visit(Dimension node) {
        return append(node);
    }

    @Override
    public boolean visit(FieldAccess node) {
        return append(node);
    }

    @Override
    public boolean visit(GuardedPattern node) {
        return append(node);
    }

    @Override
    public boolean visit(InfixExpression node) {
        return append(node);
    }

    @Override
    public boolean visit(InstanceofExpression node) {
        return append(node);
    }

    @Override
    public boolean visit(LambdaExpression node) {
        JavaCodeLambdaExpression l = new JavaCodeLambdaExpression(null);
        CodeParser.apply(() -> node.parameters(), VariableDeclaration.class, p -> {
            l.addVariable(p.getName().getIdentifier());
        });
        if (node.getBody() instanceof Expression) {
            node.getBody().accept(this);
            l.addExpression(getEx());
        } else {
            blocks.push(new JavaCodeBlock(null, false, false));
            node.getBody().accept(this);
            l.setBlock(blocks.pop());
        }
        ex = l;
        return false;
    }

    private boolean createMethodCall(Expression expr, String name, boolean constructor, Supplier<List<?>> args, 
        boolean add) {
        if (null != expr) {
            expr.accept(this);
            name = getExToString() + "." + name;
        }
        
        int dotCount = StringUtils.countMatches(name, ".");
        JavaCodeImportScope scope;
        // heuristic, guessing; no code annotation possible at method call
        if (name.startsWith("System.")) {
            scope = JavaCodeImportScope.NONE;
        } else if (dotCount > 2) {
            scope = JavaCodeImportScope.CLASS_NO_METHOD;
        } else {
            scope = JavaCodeImportScope.NONE;
        }
        JavaCodeMethodCall call = constructor ? new JavaCodeConstructorCall(null, name, false, "") 
            : new JavaCodeMethodCall(null, name, scope, false, "");
        CodeParser.apply(args, Expression.class, a -> {
            a.accept(this);
            call.addArgument(getEx());
        });
        if (add) {
            getBlock().add(call);
        } else {
            ex = call;
        }
        return false;
    }
    
    @Override
    public boolean visit(MethodInvocation node) {
        return createMethodCall(node.getExpression(), node.getName().getIdentifier(), false, 
            () -> node.arguments(), false);
    }
    
    private boolean append(ASTNode node) {
        if (null == ex) {
            ex = new JavaCodeTextExpression(null, node.toString());
        } else if (ex instanceof JavaCodeTextExpression) {
            ex = ((JavaCodeTextExpression) ex).append(node.toString());
        } else {
            ex = new JavaCodeTextExpression(null, ex.toCode()).append(node.toString());
        }
        return false;
    }

    @Override
    public boolean visit(NullLiteral node) {
        return append(node);
    }

    @Override
    public boolean visit(NullPattern node) {
        return append(node);
    }

    @Override
    public boolean visit(NumberLiteral node) {
        return append(node);
    }

    /*@Override // parenthesis used in artifact only implicit, here expression is turned to text
    public boolean visit(ParenthesizedExpression node) {
        ex = new JavaCodeParenthesisExpression(null, ex);
        return true;
    }*/

    @Override
    public boolean visit(PatternInstanceofExpression node) {
        return append(node);
    }

    @Override
    public boolean visit(PostfixExpression node) {
        return append(node);
    }

    @Override
    public boolean visit(PrefixExpression node) {
        return append(node);
    }

    @Override
    public boolean visit(QualifiedName node) {
        return append(node);
    }

    @Override
    public boolean visit(QualifiedType node) {
        return append(node);
    }

    @Override
    public boolean visit(RecordPattern node) {
        return append(node);
    }

    @Override
    public boolean visit(SimpleName node) {
        return append(node);
    }

    @Override
    public boolean visit(SimpleType node) {
        return append(node);
    }

    @Override
    public boolean visit(StringLiteral node) {
        return append(node);
    }

    @Override
    public boolean visit(SuperFieldAccess node) {
        return append(node);
    }

    @Override
    public boolean visit(SuperMethodReference node) {
        return append(node);
    }

    @Override
    public boolean visit(TextBlock node) {
        return append(node);
    }

    @Override
    public boolean visit(ThisExpression node) {
        return append(node);
    }

    private void processModifier(Supplier<List<?>> modSupplier, JavaCodeMethod meth) {
        processModifier(modSupplier, meth, m -> {
            if (m.isDefault()) {
                meth.setDefault();
            }
            if (m.isSynchronized()) {
                meth.setSynchronized();
            }
        });
    }

    private void processModifier(Supplier<List<?>> modSupplier, JavaCodeAbstractVisibleElement elt, 
        Consumer<Modifier> elseConsumer) {
        processModifier(modSupplier, elt, t -> elt.setAbstract(t), elseConsumer);
    }
    
    private void processModifier(Supplier<List<?>> modSupplier, JavaCodeVisibleElement elt, 
        Consumer<Boolean> abstractConsumer, Consumer<Modifier> elseConsumer) {
        elt.setPackage(); // reset, to be overwritten if there is some visibility
        CodeParser.apply(modSupplier, Modifier.class, mod -> {
            boolean done = false;
            if (mod.isPublic()) {
                elt.setPublic();
                done = true;
            } else if (mod.isPrivate()) {
                elt.setPrivate();
                done = true;
            } else if (mod.isProtected()) {
                elt.setProtected();
                done = true;
            } // there is no mod.isPackage(), else for package would overwrite in case of any other modifier
            if (mod.isFinal()) {
                elt.setFinal();
                done = true;
            }
            if (mod.isStatic()) {
                elt.setStatic();
                done = true;
            }
            if (mod.isAbstract() && abstractConsumer != null) {
                abstractConsumer.accept(true);
                done = true;
            }
            if (!done && elseConsumer != null) {
                elseConsumer.accept(mod);
            }
        });
    }
    
    @Override
    public boolean visit(FieldDeclaration node) {
        JavaCodeClass c = getCurrentClass();
        if (null != c) {
            String type = toString(node.getType(),  false);
            CodeParser.apply(() -> node.fragments(), VariableDeclarationFragment.class, f -> {
                // TODO Javadoc, annotations
                JavaCodeAttribute a = c.addAttribute(type, f.getName().getIdentifier());
                processModifier(() -> node.modifiers(), a, null, m -> {
                    if (m.isTransient()) {
                        a.setTransient();
                    }
                });
                if (null != f.getInitializer()) {
                    f.getInitializer().accept(this);
                    a.addInitializer(getEx());
                }
            });
        }
        return false;
    }
    
    @Override
    public boolean visit(AnnotationTypeDeclaration node) {
        JavaCodeClass c = new JavaCodeClass(node.getName().getIdentifier(), classes.isEmpty() ? null : classes.peek());
        c.asAnnotation();
        processModifier(() -> node.modifiers(), c, null);
        classes.push(c);
        CodeParser.apply(() -> node.bodyDeclarations(), BodyDeclaration.class, b -> {
            b.accept(this);
        });
        classes.pop();
        if (null == cls) {
            cls = c;
        }
        return false;
    }
    
    @Override
    public boolean visit(AnnotationTypeMemberDeclaration node) {
        JavaCodeJavadocComment comment = new JavaCodeJavadocComment(null, null);
        Javadoc javadoc = node.getJavadoc();
        if (null != javadoc) {
            CodeParser.apply(() -> javadoc.tags(), TagElement.class, t -> {
                String tagName = t.getTagName();
                if (null == tagName) { // main comment
                    comment.setComment(CodeParser.join(t.fragments(), 0, -1));
                } else if (TagElement.TAG_PARAM.equals(tagName)) {
                    CodeParser.idRest(t.fragments(), (i, r) -> comment.addParameterComment(i, r));
                } else if (TagElement.TAG_EXCEPTION.equals(tagName)) {
                    CodeParser.idRest(t.fragments(), (i, r) -> comment.addExceptionComment(i, r));
                } else if (TagElement.TAG_RETURN.equals(tagName)) {
                    comment.addReturnComment(CodeParser.join(t.fragments(), 0, -1));
                }
            });
        }
        // consistency, comments via block comments where annotation not possible
        String docComment = CodeParser.getComment(node, comments, source);
        if (null != docComment) {
            comment.setComment(docComment);
        }
        AtomicBoolean enabled = new AtomicBoolean(true);
        JavaCodeClass enclosing = getCurrentClass();
        JavaCodeMethod m = new JavaCodeMethod(JavaCodeTypeSpecification.create(node.getType()), 
            node.getName().getIdentifier(), enclosing, null);
        if (null != enclosing) {
            enclosing.addMethod(m);
        }
        m.setJavadocComment(comment); // explicitly take over
        // modifier
        processModifier(() -> node.modifiers(), m);
        // method annotations
        CodeParser.processAnnotations(() -> node.modifiers(), e -> enabled.set(e), 
            c -> m.getJavadocComment().setComment(c), m);
        if (null != node.getDefault()) {
            node.getDefault().accept(this);
            m.addDefault(getEx());
        }
        if (enabled.get()) {
            method = m;
        }
        return false; // skip children
    }

    @Override
    public boolean visit(TypeDeclaration node) {
        JavaCodeClass c = new JavaCodeClass(node.getName().getIdentifier(), classes.isEmpty() ? null : classes.peek());
        c.asInterface(node.isInterface());
        processModifier(() -> node.modifiers(), c, null);
        CodeParser.apply(() -> node.typeParameters(), TypeParameter.class, t -> {
            c.addGeneric(t.getName().getIdentifier()); // TODO comment
        });
        c.addExtends(toString(node.getSuperclassType(), false));
        CodeParser.apply(() -> node.superInterfaceTypes(), Type.class, t -> {
            c.addInterface(toString(t, false));
        });
        //node.permittedTypes();
        classes.push(c);
        for (TypeDeclaration t : node.getTypes()) {
            t.accept(this);
        }
        for (FieldDeclaration f : node.getFields()) {
            f.accept(this);
        }
        for (MethodDeclaration m : node.getMethods()) {
            m.accept(this);
        }
        classes.pop();
        if (null == cls) {
            cls = c;
        }
        return false;
    }
    
    @Override
    public boolean visit(EnumDeclaration node) {
        JavaCodeEnum e = new JavaCodeEnum(node.getName().getIdentifier(), classes.isEmpty() ? null : classes.peek());
        processModifier(() -> node.modifiers(), e, null);
        CodeParser.apply(() -> node.superInterfaceTypes(), Type.class, t -> {
            e.addInterface(toString(t, false));
        });
        classes.push(e);
        CodeParser.apply(() -> node.enumConstants(), EnumConstantDeclaration.class, c -> {
            e.addLiteral(c.getName().getIdentifier()); // TODO handle comment
        });
        CodeParser.apply(() -> node.bodyDeclarations(), BodyDeclaration.class, b -> {
            b.accept(this);
        });
        classes.pop();
        if (null == enumeration) {
            enumeration = e;
        }
        if (null == cls) { // for now
            cls = e;
        }
        return false;
    }

    @Override
    public boolean visit(TypeDeclarationStatement node) {
        return append(node);
    }

    @Override
    public boolean visit(TypeLiteral node) {
        return append(node);
    }

    @Override
    public boolean visit(TypeMethodReference node) {
        return append(node);
    }

    @Override
    public boolean visit(TypePattern node) {
        return append(node);
    }

    @Override
    public boolean visit(VariableDeclarationExpression node) {
        return append(node);
    }

    @Override
    public boolean visit(StringTemplateExpression node) {
        return append(node); // subsumes StringFragment and StringTemplateComponent
    } 
    
    // ImplicitTypeDeclaration when parsing from method, just pass through as default
        
    @Override
    public boolean visit(MethodDeclaration node) {
        JavaCodeJavadocComment comment = new JavaCodeJavadocComment(null, null);
        Javadoc javadoc = node.getJavadoc();
        if (null != javadoc) {
            CodeParser.apply(() -> javadoc.tags(), TagElement.class, t -> {
                String tagName = t.getTagName();
                if (null == tagName) { // main comment
                    comment.setComment(CodeParser.join(t.fragments(), 0, -1));
                } else if (TagElement.TAG_PARAM.equals(tagName)) {
                    CodeParser.idRest(t.fragments(), (i, r) -> comment.addParameterComment(i, r));
                } else if (TagElement.TAG_EXCEPTION.equals(tagName)) {
                    CodeParser.idRest(t.fragments(), (i, r) -> comment.addExceptionComment(i, r));
                } else if (TagElement.TAG_RETURN.equals(tagName)) {
                    comment.addReturnComment(CodeParser.join(t.fragments(), 0, -1));
                }
            });
        }
        // consistency, comments via block comments where annotation not possible
        String docComment = CodeParser.getComment(node, comments, source);
        if (null != docComment) {
            comment.setComment(docComment);
        }
        AtomicBoolean enabled = new AtomicBoolean(true);
        JavaCodeClass enclosing = getCurrentClass();
        JavaCodeMethod m = new JavaCodeMethod(JavaCodeTypeSpecification.create(node.getReturnType2()), 
            node.getName().getIdentifier(), enclosing, null);
        if (null != enclosing) {
            enclosing.addMethod(m);
        }
        m.setJavadocComment(comment); // explicitly take over
        // modifier
        processModifier(() -> node.modifiers(), m);
        // method annotations
        CodeParser.processAnnotations(() -> node.modifiers(), e -> enabled.set(e), 
            c -> m.getJavadocComment().setComment(c), m);
        // throws
        CodeParser.apply(() -> node.thrownExceptionTypes(), Type.class, t -> {
            m.addException(t.toString(), CodeParser.getComment(t, comments, source));
        });
        // param
        CodeParser.apply(() -> node.parameters(), SingleVariableDeclaration.class, d -> {
            AtomicBoolean paramEnabled = new AtomicBoolean(true);
            AtomicReference<String> paramComment = new AtomicReference<>();
            paramComment.set(CodeParser.getComment(d, comments, source));
            JavaCodeParameterSpecification p = new JavaCodeParameterSpecification(d.getType().toString(), 
                d.getName().getIdentifier(), m);
            CodeParser.apply(() -> d.modifiers(), Modifier.class, mod -> {
                p.setFinal(mod.isFinal());
            });
            CodeParser.processAnnotations(() -> d.modifiers(), e -> paramEnabled.set(e), 
                c -> paramComment.set(c), p);
            if (paramEnabled.get()) {
                m.addParameter(p, paramComment.get());
            } else {
                m.getJavadocComment().deleteParameterComment(p.getName());
            }
        });
        blocks.push(m.getBlock());
        if (null != node.getBody()) { // interface signature
            node.getBody().accept(this);
        }
        blocks.pop();
        if (enabled.get()) {
            method = m;
        }
        return false; // skip children
    }            
    
    
}