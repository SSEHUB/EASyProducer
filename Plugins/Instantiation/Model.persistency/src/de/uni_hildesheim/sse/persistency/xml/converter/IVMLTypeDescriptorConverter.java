package de.uni_hildesheim.sse.persistency.xml.converter;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.instantiation.core.Bundle;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.FakeTypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.IvmlTypeDescriptor;


/**
 * Converter for the {@link IVMLTypeDescriptor}.
 * 
 * @author Sass
 * 
 */
public class IVMLTypeDescriptorConverter implements Converter {
    
    private static EASyLogger logger = EASyLoggerFactory.INSTANCE.getLogger(IVMLTypeDescriptorConverter.class,
            Bundle.ID);

    private static TypeRegistry typeRegistry = TypeRegistry.DEFAULT;
    
    /**
     * Creates a singleton type converter.
     */
    public IVMLTypeDescriptorConverter() {
    }

    /**
     * Determines whether this converter instance handles the given class.
     *
     * @param cls the class to be tested
     * @return <code>true</code> if this instance handles <code>class</code> (this 
     *   is only the case if it is a IvmlTypeDescriptor class), <code>false</code> else 
     */
    @SuppressWarnings("rawtypes")
    @Override
    public boolean canConvert(Class cls) {
        return IvmlTypeDescriptor.class.isAssignableFrom(cls);
    }

    /**
     * Marshals a given <code>object</code> to the given <code>writer</code> in the 
     * specified marshaling <code>context</code>. This method translates a IvmlTypeDescriptor
     * type singleton to a name.
     * 
     * @param object the object to be marshaled
     * @param writer the output stream writer
     * @param context the marshaling context
     */
    @Override
    public void marshal(Object object, HierarchicalStreamWriter writer, MarshallingContext context) {
        writer.startNode("iTD");
        if (object instanceof IvmlTypeDescriptor) {
            object = ((IvmlTypeDescriptor) object);
            int parameterCount = ((IvmlTypeDescriptor) object).getGenericParameterCount();
            writer.addAttribute("name", ((IvmlTypeDescriptor) object).getName());
            for (int i = 0; i < parameterCount; i++) {
                writer.addAttribute("parameter" + i, ((IvmlTypeDescriptor) object).getGenericParameterType(i)
                        .getVilName());
            }
            writer.endNode();
        }
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
        reader.moveDown();
        String name = reader.getAttribute("name");
        result = typeRegistry.getType(name);
        if (result.getClass().isAssignableFrom(FakeTypeDescriptor.class)) {
            logger.warn("FakeTypeDescriptor for " + name);
        }
        reader.moveUp();
        return result;
    }
    
    /**
     * Setter for the type registry.
     * 
     * @param registry
     *            The type registry to be set
     */
    public static void setTypeRegistry(TypeRegistry registry) {
        typeRegistry = registry;
    }

}
