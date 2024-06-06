package genshin.project.back.end.characters.Repository;

import genshin.project.back.end.characters.Model.Character;
import genshin.project.back.end.characters.Model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharactersRepository extends CrudRepository<Character, Integer> {

    public List<Character> findCharactersByUser(User user);
}
