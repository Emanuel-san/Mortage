package app.mortage;

import app.mortage.handler.MortageFileHandler;

import java.io.File;
import java.nio.file.Path;

public class Application {
    public static void main(String[] args) {
//        Mortage p = new Mortage("Juha",1000,5,2);
//        p.printCustomerMonthlyPayment();
        MortageFileHandler handler = new MortageFileHandler();
        Path path = Path.of(System.getProperty("user.dir") + File.separator + "prospects.txt");
        handler.readFile(path);
    }
}
