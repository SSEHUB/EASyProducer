package de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilLanguageException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionException;

/**
 * A visitor interface for the template language elements.
 * 
 * @author Holger Eichelberger
 */
public interface IVisitor {
    
    /**
     * Visits a template.
     * 
     * @param template the template to visit
     * @return the result of visiting the given statement (may be <b>null</b>)
     * @throws VilLanguageException in case that visiting fails (e.g., execution)
     */
    public Object visitTemplate(Template template) throws VilLanguageException;

    /**
     * Visits a sub-template definition.
     * 
     * @param def the sub-template definition to visit
     * @return the result of visiting the given statement (may be <b>null</b>)
     * @throws VilLanguageException in case that visiting fails (e.g., execution)
     */
    public Object visitDef(Def def) throws VilLanguageException;

    /**
     * Visits a template block.
     * 
     * @param block the template block to visit
     * @return the result of visiting the given statement (may be <b>null</b>)
     * @throws VilLanguageException in case that visiting fails (e.g., execution)
     */
    public Object visitTemplateBlock(TemplateBlock block) throws VilLanguageException;
    
    /**
     * Visits an alternative statement.
     * 
     * @param alternative the alternative to visit
     * @return the result of visiting the given statement (may be <b>null</b>)
     * @throws VilLanguageException in case that visiting fails (e.g., execution)
     */
    public Object visitAlternative(AlternativeStatement alternative) throws VilLanguageException;
    
    /**
     * Visits a loop statement.
     * 
     * @param loop the loop statement to visit
     * @return the result of visiting the given statement (may be <b>null</b>)
     * @throws VilLanguageException in case that visiting fails (e.g., execution)
     */
    public Object visitLoop(LoopStatement loop) throws VilLanguageException;

    /**
     * Visits a switch statement.
     * 
     * @param swtch the switch statement to visit
     * @return the result of visiting the given statement (may be <b>null</b>)
     * @throws VilLanguageException in case that visiting fails (e.g., execution)
     */
    public Object visitSwitch(SwitchStatement swtch) throws VilLanguageException;

    /**
     * Visits a content statement.
     * 
     * @param cnt the content statement
     * @return the result of visiting the given statement (may be <b>null</b>)
     * @throws VilLanguageException in case that visiting fails (e.g., execution)
     */
    public Object visitContentStatement(ContentStatement cnt) throws VilLanguageException;

    /**
     * Visits a java extension.
     * 
     * @param ext the java extension
     * @return the result of visiting the given statement (may be <b>null</b>)
     * @throws VilLanguageException in case that visiting fails (e.g., execution)
     */
    public Object visitJavaExtension(JavaExtension ext) throws VilLanguageException;

    /**
     * Visits a template call expression.
     * 
     * @param call the call expression
     * @return the result of visiting the given expression (may be <b>null</b>)
     * @throws ExpressionException in case that visiting fails (e.g., execution)
     */
    public Object visitTemplateCallExpression(TemplateCallExpression call) throws ExpressionException;

}
