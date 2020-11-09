package br.com.hubspot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.hubspot.service.MainService;

@SpringBootApplication
public class HubspotApplication implements CommandLineRunner {

	private final MainService mainService;
	
	public HubspotApplication(MainService mainService) {
		this.mainService = mainService;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(HubspotApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		mainService.execute();
	}

}
