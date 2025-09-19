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

    @Test
    @DisplayName("ARCHER <50%: +1 sans Magic Bow")
    void archerBelowHalfNoBow() {
        player p = mk("ARCHER", 40, 10);
        UpdatePlayer.majFinDeTour(p);
        assertThat(p.currenthealthpoints, is(11));
    }

    @Test
    @DisplayName("ARCHER <50%: +2 avec Magic Bow (bonus proportionnel)")
    void archerBelowHalfWithBow() {
        player p = mk("ARCHER", 40, 16); // < 20 ; 16/8 - 1 = 1
        p.inventory.add("Magic Bow");
        UpdatePlayer.majFinDeTour(p);
        assertThat(p.currenthealthpoints, is(18)); // +1 + (2-1) = +2
    }

    @Test
    @DisplayName("ADVENTURER <50% et niv<3: +1 (2 puis -1)")
    void adventurerBelowHalfLowLevel() {
        player p = mk("ADVENTURER", 40, 10);
        // force XP <27 (déjà le cas par défaut)
        UpdatePlayer.majFinDeTour(p);
        assertThat(p.currenthealthpoints, is(11)); // +2 puis -1 => +1
    }


}
