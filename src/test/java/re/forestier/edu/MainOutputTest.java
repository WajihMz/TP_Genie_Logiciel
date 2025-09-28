package re.forestier.edu;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

class MainOutputTest {

    @Test
    void main_prints_expected_information() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        try {
            Main.main(new String[]{});
            String printed = out.toString();

            assertThat(printed, containsString("Joueur"));
            assertThat(printed, containsString("Niveau :"));
            assertThat(printed, containsString("Capacités :"));
            assertThat(printed, containsString("Inventaire :"));
            assertThat(printed, containsString("------------------"));
        } finally {
            System.setOut(originalOut);
        }
    }
}

