package com.example.demo.database.Service.storage;

import com.example.demo.Constant;

import java.util.Random;
public class Path {
    public String pathDefault = Constant.BASE_PATH;
    private String path;

    public String getPath() {
        return path;
    }
    private void randomPath() {
        StringBuilder s = new StringBuilder();
        var l = pathDefault;
        s.append(pathDefault);
        s.append(generateRandomString());
        s.append("/");
        path = String.valueOf(s);
    }
    private String generateRandomString() {
        String characters = Constant.CHARACTERS_LATIN; // Ký tự sẽ được sử dụng
        int size = Constant.LONG_SIZE_FOLDER_PATH;
        StringBuilder randomString = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            int index = random.nextInt(characters.length());
            char randomChar = characters.charAt(index);
            randomString.append(randomChar);
        }

        return String.valueOf(randomString);
    }

    public Path() {
        randomPath();
    }

    public void setPath(String path) {
        this.path = path;
    }
}
