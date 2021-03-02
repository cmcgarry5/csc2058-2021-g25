import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DiceTest {
    static Dice dice;

    @Before
    public void setUp() {
        dice = new Dice();
    }

    @Test
    public void nextPlayer() {
        dice.setIsDouble(true);
        dice.setIsSecondDouble(true);
        dice.nextPlayer();

        boolean actualIsDouble = dice.getIsDouble();
        boolean actualIsSecondDouble = dice.getIsSecondDouble();

        assertFalse("isDouble", actualIsDouble);
        assertFalse("isSecondDouble", actualIsSecondDouble);
    }

    @Test
    public void getRollValue() {
        boolean expectedRollValue = false;
        for (int i = 2; i <= 12; i++) {
            if (dice.getRollValue() == i) {
                expectedRollValue = true;
            }
        }

        assertTrue("expectedRollValue", expectedRollValue);
    }

    @After
    public void tearDown() {
        dice = null;
    }

}