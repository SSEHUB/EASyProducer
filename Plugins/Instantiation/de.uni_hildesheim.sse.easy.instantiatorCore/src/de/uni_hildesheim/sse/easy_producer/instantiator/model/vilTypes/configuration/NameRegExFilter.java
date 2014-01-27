package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArtifactException;

/**
 * A name filter based on regular expressions (Perl-Style).
 * 
 * @author Holger Eichelberger
 */
public class NameRegExFilter implements IConfigurationFilter {

    /**
     * Defines the data type to filter on.
     * 
     * @author Holger Eichelberger
     */
    public enum DataType {

        /**
         * Filter according to element names.
         */
        NAME,

        /**
         * Filter according to types.
         */
        TYPE,

        /**
         * Filter according to attributes.
         */
        ATTRIBUTE;

    }

    private DataType type;
    private IConfigurationFilter further;
    private Pattern pattern;

    /**
     * Creates a filter.
     * 
     * @param pattern the (valid) pattern
     * @param type the data type to filter on
     * @throws ArtifactException in case that the pattern is illformed
     */
    public NameRegExFilter(String pattern, DataType type) throws ArtifactException {
        this(pattern, type, null);
    }
    
    /**
     * Creates a filter.
     * 
     * @param pattern the (valid) pattern
     * @param type the data type to filter on
     * @param further an (optional) filter to be considered (may be <b>null</b>)
     * @throws ArtifactException in case that the pattern is illformed
     */
    public NameRegExFilter(String pattern, DataType type, IConfigurationFilter further) 
        throws ArtifactException {
        this.type = type;
        this.further = further;
        try {
            this.pattern = Pattern.compile(pattern);
        } catch (PatternSyntaxException e) {
            throw new ArtifactException(e.getMessage(), ArtifactException.ID_INVALID_PATTERN);
        }
    }

    /**
     * Determines a string match.
     * 
     * @param string the string to match
     * @return <code>true</code> if <code>string</code> matches pattern, <code>false</code> else
     */
    private boolean match(String string) {
        return pattern.matcher(string).matches();
    }

    @Override
    public boolean include(IvmlElement element) {
        return include(element, type);
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

    /**
     * Implements the inclusion function for a given data <code>type</code>.
     * 
     * @param element the element to be tested
     * @param type the type of data to be considered
     * @return <code>true</code> if <code>element</code> shall be included, <code>false</code> else
     */
    private boolean include(IvmlElement element, DataType type) {
        boolean result;
        switch (type) {
        case NAME:
            result = checkFurther(element, match(element.getName()) || match(element.getQualifiedName()));
            break;
        case TYPE:
            result = checkFurther(element, match(element.getType()) || match(element.getQualifiedType()));
            break;
        case ATTRIBUTE:
            result = false;
            int count = element.getAttributeCount();
            for (int a = 0; !result && a < count; a++) {
                // includes checking further due to 1-recursion
                result = include(element.getAttribute(a), DataType.NAME);
            }
            break;
        default:
            result = false;
            break;
        }
        return result;
    }

}
