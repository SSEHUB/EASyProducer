package de.uni_hildesheim.sse.model.varModel.filter;

/**
 * This enumeration if for the constructors of this package to denote
 * whether imports should be considered during filtering the current project.
 * @author El-Sharkawy
 *
 */
public enum FilterType {
    /**
     * Current project and all imported projects will be filtered.
     */
    ALL,
    /**
     * Only the current project without imports will be filtered.
     */
    NO_IMPORTS,
    
    /**
     * Only the imported projects without the current project will be considered.
     */
    ONLY_IMPORTS;

}
