package de.uni_hildesheim.sse.persistency.xml;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.TypeMapper;

/**
 * A type converter for delegating types. Background: In the IVML object model, 
 * delegating types are used to resolve class dependencies while defining IVML operations
 * as constants. These delegating types are singleton instances and if serialized
 * to an XML file, the type identity of the object constants defined in the IVML 
 * object model are not unique anymore. In this class, map the delegating type to a 
 * unique name and back to the actual singleton instance.
 * 
 * @author Holger Eichelberger
 */
class DelegatingTypeConverter implements Converter {

    /**
     * Creates a singleton type converter.
     */
    DelegatingTypeConverter() {
    }
    
    /**
     * Determines whether this converter instance handles the given class.
     *
     * @param cls the class to be tested
     * @return <code>true</code> if this instance handles <code>class</code> (this 
     *   is only the case if it is a delegating class), <code>false</code> else 
     */
    @SuppressWarnings("rawtypes") 
    public boolean canConvert(Class cls) {
        return cls.equals(TypeMapper.DELEGATING_CLASS);
    }
    
    /**
     * Marshals a given <code>object</code> to the given <code>writer</code> in the 
     * specified marshalling <code>context</code>. This method translates a delegating
     * type singleton to a name.
     * 
     * @param object the object to be marshalled
     * @param writer the output stream writer
     * @param context the marshalling context
     */
    public void marshal(Object object, HierarchicalStreamWriter writer, MarshallingContext context) {
        writer.startNode("delegateName");
        if (object instanceof IDatatype) {
            writer.setValue(TypeMapper.getName((IDatatype) object));
        }
        writer.endNode();
    }

    /**
     * Unmarshals the current object to be read from the given <code>reader</code> in the 
     * specified unmarshalling <code>context</code>. This method translates the name
     * back to the singleton instance.
     * 
     * @param reader the input stream writer
     * @param context the marshalling context
     * @return the unmarshalled object
     */
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
        Object result;
        reader.moveDown();
        result = TypeMapper.getType(reader.getValue());
        reader.moveUp();
        return result;
    }

}
