package genshin.project.back.end.characters.Service;

import genshin.project.back.end.characters.Model.Character;
import genshin.project.back.end.characters.Repository.CharactersRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static genshin.project.back.end.characters.Model.Character.lastId;

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

    public List<Character> getPaginationCharacters(List<Character> characters, int page, int number) {
        int start = number * (page - 1);
        int end = number * page;
        if(start < 0)
            start = 0;
        if(number * page > characters.size())
            end = characters.size();
        return characters.subList(start, end);
    }

    public Optional<Character> getCharacterById(Integer id) {
        return repo.findById(id);
    }

    //    Get sorted list     //

    public List<Character> getSortedListByLevel() {
        return this.getAllCharacters().stream()
                .sorted(Comparator.comparingInt(Character::getCurrentLevel).reversed())
                .collect(Collectors.toList());
    }

    public List<Character> getSortedListByName() {
        return this.getAllCharacters().stream()
                .sorted(Comparator.comparing(Character::getName))
                .collect(Collectors.toList());
    }

    //    Create, Update & Delete  Character     //

    public int addNewCharacter(Character newChara) throws Exception{
        lastId++;
        newChara.setId(lastId);
        String error = this.validateCharacter(newChara);
        if(!error.isEmpty())
            throw new Exception(error);

        if(repo.findById(newChara.getId()).isPresent())
            throw new Exception("Character already in repo present");

        repo.save(newChara);
        return newChara.getId();
    }

    public int updateCharacter(Character chara) throws Exception {
        String error = this.validateCharacter(chara);
        if(!error.isEmpty())
            throw new Exception(error);

        if(repo.findById(chara.getId()).isEmpty())
            throw new Exception("Character not in repo");

        repo.save(chara);
        return chara.getId();
    }

    public boolean deleteCharacterById(Integer id) throws Exception {

        if(repo.findById(id).isEmpty())
            throw new Exception("Character not in repo");

        repo.deleteById(id);
        return true;
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
