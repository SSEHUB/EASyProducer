package net.ssehub.easy.varModel.confModel;

import net.ssehub.easy.varModel.cst.CompoundAccess;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;
import net.ssehub.easy.varModel.cst.Variable;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.IvmlKeyWords;
import net.ssehub.easy.varModel.model.datatypes.EnumLiteral;
import net.ssehub.easy.varModel.model.datatypes.OclKeyWords;
import net.ssehub.easy.varModel.persistency.StringProvider;

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
     * Returns the display name of a constraint, e.g., for a value of a reference.
     * 
     * @param constraint the constraint to return the name for
     * @param configuration the containing configuration in order to avoid unnecessary qualifications or to resolve 
     *   expressions for better readability
     * @return the display name (must not be <b>null</b>)
     */
    public String getDisplayName(ConstraintSyntaxTree constraint, Configuration configuration) {
        // TODO make it clean / use visitor
        String name;
        if (constraint instanceof Variable) {
            name = getDisplayName(((Variable) constraint).getVariable());
        } else if (constraint instanceof CompoundAccess) {
            CompoundAccess access = (CompoundAccess) constraint;
            String varName = (null != access.getResolvedSlot()) ? getDisplayName(access.getResolvedSlot())
                : access.getSlotName();
            name = getDisplayName(access.getCompoundExpression(), configuration)
                + IvmlKeyWords.COMPOUND_ACCESS + varName;
        } else if (constraint instanceof OCLFeatureCall
            && OclKeyWords.INDEX_ACCESS.equals(((OCLFeatureCall) constraint).getOperation())) {
            OCLFeatureCall call = (OCLFeatureCall) constraint;
            name = getDisplayNameForIndexAccess(call, configuration);
        } else {
            name = StringProvider.toIvmlString(constraint, configuration.getProject());
        }
        return name;
    }
    
    /**
     * Returns the display name for an index access constraint expression. This method is intended for overriding
     * as the returned display name is rather generic.
     * 
     * @param call the call representing the index access
     * @param configuration the containing configuration
     * @return the display name
     */
    protected String getDisplayNameForIndexAccess(OCLFeatureCall call, Configuration configuration) {
        return getDisplayName(call.getOperand(), configuration) + "[" 
                + getDisplayName(call.getParameter(0), configuration) + "]";
    }

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