package genshin.project.back.end.characters.Controller;

import genshin.project.back.end.characters.Model.Character;
import genshin.project.back.end.characters.Service.CharacterService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
