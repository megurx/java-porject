package ru.kubsu.geocoder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.kubsu.geocoder.model.Test;

@SpringBootApplication
public class GeocoderApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeocoderApplication.class, args);

		Test test = new Test();
		System.out.println(test.getId());
	}



}
