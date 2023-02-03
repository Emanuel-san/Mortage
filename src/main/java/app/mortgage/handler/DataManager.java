package app.mortgage.handler;

import app.mortgage.Mortgage;
import app.mortgage.exceptions.IllegalArrayLengthException;

import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.HashMap;

public class DataManager {
    private final HashMap<Integer, Mortgage> mortgages;

    public DataManager() {
        mortgages = new HashMap<>();
    }
    public void addMortgage(String[] mortgageData) throws NumberFormatException, IllegalArrayLengthException {
        try {
            if(mortgageData.length == 4) {
                Mortgage newEntry = new Mortgage(mortgageData[0], Double.parseDouble(mortgageData[1]), Double.parseDouble(mortgageData[2]), Integer.parseInt(mortgageData[3]));
                mortgages.put(newEntry.getId(), newEntry);
            }
            else{
                throw new IllegalArrayLengthException("Array length passed to instantiate a Mortgage must always be 4, array length passed to method was " + mortgageData.length);
            }
        }
        catch (NumberFormatException e){
            throw e;
        }
    }
    public void initDataFetch(Path path){
        MortgageFileHandler handler = new MortgageFileHandler(this);
        try {
            handler.readFile(path);
        } catch (NoSuchFileException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
    public void printAllMortages(){
        mortgages.values().forEach(Mortgage::printCustomerMonthlyPayment);
    }
    public int mapSize(){
        return mortgages.size();
    }

}
