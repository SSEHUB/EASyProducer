package de.uni_hildesheim.sse.easy.ui.reasoner;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.PlatformUI;

import de.uni_hildesheim.sse.reasoning.core.frontend.ReasonerFrontend;
import de.uni_hildesheim.sse.reasoning.core.reasoner.ReasonerDescriptor;
import de.uni_hildesheim.sse.reasoning.core.reasoner.ReasoningResult;
import de.uni_hildesheim.sse.utils.progress.ProgressObserver;

/**
 * Implements the preference page.
 * 
 * @author Holger Eichelberger
 */
public class ReasonerPreferencePage extends PreferencePage implements
    IWorkbenchPreferencePage, Listener {

    private static final String UNKNOWN = "unknown";
    private static final boolean DEBUG = false;
    private static final ReasonerDescriptor[] DEBUG_REASONERS;
    
    /**
     * A virtual reasoner for debugging.
     */
    static {
        ReasonerDescriptor[] debugReasoners = null;
        if (DEBUG) {
            try {
                debugReasoners = new ReasonerDescriptor[1];
                File file = new File(".");
                debugReasoners[0] = new ReasonerDescriptor("SSE-SMT", "4.01", 
                    "Copyright (c) 2000, 2011 IBM Corporation and others."
                    + "All rights reserved. This program and the accompanying materials"
                    + "are made available under the terms of the Eclipse Public License v1.0"
                    + "which accompanies this distribution, and is available at"
                    + "http://www.eclipse.org/legal/epl-v10.html", 
                    null, file.toURI().normalize().toURL());
            } catch (MalformedURLException e) {
            }
        }
        DEBUG_REASONERS = debugReasoners;
    }
    
    private Table reasoners;
    private Text license;
    private Text licenseRestriction;
    private Text version;
    private Text url;
    private Button file;
    private Button dir;
    private Button upgrade;
    private ReasonerFrontend frontend;

    /**
     * {@inheritDoc}
     */
    @Override
    public void init(IWorkbench workbench) {
        frontend = ReasonerFrontend.getInstance();
    }

    // TODO HE: allow to select the hint reasoner... further settings in future

    /**
     * {@inheritDoc}
     */
    @Override
    protected Control createContents(Composite parent) {
        Composite pageComponent = new Composite(parent, SWT.NULL);
        GridLayout layout = new GridLayout();
        layout.numColumns = 3;
        layout.marginWidth = 0;
        layout.marginHeight = 0;
        pageComponent.setLayout(layout);
        GridData data = new GridData();
        data.verticalAlignment = GridData.FILL;
        data.horizontalAlignment = GridData.FILL;
        pageComponent.setLayoutData(data);

        Label label = new Label(pageComponent, SWT.LEFT);
        label.setText("This page displays the currently installed reasoners, their "
            + "licenses and allows to upgrade a licensed reasoner.\n An upgrade may happen"
            + "using the original URI provided by the reasoner or by providing an "
            + "own (local) URI,\n e.g. after downloading.");
        data = new GridData();
        data.horizontalAlignment = GridData.FILL;
        data.horizontalSpan = 3;
        label.setLayoutData(data);
        
        label = new Label(pageComponent, SWT.LEFT);
        label.setText("Installed reasoners:");
        data = new GridData();
        data.horizontalAlignment = GridData.FILL;
        data.horizontalSpan = 3;
        label.setLayoutData(data);
        
        reasoners = new Table(pageComponent, SWT.MULTI | SWT.BORDER
                | SWT.FULL_SELECTION | SWT.SINGLE);
        reasoners.addListener(SWT.Selection, this);
        data = new GridData(GridData.FILL_HORIZONTAL);
        int availableRows = availableRows(pageComponent);
        data.heightHint = reasoners.getItemHeight() * (availableRows / 8);
        data.horizontalSpan = 3;
        reasoners.setLayoutData(data);
        
        initializeReasonersList();
        createReasonerDescriptionComponents(pageComponent);
        
        if (reasoners.getItemCount() > 0) {
            reasoners.setSelection(0);
            displayReasonerData();
        }
        return pageComponent;
    }
    
    /**
     * Creates the components for describing a reasoner.
     * 
     * @param pageComponent the parent page component
     */
    private void createReasonerDescriptionComponents(Composite pageComponent) {
        Label label = new Label(pageComponent, SWT.LEFT);
        label.setText("Version");
        
        version = new Text(pageComponent, SWT.LEFT | SWT.BORDER);
        version.setEditable(false);
        GridData data = new GridData(GridData.FILL_HORIZONTAL);
        data.horizontalSpan = 2;
        version.setLayoutData(data);
        
        label = new Label(pageComponent, SWT.LEFT);
        label.setText("License");
        
        license = new Text(pageComponent, SWT.LEFT | SWT.BORDER | SWT.WRAP);
        license.setEditable(false);
        data = new GridData(GridData.FILL_HORIZONTAL);
        data.horizontalSpan = 2;
        data.heightHint = license.getLineHeight() * 5;
        license.setLayoutData(data);

        label = new Label(pageComponent, SWT.LEFT);
        label.setText("License restriction");
        
        licenseRestriction = new Text(pageComponent, SWT.LEFT | SWT.BORDER | SWT.WRAP);
        licenseRestriction.setEditable(false);
        data = new GridData(GridData.FILL_HORIZONTAL);
        data.horizontalSpan = 2;
        data.heightHint = licenseRestriction.getLineHeight() * 2;
        licenseRestriction.setLayoutData(data);
        
        label = new Label(pageComponent, SWT.LEFT);
        label.setText("Download URL");
        
        url = new Text(pageComponent, SWT.LEFT | SWT.BORDER);
        url.setEditable(false);
        data = new GridData(GridData.FILL_HORIZONTAL);
        data.horizontalSpan = 1;
        url.setLayoutData(data);

        createUpgradeButtons(pageComponent);
    }

    /**
     * Creates a formatted component for the upgrade buttons.
     * 
     * @param pageComponent the parent page component
     * @return the created component
     */
    private Composite createUpgradeButtons(Composite pageComponent) {
        Composite buttonComponent = new Composite(pageComponent, SWT.NULL);
        buttonComponent.setLayout(new FillLayout());
        
        file = new Button(buttonComponent, SWT.CENTER);
        file.setText("File");
        file.setEnabled(false);
        file.addListener(SWT.Selection, this);

        dir = new Button(buttonComponent, SWT.CENTER);
        dir.setText("Directory");
        dir.setEnabled(false);
        dir.addListener(SWT.Selection, this);
        
        upgrade = new Button(buttonComponent, SWT.CENTER);
        upgrade.setText("upgrade");
        upgrade.setEnabled(false);
        upgrade.addListener(SWT.Selection, this);

        return buttonComponent;
    }

    /**
     * Returns the number of available reasoner descriptors. This method transparently uses any 
     * virtual reasoner defined in this class for debugging the UI.
     * 
     * @return the number of available reasoners
     */
    private int getReasonersCount() {
        int count = frontend.getReasonersCount();
        if (null != DEBUG_REASONERS) {
            count += DEBUG_REASONERS.length;
        }
        return count;
    }
    
    /**
     * Returns the specified reasoner descriptor. This method transparently uses any 
     * virtual reasoner defined in this class for debugging the UI.
     * 
     * @param index the index of the reasoner to return
     * @return the reasoner
     * @throws IndexOutOfBoundsException if 
     *   <code>index&lt;0 || index&gt;={{@link #getReasonersCount()}}</code>
     */
    private ReasonerDescriptor getReasonerDescriptor(int index) {
        ReasonerDescriptor result;
        if (null != DEBUG_REASONERS) {
            int originalCount = frontend.getReasonersCount();
            if (index >= originalCount) {
                result = DEBUG_REASONERS[index - originalCount];
            } else {
                result = frontend.getReasonerDescriptor(index);
            }
        } else {
            result = frontend.getReasonerDescriptor(index);
        }
        return result;
    }
    
    /**
     * Initializes the list of reasoners.
     */
    private void initializeReasonersList() {
        ReasonerDescriptor defaultHint = frontend.getReasonerHint();
        int count = getReasonersCount();
        for (int r = 0; r < count; r++) {
            ReasonerDescriptor descriptor = getReasonerDescriptor(r);
            String name;
            String imgName;
            if (null == descriptor) {
                name = UNKNOWN;
                imgName = Images.NAME_UNKNOWN;
            } else {
                boolean ready = descriptor.isReadyForUse();
                name = descriptor.getName();
                if (defaultHint == descriptor) {
                    if (ready) {
                        imgName = Images.NAME_READY_DEFAULT;
                    } else {
                        imgName = Images.NAME_NOT_READY_DEFAULT;
                    }
                } else {
                    if (ready) {
                        imgName = Images.NAME_READY;
                    } else {
                        imgName = Images.NAME_NOT_READY;
                    }
                }
            }
            TableItem item = new TableItem(reasoners, SWT.NULL, r);
            item.setImage(Images.getImage(imgName));
            item.setText(name);
            item.setData(descriptor);
        }
    }

    /**
     * Return the number of rows available in the current display using the
     * current font.
     * 
     * @param parent The Composite whose Font will be queried.
     * @return the result of the display size divided by the font size.
     */
    public static int availableRows(Composite parent) {

        int fontHeight = (parent.getFont().getFontData())[0].getHeight();
        int displayHeight = parent.getDisplay().getClientArea().height;

        return displayHeight / fontHeight;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void handleEvent(Event event) {
        if (event.widget == reasoners) {
            displayReasonerData();
        } else if (event.widget == file) {
            displayFileDialog();
        } else if (event.widget == dir) {
            displayDirDialog();
        } else if (event.widget == upgrade) {
            upgrade();
        }
    }
    
    /**
     * Turns a string into a safe (empty) string.
     * 
     * @param string the string to be considered
     * @return <code>string</code> or an empty string if <code>string = <b>null</b></code>
     */
    private static final String toSafeString(String string) {
        String result;
        if (null == string) {
            result = "";
        } else {
            result = string;
        }
        return result;
    }
    
    /**
     * Displays the data of the currently selected reasoner and switches the enabled
     * states accordingly. 
     */
    private void displayReasonerData() {
        ReasonerDescriptor descriptor = getSelected();
        if (null != descriptor) {
            version.setText(toSafeString(descriptor.getVersion()));
            license.setText(toSafeString(descriptor.getLicense()));
            licenseRestriction.setText(toSafeString(descriptor.getLicenseRestriction()));
            String urlText;
            if (null == descriptor.getDownloadSource()) {
                urlText = "";
            } else {
                urlText = toSafeString(descriptor.getDownloadSource().toString());
            }
            url.setText(urlText);
            boolean upgradeEnabled = (urlText.length() > 0);
            file.setEnabled(upgradeEnabled);
            dir.setEnabled(upgradeEnabled);
            url.setEditable(upgradeEnabled);
            upgrade.setEnabled(upgradeEnabled);
        } else {
            license.setText(UNKNOWN);
            licenseRestriction.setText(UNKNOWN);
            version.setText(UNKNOWN);
            url.setText(UNKNOWN);
            file.setEnabled(false);
            dir.setEnabled(false);
            url.setEditable(false);
            upgrade.setEnabled(false);
        }
    }

    /**
     * Returns the currently selected reasoner.
     * 
     * @return the currently selected reasoner
     */
    private ReasonerDescriptor getSelected() {
        // single selection only, just consider the first entry
        ReasonerDescriptor result = null;
        TableItem[] selection = reasoners.getSelection();
        if (null != selection && selection.length > 0) {
            result = (ReasonerDescriptor) selection[0].getData();
        }
        return result;
    }
    
    /**
     * Display the file dialog for choosing the URL source.
     */
    private void displayFileDialog() {
        ReasonerDescriptor descriptor = getSelected();
        if (null != descriptor) {
            URL url = descriptor.getDownloadSource();
            if (null != url) {
                FileDialog fd = new FileDialog(getShell(), SWT.OPEN);
                fd.setFileName(toSafeString(url.toString()));
                String input = fd.open();
                if (null != input) {
                    File file = new File(input);
                    try {
                        this.url.setText(file.toURI().toURL().toString());
                    } catch (MalformedURLException e) {
                        MessageBox mb = new MessageBox(getShell(), SWT.OK);
                        mb.setText("Input problem");
                        mb.setMessage("Input is not a valid URL");
                        mb.open();
                    }
                }
            }
        }
    }
    
    /**
     * Display the directory dialog for choosing the URL source.
     */
    private void displayDirDialog() {
        ReasonerDescriptor descriptor = getSelected();
        if (null != descriptor) {
            URL url = descriptor.getDownloadSource();
            if (null != url) {
                DirectoryDialog dd = new DirectoryDialog(getShell());
                String input = dd.open();
                if (null != input) {
                    File file = new File(input);
                    try {
                        this.url.setText(file.toURI().toURL().toString());
                    } catch (MalformedURLException e) {
                        MessageBox mb = new MessageBox(getShell(), SWT.OK);
                        mb.setText("Input problem");
                        mb.setMessage("Input is not a valid URL");
                        mb.open();
                    }
                }
            }
        }
    }

    /**
     * Performs the upgrade of the selected reasoner.
     */
    private void upgrade() {
        ReasonerDescriptor descriptor = getSelected();
        StringBuilder builder = new StringBuilder();
        if (null != descriptor) {
            try {
                ReasoningResult result = frontend.upgradeReasoner(descriptor, new URI(url.getText()), 
                    ProgressObserver.NO_OBSERVER);
                if (result.getMessageCount() > 0) {
                    for (int m = 0; m < result.getMessageCount(); m++) {
                        if (m > 0) {
                            builder.append("\n");
                        }
                        builder.append(result.getMessage(m).getDescription());
                    }
                }
            } catch (URISyntaxException e) {
                builder.append(e.getMessage());
            }
        }

        if (builder.length() > 0) {
            MessageDialog.openError(getShell(), "Problems during upgrade", builder.toString());
        } else {
            if (MessageDialog.openQuestion(getShell(), "Successful", 
                "Upgrade complete. Eclipse needs to be restarted. Restart eclipse now?")) {
                PlatformUI.getWorkbench().restart();
            }
        }
    }
    
}
