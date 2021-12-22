package Utilities;

import java.util.List;
import java.util.Map;

public class ExcelReader {
	static ExcelUtil excelUtil = new ExcelUtil();
	static String path = System.getProperty("user.dir")+ "\\Configurations\\TestData.xlsx";
	static String sheetName = "Sheet1";
	static List<Map<String, String>> testData = excelUtil.getData(path, sheetName);
	
	public static final String username = testData.get(0).get("Username");
	public static final String password = testData.get(0).get("Password");
		
	public static final String heading = testData.get(0).get("subjectheading");
	public static final String email = testData.get(0).get("email");
	public static final String orderRefe = testData.get(0).get("orderref");
	public static final String message = testData.get(0).get("message");
}
