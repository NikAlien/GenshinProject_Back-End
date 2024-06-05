package genshin.project.back.end.characters.Controller;

import genshin.project.back.end.characters.Model.Character;
import genshin.project.back.end.characters.Model.User;
import genshin.project.back.end.characters.Model.Weapon;
import genshin.project.back.end.characters.Repository.CharactersRepository;
import genshin.project.back.end.characters.Repository.UserRepository;
import genshin.project.back.end.characters.Repository.WeaponRepository;
import genshin.project.back.end.characters.Service.CharacterService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;


@Component
@AllArgsConstructor
public class DataBaseLoad implements CommandLineRunner {

    @Autowired
    private final CharacterService service;

//    @Autowired
//    private final WeaponRepository repo;

    @Autowired
    private final UserRepository repo;

    @Override
    public void run(String... strings) throws Exception {
//        this.repo.save(new User("nik", "2003"));
//        this.repo.save(new User("admin", "admin"));
//
//        this.service.addNewCharacter(new Character( "Razor", 90, "electro","Wolvendom", null, this.repo.findById(1).get()));
//        this.service.addNewCharacter(new Character("Xianyun", 80, "anemo" ,"Mt. Aocang", null, this.repo.findById(1).get()));
//        this.service.addNewCharacter(new Character( "Cyno", 90, "electro","Temple of Silence", null, this.repo.findById(1).get()));
//        this.service.addNewCharacter(new Character( "Baizhu", 87, "dendro","Bubu Pharmacy", null, this.repo.findById(1).get()));
//        this.service.addNewCharacter(new Character("Xingqiu", 70, "hydro" ,"Feiyun Commerce Guild", null, this.repo.findById(1).get()));
//        this.service.addNewCharacter(new Character( "Bennett", 87, "pyro" ,"Adventurers' Guild", null, this.repo.findById(2).get()));
//        this.service.addNewCharacter(new Character( "Kaeya", 57, "cryo","Knights of Favonius", this.repo.findById(2).get()));

//        this.service.addNewCharacter(new Character( "Tighnari", 40, "dendro" ,"Gandharva Ville", this.repo.findById(1).get()));

    }
}
