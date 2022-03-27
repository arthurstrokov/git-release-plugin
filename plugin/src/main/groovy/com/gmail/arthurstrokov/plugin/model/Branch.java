package com.gmail.arthurstrokov.plugin.model;

public class Branch {

    private static String major = "master";

    private Branch() {
    }

    public static String major() {
        return major;
    }

    public static void setMajor(String major) {
        Branch.major = major;
    }
}
