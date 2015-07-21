package de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.execOperand;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.FileArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;

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
