package net.ssehub.easy.instantiation.serializer.xml.converter;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import net.ssehub.easy.instantiation.core.model.vilTypes.ReflectionOperationDescriptor;

/**
 * Converter for the {@link ReflectionOperationDescriptor}.
 * 
 * @author Sass
 *
 */
public class ReflectionOperationDescriptorConverter extends AbstractDescriptorConverter implements Converter {
    
    /**
     * Determines whether this converter instance handles the given class.
     *
     * @param cls the class to be tested
     * @return <code>true</code> if this instance handles <code>class</code> (this 
     *   is only the case if it is a ReflectionOperationDescriptor class), <code>false</code> else 
     */
    @Override
    @SuppressWarnings("rawtypes")
    public boolean canConvert(Class cls) {
        return ReflectionOperationDescriptor.class.isAssignableFrom(cls);
    }

    /**
     * Marshals a given <code>object</code> to the given <code>writer</code> in the 
     * specified marshaling <code>context</code>. This method translates a ReflectionOperationDescriptor
     * type singleton to a name.
     * 
     * @param object the object to be marshaled
     * @param writer the output stream writer
     * @param context the marshaling context
     */
    @Override
    public void marshal(Object object, HierarchicalStreamWriter writer, MarshallingContext context) {
        ReflectionOperationDescriptor reflectionOperationDescriptor = (ReflectionOperationDescriptor) object;
        writer.startNode("rOD");
        addAttributes(writer, reflectionOperationDescriptor);
        writer.endNode();
    }

}

