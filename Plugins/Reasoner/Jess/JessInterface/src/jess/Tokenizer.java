package jess;

public interface Tokenizer {

    // TODO Phani: replace initial values by real Jess constants!!!
	//DONE!
    
    public static final java.lang.String BLANK_PREFIX = "_blank_";
    public static final java.lang.String BLANK_MULTI = "_blank_mf";
    
    public void reportNewlines(boolean b);
    public String readLine() throws JessException;
    public JessToken nextToken() throws JessException;
    public java.lang.String discardToEOL() throws JessException;
    public int getStreamPos();
    public void eatWhitespace() throws jess.JessException;
}
