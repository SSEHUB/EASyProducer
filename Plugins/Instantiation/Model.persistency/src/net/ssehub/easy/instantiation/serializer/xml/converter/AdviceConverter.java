package net.ssehub.easy.instantiation.serializer.xml.converter;

import java.util.List;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import net.ssehub.easy.basics.modelManagement.ModelInfo;
import net.ssehub.easy.instantiation.core.model.common.Advice;
import net.ssehub.easy.varModel.management.VarModel;
import net.ssehub.easy.varModel.model.Project;

/**
 * A converter for the {@link Advice}. While marshaling the project name will be written.
 * In the process of unmarshaling the actual project from the available models is searched.
 * 
 * @author Sass
 *
 */
public class AdviceConverter implements Converter {
    
    /**
     * Creates a singleton type converter.
     */
    public AdviceConverter() {
    }

    /**
     * Determines whether this converter instance handles the given class.
     *
     * @param cls the class to be tested
     * @return <code>true</code> if this instance handles <code>class</code> (this 
     *   is only the case if it is a Advice class), <code>false</code> else 
     */
    @Override
    @SuppressWarnings("rawtypes")
    public boolean canConvert(Class cls) {
        return Advice.class.isAssignableFrom(cls);
    }

    /**
     * Marshals a given <code>object</code> to the given <code>writer</code> in the 
     * specified marshaling <code>context</code>. This method translates a advice
     * type singleton to a name.
     * 
     * @param object the object to be marshaled
     * @param writer the output stream writer
     * @param context the marshaling context
     */
    @Override
    public void marshal(Object object, HierarchicalStreamWriter writer, MarshallingContext context) {
        writer.startNode("advice");
        writer.setValue(((Advice) object).getName());
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
        Object result;
        reader.moveDown();
        TypeRegistryConverter.setProjectName(reader.getValue());
        List<ModelInfo<Project>> project = VarModel.INSTANCE.availableModels().getModelInfo(reader.getValue());
        result = null;
        if (null != project && project.size() > 0) {
            result = new Advice(reader.getValue(), null, project.get(0).getResolved());
        } 
        reader.moveUp();
        return result;
    }

}
