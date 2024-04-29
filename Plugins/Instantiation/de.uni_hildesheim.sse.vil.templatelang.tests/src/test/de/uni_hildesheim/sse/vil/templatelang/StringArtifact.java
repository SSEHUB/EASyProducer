package test.de.uni_hildesheim.sse.vil.templatelang;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.ssehub.easy.instantiation.core.model.artifactModel.IArtifactVisitor;
import net.ssehub.easy.instantiation.core.model.artifactModel.SimpleArtifact;
import net.ssehub.easy.instantiation.core.model.artifactModel.representation.Binary;
import net.ssehub.easy.instantiation.core.model.artifactModel.representation.Text;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.ArraySet;
import net.ssehub.easy.instantiation.core.model.vilTypes.IStringValueProvider;
import net.ssehub.easy.instantiation.core.model.vilTypes.PseudoString;
import net.ssehub.easy.instantiation.core.model.vilTypes.ReturnGenerics;
import net.ssehub.easy.instantiation.core.model.vilTypes.Set;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.Configuration;

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
    @ReturnGenerics(String.class)
    public Set<String> selectAll() {
        String[] results = new String[3];
        for (int i = 0; i < results.length; i++) {
            results[i] = String.valueOf(i);
        }
        return new ArraySet<String>(results, PseudoString.class);
    }

    @Override
    public void delete() throws VilException {
    }

    @Override
    public String getName() throws VilException {
        return "<StringArtifact>";
    }

    @Override
    public void rename(String name) throws VilException {
    }
    
    /**
     * Turns a configuration into a string.
     * 
     * @param cfg the configuration
     * @return the string representation
     */
    public String toString(Configuration cfg) {
        return cfg.getName();
    }

    @Override
    public Text getText() throws VilException {
        return Text.CONSTANT_EMPTY;
    }

    @Override
    public Binary getBinary() throws VilException {
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
    public void store() throws VilException {
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
    public void update() throws VilException {
    }
    
    /**
     * Just return strings as iterator.
     * 
     * @return the iterator
     */
    @ReturnGenerics(String.class)
    public Iterator<String> values() {
        List<String> tmp = new ArrayList<String>();
        tmp.add("1");
        tmp.add("2");
        tmp.add("3");
        return tmp.iterator();
    }
    
}
