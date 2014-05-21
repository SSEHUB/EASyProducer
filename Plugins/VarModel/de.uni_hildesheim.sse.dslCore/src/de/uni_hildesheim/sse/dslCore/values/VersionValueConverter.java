package de.uni_hildesheim.sse.dslCore.values;

import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.AbstractLexerBasedConverter;
import org.eclipse.xtext.nodemodel.INode;

/**
 * Converts version numbers by removing the leading "v".
 * 
 * @author Holger Eichelberger
 */
public class VersionValueConverter extends AbstractLexerBasedConverter<String> {

    /**
     * {@inheritDoc}
     */
    @Override
    protected String toEscapedString(String value) {
        return value;
    }

    /**
     * Returns a value for the given version <code>string</code> stored 
     * in <code>node</code>.
     * 
     * @param string the version string to be converted
     * @param node the node holding the string
     * @return the converted string
     * @throws ValueConverterException in case of conversion problems
     */
    public String toValue(String string, INode node) {
        String result;
        if (string == null) {
            result = null; 
        } else if (string.length() < 2) {
            throw new ValueConverterException(
                "A version must contain at least 2 characters (v1)", node,
                null);
        } else {
            try {
                // cut the "v" at the beginning
                result = string.substring(1, string.length()).trim();
            } catch (IllegalArgumentException e) {
                throw new ValueConverterException(e.getMessage(), node, e);
            }
        }
        return result;
    }
}
