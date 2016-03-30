package net.ssehub.easy.instantiation.core.model.buildlangModel.execOperand;

import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;

/**
 * Frontend access to the executable operands.
 * 
 * @author Holger Eichelberger
 */
public class ExecutableOperand {
    
    private static final IExecutableOperandType[] EXEC_OPERAND_TYPES = {
        StringExecutableOperandType.INSTANCE, 
        PathExecutableOperandType.INSTANCE, 
        FileArtifactExecutableOperandType.INSTANCE, 
        FileSystemArtifactExecutableOperandType.INSTANCE};

    /**
     * Returns the executable operand type for the given <code>type</code>.  
     * 
     * @param type the type to return the executable type for
     * @return the executable operand type, <b>null</b> if there is none
     * 
     * @see IExecutableOperandType#sameType(TypeDescriptor)
     */
    public static IExecutableOperandType getExecutableType(TypeDescriptor<?> type) {
        IExecutableOperandType result = null;
        for (int e = 0; null == result && e < EXEC_OPERAND_TYPES.length; e++) {
            if (EXEC_OPERAND_TYPES[e].sameType(type)) {
                result = EXEC_OPERAND_TYPES[e];
            }
        }
        return result;
    }

    /**
     * Returns the executable operand type for the given <code>object</code>.  
     * 
     * @param object the object to return the executable type for
     * @return the executable operand type, <b>null</b> if there is none
     * 
     * @see IExecutableOperandType#sameType(Object)
     */
    public static IExecutableOperandType getExecutableType(Object object) {
        IExecutableOperandType result = null;
        for (int e = 0; null == result && e < EXEC_OPERAND_TYPES.length; e++) {
            if (EXEC_OPERAND_TYPES[e].sameType(object)) {
                result = EXEC_OPERAND_TYPES[e];
            }
        }
        return result;
    }

}
