import java.io.InputStream;

/**
 * 
 */
public class SomeClass {

    public void doA(InputStream in) {
        int test = 0;
        if (test >= 0) {
            System.out.println("HERE");
        }
    }
    
    public void doFurther(String data) { 
        if (data.length() > 0) {
            data += " TEST";
        }
        System.out.println(data);
    }

    public void doFurther2(String data) { 
        if (data.length() > 0) {
            data += " TEST";
        }
        System.out.println(data);
        // Comment
    }
}