package de.uni_hildesheim.sse.easy_producer.instantiator.model.defaultInstantiators;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.ArtifactFactory;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.FileArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.IArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.Path;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.VtlFileArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.BuildModel;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Script;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilLanguageException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.execution.TracerFactory;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.EvaluationVisitor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.IExpressionParser;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.IResolvable;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.IRuntimeEnvironment;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.StringReplacer;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.ITracer;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.Template;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.TemplateLangExecution;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.TemplateModel;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArtifactException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Collection;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Constants;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Instantiator;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ListSet;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationMeta;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Set;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration.AbstractIvmlVariable;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration.Attribute;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration.Configuration;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration.DecisionVariable;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration.IvmlElement;
import de.uni_hildesheim.sse.utils.modelManagement.ModelImport;
import de.uni_hildesheim.sse.utils.modelManagement.ModelInfo;
import de.uni_hildesheim.sse.utils.modelManagement.ModelManagementException;
import de.uni_hildesheim.sse.utils.modelManagement.Version;
import de.uni_hildesheim.sse.utils.modelManagement.VersionRestriction;
import de.uni_hildesheim.sse.utils.modelManagement.VersionRestriction.Operator;

/**
 * Implements the default VIL template processor. This instantiator handles
 * two types of artifacts, VTL templates and arbitrary file artifacts. In
 * case of VTL templates it tries to obtain the related VTL script (from a registered
 * and scanned VTL location - see {@link TemplateModel#locations()} and executes
 * the VTL script. In case of another file, it takes the file contents and instantiates
 * the VTL expressions in it (if there are some).
 * 
 * @author Holger Eichelberger
 */
@Instantiator(value = "vilTemplateProcessor", acceptsImplicitParameters = true)
public class VilTemplateProcessor implements IVilType {

    /**
     * Denotes the default name of the configuration parameter ({@link TemplateLangExecution#PARAM_CONFIG}).
     */
    public static final String PARAM_CONFIG = TemplateLangExecution.PARAM_CONFIG;
    
    /**
     * Denotes the default name of the target artifact parameter ({@link TemplateLangExecution#PARAM_TARGET}).
     */
    public static final String PARAM_TARGET = TemplateLangExecution.PARAM_TARGET;

    /**
     * Instantiates <code>source</code> to <code>target</code>.
     * 
     * @param template the input template script
     * @param config the variability configuration to process
     * @param targets the target artifacts (may be modified)
     * @param other named optional parameter
     * @return the created artifacts
     * @throws ArtifactException in case that execution fails
     */
    @OperationMeta(returnGenerics = IArtifact.class)
    public static Set<IArtifact> vilTemplateProcessor(FileArtifact template, Configuration config, 
        Collection<IArtifact> targets, Map<String, Object> other) throws ArtifactException {
        List<IArtifact> result = new ArrayList<IArtifact>();
        for (IArtifact target : targets) {
            process(template, config, target, other, result);
        }
        return new ListSet<IArtifact>(result, IArtifact.class);
    }

    /**
     * Instantiates <code>source</code> to <code>target</code>.
     * 
     * @param template the input template script
     * @param config the variability configuration to process
     * @param target the target artifact (may be modified)
     * @param other named optional parameter
     * @return the created artifacts
     * @throws ArtifactException in case that execution fails
     */
    @OperationMeta(returnGenerics = IArtifact.class)
    public static Set<IArtifact> vilTemplateProcessor(FileArtifact template, Configuration config, IArtifact target, 
        Map<String, Object> other) throws ArtifactException {
        List<IArtifact> result = new ArrayList<IArtifact>();
        process(template, config, target, other, result);
        return new ListSet<IArtifact>(result, IArtifact.class);
    }
    
    /**
     * Instantiates <code>source</code> to <code>target</code>.
     * 
     * @param template the input template script
     * @param config the variability configuration to process
     * @param target the target artifact (may be modified)
     * @param other named optional parameter
     * @param result the created artifacts (modified as a side effect)
     * @throws ArtifactException in case that execution fails
     */
    private static void process(FileArtifact template, Configuration config, IArtifact target, 
        Map<String, Object> other, List<IArtifact> result) throws ArtifactException {
        // obtaining the expression parser for instantiation
        IExpressionParser expressionParser = TemplateLangExecution.getExpressionParser();
        if (null == expressionParser) {
            throw new ArtifactException("no expression parser registered", ArtifactException.ID_INTERNAL);
        }
        // obtaining the file contents for instantiation
        File inAbsFile = template.getPath().getAbsolutePath();
        String templateContents;
        try {
            templateContents = FileUtils.readFileToString(inAbsFile);
        } catch (IOException e) {
            throw new ArtifactException(e.getMessage(), ArtifactException.ID_IO);
        }
        // instantiate the file template
        try  {
            RuntimeEnvironment runtimeEnvironment = new RuntimeEnvironment(config);
            ITracer tracer = TracerFactory.createTemplateLanguageTracer();
            EvaluationVisitor evaluationVisitor = new EvaluationVisitor(runtimeEnvironment, tracer);
            String instantiatedContent = StringReplacer.substitute(templateContents, runtimeEnvironment, 
                expressionParser, evaluationVisitor);
            
            StringWriter out = new StringWriter();
            out.append(instantiatedContent);
            out.flush();
            String tmp = out.toString();
            if (tmp.length() > 0) {
                target.getText().setText(tmp);
                target.store(); // just to be sure for the moment
            }
        } catch (ExpressionException e) {
            throw new ArtifactException(e.getMessage(), ArtifactException.ID_IO);
        }
        // returning the affected file(s)
        result.add(target);
    }

    /**
     * Instantiates <code>source</code> to <code>target</code>.
     * 
     * @param template the input template script
     * @param config the variability configuration to process
     * @param targets the target artifacts (may be modified)
     * @param other named optional parameter
     * @return the created artifacts
     * @throws ArtifactException in case that execution fails
     */
    @OperationMeta(returnGenerics = IArtifact.class)
    public static Set<IArtifact> vilTemplateProcessor(VtlFileArtifact template, Configuration config, 
        Collection<IArtifact> targets, Map<String, Object> other) throws ArtifactException {
        List<IArtifact> result = new ArrayList<IArtifact>();
        for (IArtifact target : targets) {
            process(template, config, target, other, result);
        }
        return new ListSet<IArtifact>(result, IArtifact.class);
    }
    
    /**
     * Instantiates <code>source</code> to <code>target</code>.
     * 
     * @param template the input template script
     * @param config the variability configuration to process
     * @param target the target artifact (may be modified)
     * @param other named optional parameter
     * @return the created artifacts
     * @throws ArtifactException in case that execution fails
     */
    @OperationMeta(returnGenerics = IArtifact.class)
    public static Set<IArtifact> vilTemplateProcessor(VtlFileArtifact template, Configuration config, 
        IArtifact target, Map<String, Object> other) throws ArtifactException {
        List<IArtifact> result = new ArrayList<IArtifact>();
        process(template, config, target, other, result);
        return new ListSet<IArtifact>(result, IArtifact.class);
    }    
    
    /**
     * Instantiates <code>source</code> to <code>target</code>.
     * 
     * @param template the input template script (as artifact)
     * @param config the variability configuration to process
     * @param target the target artifact (may be modified)
     * @param other named optional parameter
     * @param result the created artifacts (modified as a side effect)
     * @throws ArtifactException in case that execution fails
     */
    @OperationMeta(returnGenerics = IArtifact.class)
    private static void process(VtlFileArtifact template, Configuration config, 
        IArtifact target, Map<String, Object> other, List<IArtifact> result) throws ArtifactException {
        // obtaining the model info
        Path path = template.getPath();
        if (path.isPattern()) {
            throw new ArtifactException("template '" + path.getPath() + "' is a pattern and cannot be instantiated", 
                ArtifactException.ID_IO);
        } 
        File absPath = template.getPath().getAbsolutePath();
        if (!path.exists()) {
            throw new ArtifactException("template '" + path.getPath() + "' (" + absPath + ") does not exist", 
                ArtifactException.ID_IO);
        }
        URI uri = template.getPath().getAbsolutePath().toURI();
        ModelInfo<Template> info = TemplateModel.INSTANCE.availableModels().getInfo(uri);
        if (null == info) {
            throw new ArtifactException("template '" + path.getPath() + "' does not contain a valid template model", 
                ArtifactException.ID_IO);
        }
        // obtaining/loading the model
        try {
            Template model = TemplateModel.INSTANCE.load(info);
            process(model, config, target, other, result);
        } catch (ModelManagementException e) {
            throw new ArtifactException(e.getMessage(), ArtifactException.ID_IO);
        }
    }
    
    /**
     * Returns the applicable VTL restrictions.
     * 
     * @param templateName the name of the template to search for
     * @param other the other (named) parameters
     * @return the applicable VTL restrictions or <b>null</b> if there are none
     */
    private static ModelImport<Template> getVtlRestrictions(String templateName, Map<String, Object> other) {
        ModelImport<Template> result = null;
        if (null != other) {
            Object parent = other.get(Constants.IMPLICIT_PARENT_PARAMETER_NAME);
            if (parent instanceof Script) {
                Script script = (Script) parent;
                for (int r = 0; null == result && r < script.getVtlRestrictionsCount(); r++) {
                    ModelImport<Template> restriction = script.getVtlRestriction(r);
                    if (restriction.getName().equals(templateName)) {
                        result = restriction;
                    }
                }
            }
        }
        return result;
    }
    
    /**
     * Returns the VTL paths passed in as implicit parameter {@link Constants#IMPLICIT_PATHS_PARAMETER_NAME}.
     * 
     * @param other the other (named) parameters
     * @return the VTL paths, <b>null</b> if none were specified
     */
    private static String[] getVtlPaths(Map<String, Object> other) {
        String[] result = null;
        Object tmp = other.get(Constants.IMPLICIT_PATHS_PARAMETER_NAME);
        if (tmp instanceof String[]) {
            result = (String[]) tmp;
        }
        return result;
    }
    
    /**
     * Instantiates <code>source</code> to <code>target</code>. Versions restrictions may implicitly
     * be specified as {@link Constants#IMPLICIT_PARENT_PARAMETER_NAME implicit parent parameter name}
     * in terms of a Script instance.
     * 
     * @param templateName the name of the template
     * @param config the variability configuration to process
     * @param targets the target artifacts (may be modified)
     * @param other named optional parameter
     * @return the created artifacts
     * @throws ArtifactException in case that execution fails
     */
    @OperationMeta(returnGenerics = IArtifact.class)
    public static Set<IArtifact> vilTemplateProcessor(String templateName, Configuration config, 
        Collection<IArtifact> targets, Map<String, Object> other) throws ArtifactException {
        Set<IArtifact> result = null;
        try {
            // ugly manual dispatch but String as first parameter without further parameters does not lead 
            // to an artifact conversion
            Path path = Path.convert(templateName);
            FileArtifact art = ArtifactFactory.createArtifact(FileArtifact.class, path.getAbsolutePath(), 
                path.getArtifactModel());
            if (art instanceof VtlFileArtifact) {
                result = vilTemplateProcessor((VtlFileArtifact) art, config, targets, other);
            } else {
                result = vilTemplateProcessor(art, config, targets, other);
            }
        } catch (ArtifactException e) {
            // don't care
        }
        if (null == result) {
            List<IArtifact> tmp = new ArrayList<IArtifact>();
            Template template = obtainTemplate(templateName, getVtlRestrictions(templateName, other), 
                 getVtlPaths(other), config.getRootScript());
            for (IArtifact target : targets) {
                process(template, config, target, other, tmp);
            }
            result = new ListSet<IArtifact>(tmp, IArtifact.class);
        }
        return result;
    }
    
    /**
     * Instantiates <code>source</code> to <code>target</code>. Versions restrictions may implicitly
     * be specified as {@link Constants#IMPLICIT_PARENT_PARAMETER_NAME implicit parent parameter name}
     * in terms of a Script instance.
     * 
     * @param templateName the name of the template
     * @param config the variability configuration to process
     * @param target the target artifact (may be modified)
     * @param other named optional parameter
     * @return the created artifacts
     * @throws ArtifactException in case that execution fails
     */
    @OperationMeta(returnGenerics = IArtifact.class)
    public static Set<IArtifact> vilTemplateProcessor(String templateName, Configuration config, 
        IArtifact target, Map<String, Object> other) throws ArtifactException {
        Set<IArtifact> result = null;
        try {
            // ugly manual dispatch but String as first parameter without further parameters does not lead 
            // to an artifact conversion
            Path path = Path.convert(templateName);
            FileArtifact art = ArtifactFactory.createArtifact(FileArtifact.class, path.getAbsolutePath(), 
                path.getArtifactModel());
            if (art instanceof VtlFileArtifact) {
                result = vilTemplateProcessor((VtlFileArtifact) art, config, target, other);
            } else {
                result = vilTemplateProcessor(art, config, target, other);
            }
        } catch (ArtifactException e) {
            // don't care
        }
        if (null == result) {
            List<IArtifact> tmp = new ArrayList<IArtifact>();
            Template template = obtainTemplate(templateName, getVtlRestrictions(templateName, other), 
                getVtlPaths(other), config.getRootScript());
            process(template, config, target, other, tmp);
            result = new ListSet<IArtifact>(tmp, IArtifact.class);
        }
        return result;
    }   
    
    /**
     * Prunes <code>info</code> by removing all information objects that are not in one of the <code>vtlPaths</code>.
     * 
     * @param info the information objects to be pruned (may be <b>null</b>)
     * @param vtlPaths the paths to be used for pruning (may be <b>null</b>)
     */
    private static void pruneByPaths(List<ModelInfo<Template>> info, String[] vtlPaths) {
        if (null != info && null != vtlPaths) {
            for (int i = info.size() - 1; i >= 0; i--) {
                ModelInfo<Template> tmp = info.get(i);
                String location = new File(tmp.getLocation()).getAbsolutePath();
                boolean found = false;
                for (int p = 0; !found && p < vtlPaths.length; p++) {
                    found = location.startsWith(vtlPaths[p]);
                }
                if (!found) {
                    info.remove(i);
                }
            }
        }
        // getting rid of unrelated paths is just a first solution
    }
    
    /**
     * Obtains the template for <code>templateName</code> and <code>version</code>.
     * 
     * @param templateName the name of the template
     * @param restrictions the VTL resolution restrictions (may be <b>null</b>)
     * @param vtlPaths the VTL path(s) of the source project(s) (may be <b>null</b>)
     * @param caller the root executing script for URI-based model resolution
     * @return the template model
     * @throws ArtifactException in case that execution fails
     */
    private static Template obtainTemplate(String templateName, ModelImport<Template> restrictions, String[] vtlPaths, 
        Script caller) throws ArtifactException {
        Template model = null;
        Version ver = null;
        if (null != restrictions) {
            // TODO resolve based on restrictions -> Patrick Jähne
            if (1 == restrictions.getRestrictionsCount()) {
                VersionRestriction res = restrictions.getRestriction(0);
                if (Operator.EQUALS == res.getOperator()) {
                    ver = res.getVersion();
                }
            }
        }
        try {
            List<ModelInfo<Template>> info = null;
            if (null != caller) {
                ModelInfo<Script> cInfo = BuildModel.INSTANCE.availableModels().getModelInfo(caller);
                if (null != cInfo) {
                    info = TemplateModel.INSTANCE.availableModels().getVisibleModelInfo(
                        templateName, ver, cInfo.getLocation());
                }
            } 
            if (null == info || info.isEmpty()) {
                // no info via caller - try directly
                info = TemplateModel.INSTANCE.availableModels().getModelInfo(templateName, ver);
                pruneByPaths(info, vtlPaths);
            }

            if (null == info || info.isEmpty()) {
                throw new ArtifactException(templateName + " cannot be found", 
                    ArtifactException.ID_IO);
            }
            if (info.size() > 1) {
                String versionText = "";
                if (null != ver) {
                    versionText = " with version " + Version.toString(ver);
                }
                throw new ArtifactException(templateName + versionText + " is ambigous (" + info.size() 
                    + " models found)", ArtifactException.ID_IO);
            }

            // obtaining/loading the model
            model = TemplateModel.INSTANCE.load(info.get(0));
        } catch (ModelManagementException e) {
            throw new ArtifactException(e.getMessage(), ArtifactException.ID_IO);
        }
        return model;
    }
    
    /**
     * Instantiates <code>source</code> to <code>target</code>.
     * 
     * @param template the input template script (as template instance)
     * @param config the variability configuration to process
     * @param target the target artifact (may be modified)
     * @param other named optional parameter
     * @param result the created artifacts (modified as a side effect)
     * @throws ArtifactException in case that execution fails
     */
    @OperationMeta(returnGenerics = IArtifact.class)
    private static void process(Template template, Configuration config, 
        IArtifact target, Map<String, Object> other, List<IArtifact> result) throws ArtifactException {
        // executing the model
        try {
            StringWriter out = new StringWriter();
            Map<String, Object> localParam = new HashMap<String, Object>();
            // put default parameter
            localParam.put(PARAM_CONFIG, config);
            localParam.put(PARAM_TARGET, target);
            // put other parameter (default may be overridden if used differently)
            localParam.putAll(other);
            // put default parameters for sure
            localParam.put(TemplateLangExecution.PARAM_CONFIG_SURE, config);
            localParam.put(TemplateLangExecution.PARAM_TARGET_SURE, target);
            ITracer tracer = TracerFactory.createTemplateLanguageTracer();
            TemplateLangExecution exec = new TemplateLangExecution(tracer, out, localParam);
            template.accept(exec);
            String tmp = out.toString();
            if (tmp.length() > 0) {
                target.getText().setText(tmp);
                target.store(); // just to be sure for the moment
            }
        } catch (VilLanguageException e) {
            throw new ArtifactException(e.getMessage(), ArtifactException.ID_WHILE_INSTANTIATION);
        }
        result.add(target);
    }

    /**
     * Creates a specific runtime environment which contains the variables of a configuration.
     * 
     * @author Holger Eichelberger
     */
    private static class RuntimeEnvironment implements IRuntimeEnvironment {

        private Map<IResolvable, Object> values = new HashMap<IResolvable, Object>();
        private Map<String, IvmlElement> nameMap = new HashMap<String, IvmlElement>();

        /**
         * Creates a new runtime environment.
         * 
         * @param config the configuration used to fill this environment
         */
        RuntimeEnvironment(Configuration config) {
            Iterator<DecisionVariable> vIter = config.variables().iterator();
            while (vIter.hasNext()) {
                addVariable(vIter.next());
            }
            Iterator<Attribute> aIter = config.attributes().iterator();
            while (aIter.hasNext()) {
                addVariable(aIter.next());
            }
        }
        
        /**
         * Adds an IVML variable to the runtime environment.
         * 
         * @param var the variable to be added
         */
        private void addVariable(AbstractIvmlVariable var) {
            nameMap.put(var.getQualifiedName(), var);
            values.put(var, var.getValue());
            Iterator<DecisionVariable> vIter = var.variables().iterator();
            while (vIter.hasNext()) {
                addVariable(vIter.next());
            }
            Iterator<Attribute> aIter = var.attributes().iterator();
            while (aIter.hasNext()) {
                addVariable(aIter.next());
            }
        }
        
        @Override
        public Object getValue(IResolvable resolvable) throws ExpressionException {
            Object result;
            if (resolvable instanceof IvmlElement) {
                result = ((IvmlElement) resolvable).getValue();
            } else {
                if (values.containsKey(resolvable)) {
                    result = values.get(resolvable);
                } else {
                    throw new ExpressionException(resolvable.getName() + " is not defined", 
                        ExpressionException.ID_RUNTIME);
                }
            }
            return result;
        }

        @Override
        public IResolvable get(String name) {
            return nameMap.get(name);
        }

        @Override
        public void setValue(IResolvable var, Object object) throws VilLanguageException {
            if (var instanceof IvmlElement) {
                throw new VilLanguageException("cannot change configuration", VilLanguageException.ID_SEMANTIC);
            } else {
                values.put(var, object);
            }
        }

        @Override
        public Object getIvmlValue(String name) throws ExpressionException {
            return nameMap.get(name);
        }

        @Override
        public String[] getContextPaths() {
            return null;
        }

        @Override
        public TypeRegistry getTypeRegistry() {
            return TypeRegistry.DEFAULT; // TODO unsure whether local is needed
        }
        
    }

}
