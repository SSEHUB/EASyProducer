package jess;

public interface ArgumentChecker {

    public boolean check(Funcall f, JessToken r, ErrorSink s) throws JessException;
}
