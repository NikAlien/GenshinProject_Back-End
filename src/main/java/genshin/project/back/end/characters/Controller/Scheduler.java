package genshin.project.back.end.characters.Controller;
import genshin.project.back.end.characters.Model.Character;
import genshin.project.back.end.characters.Repository.CharacterFaker;
import genshin.project.back.end.characters.Service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {

    @Autowired
    private CharacterService service;

    @Scheduled(fixedRate = 5000)
    public void addNewCharactersToRepo() throws Exception {
//        Character newChara = CharacterFaker.createFakeCharacter();
//        service.addNewCharacter(newChara);
    }
}
