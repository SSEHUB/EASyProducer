package de.uni_hildesheim.sse.dslCore.values;

import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.AbstractLexerBasedConverter;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.util.Strings;

/**
 * Converts strings recognized by the grammar to float values.
 * 
 * @author Holger Eichelberger
 */
public class FloatValueConverter extends AbstractLexerBasedConverter<Double> {

    /**
     * Creates a float value converter.
     */
    public FloatValueConverter() {
        super();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String toEscapedString(Double value) {
        return value.toString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void assertValidValue(Double value) {
        super.assertValidValue(value);
        if (value < 0) {
            throw new ValueConverterException(getRuleName()
                    + "-value may not be negative (value:" + value + ").",
                    null, null);
        }
    }

    /**
     * Returns a double value for the given <code>string</code> stored 
     * in <code>node</code>.
     * 
     * @param string the version string to be converted
     * @param node the node holding the string
     * @return the converted double value
     * @throws ValueConverterException in case of conversion problems
     */    
    public Double toValue(String string, INode node) {
        if (Strings.isEmpty(string)) {
            throw new ValueConverterException(
                    "Couldn't convert empty string to double.", node, null);
        }
        try {
            return Double.valueOf(string);
        } catch (NumberFormatException e) {
            throw new ValueConverterException("Couldn't convert '" + string
                    + "' to double.", node, e);
        }
    }

}
