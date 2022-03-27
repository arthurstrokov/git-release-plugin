package com.gmail.arthurstrokov.plugin.model;

public class PluginBranchModel {

    private static String major = "master";

    private PluginBranchModel() {
    }

    public static String major() {
        return major;
    }

    public static void setMajor(String major) {
        PluginBranchModel.major = major;
    }
}
