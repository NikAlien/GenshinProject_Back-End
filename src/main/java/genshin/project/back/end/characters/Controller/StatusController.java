package genshin.project.back.end.characters.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class StatusController {
    @GetMapping("api/v1/status")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> getStatus() {
        return new ResponseEntity<>("\"OK\"", HttpStatus.OK);
    }
}
