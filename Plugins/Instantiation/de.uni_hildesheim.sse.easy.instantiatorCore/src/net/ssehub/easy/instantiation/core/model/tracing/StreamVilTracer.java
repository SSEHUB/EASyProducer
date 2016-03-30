package net.ssehub.easy.instantiation.core.model.tracing;

import java.io.PrintStream;

/**
 * Implements the VIL tracer for print streams.
 * 
 * @author Holger Eichelberger
 */
public class StreamVilTracer extends AbstractVilTracer {

    private PrintStream out;

    /**
     * Creates a new VIL tracer instance for <i>System.out</i>.
     */
    public StreamVilTracer() {
        this(System.out);
    }

    /**
     * Creates a new VIL tracer instance for <code>out</code>.
     * 
     * @param out the output stream
     */
    public StreamVilTracer(PrintStream out) {
        this.out = out;
    }
    
    @Override
    protected void writeImpl(String msg) {
        out.println(msg);
    }

}
