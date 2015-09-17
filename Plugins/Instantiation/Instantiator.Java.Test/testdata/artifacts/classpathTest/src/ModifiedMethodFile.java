import java.util.logging.LogManager;
import java.util.logging.Logger;

public class MethodFile {
    private static Logger logger = LogManager.getLogManager().getLogger("MethodFile");

    public void testModifyMethod() {
        for (int i = 0; i < 100; i++) {
            logger.info("#" + i);
        }
        TestClass cls = new TestClass();
        cls.printToConsole("ABC");
    }

    public void test() {
    }

    private class TestClass {
        @Deprecated
        public void printToConsole(String string) {
        }
    }
}
