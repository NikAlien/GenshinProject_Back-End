package genshin.project.back.end.characters.Controller;

import genshin.project.back.end.characters.Model.Character;
import genshin.project.back.end.characters.Repository.CharactersRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class DataBaseLoad implements CommandLineRunner {

    @Autowired
    private final CharactersRepository repository;


    @Override
    public void run(String... strings) throws Exception{
        this.repository.save(new Character(1, "raz", 10, "electro","wolf"));
        this.repository.save(new Character(2, "ben", 20, "pyro" ,"no"));
    }
}
