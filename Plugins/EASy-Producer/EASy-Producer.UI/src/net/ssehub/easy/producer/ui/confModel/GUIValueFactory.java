package net.ssehub.easy.producer.ui.confModel;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.eclipse.swt.widgets.Composite;

import net.ssehub.easy.varModel.confModel.ConfigQuery;
import net.ssehub.easy.varModel.confModel.DisplayNameProvider;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.model.datatypes.AnyType;
import net.ssehub.easy.varModel.model.datatypes.BooleanType;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.ConstraintType;
import net.ssehub.easy.varModel.model.datatypes.DerivedDatatype;
import net.ssehub.easy.varModel.model.datatypes.Enum;
import net.ssehub.easy.varModel.model.datatypes.EnumLiteral;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.IDatatypeVisitor;
import net.ssehub.easy.varModel.model.datatypes.IntegerType;
import net.ssehub.easy.varModel.model.datatypes.MetaType;
import net.ssehub.easy.varModel.model.datatypes.OrderedEnum;
import net.ssehub.easy.varModel.model.datatypes.RealType;
import net.ssehub.easy.varModel.model.datatypes.Reference;
import net.ssehub.easy.varModel.model.datatypes.Sequence;
import net.ssehub.easy.varModel.model.datatypes.Set;
import net.ssehub.easy.varModel.model.datatypes.StringType;
import net.ssehub.easy.varModel.model.datatypes.VersionType;
import net.ssehub.easy.varModel.model.values.NullValue;
import net.ssehub.easy.varModel.persistency.StringProvider;
/**
 * Creates a {@link GUIVariable} for a given {@link IDecisionVariable}.
 * @author El-Sharkawy
 *
 */
public class GUIValueFactory {
    
    private static boolean createUpdatableCellEditors = false;
    
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
            ComboboxGUIVariable.ComboItem[] items = createComboItems(variable, reference);
            resultVariable = new ComboboxGUIVariable(variable, parent, reference, items, confParent);
        }
        
        @Override
        public void visitBooleanType(BooleanType type) {
            ComboboxGUIVariable.ComboItem[] items = createComboItemArray(variable, 2);
            // never change this sequence :| QM-IConf relies on that
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
                DisplayNameProvider nameProvider = DisplayNameProvider.getInstance();
                items = createComboItemArray(variable, enumType.getLiteralCount());
                for (int i = 0; i < enumType.getLiteralCount(); i++) {
                    EnumLiteral literal = enumType.getLiteral(i);
                    String literalName = nameProvider.getDisplayName(literal);
                    items[i] = new ComboboxGUIVariable.ComboItem(literalName, literal);
                }
            }
            resultVariable = new ComboboxGUIVariable(variable, parent, enumType, items, confParent);
        }

        @Override
        public void visitOrderedEnumType(OrderedEnum enumType) {
            visitEnumType(enumType);
        }

        @Override
        public void visitVersionType(VersionType type) {
            // Actually not needed as this cannot occur as a type of a variable
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
    public static GUIVariable createVariable(IDecisionVariable variable, Composite parent, GUIConfiguration config,
        GUIVariable varParent) {
        
        VariableVisitor visitor = new VariableVisitor(variable, parent, config, varParent); 
        return visitor.getVariable();
    }

    /**
     * Creates the array for combobox items and pre-assigns the null value if required via 
     * {@link DisplayNameProvider#enableNullValueInConfiguration(IDecisionVariable)}. The caller may
     * utilize the result until <code>length</code> but not further.
     * 
     * @param variable the variable to create the combo items for
     * @param length the length of the array to be created (except for null value entries)
     * @return the created array
     */
    private static ComboboxGUIVariable.ComboItem[] createComboItemArray(IDecisionVariable variable, int length) {
        DisplayNameProvider nameProvider = DisplayNameProvider.getInstance();
        boolean enableNullValue = nameProvider.enableNullValueInConfiguration(variable);
        if (enableNullValue) {
            length++;
        }
        ComboboxGUIVariable.ComboItem[] result = new ComboboxGUIVariable.ComboItem[length];
        if (enableNullValue) {
            result[length - 1] = new ComboboxGUIVariable.ComboItem(nameProvider.getNullName(variable), 
                NullValue.INSTANCE);
        }
        return result;
    }
    
    /**
     * Returns a list of unique elements taken from <code>list</code>.
     * 
     * @param <T> the element type
     * @param list the list to be processed
     * @return the list of unique elements from <code>list</code> in sequence of <code>list</code>
     */
    private static <T> List<T> makeUnique(List<T> list) {
        List<T> result;
        if (null == list || list.size() < 2) {
            result = list;
        } else {
            java.util.Set<T> known = new HashSet<T>();
            result = new ArrayList<T>();
            for (int i = 0; i < list.size(); i++) {
                T element = list.get(i);
                if (!known.contains(element)) {
                    result.add(element);
                    known.add(element);
                }
            }
        }
        return result;
    }

    /**
     * Creates combo items for the given <code>variable</code> of type <code>reference</code>.
     * 
     * @param variable the variable to be considered
     * @param reference the (required) reference type of <code>variable</code>
     * @return the combo items
     */
    public static ComboboxGUIVariable.ComboItem[] createComboItems(IDecisionVariable variable, 
        Reference reference) {
        java.util.Set<ConstraintSyntaxTree> possibleValues =
            ConfigQuery.possibleValuesForReferences(variable.getConfiguration(), reference);
        ComboboxGUIVariable.ComboItem[] items = null;
        
        if (possibleValues.size() > 0) {
            items = createComboItemArray(variable, possibleValues.size());
            int index = 0;
            for (ConstraintSyntaxTree value : possibleValues) {
                // TODO SE: Consider DisplayNameProvider
                String label = StringProvider.toIvmlString(value, variable.getConfiguration().getProject());
                items[index++] = new ComboboxGUIVariable.ComboItem(label, value);  
            }
        }
        return items;
    }

    /**
     * Defines whether updatable cell editors shall be created if possible.
     * 
     * @param updatable if <code>true</code>, updatable cell editors shall be created, 
     *   <code>false</code> for usual ones
     */
    public static final void createUpdatableCellEditors(boolean updatable) {
        createUpdatableCellEditors = updatable;
    }

    /**
     * Returns whether updatable cell editors shall be created if possible.
     * 
     * @return <code>true</code> if updatable cell editors shall be created, 
     *   <code>false</code> for usual ones
     */
    public static final boolean createUpdatableCellEditors() {
        return createUpdatableCellEditors;
    }

}
