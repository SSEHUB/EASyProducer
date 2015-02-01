package de.uni_hildesheim.sse.vil.templatelang.ui.contentassist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.xtext.nodemodel.INode;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;
import de.uni_hildesheim.sse.vil.expressions.ResourceRegistry;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.Parameter;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.VariableDeclaration;
import de.uni_hildesheim.sse.vil.expressions.translation.Utils;
import de.uni_hildesheim.sse.vil.templatelang.templateLang.Stmt;
import de.uni_hildesheim.sse.vil.templatelang.templateLang.VilDef;
import de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.LanguageUnitImpl;
import de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.StmtBlockImpl;
import de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.VilDefImpl;


/**
 * A utility class for determining different elements in the VTL build model based on the
 * more generic information provided by the Xtext UI functionalities (typically EObject, etc.)
 * 
 * @auther dernek
 */
public class TemplateLangProposalProviderUtility {
    
    
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
     * @return <code>List<StyledString></code> with all variables, to show as a proposal.
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
                    String varType = Utils.getQualifiedNameString(var.getType().getName());
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
     * @param the list <code>List<String></code> with the specific types.
     * @return <code>List<StyledString></code> with all variables, to show as a proposal.
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
                    String varType = Utils.getQualifiedNameString(var.getType().getName());
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
     * @return <code>List<StyledString></code> with all variables, to show as a proposal.
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
                    String varType = Utils.getQualifiedNameString(var.getType().getName());
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
                    String varType = Utils.getQualifiedNameString(var.getType().getName());
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
     * @return <code>List<StyledString></code> with all def-Declarations.
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
                                String paramtype = Utils.getQualifiedNameString(param.getType().getName());
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
     * @return <code>List<StyledString></code> with all parameters.
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
                    String varType = Utils.getQualifiedNameString(param.getType().getName());
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
     * @return <code>List<StyledString></code> with all parameters.
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
                    String varType = Utils.getQualifiedNameString(param.getType().getName());
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
    
    /**
     * Returns all VTL-types currently available in EASy-Producer, but may contain duplicate entries.
     * 
     * @param node the <code>INode</code> object (last complete node) for which the content assist is called.
     * @return a list of the names (<code>String</code>) of all types currently registered to EASy-Producer.
     */
    private List<String> getAllTypes(INode node) {
        List<String> allTypes = null;
        TypeRegistry typeRegistry = ResourceRegistry.getTypeRegistry(node);
        if (typeRegistry != null) {
            Iterable<TypeDescriptor<? extends IVilType>> types = typeRegistry.allTypes();
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
        }
        return allTypes;
    }
    
    private List<VariableDeclaration> getVarsInStmtWithType(INode node, List<String> typeList) {
        List<VariableDeclaration> result = null;
        if (node != null) {
            List<VariableDeclaration> allVarList = getVarsInStmt(node);
            if (allVarList != null && !allVarList.isEmpty()) {
                result = new ArrayList<VariableDeclaration>();
                for (String typeStr : typeList) {
                    for (VariableDeclaration var : allVarList) {
                        String varType = Utils.getQualifiedNameString(var.getType().getName());
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
                            String varType = Utils.getQualifiedNameString(var.getType().getName());
                            if (typeStr.equals(varType)) {
                                result.add(var);
                            }
                        }
                    }
                } else {
                    result = new ArrayList<VariableDeclaration>();
                    for (String typeStr : typeList) {
                        for (VariableDeclaration var : allVarList) {
                            String varType = Utils.getQualifiedNameString(var.getType().getName());
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
                result = langUnit.getVars();
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
     * @return <code>List<VilDef></code> with all def-Declarations.
     * Maybe <b>null</b>, if no defs were found.
     */
    private List<VilDef> getDefs(INode node) {
        List<VilDef> result = null;
        if (node != null) {
            if (node.getSemanticElement() instanceof LanguageUnitImpl) {
                LanguageUnitImpl langUnit = (LanguageUnitImpl) node.getSemanticElement();
                result = langUnit.getDefs();
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
     * @return <code>EList<Parameter></code> with all parameters.
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
     * @return <code>EList<Parameter></code> with all parameters.
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
}
