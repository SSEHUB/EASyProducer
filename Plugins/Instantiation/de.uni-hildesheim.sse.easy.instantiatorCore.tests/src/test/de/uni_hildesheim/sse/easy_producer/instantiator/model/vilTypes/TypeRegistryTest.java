package test.de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes;

import java.util.HashSet;

import org.junit.Assert;
import org.junit.Test;

import test.de.uni_hildesheim.sse.easy_producer.instantiator.model.AbstractTest;
import test.de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.testArtifacts.FailingInstantiator1;
import test.de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.testArtifacts.FailingInstantiator2;
import test.de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.testArtifacts.FailingInstantiator3;
import test.de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.testArtifacts.FailingInstantiator4;
import test.de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.testArtifacts.FailingInstantiator5;
import test.de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.testArtifacts.InstanceInstantiator;
import test.de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.testArtifacts.StaticInstantiator;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.xml.XmlFileArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.VilException;

/**
 * Tests the type registry.
 * 
 * @author Holger Eichelberger
 */
public class TypeRegistryTest extends AbstractTest {

    /**
     * Tests whether the build-in default types are registered.
     */
    @Test
    public void testDefaultTypes() {
        // by design, the TypeDescriptor shall not provide access to the underlying class!
        // fragile test
        HashSet<String> expected = new HashSet<String>();
        expected.add("FileArtifact");
        expected.add("FolderArtifact");
        expected.add("XmlFileArtifact");
        expected.add("Configuration");
        expected.add("Project");
        expected.add("Attribute");
        for (String name : expected) {
            TypeDescriptor<? extends IVilType> desc = TypeRegistry.DEFAULT.getType(name);
            Assert.assertNotNull("default type descriptor shall exist", desc);
            Assert.assertEquals("at least the name shall match - no access to actual class", name, desc.getName());
        }        
        for (TypeDescriptor<?> descriptor : TypeRegistry.DEFAULT.allTypes()) {
            expected.remove(descriptor.getName());
        }
        Assert.assertTrue("not all expected default types registered", expected.isEmpty());
    }
    
    /**
     * Tests extension artifact types.
     */
    @Test
    public void testTypeExtension() {
        // use qualified names in here to avoid confusion with already registered artifacts in
        // further tests in this class
        final Class<? extends IVilType> myArtifactClass = test.de.uni_hildesheim.sse.easy_producer.instantiator.model
            .vilTypes.testArtifacts.MyArtifact.class;
        try {
            TypeRegistry.DEFAULT.registerType(XmlFileArtifact.class);
            Assert.fail("already registered");
        } catch (VilException e) {
            Assert.assertEquals("exception id does not match", VilException.ID_ALREADY_REGISTERED, e.getId());
        }
        try {
            TypeRegistry.DEFAULT.registerType(test.de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes
                .testArtifacts.FileArtifact.class);
        } catch (VilException e) {
            Assert.fail("overriding a default artifact with same name in same hierarchy shall work");
        }
        try {
            TypeRegistry.DEFAULT.registerType(myArtifactClass);
        } catch (VilException e) {
            if (e.getId() == VilException.ID_ALREADY_REGISTERED) {
                Assert.fail("did the TypeDescriptorTest run before this test?");
            } else {
                Assert.fail("adding a new artifact shall work");
            }
        }
        try {
            TypeRegistry.DEFAULT.registerType(test.de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes
                .testArtifacts.MySubArtifact.class);
        } catch (VilException e) {
            if (e.getId() == VilException.ID_ALREADY_REGISTERED) {
                Assert.fail("did the TypeDescriptorTest run before this test?");
            } else {
                Assert.fail("adding a new artifact shall work");
            }
        }

        // all default types shall still be present
        testDefaultTypes();

        String expectedName = myArtifactClass.getSimpleName();
        TypeDescriptor<? extends IVilType> desc = TypeRegistry.DEFAULT.getType(expectedName);
        Assert.assertNotNull("new type shall exist", desc);
        Assert.assertEquals("at least the name shall be the same", desc.getName(), expectedName);
        assertOperationDeclaringTypes(desc);

        // shall be the same
        desc = TypeRegistry.DEFAULT.getType(myArtifactClass.getSimpleName());
        Assert.assertNotNull("new type shall exist", desc);
        Assert.assertEquals("at least the name shall be the same", desc.getName(), expectedName);
        assertOperationDeclaringTypes(desc);
    }
    
    /**
     * Asserts the correct declaring type for operation descriptors.
     * 
     * @param descriptor the type descriptor to be checked
     */
    private void assertOperationDeclaringTypes(TypeDescriptor<? extends IVilType> descriptor) {
        for (OperationDescriptor operation : descriptor.getOperations()) {
            Assert.assertNotNull("declaring type of operation " + operation.getJavaSignature() + "is null", 
                operation.getDeclaringType());
        }
    }
    
    /**
     * Tests the instantiators.
     */
    @Test
    public void testInstantiators() {
        testInstantiator(StaticInstantiator.class, null);
        testInstantiator(InstanceInstantiator.class, null);
        // failing must be after successful to cause double registration situation
        testInstantiator(FailingInstantiator1.class, VilException.ID_MISSING_DATA);
        testInstantiator(FailingInstantiator2.class, VilException.ID_INVALID_INSTANTIATOR); // TODO error codes
        testInstantiator(FailingInstantiator3.class, VilException.ID_INVALID_INSTANTIATOR);
        testInstantiator(FailingInstantiator4.class, VilException.ID_INVALID_INSTANTIATOR);
        testInstantiator(FailingInstantiator5.class, VilException.ID_INVALID_INSTANTIATOR);
    }
    
    /**
     * Tests a single instantiator registration.
     * 
     * @param cls the instantiator class.
     * @param expectedExceptionCode the expected error code (see exceptions), may be <b>null</b> 
     *     if none is expected
     */
    private void testInstantiator(Class<? extends IVilType> cls, Integer expectedExceptionCode) {
        try {
            TypeRegistry.DEFAULT.registerType(cls);
        } catch (VilException e) {
            if (null == expectedExceptionCode) {
                Assert.fail("unexpected exception: " + e.getMessage());
            } else {
                Assert.assertEquals("unexpected exception id ", expectedExceptionCode.intValue(), e.getId());
            }
        }
    }

}
