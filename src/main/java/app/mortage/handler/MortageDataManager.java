package app.mortage.handler;

import app.mortage.Mortage;

import java.util.HashMap;

public class MortageDataManager {
    private final HashMap<Integer, Mortage> mortages;

    public MortageDataManager() {
        mortages = new HashMap<>();
    }
}
