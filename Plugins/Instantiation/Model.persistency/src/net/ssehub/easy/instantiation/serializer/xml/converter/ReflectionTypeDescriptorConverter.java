package net.ssehub.easy.instantiation.serializer.xml.converter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.instantiation.core.Bundle;
import net.ssehub.easy.instantiation.core.model.buildlangModel.RuleExecutionResult;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.ReflectionTypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.FakeTypeDescriptor;

/**
 * Converter for the {@link ReflectionTypeDescriptor}.
 * 
 * @author Sass
 * 
 */
public class ReflectionTypeDescriptorConverter implements Converter {

    private static EASyLogger logger = EASyLoggerFactory.INSTANCE.getLogger(ReflectionTypeDescriptorConverter.class,
            Bundle.ID);

    private static TypeRegistry typeRegistry = TypeRegistry.DEFAULT;
    
    private static Map<String, TypeDescriptor<?>> pseudoTypes = new HashMap<String, TypeDescriptor<?>>();

    /**
     * Creates a singleton type converter.
     */
    public ReflectionTypeDescriptorConverter() {
        for (TypeDescriptor<?> type : Arrays.asList(ReflectionTypeDescriptor.PSEUDO_TYPES)) {
            pseudoTypes.put(type.getVilName(), type);
        }
    }

    /**
     * Determines whether this converter instance handles the given class.
     *
     * @param cls the class to be tested
     * @return <code>true</code> if this instance handles <code>class</code> (this 
     *   is only the case if it is a ReflectionTypeDescriptor class), <code>false</code> else 
     */
    @SuppressWarnings("rawtypes")
    @Override
    public boolean canConvert(Class cls) {
        return ReflectionTypeDescriptor.class.isAssignableFrom(cls);
    }

    /**
     * Marshals a given <code>object</code> to the given <code>writer</code> in the 
     * specified marshaling <code>context</code>. This method translates a ReflectionTypeDescriptor
     * type singleton to a name.
     * 
     * @param object the object to be marshaled
     * @param writer the output stream writer
     * @param context the marshaling context
     */
    @Override
    public void marshal(Object object, HierarchicalStreamWriter writer, MarshallingContext context) {
        writer.startNode("rTD");
        if (object instanceof ReflectionTypeDescriptor<?>) {
            object = ((ReflectionTypeDescriptor<?>) object);
            int parameterCount = ((ReflectionTypeDescriptor<?>) object).getGenericParameterCount();
            writer.addAttribute("name", ((ReflectionTypeDescriptor<?>) object).getName());
            for (int i = 0; i < parameterCount; i++) {
                writer.addAttribute("parameter" + i, ((ReflectionTypeDescriptor<?>) object).getGenericParameterType(i)
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
        int numberOfAttributes = reader.getAttributeCount();
        String name = reader.getAttribute("name");
        if (pseudoTypes.containsKey(name)) {
            result = pseudoTypes.get(name);
        } else if (name.equals(RuleExecutionResult.TYPE.getVilName())) {
            result = RuleExecutionResult.TYPE;
        } else {
            if (name.startsWith("Sequence") && numberOfAttributes > 1) {
                try {
                    TypeDescriptor<?>[] temp = getAllAttributes(reader, numberOfAttributes);
                    result = TypeRegistry.getSequenceType(temp);
                } catch (VilException e) {
                    logger.exception(e);
                }
            } else if (name.startsWith("Map") && numberOfAttributes > 1) {
                try {
                    TypeDescriptor<?>[] temp = getAllAttributes(reader, numberOfAttributes);
                    result = TypeRegistry.getMapType(temp);
                } catch (VilException e) {
                    logger.exception(e);
                }
            } else if (name.startsWith("Set") && numberOfAttributes > 1) {
                try {
                    TypeDescriptor<?>[] temp = getAllAttributes(reader, numberOfAttributes);
                    result = TypeRegistry.getSetType(temp);
                } catch (VilException e) {
                    logger.exception(e);
                }
            } else if (name.startsWith("Collection") && numberOfAttributes > 1) {
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
        }
        reader.moveUp();
        return result;
    }

    /**
     * Gets All attributes for maps, sets and collections.
     * 
     * @param reader
     *            HierarchicalStreamReader
     * @param numberOfAttributes
     *            the number of attributes
     * @return Array of all attribute types
     */
    private TypeDescriptor<?>[] getAllAttributes(HierarchicalStreamReader reader, int numberOfAttributes) {
        TypeDescriptor<?>[] temp = new TypeDescriptor<?>[numberOfAttributes - 1];
        for (int i = 0; i < temp.length; i++) {
            String name = reader.getAttribute(i + 1);
            if (name.startsWith("mapOf")) {
                try {
                    temp[i] = getMapType(name, "mapOf");
                } catch (VilException e) {
                    logger.exception(e);
                }
            } else if (name.startsWith("setOf")) {
                try {
                    temp[i] = getSetType(name, "setOf");
                } catch (VilException e) {
                    logger.exception(e);
                }
            } else if (name.startsWith("sequenceOf")) {
                try {
                    temp[i] = getSequenceType(name, "sequenceOf");
                } catch (VilException e) {
                    logger.exception(e);
                }
            } else if (pseudoTypes.containsKey(name)) {
                temp[i] = pseudoTypes.get(name);
            } else {
                temp[i] = typeRegistry.getType(name);

            }
            if (temp[i].getClass().isAssignableFrom(FakeTypeDescriptor.class)) {
                logger.warn("FakeTypeDescriptor for " + name);
            }
        }
        return temp;
    }

    /**
     * Get the sequence type from the typeRegistry.
     * 
     * @param name
     *            type name
     * @param regex regex
     * @return SequenceType
     * @throws VilException exception
     */
    private TypeDescriptor<?> getSequenceType(String name, String regex) throws VilException {
        return TypeRegistry.getSequenceType(getType(name, regex));
    }

    /**
     * Get the map type from the typeRegistry.
     * 
     * @param name
     *            type name
     * @param regex regex
     * @return MapType
     * @throws VilException exception
     */
    private TypeDescriptor<?> getMapType(String name, String regex) throws VilException {
        return TypeRegistry.getMapType(getType(name, regex));
    }

    /**
     * Get the set type from the typeRegistry.
     * 
     * @param name
     *            type name
     * @param regex regex
     * @return set type
     * @throws VilException exception
     */
    private TypeDescriptor<?> getSetType(String name, String regex) throws VilException {
        return TypeRegistry.getSetType(getType(name, regex));
    }

    /**
     * Get type from the typeRegistry.
     * 
     * @param name
     *            type name
     * @param regex regex
     * @return {@link TypeDescriptor}
     */
    private TypeDescriptor<?>[] getType(String name, String regex) {
        String[] tmp = splitString(name, regex);
        TypeDescriptor<?>[] types = new TypeDescriptor<?>[tmp.length];
        for (int j = 0; j < tmp.length; j++) {
            types[j] = typeRegistry.getType(tmp[j]);
            if (types[j].getClass().isAssignableFrom(FakeTypeDescriptor.class)) {
                logger.warn("FakeType for " + types[j]);
            }
        }
        return types;
    }

    /**
     * Splits a string with a given regex.
     * 
     * @param name  the string to be splitted
     * @param regex the regex used for splitting
     * @return result
     */
    private String[] splitString(String name, String regex) {
        String[] result = name.split(regex);
        // Get rid of special chars except whitespaces
        String string = result[1].replaceAll("[^\\w\\s]", "");
        result = string.split("\\s");
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
