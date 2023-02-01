package app.mortage.handler;

import app.mortage.Mortage;

import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.HashMap;

public class DataManager {
    private final HashMap<Integer, Mortage> mortages;

    public DataManager() {
        mortages = new HashMap<>();
    }
    public void addMortage(String[] mortageData){
        Mortage newEntry = new Mortage(mortageData[0], Double.parseDouble(mortageData[1]), Double.parseDouble(mortageData[2]), Integer.parseInt(mortageData[3]));
        mortages.put(newEntry.getId(), newEntry);
    }
    public void initDataFetch(Path path){
        MortageFileHandler handler = new MortageFileHandler(this);
        try {
            handler.readFile(path);
        } catch (NoSuchFileException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
    public void printAllMortages(){
        mortages.values().forEach(Mortage::printCustomerMonthlyPayment);
    }
    public int mapSize(){
        return mortages.size();
    }

}
