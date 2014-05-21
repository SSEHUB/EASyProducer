package jess;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Token implements Serializable {

    public final Fact topFact() {
        return null;
    }
    
    public final Fact fact(int i) {
        return null;
    }
    
    public final int size() {
        return 0;
    }
    
    public Token(Fact f, int i) throws JessException {
    }
    
    public Token(Fact f) throws JessException {
    }
    
    public Token(Token t, Fact f) throws JessException {
    }
    
    public Token(Token t, Token f) throws JessException {
    }
    
    public Token(Token t) throws JessException {
    }
    
    public int getTime() {
        return 0;
    }
    
    public int getTotalTime() {
        return 0;
    }
    
    public final boolean dataEquals(Token t) {
        return false;
    }
    
    public final boolean fastDataEquals(Token t) {
        return false;
    }
    
    public Token prepare(boolean b) throws JessException {
        return null;
    }
}
