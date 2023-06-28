package com.example.mountainapp;

import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MountainList {

    private static MountainList instance;
    private List<MountainPeak> mountainList;

    private MountainList() {
        mountainList = new ArrayList<>();
    }

    public static MountainList getInstance() {
        if (instance == null) {
            instance = new MountainList();
        }
        return instance;
    }

    public List<MountainPeak> getMountainList() {
        return mountainList;
    }

    public void addMountain(MountainPeak mountain) {
        if ((mountain.getMountainPeak() != null) && (mountain.getHeight() != 0)) {
            mountainList.add(mountain);
        }
    }

    public void clearMountainList() {
        mountainList.clear();
    }
}