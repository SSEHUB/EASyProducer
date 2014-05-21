package de.uni_hildesheim.sse.reasoning.core.model.variables;

import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;
import de.uni_hildesheim.sse.reasoning.core.Bundle;
import de.uni_hildesheim.sse.reasoning.core.model.ReasonerModel;
import de.uni_hildesheim.sse.reasoning.core.model.datatypes.ReasonerDatatype;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory.EASyLogger;

/**
 * Abstract super class for {@link ReasonerVariable}s, which are an instance of a {@link ReasonerDatatype}.
 * @author El-Sharkawy
 *
 */
abstract class CustomVariable extends ReasonerVariable {

    private static final EASyLogger LOGGER = EASyLoggerFactory.INSTANCE.getLogger(CustomVariable.class, Bundle.ID);
    
    private ReasonerDatatype type;
    
    /**
     * Sole constructor for creating a new {@link ReasonerVariable}.
     * @param configVariable The origin {@link IDecisionVariable}, which should be wrapped into
     *     this {@link ReasonerVariable} (must not be <tt>null</tt>).
     * @param name The unique name of the {@link ReasonerVariable} inside the 
     *     {@link ReasonerModel}
     * @param model the {@link ReasonerModel}, where this variable should be added to
     *     (needed for {@link ReasonerDatatype} resolution).
     * @param parent Variables container.  
     */
    protected CustomVariable(IDecisionVariable configVariable, String name, ReasonerModel model,
            ReasonerVariable parent) {
        super(configVariable, name, model, parent);
        String typeName = configVariable.getDeclaration().getType().getName();
        type = model.getDatatype(typeName);
        if (null == type) {
            LOGGER.error("Datatype for variable " + getName() + " could not be retrieved from the ReasonerModel");
            throw new NullPointerException("Datatype could not be resolved");
        }
    }

    /**
     * Returns the {@link ReasonerDatatype} of this {@link ReasonerVariable}.
     * @return The {@link ReasonerDatatype} of this {@link ReasonerVariable}.
     */
    public ReasonerDatatype getType() {
        return type;
    }
}
