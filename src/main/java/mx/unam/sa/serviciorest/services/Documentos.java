/*
 * (c) UNAM, 2023
 */
package mx.unam.sa.serviciorest.services;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;

/**
 *
 * @author israel1971
 */
@Service
public class Documentos {

    public ByteArrayInputStream getDocumento() throws Exception {
        try {
            FileInputStream fileInputStream = new FileInputStream("C:/temp/test.pdf");
            int fileSize = fileInputStream.available();
            byte[] fileData = new byte[fileSize];
            fileInputStream.read(fileData);
            ByteArrayInputStream bis = new ByteArrayInputStream(fileData);
            fileInputStream.close();
            return bis;
        } catch (IOException e) {
             throw new Exception(e.getMessage());
        }
    }
}
