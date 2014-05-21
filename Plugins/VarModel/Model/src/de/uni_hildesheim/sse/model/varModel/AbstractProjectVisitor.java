package de.uni_hildesheim.sse.model.varModel;

import de.uni_hildesheim.sse.model.varModel.filter.FilterType;

/**
 * Abstract super class for visiting projects.
 * This visitor can be controlled to specify whether project imports shall be visited or not.
 * @author El-Sharkawy
 *
 */
public abstract class AbstractProjectVisitor implements IModelVisitor {
    /**
     * The project where the visiting has been started.
     */
    private Project originProject;
    
    /**
     * Specifies whether project imports shall be considered or not.
     */
    private FilterType filterType;
    
    /**
     * Sole constructor for this visitor.
     * This constructor does not start the visiting process, the {@link Project#accept(IModelVisitor)} should be called
     * inside the constructor of the inherited visitors.
     * @param originProject The project where the visiting shall start
     * @param filterType Specifies whether project imports shall be considered or not.
     */
    protected AbstractProjectVisitor(Project originProject, FilterType filterType) {
        this.originProject = originProject;
        this.filterType = filterType;
    }

    /**
     * {@inheritDoc}
     */
    public void visitProjectImport(ProjectImport pImport) {
        if (null != pImport.getResolved()) {
            pImport.getResolved().accept(this);
        }
    }
    
    /**
     * {@inheritDoc}
     */
    public void visitProject(Project project) {
        boolean importedProject = originProject != project;
        
        // Visit imports.
        if (FilterType.ALL == filterType || FilterType.ONLY_IMPORTS == filterType) {
            for (int i = 0; i < project.getImportsCount(); i++) {
                project.getImport(i).accept(this);
            }
        }
        
        // Visit current project.
        boolean anyProject = FilterType.ALL == filterType;
        boolean onlyImports = FilterType.ONLY_IMPORTS == filterType && importedProject;
        boolean noImports = FilterType.NO_IMPORTS == filterType && !importedProject;
        if (anyProject || onlyImports || noImports) {
            for (int i = 0; i < project.getElementCount(); i++) {
                project.getElement(i).accept(this);
            }
        }
    }
}
