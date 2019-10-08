package com.example.myhouse;


import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class AppManager {
    private static AppManager instance = null;

    private AppManager() {
    }

    public static AppManager getInstance() {
        if (instance == null)
            instance = new AppManager();
        return instance;
    }

    String npkiPath = null;

    public String getNpkiPath() {return npkiPath; }
    public void setNpkiPath(String path) {this.npkiPath = path;}
}

