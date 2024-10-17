package de.iip_ecosphere.platform.support.aas.types;

import static de.iip_ecosphere.platform.support.aas.IdentifierType.*;
import static de.iip_ecosphere.platform.support.aas.types.common.Utils.*;

import java.util.Set;
import java.util.HashSet;
import java.util.concurrent.ExecutionException;

import de.iip_ecosphere.platform.support.Builder;
import de.iip_ecosphere.platform.support.aas.Aas.AasBuilder;
import de.iip_ecosphere.platform.support.aas.Entity.EntityBuilder;
import de.iip_ecosphere.platform.support.aas.Submodel.SubmodelBuilder;
import de.iip_ecosphere.platform.support.aas.SubmodelElementCollection.SubmodelElementCollectionBuilder;
import de.iip_ecosphere.platform.support.aas.*;
import de.iip_ecosphere.platform.support.aas.types.common.*;

import de.iip_ecosphere.platform.support.aas.types.ContactInformationsBuilder;
import de.iip_ecosphere.platform.support.aas.types.ContactInformations;
import de.iip_ecosphere.platform.support.aas.types.ContactInformationsBuilder.ContactInformationBuilder;
import de.iip_ecosphere.platform.support.aas.types.ContactInformationsBuilder.EmailBuilder;
import de.iip_ecosphere.platform.support.aas.types.ContactInformationsBuilder.FaxBuilder;
import de.iip_ecosphere.platform.support.aas.types.ContactInformationsBuilder.IPCommunicationBuilder;
import de.iip_ecosphere.platform.support.aas.types.ContactInformationsBuilder.PhoneBuilder;
import de.iip_ecosphere.platform.support.aas.types.ContactInformationsBuilder.RoleOfContactPerson;
import de.iip_ecosphere.platform.support.aas.types.ContactInformationsBuilder.TypeOfEmailAddress;
import de.iip_ecosphere.platform.support.aas.types.ContactInformationsBuilder.TypeOfFaxNumber;
import de.iip_ecosphere.platform.support.aas.types.ContactInformationsBuilder.TypeOfTelephone;
import de.iip_ecosphere.platform.support.aas.types.ContactInformations.ContactInformation;
import de.iip_ecosphere.platform.support.aas.types.ContactInformations.Email;
import de.iip_ecosphere.platform.support.aas.types.ContactInformations.Fax;
import de.iip_ecosphere.platform.support.aas.types.ContactInformations.IPCommunication;
import de.iip_ecosphere.platform.support.aas.types.ContactInformations.Phone;

import org.junit.Test;
import org.junit.Assert;
import test.de.iip_ecosphere.platform.support.aas.AbstractAasExample;

/**
* Tests {@link ContactInformationsBuilder} and {@link ContactInformations}.
*/
public class ContactInformationsBuilderTest extends AbstractAasExample {

    private static Reference testReference;
    private static Range testRange;
    private static SubmodelBuilder testSmBuilder;
    private static Set<String> stack = new HashSet<>();
    
    /**
    * Returns the test reference.
    *
    * @return the test reference
    */
    protected static Reference getTestReference() {
        return testReference;
    }
    
    /**
    * Returns the test range.
    *
    * @return the test range
    */
    protected static Range getTestRange() {
        return testRange;
    } 

    /**
    * Returns the a submodel builder, e.g., for ranges.
    *
    * @return the a submodel builder, e.g., for ranges
    */
    protected static SubmodelBuilder getSmBuilder() {
        return testSmBuilder;
    }
    
    @Override
    protected String getTestFileName(Aas aas) {
        return "ContactInformations-IDTA02002-1-0.spec";
    }

    @Override
    protected String getFolderName() {
        return "contactInformations-gen";
    }
    
    @Override
    public java.io.File[] getTargetFiles() {
        return new java.io.File[] {new java.io.File("./output/contactInformations.aasx")};
    }

    @Override
    protected void createAas() {
        Aas refAas = AasFactory.getInstance().createAasBuilder("ContactInformationsExampleRef", 
            "urn:::AAS:::ContactInformationsRefExample#").build();
        testReference = refAas.createReference(); // just for test instances, do not registerAas
        testSmBuilder = refAas.createSubmodelBuilder("test_sm", null);
        testRange = testSmBuilder.createRangeBuilder("test_rng", Type.AAS_INTEGER, 1, 2).build();
        
        AasBuilder aasBuilder = AasFactory.getInstance().createAasBuilder("ContactInformationsExample", 
            "urn:::AAS:::ContactInformationsExample#");
        aasBuilder.createAssetBuilder("ci", "urn:::Asset:::ci#", AssetKind.INSTANCE).build();

        ContactInformationsBuilder smBuilder = new ContactInformationsBuilder(aasBuilder, 
            "urn:::SM:::ContactInformations#");
        smBuilder.setCreateMultiLanguageProperties(isCreateMultiLanguageProperties());
        populate(smBuilder, 1);
        smBuilder.build();
        
        try {
            testAas(registerAas(aasBuilder));
        } catch (ExecutionException e) {
            e.printStackTrace(System.out);
            Assert.fail(e.getMessage());
        }
    }
    
    /**
     * Populates an example contact information builder.
     * 
     * @param builder the instance to populate
     * @param depth initialization recursion depth
     * @return {@code builder}
     */
    public static ContactInformationsBuilder populate(ContactInformationsBuilder builder, int depth) {
        ContactInformationBuilder contactInformationBuilder; 
        for (int card = 1; card <= 1; card++) { 
            contactInformationBuilder = builder.createContactInformationBuilder();
            if (!stack.contains("ContactInformation")) {
                stack.add("ContactInformation");
                populate(contactInformationBuilder, depth + 1);
                stack.remove("ContactInformation");
            }
            contactInformationBuilder.build();
        }
        return builder;
    }
    
    /**
    * Populates the SMEC ContactInformation.
    *
    * @param builder the builder to populate
    * @param depth recursion depth starting at 1
    */
    private static void populate(ContactInformationBuilder builder, int depth) {
        builder.setRoleOfContactPerson(toTestEnum(RoleOfContactPerson.class, "0173-1#07-AAS931#001"));
        builder.setNationalCode(toTestLangString("DE@de", "test@en"));
        builder.setLanguage(toTestString("de", "TEST"));
        builder.setTimeZone(toTestString("Z-12:00", "TEST"));
        builder.setCityTown(toTestLangString("Musterstadt@de", "test@en"));
        builder.setCompany(toTestLangString("ABC Company@en", "test@en"));
        builder.setDepartment(toTestLangString("Vertrieb@de", "test@en"));
        PhoneBuilder phoneBuilder;
        for (int card = 1; card <= 1; card++) { 
            phoneBuilder = builder.createPhoneBuilder();
            if (!stack.contains("Phone")) {
                stack.add("Phone");
                populate(phoneBuilder, depth + 1);
                stack.remove("Phone");
            }
            phoneBuilder.build();
        }
        FaxBuilder faxBuilder;
        for (int card = 1; card <= 1; card++) { 
            faxBuilder = builder.createFaxBuilder();
            if (!stack.contains("Fax")) {
                stack.add("Fax");
                populate(faxBuilder, depth + 1);
                stack.remove("Fax");
            }
            faxBuilder.build();
        }
        EmailBuilder emailBuilder;
        for (int card = 1; card <= 1; card++) { 
            emailBuilder = builder.createEmailBuilder();
            if (!stack.contains("Email")) {
                stack.add("Email");
                populate(emailBuilder, depth + 1);
                stack.remove("Email");
            }
            emailBuilder.build();
        }
        IPCommunicationBuilder iPCommunicationBuilder;
        for (int card = 1; card <= 1; card++) { 
            iPCommunicationBuilder = builder.createIPCommunicationBuilder();
            if (!stack.contains("IPCommunication")) {
                stack.add("IPCommunication");
                populate(iPCommunicationBuilder, depth + 1);
                stack.remove("IPCommunication");
            }
            iPCommunicationBuilder.build();
        }
        builder.setStreet(toTestLangString("Musterstrasse 1@de", "test@en"));
        builder.setZipcode(toTestLangString("12345@de", "test@en"));
        builder.setPOBox(toTestLangString("PF 1234@de", "test@en"));
        builder.setZipCodeOfPOBox(toTestLangString("12345@de", "test@en"));
        builder.setStateCounty(toTestLangString("Muster-Bundesland@de", "test@en"));
        builder.setNameOfContact(toTestLangString("", "test@en"));
        builder.setFirstName(toTestLangString("", "test@en"));
        builder.setMiddleNames(toTestLangString("", "test@en"));
        builder.setTitle(toTestLangString("", "test@en"));
        builder.setAcademicTitle(toTestLangString("", "test@en"));
        builder.setFurtherDetailsOfContact(toTestLangString("", "test@en"));
        builder.setAddressOfAdditionalLink(toTestString("", "TEST"));
    }
    
    /**
    * Populates the SMEC Phone.
    *
    * @param builder the builder to populate
    * @param depth recursion depth starting at 1
    */
    private static void populate(PhoneBuilder builder, int depth) {
        builder.setTelephoneNumber(toTestLangString("+491234567890@de", "test@en"));
        builder.setTypeOfTelephone(toTestEnum(TypeOfTelephone.class, "0173-1#07-AAS754#001"));
        builder.setAvailableTime(toTestLangString("Montag – Freitag 08:00 bis 16:00@de", "test@en"));
    }
    
    /**
    * Populates the SMEC Fax.
    *
    * @param builder the builder to populate
    * @param depth recursion depth starting at 1
    */
    private static void populate(FaxBuilder builder, int depth) {
        builder.setFaxNumber(toTestLangString("+491234567890@de", "test@en"));
        builder.setTypeOfFaxNumber(toTestEnum(TypeOfFaxNumber.class, "1"));
    }
    
    /**
    * Populates the SMEC Email.
    *
    * @param builder the builder to populate
    * @param depth recursion depth starting at 1
    */
    private static void populate(EmailBuilder builder, int depth) {
        builder.setEmailAddress(toTestString("email@muster-ag.de", "TEST"));
        builder.setPublicKey(toTestLangString("", "test@en"));
        builder.setTypeOfEmailAddress(toTestEnum(TypeOfEmailAddress.class, "0173-1#07-AAS754#001"));
        builder.setTypeOfPublicKey(toTestLangString("", "test@en"));
    }
    
    /**
    * Populates the SMEC IPCommunication.
    *
    * @param builder the builder to populate
    * @param depth recursion depth starting at 1
    */
    private static void populate(IPCommunicationBuilder builder, int depth) {
        builder.setAddressOfAdditionalLink(toTestString("", "TEST"));
        builder.setTypeOfCommunication(toTestString("Chat Video call", "TEST"));
        builder.setAvailableTime(toTestLangString("Montag – Freitag 08:00 bis 16:00@de", "test@en"));
    }
    
    @Override
    protected java.io.File getThumbnail() {
        return null;
    }
    
    /**
    * Tests the created AAS.
    *
    * @param aas the top-level AAS instance to test
    * @throws ExecutionException if property accesses fail during the test execution
    */
    private void testAas(Aas aas) throws ExecutionException {
        ContactInformations instance = new ContactInformations(aas);
        int depth = 0;
        if (!stack.contains("ContactInformation")) {
            stack.add("ContactInformation");
            test(instance.getContactInformation(1), depth + 1);
            stack.remove("ContactInformation");
        }
    }

    /**
    * Tests the SMEC ContactInformation.
    *
    * @param instance the instance to test
    * @param depth recursion depth starting at 1
    * @throws ExecutionException if property accesses/conversions fail
    */
    private static void test(ContactInformation instance, int depth) throws ExecutionException {
        assertEquals(toTestEnum(RoleOfContactPerson.class, "0173-1#07-AAS931#001"), first(instance.
            getRoleOfContactPerson()));
        Assert.assertNotNull(instance.getRoleOfContactPersonProperty());
        assertLangStringsEquals(toTestLangString("DE@de", "test@en"), first(instance.getNationalCode()));
        Assert.assertNotNull(instance.getNationalCodeProperty());
        assertEquals(toTestString("de", "TEST"), first(instance.getLanguage()));
        Assert.assertNotNull(instance.getLanguageProperty(1));
        assertEquals(toTestString("Z-12:00", "TEST"), first(instance.getTimeZone()));
        Assert.assertNotNull(instance.getTimeZoneProperty());
        assertLangStringsEquals(toTestLangString("Musterstadt@de", "test@en"), first(instance.getCityTown()));
        Assert.assertNotNull(instance.getCityTownProperty());
        assertLangStringsEquals(toTestLangString("ABC Company@en", "test@en"), first(instance.getCompany()));
        Assert.assertNotNull(instance.getCompanyProperty());
        assertLangStringsEquals(toTestLangString("Vertrieb@de", "test@en"), first(instance.getDepartment()));
        Assert.assertNotNull(instance.getDepartmentProperty());
        if (!stack.contains("Phone")) {
            stack.add("Phone");
            test(instance.getPhone(), depth + 1);
            stack.remove("Phone");
        }
        if (!stack.contains("Fax")) {
            stack.add("Fax");
            test(instance.getFax(), depth + 1);
            stack.remove("Fax");
        }
        if (!stack.contains("Email")) {
            stack.add("Email");
            test(instance.getEmail(), depth + 1);
            stack.remove("Email");
        }
        if (!stack.contains("IPCommunication")) {
            stack.add("IPCommunication");
            test(instance.getIPCommunication(1), depth + 1);
            stack.remove("IPCommunication");
        }
        assertLangStringsEquals(toTestLangString("Musterstrasse 1@de", "test@en"), first(instance.getStreet()));
        Assert.assertNotNull(instance.getStreetProperty());
        assertLangStringsEquals(toTestLangString("12345@de", "test@en"), first(instance.getZipcode()));
        Assert.assertNotNull(instance.getZipcodeProperty());
        assertLangStringsEquals(toTestLangString("PF 1234@de", "test@en"), first(instance.getPOBox()));
        Assert.assertNotNull(instance.getPOBoxProperty());
        assertLangStringsEquals(toTestLangString("12345@de", "test@en"), first(instance.getZipCodeOfPOBox()));
        Assert.assertNotNull(instance.getZipCodeOfPOBoxProperty());
        assertLangStringsEquals(toTestLangString("Muster-Bundesland@de", "test@en"), first(instance.getStateCounty(
            )));
        Assert.assertNotNull(instance.getStateCountyProperty());
        assertLangStringsEquals(toTestLangString("", "test@en"), first(instance.getNameOfContact()));
        Assert.assertNotNull(instance.getNameOfContactProperty());
        assertLangStringsEquals(toTestLangString("", "test@en"), first(instance.getFirstName()));
        Assert.assertNotNull(instance.getFirstNameProperty());
        assertLangStringsEquals(toTestLangString("", "test@en"), first(instance.getMiddleNames()));
        Assert.assertNotNull(instance.getMiddleNamesProperty());
        assertLangStringsEquals(toTestLangString("", "test@en"), first(instance.getTitle()));
        Assert.assertNotNull(instance.getTitleProperty());
        assertLangStringsEquals(toTestLangString("", "test@en"), first(instance.getAcademicTitle()));
        Assert.assertNotNull(instance.getAcademicTitleProperty());
        assertLangStringsEquals(toTestLangString("", "test@en"), first(instance.getFurtherDetailsOfContact()));
        Assert.assertNotNull(instance.getFurtherDetailsOfContactProperty());
        assertEquals(toTestString("", "TEST"), first(instance.getAddressOfAdditionalLink()));
        Assert.assertNotNull(instance.getAddressOfAdditionalLinkProperty());
    }
    
    /**
    * Tests the SMEC Phone.
    *
    * @param instance the instance to test
    * @param depth recursion depth starting at 1
    * @throws ExecutionException if property accesses/conversions fail
    */
    private static void test(Phone instance, int depth) throws ExecutionException {
        assertLangStringsEquals(toTestLangString("+491234567890@de", "test@en"), first(instance.getTelephoneNumber(
            )));
        Assert.assertNotNull(instance.getTelephoneNumberProperty());
        assertEquals(toTestEnum(TypeOfTelephone.class, "0173-1#07-AAS754#001"), first(instance.getTypeOfTelephone()));
        Assert.assertNotNull(instance.getTypeOfTelephoneProperty());
        assertLangStringsEquals(toTestLangString("Montag – Freitag 08:00 bis 16:00@de", "test@en"), first(instance.
            getAvailableTime()));
        Assert.assertNotNull(instance.getAvailableTimeProperty());
    }
    
    /**
    * Tests the SMEC Fax.
    *
    * @param instance the instance to test
    * @param depth recursion depth starting at 1
    * @throws ExecutionException if property accesses/conversions fail
    */
    private static void test(Fax instance, int depth) throws ExecutionException {
        assertLangStringsEquals(toTestLangString("+491234567890@de", "test@en"), first(instance.getFaxNumber()));
        Assert.assertNotNull(instance.getFaxNumberProperty());
        assertEquals(toTestEnum(TypeOfFaxNumber.class, "1"), first(instance.getTypeOfFaxNumber()));
        Assert.assertNotNull(instance.getTypeOfFaxNumberProperty());
    }
    
    /**
    * Tests the SMEC Email.
    *
    * @param instance the instance to test
    * @param depth recursion depth starting at 1
    * @throws ExecutionException if property accesses/conversions fail
    */
    private static void test(Email instance, int depth) throws ExecutionException {
        assertEquals(toTestString("email@muster-ag.de", "TEST"), first(instance.getEmailAddress()));
        Assert.assertNotNull(instance.getEmailAddressProperty());
        assertLangStringsEquals(toTestLangString("", "test@en"), first(instance.getPublicKey()));
        Assert.assertNotNull(instance.getPublicKeyProperty());
        assertEquals(toTestEnum(TypeOfEmailAddress.class, "0173-1#07-AAS754#001"), first(instance.
            getTypeOfEmailAddress()));
        Assert.assertNotNull(instance.getTypeOfEmailAddressProperty());
        assertLangStringsEquals(toTestLangString("", "test@en"), first(instance.getTypeOfPublicKey()));
        Assert.assertNotNull(instance.getTypeOfPublicKeyProperty());
    }
    
    /**
    * Tests the SMEC IPCommunication.
    *
    * @param instance the instance to test
    * @param depth recursion depth starting at 1
    * @throws ExecutionException if property accesses/conversions fail
    */
    private static void test(IPCommunication instance, int depth) throws ExecutionException {
        assertEquals(toTestString("", "TEST"), first(instance.getAddressOfAdditionalLink()));
        Assert.assertNotNull(instance.getAddressOfAdditionalLinkProperty());
        assertEquals(toTestString("Chat Video call", "TEST"), first(instance.getTypeOfCommunication()));
        Assert.assertNotNull(instance.getTypeOfCommunicationProperty());
        assertLangStringsEquals(toTestLangString("Montag – Freitag 08:00 bis 16:00@de", "test@en"), first(instance.
            getAvailableTime()));
        Assert.assertNotNull(instance.getAvailableTimeProperty());
    }
    
    /**
    * Tests declared enums.
    */
    @Test
    public void testEnums() {
        assertEnum(ContactInformationsBuilder.RoleOfContactPerson.values(), 
            v -> v.getValue() != null && v.getValueId() >= 0 && v.getSemanticId() != null);
        assertEnum(ContactInformationsBuilder.TypeOfEmailAddress.values(), 
            v -> v.getValue() != null && v.getValueId() >= 0 && v.getSemanticId() != null);
        assertEnum(ContactInformationsBuilder.TypeOfFaxNumber.values(), 
            v -> v.getValue() != null && v.getValueId() >= 0 && v.getSemanticId() != null);
        assertEnum(ContactInformationsBuilder.TypeOfTelephone.values(), 
            v -> v.getValue() != null && v.getValueId() >= 0 && v.getSemanticId() != null);
    }

}
