package oop;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ProbabilityCalculatorImpl implements ProbabilityCalculator {

    private final int SCALE = 5;
    private final BigDecimal maximum;

    public ProbabilityCalculatorImpl(int max) {
        this.maximum = BigDecimal.valueOf(max);
    }

    @Override
    public BigDecimal chanceOfHit() {
        return BigDecimal.ONE.divide(maximum, SCALE, RoundingMode.HALF_UP);
    }

    @Override
    public BigDecimal chanceOfNoHit() {
        return BigDecimal.ONE.subtract(chanceOfHit());
    }

    @Override
    public BigDecimal productOfChances(BigDecimal probabilityA, BigDecimal probabilityB) {
        return probabilityA.multiply(probabilityB);
    }

    @Override
    public BigDecimal logicalOrOf(BigDecimal probabilityA, BigDecimal probabilityB) {
        return probabilityA.add(probabilityB)
                .subtract(productOfChances(probabilityA, probabilityB));
    }

    @Override
    public BigDecimal productOfChances(BigDecimal... probabilities) {
        // TODO
        return null;
    }
}
