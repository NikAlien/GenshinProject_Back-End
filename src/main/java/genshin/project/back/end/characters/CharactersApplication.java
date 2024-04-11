package genshin.project.back.end.characters;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication()
@EnableScheduling
public class CharactersApplication {

	public static void main(String[] args) {
		SpringApplication.run(CharactersApplication.class, args);
	}

}
