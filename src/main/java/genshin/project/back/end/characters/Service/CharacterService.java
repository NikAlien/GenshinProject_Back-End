package genshin.project.back.end.characters.Service;

import genshin.project.back.end.characters.Model.Character;
import genshin.project.back.end.characters.Repository.CharactersRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CharacterService {

    @Autowired
    private CharactersRepository repo;

    //    Get all or only one entity     //

    public List<Character> getAllCharacters() {
        List<Character> result = new ArrayList<>();
        repo.findAll().forEach(result::add);
        return result;
    }

    public Optional<Character> getCharacterById(Integer id) {
        return repo.findById(id);
    }

    //    Create, Update & Delete  Character     //

    public void addNewCharacter(Character newChara) {
        repo.save(newChara);
    }

    public void updateCharacter(Character chara) {
        repo.save(chara);
    }

    public void deleteCharacterById(Integer id) {
        repo.deleteById(id);
    }
}
