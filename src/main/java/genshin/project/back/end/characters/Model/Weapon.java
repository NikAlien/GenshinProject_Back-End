package genshin.project.back.end.characters.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "Weapons")
@AllArgsConstructor
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
    @JsonIgnore
    private Set<Character> characterList = new HashSet<>();

    public Weapon(String name, String type, int baseAttack, String additionalCharacteristic, double characteristicNumbers) {
        this.name = name;
        this.type = type;
        this.baseAttack = baseAttack;
        this.secondStat = additionalCharacteristic;
        this.secondStatNumbers = characteristicNumbers;
    }

    public Weapon(int weaponId, String name, String type, int baseAttack, String secondStat, double secondStatNumbers) {
        this.weaponId = weaponId;
        this.name = name;
        this.type = type;
        this.baseAttack = baseAttack;
        this.secondStat = secondStat;
        this.secondStatNumbers = secondStatNumbers;
    }
}
