package net.ssehub.easy.instantiation.core.model.templateModel;

import net.ssehub.easy.instantiation.core.model.common.VilException;

/**
 * A visitor interface for the template language elements.
 * 
 * @author Holger Eichelberger
 */
public interface IVisitor extends net.ssehub.easy.instantiation.core.model.common.IVisitor {
    
    /**
     * Visits a template.
     * 
     * @param template the template to visit
     * @return the result of visiting the given statement (may be <b>null</b>)
     * @throws VilException in case that visiting fails (e.g., execution)
     */
    public Object visitTemplate(Template template) throws VilException;

    /**
     * Visits a sub-template definition.
     * 
     * @param def the sub-template definition to visit
     * @return the result of visiting the given statement (may be <b>null</b>)
     * @throws VilException in case that visiting fails (e.g., execution)
     */
    public Object visitDef(Def def) throws VilException;

    /**
     * Visits a template block.
     * 
     * @param block the template block to visit
     * @return the result of visiting the given statement (may be <b>null</b>)
     * @throws VilException in case that visiting fails (e.g., execution)
     */
    public Object visitTemplateBlock(TemplateBlock block) throws VilException;
    
    /**
     * Visits an alternative statement.
     * 
     * @param alternative the alternative to visit
     * @return the result of visiting the given statement (may be <b>null</b>)
     * @throws VilException in case that visiting fails (e.g., execution)
     */
    public Object visitAlternative(AlternativeStatement alternative) throws VilException;
    
    /**
     * Visits a loop statement.
     * 
     * @param loop the loop statement to visit
     * @return the result of visiting the given statement (may be <b>null</b>)
     * @throws VilException in case that visiting fails (e.g., execution)
     */
    public Object visitLoop(LoopStatement loop) throws VilException;

    /**
     * Visits a while statement.
     * 
     * @param stmt the while statement to visit
     * @return the result of visiting the given statement (may be <b>null</b>)
     * @throws VilException in case that visiting fails (e.g., execution)
     */
    public Object visitWhile(WhileStatement stmt) throws VilException;

    /**
     * Visits a switch statement.
     * 
     * @param swtch the switch statement to visit
     * @return the result of visiting the given statement (may be <b>null</b>)
     * @throws VilException in case that visiting fails (e.g., execution)
     */
    public Object visitSwitch(SwitchStatement swtch) throws VilException;

    /**
     * Visits a content statement.
     * 
     * @param cnt the content statement
     * @return the result of visiting the given statement (may be <b>null</b>)
     * @throws VilException in case that visiting fails (e.g., execution)
     */
    public Object visitContentStatement(ContentStatement cnt) throws VilException;

    /**
     * Visits a java extension.
     * 
     * @param ext the java extension
     * @return the result of visiting the given statement (may be <b>null</b>)
     * @throws VilException in case that visiting fails (e.g., execution)
     */
    public Object visitJavaExtension(JavaExtension ext) throws VilException;

    /**
     * Visits a template call expression.
     * 
     * @param call the call expression
     * @return the result of visiting the given expression (may be <b>null</b>)
     * @throws VilException in case that visiting fails (e.g., execution)
     */
    public Object visitTemplateCallExpression(TemplateCallExpression call) throws VilException;
    
    /**
     * Visits a flush statement.
     * 
     * @param flush the flush statement
     * @return the result visiting the given statement (may be <b>null</b>)
     * @throws VilException in case that visiting fails (e.g., execution)
     */
    public Object visitFlush(FlushStatement flush) throws VilException;

    /**
     * Visits a content alternative expression.
     * 
     * @param ex the expression
     * @return the result visiting the given statement (may be <b>null</b>)
     * @throws VilException in case that visiting fails (e.g., execution)
     */
    public Object visitContentAlternativeExpression(ContentAlternativeExpression ex) throws VilException;

    /**
     * Visits a content loop expression.
     * 
     * @param ex the expression
     * @return the result visiting the given statement (may be <b>null</b>)
     * @throws VilException in case that visiting fails (e.g., execution)
     */
    public Object visitContentLoopExpression(ContentLoopExpression ex) throws VilException;

    /**
     * Visits a content variable declaration expression.
     * 
     * @param ex the expression
     * @return the result visiting the given statement (may be <b>null</b>)
     * @throws VilException in case that visiting fails (e.g., execution)
     */
    public Object visitContentVarDeclExpression(ContentVarDeclExpression ex) throws VilException;

}
