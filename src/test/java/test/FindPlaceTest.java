package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import page.FindaPlace;

public class FindPlaceTest extends TestBase {
	private static final Logger log = LogManager.getLogger(FindPlaceTest.class.getName());

	@DataProvider(name = "gplaceData")
	public String[][] dataSourceProvider() {
		return getData("gplace-data.xlsx", "GplaceResources");
	}

	@Test(dataProvider = "gplaceData")
	public void verifyFindPlace(String resource, String latitudeLongitude, String nameOfPlace, String appId,
			String appCode, String runMode) {

		log.info("Inside method verifyFindPlace");
		FindaPlace.searchForAPlace(resource, latitudeLongitude, nameOfPlace, appId, appCode);

	}

}
