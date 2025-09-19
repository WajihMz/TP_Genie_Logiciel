package re.forestier.edu;

import org.junit.jupiter.api.*;
import re.forestier.edu.rpg.player;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;

public class UnitTests {

    @Test
    @DisplayName("Sample test")
    void testPlayerName() {
        player player = new player("Florian", "Grognak le barbare", "ADVENTURER", 100, new ArrayList<>());
        assertThat(player.playerName, is("Florian"));
    }

    @Test
    @DisplayName("Impossible to have negative money")
    void testNegativeMoney() {
        player p = new player("Florian", "Grognak le barbare", "ADVENTURER", 100, new ArrayList<>());

        try {
            p.removeMoney(200);
        } catch (IllegalArgumentException e) {
            return;
        }
        fail();
    }

    @Test
    @DisplayName("Niveau initial d'un joueur = 1")
    void initialLevelIsOne() {
        player p = new player("T", "A", "ADVENTURER", 0, new ArrayList<>());
        assertThat(p.retrieveLevel(), is(1));
    }

    @Test
    @DisplayName("XP=9 -> niveau reste 1")
    void levelStaysOneAtNineXp() {
        player p = new player("T", "A", "ADVENTURER", 0, new ArrayList<>());
        re.forestier.edu.rpg.UpdatePlayer.addXp(p, 9);
        assertThat(p.getXp(), is(9));
        assertThat(p.retrieveLevel(), is(1));
    }

}
