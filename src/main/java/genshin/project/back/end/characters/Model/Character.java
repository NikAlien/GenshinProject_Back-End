package genshin.project.back.end.characters.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Character {

    private @Id Integer id;
    private String name;
    private Integer currentLevel;
    private String vision;
    private String affiliation;


    public Character(int id, String name, int lvl, String vis, String aff) {
        this.id = id;
        this.name = name;
        this.vision = vis;
        this.currentLevel = lvl;
        this.affiliation = aff;
    }
}
