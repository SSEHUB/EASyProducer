package de.uni_hildesheim.sse.easy.ui.productline_editor.project_configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import de.uni_hildesheim.sse.easy.ui.internal.Activator;
import de.uni_hildesheim.sse.easy.ui.productline_editor.AbstractEASyEditorPage;
import de.uni_hildesheim.sse.easy.ui.productline_editor.EasyProducerDialog;
import de.uni_hildesheim.sse.easy_producer.model.ProductLineProject;
import de.uni_hildesheim.sse.easy_producer.persistence.PersistenceException;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory.EASyLogger;
import de.uni_hildesheim.sse.utils.modelManagement.ModelInfo;
import de.uni_hildesheim.sse.utils.modelManagement.Version;
import de.uni_hildesheim.sse.utils.modelManagement.VersionFormatException;

/**
 * Combobox for selecting the model to use.
 * @author pastusch
 * Code chunks taken from CopyCombobox (by El-Sharkawy)
 *
 */
public class ModelCombobox implements SelectionListener {
    
    private static final EASyLogger LOGGER = EASyLoggerFactory.INSTANCE.getLogger(
        ProductLineProject.class, Activator.PLUGIN_ID); 
    
    private ProductLineProject plp;
    private Combo modelMenu;
    private AbstractEASyEditorPage parentPage;
    private Map<String, ModelInfo<Project>> items;
    private Button button;
    
    /**
     * Constructor.
     * @param parent The parent composite to hold this combobox.
     * @param plp The project (and its models) this combobox represents.
     * @param parentPage The parent page which will react on changes of this Combobox.
     */
    public ModelCombobox(Composite parent, ProductLineProject plp, AbstractEASyEditorPage parentPage) {

        this.plp = plp;
        this.parentPage = parentPage;
        
        Label modelLabel = new Label(parent, SWT.LEFT);
        modelLabel.setText("Choose model:");
        
        modelMenu = new Combo(parent, SWT.None | SWT.DROP_DOWN);
        modelMenu.addSelectionListener(this);
        
        button = new Button(parent, SWT.PUSH);
        button.setText("Create New Model");
        button.setToolTipText("Creates a new model for this project");
        button.addSelectionListener(this);
        
        items = new HashMap<String, ModelInfo<Project>>();
        refresh();
        
    }

    /**
     * Refreshes the list of all available models shown in the Combo Menu.
     * Also refreshes the HashMap.
     */
    public void refresh() {
 
        modelMenu.removeAll();
        items.clear();
        
        List<ModelInfo<Project>> infos = plp.listAvailableModels();
        
        //Add all models to the dropdown menu and the hashmap.
        for (ModelInfo<Project> projectInfo : infos) {            
            String name = projectInfo.getName() + " v" + projectInfo.getVersion();
            modelMenu.add(name);
            items.put(name, projectInfo);
            Version infoVersion = projectInfo.getVersion();
            Version plpVersion = plp.getProject().getVersion();
            if (null != infoVersion && null != plpVersion && infoVersion.toString().equals(plpVersion.toString())) {
                modelMenu.select(modelMenu.getItemCount() - 1);
            }   
        }
         
    }
    
    /**
     * Returns the selected model version.
     * @return The currently selected version (as String)
     */
    public ModelInfo<Project> getSelected() {
        ModelInfo<Project> selected = null;
        if (-1 != modelMenu.getSelectionIndex()) {
            String name = modelMenu.getItem(modelMenu.getSelectionIndex());
            selected = items.get(name);
        }
        
        return selected;
    }
    
    @Override
    public void widgetSelected(SelectionEvent evt) {

        if (evt.getSource() == modelMenu) {
            plp.setMainModel(this.getSelected());
            this.parentPage.setDirty();    
        } else {
            try {
                this.refresh();
                Version highest = plp.getHighestVersion();
                if (null != highest) {
                    highest = highest.getIncrementedVersion();
                } else {
                    highest = new Version(0);
                }
                plp.createNewModel(highest);
                this.refresh();
            } catch (VersionFormatException exc) {
                LOGGER.exception(exc);
            } catch (PersistenceException exc) {
                LOGGER.exception(exc);
                EasyProducerDialog.showErrorDialog("New IVML file could not be created:\n" + exc.getLocalizedMessage());
            }
        }
        
    }

    @Override
    public void widgetDefaultSelected(SelectionEvent evt) {
        // not needed.
        
    }

}
