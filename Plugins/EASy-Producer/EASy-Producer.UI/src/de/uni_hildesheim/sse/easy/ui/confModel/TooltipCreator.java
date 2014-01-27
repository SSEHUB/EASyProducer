package de.uni_hildesheim.sse.easy.ui.confModel;

import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;
import de.uni_hildesheim.sse.model.cst.ConstraintSyntaxTree;
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
import de.uni_hildesheim.sse.persistency.StringProvider;

/**
 * Created a tooltip for a given variable.
 * This tooltip displays the datatype of the variable, for example &quot;Set of Compound of C&quot;.
 * @author El-Sharkawy
 *
 */
class TooltipCreator implements IDatatypeVisitor {

    private StringBuffer tooltip;
    
    /**
     * Sole constructor for this tooltip generator.
     * @param variable The variable for which the tooltip shall be generated.
     */
    TooltipCreator(IDecisionVariable variable) {
        tooltip = new StringBuffer();
        IDatatype type = variable.getDeclaration().getType();
        type.accept(this);
    }
    
    /**
     * Getter for the generated tooltip.
     * @return Returns the datatype of the given variable as string. This can be used as a tooltip inside the GUI.
     * This string must not be <tt>null</tt>.
     */
    String getTooltip() {
        return tooltip.toString();
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
    public void visitDerivedType(DerivedDatatype datatype) {
        tooltip.append("Derived type of ");
        datatype.getBasisType().accept(this);
        tooltip.append("\n with:");
        for (int i = 0; i < datatype.getConstraintCount(); i++) {
            ConstraintSyntaxTree cst = datatype.getConstraint(i).getConsSyntax();
            tooltip.append("\n");
            tooltip.append(StringProvider.toIvmlString(cst));
        }
    }

    @Override
    public void visitSet(Set set) {
        tooltip.append("Set of ");
        set.getContainedType().accept(this);
    }

    @Override
    public void visitSequence(Sequence sequence) {
        tooltip.append("Sequence of ");
        sequence.getContainedType().accept(this);
    }

    @Override
    public void visitReference(Reference reference) {
        tooltip.append("Refernce of ");
        reference.getType().accept(this);
    }

    @Override
    public void visitBooleanType(BooleanType type) {
        tooltip.append(type.getName());
    }

    @Override
    public void visitConstraintType(ConstraintType type) {
        tooltip.append(type.getName());
    }
    
    @Override
    public void visitStringType(StringType type) {
        tooltip.append(type.getName());
    }

    @Override
    public void visitIntegerType(IntegerType type) {
        tooltip.append(type.getName());
    }

    @Override
    public void visitRealType(RealType type) {
        tooltip.append(type.getName());
    }

    @Override
    public void visitCompoundType(Compound compound) {
        tooltip.append("Compound of ");
        tooltip.append(compound.getName());
    }

    @Override
    public void visitEnumType(Enum enumType) {
        tooltip.append("Enumeration: ");
        if (enumType.getLiteralCount() > 0) {
            for (int i = 0; i < enumType.getLiteralCount() - 1; i++) {
                tooltip.append(enumType.getLiteral(i).getName());
                tooltip.append(", ");
            }
            tooltip.append(enumType.getLiteral(enumType.getLiteralCount() - 1).getName());
        }
    }

    @Override
    public void visitOrderedEnumType(OrderedEnum enumType) {
        tooltip.append("Odered enumeration: ");
        if (enumType.getLiteralCount() > 0) {
            for (int i = 0; i < enumType.getLiteralCount() - 1; i++) {
                EnumLiteral literal = enumType.getLiteral(i);
                tooltip.append(literal.getName());
                tooltip.append(" = ");
                tooltip.append(literal.getOrdinal());
                tooltip.append(", ");
            }
            EnumLiteral literal = enumType.getLiteral(enumType.getLiteralCount() - 1);
            tooltip.append(literal.getName());
            tooltip.append(" = ");
            tooltip.append(literal.getOrdinal());
        }
    }

}
