package org.acumen.training.codes.bonus.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.acumen.training.codes.bonus.Coin;
import org.acumen.training.codes.bonus.VendingMachine;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TestVendingMachine {
	
	private VendingMachine vend;
	
	@BeforeEach
	public void setup() {
		vend = new VendingMachine();
	}
	
	@AfterEach
	public void teardown() {
		vend = null;
	}
	
	@ParameterizedTest
	@ValueSource(strings={"penny", "nickel", "dime", "quarter", "halfdollar", "silverdollar"})
	public void testInsertCoin(String data) {
		Coin coin = new Coin(data);
		vend.insert(coin);
	}
}
