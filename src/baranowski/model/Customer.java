package baranowski.model;

import baranowski.model.contacts.Contact;

import java.util.ArrayList;
import java.util.Arrays;

public class Customer {
    private String name;
    private String surname;
    private String city;
    private String age;
    private ArrayList<Contact> contacts;

    public Customer(String name, String surname, String age, String city, ArrayList<Contact> contacts) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.city = city;
        this.contacts = contacts;
    }

    public Customer(String name, String surname, String city, ArrayList<Contact> contacts) {
        this.name = name;
        this.surname = surname;
        this.city = city;
        this.contacts = contacts;
    }


    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", city='" + city + '\'' +
                ", age='" + age + '\'' +
                ", contacts=["+ Arrays.toString(contacts.toArray())+
                '}';
    }
}