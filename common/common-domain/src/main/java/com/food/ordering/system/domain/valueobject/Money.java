package com.food.ordering.system.domain.valueobject;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Money {
    private final BigDecimal amount;

    public Money(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return this.amount;
    }

    public boolean isGreaterThanZero() {
        return amount!= null && amount.compareTo(BigDecimal.ZERO) > 0;
    }

    public boolean isGreaterThan(BigDecimal money) {
        return this.amount.compareTo(money) > 0;
    }

    public Money add(Money addition) {
        return new Money(setScale(this.amount.add(addition.getAmount())));
    }

    public Money subtract(Money addition) {
        return new Money(setScale(this.amount.subtract(addition.getAmount())));
    }

    public Money multiply(int multiplier) {
        return new Money(setScale(this.amount.multiply(new BigDecimal(multiplier))));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return amount.equals(money.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    private BigDecimal setScale(BigDecimal input) {
        return input.setScale(2, RoundingMode.HALF_EVEN);
    }
}
