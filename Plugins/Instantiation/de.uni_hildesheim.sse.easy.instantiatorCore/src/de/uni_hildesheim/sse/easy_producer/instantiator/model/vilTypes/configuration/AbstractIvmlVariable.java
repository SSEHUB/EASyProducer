package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArraySequence;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Invisible;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationMeta;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Sequence;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Set;
import de.uni_hildesheim.sse.model.confModel.ConfigurationException;
import de.uni_hildesheim.sse.model.confModel.ContainerVariable;
import de.uni_hildesheim.sse.model.confModel.IAssignmentState;
import de.uni_hildesheim.sse.model.confModel.IConfigurationElement;
import de.uni_hildesheim.sse.model.confModel.IConfigurationVisitor;
import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;
import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
import de.uni_hildesheim.sse.model.varModel.values.CompoundValue;
import de.uni_hildesheim.sse.model.varModel.values.ContainerValue;
import de.uni_hildesheim.sse.model.varModel.values.NullValue;
import de.uni_hildesheim.sse.model.varModel.values.ReferenceValue;
import de.uni_hildesheim.sse.model.varModel.values.Value;

/**
 * Wraps a decision variable. Primitive values may be obtained using the getter methods. Complex
 * values such as compounds or containers may be provided by subclasses.
 * 
 * @author Holger Eichelberger
 */
public abstract class AbstractIvmlVariable extends IvmlElement {

    private static final ValueVisitor VALUE_VISITOR = new ValueVisitor();
    protected IDecisionVariable origVariable;
    protected IDecisionVariable variable;
    protected IVariableFilter filter;
    private DecisionVariable[] nested;
    
    /**
     * Creates a new IVML variable.
     * 
     * @param variable the variable to be wrapped
     * @param filter the variable filter to apply
     */
    protected AbstractIvmlVariable(IDecisionVariable variable, IVariableFilter filter) {
        origVariable = variable; // keep the variable before dereferencing it
        this.filter = filter;
        Value val = variable.getValue();
        if (val instanceof ReferenceValue) {
            // dereference
            DecisionVariableDeclaration referenced = ((ReferenceValue) val).getValue();
            this.variable = variable.getConfiguration().getDecision(referenced);
        } else {
            this.variable = variable;
        }
    }

    @Override
    protected void initializeNested() {
        if (null == nested) {
            if (variable.getNestedElementsCount() > 0) {
                nested = new DecisionVariable[variable.getNestedElementsCount()];
                for (int n = 0; n < nested.length; n++) {
                    nested[n] = new DecisionVariable(variable.getNestedElement(n), filter);
                }
            } else {
                Value val = variable.getValue();
                if (val instanceof ContainerValue) {
                    ContainerValue cont = (ContainerValue) val;
                    nested = new DecisionVariable[cont.getElementSize()];
                    for (int n = 0; n < nested.length; n++) {
                        nested[n] = new DecisionVariable(new DecVar(variable, cont.getElement(n), null), filter);
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
        public de.uni_hildesheim.sse.model.confModel.Configuration getConfiguration() {
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
        public void freeze() {
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
        
    }

    /**
     * Returns the simple name of the decision variable.
     * 
     * @return the simple name
     */
    public String getName() {
        IDecisionVariable var = origVariable;
        // somebody decided that it is cool to add the index to the name of a container variable 
        // trying to access the container variable itself
        while (var.getParent() instanceof ContainerVariable) {
            var = (ContainerVariable) var.getParent();
        }
        return var.getDeclaration().getName();
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
     * Returns the simple type name of the decision variable.
     * 
     * @return the simple type name
     */
    public String getType() {
        return variable.getDeclaration().getType().getName();
    }

    /**
     * Returns the qualified type name of the decision variable.
     * 
     * @return the qualified type name
     */
    public String getQualifiedType() {
        return origVariable.getDeclaration().getType().getQualifiedName();
    }

    @Override
    public Object getValue() { 
        Object result = null;
        if (null != variable.getValue()) {
            synchronized (VALUE_VISITOR) { // just to be sure
                VALUE_VISITOR.clear();
                variable.getValue().accept(VALUE_VISITOR);
                result = VALUE_VISITOR.getValue();
            }
        }
        return result;
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
     * @return the decision variables
     */
    @OperationMeta(returnGenerics = { DecisionVariable.class } )
    public Sequence<DecisionVariable> variables() {
        initializeNested();
        return new ArraySequence<DecisionVariable>(nested, DecisionVariable.class);
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
     * Returns the decision variables contained in this variable.
     * 
     * @return the decision variables
     */
    @OperationMeta(returnGenerics = { Attribute.class } )
    public abstract Set<Attribute> attributes();

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

}
