/*
 * (c) UNAM, 2023
 */
package mx.unam.sa.serviciorest.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author israel1971
 */
@RestController
@RequestMapping("/")
public class Inicial {

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

        if (payload.get("contacto") != null){
            resultado.put("Dato entrada contacto", payload.get("contacto").toString() );
        }
        
        return ResponseEntity.ok(resultado);
    }

}
