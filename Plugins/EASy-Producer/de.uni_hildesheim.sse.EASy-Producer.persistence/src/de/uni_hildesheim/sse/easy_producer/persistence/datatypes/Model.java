package de.uni_hildesheim.sse.easy_producer.persistence.datatypes;

import java.util.ArrayList;

/**
 * Objects of this class stores information related to exactly one model.
 * Supported models are:
 * <ul>
 * <li>Information, which ivml model should be loaded</li>
 * <li>Transformer settings</li>
 * <li>Related projects</li>
 * <li>Configured Binding Times</li>
 * </ul>
 * @author El-Sharkawy
 */
public class Model {
    private ModelType modelType;
    private ArrayList<Entity> entities;

    /**
     * Sole constructor for this class.
     * @param modelType The type of information, which should be stored.
     */
    public Model(ModelType modelType) {
        this.modelType = modelType;
        entities = new ArrayList<Entity>();
    }

    /**
     * Returns which kind of model/information are stored in this simple representation.
     * @return The type of information represented by this model object.
     */
    public ModelType getModelType() {
        return modelType;
    }

    /**
     * Returns an entity specified by <code>index</code>.
     * 
     * @param index a 0-based index specifying entity to be returned
     * @return all existing entities of this model
     * @throws IndexOutOfBoundsException if the index is out of range
     *         (<tt>index &lt; 0 || index &gt;= size()</tt>)
     */
    public Entity getEntity(int index) {       
        return entities.get(index);
    }

    /**
     * Returns the number of entities.
     * 
     * @return the number of entities.
     */
    public int getEntityCount() {
        return entities.size() > 0 ? entities.size() : -1;
    }

    /**
     * Method for adding one new entity to this model. 
     * @param entity The entity, which should be added to this model.
     */
    public void addEntity(Entity entity) {
        entities.add(entity);
    }

}
