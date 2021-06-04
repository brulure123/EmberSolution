package com.zedlab.embersolutionofficial.Models.Entity;

public class User {

    private String fullName;
    private String emailAddress;
    private String password;
    private String phoneNumber;
    private GeoCoord location;
    private String physicalAddress;
    private String imageUri;

    public User() {
    }

    public User(String fullName, String emailAddress, String password, String phoneNumber, GeoCoord location, String physicalAddress, String imageUri) {
        this.fullName = fullName;
        this.emailAddress = emailAddress;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.location = location;
        this.physicalAddress = physicalAddress;
        this.imageUri = imageUri;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public GeoCoord getLocation() {
        return location;
    }

    public void setLocation(GeoCoord location) {
        this.location = location;
    }

    public String getPhysicalAddress() {
        return physicalAddress;
    }

    public void setPhysicalAddress(String physicalAddress) {
        this.physicalAddress = physicalAddress;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }
}
