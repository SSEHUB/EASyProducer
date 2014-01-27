package de.uni_hildesheim.sse.vil.expressions.translation;

import de.uni_hildesheim.sse.dslCore.translation.ErrorCodes;
import de.uni_hildesheim.sse.dslCore.translation.TranslatorException;
import de.uni_hildesheim.sse.utils.modelManagement.Version;
import de.uni_hildesheim.sse.utils.modelManagement.VersionFormatException;
import de.uni_hildesheim.sse.utils.modelManagement.VersionRestriction;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionDslPackage;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.VersionSpec;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.VersionedId;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.Resolver;

/**
 * Utility methods for imports.
 * 
 * @author Holger Eichelberger
 */
public class ImportTranslator {

    /**
     * Prevents external creation.
     */
    private ImportTranslator() {
    }
    
    /**
     * Processes version restrictions.
     * 
     * @param name the name of the versioned element
     * @param spec the version specification (may be <b>null</b>)
     * @return the restrictions (may be <b>null</b> if there are none)
     * @throws TranslatorException in case that the translation fails
     */
    public static VersionRestriction[] processRestrictions(String name, VersionSpec spec) throws TranslatorException {
        VersionRestriction[] result = null;
        if (null != spec) {
            int size = spec.getConflicts().size();
            result = new VersionRestriction[size];
            for (int v = 0; v < size; v++) {
                VersionedId vId = spec.getConflicts().get(v);
                VersionRestriction.Operator operator = Resolver.resolveOperator(vId.getOp());
                if (null == operator) {
                    throw new TranslatorException("unknown operator " + vId.getOp(), vId,
                        ExpressionDslPackage.Literals.VERSIONED_ID__OP, ErrorCodes.IMPORT);
                } else {
                    try {
                        result[v] = new VersionRestriction(name, operator, new Version(vId.getVersion()));
                    } catch (VersionFormatException e) {
                        throw new TranslatorException(e, vId, ExpressionDslPackage.Literals.VERSIONED_ID__VERSION);
                    }
                }
            }
        }
        return result;
    }
    
}
