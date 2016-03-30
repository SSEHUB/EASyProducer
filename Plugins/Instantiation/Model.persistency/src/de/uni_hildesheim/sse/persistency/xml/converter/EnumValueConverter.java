package de.uni_hildesheim.sse.persistency.xml.converter;

import java.util.List;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.basics.modelManagement.ModelInfo;
import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.instantiation.core.Bundle;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.EnumValue;
import net.ssehub.easy.varModel.management.VarModel;
import net.ssehub.easy.varModel.model.IvmlException;
import net.ssehub.easy.varModel.model.ModelQuery;
import net.ssehub.easy.varModel.model.ModelQueryException;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.values.Value;

/**
 * Converter for the enums.
 * 
 * @author Sass
 *
 */
public class EnumValueConverter implements Converter {
    
    protected static EASyLogger logger = EASyLoggerFactory.INSTANCE.getLogger(EnumValueConverter.class,
            Bundle.ID);
    
    /**
     * Creates a singleton type converter.
     */
    public EnumValueConverter() {
    }

    /**
     * Determines whether this converter instance handles the given class.
     *
     * @param cls the class to be tested
     * @return <code>true</code> if this instance handles <code>class</code> (this 
     *   is only the case if it is a EnumValue class), <code>false</code> else 
     */
    @SuppressWarnings("rawtypes")
    @Override
    public boolean canConvert(Class cls) {
        return EnumValue.class.isAssignableFrom(cls);
    }

    /**
     * Marshals a given <code>object</code> to the given <code>writer</code> in the 
     * specified marshaling <code>context</code>. This method translates a EnumValue
     * type singleton to a name.
     * 
     * @param object the object to be marshaled
     * @param writer the output stream writer
     * @param context the marshaling context
     */
    @Override
    public void marshal(Object object, HierarchicalStreamWriter writer, MarshallingContext context) {
        EnumValue enumValue = (EnumValue) object;
        writer.startNode("enumValue");
        net.ssehub.easy.varModel.model.datatypes.Enum e = 
            (net.ssehub.easy.varModel.model.datatypes.Enum) enumValue.getDatatype();
        writer.addAttribute("project", String.valueOf(e.getTopLevelParent().getName()));
        writer.addAttribute("type", enumValue.getDatatype().getName());
        writer.addAttribute("enum", enumValue.getQualifiedName());
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
        // Get attributes and parameters
        String projectName = reader.getAttribute("project");
        String type = reader.getAttribute("type");
        String literal = reader.getAttribute("enum");
        List<ModelInfo<Project>> list1 = VarModel.INSTANCE.availableModels().getModelInfo(projectName);
        ModelInfo<Project> model = list1.get(0);
        try {
            VarModel.INSTANCE.load(model);
            Project project = model.getResolved();
            String name = type + "." + literal;
            if (project != null) {
                try {
                    Value eVal = ModelQuery.enumLiteralAsValue(project, name);
                    if (eVal instanceof net.ssehub.easy.varModel.model.values.EnumValue) {
                        result = new EnumValue((net.ssehub.easy.varModel.model.values.EnumValue) eVal);
                    }
                } catch (ModelQueryException e) {
                    logger.exception(e);
                } catch (IvmlException e) {
                    logger.exception(e);
                }
            } else {
                logger.warn("Enum " + name + " not found! Project " + projectName + " was null");
            }
        } catch (ModelManagementException e1) {
            logger.exception(e1);
        }
        reader.moveUp();
        return result;
    }

}
