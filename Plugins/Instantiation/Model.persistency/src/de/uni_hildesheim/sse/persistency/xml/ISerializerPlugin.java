package de.uni_hildesheim.sse.persistency.xml;

import java.io.File;
import java.util.List;

import net.ssehub.easy.basics.modelManagement.IModel;
import net.ssehub.easy.basics.modelManagement.IModelLoader;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;

/**
 * Interface for the SerializerPlugin that adds the functionality of serializing runtime VIL.
 * 
 * @author Sass
 * @param <M>
 *
 */
public interface ISerializerPlugin<M extends IModel> {
    
    /**
     * Method for serializing runtime VIL.
     * 
     * @param source    Source folder of the model
     * @param modelList list containing all loaded models
     */
    public void serialize(File source, List<IModel> modelList);
    
    /**
     * Deserializes the model from a XML file.
     * 
     * @param file  The XML file containing the model.
     */
    public void deserialize(File file);
    
    /**
     * Get the identifier for the type registry.
     * 
     * @param typeRegistry typeRegistry
     * @return identifier as string
     */
    public String getTypeRegistryIdentifier(TypeRegistry typeRegistry);
    
    /**
     * Creates a typeRegistry.
     * 
     * @param identifier identifier of the type registry
     * @return created TypeRegistry
     */
    public TypeRegistry createTypeRegistry(String identifier);

    /**
     * Getter for the model loader.
     * 
     * @return the model loader of the plugin
     */
    public IModelLoader<?> getModelLoader();

    /**
     * Getter for the RtVilTypeRegistry.
     * 
     * @return the RtVilTypeRegistry
     */
    public TypeRegistry getRtVilTypeRegistry();

    /** 
     * Getter for all RtVil classes.
     * 
     * @return array with specific rtvil classes
     */
    public Class<?>[] getRtVilClasses();

}
