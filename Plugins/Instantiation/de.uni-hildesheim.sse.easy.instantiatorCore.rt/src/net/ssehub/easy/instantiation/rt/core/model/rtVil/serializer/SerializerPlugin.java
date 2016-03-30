package net.ssehub.easy.instantiation.rt.core.model.rtVil.serializer;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.FileUtils;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.basics.modelManagement.IModel;
import net.ssehub.easy.basics.modelManagement.IModelLoader;
import net.ssehub.easy.basics.modelManagement.ModelInfo;
import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;
import net.ssehub.easy.instantiation.rt.core.model.rtVil.Bundle;
import net.ssehub.easy.instantiation.rt.core.model.rtVil.RtVilModel;
import net.ssehub.easy.instantiation.rt.core.model.rtVil.Script;
import net.ssehub.easy.instantiation.rt.core.model.rtVil.Strategy;
import net.ssehub.easy.instantiation.rt.core.model.rtVil.Tactic;
import net.ssehub.easy.instantiation.rt.core.model.rtVil.TacticCall;
import net.ssehub.easy.instantiation.rt.core.model.rtVil.types.RtVilTypeRegistry;
import net.ssehub.easy.instantiation.serializer.xml.ISerializerPlugin;

/**
 * Plug-in to serialize runtime VIL.
 * 
 * @author Sass
 * @param <M>
 *
 */
public class SerializerPlugin<M> implements ISerializerPlugin<Script> {
    
    protected static EASyLogger logger = EASyLoggerFactory.INSTANCE.getLogger(SerializerPlugin.class,
            Bundle.ID);

    protected static final ProgressObserver OBSERVER = ProgressObserver.NO_OBSERVER;
    
    private static final String[] RTVIL_FILTER = {"rtvil" };
    
    private List<TypeRegistry> registries = new ArrayList<TypeRegistry>();
    
    @Override
    public void serialize(File source, List<IModel> modelList) {
        Collection<File> rtvilFiles = FileUtils.listFiles(source, RTVIL_FILTER, true);
        // Load all RTVIL files
        for (File file : rtvilFiles) {
            ModelInfo<Script> foundScript = RtVilModel.INSTANCE.availableModels().getInfo(file.toURI());
            try {
                if (null != foundScript) {
                    RtVilModel.INSTANCE.load(foundScript);
                    Script script = foundScript.getResolved();
                    registries.add(script.getTypeRegistry());
                    modelList.add(script);
                }
            } catch (ModelManagementException e) {
                logger.exception(e);
            }
        }
    }
    
    @Override
    public void deserialize(File file) {
        try {
            RtVilModel.INSTANCE.loaders().registerLoader(RTVILModelLoader.INSTANCE, OBSERVER);
            RtVilModel.INSTANCE.locations().addLocation(file, OBSERVER);
        } catch (ModelManagementException e) {
            logger.exception(e);
        }
    }

    @Override
    public String getTypeRegistryIdentifier(TypeRegistry typeRegistry) {
        String identifier = "";
        if (typeRegistry.getParentRegistry() instanceof RtVilTypeRegistry) {
            identifier = "rtVil";
        }
        return identifier;
    }

    @Override
    public TypeRegistry createTypeRegistry(String identifier) {
        TypeRegistry typeRegistry = null;
        if (identifier.equals("rtVil")) {
            typeRegistry = new TypeRegistry(RtVilTypeRegistry.INSTANCE);
        }
        return typeRegistry;
    }
    
    @Override
    public IModelLoader<?> getModelLoader() {
        return RTVILModelLoader.INSTANCE;
    }

    @Override
    public TypeRegistry getRtVilTypeRegistry() {
        return new TypeRegistry(RtVilTypeRegistry.INSTANCE);
    }
    
    @Override
    public Class<?>[] getRtVilClasses() {
        Class<?> c = null;
        Class<?> c1 = null;
        Class<?> c2 = null;
        try {
            c = Class.forName("de.uni_hildesheim.sse.easy_producer.instantiator.model.rtVil"
                    + ".types.RtVilTypeRegistry$RtReflectionFieldDescriptor");
            c1 = Class.forName("de.uni_hildesheim.sse.easy_producer.instantiator.model.rtVil"
                    + ".types.RtVilTypeRegistry$RtReflectionOperationDescriptor");
            c2 = Class.forName("de.uni_hildesheim.sse.easy_producer.instantiator.model.rtVil"
                    + ".types.RtVilTypeRegistry$RtReflectionConstructorDescriptor");
        } catch (ClassNotFoundException e) {
            logger.exception(e);
        }
        Class<?>[] classes = {Script.class, c, c1, c2, Strategy.class, TacticCall.class, Tactic.class};
        return classes;
    }
    
}
