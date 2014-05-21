package de.uni_hildesheim.sse.easy.ui.core.instantiation;

import de.uni_hildesheim.sse.easy.ui.productline_editor.configuration.EclipseConsole;
import de.uni_hildesheim.sse.easy_producer.core.varMod.tracing.AbstractVilTracer;

/**
 * Implements a combined tracer for VIL and VTL with common indentation.
 * 
 * @author Holger Eichelberger
 */
public class VilTracer extends AbstractVilTracer {

    // currently we assume that tracers are not used in parallel :o 
    public static final VilTracer INSTANCE = new VilTracer();
    /**
     * Creates a tracer instance.
     */
    private VilTracer() {
    }

    @Override
    protected void writeImpl(String msg) {
        EclipseConsole.INSTANCE.writeToConsole(msg, true);
    }

}
