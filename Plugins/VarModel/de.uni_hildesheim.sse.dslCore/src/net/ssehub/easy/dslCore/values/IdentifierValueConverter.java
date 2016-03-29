package net.ssehub.easy.dslCore.values;

import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.AbstractLexerBasedConverter;
import org.eclipse.xtext.nodemodel.INode;

/**
 * Converts version numbers by removing the leading "v".
 * 
 * @author Holger Eichelberger
 */
public class IdentifierValueConverter extends AbstractLexerBasedConverter<String> {

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
        } else {
            boolean found = false;
            int size = string.length();
            for (int i = 0; !found && i < size; i++) {
                char c = string.charAt(i);
                found = ('.' == c // from version terminal
                    || '+' == c || '-' == c); // from exponent terminal
            }
            if (found) {
                throw new ValueConverterException("An identifier must not contain a '.'", node, null);
            } else {
                result = string;
            }
        }
        return result;
    }

}
