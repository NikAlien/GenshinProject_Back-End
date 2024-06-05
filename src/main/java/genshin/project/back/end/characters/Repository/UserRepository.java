package genshin.project.back.end.characters.Repository;

import genshin.project.back.end.characters.Model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    User findUserByUserNameAndUserPassword(String userName, String userPassword);
}