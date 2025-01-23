package net.ssehub.easy.instantiation.core.model.vilTypes.configuration;

import java.util.ArrayList;
import java.util.List;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.instantiation.core.Bundle;
import net.ssehub.easy.instantiation.core.model.vilTypes.ArraySequence;
import net.ssehub.easy.instantiation.core.model.vilTypes.ArraySet;
import net.ssehub.easy.instantiation.core.model.vilTypes.IActualTypeProvider;
import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;
import net.ssehub.easy.instantiation.core.model.vilTypes.OperationMeta;
import net.ssehub.easy.instantiation.core.model.vilTypes.ReturnGenerics;
import net.ssehub.easy.instantiation.core.model.vilTypes.Sequence;
import net.ssehub.easy.instantiation.core.model.vilTypes.Set;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.UnmodifiableSequence;
import net.ssehub.easy.instantiation.core.model.vilTypes.UnmodifiableSet;
import net.ssehub.easy.reasoning.core.frontend.ReasonerAdapter;
import net.ssehub.easy.reasoning.core.impl.ReasonerHelper;
import net.ssehub.easy.reasoning.core.reasoner.Message;
import net.ssehub.easy.reasoning.core.reasoner.ValueCreationResult;
import net.ssehub.easy.varModel.confModel.AssignmentState;
import net.ssehub.easy.varModel.confModel.ConfigurationException;
import net.ssehub.easy.varModel.confModel.ContainerVariable;
import net.ssehub.easy.varModel.confModel.IAssignmentState;
import net.ssehub.easy.varModel.confModel.IConfiguration;
import net.ssehub.easy.varModel.confModel.IConfigurationElement;
import net.ssehub.easy.varModel.confModel.IConfigurationVisitor;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.confModel.IFreezeSelector;
import net.ssehub.easy.varModel.confModel.paths.IResolutionPathElement;
import net.ssehub.easy.varModel.confModel.paths.StartPathElement;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.Container;
import net.ssehub.easy.varModel.model.datatypes.DerivedDatatype;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.IntegerType;
import net.ssehub.easy.varModel.model.datatypes.Reference;
import net.ssehub.easy.varModel.model.datatypes.TypeQueries;
import net.ssehub.easy.varModel.model.values.CompoundValue;
import net.ssehub.easy.varModel.model.values.ContainerValue;
import net.ssehub.easy.varModel.model.values.NullValue;
import net.ssehub.easy.varModel.model.values.ReferenceValue;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;

/**
 * Wraps a decision variable. Primitive values may be obtained using the getter methods. Complex
 * values such as compounds or containers may be provided by subclasses.
 * 
 * @author Holger Eichelberger
 */
public abstract class AbstractIvmlVariable extends IvmlElement implements IActualTypeProvider {

    private static final ValueVisitor VALUE_VISITOR = new ValueVisitor();
    protected IDecisionVariable origVariable;
    protected IDecisionVariable variable;
    protected IVariableFilter filter;
    private DecisionVariable[] nested;
    private Configuration config;
    
    /**
     * Creates a new IVML variable.
     * 
     * @param cfg the parent configuration
     * @param variable the variable to be wrapped
     * @param filter the variable filter to apply
     */
    protected AbstractIvmlVariable(Configuration cfg, IDecisionVariable variable, IVariableFilter filter) {
        origVariable = variable; // keep the variable before dereferencing it
        this.variable = variable;
        this.config = cfg;
        this.filter = filter;
        Value val = variable.getValue();
        if (val instanceof ReferenceValue) {
            // dereference
            AbstractVariable referenced = ((ReferenceValue) val).getValue();
            if (null != referenced) {
                IConfiguration config = variable.getConfiguration();
                this.variable = config.getDecision(referenced);
                if (null == this.variable) {
                    this.variable = origVariable; // search for??
                }
            }
        }
    }
    
    /**
     * Returns the configuration.
     * 
     * @return the configuration
     */
    @Invisible
    public Configuration getConfiguration() {
        return config;
    }
    
    /**
     * Returns whether this instances holds <code>var</code>.
     * 
     * @param var the variable to look for
     * @return <code>true</code> if <code>var</code> is held by this instance, <code>false</code> else
     */
    @Invisible
    public boolean isVariable(IDecisionVariable var) {
        return origVariable == var || variable == var;
    }
    
    /**
     * Returns the parent of this variable.
     * 
     * @return the parent if it exists
     */
    public IvmlElement getParent() {
        IvmlElement result = config;
        IConfigurationElement elt = variable.getParent();
        if (elt instanceof IDecisionVariable) {
            result = config.findVariable((IDecisionVariable) elt);
        }
        return result;
    }

    @Override
    protected void initializeNested() {
        if (null == nested) {
            if (variable.getNestedElementsCount() > 0) {
                List<DecisionVariable> tmp = new ArrayList<DecisionVariable>();
                nested = new DecisionVariable[variable.getNestedElementsCount()];
                for (int n = 0; n < variable.getNestedElementsCount(); n++) {
                    IDecisionVariable var = variable.getNestedElement(n);
                    if (filter.isEnabled(var)) {
                        tmp.add(new DecisionVariable(config, var, filter));
                    }
                }
                nested = tmp.toArray(new DecisionVariable[tmp.size()]);
            } else {
                Value val = variable.getValue();
                if (val instanceof ContainerValue) {
                    ContainerValue cont = (ContainerValue) val;
                    nested = new DecisionVariable[cont.getElementSize()];
                    for (int n = 0; n < nested.length; n++) {
                        // FILTER???
                        nested[n] = new DecisionVariable(config, 
                            new DecVar(variable, cont.getElement(n), null), filter);
                    }
                }
            }
        }
    }
    
    /**
     * Implements a dynamic mapping of nested (container) values to temporary decision variables.
     * Nested container values do not have attributes.
     * 
     * @author Holger Eichelberger
     */
    private static class DecVar implements IDecisionVariable {

        private IDecisionVariable parent;
        private Value value;
        private DecisionVariableDeclaration decl;
        private IDecisionVariable[] nested;
        
        /**
         * Creates a temporary decision variable.
         * 
         * @param parent the parent variable
         * @param value the actual value
         * @param decl the related decision variable declaration (may be <b>null</b>, then a temporary one is created)
         */
        private DecVar(IDecisionVariable parent, Value value, DecisionVariableDeclaration decl) {
            this.parent = parent;
            this.value = value;
            if (null == decl) {
                this.decl = new DecisionVariableDeclaration("", value.getType(), parent.getDeclaration().getParent());
            } else {
                this.decl = decl;
            }
        }
        
        /**
         * Initializes nested variables.
         */
        private void initializeNested() {
            if (null == nested) {
                if (value instanceof CompoundValue) {
                    CompoundValue comp = (CompoundValue) value;
                    Compound type = (Compound) comp.getType();
                    nested = new IDecisionVariable[type.getElementCount()];
                    for (int i = 0; i < nested.length; i++) {
                        DecisionVariableDeclaration d = type.getElement(i);
                        nested[i] = new DecVar(this, comp.getNestedValue(d.getName()), d);
                    }
                } else if (value instanceof ContainerValue) {
                    ContainerValue cont = (ContainerValue) value;
                    nested = new IDecisionVariable[cont.getElementSize()];
                    for (int i = 0; i < nested.length; i++) {
                        nested[i] = new DecVar(this, cont.getElement(i), null);
                    }
                }
            }
        }
        
        @Override
        public IConfigurationElement getParent() {
            return parent;
        }

        @Override
        public net.ssehub.easy.varModel.confModel.Configuration getConfiguration() {
            return parent.getConfiguration();
        }

        @Override
        public boolean isNested() {
            return true;
        }

        @Override
        public IAssignmentState getState() {
            return parent.getState();
        }

        @Override
        public void setValue(Value value, IAssignmentState state, IConfigurationElement nested)
            throws ConfigurationException {
            // temporary only, do not allow setting
        }

        @Override
        public void freeze(IFreezeSelector selector) {
            // temporary only, do not allow freeze
        }

        @Override
        public void unfreeze(IAssignmentState state) {
            // temporary only, do not allow freeze
        }

        @Override
        public void freeze(String nestedElement) {
            // temporary only, do not allow freeze
        }

        @Override
        public AbstractVariable getDeclaration() {
            return decl;
        }

        @Override
        public void accept(IConfigurationVisitor visitor) {
            visitor.visitDecisionVariable(this);
        }

        @Override
        public Value getValue() {
            return value;
        }

        @Override
        public void setValue(Value value, IAssignmentState state) throws ConfigurationException {
            // temporary only, do not allow setting
        }
        
        @Override
        public void setValue(Value value, IAssignmentState state, boolean asAssignment) throws ConfigurationException {
            // temporary only, do not allow setting
        }

        @Override
        public void setHistoryValue(Value value, IAssignmentState state) throws ConfigurationException {
            // temporary only, do not allow setting
        }

        @Override
        public int getNestedElementsCount() {
            initializeNested();
            return null == nested ? 0 : nested.length;
        }

        @Override
        public IDecisionVariable getNestedElement(int index) {
            initializeNested();
            if (null == nested) {
                throw new IndexOutOfBoundsException();
            } 
            return nested[index];
        }


        @Override
        public IDecisionVariable getNestedElement(String name) {
            return net.ssehub.easy.varModel.confModel.Configuration.getNestedElement(this, name);
        }

        @Override
        public int getAttributesCount() {
            return parent.getAttributesCount();
        }

        @Override
        public IDecisionVariable getAttribute(int index) {
            return parent.getAttribute(index);
        }

        @Override
        public int getNestedDepth() {
            return 0;
        }

        @Override
        public boolean isVisible() {
            return false;
        }

        @Override
        public boolean hasValue() {
            return value != null;
        }

        @Override
        public boolean hasNullValue() {
            return value == null || NullValue.INSTANCE == value;
        }

        @Override
        public boolean removeDerivedValues() {
            // TODO SE: Unclear whether it's needed here.
            return false;
        }
        
        @Override
        public String getQualifiedName() {
            return getDeclaration().getQualifiedName();
        }
        
        @Override
        public IResolutionPathElement getResolutionPath() {
            return new StartPathElement(getDeclaration()); // unclear for now
        }
        
        @Override
        public boolean isLocal() {
            return false;
        }

        @Override
        public boolean wasCreated() {
            return true;
        }
        
        @Override
        public void notifyCreated() {
        }

        @Override
        public boolean notifyWasAssigned(Value value) {
            return false; // not relevant here, disabled see #enableWasAssignedForIsDefined
        }

        @Override
        public boolean wasAssigned() {
            return true;
        }

        @Override
        public boolean enableWasAssignedForIsDefined() {
            return false;
        }    

    }
    
    /**
     * Returns the underlying IVML (un-dereferenced) variable.
     * 
     * @return the underlying IVML variable
     */
    @Invisible
    public IDecisionVariable getVariable() {
        return origVariable;
    }
    
    /**
     * Returns the actual IVML type of <code>decVar</code>.
     * 
     * @return the IVML type, if possible the actual, dynamic type, else the declared type
     */
    @Invisible
    public IDatatype getActualType() {
        IDatatype dType = null;
        // try to get actual type, don't use IVML null as type is anytype -> use then variable declaration
        Value val = origVariable.getValue();
        if (null != val && NullValue.INSTANCE != val) {
            dType = val.getType();
        } else {
            dType = origVariable.getDeclaration().getType();
        }
        return dType;
    }

    /**
     * Returns the simple name of the decision variable.
     * 
     * @return the simple name
     */
    public String getName() {
        return origVariable.getDeclaration().getName();
    }

    /**
     * Returns the qualified name of the decision variable.
     * 
     * @return the qualified name
     */
    public String getQualifiedName() {
        return origVariable.getDeclaration().getQualifiedName();
    }

    /**
     * Returns the name of the underlying decision variable.
     * If the variable is referenced (via a reference), then the name of the referenced variable
     * will be returned instead of the variable representing the reference.
     * 
     * @return the name of the underlying decision variable 
     */
    public String getVarName() {
        return variable.getDeclaration().getName();
    }

    /**
     * Returns the name of the underlying decision variable.
     * If the variable is referenced (via a reference), then the qualified name of the referenced variable
     * will be returned instead of the variable representing the reference.
     * 
     * @return the qualified name of the underlying decision variable 
     */
    public String getQualifiedVarName() {
        return variable.getDeclaration().getName();
    }
    
    /**
     * Returns the type of the (dereferenced) decision variable (VIL view).
     * 
     * @return the type (if configured the dynamic, actual type), else the defined type
     */
    public TypeDescriptor<?> getType() {
        IDatatype type;
        Value value = getDecisionVariable().getValue();
        if (null != value) {
            // return the dynamic type if possible
            type = value.getType();
        } else {
            type = getIvmlType();
        }
        return getTypeDescriptor(type);
    }

    /**
     * Returns the simple type name of the (dereferenced) decision variable (VIL view).
     * 
     * @return the simple type name
     */
    public String getTypeName() {
        return getIvmlType().getName();
    }

    /**
     * Returns the declared IVML type of the (dereferenced) decision variable (VIL view).
     * 
     * @return the IVML type
     */
    @Invisible
    public IDatatype getIvmlType() {
        return variable.getDeclaration().getType();
    }

    /**
     * Returns the qualified type name of the decision variable.
     * 
     * @return the qualified type name
     */
    public String getQualifiedType() {
        return origVariable.getDeclaration().getType().getQualifiedName();
    }

    /**
     * Returns whether the underlying decision variable is configured. Please note that
     * this is different from {@link #isNull()} as a null value is considered as configured.
     * 
     * @return <code>true</code> if the variable is configured, <code>false</code> else
     */
    @OperationMeta(name = {"isConfigured", "isDefined"})
    public boolean isConfigured() {
        return AssignmentState.UNDEFINED != origVariable.getState() && null != origVariable.getValue();
    }

    /**
     * Returns whether this element is frozen.
     * 
     * @return <code>true</code> if it is frozen, <code>false</code> else
     */
    public boolean isFrozen() {
        // TODO check parent state - as variable from above!
        return AssignmentState.FROZEN == origVariable.getState();
    }

    /**
     * Clears the actual variable. Has no effect if frozen.
     */
    public void clearValue() {
        // easy implicitly assigned Java "default" values to top-level variables
        // this is not done here - don't know where this happens
        try {
            origVariable.setValue(null, AssignmentState.UNDEFINED);
        } catch (ConfigurationException e) {
        }
    }

    /**
     * Changes the value of this variable. This method works only if the variable
     * is not {@link #isFrozen() frozen}, in particular at runtime.
     * 
     * @param value the new value
     */
    public void setValue(Object value) {
        if (!isFrozen()) {
            IDecisionVariable toChange = variable;
            // if I'm a reference, I expect a variable declaration
            boolean refVar = Reference.TYPE.isAssignableFrom(origVariable.getDeclaration().getType());
            if (value instanceof AbstractIvmlVariable && refVar) {
                IDecisionVariable newVar = ((AbstractIvmlVariable) value).variable; 
                toChange = null;
                changeValue(origVariable, newVar.getDeclaration()); // the dereferenced one
                nested = null; // TODO reset attributes
                variable = newVar;
            } else if (null == value && refVar) {
                toChange = null;
                changeValue(origVariable, null);
                nested = null; // TODO reset attributes
                variable = origVariable;
            } else if (value instanceof IvmlElement) {
                value = ((IvmlElement) value).getValue();
            }
            if (null != toChange) {
                changeValue(toChange, value);
            }
        } else {
            EASyLoggerFactory.INSTANCE.getLogger(getClass(), Bundle.ID).error(
                "setting " + value + " as new value is not possible as variable " 
                    + net.ssehub.easy.varModel.confModel.Configuration.getInstanceName(variable) + " is frozen");
        }
    }

    /**
     * Changes the value of the given variable.
     * 
     * @param toChange the variable to change
     * @param value the new value
     */
    private void changeValue(IDecisionVariable toChange, Object value) {
        if (null == value) { // VIL null / undefined is handled while evaluating the field value expression
            value = NullValue.INSTANCE;
        }
        IDatatype varType = toChange.getDeclaration().getType();
        if (TypeQueries.sameTypes(IntegerType.TYPE, varType) && value instanceof Double) {
            value = ((Double) value).intValue();
        }
        try {
            Value oldValue = toChange.getValue();
            if (null != oldValue) {
                oldValue = oldValue.clone();
            }
            Value val;
            if (value instanceof Value) {
                val = (Value) value;
            } else {
                val = ValueFactory.createValue(varType, value);
            }
            IAssignmentState varState = toChange.getState();
            if (AssignmentState.UNDEFINED == varState) {
                varState = AssignmentState.USER_ASSIGNED;
            } else if (AssignmentState.ASSIGNED == varState) {
                // for now, just be careful when overriding the assigned state; USER_ASSIGNED forces the reasoner 
                // to recalculate dependent values
                varState = AssignmentState.USER_ASSIGNED; 
            }
            toChange.setValue(val, varState);
            config.notifyValueChanged(this, oldValue);
        } catch (ConfigurationException e) {
            EASyLoggerFactory.INSTANCE.getLogger(getClass(), Bundle.ID).error("while changing " + getName()
                + " with value " + value + ": " + e.getMessage());
        } catch (ValueDoesNotMatchTypeException e) {
            EASyLoggerFactory.INSTANCE.getLogger(getClass(), Bundle.ID).error("while changing " + getName()
                + " with value " + value + ": " + e.getMessage());
        }
    }
    
    /**
     * Returns the original value before any change. Intended for runtime reconfiguration.
     * In VIL, this always returns the value of {@link #getValue()}
     * 
     * @return the original value
     */
    public Object getOriginalValue() {
        Object result = null;
        Value val = config.getChangeHistory().getOriginalValue(this);
        if (null != val) {
            synchronized (VALUE_VISITOR) { // just to be sure
                VALUE_VISITOR.clear();
                val.accept(VALUE_VISITOR);
                result = VALUE_VISITOR.getValue();
            }
        }
        return result;
    }
    
    /**
     * Returns value into the corresponding (VIL) object value.
     * 
     * @param value the value
     * @return the object value
     */
    @Invisible
    public static Object toObject(Value value) {
        Object result = null;
        if (null != value) {
            synchronized (VALUE_VISITOR) { // just to be sure
                VALUE_VISITOR.clear();
                value.accept(VALUE_VISITOR);
                result = VALUE_VISITOR.getValue();
            }
        }
        return result;
    }

    @Override
    public Object getValue() { 
        return toObject(variable.getValue());
    }

    @Override
    public String getStringValue() {
        String result = null;
        if (null != variable.getValue()) {
            synchronized (VALUE_VISITOR) { // just to be sure
                VALUE_VISITOR.clear();
                variable.getValue().accept(VALUE_VISITOR);
                result = VALUE_VISITOR.getStringValue();
            }
            if (null == result) {
                Object o = variable.getValue().getValue();
                if (null != o) {
                    result = o.toString();
                }
            }
        }
        return result;
    }

    @Override
    public Integer getIntegerValue() {
        Integer result = null;
        if (null != variable.getValue()) {
            synchronized (VALUE_VISITOR) { // just to be sure
                VALUE_VISITOR.clear();
                variable.getValue().accept(VALUE_VISITOR);
                result = VALUE_VISITOR.getIntegerValue();
            }
        }
        return result;
    }

    @Override
    public Double getRealValue() {
        Double result = null;
        if (null != variable.getValue()) {
            synchronized (VALUE_VISITOR) { // just to be sure
                VALUE_VISITOR.clear();
                variable.getValue().accept(VALUE_VISITOR);
                result = VALUE_VISITOR.getDoubleValue();
            }
        }
        return result;
    }
    
    @Override
    public Boolean getBooleanValue() {
        Boolean result = null;
        if (null != variable.getValue()) {
            synchronized (VALUE_VISITOR) { // just to be sure
                VALUE_VISITOR.clear();
                variable.getValue().accept(VALUE_VISITOR);
                result = VALUE_VISITOR.getBooleanValue();
            }
        }
        return result;
    }

    @Override
    public EnumValue getEnumValue() {
        EnumValue result = null;
        if (null != variable.getValue()) {
            synchronized (VALUE_VISITOR) { // just to be sure
                VALUE_VISITOR.clear();
                variable.getValue().accept(VALUE_VISITOR);
                result = VALUE_VISITOR.getEnumValue();
            }
        }
        return result;
    }
    
    /**
     * Returns the decision variables contained in this variable. This shall be a sequence
     * to implicitly handle IVML sequences. Primitive values may be obtained using the getter methods. Complex
     * values such as compounds or containers may be accessed via {@link #variables()}.
     * 
     * @return the decision variables (unmodifiable)
     */
    @ReturnGenerics(DecisionVariable.class )
    public Sequence<DecisionVariable> variables() {
        initializeNested();
        return new UnmodifiableSequence<DecisionVariable>(
            new ArraySequence<DecisionVariable>(nested, DecisionVariable.class));
    }

    /**
     * Returns the decision variables contained in this variable as a set.
     * 
     * @return the decision variables (unmodifiable)
     */
    @Invisible
    @ReturnGenerics(DecisionVariable.class )
    public Set<DecisionVariable> variablesSet() {
        initializeNested();
        return new UnmodifiableSet<DecisionVariable>(
            new ArraySet<DecisionVariable>(nested, DecisionVariable.class));
    }
    
    /**
     * Returns a projected configuration on all nested variables.
     * 
     * @return the projected configuration
     */
    public Configuration selectAll() {
        initializeNested();
        return new Configuration(variable.getConfiguration(), nested, filter);
    }

    /**
     * Returns the annotations for this variable.
     * 
     * @return the decision variables
     */
    @ReturnGenerics(Attribute.class)
    public abstract Set<Attribute> attributes();
    // TODO remove -> annotations
    
    /**
     * Returns the annotations for this variable.
     * 
     * @return the decision variables
     */
    @ReturnGenerics(Attribute.class)
    public abstract Set<Attribute> annotations();

    @Override
    public int hashCode() {
        return variable.hashCode();
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof AbstractIvmlVariable && variable.equals(((AbstractIvmlVariable) object).variable);
    }

    @Override
    public IvmlElement getElement(String name) {
        initializeNested();
        initializeAttributes();
        IvmlElement result = search(name, nested);
        if (null == result) {
            for (int a = 0; null == result && a < getAttributeCount(); a++) {
                result = checkElement(name, getAttribute(a));
            }
        }
        return result;
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
     * Return the underlying decision variable for internal purpose, such as velocity.
     * 
     * @return the decision variable
     */
    @Invisible
    public IDecisionVariable getDecisionVariable() {
        return variable;
    }
    
    /**
     * Returns the declaration of this variable in terms of VIL/VTL instances.
     * 
     * @return the declaration
     */
    public IvmlDeclaration getDeclaration() {
        return new IvmlDeclaration(variable.getDeclaration());
    }

    @Override
    @Invisible
    public String getInstanceName() {
        return net.ssehub.easy.varModel.confModel.Configuration.getInstanceName(getVariable());
    }
    
    /**
     * Returns the logger for this class.
     * 
     * @return the logger
     */
    private EASyLogger getLogger() {
        return EASyLoggerFactory.INSTANCE.getLogger(AbstractIvmlVariable.class, Bundle.ID);
    }

    /**
     * Creates a value matching to this variable and tries to assign it. Failures will be logged
     * and ignored.
     *
     * @param override try overriding the existing value (<code>true</code>) or just do nothing if a value already 
     *    exists (<code>false</code>)
     */
    public void createValue(boolean override) {
        createValue(getType(), override);
    }
    
    /**
     * Creates a value matching to this variable and tries to assign it. Failures will be logged
     * and ignored.
     *
     * @param type the type of value to create
     * @param override try overriding the existing value (<code>true</code>) or just do nothing if a value already 
     *    exists (<code>false</code>)
     */
    public void createValue(TypeDescriptor<?> type, boolean override) {
        if (null != variable && (override || (!override && !isConfigured()))) {
            if (type instanceof IvmlTypeDescriptor) {
                IDatatype t = ((IvmlTypeDescriptor) type).getIvmlType();
                if (variable.getDeclaration().getType().isAssignableFrom(t)) {
                    createValue(variable, t);
                } else {
                    getLogger().warn("given type is not compatible to variable type");
                }
            }
        }
    }
    
    /**
     * Creates a value for the given {@code type} via {@link ReasonerAdapter#getInstanceSafe() a safe reasoner adapter}.
     * 
     * @param var the target variable to modify
     * @param type the type to create the value for
     * @see #createValue(IDecisionVariable, IDatatype)
     */
    private void createValue(IDecisionVariable var, IDatatype type) {
        ValueCreationResult vRes = ReasonerAdapter.getInstanceSafe().createValue(
            var.getConfiguration().getConfiguration(), var.getDeclaration(), 
            type, null, ProgressObserver.NO_OBSERVER);
        
        for (int m = 0; m < vRes.getMessageCount(); m++) {
            Message msg = vRes.getMessage(m);
            getLogger().warn(msg.getDescription());
        }
        if (vRes.getVariable() != null) {
            transferState(vRes.getVariable(), var);
            try {
                var.setValue(vRes.getVariable().getValue(), AssignmentState.ASSIGNED);
            } catch (ConfigurationException e) {
                getLogger().warn(e.getMessage());
            }
        }
    }

    /**
     * Transfers the states between {@code source} and {@code target}. May be required if
     * the configuration initialization just freezes everything without evaluating constraints.
     * The given variables must be of the same type.
     * 
     * @param source the source variable to take the states from
     * @param target the target the target variable to apply the states to
     */
    private static void transferState(IDecisionVariable source, IDecisionVariable target) {
        if (source.getState() != target.getState()) {
            if (AssignmentState.FROZEN == target.getState()) {
                // usually not needed, only if configuration is not exactly frozen
                if (source.getConfiguration().getConfiguration().isApproximatelyFrozen()) {
                    target.unfreeze(source.getState());
                }
            } else {
                try {
                    target.setValue(source.getValue(), source.getState());
                } catch (ConfigurationException e) {
                    EASyLoggerFactory.INSTANCE.getLogger(ReasonerHelper.class, Bundle.ID)
                        .warn("transferState: " + e.getMessage());
                }
            }
        }
        for (int a = 0; a < source.getAttributesCount(); a++) {
            IDecisionVariable sAttr = source.getAttribute(a);
            IDecisionVariable tAttr = target.getAttribute(a);
            transferState(sAttr, tAttr);
        }
        for (int n = 0; n < source.getNestedElementsCount(); n++) {
            IDecisionVariable sNested = source.getNestedElement(n);
            IDecisionVariable tNested = target.getNestedElement(sNested.getDeclaration().getName());
            if (null == tNested) { // position as fallback
                tNested = target.getNestedElement(n);
            }
            if (null != tNested) {
                transferState(sNested, tNested);
            }
        }
    }
    
    /**
     * Adds a value if the actual variable represents an IVML collection. The declared element type is used
     * as type of the new value.
     * 
     * @return the added variable
     */
    public DecisionVariable addValue() {
        DecisionVariable result = null;
        if (null != variable) {
            IDatatype vType = DerivedDatatype.resolveToBasis(variable.getDeclaration().getType());
            if (Container.TYPE.isAssignableFrom(vType) && vType.getGenericTypeCount() > 0) {
                result = addValue(vType.getGenericType(0));
            } else {
                getLogger().warn("given type is not a container");
            }
        }
        return result;
    }

    /**
     * Adds a value if the actual variable represents an IVML collection.
     * 
     * @param type the desired type of the new variable (must be compatible to the element type of the 
     *     underlying collection)
     * @return the added variable
     */
    public DecisionVariable addValue(TypeDescriptor<?> type) {
        DecisionVariable result = null;
        if (null != variable && type instanceof IvmlTypeDescriptor) {
            IDatatype vType = DerivedDatatype.resolveToBasis(variable.getDeclaration().getType());
            if (Container.TYPE.isAssignableFrom(vType) && vType.getGenericTypeCount() > 0) {
                IDatatype iType = ((IvmlTypeDescriptor) type).getIvmlType();
                if (vType.getGenericType(0).isAssignableFrom(iType)) {
                    result = addValue(iType);
                } else {
                    getLogger().warn("given type is not compatible to container element type");
                }
            } else {
                getLogger().warn("given type is not a container");
            }
        }
        return result;
    }

    /**
     * adds a value of a given type to a container.
     * 
     * @param type the type
     * @return the created variable
     * @see #createValue(IDecisionVariable, IDatatype)
     */
    private DecisionVariable addValue(IDatatype type) {
        DecisionVariable result = null;
        if (variable instanceof ContainerVariable) {
            ContainerVariable cVariable = (ContainerVariable) variable;
            IDecisionVariable var = cVariable.addNestedElement(type);
            createValue(var, type);
            if (filter.isEnabled(var)) {
                result = new DecisionVariable(config, var, filter);
                int nestedLength = null == nested ? 0 : nested.length;
                DecisionVariable[] tmp = new DecisionVariable[nestedLength + 1];
                if (null != nested) {
                    System.arraycopy(nested, 0, tmp, 0, nestedLength);
                }
                tmp[nestedLength] = result;
                nested = tmp;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        String result;
        AbstractVariable decl = variable.getDeclaration();
        if (null == decl || variable.getValue() == null) { // QM2 tests after migration to Java 17 (?)
            result = "<null>";
        } else {
            result = decl.getType().toString() + " " + decl.getName() + " = " + variable.getValue().toString();
        }
        return result;
    }

    
    @Override
    @Invisible
    public IDatatype determineActualTypeName() {
        IDatatype type;
        IDatatype declType = getDecisionVariable().getDeclaration().getType();
        IDatatype actType = getActualType();
        // this is a rather strange part - shall depend on variable, but does not seem to work in all cases
        if (TypeQueries.isCompound(declType) && !TypeQueries.isReference(actType)) {
            type = actType;
        } else if (TypeQueries.isCompound(declType) && TypeQueries.isReference(actType)) {
            type = declType;
            if (null != variable && null != variable.getValue() 
                && type.isAssignableFrom(variable.getValue().getType())) {
                type = variable.getValue().getType();
            }
        } else {
            type = declType;
        }
        return type;
    }

}
