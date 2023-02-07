package com.example.Ejercicio1;

import com.example.Ejercicio1.entities.Laptop;
import com.example.Ejercicio1.repository.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Ejercicio1Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run (Ejercicio1Application.class, args);
		LaptopRepository repository = context.getBean(LaptopRepository.class);

		Laptop laptop1 = new Laptop(null,"Apple", "Macbook",13.00, 857.43, "IOS");
		Laptop laptop2 = new Laptop(null, "Xiaomi", "MI34", 17.5, 654.23, "Windows");
		repository.save(laptop1);
		repository.save(laptop2);

	}

}
