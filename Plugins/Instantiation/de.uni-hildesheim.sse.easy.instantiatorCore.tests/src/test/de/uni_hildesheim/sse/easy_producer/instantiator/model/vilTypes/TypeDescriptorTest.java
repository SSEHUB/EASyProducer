package test.de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

import test.de.uni_hildesheim.sse.easy_producer.instantiator.model.AbstractTest;
import test.de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.testArtifacts.MyArtifact;
import test.de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.testArtifacts.MySubArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Invisible;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationDescriptor.AliasType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationDescriptor.CompatibilityResult;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationMeta;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.PseudoBoolean;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.PseudoInteger;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.PseudoReal;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.PseudoString;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.VilException;

/**
 * Tests the type descriptor class. This test must be executed 
 * after {@link TypeDescriptorTest}. In particlar, this class implements an alternative
 * algorithm for testing invisible methods.
 * 
 * @author Holger Eichelberger
 */
public class TypeDescriptorTest extends AbstractTest {

    /**
     * Sets up MyArtifact and MySubArtifact.
     */
    static final void setUpMyArtifacts() {
        try {
            TypeRegistry.registerType(test.de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes
                .testArtifacts.MyArtifact.class);
        } catch (VilException e) {
            // already registered, ok ;)
        }
        try {
            TypeRegistry.registerType(test.de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes
                .testArtifacts.MySubArtifact.class);
        } catch (VilException e) {
            // already registered, ok ;)
        }
    }
    
    /**
     * Set up - ensure artifacts.
     */
    @BeforeClass
    public static void startUp() {
        setUpMyArtifacts();
    }
    
    /**
     * Tests whether the expected operations are present and whether no invisible
     * operations have been included.
     */
    @Test
    public void testOperations() {
        assertOperations(MyArtifact.class, false);
        assertOperations(MySubArtifact.class, false);
        assertOperations(PseudoInteger.class, true);
    }

    /**
     * Asserts the expected operations on the given type <code>cls</code>. This method
     * retrieves the type descriptor, the expected constructors and operations and tests 
     * the index-based and the iterator-based access.
     * 
     * @param cls the VIL type to be tested
     * @param qualified if the qualified class name (pseudo primitives) shall be used or the 
     *   simple name (e.g., artifact classes)
     * @see #getExpectedSignatures(Class, String)
     * @see OperationsIterator
     */
    private void assertOperations(Class<? extends IVilType> cls, boolean qualified) {
        String clsName;
        if (qualified) {
            clsName = cls.getName();
        } else {
            clsName = cls.getSimpleName();
        }
        TypeDescriptor<? extends IVilType> descriptor = TypeRegistry.getType(clsName);
        Assert.assertNotNull(descriptor);
        assertOperations(cls, descriptor.getOperations());
        assertOperations(cls, new OperationsIterator(descriptor));
    }

    /**
     * Asserts the expected operations on the given iterable.
     * 
     * @param cls the class of the VIL type
     * @param iter the operations to analyze
     */
    private void assertOperations(Class<? extends IVilType> cls, Iterable<OperationDescriptor> iter) {
        Set<String> exCons = new HashSet<String>();
        addOperations(cls, exCons, true);
        Set<String> exOps = new HashSet<String>();
        addOperations(cls, exOps, false);
        
        for (OperationDescriptor operation : iter) {
            if (AliasType.IMPLICIT != operation.isAlias()) {
                String sig = operation.getJavaSignature();
                if (operation.isConstructor()) {
                    if (!exCons.remove(sig)) {
                        Assert.fail("constructor signature unexpected " + sig + " in " + cls.getName());
                    }
                } else {
                    if (!exOps.remove(sig)) {
                        Assert.fail("operation signature unexpected " + sig + " in " + cls.getName());
                    }
                }
            }
        }
        Assert.assertTrue("not all constructors found (" + cls.getName() + "): " + exCons, exCons.isEmpty());
        Assert.assertTrue("not all operations found (" + cls.getName() + "): " + exOps, exOps.isEmpty());
    }

    /**
     * Returns whether the given method is invisible.
     * 
     * @param method the method to be analyzed
     * @return <code>true</code> if it is invisible, <code>false</code> else
     */
    private boolean isInvisible(Method method) {
        boolean invisible = (null != method.getAnnotation(Invisible.class));
        Class<?> declClass = method.getDeclaringClass();
        for (int i = 0; !invisible && i < TypeRegistry.INVISIBLE_BY_DEFAULT.length; i++) {
            Class<?> dflt = TypeRegistry.INVISIBLE_BY_DEFAULT[i];
            if (dflt.isAssignableFrom(declClass)) {
                Method[] methods = dflt.getDeclaredMethods();
                for (int m = 0; !invisible && m < methods.length; m++) {
                    invisible = OperationDescriptor.isSameSignature(method, methods[m]);
                }
            }
        }
        invisible |= isInvisibleInParent(method, method.getDeclaringClass());
        return invisible;
    }
    
    /**
     * Returns whether the given method is invisible in its parent <code>cls</code>.
     * 
     * @param method the method to be analyzed
     * @param cls the parent class
     * @return <code>true</code> if it is invisible, <code>false</code> else
     */
    private boolean isInvisibleInParent(Method method, Class<?> cls) {
        boolean invisible = false;
        if (null != cls) {
            Method[] methods = cls.getMethods();
            for (int m = 0; m < methods.length; m++) {
                Method tmp = methods[m];
                if (OperationDescriptor.isSameSignature(method, tmp)) {
                    Invisible inv = tmp.getAnnotation(Invisible.class);
                    invisible = (null != inv && inv.inherit());
                }
            }
            invisible |= isInvisibleInParent(method, cls.getSuperclass());
            Class<?>[] interfaces = cls.getInterfaces();
            if (null != interfaces) {
                for (int i = 0; !invisible && i < interfaces.length; i++) {
                    invisible |= isInvisibleInParent(method, interfaces[i]);
                }
            }
        }
        return invisible;
    }

    /**
     * Adds the given method by reflection analysis.
     * 
     * @param method the method to be added
     * @param ops the list of operation signatures to be modified as a side effect
     * @param constructors whether constructors or operations shall be retrieved
     */
    private void addOperation(Method method, Set<String> ops, boolean constructors) {
        if (!isInvisible(method)) {
            if ((constructors && OperationDescriptor.isConstructor(method)) 
                || (!constructors && OperationDescriptor.isOperation(method))) {
                OperationMeta meta = method.getAnnotation(OperationMeta.class);
                boolean done = false;
                if (null != meta) {
                    String[] names = meta.name();
                    if (null != names) {
                        for (int n = 0; n < names.length; n++) {
                            ops.add(OperationDescriptor.getJavaSignature(method, names[n], false));
                        }
                        done = names.length > 0;
                    }
                }
                if (!done) {
                    ops.add(OperationDescriptor.getJavaSignature(method));
                }
            }
        }
    }
    
    /**
     * Adds the operations and constructors by reflection analysis.
     * 
     * @param cls the class to be analyzed
     * @param ops the list of operation signatures to be modified as a side effect
     * @param constructors whether constructors or operations shall be retrieved
     */
    private void addOperations(Class<?> cls, Set<String> ops, boolean constructors) {
        if (cls != Object.class) {
            Method[] methods = cls.getDeclaredMethods();
            for (int m = 0; m < methods.length; m++) {
                addOperation(methods[m], ops, constructors);
            }
            if (!constructors) {
                if (null != cls.getSuperclass()) {
                    addOperations(cls.getSuperclass(), ops, false);
                }
                Class<?>[] interfaces = cls.getInterfaces();
                if (null != interfaces) {
                    for (Class<?> iface : interfaces) {
                        addOperations(iface, ops, false);
                    }
                }
            }
        }
    }

    /**
     * Tests a single primitive / basic type.
     * 
     * @param typeClass the name of the implementing class in VIL (Pseudo...)
     * @param vilName the name of the primitive in VIL
     * @param wrapperClass the name of the corresponding wrapper class in Java
     * @param primitiveName the name of the primitive type in Java (may be <b>null</b> to test for 
     *   <code>java.lang.String</code>)
     */
    private static void testBasicType(Class<?> typeClass, String vilName, Class<?> wrapperClass, String primitiveName) {
        TypeDescriptor<? extends IVilType> cDesc = TypeRegistry.getType(typeClass.getName());
        Assert.assertNotNull(cDesc);
        TypeDescriptor<? extends IVilType> vDesc = TypeRegistry.getType(vilName);
        Assert.assertNotNull(vDesc);
        TypeDescriptor<? extends IVilType> wDesc = TypeRegistry.getType(wrapperClass.getName());
        Assert.assertNotNull(wDesc);
        TypeDescriptor<? extends IVilType> pDesc;
        if (null != primitiveName) {
            pDesc = TypeRegistry.getType(primitiveName);
            Assert.assertNotNull(pDesc);
        } else {
            pDesc = null;
        }
        Assert.assertEquals(cDesc, vDesc);
        Assert.assertEquals(vDesc, wDesc);
        if (null != pDesc) {
            Assert.assertEquals(wDesc, pDesc);
        }
    }
    
    /**
     * Test for the existence of primitive / basic type descriptors and their equivalent
     * aliases.
     */
    @Test
    public void testBasicTypes() {
        testBasicType(PseudoInteger.class, "Integer", Integer.class, "int");
        testBasicType(PseudoReal.class, "Real", Double.class, "double");
        testBasicType(PseudoBoolean.class, "Boolean", Boolean.class, "boolean");
        testBasicType(PseudoString.class, "String", String.class, null);
    }

    /**
     * Tests for known conversions.
     */
    @Test
    public void testConversions() {
        TypeDescriptor<? extends IVilType> cDesc = TypeRegistry.getType(Integer.class.getName());
        Assert.assertNotNull(cDesc);
        Assert.assertTrue("there must be at least on conversion in Integer", cDesc.getConversionsCount() > 0);
        int count = 0;
        for (int c = 0; c < cDesc.getConversionsCount(); c++) {
            OperationDescriptor oDesc = cDesc.getConversion(c);
            if (CompatibilityResult.COMPATIBLE == oDesc.isCompatible(Double.TYPE, Integer.TYPE)) {
                count++;
            }
        }
        Assert.assertTrue("there must be exactly one int->double conversion", 1 == count);
    }
    
}
