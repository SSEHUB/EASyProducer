package de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.execOperand;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;

/**
 * An executable operand type for Strings.
 * 
 * @author Holger Eichelberger
 */
class StringExecutableOperandType implements IExecutableOperandType {

    public static final IExecutableOperandType INSTANCE = new StringExecutableOperandType();

    /**
     * Prevents external creation.
     */
    private StringExecutableOperandType() {
    }
    
    @Override
    public String convert(Object object) {
        return object.toString();
    }

    @Override
    public boolean sameType(TypeDescriptor<?> type) {
        return type == TypeRegistry.stringType();
    }

    @Override
    public boolean sameType(Object object) {
        return object instanceof String;
    }
    
}
