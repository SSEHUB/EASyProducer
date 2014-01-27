package jess;

import java.io.Reader;
import java.util.List;

public class Jesp implements ErrorSink {
    
    // TODO Phani: replace initial values by real Jess constants!!!
	//DONE!
    
    public static final java.lang.String PROMPT = "Jess> ";

    public Jesp(Reader r1, jess.Rete r2) {
    }
    
    public Jesp(Tokenizer t, Rete r) {
    }

    public void addArgumentChecker(String s, ArgumentChecker a) {
    }

    public void setIssueWarnings(boolean b) {
    }

    public void clearWarnings() {
    }

    @SuppressWarnings("rawtypes")
    public List getWarnings() {
        return null;
    }

    public int getStreamPos() {
        return 0;
    }
    
    public void eatWhitespace() throws jess.JessException {
    }

    public void eatWhitespaceAndComments() throws JessException {
    }

    public Value parse(boolean b) throws JessException {
        return null;
    }
    
    public synchronized Value parse(boolean b, Context c) throws JessException {
        return null;
    }

    public Value promptAndParseOneExpression(boolean b, Context c) throws JessException {
        return null;
    }

    public void clear() {
    }
    
    public Value loadFacts(Context c) throws JessException {
        return null;
    }
    
    public Object parseExpression(Context c, boolean b) throws JessException {
        return null;
    }
    // public java.lang.Object parseExpression(jess.Context, boolean, jess.e8) throws jess.JessException;
    public void setFileName(String s) {
    }
    //public jess.Defmodule parseDefmodule(jess.e8, jess.Context)       throws jess.JessException;
    //public jess.Funcall parseFuncall(jess.Rete, jess.e8)       throws jess.JessException;
    //public jess.Deffacts parseDeffacts(jess.Rete, jess.e8)       throws jess.JessException;
    //public jess.Deftemplate parseDeftemplate(jess.Context, jess.Rete, jess.e8) throws jess.JessException;
    //public jess.Defrule parseDefrule(jess.Context, jess.Rete, jess.e8) throws jess.JessException;
    //public synchronized jess.Defquery parseDefquery(jess.Context, jess.Rete, jess.e8) throws jess.JessException;
    //public Deffunction parseDeffunction(Rete r, jess.e8) throws JessException {
        
    public void error(String s, String s1, int i, JessToken t) throws JessException {
    }

    public void error(String s, String s1, int i, JessToken t, Named n) throws JessException {
    }

    public void error(String s, String s1, String[] s2, int i, JessToken t) throws JessException {
    }

    public void error(String s, String s1, String[] s2, int i, JessToken t, Named n) throws JessException {
    }

    public void warning(String s1, String s2, String[] s3, int i, JessToken t) {
    }
    
    public Rete getEngine() {
        return null;
    }
    
    public static boolean isAConstructName(String s) {
        return false;
    }

}
