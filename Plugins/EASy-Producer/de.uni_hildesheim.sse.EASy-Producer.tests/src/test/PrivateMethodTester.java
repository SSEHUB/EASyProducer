package test;
//
//import static org.junit.Assert.fail;
//
//import java.lang.reflect.Field;
//import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.Method;
//
//import org.eclipse.swt.SWT;
//import org.eclipse.swt.custom.ScrolledComposite;
//import org.eclipse.swt.widgets.Button;
//import org.eclipse.swt.widgets.Composite;
//import org.eclipse.swt.widgets.Display;
//import org.eclipse.swt.widgets.Shell;
//import org.eclipse.ui.IWorkbenchPage;
//import org.eclipse.ui.PlatformUI;
//import org.eclipse.ui.intro.IIntroPart;
//import org.junit.Assert;
//
//import de.uni_hildesheim.sse.easy.ui.productline_editor.Editor;
//
///**
// * This is a class to support testing of private method and attributes.<br/>
// * Please use this class only for GUI Tests. <br/>
// * Adapted from <a href="http://www.artima.com/suiterunner/private.html">Testing Private Methods with JUnit and
// * SuiteRunner</a>
// * 
// * @author El-Sharkawy
// * @author kroeher
// * @since 11.03.2011
// * 
// */
//public class PrivateMethodTester {
//
//    /**
//     * This Method allows the programmer to test private and static methods of a class.<br/>
//     * Please use this method only for GUI testing, to keep information hidding.
//     * 
//     * @param targetClass Class to be tested
//     * @param methodName Name of the method, which should be tested
//     * @param argClasses List of argument types of the tested method
//     * @param argObjects List of arguments which are used in this test case
//     * @param callingClass The object which invokes the method. If the method is static this is <b>null</b>.
//     * @return The return value of the tested method or <b>null</b> if the underlying method return type is void.
//     * @throws Throwable Will be thrown if the tested object can not be introspected.
//     */
//    @SuppressWarnings({ "unchecked", "rawtypes" })
//    // checkstyle: stop exception type check
//    public static Object invokeMethod(Class targetClass, String methodName, Class[] argClasses, Object[] argObjects,
//        Object callingClass) throws Throwable {
//    // checkstyle: resume exception type check
//        
//        Object result = null;
//        Method method;
//        try {
//            method = targetClass.getDeclaredMethod(methodName, argClasses);
//            method.setAccessible(true);
//            result = method.invoke(callingClass, argObjects);
//
//        } catch (NoSuchMethodException e) {
//            // Should happen only rarely, because most times the
//            // specified method should exist. If it does happen, just let
//            // the test fail so the programmer can fix the problem.
//            e.printStackTrace();
//            fail();
//        } catch (SecurityException e) {
//            // Should happen only rarely, because the setAccessible(true)
//            // should be allowed in when running unit tests. If it does
//            // happen, just let the test fail so the programmer can fix
//            // the problem.
//            e.printStackTrace();
//            fail();
//        } catch (IllegalAccessException e) {
//            // Should never happen, because setting accessible flag to
//            // true. If setting accessible fails, should throw a security
//            // exception at that point and never get to the invoke. But
//            // just in case, wrap it in a TestFailedException and let a
//            // human figure it out.
//            e.printStackTrace();
//            fail();
//        } catch (IllegalArgumentException e) {
//            // Should happen only rarely, because usually the right
//            // number and types of arguments will be passed. If it does
//            // happen, just let the test fail so the programmer can fix
//            // the problem.
//            e.printStackTrace();
//            fail();
//        } catch (InvocationTargetException e) {
//            // This happens if the tested method (should) throw an
//            // exception.
//            // Throw the originated exception to handle it inside
//            // the specifies test case.
//            throw e.getTargetException();
//        }
//        return result;
//    }
//
//    /**
//     * This Method allows the programmer to test private attributes (variables) of a class.<br/>
//     * Please use this method only for GUI testing, to keep information hidding.
//     * 
//     * @param object The GUI-Object to be tested.
//     * @return All nested variables or <b>null</b> if there are no nested variables
//     */
//    public static PrivateVariable[] getPrivateVariables(Object object) {
//        Field[] f = object.getClass().getDeclaredFields();
//        PrivateVariable[] variables = null;
//
//        if (null != f && 0 != f.length) {
//            variables = new PrivateVariable[f.length];
//            for (int i = 0; i < f.length; i++) {
//                f[i].setAccessible(true);
//                try {
//                    variables[i] = new PrivateVariable(f[i], object);
//                } catch (IllegalArgumentException e) {
//                    // Should happen only rarely, because usually the right
//                    // number and types of arguments will be passed. If it does
//                    // happen, just let the test fail so the programmer can fix
//                    // the problem.
//                    e.printStackTrace();
//                    fail();
//                }
//            }
//        }
//        return variables;
//    }
//
//    /**
//     * Creates a composite for testing GUI-Elements.
//     * 
//     * @return A composite
//     */
//    public static Composite createComposite() {
//        Display display = Display.getCurrent();
//        final Shell shell = new Shell(display, SWT.SHELL_TRIM | SWT.H_SCROLL | SWT.V_SCROLL);
//        final Composite composite = new Composite(shell, SWT.BORDER);
//
//        return composite;
//    }
//
//    public static ScrolledComposite getEditorPage(int pageNum, boolean setActive) {
//        Editor plcEditor = getPLCEditor();
//        String[] editorPageTypes = { "ProductlineConfigurationPage", "ProductConfigurationEditorPage",
//            "TransformatorConfigPage", "BindingtimeConfigurationEditorPage", "TextEditor" };
//        ScrolledComposite editorPage = null;
//        // Search for the requested page.
//        PrivateVariable[] editorVariables = PrivateMethodTester.getPrivateVariables(plcEditor);
//        for (int i = 0; i < editorVariables.length; i++) {
//            if (editorVariables[i].getType().toString().contains(editorPageTypes[pageNum])) {
//                editorPage = (ScrolledComposite) editorVariables[i].getInstance();
//            }
//        }
//        // Make this page the active page of the editor.
//        if (editorPage != null && setActive) {
//            // Switches to transformator tab
//            @SuppressWarnings("rawtypes")
//            Class[] paramClass = { int.class };
//            final Object[] pageNr = { pageNum };
//            try {
//                PrivateMethodTester.invokeMethod(org.eclipse.ui.part.MultiPageEditorPart.class, "setActivePage",
//                    paramClass, pageNr, plcEditor);
//            } catch (Throwable e) {
//                Assert.fail();
//                e.printStackTrace();
//            }
//        }
//        return editorPage;
//    }
//
//    public static Editor getPLCEditor() {
//        Editor plcEditor = null;
//        IWorkbenchPage page = null;
//
//        page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
//
//        if (page != null) {
//            plcEditor = (Editor) page.getActiveEditor();
//            plcEditor.setFocus();
//            // Only to check this test case
//            // the current editor should be the active editor
//            Assert.assertTrue(page.isPartVisible(plcEditor));
//        } else {
//            Assert.fail();
//        }
//
//        return plcEditor;
//    }
//
//    public static void closeIntro() {
//        IIntroPart workbenchWelcome = PlatformUI.getWorkbench().getIntroManager().getIntro();
//        PlatformUI.getWorkbench().getIntroManager().closeIntro(workbenchWelcome);
//    }
//
//    public static void refreshGui() {
//        // Wait until all events are dispatched
//        while (Display.getCurrent().readAndDispatch())
//            ;
//        // Then redraw all workbench elements (for whom this is possible)
//        PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor().getSite().getShell()
//            .redraw();
//        PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActivePart().getSite().getShell()
//            .redraw();
//        PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell().redraw();
//        // Update the whole display for running the redraw events
//        Display.getCurrent().update();
//    }
//
//    /**
//     * Adaption of {@link #invokeMethod(Class, String, Class[], Object[], Object)} to press a button
//     * 
//     * @param button Button to be pressed
//     */
//    public static void pressButton(Button button) {
//        // Call the click method which is invoked when the button is clicked
//        try {
//            PrivateMethodTester.invokeMethod(button.getClass(), "click", null, null, button);
//        } catch (Throwable e) {
//            // Button.click shouldn't throw any exceptions
//            e.printStackTrace();
//            Assert.fail();
//        }
//
//        // Wait until button click is processed and refresh gui elements
//        PrivateMethodTester.refreshGui();
//    }
//
//    public static PrivateVariable findElement_Type(Object instance, String className) {
//        PrivateVariable result = null;
//        PrivateVariable[] privateVariables = PrivateMethodTester.getPrivateVariables(instance);
//
//        for (int i = 0; i < privateVariables.length; i++) {
//            if (privateVariables[i].getType().toString().contains(className)) {
//                result = privateVariables[i];
//            }
//        }
//
//        return result;
//    }
//
//    public static PrivateVariable findElement_Instance(Object instance, String instance2String) {
//        PrivateVariable result = null;
//        PrivateVariable[] privateVariables = PrivateMethodTester.getPrivateVariables(instance);
//
//        for (int i = 0; i < privateVariables.length; i++) {
//            if (privateVariables[i].getInstance().toString().contains(instance2String)) {
//                result = privateVariables[i];
//            }
//        }
//
//        return result;
//    }
//}
