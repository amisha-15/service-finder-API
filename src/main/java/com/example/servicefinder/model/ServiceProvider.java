package com.example.servicefinder.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;


@Entity
public class ServiceProvider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Name is requried")
    private String name;

    @NotBlank(message = "Service type is required")
    private String service;

    @NotBlank(message = "City is required")
    private String city;

    @Pattern(regexp = "^[0-9]{10}$",message = "contact must be 10 digits")
    private String contact;

    //Getter
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getService() {
        return service;
    }

    public String getCity() {
        return city;
    }

    public String getContact() {
        return contact;
    }


//Setter

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setService(String service) {
        this.service = service;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
