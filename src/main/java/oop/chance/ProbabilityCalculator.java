package oop.chance;

import java.math.BigDecimal;

public interface ProbabilityCalculator {

    BigDecimal chanceOfHit();
    BigDecimal chanceOfNoHit();
    BigDecimal productOfChances(BigDecimal probabilityA, BigDecimal probabilityB);
    BigDecimal logicalOrOf(BigDecimal probabilityA, BigDecimal probabilityB);
    BigDecimal productOfChances(BigDecimal... probabilities);

}
