package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration;

import net.ssehub.easy.varModel.model.Project;

/**
 * A project-based filter, i.e., all {@link IvmlElement elements} contained in a project
 * shall be included by this filter.
 * 
 * @author Holger Eichelberger
 */
class ProjectFilter implements IConfigurationFilter {

    private Project project;
    private boolean considerImports;
    private IConfigurationFilter further;

    /**
     * Creates a filter.
     * 
     * @param project the project to filter for
     * @param considerImports the imports of <code>project</code>
     */
    public ProjectFilter(Project project, boolean considerImports) {
        this(project, considerImports, null);
    }
    
    /**
     * Creates a filter.
     * 
     * @param project the project to filter for (may be <b>null</b>, then the filter rejects all elements)
     * @param considerImports the imports of <code>project</code>
     * @param further an (optional) filter to be considered (may be <b>null</b>)
     */
    public ProjectFilter(Project project, boolean considerImports, IConfigurationFilter further) {
        this.further = further;
        this.project = project;
        this.considerImports = considerImports;
    }
    
    /**
     * Checks whether <code>element</code> shall be included due to its membership in <code>project</code>.
     * 
     * @param element the element to consider
     * @param project the project to ask for <code>element</code>
     * @return <code>true</code> if <code>element</code> shall be included, <code>false</code> else
     */
    private boolean include(IvmlElement element, Project project) {
        boolean result;
        if (null == project) {
            result = false;
        } else {
            result = project.containsByName(element.getQualifiedName());
            if (!result && considerImports) {
                for (int i = 0; !result && i < project.getImportsCount(); i++) {
                    result = include(element, project.getImport(i).getResolved());
                }
            }
        }
        return result;
    }
    
    @Override
    public boolean include(IvmlElement element) {
        return checkFurther(element, include(element, project));
    }
    
    /**
     * Checks whether {@link #further} applies.
     * 
     * @param element the element to be tested
     * @param result the result determined for including <code>element</code> so far
     * @return <code>true</code> if <code>element</code> shall be included, <code>false</code> else
     */
    private boolean checkFurther(IvmlElement element, boolean result) {
        if (result && null != further) {
            result = further.include(element);
        } 
        return result;
    }

}
