package test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Currency;

import org.junit.Test;

import pl.com.bottega.ecommerce.sharedkernel.Money;

public class MoneyTest {

    @Test
    public void testMoneyMultiplyByDouble() {
        Money moneyBeforMultiplication = new Money(1);
        Money moneyAfterMultiplication = new Money(2);
        assertThat(moneyBeforMultiplication.multiplyBy(2), is(equalTo(moneyAfterMultiplication)));
    }

    @Test
    public void testAddingValueToMoney() {
        Money money = new Money(1);
        Money money2 = new Money(2);
        assertThat(money.add(money), is(equalTo(money2)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionDuringAdding() {
        Money money = new Money(1, Currency.getInstance("USD"));
        Money money2 = new Money(2);
        money.add(money2);
    }

}
