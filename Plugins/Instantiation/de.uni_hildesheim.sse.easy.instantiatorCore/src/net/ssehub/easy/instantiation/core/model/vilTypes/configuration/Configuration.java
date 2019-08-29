package net.ssehub.easy.instantiation.core.model.vilTypes.configuration;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.instantiation.core.model.artifactModel.ArtifactFactory;
import net.ssehub.easy.instantiation.core.model.artifactModel.FileArtifact;
import net.ssehub.easy.instantiation.core.model.artifactModel.Path;
import net.ssehub.easy.instantiation.core.model.buildlangModel.Script;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.ArraySequence;
import net.ssehub.easy.instantiation.core.model.vilTypes.ArraySet;
import net.ssehub.easy.instantiation.core.model.vilTypes.IStringValueProvider;
import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;
import net.ssehub.easy.instantiation.core.model.vilTypes.OperationMeta;
import net.ssehub.easy.instantiation.core.model.vilTypes.Sequence;
import net.ssehub.easy.instantiation.core.model.vilTypes.SetSet;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.NameRegExFilter.DataType;
import net.ssehub.easy.reasoning.core.frontend.ReasonerFrontend;
import net.ssehub.easy.reasoning.core.reasoner.ReasonerConfiguration;
import net.ssehub.easy.reasoning.core.reasoner.ReasoningResult;
import net.ssehub.easy.varModel.confModel.ConfigurationException;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.IvmlException;
import net.ssehub.easy.varModel.model.ModelQuery;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.values.ContainerValue;
import net.ssehub.easy.varModel.model.values.ReferenceValue;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.persistency.IVMLWriter;

/**
 * Represents a variability model and its configuration in VIL. This class provides
 * specific methods to filter and select variables, attributes etc. Basically, the idea
 * of this configuration class is to contain a filtered set of configurable elements (see {@link IVariableFilter}, 
 * typically one that enables only frozen variables). It is currently
 * unsure how much access we actually need to the variable and attribute declarations.
 * Shifted this into {@link Utils}.
 * 
 * @author Holger Eichelberger
 */
public class Configuration extends IvmlElement implements IStringValueProvider {

    private Script rootScript;
    private Project project; 
    private net.ssehub.easy.varModel.confModel.Configuration configuration;
    private DecisionVariable[] variables;
    private Attribute[] attributes;
    private Map<String, IvmlElement> nameMap = new HashMap<String, IvmlElement>();
    private IVariableFilter filter;
    private boolean isValid = true;
    private ChangeHistory changed;

    /**
     * Creates a new configuration instance from an EASy configuration based
     * on frozen variables.
     * 
     * @param configuration the IVML configuration instance to be wrapped
     */
    public Configuration(net.ssehub.easy.varModel.confModel.Configuration configuration) {
        this(configuration, FrozenVariablesFilter.INSTANCE);
    }
    
    /**
     * Creates a new configuration instance from an EASy configuration.
     * 
     * @param configuration the IVML configuration instance to be wrapped
     * @param filter the external variable filter, e.g., for frozen variables
     */
    public Configuration(net.ssehub.easy.varModel.confModel.Configuration configuration, 
        IVariableFilter filter) {
        this.configuration = configuration;
        this.project = configuration.getProject();
        this.filter = filter;
        this.changed = new ChangeHistory(this);
    }

    /**
     * Creates a configuration from a given set of variables.
     * 
     * @param configuration the IVML configuration instance to be wrapped
     * @param variables the variables representing the actual contents of this configuration
     * @param filter the external variable filter
     */
    Configuration(net.ssehub.easy.varModel.confModel.Configuration configuration, DecisionVariable[] variables, 
        IVariableFilter filter) {
        this.configuration = configuration;
        this.variables = variables;
        this.project = configuration.getProject();
        this.filter = filter;
        this.changed = new ChangeHistory(this);
        index(variables);
    }

    /**
     * Creates a projected configuration only containing the <code>changed</code> variables.
     * 
     * @param configuration the base configuration
     * @param changed the changed variables to be present in the projection
     */
    private Configuration(Configuration configuration, Set<AbstractIvmlVariable> changed) {
        this.isValid = configuration.isValid;
        this.configuration = configuration.configuration;
        this.project = configuration.project;
        this.changed = configuration.changed;
        ConfigurationContextResolver resolver = new ConfigurationContextResolver(this, changed);
        resolver.resolve();
        this.filter = resolver.filter();
        this.variables = resolver.variables();
        index(this.variables);
        this.attributes = resolver.attributes();
        index(this.attributes);
    }

    /**
     * Creates a projected configuration (without explicit project).
     * 
     * @param configuration the base configuration
     * @param variablesFilter the filter to apply to variables
     * @param filter the external variable filter
     */
    private Configuration(Configuration configuration, IConfigurationFilter variablesFilter, IVariableFilter filter) {
        this(configuration, null, variablesFilter, filter);
    }
    
    /**
     * Creates a projected configuration.
     * 
     * @param configuration the base configuration
     * @param project the top-level project used for the projection (may be <b>null</b>)
     * @param variablesFilter the filter to apply to variables
     * @param filter the external variable filter
     */
    private Configuration(Configuration configuration, Project project, IConfigurationFilter variablesFilter, 
        IVariableFilter filter) {
        this.isValid = configuration.isValid;
        this.filter = filter;
        this.configuration = configuration.getConfiguration();
        this.changed = configuration.changed;
        if (null == project) {
            this.project = this.configuration.getProject();
        } else {
            this.project = project;
        }
        configuration.initializeNested();
        if (null != variablesFilter && variablesFilter != NoFilter.INSTANCE) {
            List<DecisionVariable> tmp = new ArrayList<DecisionVariable>();
            for (int v = 0; v < configuration.variables.length; v++) {
                DecisionVariable var = configuration.variables[v];
                if (variablesFilter.include(var)) {
                    tmp.add(var);
                    if (this.project.getName().equals(var.getDecisionVariable().getDeclaration().getNameSpace())) {
                        nameMap.put(var.getName(), var);
                    }
                    nameMap.put(var.getQualifiedName(), var);
                }
            }
            variables = new DecisionVariable[tmp.size()];
            tmp.toArray(variables);
        }
        configuration.initializeAttributes();
        attributes = configuration.attributes;
        index(attributes);
    }
    
    /**
     * Indexes the names of the given elements.
     * 
     * @param elements the elements to index
     */
    private void index(IvmlElement[] elements) {
        if (null != elements) {
            for (int e = 0; e < elements.length; e++) {
                nameMap.put(elements[e].getName(), elements[e]);
                nameMap.put(elements[e].getQualifiedName(), elements[e]);
            }
        }
    }
    
    /**
     * Returns the underlying EASy configuration. This operation may be required to wrap old-style
     * instantiators.
     * 
     * @return the EASy configuration
     */
    @Invisible
    public net.ssehub.easy.varModel.confModel.Configuration getConfiguration() {
        return configuration;
    }
    
    @Override
    protected void initializeNested() { 
        // this is not optimal if a configuration is used directly for projection but ok for now
        // (re) initializes self and leaves parent untouched where instances may be reused
        if (null == variables) {
            Project project = configuration.getProject();
            VariableCollector collector = new VariableCollector(this, filter);
            project.accept(collector);
            variables = collector.getCollectedVariables();
            index(variables);
        }
    }

    @Override
    protected void initializeAttributes() { 
        // this is not optimal if a configuration is used directly for projection but ok for now
        // (re) initializes self and leaves parent untouched where instances may be reused
        if (null == attributes) {
            Project project = configuration.getProject();
            List<Attribute> tmp = new ArrayList<Attribute>();
            for (int a = 0; a < project.getAttributesCount(); a++) {
                IDecisionVariable var = configuration.getDecision(project.getAttribute(a));
                if (null != var && filter.isEnabled(var)) {
                    Attribute attr = new Attribute(this, var, filter);
                    tmp.add(attr);
                    nameMap.put(attr.getQualifiedName(), attr);
                }
            }
            attributes = new Attribute[tmp.size()];
            tmp.toArray(attributes);
        }
    }
    
    /**
     * Returns the decision variables represented by this configuration.
     * 
     * @return the decision variables
     */
    @OperationMeta(returnGenerics = { DecisionVariable.class } )
    public Sequence<DecisionVariable> variables() {
        initializeNested();
        return new ArraySequence<DecisionVariable>(variables, DecisionVariable.class); 
    }
    
    /**
     * Returns a projected version of this configuration according to the names
     * of the variables.
     * 
     * @param namePattern a regular name pattern (or just the full name) all variables
     *   in the resulting configuration must match
     * @return the projected configuration
     * @throws VilException in case of an illformed name pattern
     */
    public Configuration selectByName(String namePattern) throws VilException {
        initializeNested();
        NameRegExFilter regexFilter = new NameRegExFilter(namePattern, DataType.NAME);
        Configuration newConfig = new Configuration(this, regexFilter, filter);
        return newConfig;
    }

    /**
     * Returns a projected version of this configuration according to the type
     * of the variables.
     * 
     * @param typePattern a regular pattern (or just the full name) all variables
     *   in the resulting configuration must match
     * @return the projected configuration
     * @throws VilException in case of an illformed name pattern
     */
    public Configuration selectByType(String typePattern) throws VilException {
        initializeNested();
        return new Configuration(this, new NameRegExFilter(typePattern, DataType.TYPE), filter);
    }
    
    /**
     * Returns a projected version of this configuration according to the applied
     * annotations.
     * 
     * @param namePattern a regular name pattern (or just the full name) all applied
     *   annotations of all variables in the resulting configuration must match
     * @return the projected configuration
     * @throws VilException in case of an illformed name pattern
     */
    public Configuration selectByAnnotation(String namePattern) throws VilException {
        initializeAttributes();
        return new Configuration(this, new NameRegExFilter(namePattern, DataType.ATTRIBUTE), filter);
    }

    /**
     * Returns a projected version of this configuration according to the applied
     * annotations.
     * 
     * @param namePattern a regular name pattern (or just the full name) all applied
     *   annotations of all variables in the resulting configuration must match
     * @return the projected configuration
     * @throws VilException in case of an illformed name pattern
     */
    public Configuration selectByAttribute(String namePattern) throws VilException {
        return selectByAnnotation(namePattern);
    } // TODO cleanup -> annotation

    /**
     * Returns a projected version of this configuration according to variables defined for 
     * the specified project.
     * 
     * @param name the name of the project
     * @param considerImports whether imports of projects shall be considered
     * @return the projected configuration
     */
    public Configuration selectByProject(String name, boolean considerImports) {
        Project project = ModelQuery.findProject(configuration.getProject(), name);
        if (null == project) {
            project = new Project(name); // tolerance, but no contents
        }
        return new Configuration(this, project, new ProjectFilter(project, considerImports), filter);
    }
    
    /**
     * Returns a projected version of this configuration according to variables defined for 
     * the specified project. Imports are considered by default.
     * 
     * @param name the name of the project
     * @return the projected configuration
     */
    public Configuration selectByProject(String name) {
        return selectByProject(name, true);
    }
    
    /**
     * Returns a projected version of this configuration according to the applied
     * annotations.
     * 
     * @param name the name of the annotation (may be <b>null</b>)
     * @param value the value as an IVML identifier (may be <b>null</b>)
     * @return the projected configuration
     * @throws VilException in case of an illformed name pattern
     */
    public Configuration selectByAnnotation(String name, Object value) throws VilException {
        initializeAttributes();
        Configuration result;
        if (null == name) {
            result = new Configuration(this, AllFilter.INSTANCE, filter);
        } else {
            result = new Configuration(this, 
                new NameRegExFilter(name, DataType.ATTRIBUTE, 
                    new ValueFilter(value, Attribute.class)), filter);
        }
        return result;
    }
    
    /**
     * Returns a projected version of this configuration according to the applied
     * annotations.
     * 
     * @param name the name of the annotation (may be <b>null</b>)
     * @param value the value as an IVML identifier (may be <b>null</b>)
     * @return the projected configuration
     * @throws VilException in case of an illformed name pattern
     */
    public Configuration selectByAttribute(String name, Object value) throws VilException {
        return selectByAnnotation(name, value);
    }
    
    /**
     * Returns whether this configuration is empty.
     * 
     * @return <code>true</code> if there are no decision variables to be configured,
     *   <code>false</code> else
     */
    public boolean isEmpty() {
        int count = 0;
        if (null != variables || null != attributes) {
            // if filtered/initialized
            count += null != variables ? variables.length : 0;
            count += null != attributes ? attributes.length : 0;
        } else {
            // fallback
            count = configuration.getProject().getElementCount();
        }
        return count == 0;
    }

    @Override
    public String getStringValue(StringComparator comparator) {
        return "<config>"; // currently a pseudo value for testing
    }

    @Override
    public String getName() {
        return project.getName();
    }

    @Override
    public String getQualifiedName() {
        return project.getQualifiedName();
    }

    @Override
    public TypeDescriptor<?> getType() {
        return getTypeDescriptor(project.getType());
    }

    @Override
    public String getTypeName() {
        return project.getType().getName();
    }

    @Override
    public String getQualifiedType() {
        return project.getType().getQualifiedName();
    }

    /**
     * Returns the specified attribute.
     * 
     * @param index the 0-based index of the attribute to return
     * @return the specified attribute
     * @throws IndexOutOfBoundsException if <code>index &lt; 0 || index &gt;= {@link #getAttributeCount()}</code>
     */
    Attribute getAttribute(int index) {
        initializeAttributes();
        if (null == attributes) {
            throw new IndexOutOfBoundsException();
        }
        return attributes[index];
    }
    
    /**
     * Returns the number of attributes.
     * 
     * @return the number of attributes
     */
    int getAttributeCount() {
        initializeAttributes();
        return null == attributes ? 0 : attributes.length; 
    }
    
    @Invisible
    @Override
    public Object getValue() {
        return null;
    }

    /**
     * Returns the attributes of this configuration.
     * 
     * @return the attributes
     */
    @OperationMeta(returnGenerics = { Attribute.class } )
    public Sequence<Attribute> attributes() {
        initializeAttributes();
        return new ArraySequence<Attribute>(attributes, Attribute.class);
    }
    
    /**
     * Returns the decision variable with the given (qualified) name.
     * 
     * @param name the name of the variable to return
     * @return the variable or <b>null</b> if not found
     */
    public DecisionVariable getByName(String name) {
        IvmlElement elt = getElement(name);
        DecisionVariable result;
        if (elt instanceof DecisionVariable) {
            result = (DecisionVariable) elt;
        } else {
            result = null;
        }
        return result;
    }
    
    /**
     * Returns the element matching the given (qualified) name.
     * 
     * @param name the name to search for
     * @return the matching element or <b>null</b> if not found
     */
    @Invisible
    public IvmlElement getElement(String name) {
        initializeAttributes();
        initializeNested();
        String key = name;
        int pos = name.indexOf("::");
        if (pos > 0) {
            pos = name.indexOf("::", pos + 2);
            if (pos > 0) {
                // project::element
                key = name.substring(0, pos);
            }
        }
        IvmlElement match = nameMap.get(key);
        if (null != match && key.length() < name.length()) {
            match = match.getElement(name);
        }
        if (null == match) { // FQN match
            match = nameMap.get(name);
        }
        if (null == match) {
            Project project = configuration.getProject();
            try {
                AbstractVariable var = (AbstractVariable) ModelQuery.findElementByName(
                    project, name, AbstractVariable.class);
                if (null != var) {
                    match = new IvmlDeclaration(var);
                }
            } catch (IvmlException e) {
            }
            try {
                Value eVal = ModelQuery.enumLiteralAsValue(project, name);
                if (eVal instanceof net.ssehub.easy.varModel.model.values.EnumValue) {
                    match = new EnumValue((net.ssehub.easy.varModel.model.values.EnumValue) eVal);
                }
            } catch (IvmlException e) {
            }
        }
        return match;
    }

    @Invisible
    @Override
    public String getStringValue() {
        return null;
    }

    @Invisible
    @Override
    public Integer getIntegerValue() {
        return null;
    }

    @Invisible
    @Override
    public Double getRealValue() {
        return null;
    }

    @Invisible
    @Override
    public Boolean getBooleanValue() {
        return null;
    }

    @Invisible
    @Override
    public EnumValue getEnumValue() {
        return null;
    }

    /**
     * Stores a hint to the root executing script (for VTL-by-name resolution).
     * 
     * @return the hint to the executing script
     */
    @Invisible
    public Script getRootScript() {
        return rootScript;
    }

    /**
     * Stores a hint to the root executing script (for VTL-by-name resolution).
     * 
     * @param rootScript the hint to the executing script
     */
    @Invisible
    public void setRootScript(Script rootScript) {
        this.rootScript = rootScript;
    }

    /**
     * Stores the underlying (unprojected) configuration to <code>path</code>.
     * 
     * @param path the target path
     * @return the created/modified file artifact
     * @throws VilException in case that storing the configuration fails
     */
    public FileArtifact store(Path path) throws VilException {
        return store(path, true);
    }

    /**
     * Stores the underlying (unprojected) configuration to <code>path</code>.
     * 
     * @param path the target path
     * @param userValuesOnly store only user defined values (<code>true</code>) or the full 
     *     configuration (<code>false</code>)
     * @return the created/modified file artifact
     * @throws VilException in case that storing the configuration fails
     */
    public FileArtifact store(Path path, boolean userValuesOnly) throws VilException {
        File target = path.getAbsolutePath();
        FileWriter out = null;
        try {
            Project project = configuration.toProject(true, userValuesOnly);
            out = new FileWriter(target);
            IVMLWriter writer = new IVMLWriter(out);
            project.accept(writer);
            IVMLWriter.releaseInstance(writer);
            out.close();
        } catch (ConfigurationException e) {
            throw new VilException(e, VilException.ID_RUNTIME_EXECUTION);
        } catch (IOException e) {
            if (null != out) {
                try {
                    out.close();
                } catch (IOException e1) {
                }
            }
            throw new VilException(e, VilException.ID_IO);
        }
        return ArtifactFactory.createArtifact(FileArtifact.class, target, null);
    }

    // --------------------------------- DSPL functions ------------------------------------------
    
    /**
     * Re-reasons on the variable settings of this configuration. This operation is intended
     * for runtime reasoning, in particular of changed variables only.
     * 
     * @return a projection of this configuration containing the variables changed by reasoning or 
     *   <b>this</b> if the reasoner does not provide information on affected variables
     */
    public Configuration reason() {
        Configuration result;
        ReasoningResult tmp = ReasonerFrontend.getInstance().propagate(configuration, 
            new ReasonerConfiguration(), ProgressObserver.NO_OBSERVER);
        if (tmp.providesInformationOnAffectedVariables()) {
            int aCount = tmp.getAffectedVariablesCount();
            final HashSet<String> affected = new HashSet<String>();
            for (int a = 0; a < aCount; a++) {
                affected.add(tmp.getAffectedVariable(a).getDeclaration().getQualifiedName());
            }
            IConfigurationFilter reasoningFilter = new IConfigurationFilter() {
                
                @Override
                public boolean include(IvmlElement element) {
                    return affected.contains(element.getQualifiedName());
                }
            };
            result = new Configuration(this, reasoningFilter, filter);
            result.isValid = !tmp.hasConflict();
        } else {
            result = this;
        }
        return result;
    }
    
    /**
     * Projects this configuration to the frozen variables. This method is intended to support runtime
     * variability, i.e., to explicitly separate between pre-runtime instantiation and runtime instantiation.
     * Please note that a configuration projected to frozen variables (in particular in pre-runtime instantiation) will
     * remain frozen.
     * 
     * @return a projection of this configuration containing frozen variables only
     */
    public Configuration selectFrozen() {
        Configuration result;
        if (filter == FrozenVariablesFilter.INSTANCE) {
            result = this;
        } else {
            result = new Configuration(configuration, FrozenVariablesFilter.INSTANCE);
            result.isValid = isValid;
        }
        return result;
    }

    /**
     * Returns a projection of this configuration returning all variables, including non-frozen
     * runtime variables. Please note that a configuration projected to frozen variables (in particular in 
     * pre-runtime instantiation) will remain frozen.
     * 
     * @return the projected configuration
     */
    public Configuration selectAll() {
        return this;
    }
    
    /**
     * Copies this configuration into a new configuration instance. This method is intended for instantiating runtime
     * variabilities.
     * 
     * @return a copy of the configuration
     */
    public Configuration copy() {
        Configuration result = new Configuration(
            new net.ssehub.easy.varModel.confModel.Configuration(configuration), filter);
        result.isValid = isValid;
        return result;
    }
    
    /**
     * Returns whether this configuration is valid, in particular after {@link #reason()}.
     * 
     * @return <code>true</code> if this configuration is valid, <code>false</code> else
     */
    public boolean isValid() {
        return isValid;
    }

    /**
     * Projects to the changed variables only.
     * 
     * @return a projects of the changed variables only, may be empty
     * @see #selectChangedWithContext()
     */
    public Configuration selectChanged() {
        return new Configuration(configuration, changed.changedFilter());
    }
    
    /**
     * Projects to the changed variables with their context.
     * 
     * @return a projects of the changed variables only, may be empty
     * @see #selectChanged()
     */
    public Configuration selectChangedWithContext() {
        return new Configuration(this, changed.changed());
    }
    
    /**
     * Is called to notify the configuration about a changed variable value.
     * 
     * @param variable the variable the value has changed for
     * @param oldValue the value of the variable before the change
     */
    @Invisible
    public void notifyValueChanged(AbstractIvmlVariable variable, Value oldValue) {
        changed.notifyChanged(variable, oldValue); 
        // don't rely on the qualified name here due to changing pseudo names for collections
    }
    
    /**
     * Returns the mapped IVML element for <code>name</code>.
     * 
     * @param name the name
     * @return the mapped element (may be <b>null</b>)
     */
    @Invisible
    IvmlElement get(String name) {
        return nameMap.get(name);
    }
    
    /**
     * Returns the change history.
     * 
     * @return the change history
     */
    public ChangeHistory getChangeHistory() {
        return changed;
    }

    /**
     * Searches for the VIL instance holding <code>var</code>.
     * 
     * @param var the variable
     * @return the VIL instance holding <code>var</code>
     */
    @Invisible
    public DecisionVariable findVariable(IDecisionVariable var) {
        DecisionVariable result = getByName(net.ssehub.easy.varModel.confModel.Configuration.getInstanceName(var));
        for (int v = 0; null == result && v < variables.length; v++) {
            result = findVariable(var, variables[v]);
        }
        return result;
    }
    
    /**
     * Searches for <code>var</code> in <code>dVar</code>, i.e., whether <code>dVar</code> or 
     * one of its contained variables holdes <code>var</code>.
     * 
     * @param var the variable to search for
     * @param dVar the VIL variable wrapper to look into
     * @return the VIL wrapper representing <code>dVar</code> or <b>null</b> if not found
     */
    private DecisionVariable findVariable(IDecisionVariable var, DecisionVariable dVar) {
        DecisionVariable result = null;
        if (dVar.isVariable(var)) {
            result = dVar;
        } else {
            Sequence<DecisionVariable> vars = dVar.variables();
            for (int v = 0; null == result && v < vars.size(); v++) {
                DecisionVariable tmp = vars.get(v);
                if (tmp.isVariable(var)) {
                    result = tmp;
                }
            }
        }
        return result;
    }
    
    /**
     * Returns all instances of the given <code>type</code>.
     * 
     * @param type the type to look for
     * @return all instances (may be empty)
     */
    public net.ssehub.easy.instantiation.core.model.vilTypes.Set<?> allInstances(TypeDescriptor<?> type) {
        net.ssehub.easy.instantiation.core.model.vilTypes.Set<?> result = null;
        if (type instanceof IvmlTypeDescriptor) {
            IDatatype ivmlType = ((IvmlTypeDescriptor) type).getIvmlType();
            Value val = configuration.getAllInstances(ivmlType);
            if (val instanceof ContainerValue) {
                ContainerValue cValue = (ContainerValue) val;
                Set<Object> tmp = new HashSet<Object>(cValue.getElementSize());
                for (int v = 0; v < cValue.getElementSize(); v++) {
                    resolveAndAddValue(cValue.getElement(v), tmp);
                }
                if (!tmp.isEmpty()) {
                    result = new SetSet<Object>(tmp, type);
                }
            }
        }
        if (null == result) {
            result = new ArraySet<Object>(new Object[0], type);
        }
        return result;
    }

    /**
     * Resolves the VIL decision variable object for <code>value</code> and adds it to <code>result</code>.
     * 
     * @param value the value
     * @param result the result (to be modified as a side effect)
     */
    private void resolveAndAddValue(Value value, Set<Object> result) {
        if (value instanceof ReferenceValue) { // always the case, just to be sure
            AbstractVariable var = ((ReferenceValue) value).getValue();
            if (var != null) {
                IDecisionVariable decVar = configuration.getDecision(var);
                if (null != decVar) {
                    DecisionVariable dVar = findVariable(decVar);
                    if (null != dVar) {
                        result.add(dVar);
                    }
                }
            }
        }
    }
    
}
