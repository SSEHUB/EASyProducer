package de.uni_hildesheim.sse.model.varModel;

import java.util.ArrayList;
import java.util.List;

import de.uni_hildesheim.sse.model.varModel.datatypes.BooleanType;
import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
import de.uni_hildesheim.sse.model.varModel.datatypes.ConstraintType;
import de.uni_hildesheim.sse.model.varModel.datatypes.DatatypeVisitor;
import de.uni_hildesheim.sse.model.varModel.datatypes.Enum;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.IResolutionScope;
import de.uni_hildesheim.sse.model.varModel.datatypes.IntegerType;
import de.uni_hildesheim.sse.model.varModel.datatypes.QualifiedNameMode;
import de.uni_hildesheim.sse.model.varModel.datatypes.RealType;
import de.uni_hildesheim.sse.model.varModel.datatypes.StringType;
import de.uni_hildesheim.sse.model.varModel.search.PrefixSearchVisitor;
import de.uni_hildesheim.sse.model.varModel.search.SearchContext;
import de.uni_hildesheim.sse.model.varModel.search.SearchResult;
import de.uni_hildesheim.sse.model.varModel.values.Value;
import de.uni_hildesheim.sse.model.varModel.values.ValueFactory;

/**
 * Provides an interface to query models.
 * 
 * @author Holger Eichelberger
 */
public class ModelQuery {

    // TODO further ambiguity checks

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
            super("s", "q", "r");
        }
    }

    /**
     * Returns the textual representation of the given element.
     * 
     * @param element the element to be represented
     * @param mode the name mode
     * @return the textual representation
     */
    private static final synchronized String getType(ContainableModelElement element, QualifiedNameMode mode) {
        MqDatatypeVisitor vis;
        if (!VIS_INSTANCES.isEmpty()) {
            vis = VIS_INSTANCES.remove(VIS_INSTANCES.size() - 1);
        } else {
            vis = new MqDatatypeVisitor();
        }
        vis.setQualifiedNameMode(mode);
        element.accept(vis);
        String result = vis.getResult();
        vis.clear();
        VIS_INSTANCES.add(vis);
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
        return findType(elements, name, false, type);
    }

    /**
     * Finds the specified data type definition in the given <code>project</code>.
     * 
     * @param elements the elements to search for
     * @param name the name of the type to search for (may be qualified)
     * @param considerVariableDeclarations take the types of variable declarations into account
     * @param type the specific type of datatype to be returned, {@link IDatatype} 
     *   is used if <b>null</b>
     * @return the corresponding type or <b>null</b>
     * @throws ModelQueryException in case of violated project access restrictions
     */
    private static IDatatype findType(IResolutionScope elements, String name, 
        boolean considerVariableDeclarations, Class<? extends IDatatype> type) throws ModelQueryException {

        // determine import scope
        IResolutionScope initialScope = elements;
        IResolutionScope importedScope = getScope(elements, name);
        if (null != importedScope) {
            name = removeNamespace(name);
            elements = importedScope;
            considerVariableDeclarations = (elements != initialScope && elements.isInterface());
        }
        
        if (null == type) {
            type = IDatatype.class;
        }
        IDatatype result = null;
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
                        result = findType(imported, name, imported.isInterface(), type);
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
        // determine import scope
        IResolutionScope importedScope = getScope(elements, typeName);
        if (null != importedScope) {
            typeName = removeNamespace(typeName);
            elements = importedScope;
        }
        
        if (null == type) {
            type = IDatatype.class;
        }
        IDatatype result = null;
        for (int c = 0; c < elements.getElementCount(); c++) {
            ContainableModelElement element = elements.getElement(c);
            if (type.isAssignableFrom(element.getClass())) {
                String elName = getType(element, QualifiedNameMode.UNQUALIFIED);
                if (elName.equals(typeName)) {
                    result = (IDatatype) element;
                    break;
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
                        result = findElementByTypeName(imported, typeName, type);
                    }
                }
            }
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
    
    /*
    // look into all namespace parts from left to right and 
    // successively determine the scope. namespaceStart contains
    // the part we are looking into, namespaceTail the remainder
    // to be resolved
    String namespaceStart;
    String namespaceTail = namespace;
    IResolutionScope curScope = scope;
    IResolutionScope imported = null;
    do {
        pos = namespaceTail.indexOf(IvmlKeyWords.NAMESPACE_SEPARATOR);
        if (pos > 0) {
            // this looks like namespaceStart::tail - split them
            namespaceStart = namespaceTail.substring(0, pos);
            namespaceTail = namespaceTail.substring(pos + IvmlKeyWords.NAMESPACE_SEPARATOR.length());
        } else {
            // this is just a name - end of loop
            namespaceStart = namespace;
            namespaceTail = null;
        }
        // search within scope, check name of scope, search imports
        IResolutionScope tmp = (IResolutionScope) findElementByName(
            curScope, namespaceStart, IResolutionScope.class);
        if (null == tmp) {
            if (namespaceStart.equals(curScope.getName())) {
                tmp = curScope;
            } else {
                for (int i = 0; null == tmp && i < curScope.getImportsCount(); i++) {
                    ProjectImport imp = curScope.getImport(i);
                    if (!imp.isConflict() && namespaceStart.equals(imp.getProjectName())) {
                        IResolutionScope impScope = imp.getScope();
                        if (null != impScope) {
                            
                        }
                        if (null == imp.getInterfaceName() || imp.get)
                        imported = imp.getResolved(); // this may be null!
                        tmp = imported;
                    }
                }
            }
        } 
        curScope = tmp;
    } while (null != curScope && (null != namespaceTail && namespaceTail.length() > 0));
    if (null != curScope) {
        if (null != imported) {
            boolean isCurScopeInterface = (curScope instanceof ProjectInterface);
            if (imported.hasInterfaces() && !isCurScopeInterface) {
                // the inverse case cannot happen (or hasInterfaces is broken)
                curScope = null;
            }
        }
        result = curScope;
    }*/

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
        do {
            ispace.shiftRight();
            // search within scope, check name of scope, search imports
            IResolutionScope tmp = (IResolutionScope) findElementByName(
                curScope, ispace.namespaceStart, IResolutionScope.class);
            if (null == tmp) {
                if (ispace.namespaceStart.equals(curScope.getName())) {
                    tmp = curScope;
                } else {
                    for (int i = 0; null == tmp && i < curScope.getImportsCount(); i++) {
                        ProjectImport imp = curScope.getImport(i);
                        if (checkScopeForImport(ispace.namespaceStart, imp, namespace)) {
                            // set resolved but not scope as this will happen in the next iteration
                            imported = imp.getResolved();
                            tmp = checkInterfaceImport(imp.getScope(), ispace, namespace, imported);
                        }
                    }
                }
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
     * Performs final checks on accessing an imported interface.
     * @param scope the scope containing the interface being imported (may be <b>null</b>)
     * @param ispace the current state in resolving the namespace
     * @param namespace the initial namespace (for error messages=
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
        AbstractVariable result = null;
        if (null == type) {
            // set default value
            type = AbstractVariable.class;
        }
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
        result = (AbstractVariable) findElementByName(elements, name, type);
        result = findCompoundOrAttributeAccess(elements, name, innerName, result);
        
        // search unqualified imported elements
        if (null == result) {
            for (int i = 0; null == result && i < elements.getImportsCount(); i++) {
                ProjectImport imp = elements.getImport(i);
                if (!imp.isConflict()) {
                    IResolutionScope imported = imp.getScope();
                    if (null != imported) {
                        result = findVariable(imported, name, type);
                    }
                }
            }
        }
        
        if (null != result && !type.isAssignableFrom(result.getClass())) {
            result = null;
        }
        if (null != directResult && !directResult.equals(result)) {
            throw new ModelQueryException("name is ambiguous '" + originalName + "'", 
                 ModelQueryException.AMBIGUITY);
        }
        return result;
    }

    /**
     * Finds a variable by compound/attribute access as part of {@link #findVariable(IResolutionScope, String, Class)}.
     * @param elements the elements to search for
     * @param name the name of the variable to search for 
     * @param innerName the name of the compound element/attribute
     * @param result the result determined so far
     * @return the subsequent compound or attribute access
     * @throws ModelQueryException in case of ambiguities
     */
    private static AbstractVariable findCompoundOrAttributeAccess(IResolutionScope elements, String name, 
        String innerName, AbstractVariable result) throws ModelQueryException {
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
            AbstractVariable var = result;
            Compound comp = null;
            result = null;
            if (null != var && var.getType().isAssignableFrom(Compound.TYPE)) {
                comp = (Compound) var.getType();
                result = findVariable(comp, innerNamePart);
            }
            if (null == result) {
                comp = (Compound) findElementByTypeName(elements, name, Compound.class);
                if (null != comp) {
                    result = findVariable(comp, innerNamePart);
                }
            }
            AbstractVariable compoundResult = result;
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
        ContainableModelElement result = null;
        // determine import scope
        IResolutionScope importedScope = getScope(elements, name);
        if (null != importedScope) {
            name = removeNamespace(name);
            elements = importedScope;
        }
        // TODO use visitor
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
                        result = findElementByName(imported, name, type);
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
        if (null == type || type.isAssignableFrom(element.getClass())) {
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
        String innerName = null;
        int pos = name.indexOf(IvmlKeyWords.ENUM_ACCESS);
        if (pos > 0) {
            innerName = name.substring(pos + 1);
            name = name.substring(0, pos);
        }
        Enum enumResult = (Enum) findElementByName(elements, name, Enum.class);
        if (null != enumResult && null != enumResult.get(innerName)) {
            result = ValueFactory.createValue(enumResult, innerName);
            // currently - only one innerName step and no attribute???
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
        getAllAttributes(scope, result);
        return result;
    }

    /**
     * Collects all attributes in <code>scope</code> and imported scopes.
     * 
     * @param scope the scope to be considered for collecting
     * @param attributes the contained attributes (modified as a side effect)
     */
    private static void getAllAttributes(IResolutionScope scope, List<Attribute> attributes) {
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
                    getAllAttributes(imported, attributes);
                }
            }
        }
    }

}
