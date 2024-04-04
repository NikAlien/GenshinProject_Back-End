package genshin.project.back.end.characters.Service;

import genshin.project.back.end.characters.Model.Character;
import genshin.project.back.end.characters.Repository.CharactersRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CharacterService {

    @Autowired
    private CharactersRepository repo;

    public List<Character> getAllCharacters() {
        List<Character> result = new ArrayList<>();
        repo.findAll().forEach(result::add);
        return result;
    }
}
