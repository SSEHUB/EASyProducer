package net.ssehub.easy.instantiation.core.model.buildlangModel.execOperand;

import net.ssehub.easy.instantiation.core.model.artifactModel.Path;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;

/**
 * An executable operand type for {@link Path}.
 * 
 * @author Holger Eichelberger
 */
class PathExecutableOperandType implements IExecutableOperandType {

    public static final IExecutableOperandType INSTANCE = new PathExecutableOperandType();

    /**
     * Prevents external creation.
     */
    private PathExecutableOperandType() {
    }
    
    /**
     * Converts a path into a string.
     * 
     * @param path the path to be converted
     * @return the converted path
     */
    public static String convert(Path path) {
        return path.getPath();
    }
    
    @Override
    public String convert(Object object) {
        return convert((Path) object);
    }

    @Override
    public boolean sameType(TypeDescriptor<?> type) {
        return type.getName().equals(Path.class.getSimpleName());
    }
    
    @Override
    public boolean sameType(Object object) {
        return object instanceof Path;
    }

}
