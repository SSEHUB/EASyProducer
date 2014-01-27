package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Script;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArraySequence;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArtifactException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IStringValueProvider;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Invisible;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationMeta;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Sequence;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration.NameRegExFilter.DataType;
import de.uni_hildesheim.sse.model.confModel.AssignmentState;
import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;
import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.IvmlException;
import de.uni_hildesheim.sse.model.varModel.ModelQuery;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.values.Value;

/**
 * Represents a variability model and its configuration in VIL. This class provides
 * specific methods to filter and select variables, attributes etc. Basically, the idea
 * of this configuration class is to contain only FROZEN and configured elements. It is currently
 * unsure how much access we actually need to the variable and attribute declarations.
 * Shifted this into {@link Utils}.
 * 
 * @author Holger Eichelberger
 */
public class Configuration extends IvmlElement implements IStringValueProvider {

    private Script rootScript;
    private de.uni_hildesheim.sse.model.confModel.Configuration configuration;
    private DecisionVariable[] variables;
    private Attribute[] attributes;
    private Map<String, IvmlElement> nameMap = new HashMap<String, IvmlElement>();
    
    /**
     * Creates a new configuration instance from an EASy configuration.
     * 
     * @param configuration the IVML configuration instance to be wrapped
     */
    public Configuration(de.uni_hildesheim.sse.model.confModel.Configuration configuration) {
        this.configuration = configuration;
    }

    /**
     * Creates a configuration from a given set of variables.
     * 
     * @param configuration the IVML configuration instance to be wrapped
     * @param variables the variables representing the actual contents of this configuration
     */
    Configuration(de.uni_hildesheim.sse.model.confModel.Configuration configuration, DecisionVariable[] variables) {
        this.configuration = configuration;
        this.variables = variables;
        index(variables);
    }

    /**
     * Creates a projected configuration.
     * 
     * @param configuration the base configuration
     * @param variablesFilter the filter to apply to variables
     */
    private Configuration(Configuration configuration, IConfigurationFilter variablesFilter) {
        this.configuration = configuration.getConfiguration();
        configuration.initializeNested();
        if (null != variablesFilter && variablesFilter != NoFilter.INSTANCE) {
            List<DecisionVariable> tmp = new ArrayList<DecisionVariable>();
            for (int v = 0; v < configuration.variables.length; v++) {
                DecisionVariable var = configuration.variables[v];
                if (variablesFilter.include(var)) {
                    tmp.add(var);
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
    public de.uni_hildesheim.sse.model.confModel.Configuration getConfiguration() {
        return configuration;
    }
    
    @Override
    protected void initializeNested() { 
        // this is not optimal if a configuration is used directly for projection but ok for now
        // (re) initializes self and leaves parent untouched where instances may be reused
        if (null == variables) {
            Project project = configuration.getProject();
            VariableCollector collector = new VariableCollector(configuration);
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
                if (null != var && AssignmentState.FROZEN == var.getState()) {
                    Attribute attr = new Attribute(var);
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
     * @return the projected configuration (<b>this</b> at the moment)
     * @throws ArtifactException in case of an illformed name pattern
     */
    public Configuration selectByName(String namePattern) throws ArtifactException {
        initializeNested();
        return new Configuration(this, new NameRegExFilter(namePattern, DataType.NAME));
    }

    /**
     * Returns a projected version of this configuration according to the type
     * of the variables.
     * 
     * @param typePattern a regular pattern (or just the full name) all variables
     *   in the resulting configuration must match
     * @return the projected configuration (<b>this</b> at the moment)
     * @throws ArtifactException in case of an illformed name pattern
     */
    public Configuration selectByType(String typePattern) throws ArtifactException {
        initializeNested();
        return new Configuration(this, new NameRegExFilter(typePattern, DataType.TYPE));
    }

    /**
     * Returns a projected version of this configuration according to the applied
     * attributes.
     * 
     * @param namePattern a regular name pattern (or just the full name) all applied
     *   attributes of all variables in the resulting configuration must match
     * @return the projected configuration (<b>this</b> at the moment)
     * @throws ArtifactException in case of an illformed name pattern
     */
    public Configuration selectByAttribute(String namePattern) throws ArtifactException {
        initializeAttributes();
        return new Configuration(this, new NameRegExFilter(namePattern, DataType.ATTRIBUTE));
    }

    /**
     * Returns a projected version of this configuration according to the applied
     * attributes.
     * 
     * @param name the name of the attribute (may be <b>null</b>)
     * @param value the value as an IVML identifier (may be <b>null</b>)
     * @return the projected configuration (<b>this</b> at the moment)
     * @throws ArtifactException in case of an illformed name pattern
     */
    public Configuration selectByAttribute(String name, Object value) throws ArtifactException {
        initializeAttributes();
        Configuration result;
        if (null == name) {
            result = new Configuration(this, AllFilter.INSTANCE);
        } else {
            result = new Configuration(this, 
                new NameRegExFilter(name, DataType.ATTRIBUTE, 
                    new ValueFilter(value, Attribute.class)));
        }
        return result;
    }
    
    /**
     * Returns whether this configuration is empty.
     * 
     * @return <code>true</code> if there are no decision variables to be configured,
     *   <code>false</code> else
     */
    public boolean isEmpty() {
        return configuration.getProject().getElementCount() > 0;
    }

    @Override
    public String getStringValue(StringComparator comparator) {
        return "<config>"; // currently a pseudo value for testing
    }

    @Override
    public String getName() {
        return configuration.getProject().getName();
    }

    @Override
    public String getQualifiedName() {
        return configuration.getProject().getQualifiedName();
    }

    @Override
    public String getType() {
        return configuration.getProject().getType().getName();
    }

    @Override
    public String getQualifiedType() {
        return configuration.getProject().getType().getQualifiedName();
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
                if (eVal instanceof de.uni_hildesheim.sse.model.varModel.values.EnumValue) {
                    match = new EnumValue((de.uni_hildesheim.sse.model.varModel.values.EnumValue) eVal);
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

}
