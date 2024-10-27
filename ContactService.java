package org.example.service;

import jakarta.validation.ValidationException;
import org.example.modules.Contact;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private final Map<String, Contact> contacts; // Stores contacts in memory

    public ContactService() {
        contacts = new HashMap<>();
    }

    // Method to add a new contact
    public void addContact(Contact contact) {
        if (contacts.containsKey(contact.getContactId())) {
            throw new ValidationException("Contact with this ID already exists.");
        }
        contacts.put(contact.getContactId(), contact);
        System.out.println("Contact added: " + contact);
    }

    // Method to delete a contact by ID
    public void deleteContact(String contactId) {
        if (contacts.remove(contactId) == null) {
            throw new ValidationException("No contact found with this ID.");
        } else {
            System.out.println("Contact with ID " + contactId + " deleted.");
        }
    }

    // Method to update contact fields by ID
    public void updateContact(String contactId, String firstName, String lastName, String phone, String address) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new ValidationException("No contact found with this ID.");
        }
        if (firstName != null) {
            contact.setFirstName(firstName);
        }
        if (lastName != null) {
            contact.setLastName(lastName);
        }
        if (phone != null) {
            contact.setPhone(phone);
        }
        if (address != null) {
            contact.setAddress(address);
        }
        System.out.println("Contact updated: " + contact);
    }

    // Method to retrieve all contacts
    public Map<String, Contact> getContacts() {
        return new HashMap<>(contacts); // Return a copy to avoid external modifications
    }
}
