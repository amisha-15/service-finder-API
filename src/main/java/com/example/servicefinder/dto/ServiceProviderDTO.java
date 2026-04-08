package com.example.servicefinder.dto;

import jakarta.validation.constraints.*;

public class ServiceProviderDTO {

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Service is required")
    private String service;

    @NotBlank(message = "City is required")
    private String city;

    @Pattern(regexp = "^[0-9]{10}$", message = "Contact must be 10 digits")
    private String contact;

    // getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
