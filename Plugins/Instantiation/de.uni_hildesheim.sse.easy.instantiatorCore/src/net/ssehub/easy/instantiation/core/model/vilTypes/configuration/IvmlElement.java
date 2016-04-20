package net.ssehub.easy.instantiation.core.model.vilTypes.configuration;

import net.ssehub.easy.instantiation.core.model.expressions.IResolvable;
import net.ssehub.easy.instantiation.core.model.vilTypes.Constants;
import net.ssehub.easy.instantiation.core.model.vilTypes.IStringValueProvider;
import net.ssehub.easy.instantiation.core.model.vilTypes.IVilType;
import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;
import net.ssehub.easy.instantiation.core.model.vilTypes.OperationMeta;
import net.ssehub.easy.instantiation.core.model.vilTypes.OperationType;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;

/**
 * Denotes an element resolved in IVML. This must not be an interface
 * as it provides implemented IVML operations.
 * 
 * @author Holger Eichelberger
 */
public abstract class IvmlElement implements IVilType, IResolvable, IStringValueProvider {

    /**
     * Lazily initializes the attributes.
     */
    protected abstract void initializeAttributes();
    
    /**
     * Lazily initializes the nested parts.
     */
    protected abstract void initializeNested();
    
    /**
     * Returns the simple name of the element.
     * 
     * @return the simple name
     */
    public abstract String getName();

    /**
     * Returns the qualified name of the element.
     * 
     * @return the qualified name
     */
    public abstract String getQualifiedName();

    /**
     * Returns the simple type name of the element.
     * 
     * @return the simple type name
     */
    public abstract String getType();

    /**
     * Returns the qualified type name of the element.
     * 
     * @return the qualified type name
     */
    public abstract String getQualifiedType();

    /**
     * Returns the specified attribute.
     * 
     * @param index the 0-based index of the attribute to return
     * @return the specified attribute
     * @throws IndexOutOfBoundsException if <code>index &lt; 0 || index &gt;= {@link #getAttributeCount()}</code>
     */
    abstract IvmlElement getAttribute(int index);
    
    /**
     * Returns the number of attributes.
     * 
     * @return the number of attributes
     */
    abstract int getAttributeCount();
    
    /**
     * Returns the attribute specified by <b>name</b> (matches qualified and unqualified names).
     * 
     * @param name the name of the element (no regex)
     * @return the matching attribute or <b>null</b>
     */
    public IvmlElement getAttribute(String name) {
        initializeAttributes();
        IvmlElement result = null;
        for (int a = 0; null == result && a < getAttributeCount(); a++) {
            IvmlElement tmp = getAttribute(a);
            if (tmp.getName().equals(name) || tmp.getQualifiedName().equals(name)) {
                result = tmp;
            }
        }
        return result;
    } // TODO remove, switch to getAnnotation
    
    /**
     * Returns the attribute specified by <b>element</b> (matches qualified and unqualified names).
     * 
     * @param element the IvmlElement denoting the attribute
     * @return the matching attribute or <b>null</b>
     */
    public IvmlElement getAttribute(IvmlElement element) {
        return getAttribute(element.getQualifiedName());
    } // TODO remove, switch to getAnnotation
    
    /**
     * Returns the attribute specified by <b>name</b> (matches qualified and unqualified names).
     * 
     * @param name the name of the element (no regex)
     * @return the matching attribute or <b>null</b>
     */
    public IvmlElement getAnnotation(String name) {
        return getAttribute(name);
    }
    
    /**
     * Returns the attribute specified by <b>element</b> (matches qualified and unqualified names).
     * 
     * @param element the IvmlElement denoting the attribute
     * @return the matching attribute or <b>null</b>
     */
    public IvmlElement getAnnotation(IvmlElement element) {
        return getAttribute(element.getQualifiedName());
    }

    /**
     * Returns whether this element is valid.
     * 
     * @return <code>true</code> if this element is valid, <code>false</code> else
     * @see VariableValueMapping#getValidFlag(AbstractIvmlVariable)
     */
    public boolean isValid() {
        return VariableValueMapping.getInstance().isValid(this);
    }

    /**
     * Returns whether this element is currently enacting.
     * 
     * @return <code>true</code> if this currently in enactment, <code>false</code> else
     * @see VariableValueMapping#getValidFlag(AbstractIvmlVariable)
     */
    public boolean isEnacting() {
        return VariableValueMapping.getInstance().isEnacting(this);
    }

    /**
     * Returns whether the {@link #getValue() value} of this element is null (in the semantics
     * of IVML). This does not mean undefined!
     * 
     * @return <code>true</code> if the value is null, <code>false</code> else
     */
    public boolean isNull() {
        return getValue() == TypeRegistry.NULL;
    }
    
    /**
     * Returns the (untyped) value of the decision variable.
     * 
     * @return the value (may be <b>null</b>)
     */
    public abstract Object getValue();
    
    /**
     * Returns the string value of the decision variable.
     * 
     * @return the value (may be <b>null</b>)
     */
    public abstract String getStringValue();

    /**
     * Returns the integer value of the decision variable.
     * 
     * @return the value (may be <b>null</b>)
     */
    public abstract Integer getIntegerValue();

    /**
     * Returns the real value of the decision variable.
     * 
     * @return the value (may be <b>null</b>)
     */
    public abstract Double getRealValue();
    
    /**
     * Returns the boolean value of the decision variable.
     * 
     * @return the value (may be <b>null</b>)
     */
    public abstract Boolean getBooleanValue();

    /**
     * Returns the boolean value of the decision variable.
     * 
     * @return the value (may be <b>null</b>)
     */
    public abstract EnumValue getEnumValue();
    
    /**
     * Returns the element matching the given (qualified) name.
     * 
     * @param name the name to search for
     * @return the matching element or <b>null</b> if not found
     */
    public abstract IvmlElement getElement(String name);
    
    /**
     * Searches for an element denoted by <code>name</code> in <code>elements</code>.
     * 
     * @param name the element to search for
     * @param elements the elements to search within
     * @return the found element or <b>null</b>
     */
    protected IvmlElement search(String name, IvmlElement[] elements) {
        IvmlElement result = null;
        if (null != elements) {
            for (int e = 0; null == result && e < elements.length; e++) {
                result = checkElement(name, elements[e]);
            }
        }
        return result;
    }

    /**
     * Checks the given element for equality and performs (if required) deeper search
     * using {@link #getElement(String)}.
     * 
     * @param name the element to search for
     * @param element the element to search within
     * @return the found element or <b>null</b>
     */
    protected IvmlElement checkElement(String name, IvmlElement element) {
        IvmlElement result = null;
        if (element.getName().equals(name)) {
            result = element;
        } else if (element.getName().startsWith(name)) {
            result = element.getElement(name);
        }
        return result;
    }
    
    /**
     * Represents the equality operation for IvmlElements.
     * 
     * @param i1 the first element to be considered
     * @param i2 the second element to be considered
     * @return i1 == i2
     */
    @OperationMeta(name = Constants.EQUALITY, opType = OperationType.INFIX)
    public static boolean equals(IvmlElement i1, IvmlElement i2) {
        return (i1 == null && i2 == null) || (i1 != null && i1.equals(i2));
    }

    /**
     * Represents the equality operation for IvmlElements and AnyType, in particular the null value.
     * 
     * @param i1 the first element to be considered
     * @param i2 the second element to be considered
     * @return i1 == i2
     */
    @OperationMeta(name = Constants.EQUALITY, opType = OperationType.INFIX)
    public static boolean equals2(IvmlElement i1, Object i2) {
        boolean result;
        if (i1 != null && i2 == TypeRegistry.NULL) {
            result = i1.isNull();
        } else {
            Object o1 = i1;
            if (null != i1 && !(i2 instanceof IvmlElement)) {
                o1 = i1.getValue(); // otherwise it will never match
            }
            result = (o1 == null && i2 == null) || (o1 != null && o1.equals(i2));
        }
        return result;
    }

    /**
     * Represents the unequality operation for IvmlElements.
     * 
     * @param i1 the first element to be considered
     * @param i2 the second element to be considered
     * @return i1 == i2
     */
    @OperationMeta(name = {Constants.UNEQUALITY, Constants.UNEQUALITY_ALIAS }, opType = OperationType.INFIX)
    public static boolean unequals(IvmlElement i1, IvmlElement i2) {
        return (i1 == null && i2 == null) || (i1 != null && !i1.equals(i2));
    }

    /**
     * Represents the unequality operation for IvmlElements and AnyTypes, in particular the null value.
     * 
     * @param i1 the first element to be considered
     * @param i2 the second element to be considered
     * @return i1 == i2
     */
    @OperationMeta(name = {Constants.UNEQUALITY, Constants.UNEQUALITY_ALIAS }, opType = OperationType.INFIX)
    public static boolean unequals2(IvmlElement i1, Object i2) {
        boolean result;
        if (i1 != null && i2 == TypeRegistry.NULL) {
            result = !i1.isNull();
        } else {
            result = (i1 == null && i2 == null) || (i1 != null && !i1.equals(i2));
        }
        return result;
    }
    
    @Invisible
    @Override
    public String getStringValue(StringComparator comparator) {
        return getQualifiedName();
    }
    
    /**
     * Returns the instance name of this element.
     * 
     * @return the instance name
     */
    @Invisible
    public String getInstanceName() {
        return getQualifiedName();
    }

}
