package test;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import page.FindaPlace;

public class FindPlaceTest {
	private static final Logger log = LogManager.getLogger(FindPlaceTest.class.getName());
	@Test
	public void verifyFindPlace() {
		
		log.info("Inside method verifyFindPlace");
		FindaPlace.placeASearch();
		
	}

}
