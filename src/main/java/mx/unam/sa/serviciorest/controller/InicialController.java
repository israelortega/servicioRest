/*
 * (c) UNAM, 2023
 */
package mx.unam.sa.serviciorest.controller;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author israel1971
 */
@RestController
@RequestMapping("/")
public class InicialController {

    @GetMapping
    public ResponseEntity<String> inicial() {
        String salida = "<p>Proyecto servicioRest</p>";
        return ResponseEntity.ok().body(salida);
    }

    @GetMapping("/map")
    public Map<String, String> salidaJson() {
        Map<String, String> salida = new HashMap();
        salida.put("valor 1", "A");
        salida.put("valor 2", "B");
        salida.put("valor 3", "C");

        return salida;
    }

    @RequestMapping(value = "/respuesta1/{valor1}/{valor2}/{valor3}", method = RequestMethod.GET)
    public Map<String, String> respuesta1(@PathVariable("valor1") String valor1,
                                          @PathVariable("valor2") String valor2,
                                          @PathVariable("valor3") String valor3) {
        Map<String, String> salida = new HashMap();
        salida.put("valor1", valor1);
        salida.put("valor2", valor2);
        salida.put("valor3", valor3);

        return salida;
    }

    @GetMapping(value = "/respuesta2")
    public Map<String, String> respuesta2(@RequestParam("valor1") String valor1,
                                          @RequestParam("valor2") String valor2,
                                          @RequestParam("valor3") String valor3) {
        Map<String, String> salida = new HashMap();
        salida.put("valor1", valor1);
        salida.put("valor2", valor2);
        salida.put("valor3", valor3);

        return salida;
    }

    @RequestMapping(value = "/rData", method = RequestMethod.POST, headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity insetData(@RequestBody Map<String, Object> payload) throws Exception {
        Map<String, String> resultado = new HashMap<>();

        if (payload.get("contacto") != null) {
            resultado.put("Dato entrada contacto", payload.get("contacto").toString());
        }

        return ResponseEntity.ok(resultado);
    }

    @GetMapping(value = "/getPdf", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> getPdf() {


        try {
            FileInputStream fileInputStream = new FileInputStream("C:/temp/test.pdf");
            int fileSize = fileInputStream.available();
            byte[] fileData = new byte[fileSize];
            fileInputStream.read(fileData);
            ByteArrayInputStream bis = new ByteArrayInputStream(fileData);
            fileInputStream.close();

            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "inline; filename=test.pdf");

            return ResponseEntity
                    .ok()
                    .headers(headers)
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(new InputStreamResource(bis));
        } catch (IOException e) {
            return ResponseEntity.notFound().build();
        }

    }

}
