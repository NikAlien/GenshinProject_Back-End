package genshin.project.back.end.characters.Service;

import genshin.project.back.end.characters.Model.Character;
import genshin.project.back.end.characters.Model.User;
import genshin.project.back.end.characters.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class UserService {

    @Autowired
    private UserRepository repo;

    //    Get all or only one entity     //

    public List<User> getAllUsers() {
        List<User> result = new ArrayList<>();
        repo.findAll().forEach(result::add);
        return result;
    }
    public Optional<Integer> getUserID(String userName, String userPassword) {
        return Optional.of(repo.findUserByUserNameAndUserPassword(userName, userPassword).getUserId());
    }
}
