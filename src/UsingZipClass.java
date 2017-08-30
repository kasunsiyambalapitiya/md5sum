import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * Created by kasun on 8/30/17.
 */
public class UsingZipClass {

    public static void main(String[] args) {
        try {
            ZipFile zipFile = new ZipFile("/home/kasun/Downloads/WSO2/Products/C5-Patching-Model/Custom " +
                    "Product/c5-custom-product-5.2.0.zip");

            Enumeration<? extends ZipEntry> enumeration = zipFile.entries();
            do {
                ZipEntry element = enumeration.nextElement();
                System.out.println(element.getName());
                System.out.println(element.hashCode());
            }while(enumeration.hasMoreElements());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
