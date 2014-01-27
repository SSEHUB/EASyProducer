package de.uni_hildesheim.sse.easy.ui.productline_editor;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Shell;

/**
 * This class represents the transformator progress dialog.
 * 
 * @author freitag
 * @author El-Sharkawy
 */
public class TransformatorProgressDialog extends Dialog {

    private int currentCount;
    private ProgressBar bar;
    private Label barLabel;
    private Label percentLabel;
    private Shell shell;

    /**
     * TransformatorProgressDialog constructor.
     * 
     * @param parent the parent
     */
    public TransformatorProgressDialog(Shell parent) {
        // Pass the default styles here
        super(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
    }

    /**
     * Updates the progress bar.
     * 
     * @param numberOfFiles The number of currently processed files (not accumulated).
     */
    public void incrementProgress(final int numberOfFiles) {
        if (!shell.isDisposed() && !getParent().isDisposed()) {
            getParent().getDisplay().syncExec(new Runnable() {
                
                @Override
                public void run() {
                    currentCount += numberOfFiles;
                    bar.setSelection(currentCount);
                    int percent = (int) ((1.0 * currentCount) / (1.0 * bar.getMaximum()) * 100);
                    percentLabel.setText(percent + "%");
                    TransformatorProgressDialog.this.shell.update();
                }
                
            });
        }
    }

    /**
     * Sets the number of files for display purposes.
     * 
     * @param numberOfFiles number of files to display
     */
    public void setNumberOfFiles(final int numberOfFiles) {
        if (!getParent().isDisposed()) {
            getParent().getDisplay().syncExec(new Runnable() {
                
                @Override
                public void run() {
                    bar.setMaximum(numberOfFiles);
                }
                
            });
        }
    }

    /**
     * Opens the dialog.
     * 
     */
    public void open() {
        currentCount = 0;
        shell = new Shell(getParent(), SWT.TITLE);
        shell.setText("Transformation progress");
        shell.setSize(220, 80);
        createContents(shell);
        Monitor ma = getParent().getDisplay().getPrimaryMonitor();
        shell.setLocation((ma.getClientArea().width - 220) / 2, (ma.getClientArea().height - 80) / 2);
        shell.open();

    }

    /**
     * Creates the dialog's contents.
     * 
     * @param shell the dialog window
     */
    private void createContents(final Shell shell) {
        shell.setLayout(new GridLayout(2, true));

        // Show the message
        barLabel = new Label(shell, SWT.NONE);
        barLabel.setText("Instantiating...");
        GridData data = new GridData();
        data.widthHint = 300;
        barLabel.setLayoutData(data);

        Composite progressComposite = new Composite(shell, SWT.NONE);
        GridLayout layout = new GridLayout();
        layout.numColumns = 2;
        progressComposite.setLayout(layout);

        bar = new ProgressBar(progressComposite, SWT.SMOOTH);
        bar.setBounds(10, 10, 250, 32);
        bar.setSelection(0);

        // Show the message
        percentLabel = new Label(progressComposite, SWT.NONE);
        percentLabel.setText(bar.getSelection() + " %");
        GridData data2 = new GridData();
        data2.widthHint = 80;
        data.horizontalSpan = 2;
        percentLabel.setLayoutData(data2);

    }

    /**
     * Closes the dialog.
     */
    public void close() {
        getParent().getDisplay().syncExec(new Runnable() {
            
            @Override
            public void run() {
                shell.close();              
            }
            
        });
    }
}