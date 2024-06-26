package genshin.project.back.end.characters.Controller;

import genshin.project.back.end.characters.Model.Character;
import genshin.project.back.end.characters.Model.User;
import genshin.project.back.end.characters.Service.CharacterService;
import genshin.project.back.end.characters.Service.UserService;
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
@RequestMapping("/api/v1/users")
@CrossOrigin
@AllArgsConstructor

public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
        return new ResponseEntity<>(service.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/userID/{userName}")
    public ResponseEntity<Integer> getUserID(@PathVariable(name = "userName") String userName, @RequestParam String userPassword){
        return new ResponseEntity<>(service.getUserID(userName, userPassword), HttpStatus.OK);
    }

    //     Inserting new Character     //
    @PostMapping("/insert")
    public int insertNewCharacter(@RequestBody User newUser) {
        try {
            return service.addNewUser(newUser);
        } catch (Exception e) {
            return -1;
        }
    }

}
