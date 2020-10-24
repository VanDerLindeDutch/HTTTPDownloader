package BitumURL;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

class CopyFile {
    static void copyFile(String original, String target) throws IOException {
        Path originalPath = Paths.get(original);
        Path targetPath = Paths.get(target);
        Files.copy(originalPath, targetPath, StandardCopyOption.REPLACE_EXISTING);
        System.out.println("Thread name-" + Thread.currentThread().getName());
        System.out.printf("File %s was copied to %s\n", originalPath.getFileName(), targetPath.getFileName());
    }
}
