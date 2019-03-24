package baranowski.model.contacts;

import baranowski.model.contacts.Contact;

public class Email implements Contact {

    private String identifier;

    @Override
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public String getIdentifier() {
        return identifier;
    }

    @Override
    public String toString() {
        return "Email{" +
                "identifier='" + identifier + '\'' +
                '}';
    }
}
