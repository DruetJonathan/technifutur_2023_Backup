package bstorm.demoSpring.utils;

import org.springframework.stereotype.Component;

import java.io.*;
import java.util.UUID;

@Component
public class FileUtils {

    private static final String FILE_BASE_PATH = "./src/main/resources/images/";

    public String save(byte[] bytes, String ext) throws IOException {
        String filename = UUID.randomUUID() + "." + ext;
        File file = new File(FILE_BASE_PATH + filename);
        file.createNewFile();
        FileOutputStream stream = new FileOutputStream(file);
        try {
            stream.write(bytes);
        } finally {
            stream.close();
        }
        return filename;
    }

    public boolean remove(String filename) {
        File file = new File(FILE_BASE_PATH + filename);
        if(file.exists()) {
            return file.delete();
        }
        return false;
    }

    public InputStream get(String filename) throws FileNotFoundException {
        File file = new File(FILE_BASE_PATH + filename);
        return new FileInputStream(file);
    }
}
