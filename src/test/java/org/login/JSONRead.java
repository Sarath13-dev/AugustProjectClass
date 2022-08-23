package org.login;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONRead {

	public static void main(String[] args) throws IOException, ParseException {
		JSONParser json = new JSONParser();// To seperate or Parse the JSON file into different fields
		FileReader file = new FileReader(
				"C:\\Users\\LENOVO\\eclipse-workspace\\MavenTestng\\src\\test\\resources\\testData\\testread.json");
		Object parse = json.parse(file);// Return Type - Object (Java- Super Class)
		// Java Object - JSON Object
		// Higher Order - Lower Order - Type Casting or Down Casting
		// LowerOrder ref = (LowerOrder) higherOrderref
		JSONObject js = (JSONObject) parse;
		// Pass the key and get the Value
		Object object = js.get("name");
		// Java Object - String
		String s = (String) object;
		System.out.println(object);

	}

}
