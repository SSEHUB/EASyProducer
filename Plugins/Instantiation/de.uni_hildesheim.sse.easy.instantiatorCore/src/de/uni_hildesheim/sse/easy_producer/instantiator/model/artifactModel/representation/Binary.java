package de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.representation;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.commons.io.FileUtils;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.IArtifactChangedListener;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IStringValueProvider;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Invisible;

/**
 * The binary representation of an artifact. Please note that
 * this class is not an artifact by itself rather then a specific 
 * representation of an artifact.
 * 
 * @author Holger Eichelberger
 */
public class Binary extends AbstractArtifactRepresentation implements IArtifactChangedListener, IStringValueProvider {
    
    public static final Binary CONSTANT_EMPTY = new Binary(false);
    
    // TODO notification mechanism changed/reparse

    private byte[] data;
    private File file;

    /**
     * Creates a new empty binary representation.
     * 
     * @param modifiable whether this representation shall be modifiable
     */
    public Binary(boolean modifiable) {
        super(modifiable);
        data = new byte[0];
    }
    
    /**
     * Creates a new binary representation from <code>file</code>.
     * 
     * @param text the text to construct the representation from
     * @param modifiable whether this representation shall be modifiable
     * 
     * @throws VilException in case that reading fails for some reason
     */
    public Binary(String text, boolean modifiable) throws VilException {
        super(modifiable);
        data = text.getBytes();
        updateContents(); // does nothing
    }

    /**
     * Creates a new binary representation from <code>file</code>.
     * 
     * @param file the file to be considered as input
     * @param modifiable whether this representation shall be modifiable
     * 
     * @throws VilException in case that reading fails for some reason
     */
    public Binary(File file, boolean modifiable) throws VilException {
        super(modifiable);
        this.file = file;
        updateContents();
    }
    
    /**
     * Updates the text contents.
     * 
     * @throws VilException in case that reading fails for some reason
     */
    public void updateContents() throws VilException {
        if (isModifiable()) {
            if (null != file) {
                try {
                    data = FileUtils.readFileToByteArray(file);
                } catch (IOException e) {
                    throw new VilException(e, VilException.ID_IO);
                }
            }
        }
    }
    
    @Override
    public boolean isEmpty() {
        return 0 == data.length;
    }

    @Override
    public void artifactChanged(Object cause) throws VilException {
        updateContents();
    }
    
    /**
     * Writes the data to the given output stream.
     * 
     * @param out the target output stream
     * @throws IOException in case of I/O problems
     */
    @Invisible
    public void write(OutputStream out) throws IOException {
        out.write(data);
    }

    @Override
    public String getStringValue(StringComparator comparator) {
        return "<binary>";
    }

    // TODO byte-wise / bit-wise operations missing
    
}
