import java.io.File;

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import de.uni_hildesheim.sse.ModelUtility;
import de.uni_hildesheim.sse.StandaloneInitializer;
import de.uni_hildesheim.sse.model.confModel.Configuration;
import de.uni_hildesheim.sse.model.management.ProjectInfo;
import de.uni_hildesheim.sse.model.management.VarModel;
import de.uni_hildesheim.sse.model.management.VarModelException;
import de.uni_hildesheim.sse.model.varModel.ProgressObserver;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.StringFormatException;
import de.uni_hildesheim.sse.persistency.StringProvider;
import de.uni_hildesheim.sse.reasoning.core.reasoner.IReasoner;
import de.uni_hildesheim.sse.reasoning.core.reasoner.ReasoningResult;
import de.uni_hildesheim.sse.reasoning.drools.DroolsReasoner;


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
                IReasoner drools = new DroolsReasoner();
                ReasoningResult result = drools.check(project, cfg, null, ProgressObserver.NO_OBSERVER);
                String conflictMsg = result.hasConflict() ? " (contains errors)" : " (conflict free)";
                lbl.setText("Projekt geladen: " + project.getName() + conflictMsg);
                DefaultListModel model = new DefaultListModel();
                JList liste = new JList(model);
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
        ProjectInfo info = null;
        try {
            File directory = ivmlFile.getParentFile();
            String name = ivmlFile.getName();
            String version = ivmlFile.getName();
            int posUnderline = name.lastIndexOf('_');
            int posDot = version.lastIndexOf('.');
            name = name.substring(0, posUnderline);
            version = version.substring(posUnderline + 1, posDot);
            System.out.println("Projektname: " + name);
            VarModel.INSTANCE.locations().addLocation(directory, ProgressObserver.NO_OBSERVER);
            info = VarModel.INSTANCE.availableProjects().getProjectInfo(name, version, ivmlFile.toURI());
        } catch (StringFormatException e) {
            //
        } catch (VarModelException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (null != info) {
            try {
                ivmlProject = VarModel.INSTANCE.load(info);
            } catch (VarModelException e) {
                //
            }
        }
        return ivmlProject;
    }
    
    private static void konfiguriereParser() {
        try {
            VarModel.INSTANCE.loaders().registerLoader(ModelUtility.INSTANCE, ProgressObserver.NO_OBSERVER);
            ModelUtility.setResourceInitializer(new StandaloneInitializer());
        } catch (VarModelException e) {
            // No other way to handle it here
            e.printStackTrace();
        }
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        new Fenster();
    }

}
