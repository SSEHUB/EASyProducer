package de.uni_hildesheim.sse.reasoning.chocoreasoner.implementation.mapping;

import static choco.Choco.makeIntVar;

import java.util.HashMap;
import java.util.Properties;

import choco.cp.model.CPModel;
import choco.kernel.model.Model;
import choco.kernel.model.variables.Variable;
import choco.kernel.model.variables.integer.IntegerVariable;
import de.uni_hildesheim.sse.model.varModel.Attribute;
import de.uni_hildesheim.sse.model.varModel.Constraint;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.FreezeBlock;
import de.uni_hildesheim.sse.model.varModel.IModelVisitor;
import de.uni_hildesheim.sse.model.varModel.OperationDefinition;
import de.uni_hildesheim.sse.model.varModel.PartialEvaluationBlock;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.ProjectImport;
import de.uni_hildesheim.sse.model.varModel.ProjectInterface;
import de.uni_hildesheim.sse.model.varModel.VarModel;
import de.uni_hildesheim.sse.model.varModel.Version;
import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
import de.uni_hildesheim.sse.model.varModel.datatypes.DerivedDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.Enum;
import de.uni_hildesheim.sse.model.varModel.datatypes.EnumLiteral;
import de.uni_hildesheim.sse.model.varModel.datatypes.OrderedEnum;
import de.uni_hildesheim.sse.model.varModel.datatypes.Reference;
import de.uni_hildesheim.sse.model.varModel.datatypes.Sequence;
import de.uni_hildesheim.sse.model.varModel.datatypes.Set;

/**
 * This class visits the projects and creates {@link Constraint}s and {@link Variable}s for the choco reasoner.
 * @author El-Sharkawy
 *
 */
public class ProjectVisitor implements IModelVisitor {
    //Constants
    private static final int MAX_VAL = 2500;
    private static final int MIN_VAL = -1 * MAX_VAL;
    private static final String ENUM_CONSTS_PREFIX = "EnumConstValue ";
    
    //Variables
    //Unclear whether this map is really needed.
    private HashMap<String, Properties> propertiesMap;
    //Stored the relation between the name of the variable and the choco variable
    private HashMap<String, Variable> variablesMap;
    private Model model;
    
    /**
     * Sole constructor for this class. <br/>
     * Visits the hole project and copies for reasoning needed elements into the model.
     * This model is needed for reasoning
     * @param project The project which should be checked during the next reasoning steps.
     */
    public ProjectVisitor(Project project) {
        variablesMap = new HashMap<String, Variable>();
        propertiesMap = new HashMap<String, Properties>();
        model = new CPModel();
        
        //Start visiting
        project.accept(this);
    }
    
    /**
     * Stores the name of the variable and the related choco variables inside the model and the hashmap. 
     * @param variableName The name of the variable
     * @param chocoVariable The related translated choco variable.
     */
    private void storeVariable(String variableName, Variable chocoVariable) {
        variablesMap.put(variableName, chocoVariable);
        model.addVariable(chocoVariable);
    }

    @Override
    public void visitEnum(Enum eenum) {
        StringBuffer name = new StringBuffer(ENUM_CONSTS_PREFIX);
        name.append(eenum.getName());
        name.append(" ");
        //TODO SE: Check whether we really need this lopp and its content
        for (int i = 0; i < eenum.getLiteralCount(); i++) {
            EnumLiteral literal = eenum.getLiteral(i);

            StringBuffer concreteName = new StringBuffer(name);
            concreteName.append(literal.getName());
            IntegerVariable enumConstValue = makeIntVar(name.toString(), i, i, "cp:enum");
            
            //unclear whether we really need this properties.
            Properties prop = new Properties();
            prop.put("name", eenum.getName());
            prop.put("value", literal.getName());
            prop.put("intValue", i);
            propertiesMap.put(eenum.getName() + " " + i, prop);
            storeVariable(name.toString(), enumConstValue);
            
        }
        
        IntegerVariable enumVar = makeIntVar(name.toString(), 0, eenum.getLiteralCount() - 1, "cp:enum");
        storeVariable(name.toString(), enumVar);
    }

    @Override
    public void visitOrderedEnum(OrderedEnum eenum) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visitCompound(Compound compound) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visitDerivedDatatype(DerivedDatatype datatype) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visitEnumLiteral(EnumLiteral literal) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visitReference(Reference reference) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visitSequence(Sequence sequence) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visitSet(Set set) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visitVarModel(VarModel model) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visitProject(Project project) {
        //TODO SE: handle project imports
        
        //Visit all nested datatype definitions, constraints and variable declarations
        for (int i = 0; i < project.getElementCount(); i++) {
            project.getElement(i).accept(this);
        }

        //Visit all internal constraints, e.g. constraints of instances of a derived datatype
        for (int i = 0; i < project.getInternalConstraintCount(); i++) {
            project.getInternalConstraint(i).accept(this);
        }
    }

    @Override
    public void visitVersion(Version version) {
        //The version of this project can be ignored, since Choco won't need the version for reasoning.
    }

    @Override
    public void visitProjectImport(ProjectImport pImport) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visitDecisionVariableDeclaration(
            DecisionVariableDeclaration decl) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visitAttribute(Attribute attribute) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visitConstraint(Constraint constraint) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visitFreezeBlock(FreezeBlock freeze) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visitOperationDefinition(OperationDefinition opdef) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visitPartialEvaluationBlock(PartialEvaluationBlock block) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visitProjectInterface(ProjectInterface iface) {
        // TODO Auto-generated method stub

    }

}
