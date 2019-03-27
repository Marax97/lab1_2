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

    @Test
    public void testSubtractingValueFromMoney() {
        Money money = new Money(1);
        Money money2 = new Money(2);
        assertThat(money2.subtract(money), is(equalTo(money)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionDuringSubtract() {
        Money money = new Money(1, Currency.getInstance("USD"));
        Money money2 = new Money(2);
        money.subtract(money2);
    }

    @Test
    public void testCurrencyCodeIsValid() {
        Money money = new Money(1, Currency.getInstance("USD"));
        String currencyCode = "USD";
        assertThat(currencyCode, is(equalTo(money.getCurrencyCode())));
    }

    @Test
    public void testGetCurrencyIsValid() {
        Currency currency = Currency.getInstance("USD");
        Money money = new Money(1, Currency.getInstance("USD"));
        assertThat(currency, is(equalTo(money.getCurrency())));
    }

    @Test
    public void testIfMoneyIsGraterThenOtherMoney() {
        Money money = new Money(1);
        Money money2 = new Money(2);
        assertThat(money2.greaterThan(money), is(equalTo(true)));
        assertThat(money.greaterThan(money2), is(equalTo(false)));
    }

}
