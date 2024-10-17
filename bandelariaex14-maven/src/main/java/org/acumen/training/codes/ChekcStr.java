package org.acumen.training.codes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ChekcStr {
	private static final Logger LOGGER = LogManager.getLogger("ELOG");
	
	public ChekcStr() {
		LOGGER.info("Object created.");
	}

	public String convert(String str) {
		LOGGER.info("Start of conversion");
		String binarise = binarise(total(str));
		LOGGER.info("Result Value: {}", binarise);
		LOGGER.info("End of conversion");
		return binarise;
	}

	public int total(String str) {
		LOGGER.info("Start of total length of binary numbers from string");
		if (str == "") {
			LOGGER.info("Returns 0");
			return 0;
		}
		if (str.length() == 1) {
			LOGGER.info("Returns the character as a number");
			return ((int) (str.charAt(0)));
		}
		int result = ((int) (str.charAt(0))) + total(str.substring(1));
		LOGGER.info("Method Result: {}", result);
		LOGGER.info("End of total length of binary numbers from string");
		return result;
	}

	public String binarise(int givenstrvalue) {
		LOGGER.info("Start of binarise algorithm");
		if (givenstrvalue == 0) {
			LOGGER.info("Returns empty");
			return "";
		}
		if (givenstrvalue % 2 == 1) {
			String subStr = "1" + binarise(givenstrvalue / 2);
			LOGGER.info("Substring result: {}", subStr);
			return subStr;
		}
		String subStr = "0" + binarise(givenstrvalue / 2);
		LOGGER.info("Substring result: {}", subStr);
		LOGGER.info("End of binarise algorithm");
		return subStr;
	}
}
