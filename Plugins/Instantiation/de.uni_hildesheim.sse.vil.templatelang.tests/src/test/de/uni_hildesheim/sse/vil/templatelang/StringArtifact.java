package test.de.uni_hildesheim.sse.vil.templatelang;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.IArtifactVisitor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.SimpleArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.representation.Binary;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.representation.Text;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArraySet;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArtifactException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IStringValueProvider;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationMeta;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.PseudoString;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Set;

/**
 * A simple artifact for testing.
 * 
 * @author Holger Eichelberger
 */
public class StringArtifact extends SimpleArtifact implements IStringValueProvider {

    /**
     * The constructor for the artifact.
     * 
     * @return the artifact instance
     */
    public static StringArtifact create() {
        return new StringArtifact();
    }
    
    /**
     * Selects all file artifacts represented by this path.
     * 
     * @return all file artifacts represented by path
     */
    @OperationMeta(returnGenerics = String.class)
    public Set<String> selectAll() {
        String[] results = new String[3];
        for (int i = 0; i < results.length; i++) {
            results[i] = String.valueOf(i);
        }
        return new ArraySet<String>(results, PseudoString.class);
    }

    @Override
    public void delete() throws ArtifactException {
    }

    @Override
    public String getName() throws ArtifactException {
        return "<StringArtifact>";
    }

    @Override
    public void rename(String name) throws ArtifactException {
    }

    @Override
    public Text getText() throws ArtifactException {
        return Text.CONSTANT_EMPTY;
    }

    @Override
    public Binary getBinary() throws ArtifactException {
        return Binary.CONSTANT_EMPTY;
    }

    @Override
    public void accept(IArtifactVisitor visitor) {
        visitor.visitSimpleArtifact(this);
    }

    @Override
    public boolean exists() {
        return false;
    }

    @Override
    public void store() throws ArtifactException {
    }

    @Override
    public String getStringValue(StringComparator comparator) {
        return "<stringArtifact>";
    }

    @Override
    public long lastModification() {
        return 0;
    }

    @Override
    public void update() throws ArtifactException {
    }
    
}
