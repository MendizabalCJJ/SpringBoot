package controllers;

import org.springframework.web.bind.annotation.RestController;

import services.BusinessService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class HelloController {
	@Value("${demo.spring.nombre}")
	private String nombre;
	
	//@Autowired
	private final BusinessService businessService;
	
	@Autowired
	public HelloController(BusinessService businessService) {
		this.businessService = businessService;
	}
	
    //@RequestMapping("/")//get
	@RequestMapping(value = "/saludar/{nombre}", method = RequestMethod.GET)//get parametrizado
    public String index(@PathVariable String nombre) {//se pone la anotacion y nombre del parametro
        String respuesta = "Nombre del Proyecto: " + this.nombre;//"Greetings from Spring Boot!";
        respuesta += "\n" + businessService.getSaludo();
        
        if(nombre.equals("Pilar")) {
        	return "Hola Srita " + nombre;
        } else {
        	return "Hola sr " + nombre;
        }
        
        //return "Hola " + nombre;
        //return respuesta;
    }
}