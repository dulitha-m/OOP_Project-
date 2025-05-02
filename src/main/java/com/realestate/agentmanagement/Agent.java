package com.realestate.agentmanagement;

import java.io.Serializable;

public class Agent implements Serializable {
    private int id;
    private String name;
    private String contact;
    private double rating;
    private String specialization;

    public Agent(int id, String name, String contact, double rating, String specialization) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.rating = rating;
        this.specialization = specialization;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}