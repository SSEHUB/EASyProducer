import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class MethodFile {

    private static Logger logger = LogManager.getLogManager().getLogger("MethodFile");

    public void testModifyMethod() {
        try {
            for (int i = 0; i < 100; i++) {
                logger.info("#" + i);
            }
        } catch (IOException e) {
            logger.warning(e.getMessage());
        }
        TestClass cls = new TestClass();
        cls.printToConsole("ABC");
    }

    public void test() {
        System.out.println("dies ist ein test");
    }

    private class TestClass {

        @Deprecated
        public void printToConsole(String string) {
            
        }

    }

}