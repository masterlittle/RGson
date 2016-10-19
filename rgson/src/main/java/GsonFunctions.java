import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.*;
import java.lang.reflect.Type;

/**
 * Created by Shitij on 30/07/16.
 */
public class GsonFunctions {

    static <T> T readValue(Gson gson, String value, Class<T> classInstance) {
        return gson.fromJson(value, classInstance);
    }

    static <T> T readValue(Gson gson, String value, Type typeT) {
        return gson.fromJson(value, typeT);
    }

    static <T> T readValue(Gson gson, Reader reader, Class<T> classInstance) {
        return gson.fromJson(reader, classInstance);
    }

    static <T> T readValue(Gson gson, Reader reader, Type typeT) {
        return gson.fromJson(reader, typeT);
    }

    static <T> T readValue(Gson gson, JsonReader jsonReader, Class<T> classInstance) {
        return gson.fromJson(jsonReader, classInstance);
    }

    static <T> T readValue(Gson gson, JsonReader jsonReader, Type type) {
        return gson.fromJson(jsonReader, type);
    }

    static <T> T readValue(Gson gson, JsonElement jsonElement, Class<T> classInstance) {
        return gson.fromJson(jsonElement, classInstance);
    }

    static <T> T readValue(Gson gson, JsonElement jsonElement, Type typeT) {
        return gson.fromJson(jsonElement, typeT);
    }

    static String writeValue(Gson gson, Object object) {
        return gson.toJson(object);
    }

    static String writeValue(Gson gson, JsonElement jsonElement) {
        return gson.toJson(jsonElement);
    }

    static String writeValue(Gson gson, Object object, Type type) {
        return gson.toJson(object, type);
    }

    static void writeValue(Gson gson, Object object, Appendable writer) {
        gson.toJson(object, writer);
    }

    static void writeValue(Gson gson, Object object, Type type, Appendable writer) {
        gson.toJson(object, type, writer);
    }

    static void writeValue(Gson gson, Object object, Type type, JsonWriter jsonWriter) {
        gson.toJson(object, type, jsonWriter);
    }

    static void writeValue(Gson gson, JsonElement jsonElement, Appendable writer) {
        gson.toJson(jsonElement, writer);
    }

    static void writeValue(Gson gson, JsonElement jsonElement, Type type, Appendable writer) {
        gson.toJson(jsonElement, type, writer);
    }

    static void writeValue(Gson gson, JsonElement jsonElement, Type type, JsonWriter jsonWriter) {
        gson.toJson(jsonElement, type, jsonWriter);
    }

    static void writeValue(Gson gson, JsonElement jsonElement, JsonWriter jsonWriter) {
        gson.toJson(jsonElement, jsonWriter);
    }

    static JsonWriter newJsonWriter(Gson gson, Writer writer) throws IOException {
        return gson.newJsonWriter(writer);
    }

    static JsonReader readJson(InputStream inputStream) throws IOException {
        String defaultEncoding = "UTF-8";
        return new JsonReader(new InputStreamReader(inputStream, defaultEncoding));
    }

    static JsonReader readJson(String filePath) throws IOException {
        String defaultEncoding = "UTF-8";

        InputStream inputStream = new FileInputStream(filePath);
        return new JsonReader(new InputStreamReader(inputStream, defaultEncoding));

    }

    static JsonReader readJson(InputStream inputStream, String encoding) throws IOException {
        return new JsonReader(new InputStreamReader(inputStream, encoding));
    }

}
