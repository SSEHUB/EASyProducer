package de.uni_hildesheim.sse.easy_producer.instantiator.model.common;

import java.util.ArrayList;
import java.util.List;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.Expression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.IResolvable;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ResolvableOperationExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IMetaOperation;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.basics.modelManagement.IVariable;

/**
 * Represents a variable declaration.
 * 
 * @author Christian Kröher
 * @author Holger Eichelberger
 */
public abstract class VariableDeclaration implements IResolvable, IVariable {

    private String name;
    private TypeDescriptor<?> type;
    private boolean isConstant;
    private Expression expression;
    private boolean hasExplicitType;
    private List<IModifier> modifiers;
    
    /**
     * Creates a new variable declaration. Explicit type is assumed.
     * 
     * @param name the name of the variable
     * @param type the type of the variable
     * 
     * @see #hasExplicitType()
     */
    public VariableDeclaration(String name, TypeDescriptor<?> type) {
        this(name, type, false, null);
    }

    /**
     * Creates a new variable declaration. Explicit type is assumed.
     * 
     * @param name the name of the variable
     * @param type the type of the variable
     * @param isConstant whether this variable is a constant
     * @param expression an expression denoting the initial value (may be <b>null</b>)
     * 
     * @see #hasExplicitType()
     */
    public VariableDeclaration(String name, TypeDescriptor<?> type, boolean isConstant, 
        Expression expression) {
        this.name = name;
        this.type = type;
        this.isConstant = isConstant;
        this.expression = expression;
        hasExplicitType = true;
    }

    /**
     * Get the name of this project element.
     * 
     * @return The name of this project element.
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Returns the type of this variable.
     * 
     * @return the type of this variable
     */
    public TypeDescriptor<?> getType() {
        return type;
    }
    
    /**
     * Define this variable as constant. By default, a variable is always not constant.
     * 
     * @param isConstant <b>true</b> if this variable is a constant. <b>False</b> otherwise.
     */
    public void setIsConstant(boolean isConstant) {
        this.isConstant = isConstant;
    }
    
    /**
     * Returns whether this variable is constant or not. By default, a variable is always not constant.
     * 
     * @return <b>True</b> if this variable is a constant. <b>False</b> otherwise.
     */
    public boolean isConstant() {
        return this.isConstant;
    }
    
    /**
     * Get the value of this variable.
     * 
     * @return The value of this variable of <b>null</b> if this variable is unassigned.
     */
    public Expression getExpression() {
        return expression;
    }

    /**
     * Accepts the given visitor for visiting this instance.
     * 
     * @param visitor the visitor
     * @return the result of visiting the given statement (may be <b>null</b>)
     * @throws VilException in case that visiting fails (e.g., execution)
     */
    public Object accept(IVisitor visitor) throws VilException {
        return visitor.visitVariableDeclaration(this);
    }
    
    /**
     * Changes the formatting hint whether this declaration has an explicit type.
     * 
     * @param hasExplicitType the new status of the formatting hint
     */
    public void setHasExplicitType(boolean hasExplicitType) {
        this.hasExplicitType = hasExplicitType;
    }

    /**
     * Returns the formatting hint whether this declaration has an explicit type.
     * 
     * @return whether this declaration has an explicit type
     */
    public boolean hasExplicitType() {
        return hasExplicitType;
    }

    /**
     * Adds the specified modifier.
     * 
     * @param modifier the modifier to be added
     */
    public void addModifier(IModifier modifier) {
        if (null == modifiers) {
            modifiers = new ArrayList<IModifier>();
        }
        modifiers.add(modifier);
    }
    
    /**
     * Returns the number of modifiers.
     * 
     * @return the number of modifiers
     */
    public int getModifierCount() {
        return null == modifiers ? 0 : modifiers.size();
    }
    
    /**
     * Returns the specified modifier.
     * 
     * @param index the 0-based index of the modifier to return
     * @return the specified modifier
     * @throws IndexOutOfBoundsException if <code>index &lt; 0 || index &get;={@link #getModifierCount()}</code>
     */
    public IModifier getModifier(int index) {
        if (null == modifiers) {
            throw new IndexOutOfBoundsException();
        }
        return modifiers.get(index);
    }
    
    /**
     * Returns whether this variable declaration has a given <code>modifier</code>.
     * 
     * @param modifier the modifier to search for
     * @return <code>true</code> if this variable declaration has the <code>modifier</code> attached, 
     *   <code>false</code> else
     */
    public boolean hasModifier(IModifier modifier) {
        return null == modifiers ? false : modifiers.contains(modifier);
    }
    
    /**
     * Resolves a (temporary) initialization expression to a {@link ResolvableOperationExpression} ("function pointer").
     * 
     * @param type the declared type (of the function pointer)
     * @param operation the resolved base operation
     */
    public void resolveOperation(TypeDescriptor<?> type, IMetaOperation operation) {
        this.expression = new ResolvableOperationExpression(type, operation);
    }

}
