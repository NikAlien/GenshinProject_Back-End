package genshin.project.back.end.characters.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "Characters")
@AllArgsConstructor
@NoArgsConstructor
public class Character {

    @Id
    @GeneratedValue
    private int characterId;
    private String name;
    private int currentLevel;
    private String vision;
    private String affiliation;

    @ManyToOne
    @JoinColumn(name = "weaponId")
    private Weapon weapon;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    public Character(String name, int lvl, String vis, String aff) {
        this.name = name;
        this.vision = vis;
        this.currentLevel = lvl;
        this.affiliation = aff;
        this.weapon = null;
    }

    public Character(String name, int lvl, String vis, String aff, Weapon weapon, User user) {
        this.name = name;
        this.vision = vis;
        this.currentLevel = lvl;
        this.affiliation = aff;
        this.weapon = weapon;
        this.user = user;
    }
}
