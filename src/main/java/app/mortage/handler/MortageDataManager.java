package app.mortage.handler;

import app.mortage.Mortage;

import java.io.File;
import java.nio.file.Path;
import java.util.HashMap;

public class MortageDataManager {
    private final HashMap<Integer, Mortage> mortages;

    public MortageDataManager() {
        mortages = new HashMap<>();
    }
    public void addMortage(String[] mortageData){
        Mortage newEntry = new Mortage(mortageData[0], Double.parseDouble(mortageData[1]), Double.parseDouble(mortageData[2]), Integer.parseInt(mortageData[3]));
        mortages.put(newEntry.getId(), newEntry);
    }
    public void initDataFetch(){
        MortageFileHandler handler = new MortageFileHandler(this);
        Path path = Path.of(System.getProperty("user.dir") + File.separator + "prospects.txt");
        handler.readFile(path);
    }
    public void printAllMortages(){
        mortages.values().forEach(Mortage::printCustomerMonthlyPayment);
    }
}
