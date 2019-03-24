package baranowski.controllers;

import baranowski.model.Customer;
import baranowski.services.EmailAdressValidationService;
import baranowski.services.PhoneNumberValidationService;
import baranowski.services.TxtReaderService;
import baranowski.services.XmlReaderService;

import java.io.IOException;
import java.util.ArrayList;

public class ReadingController {
    private TxtReaderService txtReaderService;
    private XmlReaderService xmlReaderService;

    public ReadingController() {
        this.txtReaderService = new TxtReaderService(new EmailAdressValidationService(),
                new PhoneNumberValidationService());
        this.xmlReaderService = new XmlReaderService();
    }

    public ArrayList<Customer> parseFile(String filePath) throws IOException {
        if (filePath.endsWith(".txt")) {
            return txtReaderService.getCustomerListFromTxt(filePath);
        } else if (filePath.endsWith(".xml")) {
            return xmlReaderService.getCustomersFromXmlFile(filePath);
        } else {
            return null;
        }
    }
}
