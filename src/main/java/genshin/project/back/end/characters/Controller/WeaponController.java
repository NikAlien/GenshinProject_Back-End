package genshin.project.back.end.characters.Controller;

import genshin.project.back.end.characters.Model.Character;
import genshin.project.back.end.characters.Model.Weapon;
import genshin.project.back.end.characters.Service.WeaponServer;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/weapons")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor

public class WeaponController {

    @Autowired
    private WeaponServer service;

    //    Get all or only one entity     //
    @GetMapping
    public ResponseEntity<List<Weapon>> getAllWeapons(){
        return new ResponseEntity<>(service.getAllWeapons(), HttpStatus.OK);
    }

    @GetMapping("/id_{id}")
    public ResponseEntity<Optional<Weapon>> getWeaponById(@PathVariable(name = "id") Integer id) {
        return new ResponseEntity<>(service.getWeaponById(id), HttpStatus.OK);
    }

    @GetMapping("/id_{id}/characterList")
    public ResponseEntity<Set<Character>> getWeaponCharacterList(@PathVariable(name = "id") Integer id) {
        return new ResponseEntity<>(service.getCharacterList(id), HttpStatus.OK);
    }

    //     Inserting new Weapon     //
    @PostMapping("/insert")
    public int insertNewWeapon(@RequestBody Weapon newWeapon) {
        try {
            return service.addNewWeapon(newWeapon);
        } catch (Exception e) {
            return -1;
        }
    }


    //     Updating Weapon     //
    @PutMapping("/update_{id}")
    public int updateWeapon( @PathVariable(name = "id") Integer id, @RequestBody Weapon newWeapon) {

        if(!id.equals(newWeapon.getWeaponId())) {
            return -1;
        }

        try {
            return service.updateWeapon(newWeapon);
        } catch (Exception e) {
            return -1;
        }
    }


    //     Deleting Weapon     //
    @DeleteMapping("/delete_{id}")
    public boolean deleteWeapon(@PathVariable(name = "id") Integer id) {
        try {
            return service.deleteWeaponById(id);
        } catch (Exception e) {
            return false;
        }
    }

}
