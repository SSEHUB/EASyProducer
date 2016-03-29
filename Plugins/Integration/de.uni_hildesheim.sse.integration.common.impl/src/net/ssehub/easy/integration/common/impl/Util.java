package net.ssehub.easy.integration.common.impl;

import net.ssehub.easy.integration.common.ModelException;
import net.ssehub.easy.varModel.validation.IvmlIdentifierCheck;

/**
 * Some utility methods.
 * 
 * @author Holger Eichelberger
 */
public class Util {

    /**
     * Prevents access from outside (utility class).
     */
    private Util() {
    }
    
    /**
     * Creates an unknown implementation exception.
     * 
     * @return the exception instance
     */
    public static final IllegalArgumentException createUnknownImplementationException() {
        return new IllegalArgumentException("unknown implementation");
    }
    
    /**
     * Asserts a valid IVML identifier.
     * 
     * @param identifier the identifier to be tested
     * @return <code>identifier</code>
     * @throws ModelException in case that <code>identifier</code> is not valid
     */
    public static final String assertValidIdentifier(String identifier) throws ModelException {
        if (!IvmlIdentifierCheck.isValidIdentifier(identifier)) {
            throw new ModelException("'" + identifier + "' is not a valid IVML identifier");
        }
        return identifier;
    }

}
