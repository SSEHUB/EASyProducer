package net.ssehub.easy.reasoning.drools2.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import net.ssehub.easy.reasoning.drools2.model.variables.CompoundVariable;
import net.ssehub.easy.reasoning.drools2.model.variables.ReasonerVariable;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.ModelElement;
import net.ssehub.easy.varModel.model.filter.ConstraintFinder;

/**
 * Part of the {@link ReasonerModel}, which holds all constraints in a structured way.
 * @author El-Sharkawy
 * @author Sizonenko
 *
 */
class ConstraintContainer implements IConstraintContainer {

    private ReasonerModel parent;
    // All normal constraints from the model
    private List<Constraint> normalConstraints;
    // Variables of each normal constraint
    private List<Set<ReasonerVariable>> variablesOfNormalConstraint;
    // Variables of each internal constraint
    private List<Set<ReasonerVariable>> variablesOfInternalConstraint;
    
    
    /**
     * Default constructor for this class.
     * @param parent The {@link ReasonerModel}, which will hold this {@link ConstraintContainer}.
     */
    ConstraintContainer(ReasonerModel parent) {
        this.parent = parent;        
        
        // All normal constraints in the model
        ConstraintFinder consFinder = new ConstraintFinder(parent.getProject());
        normalConstraints = consFinder.getConstraints();
        
        // Determine for each normal constraint, which (toplevel) variables are used
        variablesOfNormalConstraint =
                new ArrayList<Set<ReasonerVariable>>(getNormalConstraintCount());
        for (int i = 0; i < getNormalConstraintCount(); i++) {
            ConstraintSyntaxTree syntax = getNormalConstraint(i);            
            variablesOfNormalConstraint.add(findVariablesUsedInConstraint(syntax));
        }
        
    }
    
    @Override
    public int getNormalConstraintCount() {
        return normalConstraints.size();
    }
    
    @Override
    public ConstraintSyntaxTree getNormalConstraint(int index) {
        return normalConstraints.get(index).getConsSyntax();
    }
    
    @Override
    public Set<ReasonerVariable> getVariablesOfNormalConstraint(int index) {
        return variablesOfNormalConstraint.get(index);
    }  
    
    @Override
    public Set<ReasonerVariable> getVariablesOfInternalConstraint(int index) {
        return variablesOfInternalConstraint.get(index);
    }
    
    @Override
    public int getConstraintCount() {
        return normalConstraints.size();
    }
    
    @Override
    public Set<ReasonerVariable> getVariablesOfConstraint(int index) {
        Set<ReasonerVariable> result = new HashSet<ReasonerVariable>();
        if (index < getNormalConstraintCount()) {
            result = getVariablesOfNormalConstraint(index);
        } else {
            index = getConstraintCount() - index;
            result = getVariablesOfInternalConstraint(index);                    
        }
        return result;
    }
    
    @Override
    public ConstraintSyntaxTree getConstraint(int index) {
        ConstraintSyntaxTree result = null;
        if (index < getNormalConstraintCount()) {
            result = getNormalConstraint(index);
        }
        return result;
    }
    
    @Override
    public ModelElement getConflictingElement(int index) {
        ModelElement result = null;
        if (index < getNormalConstraintCount()) {
            result = normalConstraints.get(index);
        }
        return result;
    }
    
    /**
     * Traverses the constraint and collects all toplevel {@link ReasonerVariable}s, which are used in constraints.     
     * @param constraint {@link ConstraintSyntaxTree} stored in this instance. 
     * @return Set of variables used in this constraint.  
     */
    private Set<ReasonerVariable> findVariablesUsedInConstraint(ConstraintSyntaxTree constraint) {
        Set <ReasonerVariable> variablesInConstraint = new HashSet<ReasonerVariable>();
        VariablesInConstraintsFinder variablesFinder = new VariablesInConstraintsFinder(constraint);
        Set<AbstractVariable> foundVariables = variablesFinder.getVariables();
        for (AbstractVariable abstractVariable : foundVariables) {
            String variableName = abstractVariable.getName();
            ReasonerVariable foundReasonerVariable = parent.getVariable(variableName);
            
            /*
             *  In case of a nested variable (e.g. of a compound), the nested variables will not be stored
             *  in the variables map, and, thus, the result will be null.
             */
            if (null != foundReasonerVariable) {
                variablesInConstraint.add(foundReasonerVariable);
            } else if (abstractVariable.getType().getTypeClass().getSimpleName().equals("DerivedDatatype")) {
                variablesInConstraint.add(findNestedDerivedVariable(abstractVariable));
            }
        }
        return variablesInConstraint;
    }

    /**
     * Method for finding nested derived variables.
     * @param abstractVariable to find.
     * @return {@link ReasonerVariable} found.
     */
    private ReasonerVariable findNestedDerivedVariable(AbstractVariable abstractVariable) {
        ReasonerVariable foundReasonerVariable = null;
        if (abstractVariable.getParent().getClass().getSimpleName().equals("Compound")) { 
            Iterator<ReasonerVariable> varIterator = parent.iterator();
            while (varIterator.hasNext()) {
                ReasonerVariable modelVariable = varIterator.next();
                if (modelVariable.getDecisionVariable().getClass().getSimpleName().equals("CompoundVariable")) {
                    CompoundVariable cmpVar = (CompoundVariable) modelVariable;
                    if (cmpVar.getNestedVariable(abstractVariable.getName()) != null) {
                        foundReasonerVariable = cmpVar.getNestedVariable(abstractVariable.getName());
                    }
                }
                
            }        
            System.out.println(abstractVariable.getType().getTypeClass().getSimpleName().toString());
        }
        return foundReasonerVariable;
    }

}
