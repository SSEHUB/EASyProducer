package net.ssehub.easy.instantiation.serializer.xml.converter;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.instantiation.core.Bundle;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.FakeTypeDescriptor;

/**
 * Type converter for vtl types.
 * 
 * @author Aike Sass
 */
public class VTLTypeConverter implements Converter {

    private static EASyLogger logger = EASyLoggerFactory.INSTANCE.getLogger(VTLTypeConverter.class,
            Bundle.ID);

    private static TypeRegistry typeRegistry = TypeRegistry.DEFAULT;

    /**
     * Creates a singleton type converter.
     */
    public VTLTypeConverter() {
    }

    /**
     * Determines whether this converter instance handles the given class.
     * 
     * @param cls
     *            the class to be tested
     * @return <code>true</code> if this instance handles <code>class</code> (this is only the case if it is a
     *         TypeDescriptor class), <code>false</code> else
     */
    @SuppressWarnings("rawtypes")
    public boolean canConvert(Class cls) {
        return TypeDescriptor.class.isAssignableFrom(cls);
    }

    /**
     * Marshals a given <code>object</code> to the given <code>writer</code> in the specified marshaling
     * <code>context</code>. This method translates a TypeDescriptor type singleton to a name.
     * 
     * @param object
     *            the object to be marshaled
     * @param writer
     *            the output stream writer
     * @param context
     *            the marshaling context
     */
    public void marshal(Object object, HierarchicalStreamWriter writer, MarshallingContext context) {
        writer.startNode("vT");
        if (object instanceof TypeDescriptor<?>) {
            object = ((TypeDescriptor<?>) object);
            int parameterCount = ((TypeDescriptor<?>) object).getGenericParameterCount();
            writer.addAttribute("name", ((TypeDescriptor<?>) object).getName());
            for (int i = 0; i < parameterCount; i++) {
                writer.addAttribute("parameter" + i, 
                    ((TypeDescriptor<?>) object).getGenericParameterType(i).getVilName());
            }
            writer.endNode();
        }
    }

    /**
     * Unmarshals the current object to be read from the given <code>reader</code> in the specified unmarshaling
     * <code>context</code>. This method translates the name back to the singleton instance.
     * 
     * @param reader
     *            the input stream writer
     * @param context
     *            the marshaling context
     * @return the unmarshaled object
     */
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
        Object result = null;
        reader.moveDown();
        int numberOfAttributes = reader.getAttributeCount();
        String name = reader.getAttribute("name");
        if (name.startsWith("Sequence") && numberOfAttributes > 1 ) {
            try {
                result = TypeRegistry.getSequenceType(typeRegistry.getType(reader.getAttribute(1)));
            } catch (VilException e) {
                logger.exception(e);
            }
        } else if (name.startsWith("Map") && numberOfAttributes > 1 ) {
            try {
                TypeDescriptor<?>[] temp = getAllAttributes(reader, numberOfAttributes);
                result = TypeRegistry.getMapType(temp);
            } catch (VilException e) {
                logger.exception(e);
            }
        } else if (name.startsWith("Set") && numberOfAttributes > 1 ) {
            try {
                TypeDescriptor<?>[] temp = getAllAttributes(reader, numberOfAttributes);
                result = TypeRegistry.getSetType(temp);
            } catch (VilException e) {
                logger.exception(e);
            }
        } else if (name.startsWith("Collection") && numberOfAttributes > 1 ) {
            try {
                TypeDescriptor<?>[] temp = getAllAttributes(reader, numberOfAttributes);
                result = TypeRegistry.getCollectionType(temp);
            } catch (VilException e) {
                logger.exception(e);
            }
        } else {
            result = typeRegistry.getType(name);
        }
        if (result.getClass().isAssignableFrom(FakeTypeDescriptor.class)) {
            logger.warn("FakeTypeDescriptor for " + name);
        }
        reader.moveUp();
        return result;
    }

    /**
     * Gets All attributes for maps, sets and collections.
     * 
     * @param reader HierarchicalStreamReader
     * @param numberOfAttributes the number of attributes
     * @return Array of all attribute types
     */
    private TypeDescriptor<?>[] getAllAttributes(HierarchicalStreamReader reader, int numberOfAttributes) {
        TypeDescriptor<?>[] temp = new TypeDescriptor<?>[numberOfAttributes - 1];
        for (int i = 0; i < temp.length; i++) {
            String name = reader.getAttribute(i + 1);
            temp[i] = typeRegistry.getType(name);
            if (temp[i].getClass().isAssignableFrom(FakeTypeDescriptor.class)) {
                logger.warn("FakeType for " + name);
            }
        }
        return temp;
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
