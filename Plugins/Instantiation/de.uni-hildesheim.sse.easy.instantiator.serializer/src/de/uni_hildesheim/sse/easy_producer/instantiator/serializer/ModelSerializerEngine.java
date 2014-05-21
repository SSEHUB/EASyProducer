package de.uni_hildesheim.sse.easy_producer.instantiator.serializer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.osgi.service.component.ComponentContext;

import de.uni_hildesheim.sse.easy_producer.instantiator.InstantiatorEngine;
import de.uni_hildesheim.sse.easy_producer.instantiator.InstantiatorException;
import de.uni_hildesheim.sse.easy_producer.instantiator.Transformator;
import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;
import de.uni_hildesheim.sse.persistency.xml.XmlIo;

/**
 * The model serialization transformator engine implementation.
 * 
 * @author Holger Eichelberger
 */
public class ModelSerializerEngine extends InstantiatorEngine {

    private static final String MODELNAME = "model";
    private static final String FILETYPE = ".xml";

    /**
     * Creates an instance of this engine.
     */
    public ModelSerializerEngine() {
        // required by DS
    }
    
    /**
     * Private method to activate plugin.
     * @param context Context.
     */
    protected void activate(ComponentContext context) {
        // this is not the official way of using DS but the official way is instable
        Transformator.addEngine(this);
    }

    /**
     * Private method to to de-activate plugin.
     * @param context Context.
     */
    protected void deactivate(ComponentContext context) {
        // this is not the official way of using DS but the official way is instable
        Transformator.removeEngine(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initEngine() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void instantiate() throws InstantiatorException {
        try {
            File easyDir = getPLP().getConfigLocation();
            File modelFile = new File(easyDir, MODELNAME + FILETYPE);
            XmlIo.write(getPLP().getConfiguration().getProject(), new FileOutputStream(modelFile));
        } catch (IOException e) {
            throw new InstantiatorException(e.getLocalizedMessage());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void clearContext() {
    }

    @Override
    protected void addValue2Context(IDecisionVariable variable) {
        // TODO Auto-generated method stub
        
    }

}