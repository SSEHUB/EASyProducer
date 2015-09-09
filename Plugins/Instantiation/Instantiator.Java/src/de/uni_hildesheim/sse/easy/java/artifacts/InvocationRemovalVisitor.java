package de.uni_hildesheim.sse.easy.java.artifacts;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.IMethodBinding;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;

/**
 * Visitor to find all method invocations.
 * 
 * @author Aike Sass
 *
 */
public class InvocationRemovalVisitor extends ASTVisitor {
    
    private MethodDeclaration methodDeclaration;
    private IMethodBinding methodDeclarationBinding;
    private boolean hasBeenDeleted;
    
    /**
     * Default Constructor.
     * 
     * @param methodDeclaration the method declaration
     */
    public InvocationRemovalVisitor(MethodDeclaration methodDeclaration) {
        this.methodDeclaration = methodDeclaration;
        this.methodDeclarationBinding = methodDeclaration.resolveBinding();
        hasBeenDeleted = false;
    }
    

    @Override
    public boolean visit(MethodInvocation node) {
        IMethodBinding iMethod = (IMethodBinding) node.resolveMethodBinding();
        IMethodBinding methodDeclarationCandidate = iMethod.getMethodDeclaration();
        if (check(methodDeclarationCandidate)) {
            node.getParent().delete();
            hasBeenDeleted = true;
        }
        return false;
    }
    
    /**
     * Check if a method binding matches to the one that should be deleted.
     * @param candidate the method binding that should be investigated
     * @return result
     */
    private boolean check(IMethodBinding candidate) {
        boolean result = null != candidate;
        result = result && methodDeclarationBinding.getName().equals(candidate.getName());
        return result;
    }
    
    /**
     * Getter that identifies if a node has been deleted.
     * @return true if node has been deleted otherwise false
     */
    public boolean hasBeenDeleted() {
        return hasBeenDeleted;
    }
    
}
