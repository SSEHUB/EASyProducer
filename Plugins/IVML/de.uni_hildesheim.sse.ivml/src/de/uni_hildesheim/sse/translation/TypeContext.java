package de.uni_hildesheim.sse.translation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.uni_hildesheim.sse.ModelUtility;
import de.uni_hildesheim.sse.ivml.DerivedType;
import de.uni_hildesheim.sse.ivml.IvmlPackage;
import de.uni_hildesheim.sse.ivml.Type;
import de.uni_hildesheim.sse.ivml.Typedef;
import de.uni_hildesheim.sse.ivml.Value;
import net.ssehub.easy.basics.modelManagement.Version;
import net.ssehub.easy.dslCore.translation.Message;
import net.ssehub.easy.dslCore.translation.MessageReceiver;
import net.ssehub.easy.dslCore.translation.TranslatorException;
import net.ssehub.easy.varModel.capabilities.DefaultReasonerAccess;
import net.ssehub.easy.varModel.capabilities.IvmlReasonerCapabilities;
import net.ssehub.easy.varModel.cst.ConstantValue;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.cst.Self;
import net.ssehub.easy.varModel.cst.Variable;
import net.ssehub.easy.varModel.cst.VariablePool;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.AttributeAssignment;
import net.ssehub.easy.varModel.model.Comment;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.ContainableModelElement;
import net.ssehub.easy.varModel.model.ContainableModelElementList;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.IModelElement;
import net.ssehub.easy.varModel.model.IvmlDatatypeVisitor;
import net.ssehub.easy.varModel.model.IvmlException;
import net.ssehub.easy.varModel.model.IvmlKeyWords;
import net.ssehub.easy.varModel.model.ModelElement;
import net.ssehub.easy.varModel.model.ModelQuery;
import net.ssehub.easy.varModel.model.ModelQueryException;
import net.ssehub.easy.varModel.model.OperationDefinition;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.ProjectImport;
import net.ssehub.easy.varModel.model.datatypes.BooleanType;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.Container;
import net.ssehub.easy.varModel.model.datatypes.CustomDatatype;
import net.ssehub.easy.varModel.model.datatypes.IContainableElementsSorter;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.IResolutionScope;
import net.ssehub.easy.varModel.model.datatypes.IntegerType;
import net.ssehub.easy.varModel.model.datatypes.MetaType;
import net.ssehub.easy.varModel.model.datatypes.RealType;
import net.ssehub.easy.varModel.model.datatypes.Reference;
import net.ssehub.easy.varModel.model.datatypes.Sequence;
import net.ssehub.easy.varModel.model.datatypes.Set;
import net.ssehub.easy.varModel.model.datatypes.StringType;
import net.ssehub.easy.varModel.model.datatypes.VersionType;
import net.ssehub.easy.varModel.model.values.NullValue;
import net.ssehub.easy.varModel.model.values.ValueFactory;
import net.ssehub.easy.varModel.persistency.AbstractVarModelWriter;

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

    private ContainableModelElementList implicitDefinitions = new ContainableModelElementList(null);
    private Project project;
    private MessageReceiver messageReceiver;
    private VariablePool variablePool = new VariablePool();
    private Map<Compound, Self> selfPool = new HashMap<Compound, Self>();

    // may support shadowed variables
    private Stack<ContainableModelElementList> directContext = new Stack<ContainableModelElementList>();
    private ContainableElementsMapAndComparator sortMap = new ContainableElementsMapAndComparator();
    private Map<IContainableElementsSorter, ContainableElementsMapAndComparator> elementSortMaps 
        = new HashMap<IContainableElementsSorter, ContainableElementsMapAndComparator>();
    private Map<String, List<Compound>> unresolvedCompoundRefinements = new HashMap<String, List<Compound>>();

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
     * Creates a local type context.
     * 
     * @param context the global type context to take basic information from
     */
    public TypeContext(TypeContext context) {
        this.project = context.project;
        this.messageReceiver = context.messageReceiver;
    }

    /**
     * Push a resolution layer in case that intermediary variables shell be considered, e.g.
     * within a compound. Please note that the parent itself is not added to the layer/context
     * and needs a specific subsequent add call.
     * 
     * @param parent the parent (scope, may be <b>null</b> - in this case the parent scope of the previous 
     *   layer is considered)
     */
    public void pushLayer(IModelElement parent) {
        if (null == parent && !directContext.isEmpty()) {
            parent = directContext.peek().getParent();
        }
        directContext.push(new ContainableModelElementList(parent));
    }
    
    /**
     * Pushes the enclosing parents of <code>decVar</code>.
     * 
     * @param decVar the variable to push
     * @return the number of layers pushed
     */
    public int pushParent(DecisionVariableDeclaration decVar) {
        return pushParentRec(decVar);
    }

    /**
     * Pushes the enclosing parents of <code>elt</code> in a recursive manner.
     * 
     * @param elt the element to push the parents for
     * @return the number of layers pushed
     */
    private int pushParentRec(IModelElement elt) {
        int result = 0;
        if (null != elt) {
            if (!(elt instanceof Project)) {
                result = pushParentRec(elt.getParent());
                if (elt instanceof Compound) {
                    pushLayer(elt);
                    addToContext((Compound) elt);
                    result++;
                }
            } 
        }
        return result;
    }
    
    /**
     * Pops <code>count</code> layers.
     * 
     * @param count the amount of layers to pop
     * @see #pushParent(DecisionVariableDeclaration)
     */
    public void popLayer(int count) {
        for (int i = 1; i <= count; i++) {
            popLayer();
        }
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
        addToContext(comp, new HashSet<Compound>());
    }

    /**
     * Adds a compound to the current context (layer). Please call {@link #pushLayer()} before.
     * 
     * @param comp the compound for which all contained variables shall be added
     * @param done already added compounds
     */
    private void addToContext(Compound comp, java.util.Set<Compound> done) {
        if (!done.contains(comp)) {
            done.add(comp);
            if (null != comp.getRefines()) {
                addToContext(comp.getRefines(), done);
            }
            int count = comp.getElementCount();
            for (int c = 0; c < count; c++) {
                addToContext(comp.getElement(c));
            }
            for (int a = 0; a < comp.getAssignmentCount(); a++) {
                addToContext(comp.getAssignment(a));
            }
        }
    }

    /**
     * Adds an attribute assignment to the current context (layer). Please call {@link #pushLayer()} before.
     * 
     * @param assignment the assignment for which all contained variables shall be added
     */
    public void addToContext(AttributeAssignment assignment) {
        if (null != assignment) {
            int count = assignment.getElementCount();
            for (int c = 0; c < count; c++) {
                addToContext(assignment.getElement(c));
            }
            for (int a = 0; a < assignment.getAssignmentCount(); a++) {
                addToContext(assignment.getAssignment(a));
            }
        }
    }
    
    /**
     * Stores a refined compound where the parent/super compound could not be loaded at the current time. 
     * @param compound A refined compound where the super compound was not set so far (i.e. is set to <tt>null</tt>).
     * @param unresolvedParentCompound The name of the super/parent compound, which was not found so far.
     */
    void addToContext(Compound compound, String unresolvedParentCompound) {
        List<Compound> uncompletedCompounds = unresolvedCompoundRefinements.get(unresolvedParentCompound);
        if (null == uncompletedCompounds) {
            uncompletedCompounds = new ArrayList<Compound>();
            unresolvedCompoundRefinements.put(unresolvedParentCompound, uncompletedCompounds);
        }
        uncompletedCompounds.add(compound);
    }
    
    /**
     * Returns a list of compounds where the given compound was specified as a super/parent compound, but could not be
     * set, as it was not available during parsing the child compound.
     * @param parentCompound The parent/super compound of a refinement.
     * @return <tt>null</tt> or a list of incomplete compounds.
     */
    List<Compound> getUnresolvedCompoundRefinments(String parentCompound) {
        return unresolvedCompoundRefinements.get(parentCompound);
    }
    
    /**
     * Clears the list of incomplete compounds, where the parent/super compound of a refinement was missing.
     * Should be done after the refinements where resolved.
     * @param parentCompound The name of the super/parent compound.
     */
    void clearUnresolvedCompounds(String parentCompound) {
        unresolvedCompoundRefinements.remove(parentCompound);
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
     * Obtains a CTS variable node for a given variable declaration, i.e., creates it
     * or returns it from the variable pool of this context.
     *  
     * @param decl the declaration
     * @return the variable
     */
    public final Variable obtainVariable(AbstractVariable decl) {
        return variablePool.obtainVariable(decl);
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
        if (null != type) { // due to xText incremental parsing
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
                    throw new TranslatorException("<unspecified type>", type, causingFeature, 
                        TranslatorException.INTERNAL);
                }
                // search the implicit ones
                try {
                    String searchName = ModelUtility.stringValue(derived, true);
                    result = ModelQuery.findElementByTypeName(this, searchName, restriction);
                } catch (ModelQueryException e) {
                    throw new TranslatorException(e, type, causingFeature);
                }
                if (null == result) {
                    IDatatype containedType = resolveType(derived.getType());
                    if (derived.getOp().equals(IvmlKeyWords.SETOF)) {
                        result = addImplicitDefinition(new Set(typeName, containedType, project));
                        restriction = Set.class;
                    } else if (derived.getOp().equals(IvmlKeyWords.SEQUENCEOF)) {
                        result = addImplicitDefinition(new Sequence(typeName, containedType, project));
                        restriction = Sequence.class;
                    } else if (derived.getOp().equals(IvmlKeyWords.REFTO)) {
                        result = addImplicitDefinition(new Reference(typeName, containedType, project));
                        restriction = Reference.class;
                    }
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
     * Finds a reference type (declaration or defines an implicit type) for a given contained type.
     * 
     * @param contained the contained type
     * @return the reference type declaration
     */
    public IDatatype findRefType(IDatatype contained) {
        IDatatype result = null;
        try {
            String typeName = ModelQuery.getReferenceTypeSearchName(contained);
            result = ModelQuery.findElementByTypeName(this, typeName, Reference.class);
        } catch (ModelQueryException e) {
            // ???
        }
        if (null == result) {
            String typeName = IvmlKeyWords.REFTO + "(" + IvmlDatatypeVisitor.getUnqualifiedType(contained) + ")";
            result = addImplicitDefinition(new Reference(typeName, contained, project));
        }
        if (null == result) {
            result = Reference.TYPE; // last resort, shall not be used, avoid NPE
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
     * @param name the name of the variable to search for (may be qualified)
     * @param type the specific variable of datatype to be returned,
     *             {@link AbstractVariable} is used if <b>null</b>
     * @return the corresponding variable or <b>null</b>
     * @throws ModelQueryException
     *             in case of semantic problems
     */
    public AbstractVariable findVariable(String name,
            Class<? extends AbstractVariable> type) throws ModelQueryException {
        ModelQueryException ex = null;
        AbstractVariable result = null;
        // search contexts first, from newest to oldest
        for (int c = directContext.size() - 1; null == result && c >= 0; c--) {
            try {
                result = ModelQuery.findVariable(directContext.get(c), name, type);
            } catch (ModelQueryException e) {
                ex = e;
            }
        }
        if (null == result) {
            // last resort - ask the project, but not all variables are allowed/accessible...
            result = ModelQuery.findVariable(project, name, type);
            if (null != result && name.indexOf(IvmlKeyWords.NAMESPACE_SEPARATOR) < 0 
                && !(findActualParent(result) instanceof Project)) {
                result = null; // avoid erroneous compound access, exclude qualified access may                 
            }
        }
        if (null == result && ex != null) {
            throw ex;
        }
        return result;
    }
  
    /**
     * Returns the actual project or compound the <code>element</code> is located in.
     * 
     * @param elt the element
     * @return the actual parent
     */
    private IModelElement findActualParent(IModelElement elt) {
        IModelElement result = elt.getParent();
        while (null != result && null != result.getParent() 
            && !(result instanceof Project || result instanceof Compound)) {
            result = result.getParent();
        }
        return result;
    }

    /**
     * Searches for the use of a specified variable (declaration or compound access).
     * 
     * @param name the name of the variable to search for (may be qualified)
     * @return the corresponding variable or <b>null</b>
     * @throws ModelQueryException in case of semantic problems
     */
    public IModelElement findVariableUse(String name) throws ModelQueryException {
        IModelElement result = null;
        // search contexts first, from newest to oldest
        for (int c = directContext.size() - 1; null == result && c >= 0; c--) {
            result = ModelQuery.findVariableUse(directContext.get(c), name, null);
        }
        if (null == result) {
            // last resort - ask the project
            result = ModelQuery.findVariableUse(project, name, null);
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
     * Adds an implicit type definition.
     * 
     * @param type the implicitly defined type
     * @return <code>type</code>
     * 
     * @see #getElement(int)
     * @see #getElementCount()
     */
    CustomDatatype addImplicitDefinition(CustomDatatype type) {
        implicitDefinitions.add(type);
        return type;
    }

    /**
     * Resolves a value and returns the corresponding syntax tree (one node).
     * 
     * @param value the value to be converted
     * @param parent the model parent
     * @param object the grammar object this method is called for
     * @param feature the grammar feature this method is called for
     * @return the corresponding syntax tree
     * @throws TranslatorException in case of any translation problem
     */
    public ConstraintSyntaxTree resolveValue(Value value, IModelElement parent, EObject object,
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
            if (Version.isVersion(sValue)) { // mapped to qualifiedName by parser :o
                result = createValueTree(sValue, VersionType.TYPE, object, feature);
            } else {
                result = processQValue(sValue, object, feature);
            }
        } else if (null != value.getSValue()) { // string value
            result = createValueTree(value.getSValue(), StringType.TYPE, object, feature);
        } else if (null != value.getBValue()) { // boolean value
            result = createValueTree(value.getBValue(), BooleanType.TYPE, object, feature);
        } else if (null != value.getSelf()) {
            result = resolveSelf(parent, object, feature);
        } else if (null != value.getNullValue()) {
            result = new ConstantValue(NullValue.INSTANCE);
            if (!DefaultReasonerAccess.hasCapability(IvmlReasonerCapabilities.NULL_VALUE)) {
                messageReceiver.warning("'null' values are currently not fully supported by the reasoner", object, 
                    feature, Message.CODE_IGNORE);
            }
        } else if (null != value.getVersion()) {
            result = createValueTree(value.getVersion(), VersionType.TYPE, object, feature);
        } else {
            throw new TranslatorException("<no type alternative>", object, feature, ErrorCodes.INTERNAL);
        }
        return result;
    }

    /**
     * Resolves "self" and returns the corresponding syntax tree (one node).
     * 
     * @param parent the model parent
     * @param object the grammar object this method is called for
     * @param feature the grammar feature this method is called for
     * @return the corresponding syntax tree
     * @throws TranslatorException in case of any translation problem
     */
    private ConstraintSyntaxTree resolveSelf(IModelElement parent, EObject object, EStructuralFeature feature) 
        throws TranslatorException {
        ConstraintSyntaxTree result = null;
        if (parent instanceof Constraint) { // typically we are in a constraint
            parent = parent.getParent();
            if (parent instanceof Compound) {
                result = getSelf((Compound) parent);
            } 
        } else if (parent instanceof Compound) {
            result = getSelf((Compound) parent);
        }
        if (null == result) {
            throw new TranslatorException("self is only defined in compounds", object, feature, 
                ErrorCodes.UNKNOWN_ELEMENT);
        }
        return result;
    }
    
    /**
     * Returns a self instance from the self pool.
     * 
     * @param comp the compond to return the self instance for
     * @return the self instance
     */
    private Self getSelf(Compound comp) {
        Self self = selfPool.get(comp);
        if (null == self) {
            self = new Self(comp);
            selfPool.put(comp, self);
        }
        return self;
    }
    
    /**
     * Processes a qualified name as value.
     * 
     * @param sValue the qualified name as string
     * @param object the grammar object this method is called for
     * @param feature the grammar feature this method is called for
     * @return the corresponding syntax tree
     * @throws TranslatorException in case of any translation problem
     */
    ConstraintSyntaxTree processQValue(String sValue, EObject object,
        EStructuralFeature feature) throws TranslatorException {
        ConstraintSyntaxTree result = null;
        IvmlException varException = null;
        AbstractVariable var = null;
        try {
            var = findVariable(sValue, null);
        } catch (IvmlException e) {
            varException = e;
        }
        if (null == var) {
            try {
                net.ssehub.easy.varModel.model.values.Value litValue = ModelQuery
                    .enumLiteralAsValue(project, sValue);
                if (null != litValue) {
                    checkEnumOclCompliance(sValue, object, feature);
                    result = new ConstantValue(litValue);
                } else {
                    IDatatype type = findType(sValue, null);
                    if (null == type && sValue.equals(project.getName())) {
                        type = project.getType();
                    }
                    if (null != type) {
                        result = new ConstantValue(ValueFactory.createValue(MetaType.TYPE, type));
                    } else {
                        if (null != varException) {
                            throw new TranslatorException(varException, object, feature);
                        } else {
                            throw new TranslatorException("'" + sValue + "' is unknown", object, feature,
                                ErrorCodes.UNKNOWN_ELEMENT);
                        }
                    }
                }
            } catch (IvmlException e) {
                throw new TranslatorException(e, object, feature);
            }
        } else {
            result = obtainVariable(var);
        }
        return result;
    }

    /**
     * Checks a (potentially) qualified enum literal name for OCL compliance if enabled.
     * 
     * @param qName the qualified name
     * @param object the grammar object this method is called for
     * @param feature the grammar feature this method is called for
     */
    public void checkEnumOclCompliance(String qName, EObject object, EStructuralFeature feature) {
        if (AbstractVarModelWriter.considerOclCompliance() 
            && qName.indexOf(IvmlKeyWords.ENUM_ACCESS) > 0) {
            messageReceiver.warning("OCL compliance: Enum literal access shall be stated by '::' "
                + "rather than '.'", object, feature, ErrorCodes.WARNING_USAGE);
        }
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

    @Override
    public int getImportsCount() {
        return 0;
    }

    @Override
    public ProjectImport getImport(int index) {
        throw new IndexOutOfBoundsException();
    }
    
    @Override
    public IModelElement getParent() {
        return null;
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public boolean hasInterfaces() {
        return false;
    }

    @Override
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
            elementSortMaps.remove(sorter);
        }
    }
    
    /**
     * Clears this type context (for possible reuse).
     */
    public void clear() {
        variablePool.clear();
        implicitDefinitions.clear();
        project = null;
        directContext.clear();
        sortMap.clear();
        for (ContainableElementsMapAndComparator c : elementSortMaps.values()) {
            c.clear();
        }
        elementSortMaps.clear();
    }

    @Override
    public ContainableModelElement getElement(String name) {
        return project.getElement(name);
    }
    
}
