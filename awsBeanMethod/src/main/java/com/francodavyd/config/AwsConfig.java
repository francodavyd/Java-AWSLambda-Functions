package com.francodavyd.config;

import com.francodavyd.domain.Personaje;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@Configuration
public class AwsConfig {
 
  //El supplier siempre sera de tipo GET
  @Bean(name = "saludar")
 public Supplier<String> saludo(){
   return () -> "Hola mundo";
 }
 // Lo ideal es que un Consumer sea de tipo POST
 // Es una función que consume o utiliza el valor proporcionado como entrada sin devolver nada.
 @Bean(name = "imprimir")
  public Consumer<String> imprimirParametro(){
    return (param) -> {
      System.out.println(param);
    };
 }
 //Se puede usar tanto con GET como con POST
 @Bean(name = "funcion")
  public Function<String, String> recibirParametro(){
    return (param) -> {
      String name = param.toUpperCase();
      return name;
    };
 }
 //un Supplier no toma ningún argumento pero produce un resultado.
 @Bean
 public Supplier<Map<String, Object>> crearPersonaje(){
    return ()-> {
      Map<String, Object> character = new HashMap<>();
      character.put("Nombre", "Martin");
      character.put("Vida", 600);
      character.put("habilidad", "Rasengan");
      return character;
    };
 }
@Bean
  public Function<Map<String, Object>, String> recibirPersonaje(){
    return (param) -> {
      param.forEach((key, value) -> System.out.println(key + "-" + value.toString()));
      return "Personaje recibido";
    };

}
@Bean
public Function<Personaje, Personaje> recibirObjeto(){
     return (param) -> param;
}
@Bean
    public Function<Map<String, Object>, Map<String, Object>> procesarPersonaje(){
      return (param) -> {
          Map<String, Object> mapPerson = param;

          mapPerson.forEach((k, v) -> System.out.println(k + "-" + v.toString()));

          Map<String, Object> mapDos = new HashMap<>();
          mapDos.put("nombre", "bubby");
          mapDos.put("vida", 50);
          mapDos.put("habilidad", "golpe de sangre");

          return mapDos;
      };
}




  }
