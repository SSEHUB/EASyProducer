public class MethodReturnType {
    public String returnString() {
        return "MethodReturnType";
    }
    
    public int returnInteger() {
        return 1;
    }
    
    public boolean returnBoolean() {
        return true;
    }
    
    public char returnChar() {
        return 'b';
    }
    
    public Object returnNull() {
        return null;
    }
    
    public double returnDouble() {
        return 0.1;
    }
    
    public void method() {
        String string = returnString();
        int integer = returnInteger();
        boolean bool = returnBoolean();
        char character = returnChar();
        Object object = returnNull();
        double doubleNumber = returnDouble();
        System.out.println("This is a test");
    }
}
