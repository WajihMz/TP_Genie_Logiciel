package re.forestier.edu;

import org.junit.jupiter.api.*;
import re.forestier.edu.rpg.player;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;

public class MoneyTests {

    @Test
    @DisplayName("addMoney ajoute le bon montant")
    void addMoneyIncrements() {
        player p = new player("T", "A", "ADVENTURER", 100, new ArrayList<>());
        p.addMoney(40);
        assertThat(p.money, is(140));
    }
    
}
