package de.uni_hildesheim.sse.dslCore.translation;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;

/**
 * A basic implementation of a model translator, i.e., a basic class for translating
 * individual model elements into model instances. This class relies on an associated
 * {@link ExpressionTranslator}.
 * 
 * @param <E> the specific type of expression translator to be used
 * 
 * @author Holger Eichelberger
 */
public abstract class ModelTranslator <E extends ExpressionTranslator> extends MessageReceiver {

    private E expressionTranslator;
    
    /**
     * Creates a new model translator.
     * 
     * @param expressionTranslator the associated expression translator
     */
    public ModelTranslator(E expressionTranslator) {
        this.expressionTranslator = expressionTranslator;
    }
    
    /**
     * Selects the given <code>objects</code> by <code>type</code>.
     * 
     * @param <T> the actual type of list entries
     * 
     * @param objects the objects to be considered
     * @param type the type as selection criterion
     * @return the selected objects being instance of <code>type</code>
     */
    protected static <T extends EObject> List<T> select(EList<? extends EObject> objects,  Class<T> type) {
        List<T> decls = new ArrayList<T>();
        for (EObject elt : objects) {
            if (type.isInstance(elt)) {
                decls.add(type.cast(elt));
            }
        }
        return decls;
    }
    
    /**
     * Returns the associated expression translator.
     * 
     * @return the expression translator
     */
    protected E getExpressionTranslator() {
        return expressionTranslator;
    }
    
    /**
     * {@inheritDoc}
     */
    public int getMessageCount() {
        return expressionTranslator.getMessageCount();
    }

    /**
     * {@inheritDoc}
     */
    public int getErrorCount() {
        return expressionTranslator.getErrorCount();
    }

    /**
     * {@inheritDoc}
     */
    public Message getMessage(int index) {
        return expressionTranslator.getMessage(index);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void error(String message, EObject cause, EStructuralFeature causeFeature,
            int code) {
        expressionTranslator.error(message, cause, causeFeature, code);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void warning(String message, EObject cause,
            EStructuralFeature causeFeature, int code) {
        expressionTranslator.warning(message, cause, causeFeature, code);
    }

    /**
     * Adds a diagnostic error, typically from a standalone parser
     * configuration.
     * 
     * @param diagnostic
     *            the diagnostic to be added
     */
    public void error(Diagnostic diagnostic) {
        expressionTranslator.error(diagnostic);
    }

}
