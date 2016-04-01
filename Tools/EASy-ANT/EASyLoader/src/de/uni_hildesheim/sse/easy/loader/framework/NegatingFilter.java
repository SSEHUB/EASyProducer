package de.uni_hildesheim.sse.easy.loader.framework;

import java.io.File;

/**
 * Implements a negating delegating filter, i.e., a filter which obtains
 * the initial results from a delegate filter and negates the return values.
 * 
 * @author Holger Eichelberger
 */
public class NegatingFilter implements IBundleFilter {

    private IBundleFilter filter;
    
    /**
     * Creates a negating delegating filter.
     * 
     * @param filter the filter to obtain the results from
     */
    public NegatingFilter(IBundleFilter filter) {
        this.filter = filter;
    }
    
    @Override
    public boolean acceptJar(File jar) {
        return !filter.acceptJar(jar);
    }

    @Override
    public boolean acceptSymbolicName(String name) {
        return !filter.acceptSymbolicName(name);
    }

}
