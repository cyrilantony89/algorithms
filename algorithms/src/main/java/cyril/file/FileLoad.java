package cyril.file;

import java.io.File;

public class FileLoad {
    public static void main(String[] args) {
        File file = new File("abc.txt");
        System.out.println(file.getAbsolutePath());
    }
}
