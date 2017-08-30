import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by kasun on 8/30/17.
 */
public class CopyingFile {

    public static void main(String[] args) {
        // outputName, name of the file to extract from the zip file
        String outputName = "artifacts.xml";
// location to store the extracted file to
        File outputFile = new File(outputName);

// path to the zip file
        Path zipFile = Paths.get("/home/kasun/Downloads/WSO2/Products/C5-Patching-Model/Custom " +
                "Product/c5-custom-product-5.2.0.zip");
// load zip file as filesystem
        FileSystem fileSystem = null;
        try {
            fileSystem = FileSystems.newFileSystem(zipFile, null);
        } catch (IOException e) {
            e.printStackTrace();
        }

// copy file from zip file to output location
        Path source = fileSystem.getPath("c5-custom-product-5.2.0/wso2/lib/"+outputName);
        try {
            Files.copy(source, outputFile.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
