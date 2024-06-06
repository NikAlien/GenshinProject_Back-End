package genshin.project.back.end.characters.Service;

import genshin.project.back.end.characters.Model.Character;
import genshin.project.back.end.characters.Repository.CharactersRepository;
import genshin.project.back.end.characters.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class CharacterService {

    @Autowired
    private CharactersRepository repo;

    @Autowired
    private UserRepository userRepo;

    //    Get all or only one entity     //

    public List<Character> getAllCharacters(int UserId) {
        return new ArrayList<>(repo.findCharactersByUser(userRepo.findById(UserId).get()));
    }

    public List<Character> getAllCharactersCopy() {
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

    public List<Character> getSortedListByLevel(int userId) {
        return this.getAllCharacters(userId).stream()
                .sorted(Comparator.comparingInt(Character::getCurrentLevel).reversed())
                .collect(Collectors.toList());
    }

    public List<Character> getSortedListByName() {
        return this.getAllCharactersCopy().stream()
                .sorted(Comparator.comparing(Character::getName))
                .collect(Collectors.toList());
    }

    //    Get filtered list     //

    public List<Character> getFilteredListByVision(String vision) {
        return this.getAllCharactersCopy().stream()
                .filter(character -> character.getVision().equals(vision))
                .collect(Collectors.toList());
    }


    //     Get necessary chart data     //

    public List<Integer> getChartData(){
        List<Integer> dataList = new ArrayList<>(7);
        dataList.add(this.getFilteredListByVision("anemo").size());
        dataList.add(this.getFilteredListByVision("cryo").size());
        dataList.add(this.getFilteredListByVision("dendro").size());
        dataList.add(this.getFilteredListByVision("electro").size());
        dataList.add(this.getFilteredListByVision("geo").size());
        dataList.add(this.getFilteredListByVision("hydro").size());
        dataList.add(this.getFilteredListByVision("pyro").size());
        return dataList;
    }


    //    Create, Update & Delete  Character     //

    public int addNewCharacter(Character newChara, int UserId) throws Exception{
        String error = this.validateCharacter(newChara);
        if(!error.isEmpty())
            throw new Exception(error);

        if(repo.findById(newChara.getCharacterId()).isPresent())
            throw new Exception("Character already in repo present");

        newChara.setUser(userRepo.findById(UserId).get());
        Character chara = repo.save(newChara);
        return chara.getCharacterId();
    }

    public int updateCharacter(Character chara) throws Exception {
        String error = this.validateCharacter(chara);
        if(!error.isEmpty())
            throw new Exception(error);

        if(repo.findById(chara.getCharacterId()).isEmpty())
            throw new Exception("Character not in repo");

        repo.save(chara);
        return chara.getCharacterId();
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


        if(chara.getName().isEmpty() || chara.getAffiliation().isEmpty() || chara.getVision().isEmpty())
            finalError += "Empty filds, please fill them up; ";

        if(chara.getCurrentLevel() < 0 || chara.getCurrentLevel() > 90)
            finalError += "Invalid level inserted; ";

        return finalError;
    }
}
