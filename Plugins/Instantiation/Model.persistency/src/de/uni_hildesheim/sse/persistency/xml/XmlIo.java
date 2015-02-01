package de.uni_hildesheim.sse.persistency.xml;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.thoughtworks.xstream.XStream;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Script;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.Template;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.utils.modelManagement.IModel;

/**
 * Supports storing projects (and referenced projects) into XML format. Please note that the XML format is intended for
 * temporary storage of models, in particular in environments where xText or Eclipse dependency must not be used.
 * Further, this class does not rely on {@link de.uni_hildesheim.sse.model.management.VarModel}, i.e. the related
 * mechanisms, loaders and listeners there are not considered by this class (this would require a specific XML loader).
 * [req SAP, TUV]
 * 
 * @author Holger Eichelberger
 */
public class XmlIo {

    // /**
    // * Writes an entire project including references to the given output stream.
    // *
    // * @param project the project to be written
    // * @param out the output stream where to write the project to
    // */
    // public static final void write(Project project, OutputStream out) {
    // XStream xstream = createStream();
    // xstream.toXML(new IvmlModel(project), out);
    // }
    //
    // /**
    // * Writes an entire script including references to the given output stream.
    // *
    // * @param script the script to be written
    // * @param out the output stream where to write the script to
    // */
    // public static final void write(Script script, OutputStream out) {
    // XStream xstream = createStream();
    // xstream.toXML(new VilModel(script), out);
    // }

    // /**
    // * Writes an entire template including references to the given output stream.
    // *
    // * @param template the template to be written
    // * @param out the output stream where to write the script to
    // */
    // public static final void write(Template template, OutputStream out) {
    // XStream xstream = createStream();
    // xstream.toXML(new VtlModel(template), out);
    // }

    /**
     * Writes a list of {@link IModel} to the given output stream.
     * 
     * @param list
     *            the list to be written
     * @param out
     *            the output stream where to write the list to
     */
    public static final void write(List<IModel> list, OutputStream out) {
        XStream xstream = createStream();
        xstream.toXML(list, out);
    }

    // /**
    // * Reads a project from an input stream.
    // *
    // * @param in the input stream to read the project definition from
    // * @return the instantiated project
    // */
    // public static final Project read(InputStream in) {
    // XStream xstream = createStream();
    // IvmlModel model = (IvmlModel) xstream.fromXML(in);
    // return model.getProject();
    // }

    /**
     * Reads a list of {@link IModel} from an input stream.
     * 
     * @param in
     *            the input stream to read the project definition from
     * @return the instantiated IModel
     */
    public static final List<IModel> read(InputStream in) {
        XStream xstream = createStream();
        List<IModel> list = (List<IModel>) xstream.fromXML(in);
//        List<IModel> list = castList(IModel.class, xstream.fromXML(in));
        return list;
    }

    // TODO: refactor: does not work. same object will be casted again and again.
    /**
     *
     * Casts a Collection to a List with TypeSafety.
     * 
     * @param clazz
     *            Class for type safety
     * @param obj
     *            The object to be casted.
     * @param <T>
     *            Type
     * @return List with casted collection
     */
    private static <T> List<IModel> castList(Class<? extends T> clazz, Object obj) {
        // Check it's an ArrayList
        List<IModel> list = new ArrayList<IModel>();
        if (obj instanceof ArrayList<?>) {
            // Get the List.
            ArrayList<?> al = (ArrayList<?>) obj;
            if (al.size() > 0) {
                // Iterate.
                for (int i = 0; i < al.size(); i++) {
                    Object o = al.get(0);
                    if (o instanceof Project) {
                        Project p = (Project) o;
                        list.add(p);
                    }
                    if (o instanceof Template) {
                        Template t = (Template) o;
                        list.add(t);
                    }
                    if (o instanceof Script) {
                        Script s = (Script) o;
                        list.add(s);
                    }
                }
            }
        }
        return list;
    }

    // /**
    // * Reads a script from an input stream.
    // *
    // * @param in the input stream to read the script definition from
    // * @return the instantiated script
    // */
    // public static final Script readVilXML(InputStream in) {
    // XStream xstream = createStream();
    // VilModel model = (VilModel) xstream.fromXML(in);
    // return model.getScript();
    // }
    //
    // /**
    // * Reads a template from an input stream.
    // *
    // * @param in the input stream to read the template definition from
    // * @return the instantiated template
    // */
    // public static final Template readVtlXML(InputStream in) {
    // XStream xstream = createStream();
    // VtlModel model = (VtlModel) xstream.fromXML(in);
    // return model.getTemplate();
    // }

    /**
     * Creates a stream instance for reading and writing.
     * 
     * @return the stream instance
     */
    private static final XStream createStream() {
        XStream xstream = new XStream();
        // xstream.alias("ivmlModel", IvmlModel.class);
        // xstream.alias("VtlModel", VtlModel.class);
        // xstream.alias("VilModel", VilModel.class);
        xstream.alias("model", Model.class);
        xstream.addImplicitCollection(Model.class, "models");
        xstream.registerConverter(new DelegatingTypeConverter());
        xstream.registerConverter(new OperationConverter());
        xstream.registerConverter(new TypeRegistryConverter());
        xstream.registerConverter(new VTLTypeConverter());
        xstream.registerConverter(new AdviceConverter());
//        xstream.registerConverter(new ContentExpressionConverter());
//        xstream.registerConverter(new ConstantValueConverter());
        return xstream;
    }

    /**
     * Defines the top level element in the XML.
     * 
     * @author Aike Sass
     */
    private static class Model {

        private List<IModel> models;

        /**
         * Creates the top-level wrapping instance.
         */
        public Model() {
            models = new ArrayList<IModel>();
        }

        /**
         * Adds an IModel to the list.
         * 
         * @param model
         *            the IModel that should be added
         */
        public void addModel(IModel model) {
            models.add(model);
        }

    }

    // /**
    // * Defines the top level element in the XML. In future versions this class
    // * may contain a file version information.
    // *
    // * @author Holger Eichelberger
    // */
    // private static class IvmlModel extends Model {
    //
    // /**
    // * The project to be persisted or read from a file.
    // */
    // private Project project;
    //
    // /**
    // * Creates the top-level wrapping instance.
    // *
    // * @param project the project to be contained
    // */
    // public IvmlModel(Project project) {
    // super(project);
    // }
    //
    // /**
    // * Returns the contained project instance.
    // *
    // * @return the contained project instance
    // */
    // public Project getProject() {
    // return project;
    // }
    // }

    // /**
    // * Defines the top level element in the XML. In future versions this class
    // * may contain a file version information.
    // *
    // * @author Aike Sass
    // */
    // private static class VilModel extends Model {
    //
    // /**
    // * The script to be persisted or read from a file.
    // */
    // private Script script;
    //
    //
    // /**
    // * Creates the top-level wrapping instance.
    // *
    // * @param script the script to be contained
    // */
    // public VilModel(Script script) {
    // super(script);
    // }
    //
    // /**
    // * Returns the contained script instance.
    // *
    // * @return the contained script instance
    // */
    // public Script getScript() {
    // return script;
    // }
    // }

    // /**
    // * Defines the top level element in the XML. In future versions this class
    // * may contain a file version information.
    // *
    // * @author Aike Sass
    // */
    // private static class VtlModel extends Model {
    //
    // /**
    // * The template to be persisted or read from a file.
    // */
    // private Template template;
    //
    // /**
    // * Creates the top-level wrapping instance.
    // *
    // * @param template the template to be contained
    // */
    // public VtlModel(Template template) {
    // super(template);
    // }
    //
    // /**
    // * Returns the contained template instance.
    // *
    // * @return the contained template instance
    // */
    // public Template getTemplate() {
    // return template;
    // }
    // }

}
