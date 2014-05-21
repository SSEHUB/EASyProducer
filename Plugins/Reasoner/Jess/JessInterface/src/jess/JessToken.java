package jess;

import java.io.Serializable;

@SuppressWarnings("serial")
public class JessToken implements Serializable {

    // TODO Phani: replace initial values by real Jess constants!!!
	//DONE!
    
    public static final int NONE_TOK = 0;
    public static final int MULTIVARIABLE_TOK = 1;
    public static final int VARIABLE_TOK = 2;
    public static final int STRING_TOK = 3;
    public static final int SYMBOL_TOK = 4;
    public static final int INTEGER_TOK = 5;
    public static final int FLOAT_TOK = 6;
    public static final int COMMENT_TOK = 7;
    public static final int REGEXP_TOK = 8;
    public static final int LONG_TOK = 9;
    public static final int MULTILINE_COMMENT_TOK = 11;
    public java.lang.String m_sval;
    public double m_nval;
    public long m_lval;
    public int m_lineno;
    public int m_ttype;
    public int m_start;
    public int m_end;

    public JessToken(int i1, int i2) {
    }

    public JessToken(int i1, int i2, int i3, String s1) {
    }
    
    public Value rawValueOf(Context c) throws JessException {
        return null;
    }
    
    public Value valueOf(Context c) throws JessException {
        return null;
    }
    
    public boolean isComment() {
        return false;
    }
    
    public boolean isEOF() {
        return false;
    }
    
    public boolean isVariable() {
        return false;
    }

    public boolean isLexeme() {
        return false;
    }
}
