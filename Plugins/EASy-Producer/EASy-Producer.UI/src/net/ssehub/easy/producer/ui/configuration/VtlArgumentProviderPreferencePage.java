package net.ssehub.easy.producer.ui.configuration;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import net.ssehub.easy.producer.core.mgmt.VilArgumentProvider;
import net.ssehub.easy.producer.ui.internal.EASyPreferenceStore;

/**
 * Implements the providers - preference - page.
 * Existing Providers are shown in the table.
 * Providers can be customized using this page.
 * The user can de-/ activate providers, add and/or delete arguments by
 * typing them into the relevant row.
 * 
 * @author Niko Nowatzki
 */
public class VtlArgumentProviderPreferencePage extends PreferencePage implements
    IWorkbenchPreferencePage, Listener {
    
    private static final String[] TITLES = {"Name", "Parameter name",
        "Parameter type", "arguments allowed", "free arguments"};
    private Table providers;
    
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
        data = new GridData();
        data.horizontalAlignment = GridData.FILL;
        data.horizontalSpan = 3;
        label.setLayoutData(data);
        
        label = new Label(pageComponent, SWT.LEFT);
        label.setText("Enable, disable or configure VIL argument providers");
        data = new GridData();
        data.horizontalAlignment = GridData.FILL;
        data.horizontalSpan = 3;
        label.setLayoutData(data);
        
        addTable(pageComponent);
          
        providers.addListener(SWT.Selection, this);
        data = new GridData(GridData.FILL_HORIZONTAL);
        int availableRows = availableRows(pageComponent);
        data.heightHint = providers.getItemHeight() * (availableRows / 6);
        data.horizontalSpan = 3;
        providers.setLayoutData(data);

        // we do not need the restore - button, thus we cancel out both of the
        // inherited buttons and create our own apply - button.
        // Intention is not to see the difference between created and original button.
        noDefaultAndApplyButton();
        
        return pageComponent;
    }
    
    @Override
    protected void contributeButtons(final Composite parent) {
    
        //Create apply - button we will use instead of the original one
        final Button applyButton = new Button(parent, SWT.PUSH);
        applyButton.setText("Apply");

        final int widthHint = convertHorizontalDLUsToPixels(IDialogConstants.BUTTON_WIDTH);
        final GridData data = new GridData(SWT.FILL, SWT.CENTER, false, false);
        final org.eclipse.swt.graphics.Point minButtonSize = applyButton.computeSize(SWT.DEFAULT, SWT.DEFAULT, true);
        
        data.widthHint = Math.max(widthHint, minButtonSize.x);
        applyButton.setLayoutData(data);

        applyButton.addSelectionListener(new SelectionAdapter() {
        
                @Override
                public void widgetSelected(final SelectionEvent exc) {
                    performApply();
                }
            });

        final GridLayout layout = (GridLayout) parent.getLayout();
        layout.numColumns++;
    }
    
   
    /**
     * When apply-button is pressed store if providers are active or not.
     * Moreover store the arguments.
     */
    protected void performApply() {

        for (int i = 0; i < providers.getItemCount(); i++) {

            //TODO: The checkboxes are buggy. Sometimes the provider in the table - representation
            // seems not to be the correct VilArgumentProvier.
            if (providers.getItem(i).getChecked()) {
                VilArgumentProvider.getProvider(i).setActive(true);
            } else {
                VilArgumentProvider.getProvider(i).setActive(false);
            }
            
            //the arguments are in column 4..
            try {
                //Set the free arguments
                VilArgumentProvider.getProvider(i).setFreeArguments(providers.getItem(i).getText(4).trim().toString());
            } catch (NullPointerException e) {
                VilArgumentProvider.getProvider(i).setFreeArguments("");
            }
                
            EASyPreferenceStore.persistVilArgumentProviderStates();
        }
    }
    
    /**
     * Create table which shows the providers.
     * 
     * @param parent the parent.
     */
    private void addTable(Composite parent) {
    
        providers = new Table(parent, SWT.CHECK | SWT.BORDER
                | SWT.V_SCROLL | SWT.H_SCROLL);
        providers.setHeaderVisible(true);
        
        //Just for testing: Add some content to the table
        for (int i = 0; i < TITLES.length; i++) {
            TableColumn column = new TableColumn(providers, SWT.NULL);
            column.setText(TITLES[i]);
        }
        
        for (int i = 0; i < VilArgumentProvider.getProviderCount(); i++) {
            //Create new TableItem for each provider
            TableItem item = new TableItem(providers, SWT.NONE);

            VilArgumentProvider provider = VilArgumentProvider.getProvider(i);
            
            //Set Checkboxes
            if (VilArgumentProvider.getProvider(i).isActive()) {
                item.setChecked(true);
            } else {
                item.setChecked(false);
            }
            
            /*
             * Firstly we add the first 4 columns to the table-items because this is
             * essential for the decision whether a row is modifiable or not.
             * After that we add the free arguments to the items.
             * This is important because the method "makeModifiable" replaces certain cells in the table.
             */
            
            item.setText(0, String.valueOf(provider.getName()));
            item.setText(1, String.valueOf(provider.getParameterName()));
            item.setText(2, String.valueOf(provider.getParameterType()));
            item.setText(3, String.valueOf(provider.acceptsFreeArguments()));
            
            //make editor modifiable
            makeModifiable();
            
            try {
                item.setText(4, (provider.getFreeArguments().toString()));
            } catch (NullPointerException e) {
                item.setText(4, "");
            }
            
        }
    }
        
    /**
     * Make the editor modifiable.
     */
    private void makeModifiable() {
        final TableEditor editor = new TableEditor(providers);
        editor.horizontalAlignment = SWT.LEFT;
        editor.grabHorizontal = true;
        editor.minimumWidth = 50;

        // editing the fourth column
        final int editable = 4;

        providers.addSelectionListener(new SelectionListener() {
        
            @Override
            public void widgetSelected(SelectionEvent exc) {

                TableItem item = (TableItem) exc.item;

                //Column should only be editable if arguments are allowed for the provider.
                if (item.getText(3).toString().equals("false") || item == null) {
                    return;
                }

                Control oldEditor = editor.getEditor();

                if (oldEditor != null) {
                    oldEditor.dispose();
                }

                        
                Text newEditor = new Text(providers, SWT.NONE);
                newEditor.setText(item.getText(editable));
                newEditor.addModifyListener(new ModifyListener() {

                
                    @Override
                    public void modifyText(ModifyEvent exc) {
                        Text text = (Text) editor.getEditor();
                        editor.getItem().setText(editable, text.getText());
                    }
                });
      
                newEditor.selectAll();
                newEditor.setFocus();
                editor.setEditor(newEditor, item, editable);                  
            }

            @Override
            public void widgetDefaultSelected(SelectionEvent exc) {
                // TODO Auto-generated method stub
            }
        });
       
        for (int i = 0; i < TITLES.length; i++) {
            providers.getColumn(i).pack();
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

    @Override
    public void init(IWorkbench workbench) {
        // TODO Auto-generated method stub
    }

    @Override
    public void handleEvent(Event event) {
        // TODO Auto-generated m
    }
    
}
