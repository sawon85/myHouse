package com.example.myhouse;


import com.example.myhouse.House.HouseAdapter;
import com.example.myhouse.Loan.loanProducts;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class AppManager {
    private static AppManager instance = null;

    private AppManager() {
        availableLoans = new ArrayList<>();
        sortedAvailableLoans = new ArrayList<>();
    }

    public static AppManager getInstance() {
        if (instance == null)
            instance = new AppManager();
        return instance;
    }

    String npkiPath = null;

    public String getNpkiPath() {return npkiPath; }
    public void setNpkiPath(String path) {this.npkiPath = path;}

    public String result;

    public ArrayList<String> account;

    public HouseAdapter houseAdapter;

    public ArrayList<loanProducts> loanProducts;
    public ArrayList<loanProducts> availableLoans;
    public ArrayList<loanProducts> sortedAvailableLoans;
}

