package org.acumen.training.codes.bonus.test;

import org.acumen.training.codes.bonus.Coin;
import org.acumen.training.codes.bonus.VendingMachine;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TestVendingMachine {

	private VendingMachine vend;
	private Coin coin;

	@BeforeEach
	public void setup() {
		vend = new VendingMachine();
	}

	@AfterEach
	public void teardown() {
		vend = null;
	}

	@ParameterizedTest
	@ValueSource(strings = { "penny", "nickel", "dime", "quarter", "halfdollar", "silverdollar" })
	public void testInsertCoin(String data) {
		coin = new Coin(data);
		vend.insert(coin);
	}

	@Test
	public void testReturnCoinsNonzero() {
		coin = new Coin("penny");
		vend.returnCoins();
	}

	@Test
	public void testReturnCoinsZero() {
		coin = null;
		vend.returnCoins();
	}

	@Test
	public void testVendNull() {

		try {
			vend.vend();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
