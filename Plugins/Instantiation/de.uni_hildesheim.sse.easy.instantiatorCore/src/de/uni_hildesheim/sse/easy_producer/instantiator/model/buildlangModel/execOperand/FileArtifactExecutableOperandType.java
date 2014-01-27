package de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.execOperand;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.FileArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArtifactException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
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
    public String convert(Object object) throws ArtifactException {
        return PathExecutableOperandType.convert(((FileArtifact) object).getPath());
    }

    @Override
    public boolean sameType(TypeDescriptor<? extends IVilType> type) {
        return TypeRegistry.getType(FileArtifact.class.getSimpleName()).isAssignableFrom(type);
    }

    @Override
    public boolean sameType(Object object) {
        return object instanceof FileArtifact;
    }

}
