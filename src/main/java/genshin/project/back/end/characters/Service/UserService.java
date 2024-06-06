package genshin.project.back.end.characters.Service;

import genshin.project.back.end.characters.Model.Character;
import genshin.project.back.end.characters.Model.User;
import genshin.project.back.end.characters.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
    public int getUserID(String userName, String userPassword) {
        User gatheredUser = repo.findUserByUserNameAndUserPassword(userName, userPassword);
        if (gatheredUser == null)
            return -1;
        return gatheredUser.getUserId();
    }

    public int addNewUser(User newUser) throws Exception{
        int checkUser = this.getUserID(newUser.getUserName(), newUser.getUserPassword());
        if(checkUser != -1)
            return -1;

        User user = repo.save(newUser);
        return user.getUserId();
    }
}
