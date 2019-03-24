package baranowski.services;

import baranowski.model.contacts.Contact;
import baranowski.model.contacts.ContactFactory;
import baranowski.model.Customer;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public class XmlReaderService {
    DocumentBuilderFactory factory;
    DocumentBuilder builder;


    public ArrayList<Customer> getCustomersFromXmlFile(String filePath) {

        factory = DocumentBuilderFactory.newDefaultInstance();
        ArrayList<Customer> customerList = new ArrayList<>();

        String name;
        String surname;
        String age = null;
        String city;

        try {
            builder = factory.newDocumentBuilder();
            Document doc = builder.parse(filePath);
            NodeList persons = doc.getElementsByTagName("person");

            for (int i = 0; i < persons.getLength(); i++) {
                Element person = (Element) persons.item(i);


                name = person.getElementsByTagName("name").item(0).getTextContent();
                surname = person.getElementsByTagName("surname").item(0).getTextContent();

                if (person.getElementsByTagName("age").getLength() > 0) {
                    age = person.getElementsByTagName("age").item(0).getTextContent();
                }

                city = person.getElementsByTagName("city").item(0).getTextContent();

                NodeList contacts = doc.getElementsByTagName("contacts");
                Element contact = (Element) contacts.item(i);
                NodeList contactForm = contact.getElementsByTagName("*");

                ArrayList<Contact> contactList = new ArrayList<>();

                for (int j = 0; j < contactForm.getLength(); j++) {
                    Element specificContact = (Element) contactForm.item(j);
                    Contact cont = ContactFactory.getContact(specificContact.getTagName());
                    cont.setIdentifier(specificContact.getTextContent());
                    contactList.add(cont);
                }
                if (age != null) {
                    customerList.add(new Customer(name, surname, age, city, contactList));
                } else {
                    customerList.add(new Customer(name, surname, city, contactList));
                }
            }
            return customerList;


        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
        return null;
    }
}
