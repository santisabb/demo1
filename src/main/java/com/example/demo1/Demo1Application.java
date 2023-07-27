package com.example.demo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Demo1Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Demo1Application.class, args);
		UsuarioRepository repo = context.getBean(UsuarioRepository.class);
		System.out.println("El numero de usuarios en la base de datos es: " + repo.count());
		Usuario user1 = new Usuario(41312139, "Santi Sabbioni", "santisabb@gmail.com", 440934 , 0);
		repo.save(user1);
		System.out.println("El numero de usuarios en la base de datos es: " + repo.count());
		System.out.println(repo.findAll());
	}

}
