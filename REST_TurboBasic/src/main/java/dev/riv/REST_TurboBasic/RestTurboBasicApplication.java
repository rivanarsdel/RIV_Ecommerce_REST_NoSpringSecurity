package dev.riv.REST_TurboBasic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {
		"dev/riv/REST_TurboBasic/controllers",
		"dev/riv/REST_TurboBasic/services",
		"dev/riv/REST_TurboBasic/repositories",
		"dev/riv/REST_TurboBasic/models",
		"dev/riv/REST_TurboBasic/modelDTOs",
		"dev/riv/REST_TurboBasic/modelHelpers",
		"dev/riv/REST_TurboBasic/utilities",
	})
@SpringBootApplication
public class RestTurboBasicApplication {

	public static void main(String[] args) {

		SpringApplication.run(RestTurboBasicApplication.class, args);
		System.out.println("App Running");
	}

}
