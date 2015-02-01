package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration;

import java.util.List;
import java.util.Map;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Constants;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IMetaType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.VilException;
import de.uni_hildesheim.sse.model.varModel.IAttributableElement;
import de.uni_hildesheim.sse.model.varModel.IModelElement;
import de.uni_hildesheim.sse.model.varModel.datatypes.Enum;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;

/**
 * Implements a dynamic type descriptor for IVM decision variables. Instances of this
 * class represent IVML types and act as a frontend for {@link DecisionVariable}, thus,
 * {@link DecisionVariable decision variables} are assignable.
 * 
 * @author Holger Eichelberger
 */
abstract class AbstractIvmlTypeDescriptor extends TypeDescriptor<DecisionVariable> {

    private TypeRegistry typeRegistry;
    private AbstractIvmlTypeDescriptor refines;
    private IDatatype type;
    
    /**
     * Creates a new type descriptor. Overridden constructors shall call {@link #setOperations(java.util.Collection)}
     * and {@link #setConversions(java.util.Collection)}.
     * 
     * @param ivmlType the IVML type to create the descriptor for
     * @param resolver for retrieving further IVML types
     * @throws VilException if analyzing the class fails for some reason
     */
    AbstractIvmlTypeDescriptor(IDatatype ivmlType, IvmlTypeResolver resolver) throws VilException {
        super((TypeDescriptor<? extends IVilType>[]) null);
        this.type = ivmlType;
        this.typeRegistry = resolver.getTypeRegistry();
        // sets qualified and unqualified name
        setName(ivmlType.getQualifiedName());
        // do this before subclasses so that the unqualified name is associated with the topmost class
        resolver.addType(getName(), this);
        resolver.addType(resolver.getQualifiedNamePrefix() + getQualifiedName(), this);
    }

    /**
     * Adds a descriptor to the given signature-descriptor map.
     * 
     * @param operation the operation to be added
     * @param operations the operations (signature-descriptor) (to be modified as a side effect)
     */
    protected static void addOperation(OperationDescriptor operation, Map<String, OperationDescriptor> operations) {
        String sig = operation.getSignature();
        if (!operations.containsKey(sig)) {
            operations.put(sig, operation);
        }
    }
    
    /**
     * Adds the default meta operations.
     * 
     * @param operations the operations (signature-descriptor) (to be modified as a side effect)
     */
    protected void addMetaOperations(Map<String, OperationDescriptor> operations) {
        addOperation(new IvmlMetaVariableOperationDescriptor(this), operations);
        addOperation(new IvmlMetaDeclarationOperationDescriptor(this), operations);
        addOperation(new IvmlMetaNameOperationDescriptor(this), operations);
        addOperation(new IvmlMetaVarNameOperationDescriptor(this), operations);
        addOperation(new IvmlMetaTypeOperationDescriptor(this), operations);
    }

    /**
     * Adds the default comparison operations.
     * 
     * @param operations the operations (signature-descriptor) (to be modified as a side effect)
     */
    protected void addComparisonOperations(Map<String, OperationDescriptor> operations) {
        TypeDescriptor<? extends IVilType> paramType = TypeRegistry.DEFAULT.findType(IvmlElement.class);
        addOperation(
            new IvmlComparisonOperationDescriptor(this, Constants.EQUALITY, true, paramType), operations);
        addOperation(
            new IvmlComparisonOperationDescriptor(this, Constants.UNEQUALITY, false, paramType), operations);
        addOperation(
            new IvmlComparisonOperationDescriptor(this, Constants.UNEQUALITY_ALIAS, false, paramType), operations);
        if (isEnum()) {
            addOperation(
                new IvmlComparisonOperationDescriptor(this, Constants.EQUALITY, true, this), operations);
            addOperation(
                new IvmlComparisonOperationDescriptor(this, Constants.UNEQUALITY, false, this), operations);
            addOperation(
                new IvmlComparisonOperationDescriptor(this, Constants.UNEQUALITY_ALIAS, false, this), operations);
        }
    }
    
    /**
     * Adds required conversion operations to <code>operations</code>.
     * 
     * @param operations the operations to be modified as a side effect
     */
    protected void addConversionOperations(List<OperationDescriptor> operations) {
        if (isEnum()) {
            TypeDescriptor<? extends IVilType> returnType = TypeRegistry.DEFAULT.findType(IvmlElement.class);
            operations.add(new IvmlConversionOperationDescriptor(this, returnType));
        }
        operations.add(new IvmlConversionOperationDescriptor(this));
    }
    
    /**
     * Returns whether this type is an enum.
     * 
     * @return <code>true</code> if it is an enum, <code>false</code> else
     */
    protected boolean isEnum() {
        return Enum.TYPE.isAssignableFrom(getDatatype());
    }
    
    /**
     * Adds the attribute access operations.
     * 
     * @param operations the operations (signature-descriptor) (to be modified as a side effect)
     * @param elt the model element to take the attributes from
     * @throws VilException in case that creating the descriptors fails
     */
    protected void addAttributeOperations(Map<String, OperationDescriptor> operations, IModelElement elt) 
        throws VilException {
        // However, as attributes are bound to variables,
        // attributes of individual variables cannot be turned into functions at the moment.
        
        // -> advice6
        IModelElement iter = elt;
        do {
            if (iter instanceof IAttributableElement) {
                IAttributableElement aElt = (IAttributableElement) iter;
                for (int a = 0; a < aElt.getAttributesCount(); a++) {
                    de.uni_hildesheim.sse.model.varModel.Attribute attribute = aElt.getAttribute(a);
                    IvmlAttributeOperationDescriptor.createDescriptors(this, attribute, operations);
                }
            }
            iter = iter.getParent();
        } while (null != iter);
    }

    @Override
    public boolean isBasicType() {
        return false;
    }

    @Override
    public TypeRegistry getTypeRegistry() {
        return typeRegistry;
    }

    @Override
    public Class<DecisionVariable> getTypeClass() {
        return DecisionVariable.class;
    }

    @Override
    public boolean canBeInstantiated() {
        return false;
    }
    
    @Override
    public DecisionVariable create(Object... params) throws VilException {
        return null; // cannot be instantiated
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public boolean isAssignableFrom(IMetaType type) {
        boolean result;
        if (type instanceof TypeDescriptor) {
            result = isAssignableFrom((TypeDescriptor<? extends IVilType>) type);
        } else {
            result = false;
        }
        return result;
    }

    @Override
    public boolean isCollection() {
        return false;
    }

    @Override
    public boolean isSet() {
        return false;
    }
    
    @Override
    public boolean isMap() {
        return false;
    }

    @Override
    public boolean isSequence() {
        return false;
    }

    /**
     * Returns the type descriptor which is refined by this descriptor.
     * 
     * @return the refined type (may be <b>null</b> if there is none)
     */
    AbstractIvmlTypeDescriptor getRefines() {
        return refines;
    }

    /**
     * Changes the type descriptor which is refined by this descriptor.
     * 
     * @param refines the refined type descriptor (may be <b>null</b> if there is none)
     */
    protected void setRefines(AbstractIvmlTypeDescriptor refines) {
        this.refines = refines;
    }
    
    /**
     * Returns the underlying IVML datatype.
     *  
     * @return the underlying IVML datatype
     */
    public IDatatype getDatatype() {
        return type;
    }
    
    @Override
    public boolean isActualTypeOf(IMetaType type) {
        // exclude further specialization in this hierarchy and fake types
        return !getClass().isInstance(type) && !FakeTypeDescriptor.class.isInstance(type);
    }

}
