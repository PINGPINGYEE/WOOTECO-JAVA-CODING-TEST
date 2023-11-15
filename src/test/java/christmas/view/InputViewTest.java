package christmas.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void readMenuAndNumberOfOrdersProcess_onlyDrink() {
        InputView inputView = new InputView();
        String input = "제로콜라-1,레드와인-2"; // 잘못된 입력 예시

        try {
            inputView.readMenuAndNumberOfOrdersProcess(10, input);
        } catch (Exception ignored) {

        }

        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("[ERROR]"));
    }

    @Test
    void readMenuAndNumberOfOrdersProcess_over20() {
        InputView inputView = new InputView();
        String input = "타파스-20,레드와인-2"; // 잘못된 입력 예시

        try {
            inputView.readMenuAndNumberOfOrdersProcess(10, input);
        } catch (Exception ignored) {

        }

        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("[ERROR]"));
    }
}
