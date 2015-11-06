package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.List;
import java.util.Map;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Constants;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Conversion;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.FieldDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IMetaType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Invisible;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationMeta;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ReflectionOperationDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ReflectionTypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.model.varModel.IAttributableElement;
import de.uni_hildesheim.sse.model.varModel.IModelElement;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.TypeQueries;

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
    
    /**
     * Creates a new type descriptor. Overridden constructors shall call {@link #setOperations(java.util.Collection)}
     * and {@link #setConversions(java.util.Collection)}.
     * 
     * @param ivmlType the IVML type to create the descriptor for
     * @param resolver for retrieving further IVML types
     * @throws VilException if analyzing the class fails for some reason
     */
    AbstractIvmlTypeDescriptor(IDatatype ivmlType, IvmlTypeResolver resolver) throws VilException {
        super((TypeDescriptor<?>[]) null);
        this.typeRegistry = resolver.getTypeRegistry();
        // sets qualified and unqualified name
        setName(ivmlType.getQualifiedName());
        // do this before subclasses so that the unqualified name is associated with the topmost class
        resolver.addType(getName(), this);
        resolver.addType(getQualifiedName(), this);
    }
    
    /**
     * Adds the operations to be taken over from {@link DecisionVariable}. Calls {@link #includeMethod(Method)}.
     * 
     * @param operations the operations (signature-descriptor) (to be modified as a side effect)
     */
    protected void addDecisionVariableOperations(Map<String, OperationDescriptor> operations) {
        Method[] methods = DecisionVariable.class.getMethods();
        for (int m = 0; m < methods.length; m++) {
            Method method = methods[m];
            if (includeMethod(method)) {
                Utils.addOperation(new ReflectionOperationDescriptor(this, method, false), operations);
                String name = ReflectionTypeDescriptor.stripGetterPrefix(method.getName());
                if (null != name) {
                    Utils.addOperation(new ReflectionOperationDescriptor(this, method, name, false), operations);
                }
            }
        }
    }
    
    /**
     * Determines whether a <code>method</code> shall be included as automatically mapped operation.
     * 
     * @param method the method to be considered
     * @return <code>true</code> if <code>method</code> shall be included, <code>false</code> else
     */
    private static boolean includeMethod(Method method) {
        int modifier = method.getModifiers();
        boolean include = Modifier.isPublic(modifier) && !Modifier.isAbstract(modifier);
        include &= (null == method.getAnnotation(Invisible.class));
        include &= (null == method.getAnnotation(Conversion.class));
        include &= Object.class != method.getDeclaringClass();
        if (include) {
            // specific comparison operations are defined in this class
            OperationMeta opMeta = method.getAnnotation(OperationMeta.class);
            if (null != opMeta && OperationType.INFIX == opMeta.opType()) {
                include = false;
            }
        }
        return include;
    }

    /**
     * Adds the default comparison operations.
     * 
     * @param type the IVML type to add the operations for
     * @param operations the operations (signature-descriptor) (to be modified as a side effect)
     */
    protected void addComparisonOperations(IDatatype type, Map<String, OperationDescriptor> operations) {
        TypeDescriptor<?> paramType = TypeRegistry.DEFAULT.findType(IvmlElement.class);
        Utils.addOperation(
            new IvmlComparisonOperationDescriptor(this, Constants.EQUALITY, true, paramType), operations);
        Utils.addOperation(
            new IvmlComparisonOperationDescriptor(this, Constants.UNEQUALITY, false, paramType), operations);
        Utils.addOperation(
            new IvmlComparisonOperationDescriptor(this, Constants.UNEQUALITY_ALIAS, false, paramType), operations);
        if (TypeQueries.isEnum(type)) {
            Utils.addOperation(
                new IvmlComparisonOperationDescriptor(this, Constants.EQUALITY, true, this), operations);
            Utils.addOperation(
                new IvmlComparisonOperationDescriptor(this, Constants.UNEQUALITY, false, this), operations);
            Utils.addOperation(
                new IvmlComparisonOperationDescriptor(this, Constants.UNEQUALITY_ALIAS, false, this), operations);
        }
    }
    
    /**
     * Adds required conversion operations to <code>operations</code>.
     * 
     * @param type the IVML type to add the operations for
     * @param operations the operations to be modified as a side effect
     */
    protected void addConversionOperations(IDatatype type, List<OperationDescriptor> operations) {
        if (TypeQueries.isEnum(type)) {
            TypeDescriptor<?> returnType = TypeRegistry.DEFAULT.findType(IvmlElement.class);
            operations.add(new IvmlConversionOperationDescriptor(this, returnType));
        }
        operations.add(new IvmlConversionOperationDescriptor(this));
    }
    
    /**
     * Adds the attribute access fields.
     * 
     * @param fields the fields (signature-field) (to be modified as a side effect)
     * @param elt the model element to take the attributes from
     * @param registry the actual type registry
     * @throws VilException in case that creating the descriptors fails
     */
    protected void addAttributeFields(Map<String, FieldDescriptor> fields, IModelElement elt, 
        TypeRegistry registry) throws VilException {
        // However, as attributes are bound to variables,
        // attributes of individual variables cannot be turned into functions at the moment.
        
        // -> advice6
        IModelElement iter = elt;
        do {
            if (iter instanceof IAttributableElement) {
                IAttributableElement aElt = (IAttributableElement) iter;
                for (int a = 0; a < aElt.getAttributesCount(); a++) {
                    de.uni_hildesheim.sse.model.varModel.Attribute attribute = aElt.getAttribute(a);
                    Utils.addField(new IvmlAnnotationFieldDescriptor(this, attribute, registry), fields);
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
    
    @Override
    public boolean isAssignableFrom(IMetaType type) {
        boolean result;
        if (type instanceof TypeDescriptor) {
            result = isAssignableFrom((TypeDescriptor<?>) type);
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
    public boolean isIterator() {
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

    @Override
    public IMetaType getSuperType() {
        return refines;
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
    
    @Override
    public boolean isActualTypeOf(IMetaType type) {
        // exclude further specialization in this hierarchy and fake types
        return !getClass().isInstance(type) && !FakeTypeDescriptor.class.isInstance(type);
    }

}
