package taewan.shoppingmall_admin.base.util;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FileManager {

    public static List<String> saveFiles(List<byte[]> files, List<String> extensions, String path) {
        List<String> savedFileNames = new ArrayList<>(files.size());

        for (int i = 0; i < files.size(); i++) {
            String saveName = makeName("product") + "." + extensions.get(i);

            new File(path).mkdirs();
            save(files.get(i), path + saveName);
            savedFileNames.add(saveName);
        }
        return savedFileNames;
    }

    private static void save(byte[] file, String filePath) {
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            fos.write(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String makeName(String prefix) {
        return prefix + "-" + UUID.randomUUID() + "-" + LocalDateTime.now().format( DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
    }

}
