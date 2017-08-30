import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Created by kasun on 8/30/17.
 */
public class UsingUtilZip {
    public static void main(String[] args) {
        OutputStream out = null;
        try {
            out = new FileOutputStream("artifacts.xml");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        FileInputStream fin = null;
        try {
            fin = new FileInputStream("/home/kasun/Downloads/WSO2/Products/C5-Patching-Model/Custom " +
            "Product/c5-custom-product-5.2.0.zip");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedInputStream bin = new BufferedInputStream(fin);
        ZipInputStream zin = new ZipInputStream(bin);
        ZipEntry ze = null;
        try {
            while ((ze = zin.getNextEntry()) != null) {
                if (ze.getName().equals("your.file")) {
                    byte[] buffer = new byte[8192];
                    int len;
                    while ((len = zin.read(buffer)) != -1) {
                        out.write(buffer, 0, len);
                    }
                    out.close();
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
