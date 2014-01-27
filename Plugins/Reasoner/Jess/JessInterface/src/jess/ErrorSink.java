package jess;

public interface ErrorSink {

    public void error(String s, String s1, int i, JessToken t) throws JessException;
    public void error(String s, String s1, int i, JessToken t, Named n) throws JessException;
    public void error(String s, String s1, String[] s2, int i, JessToken t) throws JessException;
    public void error(String s, String s1, String[] s2, int i, JessToken t, Named n) throws JessException;
    public void warning(String s1, String s2, String[] s3, int i, JessToken t);
    public Rete getEngine();
}
