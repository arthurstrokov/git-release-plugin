package com.gmail.arthurstrokov.plugin.model;

public class MajorBranch {

    private static String branch = "master";

    private MajorBranch() {
    }

    public static String getMajorBranch() {
        return branch;
    }

    public static void setMajorBranch(String majorBranch) {
        MajorBranch.branch = majorBranch;
    }
}
