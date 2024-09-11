package de.uni_hildesheim.sse.vil.buildlang.ui.contentassist;

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
import de.uni_hildesheim.sse.vil.expressions.ResourceRegistry;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.LogicalExpression;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.Parameter;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.VariableDeclaration;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.CallImpl;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionOrQualifiedExecutionImpl;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.VariableDeclarationImpl;
import de.uni_hildesheim.sse.vil.expressions.ui.contentassist.ExpressionDslProposalProviderUtility;
import de.uni_hildesheim.sse.vil.buildlang.vilBuildLanguage.ImplementationUnit;
import de.uni_hildesheim.sse.vil.buildlang.vilBuildLanguage.LanguageUnit;
import de.uni_hildesheim.sse.vil.buildlang.vilBuildLanguage.LoopVariable;
import de.uni_hildesheim.sse.vil.buildlang.vilBuildLanguage.RuleConditions;
import de.uni_hildesheim.sse.vil.buildlang.vilBuildLanguage.RuleDeclaration;
import de.uni_hildesheim.sse.vil.buildlang.vilBuildLanguage.RuleElement;
import de.uni_hildesheim.sse.vil.buildlang.vilBuildLanguage.RuleElementBlock;
import de.uni_hildesheim.sse.vil.buildlang.vilBuildLanguage.ScriptContents;
import de.uni_hildesheim.sse.vil.buildlang.vilBuildLanguage.impl.ImplementationUnitImpl;
import de.uni_hildesheim.sse.vil.buildlang.vilBuildLanguage.impl.MapImpl;
import de.uni_hildesheim.sse.vil.buildlang.vilBuildLanguage.impl.RuleDeclarationImpl;
import net.ssehub.easy.basics.modelManagement.ModelInfo;
import net.ssehub.easy.instantiation.core.model.buildlangModel.Script;
import net.ssehub.easy.instantiation.core.model.vilTypes.IVilType;
import net.ssehub.easy.instantiation.core.model.vilTypes.OperationDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;

/**
 * A utility class for determining different elements in the VIL build model based on the
 * more generic information provided by the Xtext UI functionalities (typically EObject, etc.)
 * 
 * Please note if multiple VIL scripts are defined in the same file, the proposals of the content
 * assist may be wrong!
 * 
 * @author kroeher
 * @author dernek
 */
public class VilBuildLangProposalProviderUtility extends ExpressionDslProposalProviderUtility {

    /**
     * The current instance of the utility class. Prevent parallel access to the parse tree.
     */
    public static final VilBuildLangProposalProviderUtility INSTANCE = new VilBuildLangProposalProviderUtility();
    
    /**
     * Prevents external creation.
     */
    private VilBuildLangProposalProviderUtility() {
    }
    
    /**
     * Returns all parameters defined for a specific script. Typically this returns the following
     * elements: Project source, Project target, and Configuration conf. However, the user may define
     * additional parameters or may delete these script parameters (yielding a return values of <b>null</b>).
     *  
     * @param node the <code>INode</code> object (last complete node) for which the content assist is called. This node is used 
     * to determine the parent script and, thus, its parameters.
     * @return a list of <code>StyledString</code> that includes all script parameters ready for displaying in the
     * content assist or <b>null</b> if no script parameters are defined.
     */
    public List<StyledString> getScriptParameters(INode node) {
        List<StyledString> result = null;
        if (node != null) {
            LanguageUnit activeScript = getActiveVilScript(node);
            if (activeScript != null && activeScript.getParam() != null && hasElements(activeScript.getParam().getParam())) {
                EList<Parameter> paramList = activeScript.getParam().getParam();
                result = new ArrayList<StyledString>();
                for (Parameter param : paramList) {
                    String varName = param.getName();
                    String type = getTypeName(param.getType());
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
     * Returns all rules in the current script in terms of a <code>StyledString</code> including name
     * and parameter list.
     * 
     * @param node the <code>INode</code> object (last complete node) for which the content assist is called. This node is used 
     * to determine the parent script and, thus, all defined rules in this script.
     * @param deleteSelf if the passed node (last complete node) is a rules itself, we assume, that the content assist is called
     * to complete a pre-/postcondition. In such a case, the rule for which the condition shall be completed must not be in the
     * proposal list (deleteSelf = <b>true</b>). To return all rules of the script, use <b>false</b>.
     * @return a list of <code>StyledString</code> that includes all rules ready for displaying in the content assist or 
     * <b>null</b> if no rule parameters are defined.
     */
    public List<StyledString> getAllRules(INode node, boolean deleteSelf) {
        List<StyledString> result = null;
        if (node != null) {
           List<RuleDeclaration> allRules = getAllRules(getActiveVilScript(node));
           if (hasElements(allRules)) {
               if (deleteSelf) {
                   allRules.remove(getParentRule(node));
               }
               result = new ArrayList<StyledString>();
               for (RuleDeclaration ruleDecl : allRules) {
                   if (ruleDecl != null) {
                       String ruleName = ruleDecl.getName() + "(";
                       if (ruleDecl.getParamList() != null && hasElements(ruleDecl.getParamList().getParam())) {
                           EList<Parameter> paramList = ruleDecl.getParamList().getParam();
                           String parameterString = "";
                           for (Parameter param : paramList) {
                               parameterString = parameterString + getTypeName(param.getType());
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
     * Returns all variables defined for a specific script. This includes also the implicit variables <b>OTHERPROJECTS</b>
     * and <b>SCRIPTDIR</b>. However, variables that are defined as part of a rule or other elements than the script itself
     * will not be considered.
     * 
     * @param node the <code>INode</code> object (last complete node) for which the content assist is called. This node is used 
     * to determine the parent script and, thus, its variables.
     * @param completeDefsOnly in order to prevent proposals of incomplete variables, i.e. if the user calls the content assist 
     * for completing a variable definition, the incomplete variable(s) must not be proposed (completeDefsOnly = <b>true</b>). 
     * To return all variables of the script, use <b>false</b>.   
     * @return a list of <code>StyledString</code> that includes all script variables ready for displaying in the content assist
     * or <b>null</b> if no script variables are defined. 
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
                List<VariableDeclaration> varDecls = getAllVariables(activeScript);
                if (hasElements(varDecls)) {
                    for (VariableDeclaration varDecl : varDecls) {
                        if (completeDefsOnly) {
                            if (varDecl.getExpression() != null /*TODO: also include expressions are not null ... does not work like this*/) {
                                String varName = varDecl.getName();
                                String type = getTypeName(varDecl.getType());
                                StyledString displayString = new StyledString();
                                displayString.append(varName);
                                displayString.append(" : " + type, StyledString.QUALIFIER_STYLER);
                                result.add(displayString);                                
                            }
                        } else {
                            String varName = varDecl.getName();
                            String type = getTypeName(varDecl.getType());
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
     * Returns the name of the current VIL file.
     * 
     * @param rootObject the root element of the current context. Typically this is the <code>ImplementationUnit</code>.
     * @return the name of the current VIL file or an empty string if the file could not be resolved.
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
     * Returns the name of the first IVML-file which can be found in the parent-directory of the current VIL-file.
     *  
     * @param rootObject the root element of the current context. Typically this is the <code>ImplementationUnit</code>.
     * @return the name of the first IVML-file which can be found in the parent-directory of the current VIL-file or an 
     * empty string if no IVML-file is located in the parent-directory
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
     * Checks whether the current VIL-build script has a version.
     * 
     * @param node the <code>INode</code> object (last complete node) for which the content assist is called.
     * @return <b>true</b> if the current VIL-build script has a version. <b>False</b> otherwise.
     */
    public boolean hasVersion(INode node) {
        boolean hasVersion = false;
        if (node != null) {
            LanguageUnit activeScript = getActiveVilScript(node);
            if (activeScript != null && activeScript.getVersion() != null) {
                hasVersion = true;
            }
        }
        return hasVersion;
    }
    
    /**
     * Checks whether a script is defined as part of the current VIL-file.
     * 
     * @param node the <code>INode</code> object (last complete node) for which the content assist is called.
     * @return <b>true</b> if the current VIL-file includes a script-definition. <b>False</b> otherwise.
     */
    public boolean hasScript(INode node) {
        boolean hasScript = false;
        if (node != null) {
            LanguageUnit activeScript = getActiveVilScript(node);
            if (activeScript != null) {
                hasScript = true;
            }
        }
        return hasScript;
    }
    
    /**
     * Returns all operations currently available in EASy-Producer that return a specific VIL-type.
     * 
     * @param node the <code>INode</code> object (last complete node) for which the content assist is called. The semantic 
     * element of this node is used for determining the VIL-type the return type of the operations shall match. 
     * @return a list of <code>StyledString</code> that includes all operations which return the same type as the semantic 
     * element of the node ready for displaying in the content assist or <b>null</b> if no such operations are available.
     */
    public List<StyledString> getOperationsMatchingReturnType(INode node) {
        String desiredType = getType(node);
        List<OperationDescriptor> fullOperationsList = getAvailableOperations(node);
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
    
    /**
     * Returns all instantiators currently available in EASy-Producer.
     * 
     * @param node the <code>INode</code> object (last complete node) for which the content assist is called.
     * @return a list of <code>StyledString</code> that includes all instantiators currently available in EASy-Producer 
     * ready for displaying in the content assist or <b>null</b> if no instantiators are available.
     */
    public List<StyledString> getAllInstantiators(INode node) {
        return opsToDisplayString(getAvailableInstantiators(node));
    }

    @Override
    public List<StyledString> getParentParameters(INode node) {
        List<StyledString> parentParamList = null;
        if (node != null) {
            parentParamList = new ArrayList<StyledString>();
            EObject semanticElement = node.getSemanticElement();
            if (semanticElement instanceof MapImpl) {
                // First, search for map-expression and all defined parameter and variables for/in that expression
                MapImpl parentMap = (MapImpl) semanticElement;
                // TODO: determine the actual type of each variable by analyzing the expression
                if (parentMap != null && hasElements(parentMap.getVar()) /* && parentMap.getExpr() != null*/) {
                    EList<LoopVariable> parentMapVars = parentMap.getVar();
                    for (int i = 0; i < parentMapVars.size(); i++) {
                        StyledString mapParam = new StyledString(parentMapVars.get(i).getVar());
                        // TODO: now an explicit given type may be available (or null if not given!)
                        mapParam.append(" : <Type?>", StyledString.QUALIFIER_STYLER);
                        parentParamList.add(mapParam);
                    }                        
                }
            } 
            if (semanticElement instanceof RuleDeclarationImpl) {
                // Second, search for parent rule and all defined parameter and variables for/in that rule
                List<StyledString> parameterList = getRuleParameters(node);
                if (parameterList != null && !parameterList.isEmpty()) {
                    parentParamList.addAll(getRuleParameters(node));
                }
            } else {
                // As long as there was no rule found, search recursively for more nested variables/parameters.
                List<StyledString> parentParams = getParentParameters(node.getParent());
                if (null != parentParams) { 
                    parentParamList.addAll(parentParams);
                }
            }
        }
        return parentParamList;
    }
    
    @Override
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
                parentVarList.addAll(getRuleVariables(node, completeDefsOnly, true));
                
            } else {
                // As long as there was no rule found, search recursively for more nested variables/parameters.
                List<StyledString> parentList = getParentVariables(node.getParent(), completeDefsOnly);
                if (parentList != null) {
                    parentVarList.addAll(parentList);
                }
            }
        }
        return parentVarList;
    }
    
    /**
     * Returns a <code>List&lt;String&gt;</code> with the types of the parameters from the rule, which is searched.
     * @param toSearch the name of the rule, for which we want the types of the parameters.
     * @param node the last complete node which will committed when we start using the content assist in braces.
     * @return <code>List&lt;String&gt;</code> with the parameter types. Can be <b>null</b>.
     */
    public List<String> searchForRuleParameterTypes(String toSearch, INode node) {
        List<String> parameterTypes = null;
        if (node != null) {
            List<RuleDeclaration> allRules = getAllRules(getActiveVilScript(node));
            for (RuleDeclaration rule : allRules) {
                if (rule != null) {
                    if (rule.getName() != null) {
                        if (rule.getName().equals(toSearch)) {
                            parameterTypes = new ArrayList<String>();
                            if (rule.getParamList() != null) {
                                if (rule.getParamList().getParam() != null) {
                                    for (Parameter param : rule.getParamList().getParam()) {
                                        String toAdd = getTypeName(param.getType());
                                        //System.out.println("SearchForTypes: " + toAdd);
                                        parameterTypes.add(toAdd); 
                                    }                           
                                }
                            }
                        }    
                    }
                }
            }
        }
        return parameterTypes;
    }
    
    /**
     * Tries to filter the <code>CallImpl</code> from a node.
     * This method should only be used in a parameter-complete method.
     * 
     * @param node the last complete node.
     * @return the <code>CallImpl</code> from the node. Maybe <b>null</b>, if no <code>CallImpl</code> was 
     * found.
     */
    public CallImpl getCallImpl(INode node) {
        CallImpl result = null;
        if (node != null) {
            if (node.getSemanticElement() instanceof CallImpl) {
                result = (CallImpl) node.getSemanticElement();
            } else {
                INode parentNode = node.getParent();
                if (parentNode != null) {
                    result = getCallImpl(parentNode);
                }
            }
        }
        return result;
    }
    
    public ExpressionOrQualifiedExecutionImpl getExprOrExecution(INode node) {
        ExpressionOrQualifiedExecutionImpl result = null;
        if (node != null) {
            if (node.getSemanticElement() instanceof ExpressionOrQualifiedExecutionImpl) {
                result = (ExpressionOrQualifiedExecutionImpl) node.getSemanticElement();
            } else {
                INode parentNode = node.getParent();
                if (parentNode != null) {
                    result = getExprOrExecution(parentNode);
                }
            }
        }
        return result;
    }
    
    /**
     * Returns a List with all variables in the document, which have a specified type.
     * @param node the last complete node, when the content assist is used.
     * @param typeList the <code>List&lt;String&gt;</code> with all types.
     * @param completeDefsOnly <b>true</b> if you only want full declared variables, <b>false</b> if you don't.
     * @return a <code>List&lt;StyledString&gt;</code> with all proposals, which are ready to display in the content assist.
     * Maybe <b>null</b> if no variables found.
     */
    public List<StyledString> getAllVarsForType(INode node, List<String> typeList, boolean completeDefsOnly) {
        List<StyledString> result = null;
        if (node != null) {
            // Take all Vars inside of the rule
            result = new ArrayList<StyledString>();
            List<VariableDeclaration> varDecls = getRuleVars(node);
            if (hasElements(varDecls)) {                
                for (VariableDeclaration varDecl : varDecls) {
                    if (completeDefsOnly) {
                        if (varDecl.getExpression() != null) {
                            for (String type : typeList) {
                                if (varDecl.getType().getName().getQname().get(0).equals(type)) {
                                    String varName = varDecl.getName();
                                    String varType = getTypeName(varDecl.getType());
                                    StyledString displayString = new StyledString();
                                    displayString.append(varName);
                                    displayString.append(" : " + varType, StyledString.QUALIFIER_STYLER);
                                    result.add(displayString);                                  
                                }
                            }
                        }
                    } else {
                        for (String type : typeList) {
                            if (varDecl.getType().getName().getQname().get(0).equals(type)) {
                                String varName = varDecl.getName();
                                String varType = getTypeName(varDecl.getType());
                                StyledString displayString = new StyledString();
                                displayString.append(varName);
                                displayString.append(" : " + varType, StyledString.QUALIFIER_STYLER);
                                result.add(displayString);
                            }
                        }
                    }
                }
            }
            // take parameters from rule
            List<Parameter> paramList = getRuleParams(node);
            if (hasElements(paramList)) {
                for (Parameter parameter : paramList) {
                    for (String type : typeList) {
                        if (parameter.getType().getName().getQname().get(0).equals(type)) {
                            String varName = parameter.getName();
                            String vartype = getTypeName(parameter.getType());
                            StyledString displayString = new StyledString();
                            displayString.append(varName);
                            displayString.append(" : " + vartype, StyledString.QUALIFIER_STYLER);
                            result.add(displayString);   
                        }  
                    }
                }
            }
            
            // take all vars from script
            LanguageUnit activeScript = getActiveVilScript(node);
            if (activeScript != null) {
                List<VariableDeclaration> varDeclarations = getAllVariables(activeScript);
                if (hasElements(varDecls)) {
                    for (VariableDeclaration varDecl : varDeclarations) {
                        if (completeDefsOnly) {
                            for (String type : typeList) {
                                if (varDecl.getType().getName().getQname().get(0).equals(type)) {
                                    if (varDecl.getExpression() != null) {
                                        String varName = varDecl.getName();
                                        String vartype = getTypeName(varDecl.getType());
                                        StyledString displayString = new StyledString();
                                        displayString.append(varName);
                                        displayString.append(" : " + vartype, StyledString.QUALIFIER_STYLER);
                                        result.add(displayString);                                
                                    } 
                                }
                            }
                        } else {
                            for (String type : typeList) {
                                if (varDecl.getType().getName().getQname().get(0).equals(type)) {
                                    String varName = varDecl.getName();
                                    String vartype = getTypeName(varDecl.getType());
                                    StyledString displayString = new StyledString();
                                    displayString.append(varName);
                                    displayString.append(" : " + vartype, StyledString.QUALIFIER_STYLER);
                                    result.add(displayString);
                                }
                            }
                        }
                    }
                }
            }
            
            //take all script parameters
            activeScript = getActiveVilScript(node);
            if (activeScript != null && activeScript.getParam() != null && hasElements(activeScript.getParam().getParam())) {
                EList<Parameter> scriptParamList = activeScript.getParam().getParam();
                for (Parameter param : scriptParamList) {
                    for (String type : typeList) {
                        if (param.getType().getName().getQname().get(0).equals(type)) {
                            String varName = param.getName();
                            String vartype = getTypeName(param.getType());
                            StyledString displayString = new StyledString();
                            displayString.append(varName);
                            displayString.append(" : " + vartype, StyledString.QUALIFIER_STYLER);
                            result.add(displayString); 
                        }
                    }
                }
            }
            
        }
        
        return result;
    }
    
    public boolean isMainRuleDeclared(INode node) {
        boolean result = false;
        LanguageUnit activeScript = getActiveVilScript(node);
        if (activeScript != null) {
            ScriptContents scriptContents = activeScript.getContents();
            if (scriptContents != null && hasElements(scriptContents.getElements())) {
                List<EObject> scriptContentElements = scriptContents.getElements();
                for (EObject element : scriptContentElements) {
                    if (element != null && element instanceof RuleDeclarationImpl) {
                        RuleDeclarationImpl potentialMainRule = (RuleDeclarationImpl) element;
                        if (potentialMainRule.getName().equals("main")) {
                            result = true;
                        }
                    }
                }
            }   
        }
        return result;
    }
    
    public String getScriptParametersForMainRule(INode node) {
        String result = null;
        if (node != null) {
            LanguageUnit activeScript = getActiveVilScript(node);
            if (activeScript != null && activeScript.getParam() != null && hasElements(activeScript.getParam().getParam())) {
                EList<Parameter> paramList = activeScript.getParam().getParam();
                result = "";
                for (Parameter param : paramList) {
                    String varName = param.getName();
                    String type = getTypeName(param.getType());
                    result += type + " " + varName + ", ";
                }
            }
        }
        if (!result.equals("")) {
            result = result.substring(0, result.length() - 2);
        } else {
            result = null;
        }
        return result;
    }
    
    /**
     * Returns the active VIL-script.
     * 
     * @param node the <code>INode</code> object (last complete node) for which the content assist is called. 
     * @return the active VIL-script in terms of a <code>LanguageUnit</code> object or <b>null</b> if no such 
     * object can be found.
     */
    private LanguageUnit getActiveVilScript(INode node) {
        LanguageUnit activeScript = null;
        ICompositeNode rootNode = node.getRootNode();        
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
    
    /**
     * Returns a list of all <code>RuleDeclaration</code> objects defined in the current VIL-script.
     * 
     * @param activeScript the <code>LanguageUnit</code> object which represents the active VIL-script currently in use.
     * @return a list of <code>RuleDeclaration</code> objects or <b>null</b> if no such object can be found.
     */
    private List<RuleDeclaration> getAllRules(LanguageUnit activeScript) {
        List<RuleDeclaration> ruleList = null;
        ScriptContents scriptContents = activeScript.getContents();
        if (scriptContents != null && hasElements(scriptContents.getElements())) {
            List<EObject> scriptContentElements = scriptContents.getElements();
            ruleList = new ArrayList<RuleDeclaration>();
            for (EObject element : scriptContentElements) {
                if (element != null && element instanceof RuleDeclaration) {
                    ruleList.add((RuleDeclaration) element);
                }
            }
        }
        return ruleList;
    }
    
    /**
     * Returns a list of all <code>VariableDeclaration</code> objects defined in the current VIL-script.
     * 
     * @param activeScript the <code>LanguageUnit</code> object which represents the active VIL-script currently in use.
     * @return a list of <code>VariableDeclaration</code> objects or <b>null</b> if no such object can be found.
     */
    private List<VariableDeclaration> getAllVariables(LanguageUnit activeScript) {
        List<VariableDeclaration> variableList = null;
        ScriptContents scriptContents = activeScript.getContents();
        if (scriptContents != null && hasElements(scriptContents.getElements())) {
            List<EObject> scriptContentElements = scriptContents.getElements();
            variableList = new ArrayList<VariableDeclaration>();
            for (EObject element : scriptContentElements) {
                if (element != null && element instanceof VariableDeclaration) {
                    variableList.add((VariableDeclarationImpl) element);
                }
            }
        }
        return variableList;
    }
    
    @Override
    protected String getMatchingType(INode node, String id) {
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
                    while (parentSemanticElement instanceof RuleElementBlock) {
                        parentSemanticElement = parentSemanticElement.eContainer();
                    }
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
                            typeName = getReturnType(id, node);
                        }
                    }
                }
            }            
        }
        return typeName;
    }
    
    /**
     * Returns a list with all available instantiators.
     * @param node the last complete node which provides the basic information for retrieving the operations.
     * @return <code>List&lt;OperationDescriptor&gt;</code> which contains the available instantiator operations. Can be <b>null</b>.
     */
    private List<OperationDescriptor> getAvailableInstantiators(INode node) {        
        List<OperationDescriptor> instantiatorOperations = null;
        TypeRegistry typeRegistry = ResourceRegistry.getTypeRegistry(node);
        if (typeRegistry != null) {
            Iterable<TypeDescriptor<? extends IVilType>> instantiators = typeRegistry.allInstantiators();
            if (instantiators != null) {
                Iterator<TypeDescriptor<? extends IVilType>> instantiatorIterator = instantiators.iterator();
                if (instantiatorIterator != null) {
                    instantiatorOperations = new ArrayList<OperationDescriptor>();
                    while (instantiatorIterator.hasNext()) {
                        TypeDescriptor<? extends IVilType> next = instantiatorIterator.next();
                        for (int i = 0; i < next.getOperationsCount(); i++) {
                            instantiatorOperations.add(next.getOperation(i));
                        }
                    }
                }
            }            
        }
        return instantiatorOperations;
    }
    
    /**
     * Returns the type of an variable.
     * 
     * @param node the last complete node, after the content assist is used.
     * @return a <code>String</code> which contains the type of the variable. Never <b>null</b> but maybe an empty <code>String</code>, if nothing 
     * was found.
     */
    private String getType(INode node) {
        String typeName = "";
        if (node != null) {
            EObject nodeSemanticElement = node.getSemanticElement();
            if (nodeSemanticElement != null && nodeSemanticElement instanceof VariableDeclarationImpl) {
                VariableDeclarationImpl varDecl = (VariableDeclarationImpl) nodeSemanticElement;
                if (varDecl.getType() != null && varDecl.getType().getName() != null) {
                    typeName = getTypeName(varDecl.getType());
                }
            }
        }
        return typeName;
    }
    
    /**
     * Get the name of the type of an VIL element based on the name (identifier) of this element.
     * 
     * @param ruleDecl <code>RuleDeclarationImpl</code> the parent-rule in which the element of interest is used in.
     * @param name <code>String</code> the name of the element as a string for which the type will be determined.
     * @return <code>String</code> the name of the type of the VIL element or an empty <code>String</code> if the type
     * could not be determined. Never <b>null</b>.
     */
    private String getType(RuleDeclarationImpl ruleDecl, String name) {
        String typeName = "";
        if (ruleDecl != null && !name.isEmpty()) {
            // If the name of the element is LHS, it identifies the first precondition of the given rule
            RuleConditions cond = ruleDecl.getConditions();
            if (name.equals("LHS") && null != cond && hasElements(cond.getPreconditions())) {
                LogicalExpression ruleFirstPrecondition = cond.getPreconditions().get(0);
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
                            typeName = getTypeName(param.getType()); 
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
     * @param logExpr a <code>LogicalExpression</code> in which the element of interest is used.
     * @param name <code>String</code> name of the element as a string for which the type will be determined
     * @return <code>String</code> name of the type of the VIL element or an empty <code>String</code> if the type
     * could not be determined. Never <b>null</b>.
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
     * @param ruleElBlock <code>RuleElementBlock</code> the rule implementation (complete rule representation) in which the 
     * search for the type will start
     * @param name <code>String</code> the name of the element as a string for which the type will be determined.
     * @return <code>String</code> name of the type of the VIL element or an empty <code>String</code> if the type
     * could not be determined. Never <b>null</b>.
     */
    private String getType(RuleElementBlock ruleElBlock, String name) {
        String typeName = "";
        if (hasElements(ruleElBlock) && name != null && !name.isEmpty()) {
            for (int i = 0; i < ruleElBlock.getElements().size(); i++) {
                RuleElement ruleElement = ruleElBlock.getElements().get(i);
                if (ruleElement.getVarDecl() != null) {
                    VariableDeclaration varDeclElement = ruleElement.getVarDecl();
                    if (varDeclElement.getName().equals(name)) {
                        typeName = getTypeName(varDeclElement.getType());
                    }
                }
            }
        }
        return typeName;
    }
    
    /**
     * Get the name of the type of an VIL element based on the name (identifier) of this element.
     * 
     * @param script <code>LanguageUnit</code> script in which the search for the type will start.
     * @param name <code>String</code> name of the element as a string for which the type will be determined.
     * @return <code>String</code> name of the type of the VIL element or an empty <code>String</code> if the type
     * could not be determined. Never <b>null</b>.
     */
    private String getType(LanguageUnit script, String name) {
        String typeName = "";
        if (script != null && !name.isEmpty()) {
            // Check if the element identified by "name" is part of the script's variables (incl. rule variables, etc.)
            List<VariableDeclaration> varDecls = getAllVariables(script);
            if (hasElements(varDecls)) {
                for (VariableDeclaration varDecl : varDecls) {
                    if (varDecl != null && varDecl.getName() != null && varDecl.getName().equals(name)) {
                        typeName = getTypeName(varDecl.getType());
                    }
                }
            }
            // Otherwise, the element may identify a script parameter 
            if (typeName.isEmpty() && script.getParam() != null && hasElements(script.getParam().getParam())) {
                EList<Parameter> paramList = script.getParam().getParam();
                for (Parameter param : paramList) {
                    if (param.getName() != null && param.getName().equals(name)) {
                        typeName = getTypeName(param.getType());
                    }
                }
            }
            // Otherwise, the element may identify a rule in the script
            if (typeName.isEmpty()) {
                List<RuleDeclaration> ruleDecls = getAllRules(script);
                if (hasElements(ruleDecls)) {
                    for (RuleDeclaration ruleDecl : ruleDecls) {
                        if (ruleDecl.getName() != null && ruleDecl.getName().equals(name) && ruleDecl.getType() != null) {
                            typeName = getTypeName(ruleDecl.getType());
                        }
                    }
                }
            }
            
            // TODO extend this to searches in parent-script, imports and load properties! (IVML decision variables?)
            
        }
        return typeName;
    }
    
    /**
     * Returns the file of the VIL-Script.
     * 
     * @param rootObject the rootModel from the <code>ContentAssistContext</code>.
     * @return the VIL-Script file as a <code>File</code>. Maybe <b>null</b>.
     */
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
    
    /**
     * Checks if the <code>RuleElementBlock</code> has at least one element or not.
     * 
     * @param ruleElBlock rule element block
     * @return <b>true</b> if it has at least one element, <b>false</b> otherwise.
     */
    private boolean hasElements(RuleElementBlock ruleElBlock) {
        return ruleElBlock != null
                && ruleElBlock.getElements() != null
                && !ruleElBlock.getElements().isEmpty();
    }
    
    /**
     * Returns the parameters from a rule.
     * 
     * @param node Last complete node, when the content assist is used.
     * @return a <code>List&lt;Parameter&gt;</code> list with the <code>Parameter</code>s from the rule. Maybe <b>null</b>.
     */
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
    
    /**
     * Returns the variables from a rule.
     * 
     * @param node Last complete node, when the content assist is used.
     * @return a <code>List&lt;VariableDeclaration&gt;</code> list with the <code>VariableDeclaration</code>s from the rule.
     * Maybe <b>null</b>.
     */
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
    
    /**
     * Returns all variables from the <code>RuleElementBlock</code>.
     * 
     * @param ruleElementBlock
     * @return a <code>List&lt;VariableDeclaration&gt;</code> with all variables from the <code>RuleElementBlock</code>.
     * Maybe <b>null</b>.
     */
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
    
    /**
     * Returns the <code>RuleDeclarationImpl</code>, so the object of the rule.
     * @param node the last complete node, which were committed, when we invoke the content assist inside of the rule.
     * @return the <code>RuleDeclarationImpl</code> of the rule.
     */
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
    
    /**
     * Converts the variable names into a content assist friendly format, which can be directly used to display.
     * @param varDeclList the variable declarations
     * @return a <code>List&lt;StyledString&gt;</code> which contains all variables, ready to display in the content assist.
     * Maybe <b>null</b>, if the <code>List&lt;VariableDeclaration&gt;</code> varDeclList is empty.
     */
    private List<StyledString> varsToDisplayString(List<VariableDeclaration> varDeclList) {
        List<StyledString> varDeclStringList = null;
        if (hasElements(varDeclList)) {
            varDeclStringList = new ArrayList<StyledString>();
            for (VariableDeclaration varDecl : varDeclList) {
                String varName = varDecl.getName();
                String type = getTypeName(varDecl.getType());
                StyledString displayString = new StyledString();
                displayString.append(varName);
                displayString.append(" : " + type, StyledString.QUALIFIER_STYLER);
                varDeclStringList.add(displayString);
            }
        }
        return varDeclStringList;
    }
    
    /**
     * Returns all parameters defined for a specific rule. This method assumes that the semantic element of 
     * passed node is of type <code>RuleDeclarationImpl</code>. This must be checked before calling this method.
     * 
     * @param node the <code>INode</code> object of type <code>RuleDeclarationImpl</code> for which the parameters shall be
     * returned. 
     * @return a list of <code>StyledString</code> that includes all rule parameters ready for displaying in the
     * content assist or <b>null</b> if no rule parameters are defined.
     */
    private List<StyledString> getRuleParameters(INode node) {
        List<StyledString> result = null;
        if (node != null) {
            List<Parameter> paramList = getRuleParams(node);
            if (hasElements(paramList)) {
                result = new ArrayList<StyledString>();
                for (Parameter parameter : paramList) {
                    String varName = parameter.getName();
                    String type = getTypeName(parameter.getType());
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
     * Returns all variables defined for a specific rule. This includes also the implicit variables <b>LHS</b> and <b>RHS</b>.
     * This method assumes that the semantic element of passed node is of type <code>RuleDeclarationImpl</code>. This must be 
     * checked before calling this method.
     * 
     * @param node the <code>INode</code> object (last complete node) for which the content assist is called. The semantic 
     * element of this node must be of type <code>RuleDeclarationImpl</code> to determine the variables defined in this rule.
     * @param completeDefsOnly in order to prevent proposals of incomplete variables, i.e. if the user calls the content assist 
     * for completing a variable definition, the incomplete variable(s) must not be proposed (completeDefsOnly = <b>true</b>). 
     * To return all variables of the rule, use <b>false</b>.   
     * @param addLRHS <b>true</b> to add or <b>false</b> to don't add LHS and RHS as a proposal, if necessary. 
     * @return a list of <code>StyledString</code> that includes all rule variables ready for displaying in the content assist
     * or <b>null</b> if no rule variables are defined. 
     */
    private List<StyledString> getRuleVariables(INode node, boolean completeDefsOnly, boolean addLRHS) {
        List<StyledString> result = new ArrayList<StyledString>();
        // First, add the two implicit VIL rule variables
        if (addLRHS) {// TODO: multiple conditions!
            StyledString lhs = new StyledString();
            lhs.append("LHS");
            // TODO: the type of LHS is the return type of the first precondition
            lhs.append(" : <Type?>", StyledString.QUALIFIER_STYLER);
            result.add(lhs);
            StyledString rhs = new StyledString();
            rhs.append("RHS");
            rhs.append(" : <Type?>", StyledString.QUALIFIER_STYLER);
            result.add(rhs);

            StyledString lhsNew = new StyledString();
            lhsNew.append("FROM");
            // TODO: the type of LHS is the return type of the first precondition
            lhsNew.append(" : <Type?>", StyledString.QUALIFIER_STYLER);
            result.add(lhsNew);
            StyledString rhsNew = new StyledString();
            rhsNew.append("TO");
            rhsNew.append(" : <Type?>", StyledString.QUALIFIER_STYLER);
            result.add(rhsNew);         
        }
        // Second, add all declared rule variables 
        if (node != null) {
            List<VariableDeclaration> varDecls = getRuleVars(node);
            if (hasElements(varDecls)) {                
                for (VariableDeclaration varDecl : varDecls) {
                    if (completeDefsOnly) {
                        if (varDecl.getExpression() != null) {
                            String varName = varDecl.getName();
                            String type = getTypeName(varDecl.getType());
                            StyledString displayString = new StyledString();
                            displayString.append(varName);
                            displayString.append(" : " + type, StyledString.QUALIFIER_STYLER);
                            result.add(displayString);                                
                        }
                    } else {
                        String varName = varDecl.getName();
                        String type = getTypeName(varDecl.getType());
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
}
