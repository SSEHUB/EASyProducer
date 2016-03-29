package net.ssehub.easy.dslCore.values;

import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.AbstractLexerBasedConverter;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.util.Strings;

/**
 * Converts a string recognized by the grammar to an integer.
 * 
 * @author Holger Eichelberger
 */
public class IntValueConverter extends AbstractLexerBasedConverter<Integer> {

    /**
     * Creates the value converter instance.
     */
    public IntValueConverter() {
        super();
    }

    @Override
    protected String toEscapedString(Integer value) {
        return value.toString();
    }

    @Override
    protected void assertValidValue(Integer value) {
        super.assertValidValue(value);
    }

    /**
     * Returns an integer value for the given <code>string</code> stored 
     * in <code>node</code>.
     * 
     * @param string the version string to be converted
     * @param node the node holding the string
     * @return the converted integer value
     * @throws ValueConverterException in case of conversion problems
     */    
    public Integer toValue(String string, INode node) {
        if (Strings.isEmpty(string)) {
            throw new ValueConverterException(
                    "Couldn't convert empty string to int.", node, null);
        } 
        try {
            int intValue = Integer.parseInt(string, 10);
            return Integer.valueOf(intValue);
        } catch (NumberFormatException e) {
            throw new ValueConverterException("Couldn't convert '" + string
                    + "' to int.", node, e);
        }
    }

}
