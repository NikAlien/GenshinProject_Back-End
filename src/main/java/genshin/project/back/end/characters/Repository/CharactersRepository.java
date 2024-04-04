package genshin.project.back.end.characters.Repository;

import genshin.project.back.end.characters.Model.Character;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharactersRepository extends CrudRepository<Character, Integer> {
}
