package net.ssehub.easy.reasoning.drools2;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

/**
 * Adapter/Wrapper for Drools.
 * This {@link Writer} can be used inside of {@link DroolsEngine} for debugging created DRL files.
 * This Writer will write the DRL file (if a {@link java.io.FileWriter} was given as parameter) and is also
 * able to print the created file via the {@link #toString()} method.
 * @author El-Sharkawy
 *
 */
public class DroolsWriter extends Writer {
    
    private StringWriter sWriter;
    private Writer mainWriter;
    
    /**
     * Sole constructor for this class.
     * @param writer A writer which should be used for the creating the DRL file.
     */
    public DroolsWriter(Writer writer) {
        this.sWriter = new StringWriter();
        this.mainWriter = writer;
    }
    
    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {
        mainWriter.write(cbuf, off, len);
        sWriter.write(cbuf, off, len);
    }

    @Override
    public void flush() throws IOException {
        mainWriter.flush();
        sWriter.flush();
    }

    @Override
    public void close() throws IOException {
        mainWriter.close();
        sWriter.close();
    }
    
    @Override
    public String toString() {
        return sWriter.toString();
    }
}
