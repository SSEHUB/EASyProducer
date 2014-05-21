package de.uni_hildesheim.sse.model.varModel.search;


/**
 * Describes a search result. Note that each model element may be included multiple
 * times in a search result, e.g. via its simple and its qualified name.
 * 
 * @author Holger Eichelberger
 */
public class SearchResult {

    /**
     * The matched name.
     */
    private String matchedName;
    
    /**
     * The related element. This is of type object as {@link de.uni_hildesheim.sse.model.varModel.ModelElement} is too 
     * restrictive, e.g. for project imports.
     */
    private Object element; // might also be just a Class<?>
    
    /**
     * Creates a search result.
     * 
     * @param matchedName the matched name
     * @param element the related element
     */
    SearchResult(String matchedName, Object element) {
        this.matchedName = matchedName;
        this.element = element;
    }
    
    /**
     * Returns the matched name.
     * 
     * @return the matched name
     */
    public String getMatchedName() {
        return matchedName;
    }
    
    /**
     * Returns the related (model) element.
     * 
     * @return the related element
     */
    public Object getElement() {
        return element;
    }
    
}

