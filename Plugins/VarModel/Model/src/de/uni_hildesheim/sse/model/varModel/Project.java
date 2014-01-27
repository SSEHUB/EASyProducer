package de.uni_hildesheim.sse.model.varModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import de.uni_hildesheim.sse.model.varModel.datatypes.CustomOperation;
import de.uni_hildesheim.sse.model.varModel.datatypes.DerivedDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.ICustomOperationAccessor;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.IResolutionScope;
import de.uni_hildesheim.sse.utils.modelManagement.IModel;
import de.uni_hildesheim.sse.utils.modelManagement.IndentationConfiguration;
import de.uni_hildesheim.sse.utils.modelManagement.ModelImport;
import de.uni_hildesheim.sse.utils.modelManagement.Version;

/**
 * This class holds the project imports, the containable model-, and attributable elements.
 * Project is the top-level element of each VarModel. Use {@link #getVariable()} for 
 * attributing a project.
 * 
 * @author Marcel Lueder
 * @author Holger Eichelberger
 */
public class Project extends ModelElement implements IModel, IAttributableElement, 
    IResolutionScope, ICustomOperationAccessor {
    
    private List<ContainableModelElement> modelElements;
    private Version version;
    private List<ProjectImport> imports;
    // lazy initialization
    private ProjectType type = new ProjectType(this);
    private int interfaceCount = 0; // speeds up search, consider when removing elements!
    private Project parent;

    /**
     * Stores the (pseudo) variable for this project. We need this variable
     * to attribute a project.
     */
    private DecisionVariableDeclaration variable;
    
    /**
     * List of internally created constraints, which are not modeled explicitly,
     * e.g. constraints for instances of a <code>DerivedDatatype</code>. This list must not be saved.
     */
    private List<InternalConstraint> internalConstraints;

    /**
     * Comments directly attached to this project (lazy initialization).
     */
    private StructuredComment comment;
    
    /**
     * Constructor for the project.
     * @param name Name of project
     */
    public Project(String name) {
        super(name);
        modelElements = new ArrayList<ContainableModelElement>();
        imports = new ArrayList<ProjectImport>();
        version = null;
        internalConstraints = new ArrayList<InternalConstraint>();
        variable = new ProjectDecisionVariableDeclaration(name, type, this);
    }
    
    /**
     * Adds an import to this project. Conflicts are added always,
     * imports are checked for duplicates.
     * 
     * @param pimport The import
     * @return <code>true</code> if the addition was successful, 
     *   <code>false</code> else due to duplicated names
     */
    public boolean addImport(ProjectImport pimport) {
        boolean found = false;
        if (!pimport.isConflict()) {
            for (int i = 0; !found && i < imports.size(); i++) {
                ProjectImport tmp = imports.get(i);
                if (tmp.getProjectName().equals(pimport.getProjectName())) {
                    String ifName = tmp.getInterfaceName();
                    if (null == ifName) {
                        found = ifName == pimport.getInterfaceName();
                    } else {
                        found = ifName.equals(pimport.getInterfaceName());
                    }
                }
            }
        }
        if (!found) {
            imports.add(pimport);
        }
        return !found; // use exception?
    }
    
    /**
     * Method for adding Constraints of a VariableDeclaration of a DerivedDatatype.
     * @param constraints the constraints related to the concrete VariableDeclaration
     */
    void addInternalConstraints(InternalConstraint[] constraints) {
        for (int i = 0; i < constraints.length; i++) {
            internalConstraints.add(constraints[i]);
        }
    }
    
    /**
     * Returns the internalConstraints of the project, needed for derivedDatatypes.
     * @return the number of internalConstraints stored in this project.
     */
    public int getInternalConstraintCount() {
        return internalConstraints.size();
    }
    
    /**
     * Returns the internal constraints specified by <code>index</code>. <br/>
     * This list of internally created constraints are not modeled explicitly. For instance, these constraints are
     * constraints for instances of a <code>DerivedDatatype</code>. This list must not be saved.
     * 
     * @param index a 0-based index specifying internal constraint to be returned
     * @return all existing constraints of the project
     * @throws IndexOutOfBoundsException if the index is out of range
     *         (<tt>index &lt; 0 || index &gt;= size()</tt>)
     */
    public InternalConstraint getInternalConstraint(int index) {
        return internalConstraints.get(index);
    }
    
    /**
     * Removes all internal constraints of a given {@link DerivedDatatype}. <br>
     * This must be done in case a constraint for an existing {@link DerivedDatatype} changes.
     * Since the whole project is reparsed after an change, this should not occur.
     * @param originType The {@link DerivedDatatype} where the change occurred.
     */
    public void removeInternalConstraints(DerivedDatatype originType) {
        for (int i = 0; i < internalConstraints.size(); i++) {
            if (internalConstraints.get(i).getDerivedDatatype() == originType) {
                internalConstraints.remove(i);
            }
        }
    }
    
    /**
     * Removes all specified elements the list of modelElements.<br>
     * This method is only desired for removing constraints and freeze blocks
     * while adding configuration information to this project.
     * @param elementsToRemove Old elements which should be removed. See <tt>Configuration.toProject(false)</tt>.
     * @return <tt>true</tt> if this project changed as a result of the call
     */
    public boolean removeElements(List<ContainableModelElement> elementsToRemove) {
        return modelElements.removeAll(elementsToRemove);
    }
    
    /**
     * Removes the content of the project.
     * Removes:
     * <ul>
     * <li>All model elements</li>
     * <ul>
     * <li>All Internal constraints</li>
     * </ul>
     * <li>All Imports</li>
     * </ul>
     */
    public void clear() {
        modelElements = new ArrayList<ContainableModelElement>();
        imports = new ArrayList<ProjectImport>();
        internalConstraints = new ArrayList<InternalConstraint>();
    }

    /**
     * Returns the number of imports.
     * 
     * @return the number of imports
     */
    public int getImportsCount() {
        return imports.size();
    }
    
    /**
     * Returns the project import specified by <code>index</code>.
     * 
     * @param index a 0-based index specifying the import to be returned
     * @return the project import
     * @throws IndexOutOfBoundsException if 
     *   <code>index&lt;0 || index&gt;={@link #getImportsCount()}</code>
     */
    public ProjectImport getImport(int index) {
        return imports.get(index);
    }
    
    /**
     * Changes the version of this project.
     * 
     * @param version Version to set
     */
    public void setVersion(Version version) {
        this.version = version;
    }
    
    /**
     * Returns the version of this project.
     * 
     * @return the version or <code>null</code> if no version is specified for this project.
     */
    public Version getVersion() {
        return version;
    }
    
    /**
     * Returns a contained model element specified by <code>index</code>.
     * 
     * @param index a 0-based index specifying the operation to be returned
     * @return the contained element
     * @throws IndexOutOfBoundsException if 
     *   <code>index&lt;0 || index&gt;={@link #getElementCount()}</code>
     */
    public ContainableModelElement getElement(int index) {
        return modelElements.get(index);
    }

    /**
     * Returns the comment before the specified model element.
     * 
     * @param element the element to search for
     * @param ensureStructured whether a default structured comment shall be inserted before <code>element</code> 
     *   if no comment was found
     * @return the comment assigned to <code>element</code> or <b>null</b> if none was found or 
     *   <code>ensureStructured</code> is false, respectively
     */
    public Comment getCommentBefore(IModelElement element, boolean ensureStructured) {
        Comment result = null;
        if (null != modelElements) {
            int eltPos = modelElements.indexOf(element);
            if (eltPos >= 0) {
                int pos = eltPos - 1;
                if (pos > 0) {
                    IModelElement tmp = modelElements.get(pos);
                    if (tmp instanceof Comment) {
                        result = (Comment) tmp;
                    }
                }
                if (null == result && ensureStructured) {
                    result = new StructuredComment(null, this);
                    modelElements.add(eltPos, result);
                }
            }
        } else if (ensureStructured) {
            result = new StructuredComment(null, this); // fake, unclear
        }
        return result;
    }

    /**
     * Returns the number of contained elements.
     * 
     * @return the number of contained elements
     */
    public int getElementCount() {
        return modelElements.size();
    }
    
    /**
     * Returns whether this project contains an element (of the specified type)
     * and its name.
     * 
     * @param name the name to search for
     * @param cls optional type, may be <b>null</b>
     * @return <code>true</code> if this project contains the specified element, 
     *     <code>false</code> else
     */
    public boolean containsByName(String name, Class<? extends ContainableModelElement> cls) {
        boolean found = false;
        for (int m = 0; !found && m < modelElements.size(); m++) {
            ContainableModelElement tmp = modelElements.get(m);
            if (null == cls || cls.isInstance(tmp)) {
                // unsure - do we need the namespace here
                // getName may be null, e.g. in case of unnamed constraints
                found = null != tmp.getName() && tmp.getName().equals(name);
            }
        }
        return found;
    }
    
    /**
     * Method to add an object to the modelElement list of the project.
     * Only named elements are considered for checking duplicates!
     * 
     * @param element which should be added
     * @return <code>true</code> if the addition was successful, 
     *   <code>false</code> else due to duplicated names
     */
    public boolean add(ContainableModelElement element) {
        boolean found = false;
        if (null != element) {
            if (!(element instanceof Attribute) && !(element instanceof AttributeAssignment)) {
                // attributes are checked on the attributable element
                if (null != element.getName() && element.getName().length() > 0) {
                    found = containsByName(element.getName(), null);
                }
            }
            if (!found) {
                modelElements.add(element);
                if (element instanceof ProjectInterface) {
                    interfaceCount++;
                }
            }
        }
        return !found; // use exception?
    }
    
    /**
     * Method to add an operation definition to the modelElement list of the project.
     * 
     * @param definition the operation definition which should be added
     * @return <code>true</code> if the addition was successful, 
     *   <code>false</code> else due to duplicated names
     */
    public boolean add(OperationDefinition definition) {
        boolean ok = add((ContainableModelElement) definition); // explicitly refer to the add above
        if (ok) {
            // ensure consistency by fusing two add operations
            type.addOperation(definition.getOperation());
        }
        return ok; 
    }
    
    /**
     * Removes the given operation definition.
     * 
     * @param definition the definition to be removed
     * @return <code>true</code> if the operation was removed, <code>false</code> else
     */
    public boolean remove(OperationDefinition definition) {
        boolean result = false;
        result |= modelElements.remove(definition);
        result |= type.removeOperation(definition.getOperation());
        return result;
    }
    
    /** 
     * Accept method for the visitor.
     * 
     * @param visitor The visitor, which should process this model element.
     */
    public void accept(IModelVisitor visitor) {
        visitor.visitProject(this);
    }
    
    /**
     * Returns the operation specified by <code>index</code>.
     * 
     * @param index a 0-based index specifying the operation to be returned
     * @return the operation
     * @throws IndexOutOfBoundsException if 
     *   <code>index&lt;0 || index&gt;={@link #getOperationCount}</code>
     */
    public CustomOperation getOperation(int index) {
        return type.getOperation(index);
    }

    /**
     * Returns the number of operations.
     * 
     * @return the number of operations
     */
    public int getOperationCount() {
        return type.getOperationCount();
    }

    /**
     * Returns the (pseudo) datatype of this project. The returned type
     * is intended to be used as the operand for custom operations to be 
     * added with {@link #add(OperationDefinition)}.
     * 
     * @return the datatype
     */
    public IDatatype getType() {
        return type;
    }
    
    /**
     * Returns the (pseudo) variable for this project. We need this variable
     * to attribute a project.
     * 
     * @return the (pseudo) variable
     */
    public DecisionVariableDeclaration getVariable() {
        return variable;
    }
    
    /**
     * Returns whether this project has interfaces.
     * 
     * @return <code>true</code> if it has interfaces, <code>false</code> else
     */
    public boolean hasInterfaces() {
        return interfaceCount > 0;
    }

    /**
     * {@inheritDoc}
     */
    public boolean attribute(Attribute attribute) {
        return variable.attribute(attribute);
    }

    /**
     * {@inheritDoc}
     */
    public int getAttributesCount() {
        return variable.getAttributesCount();
    }

    /**
     * {@inheritDoc}
     */
    public Attribute getAttribute(String name) {
        return variable.getAttribute(name);
    }
    
    /**
     * {@inheritDoc}
     */
    public Attribute getAttribute(int index) {
        return variable.getAttribute(index);
    }
    
    /**
     * {@inheritDoc}
     */
    public boolean isInterface() {
        return false;
    }

    /** 
     * {@inheritDoc}
     */
    public String getNameSpace() {
        String namespace;
        if (null == parent) {
            namespace = getName();
        } else {
            namespace = parent.getNameSpace() + IvmlKeyWords.NAMESPACE_SEPARATOR + getName();
        }
        return namespace;
    }
    
    /**
     * Returns the parent of this project.
     * 
     * @return the parent of this project (in case of copied projects, may be <b>null</b>)
     */
    public Project getParent() {
        return parent;
    }
    
    /**
     * Changes the parent of this project (intended to be used internally by the copy mechanism).
     * @param parent the new parent
     */
    void setParent(Project parent) {
        this.parent = parent;
    }
    
    /**
     * Sets a structured comment object for this project.
     * 
     * @param comment the comment object (may be <b>null</b>)
     */
    public void setComments(StructuredComment comment) {
        this.comment = comment;
    }
    
    /**
     * Returns the structured comment for this project.
     * 
     * @return structured comment instance
     */
    public StructuredComment getComments() {
        return comment;
    }
    
    /**
     * Returns a comment for an <code>element </code> from within the {@link #getComments()}.
     * 
     * @param element the element to return the comment for
     * @return the element, may be <b>null</b>
     */
    public Comment getNestedComment(Object element) {
        Comment result;
        if (null == comment) {
            result = null;
        } else {
            result = comment.getComment(element);
        }
        return result;
    }
    
    /**
     * Sorts the contained elements according to the specified comparator. Please
     * note the following requirements for applying this method:
     * <ul>
     *   <li>All Elements which were added before this operation must still be 
     *       member of this project after executing this operation.</li>
     *   <li>Comments related to an element must occur before the element in the
     *       final sequence.</li>
     * </ul>
     * @param comp a comparator which fulfills the requirements above
     */
    public void sortContainedElements(Comparator<ContainableModelElement> comp) {
        assert null != comp;
        int size = modelElements.size();
        Collections.sort(modelElements, comp);
        assert modelElements.size() == size;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean propagateAttribute(Attribute attribute) {
        boolean successful = true;
        for (int m = 0; m < modelElements.size(); m++) {
            successful &= modelElements.get(m).propagateAttribute(attribute);
        }
        return successful;
    }

    /**
     * Returns the reference to the super model (if it exists).
     * 
     * @return always <b>null</b> as this does not exist in IVML
     */
    //@Override -> JDK 1.5
    public ModelImport<Project> getSuper() {
        return null;
    }

    /**
     * Returns the indentation configuration for this model. The indentation
     * configuration is considered to be immutable.
     * 
     * @return the indentation configuration (disabled if <b>null</b>)
     */
    public IndentationConfiguration getIndentationConfiguration() {
        return null; // disabled
    }
    
}
