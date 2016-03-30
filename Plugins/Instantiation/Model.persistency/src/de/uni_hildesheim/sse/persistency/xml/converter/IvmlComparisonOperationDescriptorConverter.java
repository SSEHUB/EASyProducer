package de.uni_hildesheim.sse.persistency.xml.converter;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.IvmlComparisonOperationDescriptor;

/**
 * Converter for the {@link IvmlComparisonOperationDescriptor}.
 * 
 * @author Sass
 *
 */
public class IvmlComparisonOperationDescriptorConverter extends AbstractDescriptorConverter implements Converter {
    
    /**
     * Determines whether this converter instance handles the given class.
     *
     * @param cls the class to be tested
     * @return <code>true</code> if this instance handles <code>class</code> (this 
     *   is only the case if it is a IvmlComparisonOperationDescriptor class), <code>false</code> else 
     */
    @SuppressWarnings("rawtypes")
    @Override
    public boolean canConvert(Class cls) {
        return IvmlComparisonOperationDescriptor.class.isAssignableFrom(cls);
    }

    /**
     * Marshals a given <code>object</code> to the given <code>writer</code> in the 
     * specified marshaling <code>context</code>. This method translates a IvmlComparisonOperationDescriptor
     * type singleton to a name.
     * 
     * @param object the object to be marshaled
     * @param writer the output stream writer
     * @param context the marshaling context
     */
    @Override
    public void marshal(Object object, HierarchicalStreamWriter writer, MarshallingContext context) {
        IvmlComparisonOperationDescriptor ivmlCompOperationDescriptor = (IvmlComparisonOperationDescriptor) object;
        writer.startNode("iCOD");
        addAttributes(writer, ivmlCompOperationDescriptor);
        writer.endNode();
    }

}
