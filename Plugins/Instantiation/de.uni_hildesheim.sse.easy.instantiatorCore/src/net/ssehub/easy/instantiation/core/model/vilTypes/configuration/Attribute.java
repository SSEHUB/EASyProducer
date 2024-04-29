package net.ssehub.easy.instantiation.core.model.vilTypes.configuration;

import net.ssehub.easy.instantiation.core.model.vilTypes.ArraySequence;
import net.ssehub.easy.instantiation.core.model.vilTypes.ArraySet;
import net.ssehub.easy.instantiation.core.model.vilTypes.Conversion;
import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;
import net.ssehub.easy.instantiation.core.model.vilTypes.ReturnGenerics;
import net.ssehub.easy.instantiation.core.model.vilTypes.Sequence;
import net.ssehub.easy.instantiation.core.model.vilTypes.Set;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;
import net.ssehub.easy.instantiation.core.model.vilTypes.UnmodifiableSet;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;

/**
 * Represents an attribute from a variability model imported into VIL.
 * 
 * @author Holger Eichelberger
 */
public class Attribute extends AbstractIvmlVariable {
    
    /**
     * Creates a new attribute instance.
     * 
     * @param parent the parent configuration
     * @param attribute the IVML attribute
     * @param filter the variable filter to apply
     */
    Attribute(Configuration parent, IDecisionVariable attribute, IVariableFilter filter) {
        super(parent, attribute, filter);
    }

    @Override
    protected void initializeAttributes() {
        // has no attributes
    }
    
    /**
     * Returns the specified attribute.
     * 
     * @param index the 0-based index of the attribute to return
     * @return the specified attribute
     * @throws IndexOutOfBoundsException if <code>index &lt; 0 || index &gt;= {@link #getAttributeCount()}</code>
     */
    Attribute getAttribute(int index) {
        throw new IndexOutOfBoundsException();
    }
    
    /**
     * Returns the number of attributes.
     * 
     * @return the number of attributes
     */
    int getAttributeCount() {
        return 0;
    }

    @Invisible
    @Override
    public Sequence<DecisionVariable> variables() {
        return ArraySequence.empty(DecisionVariable.class, TypeRegistry.DEFAULT); // DecisionVariable -> DEFAULT
    }

    @Invisible
    @Override
    public Set<Attribute> attributes() {
        return annotations();
    } // TODO remove attributes() -> annotations()
    
    @Invisible
    @Override
    public Set<Attribute> annotations() {
        return new UnmodifiableSet<Attribute>(ArraySet.empty(Attribute.class));
    }

    // ---------------------------- conversions -----------------------------
    
    /**
     * Conversion operation to Real.
     * 
     * @param val the value (variable) to be converted
     * @return the converted value (may be <b>null</b>, depends on the type of the attribute)
     */
    @Conversion
    public static double convert2Real(Attribute val) {
        return val.getRealValue();
    }

    /**
     * Conversion operation to Integer.
     * 
     * @param val the value (variable) to be converted
     * @return the converted value (may be <b>null</b>, depends on the type of the attribute)
     */
    @Conversion
    public static int convert2Integer(Attribute val) {
        return val.getIntegerValue();
    }

    /**
     * Conversion operation to Boolean.
     * 
     * @param val the value (variable) to be converted
     * @return the converted value (may be <b>null</b>, depends on the type of the attribute)
     */
    @Conversion
    public static boolean convert2Boolean(Attribute val) {
        return val.getBooleanValue();
    }

    /**
     * Conversion operation to String.
     * 
     * @param val the value (variable) to be converted
     * @return the converted value (may be <b>null</b>, depends on the type of the attribute)
     */
    @Conversion
    public static String convert2String(Attribute val) {
        return val.getStringValue();
    }

    /**
     * Conversion operation to an EnumValue.
     * 
     * @param val the value (variable) to be converted
     * @return the converted value (may be <b>null</b>, depends on the type of the attribute)
     */
    @Conversion
    public static EnumValue convert2EnumValue(Attribute val) {
        return val.getEnumValue();
    }

    /**
     * Conversion operation to an EnumValue.
     * 
     * @param val the value (variable) to be converted
     * @return the converted value (may be <b>null</b>, depends on the type of the variable)
     */
    @Conversion
    @ReturnGenerics(DecisionVariable.class)
    public static Sequence<DecisionVariable> convert2Sequence(Attribute val) {
        return val.variables();
    }

}
