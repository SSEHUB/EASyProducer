package de.uni_hildesheim.sse.model.varModel;

import de.uni_hildesheim.sse.Bundle;
import de.uni_hildesheim.sse.model.cst.CSTSemanticException;
import de.uni_hildesheim.sse.model.cst.ConstantValue;
import de.uni_hildesheim.sse.model.cst.ConstraintSyntaxTree;
import de.uni_hildesheim.sse.model.varModel.datatypes.DerivedDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDerivedDatatypeListener;
import de.uni_hildesheim.sse.model.varModel.values.Value;
import de.uni_hildesheim.sse.model.varModel.values.ValueDoesNotMatchTypeException;
import de.uni_hildesheim.sse.model.varModel.values.ValueFactory;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;

/**
 * Defines an abstract variable.
 * @author Marcel Lueder
 * @author Holger Eichelberger
 */
public abstract class AbstractVariable extends ContainableModelElement implements IAttributeAccess,
    IDerivedDatatypeListener {
    
    private IDatatype type;
    //private Value defaultValue;
    private ConstraintSyntaxTree defaultValue;
    
    /**
     * Constructor for decision variable declaration.
     * @param name Name of the decision variable declaration
     * @param type type of the new VariableDeclaration
     * @param parent the object, in which this specific one is embedded
     */
    public AbstractVariable(String name, IDatatype type, IModelElement parent) {
        this(name, type, null, parent);
    }
    
    /**
     * Constructor for explicit variable creation.
     * @param name Name of the decision variable declaration
     * @param type type of the new VariableDeclaration
     * @param defaultValue the default value (may be <b>null</b>)
     * @param parent the object, in which this specific one is embedded
     */
    public AbstractVariable(String name, IDatatype type, Value defaultValue, IModelElement parent) {
        super(name, parent);
        this.type = type;
        // Cannot use isAssignablefrom, otherwise you would get InitializeException
        if (type instanceof DerivedDatatype) {
            DerivedDatatype derivedType = (DerivedDatatype) type;
            derivedType.register(this);
        }
        constraintsChanged();
        if (null != defaultValue) {
            this.defaultValue = new ConstantValue(defaultValue);
        }
    }
    
    /**
     * Defines the default value. Note that this method provides exactly one value, not
     * multiple as required in case of containers or compounds.
     * 
     * @param value the default value.
     * @throws ValueDoesNotMatchTypeException if one of the default values do not comply
     *   to the respective types
     */
    public void setValue(String value) throws ValueDoesNotMatchTypeException {
        if (null == value) {
            defaultValue = null;
        } else {
            defaultValue = new ConstantValue(ValueFactory.createValue(type, value));
        }
    }

    /**
     * Defines the default value.
     * 
     * @param value the default value.
     * @throws ValueDoesNotMatchTypeException if one of the default values do not comply
     *   to the respective types
     * @throws CSTSemanticException in case of type resolution errors
     */
    public void setValue(ConstraintSyntaxTree value) 
        throws ValueDoesNotMatchTypeException, CSTSemanticException {
        IDatatype valueType = value.inferDatatype();
        if (!type.isAssignableFrom(valueType)) {
            throw new ValueDoesNotMatchTypeException("value is of type '"
                + valueType.getName() + "' but required is '" + type.getName() + "'", 
                ValueDoesNotMatchTypeException.TYPE_MISMATCH);
        }
        defaultValue = value;
    }

    /**
     * Defines (possible multiple) default value(s).
     * 
     * @param values the (possible) multiple values
     * @throws ValueDoesNotMatchTypeException if one of the default values do not comply
     *   to the respective types
     */
    public void setValue(Object... values) throws ValueDoesNotMatchTypeException {
        if (null == values) {
            defaultValue = null;
        } else {
            defaultValue = new ConstantValue(ValueFactory.createValue(type, values));
        }
    }
    
    /**
     * Getter for the value.
     * @return the value
     */
    public ConstraintSyntaxTree getDefaultValue() {
        return defaultValue;
    }
    
    /**
     * Returns the type of this variable.
     * 
     * @return the type of this variable
     */
    public IDatatype getType() {
        return type;
    }

    /**
     * Returns whether two variables are considered as being the same (same name/type). Please
     * consider that this method does not check for the scope, e.g., whether they are in the
     * same compound.
     * 
     * @param var the variable to check for
     * @return <code>true</code> if they are equal, <code>false</code> else
     */
    public boolean isSame(AbstractVariable var) {
        return getName().equals(var.getName()) && getType().equals(var.getType()); 
    }
    
    @Override
    public boolean equals(Object obj) {
        //Two objects are equal if they instances of the same class and have the same hashCode
        boolean equals = false;
        
        if (obj instanceof AbstractVariable) {
            equals = this.hashCode() == obj.hashCode();
        }
        
        return equals;
    }
    
    @Override
    public int hashCode() {
        //Two Abstract Variables are equal if they have the same qualified (including parent) name and type.
        int hashCode = getQualifiedName().hashCode();
        int typeHashCode = type.hashCode();
        if (0 != typeHashCode) {
            hashCode *= typeHashCode;
        }
        if (getParent() != getTopLevelParent()) {
            int parentCode = getParent().getQualifiedName().hashCode();
            
            if (0 != parentCode) {
                hashCode *= parentCode;
            }
        }
        
        return hashCode;
    }
    
    /**
     * Returns whether this decision variable declaration is used as 
     * a temporary variable (in constraints, i.e. the parent is a constraint).
     * 
     * @return <code>true</code> if it is a temporary variable, <code>false</code>
     * if it is a defined variable in the model
     */
    public abstract boolean isTemporaryVariable();
    
    
    /**
     * {@inheritDoc}
     */
    public void constraintsChanged() {
        //TODO SE: Remove old constraints if necessary
        try {
            InternalConstraint[] constraints = type.createConstraints(this);
            if (null != constraints) {
                Project project = (Project) getTopLevelParent();
                project.addInternalConstraints(constraints);
            }
        } catch (CSTSemanticException e) {
            EASyLoggerFactory.INSTANCE.getLogger(AbstractVariable.class, Bundle.ID).exception(e);
        }
    }
    
    /**
     * Returns whether this variable is an attribute.
     * 
     * @return <code>true</code> if it is an attribute, <code>false</code> else
     */
    public abstract boolean isAttribute();
}
