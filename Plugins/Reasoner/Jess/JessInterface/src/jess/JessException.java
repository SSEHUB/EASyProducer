package jess;

@SuppressWarnings("serial")
public class JessException extends Exception {

    // TODO Phani: replace initial values by real Jess constants!!!
	//DONE!
    
    public static final int NO_ERROR = 0;
    public static final int GENERAL_ERROR = 1;
    public static final int CLASS_NOT_FOUND = 2;
    
    public JessException(String s1, String s2, String s3) {
    }
    
    public JessException(String s1, String s2, String s3, String s4) {
        
    }
    public JessException(String s1, String s2, int i) {
    }
    
    public JessException(String s1, String s2, Throwable t) {
    }
    
    public JessException(String s1, String s2, String s3, Throwable t1) {
        
    }
    public JessException(String s1, String s2, String s3, String s4, Throwable t1) {
    }
    
    public int getLineNumber() {
        return 0;
    }

    public String getFilename() {
        return null;
    }
    
    public void setFilename(String a) {
    }
    
    public String getDetail() {
        return null;
    }
    
    public String getRoutine() {
        return null;
    }
    
    public String getData() {
        return null;
    }
    
    public String getProgramText() {
        return null;
    }
    
    public String getContext() {
        return null;
    }
    
    public Context getExecutionContext() {
        return null;
    }
    
    public String toString() {
        return null;
    }
    
    public int getErrorCode() {
        return 0;
    }
    
    public void setErrorCode(int i) {
    }
}
