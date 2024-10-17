package org.acumen.training.codes;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TrapArray {
	// regex constants
	private static final String INVALID_REGEX = "[^a-zA-Z\\d\\s:]+";
	private static final String ALPHANUMERIC_REGEX = "[a-zA-Z]+";
	private static final String GOODBYE_REGEX = "[e|E]";
	
	// logger
	private static final Logger LOGGER = LogManager.getLogger("DLOG");
	
	public void arrayTransact() {
		Scanner in = new Scanner(System.in);
		String arraySize = null;
		
		// check if this can still be modularized
		Integer size = 0;
		boolean firstAccept = false;
		while (firstAccept == false) {
			LOGGER.info("TrapArray starts.");
			System.out.print("Enter the array size: ");
			arraySize = in.nextLine();
			try {
				checkValidity(arraySize);
				checkAlphaNumeric(arraySize);
				size = Integer.parseInt(arraySize);
				checkNegatives(size);
				firstAccept = true;
			} catch (NegativeArraySizeException e) {
				LOGGER.fatal(e.getMessage());
				continue;
			} catch (LetterSizeException e) {
				LOGGER.fatal(e.getMessage());
				continue;
			} catch (Exception e) {
				LOGGER.fatal(e.getMessage());
				continue;
			}
		}
				
		// 2nd check
		Integer[] arrayInts = new Integer[size];
		String testInput = null;
		
		Integer element = 0;
		int i = 0;
		while(i < size) {
			System.out.print("Enter the value: ");
			testInput = in.nextLine();
			try {
				checkValidity(testInput);
				checkCharElement(testInput);
				element = Integer.parseInt(testInput);
				checkFloatingPointElement(element);
				arrayInts[i] = element;
				i++;
			} catch (ElementCharException e) {
				LOGGER.error(e.getMessage());
				continue;		
			} catch (ElementDecimalException e) {
				LOGGER.error(e.getMessage());
				continue;
			} catch (Exception e) {
				LOGGER.error(e.getMessage());
				continue;
			}
		}
		LOGGER.info("Array of {} integers created.", element);

		
		// 3rd check
		String index = null;
		
		boolean indexAccept = false;
		while(indexAccept == false) {
			System.out.print("Enter the Index that you want to view: ");
			index = in.nextLine();
			try {
				if (index.matches(GOODBYE_REGEX)) {
					System.out.println("Goodbye.");
					break;
				}
				checkBadIndex(index, size);
				System.out.println(arrayInts[Integer.parseInt(index)]);
			} catch (BadIndexException e) {
				LOGGER.error(e.getMessage());
				continue;
			} catch (Exception e) {
				LOGGER.error(e.getMessage());
				continue;
			}
		}
		
		in.close();
	}
	
	private void checkNegatives(Integer test)
			throws NegativeArraySizeException, Exception {
		if(test < 0) {
			throw new NegativeArraySizeException("Array size cannot be negative.");
		}
	}
	private void checkValidity(String test)
			throws InvalidSizeException, Exception {
		if(test == null || test.matches(INVALID_REGEX)) {
			throw new InvalidSizeException();
		}
	}
	private void checkAlphaNumeric(String test) 
			throws LetterSizeException, Exception {
		if(test.matches(ALPHANUMERIC_REGEX)) { // regex
			throw new LetterSizeException();
		}
	}
	private void checkCharElement(String test) 
			throws ElementCharException, Exception {
		if(test.matches(ALPHANUMERIC_REGEX)) {
			throw new ElementCharException();
		}
	}
	private void checkFloatingPointElement(Number test)
			throws ElementDecimalException, Exception {
		if(test.floatValue() % 1 != 0) {
			throw new ElementDecimalException();
		}
	}
	private void checkBadIndex(String index, Integer size) 
			throws BadIndexException, Exception {
		if(Integer.parseInt(index) >= size) {
			throw new BadIndexException();
		}
	}
}
