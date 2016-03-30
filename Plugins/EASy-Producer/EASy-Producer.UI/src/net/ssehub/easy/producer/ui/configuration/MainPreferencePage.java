package net.ssehub.easy.producer.ui.configuration;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/**
 * Just an empty preference page as the main hook-in point for EASy-Producer preference pages.
 * 
 * @author Holger Eichelberger
 */
public class MainPreferencePage extends PreferencePage implements
    IWorkbenchPreferencePage {

    @Override
    public void init(IWorkbench workbench) {
    }

    @Override
    protected Control createContents(Composite parent) {
        return new Composite(parent, SWT.NULL);
    }

}
