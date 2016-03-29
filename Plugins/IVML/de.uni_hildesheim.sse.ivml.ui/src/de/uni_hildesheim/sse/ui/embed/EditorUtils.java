package de.uni_hildesheim.sse.ui.embed;

import org.eclipse.swt.widgets.Composite;

import com.google.inject.Injector;

import de.uni_hildesheim.sse.ConstraintSyntaxException;
import de.uni_hildesheim.sse.ModelUtility;
import de.uni_hildesheim.sse.ui.internal.IvmlActivator;
import net.ssehub.easy.basics.modelManagement.ModelInfo;
import net.ssehub.easy.dslCore.ui.editors.EmbeddingHelper;
import net.ssehub.easy.dslCore.ui.editors.IEmbeddedEditor;
import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.model.IModelElement;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.persistency.ConstraintSplitWriter;
import net.ssehub.easy.varModel.persistency.ConstraintSplitWriter.IConstraintFilter;

/**
 * Provides editor utility methods.
 * 
 * @author Holger Eichelberger
 */
public class EditorUtils {

    /**
     * Creates an instance (public constructor required by OSGI-DS).
     */
    public EditorUtils() {
    }
    
    /**
     * Embeds an IVML editor for the given resource into the given <code>parent</code>.
     * 
     * @param file the file representing the resource
     * @param parent the parent UI component
     * @return the embedded editor (or <b>null</b> if embedding failed)
     */
    public static IEmbeddedEditor embedIvmlEditor(java.net.URI file, Composite parent) {
        return EmbeddingHelper.embedEditor(file, parent, getInjector());
    }
    
    private static Injector getInjector() {
        IvmlActivator activator = IvmlActivator.getInstance();
        return activator.getInjector(IvmlActivator.DE_UNI_HILDESHEIM_SSE_IVML);
    }

    /**
     * Embeds an IVML editor for the constraint indicated by <code>filter</code> in given resource into the given 
     * <code>parent</code>.
     * 
     * @param info the model information of the containing project
     * @param parent the parent UI component
     * @param filter the constraint filter indicating then constraint to embed into the editor
     * @param trimParenthesis shifts the outermost parenthesis pair to the model context
     * @return the embedded editor (or <b>null</b> if embedding failed)
     */
    public static IEmbeddedEditor embedIvmlConstraintEditor(ModelInfo<Project> info, Composite parent, 
        IConstraintFilter filter, boolean trimParenthesis) {
        IEmbeddedEditor result;
        if (null != info && null != info.getResolved()) {
            ConstraintSplitWriter writer = new ConstraintSplitWriter(filter);
            writer.setIndentationStep(0); 
            writer.setUseWhitespaces(true);
            info.getResolved().accept(writer);
            result = EmbeddingHelper.embedEditor(info.getLocation(), parent, getInjector(), 
                writer.getSplit(true, trimParenthesis), false);
        } else {
            result = null;
        }
        return result;
    }
    
    /**
     * Sets new content for the given <code>editor</code>.
     * 
     * @param editor the editor to set the content on
     * @param info the model information of the containing project
     * @param filter the constraint filter indicating then constraint to embed into the editor
     * @param trimParenthesis shifts the outermost parenthesis pair to the model context
     */
    public static void setConstraint(IEmbeddedEditor editor, ModelInfo<Project> info, IConstraintFilter filter, 
        boolean trimParenthesis) {
        ConstraintSplitWriter writer = new ConstraintSplitWriter(filter);
        info.getResolved().accept(writer);
        editor.setContent(writer.getSplit(true, trimParenthesis));
    }
    
    /**
     * Obtains the edited expression from an editor created by 
     * {@link #embedIvmlConstraintEditor(ModelInfo, Composite, IConstraintFilter)}.
     * 
     * @param editor the editor
     * @param info the model information of the containing project
     * @param context the context to resolve the expression within, see 
     *     {@link ModelUtility#createExpression(String, IModelElement)}, if <b>null</b>, the resolved project from 
     *     <code>info</code> is taken
     * @return the edited expression
     * @throws CSTSemanticException in case of semantic problems in the constraint
     * @throws ConstraintSyntaxException in case of syntax problems in the constraint
     */
    public static ConstraintSyntaxTree obtainExpression(IEmbeddedEditor editor, ModelInfo<Project> info, 
        IModelElement context) throws CSTSemanticException, ConstraintSyntaxException {
        if (null == context) {
            context = info.getResolved();
        }
        ConstraintSyntaxTree result = null;
        if (null != context) {
            result = ModelUtility.INSTANCE.createExpression(editor.getEditableContent(), context);
        }
        return result;
    }

}
