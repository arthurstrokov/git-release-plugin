package com.gmail.arthurstrokov.plugin.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFromFile {
    public static List<String> readFromFile() {
        List<String> branches = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("branches.txt"))) {
            while (scanner.hasNext()) {
                branches.add(scanner.nextLine());
            }
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
        return branches;
    }
}
