package com.zollnersolutions;
import com.fasterxml.jackson.databind.JsonNode;
import java.io.IOException;

public final class App {

    public static String makeUrl(String searchString) {
        String queryString;
        if (searchString.length() > 1) {
            queryString = searchString.replaceAll(" ", "+");
        } else {
            queryString = searchString;
        }
        return String.format("http://openlibrary.org/search.json?q=%s", queryString);
    }

    public static String ddcFromTitle(String searchUrl) throws IOException {
        JsonNode node = JsonUrlReader.get(searchUrl);
        return node.findValuesAsText("ddc_sort").toString();
    }
    public static void main(String[] args) throws IOException {
        //String userQuery = args[0];
        String userQuery = "moby dick";
        String queryUrl = makeUrl(userQuery);
        String ddc = ddcFromTitle(queryUrl);
        System.out.println(ddc);
    }
}
