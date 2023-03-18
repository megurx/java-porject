package ru.kubsu.geocoder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.kubsu.geocoder.model.Test;

@SpringBootApplication
@SuppressWarnings({"PWD.UseUtilityClass", "HideUtilityConstructor"})
public class GeocoderApplication {

	public static void main(final String[] args) {
		SpringApplication.run(GeocoderApplication.class, args);

		Test test = new Test();
		System.out.println(test.getId());
	}



}
