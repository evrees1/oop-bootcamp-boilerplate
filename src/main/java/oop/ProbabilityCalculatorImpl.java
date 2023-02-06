package oop;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class ProbabilityCalculatorImpl implements ProbabilityCalculator {

    final int SCALE = 5;
    private final BigDecimal max;

    public ProbabilityCalculatorImpl(int max) {
        this.max = BigDecimal.valueOf(max);
    }

    @Override
    public BigDecimal chanceOf() {
        return BigDecimal.ONE.divide(max, SCALE, RoundingMode.HALF_UP);
    }

    @Override
    public BigDecimal chanceOfNot() {
        return BigDecimal.ONE.subtract(chanceOf());
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
