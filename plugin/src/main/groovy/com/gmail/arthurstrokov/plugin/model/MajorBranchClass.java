package com.gmail.arthurstrokov.plugin.model;

public class MajorBranchClass {

    private MajorBranchClass() {
    }

    private static String majorBranch = "master";

    public static String majorBranch() {
        return majorBranch;
    }

    public static void majorBranch(String majorBranch) {
        MajorBranchClass.majorBranch = majorBranch;
    }
}
