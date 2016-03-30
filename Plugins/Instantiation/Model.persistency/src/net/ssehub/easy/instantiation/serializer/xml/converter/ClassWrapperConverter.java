package net.ssehub.easy.instantiation.serializer.xml.converter;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.instantiation.core.Bundle;
import net.ssehub.easy.instantiation.core.model.vilTypes.ClassWrapper;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;

/**
 * Converter to serialize the {@link ClassWrapper}.
 * 
 * @author Sass
 *
 */
public class ClassWrapperConverter implements Converter {
    
    protected static EASyLogger logger = EASyLoggerFactory.INSTANCE.getLogger(ClassWrapperConverter.class,
            Bundle.ID);
    
    /**
     * Creates a singleton type converter.
     */
    public ClassWrapperConverter() {
    }

    /**
     * Determines whether this converter instance handles the given class.
     *
     * @param cls the class to be tested
     * @return <code>true</code> if this instance handles <code>class</code> (this 
     *   is only the case if it is a ClassWrapper class), <code>false</code> else 
     */
    @SuppressWarnings("rawtypes")
    @Override
    public boolean canConvert(Class cls) {
        return ClassWrapper.class.isAssignableFrom(cls);
    }

    /**
     * Marshals a given <code>object</code> to the given <code>writer</code> in the 
     * specified marshaling <code>context</code>. This method translates a ClassWrapper
     * type singleton to a name.
     * 
     * @param object the object to be marshaled
     * @param writer the output stream writer
     * @param context the marshaling context
     */
    @Override
    public void marshal(Object object, HierarchicalStreamWriter writer, MarshallingContext context) {
        ClassWrapper wrapper = (ClassWrapper) object;
        writer.setValue(wrapper.getWrappedClass().getName());
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
        TypeRegistry typeRegistry = TypeRegistry.DEFAULT;
        try {
            result = new ClassWrapper(Class.forName(reader.getValue()), typeRegistry);
        } catch (ClassNotFoundException e) {
            logger.exception(e);
        }
        return result;
    }

}
