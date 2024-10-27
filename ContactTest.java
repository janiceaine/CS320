package org.example.modules;

import jakarta.validation.ValidationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactTest {

    private String validContactId;
    private String validFirstName;
    private String validLastName;
    private String validPhone;
    private String validAddress;

    @BeforeEach
    public void setUp() {
        validContactId = "1234567890";
        validFirstName = "John";
        validLastName = "Doe";
        validPhone = "1234567890";
        validAddress = "123 Elm St";
    }

    @Test
    public void testValidContactCreation() {
        // Create a valid contact and verify no exceptions are thrown
        Contact contact = new Contact(validContactId, validFirstName, validLastName, validPhone, validAddress);
        Assertions.assertNotNull(contact);
        Assertions.assertEquals(validContactId, contact.getContactId());
        Assertions.assertEquals(validFirstName, contact.getFirstName());
        Assertions.assertEquals(validLastName, contact.getLastName());
        Assertions.assertEquals(validPhone, contact.getPhone());
        Assertions.assertEquals(validAddress, contact.getAddress());
        System.out.println("Contact created successfully: " + contact);
    }

    @Test
    public void testContactIdCannotBeNull() {
        // Creating a contact with a null ID should throw ValidationException
        Assertions.assertThrows(ValidationException.class, () -> {
            new Contact(null, validFirstName, validLastName, validPhone, validAddress);
        });
    }

    @Test
    public void testFirstNameCannotBeNull() {
        // Creating a contact with a null first name should throw ValidationException
        Assertions.assertThrows(ValidationException.class, () -> {
            new Contact(validContactId, null, validLastName, validPhone, validAddress);
        });
    }

    @Test
    public void testLastNameCannotBeNull() {
        // Creating a contact with a null last name should throw ValidationException
        Assertions.assertThrows(ValidationException.class, () -> {
            new Contact(validContactId, validFirstName, null, validPhone, validAddress);
        });
    }

    @Test
    public void testPhoneMustBeExactly10Digits() {
        // Creating a contact with an invalid phone number should throw ValidationException
        Assertions.assertThrows(ValidationException.class, () -> {
            new Contact(validContactId, validFirstName, validLastName, "12345", validAddress); // Too short
        });
        Assertions.assertThrows(ValidationException.class, () -> {
            new Contact(validContactId, validFirstName, validLastName, "12345678901", validAddress); // Too long
        });
        Assertions.assertThrows(ValidationException.class, () -> {
            new Contact(validContactId, validFirstName, validLastName, null, validAddress); // Null phone number
        });
    }

    @Test
    public void testAddressCannotBeLongerThan30Characters() {
        // Creating a contact with an address longer than 30 characters should throw ValidationException
        Assertions.assertThrows(ValidationException.class, () -> {
            new Contact(validContactId, validFirstName, validLastName, validPhone, "This address is way too long and should not be allowed.");
        });
    }

    @Test
    public void testSetFirstNameSuccessfully() {
        // Test setting a valid first name
        Contact contact = new Contact(validContactId, validFirstName, validLastName, validPhone, validAddress);
        String newFirstName = "Jane";
        contact.setFirstName(newFirstName);

        // Verify that the first name was updated correctly
        Assertions.assertEquals(newFirstName, contact.getFirstName());
        System.out.println("First name updated successfully: " + contact);
    }

    @Test
    public void testSetFirstNameToNullShouldThrowValidationException() {
        // Test setting the first name to null should throw ValidationException
        Contact contact = new Contact(validContactId, validFirstName, validLastName, validPhone, validAddress);
        Assertions.assertThrows(ValidationException.class, () -> {
            contact.setFirstName(null);
        });
    }

    @Test
    public void testSetLastNameSuccessfully() {
        // Test setting a valid last name
        Contact contact = new Contact(validContactId, validFirstName, validLastName, validPhone, validAddress);
        String newLastName = "Smith";
        contact.setLastName(newLastName);

        // Verify that the last name was updated correctly
        Assertions.assertEquals(newLastName, contact.getLastName());
        System.out.println("Last name updated successfully: " + contact);
    }

    @Test
    public void testSetPhoneSuccessfully() {
        // Test setting a valid phone number
        Contact contact = new Contact(validContactId, validFirstName, validLastName, validPhone, validAddress);
        String newPhone = "0987654321";
        contact.setPhone(newPhone);

        // Verify that the phone number was updated correctly
        Assertions.assertEquals(newPhone, contact.getPhone());
        System.out.println("Phone number updated successfully: " + contact);
    }

    @Test
    public void testSetAddressSuccessfully() {
        // Test setting a valid address
        Contact contact = new Contact(validContactId, validFirstName, validLastName, validPhone, validAddress);
        String newAddress = "456 Oak St";
        contact.setAddress(newAddress);

        // Verify that the address was updated correctly
        Assertions.assertEquals(newAddress, contact.getAddress());
        System.out.println("Address updated successfully: " + contact);
    }
}