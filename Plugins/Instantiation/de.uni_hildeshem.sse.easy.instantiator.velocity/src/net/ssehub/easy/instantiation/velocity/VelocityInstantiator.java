/*
 * Copyright 2009-2015 University of Hildesheim, Software Systems Engineering
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.ssehub.easy.instantiation.velocity;

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
import org.osgi.service.component.ComponentContext;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.instantiation.core.model.artifactModel.ArtifactFactory;
import net.ssehub.easy.instantiation.core.model.artifactModel.FileArtifact;
import net.ssehub.easy.instantiation.core.model.artifactModel.Path;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.ArraySet;
import net.ssehub.easy.instantiation.core.model.vilTypes.Collection;
import net.ssehub.easy.instantiation.core.model.vilTypes.IRegistration;
import net.ssehub.easy.instantiation.core.model.vilTypes.IVilType;
import net.ssehub.easy.instantiation.core.model.vilTypes.Instantiator;
import net.ssehub.easy.instantiation.core.model.vilTypes.Map;
import net.ssehub.easy.instantiation.core.model.vilTypes.Set;
import net.ssehub.easy.instantiation.core.model.vilTypes.StringValueHelper;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.Configuration;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.DecisionVariable;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;

/**
 * A VIL instantiator for velocity.
 * 
 * @author Holger Eichelberger
 * @author Sascha El-Sharkawy
 */
@Instantiator("velocity")
public class VelocityInstantiator implements IVilType, IRegistration {
    
    private static boolean registered = false;
    
    /**
     * Registers the Java artifacts and instantiators.
     */
    public static final void register() {
        if (!registered) {
            registered = true;
            TypeRegistry.DEFAULT.register(VelocityInstantiator.class);
        }
    }
    
    /**
     * Private method to activate plugin.
     * @param context Context.
     */
    protected void activate(ComponentContext context) {
        // this is not the official way of using DS but the official way is instable
        register();
    }

    /**
     * Private method to to de-activate plugin.
     * @param context Context.
     */
    protected void deactivate(ComponentContext context) {
        // this is not the official way of using DS but the official way is instable
    }
    
    /**
     * Instantiates a collection of file artifacts using the given <code>configuration</code>.
     * 
     * @param templates the templates to be instantiated
     * @param config the configuration to be considered
     * @return the modified artifacts
     * @throws VilException In case that instantiation fails
     */
    public static Set<FileArtifact> velocity(Collection<FileArtifact> templates, Configuration config) 
        throws VilException {
        return velocity(templates, config, null);
    }
    
    /**
     * Instantiates a collection of file artifacts using the given <code>configuration</code>.
     * 
     * @param templates the templates to be instantiated
     * @param config the configuration to be considered
     * @param nameMapping an optional mapping from IVML names to names used in the target artifact(s)
     * @return the modified artifacts
     * @throws VilException in case that instantiation fails
     */
    public static Set<FileArtifact> velocity(Collection<FileArtifact> templates, Configuration config, 
        Map<?, ?> nameMapping) throws VilException {
        VelocityEngine engine = createEngine();
        VelocityContext context = createContext(config, nameMapping);
        List<FileArtifact> tmp = new ArrayList<FileArtifact>();
        Iterator<FileArtifact> iter = templates.iterator();
        while (iter.hasNext()) {
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
        // Disable logging
        Properties properties = new Properties();
        properties.put("runtime.log.logsystem.class", "org.apache.velocity.runtime.log.NullLogSystem");
        
        // Configure Velocity
        VelocityEngine engine = new VelocityEngine();
        properties.put("resource.loader", "file");
        properties.put("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.FileResourceLoader");
        properties.put("file.resource.loader.path", "");
        
        //checkstyle: stop exception type check 
        try {
            engine.init(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //checkstyle: resume exception type check 
        
        return engine;
    }

    /**
     * Instantiates a single file artifact using the given <code>configuration</code>.
     * 
     * @param template the template to be instantiated
     * @param config the configuration to be considered
     * @return the modified artifact
     * @throws VilException in case that instantiation fails
     */
    public static Set<FileArtifact> velocity(Path template, Configuration config) throws VilException {
        return velocity(template, config, null);
    }
    
    /**
     * Instantiates a single file artifact using the given <code>configuration</code>.
     * 
     * @param template the template to be instantiated
     * @param config the configuration to be considered
     * @param nameMapping an optional mapping from IVML names to names used in the target artifact(s)
     * @return the modified artifact
     * @throws VilException in case that instantiation fails
     */
    public static Set<FileArtifact> velocity(Path template, Configuration config, Map<?, ?> nameMapping) 
        throws VilException {
        Set<FileArtifact> result;
        if (template.isPattern()) {
            result = velocity(template.selectAll(), config, nameMapping);
        } else {
            VelocityEngine engine = createEngine();
            VelocityContext context = createContext(config, nameMapping);
            FileArtifact[] tmp = new FileArtifact[1];
            FileArtifact templateArtifact 
                = ArtifactFactory.createArtifact(FileArtifact.class, template.getAbsolutePath(),
                    template.getArtifactModel());
            tmp[0] = instantiate(templateArtifact, engine, context);
            result = new ArraySet<FileArtifact>(tmp, FileArtifact.class);
        }
        return result;
    }
    
    /**
     * Creates the velocity context.
     * 
     * @param config the configuration to create the context from
     * @param nameMapping an optional mapping from IVML names to names used in the target artifact(s)
     * @return the velocity context
     */
    private static final VelocityContext createContext(Configuration config, Map<?, ?> nameMapping) {
        
        VelocityContext context = new VelocityContext();
        for (DecisionVariable var : config.variables()) {
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
                Object value = items.get(i).getValue();
                if (null != value) {
                    context.put(name, items.get(i).getValue());
                }
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
     * @throws VilException in case of problems
     */
    private static final FileArtifact instantiate(FileArtifact template, VelocityEngine engine, 
        VelocityContext context) throws VilException {
        File file = template.getPath().getAbsolutePath();
        String path = file.getAbsolutePath();
        StringWriter writer = null;
        
        //checkstyle: stop exception type check 
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
            throw new VilException(errorMsg.toString(), VilException.ID_IO);
        } catch (Exception e) {
            EASyLoggerFactory.INSTANCE.getLogger(VelocityInstantiator.class,
                "net.ssehub.easy.instantiation.velocity").exception(e);
            throw new VilException(e.getLocalizedMessage(), VilException.ID_IO);
        }
        //checkstyle: resume exception type check 

        Writer fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            fileWriter.write(writer.toString());
        } catch (IOException e) {
            EASyLoggerFactory.INSTANCE.getLogger(VelocityInstantiator.class, "velocity").exception(e);
            throw new VilException(e.getLocalizedMessage(), VilException.ID_IO);
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
