package de.uni_hildesheim.sse.reasoning.core.model.datatypes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.CustomDatatype;
import net.ssehub.easy.varModel.model.datatypes.Reference;
import net.ssehub.easy.varModel.model.filter.DeclarationFinder;
import net.ssehub.easy.varModel.model.filter.FilterType;
import net.ssehub.easy.varModel.model.filter.DeclarationFinder.VisibilityType;

/**
 * Representation of {@link Reference} type.
 * @author Sizonenko
 * @author El-Sharkawy
 */
public class ReferenceType extends ReasonerDatatype {

    private Set<String> possibleVariablesSet;
    private List<String> possibleVariablesList;
    
    /**
     * Constructor for {@link ReferenceType}.
     * @param type An object passed to the constructor.
     * @param project {@link Project} on which reasoning is taking place.
     */
    ReferenceType(CustomDatatype type, Project project) {
        super(type);
        possibleVariablesSet = new HashSet<String>();
        Reference refType = (Reference) type;
        DeclarationFinder finder = new DeclarationFinder(project, FilterType.ALL, refType.getType());
        List<AbstractVariable> abstractVariableList = finder.getVariableDeclarations(VisibilityType.ALL);
        for (int i = 0; i < abstractVariableList.size(); i++) {
            possibleVariablesSet.add(abstractVariableList.get(i).getName());            
        }
        possibleVariablesList = new ArrayList<String>();
        possibleVariablesList.addAll(possibleVariablesSet);
    }
    
    /**
     * Method to retrieve number of elements in the reference.
     * @return Size of the list of Variables.
     */
    public int getPossibleNameCount() {
        return possibleVariablesList.size();
    }
    
    /**
     * Method to retrieve value from a specific index in the list.
     * @param index Numeric value to identify index in the List.
     * @return Variable from a given index.
     */
    public String getPossibleName(int index) {
        return possibleVariablesList.get(index);
    }
    
    /**
     * Method to validate if a variable exists in the List.
     * @param name Name of the variable.
     * @return Returns <b>true</b> if value exists in the List.
     */
    public boolean isValidName(String name) {
        return possibleVariablesSet.contains(name);
    }
    
    @Override
    public Reference getType() {
        return (Reference) super.getType();
    }   

    @Override
    public void accept(IReasonerTypeVisitor visitor) {
        visitor.visitRefernceType(this);
    }
}
