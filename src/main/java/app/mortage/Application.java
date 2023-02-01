package app.mortage;

import app.mortage.handler.MortageDataManager;

public class Application {
    public static void main(String[] args) {
        MortageDataManager manager = new MortageDataManager();
        manager.initDataFetch();
        manager.printAllMortages();
    }
}
