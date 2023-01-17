/*
 * (c) UNAM, 2023
 */
package mx.unam.sa.serviciorest.utils;

import java.util.Map;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author israel1971
 */
public class TestRespuesta1 {

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/respuesta1/cuatro/cinco/seis";
        Map<String, String> result = restTemplate.getForObject(url, Map.class);
        System.out.println("Resultado:" + result);
    }
}
