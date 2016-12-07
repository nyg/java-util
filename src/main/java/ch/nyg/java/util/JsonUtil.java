package ch.nyg.java.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public final class JsonUtil {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper().setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
    private static final ObjectWriter JSON_WRITER = OBJECT_MAPPER.writerWithDefaultPrettyPrinter();

    public static String serialize(Object object) {
        try {
            return JSON_WRITER.writeValueAsString(object);
        }
        catch (JsonProcessingException e) {
            LogUtil.severe(e);
            throw new IllegalArgumentException("Object could not be serialized. Check logs.");
        }
    }

    public static JsonNode parse(String string) {
        try {
            return OBJECT_MAPPER.readTree(string);
        }
        catch (IOException e) {
            LogUtil.severe(e);
            throw new IllegalArgumentException("String could not be parsed. Check logs.");
        }
    }

    public static <T> T deserialize(File file, Class<T> clazz) {
        try {
            return OBJECT_MAPPER.readValue(file, clazz);
        }
        catch (IOException e) {
            LogUtil.severe(e);
            throw new IllegalArgumentException("File could not be deserialized. Check logs.");
        }
    }

    private JsonUtil() {}
}
