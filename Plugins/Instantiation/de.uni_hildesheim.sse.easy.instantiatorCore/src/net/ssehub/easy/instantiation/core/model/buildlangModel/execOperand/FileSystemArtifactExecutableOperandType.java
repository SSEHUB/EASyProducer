package net.ssehub.easy.instantiation.core.model.buildlangModel.execOperand;

import net.ssehub.easy.instantiation.core.model.artifactModel.IFileSystemArtifact;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;

/**
 * An executable operand type for {@link IFileSystemArtifact}.
 * 
 * @author Holger Eichelberger
 */
class FileSystemArtifactExecutableOperandType implements IExecutableOperandType {

    public static final IExecutableOperandType INSTANCE = new FileSystemArtifactExecutableOperandType();

    /**
     * Prevents external creation.
     */
    private FileSystemArtifactExecutableOperandType() {
    }
    
    @Override
    public String convert(Object object) throws VilException {
        return PathExecutableOperandType.convert(((IFileSystemArtifact) object).getPath());
    }

    @Override
    public boolean sameType(TypeDescriptor<?> type) {
        return false; // not required
    }

    @Override
    public boolean sameType(Object object) {
        return object instanceof IFileSystemArtifact;
    }

}
