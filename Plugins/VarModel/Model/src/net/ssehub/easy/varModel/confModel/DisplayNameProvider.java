package net.ssehub.easy.varModel.confModel;

import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.datatypes.EnumLiteral;

/**
 * A provider for display names (e.g., in case that not variable names shall be displayed). This is a QualiMaster 
 * addition.
 * 
 * @author Holger Eichelberger
 */
public abstract class DisplayNameProvider {
    
    private static DisplayNameProvider nameProvider;
    
    /**
     * Changes the display name provider.
     * 
     * @param provider the new name provider (considered only if not <b>null</b>)
     */
    public static void setInstance(DisplayNameProvider provider) {
        if (null != provider) {
            nameProvider = provider;
        }
    }
    
    /**
     * Returns the current display name provider.
     * 
     * @return the current display name provider
     */
    public static DisplayNameProvider getInstance() {
        return nameProvider;
    }
    
    static {
        nameProvider = new DisplayNameProvider() {
            
            @Override
            public String getDisplayName(AbstractVariable variable) {
                return variable.getUniqueName();
            }
            
            @Override
            public String getParentNames(AbstractVariable variable) {
                String result = null;
                if (variable.getParent() != null) {
                    result = variable.getParent().getQualifiedName();
                }
                return result;
            }

            @Override
            public String getDisplayName(EnumLiteral literal) {
                return literal.getName();
            }

            @Override
            public String getNullName(AbstractVariable type) {
                return "[NULL]";
            }

            @Override
            public boolean enableNullValueInConfiguration(AbstractVariable variable) {
                return false;
            }
        };
    }

    /**
     * Returns the display name of a variable.
     * 
     * @param variable the variable to return the name for
     * @return the display name (must not be <b>null</b>)
     */
    public String getDisplayName(IDecisionVariable variable) {
        return getDisplayName(variable.getDeclaration());
    }
        
    /**
     * Returns the display name of a variable.
     * 
     * @param variable the variable to return the name for
     * @return the display name (must not be <b>null</b>)
     */
    public abstract String getDisplayName(AbstractVariable variable);

    /**
     * Returns the display names of the parents.
     * 
     * @param variable the variable to return the name for
     * @return the display name (must not be <b>null</b>)
     */
    public abstract String getParentNames(AbstractVariable variable);
    
    /**
     * Returns the display name of an enumeration literal.
     * 
     * @param literal the name of an enumeration literal
     * @return the display name (must not be <b>null</b>)
     */
    public abstract String getDisplayName(EnumLiteral literal);

    /**
     * Returns the name to be used for an IVML null value, possibly
     * dependent on the given <code>variable</code>.
     * 
     * @param variable the variable, i.e., including its type (may be <b>null</b> 
     *     to query for a generic name)
     * @return the name for the IVML null value (must not be <b>null</b>)
     */
    public abstract String getNullName(AbstractVariable variable);

    
    /**
     * Returns the name to be used for an IVML null value, possibly
     * dependent on the given <code>variable</code>. Shall be consistent with {@link #getNullName(AbstractVariable)}.
     * 
     * @param variable the variable, i.e., including its type (may be <b>null</b> 
     *     to query for a generic name)
     * @return the name for the IVML null value (must not be <b>null</b>)
     */
    public String getNullName(IDecisionVariable variable) {
        String result = null;
        if (null != variable) {
            result = getNullName(variable.getDeclaration());
        }
        return result;
    }
    
    /**
     * Returns whether IMVL null values shall be visible in the configuration editor. The
     * result shall be consistent with {@link #enableNullValueInConfiguration(AbstractVariable)}.
     * 
     * @param variable the variable to check for (may be <b>null</b> for a generic query)
     * @return <code>true</code> if null values shall be available for configuration, <code>false</code> else
     */
    public boolean enableNullValueInConfiguration(IDecisionVariable variable) {
        boolean result = false;
        if (null != variable) {
            result = enableNullValueInConfiguration(variable.getDeclaration());
        }
        return result;
    }

    /**
     * Returns whether IMVL null values shall be visible in the configuration editor.
     * 
     * @param variable the variable to check for (may be <b>null</b> for a generic query)
     * @return <code>true</code> if null values shall be available for configuration, <code>false</code> else
     */
    public abstract boolean enableNullValueInConfiguration(AbstractVariable variable);

}