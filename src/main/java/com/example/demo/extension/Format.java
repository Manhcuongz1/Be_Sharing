package com.example.demo.extension;

import com.example.demo.Constant;

import java.io.File;

public class Format {
    public synchronized static Boolean checkStorage() {
        // Thay thế "C:" bằng đường dẫn của ổ đĩa bạn muốn kiểm tra
        File drive = new File("C:");

        // Kiểm tra xem ổ đĩa có tồn tại không
        if (drive.exists()) {
            // Lấy dung lượng không gian có thể sử dụng
            long usableSpace = drive.getUsableSpace();
            return usableSpace > Constant.MIN_SIZE_STORAGE;
        }
        return true;
    }

//    private static String formatSize(long bytes) {
//        long kilo = 1024;
//        long mega = kilo * 1024;
//        long giga = mega * 1024;
//
//        if (bytes < kilo) {
//            return bytes + " B";
//        } else if (bytes < mega) {
//            return (bytes / kilo) + " KB";
//        } else if (bytes < giga) {
//            return (bytes / mega) + " MB";
//        } else {
//            return (bytes / giga) + " GB";
//        }
//    }
}

