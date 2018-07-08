package com.bb.mylistview2;

public class Contact {
    private String name;
    private String imageUrl;
    private String phoneNumber;

    public Contact(String name, String imageUrl, String phoneNumber) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

}
