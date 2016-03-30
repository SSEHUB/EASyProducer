package de.uni_hildesheim.sse.persistency.xml.converter;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.basics.modelManagement.Version;
import net.ssehub.easy.basics.modelManagement.VersionFormatException;
import net.ssehub.easy.instantiation.core.Bundle;
import net.ssehub.easy.varModel.management.VarModel;
import net.ssehub.easy.varModel.model.Project;

/**
 * Converter for {@link Project} within VIL or VTL files.
 * 
 * @author Sass
 *
 */
public class ProjectConverter implements Converter {
    
    protected static EASyLogger logger = EASyLoggerFactory.INSTANCE.getLogger(ProjectConverter.class,
            Bundle.ID);
    
    /**
     * Creates a singleton type converter.
     */
    public ProjectConverter() {
    }

    /**
     * Determines whether this converter instance handles the given class.
     *
     * @param cls the class to be tested
     * @return <code>true</code> if this instance handles <code>class</code> (this 
     *   is only the case if it is a Project class), <code>false</code> else 
     */
    @SuppressWarnings("rawtypes")
    @Override
    public boolean canConvert(Class cls) {
        return Project.class.isAssignableFrom(cls);
    }

    /**
     * Marshals a given <code>object</code> to the given <code>writer</code> in the 
     * specified marshaling <code>context</code>. This method translates a Project
     * type singleton to a name.
     * 
     * @param object the object to be marshaled
     * @param writer the output stream writer
     * @param context the marshaling context
     */
    @Override
    public void marshal(Object object, HierarchicalStreamWriter writer, MarshallingContext context) {
        Project project = (Project) object;
        writer.startNode("project");
        writer.addAttribute("name", project.getName());
        Version version = project.getVersion();
        String versionAsString = "";
        if (null != version) {
            versionAsString = version.getVersion();
        }
        writer.addAttribute("version", versionAsString);
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
        reader.moveDown();
        Object result = null;
        String name = reader.getAttribute("name");
        String version = reader.getAttribute("version");
        if (version.isEmpty()) {
            version = null;
        }
        try {
            result = VarModel.INSTANCE.availableModels().getModelInfo(name, version);
        } catch (VersionFormatException e) {
            logger.exception(e);
        }
        reader.moveUp();
        return result;
    }

}
