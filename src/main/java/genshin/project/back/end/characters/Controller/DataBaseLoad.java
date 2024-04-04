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
    public void run(String... strings) {
        this.repository.save(new Character(1, "Razor", 90, "electro","Wolvendom"));
        this.repository.save(new Character(2, "Bennett", 87, "pyro" ,"Adventurers' Guild"));
        this.repository.save(new Character(3, "Kaeya", 57, "cryo","Knights of Favonius"));
        this.repository.save(new Character(4, "Xianyun", 80, "anemo" ,"Mt. Aocang"));
        this.repository.save(new Character(5, "Cyno", 90, "electro","Temple of Silence"));
        this.repository.save(new Character(6, "Tighnari", 40, "dendro" ,"Gandharva Ville"));
        this.repository.save(new Character(7, "Baizhu", 87, "dendro","Bubu Pharmacy"));
        this.repository.save(new Character(8, "Xingqiu", 70, "hydro" ,"Feiyun Commerce Guild"));

    }
}
