package com.zollnersolutions;


import java.io.IOException;

public final class App {
    public static void main(String[] args) throws IOException {
        String userQuery = args[0];
        String openlibQUrl = "http://openlibrary.org/search.json?q=%s";
    }
}
