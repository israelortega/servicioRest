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
public class TestRespuesta2 {

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/respuesta2?valor1=x&valor2=y&valor3=z";
        Map<String, String> result = restTemplate.getForObject(url, Map.class);
        System.out.println("Resultado:" + result);
    }
}
