package de.uni_hildesheim.sse.dslCore.values;

import org.eclipse.xtext.conversion.impl.AbstractLexerBasedConverter;
import org.eclipse.xtext.nodemodel.INode;

/**
 * Converts strings recognized by the grammar to float values.
 * 
 * @author Holger Eichelberger
 */
public class StringValueConverter extends AbstractLexerBasedConverter<String> {

    /**
     * Creates a float value converter.
     */
    public StringValueConverter() {
        super();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String toEscapedString(String value) {
        return value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void assertValidValue(String value) {
        super.assertValidValue(value);
    }

    /**
     * Returns a double value for the given <code>string</code> stored 
     * in <code>node</code>.
     * 
     * @param string the version string to be converted
     * @param node the node holding the string
     * @return the converted double value
     */    
    public String toValue(String string, INode node) {
        return string;
    }

}
