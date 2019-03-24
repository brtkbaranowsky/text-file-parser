package baranowski.model.contacts;

public class ContactFactory {
    public static Contact getContact(String contactType) {
        if (contactType == null || contactType.equals("")) {
            return null;
        }
        if (contactType.equalsIgnoreCase("JABBER")) {
            return new Jabber();
        } else if (contactType.equalsIgnoreCase("PHONE")) {
            return new Phone();
        } else if (contactType.equalsIgnoreCase("ICQ")) {
            return new Icq();
        } else if (contactType.equalsIgnoreCase("EMAIL")) {
            return new Email();
        } else {
            return new Unknown();
        }
    }
}
