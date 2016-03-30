package net.ssehub.easy.instantiation.core.model.buildlangModel.execOperand;

import net.ssehub.easy.instantiation.core.model.artifactModel.FileArtifact;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;

/**
 * An executable operand type for {@link FileArtifact}.
 * 
 * @author Holger Eichelberger
 */
class FileArtifactExecutableOperandType implements IExecutableOperandType {

    public static final IExecutableOperandType INSTANCE = new FileArtifactExecutableOperandType();

    /**
     * Prevents external creation.
     */
    private FileArtifactExecutableOperandType() {
    }
    
    @Override
    public String convert(Object object) throws VilException {
        return PathExecutableOperandType.convert(((FileArtifact) object).getPath());
    }

    @Override
    public boolean sameType(TypeDescriptor<?> type) {
        return TypeRegistry.DEFAULT.getType(FileArtifact.class.getSimpleName()).isAssignableFrom(type);
    }

    @Override
    public boolean sameType(Object object) {
        return object instanceof FileArtifact;
    }

}
