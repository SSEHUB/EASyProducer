import java.io.File;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import de.uni_hildesheim.sse.ModelUtility;
import de.uni_hildesheim.sse.easy.loader.ListLoader;
import net.ssehub.easy.basics.modelManagement.ModelInfo;
import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.basics.modelManagement.VersionFormatException;
import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.dslCore.StandaloneInitializer;
import net.ssehub.easy.reasoning.core.frontend.ReasonerFrontend;
import net.ssehub.easy.reasoning.core.reasoner.ReasoningResult;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.management.VarModel;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.persistency.StringProvider;

/**
 * Small running example of an IVML stand alone application.
 * @author El-Sharkawy
 *
 */
public class Fenster extends JFrame {
    
    /**
     * To avoid annoying warning. ;-)
     */
    private static final long serialVersionUID = 5669828980662272453L;

    static {
        konfiguriereParser();
    }

    private Fenster() {
        super("IVML Loader");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JLabel lbl = new JLabel("Kein Projekt geladen");
        File ivmlFile = showDialog();
        if (null != ivmlFile) {
            Project project = loadProject(ivmlFile);
            if (null != project) {
                Configuration cfg = new Configuration(project);
                ReasonerFrontend rf = ReasonerFrontend.getInstance();
                rf.setPreferredReasoner();
                ReasoningResult result = rf.check(project, cfg, null, ProgressObserver.NO_OBSERVER);
                String conflictMsg = result.hasConflict() ? " (contains errors)" : " (conflict free)";
                lbl.setText("Projekt geladen: " + project.getName() + conflictMsg);
                DefaultListModel<String> model = new DefaultListModel<String>();
                JList<String> liste = new JList<String>(model);
                for (int i = 0; i < project.getElementCount(); i++) {
                    model.addElement(StringProvider.toIvmlString(project.getElement(i)));
                }
                getContentPane().add(new JScrollPane(liste, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                    JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
                String titel = "IVML Loader: ";
                titel += project.getVersion() != null ?  project.getName() + " - " + project.getVersion().getVersion() : project.getName();
                setTitle(titel + conflictMsg);
            } else {
                getContentPane().add(lbl);
                setTitle("IVML Loader: No project loaded");
            }
        } else {
            getContentPane().add(lbl);
            setTitle("IVML Loader: No project loaded");
        }
        pack();
        setVisible(true);
    }
    
    private File showDialog() {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("IVML Files (*.ivml)", "ivml");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(this);
        File ivmlFile = null;
        if(returnVal == JFileChooser.APPROVE_OPTION) {
           ivmlFile = chooser.getSelectedFile();
        }
        
        return ivmlFile;
    }
    
    private Project loadProject(File ivmlFile) {
        Project ivmlProject = null;
        ModelInfo<Project> info = null;
        try {
            File directory = ivmlFile.getParentFile();
            String name = ivmlFile.getName();
            String version = ivmlFile.getName();
            int posUnderline = name.lastIndexOf('_');
            int posDot = version.lastIndexOf('.');
            if (posUnderline > 0) {
                name = name.substring(0, posUnderline);
                version = version.substring(posUnderline + 1, posDot);
            }
            System.out.println("Projektname: " + name);
            VarModel.INSTANCE.locations().addLocation(directory, ProgressObserver.NO_OBSERVER);
            info = VarModel.INSTANCE.availableModels().getModelInfo(name, version, ivmlFile.toURI());
        } catch (VersionFormatException e) {
            System.out.println(e.getMessage());
        } catch (ModelManagementException e) {
            System.out.println(e.getMessage());
        }
        if (null != info) {
            try {
                ivmlProject = VarModel.INSTANCE.load(info);
            } catch (ModelManagementException e) {
                System.out.println(e.getMessage());
            }
        }
        return ivmlProject;
    }
    
    private static void konfiguriereParser() {
        try {
            VarModel.INSTANCE.loaders().registerLoader(ModelUtility.INSTANCE, ProgressObserver.NO_OBSERVER);
            ModelUtility.setResourceInitializer(new StandaloneInitializer());
        } catch (ModelManagementException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        try {
            ListLoader loader = new ListLoader();
            loader.startup();
            new Fenster();
            loader.shutdown();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
