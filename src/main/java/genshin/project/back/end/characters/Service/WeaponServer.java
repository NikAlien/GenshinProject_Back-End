package genshin.project.back.end.characters.Service;

import genshin.project.back.end.characters.Model.Character;
import genshin.project.back.end.characters.Model.Weapon;
import genshin.project.back.end.characters.Repository.WeaponRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class WeaponServer {

    @Autowired
    private WeaponRepository repo;

    //    Get all or only one entity     //

    public List<Weapon> getAllWeapons() {
        List<Weapon> result = new ArrayList<>();
        repo.findAll().forEach(result::add);
        return result;
    }

    public Optional<Weapon> getWeaponById(Integer id) {
        return repo.findById(id);
    }

    public Set<Character> getCharacterList(Integer id) {return repo.findById(id).get().getCharacterList();}


    //    Create, Update & Delete  Character     //

    public int addNewWeapon(Weapon newWeapon) throws Exception{
        String error = this.validateWeapon(newWeapon);
        if(!error.isEmpty())
            throw new Exception(error);

        if(repo.findById(newWeapon.getWeaponId()).isPresent())
            throw new Exception("Weapon already in repo present");

        repo.save(newWeapon);
        return newWeapon.getWeaponId();
    }

    public int updateWeapon(Weapon weapon) throws Exception {
        String error = this.validateWeapon(weapon);
        if(!error.isEmpty())
            throw new Exception(error);

        if(repo.findById(weapon.getWeaponId()).isEmpty())
            throw new Exception("Character not in repo");

        repo.save(weapon);
        return weapon.getWeaponId();
    }

    public boolean deleteWeaponById(Integer id) throws Exception {

        if(repo.findById(id).isEmpty())
            throw new Exception("Character not in repo");

        repo.deleteById(id);
        return true;
    }


    //     Validate Weapon     //
    public String validateWeapon(Weapon weapon) {
        String finalError = "";

        if(weapon.getName().isEmpty() || weapon.getType().isEmpty() || weapon.getSecondStat().isEmpty())
            finalError += "Empty fields, please fill them up; ";

        if(weapon.getBaseAttack() < 0 || weapon.getSecondStatNumbers() < 0)
            finalError += "Invalid numbers inserted; ";

        return finalError;
    }

}
