package baranowski;

import baranowski.controllers.ReadingController;
import baranowski.model.Customer;
import baranowski.model.Datasource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Main.class.getName());
        final String FILE_PATH_1 = "dane-osoby.txt";
        final String FILE_PATH_2 = "dane-osoby.xml";

        ReadingController readingController = new ReadingController();
        Datasource datasource = new Datasource();
        try {
            datasource.open();

            ArrayList<Customer> customers1 = readingController.parseFile(FILE_PATH_1);
            ArrayList<Customer> customers =  readingController.parseFile(FILE_PATH_2);

            if(customers !=null && customers1 != null) {
                for (Customer customer : customers
                ) {
                    logger.info(customer.toString());
                }

                for (Customer customer : customers1
                ) {
                    logger.info(customer.toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
