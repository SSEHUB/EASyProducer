package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes;

import java.io.File;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Script;
import de.uni_hildesheim.sse.utils.progress.ProgressObserver;

/**
 * Describes a {@link Project} for creation of a project object. This interface helps
 * separating VIL from upper level parts of EASy.
 * 
 * @author Holger Eichelberger
 */
public interface IProjectDescriptor {

    /**
     * Defines different model kinds.
     * 
     * @author Holger Eichelberger
     */
    public enum ModelKind {
        
        /**
         * IVML models.
         */
        IVML,

        /**
         * VIL models.
         */
        VIL,

        /**
         * VTL models.
         */
        VTL;
    }
    
    /**
     * The base folder of the project (typically the project location).
     * 
     * @return the base folder
     */
    public File getBase();
    
    /**
     * The number of predecessor projects.
     * 
     * @return the number of predecessor projects
     */
    public int getPredecessorCount();
    
    /**
     * Returns a specific predecessor descriptor.
     * 
     * @param index the index of the predecessor to be returned
     * @return the predecessor
     * @throws IndexOutOfBoundsException in case that 
     *   <code>index &lt; 0 || index &gt;= {@link #getPredecessorCount()}</code>
     */
    public IProjectDescriptor getPredecessor(int index);

    /**
     * Returns the main VIL script of the project.
     * 
     * @return the main VIL script
     */
    public Script getMainVilScript();
    
    /**
     * Creates a progress observer on demand, e.g., when predecessors are accessed the
     * first time. [factory method]
     * 
     * @return the progress observer to be used
     */
    public ProgressObserver createObserver();
    
    /**
     * Returns the path to the respective models relative to {@link #getBase()}.
     * 
     * @param kind the model kind to return the folder for
     * @return the relative path to the model folder
     */
    public String getModelFolder(ModelKind kind);

}
