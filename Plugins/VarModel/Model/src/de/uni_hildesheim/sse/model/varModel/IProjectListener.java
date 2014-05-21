package de.uni_hildesheim.sse.model.varModel;

import de.uni_hildesheim.sse.utils.modelManagement.IModelListener;

/**
 * Defines a project listener in order to inform interested parties about
 * changes within a project instance. Currently, this class does only notify
 * about the internal replacement of an entire project instance as the editor
 * does not support incremental model updates. [retyping for convenience]
 * 
 * @author Holger Eichelberger
 */
public interface IProjectListener extends IModelListener<Project> {
    
}
