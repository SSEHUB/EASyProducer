package de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.execOperand;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.IFileSystemArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;

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
