package com.example.demo.data.service.storage;

import com.example.demo.Constant;
import lombok.Data;

import java.util.Random;
@Data
public class RandomPath {
    private String basePath = Constant.BASE_PATH;
    private String path="";
    private String folderName = "";
    private static RandomPath instance;
    private RandomPath(){};
    private String generateRandomString() {
        String characters = Constant.CHARACTERS_LATIN; // Ký tự sẽ được sử dụng
        StringBuilder folderName = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < Constant.LONG_SIZE_FOLDER_PATH; i++) {
            int index = random.nextInt(characters.length());
            folderName.append(characters.charAt(index));
        }
        return String.valueOf(folderName);
    }
    public static RandomPath getInstance() {
        if(instance == null) {
            instance = new RandomPath();
        }
        return instance;
    }
    public RandomPath create() {
        folderName = generateRandomString();
        buildPath();
        return instance;
    }
    private void buildPath() {
        path = basePath + folderName + "/";
    }
    public String buildPath(String folder) {
        return path = basePath + folder + "/";
    }

}
