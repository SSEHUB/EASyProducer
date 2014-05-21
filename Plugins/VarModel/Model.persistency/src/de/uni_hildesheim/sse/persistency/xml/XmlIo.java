package de.uni_hildesheim.sse.persistency.xml;

import java.io.InputStream;
import java.io.OutputStream;

import com.thoughtworks.xstream.XStream;

import de.uni_hildesheim.sse.model.varModel.Project;

/**
 * Supports storing projects (and referenced projects) into 
 * XML format. Please note that the XML format is intended for
 * temporary storage of models, in particular in environments where
 * xText or Eclipse dependency must not be used. Further, this class
 * does not rely on {@link de.uni_hildesheim.sse.model.management.VarModel}, 
 * i.e. the related mechanisms, loaders and listeners there are not 
 * considered by this class (this would require a specific XML loader). [req SAP, TUV]
 * 
 * @author Holger Eichelberger
 */
public class XmlIo {
    
    /**
     * Writes an entire project including references to the given output stream.
     * 
     * @param project the project to be written
     * @param out the output stream where to write the project to
     */
    public static final void write(Project project, OutputStream out) {
        XStream xstream = createStream();
        xstream.toXML(new IvmlModel(project), out);
    }
    
    /**
     * Reads a project from an input stream.
     * 
     * @param in the input stream to read the project definition from
     * @return the instantiated project
     */
    public static final Project read(InputStream in) {
        XStream xstream = createStream();
        IvmlModel model = (IvmlModel) xstream.fromXML(in);
        return model.getProject();
    }
    
    /**
     * Creates a stream instance for reading and writing.
     * 
     * @return the stream instance
     */
    private static final XStream createStream() {
        XStream xstream = new XStream();
        xstream.alias("ivmlModel", IvmlModel.class);
        xstream.registerConverter(new DelegatingTypeConverter());
        xstream.registerConverter(new OperationConverter());
        return xstream;
    }

    /**
     * Defines the top level element in the XML. In future versions this class
     * may contain a file version information.
     * 
     * @author Holger Eichelberger
     */
    private static class IvmlModel {
        
        /**
         * The project to be persisted or read from a file.
         */
        private Project project;
        
        /**
         * Creates the top-level wrapping instance.
         * 
         * @param project the project to be contained
         */
        public IvmlModel(Project project) {
            this.project = project;
        }
        
        /**
         * Returns the contained project instance.
         * 
         * @return the contained project instance
         */
        public Project getProject() {
            return project;
        }
    }

}
