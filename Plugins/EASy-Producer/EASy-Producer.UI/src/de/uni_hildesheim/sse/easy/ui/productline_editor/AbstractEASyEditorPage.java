package de.uni_hildesheim.sse.easy.ui.productline_editor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.IPageChangedListener;
import org.eclipse.jface.dialogs.PageChangedEvent;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IPropertyListener;
import org.eclipse.ui.forms.IFormColors;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormText;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

import de.uni_hildesheim.sse.easy_producer.model.ProductLineProject;

/**
 * Abstract super class for editor pages of the EASy-Producer tool suite.
 * @author El-Sharkawy
 *
 */
public abstract class AbstractEASyEditorPage extends Composite implements IPageChangedListener, 
    IPropertyListener {
    
    private ProductLineProject plp;
    private FormToolkit toolkit;
    private ScrolledForm contentPane;
    private List<IEASyPageListener> pageListeners;
      
    /**
     * Sole constructor for this class.
     * @param plp The {@link ProductLineProject} edited in this editor page.
     * @param title The title for this editor page.
     * @param parent The parent, holding this editor page.
     */
    public AbstractEASyEditorPage(ProductLineProject plp, String title, Composite parent) {
        super(parent, SWT.BORDER);
        this.plp = plp;
        setLayout(new FillLayout());
        pageListeners = new ArrayList<IEASyPageListener>();
        toolkit = new FormToolkit(getDisplay());
        contentPane = toolkit.createScrolledForm(this);
        GridLayout layout = new GridLayout();
        contentPane.getBody().setLayout(layout);
        
        //Set Title contentPane.setText(text) will cause that scrollbars won't work correctly.
        FormText titleText = toolkit.createFormText(contentPane.getBody(), false);
        String htmlTitle = "<form><p><span color=\"header\" font=\"header\">" + title + ": " + plp.getProjectName()
            + "</span></p></form>";
        titleText.setWhitespaceNormalized(true);
        titleText.setFont("header", JFaceResources.getHeaderFont());
        titleText.setColor("header", toolkit.getColors().getColor(IFormColors.TITLE));
        titleText.setText(htmlTitle, true, false);
    }
    
    @Override
    public boolean setFocus() {
        return contentPane.setFocus();
    }
    
    /**
     * Returns the {@link ProductLineProject} currently edited by this editor.
     * @return The {@link ProductLineProject} edited in the current editor.
     */
    protected final ProductLineProject getProductLineProject() {
        return plp;
    }
    
    /**
     * Returns the content pane of this editor page.
     * @return The content pane of this editor page
     */
    public final Composite getContentPane() {
        return contentPane.getBody();
    }
    
    /**
     * Refreshes the shown content of the current project.
     */
    public abstract void refresh();
    
    /**
     * Returns the text label for the editor page.
     * @return The text label for the editor page.
     */
    public abstract String getPageText();
    
    /**
     * This method will be called, when this editor page becomes active.
     */
    protected abstract void pageActivated();
    
    @Override
    public final void pageChanged(PageChangedEvent event) {
        if (event.getSelectedPage() == this) {
            pageActivated();
        }
    }
    
    /**
     * Informs all {@link IEASyPageListener} that this page became dirty.
     */
    public final void setDirty() {
        for (int i = 0; i < pageListeners.size(); i++) {
            pageListeners.get(i).pageBecomesDirty(this);
        }
    }
    
    /**
     * Registers a new {@link IEASyPageListener} which will be informed when this page becomes dirty.
     * @param listener A {@link IEASyPageListener} which will be informed when this page becomes dirty.
     */
    public void register(IEASyPageListener listener) {
        pageListeners.add(listener);
    }
    
    @Override
    public void dispose() {
        close();
        toolkit.dispose();
        super.dispose();
    }

    /**
     * Optional method for specifying an on-closed action.
     */
    public abstract void close();
    
    /**
     * Creates a form widget in the {@link #getContentPane()}. Note that this widget does
     * not scroll its content, so make sure there is a scrolled composite up the
     * parent chain. If you require scrolling, use 'createScrolledForm' instead.
     * 
     * @return the form that does not scroll
     */
    protected Form createForm() {
        return toolkit.createForm(getContentPane());
    }
    
    /**
     * Returns the toolkit for creating new widgets.
     * @return Toolkit for creating new widgets
     */
    protected FormToolkit getToolkit() {
        return toolkit;
    }
    
    /**
     * Creates a new subsection inside the current page. This subsection has its own heading and can be (un-)folded.
     * 
     * @param title
     *            The title of the section
     * @param description
     *            The description of the section (will be shown directly under the title)
     * @param gridStyle A GridData constants for configuring the behavior of the section.
     *     Usually,  <tt>GridData.FILL_HORIZONTAL</tt> should be appropriate.
     * @return A new composite where new elements can be added to.
     *     The newly created composite must be configured with a {@link GridLayout} otherwise
     *     nested elements will not be displayed.
     * @see #createSection(String, String, int, int)
     */
    protected Composite createSection(String title, String description, int gridStyle) {
        int style = Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED;
        if (null != description) {
            style |= Section.DESCRIPTION;
        }
        
        return createSection(title, description, style, gridStyle);
    }
    
    /**
     * Creates a new subsection inside the current page. This subsection has its own heading and can be (un-)folded.
     * 
     * @param title
     *            The title of the section
     * @param description
     *            The description of the section (will be shown directly under the title)
     * @param style the section style (use SWT constants).
     * @param gridStyle A GridData constants for configuring the behavior of the section.
     *     Usually,  <tt>GridData.FILL_HORIZONTAL</tt> should be appropriate.
     * @return A new composite where new elements can be added to.
     *     The newly created composite must be configured with a {@link GridLayout} otherwise
     *     nested elements will not be displayed.
     * @see #createSection(String, String, int)
     */
    protected Composite createSection(String title, String description, int style, int gridStyle) {
        Section section = getToolkit().createSection(getContentPane(), style);
        section.setText(title);
        if (null != description) {
            section.setDescription(description);
        }
        GridData data = new GridData(gridStyle);
        section.setLayoutData(data);
        Composite client = getToolkit().createComposite(section, SWT.WRAP);
        section.setClient(client);

        return client;
    }
}
