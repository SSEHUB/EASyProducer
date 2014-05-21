package de.uni_hildesheim.sse.model.varModel;

import de.uni_hildesheim.sse.model.varModel.datatypes.DerivedDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.Enum;
import de.uni_hildesheim.sse.model.varModel.datatypes.EnumLiteral;
import de.uni_hildesheim.sse.model.varModel.datatypes.OrderedEnum;
import de.uni_hildesheim.sse.model.varModel.datatypes.Reference;
import de.uni_hildesheim.sse.model.varModel.datatypes.Sequence;
import de.uni_hildesheim.sse.model.varModel.datatypes.Set;

/**
 * This class provides some methods to access statistical information about a given project.
 * 
 * @author Holger Eichelberger
 */
public class ModelStatistics {

    private int constraintsCount = 0;
    private int variablesCount = 0;
    private int declaredDataTypesCount = 0;

    /**
     * Creates a new model statistics object. Please note that we explicitly separated
     * the creation of this object from the {@link #collect(Project) collection of data}
     * as we expect further, more complex statistical operations on subelements (such as 
     * the average depth of constraint trees) which shall explicitly be enabled before
     * data collection.
     */
    public ModelStatistics() {
    }
    
    /**
     * Collects statistics about <code>project</code>.
     * 
     * @param project the project to collect statistics about
     */
    public void collect(Project project) {
        project.accept(new StatisticsVisitor());
    }

    /**
     * Visits the elements in the given project. Note, that currently only basic elements are considered.
     * 
     * @author Holger Eichelberger
     */
    private class StatisticsVisitor extends AbstractVisitor {

        /**
         * {@inheritDoc}
         */
        public void visitEnum(Enum eenum) {
            declaredDataTypesCount++;
            super.visitEnum(eenum);
        }

        /**
         * {@inheritDoc}
         */
        public void visitOrderedEnum(OrderedEnum eenum) {
            declaredDataTypesCount++;
            super.visitOrderedEnum(eenum);
        }

        /**
         * {@inheritDoc}
         */
        public void visitDerivedDatatype(DerivedDatatype datatype) {
            declaredDataTypesCount++;
        }

        /**
         * {@inheritDoc}
         */
        public void visitEnumLiteral(EnumLiteral literal) {
        }

        /**
         * {@inheritDoc}
         */
        public void visitReference(Reference reference) {
            declaredDataTypesCount++;
        }

        /**
         * {@inheritDoc}
         */
        public void visitSequence(Sequence sequence) {
            declaredDataTypesCount++;
        }

        /**
         * {@inheritDoc}
         */
        public void visitSet(Set set) {
            declaredDataTypesCount++;
        }

        /**
         * {@inheritDoc}
         */
        public void visitProjectImport(ProjectImport pImport) {
        }

        /**
         * {@inheritDoc}
         */
        public void visitDecisionVariableDeclaration(DecisionVariableDeclaration decl) {
            variablesCount++;
        }

        /**
         * {@inheritDoc}
         */
        public void visitAttribute(Attribute attribute) {
        }

        /**
         * {@inheritDoc}
         */
        public void visitConstraint(Constraint constraint) {
            constraintsCount++;
        }

        /**
         * {@inheritDoc}
         */
        public void visitFreezeBlock(FreezeBlock freeze) {
        }

        /**
         * {@inheritDoc}
         */
        public void visitOperationDefinition(OperationDefinition opdef) {
        }

        /**
         * {@inheritDoc}
         */
        public void visitPartialEvaluationBlock(PartialEvaluationBlock block) {
        }

        /**
         * {@inheritDoc}
         */
        public void visitProjectInterface(ProjectInterface iface) {
        }


        /**
         * {@inheritDoc}
         */
        public void visitComment(Comment comment) {
        }
    
        
        /**
         * {@inheritDoc}
         */
        public void visitAttributeAssignment(AttributeAssignment assignment) {
        }

    }

    /**
     * Returns the number of declared constraints.
     * 
     * @return the number of declared constraints
     */
    public int getDeclaredConstraintsCount() {
        return constraintsCount;
    }

    /**
     * Returns the number of declared decision variables.
     * 
     * @return the number of declared decision variables
     */
    public int getDeclaredVariablesCount() {
        return variablesCount;
    }

    /**
     * Returns the number of declared data types.
     * 
     * @return the number of declared data types
     */
    protected int getDeclaredDataTypesCount() {
        return declaredDataTypesCount;
    }

}
