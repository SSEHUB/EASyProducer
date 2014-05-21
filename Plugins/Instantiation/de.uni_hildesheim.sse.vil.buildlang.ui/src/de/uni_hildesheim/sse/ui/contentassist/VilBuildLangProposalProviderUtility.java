package de.uni_hildesheim.sse.ui.contentassist;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;

import de.uni_hildesheim.sse.BuildLangModelUtility;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Script;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;
import de.uni_hildesheim.sse.utils.modelManagement.ModelInfo;
import de.uni_hildesheim.sse.vil.expressions.ResourceRegistry;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.Constant;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionOrQualifiedExecution;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.LogicalExpression;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.Parameter;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.SubCall;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.UnqualifiedExecution;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.VariableDeclaration;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionOrQualifiedExecutionImpl;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.UnqualifiedExecutionImpl;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.VariableDeclarationImpl;
import de.uni_hildesheim.sse.vilBuildLanguage.ImplementationUnit;
import de.uni_hildesheim.sse.vilBuildLanguage.LanguageUnit;
import de.uni_hildesheim.sse.vilBuildLanguage.RuleElement;
import de.uni_hildesheim.sse.vilBuildLanguage.RuleElementBlock;
import de.uni_hildesheim.sse.vilBuildLanguage.ScriptContents;
import de.uni_hildesheim.sse.vilBuildLanguage.impl.ImplementationUnitImpl;
import de.uni_hildesheim.sse.vilBuildLanguage.impl.MapImpl;
import de.uni_hildesheim.sse.vilBuildLanguage.impl.RuleDeclarationImpl;

/**
 * A utility class for determining different elements in the VIL build model based on the
 * more generic information provided by the Xtext UI functionalities (typically EObject, etc.)
 * 
 * Please note if multiple VIL scripts are defined in the same file, the proposals of the content
 * assist may be wrong!
 * 
 * @author kroeher
 * @auther dernek
 */
public class VilBuildLangProposalProviderUtility {

    public static final VilBuildLangProposalProviderUtility INSTANCE = new VilBuildLangProposalProviderUtility();
    public enum VIL_ELEMENTS {ADVICE, IMPORT, SCRIPT, PARENT_SCRIPT, SCRIPT_VARIABLES, RULE}
    private static final String[] OPERATIONS_BLACKLIST = 
        {"!", "*", "+", "/", "-", ">", "<", "and", "or", "xor", "not", "[]", ">=", "==", "<="};
    
    /**
     * Prevents external creation.
     */
    private VilBuildLangProposalProviderUtility() {
    }
    
    public List<StyledString> getScriptParameters(INode node) {
        List<StyledString> result = null;
        if (node != null) {
            LanguageUnit activeScript = getActiveVilScript(node);
            if (activeScript != null && activeScript.getParam() != null && hasElements(activeScript.getParam().getParam())) {
                EList<Parameter> paramList = activeScript.getParam().getParam();
                result = new ArrayList<StyledString>();
                for (Parameter param : paramList) {
                    String varName = param.getName();
                    String type = param.getType().getName();
                    StyledString displayString = new StyledString();
                    displayString.append(varName);
                    displayString.append(" : " + type, StyledString.QUALIFIER_STYLER);
                    result.add(displayString);
                }
            }
        }
        return result;
    }
    
    /**
     * 
     * @param node
     * @return
     */
    public List<StyledString> getRuleParameters(INode node) {
        List<StyledString> result = null;
        if (node != null) {
            List<Parameter> paramList = getRuleParams(node);
            if (hasElements(paramList)) {
                result = new ArrayList<StyledString>();
                for (Parameter parameter : paramList) {
                    String varName = parameter.getName();
                    String type = parameter.getType().getName();
                    StyledString displayString = new StyledString();
                    displayString.append(varName);
                    displayString.append(" : " + type, StyledString.QUALIFIER_STYLER);
                    result.add(displayString);
                }
            }
        }
        return result;
    }
    
    /**
     * 
     * @param node
     * @param deleteSelf if true, delete the rule for which this is called from proposallist
     * @return
     */
    public List<StyledString> getAllRules(INode node, boolean deleteSelf) {
        List<StyledString> result = null;
        if (node != null) {
           List<RuleDeclarationImpl> allRules = getAllRules(getActiveVilScript(node));
           if (hasElements(allRules)) {
               if (deleteSelf) {
                   allRules.remove(getParentRule(node));
               }
               result = new ArrayList<StyledString>();
               for (RuleDeclarationImpl ruleDecl : allRules) {
                   if (ruleDecl != null) {
                       String ruleName = ruleDecl.getName() + "(";
                       if (ruleDecl.getParamList() != null && hasElements(ruleDecl.getParamList().getParam())) {
                           EList<Parameter> paramList = ruleDecl.getParamList().getParam();
                           String parameterString = "";
                           for (Parameter param : paramList) {
                               parameterString = parameterString + param.getType().getName();
                               parameterString = parameterString + " " + param.getName() + ", ";
                           }
                           parameterString = parameterString.substring(0, parameterString.length() -2);
                           ruleName = ruleName + parameterString + ")";
                       } else {
                           ruleName = ruleName + ")";
                       }
                       StyledString displayString = new StyledString();
                       displayString.append(ruleName);
                       displayString.append(" : Rule", StyledString.QUALIFIER_STYLER);
                       result.add(displayString);
                   }
               }
           }
        }
        return result;
    }
    
    /**
     * 
     * @param node
     * @param completeDefsOnly <b>True</b> if list should only contain variables that are completely
     * defined (have an expression assigned to). <b>False</b> if all variables should by included, e.g.
     * also only declared variables. 
     * @return
     */
    public List<StyledString> getScriptVariables(INode node, boolean completeDefsOnly) {
        List<StyledString> result = new ArrayList<StyledString>();
        // First, add the two implicit VIL variables
        StyledString otherProjects = new StyledString();
        otherProjects.append("OTHERPROJECTS");
        otherProjects.append(" : Set", StyledString.QUALIFIER_STYLER);
        result.add(otherProjects);
        StyledString scriptDir = new StyledString();
        scriptDir.append("SCRIPTDIR");
        scriptDir.append(" : String", StyledString.QUALIFIER_STYLER);
        result.add(scriptDir);
        // Second, add all declared script variables
        if (node != null) {
            LanguageUnit activeScript = getActiveVilScript(node);
            if (activeScript != null) {
                List<VariableDeclarationImpl> varDecls = getAllVariables(activeScript);
                if (hasElements(varDecls)) {
                    for (VariableDeclarationImpl varDecl : varDecls) {
                        if (completeDefsOnly) {
                            if (varDecl.getExpression() != null) {
                                String varName = varDecl.getName();
                                String type = varDecl.getType().getName();
                                StyledString displayString = new StyledString();
                                displayString.append(varName);
                                displayString.append(" : " + type, StyledString.QUALIFIER_STYLER);
                                result.add(displayString);                                
                            }
                        } else {
                            String varName = varDecl.getName();
                            String type = varDecl.getType().getName();
                            StyledString displayString = new StyledString();
                            displayString.append(varName);
                            displayString.append(" : " + type, StyledString.QUALIFIER_STYLER);
                            result.add(displayString);
                        }
                    }
                }
            }
        }
        return result;
    }
    
    /**
     * 
     * @param node
     * @return
     */
    public List<StyledString> getRuleVariables(INode node, boolean completeDefsOnly) {
        List<StyledString> result = new ArrayList<StyledString>();
        // First, add the two implicit VIL rule variables
        StyledString lhs = new StyledString();
        lhs.append("LHS");
        // TODO: the type of LHS is the return type of the first precondition
        lhs.append(" : <Type?>", StyledString.QUALIFIER_STYLER);
        result.add(lhs);
        StyledString rhs = new StyledString();
        rhs.append("RHS");
        rhs.append(" : <Type?>", StyledString.QUALIFIER_STYLER);
        result.add(rhs);        
        // Second, add all declared rule variables 
        if (node != null) {
            List<VariableDeclaration> varDecls = getRuleVars(node);
            if (hasElements(varDecls)) {                
                for (VariableDeclaration varDecl : varDecls) {
                    if (completeDefsOnly) {
                        if (varDecl.getExpression() != null) {
                            String varName = varDecl.getName();
                            String type = varDecl.getType().getName();
                            StyledString displayString = new StyledString();
                            displayString.append(varName);
                            displayString.append(" : " + type, StyledString.QUALIFIER_STYLER);
                            result.add(displayString);                                
                        }
                    } else {
                        String varName = varDecl.getName();
                        String type = varDecl.getType().getName();
                        StyledString displayString = new StyledString();
                        displayString.append(varName);
                        displayString.append(" : " + type, StyledString.QUALIFIER_STYLER);
                        result.add(displayString);
                    }
                }
            }
        }
        return result;
    }
    
    /**
     * Get the name of the current VIL file.
     * 
     * @param rootObject the root element of the current context. Typically this is the implementation unit.
     * @return the name of the current VIL file or an empty string if the file could not be resolved
     */
    public String getVilFileName(EObject rootObject) {
        String vilFileName = "";
        File vilFile = getVilFile(rootObject);
        if (vilFile.exists()) {
            vilFileName = vilFile.getName().substring(0, vilFile.getName().indexOf("."));
        }
        return vilFileName;
    }
    
    /**
     * Get the name of the first IVML file which can be found in the parent-directory of the current VIL file.
     *  
     * @param rootObject the root element of the current context. Typically this is the implementation unit.
     * @return the name of the first IVML file which can be found in the parent-directory of the current VIL
     * file or an empty string if no IVML file is located in the parent-directory
     */
    public String getIvmlModelName(EObject rootObject) {
        String ivmlModelName = "";
        File vilFile = getVilFile(rootObject);
        if (vilFile.exists() && vilFile.getParentFile().isDirectory()) {
            for (String fileNames : vilFile.getParentFile().list()) {
                if (fileNames.contains(".ivml")) {
                    ivmlModelName = fileNames.substring(0, fileNames.indexOf("."));
                }
            }                        
        }
        return ivmlModelName;
    }
    
    /**
     * Get all available types for variable declaration currently registered to EASy-Producer.
     * 
     * @param registry the registry to query
     * @return a list of the names of all types currently registered to EASy-Producer.
     */
    public List<String> getAllTypes(TypeRegistry registry) {
        List<String> allTypes = null;
        Iterable<TypeDescriptor<? extends IVilType>> types = registry.allTypes();
        if (types != null) {
            Iterator<TypeDescriptor<? extends IVilType>> typeIterator = types.iterator();
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
        return allTypes;
    }
    
    /**
     * Check whether the current VIL build script has a version.
     * 
     * @param currentNode the last complete node of the parse tree.
     * @return true if the current VIL build script has a version. False otherwise.
     */
    public boolean hasVersion(INode currentNode) {
        boolean hasVersion = false;
        if (currentNode != null) {
            LanguageUnit activeScript = getActiveVilScript(currentNode);
            if (activeScript != null && activeScript.getVersion() != null) {
                hasVersion = true;
            }
        }
        return hasVersion;
    }
    
    /**
     * Check whether a script is defined as part of the current VIL file.
     * 
     * @param currentNode the last complete node of the parse tree.
     * @return true if the current VIL file includes at a script. False otherwise.
     */
    public boolean hasScript(INode currentNode) {
        boolean hasScript = false;
        if (currentNode != null) {
            LanguageUnit activeScript = getActiveVilScript(currentNode);
            if (activeScript != null) {
                hasScript = true;
            }
        }
        return hasScript;
    }
    
    /**
     * Get the list of all valid operations for a specific VIL type based on the corresponding
     * node of this element in the syntax tree.
     * 
     * @param node the base element that holds the id for which the corresponding operations should be found
     * @param returnAll true if all available operations should be return (regardless of the type of the node).
     * False if only the valid operations for the type of the node should be returned. 
     * @return a list of strings (Java signature format) that define the valid operations for the given type.
     * Maybe null if no operation can be found.
     */
    public List<StyledString> getValidTypeOperations(INode node, boolean returnAll) {
        List<OperationDescriptor> operationsList = null;
        if (returnAll) {
            operationsList = getAvailableOperations(ResourceRegistry.getTypeRegistry(node));
        } else {
            operationsList = getValidTypeOperationList(node);   
        }
        removeLogicalAndMathOperations(operationsList);
        return opsToDisplayString(operationsList);
    }
    
    public List<StyledString> getOperationsMatchingReturnType(INode node) {
        String desiredType = getType(node);
        List<OperationDescriptor> fullOperationsList = getAvailableOperations(ResourceRegistry.getTypeRegistry(node));
        List<OperationDescriptor> operationsMatchingReturnType = null;
        if (hasElements(fullOperationsList) && desiredType != null && !desiredType.isEmpty()) {
            operationsMatchingReturnType = new ArrayList<OperationDescriptor>();
            for (OperationDescriptor opDescr : fullOperationsList) {
                if (opDescr.getReturnType().getName().equals(desiredType)) {
                    operationsMatchingReturnType.add(opDescr);
                }
            }
        }
        return opsToDisplayString(operationsMatchingReturnType);
    }
    
    public List<StyledString> getAllInstantiators(TypeRegistry registry) {
        return opsToDisplayString(getAvailableInstantiators(registry));
    }
    
    public List<StyledString> getParentParameters(INode node) {
        List<StyledString> parentParamList = null;
        System.out.println("NODE: " + node);
        if (node != null) {
            parentParamList = new ArrayList<StyledString>();
            EObject semanticElement = node.getSemanticElement();
            if (semanticElement instanceof MapImpl) {
                // First, search for map-expression and all defined parameter and variables for/in that expression
                MapImpl parentMap = (MapImpl) semanticElement;
                // TODO: determine the actual type of each variable by analyzing the expression
                if (parentMap != null && hasElements(parentMap.getVar()) /* && parentMap.getExpr() != null*/) {
                    EList<String> parentMapVars = parentMap.getVar();
                    for (int i = 0; i < parentMapVars.size(); i++) {
                        StyledString mapParam = new StyledString(parentMapVars.get(i));
                        mapParam.append(" : <Type?>", StyledString.QUALIFIER_STYLER);
                        parentParamList.add(mapParam);
                    }                        
                }
            } 
            if (semanticElement instanceof RuleDeclarationImpl) {
                // Second, search for parent rule and all defined parameter and variables for/in that rule
                parentParamList.addAll(getRuleParameters(node));
                
            } else {
                // As long as there was no rule found, search recursively for more nested variables/parameters.
                parentParamList.addAll(getParentParameters(node.getParent()));
            }
        }
        return parentParamList;
    }
    
    public List<StyledString> getParentVariables(INode node, boolean completeDefsOnly) {
        List<StyledString> parentVarList = null;
        if (node != null) {
            parentVarList = new ArrayList<StyledString>();
            EObject semanticElement = node.getSemanticElement();
            if (semanticElement instanceof MapImpl) {
                // First, search for map-expression and all defined variables in that expression
                MapImpl parentMap = (MapImpl) semanticElement;
                if (parentMap != null && hasElements(parentMap.getBlock())) {
                    parentVarList.addAll(varsToDisplayString(getRuleElementBlockVars(parentMap.getBlock())));
                }
            } 
            if (semanticElement instanceof RuleDeclarationImpl) {
                // Second, search for parent rule and all defined variables in that rule
                parentVarList.addAll(getRuleVariables(node, completeDefsOnly));
                
            } else {
                // As long as there was no rule found, search recursively for more nested variables/parameters.
                parentVarList.addAll(getParentVariables(node.getParent(), completeDefsOnly));
            }
        }
        return parentVarList;
    }
    
    /**
     * 
     * @param toSearch
     * @param node
     * @return
     */
    public List<String> searchForRuleParameterTypes(String toSearch, INode node) {
        List<String> parameterTypes = null;
        if (node != null) {
            List<RuleDeclarationImpl> allRules = getAllRules(getActiveVilScript(node));
            for (RuleDeclarationImpl rule : allRules) {
                if (rule.getName().equals(toSearch)) {
                    parameterTypes = new ArrayList<String>();
                    for (Parameter param : rule.getParamList().getParam()) {
                        parameterTypes.add(param.getType().getName()); 
                    }
                }
            }
        }
        return parameterTypes;
    }
    
    private LanguageUnit getActiveVilScript(INode parseTreeNode) {
        LanguageUnit activeScript = null;
        ICompositeNode rootNode = parseTreeNode.getRootNode();        
        if (rootNode != null && rootNode.getSemanticElement() != null) {
            EObject semanticRootElement = rootNode.getSemanticElement();
            if (semanticRootElement instanceof ImplementationUnitImpl) {
                ImplementationUnitImpl vilImplementationUnit = (ImplementationUnitImpl) semanticRootElement;
                EList<LanguageUnit> scriptList = vilImplementationUnit.getScripts();
                if (hasElements(scriptList)) {
                    /*
                     *  Note that here only a single script is available, as we are beginning with the root
                     *  node of the current parse tree. This means, we only know the current script at this point.
                     */
                    activeScript = scriptList.get(0);
                }
            }
        }
        return activeScript;
    }
    
    private List<RuleDeclarationImpl> getAllRules(LanguageUnit activeScript) {
        List<RuleDeclarationImpl> ruleList = null;
        ScriptContents scriptContents = activeScript.getContents();
        if (scriptContents != null && hasElements(scriptContents.getElements())) {
            List<EObject> scriptContentElements = scriptContents.getElements();
            ruleList = new ArrayList<RuleDeclarationImpl>();
            for (EObject element : scriptContentElements) {
                if (element != null && element instanceof RuleDeclarationImpl) {
                    ruleList.add((RuleDeclarationImpl) element);
                }
            }
        }
        return ruleList;
    }
    
    private List<VariableDeclarationImpl> getAllVariables(LanguageUnit activeScript) {
        List<VariableDeclarationImpl> variableList = null;
        ScriptContents scriptContents = activeScript.getContents();
        if (scriptContents != null && hasElements(scriptContents.getElements())) {
            List<EObject> scriptContentElements = scriptContents.getElements();
            variableList = new ArrayList<VariableDeclarationImpl>();
            for (EObject element : scriptContentElements) {
                if (element != null && element instanceof VariableDeclarationImpl) {
                    variableList.add((VariableDeclarationImpl) element);
                }
            }
        }
        return variableList;
    }
    
    /**
     * Get the list of all valid operations for a specific VIL type based on the corresponding
     * node of this element in the syntax tree.
     * 
     * @param node the base element that holds the id for which the corresponding operations should be found
     * @return a list of operation descriptors that define the valid operations for the given type. Maybe
     * null if no operation can be found.
     */
    private List<OperationDescriptor> getValidTypeOperationList(INode node) {
        List<OperationDescriptor> validTypeOperations = null;
        if (node != null) {
            /*
             *  First, determine the type of the element left from the "."
             *  This may be a variable type of the return type of another operations.
             */
            String prefixType = getMatchingType(node, getSubCallPrefix(node));
            // Second, determine all valid operations on the type determined in the previous step.
            validTypeOperations = getValidTypeOperations(prefixType, ResourceRegistry.getTypeRegistry(node));
        }
        return validTypeOperations;
    }
    
    /**
     * Get the prefix (the identifier at the left-hand side of the "." for which the call is defined) based
     * on the "." in the VIL file.
     * 
     * @param node the last complete node in the VIL file. Typically, this is the ".", which is used here as
     * the starting point for determining the prefix (the identifier left to the ".")
     * @return the prefix as a string or an empty string if no prefix is available
     */
    private String getSubCallPrefix(INode node) {
        String prefix = "";
        INode parent = node.getParent();
        if (parent != null) {
            EObject parentSemanticElement = parent.getSemanticElement();
            if (parentSemanticElement != null) {
                // Check whether left from "." is another SubCall or a simple prefix (identifier)
                if (parentSemanticElement instanceof ExpressionOrQualifiedExecutionImpl) {
                    ExpressionOrQualifiedExecution qExecution = (ExpressionOrQualifiedExecution) parentSemanticElement;
                    // As the left-handed part of "." might be a SubCall again, try to find a SubCall first
                    prefix = getSubCallName(qExecution, getSiblingCount(node));
                    // If no SubCall or instantiator call is found, there should be a simple prefix (identifier)
                    if (prefix == null || prefix.length() <= 0) {
                        Constant constantElement = qExecution.getVal();
                        prefix = getQualifiedName(constantElement);                     
                    }                    
                // Check whether left from "." is an instantiator call
                } else if (parentSemanticElement instanceof UnqualifiedExecutionImpl) {
                    UnqualifiedExecution uExecution = (UnqualifiedExecution) parentSemanticElement;
                    prefix = uExecution.getCall().getName().getQname().get(0);
                } else {
                    prefix = getSubCallPrefix(parent);
                }
            }            
        }
        return prefix;
    }
    
    /**
     * Get the qualified name (identifier) of a constant (typically a variable).
     * 
     * @param constantElement the element from which the qualified name will be determined
     * @return the qualified name of the given element as a string or an empty string if no prefix is available
     */
    private String getQualifiedName(Constant constantElement) {
        String qName = "";
        if (hasQName(constantElement)) {
            List<String> constantQNameList = constantElement.getQValue().getPrefix().getQname();
            qName = constantQNameList.get(constantQNameList.size() - 1);
        }
        return qName;
    }
    
    /**
     * Get the sub call (name of the operation) on the left-handed side of a ".".
     * 
     * @param qExecution the ExpressionOrQualifiedExecution as a basis for determining the name of the
     * sub call operation.
     * @param nodeSiblingCount the number of sub calls after the "." for exact determination of the right
     * sub call left to the current position (".")  
     * @return the sub call name of the given qExecution as a string or an empty string if no prefix is available
     */
    private String getSubCallName(ExpressionOrQualifiedExecution qExecution, int nodeSiblingCount) {
        String subCallName = "";
        if (qExecution != null && hasElements(qExecution.eContents())) {
            List<SubCall> subCallList = new ArrayList<SubCall>();
            for (EObject contentElement : qExecution.eContents()) {
                if (contentElement instanceof SubCall) {
                    subCallList.add((SubCall) contentElement);
                }
            }
            /*
             *  In case that there are further SubCalls at the right-handed side of the ".", determine
             *  the exact SubCall at the left-handed side of the "."
             */
            if (hasElements(subCallList)) {
                if (subCallList.size() > nodeSiblingCount) {
                    SubCall previousSubCall = subCallList.get(subCallList.size() - nodeSiblingCount - 1);
                    if (hasQName(previousSubCall)) {
                        EList<String> qNameList = previousSubCall.getCall().getName().getQname();
                        subCallName = qNameList.get(qNameList.size() - 1);
                    }
                }
            }
        }
        return subCallName;
    }
    
    /**
     * Get the number of sub calls right to the ".".
     * 
     * @param node the node (typically the ".") which is the starting point for counting
     * @return the number of sub calls right to the "."
     */
    private int getSiblingCount(INode node) {
        int siblingCount = 0;
        INode currentNode = node;
        while (currentNode != null && currentNode.hasSiblings()) {
            siblingCount++;
            currentNode = currentNode.getNextSibling();
        }
        return siblingCount;
    }
    
    /**
     * Get the closest matching type of an VIL element based on the identifier (the name) of the
     * element and the corresponding node of this element in the syntax tree.
     * 
     * @param node the base element that holds the id for which the corresponding type should be found
     * @param id the name (identifier) for which the corresponding type should be found.
     */
    private String getMatchingType(INode node, String id) {
        String typeName = "";
        if (id.equals("OTHERPROJECTS")) {
            typeName = "Set";
        } else if (id.equals("SCRIPTDIR")) {
            typeName = "String";
        } else {
            /*
             * Search in the parent-element if the identifier "id" is defined in it.
             * If yes, return the type of "id". If not, do the same search for the next
             * parent recursively.
             */
            if (node != null && id != null && !id.isEmpty()) {
                INode parent = node.getParent();
                if (parent != null) {
                    EObject parentSemanticElement = parent.getSemanticElement();
                    /*
                     * Because of the VIL build-structure, we can restrict the search to map, rules and the 
                     * entire script. More fine-grained searches like in a rule-body may be possible but with this
                     * granularity we can also directly search for, i.e. rule parameters, in the same step.
                     */
                    if (parentSemanticElement instanceof MapImpl) {
                        MapImpl map = (MapImpl) parentSemanticElement;
                        typeName = getType(map.getBlock(), id);
                    }
                    if (parentSemanticElement instanceof RuleDeclarationImpl) {
                        RuleDeclarationImpl rule = (RuleDeclarationImpl) parentSemanticElement;
                        typeName = getType(rule, id);
                    }
                    if (parentSemanticElement instanceof ImplementationUnitImpl) {
                        LanguageUnit activeScript = getActiveVilScript(parent);
                        typeName = getType(activeScript, id);
                    }
                    if (typeName.isEmpty()) {
                        typeName = getMatchingType(parent, id);
                        // If no element was found - even after complete recursion - try to find an operation with this name
                        if (typeName.isEmpty()) {
                            typeName = getReturnType(id, ResourceRegistry.getTypeRegistry(node));
                        }
                    }
                }
            }            
        }
        return typeName;
    }
    
    /**
     * Get all valid VIL operation for a specific VIL (artefact) type.
     * 
     * @param typeName the name of the VIL element for which the valid operations will be determined
     * @param registry the type registry to query
     * @return a lost of operations descriptors defining the valid operations for the given type. Maybe
     * null if the type is not supported or no operation for this type is defined
     */
    private List<OperationDescriptor> getValidTypeOperations(String typeName, TypeRegistry registry) {
        List<OperationDescriptor> validTypeOperations = null;
        if (typeName != null && !typeName.isEmpty()) {
            List<OperationDescriptor> allOperations = getAvailableOperations(registry);
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
     * Get all VIL operations currently registered to EASy-Producer.
     *  
     * @param registry the type registry to query
     * @return a list of all operation descriptions. Maybe an empty list (not null!)
     * if no operation can be found
     */
    private List<OperationDescriptor> getAvailableOperations(TypeRegistry registry) {
        List<OperationDescriptor> operations = new ArrayList<OperationDescriptor>();
        Iterable<TypeDescriptor<? extends IVilType>> types = registry.allTypes();
        if (types != null) {
            Iterator<TypeDescriptor<? extends IVilType>> typeIterator = types.iterator();
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
        return operations;
    }
    
    private List<OperationDescriptor> getAvailableInstantiators(TypeRegistry registry) {
        List<OperationDescriptor> instantiatorOperations = new ArrayList<OperationDescriptor>();
        Iterable<TypeDescriptor<? extends IVilType>> instantiators = registry.allInstantiators();
        if (instantiators != null) {
            Iterator<TypeDescriptor<? extends IVilType>> instantiatorIterator = instantiators.iterator();
            if (instantiatorIterator != null) {
                while (instantiatorIterator.hasNext()) {
                    TypeDescriptor<? extends IVilType> next = instantiatorIterator.next();
                    for (int i = 0; i < next.getOperationsCount(); i++) {
                        instantiatorOperations.add(next.getOperation(i));
                    }
                }
            }
        }
        return instantiatorOperations;
    }
    
    private String getType(INode node) {
        String typeName = "";
        if (node != null) {
            EObject nodeSemanticElement = node.getSemanticElement();
            if (nodeSemanticElement != null && nodeSemanticElement instanceof VariableDeclarationImpl) {
                VariableDeclarationImpl varDecl = (VariableDeclarationImpl) nodeSemanticElement;
                if (varDecl.getType() != null && varDecl.getType().getName() != null) {
                    typeName = varDecl.getType().getName();
                }
            }
        }
        return typeName;
    }
    
    /**
     * Get the name of the type of an VIL element based on the name (identifier) of this element.
     * 
     * @param ruleDecl the parent-rule in which the element of interest is used in
     * @param name the name of the element as a string for which the type will be determined
     * @return the name of the type of the VIL element or an empty string if the type
     * could not be determined
     */
    private String getType(RuleDeclarationImpl ruleDecl, String name) {
        String typeName = "";
        if (ruleDecl != null && !name.isEmpty()) {
            // If the name of the element is LHS, it identifies the first precondition of the given rule
            if (name.equals("LHS") && hasElements(ruleDecl.getPreconditions())) {
                LogicalExpression ruleFirstPrecondition = ruleDecl.getPreconditions().get(0);
                // Can only be a path match, an artefact or an artefact collection (as defined in the language specification)
                typeName = getType(ruleFirstPrecondition, name);
            } else {
                // Check if declaration of the element identified by "name" is part of the rule element block 
                typeName = getType(ruleDecl.getBlock(), name);
                // Otherwise, check if the element is a rule parameter
                if (typeName.isEmpty() && null != ruleDecl.getParamList() 
                    && hasElements(ruleDecl.getParamList().getParam())) {
                    EList<Parameter> ruleParameters = ruleDecl.getParamList().getParam();
                    for (Parameter param : ruleParameters) {
                        if (param != null && param.getName().equals(name)) {
                            typeName = param.getType().getName(); 
                        }
                    }   
                }                
            }
        }
        return typeName;
    }
    
    /**
     * Get the name of the type of an VIL element based on the name (identifier) of this element.
     * 
     * @param logExpr a logical expression in which the element of interest is used
     * @param name the name of the element as a string for which the type will be determined
     * @return the name of the type of the VIL element or an empty string if the type
     * could not be determined
     */
    private String getType(LogicalExpression logExpr, String name) {
        String typeName = "";
        if (logExpr != null && !name.isEmpty()) {
            // TODO: finish this   
        }
        return typeName;
    }
     
    /**
     * Get the name of the type of an VIL element based on the name (identifier) of this element.
     * 
     * @param ruleImpl the rule implementation (complete rule representation) in which the search
     * for the type will start
     * @param name the name of the element as a string for which the type will be determined
     * @return the name of the type of the VIL element or an empty string if the type
     * could not be determined
     */
    private String getType(RuleElementBlock ruleElBlock, String name) {
        String typeName = "";
        if (hasElements(ruleElBlock) && name != null && !name.isEmpty()) {
            for (int i = 0; i < ruleElBlock.getElements().size(); i++) {
                RuleElement ruleElement = ruleElBlock.getElements().get(i);
                if (ruleElement.getVarDecl() != null) {
                    VariableDeclaration varDeclElement = ruleElement.getVarDecl();
                    if (varDeclElement.getName().equals(name)) {
                        typeName = varDeclElement.getType().getName();                        
                    }
                }
            }
        }
        return typeName;
    }
    
    /**
     * Get the name of the type of an VIL element based on the name (identifier) of this element.
     * 
     * @param script the script in which the search for the type will start
     * @param name the name of the element as a string for which the type will be determined
     * @return the name of the type of the VIL element or an empty string if the type
     * could not be determined
     */
    private String getType(LanguageUnit script, String name) {
        String typeName = "";
        if (script != null && !name.isEmpty()) {
            // Check if the element identified by "name" is part of the script's variables (incl. rule variables, etc.)
            List<VariableDeclarationImpl> varDecls = getAllVariables(script);
            if (hasElements(varDecls)) {
                for (VariableDeclarationImpl varDecl : varDecls) {
                    if (varDecl != null && varDecl.getName() != null && varDecl.getName().equals(name)) {
                        typeName = varDecl.getType().getName();
                    }
                }
            }
            // Otherwise, the element may identify a script parameter 
            if (typeName.isEmpty() && script.getParam() != null && hasElements(script.getParam().getParam())) {
                EList<Parameter> paramList = script.getParam().getParam();
                for (Parameter param : paramList) {
                    if (param.getName() != null && param.getName().equals(name)) {
                        typeName = param.getType().getName();
                    }
                }
            }
            // Otherwise, the element may identify a rule in the script
            if (typeName.isEmpty()) {
                List<RuleDeclarationImpl> ruleDecls = getAllRules(script);
                if (hasElements(ruleDecls)) {
                    for (RuleDeclarationImpl ruleDecl : ruleDecls) {
                        if (ruleDecl.getName() != null && ruleDecl.getName().equals(name)) {
                            //TODO It is not possible to get the return type from RuleDeclarationImpl
                        }
                    }
                }
            }
            
            // TODO extend this to searches in parent-script, imports and load properties! (IVML decision variables?)
            
        }
        return typeName;
    }
    
    private String getReturnType(String id, TypeRegistry registry) {
        String returnType = "";
        if (!id.isEmpty()) {
            List<OperationDescriptor> operationsList = getAvailableOperations(registry);
            if (hasElements(operationsList)) {
                for (OperationDescriptor opDescr : operationsList) {
                    if (opDescr.getName().equals(id)) {
                        returnType = opDescr.getReturnType().getName();
                    }
                }
            }
        }
        return returnType;
    }
    
    private File getVilFile(EObject rootObject) {
        File vilFile = null;
        if (rootObject != null && rootObject instanceof ImplementationUnit) {
            ImplementationUnit implUnit = (ImplementationUnit) rootObject;
            List<ModelInfo<Script>> modelInfos;
            try {
                modelInfos = BuildLangModelUtility.INSTANCE.obtainInfo(implUnit.eResource().getURI());
                if (modelInfos != null) {
                    ModelInfo<Script> currentModelInfo = modelInfos.get(0);
                    vilFile = new File(currentModelInfo.getLocation());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return vilFile;
    }
    
    private boolean hasQName(Constant constant) {
        return constant != null
                && constant.getQValue() != null
                && constant.getQValue().getPrefix() != null
                && hasElements(constant.getQValue().getPrefix().getQname());
    }
    
    private boolean hasQName(SubCall subCall) {
        return subCall != null
                && subCall.getCall() != null
                && subCall.getCall().getName() != null
                && hasElements(subCall.getCall().getName().getQname());
    }
    
    private boolean hasElements(RuleElementBlock ruleElBlock) {
        return ruleElBlock != null
                && ruleElBlock.getElements() != null
                && !ruleElBlock.getElements().isEmpty();
    }
    
    private boolean hasElements(List<?> list) {
        return list != null && !list.isEmpty();
    }
    
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
    
    private List<Parameter> getRuleParams(INode node) {
        List<Parameter> result = null;
        if (node != null) {
            RuleDeclarationImpl rule = getParentRule(node);
            if (rule != null && rule.getParamList() != null && hasElements(rule.getParamList().getParam())) {
                result = rule.getParamList().getParam();   
            }
        }
        return result;
    }
    
    private List<VariableDeclaration> getRuleVars(INode node) {
        List<VariableDeclaration> result = null;
        if (node != null) {
            RuleDeclarationImpl rule = getParentRule(node);
            if (hasElements(rule.getBlock())) {
                result = getRuleElementBlockVars(rule.getBlock());
            }
        }
        return result; 
    }
    
    private List<VariableDeclaration> getRuleElementBlockVars(RuleElementBlock ruleElementBlock) {
        List<VariableDeclaration> result = null;
        if (hasElements(ruleElementBlock)) {
            result = new ArrayList<VariableDeclaration>();
            EList<RuleElement> ruleElements = ruleElementBlock.getElements();
            for (RuleElement ruleElement : ruleElements) {
                if (ruleElement != null && ruleElement.getVarDecl() != null) {
                    result.add(ruleElement.getVarDecl());
                }
            }            
        }
        return result;
    }
    
    private RuleDeclarationImpl getParentRule(INode node) {
        RuleDeclarationImpl parentRule = null;
        if (node != null) {
            EObject semanticElement = node.getSemanticElement();
            if (semanticElement instanceof RuleDeclarationImpl) {
                parentRule = (RuleDeclarationImpl) semanticElement;
            } else {
                parentRule = getParentRule(node.getParent());
            }
        }
        return parentRule;
    }
    
    private List<StyledString> opsToDisplayString(List<OperationDescriptor> operationsList) {
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
    
    private List<StyledString> varsToDisplayString(List<VariableDeclaration> varDeclList) {
        List<StyledString> varDeclStringList = null;
        if (hasElements(varDeclList)) {
            varDeclStringList = new ArrayList<StyledString>();
            for (VariableDeclaration varDecl : varDeclList) {
                String varName = varDecl.getName();
                String type = varDecl.getType().getName();
                StyledString displayString = new StyledString();
                displayString.append(varName);
                displayString.append(" : " + type, StyledString.QUALIFIER_STYLER);
                varDeclStringList.add(displayString);
            }
        }
        return varDeclStringList;
    }
}
