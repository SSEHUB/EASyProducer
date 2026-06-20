package net.ssehub.easy.instantiation.java.artifacts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.instantiation.core.model.artifactModel.ArtifactCreator;
import net.ssehub.easy.instantiation.core.model.artifactModel.ArtifactFactory;
import net.ssehub.easy.instantiation.core.model.artifactModel.ArtifactModel;
import net.ssehub.easy.instantiation.core.model.artifactModel.FileArtifact;
import net.ssehub.easy.instantiation.core.model.artifactModel.FileTracker;
import net.ssehub.easy.instantiation.core.model.artifactModel.IFileSystemArtifact;
import net.ssehub.easy.instantiation.core.model.artifactModel.Path;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.Conversion;
import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;
import net.ssehub.easy.instantiation.core.model.vilTypes.ListSet;
import net.ssehub.easy.instantiation.core.model.vilTypes.Map;
import net.ssehub.easy.instantiation.core.model.vilTypes.Set;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;
import net.ssehub.easy.instantiation.java.Bundle;
import net.ssehub.easy.instantiation.java.codeArtifacts.JavaCodeArtifact;

/**
 * Represents a Java properties file.
 * 
 * @author Holger Eichelberger, Sass
 */
@ArtifactCreator(PropertiesArtifactCreator.class)
public class PropertiesFileArtifact extends FileArtifact {

    private Properties data;
    private File file;
    private String comment = null;
    
    /**
     * Creates a new class file artifact.
     * 
     * @param file the file to read the artifact contents from
     * @param model the artifact model to create this folder artifact within
     */
    public PropertiesFileArtifact(File file, ArtifactModel model) {
        super(file, model);
        this.file = file;
        data = new Properties();
        if (file.exists()) {
            try (FileInputStream fis = new FileInputStream(file)) {
                if (file.getName().endsWith(".xml")) {
                    data.loadFromXML(fis);
                } else {
                    data.load(fis);
                }
            } catch (IOException e) {
                EASyLoggerFactory.INSTANCE.getLogger(JavaCodeArtifact.class, Bundle.ID).error(e.getMessage());
            }
        }
    }
    
    /**
     * Conversion operation.
     * 
     * @param val the value to be converted
     * @return the converted value
     * @throws VilException in case that creating the artifact fails
     */
    @Invisible
    @Conversion
    public static FileArtifact convert(String val) throws VilException {
        Path path = Path.convert(val);
        return ArtifactFactory.createArtifact(PropertiesFileArtifact.class, path.getAbsolutePath(), 
            path.getArtifactModel());
    }
    
    /**
     * Conversion operation.
     * 
     * @param val the value to be converted
     * @return the converted value
     */
    @Invisible
    @Conversion
    public static PropertiesFileArtifact convert(IFileSystemArtifact val) {
        PropertiesFileArtifact convertedValue = null;
        if (val instanceof PropertiesFileArtifact) {
            convertedValue = (PropertiesFileArtifact) val;
        } else if (val instanceof FileArtifact) {
            FileArtifact fa = (FileArtifact) val;
            try {
                convertedValue = ArtifactFactory.createArtifact(
                    PropertiesFileArtifact.class, fa.getPath().getAbsolutePath(), null);
                fa.setEnableContentStore(false); // decisions are made based on the original artifact
            } catch (VilException e) {
                EASyLoggerFactory.INSTANCE.getLogger(JavaCodeArtifact.class, Bundle.ID).error(e.getMessage());
            }
        }
        return convertedValue;
    } 
    
    /**
     * Conversion operation.
     * 
     * @param path
     *            the path to be converted
     * @return the converted value
     * @throws VilException
     *             in case that creating the artifact fails
     */
    @Invisible
    @Conversion
    public static PropertiesFileArtifact convert(Path path) throws VilException {
        return ArtifactFactory.createArtifact(PropertiesFileArtifact.class, path.getAbsolutePath(), 
            path.getArtifactModel());
    }

    @Invisible
    @Conversion
    public static PropertiesFileArtifact convert(JavaFileArtifact val) {
        return convert((IFileSystemArtifact) val);
    } 
    
    /**
     * Actual, unconditional implementation of {@link #prepare()}. {@link FileTracker} notification and file deletion
     * happens in {@link #prepare()}.
     */
    protected void prepareImpl() {
        data = null;
    }    

    @Override
    public void store() throws VilException {
        super.store();
        if (null != data) {
            try (FileOutputStream fis = new FileOutputStream(file)) {
                if (file.getName().endsWith(".xml")) {
                    data.storeToXML(fis, comment);
                } else {
                    data.store(fis, comment);
                }
                FileTracker.stored(getPath());
            } catch (IOException e) {
                EASyLoggerFactory.INSTANCE.getLogger(JavaCodeArtifact.class, Bundle.ID).error(e.getMessage());
            }
        }
    }
    
    /**
     * Forces storing this artifact.
     * 
     * @throws VilException
     */
    public void save() throws VilException {
        store();
    }

    @Invisible
    @Override
    public boolean enableAutoStore() {
        return true;
    }    

    /**
     * Returns the comment.
     * 
     * @return the comment, <b>null</b> for none
     */
    public String getComment() {
        return comment;
    }
    
    /**
     * Sets the comment.
     * 
     * @param comment the comment, <b>null</b> for none
     */
    public void setComment(String comment) {
        this.comment = comment;
    }
    
    /**
     * Lazily initializes the initial data structure.
     */
    private void initLazy() {
        if (null == data) {
            data = new Properties();
        }
    }

    /**
     * Sets a single value.
     * 
     * @param key the key to set the value for
     * @param value the value to set
     */
    public void setValue(String key, String value) {
        initLazy();
        data.setProperty(key, value);
    }
    
    /**
     * Returns whether there is a value for the specified {@code key}.
     * 
     * @param key the key to return the value for
     * @return {@code true} if there is a value, {@code false}
     */
    public boolean hasValue(String key) {
        return data == null ? false : data.containsKey(key);
    }
    
    /**
     * Returns the value for the specified {@code key}.
     * 
     * @param key the key to return the value for
     * @return the value or <b>null</b>
     */
    public String getValue(String key) {
        return data == null ? null : data.getProperty(key);
    }

    /**
     * Returns the value for the specified {@code key}.
     * 
     * @param key the key to return the value for
     * @param dflt value to be returned if there is no such value
     * @return the value or {@code dflt}
     */
    public String getValue(String key, String dflt) {
        return data == null ? dflt : data.getProperty(key, dflt);
    }
    
    /**
     * Sets/add values in the properties file.
     * 
     * @param values the values
     */
    public void setValues(Map<Object, Object> values) {
        initLazy();
        for (Object k: values.getKeys()) {
            Object v = values.get(k);
            if (null != v) {
                data.setProperty(k.toString(), v.toString());
            }
        }
    }
    
    /**
     * Returns all values in the properties file.
     * 
     * @return the values
     */
    public Map<Object, Object> getValues() {
        TypeDescriptor<?>[] params = TypeDescriptor.createArray(2);
        params[0] = TypeRegistry.stringType();
        params[1] = TypeRegistry.stringType();
        Map<Object, Object> result = new Map<Object, Object>(params);
        if (null != data) {
            for (Object k : data.keySet()) {
                Object v = data.get(k);
                if (null != v) {
                    result.put(k.toString(), v.toString());
                }
            }
        }
        return result;
    }
    
    /**
     * Returns the keys.
     * 
     * @return the key
     */
    public Set<Object> getKeys() {
        List<Object> result = new ArrayList<>();
        if (null != data) {
            for (Object k: data.keySet()) {
                result.add(k.toString());
            }
        }
        return new ListSet<Object>(result, TypeRegistry.stringType());
    }
    
    /**
     * Returns the number of keys/size of the data structure.
     * 
     * @return the size
     */
    public int size() {
        return data == null ? 0 : data.size();
    }

    /**
     * Clears the data.
     */
    public void clear() {
        if (null != data) {
            data.clear();
        }
    }

}
