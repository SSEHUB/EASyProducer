package net.ssehub.easy.producer.ui.core.instantiation;

import org.eclipse.swt.widgets.Display;

import net.ssehub.easy.instantiation.core.model.tracing.AbstractVilTracer;
import net.ssehub.easy.producer.ui.productline_editor.EclipseConsole;

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
