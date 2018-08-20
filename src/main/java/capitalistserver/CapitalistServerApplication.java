package capitalistserver;

import capitalistserver.model.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class CapitalistServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CapitalistServerApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() {
		System.out.println("RUNNING...");
		Main main = new Main();
		main.generateTerritory();
	}
}
