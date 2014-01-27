package de.uni_hildesheim.sse.translation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.uni_hildesheim.sse.ModelUtility;
import de.uni_hildesheim.sse.dslCore.translation.Message;
import de.uni_hildesheim.sse.dslCore.translation.MessageReceiver;
import de.uni_hildesheim.sse.dslCore.translation.TranslatorException;
import de.uni_hildesheim.sse.ivml.DerivedType;
import de.uni_hildesheim.sse.ivml.IvmlPackage;
import de.uni_hildesheim.sse.ivml.Type;
import de.uni_hildesheim.sse.ivml.Typedef;
import de.uni_hildesheim.sse.ivml.Value;
import de.uni_hildesheim.sse.model.cst.ConstantValue;
import de.uni_hildesheim.sse.model.cst.ConstraintSyntaxTree;
import de.uni_hildesheim.sse.model.cst.Variable;
import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.AttributeAssignment;
import de.uni_hildesheim.sse.model.varModel.Comment;
import de.uni_hildesheim.sse.model.varModel.ContainableModelElement;
import de.uni_hildesheim.sse.model.varModel.ContainableModelElementList;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.IModelElement;
import de.uni_hildesheim.sse.model.varModel.IvmlException;
import de.uni_hildesheim.sse.model.varModel.IvmlKeyWords;
import de.uni_hildesheim.sse.model.varModel.ModelElement;
import de.uni_hildesheim.sse.model.varModel.ModelQuery;
import de.uni_hildesheim.sse.model.varModel.ModelQueryException;
import de.uni_hildesheim.sse.model.varModel.OperationDefinition;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.ProjectImport;
import de.uni_hildesheim.sse.model.varModel.datatypes.BooleanType;
import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
import de.uni_hildesheim.sse.model.varModel.datatypes.Container;
import de.uni_hildesheim.sse.model.varModel.datatypes.IContainableElementsSorter;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.IResolutionScope;
import de.uni_hildesheim.sse.model.varModel.datatypes.IntegerType;
import de.uni_hildesheim.sse.model.varModel.datatypes.MetaType;
import de.uni_hildesheim.sse.model.varModel.datatypes.RealType;
import de.uni_hildesheim.sse.model.varModel.datatypes.Reference;
import de.uni_hildesheim.sse.model.varModel.datatypes.Sequence;
import de.uni_hildesheim.sse.model.varModel.datatypes.Set;
import de.uni_hildesheim.sse.model.varModel.datatypes.StringType;
import de.uni_hildesheim.sse.model.varModel.values.NullValue;
import de.uni_hildesheim.sse.model.varModel.values.ValueFactory;

/**
 * Defines a type context which consists of all variables defined in a project
 * and additionally variables which can be added to the context in a layered
 * manner. While IVML currently may not really require layered type contexts
 * (shadowing variables), we just introduce it here for future use. The typical
 * use is <code>
 * context.pushLayer();
 * context.addToContext(...);
 * try {
 *     // resolve some types or expressions
 * } catch (TranslatorException e) {
 *     throw e;
 * } finally {
 *     context.popLayer();
 * }
 * </code> Please note that layers must properly be cleared ({@link #popLayer()}
 * . Further, a type context provides a resolution scope for its implicit
 * definitions (without providing interfaces or a name).<br/>
 * This class provides support for sorting elements on project level as well
 * as on compound level according to the input.
 * 
 * @author Holger Eichelberger
 */
public class TypeContext implements IResolutionScope {

    private ContainableModelElementList implicitDefinitions = new ContainableModelElementList();
    private Project project;
    private MessageReceiver messageReceiver;

    // may support shadowed variables
    private Stack<ContainableModelElementList> directContext = new Stack<ContainableModelElementList>();
    private ContainableElementsMapAndComparator sortMap = new ContainableElementsMapAndComparator();
    private Map<IContainableElementsSorter, ContainableElementsMapAndComparator> elementSortMaps 
        = new HashMap<IContainableElementsSorter, ContainableElementsMapAndComparator>();

    /**
     * Creates a type context for a given project.
     * 
     * @param project the project representing the root resolution scope of this type context
     * @param messageReceiver instance for receiving, storing and passing messages to Eclipse
     */
    public TypeContext(Project project, MessageReceiver messageReceiver) {
        this.project = project;
        this.messageReceiver = messageReceiver;
    }

    /**
     * Push a resolution layer in case that intermediary variables shell be considered, e.g.
     * within a compound.
     */
    public void pushLayer() {
        directContext.push(new ContainableModelElementList());
    }

    /**
     * Pop a resolution layer in case that intermediary variables shell be considered, e.g.
     * at the end of a compound. Please consider proper handling of exceptions so that this
     * method is always called at the end of a pushed section so that further semantic 
     * analysis after the error is possible!
     */
    public void popLayer() {
        directContext.pop();
    }

    /**
     * Adds a compound to the current context (layer). Please call {@link #pushLayer()} before.
     * 
     * @param comp the compound for which all contained variables shall be added
     */
    public void addToContext(Compound comp) {
        int count = comp.getElementCount();
        for (int c = 0; c < count; c++) {
            addToContext(comp.getElement(c));
        }
    }

    /**
     * Adds an attribute assignment to the current context (layer). Please call {@link #pushLayer()} before.
     * 
     * @param assignment the assignment for which all contained variables shall be added
     */
    public void addToContext(AttributeAssignment assignment) {
        int count = assignment.getElementCount();
        for (int c = 0; c < count; c++) {
            addToContext(assignment.getElement(c));
        }
    }
    
    /**
     * Adds an operation definition to the current context (layer). Please call {@link #pushLayer()} before.
     * 
     * @param opDef the operation definition which shall be added
     */
    public void addToContext(OperationDefinition opDef) {
        directContext.peek().add(opDef);
    }
    
    /**
     * Adds a variable declaration to the current context (layer). Please call {@link #pushLayer()} before.
     * 
     * @param var the decision variable declaration which shall be added
     */
    public void addToContext(DecisionVariableDeclaration var) {
        directContext.peek().add(var);
    }

    /**
     * Returns the project providing the root resolution scope.
     * 
     * @return the project
     */
    public Project getProject() {
        return project;
    }

    /**
     * Resolves a given type to a type representation in the IVML object model.
     * 
     * @param type the type to be resolved
     * @return the representing type
     * @throws TranslatorException in case that the given <code>type</code> cannot be resolved
     */
    public IDatatype resolveType(Type type) throws TranslatorException {
        IDatatype result = null;
        String typeName = "";
        EStructuralFeature causingFeature = null;
        Class<? extends IDatatype> restriction = null;
        if (null != type.getType()) {
            typeName = type.getType().getType();
            restriction = IDatatype.class;
            causingFeature = IvmlPackage.Literals.TYPE__ID;
        } else if (null != type.getId()) {
            typeName = Utils.getQualifiedNameString(type.getId());
            restriction = IDatatype.class;
            causingFeature = IvmlPackage.Literals.TYPE__ID;
        } else if (null != type.getDerived()) {
            causingFeature = IvmlPackage.Literals.TYPE__TYPE;
            // basicType (type), ID (id), derived
            DerivedType derived = type.getDerived();
            typeName = ModelUtility.stringValue(derived.getType());
            if (derived.getOp().equals(IvmlKeyWords.SETOF)) {
                restriction = Container.class;
            } else if (derived.getOp().equals(IvmlKeyWords.SEQUENCEOF)) {
                restriction = Container.class;
            } else if (derived.getOp().equals(IvmlKeyWords.REFTO)) {
                restriction = Reference.class;
            } else {
                throw new TranslatorException("<unspecified type>", type,
                        causingFeature, TranslatorException.INTERNAL);
            }
            // search the implicit ones
            try {
                result = ModelQuery.findElementByTypeName(this, typeName,
                        restriction);
            } catch (ModelQueryException e) {
                throw new TranslatorException(e, type, causingFeature);
            }
            if (null == result) {
                IDatatype containedType = resolveType(derived.getType());
                ContainableModelElement tmp = null;
                if (derived.getOp().equals(IvmlKeyWords.SETOF)) {
                    tmp = addImplicitDefinition(new Set(typeName,
                            containedType, project));
                    restriction = Set.class;
                } else if (derived.getOp().equals(IvmlKeyWords.SEQUENCEOF)) {
                    tmp = addImplicitDefinition(new Sequence(typeName,
                            containedType, project));
                    restriction = Sequence.class;
                } else if (derived.getOp().equals(IvmlKeyWords.REFTO)) {
                    tmp = addImplicitDefinition(new Reference(typeName,
                            containedType, project));
                    restriction = Reference.class;
                }
                if (null != tmp) {
                    result = (IDatatype) tmp;
                }
            }
        }
        if (null != typeName && null == result) {
            // search explicit definitions
            try {
                result = findType(typeName, restriction);
            } catch (ModelQueryException e) {
                throw new TranslatorException(e, type, causingFeature);
            }
            if (null == result) {
                throw new UnknownTypeException(typeName, type, causingFeature);
            }
        }
        return result;
    }

    /**
     * Searches for a specified element.
     * 
     * @param name
     *            the name of the element to search for (may be qualified)
     * @param type
     *            the specific element to be returned
     * @return the corresponding variable or <b>null</b>
     * @throws ModelQueryException
     *             in case of semantic problems
     */
    public ContainableModelElement findElementByName(String name,
            Class<? extends ModelElement> type) throws ModelQueryException {
        ContainableModelElement result = null;
        // search contexts first, from newest to oldest
        for (int c = directContext.size() - 1; null == result && c >= 0; c--) {
            result = ModelQuery.findElementByName(directContext.get(c), name,
                    type);
        }
        if (null == result) {
            // last resort - ask the project
            result = ModelQuery.findElementByName(project, name, type);
        }
        return result;
    }

    /**
     * Searches for a specified variable.
     * 
     * @param name
     *            the name of the variable to search for (may be qualified)
     * @param type
     *            the specific variable of datatype to be returned,
     *            {@link AbstractVariable} is used if <b>null</b>
     * @return the corresponding variable or <b>null</b>
     * @throws ModelQueryException
     *             in case of semantic problems
     */
    public AbstractVariable findVariable(String name,
            Class<? extends AbstractVariable> type) throws ModelQueryException {
        AbstractVariable result = null;
        // search contexts first, from newest to oldest
        for (int c = directContext.size() - 1; null == result && c >= 0; c--) {
            result = ModelQuery.findVariable(directContext.get(c), name, type);
        }
        if (null == result) {
            // last resort - ask the project
            result = ModelQuery.findVariable(project, name, type);
        }
        return result;
    }

    /**
     * Finds the specified data type definition.
     * 
     * @param name
     *            the name of the type to search for (may be qualified)
     * @param type
     *            the specific type of datatype to be returned,
     *            {@link IDatatype} is used if <b>null</b>
     * @return the corresponding type or <b>null</b>
     * @throws ModelQueryException
     *             in case of semantic problems
     */
    public IDatatype findType(String name, Class<? extends IDatatype> type)
        throws ModelQueryException {
        IDatatype result = null;
        for (int c = directContext.size() - 1; null == result && c >= 0; c--) {
            result = ModelQuery.findType(directContext.get(c), name, type);
        }
        if (null == result) {
            result = ModelQuery.findType(project, name, type);
        }
        return result;
    }

    /**
     * Returns a contained model element specified by <code>index</code>.
     * 
     * @param index
     *            a 0-based index specifying the operation to be returned
     * @return the contained element
     * @throws IndexOutOfBoundsException
     *             if
     *             <code>index&lt;0 || index&gt;={@link #getElementCount()}</code>
     */
    public ContainableModelElement getElement(int index) {
        return implicitDefinitions.get(index);
    }

    /**
     * Returns the number of contained elements.
     * 
     * @return the number of contained elements
     */
    public int getElementCount() {
        return implicitDefinitions.size();
    }

    /**
     * Adds an implicit element or type definition.
     * 
     * @param element
     *            the implicitly defined element
     * @return <code>element</code>
     * 
     * @see #getElement(int)
     * @see #getElementCount()
     */
    ContainableModelElement addImplicitDefinition(
            ContainableModelElement element) {
        implicitDefinitions.add(element);
        return element;
    }

    /**
     * Resolves a value and returns the corresponding syntax tree (one node).
     * 
     * @param value
     *            the value to be converted
     * @param object
     *            the grammar object this method is called for
     * @param feature
     *            the grammar feature this method is called for
     * @return the corresponding syntax tree
     * @throws TranslatorException in case of any translation problem
     */
    public ConstraintSyntaxTree resolveValue(Value value, EObject object,
            EStructuralFeature feature) throws TranslatorException {
        ConstraintSyntaxTree result = null;
        if (null != value.getNValue()) {
            // in case that the value is a numeric value
            String sValue = value.getNValue().getVal();
            if (sValue.indexOf(IvmlKeyWords.DECIMAL_SEPARATOR) > 0) {
                try {
                    result = new ConstantValue(ValueFactory.createValue(RealType.TYPE, sValue));
                } catch (IvmlException e) {
                    throw new TranslatorException(e, object, feature);
                }
            } else {
                try {
                    result = new ConstantValue(ValueFactory.createValue(IntegerType.TYPE, sValue));
                } catch (IvmlException e) {
                    throw new TranslatorException(e, object, feature);
                }
            }
        } else if (null != value.getQValue()) {
            // in case that the value is a qualified value
            String sValue = Utils.getQualifiedNameString(value.getQValue());
            try {
                AbstractVariable var = findVariable(sValue, null);
                if (null == var) {
                    try {
                        de.uni_hildesheim.sse.model.varModel.values.Value litValue = ModelQuery
                                .enumLiteralAsValue(project, sValue);
                        if (null != litValue) {
                            result = new ConstantValue(litValue);
                        } else {
                            IDatatype type = findType(sValue, null);
                            if (null == type && sValue.equals(project.getName())) {
                                type = project.getType();
                            }
                            if (null != type) {
                                result = new ConstantValue(ValueFactory.createValue(MetaType.TYPE, type));
                            } else {
                                throw new TranslatorException("'" + sValue + "' is unknown", object, feature,
                                    ErrorCodes.UNKNOWN_ELEMENT);
                            }
                        }
                    } catch (IvmlException e) {
                        throw new TranslatorException(e, object, feature);
                    }
                } else {
                    result = new Variable(var);
                    if (Constants.REASONER_UNQUALIFIED_NAME_WARNING && isInCompound(var)) {
                        messageReceiver.warning("Unqualified compound variable '" + var.getName() 
                            + "' is currently not supported in reasoning. Please qualify with name " 
                            + "of containing compound", object, feature, Message.CODE_IGNORE);
                    }
                }
            } catch (IvmlException e) {
                throw new TranslatorException(e, object, feature);
            }
        } else if (null != value.getRValue()) { // referenced value (refby)
            String sValue = value.getRValue();
            try { // TODO check whether required at all
                AbstractVariable var = findVariable(sValue, null);
                if (null == var) {
                    throw new UnknownVariableException(sValue, object, feature);
                }
                result = new Variable(var);
            } catch (IvmlException e) {
                throw new TranslatorException(e, object, feature);
            }
        } else if (null != value.getSValue()) { // string value
            result = createValueTree(value.getSValue(), StringType.TYPE, object, feature);
        } else if (null != value.getBValue()) { // boolean value
            result = createValueTree(value.getBValue(), BooleanType.TYPE, object, feature);
        } else if (null != value.getNullValue()) {
            result = new ConstantValue(NullValue.INSTANCE);
            messageReceiver.warning("'null' values may are currently not supported by the reasoner", object, feature, 
                Message.CODE_IGNORE);
        } else {
            throw new TranslatorException("<no type alternative>", object, feature, ErrorCodes.INTERNAL);
        }
        return result;
    }
    
    /**
     * Returns whether the given model element <code>elt</code> is located within a compound.
     * 
     * @param elt the element to analyze
     * @return <code>true</code> if <code>elt</code> is in a compound, <code>false</code> else
     */
    private boolean isInCompound(IModelElement elt) {
        boolean found = false;
        IModelElement tmp = elt.getParent();
        while (!found && null != tmp) {
            if (tmp instanceof Compound)  {
                found = true;
            } else {
                tmp = tmp.getParent();
            }
        }
        return found;
    }

    /**
     * Creates a value tree for a given <code>type</code>.
     * @param sValue the string representation of the value
     * @param type the target type
     * @param object the grammar object this method is called for
     * @param feature the grammar feature this method is called for
     * @return the value tree
     * @throws TranslatorException in case of any translation problem
     */
    private ConstraintSyntaxTree createValueTree(String sValue, IDatatype type, EObject object,
        EStructuralFeature feature) throws TranslatorException {
        ConstraintSyntaxTree result = null;
        try {
            result = new ConstantValue(ValueFactory.createValue(type, sValue));
        } catch (IvmlException e) {
            throw new TranslatorException(e, object, feature);
        }
        return result;
    }

    /**
     * {@inheritDoc}
     */
    public int getImportsCount() {
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    public ProjectImport getImport(int index) {
        throw new IndexOutOfBoundsException();
    }

    /**
     * {@inheritDoc}
     */
    public String getName() {
        return "";
    }

    /**
     * {@inheritDoc}
     */
    public boolean hasInterfaces() {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    // @Override
    // CK: Override causes errors in build process (Java > 1.5 required!)
    public boolean isInterface() {
        return false;
    }
    
    /**
     * Adds a containable element to the root resolution scope as well as 
     * a mapping from <code>key</code> to <code>comment</code> (optional)
     * and <code>element</code>.
     * 
     * @param key the key object as parsed by xText from the input file (may 
     *   be <b>null</b> then no mapping is added, e.g. when adding a comment only)
     * @param comment the comment instance (may be <b>null</b>)
     * @param element the element instance
     * @return <code>true</code> if the addition was successful, 
     *   <code>false</code> else due to duplicated names
     * 
     * @see ContainableElementsMapAndComparator#put(EObject, Comment, ContainableModelElement)
     */
    public boolean addToProject(EObject key, Comment comment, ContainableModelElement element) {
        if (null != key) {
            sortMap.put(key, comment, element);
        }
        return project.add(element);
    }
    
    /**
     * Sorts the elements in the root resolution scope according to the
     * the given list of top-level elements.
     * 
     * @param topLevelElements the top-level elements from the grammar
     */
    public void sortProjectElements(List<EObject> topLevelElements) {
        setIndexes(topLevelElements, sortMap);
        project.sortContainedElements(sortMap);
    }
    
    /**
     * Transfers the index positions of <code>elements</code> to <code>map</code>.
     * 
     * @param elements the list representing the positions
     * @param map the target map to set the values to
     */
    private static void setIndexes(List<EObject> elements, ContainableElementsMapAndComparator map) {
        int size = elements.size();
        for (int e = 0; e < size; e++) {
            EObject tmp = elements.get(e);
            if (tmp instanceof Typedef) {
                Typedef typedef = (Typedef) tmp;
                if (null != typedef.getTCompound()) {
                    tmp = typedef.getTCompound();
                } else if (null != typedef.getTEnum()) {
                    tmp = typedef.getTEnum();
                } else if (null != typedef.getTMapping()) {
                    tmp = typedef.getTMapping();
                }
            }
            map.setIndex(tmp, e);
        }
    }

    /**
     * Registers an element to be sorted (later).
     * 
     * @param sorter the element being sorted later
     * @param key the key object as parsed by xText from the input file (may 
     *   be <b>null</b> then no mapping is added, e.g. when adding a comment only)
     * @param comment the comment instance (may be <b>null</b>)
     * @param element the element instance
     */
    public void registerSorter(IContainableElementsSorter sorter, EObject key, Comment comment, 
        ContainableModelElement element) {
        ContainableElementsMapAndComparator map = elementSortMaps.get(sorter);
        if (null == map) {
            map = new ContainableElementsMapAndComparator();
            elementSortMaps.put(sorter, map);
        }
        map.put(key, comment, element);
    }
    
    /**
     * Closes an elements sorter (regarding the stored data) and sorts the elements
     * within the compound.
     * 
     * @param sorter the element being sorted
     * @param elements the grammar elements within the compound defining the sort order
     */
    public void closeSorter(IContainableElementsSorter sorter, List<EObject> elements) {
        ContainableElementsMapAndComparator sortMap = elementSortMaps.get(sorter);
        if (null != sortMap) {
            setIndexes(elements, sortMap);
            sorter.sortContainedElements(sortMap);
            sortMap.clear();
            elementSortMaps.remove(sortMap);
        }
    }
    
    /**
     * Clears this type context (for possible reuse).
     */
    public void clear() {
        implicitDefinitions.clear();
        project = null;
        directContext.clear();
        sortMap.clear();
        for (ContainableElementsMapAndComparator c : elementSortMaps.values()) {
            c.clear();
        }
        elementSortMaps.clear();
    }
    
}
