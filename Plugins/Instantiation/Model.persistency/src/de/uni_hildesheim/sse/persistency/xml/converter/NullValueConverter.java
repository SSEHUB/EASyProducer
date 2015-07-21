package de.uni_hildesheim.sse.persistency.xml.converter;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import de.uni_hildesheim.sse.model.varModel.values.NullValue;

/**
 * A type converter for delegating types. Background: In the IVML object model, 
 * delegating types are used to resolve class dependencies while defining IVML operations
 * as constants. These delegating types are singleton instances and if serialized
 * to an XML file, the type identity of the object constants defined in the IVML 
 * object model are not unique anymore. In this class, map the delegating type to a 
 * unique name and back to the actual singleton instance.
 * 
 * @author Aike Sass
 */
public class NullValueConverter implements Converter {
    
    /**
     * Creates a singleton type converter.
     */
    public NullValueConverter() {
    }

    /**
     * Determines whether this converter instance handles the given class.
     *
     * @param cls the class to be tested
     * @return <code>true</code> if this instance handles <code>class</code> (this 
     *   is only the case if it is a NullValue class), <code>false</code> else 
     */
    @Override
    @SuppressWarnings("rawtypes")
    public boolean canConvert(Class cls) {
        return NullValue.class.isAssignableFrom(cls);
    }

    /**
     * Marshals a given <code>object</code> to the given <code>writer</code> in the 
     * specified marshaling <code>context</code>. This method translates a NullValue
     * type singleton to a name.
     * 
     * @param object the object to be marshaled
     * @param writer the output stream writer
     * @param context the marshaling context
     */
    @Override
    public void marshal(Object object, HierarchicalStreamWriter writer, MarshallingContext context) {
        writer.setValue("null");
    }

    /**
     * Unmarshals the current object to be read from the given <code>reader</code> in the 
     * specified unmarshaling <code>context</code>. This method translates the name
     * back to the singleton instance.
     * 
     * @param reader the input stream writer
     * @param context the marshaling context
     * @return the unmarshaled object
     */
    @Override
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
        Object result = null;
        result = NullValue.INSTANCE;
        return result;
    }
}