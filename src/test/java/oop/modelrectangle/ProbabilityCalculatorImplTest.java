package oop.modelrectangle;

import oop.chance.ProbabilityCalculatorImpl;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.testng.Assert.assertEquals;

class ProbabilityCalculatorImplTest {

    private final int MAX = 6;
    private final ProbabilityCalculatorImpl subject = new ProbabilityCalculatorImpl(MAX);
    
    @Test
    public void itShouldReturnChanceWhereMaxIs6() {
        BigDecimal actual = subject.chanceOfHit();

        assertEquals(actual, BigDecimal.valueOf(0.16667));
    }

    @Test
    public void itShouldReturnNotChanceWhereMaxIs6() {
        BigDecimal actual = subject.chanceOfNoHit();

        assertEquals(actual, BigDecimal.valueOf(0.83333));
    }

    @Test
    public void itShouldReturnProductOfTwoChances() {
        BigDecimal chanceA = subject.chanceOfHit();
        BigDecimal chanceB = subject.chanceOfNoHit();

        BigDecimal actual = subject.productOfChances(chanceA, chanceB);

        assertEquals(actual, BigDecimal.valueOf(0.1388911111));
    }

    @Test
    public void itShouldReturnLogicalOrOfTwoChances() {
        BigDecimal chanceA = subject.chanceOfHit();
        BigDecimal chanceB = subject.chanceOfNoHit();

        BigDecimal actual = subject.logicalOrOf(chanceA, chanceB);

        assertEquals(actual, BigDecimal.valueOf(0.8611088889));
    }

}