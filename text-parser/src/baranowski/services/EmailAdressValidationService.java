package baranowski.services;

public class EmailAdressValidationService {
    private final String EMAIL_REGEX ="[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

    public boolean isEmailValid(String email){
        return email.matches(EMAIL_REGEX);
    }
}
