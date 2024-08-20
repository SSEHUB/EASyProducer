package net.ssehub.easy.producer.core.persistence.datatypes;

import java.util.LinkedHashMap;

import net.ssehub.easy.producer.core.persistence.internal.util.FileUtils;

/**
 * This class represents the entities for the persistency data-model.
 *
 * @author Kapeluch
 * @since 25.08.2011
 */
public class Entity {

    private LinkedHashMap<String, String> attributes;

    /**
     * Default constructor.
     */
    public Entity() {
        setAttributes(new LinkedHashMap<String, String>());
    }

    /**
     * Creates a new attribute for this entity.
     * 
     * @param name The name of the attribute
     * @param parameter The value of the attribute
     */
    public void createAttribute(String name, String parameter) {
        if (parameter != null) {
            attributes.put(name, parameter);
        }
    }

    /**
     * Returns the attribute-map.
     * 
     * @return The LinkedHashMap containing all attributes
     */
    public LinkedHashMap<String, String> getAttributes() {
        return attributes;
    }

    /**
     * Sets the attribute-map.
     * 
     * @param attributes The attribute-map as LinkedHashMap
     */
    public void setAttributes(LinkedHashMap<String, String> attributes) {
        this.attributes = attributes;
    }

    /**
     * Returns value of given attribute.
     * 
     * @param attribute The name of the attribute which value should be returned
     * @return The value of the attribute or <code>null</code> if the specified attribute does not exist.
     */
    public String getAttributeValue(String attribute) {
        return getAttributeValue(attribute, null);
    }
    
    /**
     * Returns value of given attribute.
     * 
     * @param attribute The name of the attribute which value should be returned
     * @param dflt the default value
     * @return The value of the attribute or <code>dflt</code> if the specified attribute does not exist.
     */
    public String getAttributeValue(String attribute, String dflt) {
        String result = dflt;
        if (attributes.containsKey(attribute)) {
            result = attributes.get(attribute);
        }
        return result;
    }

    /**
     * Returns the value of a given attribute as file string (considering internal conversion conventions).
     * 
     * @param attribute the attribute to return
     * @return The value of the attribute or <code>null</code> if the specified attribute does not exist.
     */
    public String getAttributeFileString(String attribute) {
        return FileUtils.fromIndependent(getAttributeValue(attribute));
    }

    /**
     * Creates a new attribute for this file entity (considering internal conversion conventions).
     * 
     * @param name The name of the attribute
     * @param parameter The value of the attribute
     */
    public void createAttributeFileString(String name, String parameter) {
        createAttribute(name, FileUtils.toIndependent(parameter));
    }

}
