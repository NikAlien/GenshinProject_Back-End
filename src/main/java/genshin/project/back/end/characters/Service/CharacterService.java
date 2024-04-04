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

    public void addNewCharacter(Character newChara) throws Exception{
        String error = this.validateCharacter(newChara);
        if(!error.isEmpty())
            throw new Exception(error);

        if(!repo.findById(newChara.getId()).isPresent())
            throw new Exception("Character already in repo present");

        repo.save(newChara);
    }

    public void updateCharacter(Character chara) throws Exception {
        String error = this.validateCharacter(chara);
        if(!error.isEmpty())
            throw new Exception(error);

        if(repo.findById(chara.getId()).isEmpty())
            throw new Exception("Character not in repo");

        repo.save(chara);
    }

    public void deleteCharacterById(Integer id) throws Exception {

        if(!repo.findById(id).isEmpty())
            throw new Exception("Character already in repo present");

        repo.deleteById(id);
    }


    //     Validate Character     //
    public String validateCharacter(Character chara) {
        String finalError = "";

        if(chara.getId() < 1)
            finalError += "Invalid id: ";

        if(chara.getName().isEmpty() || chara.getAffiliation().isEmpty() || chara.getVision().isEmpty())
            finalError += "Empty filds, please fill them up; ";

        if(chara.getCurrentLevel() < 0 || chara.getCurrentLevel() > 90)
            finalError += "Invalid level inserted; ";

        return finalError;
    }
}
