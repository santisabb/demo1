package com.example.demo1;

import com.example.demo1.entidades.*;
import com.example.demo1.repositorios.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Demo1Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Demo1Application.class, args);
		//long lng = 1234567891;
		UsuarioRepository repoU = context.getBean(UsuarioRepository.class);
		EmpleadoRepository repoE = context.getBean(EmpleadoRepository.class);
		FacturaRepository repoF = context.getBean(FacturaRepository.class);
		CanchaRepository repoC = context.getBean(CanchaRepository.class);
		ParrillaRepository repoP = context.getBean(ParrillaRepository.class);
		Usuario user1 = new Usuario(41312139, "Santi Sabbioni", "santisabb@gmail.com", 440934 , 0);
		Usuario user2 = new Usuario(2872023, "Julio Agosto", "julio@gmail.com", 123456 , 0);
		Empleado empleado1 = new Empleado(1L, "20-41312139-7", "Santino Marella");
		Factura factura = new Factura(1L, 2500.36, "A", "Bernardo Oviedo" );
		Cancha cancha = new Cancha(1, "Futbol 7", "15x25", true, "Natural");
		Parrilla parrilla = new Parrilla(1L, true);

		repoU.save(user1);
		repoU.save(user2);
		repoE.save(empleado1);
		repoF.save(factura);
		repoC.save(cancha);
		repoP.save(parrilla);

		System.out.println("app is running brooo lets fucking gooooo");

	}

}
