package com.restAssured;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import io.restassured.internal.support.FileReader;
import io.restassured.path.json.JsonPath;

public class ReusableMethod {
	
	public static Properties prop = new Properties();
	public static File file = new File(".\\Resources\\PropertyFile.properties");
	public static FileInputStream fis;
	
	public static JsonPath rawToJson(String response) {
		JsonPath jpath = new JsonPath(response);
		return jpath;
	}
	
	public static void writeDataToPropertyFile(String key, String value) throws IOException {
		fis = new FileInputStream(file);
		prop.load(fis);
		prop.setProperty(key, value);
		prop.store(new FileOutputStream(file), null);		
	}
	
	public static String readDataFromPropertyFile(String key) {
		String value = "";
		try {
		fis = new FileInputStream(file);
		prop.load(fis);
		value=prop.getProperty(key);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return value;
	}

}
