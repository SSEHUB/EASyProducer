package net.ssehub.easy.instantiation.core.model.templateModel;

import net.ssehub.easy.instantiation.core.model.common.RuntimeEnvironment;
import net.ssehub.easy.instantiation.core.model.common.VariableDeclaration;

/**
 * A simple tracer interface providing test support to the execution part.
 * 
 * @author Holger Eichelberger
 */
public interface ITracer extends net.ssehub.easy.instantiation.core.model.common.ITracer {

    /**
     * Starts visiting a template.
     * 
     * @param template the template being visited
     */
    public void visitTemplate(Template template);

    /**
     * Ends visiting a template.
     * 
     * @param template the template
     */
    public void visitedTemplate(Template template);
    
    /**
     * Starts visiting a sub-template.
     * 
     * @param def the sub-template
     * @param environment the runtime environment
     */
    public void visitDef(Def def, RuntimeEnvironment environment);

    /**
     * Ends visiting a sub-template.
     * 
     * @param def the sub-template
     * @param environment the runtime environment
     * @param result the execution result
     */
    public void visitedDef(Def def, RuntimeEnvironment environment, Object result);
    
    /**
     * A switch statement was visited.
     * 
     * @param select the select value
     * @param alternative the successive alternative (0-based index including default)
     * @param value the actual value of the switch statement
     */
    public void visitedSwitch(Object select, int alternative, Object value);
 
    /**
     * Visiting a loop started.
     * 
     * @param var the loop/iterator variable
     */
    public void visitLoop(VariableDeclaration var);

    /**
     * Visiting a loop ended.
     * 
     * @param var the loop/iterator variable
     */
    public void visitedLoop(VariableDeclaration var);
    
    /**
     * An alternative was visited.
     * 
     * @param takeIf if <code>true</code> the if-branch is used, <code>false</code> else the else-branch
     */
    public void visitAlternative(boolean takeIf);
    
    /**
     * Is called when the execution of a template language element failed.
     * 
     * @param element the failed element
     */
    public void failedAt(ITemplateLangElement element);

    /**
     * Is called at the beginning of a while body being visited.
     */
    public void visitWhileBody();

    /**
     * Is called at the end of a while body being visited.
     */
    public void visitedWhileBody();
    
}
