package de.uni_hildesheim.sse.easy.loader.framework;

import java.io.File;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * Implements a simple name filter filtering both, JAR name and symbolic name for the given regular expression.
 * 
 * @author Holger Eichelberger
 */
public class SimpleNameFilter implements IBundleFilter {

    private Pattern pattern;

    /**
     * Creates a simple name filter from the given Java regular expression.
     * 
     * @param regEx the regular expression to be considered
     * @throws PatternSyntaxException in case that the pattern syntax is wrong
     */
    public SimpleNameFilter(String regEx) throws PatternSyntaxException {
        pattern = Pattern.compile(regEx);
    }
    
    /**
     * Returns the match pattern.
     * 
     * @return the match pattern
     */
    protected Pattern getPattern() {
        return pattern;
    }
    
    @Override
    public boolean acceptJar(File jar) {
        return pattern.matcher(jar.getName()).matches();
    }

    @Override
    public boolean acceptSymbolicName(String name) {
        return pattern.matcher(name).matches();
    }

}
