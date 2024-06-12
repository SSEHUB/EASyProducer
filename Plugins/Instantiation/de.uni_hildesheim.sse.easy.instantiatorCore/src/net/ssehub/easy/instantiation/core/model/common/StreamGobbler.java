package net.ssehub.easy.instantiation.core.model.common;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.instantiation.core.Bundle;
import net.ssehub.easy.instantiation.core.model.execution.IInstantiatorTracer;
import net.ssehub.easy.instantiation.core.model.execution.TracerFactory;

/**
 * Implements a stream Gobbler that emits to the {@link TracerFactory#createInstantiatorTracer() instantiator tracer}. 
 * This is a helpful class if output/error streams of system processes shall be emitted to the EASy instantiation 
 * console.
 * 
 * @author Holger Eichelberger
 */
public class StreamGobbler extends Thread {

    private InputStream is;
    private boolean isErrorStream;
    private IMsgManipulator manipulator;
    private TracerFactory tracers;
    private List<Predicate<String>> excludeFilters;

    /**
     * Allows to manipulate messages.
     * 
     * @author Holger Eichelberger
     */
    public interface IMsgManipulator {

        /**
         * Manipulates a message.
         * 
         * @param message the message to be manipulated
         * @return the manipulated message, suppress if <b>null</b>
         */
        public String manipulate(String message);
    }
    
    /**
     * Creates a stream gobbler.
     * 
     * @param is the input stream to be gobbled and emitted
     * @param isErrorStream whether <code>is</code> is an error or an input stream
     */
    public StreamGobbler(InputStream is, boolean isErrorStream) {
        this(is, isErrorStream, null);
    }
    
    /**
     * Creates a stream gobbler.
     * 
     * @param is the input stream to be gobbled and emitted
     * @param isErrorStream whether <code>is</code> is an error or an input stream
     * @param manipulator an optional message manipulator
     */
    public StreamGobbler(InputStream is, boolean isErrorStream, IMsgManipulator manipulator) {
        this.is = is;
        this.isErrorStream = isErrorStream;
        this.manipulator = manipulator;
        tracers = TracerFactory.getInstance();
    }

    /**
     * Creates standard gobblers for the given process.
     * 
     * @param proc the process to gobble
     */
    public static void gobble(Process proc) {
        gobble(proc, null);
    }
    
    /**
     * Creates standard gobblers for the given process.
     * 
     * @param proc the process to gobble
     * @param manipulator an optional message manipulator
     * @param configurers optional gobbler configurers
     */
    public static void gobble(Process proc, IMsgManipulator manipulator, GobblerConfigurer... configurers) {
        StreamGobbler errorGobbler = new StreamGobbler(proc.getErrorStream(), true, manipulator);
        for (GobblerConfigurer c : configurers) {
            c.configure(errorGobbler);
        }
        errorGobbler.start();
        StreamGobbler outGobbler = new StreamGobbler(proc.getInputStream(), false, manipulator);
        outGobbler.start();
        for (GobblerConfigurer c : configurers) {
            c.configure(outGobbler);
        }
    }
    
    /**
     * In-place configuration of stream gobblers, e.g., with filters.
     * 
     * @author Holger Eichelberger
     */
    public interface GobblerConfigurer {
        
        /**
         * Configures the given {@code gobbler}.
         * 
         * @param gobbler the gobbler instance to configure
         */
        public void configure(StreamGobbler gobbler);
        
    }
    
    /**
     * Adds an exclusion filter.
     * 
     * @param filter the filter, ignored if <b>null</b>
     */
    public void addExcludeFilter(Predicate<String> filter) {
        if (null != filter) {
            if (null == excludeFilters) {
                excludeFilters = new ArrayList<>();
            }
            excludeFilters.add(filter);
        }
    }
    
    /**
     * Returns whether a {@code line} to be logged is ok for passing it on to the tracers.
     * 
     * @param line the line to be tested
     * @return {@code true} for output, {@code false} for skip
     */
    private boolean isOkForFilter(String line) {
        boolean ok = true;
        int size = null == excludeFilters ? 0 : excludeFilters.size();
        for (int i = 0; ok && i < size; i++) {
            ok = !excludeFilters.get(i).test(line);
        }
        return ok;
    }
    
    /**
     * Returns whether this gobbler is receiving an error or an output stream.
     * 
     * @return {@code true} for error, {@code false} for output
     */
    public boolean isErrorStream() {
        return isErrorStream;
    }
    
    @Override
    public void run() {
        TracerFactory.setInstance(tracers); // set thread-based
        IInstantiatorTracer tracer = TracerFactory.createInstantiatorTracer();
        try {
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            while ((line = br.readLine()) != null) {
                if (null != manipulator) {
                    line = manipulator.manipulate(line);
                }
                if (null != line && isOkForFilter(line)) {
                    if (isErrorStream) {
                        tracer.traceError(line);
                    } else {
                        tracer.traceMessage(line);
                    }
                }
            }
        } catch (EOFException eof) {
            // ok, terminate
        } catch (IOException ioe) {
            EASyLoggerFactory.INSTANCE.getLogger(StreamGobbler.class, Bundle.ID).exception(ioe);
        } finally {
            TracerFactory.setInstance(null); // reset thread-based
        }
    }
}
