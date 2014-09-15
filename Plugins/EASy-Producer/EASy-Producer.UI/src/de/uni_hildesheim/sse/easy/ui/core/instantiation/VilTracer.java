package de.uni_hildesheim.sse.easy.ui.core.instantiation;

import org.eclipse.swt.widgets.Display;

import de.uni_hildesheim.sse.easy.ui.productline_editor.EclipseConsole;
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
    protected void writeImpl(final String msg) {
        Display.getDefault().asyncExec(new Runnable() {

            @Override
            public void run() {
                EclipseConsole.INSTANCE.writeToConsole(msg, true);
            }
            
        });
    }

}
