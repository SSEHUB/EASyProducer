package net.ssehub.easy.reasonerCore.model.datatypes;

import net.ssehub.easy.varModel.model.datatypes.Enum;


/**
 * Representation of all constraints inside a compound.
 * @author Roman Sizonenko
 *
 */
public class EnumType extends ReasonerDatatype {
        
    
    /**
     * Constructor for initializing.
     * @param enumType {@link Enum}.
     */
    public EnumType(Enum enumType) {
        super(enumType);        
       
    }
    
    /**
     * Getter for returning {@link Enum}.
     * @return Returns the {@link Enum} defining the range of ordinals.
     */
    @Override
    public Enum getType() {
        return (Enum) super.getType();
    }
    
    /**
     * Returns minimal ordinal in the given {@link Enum}.
     * @return Returns the ordinal of the smallest literal, or 0 if the enum does not have any literals.
     */
    public int getMinOrdinal() {
        Enum type = getType();
        int min = type.getLiteralCount() == 0 ? 0 : type.getLiteral(0).getOrdinal();
        for (int i = 1; i < type.getLiteralCount(); i++) {
            int ordinal = type.getLiteral(i).getOrdinal();
            if (ordinal < min) {
                min = ordinal;
            }
        }
        return min;
    }
    
    /**
     * Returns maximal ordinal in the given {@link Enum}.
     * @return Returns the ordinal of the biggest literal, or 0 if the enum does not have any literals.
     */
    public int getMaxOrdinal() {
        Enum type = getType();
        int max = type.getLiteralCount() == 0 ? 0 : type.getLiteral(0).getOrdinal();
        for (int i = 1; i < type.getLiteralCount(); i++) {
            int ordinal = type.getLiteral(i).getOrdinal();
            if (ordinal > max) {
                max = ordinal;
            }
        }
        return max;
    }
    
    /**
     * Check if the given ordinal exists in the {@link Enum} definition.
     * @param ordinal Possible assignment that should be checked.
     * @return Returns true if the {@link Enum} has a literal with a given ordinal, otherwise returns false.
     */
    public boolean isValidOrdinal(int ordinal) {
        boolean isValid = false;
        Enum type = getType();        
        for (int i = 0; !isValid && i < type.getLiteralCount(); i++) {
            int tmpOrdinal = type.getLiteral(i).getOrdinal();
            if (tmpOrdinal == ordinal) {
                isValid = true;
            }
        }
        return isValid;
    }
    
    
    @Override
    public void accept(IReasonerTypeVisitor visitor) {
        visitor.visitEnumType(this);
    }
}
