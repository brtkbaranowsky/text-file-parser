package baranowski.model;

public class Contact {
    private int id;
    private int customerId;
    private ContactType contactType;
    private String contactValue;

    private enum ContactType {UNKNOWN, EMAIL, PHONE, JABBER, IQR}



}


