package genshin.project.back.end.characters.Repository;

import genshin.project.back.end.characters.Model.Character;

import java.util.List;
import java.util.Random;

public class CharacterFaker {

    private static final List<String> names = List.of("Razor", "Bennett", "Venti","Zhongli", "Baizhu", "Xingqiu",
            "Raiden", "Kokomi", "Yae Miko", "Nahida", "Cyno", "Tighnari", "Furina", "Wrio", "Charlotte");
    private static final List<String> visions = List.of("electro", "anemo", "pyro", "geo", "hydro", "cryo", "dendro");

    private static final List<String> affiliations = List.of("Eight Trades", "Tri-Commission",
            "Unnamed Intelligence Organization", "Adepti", "Gunnhildr Clan", "Yae Publishing House", "The Crux");
    private static final Random rand = new Random();


    public static Character createFakeCharacter() {
        return new Character(-1, names.get(rand.nextInt(names.size())),
                rand.nextInt(91),
                visions.get(rand.nextInt(visions.size())),
                affiliations.get(rand.nextInt(affiliations.size())));
    }
}
