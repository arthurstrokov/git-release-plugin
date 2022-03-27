package com.gmail.arthurstrokov.plugin.model;

public class PluginMajorBranch {

    private static String major = "master";

    private PluginMajorBranch() {
    }

    public static String major() {
        return major;
    }

    public static void setMajor(String major) {
        PluginMajorBranch.major = major;
    }
}
