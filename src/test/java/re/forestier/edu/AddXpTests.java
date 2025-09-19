package re.forestier.edu;

import org.junit.jupiter.api.*;
import re.forestier.edu.rpg.player;
import re.forestier.edu.rpg.UpdatePlayer;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;

public class AddXpTests {
    
    @Test
    @DisplayName("addXp: pas de level-up -> false et inventaire inchangé")
    void addXpNoLevelUp() {
        player p = new player("T", "A", "ADVENTURER", 0, new ArrayList<>());
        int inventoryBefore = p.inventory.size();
        boolean leveled = UpdatePlayer.addXp(p, 5);
        assertThat(leveled, is(false));
        assertThat(p.inventory.size(), is(inventoryBefore));
    }

    @Test
    @DisplayName("addXp: level-up -> true et +1 objet (ADVENTURER)")
    void addXpLevelUpAdventurer() {
        player p = new player("T", "A", "ADVENTURER", 0, new ArrayList<>());
        int inventoryBefore = p.inventory.size();
        boolean leveled = UpdatePlayer.addXp(p, 10);
        assertThat(leveled, is(true));
        assertThat(p.inventory.size(), is(inventoryBefore + 1));
    }

    @Test
    @DisplayName("addXp: level-up -> true et +1 objet (ARCHER)")
    void addXpLevelUpArcher() {
        player p = new player("T", "A", "ARCHER", 0, new ArrayList<>());
        int inventoryBefore = p.inventory.size();
        boolean leveled = UpdatePlayer.addXp(p, 10);
        assertThat(leveled, is(true));
        assertThat(p.inventory.size(), is(inventoryBefore + 1));
    }


}
