package net.ssehub.easy.producer.core.persistence;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.persistency.IVMLWriter;

/**
 * Extended {@link IVMLWriter}, which writes {@link Project}s and their imported {@link Project}s to a given location.
 * @author El-Sharkawy
 *
 */
public class IVMLFileWriter {
    
    private Set<Project> done;
    private final File folder;
    private boolean formatInitializer;
    private boolean forceCompoundTypes;

    /**
     * sole constructor for this class.
     * @param folder The folder where all projects shall be saved to.
     * @throws IOException If the given specified folder is not a folder or does not exist.
     */
    public IVMLFileWriter(File folder) throws IOException {
        this.folder = folder;
        if (!folder.exists() || !folder.isDirectory()) {
            throw new IOException("The specified location \"" + folder.getAbsolutePath()
              + "\" is not an existing folder.");
        }
        done = new HashSet<Project>();
    }
    
    /**
     * Defines whether initializers shall be formatted.
     * 
     * @param formatInitializer <code>true</code> if initializers shall be formatted, 
     *   <code>false</code> else
     */
    public void setFormatInitializer(boolean formatInitializer) {
        this.formatInitializer = formatInitializer;
    }
    
    /**
     * Forces the output of compound types and bypasses the automatic
     * detection.
     * 
     * @param forceCompoundTypes if <code>true</code>, compound types are
     *   always emitted at creation, <code>false</code> else
     */
    public void forceComponundTypes(boolean forceCompoundTypes) {
        this.forceCompoundTypes = forceCompoundTypes;
    }
    
    /**
     * Saves the given project and all of its imports.
     * @param mainProject The starting project to save.
     * @throws IOException If an IO error occurs during saving one of the projects. 
     */
    public void save(Project mainProject) throws IOException {
        done.clear();
        write(mainProject);
    }
    
    /**
     * Recursive method to save all rpoejcts and their imports.
     * @param project The current project so save
     * @throws IOException If an IO error occurs during saving one of the projects. 
     */
    private void write(Project project) throws IOException {
        if (!done.contains(project)) {
            done.add(project);
            
            // Save project
            FileWriter fWriter = null;
            try {
                File trgFile = new File(folder, project.getName() + ".ivml");
                fWriter = new FileWriter(trgFile);
                IVMLWriter iWriter = new IVMLWriter(fWriter);
                iWriter.setFormatInitializer(formatInitializer);
                iWriter.forceComponundTypes(forceCompoundTypes);
                project.accept(iWriter);
                iWriter.flush();
            } finally {
                if (null != fWriter) {
                    fWriter.close();
                }
            }
            
            // Save imported projects
            for (int i = 0, end = project.getImportsCount(); i < end; i++) {
                Project importedProject = project.getImport(i).getResolved();
                if (null != importedProject) {
                    write(importedProject);
                }
            }
        }
    }
}
