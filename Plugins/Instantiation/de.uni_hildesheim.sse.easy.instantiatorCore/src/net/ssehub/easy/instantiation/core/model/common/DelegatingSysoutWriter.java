package net.ssehub.easy.instantiation.core.model.common;

import java.io.IOException;
import java.io.Writer;

/**
 * A writer which writes to the original (delegate) Writer and to system out.
 * This writer is intended for debugging.
 * 
 * @author Holger Eichelberger
 */
public class DelegatingSysoutWriter extends Writer {
    
    private Writer delegate;
    
    /**
     * Creates the delegating writer on <code>delegate</code>.
     * 
     * @param delegate the delegate writer
     */
    public DelegatingSysoutWriter(Writer delegate) {
        this.delegate = delegate;
    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {
        if (off >= 0 && len >= 0 && off < cbuf.length && off + len < cbuf.length) {
            String s = new String(cbuf);
            System.out.print(s.subSequence(off, len));
        }
        delegate.write(cbuf, off, len);
    }

    @Override
    public void flush() throws IOException {
        delegate.flush();
    }

    @Override
    public void close() throws IOException {
        delegate.close();
    }

}
