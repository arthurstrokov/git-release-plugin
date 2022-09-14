package com.gmail.arthurstrokov.plugin.model;

public class MajorBranch {
    private MajorBranch() {
    }

    private static String branch = "master";

    public static String majorBranch() {
        return branch;
    }

    public static void majorBranch(String majorBranch) {
        MajorBranch.branch = majorBranch;
    }
}
