package com.bb.mylistview2;

import java.util.ArrayList;
import java.util.List;

public class ContactsList {
    // Builds a static contact list with data, for easy import to use as the app contact list
    public static List<Contact> getContacts() {
      List<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact(
                "Tom Hardy",
                "https://api.androidhive.info/json/images/tom_hardy.jpg",
                "(541) 754-3010"
        ));
        contacts.add(new Contact(
                "Johnny Depp",
                "https://api.androidhive.info/json/images/johnny.jpg",
                "(452) 839-1210"
        ));
        contacts.add(new Contact(
                "Tom Cruise",
                "https://api.androidhive.info/json/images/tom_cruise.jpg",
                "(541) 453-2311"
        ));
        contacts.add(new Contact(
                "Keira Knightley",
                "https://api.androidhive.info/json/images/keira.jpg",
                "(535) 324-4334"
        ));
        contacts.add(new Contact(
                "Robert De Niro",
                "https://api.androidhive.info/json/images/robert_de.jpg",
                "(534) 325-4325"
        ));
        contacts.add(new Contact(
                "Leonardo DiCaprio",
                "https://api.androidhive.info/json/images/leonardo.jpg",
                "(564) 333-2452"
        ));
        contacts.add(new Contact(
                "Will Smith",
                "https://api.androidhive.info/json/images/will.jpg",
                "(541) 879-3453"
        ));
        contacts.add(new Contact(
                "Russell Crowe",
                "https://api.androidhive.info/json/images/russell.jpg",
                "(234) 234-3321"
        ));
        contacts.add(new Contact(
                "Brad Pitt",
                "https://api.androidhive.info/json/images/brad.jpg",
                "(567) 754-8945"
        ));
        contacts.add(new Contact(
                "Angelina Jolie",
                "https://api.androidhive.info/json/images/angelina.jpg",
                "(324) 754-5433"
        ));
        contacts.add(new Contact(
                "Kate Winslet",
                "https://api.androidhive.info/json/images/kate.jpg",
                "(788) 343-3433"
        ));
        contacts.add(new Contact(
                "Christian Bale",
                "https://api.androidhive.info/json/images/christian.jpg",
                "(865) 755-3555"
        ));
        contacts.add(new Contact(
                "Morgan Freeman",
                "https://api.androidhive.info/json/images/morgan.jpg",
                "(445) 776-9076"
        ));
        contacts.add(new Contact(
                "Hugh Jackman",
                "https://api.androidhive.info/json/images/hugh.jpg",
                "(544) 454-4544"
        ));
        contacts.add(new Contact(
                "Keanu Reeves",
                "https://api.androidhive.info/json/images/keanu.jpg",
                "(454) 455-5445"
        ));
        contacts.add(new Contact(
                "Tom Hanks",
                "https://api.androidhive.info/json/images/tom.jpg",
                "(541) 454-4544"
        ));
        contacts.add(new Contact(
                "Scarlett Johansson",
                "https://api.androidhive.info/json/images/scarlett.jpg",
                "(545) 454-2567"
        ));
        contacts.add(new Contact(
                "Robert Downey Jr.",
                "https://api.androidhive.info/json/images/robert.jpg",
                "(444) 444-4444"
        ));
        return contacts;
    }
}
