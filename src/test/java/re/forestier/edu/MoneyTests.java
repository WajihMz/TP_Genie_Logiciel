package re.forestier.edu;

import org.junit.jupiter.api.*;
import re.forestier.edu.rpg.player;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;


import java.util.ArrayList;

public class MoneyTests {

    @Test
    @DisplayName("addMoney ajoute le bon montant")
    void addMoneyIncrements() {
        player p = new player("T", "A", "ADVENTURER", 100, new ArrayList<>());
        p.addMoney(40);
        assertThat(p.money, is(140));
    }

    @Test
    @DisplayName("removeMoney diminue le montant")
    void removeMoneyDecrements() {
        player p = new player("T", "A", "ADVENTURER", 100, new ArrayList<>());
        p.removeMoney(40);
        assertThat(p.money, is(60));
    }

    @Test
    @DisplayName("removeMoney interdit l'argent négatif (exception)")
    void removeMoneyThrowsOnNegative() {
        player p = new player("T", "A", "ADVENTURER", 100, new ArrayList<>());
        assertThrows(IllegalArgumentException.class, () -> p.removeMoney(200));
    }
    
}
