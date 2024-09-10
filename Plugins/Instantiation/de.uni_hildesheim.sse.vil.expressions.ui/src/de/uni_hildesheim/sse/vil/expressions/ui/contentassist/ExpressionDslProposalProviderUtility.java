/*
 * Copyright 2009-2024 University of Hildesheim, Software Systems Engineering
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
package de.uni_hildesheim.sse.vil.expressions.ui.contentassist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.viewers.StyledString;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;

import de.uni_hildesheim.sse.vil.expressions.ResourceRegistry;
import net.ssehub.easy.instantiation.core.model.vilTypes.OperationDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;

public abstract class ExpressionDslProposalProviderUtility {
    
    /**
     * List of logical and arithmetic operations that is used to remove such operations from
     * the operations list before returning it to the proposal provider. This is only necessary if
     * an operations list for defining variable values is requested. E.g. "x = ..." does not allow
     * such operations after the "=".
     */
    private static final String[] OPERATIONS_BLACKLIST = 
        {"!", "*", "+", "/", "-", ">", "<", "<>", "and", "or", "xor", "not", "[]", ">=", "==", "<=", "!=", "="};

    /**
     * Get all VIL operations currently registered to EASy-Producer.
     *  
     * @param node the last complete node which provides the basic information for retrieving the operations.
     * @return <code>List&lt;OperationDescriptor%gt;</code> which contains all available operations. Maybe an empty list
     * if no operation can be found, but never <b>null</b>.
     */
    protected List<OperationDescriptor> getAvailableOperations(INode node) {
        List<OperationDescriptor> operations = new ArrayList<OperationDescriptor>();
        TypeRegistry typeRegistry = ResourceRegistry.getTypeRegistry(node);
        if (typeRegistry != null) {            
            Iterable<TypeDescriptor<?>> types = typeRegistry.allTypes();
            if (types != null) {
                Iterator<TypeDescriptor<?>> typeIterator = types.iterator();
                if (typeIterator != null) {
                    while (typeIterator.hasNext()) {
                        Iterable<OperationDescriptor> typeOperations = typeIterator.next().getOperations();
                        if (typeOperations != null) {
                            Iterator<OperationDescriptor> operationIterator = typeOperations.iterator();
                            if (operationIterator != null) {
                                while (operationIterator.hasNext()) {
                                    operations.add(operationIterator.next());
                                }
                            }
                        }
                    }
                }
            }
        }
        return operations;
    }

    /**
     * Returns a list of all valid operations for a specific VIL-type.
     * 
     * @param node the <code>INode</code> object that holds the symbolic name for which the corresponding operations
     * shall be found.
     * @return a list of <code>OperationDescriptor</code> objects that define the valid operations for the given type 
     * (determined via the passed node) or <b>null</b> if no such object can be found.
     */
    protected List<OperationDescriptor> getValidTypeOperationList(INode node) {
        List<OperationDescriptor> validTypeOperations = null;
        if (node != null) {
            TypeRegistry typeRegistry = ResourceRegistry.getTypeRegistry(node);
            if (typeRegistry != null) {                
                /*
                 *  First, determine the type of the element left from the "."
                 *  This may be a variable type of the return type of another operations.
                 */
                String prefixType = getMatchingType(node, getSubCallPrefix(node));
                // Second, determine all valid operations on the type determined in the previous step.
                validTypeOperations = getValidTypeOperations(prefixType, node);
            }
        }
        return validTypeOperations;
    }

    
    /**
     * Returns the prefix of a sub-call (the identifier at the left-hand side of the "." for which the call is defined).
     * 
     * @param node the <code>INode</code> object (last complete node) in the VIL file. Typically, this is the ".", which 
     * is used here as the starting point for determining the prefix (the identifier left to the "."). Should never be 
     * <code>null</code>.
     * @return the prefix as a <code>String</code> or an empty <code>String</code> if no prefix is available.
     */
    protected String getSubCallPrefix(INode node) {
        String prefix = "";
        /*
         * The following two values are used to identify the "." represented
         * by the given node in the VIL file. As multiple "." can be found in a VIL file
         * this is the only way to ensure that we found the right ".".
         */
        int nodeEndLine = node.getEndLine();
        int nodeEndOffset = node.getEndOffset();
        
        INode rootNode = node.getRootNode();
        Iterator<ILeafNode> nodeIter = rootNode.getLeafNodes().iterator();
        boolean prefixNodeFound = false;
        INode lastNode = null;
        while (!prefixNodeFound && nodeIter.hasNext()) {
            INode currentNode = nodeIter.next();
            if (currentNode.getText().equals(".") && lastNode != null) {
                // Ensure that we found the "." we are searching the prefix for
                if (nodeEndLine == currentNode.getEndLine() && nodeEndOffset == currentNode.getEndOffset()) {
                    /*
                     * If it is that ".", we need to distinguish what is actually
                     * the prefix: a variable name or another sub call
                     * (identified by closing bracket ")")
                     */
                    if (lastNode.getText().equals(")")) {
                        // Should be another sub call; get the name
                        int bracketCounter = 1;                        
                        INode previousSibling = lastNode.getPreviousSibling();
                        while (!prefixNodeFound && previousSibling != null) {
                            /*
                             * Not nice, but it works: ensure that we found the last
                             * opening bracket relative to the "."
                             */
                            if (previousSibling.getText().equals(")")) bracketCounter++;
                            if (previousSibling.getText().equals("(")) bracketCounter--;
                            
                            if (previousSibling.getText().equals("(") && bracketCounter == 0) {
                                INode targetSibling = previousSibling.getPreviousSibling();
                                if (targetSibling != null) {
                                    prefixNodeFound = true;
                                    prefix = targetSibling.getText();
                                }
                            }
                            previousSibling = previousSibling.getPreviousSibling();
                        }
                    } else {
                        // Should be a variable; return it's name
                        prefixNodeFound = true;
                        prefix = lastNode.getText();
                    }
                }
            }
            lastNode = currentNode;
        }
        System.err.println("found prefix: " + prefix);
        return prefix;
    }
    
    /**
     * Returns the closest matching type of an VIL element based on the identifier (the name) of the
     * element and the corresponding node of this element in the syntax tree.
     * 
     * @param node the base element that holds the id for which the corresponding type should be found
     * @param id the name (identifier) for which the corresponding type should be found.
     * @return a String, which contains the type name of the VIL element. Could be empty but is never <b>null</b>.
     */
    protected abstract String getMatchingType(INode node, String id);
    
    /**
     * Get all valid VIL operation for a specific VIL (artefact) type.
     * 
     * @param typeName the name of the VIL element for which the valid operations will be determined
     * @param node the node to query
     * @return <code>List&lt;OperationDescriptor&gt;</code> which contains the valid operations for the given type. Maybe
     * <b>null</b> if the type is not supported or no operation for this type is defined.
     */
    protected List<OperationDescriptor> getValidTypeOperations(String typeName, INode node) {
        List<OperationDescriptor> validTypeOperations = null;
        if (typeName != null && !typeName.isEmpty()) {
            List<OperationDescriptor> allOperations = getAvailableOperations(node);
            validTypeOperations = new ArrayList<OperationDescriptor>();
            for (OperationDescriptor opDescr : allOperations) {
                if (opDescr.getDeclaringTypeName().equals(typeName)) {
                    validTypeOperations.add(opDescr);
                }
            }
        }
        return validTypeOperations;
    }
    
    /**
     * Returns all operations currently available in EASy-Producer or a subset of these operations that are valid
     * for a specific VIL-type.
     * 
     * @param node the <code>INode</code> object (last complete node) for which the content assist is called. The semantic 
     * element of this node may be used for determining the VIL-type for which the valid operations shall be returned. 
     * @param returnAll <b>true</b> if all available operations should be return (regardless of the type of the node).
     * <b>False</b> if only the valid operations for the type of the node should be returned. 
     * @return a list of <code>StyledString</code> that includes all operations (or all operations valid for a specific
     * type) variables ready for displaying in the content assist or <b>null</b> if no operations are available.
     */
    public List<StyledString> getValidTypeOperations(INode node, boolean returnAll) {
        List<OperationDescriptor> operationsList = null;
        if (returnAll) {
            operationsList = getAvailableOperations(node);
        } else {
            operationsList = getValidTypeOperationList(node);   
        }
        removeLogicalAndMathOperations(operationsList);
        return opsToDisplayString(operationsList);
    }
    
    /**
     * Removes unneeded operations from the operationList. The unneeded ones are registered
     * in the <code>OPERATIONS_BLACKLIST</code> array.
     * @param operationList
     */
    private void removeLogicalAndMathOperations(List<OperationDescriptor> operationList) {
        if (operationList != null) {
            for (int i = 0; i < OPERATIONS_BLACKLIST.length; i++) {
                for (int j = 0; j < operationList.size(); j++) {
                    if (operationList.get(j).getName().equals(OPERATIONS_BLACKLIST[i])) {
                        operationList.remove(j);
                        // if another operation with the same name is in the list.
                        j--;
                    }
                }
            }
        }
    }

    /**
     * Converts the operation names into a content assist friendly format, which can be directly used to display.
     * @param operationsList the operations
     * @return a <code>List&lt;StyledString&gt;</code> which contains all operations, ready to display in the content assist.
     * Maybe <b>null</b>, if the List&lt;OperationDescriptor&gt; operationsList is empty.
     */
    protected List<StyledString> opsToDisplayString(List<OperationDescriptor> operationsList) {
        List<StyledString> operationStringList = null;
        if (hasElements(operationsList)) {
            operationStringList = new ArrayList<StyledString>();
            for (OperationDescriptor opDescr : operationsList) {
                StyledString operationString = new StyledString();
                operationString.append(opDescr.getName());
                operationString.append("(");
                if (opDescr.getParameterCount() > 1) {
                    for (int i = 1; i < opDescr.getParameterCount(); i++) {
                        operationString.append(opDescr.getParameterType(i).getName());
                        operationString.append(" ");
                        operationString.append(opDescr.getParameterType(i).getName().toLowerCase());
                        if (!((i + 1) >= opDescr.getParameterCount())) {
                            operationString.append(", ");
                        }
                    }
                }
                operationString.append(")");
                operationString.append(" : " + opDescr.getReturnType().getName(), StyledString.QUALIFIER_STYLER);
                operationStringList.add(operationString);
            }
        }
        return operationStringList;
    }
    
    /**
     * Checks if a <code>List&lt;?&gt;</code> has Elements or not.
     * 
     * @param list
     * @return <b>true</b> if the List has at least one element, <b>false</b> if it's empty or null.
     */
    protected boolean hasElements(List<?> list) {
        return list != null && !list.isEmpty();
    }
    
    /**
     * Returns all variables defined in/for the parents of the semantic element of the passed node (recursion from inner 
     * to outer VIL-elements). However, this will only return variables of <code>Map</code> elements or surrounding 
     * <code>Rule</code> elements. Variables or other elements from, e.g., a script must be determined using <code>getScriptVariables</code>.
     * 
     * @param node the <code>INode</code> object (last complete node) for which the content assist is called. The semantic 
     * element of this node is used as the starting point for determining the parent-variables recursively.
     * @param completeDefsOnly in order to prevent proposals of incomplete variables, i.e. if the user calls the content assist 
     * for completing a variable definition, the incomplete variable(s) must not be proposed (completeDefsOnly = <b>true</b>). 
     * To return all variables, use <b>false</b>
     * @return a list of <code>StyledString</code> that includes all variables of all surrounding VIL-elements (<code>Map</code> 
     * and <code>Rule</code>) ready for displaying in the content assist or <b>null</b> if no variables are available.
     */
    public List<StyledString> getParentVariables(INode node, boolean completeDefsOnly) {
        List<StyledString> parentVarList = null;
        if (node != null) {
            parentVarList = new ArrayList<StyledString>();
            // As long as there was no rule found, search recursively for more nested variables/parameters.
            List<StyledString> parentList = getParentVariables(node.getParent(), completeDefsOnly);
            if (parentList != null) {
                parentVarList.addAll(parentList);
            }
        }
        return parentVarList;
    }
    
    /**
     * Returns all parameters defined in/for the parents of the semantic element of the passed node (recursion from inner 
     * to outer VIL-elements). However, this will only return parameters of <code>Map</code> elements or surrounding 
     * <code>Rule</code> elements. Parameters or other elements from, e.g., a script must be determined using <code>getScriptParameters</code>. 
     *  
     * @param node the <code>INode</code> object (last complete node) for which the content assist is called. The semantic 
     * element of this node is used as the starting point for determining the parent-parameters recursively.
     * @return a list of <code>StyledString</code> that includes all parameters of all surrounding VIL-elements (<code>Map</code> 
     * and <code>Rule</code>) ready for displaying in the content assist or <b>null</b> if no parameters are available.
     */
    public List<StyledString> getParentParameters(INode node) {
        List<StyledString> parentParamList = null;
        if (node != null) {
            parentParamList = new ArrayList<StyledString>();
            // As long as there was no rule found, search recursively for more nested variables/parameters.
            List<StyledString> parentParams = getParentParameters(node.getParent());
            if (null != parentParams) { 
                parentParamList.addAll(parentParams);
            }
        }
        return parentParamList;
    }

    /**
     * Returns all VIL-types currently available in EASy-Producer.
     * 
     * @param node the <code>INode</code> object (last complete node) for which the content assist is called.
     * @return a list of the names (<code>String</code>) of all types currently registered to EASy-Producer.
     */
    public List<String> getAllTypes(INode node) {
        List<String> allTypes = null;
        TypeRegistry typeRegistry = ResourceRegistry.getTypeRegistry(node);
        if (typeRegistry != null) {
            Iterable<TypeDescriptor<?>> types = typeRegistry.allTypes();
            if (types != null) {
                Iterator<TypeDescriptor<?>> typeIterator = types.iterator();
                if (typeIterator != null) {
                    allTypes = new ArrayList<String>();
                    while (typeIterator.hasNext()) {
                        String typeName = typeIterator.next().getName();
                        if (!typeName.isEmpty()) {
                            if (typeName.equals("Set") || typeName.equals("Map")) {
                                typeName = typeName + "(<ElementType> [ ,<ElementType>]*)";
                            }
                            if (typeName.equals("Sequence")) {
                                typeName = typeName + "(<ElementType>)";
                            }
                            allTypes.add(typeName);
                        }
                    }
                }
            }            
        }
        return allTypes;
    }

}
