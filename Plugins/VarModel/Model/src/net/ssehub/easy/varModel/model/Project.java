/*
 * Copyright 2009-2013 University of Hildesheim, Software Systems Engineering
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.ssehub.easy.varModel.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.ssehub.easy.basics.modelManagement.IModel;
import net.ssehub.easy.basics.modelManagement.IRestrictionEvaluationContext;
import net.ssehub.easy.basics.modelManagement.IndentationConfiguration;
import net.ssehub.easy.basics.modelManagement.ModelImport;
import net.ssehub.easy.basics.modelManagement.Version;
import net.ssehub.easy.varModel.cstEvaluation.LocalConfiguration;
import net.ssehub.easy.varModel.model.datatypes.CustomOperation;
import net.ssehub.easy.varModel.model.datatypes.ICustomOperationAccessor;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.IResolutionScope;

/**
 * This class holds the project imports, the containable model-, and attributable elements. Project is the top-level
 * element of each VarModel. Use {@link #getVariable()} for attributing a project.
 * 
 * @author Marcel Lueder
 * @author Holger Eichelberger
 */
public class Project extends ModelElement implements IModel, IAttributableElement, IResolutionScope,
    ICustomOperationAccessor, IFreezable, IConstraintHolder {

    private List<ContainableModelElement> modelElements;
    private Version version;
    private List<ProjectImport> imports;
    // lazy initialization
    private ProjectType type = new ProjectType(this);
    private int interfaceCount = 0; // speeds up search, consider when removing elements!
    private Project parent;
    private Map<String, ContainableModelElement> names = new HashMap<String, ContainableModelElement>();
    private long timestamp = System.currentTimeMillis();

    /**
     * Stores the (pseudo) variable for this project. We need this variable to attribute a project.
     */
    private DecisionVariableDeclaration variable;

    /**
     * Comments directly attached to this project (lazy initialization).
     */
    private StructuredComment comment;

    /**
     * Constructor for serialization.
     */
    Project() {
        super(null);
    }
    
    /**
     * Constructor for the project.
     * 
     * @param name
     *            Name of project
     */
    public Project(String name) {
        super(name);
        modelElements = new ArrayList<ContainableModelElement>();
        imports = new ArrayList<ProjectImport>();
        version = null;
        variable = new ProjectDecisionVariableDeclaration(name, type, this);
    }

    /**
     * Adds an import to this project. Conflicts are added always, imports are checked for duplicates.
     * 
     * @param pimport
     *            The import
     * @return <code>true</code> if the addition was successful, <code>false</code> else due to duplicated names
     */
    public boolean addImport(ProjectImport pimport) {
        boolean found = false;
        if (!pimport.isConflict()) {
            for (int i = 0; !found && i < imports.size(); i++) {
                ProjectImport tmp = imports.get(i);
                if (tmp.getProjectName().equals(pimport.getProjectName())) {
                    String ifName = tmp.getInterfaceName();
                    if (null == ifName) {
                        found = (null == pimport.getInterfaceName());
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
     * Removes an import from this project.
     * 
     * @param pimport
     *            the import to be removed
     * @return <code>true</code> if the removal was successful, <code>false</code> else due to duplicated names
     */
    public boolean removeImport(ProjectImport pimport) {
        boolean found = false;
        ProjectImport tmp = null;
        if (!pimport.isConflict()) {
            for (int i = 0; !found && i < imports.size(); i++) {
                tmp = imports.get(i);
                if (tmp.getProjectName().equals(pimport.getProjectName())) {
                    String ifName = tmp.getInterfaceName();
                    if (null == ifName) {
                        found = (null == pimport.getInterfaceName());
                    } else {
                        found = ifName.equals(pimport.getInterfaceName());
                    }
                }
            }
        }
        if (found) {
            imports.remove(tmp);
        }
        return found; // use exception?
    }

    /**
     * Removes all specified elements from this project.
     * 
     * @param elementsToRemove
     *            elements which should be removed. See {@code Configuration.toProject(false)}.
     * @return {@code true} if this project changed as a result of the call
     * @see #removeElement(ContainableModelElement)
     */
    public boolean removeElements(List<ContainableModelElement> elementsToRemove) {
        boolean result = false;
        for (int i = 0; i < elementsToRemove.size(); i++) {
            result |= removeElement(elementsToRemove.get(i));
        }
        return result;
    }

    /**
     * Removes the specified element from from this project.
     * 
     * @param element
     *            the element that should be removed. See {@code Configuration.toProject(false)}.
     * @return {@code true} if this project changed as a result of the call
     */
    public boolean removeElement(ContainableModelElement element) {
        names.remove(element.getName());
        names.remove(element.getQualifiedName());
        return modelElements.remove(element);
    }

    /**
     * Removes the content of the project. Removes:
     * <ul>
     * <li>All model elements</li>
     * <li>All Internal constraints</li>
     * <li>All Imports</li>
     * </ul>
     */
    public void clear() {
        modelElements = new ArrayList<ContainableModelElement>();
        names.clear();
        imports = new ArrayList<ProjectImport>();
        for (int i = type.getOperationCount() - 1; i >= 0; i--) {
            type.removeOperation(type.getOperation(i));
        }
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
     * @param index
     *            a 0-based index specifying the import to be returned
     * @return the project import
     * @throws IndexOutOfBoundsException
     *             if <code>index&lt;0 || index&gt;={@link #getImportsCount()}</code>
     */
    public ProjectImport getImport(int index) {
        return imports.get(index);
    }

    /**
     * Changes the version of this project.
     * 
     * @param version
     *            Version to set
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
     * @param index
     *            a 0-based index specifying the operation to be returned
     * @return the contained element
     * @throws IndexOutOfBoundsException
     *             if <code>index&lt;0 || index&gt;={@link #getElementCount()}</code>
     */
    public ContainableModelElement getElement(int index) {
        return modelElements.get(index);
    }

    /**
     * Returns the comment before the specified model element.
     * 
     * @param element
     *            the element to search for
     * @param ensureStructured
     *            whether a default structured comment shall be inserted before <code>element</code> if no comment was
     *            found
     * @return the comment assigned to <code>element</code> or <b>null</b> if none was found or
     *         <code>ensureStructured</code> is false, respectively
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
     * Returns whether this project contains an element and its name.
     * 
     * @param name
     *            the name to search for
     * @return <code>true</code> if this project contains the specified element, <code>false</code> else
     */
    public boolean containsByName(String name) {
        // unsure - do we need the namespace here
        return null != name && names.containsKey(name);
    }

    @Override
    public ContainableModelElement getElement(String name) {
        return null == name ? null : names.get(name);
    }

    /**
     * Method to add an object to the modelElement list of the project. Only named elements are considered for checking
     * duplicates!
     * 
     * @param element
     *            which should be added
     * @return <code>true</code> if the addition was successful, <code>false</code> else due to duplicated names
     */
    public boolean add(ContainableModelElement element) {
        boolean found = false;
        if (null != element) {
            if (element instanceof OperationDefinition) {
                found = add((OperationDefinition) element);
            } else {
                if (!(element instanceof Attribute) && !(element instanceof AttributeAssignment)) {
                    // attributes are checked on the attributable element
                    if (null != element.getName() && element.getName().length() > 0) {
                        found = containsByName(element.getName());
                    }
                }
                if (!found) {
                    modelElements.add(element);
                    if (element instanceof ProjectInterface) {
                        interfaceCount++;
                    }
                    if (null != element.getName()) {
                        names.put(element.getName(), element);
                        names.put(element.getQualifiedName(), element);
                    }
                }
            }
        }
        return !found; // use exception?
    }

    /**
     * Method to add an operation definition to the modelElement list of the project.
     * 
     * @param definition
     *            the operation definition which should be added
     * @return <code>true</code> if the addition was successful, <code>false</code> else due to duplicated names
     */
    public boolean add(OperationDefinition definition) {
        boolean found = false;
        String opSig = definition.getOperation().getSignature();
        for (int op = 0, n = getOperationCount(); !found && op < n; op++) {
            found = opSig.equals(getOperation(op).getSignature());
        }
        if (!found) {
            modelElements.add(definition);
            type.addOperation(definition.getOperation());
        }
        return !found;
    }

    /**
     * Removes the given operation definition.
     * 
     * @param definition
     *            the definition to be removed
     * @return <code>true</code> if the operation was removed, <code>false</code> else
     */
    public boolean remove(OperationDefinition definition) {
        boolean result = false;
        result |= modelElements.remove(definition);
        result |= type.removeOperation(definition.getOperation());
        /*if (result && null != definition.getName()) {
            names.remove(definition.getName());
        }*/
        return result;
    }

    /**
     * Accept method for the visitor.
     * 
     * @param visitor
     *            The visitor, which should process this model element.
     */
    public void accept(IModelVisitor visitor) {
        visitor.visitProject(this);
    }

    /**
     * Returns the operation specified by <code>index</code>.
     * 
     * @param index
     *            a 0-based index specifying the operation to be returned
     * @return the operation
     * @throws IndexOutOfBoundsException
     *             if <code>index&lt;0 || index&gt;={@link #getOperationCount}</code>
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
     * Returns the (pseudo) datatype of this project. The returned type is intended to be used as the operand for custom
     * operations to be added with {@link #add(OperationDefinition)}.
     * 
     * @return the datatype
     */
    public IDatatype getType() {
        return type;
    }

    /**
     * Returns the (pseudo) variable for this project. We need this variable to attribute a project.
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

    @Override
    public boolean attribute(Attribute attribute) {
        return variable.attribute(attribute);
    }

    @Override
    public int getAttributesCount() {
        return variable.getAttributesCount();
    }

    @Override
    public Attribute getAttribute(String name) {
        return variable.getAttribute(name);
    }

    @Override
    public Attribute getAttribute(int index) {
        return variable.getAttribute(index);
    }

    @Override
    public boolean isInterface() {
        return false;
    }

    @Override
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
     * 
     * @param parent
     *            the new parent
     */
    void setParent(Project parent) {
        this.parent = parent;
    }

    /**
     * Sets a structured comment object for this project.
     * 
     * @param comment
     *            the comment object (may be <b>null</b>)
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
     * @param element
     *            the element to return the comment for
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
     * Sorts the contained elements according to the specified comparator. Please note the following requirements for
     * applying this method:
     * <ul>
     * <li>All Elements which were added before this operation must still be member of this project after executing this
     * operation.</li>
     * <li>Comments related to an element must occur before the element in the final sequence.</li>
     * </ul>
     * 
     * @param comp
     *            a comparator which fulfills the requirements above
     */
    public void sortContainedElements(Comparator<ContainableModelElement> comp) {
        assert null != comp;
        int size = modelElements.size();
        Collections.sort(modelElements, comp);
        assert modelElements.size() == size;
    }

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
    // @Override -> JDK 1.5
    public ModelImport<Project> getSuper() {
        return null;
    }

    /**
     * Returns the indentation configuration for this model. The indentation configuration is considered to be
     * immutable.
     * 
     * @return the indentation configuration (disabled if <b>null</b>)
     */
    public IndentationConfiguration getIndentationConfiguration() {
        return null; // disabled
    }

    @Override
    public void dispose() {
    }

    @Override
    public IRestrictionEvaluationContext getRestrictionEvaluationContext() {
        // put in here further "global" variables and their values needed for evaluating import / conflict restrictions
        return new LocalConfiguration();
    }

    @Override
    public void addConstraint(Constraint constraint) {
        add(constraint);
    }

    @Override
    public long getLastModification() {
        return timestamp;
    }

}
