package net.ssehub.easy.instantiation.serializer.xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.io.FilenameUtils;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.CompactWriter;
import com.thoughtworks.xstream.mapper.MapperWrapper;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.basics.modelManagement.IModel;
import net.ssehub.easy.instantiation.serializer.xml.Bundle;
import net.ssehub.easy.instantiation.serializer.xml.converter.AdviceConverter;
import net.ssehub.easy.instantiation.serializer.xml.converter.ClassWrapperConverter;
import net.ssehub.easy.instantiation.serializer.xml.converter.DelegatingTypeConverter;
import net.ssehub.easy.instantiation.serializer.xml.converter.EnumValueConverter;
import net.ssehub.easy.instantiation.serializer.xml.converter.IVMLTypeDescriptorConverter;
import net.ssehub.easy.instantiation.serializer.xml.converter.IvmlComparisonOperationDescriptorConverter;
import net.ssehub.easy.instantiation.serializer.xml.converter.NullValueConverter;
import net.ssehub.easy.instantiation.serializer.xml.converter.NullValueTypeConverter;
import net.ssehub.easy.instantiation.serializer.xml.converter.OperationConverter;
import net.ssehub.easy.instantiation.serializer.xml.converter.ProjectConverter;
import net.ssehub.easy.instantiation.serializer.xml.converter.ReflectionOperationDescriptorConverter;
import net.ssehub.easy.instantiation.serializer.xml.converter.ReflectionTypeDescriptorConverter;
import net.ssehub.easy.instantiation.serializer.xml.converter.TypeRegistryConverter;
import net.ssehub.easy.instantiation.serializer.xml.converter.VTLTypeConverter;
import net.ssehub.easy.instantiation.serializer.xml.mapper.ClassNameAliasingMapper;

/**
 * Supports storing projects (and referenced projects) into XML format. Please note that the XML format is intended for
 * temporary storage of models, in particular in environments where xText or Eclipse dependency must not be used.
 * Further, this class does not rely on {@link net.ssehub.easy.varModel.management.VarModel}, i.e. the related
 * mechanisms, loaders and listeners there are not considered by this class (this would require a specific XML loader).
 * [req SAP, TUV]
 * 
 * @author Holger Eichelberger, Aike Sass
 */
public class XmlIo {

    public static final Map<String, String> CLASSES = new HashMap<String, String>();
    
    protected static EASyLogger logger = EASyLoggerFactory.INSTANCE.getLogger(XmlIo.class,
            Bundle.ID);
    
    /**
     * Writes a list of {@link IModel} to the given output stream.
     * 
     * IF YOU WANT TO WRITE IVML THEN CALL {@link #isIvmlFile()} TO DISABLE CERTAIN
     * CONVERTERS!
     * 
     * @param list
     *            the list to be written
     * @param target
     *            the target where to write the list to
     * @param isIvmlFile switch to enable specific converter
     * @throws IOException 
     */
    public static final void write(List<IModel> list, File target, boolean isIvmlFile) throws IOException {
        XStream xStream = createStream();
        if (!isIvmlFile) {
            xStream.registerConverter(new ProjectConverter());
        }
        // PRODUCTION
        Writer writer = null;
        FileOutputStream out =  null;
        try {
            out = new FileOutputStream(target);
            writer = new OutputStreamWriter(out, "UTF-8");
            xStream.marshal(list, new CompactWriter(writer));
            printMap(CLASSES, target);
        } catch (UnsupportedEncodingException e) {
            logger.exception(e);
        } finally {
            if (null != out) {
                out.close();
                writer.close();
            }
        }
        // FOR DEBUGGING ONLY: This will print the xml with pretty printing. 
        //         xStream.toXML(list, out);
    }

    /**
     * Print map to properties file.
     * 
     * @param classes map to be printed
     * @param target target
     * @throws IOException 
     */
    private static void printMap(Map<String, String> classes, File target) throws IOException {
        Properties properties = new Properties();
        for (Map.Entry<String, String> entry : CLASSES.entrySet()) {
            properties.put(entry.getKey(), entry.getValue());
        }
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(new File(target.getParent(), 
                FilenameUtils.removeExtension(target.getName()) + ".properties"));
            properties.store(out, null);
        } catch (FileNotFoundException e) {
            logger.exception(e);
        } catch (IOException e) {
            logger.exception(e);
        } finally {
            if (null != out) {
                out.close();
            }
        }
    }
    
    /**
     * Read map from properties file.
     * @param target target file
     * @throws IOException 
     */
    private static void readMap(File target) throws IOException {
        Properties properties = new Properties();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(new File(target.getParent(), 
                FilenameUtils.removeExtension(target.getName()) + ".properties"));
            properties.load(fis);
        } catch (FileNotFoundException e) {
            logger.exception(e);
        } catch (IOException e) {
            logger.exception(e);
        } finally {
            if (null != fis) {
                fis.close();
            }
        }
        for (String key : properties.stringPropertyNames()) {
            CLASSES.put(key, properties.get(key).toString());
        }
    }

    /**
     * Reads a list of {@link IModel} from an input stream.
     * 
     * IF YOU WANT TO WRITE IVML THEN CALL {@link #isIvmlFile()} TO DISABLE CERTAIN
     * CONVERTERS!
     * 
     * @param source
     *            the source to read the project definition from
     * @param isIvmlFile switch to enable specific converter
     * @return the instantiated IModel
     * @throws IOException 
     */
    @SuppressWarnings("unchecked")
    public static final List<IModel> read(File source, boolean isIvmlFile) throws IOException {
        List<IModel> list = null;
        InputStream in = null;
        try {
            in = new FileInputStream(source);
            readMap(source);
            XStream xstream = createStream();
            if (!isIvmlFile) {
                xstream.registerConverter(new ProjectConverter());
            }
            list = (List<IModel>) xstream.fromXML(in);
            if (null == list) {
                logger.warn("List is null");
            }
        } finally {
            if (null != in) {
                in.close();
            }
        }
        return list;
    }

    /**
     * Creates a stream instance for reading and writing.
     * 
     * @return the stream instance
     */
    private static final XStream createStream() {
        XStream xstream = new XStream() {
            @Override
            protected MapperWrapper wrapMapper(MapperWrapper next) {
                return new ClassNameAliasingMapper(next);
            }
        };
        xstream.setMode(XStream.ID_REFERENCES);
        xstream.alias("model", Model.class);
        xstream.addImplicitCollection(Model.class, "models");
        xstream.registerConverter(new DelegatingTypeConverter());
        xstream.registerConverter(new EnumValueConverter());
        xstream.registerConverter(new OperationConverter());
        xstream.registerConverter(new TypeRegistryConverter());
        xstream.registerConverter(new VTLTypeConverter());
        xstream.registerConverter(new AdviceConverter());
        xstream.registerConverter(new NullValueTypeConverter());
        xstream.registerConverter(new NullValueConverter());
        xstream.registerConverter(new ReflectionOperationDescriptorConverter());
        xstream.registerConverter(new ReflectionTypeDescriptorConverter());
        xstream.registerConverter(new IVMLTypeDescriptorConverter());
        xstream.registerConverter(new IvmlComparisonOperationDescriptorConverter());
        xstream.registerConverter(new ClassWrapperConverter());
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
        @SuppressWarnings("unused")
        public Model() {
            models = new ArrayList<IModel>();
        }

        /**
         * Adds an IModel to the list.
         * 
         * @param model
         *            the IModel that should be added
         */
        @SuppressWarnings("unused")
        public void addModel(IModel model) {
            models.add(model);
        }

    }

}
