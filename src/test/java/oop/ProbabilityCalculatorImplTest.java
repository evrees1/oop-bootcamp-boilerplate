package oop;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.testng.Assert.assertEquals;

class ProbabilityCalculatorImplTest {

    private final int MAX = 6;
    private final ProbabilityCalculatorImpl subject = new ProbabilityCalculatorImpl(MAX);
    
    @Test
    public void itShouldReturnChanceWhereMaxIs6() {
        BigDecimal actual = subject.chanceOf();

        assertEquals(actual, BigDecimal.valueOf(0.16667));
    }

    @Test
    public void itShouldReturnNotChanceWhereMaxIs6() {
        BigDecimal actual = subject.chanceOfNot();

        assertEquals(actual, BigDecimal.valueOf(0.83333));
    }

    @Test
    public void itShouldReturnProductOfTwoChances() {
        BigDecimal chanceA = subject.chanceOf();
        BigDecimal chanceB = subject.chanceOfNot();

        BigDecimal actual = subject.productOfChances(chanceA, chanceB);

        assertEquals(actual, BigDecimal.valueOf(0.1388911111));
    }

    @Test
    public void itShouldReturnLogicalOrOfTwoChances() {
        BigDecimal chanceA = subject.chanceOf();
        BigDecimal chanceB = subject.chanceOfNot();

        BigDecimal actual = subject.logicalOrOf(chanceA, chanceB);

        assertEquals(actual, BigDecimal.valueOf(0.8611088889));
    }

}