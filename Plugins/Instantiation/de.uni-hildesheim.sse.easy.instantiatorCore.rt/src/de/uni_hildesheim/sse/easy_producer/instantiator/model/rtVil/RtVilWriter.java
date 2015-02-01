package de.uni_hildesheim.sse.easy_producer.instantiator.model.rtVil;

import java.io.Writer;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.BuildlangWriter;

/**
 * Defines the output writer for rt-VIL.
 * 
 * @author Holger Eichelberger
 */
public class RtVilWriter extends BuildlangWriter {

    /**
     * Creates a build language writer.
     * 
     * @param out the writer to write the elements to
     */
    public RtVilWriter(Writer out) {
        super(out);
    }

}
