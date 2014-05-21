package de.uni_hildesheim.sse.model.confModel;

import java.util.HashMap;
import java.util.Map;

import de.uni_hildesheim.sse.model.cst.ConstantValue;
import de.uni_hildesheim.sse.model.cst.ConstraintSyntaxTree;
import de.uni_hildesheim.sse.model.cst.OCLFeatureCall;
import de.uni_hildesheim.sse.model.cst.Variable;
import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.Attribute;
import de.uni_hildesheim.sse.model.varModel.AttributeAssignment;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.IAttributeAccess;
import de.uni_hildesheim.sse.model.varModel.IModelElement;
import de.uni_hildesheim.sse.model.varModel.datatypes.OclKeyWords;
import de.uni_hildesheim.sse.model.varModel.values.NullValue;
import de.uni_hildesheim.sse.model.varModel.values.Value;

/**
 * Implements a decision variable representing a specific decision.
 * Initializes and stores attributes on decision variables.
 * 
 * @author Holger Eichelberger
 * @author El-Sharkawy
 */
abstract class DecisionVariable implements IDecisionVariable {

    private IConfigurationElement parent;
    private VariableConfigProvider configProvider;
    private AbstractVariable declaration;
    private IDecisionVariable[] attributes;
    private boolean isVisible;
    
    /**
     * Creates a new decision variable representing a specific decision.
     * The assignment state will be {@link AssignmentState#UNDEFINED}.
     * 
     * @param parent the parent this variable is part of, typically the {@link Configuration}
     *   instance, but in case of compounds/container also the holding {@link IDecisionVariable}
     * @param varDeclaration the variable declaration instantiated by this decision
     * @param isVisible Specifies whether this variables is exported by an interface or not:
     * <ul>
     * <li><tt>true</tt>: The variable is exported by an interface or there is no interface</li>.
     * <li><tt>false</tt>: There is an interface which does not export this variable</li>.
     * </ul>
     */
    protected DecisionVariable(IConfigurationElement parent, AbstractVariable varDeclaration, boolean isVisible) {
        attributes = new IDecisionVariable[0];
        this.declaration = varDeclaration;
        this.parent = parent;
        this.isVisible = isVisible;
        configProvider = VariableConfigProviderFactory.createDelegate(this);
        try {
            initializeAttributes(varDeclaration);
        } catch (ConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * Creates a new decision variable representing a specific decision.
     * 
     * @param attributeDecl the element declaring the attributes for this variable
     * @throws ConfigurationException in case that types do not comply
     */
    public void initializeAttributes(IAttributeAccess attributeDecl) throws ConfigurationException {
        if (!(attributeDecl instanceof Attribute)) { // attributes of attributes are not allowed in IVML

            // unpack constraints, remove as soon as reasoner works with this
            Map<String, Value> values = new HashMap<String, Value>();
            IModelElement parent = attributeDecl.getParent();
            while (null != parent) {
                if (parent instanceof AttributeAssignment) {
                    AttributeAssignment assng = (AttributeAssignment) parent;
                    unpackConstraints(assng, values);
                }
                parent = parent.getParent();
            }
            Map<String, IDecisionVariable> tmp = new HashMap<String, IDecisionVariable>();
            addAttributes(attributeDecl, tmp, values);
            parent = attributeDecl.getParent();
            while (null != parent) {
                if (parent instanceof IAttributeAccess) {
                    addAttributes((IAttributeAccess) parent, tmp, values);
                }
                parent = parent.getParent();
            }
            
            this.attributes = new IDecisionVariable[tmp.size()];
            int a = 0;
            for (IDecisionVariable var : tmp.values()) {
                attributes[a++] = var;
            }
        }
    }

    /**
     * Unpacks the constraints and extracts the values. This is currently just a workaround as long as the reasoner
     * is not able to work with that.
     * 
     * @param assng the attribute assignment to unpack
     * @param values the attribute-value-mapping (to be modified as a side effect)
     */
    private void unpackConstraints(AttributeAssignment assng, Map<String, Value> values) {
        for (int r = 0; r < assng.getRealizingCount(); r++) {
            ConstraintSyntaxTree constr = assng.getRealizing(r).getConsSyntax();
            if (constr instanceof OCLFeatureCall) {
                OCLFeatureCall call = (OCLFeatureCall) constr;
                if (1 == call.getParameterCount() && OclKeyWords.ASSIGNMENT.equals(call.getOperation())) {
                    ConstraintSyntaxTree p0 = call.getOperand();
                    ConstraintSyntaxTree p1 = call.getParameter(0);
                    if (p0 instanceof Variable && p1 instanceof ConstantValue) {
                        AbstractVariable var = ((Variable) p0).getVariable();
                        String key = var.getName();
                        if (!values.containsKey(key)) {
                            values.put(key, ((ConstantValue) p1).getConstantValue());
                        }
                    }
                }
            }
        }
    }
    
    /**
     * Adds all attributes provided by <code>access</code>.
     * 
     * @param access the instance providing the attribute access
     * @param map a mapping between attribute and actual decision variable (modified as a side effect)
     * @param values mapping of attributes to values (just from attribute assignments)
     * @throws ConfigurationException in case of any type / value assignment error
     */
    private void addAttributes(IAttributeAccess access, Map<String, IDecisionVariable> map, 
        Map<String, Value> values) throws ConfigurationException {
        for (int a = 0; a < access.getAttributesCount(); a++) {
            Attribute attr = access.getAttribute(a);
            String key = attr.getName();
            if (!map.containsKey(key)) {
                VariableCreator creator = new VariableCreator(attr, this, isVisible);
                IDecisionVariable var = creator.getVariable();
                if (values.containsKey(key)) {
                    var.setValue(values.get(key), AssignmentState.DERIVED);
                } else if (null != attr.getDefaultValue()) {
                    if (attr.getDefaultValue() instanceof ConstantValue) {
                        Value val = ((ConstantValue) attr.getDefaultValue()).getConstantValue();
                        var.setValue(val, AssignmentState.DEFAULT);
                    }
                }
                map.put(key, var);
            }
        }
    }
    
    /**
     * Returns the number of attributes.
     * 
     * @return the number of attributes
     */
    public int getAttributesCount() {
        return attributes.length;
    }
    
    /**
     * Returns a specific attribute.
     * 
     * @param index the index of the attribute
     * @return the attribute
     * @throws IndexOutOfBoundsException if 
     *   <code>index&lt;0 || index&gt;={@link #getAttributesCount()}</code>
     */
    public IDecisionVariable getAttribute(int index) {
        return attributes[index];
    }
    
    /**
     * {@inheritDoc}
     */
    public final boolean isNested() {
        return !(parent instanceof Configuration);
    }
    
    /**
     * {@inheritDoc}
     */
    public final IConfigurationElement getParent() {
        return parent;
    }
    
    /**
     * {@inheritDoc}
     */
    public final Configuration getConfiguration() {
        Configuration config = null;
        if (isNested()) {
            config = parent.getConfiguration();
        } else {
            config = (Configuration) parent;
        }
        
        return config;
    }
    
    /**
     * {@inheritDoc}
     */
    public void accept(IConfigurationVisitor visitor) {
        visitor.visitDecisionVariable(this);
    }

    /**
     * {@inheritDoc}
     */
    public Value getValue() {
        Value returnValue = null;
        if (configProvider != null) {
            returnValue = configProvider.getValue();
        }
        return returnValue;
    }

    /**
     * {@inheritDoc}
     */
    public void setValue(Value value, IAssignmentState state) throws ConfigurationException {
        configProvider.setValue(value, state);
    }

    /**
     * {@inheritDoc}
     */
    public IAssignmentState getState() {
        return configProvider.getState();
    }

    /**
     * {@inheritDoc}
     */
    public AbstractVariable getDeclaration() {
        return declaration;
    }
    
    /**
     * {@inheritDoc}
     */
    public void freeze() {
        configProvider.freeze();
        // >> needed for VIL!
        for (int a = 0; a < getAttributesCount(); a++) {
            getAttribute(a).freeze();
        }
        // >> needed for VIL!
    }
    
    @Override
    public String toString() {
        String result = declaration.getName();
        if (null != getValue()) {
            result += " = " + getValue().toString();
        }
        return result;
    }
    
    /**
     * {@inheritDoc}
     */
    public final int getNestedDepth() {
        int depth = 0;
        
        if (isNested()) {
            IDecisionVariable parent = (IDecisionVariable) this.parent;
            depth = parent.getNestedDepth() + 1;
        } 
        
        return depth;
    }
    
    /**
     * Changes the index of the nested {@link DecisionVariable}. This method is only supported if this variable
     * is nested inside a {@link ContainerVariable}.
     * This method must be called after a nested element was removed out of the container, to ensure
     * that this variable will retrieve the correct sub value of the related {@link ContainerVariable}.
     * this method will also ensure that this nested Variable will display the correct name.
     * @param newIndex The new index inside the parent {@link IDecisionVariable}.
     * This value must be in the range (this is not checked):
     * (<tt>0 &lt;= newIndex &lt; getParent().getNestedElementsCount()</tt>)
     */
    void setIndex(int newIndex) {
        if (configProvider instanceof ContainerItemConfigProvider) {
            ContainerItemConfigProvider conItemProvider = (ContainerItemConfigProvider) configProvider;
            ContainerVariable parent = conItemProvider.getParent();
            String newName = parent.getElementName(newIndex);
            declaration = new DecisionVariableDeclaration(newName, declaration.getType(), declaration.getParent());
            conItemProvider.setIndex(newIndex);
        }
    }
    
    /**
     * Getter for the {@link VariableConfigProvider}.
     * @return Returns the {@link VariableConfigProvider} used in this class.
     * This {@link VariableConfigProvider} should not be <tt>null</tt>, however,
     * it can be <tt>null</tt> during initialization it can be <tt>null</tt>.
     */
    VariableConfigProvider getConfigProvider() {
        return configProvider;
    }
    
    /**
     * Returns whether this variable can have its own {@link IAssignmentState}.
     * @return <tt>false</tt> if one of the parents is a {@link ContainerVariable},
     * otherwise it should be <tt>true</tt>.
     */
    boolean ownStateAllowed() {
        boolean ownStateallowed = configProvider.isStateChangeAllowed();
        if (ownStateallowed && isNested() && null != getParent()) {
            ownStateallowed = ((DecisionVariable) getParent()).ownStateAllowed();
        }
        return ownStateallowed;
    }
    
    /**
     * {@inheritDoc}
     */
    public boolean isVisible() {
        return isVisible;
    }
    
    /**
     * {@inheritDoc}
     */
    public void setHistoryValue(Value value, IAssignmentState state) throws ConfigurationException {
        configProvider.setHistoryValue(value, state);
    }
    
    /**
     * {@inheritDoc}
     */
    public boolean hasValue() {
        return null != getValue() && null != getValue().getValue();
    }
    
    /**
     * {@inheritDoc}
     */
    public boolean hasNullValue() {
        return getValue() instanceof NullValue;
    }
}
