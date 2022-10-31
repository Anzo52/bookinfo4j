package com.zollnersolutions;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * The type Json url reader.
 */
public class JsonUrlReader {

    /**
     * Stream string.
     *
     * @param url the url
     * @return the string
     * @throws IOException the io exception
     */
    public static String stream(String url) throws IOException {
        try (InputStream input = new URL(url).openStream()) {
            InputStreamReader isr = new InputStreamReader(input, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(isr);
            StringBuilder json = new StringBuilder();
            int c;
            while ((c = reader.read()) != -1) {
                json.append((char) c);
            }
            return json.toString();
        }
    }

    /**
     * Get json node.
     *
     * @param url the url
     * @return the json node
     * @throws IOException the io exception
     */
    public static JsonNode get(String url) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readTree(new URL(url));
    }

    /**
     * Get t.
     *
     * @param <T>  the type parameter
     * @param url  the url
     * @param type the type
     * @return the t
     * @throws IOException the io exception
     */
    public static <T> T get(String url, Class<T> type) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new URL(url), type);
    }

    /**
     * Gets string.
     *
     * @param url the url
     * @return the string
     * @throws IOException the io exception
     */
    public static String getString(String url) throws IOException {
        return get(url).toPrettyString();
    }

    /**
     * Gets json.
     *
     * @param url the url
     * @return the json
     * @throws IOException the io exception
     */
    public static JSONObject getJson(String url) throws IOException {
        String json = IOUtils.toString(new URL(url), StandardCharsets.UTF_8);
        JSONObject object;
        try {
            object = new JSONObject(json);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return object;
    }
}
