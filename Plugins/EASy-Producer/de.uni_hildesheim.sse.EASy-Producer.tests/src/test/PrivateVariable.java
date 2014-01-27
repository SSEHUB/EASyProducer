package test;
//
//import java.lang.reflect.Field;
//
//import org.junit.Assert;
//
///**
// * Representation of a nested private (or public) variable of a tested object.<br />
// * Please use this class only for GUI-Testing, to keep information hiding!
// * 
// * @author El-Sharkawy
// * @since 11.03.2011
// */
//public class PrivateVariable {
//    private String name;
//    private Object instance;
//    @SuppressWarnings("rawtypes")
//    private Class type;
//
//    /**
//     * Sole constructor of this class.
//     * 
//     * @param name Declared name of the variable
//     * @param INSTANCE Instance where this object is nested
//     * @param type Declared Type of the variable
//     */
//    protected PrivateVariable(Field f, Object parent) {
//        this.name = f.getName();
//        instance = null;
//        try {
//            this.instance = f.get(parent);
//        } catch (IllegalAccessException e) {
//            // Should never happen, because setting accessible flag to
//            // true. If setting accessible fails, should throw a security
//            // exception at that point and never get to the invoke. But
//            // just in case, wrap it in a TestFailedException and let a
//            // human figure it out.
//            e.printStackTrace();
//            Assert.fail();
//        } catch (IllegalArgumentException e) {
//            // Should happen only rarely, because usually the right
//            // number and types of arguments will be passed. If it does
//            // happen, just let the test fail so the programmer can fix
//            // the problem.
//            e.printStackTrace();
//            Assert.fail();
//        }
//        this.type = f.getType();
//    }
//
//    /**
//     * Getter for the Classtype of the instance.
//     * 
//     * @return The Classtype
//     */
//    @SuppressWarnings("rawtypes")
//    public Class getType() {
//        return type;
//    }
//
//    /**
//     * Getter for the name of the variable inside the parent class.
//     * 
//     * @return The name of the variable
//     */
//    public String getName() {
//        return name;
//    }
//
//    /**
//     * Getter for the instance of the variable.
//     * 
//     * @return The current instance inside the parent variable
//     */
//    public Object getInstance() {
//        return instance;
//    }
//}
