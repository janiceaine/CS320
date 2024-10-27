package org.example.modules;

import jakarta.validation.ValidationException;

public class Contact {
    private final String contactId; // Unique ID, not updatable
    private String firstName; // First name, updatable
    private String lastName; // Last name, updatable
    private String phone; // Phone number, not updatable
    private String address; // Address, updatable

    // Constructor
    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        if (contactId == null || contactId.length() > 10) {
            throw new ValidationException("Contact ID cannot be null or longer than 10 characters.");
        }
        if (firstName == null || firstName.length() > 10) {
            throw new ValidationException("First name cannot be null or longer than 10 characters.");
        }
        if (lastName == null || lastName.length() > 10) {
            throw new ValidationException("Last name cannot be null or longer than 10 characters.");
        }
        if (phone == null || phone.length() != 10 || !phone.matches("\\d{10}")) {
            throw new ValidationException("Phone number must be exactly 10 digits.");
        }
        if (address == null || address.length() > 30) {
            throw new ValidationException("Address cannot be null or longer than 30 characters.");
        }

        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    // Getters
    public String getContactId() {
        return contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    // Setters (for updatable fields)
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new ValidationException("First name cannot be null or longer than 10 characters.");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new ValidationException("Last name cannot be null or longer than 10 characters.");
        }
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        if (phone == null || phone.length() != 10 || !phone.matches("\\d{10}")) {
            throw new ValidationException("Phone number must be exactly 10 digits.");
        }
        this.phone = phone;
    }

    public void setAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new ValidationException("Address cannot be null or longer than 30 characters.");
        }
        this.address = address;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "contactId='" + contactId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}