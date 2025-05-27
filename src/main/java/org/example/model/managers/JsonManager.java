package org.example.model.managers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonManager {
    private ObjectMapper objectMapper;
    private File file;

    public JsonManager(String path) {
        file = new File(path);
        objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
    }

    public <T> void writeArray( List<T> arr) throws IOException {
        objectMapper.writeValue(file, arr);
    }

    public <T> List<T> readArray(TypeReference<List<T>> typeReference) throws IOException {
        return objectMapper.readValue(file, typeReference);
    }
    public void writeObject(Object obj) throws IOException {
        objectMapper.writeValue(file, obj);
    }

    public <T> T readObject(Class<T> clazz) throws IOException {
        return objectMapper.readValue(file,clazz);
    }


}
