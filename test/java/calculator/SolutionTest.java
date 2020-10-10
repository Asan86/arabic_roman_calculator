package calculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SolutionTest {
    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(out));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    void correctExpressions(String input, String expected) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Solution.main(null);
        assertEquals(expected, out.toString().stripTrailing());
    }

    void inputMismatch(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThrows(InputMismatchException.class, () -> {
            Solution.main(null);
        });
    }

    void noSuchElement(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThrows(NoSuchElementException.class, () -> {
            Solution.main(null);
        });
    }
}
