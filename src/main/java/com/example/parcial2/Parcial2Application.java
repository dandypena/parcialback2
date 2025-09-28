package com.example.parcial2;

import com.example.parcial2.entity.Cine;
import com.example.parcial2.repository.CineRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Parcial2Application {

	public static void main(String[] args) {
		SpringApplication.run(Parcial2Application.class, args);
	}

	// Insertar un cine de prueba al iniciar la app
	@Bean
	CommandLineRunner initDatabase(CineRepository cineRepository) {
		return args -> {
			if (cineRepository.count() == 0) { // solo si la tabla está vacía
				Cine cine = new Cine(null, "Cine Nov", "Calle 123 #45-67", 5);
				cineRepository.save(cine);
				System.out.println("✅ Cine de prueba insertado en la BD");
			}

			cineRepository.findAll().forEach(c ->
					System.out.println("🎬 Cine guardado: " + c.getNombre() + " en " + c.getDireccion())
			);
		};
	}
}

