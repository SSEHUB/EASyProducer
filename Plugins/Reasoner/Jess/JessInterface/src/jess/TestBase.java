package jess;

public interface TestBase {
    
    // TODO Phani: replace initial values by real Jess constants!!!
	//DONE!

    public static final int EQ = 0;
    public static final int NEQ = 1;
    
    public boolean doTest(Context c) throws JessException;
}
