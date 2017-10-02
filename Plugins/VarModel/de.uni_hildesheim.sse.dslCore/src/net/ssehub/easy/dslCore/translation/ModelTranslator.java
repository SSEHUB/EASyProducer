package net.ssehub.easy.dslCore.translation;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;

import net.ssehub.easy.basics.messages.IMessage;

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
    public static <T extends EObject> List<T> select(List<? extends EObject> objects,  Class<T> type) {
        List<T> decls = new ArrayList<T>();
        for (EObject elt : objects) {
            if (type.isInstance(elt)) {
                decls.add(type.cast(elt));
            }
        }
        return decls;
    }

    /**
     * Copies a set of <code>objects</code>.
     * 
     * @param <T> the actual type of list entries
     * 
     * @param objects the objects to be copied (may be <b>null</b>)
     * @return the copied instance (<b>null</b> if <code>object</code> is <b>null</b>)
     */
    public static <T> List<T> copy(List<T> objects) {
        List<T> decls;
        if (null == objects) {
            decls = null;
        } else {
            decls = new ArrayList<T>(objects.size());
            decls.addAll(objects);
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
    
    @Override
    public int getMessageCount() {
        return expressionTranslator.getMessageCount();
    }

    @Override
    public int getErrorCount() {
        return expressionTranslator.getErrorCount();
    }

    @Override
    public Message getMessage(int index) {
        return expressionTranslator.getMessage(index);
    }

    @Override
    public void error(String message, EObject cause, EStructuralFeature causeFeature, int code) {
        expressionTranslator.error(message, cause, causeFeature, code);
    }

    @Override
    public void warning(String message, EObject cause, EStructuralFeature causeFeature, int code) {
        expressionTranslator.warning(message, cause, causeFeature, code);
    }
    
    @Override
    public void collect(IMessage message, EObject cause, EStructuralFeature causeFeature, int code) {
        expressionTranslator.collect(message, cause, causeFeature, code);
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
