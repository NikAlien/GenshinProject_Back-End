package genshin.project.back.end.characters.Controller;

import genshin.project.back.end.characters.Model.Character;
import genshin.project.back.end.characters.Service.CharacterService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/characters")
@AllArgsConstructor
public class CharacterController {

    @Autowired
    private CharacterService service;


    //    Get all or only one entity     //
    @GetMapping
    public ResponseEntity<List<Character>> getAllCharacters(){
        return new ResponseEntity<>(service.getAllCharacters(), HttpStatus.OK);
    }

    @GetMapping("/id_{id}")
    public ResponseEntity<Optional<Character>> getCharacterById(@PathVariable(name = "id") Integer id) {
        return new ResponseEntity<>(service.getCharacterById(id), HttpStatus.OK);
    }


    //     Inserting new Character     //
    @PostMapping("/insert")
    public ResponseEntity<String> insertNewCharacter(@RequestBody Character newChara) {

        try {
            service.addNewCharacter(newChara);
        } catch (Exception e) {
            return new ResponseEntity<>("Error at inserting element -> " + e.getMessage(), HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>("New character added successfully", HttpStatus.OK);
    }


    //     Updating Character     //
    @PutMapping("/update_{id}")
    public ResponseEntity<String> updateCharacter(@RequestBody Character newChara, @PathVariable(name = "id") Integer id) {

        if(!id.equals(newChara.getId())) {
            return new ResponseEntity<>("Error at updating element: the ids don't match ", HttpStatus.CONFLICT);
        }

        try {
            service.updateCharacter(newChara);
        } catch (Exception e) {
            return new ResponseEntity<>("Error at updating element -> " + e.getMessage(), HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>("Character updated successfully", HttpStatus.OK);
    }


    //     Deleting Character     //
    @DeleteMapping("/delete_{id}")
    public ResponseEntity<String> deleteCharacter(@PathVariable(name = "id") Integer id) {
        try {
            service.deleteCharacterById(id);
        } catch (Exception e) {
            return new ResponseEntity<>("Error at deleting element -> " + e.getMessage(), HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>("Character deleted successfully", HttpStatus.OK);
    }
}
