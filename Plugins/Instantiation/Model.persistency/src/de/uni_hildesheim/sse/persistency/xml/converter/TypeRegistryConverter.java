package de.uni_hildesheim.sse.persistency.xml.converter;

import java.util.List;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import de.uni_hildesheim.sse.easy_producer.instantiator.Bundle;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration.IvmlTypeResolver;
import de.uni_hildesheim.sse.persistency.xml.Extensions;
import de.uni_hildesheim.sse.persistency.xml.ISerializerPlugin;
import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.basics.modelManagement.ModelInfo;
import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.varModel.management.VarModel;
import net.ssehub.easy.varModel.model.Project;

/**
 * A type converter for the TypeRegistry.
 * 
 * @author Aike Sass
 */
public class TypeRegistryConverter implements Converter {

    protected static EASyLogger logger = EASyLoggerFactory.INSTANCE.getLogger(TypeRegistryConverter.class,
            Bundle.ID);
    
    private static String projectName = "QM";
    
    /**
     * Creates a singleton type converter.
     */
    public TypeRegistryConverter() {
    }
    
    /**
     * Determines whether this converter instance handles the given class.
     *
     * @param cls the class to be tested
     * @return <code>true</code> if this instance handles <code>class</code> (this 
     *   is only the case if it is a TypeRegistry class), <code>false</code> else 
     */
    @Override
    @SuppressWarnings("rawtypes")
    public boolean canConvert(Class cls) {
        return cls.equals(TypeRegistry.class);
    }

    /**
     * Marshals a given <code>object</code> to the given <code>writer</code> in the 
     * specified marshaling <code>context</code>. This method translates a TypeRegistry
     * type singleton to a name.
     * 
     * @param object the object to be marshaled
     * @param writer the output stream writer
     * @param context the marshaling context
     */
    @Override
    public void marshal(Object object, HierarchicalStreamWriter writer, MarshallingContext context) {
        writer.startNode("reg");
        TypeRegistry typeregistry = (TypeRegistry) object;
        String typeRegistryIdentifier = "";
        for (ISerializerPlugin<?> plugin : Extensions.getPluginList()) {
            typeRegistryIdentifier = plugin.getTypeRegistryIdentifier(typeregistry);
            if (!typeRegistryIdentifier.isEmpty()) {
                break;
            }
        }
        writer.setValue(typeRegistryIdentifier);
        writer.endNode();
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
        List<ModelInfo<Project>> projects = VarModel.INSTANCE.availableModels().getModelInfo(projectName);
        TypeRegistry typeRegistry = null;
        String value = reader.getValue();
        for (ISerializerPlugin<?> plugin : Extensions.getPluginList()) {
            typeRegistry = plugin.createTypeRegistry(value);
            if (null != typeRegistry) {
                break;
            }
        }
        if (null == typeRegistry) {
            typeRegistry = new TypeRegistry(TypeRegistry.DEFAULT);
        }
        if (projects != null && projects.size() > 0) {
            try {
                VarModel.INSTANCE.load(projects.get(0));
            } catch (ModelManagementException e) {
                logger.exception(e);
            }
            typeRegistry.addTypeResolver(new IvmlTypeResolver(projects.get(0).getResolved(), typeRegistry));
        }
        VTLTypeConverter.setTypeRegistry(typeRegistry);
        ReflectionOperationDescriptorConverter.setTypeRegistry(typeRegistry);
        ReflectionTypeDescriptorConverter.setTypeRegistry(typeRegistry);
        IVMLTypeDescriptorConverter.setTypeRegistry(typeRegistry);
        IvmlComparisonOperationDescriptorConverter.setTypeRegistry(typeRegistry);
        result = typeRegistry;
        reader.moveUp();
        return result;
    }

    /**
     * Setter for the project name.
     * 
     * @param name  name of the project
     */
    public static void setProjectName(String name) {
        projectName = name;
    }
}
