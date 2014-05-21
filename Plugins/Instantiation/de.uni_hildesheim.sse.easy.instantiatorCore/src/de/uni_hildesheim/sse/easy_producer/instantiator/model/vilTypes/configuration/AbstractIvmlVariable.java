package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArraySequence;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Invisible;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationMeta;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Sequence;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Set;
import de.uni_hildesheim.sse.model.confModel.ContainerVariable;
import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
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
    private DecisionVariable[] nested;
    
    /**
     * Creates a new IVML variable.
     * 
     * @param variable the variable to be wrapped
     */
    protected AbstractIvmlVariable(IDecisionVariable variable) {
        origVariable = variable; // keep the variable before dereferencing it
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
        if (null == nested && variable.getNestedElementsCount() > 0) {
            nested = new DecisionVariable[variable.getNestedElementsCount()];
            for (int n = 0; n < nested.length; n++) {
                nested[n] = new DecisionVariable(variable.getNestedElement(n));
            }
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
        return new Configuration(variable.getConfiguration(), nested);
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

}
