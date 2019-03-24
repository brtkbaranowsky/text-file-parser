package baranowski.model.contacts;

import baranowski.model.contacts.Contact;

public class Jabber implements Contact {
    private String identifier;

    @Override
    public String getIdentifier() {
        return identifier;
    }

    @Override
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public String toString() {
        return "Jabber{" +
                "identifier='" + identifier + '\'' +
                '}';
    }
}
