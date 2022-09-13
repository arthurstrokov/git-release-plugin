package com.gmail.arthurstrokov.plugin.service;

import com.gmail.arthurstrokov.plugin.util.VersionNumberComparator;

import java.util.Arrays;
import java.util.List;

public class SortService {
    private SortService() {
    }

    public static List<String> sortTags(String[] strings) {
        Arrays.sort(strings, new VersionNumberComparator());
        return Arrays.asList(strings);
    }
}
