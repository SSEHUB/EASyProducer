package de.uni_hildesheim.sse.easy.ui.confModel;

import java.util.List;

import org.eclipse.swt.widgets.Composite;

import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;
import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.datatypes.AnyType;
import de.uni_hildesheim.sse.model.varModel.datatypes.BooleanType;
import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
import de.uni_hildesheim.sse.model.varModel.datatypes.ConstraintType;
import de.uni_hildesheim.sse.model.varModel.datatypes.DerivedDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.Enum;
import de.uni_hildesheim.sse.model.varModel.datatypes.EnumLiteral;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatypeVisitor;
import de.uni_hildesheim.sse.model.varModel.datatypes.IntegerType;
import de.uni_hildesheim.sse.model.varModel.datatypes.MetaType;
import de.uni_hildesheim.sse.model.varModel.datatypes.OrderedEnum;
import de.uni_hildesheim.sse.model.varModel.datatypes.RealType;
import de.uni_hildesheim.sse.model.varModel.datatypes.Reference;
import de.uni_hildesheim.sse.model.varModel.datatypes.Sequence;
import de.uni_hildesheim.sse.model.varModel.datatypes.Set;
import de.uni_hildesheim.sse.model.varModel.datatypes.StringType;
import de.uni_hildesheim.sse.model.varModel.filter.DeclarationFinder;
import de.uni_hildesheim.sse.model.varModel.filter.DeclarationFinder.VisibilityType;
import de.uni_hildesheim.sse.model.varModel.filter.FilterType;
/**
 * Creates a {@link GUIVariable} for a given {@link IDecisionVariable}.
 * @author El-Sharkawy
 *
 */
class GUIValueFactory {
    
    /**
     * Part of the {@link GUIValueFactory} for creating a {@link GUIVariable}.
     * @author El-Sharkawy
     *
     */
    private static class VariableVisitor implements IDatatypeVisitor {
        private GUIConfiguration config;
        private GUIVariable resultVariable;
        private Composite parent;
        private IDecisionVariable variable;
        private GUIVariable varParent;
        private IGUIConfigurableElement confParent;
        
        /**
         * Sole constructor for this class.
         * @param variable The {@link IDecisionVariable} represented by this GUIVariable
         * @param parent The controlling composite, needed for the creation of CellEditors
         * @param config The {@link GUIConfiguration} holding this BasisGUIVariable
         * @param varParent The parent GUIVariable holding this variable. Can be <tt>null</tt> if and only if this
         * variable is a top level variable stored inside the configuration.
         */
        private VariableVisitor(IDecisionVariable variable, Composite parent, GUIConfiguration config,
            GUIVariable varParent) {
            
            this.config = config;
            this.variable = variable;
            this.parent = parent;
            this.varParent = varParent;
            confParent = null == varParent ? config : varParent;
            variable.getDeclaration().getType().accept(this);
        }
        
        /**
         * Returns the GUI representation of the given {@link IDecisionVariable}.
         * @return A GUI representation of the {@link IDecisionVariable}
         */
        private GUIVariable getVariable() {
            return resultVariable;
        }

        @Override
        public void visitDatatype(IDatatype datatype) {
            // Not needed
        }

        @Override
        public void visitAnyType(AnyType datatype) {
            // Not needed
        }

        @Override
        public void visitMetaType(MetaType datatype) {
            // Not needed
        }

        @Override
        public void visitConstraintType(ConstraintType datatype) {
            // Will probably not be accessible to the editor
        }
        
        @Override
        public void visitDerivedType(DerivedDatatype datatype) {
            datatype.getBasisType().accept(this);
        }

        @Override
        public void visitSet(Set set) {
            resultVariable = new ContainerGUIVariable(variable, parent, config, varParent);
        }

        @Override
        public void visitSequence(Sequence sequence) {
            resultVariable = new ContainerGUIVariable(variable, parent, config, varParent);
        }

        @Override
        public void visitReference(Reference reference) {
            Project project = (Project) variable.getDeclaration().getTopLevelParent();
            DeclarationFinder finder = new DeclarationFinder(project, FilterType.ALL, reference.getType());
            //TODO SE: check whether VisibilityType.ALL or ONLY Exported must be used.
            List<AbstractVariable> possibleDeclarations = finder.getVariableDeclarations(VisibilityType.ALL);
            ComboboxGUIVariable.ComboItem[] items = null;
            
            if (possibleDeclarations.size() > 0) {
                items = new ComboboxGUIVariable.ComboItem[possibleDeclarations.size()];
                for (int i = 0; i < possibleDeclarations.size(); i++) {
                    AbstractVariable declaration = possibleDeclarations.get(i);
                    String name = declaration.getUniqueName();
                    items[i] = new ComboboxGUIVariable.ComboItem(name, declaration);
                    
                }
            }
            resultVariable = new ComboboxGUIVariable(variable, parent, reference, items, confParent);
        }

        @Override
        public void visitBooleanType(BooleanType type) {
            ComboboxGUIVariable.ComboItem[] items = new ComboboxGUIVariable.ComboItem[2];
            items[0] = new ComboboxGUIVariable.ComboItem("true", true);
            items[1] = new ComboboxGUIVariable.ComboItem("false", false);
            
            resultVariable = new ComboboxGUIVariable(variable, parent, type, items, confParent);
        }

        @Override
        public void visitStringType(StringType type) {
            resultVariable = new BasisGUIVariable(variable, parent, config, varParent);
        }

        @Override
        public void visitIntegerType(IntegerType type) {
            resultVariable = new BasisGUIVariable(variable, parent, config, varParent);
        }

        @Override
        public void visitRealType(RealType type) {
            resultVariable = new BasisGUIVariable(variable, parent, config, varParent);
        }

        @Override
        public void visitCompoundType(Compound compound) {
            resultVariable = new CompoundGUIVariable(variable, parent, config, varParent);
        }

        @Override
        public void visitEnumType(Enum enumType) {
            ComboboxGUIVariable.ComboItem[] items = null;
            if (enumType.getLiteralCount() > 0) {
                items = new ComboboxGUIVariable.ComboItem[enumType.getLiteralCount()];
                for (int i = 0; i < items.length; i++) {
                    EnumLiteral literal = enumType.getLiteral(i);
                    String literalName = literal.getName();
                    items[i] = new ComboboxGUIVariable.ComboItem(literalName, literal);
                }
            }
            resultVariable = new ComboboxGUIVariable(variable, parent, enumType, items, confParent);
        }

        @Override
        public void visitOrderedEnumType(OrderedEnum enumType) {
            visitEnumType(enumType);
        }
        
    }
    
    /**
     * Creates a new {@link GUIVariable}.
     * @param variable The {@link IDecisionVariable} represented by this GUIVariable
     * @param parent The controlling composite, needed for the creation of CellEditors
     * @param config The {@link GUIConfiguration} holding this BasisGUIVariable
     * @param varParent The parent GUIVariable holding this variable. Can be <tt>null</tt> if and only if this variable
     * is a top level variable stored inside the configuration.
     * @return A GUI representation of the {@link IDecisionVariable}
     */
    static GUIVariable createVariable(IDecisionVariable variable, Composite parent, GUIConfiguration config,
        GUIVariable varParent) {
        
        VariableVisitor visitor = new VariableVisitor(variable, parent, config, varParent); 
        return visitor.getVariable();
    }

}
