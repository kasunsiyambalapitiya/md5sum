package md5suminsidezip;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Created by kasun on 8/30/17.
 */
public class Demo {

    public static void main(String[] args) {

        try {
            InputStream theFile = new FileInputStream("/home/kasun/Downloads/WSO2/Products/C5-Patching-Model/Custom " +
                    "Product/c5-custom-product-5.2.0.zip");
            ZipInputStream stream = new ZipInputStream(theFile);
            ZipEntry entry;
            while ((entry = stream.getNextEntry()) != null) {
                MessageDigest md = MessageDigest.getInstance("MD5");
                DigestInputStream dis = new DigestInputStream(stream, md);
                byte[] buffer = new byte[1024];
                int read = dis.read(buffer);
                while (read > -1) {
                    read = dis.read(buffer);
                }
                System.out.println(entry.getName() + ": "
                        + Arrays.toString(dis.getMessageDigest().digest()));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
