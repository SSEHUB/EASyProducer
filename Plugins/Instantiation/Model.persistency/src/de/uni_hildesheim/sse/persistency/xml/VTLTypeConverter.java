package de.uni_hildesheim.sse.persistency.xml;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.VilException;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory.EASyLogger;

/**
 * .
 * 
 * @author Aike Sass
 */
public class VTLTypeConverter implements Converter {

    private static EASyLogger logger = EASyLoggerFactory.INSTANCE.getLogger(VTLTypeConverter.class,
            "Model.persistency.Test");

    private static TypeRegistry typeRegistry = TypeRegistry.DEFAULT;

    /**
     * Creates a singleton type converter.
     */
    VTLTypeConverter() {
    }

    /**
     * Determines whether this converter instance handles the given class.
     * 
     * @param cls
     *            the class to be tested
     * @return <code>true</code> if this instance handles <code>class</code> (this is only the case if it is a
     *         delegating class), <code>false</code> else
     */
    @SuppressWarnings("rawtypes")
    public boolean canConvert(Class cls) {
        return TypeDescriptor.class.isAssignableFrom(cls);
    }

    // OLD WORKING CODE
    // /**
    // * Marshals a given <code>object</code> to the given <code>writer</code> in the
    // * specified marshaling <code>context</code>. This method translates a delegating
    // * type singleton to a name.
    // *
    // * @param object the object to be marshaled
    // * @param writer the output stream writer
    // * @param context the marshaling context
    // */
//     public void marshal(Object object, HierarchicalStreamWriter writer, MarshallingContext context) {
//     writer.startNode("declaringType");
//     if (object instanceof TypeDescriptor<?>) {
//     writer.setValue(((TypeDescriptor<?>) object).getVilName());
//     }
//     writer.endNode();
//     }

    // NEW EXPERIMENTAL CODE
    /**
     * Marshals a given <code>object</code> to the given <code>writer</code> in the specified marshaling
     * <code>context</code>. This method translates a delegating type singleton to a name.
     * 
     * @param object
     *            the object to be marshaled
     * @param writer
     *            the output stream writer
     * @param context
     *            the marshaling context
     */
    public void marshal(Object object, HierarchicalStreamWriter writer, MarshallingContext context) {
        writer.startNode("declaringType");
        if (object instanceof TypeDescriptor<?>) {
            object = ((TypeDescriptor<?>) object);
            int parameterCount = ((TypeDescriptor<?>) object).getParameterCount();
            writer.addAttribute("name", ((TypeDescriptor<?>) object).getName());
            for (int i = 0; i < parameterCount; i++) {
                writer.addAttribute("parameter" + i, ((TypeDescriptor<?>) object).getParameterType(i).getVilName());
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
                result = TypeRegistry.getMapType(typeRegistry.getType(reader.getAttribute(1)));
            } catch (VilException e) {
                logger.exception(e);
            }
        } else if (name.startsWith("Set") && numberOfAttributes > 1 ) {
            try {
                result = TypeRegistry.getSetType(typeRegistry.getType(reader.getAttribute(1)));
            } catch (VilException e) {
                logger.exception(e);
            }
        } else if (name.startsWith("Collection") && numberOfAttributes > 1 ) {
            try {
                result = TypeRegistry.getCollectionType(typeRegistry.getType(reader.getAttribute(1)));
            } catch (VilException e) {
                logger.exception(e);
            }
        } else {
            result = typeRegistry.getType(name);
        }
        reader.moveUp();
        return result;
    }

    // /**
    // * Unmarshals the current object to be read from the given <code>reader</code> in the
    // * specified unmarshaling <code>context</code>. This method translates the name
    // * back to the singleton instance.
    // *
    // * @param reader the input stream writer
    // * @param context the marshaling context
    // * @return the unmarshaled object
    // */
    // public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
    // Object result = null;
    // reader.moveDown();
    // if (reader.getValue().startsWith("sequenceOf")) {
    // String var = reader.getValue();
    // String temp = var.substring("sequenceOf(".length(), var.length() - 1);
    // try {
    // result = TypeRegistry.getSequenceType(typeRegistry.getType(temp));
    // } catch (VilException e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }
    // } else if (reader.getValue().startsWith("setOf")) {
    // String var = reader.getValue();
    // String temp = var.substring("setOf(".length(), var.length() - 1);
    // try {
    // result = TypeRegistry.getSetType(typeRegistry.getType(temp));
    // } catch (VilException e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }
    // } else if (reader.getValue().startsWith("mapOf")) {
    // String var = reader.getValue();
    // System.out.println(var + "\t" + var.length());
    // String temp = var.substring("mapOf(".length(), var.length() - 1);
    // String[] tmpArray = temp.split(",");
    // try {
    // result = TypeRegistry.getMapType(typeRegistry.getType(tmpArray[0]));
    // } catch (VilException e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }
    // } else if (reader.getValue().startsWith("collectionOf")) {
    // String var = reader.getValue();
    // String temp = var.substring("collectionOf(".length(), var.length() - 1);
    // try {
    // result = TypeRegistry.getCollectionType(typeRegistry.getType(temp));
    // } catch (VilException e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }
    // } else {
    // result = typeRegistry.getType(reader.getValue());
    // }
    //
    // System.out.println("Reader: " + reader.getValue());
    // System.out.println("Result: " + result);
    // reader.moveUp();
    // return result;
    // }

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
