/*
 * (c) UNAM, 2023
 */
package mx.unam.sa.serviciorest.utils;

import java.util.Map;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author israel1971
 */
public class TestrData {

    public static void main(String[] args) {

        JSONObject data = new JSONObject();    
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        data.put("contacto", "datos de contacto");
        HttpEntity<String> request2 = new HttpEntity<String>(data.toString(), headers);

        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/rData";
        Map<String, String> result = restTemplate.postForObject(url, request2,Map.class);

        System.out.println("Resultado:" + result);
    }
}
