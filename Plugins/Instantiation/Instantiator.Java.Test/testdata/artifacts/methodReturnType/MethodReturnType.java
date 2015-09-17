public class MethodReturnType {
    public String returnString() {
        return "MethodReturnType";
    }
    
    public void method() {
        String test = returnString();
        System.out.println("This is a test");
    }
}
