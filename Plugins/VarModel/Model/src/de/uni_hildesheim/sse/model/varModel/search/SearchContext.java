package de.uni_hildesheim.sse.model.varModel.search;

/**
 * Defines some search contexts, i.e. to hint the search whether local variables
 * shall be included.
 * 
 * @author Holger Eichelberger
 */
public enum SearchContext {

    /**
     * Include all element types.
     */
    ALL("uvoqOcel"),

    /**
     * Search for only, i.e. unqualified names.
     */
    ID("uvo"),

    /**
     * Search for qualified names.
     */
    QUALIFIED_NAME("qvo"),
    
    /**
     * Search on project level.
     */
    PROJECT("uqo"),

    /**
     * Search within compound level.
     */
    COMPOUND("uqo"),

    /**
     * Search within a constraint.
     */
    CONSTRAINT("uqvoc"),

    /**
     * Search within an operation definition.
     */
    OPERATION_DEFINITION("uqoO"),

    /**
     * Search within a freeze.
     */
    FREEZE("uq"),

    /**
     * Search within an eval.
     */
    EVAL("uqec"), 

    /**
     * Search within a let expression.
     */
    LET("uqvol");
    
    private boolean includeQualifiedNames;
    private boolean includeUnqualifiedNames;
    private boolean includeVariableDeclarations;
    private boolean includeOperations;
    private boolean includeOperationDefinitions;
    private boolean includeConstraints;
    private boolean includeEvals;
    private boolean includeLets;
    
    /**
     * Creates a new search context. We use a string here as parameter as
     * we otherwise would have more than 5 parameters in total.
     * 
     * @param spec the specification of included elements, "q" stands for
     *   qualified names, "u" stands for unqualified names, "v" for variable
     *   declarations, "o" for operations, "O" for operation definitions, "c" for
     *   constraints, "e" for evals, "l" for lets
     */
    private SearchContext(String spec) {
        for (int i = spec.length() - 1; i >= 0; i--) {
            switch (spec.charAt(i)) {
            case 'q':
                includeQualifiedNames = true;
                break;
            case 'u':
                includeUnqualifiedNames = true;
                break;
            case 'v':
                includeVariableDeclarations = true;
                break;
            case 'o':
                includeOperations = true;
                break;
            case 'O':
                includeOperationDefinitions = true;
                break;
            case 'c':
                includeConstraints = true;
                break;
            case 'e':
                includeEvals = true;
                break;
            case 'l':
                includeLets = true;
                break;
            default:
                break;
            }
        }
    }
    
    /**
     * Returns whether qualified names shall be included.
     * 
     * @return <code>true</code> if they shall be included, <code>false</code> else
     */
    public boolean includeQualifiedNames() {
        return includeQualifiedNames;
    }

    /**
     * Returns whether unqualified names shall be included.
     * 
     * @return <code>true</code> if they shall be included, <code>false</code> else
     */
    public boolean includeUnqualifiedNames() {
        return includeUnqualifiedNames;
    }

    /**
     * Returns whether variable declarations shall be included per se.
     * 
     * @return <code>true</code> if they shall be included, <code>false</code> else
     */
    public boolean includeVariableDeclarations() {
        return includeVariableDeclarations;
    }

    /**
     * Returns whether available operations shall be included.
     * 
     * @return <code>true</code> if they shall be included, <code>false</code> else
     */
    public boolean includeOperations() {
        return includeOperations;
    }

    /**
     * Returns whether operation definitions shall be included.
     * 
     * @return <code>true</code> if they shall be included, <code>false</code> else
     */
    public boolean includeOperationDefinitions() {
        return includeOperationDefinitions;
    }

    /**
     * Returns whether constraints shall be included.
     * 
     * @return <code>true</code> if they shall be included, <code>false</code> else
     */
    public boolean includeConstraints() {
        return includeConstraints;
    }

    /**
     * Returns whether evals shall be included.
     * 
     * @return <code>true</code> if they shall be included, <code>false</code> else
     */
    public boolean includeEvals() {
        return includeEvals;
    }

    /**
     * Returns whether lets shall be included.
     * 
     * @return <code>true</code> if they shall be included, <code>false</code> else
     */
    public boolean includeLets() {
        return includeLets;
    }
    
}
