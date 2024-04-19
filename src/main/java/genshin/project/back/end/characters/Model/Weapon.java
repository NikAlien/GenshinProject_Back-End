package genshin.project.back.end.characters.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "Weapons")
@NoArgsConstructor
public class Weapon {

    @Id @GeneratedValue
    private int weaponId;
    private String name;
    private String type;
    private int baseAttack;
    private String secondStat;
    private double secondStatNumbers;

    @OneToMany(mappedBy = "weapon")
    private Set<Character> characterList;

    public Weapon(String name, String type, int baseAttack, String additionalCharacteristic, double characteristicNumbers) {
        this.name = name;
        this.type = type;
        this.baseAttack = baseAttack;
        this.secondStat = additionalCharacteristic;
        this.secondStatNumbers = characteristicNumbers;
        this.characterList = new HashSet<>();
    }
}
