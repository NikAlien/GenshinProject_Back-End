package genshin.project.back.end.characters.Controller;

import genshin.project.back.end.characters.Model.Character;
import genshin.project.back.end.characters.Service.CharacterService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/characters")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
public class CharacterController {

    @Autowired
    private CharacterService service;


    //    Get all or only one entity     //
    @GetMapping
    public ResponseEntity<List<Character>> getAllCharacters(){
        return new ResponseEntity<>(service.getAllCharactersCopy(), HttpStatus.OK);
    }

    @GetMapping("/page_{page}")
    public ResponseEntity<List<Character>> getPageCharacters(@PathVariable(name = "page") int page, @RequestParam int number, @RequestParam int userId){
        return new ResponseEntity<>(service.getPaginationCharacters(service.getAllCharacters(userId), page, number), HttpStatus.OK);
    }

    @GetMapping("/page/sorted/byLevel_{page}")
    public ResponseEntity<List<Character>> getPageSortedByLevelCharacters(@PathVariable(name = "page") int page, @RequestParam int number, @RequestParam int userId){
        return new ResponseEntity<>(service.getPaginationCharacters(service.getSortedListByLevel(userId), page, number), HttpStatus.OK);
    }

    @GetMapping("/page/sorted/byName_{page}")
    public ResponseEntity<List<Character>> getPageSortedByNameCharacters(@PathVariable(name = "page") int page, @RequestParam int number){
        return new ResponseEntity<>(service.getPaginationCharacters(service.getSortedListByName(), page, number), HttpStatus.OK);
    }

    @GetMapping("/filtered/byVision/{vision}")
    public ResponseEntity<List<Character>> getFilteredByVisionCharacters(@PathVariable(name = "vision") String vision){
        return new ResponseEntity<>(service.getFilteredListByVision(vision), HttpStatus.OK);
    }

    @GetMapping("/chartData")
    public ResponseEntity<List<Integer>> getChartData(){
        return new ResponseEntity<>(service.getChartData(), HttpStatus.OK);
    }

    @GetMapping("/id_{id}")
    public ResponseEntity<Optional<Character>> getCharacterById(@PathVariable(name = "id") Integer id) {
        return new ResponseEntity<>(service.getCharacterById(id), HttpStatus.OK);
    }

    @GetMapping("/size")
    public int getSizeRepo(@RequestParam int userId){
        return service.getAllCharacters(userId).size();
    }


    //     Inserting new Character     //
    @PostMapping("/insert")
    public int insertNewCharacter(@RequestBody Character newChara, @RequestParam int userId) {
        try {
            return service.addNewCharacter(newChara, userId);
        } catch (Exception e) {
            return -1;
        }
    }


    //     Updating Character     //
    @PutMapping("/update_{id}")
    public int updateCharacter( @PathVariable(name = "id") Integer id, @RequestBody Character newChara) {

        if(!id.equals(newChara.getCharacterId())) {
            return -1;
        }

        try {
            return service.updateCharacter(newChara);
        } catch (Exception e) {
            return -1;
        }
    }


    //     Deleting Character     //
    @DeleteMapping("/delete_{id}")
    public boolean deleteCharacter(@PathVariable(name = "id") Integer id) {
        try {
            return service.deleteCharacterById(id);
        } catch (Exception e) {
            return false;
        }
    }

//    @MessageMapping("/characters/chat")
//    @SendTo("/characters")
//    public int onReceiveMessage() {
//        return this.getSizeRepo();
//    }
}
