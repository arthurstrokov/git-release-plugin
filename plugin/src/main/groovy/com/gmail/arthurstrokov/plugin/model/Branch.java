package com.gmail.arthurstrokov.plugin.model;

public class Branch {

    private Branch() {
    }

    private static String major = "master";


    public static String major() {
        return major;
    }

    public static void setMajor(String major) {

        Branch.major = major;
    }
}
