package genshin.project.back.end.characters.Repository;

import genshin.project.back.end.characters.Model.Character;
import genshin.project.back.end.characters.Model.Weapon;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeaponRepository extends CrudRepository<Weapon, Integer> {
}
