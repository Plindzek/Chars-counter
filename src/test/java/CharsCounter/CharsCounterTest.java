package CharsCounter;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class CharsCounterTest {

    CharsCounter counter = new CharsCounter();

    @Test
    public void shouldReturnCorrectResponse() {
        String response;
        String answerA = "a występuje 13 razy.";
        String answerB = "b występuje 4 razy.";
        String answerC = "c występuje 1 raz.";

        PrintStream originalOut = System.out;
        ByteArrayOutputStream os = new ByteArrayOutputStream(100);
        PrintStream capture = new PrintStream(os);
        System.setOut(capture);
        counter.countChars("baaaaaaaaaaaaabbbc");
        capture.flush();
        response = os.toString();
        System.setOut(originalOut);

        assertThat(response, containsString(answerA));
        assertThat(response, containsString(answerB));
        assertThat(response, containsString(answerC));
    }

}
