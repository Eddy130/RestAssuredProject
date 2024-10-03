package GetMethods;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {
	
	public static String BrandName() {
		String generatedString = RandomStringUtils.randomAlphabetic(1); 
		return ("Suzuki" + generatedString);
		
		
		
	}
	public static String ModelYear() {
		String generatedString = RandomStringUtils.randomNumeric(1); 
		return ("202" + generatedString);
		
		
		
	}
	public static String Odometer() {
		String generatedString = RandomStringUtils.randomNumeric(1); 
		return ("1500" + generatedString);
		
		
		
	}
	public static String OwnerName() {
		String generatedString = RandomStringUtils.randomAlphabetic(1); 
		return ("Suzuki" + generatedString);
		
		
		
	}
	
	public static String PlateID() {
		String generatedString = RandomStringUtils.randomNumeric(4); 
		return ("BEN" + generatedString);
		
		
		
	}
	public static String Product() {
		String generatedString = RandomStringUtils.randomAlphabetic(1); 
		return ("Suzuki" + generatedString);
		
		
		
	}

}
