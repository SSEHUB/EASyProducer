package de.uni_hildesheim.sse.easy_producer.instantiator.velocity;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.ParseErrorException;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.ArtifactFactory;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.FileArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.Path;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArraySet;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArtifactException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Collection;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Instantiator;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Map;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Set;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.StringValueHelper;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration.Configuration;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration.DecisionVariable;
import de.uni_hildesheim.sse.instantiator.velocitylib.Utils;
import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;

/**
 * A VIL instantiator for velocity.
 * 
 * @author Holger Eichelberger
 */
@Instantiator("velocity")
public class VelocityInstantiator implements IVilType {

    /**
     * Instantiates a collection of file artifacts using the given <code>configuration</code>.
     * 
     * @param templates the templates to be instantiated
     * @param config the configuration to be considered
     * @return the modified artifacts
     * @throws ArtifactException in case that instantiation fails
     */
    public static Set<FileArtifact> velocity(Collection<FileArtifact> templates, Configuration config) 
        throws ArtifactException {
        return velocity(templates, config, null);
    }
    
    /**
     * Instantiates a collection of file artifacts using the given <code>configuration</code>.
     * 
     * @param templates the templates to be instantiated
     * @param config the configuration to be considered
     * @param nameMapping an optional mapping from IVML names to names used in the target artifact(s)
     * @return the modified artifacts
     * @throws ArtifactException in case that instantiation fails
     */
    public static Set<FileArtifact> velocity(Collection<FileArtifact> templates, Configuration config, 
        Map<?, ?> nameMapping) throws ArtifactException {
        VelocityEngine engine = createEngine();
        VelocityContext context = createContext(config, nameMapping);
        List<FileArtifact> tmp = new ArrayList<FileArtifact>();
        Iterator<FileArtifact> iter = templates.iterator();
        while(iter.hasNext()) {
            tmp.add(instantiate(iter.next(), engine, context));
        }
        FileArtifact[] result = new FileArtifact[tmp.size()];
        tmp.toArray(result);
        return new ArraySet<FileArtifact>(result, FileArtifact.class);
    }
    
    /**
     * Creates the velocity engine with local configuration.
     * 
     * @return the actual velocity engine instance
     */
    private static VelocityEngine createEngine() {
        Properties prop = new Properties();
        Utils.disableLogging(prop);
        return Utils.createVelocityEngine(prop);
    }

    /**
     * Instantiates a single file artifact using the given <code>configuration</code>.
     * 
     * @param template the template to be instantiated
     * @param config the configuration to be considered
     * @return the modified artifact
     * @throws ArtifactException in case that instantiation fails
     */
    public static Set<FileArtifact> velocity(Path template, Configuration config) throws ArtifactException {
        return velocity(template, config, null);
    }
    
    /**
     * Instantiates a single file artifact using the given <code>configuration</code>.
     * 
     * @param template the template to be instantiated
     * @param config the configuration to be considered
     * @param nameMapping an optional mapping from IVML names to names used in the target artifact(s)
     * @return the modified artifact
     * @throws ArtifactException in case that instantiation fails
     */
    public static Set<FileArtifact> velocity(Path template, Configuration config, Map<?, ?> nameMapping) 
        throws ArtifactException {
        Set<FileArtifact> result;
//        Path templatePath = template.getPath();
        if (template.isPattern()) {
            result = velocity(template.selectAll(), config, nameMapping);
        } else {
            VelocityEngine engine = createEngine();
            VelocityContext context = createContext(config, nameMapping);
            FileArtifact[] tmp = new FileArtifact[1];
            FileArtifact templateArtifact 
                = ArtifactFactory.createArtifact(FileArtifact.class, template.getAbsolutePath(), template.getArtifactModel());
            tmp[0] = instantiate(templateArtifact, engine, context);
            result = new ArraySet<FileArtifact>(tmp, FileArtifact.class);
        }
        return result;
    }
    
    /**
     * Creates the velocity context.
     * 
     * @param config the configuration to create the context from
     * @return the velocity context
     */
    private static final VelocityContext createContext(Configuration config, Map<?, ?> nameMapping) {
        VelocityContext context = new VelocityContext();
        for (DecisionVariable var : config.variables()) { // TODO check with original version
            IDecisionVariable dVar = var.getDecisionVariable();
            VelocityContextInitializer initializer = new VelocityContextInitializer(dVar);
            List<VelocityContextItem> items = initializer.getItems();
            for (int i = 0; i < items.size(); i++) {
                String name = items.get(i).getName();
                if (null != nameMapping) {
                    Object tmp = nameMapping.get(name);
                    if (null != tmp) {
                        name = StringValueHelper.getStringValue(tmp, null);
                    }
                }
                context.put(name, items.get(i).getValue());
            }
        }
        return context;
    }
    
    /**
     * Instantiate a single file artifact.
     * @param template the template to instantiate
     * @param engine the engine for instantiation
     * @param context the velocity context
     * @return the created file artifact
     * @throws ArtifactException
     */
    private static final FileArtifact instantiate(FileArtifact template, VelocityEngine engine, 
        VelocityContext context) throws ArtifactException {
        File file = template.getPath().getAbsolutePath();
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
            throw new ArtifactException(errorMsg.toString(), ArtifactException.ID_IO);
        } catch (Exception e) {
            EASyLoggerFactory.INSTANCE.getLogger(VelocityInstantiator.class, "velocity").exception(e);
            throw new ArtifactException(e.getLocalizedMessage(), ArtifactException.ID_IO);
        }

        Writer fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            fileWriter.write(writer.toString());
        } catch (IOException e) {
            EASyLoggerFactory.INSTANCE.getLogger(VelocityInstantiator.class, "velocity").exception(e);
            throw new ArtifactException(e.getLocalizedMessage(), ArtifactException.ID_IO);
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                }
            }
        }
        return template;
    }
    
}
