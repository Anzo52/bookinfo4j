package com.zollnersolutions;

import com.fasterxml.jackson.databind.JsonNode;
import java.io.IOException;
import org.json.JSONObject;

public final class App {
    public static void main(String[] args) throws IOException {
        //String userQuery = args[0];
        String userQuery = "moby dick";
        String searchString;
        if (userQuery.length() > 1) {
            searchString = userQuery.replaceAll(" ", "+");
        } else {
            searchString = userQuery;
        }
        String openlibUrl = "http://openlibrary.org/%s";
        String openlibSearchUrl = String.format("http://openlibrary.org/search.json?q=%s", searchString);
        String booksUrl = String.format(openlibUrl, "books");
        String authorsUrl = String.format(openlibUrl, "authors");
        String worksUrl = String.format(openlibUrl, "works");
        // use "search.json?q=" for ISBN

        String jstream = JsonUrlReader.stream(openlibSearchUrl);
        String jstring = JsonUrlReader.getString(openlibSearchUrl);
        JSONObject jobj = JsonUrlReader.getJson(openlibSearchUrl);
        JsonNode node = JsonUrlReader.get(openlibSearchUrl);

        System.out.println(jobj);

    }
}