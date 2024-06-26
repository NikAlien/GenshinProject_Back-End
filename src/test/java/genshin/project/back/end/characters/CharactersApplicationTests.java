package genshin.project.back.end.characters;

import genshin.project.back.end.characters.Controller.CharacterController;
import genshin.project.back.end.characters.Model.Character;
import genshin.project.back.end.characters.Model.Weapon;
import genshin.project.back.end.characters.Service.CharacterService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

import static org.springframework.test.util.AssertionErrors.assertTrue;

@SpringBootTest
class CharactersApplicationTests {

	@Autowired
	CharacterService charaService;
	@Test
	void contextLoads() throws Exception {
		List<Character> charas = charaService.getAllCharacters();
		Assertions.assertEquals(charas.size(), 8);

		Character razor = charaService.getCharacterById(1).get();
		Assertions.assertEquals(razor.getCharacterId(), 1);
		Assertions.assertEquals(razor.getName(), "Razor");
		Assertions.assertEquals(razor.getVision(), "electro");

		charaService.addNewCharacter(new Character( "Bill", 60, "anemo", "--", new Weapon()));
		Character billy = charaService.getCharacterById(9).get();
		Assertions.assertEquals(billy.getCharacterId(), 9);
		Assertions.assertEquals(billy.getName(), "Bill");
		Assertions.assertEquals(billy.getVision(), "anemo");

		try {
			int id = charaService.addNewCharacter(new Character( "Bill", 60, "anemo", "--", new Weapon()));
			Assertions.assertEquals(1, 5);
		}
		catch (Exception e){
			Assertions.assertEquals(10, 10);
		}

		charaService.updateCharacter(new Character( "Millie", 60, "pyro", "--", new Weapon()));
		billy = charaService.getCharacterById(9).get();
		Assertions.assertEquals(billy.getCharacterId(), 9);
		Assertions.assertEquals(billy.getName(), "Millie");
		Assertions.assertEquals(billy.getVision(), "pyro");

		Assertions.assertEquals(charaService.getAllCharacters().size(), 9);
		charaService.deleteCharacterById(9);
		Assertions.assertEquals(charaService.getAllCharacters().size(), 8);

		charaService.addNewCharacter(new Character( "Bill", 60, "anemo", "--", new Weapon()));
		billy = charaService.getCharacterById(10).get();
		Assertions.assertEquals(billy.getCharacterId(), 10);
		Assertions.assertEquals(billy.getName(), "Bill");
		Assertions.assertEquals(billy.getVision(), "anemo");
		Assertions.assertEquals(charaService.getAllCharacters().size(), 9);
	}


}
