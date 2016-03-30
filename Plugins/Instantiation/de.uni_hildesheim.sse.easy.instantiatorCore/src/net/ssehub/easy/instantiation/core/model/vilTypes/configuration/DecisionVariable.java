package net.ssehub.easy.instantiation.core.model.vilTypes.configuration;

import java.util.ArrayList;
import java.util.List;

import net.ssehub.easy.instantiation.core.model.vilTypes.ArraySet;
import net.ssehub.easy.instantiation.core.model.vilTypes.Conversion;
import net.ssehub.easy.instantiation.core.model.vilTypes.IActualTypeProvider;
import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;
import net.ssehub.easy.instantiation.core.model.vilTypes.OperationMeta;
import net.ssehub.easy.instantiation.core.model.vilTypes.Sequence;
import net.ssehub.easy.instantiation.core.model.vilTypes.Set;
import net.ssehub.easy.instantiation.core.model.vilTypes.UnmodifiableSet;
import net.ssehub.easy.varModel.confModel.ContainerVariable;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;

/**
 * Realizes the bridge to the decision variables.
 * 
 * @author Holger Eichelberger
 */
public class DecisionVariable extends AbstractIvmlVariable implements IActualTypeProvider {

    private Attribute[] attributes;
    
    /**
     * Creates a decision variable.
     * 
     * @param cfg the parent configuration variable
     * @param variable the underlying IVML variable
     * @param filter the variable filter
     */
    DecisionVariable(Configuration cfg, IDecisionVariable variable, IVariableFilter filter) {
        super(cfg, variable, filter);
    }
    
    @Override
    protected void initializeAttributes() {
        if (null == attributes && variable.getAttributesCount() > 0) {
            List<Attribute> tmp = new ArrayList<Attribute>();
            for (int a = 0; a < variable.getAttributesCount(); a++) {
                IDecisionVariable attribute = variable.getAttribute(a);
                if (filter.isEnabled(attribute)) {
                    tmp.add(new Attribute(getConfiguration(), attribute, filter));
                }
            }
            attributes = new Attribute[tmp.size()];
            tmp.toArray(attributes);
        }
    }

    @Override
    @OperationMeta(returnGenerics = { Attribute.class } )
    public Set<Attribute> attributes() {
        initializeAttributes();
        return new UnmodifiableSet<Attribute>(new ArraySet<Attribute>(attributes, Attribute.class));
    }
    
    @Override
    @OperationMeta(returnGenerics = { Attribute.class } )
    public Set<Attribute> annotations() {
        return attributes();
    }
    
    /**
     * Returns the specified attribute.
     * 
     * @param index the 0-based index of the attribute to return
     * @return the specified attribute
     * @throws IndexOutOfBoundsException if <code>index &lt; 0 || index &gt;= {@link #getAttributeCount()}</code>
     */
    Attribute getAttribute(int index) {
        initializeAttributes();
        if (null == attributes) {
            throw new IndexOutOfBoundsException();
        }
        return attributes[index];
    }
    
    /**
     * Returns the number of attributes.
     * 
     * @return the number of attributes
     */
    int getAttributeCount() {
        initializeAttributes();
        return null == attributes ? 0 : attributes.length; 
    }

    // ---------------------------- conversions -----------------------------
    
    /**
     * Conversion operation to Real.
     * 
     * @param val the value (variable) to be converted
     * @return the converted value (may be <b>null</b>, depends on the type of the variable)
     */
    @Conversion
    public static double convert2Real(DecisionVariable val) {
        return val.getRealValue();
    }

    /**
     * Conversion operation to Integer.
     * 
     * @param val the value (variable) to be converted
     * @return the converted value (may be <b>null</b>, depends on the type of the variable)
     */
    @Conversion
    public static int convert2Integer(DecisionVariable val) {
        return val.getIntegerValue();
    }

    /**
     * Conversion operation to Boolean.
     * 
     * @param val the value (variable) to be converted
     * @return the converted value (may be <b>null</b>, depends on the type of the variable)
     */
    @Conversion
    public static boolean convert2Boolean(DecisionVariable val) {
        return val.getBooleanValue();
    }

    /**
     * Conversion operation to String.
     * 
     * @param val the value (variable) to be converted
     * @return the converted value (may be <b>null</b>, depends on the type of the variable)
     */
    @Conversion
    public static String convert2String(DecisionVariable val) {
        return val.getStringValue();
    }
    
    /**
     * Conversion operation to an EnumValue.
     * 
     * @param val the value (variable) to be converted
     * @return the converted value (may be <b>null</b>, depends on the type of the variable)
     */
    @Conversion
    public static EnumValue convert2EnumValue(DecisionVariable val) {
        return val.getEnumValue();
    }
    
    /**
     * Conversion operation to an EnumValue.
     * 
     * @param val the value (variable) to be converted
     * @return the converted value (may be <b>null</b>, depends on the type of the variable)
     */
    @Conversion
    @OperationMeta(returnGenerics = { DecisionVariable.class } )
    public static Sequence<DecisionVariable> convert2Sequence(DecisionVariable val) {
        return val.variables();
    }
    
    @Override
    @Invisible
    public IDatatype determineActualTypeName() {
        return getDecisionVariable().getDeclaration().getType();
    }

    /**
     * Returns the simple name of the decision variable.
     * 
     * @return the simple name
     */
    public String getName() {
        IDecisionVariable var = origVariable;
        // somebody decided that it is cool to add the index to the name of a container variable 
        // trying to access the container variable itself
        while (var.getParent() instanceof ContainerVariable) {
            var = (ContainerVariable) var.getParent();
        }
        return var.getDeclaration().getName();
    }

}
