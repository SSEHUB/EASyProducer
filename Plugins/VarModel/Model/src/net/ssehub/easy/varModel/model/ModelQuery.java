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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.ssehub.easy.varModel.model.datatypes.BooleanType;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.ConstraintType;
import net.ssehub.easy.varModel.model.datatypes.DatatypeVisitor;
import net.ssehub.easy.varModel.model.datatypes.Enum;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.IResolutionScope;
import net.ssehub.easy.varModel.model.datatypes.IntegerType;
import net.ssehub.easy.varModel.model.datatypes.QualifiedNameMode;
import net.ssehub.easy.varModel.model.datatypes.RealType;
import net.ssehub.easy.varModel.model.datatypes.StringType;
import net.ssehub.easy.varModel.model.search.PrefixSearchVisitor;
import net.ssehub.easy.varModel.model.search.SearchContext;
import net.ssehub.easy.varModel.model.search.SearchResult;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.model.values.ValueFactory;

/**
 * Provides an interface to query models.
 * 
 * @author Holger Eichelberger
 */
public class ModelQuery {

    // TODO further ambiguity checks

    public static final String MQ_SHORT_SET = "s";
    public static final String MQ_SHORT_SEQUENCE = "q";
    public static final String MQ_SHORT_REFERENCE = "r";
    
    private static final QualifiedNameMode TYPE_SEARCH_MODE = QualifiedNameMode.UNQUALIFIED;
    
    private static final List<MqDatatypeVisitor> VIS_INSTANCES = new ArrayList<MqDatatypeVisitor>();

    /**
     * A private quick datatype visitor.
     * 
     * @author Holger Eichelberger
     */
    private static class MqDatatypeVisitor extends DatatypeVisitor {

        /**
         * Constructs a visitor.
         */
        public MqDatatypeVisitor() {
            super(MQ_SHORT_SET, MQ_SHORT_SEQUENCE, MQ_SHORT_REFERENCE);
        }
    }
    
    /**
     * Returns a pooled datatype visitor instance.
     * 
     * @param mode the name mode
     * @return the visitor instance
     * 
     * @see #releaseDatatypeVisitor
     */
    private static final synchronized MqDatatypeVisitor getDatatypeVisitorInstance(QualifiedNameMode mode) {
        MqDatatypeVisitor vis;
        if (!VIS_INSTANCES.isEmpty()) {
            vis = VIS_INSTANCES.remove(VIS_INSTANCES.size() - 1);
        } else {
            vis = new MqDatatypeVisitor();
        }
        if (null != mode) {
            vis.setQualifiedNameMode(mode);
        }
        return vis;
    }
    
    /**
     * Releases a datatype visitor instance.
     * 
     * @param vis the instance to be released
     */
    private static final synchronized void releaseDatatypeVisitor(MqDatatypeVisitor vis) {
        vis.clear();
        VIS_INSTANCES.add(vis);
    }

    /**
     * Returns the textual representation of the given element.
     * 
     * @param element the element to be represented
     * @param mode the name mode
     * @return the textual representation
     */
    private static final String getType(ContainableModelElement element, QualifiedNameMode mode) {
        MqDatatypeVisitor vis = getDatatypeVisitorInstance(mode);
        element.accept(vis);
        String result = vis.getResult();
        releaseDatatypeVisitor(vis);
        return result;
    }
    
    /**
     * Returns the textual representation of the given type.
     * 
     * @param type the type to be represented
     * @param mode the name mode
     * @return the textual representation
     */
    private static final String getType(IDatatype type, QualifiedNameMode mode) {
        MqDatatypeVisitor vis = getDatatypeVisitorInstance(mode);
        type.accept(vis);
        String result = vis.getResult();
        releaseDatatypeVisitor(vis);
        return result;
    }

    /**
     * Returns the name to be used for searching for a reference with contained type <code>type</code>.
     * 
     * @param type the contained type
     * @return the search name
     */
    public static final String getReferenceTypeSearchName(IDatatype type) {
        MqDatatypeVisitor vis = getDatatypeVisitorInstance(TYPE_SEARCH_MODE);
        vis.constructReferenceName(type);
        String result = vis.getResult();
        releaseDatatypeVisitor(vis);
        return result;
    }
    
    /**
     * Finds a project with given name.
     * 
     * @param project the project to start the search at (including imports) 
     * @param name the name to search for
     * @return the found project or <b>null</b> if there is none
     */
    public static Project findProject(Project project, String name) {
        return findProject(project, name, "", new HashSet<Project>());
    }
    
    /**
     * Finds a project with given name.
     *
     * @param project the project to start the search at (including imports) 
     * @param name the name to search for
     * @param path the current qualified search path
     * @param done already processed projects
     * @return the found project or <b>null</b> if there is none
     */
    private static Project findProject(Project project, String name, String path, Set<Project> done) {
        Project result = null;
        if (!done.contains(project)) {
            done.add(project);
            String pName = project.getName();
            if (path.length() > 0) {
                path = path + IvmlKeyWords.NAMESPACE_SEPARATOR;
            }
            path += pName; 
            if (pName.equals(name) || (path.length() > 0 && path.equals(name))) {
                result = project;
            } else {
                result = null;
                for (int i = 0; null == result && i < project.getImportsCount(); i++) {
                    Project imp = project.getImport(i).getResolved();
                    if (null != imp) {
                        result = findProject(imp, name, path, done); 
                    }
                }
            }
        }
        return result;
    }

    /**
     * Finds the specified data type definition in the given <code>project</code>.
     * 
     * @param elements the elements to search for
     * @param name the name of the type to search for (may be qualified)
     * @param type the specific type of datatype to be returned, {@link IDatatype} 
     *   is used if <b>null</b>
     * @return the corresponding type or <b>null</b>
     * @throws ModelQueryException in case of violated project access restrictions
     * 
     * @see #findType(IResolutionScope, String, boolean, Class)
     */
    public static IDatatype findType(IResolutionScope elements, String name, Class<? extends IDatatype> type) 
        throws ModelQueryException {
        return findType(elements, name, false, type, new HashSet<IResolutionScope>());
    }

    /**
     * Finds the specified data type definition in the given <code>project</code>.
     * 
     * @param elements the elements to search for
     * @param name the name of the type to search for (may be qualified)
     * @param considerVariableDeclarations take the types of variable declarations into account
     * @param type the specific type of datatype to be returned, {@link IDatatype} 
     *   is used if <b>null</b>
     * @param done already done resolution scopes
     * @return the corresponding type or <b>null</b>
     * @throws ModelQueryException in case of violated project access restrictions
     */
    private static IDatatype findType(IResolutionScope elements, String name, 
        boolean considerVariableDeclarations, Class<? extends IDatatype> type, Set<IResolutionScope> done) 
        throws ModelQueryException {
        IDatatype result = null;
        if (!done.contains(elements)) {
            done.add(elements);
            // determine import scope
            //IResolutionScope initialScope = elements;
            IResolutionScope importedScope = getScope(elements, name);
            if (null != importedScope) {
                name = removeNamespace(name);
                elements = importedScope;
                considerVariableDeclarations = (/*elements != initialScope &&*/ elements.isInterface());
            }
            
            if (null == type) {
                type = IDatatype.class;
            }
            if (BooleanType.TYPE.getName().equals(name)) {
                result = BooleanType.TYPE;
            } else if (IntegerType.TYPE.getName().equals(name)) {
                result = IntegerType.TYPE;
            } else if (RealType.TYPE.getName().equals(name)) {
                result = RealType.TYPE;
            } else if (StringType.TYPE.getName().equals(name)) {
                result = StringType.TYPE;
            } else if (ConstraintType.TYPE.getName().equals(name)) {
                result = ConstraintType.TYPE;
            }
            // further checks happen inside the sub methods
            if (null != result && !type.isAssignableFrom(result.getClass())) { 
                result = null;
            }
            if (null == result) {
                result = findElementByTypeName(elements, name, type);
            }
            if (null == result && considerVariableDeclarations) {
                int size = elements.getElementCount();
                for (int e = 0; null == result && e < size; e++) {
                    ContainableModelElement elt = elements.getElement(e);
                    if (elt instanceof DecisionVariableDeclaration) {
                        DecisionVariableDeclaration varDecl = (DecisionVariableDeclaration) elt;
                        if (varDecl.getType().getName().equals(name)) {
                            result = varDecl.getType();
                        }
                    }
                }
            }
            // search unqualified imported elements
            if (null == result) {
                for (int i = 0; null == result && i < elements.getImportsCount(); i++) {
                    ProjectImport imp = elements.getImport(i);
                    if (!imp.isConflict()) {
                        IResolutionScope imported = imp.getScope();
                        if (null != imported) {
                            result = findType(imported, name, imported.isInterface(), type, done);
                        }
                    }
                }
            }
        }
        return result;
    }

    /**
     * Finds the specified data type definition in the given <code>elements</code>.
     * 
     * @param elements the elements to search for
     * @param typeName the name of the type to search for (may be qualified)
     * @param type the specific type of datatype to be returned, {@link IDatatype} 
     *   is used if <b>null</b>
     * @return the corresponding type or <b>null</b>
     * @throws ModelQueryException in case of violated project access restrictions
     */
    public static IDatatype findElementByTypeName(IResolutionScope elements, String typeName, 
        Class<? extends IDatatype> type) throws ModelQueryException {
        return findElementByTypeName(elements, typeName, type, new HashSet<IResolutionScope>());
    }

    /**
     * Finds the specified data type definition in the given <code>elements</code>.
     * 
     * @param elements the elements to search for
     * @param typeName the name of the type to search for (may be qualified)
     * @param type the specific type of datatype to be returned, {@link IDatatype} 
     *   is used if <b>null</b>
     * @param done the already processed resolution scopes
     * @return the corresponding type or <b>null</b>
     * @throws ModelQueryException in case of violated project access restrictions
     */
    public static IDatatype findElementByTypeName(IResolutionScope elements, String typeName, 
        Class<? extends IDatatype> type, Set<IResolutionScope> done) throws ModelQueryException {
        IDatatype result = null;
        // determine import scope
        if (!done.contains(elements)) {
            done.add(elements);

            IResolutionScope importedScope = getScope(elements, typeName);
            if (null != importedScope) {
                typeName = removeNamespace(typeName);
                elements = importedScope;
            }
            
            if (null == type) {
                type = IDatatype.class;
            }
            for (int c = 0; c < elements.getElementCount(); c++) {
                ContainableModelElement element = elements.getElement(c);
                if (type.isAssignableFrom(element.getClass())) {
                    String elName = getType(element, TYPE_SEARCH_MODE);
                    if (elName.equals(typeName)) {
                        result = (IDatatype) element;
                        break;
                    }
                }
                if (element instanceof AbstractVariable) { 
                    // in case of interface resolutions - consider dependent types of exports
                    AbstractVariable var = (AbstractVariable) element;
                    IDatatype varType = var.getType();
                    if (varType instanceof Compound) {
                        result = findElementByTypeName((Compound) varType, typeName);
                        if (null != result) {
                            break;
                        }
                    }
                }
            }
            
            // search unqualified imported elements
            if (null == result) {
                for (int i = 0; null == result && i < elements.getImportsCount(); i++) {
                    ProjectImport imp = elements.getImport(i);
                    if (!imp.isConflict()) {
                        IResolutionScope imported = imp.getScope();
                        if (null != imported) {
                            result = findElementByTypeName(imported, typeName, type, done);
                        }
                    }
                }
            }
        }
        return result;
    }

    /**
     * Finds the specified data type definition in the given <code>container</code>.
     * 
     * @param container the container to search for
     * @param typeName the name of the type to search for (may be qualified)
     * @return the corresponding type or <b>null</b>
     * @throws ModelQueryException in case of violated project access restrictions
     */
    public static IDatatype findElementByTypeName(IDecisionVariableContainer container, String typeName) 
        throws ModelQueryException {
        IDatatype result = null;
        for (int c = 0; null == result && c < container.getElementCount(); c++) {
            DecisionVariableDeclaration element = container.getElement(c);
            IDatatype type = element.getType();
            String tName = getType(element.getType(), TYPE_SEARCH_MODE);
            if (tName.equals(typeName)) {
                result = type;
                break;
            }
        }
        for (int a = 0; null == result && a < container.getAssignmentCount(); a++) {
            result = findElementByTypeName(container.getAssignment(a), typeName);
        }
        return result;
    }

    /**
     * Returns the resolution scope determined by the qualified <code>name</code>
     * relative to the given <code>scope</code>.
     * 
     * @param scope the scope to start with
     * @param name the (qualified) name of the relative scope to return
     * @return the relative scope
     * @throws ModelQueryException in case of violated project access restrictions
     */
    private static IResolutionScope getScope(IResolutionScope scope, String name) 
        throws ModelQueryException {
        IResolutionScope result = null;
        // determine the namespace and throw away the remainder
        String namespace;
        int pos = name.lastIndexOf(IvmlKeyWords.NAMESPACE_SEPARATOR);
        if (pos > 0) {
            namespace = name.substring(0, pos);
        } else {
            namespace = null;
        }
        
        if (null == namespace || 0 == namespace.length()) {
            // if there is no namespace than the result is the given scope
            result = scope;
        } else {
            result = getImportedScope(scope, namespace);
            if (null == result) {
                throw new ModelQueryException("cannot resolve '" + name + "'", 
                    ModelQueryException.UNMATCHED_IMPORT);
            }
        }
        return result;
    }

    /**
     * Returns the current scope due to imports.
     * 
     * @param scope the scope to start with
     * @param namespace the namespace of the resulting scope
     * @return the relative scope
     * @throws ModelQueryException in case of violated project access restrictions
     */
    private static IResolutionScope getImportedScope(IResolutionScope scope, 
        String namespace) throws ModelQueryException {
        // look into all namespace parts from left to right and 
        // successively determine the scope. namespaceStart contains
        // the part we are looking into, namespaceTail the remainder
        // to be resolved
        IResolutionScope result = null;
        IncrementalNamespace ispace = new IncrementalNamespace(namespace);
        IResolutionScope curScope = scope;
        IResolutionScope imported = null;
        Set<Project> done = new HashSet<Project>();
        do {
            ispace.shiftRight();
            
            // search within scope, check name of scope, search imports
            IResolutionScope tmp = (IResolutionScope) findElementByName(
                curScope, ispace.namespaceStart, IResolutionScope.class);
            if (null == tmp) {
                IResolutionScope iter = curScope;
                do {
                    if (ispace.namespaceStart.equals(iter.getName())) {
                        tmp = iter;
                    } else {
                        // check for direct name of searched namespace
                        for (int i = 0; null == tmp && i < iter.getImportsCount(); i++) {
                            ProjectImport imp = iter.getImport(i);
                            if (checkScopeForImport(ispace.namespaceStart, imp, namespace)) {
                                // set resolved but not scope as this will happen in the next iteration
                                imported = imp.getResolved();
                                tmp = checkInterfaceImport(imp.getScope(), ispace, namespace, imported);
                            }
                        }
                        // check for direct imports of searched namespace
                        if (null == tmp) {
                            Project nested = searchImportedProject(namespace, iter, done);
                            done.clear();
                            if (null != nested) {
                                imported = nested;
                                tmp = checkInterfaceImport(imported, ispace, namespace, imported);
                            }
                        }
                    }
                    if (null == tmp) {
                        IModelElement par = iter.getParent();
                        if (par instanceof IResolutionScope) {
                            iter = (IResolutionScope) par;
                        } else {
                            iter = null;
                        }
                    }
                } while (null == tmp && iter != null);
            } 
            
            curScope = tmp;
        } while (null != curScope && ispace.hasTail());
        if (null != curScope) {
            if (null != imported) {
                boolean isCurScopeInterface = (curScope instanceof ProjectInterface);
                if (imported.hasInterfaces() && !isCurScopeInterface) {
                    // the inverse case cannot happen (or hasInterfaces is broken)
                    curScope = null;
                }
            }
            result = curScope;
        }
        return result;
    }
    
    /**
     * Searches for an indirectly imported project in depth-first search.
     * 
     * @param namespace the namespace to search for
     * @param scope the scope to search within
     * @param done already visited projects (avoid cycles)
     * @return the project matching the namespace or <b>null</b>
     */
    private static Project searchImportedProject(String namespace, IResolutionScope scope, Set<Project> done) {
        Project result = null;
        for (int i = 0; null == result && i < scope.getImportsCount(); i++) {
            ProjectImport imp = scope.getImport(i);
            Project resolved = imp.getResolved();
            if (null != resolved && !done.contains(resolved)) { 
                done.add(resolved);
                if (imp.getName().equals(namespace)) {
                    result = resolved;
                } else {
                    result = searchImportedProject(namespace, resolved, done);
                }
            }
        }
        return result;
    }

    /**
     * Performs final checks on accessing an imported interface.
     * @param scope the scope containing the interface being imported (may be <b>null</b>)
     * @param ispace the current state in resolving the namespace
     * @param namespace the initial namespace (for error messages)
     * @param project the containing project
     * @return <code>scope</code>
     * @throws ModelQueryException in case of interface access errors, i.e. <code>scope</code>
     *   does not contain the expected/specified interface in <code>ispace</code>
     */
    private static IResolutionScope checkInterfaceImport(IResolutionScope scope, 
        IncrementalNamespace ispace, String namespace, IResolutionScope project) throws ModelQueryException {
        if (null != scope && scope.isInterface()) {
            ispace.shiftRight();
            String importedIfName = ispace.namespaceStart; 
            // null != importedIfName may be null in case of variable access
            if (null != importedIfName && !scope.getName().equals(importedIfName)) {
                boolean importedIfExists = false;
                try {
                    importedIfExists = (null != findElementByName(project, importedIfName, 
                        ProjectInterface.class));
                } catch (ModelQueryException e) {
                    // don't care, if it does not exist, throw no exception above
                }
                if (importedIfExists) {
                    throw new ModelQueryException("'" + namespace + "' is not accessible", 
                        ModelQueryException.ACCESS_ERROR);
                }
            }
        }
        return scope;
    }
    
    /**
     * Represents an incrementally resolved namespace.
     * 
     * @author Holger Eichelberger
     */
    private static class IncrementalNamespace {
        private String namespaceStart;
        private String namespaceTail;

        /**
         * Constructs the namespace object from a given namespace.
         * @param namespace the namespace to be resolved
         */
        IncrementalNamespace(String namespace) {
            this.namespaceTail = namespace;
            this.namespaceStart = null;
        }
        
        /**
         * Shift right through the namespace (modifies the attributes).
         */
        void shiftRight() {
            if (null != namespaceTail) { // shift if not at end
                int pos = namespaceTail.indexOf(IvmlKeyWords.NAMESPACE_SEPARATOR);
                if (pos > 0) {
                    // this looks like namespaceStart::tail - split them
                    namespaceStart = namespaceTail.substring(0, pos);
                    namespaceTail = namespaceTail.substring(pos + IvmlKeyWords.NAMESPACE_SEPARATOR.length());
                } else {
                    // this is just a name - end of loop
                    namespaceStart = namespaceTail;
                    namespaceTail = null;
                }
            }
        }
        
        /**
         * Returns whether a namespace tail exists.
         * 
         * @return <code>true</code> if a namespace tail exists, <code>false</code> else
         */
        public boolean hasTail() {
            return (null != namespaceTail && namespaceTail.length() > 0);
        }
        
    }
    

    /**
     * Check the validity of the scope being imported.
     * 
     * @param name the name of the element being imported
     * @param imp the import model element
     * @param namespace the total namespace being accessed
     * @return <code>true</code> if the scope matches the import, <code>false</code> else
     * @throws ModelQueryException in case of illegal accesses
     */
    private static boolean checkScopeForImport(String name, ProjectImport imp, 
        String namespace) throws ModelQueryException {
        boolean ok = false;
        // prerequisite: we cannot import a conflict, the names must match and the imported project is resolved
        if (!imp.isConflict() && name.equals(imp.getProjectName()) && null != imp.getResolved()) {
            ok = true;
            IResolutionScope scope = imp.getScope(); // getResolved != null implies getScope != null
            // semantics: what is actually being imported must match
            String ifname = imp.getInterfaceName();
            if (null == ifname || 0 == ifname.length()) {
                // scope must be a project
                if (scope.isInterface()) {
                    throw new ModelQueryException("importing an unspecified interface '"
                        + scope.getName() + "'", ModelQueryException.MISMATCHED_IMPORT);
                }
            } else {
                // scope must be an interface and interface name must match the import
                if (scope.isInterface()) {
                    ok = scope.getName().equals(ifname);
                } else {
                    throw new ModelQueryException("importing project '" + scope.getName() 
                        + "' instead of interface '" + ifname + "'", ModelQueryException.MISMATCHED_IMPORT);
                }
            }
            
        }
        return ok;
    }

    /**
     * Removes a namespace prefix from <code>name</code>.
     * 
     * @param name the name to remove the namespace from
     * @return the stripped name (or <code>name</code> if <code>name</code> does not
     *   contain a namespace prefix)
     */
    private static String removeNamespace(String name) {
        String result = name;
        int pos = name.lastIndexOf(IvmlKeyWords.NAMESPACE_SEPARATOR);
        if (pos > 0) {
            result = name.substring(pos + IvmlKeyWords.NAMESPACE_SEPARATOR.length());
        }
        return result;
    }
    
    /**
     * Searches for a specified variable.
     * @param elements the elements to search for
     * @param name the name of the variable to search for (may be qualified)
     * @param type the specific variable of datatype to be returned, {@link AbstractVariable} 
     *   is used if <b>null</b>
     * @return the corresponding variable or <b>null</b>
     * @throws ModelQueryException in case of ambiguities
     */
    public static AbstractVariable findVariable(IResolutionScope elements, String name, 
                    Class<? extends AbstractVariable> type) throws ModelQueryException {
        if (null == type) {
            // set default value
            type = AbstractVariable.class;
        }
        return (AbstractVariable) findVariableUse(elements, name, type);
    }    
    
    /**
     * Searches for a specified variable or variable use.
     * @param elements the elements to search for
     * @param name the name of the variable to search for (may be qualified)
     * @param type the specific variable of datatype to be returned, {@link AbstractVariable} 
     *   is used if <b>null</b>
     * @return the corresponding variable or {@link CompoundAccessStatement}, <b>null</b> else
     * @throws ModelQueryException in case of ambiguities
     */
    public static IModelElement findVariableUse(IResolutionScope elements, String name, 
        Class<?> type) throws ModelQueryException {
        return findVariableUse(elements, name, type, new HashSet<IResolutionScope>());
    }        
        
    /**
     * Searches for a specified variable or variable use.
     * @param elements the elements to search for
     * @param name the name of the variable to search for (may be qualified)
     * @param type the specific variable of datatype to be returned, {@link AbstractVariable} 
     *   is used if <b>null</b>
     * @param done already processed scopes
     * @return the corresponding variable or {@link CompoundAccessStatement}, <b>null</b> else
     * @throws ModelQueryException in case of ambiguities
     */
    private static IModelElement findVariableUse(IResolutionScope elements, String name, 
        Class<?> type, Set<IResolutionScope> done) throws ModelQueryException {
        IModelElement result = null;
        if (!done.contains(elements)) {
            done.add(elements);

            String originalName = name;
            Object directResult = findElementByName(elements, name, type);
            // determine import scope
            IResolutionScope importedScope = getScope(elements, name);
            if (null != importedScope) {
                name = removeNamespace(name);
                elements = importedScope;
            }
            
            // separate element name and compound access
            String innerName = null;
            int pos = name.indexOf(IvmlKeyWords.COMPOUND_ACCESS);
            if (pos > 0) {
                innerName = name.substring(pos + 1);
                name = name.substring(0, pos);
            }
            result = findElementByName(elements, name, type);
            result = findCompoundOrAttributeAccess(elements, name, innerName, result);
            if (null != type && AbstractVariable.class.isAssignableFrom(type)) {
                // support legacy results
                if (result instanceof CompoundAccessStatement) {
                    CompoundAccessStatement acc = (CompoundAccessStatement) result;
                    result = acc.getSlotDeclaration();
                }
            }
            
            // search unqualified imported elements
            if (null == result) {
                for (int i = 0; null == result && i < elements.getImportsCount(); i++) {
                    ProjectImport imp = elements.getImport(i);
                    if (!imp.isConflict()) {
                        IResolutionScope imported = imp.getScope();
                        if (null != imported) {
                            result = findVariableUse(imported, name, type, done);
                        }
                    }
                }
            }
            
            if (null != type && null != result && !type.isAssignableFrom(result.getClass())) {
                result = null;
            }
            if (null != directResult && !directResult.equals(result)) {
                throw new ModelQueryException("name is ambiguous '" + originalName + "'", 
                     ModelQueryException.AMBIGUITY);
            }
        }
        return result;
    }

    /**
     * Finds a variable by compound/attribute access as part of {@link #findVariable(IResolutionScope, String, Class)}.
     * @param elements the elements to search for
     * @param name the name of the variable to search for 
     * @param innerName the name of the compound element/attribute
     * @param result the result determined so far
     * @return the subsequent compound, compound access or attribute access
     * @throws ModelQueryException in case of ambiguities
     */
    private static IModelElement findCompoundOrAttributeAccess(IResolutionScope elements, String name, 
        String innerName, IModelElement result) throws ModelQueryException {
        String fullInnerName = innerName;
        Project project;
        if (null == result && elements instanceof Project) {
            project = (Project) elements;
            if (null != innerName) {
                // if not found check project but only for inner names -> attributes
                result = ((Project) elements).getVariable();
            }
        } else {
            project = null;
        }
        
        while (null != innerName) {            
            int pos = name.indexOf(IvmlKeyWords.COMPOUND_ACCESS);
            String innerNamePart;
            if (pos > 0) {
                innerNamePart = name.substring(0, pos);
                innerName = name.substring(pos + 1);
            } else {
                innerNamePart = innerName;
                innerName = null;
            }
            if (result instanceof AbstractVariable) {
                AbstractVariable var = (AbstractVariable) result;
                Compound comp = null;
                result = null;
                if (null != var && var.getType().isAssignableFrom(Compound.TYPE)) {
                    comp = (Compound) var.getType();
                    result = findVariable(comp, innerNamePart);
                    if (null != result) {
                        // parent may be wrong
                        result = new CompoundAccessStatement(var, result.getName(), var.getParent());
                    }
                }
                if (null == result) {
                    comp = (Compound) findElementByTypeName(elements, name, Compound.class);
                    if (null != comp) {
                        result = findVariable(comp, innerNamePart);
                    }
                }
                if (null == result || result instanceof AbstractVariable) {
                    AbstractVariable compoundResult = (AbstractVariable) result;
                    if (var instanceof IAttributableElement) {
                        result = findAttribute((IAttributableElement) var, innerNamePart);
                        if (null == result && null != project) {
                            result = findAttribute(project.getVariable(), innerNamePart);
                        }
                        if (null == result) {
                            result = compoundResult;
                        } else if (null != result && null == innerName && result.equals(compoundResult))  {
                            // only when inner name is at full resolution!
                            throw new ModelQueryException("ambiguity between attribute '" 
                                + fullInnerName + "' and slot on compound '" + comp.getName() + "'", 
                                ModelQueryException.AMBIGUITY);
                        }
                    }
                }
            }
        }
        return result;
    }

    /**
     * Finds an attribute with <code>name</code> on <code>element</code>.
     * 
     * @param element the attributable element
     * @param name the name of the attribute to search for
     * @return the attribute or <b>null</b> if none was found
     */
    private static AbstractVariable findAttribute(IAttributableElement element, String name) {
        AbstractVariable result = null;
        int aCount = element.getAttributesCount();
        for (int a = 0; null == result && a < aCount; a++) {
            Attribute attribute = element.getAttribute(a);
            if (attribute.getName().equals(name)) {
                result = attribute;
            }
        }
        return result;
    }

    /**
     * Searches for a variable of <code>name</code> in a given <code>compound</code>. This
     * method takes refined compounds (super compounds) into account.
     * 
     * @param compound the compound to search for
     * @param name the name of the variable to search for (may be qualified)
     * @return the variable or <b>null</b>
     */
    private static AbstractVariable findVariable(Compound compound, String name) {
        AbstractVariable result = compound.getElement(name);
        if (null == result) {
            Compound superCompound = compound.getRefines();
            if (null != superCompound) {
                result = findVariable(superCompound, name);
            }
        }
        return result;
    }
    
    /**
     * Finds an element by its given name in <code>elements</code>.
     * 
     * @param elements the elements to search for
     * @param name the name of the element to search for
     * @param type the specific type of element to be returned
     * @return the found element or <b>null</b>
     * @throws ModelQueryException in case of violated project access restrictions
     */
    public static ContainableModelElement findElementByName(IResolutionScope elements, String name, 
        Class<?> type) throws ModelQueryException {
        return findElementByName(elements, name, type, new HashSet<IResolutionScope>());
    }
    
    /**
     * Finds an element by its given name in <code>elements</code>.
     * 
     * @param elements the elements to search for
     * @param name the name of the element to search for
     * @param type the specific type of element to be returned
     * @param done already processed resolution scopes
     * @return the found element or <b>null</b>
     * @throws ModelQueryException in case of violated project access restrictions
     */
    private static ContainableModelElement findElementByName(IResolutionScope elements, String name, 
        Class<?> type, Set<IResolutionScope> done) throws ModelQueryException {
        ContainableModelElement result = null;
        if (!done.contains(elements)) {
            done.add(elements);
            // determine import scope
            IResolutionScope importedScope = getScope(elements, name);
            if (null != importedScope) {
                name = removeNamespace(name);
                elements = importedScope;
            }
            // TODO use visitor
            result = checkElement(elements.getElement(name), name, type);
            for (int c = 0; null == result && c < elements.getElementCount(); c++) {
                ContainableModelElement element = elements.getElement(c);
                result = checkElement(element, name, type);
                if (null == result && element instanceof IDecisionVariableContainer) {
                    IDecisionVariableContainer cont = (IDecisionVariableContainer) element;
                    DecisionVariableDeclaration var = cont.getElement(name);
                    if (null != var) {
                        result = checkElement(var, name, type);
                    }
                    /*for (int e = 0; null == result && e < cont.getElementCount(); e++) {
                        result = checkElement(cont.getElement(e), name, type);
                    }*/
                }
            }
            if (elements instanceof IAttributeAccess) {
                IAttributeAccess attributes = (IAttributeAccess) elements;
                for (int a = 0; null == result && a < attributes.getAttributesCount(); a++) {
                    result = checkElement(attributes.getAttribute(a), name, type);
                }
            }
            
            // search unqualified imported elements
            if (null == result) {
                for (int i = 0; null == result && i < elements.getImportsCount(); i++) {
                    ProjectImport imp = elements.getImport(i);
                    if (!imp.isConflict()) {
                        IResolutionScope imported = imp.getScope();
                        if (null != imported) {
                            result = findElementByName(imported, name, type, done);
                        }
                    }
                }
            }
        }
        return result;
    }
    
    /**
     * Checks a containable model element.
     * 
     * @param element the element to check
     * @param name the name to check for
     * @param type the specific type of element to be returned
     * @return <code>element</code> if found or <b>null</b>
     */
    private static ContainableModelElement checkElement(ContainableModelElement element, 
        String name, Class<?> type) {
        ContainableModelElement result = null;
        if (null != element && (null == type || type.isAssignableFrom(element.getClass()))) {
            // actually search for the name
            if (element.getUniqueName().equals(name) || element.getQualifiedName().equals(name)) {
                result = element;
            }
        }
        return result;
    }
   
    /**
     * Finds a referenced enum literal in <code>project</code>.
     * 
     * @param elements the elements to search for
     * @param name the name (may be qualified)
     * @return the found literal or <b>null</b> if not found
     * @throws ModelQueryException in case of project access restriction violations
     */
    public static Enum findEnum(IResolutionScope elements, String name) throws ModelQueryException {
        int pos = name.indexOf(IvmlKeyWords.ENUM_ACCESS);
        if (pos > 0) {
            // ignore inner name
            name = name.substring(0, pos);
        }
        return (Enum) findElementByName(elements, name, Enum.class);
    }
    
    /**
     * Finds a referenced enum literal in <code>project</code>.
     * 
     * @param elements the elements to search for
     * @param name the name (may be qualified)
     * @return the found literal as value or <b>null</b> if not found
     * @throws IvmlException in case of type compliance problems when creating the value
     * @throws ModelQueryException in case of project access restriction violations
     */
    public static Value enumLiteralAsValue(IResolutionScope elements, String name) 
        throws IvmlException, ModelQueryException {
        Value result = null;
        int pos = name.indexOf(IvmlKeyWords.ENUM_ACCESS);
        if (pos > 0) {
            String literalName = name.substring(pos + 1);
            String enumName = name.substring(0, pos);
            Enum enumResult = (Enum) findElementByName(elements, enumName, Enum.class);
            if (null != enumResult && null != enumResult.get(literalName)) {
                result = ValueFactory.createValue(enumResult, literalName);
            }
        }
        if (null == result) { // fallback for OCL notation
            pos = name.lastIndexOf(IvmlKeyWords.NAMESPACE_SEPARATOR);
            if (pos > 0) {
                String literalName = name.substring(pos + IvmlKeyWords.NAMESPACE_SEPARATOR.length());
                String enumName = name.substring(0, pos);
                Enum enumResult = (Enum) findElementByName(elements, enumName, Enum.class);
                if (null != enumResult && null != enumResult.get(literalName)) {
                    result = ValueFactory.createValue(enumResult, literalName);
                }
            }
        }
        return result;
    }
    
    /**
     * Searches a given set of elements by a name prefix starting at <code>element</code>.
     * 
     * @param element the element to start searching at
     * @param namePrefix the name prefix
     * @param datatypeVisitor a visitor for resolving type names
     * @param context additional information to include or exclude locally defined model elements
     * @param restrictions type restrictions on the elements to include into the search
     * @return the search results
     */
    public static List<SearchResult> getElementsByNamePrefix(ModelElement element, 
        String namePrefix, DatatypeVisitor datatypeVisitor, SearchContext context, Class<?>... restrictions) {
        PrefixSearchVisitor visitor = PrefixSearchVisitor.getInstance(
            namePrefix, datatypeVisitor, context, restrictions);
        element.accept(visitor);
        List<SearchResult> results = visitor.getResult();
        PrefixSearchVisitor.release(visitor);
        return results;
    }
    
    /**
     * Returns all attributes in <code>scope</code>.
     * 
     * @param scope the scope to be searched
     * @return the attributes in <code>scope</code>, may be empty
     */
    public static List<Attribute> getAllAttributes(IResolutionScope scope) {
        List<Attribute> result = new ArrayList<Attribute>();
        getAllAttributes(scope, result, new HashSet<IResolutionScope>());
        return result;
    }

    /**
     * Collects all attributes in <code>scope</code> and imported scopes.
     * 
     * @param scope the scope to be considered for collecting
     * @param attributes the contained attributes (modified as a side effect)
     * @param done already processed scopes
     */
    private static void getAllAttributes(IResolutionScope scope, List<Attribute> attributes, 
        Set<IResolutionScope> done) {
        if (!done.contains(scope)) {
            done.add(scope);
            int size = scope.getElementCount();
            for (int e = 0; e < size; e++) {
                ContainableModelElement elt = scope.getElement(e);
                if (elt instanceof Attribute) {
                    Attribute attr = (Attribute) elt;
                    if (!attributes.contains(attr)) {
                        attributes.add(attr);
                    }
                }
            }
            for (int i = 0; i < scope.getImportsCount(); i++) {
                ProjectImport imp = scope.getImport(i);
                if (!imp.isConflict()) {
                    // check: are interfaces properly considered!
                    IResolutionScope imported = imp.getScope();
                    if (null != imported) {
                        getAllAttributes(imported, attributes, done);
                    }
                }
            }
        }
    }
    
    /**
     * Defines the interface of a declaration selector.
     * 
     * @author Holger Eichelberger
     */
    public interface IDeclarationSelector {

        /**
         * Returns whether a declaration was selected.
         * 
         * @param decl the declaration to consider
         * @return <code>true</code> if <code>decl</code> was selected, <code>false</code> else
         */
        public boolean select(DecisionVariableDeclaration decl);
        
    }
    
    /**
     * Selects the first declaration with the given type.
     * 
     * @author Holger Eichelberger
     */
    public static class FirstDeclTypeSelector implements IDeclarationSelector {

        private IDatatype type;

        /**
         * Creates a selector for <code>type</code>.
         * 
         * @param type the type to select
         */
        public FirstDeclTypeSelector(IDatatype type) {
            this.type = type;
        }
        
        @Override
        public boolean select(DecisionVariableDeclaration decl) {
            return type.isAssignableFrom(decl.getType());
        }
        
    }
    
    /**
     * Searches a given <code>scope</code> for a variable declaration of <code>type</code> and returns the declaration 
     * determined by <code>selector</code>.
     * 
     * @param scope the scope to search 
     * @param selector the variable selector
     * @return the selected variable declaration or <b>null</b> if none was found
     */
    public static DecisionVariableDeclaration findDeclaration(IResolutionScope scope, IDeclarationSelector selector) {
        DecisionVariableDeclaration result = null;
        for (int e = 0; e < scope.getElementCount(); e++) {
            ContainableModelElement elt = scope.getElement(e);
            if (elt instanceof DecisionVariableDeclaration) {
                DecisionVariableDeclaration decl = (DecisionVariableDeclaration) elt;
                if (selector.select(decl)) {
                    result = decl;
                }
            }
        }
        return result;
    }

}
