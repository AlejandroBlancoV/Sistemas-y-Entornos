package com.example.demo.Controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;




@RestController
@CrossOrigin(origins="*")
public class AppController {
   

    public static int contarVocales(String palabra){
        palabra = palabra.toLowerCase();
        int contador = 0;
        for (char letra : palabra.toCharArray()){
            if(letra == 'a' || letra == 'e' || letra =='i' || letra=='o' || letra == 'u'){
                contador ++;
            }
        }
        return contador;
    }


    @GetMapping("/")
    public String saludo(){
        return "Hola Bienvenido a mi servidor personal de SpringBoot";
    }

    @GetMapping("/square/{num}")
    public double SquareOfANumber(@PathVariable double num){
        return num*num;
    }

      // localhost:8080/contar?palabra=XXX
    @GetMapping("/contar")
    public String contar(@RequestParam String palabra){
        int vocales = contarVocales(palabra);
        int consonantes = palabra.length() - vocales;
        return "Vocales: " + vocales + " Consonantes: " + consonantes;
    }   

    // localhost:8080/contar2/XXX
    @GetMapping("/contar2/{palabra}")
    public String contar2(@PathVariable String palabra){
        int vocales = contarVocales(palabra);
        int consonantes = palabra.length() - vocales;
        return "Vocales: " + vocales + " Consonantes: " + consonantes;
    }
    

}
