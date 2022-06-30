package com.example.first.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
public class NotificationToSupervisor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Pattern(regexp = "^[a-zA-Z]+$", message = "First name should be only letters, mandatory")
    private String firstName;

    @Pattern(regexp = "^[a-zA-Z]+$", message = "Last name should be only letters, mandatory")
    private String lastName;

    @Email(message = "Email is not valid")
    private String email;

    @Pattern(regexp = "^(\\([0-9]{3}\\) |[0-9]{3}-)[0-9]{3}-[0-9]{4}$", message = "Phone number format was not matched")
    private String phoneNumber;

    @NotBlank(message = "Supervisor is required.")
    private String supervisorIdentificationNumber;

    public NotificationToSupervisor() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSupervisorIdentificationNumber() {
        return supervisorIdentificationNumber;
    }

    public void setSupervisorIdentificationNumber(String supervisorIdentificationNumber) {
        this.supervisorIdentificationNumber = supervisorIdentificationNumber;
    }
}
