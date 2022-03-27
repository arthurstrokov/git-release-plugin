package com.gmail.arthurstrokov.plugin;

public class MajorBranch {

    private MajorBranch() {
    }

    private static String major = "master";

    public static String getMajor() {
        return major;
    }

    public static void setMajor(String major) {
        MajorBranch.major = major;
    }
}
