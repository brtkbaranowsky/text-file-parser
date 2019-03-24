package baranowski.services;

import baranowski.model.Customer;
import baranowski.model.contacts.Contact;
import baranowski.model.contacts.ContactFactory;
import baranowski.model.contacts.Phone;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class TxtReaderService {

    private final String CSV_SPLIT_BY = ",";
    private final int NAME_INDEX = 0;
    private final int SURNAME_INDEX = 1;
    private final int AGE_INDEX = 2;
    private final int CITY_INDEX = 3;
    private final int FIRST_CONTACT_INDEX = 4;

    private EmailAdressValidationService emailAdressValidationService;
    private PhoneNumberValidationService phoneNumberValidationService;
    private BufferedReader bufferedReader;

    public TxtReaderService(EmailAdressValidationService emailAdressValidationService, PhoneNumberValidationService phoneNumberValidationService) {
        this.emailAdressValidationService = emailAdressValidationService;
        this.phoneNumberValidationService = phoneNumberValidationService;
    }

    public ArrayList<Customer> getCustomerListFromTxt(String pathToFile) throws IOException {


        bufferedReader = new BufferedReader(new FileReader(pathToFile));
        ArrayList<Customer> customers = new ArrayList<>();

        String line = bufferedReader.readLine();
        while (line != null) {

            String name;
            String surname;
            String age = null;
            String city;
            ArrayList<Contact> contacts = new ArrayList<>();
            String[] splitLine = line.split(CSV_SPLIT_BY);
            System.out.println(splitLine);
            if (splitLine[NAME_INDEX] != null)
                name = splitLine[NAME_INDEX];
            else {
                break;
            }
            if (splitLine[SURNAME_INDEX] != null) {
                surname = splitLine[SURNAME_INDEX];
            } else {
                break;
            }
            if (splitLine[CITY_INDEX] != null) {
                city = splitLine[CITY_INDEX];
            } else {
                break;
            }
            age = splitLine[AGE_INDEX];

            for (int i = FIRST_CONTACT_INDEX; i < splitLine.length; i++) {

                //Contact type logic
                Contact contact;
                if (emailAdressValidationService.isEmailValid(splitLine[i])) {
                    contact = ContactFactory.getContact("EMAIL");
                } else if (phoneNumberValidationService.validatePhoneNumber(splitLine[i])) {
                    contact = ContactFactory.getContact("PHONE");
                } else {
                    contact = ContactFactory.getContact(splitLine[i]);
                }
                if (contact != null) {
                    contact.setIdentifier(splitLine[i]);
                    contacts.add(contact);
                }
            }
            if (age == null) {
                customers.add(new Customer(name, surname, city, contacts));
            } else {
                customers.add(new Customer(name, surname, age, city, contacts));
            }

            line = bufferedReader.readLine();
        }
        return customers;
    }
}


