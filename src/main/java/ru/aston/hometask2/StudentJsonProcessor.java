package ru.aston.hometask2;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;

class StudentJsonProcessor {
    public static final String FILENAME = "studentsBooks.json";

    private static String getDataFromJsonResourcesFile() {
        StringBuilder stringBuilder = new StringBuilder();
        try (InputStream inputStream = StudentDemo.class.getClassLoader().getResourceAsStream(FILENAME);
             InputStreamReader streamReader = new InputStreamReader(Objects.requireNonNull(inputStream), StandardCharsets.UTF_8);
             BufferedReader bufferedReader = new BufferedReader(streamReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Ошибка чтения файла: " + FILENAME, e);
        }

        return stringBuilder.toString();
    }

    public static List<Student> parseStudentsFromJsonString() {
        Gson gson = new Gson();
        Type listType = new TypeToken<List<Student>>() {
        }.getType();
        return gson.fromJson(getDataFromJsonResourcesFile(), listType);
    }
}
