package de.uni_hildesheim.sse.vil.templatelang.ui.contentassist;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.xtext.nodemodel.INode;

import de.uni_hildesheim.sse.vil.expressions.expressionDsl.Parameter;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.VariableDeclaration;
import de.uni_hildesheim.sse.vil.expressions.translation.ModelTranslator;
import de.uni_hildesheim.sse.vil.expressions.ui.contentassist.ExpressionDslProposalProviderUtility;
import de.uni_hildesheim.sse.vil.templatelang.templateLang.LanguageUnit;
import de.uni_hildesheim.sse.vil.templatelang.templateLang.Stmt;
import de.uni_hildesheim.sse.vil.templatelang.templateLang.StmtBlock;
import de.uni_hildesheim.sse.vil.templatelang.templateLang.VilDef;
import de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.LanguageUnitImpl;
import de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.StmtBlockImpl;
import de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.VilDefImpl;

/**
 * A utility class for determining different elements in the VTL build model based on the
 * more generic information provided by the Xtext UI functionalities (typically EObject, etc.)
 * 
 * @author dernek
 */
public class TemplateLangProposalProviderUtility extends ExpressionDslProposalProviderUtility {
    
    
    /**
     * The current instance of the utility class. Prevent parallel access to the parse tree.
     */
    public static final TemplateLangProposalProviderUtility INSTANCE = new TemplateLangProposalProviderUtility();
    
    /**
     * prevents external creation.
     */
    public TemplateLangProposalProviderUtility() {
    }
    
    /**
     * Returns all variables inside of a statement, ready to display as a proposal.
     * @param node the last complete node, when the content-assist is used.
     * @return <code>List&lt;StyledString&gt;</code> with all variables, to show as a proposal.
     * Maybe <b>null</b>, if no variables were found.
     */
    public List<StyledString> getAllVarsInStmt(INode node) {
        List<StyledString> result = null;
        if (node != null) {
            List<VariableDeclaration> varList = getVarsInStmt(node);
            if (varList != null) {
                result = new ArrayList<StyledString>();
                for (VariableDeclaration var : varList) {
                    StyledString str = new StyledString(var.getName());
                    String varType = getTypeName(var.getType());
                    str.append(" : " + varType, StyledString.QUALIFIER_STYLER);
                    result.add(str);
                }
            }
            // Add script-variables too
            List <StyledString> scriptVars = getAllVarsInLangUnit(node);
            if (scriptVars != null && !scriptVars.isEmpty()) {
                if (result != null) {
                    result.addAll(scriptVars);            
                } else {
                    result = new ArrayList<StyledString>();
                    result.addAll(scriptVars);
                }
            }
        }
        return result;
    }
    
    /**
     * Returns all variables inside of a statement, which have a specific type, ready to display as a proposal.
     * @param node the last complete node, when the content-assist is used.
     * @param typeList the list <code>List&lt;String&gt;</code> with the specific types.
     * @return <code>List&lt;StyledString&gt;</code> with all variables, to show as a proposal.
     * Maybe <b>null</b>, if no variables were found.
     */
    public List<StyledString> getAllVarsInStmtWithType(INode node, List<String> typeList) {
        List<StyledString> result = null;
        if (node != null) {
            List<VariableDeclaration> varList = getVarsInStmtWithType(node, typeList);
            if (varList != null) {
                result = new ArrayList<StyledString>();
                for (VariableDeclaration var : varList) {
                    StyledString str = new StyledString(var.getName());
                    String varType = getTypeName(var.getType());
                    str.append(" : " + varType, StyledString.QUALIFIER_STYLER);
                    result.add(str);
                }
            }
            // Add script-variables too
            List <StyledString> scriptVars = getAllVarsInLangUnitWithType(node, typeList);
            if (scriptVars != null && !scriptVars.isEmpty()) {
                if (result != null) {
                    result.addAll(scriptVars);
                } else {
                    result = new ArrayList<StyledString>();
                    result.addAll(scriptVars);
                }
            }
            
        }
        return result;
    }
    
    /**
     * Returns all variables inside of the LanguageUnit, ready to display as a proposal.
     * @param node the last complete node, when the content-assist is used.
     * @return <code>List&lt;StyledString&gt;</code> with all variables, to show as a proposal.
     * Maybe <b>null</b>, if no variables were found.
     */
    public List<StyledString> getAllVarsInLangUnit(INode node) {
        List<StyledString> result = null;
        if (node != null) {
            List<VariableDeclaration> varList = getVarsInLangUnit(node);
            if (varList != null) {
                result = new ArrayList<StyledString>();
                for (VariableDeclaration var : varList) {
                    StyledString str = new StyledString(var.getName());
                    String varType = getTypeName(var.getType());
                    str.append(" : " + varType, StyledString.QUALIFIER_STYLER);
                    result.add(str); 
                }
            }
        }
        return result;
    }
    
    public List<StyledString> getAllVarsInLangUnitWithType(INode node, List<String> typeList) {
        List<StyledString> result = null;
        if (node != null) {
            List<VariableDeclaration> varList = getVarsInStmtWithType(node, typeList);
            if (varList != null) {
                result = new ArrayList<StyledString>();
                for (VariableDeclaration var : varList) {
                    StyledString str = new StyledString(var.getName());
                    String varType = getTypeName(var.getType());
                    str.append(" : " + varType, StyledString.QUALIFIER_STYLER);
                    result.add(str);
                }
            }
        }
        return result;
    }
    
    /**
     * Returns all def-Declarations inside of the VTL-Script, ready to display as a propose.
     * This method should only be used inside of a def-declaration, because proposing the defs outside of the declaration makes no sense.
     * The method removes automatically the def-declaration in which the method is used. 
     * @param node the last complete node.
     * @return <code>List&lt;StyledString&gt;</code> with all def-Declarations.
     * Maybe <b>null</b>, if no defs were found.
     */
    public List<StyledString> getAllDefs(INode node) {
        List<StyledString> result = null;
        if (node != null) {
            List<VilDef> defList = getDefs(node);
            VilDefImpl defItself = findDefDeclaration(node);
            if (defList != null && defItself != null) {
                result = new ArrayList<StyledString>();
                for (VilDef def : defList) {
                    //removes itself by name-matching
                    if (!def.getId().equals(defItself.getId())) {
                        boolean addedParam = false;
                        StyledString str = new StyledString(def.getId() + "(");
                        if (def.getParam() != null && def.getParam().getParam() != null &&
                                !def.getParam().getParam().isEmpty()) {
                            EList<Parameter> paramList = def.getParam().getParam();
                            for (Parameter param : paramList) {
                                String paramtype = getTypeName(param.getType());
                                str.append(paramtype + " " + param.getName() + ", ");
                                addedParam = true;
                            }
                        }
                        if (addedParam) {
                            str = new StyledString(str.getString().substring(0, str.getString().length() -2));
                        }
                        if (def.getType() == null) {
                            str.append(") : void");
                        } else {
                            String returntype = def.getType().getName().getQname().get(0);
                            str.append(") : " + returntype);
                        }
                        result.add(str);
                    }
                }
            }
        }
        return result;
    }
    
    /**
     * Returns all parameters from a def-Declaration, ready to display as a propose.
     * This method should only be called inside of a def-Declaration.
     * @param node the last complete node.
     * @return <code>List&lt;StyledString&gt;</code> with all parameters.
     * Maybe <b>null</b>, if no parameters were found.
     */
    public List<StyledString> getAllParamsFromDef(INode node) {
        List<StyledString> result = null;
        if (node != null) {
            EList<Parameter> paramList = getParamsFromDef(node);
            if (paramList != null) {
                result = new ArrayList<StyledString>();
                for (Parameter param : paramList) {
                    StyledString str = new StyledString(param.getName());
                    String varType = getTypeName(param.getType());
                    str.append(" : " + varType, StyledString.QUALIFIER_STYLER);
                    result.add(str); 
                }
            }
        }
        return result;
    }
    
    /**
     * Returns all parameters from the VTL-Template, ready to display as a propose.
     * @param node the last complete node.
     * @return <code>List&lt;StyledString&gt;</code> with all parameters.
     * Maybe <b>null</b>, if no parameters were found.
     */
    public List<StyledString> getAllParamsFromTemplate(INode node) {
        List<StyledString> result = null;
        if (node != null) {
            EList<Parameter> paramList = getParamsFromTemplate(node);
            if (paramList != null) {
                result = new ArrayList<StyledString>();
                for (Parameter param : paramList) {
                    StyledString str = new StyledString(param.getName());
                    String varType = getTypeName(param.getType());
                    str.append(" : " + varType, StyledString.QUALIFIER_STYLER);
                    result.add(str); 
                }
            }
        }
        return result;
    }
    
    /**
     * Returns all VTL-types currently available in EASy-Producer.
     * 
     * @param node the <code>INode</code> object (last complete node) for which the content assist is called.
     * @return a list of the names (<code>String</code>) of all types currently registered to EASy-Producer.
     */
    public List<String> getAllRegisteredTypes(INode node) {
        List<String> result = null;
        result = TemplateLangProposalProviderUtility.INSTANCE.getAllTypes(node);
        Set<String> listSet = new LinkedHashSet<String>(result);
        result = new LinkedList<String>();
        result.addAll(0, listSet);
        return result;
    }
    
    private List<VariableDeclaration> getVarsInStmtWithType(INode node, List<String> typeList) {
        List<VariableDeclaration> result = null;
        if (node != null) {
            List<VariableDeclaration> allVarList = getVarsInStmt(node);
            if (allVarList != null && !allVarList.isEmpty()) {
                result = new ArrayList<VariableDeclaration>();
                for (String typeStr : typeList) {
                    for (VariableDeclaration var : allVarList) {
                        String varType = getTypeName(var.getType());
                        if (typeStr.equals(varType)) {
                            result.add(var);
                        }
                    }
                }
            }
            // add script-vars
            allVarList = getVarsInLangUnit(node);
            if (allVarList != null && !allVarList.isEmpty()) {
                if (result != null) {
                    for (String typeStr : typeList) {
                        for (VariableDeclaration var : allVarList) {
                            String varType = getTypeName(var.getType());
                            if (typeStr.equals(varType)) {
                                result.add(var);
                            }
                        }
                    }
                } else {
                    result = new ArrayList<VariableDeclaration>();
                    for (String typeStr : typeList) {
                        for (VariableDeclaration var : allVarList) {
                            String varType = getTypeName(var.getType());
                            if (typeStr.equals(varType)) {
                                result.add(var);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
    
    /**
     * Returns a list with all VariableDeclaration inside of a statement and all from tiers above.
     * @param node the last complete node, when the content-assist is used.
     * @return a list with all VariableDeclarations. Maybe <b>null</b>, if no variables were found.
     */
    private List<VariableDeclaration> getVarsInStmt(INode node) {
        List<VariableDeclaration> result = null;
        if (node != null) {
            if (node.getSemanticElement() instanceof StmtBlockImpl) {
                StmtBlockImpl stmtBlock = (StmtBlockImpl) node.getSemanticElement();
                EList<Stmt> stmtList = stmtBlock.getStmts();
                if (stmtList != null && !stmtList.isEmpty()) {
                    result = new ArrayList<VariableDeclaration>();
                    for (Stmt stmt : stmtList) {
                        VariableDeclaration varDecl = stmt.getVar();
                        if (varDecl != null) {
                            result.add(varDecl);
                        }
                    }
                    INode parentNode = node.getParent();
                    if (parentNode != null) {
                        List<VariableDeclaration> upperList = getVarsInStmt(parentNode);
                        if (upperList != null) {
                            result.addAll(getVarsInStmt(parentNode));     
                        }
                    }
                }
            } else {
                INode parentnode = node.getParent();
                if (parentnode != null) {
                    result = getVarsInStmt(parentnode);
                }
            }
        }     
        return result;
    }
    
    /**
     * Returns a list with all VariableDeclaration inside of the LanguageUnit.
     * This means all variables, which aren't in defs for example.
     * @param node the last complete node, when the content-assist is used.
     * @return a list with all VariableDeclarations. Maybe <b>null</b>, if no variables were found.
     */
    private List<VariableDeclaration> getVarsInLangUnit(INode node) {
        List<VariableDeclaration> result = null;
        if (node != null) {
            if (node.getSemanticElement() instanceof LanguageUnitImpl) {
                LanguageUnitImpl langUnit = (LanguageUnitImpl) node.getSemanticElement();
                result = ModelTranslator.select(langUnit.getElements(), VariableDeclaration.class);
            } else {
                INode parentNode = node.getParent();
                if (parentNode != null) {
                    result = getVarsInLangUnit(parentNode);
                }
            }
        }
        return result;
    }
    
    /**
     * Returns a list with all def-Declarations inside of an VTL-Script.
     * @param node the last complete node.
     * @return <code>List&lt;VilDef&gt;</code> with all def-Declarations.
     * Maybe <b>null</b>, if no defs were found.
     */
    private List<VilDef> getDefs(INode node) {
        List<VilDef> result = null;
        if (node != null) {
            if (node.getSemanticElement() instanceof LanguageUnitImpl) {
                LanguageUnitImpl langUnit = (LanguageUnitImpl) node.getSemanticElement();
                result = ModelTranslator.select(langUnit.getElements(), VilDef.class);
            } else {
                INode parentNode = node.getParent();
                if (parentNode != null) {
                    result = getDefs(parentNode);
                }
            }
        }
        return result;
    }
    
    /**
     * finds the <code>VilDefImpl</code> object inside of a statement.
     * @param node the last complete node.
     * @return the <code>VilDefImpl</code> object, when you are inside of the def-declaration.
     * Maybe <b>null</b>, if it's not found. Be sure you are using this method only inside of a def-declaration.
     */
    private VilDefImpl findDefDeclaration(INode node) {
        VilDefImpl result = null;
        if (node != null) {
            if (node.getSemanticElement() instanceof VilDefImpl) {
                result = (VilDefImpl) node.getSemanticElement();
            } else {
                INode parentNode = node.getParent();
                if (parentNode != null) {
                    result = findDefDeclaration(parentNode);
                }
            }
        }
        return result;
    }
    
    /**
     * Returns a list with all parameters the def-Declaration have.
     * @param node the last complete node.
     * @return <code>EList&lt;Parameter&gt;</code> with all parameters.
     * Maybe <b>null</b>, if no parameters were found.
     */
    private EList<Parameter> getParamsFromDef(INode node) {
        EList<Parameter> result = null;
        if (node != null) {
            if (node.getSemanticElement() instanceof VilDefImpl) {
                VilDefImpl def = (VilDefImpl) node.getSemanticElement();
                if (def.getParam() != null && def.getParam().getParam() != null &&
                        !def.getParam().getParam().isEmpty()) {
                    result = def.getParam().getParam();
                }
            } else {
                INode parentNode = node.getParent();
                if (parentNode != null) {
                    result = getParamsFromDef(parentNode);
                }
            }
        }
        return result;
    }
    
    /**
     * Returns a list with all parameters the template have.
     * @param node the last complete node.
     * @return <code>EList&lt;Parameter&gt;</code> with all parameters.
     * Maybe <b>null</b>, if no parameters were found.
     */
    private EList<Parameter> getParamsFromTemplate(INode node) {
        EList<Parameter> result = null;
        if (node != null) {
            if (node.getSemanticElement() instanceof LanguageUnitImpl) {
                LanguageUnitImpl langUnit = (LanguageUnitImpl) node.getSemanticElement();
                if (langUnit.getParam() != null && langUnit.getParam().getParam() != null &&
                        !langUnit.getParam().getParam().isEmpty()) {
                    result = langUnit.getParam().getParam();
                }
            } else {
                INode parentNode = node.getParent();
                if (parentNode != null) {
                    result = getParamsFromTemplate(parentNode);
                }
            }
        }
        return result;
    }
    
    @Override
    protected String getMatchingType(INode node, String id) {
        String typeName = "";
        if (node != null && id != null && !id.isEmpty()) {
            INode parent = node.getParent();
            if (parent != null) {
                EObject parentSemanticElement = parent.getSemanticElement();
                while (parentSemanticElement instanceof StmtBlock) {
                    parentSemanticElement = parentSemanticElement.eContainer();
                }
                if (parentSemanticElement instanceof VilDef) {
                    VilDef def = (VilDef) parentSemanticElement;
                    typeName = getType(def, id);
                }
                if (parentSemanticElement instanceof LanguageUnit) {
                    typeName = getType((LanguageUnit) parentSemanticElement, id);
                }
                // might be further alternatives
                if (typeName.isEmpty()) {
                    typeName = getMatchingType(parent, id);
                    // If no element was found - even after complete recursion - try to find an operation with this name
                    if (typeName.isEmpty()) {
                        typeName = getReturnType(id, node);
                    }
                }
            }
        }            
        return typeName; // preliminary
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
                List<VilDef> defs = getAllDefs(script);
                if (hasElements(defs)) {
                    for (VilDef def : defs) {
                        if (def.getId() != null && def.getId().equals(name) && def.getType() != null) {
                            typeName = getTypeName(def.getType());
                        }
                    }
                }
            }
            
            // TODO extend this to searches in parent-script, imports 
        }
        return typeName;
    }

    /**
     * Get the name of the type of an VTL element based on the name (identifier) of this element.
     * 
     * @param defDecl <code>VilDef</code> the parent-rule in which the element of interest is used in.
     * @param name <code>String</code> the name of the element as a string for which the type will be determined.
     * @return <code>String</code> the name of the type of the VTL element or an empty <code>String</code> if the type
     * could not be determined. Never <b>null</b>.
     */
    private String getType(VilDef defDecl, String name) {
        String typeName = "";
        if (defDecl != null && !name.isEmpty()) {
            // Check if declaration of the element identified by "name" is part of the rule element block 
            typeName = getType(defDecl.getStmts(), name);
            // Otherwise, check if the element is a rule parameter
            if (typeName.isEmpty() && null != defDecl.getParam() 
                && hasElements(defDecl.getParam().getParam())) {
                EList<Parameter> ruleParameters = defDecl.getParam().getParam();
                for (Parameter param : ruleParameters) {
                    if (param != null && param.getName().equals(name)) {
                        typeName = getTypeName(param.getType()); 
                    }
                }   
            }                
        }
        return typeName;
    }

    /**
     * Get the name of the type of an VIL element based on the name (identifier) of this element.
     * 
     * @param stmtBlock the statement block
     * @param name <code>String</code> the name of the element as a string for which the type will be determined.
     * @return <code>String</code> name of the type of the VTL element or an empty <code>String</code> if the type
     * could not be determined. Never <b>null</b>.
     */
    private String getType(StmtBlock stmtBlock, String name) {
        String typeName = "";
        if (hasElements(stmtBlock) && name != null && !name.isEmpty()) {
            for (int i = 0; i < stmtBlock.getStmts().size(); i++) {
                Stmt stmt = stmtBlock.getStmts().get(i);
                if (stmt.getVar() != null) {
                    VariableDeclaration varDecl = stmt.getVar();
                    if (varDecl.getName().equals(name)) {
                        typeName = getTypeName(varDecl.getType());                        
                    }
                }
            }
        }
        return typeName;
    }

    /**
     * Checks if the statement block has at least one statement or not.
     * 
     * @param stmtBlock the statement block
     * @return <b>true</b> if it has at least one statement, <b>false</b> otherwise.
     */
    private boolean hasElements(StmtBlock stmtBlock) {
        return stmtBlock != null
            && stmtBlock.getStmts() != null
            && !stmtBlock.getStmts().isEmpty();
    }
    
    /**
     * Returns a list of all <code>VariableDeclaration</code> objects defined in the current VTL-script.
     * 
     * @param unit the <code>LanguageUnit</code> object which represents the active VTL-script currently in use.
     * @return a list of <code>VariableDeclaration</code> objects or <b>null</b> if no such object can be found.
     */
    private List<VariableDeclaration> getAllVariables(LanguageUnit unit) {
        List<VariableDeclaration> variableList = null;
        EList<EObject> elts = unit.getElements();
        if (hasElements(elts)) {
            variableList = new ArrayList<VariableDeclaration>();
            for (EObject element : elts) {
                if (element != null && element instanceof VariableDeclaration) {
                    variableList.add((VariableDeclaration) element);
                }
            }
        }
        return variableList;
    }
    
    /**
     * Returns a list of all <code>VilDef</code> objects defined in the current VTL-script.
     * 
     * @param unit the <code>LanguageUnit</code> object which represents the active VTL-script currently in use.
     * @return a list of <code>VilDef</code> objects or <b>null</b> if no such object can be found.
     */
    private List<VilDef> getAllDefs(LanguageUnit unit) {
        List<VilDef> ruleList = null;
        EList<EObject> elts = unit.getElements();
        if (hasElements(elts)) {
            ruleList = new ArrayList<VilDef>();
            for (EObject element : elts) {
                if (element != null && element instanceof VilDef) {
                    ruleList.add((VilDef) element);
                }
            }
        }
        return ruleList;
    }


}
