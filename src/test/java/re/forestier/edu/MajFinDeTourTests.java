package re.forestier.edu;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import re.forestier.edu.rpg.UpdatePlayer;
import re.forestier.edu.rpg.player;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MajFinDeTourTests {
    
    private player mk(String cls, int hp, int chp) {
        player p = new player("T", "A", cls, 0, new ArrayList<>());
        p.healthpoints = hp;
        p.currenthealthpoints = chp;
        return p;
    }

    @Test
    @DisplayName("KO: HP restent à 0")
    void koStaysZero() {
        player p = mk("ADVENTURER", 20, 0);
        UpdatePlayer.majFinDeTour(p);
        assertThat(p.currenthealthpoints, is(0));
    }

    @Test
    @DisplayName("DWARF <50%: +1 sans Holy Elixir")
    void dwarfBelowHalfNoElixir() {
        player p = mk("DWARF", 40, 10); // < 20
        UpdatePlayer.majFinDeTour(p);
        assertThat(p.currenthealthpoints, is(11)); // +1
    }

    @Test
    @DisplayName("DWARF <50%: +2 avec Holy Elixir")
    void dwarfBelowHalfWithElixir() {
        player p = mk("DWARF", 40, 10);
        p.inventory.add("Holy Elixir");
        UpdatePlayer.majFinDeTour(p);
        assertThat(p.currenthealthpoints, is(12)); // +1 (elf) +1 (classe)
    }


}
