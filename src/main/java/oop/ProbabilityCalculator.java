package oop;

import java.math.BigDecimal;

public interface ProbabilityCalculator {

    BigDecimal chanceOf();
    BigDecimal chanceOfNot();
    BigDecimal productOfChances(BigDecimal probabilityA, BigDecimal probabilityB);
    BigDecimal logicalOrOf(BigDecimal probabilityA, BigDecimal probabilityB);
    BigDecimal productOfChances(BigDecimal... probabilities);

}
