package de.uni_hildesheim.sse.easy_producer.instantiator.velocity;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.ParseErrorException;

import de.uni_hildesheim.sse.easy_producer.instantiator.InstantiatorEngine;
import de.uni_hildesheim.sse.easy_producer.instantiator.InstantiatorException;
import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;

/**
 * Abstract super class for all instantiators, which use velocity.<br/>
 * This class is responsible for the correct handling of decision variables and values
 * using the velocity context concept.
 * @author El-Sharkawy
 * @since 02.05.2012
 * @see VelocityTransformatorEngine
 */
public abstract class AbstractVelocityIntantiatorEngine extends InstantiatorEngine {
    // the velocity engine used
    private VelocityEngine engine;

    // the context for this velocity engine
    private VelocityContext context;
    
    /**
     * Sole constructor for this class.<br/>
     * Creates the context for the instantiation process.
     */
    protected AbstractVelocityIntantiatorEngine() {
        super();
        engine = Utils.createVelocityEngine();
    }
    
    /**
     * Getter for the velocity context, where variables and values must be isnerted for the intantiation process.
     * @return The velocity context
     */
    protected final VelocityContext getVelocityContext() {
        return context;
    }
    

    @Override
    public final void instantiate() throws InstantiatorException {
        for (File file : getFilesToInstantiate()) {
            String path = file.getAbsolutePath();

            StringWriter writer = null;
            try {
                Template t = engine.getTemplate(path);
                writer = new StringWriter();
                t.merge(context, writer);
            } catch (ParseErrorException e) {
                StringBuffer errorMsg = new StringBuffer("Parse error in\n");
                errorMsg.append(e.getTemplateName());
                errorMsg.append("[line ");
                errorMsg.append(e.getLineNumber());
                errorMsg.append(", column ");
                errorMsg.append(e.getColumnNumber());
                errorMsg.append("]\n");
                String detailedMsg = e.getLocalizedMessage();
                int start = detailedMsg.indexOf("\n");
                //Remove first line of VelocityMessage and append it to the current message
                errorMsg.append(detailedMsg.substring(start + 1));
                throw new InstantiatorException(errorMsg.toString());
            } catch (Exception e) {
                e.printStackTrace();
                throw new InstantiatorException(e.getLocalizedMessage());
            }

            Writer fileWriter = null;

            try {
                fileWriter = new FileWriter(file);
                fileWriter.write(writer.toString());
            } catch (IOException e) {
                e.printStackTrace();
                throw new InstantiatorException(e.getLocalizedMessage());
            } finally {
                if (fileWriter != null) {
                    try {
                        fileWriter.close();
                    } catch (IOException e) {
                    }
                }
            }
        }
    }
    
    @Override
    protected final void initEngine() {      
        prepareContext();
    }
    
    @Override
    protected final void clearContext() {
        context = new VelocityContext();
    }
    
    @Override
    protected void addValue2Context(IDecisionVariable variable) {
        VelocityContextInitializer initializer = new VelocityContextInitializer(variable);
        List<VelocityContextItem> items = initializer.getItems();
        
        for (int i = 0; i < items.size(); i++) {
            context.put(items.get(i).getName(), items.get(i).getValue());
        }
    }
    
    /**
     * This method should insert a string value to the instantiator context.
     * This method is part of the {@link #addValue2Context(IDecisionVariable)}.
     * @param stringVariable The string value, which should be added to the context.
     * @see #addValue2Context(IDecisionVariable)
     */
    protected abstract void addStringValue2Context(IDecisionVariable stringVariable); 
}
