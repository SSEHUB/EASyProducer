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
     * Creates a new VIL tracer instance for <i>System.out</i> without emitting trace texts.
     */
    public StreamVilTracer() {
        this(System.out);
    }

    /**
     * Creates a new VIL tracer instance for <code>out</code> without emitting trace texts.
     * 
     * @param out the output stream
     */
    public StreamVilTracer(PrintStream out) {
        this(out, false);
    }

    /**
     * Creates a new VIL tracer instance for <code>out</code>.
     * 
     * @param emitTraceText whether text passed to {@link #trace(String)} shall be emitted
     */
    public StreamVilTracer(boolean emitTraceText) {
        this(System.out, emitTraceText);
    }

    /**
     * Creates a new VIL tracer instance for <code>out</code>.
     * 
     * @param out the output stream
     * @param emitTraceText whether text passed to {@link #trace(String)} shall be emitted
     */
    public StreamVilTracer(PrintStream out, boolean emitTraceText) {
        super(emitTraceText);
        this.out = out;
    }
    
    @Override
    protected void writeImpl(String msg) {
        out.println(msg);
    }

}
