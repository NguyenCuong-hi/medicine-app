package com.example.medicineapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.example.medicineapp.repository"})
public class MedicineAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedicineAppApplication.class, args);
	}

}
