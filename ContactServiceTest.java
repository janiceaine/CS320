package org.example.service;

import jakarta.validation.ValidationException;
import org.example.modules.Contact;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class ContactServiceTest {

    private org.example.service.ContactService contactService;
    private Contact validContact;

    @BeforeEach
    public void setUp() {
        contactService = new org.example.service.ContactService();
        validContact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Elm St");
    }

    @Test
    public void testAddContact() {
        // Add a valid contact
        contactService.addContact(validContact);

        // Print and verify that the contact was added
        Map<String, Contact> contacts = contactService.getContacts();
        Assertions.assertEquals(1, contacts.size());
        Assertions.assertEquals(validContact, contacts.get("1234567890"));
    }

    @Test
    public void testAddContactWithDuplicateIdThrowsException() {
        // Add the valid contact first
        contactService.addContact(validContact);

        // Attempting to add the same contact again should throw an exception
        Assertions.assertThrows(ValidationException.class, () -> {
            contactService.addContact(validContact);
        });
    }

    @Test
    public void testDeleteContact() {
        // Add and then delete a contact
        contactService.addContact(validContact);
        contactService.deleteContact("1234567890");

        // Print and verify that the contact has been deleted
        Map<String, Contact> contacts = contactService.getContacts();
        Assertions.assertEquals(0, contacts.size());
    }

    @Test
    public void testDeleteNonExistentContactDoesNothing() {
        // Delete a non-existent contact
        Assertions.assertThrows(ValidationException.class, () -> {
            contactService.deleteContact("nonexistent-id");
        });
    }

    @Test
    public void testUpdateContact() {
        // Add a contact and then update it
        contactService.addContact(validContact);
        contactService.updateContact("1234567890", "Jane", null, null, "456 Oak St");

        // Print and verify that the contact has been updated
        Contact updatedContact = contactService.getContacts().get("1234567890");
        Assertions.assertEquals("Jane", updatedContact.getFirstName());
        Assertions.assertEquals("Doe", updatedContact.getLastName()); // Last name should remain unchanged
        Assertions.assertEquals("456 Oak St", updatedContact.getAddress());
    }

    @Test
    public void testUpdateNonExistentContactThrowsException() {
        // Attempting to update a non-existent contact should throw an exception
        Assertions.assertThrows(ValidationException.class, () -> {
            contactService.updateContact("nonexistent-id", "Jane", null, null, "456 Oak St");
        });
    }
}