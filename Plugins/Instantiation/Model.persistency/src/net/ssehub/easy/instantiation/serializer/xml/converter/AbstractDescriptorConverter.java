package net.ssehub.easy.instantiation.serializer.xml.converter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.instantiation.serializer.xml.Bundle;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.OperationDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.ReflectionTypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.FakeTypeDescriptor;

/**
 * Abstract converter used by {@link ReflectionOperationDescriptorConverter} and 
 * {@link IvmlComparisonOperationDescriptorConverter}.
 * 
 * @author Sass
 *
 */
public abstract class AbstractDescriptorConverter implements Converter {

    private static TypeRegistry typeRegistry = TypeRegistry.DEFAULT;
    
    private static Map<String, TypeDescriptor<?>> pseudoTypes = new HashMap<String, TypeDescriptor<?>>();
    
    protected EASyLogger logger = EASyLoggerFactory.INSTANCE.getLogger(
            this.getClass(), Bundle.ID);
    
    /**
     * Creates a singleton descriptor converter and gets all vil pseudo types.
     */
    public AbstractDescriptorConverter() {
        for (TypeDescriptor<?> type : Arrays.asList(ReflectionTypeDescriptor.PSEUDO_TYPES)) {
            pseudoTypes.put(type.getVilName(), type);
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
        int excludeNumberOfAttributes = 3;
        reader.moveDown();
        // Get attributes and parameters
        String declaringType = reader.getAttribute("declaringType");
        String name = reader.getAttribute("name");
        boolean instantiator = Boolean.valueOf(reader.getAttribute("instantiator"));
        
        int arrayLength = reader.getAttributeCount() - excludeNumberOfAttributes;
        TypeDescriptor<?>[] parameters = new TypeDescriptor<?>[arrayLength];
        for (int i = 0; i < reader.getAttributeCount() - excludeNumberOfAttributes; i++) {
            parameters[i] = getTypeDescriptor(reader.getAttribute(i + excludeNumberOfAttributes));
        }
        
        TypeDescriptor<?> typeDescriptor = null;
        if (instantiator) {
            typeDescriptor = typeRegistry.getInstantiator(name);
        } else {
            typeDescriptor = getTypeDescriptor(declaringType);
        }
        Iterable<OperationDescriptor> operations = typeDescriptor.getOperations();
        result = getOperationDescriptor(name, result, operations, parameters);
        if (null == result) {
            result = getOperationDescriptor(name, result, typeDescriptor.getConversions(), parameters);
        }
        if (null == result) {
            logger.warn("not found: " + name);
            logger.warn("declaringType: " + declaringType);
            logger.warn("typeDescriptor: " + typeDescriptor.getVilName());
        }
        reader.moveUp();
        return result;
    }
    
    /**
     * Adds the attributes to the node.
     * 
     * @param writer the output stream writer
     * @param operationDescriptor the OperationDescriptor
     */
    public void addAttributes(HierarchicalStreamWriter writer, OperationDescriptor operationDescriptor) {
        writer.addAttribute("instantiator", String.valueOf(operationDescriptor.getDeclaringType().isInstantiator()));
        writer.addAttribute("declaringType", operationDescriptor.getDeclaringType().getVilName());
        writer.addAttribute("name", operationDescriptor.getName());
        int parameterCount = operationDescriptor.getParameterCount();
        for (int i = 0; i < parameterCount; i++) {
            writer.addAttribute("parameter" + i, operationDescriptor.getParameterType(i).getVilName());
        }
    }
    
    /**
     * Gets the {@link TypeDescriptor} for a given attribute.
     * 
     * @param attribute The attribute to be checked.
     * 
     * @return the {@link TypeDescriptor} for the given attribute, null if not found.
     */
    private TypeDescriptor<?> getTypeDescriptor(String attribute) {
        TypeDescriptor<?> result = null;
        TypeDescriptor<?> [] parameters = null;
        if (attribute.startsWith("sequence")) {
            try {
                parameters = getParameterTypes(attribute, parameters, "sequenceOf(");
                result = TypeRegistry.getSequenceType(parameters);
            } catch (VilException e) {
                logger.exception(e);
            }
        } else if (attribute.startsWith("map")) {
            try {
                parameters = getParameterTypes(attribute, parameters, "mapOf(");
                result = TypeRegistry.getMapType(parameters);
            } catch (VilException e) {
                logger.exception(e);
            }
        } else if (attribute.startsWith("set")) {
            try {
                parameters = getParameterTypes(attribute, parameters, "setOf(");
                result = TypeRegistry.getSetType(parameters);
            } catch (VilException e) {
                logger.exception(e);
            }
        } else if (attribute.startsWith("Collection")) {
            try {
                result = TypeRegistry.getCollectionType(parameters);
            } catch (VilException e) {
                logger.exception(e);
            }
        } else if (pseudoTypes.containsKey(attribute)) {
            result = pseudoTypes.get(attribute);
        } else {
            result = typeRegistry.getType(attribute);
        } 
        if (result.getClass().isAssignableFrom(FakeTypeDescriptor.class)) {
            logger.warn("FakeType for " + attribute);
        }
        return result;
    }

    /**
     * Collects the types of the parameters.
     * 
     * @param attribute The attribute to be parsed
     * @param parameters Array containing all types
     * @param regex Regex to filter the string
     * @return Array with all types
     */
    private TypeDescriptor<?>[] getParameterTypes(String attribute, TypeDescriptor<?>[] parameters, String regex) {
        String tmpAttr = attribute;
        if (tmpAttr.contains(regex)) {
            /* since we already now what kind of type we are inspecting remove it to get the parameters 
             * i.e.: mapOf(String, String) will result in "String, String" */
            tmpAttr = tmpAttr.replaceFirst(regex.replace("(", "\\("), "");
            tmpAttr = tmpAttr.substring(0, tmpAttr.lastIndexOf(")"));
            // Assuming that all types can have a maximum of two parameters split by ","
            String[] collection = tmpAttr.split(",", 2);
            parameters = new TypeDescriptor<?>[collection.length];
            // Collect all types
            for (int i = 0; i < collection.length; i++) {
                parameters[i] = getTypeDescriptor(collection[i].trim());
            }
        }
        return parameters;
    }
    
    /**
     * Gets the {@link OperationDescriptor}.
     * 
     * @param name name of the attribute
     * @param result the object to be returned
     * @param iterable   Iterable of {@link OperationDescriptor}
     * @param parameters  Array with parameters
     * @return the {@link OperationDescriptor} for a given attribute
     */
    private Object getOperationDescriptor(String name, Object result,
            Iterable<OperationDescriptor> iterable, TypeDescriptor<?>[] parameters) {
        // Get all attribute types
        for (OperationDescriptor opDesc : iterable) {
            int paramCount = opDesc.getParameterCount();
            if (opDesc.getName().equals(name) && paramCount == parameters.length) {
                // Get all parameter Types
                TypeDescriptor<?>[] parameterList = new TypeDescriptor<?>[paramCount];
                for (int i = 0; i < parameterList.length; i++) {
                    parameterList[i] = opDesc.getParameterType(i);
                }
                // Check if attribute types and parameter types are the same
                boolean isSame = false;
                for (int i = 0; i < parameterList.length; i++) {
                    if (parameters[i] == ReflectionTypeDescriptor.ANY) {
                        isSame = parameterList[i] == parameters[i];
                    } else {
                        isSame = parameterList[i].isSame(parameters[i]);
                    }
                }
                if (isSame) {
                    result = opDesc;
                    break;
                }
            }
        }
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
