package de.uni_hildesheim.sse.easy.ui.configuration;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.dialogs.PropertyPage;

/**
 * Just an empty property page as the main hook-in point for EASy-Producer preference pages.
 * 
 * @author Holger Eichelberger
 */
public class MainPropertyPage extends PropertyPage implements IWorkbenchPreferencePage {

    @Override
    public void init(IWorkbench workbench) {
    }

    @Override
    protected Control createContents(Composite parent) {
        return new Composite(parent, SWT.NULL);
    }

}
