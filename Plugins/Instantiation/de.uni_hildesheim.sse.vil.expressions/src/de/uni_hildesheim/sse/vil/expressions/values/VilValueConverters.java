package de.uni_hildesheim.sse.vil.expressions.values;

import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.impl.AbstractDeclarativeValueConverterService;
import org.eclipse.xtext.conversion.impl.AbstractIDValueConverter;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import de.uni_hildesheim.sse.dslCore.values.IdentifierValueConverter;
import de.uni_hildesheim.sse.dslCore.values.StringValueConverter;
import de.uni_hildesheim.sse.dslCore.values.VersionValueConverter;

/**
 * Factory for the value converters. Typically, one would also
 * define a converter for the STRING terminal, but due to the content
 * nature of the VIL template language, we process this manually.
 * 
 * @author Holger Eichelberger
 */
@Singleton
public class VilValueConverters extends
        AbstractDeclarativeValueConverterService {

    @Inject
    private AbstractIDValueConverter idValueConverter;

    @Inject
    private StringValueConverter textValueConverter;
    
    @Inject
    private VersionValueConverter versionValueConverter;
    
    @Inject
    private IdentifierValueConverter identifierValueConverter;

    // checkstyle: stop method name check
    
    // do not change the method names in here - dynamic dispatch
    // due to terminal names in the grammar
    
    /**
     * Returns the value converter for IDs.
     * 
     * @return the value converter for IDs.
     */
    @ValueConverter(rule = "ID")
    public IValueConverter<String> ID() {
        return idValueConverter;
    }

    /**
     * Returns the value converter for numbers.
     * 
     * @return the value converter for numbers.
     */
    @ValueConverter(rule = "NUMBER")
    public IValueConverter<String> NUMBER() {
        return textValueConverter;
    }
    
    /**
     * Returns the value converter for version numbers.
     * 
     * @return the value converter for version numbers.
     */
    @ValueConverter(rule = "VERSION")
    public IValueConverter<String> VERSION() {
        return versionValueConverter;
    }

    /**
     * Returns the value converter for identifiers.
     * 
     * @return the value converter for identifiers.
     */
    @ValueConverter(rule = "Identifier")
    public IValueConverter<String> Identifier() {
        return identifierValueConverter;
    }

    // checkstyle: resume method name check
}
