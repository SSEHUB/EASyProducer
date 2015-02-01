package de.uni_hildesheim.sse.persistency.xml;

import java.util.List;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration.IvmlTypeResolver;
import de.uni_hildesheim.sse.model.management.VarModel;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.utils.modelManagement.ModelInfo;

/**
 * A type converter for the TypeRegistry.
 * 
 * @author Aike Sass
 */
public class TypeRegistryConverter implements Converter {
    
    private static String projectName = "QM";
    
    @Override
    @SuppressWarnings("rawtypes")
    public boolean canConvert(Class cls) {
        return cls.equals(TypeRegistry.class);
    }

    @Override
    public void marshal(Object object, HierarchicalStreamWriter writer, MarshallingContext context) {
        writer.startNode("registry");
        writer.setValue(object.toString());
        writer.endNode();
    }

    @Override
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
        Object result = null;
        reader.moveDown();
        List<ModelInfo<Project>> projects = VarModel.INSTANCE.availableModels().getModelInfo(projectName);
        TypeRegistry typeRegistry = new TypeRegistry(TypeRegistry.DEFAULT);
        if (projects != null) {
            typeRegistry.addTypeResolver(new IvmlTypeResolver(projects.get(0).getResolved(), 
                    typeRegistry, projectName));
        }
        VTLTypeConverter.setTypeRegistry(typeRegistry);
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
