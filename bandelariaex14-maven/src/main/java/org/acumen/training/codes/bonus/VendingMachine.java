package org.acumen.training.codes.bonus;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class VendingMachine {
	@SuppressWarnings("unused")
	private int totValue;
	private int currValue;
	private boolean enabled;
	private static final int COST = 75;
	
	private static final Logger LOGGER = LogManager.getLogger("FLOG");

	public VendingMachine() {
		totValue = 0;
		currValue = 0;
		enabled = false;
	}

	public void insert(Coin coin) {
		int value = coin.getValue();
		if (value == 0) {
			//System.err.println("illegal value");
			LOGGER.error("illegal value");
		} else {
			currValue += value;
			LOGGER.info("Current value = {}", currValue);
			if (currValue >= COST) {
				enabled = true;
				LOGGER.info(" (sufficient credit)");
			}
		}
	}

	public void returnCoins() {
		if (currValue == 0) {
			LOGGER.error("no coins to return");
		} else {
			LOGGER.info("Take your coins");
			currValue = 0;
			enabled = false;
		}
	}

	public void vend() throws Exception {
		if (enabled) {
			LOGGER.info("Get your drink");
			totValue += COST;
			currValue -= COST;
			if (currValue == 0)
				enabled = false;
			LOGGER.info("Current value = {}", currValue);
		} else {
			LOGGER.info("Not enough credit: add {}", (COST - currValue));
		}
		if (currValue < 0) {
			String errMessage = "Error: negative credit!";
			LOGGER.fatal(errMessage);
			throw new Exception(errMessage);
		}
	}
}