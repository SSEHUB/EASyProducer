package de.uni_hildesheim.sse.persistency.xml;

import java.util.List;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.Advice;
import de.uni_hildesheim.sse.model.management.VarModel;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.utils.modelManagement.ModelInfo;

/**
 * A type converter for the advices.
 * 
 * @author Sass
 *
 */
public class AdviceConverter implements Converter {

    @Override
    @SuppressWarnings("rawtypes")
    public boolean canConvert(Class cls) {
        return Advice.class.isAssignableFrom(cls);
    }

    @Override
    public void marshal(Object object, HierarchicalStreamWriter writer, MarshallingContext context) {
        writer.startNode("advice");
        writer.setValue(((Advice) object).getName());
        writer.endNode();
    }

    @Override
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
        Object result;
        reader.moveDown();
        TypeRegistryConverter.setProjectName(reader.getValue());
        List<ModelInfo<Project>> project = VarModel.INSTANCE.availableModels().getModelInfo(reader.getValue());
        result = null;
        if (project != null) {
            result = new Advice(reader.getValue(), null, project.get(0).getResolved());
        } 
        reader.moveUp();
        return result;
    }

}
